package net.lol15.dungeonsreborn.mod.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.lol15.dungeonsreborn.mod.blockentity.ModBlockEntities;

public class IllagerBannerBlockEntity extends BlockEntity {

    public IllagerBannerBlockEntity(BlockPos pos, BlockState state) {
        // Use the correct registry field name from ModBlockEntities
        super(ModBlockEntities.ILLAGER_BANNER.get(), pos, state);
    }
}
