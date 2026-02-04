package net.lol15.dungeonsreborn.mod.animation.player;

import net.lol15.dungeonsreborn.mod.animation.PlayerAnimationHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;

public class ModAnimations {

    public static final PlayerAnimationHandler HANDLER = new PlayerAnimationHandler();

    public static final PlayerAnimation TEST_HOLD = new TestHoldAnimation(HANDLER);

    public static void register(IEventBus modBus) {

        // register MOD events (keybinds etc)
        TEST_HOLD.registerClient(modBus);

        // gameplay events go on NeoForge
        NeoForge.EVENT_BUS.register(TEST_HOLD);
    }
}
