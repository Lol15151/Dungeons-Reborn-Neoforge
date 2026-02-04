package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RoyalGuardModel extends GeoModel<RoyalGuardEntity> {

    @Override
    public ResourceLocation getModelResource(RoyalGuardEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "geo/royal_guard.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RoyalGuardEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "textures/entity/royal_guard.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RoyalGuardEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "animations/royal_guard.animation.json");
    }
}
