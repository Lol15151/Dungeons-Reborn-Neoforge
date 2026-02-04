package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.block.custom.GeomancerPillarBlock;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.GeomancerPillarBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GeomancerPillarGeoModel extends GeoModel<GeomancerPillarBlockEntity> {

    @Override
    public ResourceLocation getModelResource(GeomancerPillarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/geomancer_pillar.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(GeomancerPillarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/geomancer_pillar.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(GeomancerPillarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/geomancer_pillar.animation.json"
        );
    }
}