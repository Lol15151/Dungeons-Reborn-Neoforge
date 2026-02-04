package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.entity.custom.Vindicator2Entity;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Entity-based renderer that is compatible with common NeoForge 1.21.x mappings.
 */
public class Vindicator2Renderer extends MobRenderer<Vindicator2Entity, IllagerModel<Vindicator2Entity>> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(DungeonsReborn.MODID, "textures/entity/vindicator2.png");

    public Vindicator2Renderer(EntityRendererProvider.Context context) {
        super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.VINDICATOR)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Vindicator2Entity entity) {
        return TEXTURE;
    }
}
