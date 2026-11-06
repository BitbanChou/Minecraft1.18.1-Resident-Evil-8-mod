package com.joy187.re8joymod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class BlockComplexMechanicalHeart extends Block {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 14.0D, 4.0D, 14.0D);

	public BlockComplexMechanicalHeart() {
        super(Properties.copy(Blocks.STONE).
                strength(5f,5f).sound(SoundType.METAL).requiresCorrectToolForDrops());
	}

	public VoxelShape getShape(BlockState p_52988_, BlockGetter p_52989_, BlockPos p_52990_, CollisionContext p_52991_) {
		      return SHAPE;
	}

	@Override
	public BlockState rotate(BlockState blockstate, Rotation rot) {
		      return blockstate.setValue(FACING, rot.rotate(blockstate.getValue(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState blockstate, Mirror mirror) {
	      return blockstate.rotate(mirror.getRotation(blockstate.getValue(FACING)));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		      return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getClockWise());
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		  builder.add(FACING);
	}
}