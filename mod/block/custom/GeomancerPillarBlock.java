package net.lol15.dungeonsreborn.mod.block.custom;

import net.lol15.dungeonsreborn.mod.blockentity.GeomancerPillarBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class GeomancerPillarBlock extends Block implements EntityBlock {

    private static final VoxelShape SHAPE = Block.box(
            1.0D,  // minX
            0.0D,  // minY
            1.0D,  // minZ
            15.0D, // maxX
            48.0D, // maxY
            15.0D  // maxZ
    );

    public GeomancerPillarBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GeomancerPillarBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context
    ) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context
    ) {
        return SHAPE;
    }
}
