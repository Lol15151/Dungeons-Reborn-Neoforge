package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.client.PlayerSkinUtil;
import net.lol15.dungeonsreborn.mod.entity.custom.FakePlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FakePlayerRenderer extends GeoEntityRenderer<FakePlayerEntity> {

    public FakePlayerRenderer(EntityRendererProvider.Context context) {
        super(context, new FakePlayerModel());
    }

    @Override
    public ResourceLocation getTextureLocation(FakePlayerEntity entity) {
        return PlayerSkinUtil.getSkin(entity.getRealPlayerUUID());
    }
}
