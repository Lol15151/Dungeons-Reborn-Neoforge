package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.blockentity.ArmorStatueBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorStatueGeoModel extends GeoModel<ArmorStatueBlockEntity> {

    @Override
    public ResourceLocation getModelResource(ArmorStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/armor_statue.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(ArmorStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/armor_statue.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(ArmorStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/brasier.animation.json"
        );
    }
}