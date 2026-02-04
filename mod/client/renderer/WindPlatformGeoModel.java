package net.lol15.dungeonsreborn.mod.client.renderer;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.blockentity.BrasierBlockEntity;
import net.lol15.dungeonsreborn.mod.blockentity.WindPlatformBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WindPlatformGeoModel extends GeoModel<WindPlatformBlockEntity> {

    @Override
    public ResourceLocation getModelResource(WindPlatformBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "geo/wind_platform.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(WindPlatformBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "textures/block/wind_platform.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(WindPlatformBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(
                DungeonsReborn.MODID,
                "animations/brasier.animation.json"
        );
    }
}