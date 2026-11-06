package com.joy187.re8joymod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockMine extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 14.0D, 4.0D, 14.0D);

	public BlockMine() {
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
	
	public void stepOn(Level p_154573_, BlockPos p_154574_, BlockState p_154575_, Entity p_154576_) {
        if(p_154576_ instanceof LivingEntity)
        {
            ((LivingEntity)p_154576_).addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1,true,true));
    		p_154576_.hurt(p_154576_.damageSources().inFire(), (float)15.0F);
        }		
        p_154573_.explode((Entity)null, p_154574_.getX(), p_154574_.getY(), p_154574_.getZ(), (float)3, Level.ExplosionInteraction.NONE);
		super.stepOn(p_154573_, p_154574_, p_154575_, p_154576_);
	}
}
