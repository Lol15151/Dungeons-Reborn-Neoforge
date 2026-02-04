package net.lol15.dungeonsreborn.mod.client.sky;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

public class StormLightning {

    private static final ResourceLocation DARKEST_FOREST =
            ResourceLocation.fromNamespaceAndPath("dungeonsreborn", "darkest_forest");

    private static int flashTicks = 0;

    @SubscribeEvent
    public void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;

        var biomeKey = mc.level.getBiome(mc.player.blockPosition())
                .unwrapKey()
                .orElse(null);

        if (biomeKey == null || !biomeKey.location().equals(DARKEST_FOREST))
            return;

        if (flashTicks > 0) flashTicks--;

        // Random lightning
        if (flashTicks == 0 && mc.level.random.nextInt(600) == 0) {
            flashTicks = 4;
            mc.player.playSound(
                    SoundEvents.LIGHTNING_BOLT_THUNDER,
                    1.0F,
                    0.8F
            );
        }
    }

    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Pre event) {
        if (flashTicks <= 0) return;

        Minecraft mc = Minecraft.getInstance();
        float alpha = flashTicks / 4.0F;
        int a = (int)(alpha * 160.0F) << 24;

        event.getGuiGraphics().fill(
                0,
                0,
                mc.getWindow().getGuiScaledWidth(),
                mc.getWindow().getGuiScaledHeight(),
                a | 0xFFFFFF
        );
    }

    public static float getFlashStrength() {
        return flashTicks / 4.0F;
    }
}
