package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.item.FlailItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FlailModel extends GeoModel<FlailItem> {

    @Override
    public ResourceLocation getModelResource(FlailItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(DungeonsReborn.MODID, "geo/flail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FlailItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(DungeonsReborn.MODID, "textures/item/flail.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FlailItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(DungeonsReborn.MODID, "animations/flail.animation.json");
    }
}
