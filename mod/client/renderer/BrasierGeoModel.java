package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BrasierGeoModel extends GeoModel<BrasierBlockEntity> {

    @Override
    public ResourceLocation getModelResource(BrasierBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/brasier.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(BrasierBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/brasier.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(BrasierBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/brasier.animation.json"
        );
    }
}