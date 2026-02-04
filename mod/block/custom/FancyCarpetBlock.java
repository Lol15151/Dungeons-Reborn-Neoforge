package net.lol15.dungeonsreborn.mod.block.custom;

import net.lol15.dungeonsreborn.mod.blockentity.FancyCarpetBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FancyCarpetBlock extends CarpetBlock implements EntityBlock {

    public FancyCarpetBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.isFaceSturdy(level, pos.below(), Direction.UP)
                || below.getBlock() instanceof StairBlock;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        // Rendered manually via BlockEntityRenderer
        return RenderShape.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FancyCarpetBlockEntity(pos, state);
    }
}
