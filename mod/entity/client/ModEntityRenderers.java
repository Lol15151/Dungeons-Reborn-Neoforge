package net.lol15.dungeonsreborn.mod.entity.client;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.lol15.dungeonsreborn.mod.entity.ModEntityTypes;
import net.lol15.dungeonsreborn.mod.entity.custom.FakePlayerEntity;
import net.lol15.dungeonsreborn.mod.entity.custom.RoyalGuardEntity;
import net.lol15.dungeonsreborn.mod.entity.custom.Vindicator2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.bus.api.SubscribeEvent;

@EventBusSubscriber(modid = DungeonsReborn.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

        // Vindicator2 renderer
        event.registerEntityRenderer(
                (EntityType<Vindicator2Entity>) ModEntityTypes.VINDICATOR2.value(),
                ctx -> new Vindicator2Renderer(ctx)
        );

        // RoyalGuard renderer
        event.registerEntityRenderer(
                (EntityType<RoyalGuardEntity>) ModEntityTypes.ROYALGUARD.value(),
                ctx -> new RoyalGuardRenderer(ctx)
        );

        event.registerEntityRenderer(
                (EntityType<FakePlayerEntity>) ModEntityTypes.FAKE_PLAYER.value(),
                ctx -> new FakePlayerRenderer(ctx)
        );
    }
}