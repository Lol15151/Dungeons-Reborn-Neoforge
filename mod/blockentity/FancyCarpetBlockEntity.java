package net.lol15.dungeonsreborn.mod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FancyCarpetBlockEntity extends BlockEntity {

    public FancyCarpetBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FANCY_CARPET.get(), pos, state);
    }
}
