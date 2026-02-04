package net.lol15.dungeonsreborn.mod.launchpad;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;

public class LaunchPadDetector {

    public static Optional<BlockPos> findPadCenter(Level level, BlockPos pos) {
        for (int ox = -1; ox <= 0; ox++) {
            for (int oz = -1; oz <= 0; oz++) {
                BlockPos base = pos.offset(ox, 0, oz);

                boolean valid = true;
                for (int dx = 0; dx <= 1; dx++) {
                    for (int dz = 0; dz <= 1; dz++) {
                        if (!level.getBlockState(base.offset(dx, 0, dz)).is(Blocks.PISTON)) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid) {
                    return Optional.of(base.offset(1, 0, 1));
                }
            }
        }
        return Optional.empty();
    }
}
