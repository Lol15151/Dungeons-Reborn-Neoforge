package net.lol15.dungeonsreborn.mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class WindsweptHeatherBlock extends Block {

    public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;

    public WindsweptHeatherBlock(Properties properties) {
        super(properties
                .noOcclusion()
                .strength(0.5F)
                .sound(SoundType.GRASS)
        );

        // Default state must be set inside constructor
        this.registerDefaultState(
                this.stateDefinition.any().setValue(SNOWY, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SNOWY);
    }

    @Override
    public BlockState updateShape(
            BlockState state,
            Direction direction,
            BlockState neighborState,
            LevelAccessor level,
            BlockPos pos,
            BlockPos neighborPos
    ) {
        if (direction == Direction.UP) {
            // Snowy detection
            boolean snowy = neighborState.is(Blocks.SNOW) || neighborState.is(Blocks.SNOW_BLOCK);
            state = state.setValue(SNOWY, snowy);
        }

        return state;
    }
}
