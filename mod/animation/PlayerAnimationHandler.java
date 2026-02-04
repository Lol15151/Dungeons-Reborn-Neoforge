package net.lol15.dungeonsreborn.mod.animation;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.lol15.dungeonsreborn.mod.entity.custom.FakePlayerEntity;
import net.lol15.dungeonsreborn.mod.entity.ModEntityTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerAnimationHandler {

    private final Map<UUID, FakePlayerEntity> fakePlayers = new HashMap<>();

    /** Spawn fake player and make real player invisible */
    public void startControlling(Player player) {
        if (fakePlayers.containsKey(player.getUUID())) return;

        if (!(player instanceof ServerPlayer serverPlayer)) return;

        Level level = serverPlayer.level(); // public field in Neoforge
        FakePlayerEntity fakePlayer = new FakePlayerEntity(ModEntityTypes.FAKE_PLAYER.get(), level);
        fakePlayer.moveTo(
                player.getX(),
                player.getY(),
                player.getZ(),
                player.getYRot(),
                player.getXRot()
        );

        fakePlayer.setRealPlayerUUID(player.getUUID());
        level.addFreshEntity(fakePlayer);

        // Make player invisible
        player.setInvisible(true);

        fakePlayers.put(player.getUUID(), fakePlayer);
    }

    /** Remove fake player and restore real player */
    public void stopControlling(Player player) {
        FakePlayerEntity fake = fakePlayers.remove(player.getUUID());
        if (fake != null && !fake.isRemoved()) {
            fake.discard();
        }

        player.setInvisible(false);
    }

    public boolean isControllingFake(Player player) {
        return fakePlayers.containsKey(player.getUUID());
    }
}
