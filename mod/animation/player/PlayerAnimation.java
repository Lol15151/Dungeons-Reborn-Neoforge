package net.lol15.dungeonsreborn.mod.animation.player;

import net.neoforged.bus.api.IEventBus;

public interface PlayerAnimation {

    // Used ONLY for mod bus events (keybind registration etc)
    void registerClient(IEventBus modBus);
}
