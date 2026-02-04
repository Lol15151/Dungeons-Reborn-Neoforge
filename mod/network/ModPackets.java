package net.lol15.dungeonsreborn.mod.network;

import net.lol15.dungeonsreborn.mod.animation.PlayerAnimationHandler;
//import net.lol15.dungeonsreborn.mod.network.RemoveFakeAnimationPacket;
//import net.lol15.dungeonsreborn.mod.network.SpawnFakeAnimationPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.event.*;

public class ModPackets {

    private static final PlayerAnimationHandler HANDLER = new PlayerAnimationHandler();

    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {

        // NB: registrar version string can be your modid or any stable identifier
        PayloadRegistrar registrar = event.registrar("dungeonsreborn");

        // Register Spawn packet server-side
//        registrar.playToServer(
//                SpawnFakeAnimationPacket.TYPE,
//                SpawnFakeAnimationPacket.CODEC,
//                (packet, ctx) -> HANDLER.startControlling(ctx.player())
//        );

        // Register Remove packet server-side
//        registrar.playToServer(
//                RemoveFakeAnimationPacket.TYPE,
//                RemoveFakeAnimationPacket.CODEC,
//                (packet, ctx) -> HANDLER.stopControlling(ctx.player())
//        );
    }
}
