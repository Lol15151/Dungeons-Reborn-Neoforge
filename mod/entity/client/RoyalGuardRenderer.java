package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RoyalGuardRenderer extends GeoEntityRenderer<RoyalGuardEntity> {

    public RoyalGuardRenderer(EntityRendererProvider.Context context) {
        super(context, new RoyalGuardModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(RoyalGuardEntity entity) {
        return ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "textures/entity/royal_guard.png");
    }
}