package net.lol15.dungeonsreborn.mod.launchpad;

import net.neoforged.neoforge.common.NeoForge;

public class LaunchPadEvents {

    public static void register() {
        NeoForge.EVENT_BUS.addListener(LaunchPadInteraction::onRightClick);
        NeoForge.EVENT_BUS.register(LaunchPadTick.class);

    }
}
