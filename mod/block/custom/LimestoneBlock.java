package net.lol15.dungeonsreborn.mod.block.custom;

import net.lol15.dungeonsreborn.mod.block.ModBlocks; // your mod's registered blocks
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

public class LimestoneBlock extends Block {

    public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;
    public static final BooleanProperty LIMESTONE_HEATHER = BooleanProperty.create("limestone_heather");

    public LimestoneBlock(Properties properties) {
        super(properties
                .strength(1.5F)
                .sound(SoundType.STONE)
        );

        // default state: snowy=false, limestone_heather=false
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(SNOWY, false)
                        .setValue(LIMESTONE_HEATHER, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SNOWY, LIMESTONE_HEATHER);
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

            // Heather detection
            boolean heather = neighborState.is(ModBlocks.WINDSWEPT_HEATHER.get());
            state = state.setValue(LIMESTONE_HEATHER, heather);
        }

        return state;
    }
}
