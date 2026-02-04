package net.lol15.dungeonsreborn.mod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.lol15.dungeonsreborn.mod.blockentity.GeomancerPillarBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GeomancerPillarBlockEntityRenderer
        extends GeoBlockRenderer<GeomancerPillarBlockEntity> {

    public GeomancerPillarBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new GeomancerPillarGeoModel());
    }

    @Override
    public void render(GeomancerPillarBlockEntity blockEntity,
                       float partialTick,
                       PoseStack poseStack,
                       MultiBufferSource bufferSource,
                       int packedLight,
                       int packedOverlay) {

        super.render(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
    }
}
