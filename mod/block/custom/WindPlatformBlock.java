package net.lol15.dungeonsreborn.mod.block.custom;

import net.lol15.dungeonsreborn.mod.blockentity.WindPlatformBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WindPlatformBlock extends Block implements EntityBlock {

    // Thin platform shape
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 2, 16);

    // Invisible property for non-central blocks
    public static final BooleanProperty INVISIBLE = BooleanProperty.create("invisible");

    public WindPlatformBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(INVISIBLE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(INVISIBLE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        // Only run on server
        if (!level.isClientSide) {
            // Spawn 8x8 thin blocks around the central block
            for (int x = 0; x < 8; x++) {
                for (int z = 0; z < 8; z++) {
                    BlockPos offsetPos = pos.offset(x, 0, z);

                    // Central block stays visible
                    boolean central = (x == 3 && z == 3);
                    level.setBlock(offsetPos, this.defaultBlockState().setValue(INVISIBLE, !central), 3);
                }
            }
        }

        // Return state for the central block
        return this.defaultBlockState().setValue(INVISIBLE, false);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WindPlatformBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
