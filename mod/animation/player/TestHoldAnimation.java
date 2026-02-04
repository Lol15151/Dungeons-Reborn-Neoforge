package net.lol15.dungeonsreborn.mod.animation.player;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.lol15.dungeonsreborn.mod.animation.PlayerAnimationHandler;
import net.lol15.dungeonsreborn.mod.network.ModPackets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;

public class TestHoldAnimation implements PlayerAnimation {

    private KeyMapping key;
    private boolean wasDown = false;

    public TestHoldAnimation(PlayerAnimationHandler handler) {
    }

    @Override
    public void registerClient(IEventBus modBus) {
        modBus.addListener(this::registerKey);
    }

    private void registerKey(RegisterKeyMappingsEvent event) {
        key = new KeyMapping(
                "key.dungeonsreborn.test_hold",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "key.categories.dungeonsreborn"
        );
        event.register(key);
    }

    @SubscribeEvent
    public void clientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || key == null) return;

        boolean down = key.isDown();

        if (down && !wasDown) {
//            ModPackets.sendSpawnFake();
        }
        if (!down && wasDown) {
//            ModPackets.sendRemoveFake();
        }

        wasDown = down;
    }
}
