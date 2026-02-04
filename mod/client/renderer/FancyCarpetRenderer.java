package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lol15.dungeonsreborn.mod.block.ModBlocks;
import net.lol15.dungeonsreborn.mod.blockentity.FancyCarpetBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FancyCarpetRenderer implements BlockEntityRenderer<FancyCarpetBlockEntity> {

    public FancyCarpetRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(FancyCarpetBlockEntity be, float partialTick,
                       PoseStack poseStack, MultiBufferSource buffer,
                       int light, int overlay) {

        Level level = be.getLevel();
        if (level == null) return;

        BlockPos pos = be.getBlockPos();
        BlockState below = level.getBlockState(pos.below());

        // Only render on stairs or solid tops
        if (!(below.getBlock() instanceof StairBlock) &&
                !below.isFaceSturdy(level, pos.below(), net.minecraft.core.Direction.UP)) {
            return;
        }

        poseStack.pushPose();

        // Lift slightly to avoid z-fighting
        poseStack.translate(0, 0.001f, 0);

        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(
                ModBlocks.FANCY_CARPET.get().defaultBlockState(),
                poseStack,
                buffer,
                light,
                overlay
        );

        poseStack.popPose();
    }
}
