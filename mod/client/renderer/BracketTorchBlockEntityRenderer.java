package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lol15.dungeonsreborn.mod.blockentity.BracketTorchBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.GeomancerPillarBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import net.lol15.dungeonsreborn.mod.client.renderer.BracketTorchGeoModel;

public class BracketTorchBlockEntityRenderer
        extends GeoBlockRenderer<BracketTorchBlockEntity> {

    public BracketTorchBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new BracketTorchGeoModel());
    }

    @Override
    public void render(BracketTorchBlockEntity blockEntity,
                       float partialTick,
                       PoseStack poseStack,
                       MultiBufferSource bufferSource,
                       int packedLight,
                       int packedOverlay) {

        super.render(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
    }
}
