package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.blockentity.ArmorStatueBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.SquallGolemBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SquallGolemGeoModel extends GeoModel<SquallGolemBlockEntity> {

    @Override
    public ResourceLocation getModelResource(SquallGolemBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/squall_golem.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(SquallGolemBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/squall_golem.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(SquallGolemBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/brasier.animation.json"
        );
    }
}