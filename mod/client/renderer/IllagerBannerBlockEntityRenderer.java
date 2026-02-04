package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.custom.IllagerBannerBlock;
import net.lol15.dungeonsreborn.mod.blockentity.IllagerBannerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class IllagerBannerBlockEntityRenderer
        implements BlockEntityRenderer<IllagerBannerBlockEntity> {

    private static final ItemStack RED_BANNER_ITEM = new ItemStack(
            BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath(
                            DungeonsReborn.MODID,
                            "redbanner"
                    )
            )
    );

    public IllagerBannerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(
            IllagerBannerBlockEntity blockEntity,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        poseStack.pushPose();

        // Center block
        poseStack.translate(0.5, 0.5, 0.5);

        // Rotate from facing
        Direction facing = blockEntity.getBlockState().getValue(IllagerBannerBlock.FACING);
        float yRot = switch (facing) {
            case NORTH -> 180f;
            case EAST  -> -90f;
            case SOUTH -> 0f;
            case WEST  -> 90f;
            default -> 0f;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));

        // Push banner outward
        poseStack.translate(0.0, 0.0, 0.45);

        // Correct orientation
        poseStack.mulPose(Axis.ZP.rotationDegrees(180f));

        // Scale to fit block
        poseStack.scale(0.75f, 0.75f, 0.75f);

        // Render item model
        Minecraft.getInstance().getItemRenderer().renderStatic(
                RED_BANNER_ITEM,
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
