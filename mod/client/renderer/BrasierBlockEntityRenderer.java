package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

public class BrasierBlockEntityRenderer extends GeoBlockRenderer<BrasierBlockEntity> {

    public BrasierBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new BrasierGeoModel());
    }

    // Always fully bright
    protected int getBlockLightLevel(BrasierBlockEntity animatable, BlockState state,
                                     net.minecraft.core.BlockPos pos, int tint) {
        return 14; // Permanent light
    }

    @Override
    public void render(BrasierBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        int fullBright = 0xF000F0;

        // Just render normally — the controller handles the idle animation automatically
        super.render(blockEntity, partialTick, poseStack, bufferSource, fullBright, packedOverlay);

        // Render fire block
        Level level = blockEntity.getLevel();
        if (level != null && level.isClientSide) {
            poseStack.pushPose();
            poseStack.translate(0.16, 0.5, 0.16);
            poseStack.scale(0.7f, 0.7f, 0.7f);

            BlockState fireState = Blocks.FIRE.defaultBlockState();
            BlockRenderDispatcher dispatcher = Minecraft.getInstance().getBlockRenderer();
            dispatcher.renderSingleBlock(fireState, poseStack, bufferSource, fullBright, packedOverlay);

            poseStack.popPose();
        }
    }
}
