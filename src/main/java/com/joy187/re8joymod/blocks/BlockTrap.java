package com.joy187.re8joymod.blocks;

import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import net.minecraft.world.level.redstone.Redstone;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.function.Predicate;

public class BlockTrap extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 14.0D, 4.0D, 14.0D);

    public BlockTrap() {
        super(Properties.copy(Blocks.IRON_BLOCK).
                strength(2f,3f).sound(SoundType.METAL).requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
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
        builder.add(FACING,LIT);
    }

//    @Override
//    public void entityInside(BlockState p_154263_, Level p_154264_, BlockPos p_154265_, Entity p_154266_) {
//        if(((p_154266_ instanceof LivingEntity) && !((LivingEntity) p_154266_).hasEffect(EffectInit.EROSION.get())))
//        {
//            if (!(p_154266_ instanceof LivingEntity) || p_154266_.getFeetBlockState().is(this) ) {
//                p_154266_.makeStuckInBlock(p_154263_, new Vec3((double)0.9F, 0, (double)0.9F));
//            }
//        }
//
//    }

    public void stepOn(Level p_154573_, BlockPos p_154574_, BlockState p_154575_, Entity p_154576_) {
        if(p_154576_ instanceof LivingEntity && !((LivingEntity) p_154576_).hasEffect(EffectInit.EROSION.get()))
        {
            ((LivingEntity)p_154576_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 100,false,false));
            p_154576_.makeStuckInBlock(p_154575_, new Vec3((double)0.9F, 0, (double)0.9F));
            p_154573_.playSound((Player)null, p_154574_, SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS, 0.3F, 1);

            p_154575_.setValue(LIT, Boolean.valueOf(true));
        }

        super.stepOn(p_154573_, p_154574_, p_154575_, p_154576_);
    }

    private static final Predicate<Entity> AREA = (entity) -> {
        return entity.isAlive();
    };

    public InteractionResult use(BlockState p_54640_, Level p_54641_, BlockPos p_54642_, Player p_54643_, InteractionHand p_54644_, BlockHitResult p_54645_) {
        if (!p_54641_.isClientSide) {
            BlockPos pos = p_54642_;
            AABB aabb = (new AABB(pos)).inflate(2D);
            for (LivingEntity lvt : p_54641_.getEntitiesOfClass(LivingEntity.class, aabb, AREA)) {
                if(lvt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)){
                    lvt.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                    lvt.addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 100, 0,false,false));
                    p_54640_.setValue(LIT, Boolean.valueOf(false));
                    p_54641_.playSound((Player)null, p_54642_, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundSource.BLOCKS, 0.3F, 1);
                }
            }

            return InteractionResult.SUCCESS;
        } else {

            return super.use(p_54640_, p_54641_, p_54642_, p_54643_, p_54644_, p_54645_);
        }
    }


}
