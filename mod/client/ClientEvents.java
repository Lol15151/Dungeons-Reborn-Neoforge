package net.lol15.dungeonsreborn.mod.client;

import net.lol15.dungeonsreborn.mod.animation.player.ModAnimations;
import net.lol15.dungeonsreborn.mod.client.sky.StormCloudRenderer;
import net.lol15.dungeonsreborn.mod.client.sky.StormLightning;
import net.neoforged.neoforge.common.NeoForge;

public final class ClientEvents {

    private ClientEvents() {}

    public static void register() {

        // Sky systems
        NeoForge.EVENT_BUS.register(new StormCloudRenderer());
        NeoForge.EVENT_BUS.register(new StormLightning());

        // Animation renderer UNSURE IF WORKING
        //ModAnimations.register();
    }
}
