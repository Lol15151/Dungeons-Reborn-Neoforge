package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.custom.GeomancerPillarBlock;
import net.lol15.dungeonsreborn.mod.blockentity.BracketTorchBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.GeomancerPillarBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BracketTorchGeoModel extends GeoModel<BracketTorchBlockEntity> {

    @Override
    public ResourceLocation getModelResource(BracketTorchBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/bracket_torch.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(BracketTorchBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/bracket_torch.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(BracketTorchBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/geomancer_pillar.animation.json"
        );
    }
}