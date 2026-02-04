package net.lol15.dungeonsreborn.mod.launchpad;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LaunchPadTick {

    private static final double GRAVITY = 0.08;
    private static final int COOLDOWN_TICKS = 20;

    private static final Map<UUID, Integer> COOLDOWNS = new HashMap<>();
    private static final Set<UUID> LAUNCHED = new HashSet<>();
    private static final Map<UUID, Vec3> FORCED_HORIZONTAL = new HashMap<>();

    // =======================
    // SERVER TICK
    // =======================
    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        for (ServerLevel level : event.getServer().getAllLevels()) {
            tickLevel(level);
        }
    }

    private static void tickLevel(ServerLevel level) {
        for (ServerPlayer player : level.players()) {
            UUID id = player.getUUID();

            // Tick cooldown
            COOLDOWNS.computeIfPresent(id, (k, v) -> v > 0 ? v - 1 : 0);

            // Apply forced motion if launched
            if (LAUNCHED.contains(id)) {
                applyForcedMotion(player);
                continue;
            }

            // Cooldown active
            if (COOLDOWNS.getOrDefault(id, 0) > 0) continue;

            BlockPos below = player.blockPosition().below();

            LaunchPadDetector.findPadCenter(level, below).ifPresent(center -> {
                BlockPos target = LaunchPadTargets.get(level).getTarget(center);
                if (target == null) {
                    DungeonsReborn.LOGGER.info("[LaunchPad] No target set for pad {}", center);
                    return;
                }

                Vec3 velocity = computeLaunchVelocity(
                        player.position(),
                        Vec3.atCenterOf(target)
                );

                // Store forced horizontal velocity
                FORCED_HORIZONTAL.put(id, new Vec3(velocity.x, 0, velocity.z));
                LAUNCHED.add(id);
                COOLDOWNS.put(id, COOLDOWNS.getOrDefault(id, 0) + COOLDOWN_TICKS);

                player.setDeltaMovement(velocity);
                player.hurtMarked = true;

                DungeonsReborn.LOGGER.info(
                        "[LaunchPad] Launching {} from {} to {} | velocity={}",
                        player.getGameProfile().getName(),
                        center,
                        target,
                        velocity
                );

                LaunchPadPistons.fire(level, center);
            });
        }
    }

    // =======================
    // FORCED MOTION (NO DRAG)
    // =======================
    private static void applyForcedMotion(ServerPlayer player) {
        UUID id = player.getUUID();

        Vec3 forced = FORCED_HORIZONTAL.get(id);
        if (forced == null) return;

        Vec3 current = player.getDeltaMovement();

        // HARD OVERRIDE horizontal motion
        player.setDeltaMovement(
                forced.x,
                current.y - GRAVITY,
                forced.z
        );

        player.hurtMarked = true;

        if (player.onGround()) {
            LAUNCHED.remove(id);
            FORCED_HORIZONTAL.remove(id);

            DungeonsReborn.LOGGER.info(
                    "[LaunchPad] {} landed.",
                    player.getGameProfile().getName()
            );
        }
    }

    // =======================
    // BALLISTIC CALCULATION
    // =======================
    private static Vec3 computeLaunchVelocity(Vec3 from, Vec3 to) {
        double dx = to.x - from.x;
        double dz = to.z - from.z;
        double dy = to.y - from.y;

        double horizontalDistance = Math.sqrt(dx * dx + dz * dz);

        // === TUNABLE VALUES ===
        double horizontalSpeed = Math.max(0.9, horizontalDistance * 0.14);
        double peakHeight = horizontalDistance * 0.5;

        // Normalize horizontal direction
        double nx = dx / horizontalDistance;
        double nz = dz / horizontalDistance;

        double vx = nx * horizontalSpeed;
        double vz = nz * horizontalSpeed;

        // Vertical velocity to reach peak
        double vy = Math.sqrt(2 * GRAVITY * peakHeight);

        DungeonsReborn.LOGGER.info(
                "[LaunchPad] dist={}, speed={}, peak={}, vx={}, vy={}, vz={}",
                horizontalDistance, horizontalSpeed, peakHeight, vx, vy, vz
        );

        return new Vec3(vx, vy, vz);
    }
}
