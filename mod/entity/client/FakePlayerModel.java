package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.entity.custom.FakePlayerEntity;
import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FakePlayerModel extends GeoModel<FakePlayerEntity> {

    @Override
    public ResourceLocation getModelResource(FakePlayerEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "geo/fake_player.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FakePlayerEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "textures/entity/royal_guard.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FakePlayerEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "animations/royal_guard.animation.json");
    }
}
