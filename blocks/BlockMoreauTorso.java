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

public class BlockMoreauTorso extends Block {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

	public BlockMoreauTorso() {
        super(Properties.copy(Blocks.STONE).
                strength(3f,3f).sound(SoundType.SLIME_BLOCK).requiresCorrectToolForDrops());
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
