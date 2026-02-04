package net.lol15.dungeonsreborn.mod.launchpad;

import net.lol15.dungeonsreborn.mod.DungeonsReborn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

public class LaunchPadPistons {

    public static void fire(ServerLevel level, BlockPos center) {
        // Play piston sound
        level.playSound(null,
                center,
                SoundEvents.PISTON_EXTEND,
                SoundSource.BLOCKS,
                1.0f,
                1.0f
        );

        DungeonsReborn.LOGGER.info("[LaunchPad] Pistons fired at pad {}", center);


        level.sendParticles(
                ParticleTypes.CLOUD,
                center.getX() + 0.5,
                center.getY() + 0.6,
                center.getZ() + 0.5,
                10,
                0.3, 0.3, 0.3,
                0.05
        );
    }
}
