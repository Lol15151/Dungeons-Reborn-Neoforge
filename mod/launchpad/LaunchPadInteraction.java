package net.lol15.dungeonsreborn.mod.launchpad;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LaunchPadInteraction {

    private static final int CONFIRM_DELAY_TICKS = 20; // 1 second
    private static final Map<UUID, SelectionState> SELECTING = new HashMap<>();

    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!player.isShiftKeyDown()) return;

        ServerLevel level = player.serverLevel();
        BlockPos clicked = event.getPos();
        UUID id = player.getUUID();
        long gameTime = level.getGameTime();

        // ─────────────────────────────────────────────
        // SECOND CLICK — confirm target (after delay)
        // ─────────────────────────────────────────────
        if (SELECTING.containsKey(id)) {
            SelectionState state = SELECTING.get(id);

            long elapsed = gameTime - state.startTick;
            if (elapsed < CONFIRM_DELAY_TICKS) {
                DungeonsReborn.LOGGER.info(
                        "[LaunchPad] {} clicked too early ({} / {} ticks)",
                        player.getGameProfile().getName(),
                        elapsed,
                        CONFIRM_DELAY_TICKS
                );
                event.setCanceled(true);
                return;
            }

            SELECTING.remove(id);

            // Compute integer offset (BlockPos) instead of Vec3
            BlockPos padCenter = state.padCenter;
            BlockPos offset = clicked.subtract(padCenter); // integer offset
            LaunchPadTargets.get(level).setTargetOffset(padCenter, offset);

            player.displayClientMessage(
                    Component.literal("Target confirmed").withStyle(style -> style.withBold(true)),
                    true
            );

            DungeonsReborn.LOGGER.info(
                    "[LaunchPad] {} confirmed target {} (offset {}) for pad {}",
                    player.getGameProfile().getName(),
                    clicked,
                    offset,
                    padCenter
            );

            event.setCanceled(true);
            return;
        }

        // ─────────────────────────────────────────────
        // FIRST CLICK — select pad
        // ─────────────────────────────────────────────
        LaunchPadDetector.findPadCenter(level, clicked).ifPresent(center -> {
            SELECTING.put(id, new SelectionState(center, gameTime));

            player.displayClientMessage(
                    Component.literal("Select target"),
                    true
            );

            DungeonsReborn.LOGGER.info(
                    "[LaunchPad] {} entered selection mode for pad {}",
                    player.getGameProfile().getName(),
                    center
            );

            event.setCanceled(true);
        });
    }

    /* ───────────── INTERNAL STATE ───────────── */
    private record SelectionState(BlockPos padCenter, long startTick) {}
}
