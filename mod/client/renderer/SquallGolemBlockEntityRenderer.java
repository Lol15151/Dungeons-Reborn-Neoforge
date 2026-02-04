package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.custom.ArmorStatueBlock;
import net.lol15.dungeonsreborn.mod.block.custom.SquallGolemBlock;
import net.lol15.dungeonsreborn.mod.blockentity.ArmorStatueBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.SquallGolemBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SquallGolemBlockEntityRenderer
        extends GeoBlockRenderer<SquallGolemBlockEntity> {

    // Item to render in statue's hand (example)
    private static final ItemStack TEST_SWORD = new ItemStack(
            BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DungeonsReborn.MODID, "testsword"))
    );

    // Rotation and offset constants
    private final float rotX, rotZ;
    private final float offsetX, offsetY, offsetZ;

    public SquallGolemBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new SquallGolemGeoModel());
        this.rotX = 0f;
        this.rotZ = 135f;
        this.offsetX = 0f;
        this.offsetY = 0.3f;
        this.offsetZ = 0.65f; // flipped sign so it’s in front
    }

    @Override
    public void render(SquallGolemBlockEntity blockEntity,
                       float partialTick,
                       PoseStack poseStack,
                       MultiBufferSource bufferSource,
                       int packedLight,
                       int packedOverlay) {

        super.render(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay);

        poseStack.pushPose();

        // Determine Y rotation from block facing
        float yRotation = 0f;
        if (blockEntity.getBlockState().hasProperty(SquallGolemBlock.FACING)) {
            Direction facing = blockEntity.getBlockState().getValue(SquallGolemBlock.FACING);
            switch (facing) {
                case NORTH -> yRotation = 180f;
                case EAST  -> yRotation = -90f;
                case SOUTH -> yRotation = 0f;
                case WEST  -> yRotation = 90f;
            }
        }

        // Rotate X/Z offsets with Y rotation
        double rad = Math.toRadians(yRotation);
        double rotatedX = offsetX * Math.cos(rad) - offsetZ * Math.sin(rad);
        double rotatedZ = offsetX * Math.sin(rad) + offsetZ * Math.cos(rad);

        // Center block + rotated offsets
        poseStack.translate(0.5 + rotatedX, 0.5 + offsetY, 0.5 + rotatedZ);

        // Apply rotations
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(rotX));
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(yRotation));
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(rotZ));

        // Render the held item
        Minecraft.getInstance().getItemRenderer().renderStatic(
                TEST_SWORD,
                ItemDisplayContext.FIXED,
                packedLight,
                packedOverlay,
                poseStack,
                bufferSource,
                blockEntity.getLevel(),
                0
        );

        poseStack.popPose();
    }
}
