package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.lol15.dungeonsreborn.mod.entity.custom.Vindicator2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Vindicator2Model extends GeoModel<Vindicator2Entity> {

    @Override
    public ResourceLocation getModelResource(Vindicator2Entity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "geo/vindicator2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Vindicator2Entity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "textures/entity/vindicator2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Vindicator2Entity animatable) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "animations/vindicator2.animation.json");
    }
}
