package net.lol15.dungeonsreborn.mod.block.custom;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RunicGlassPaneBlock extends IronBarsBlock {

    public RunicGlassPaneBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn((s, l, p, e) -> false)
                .isRedstoneConductor((s, l, p) -> false)
        );
    }
}
