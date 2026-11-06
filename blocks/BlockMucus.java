package com.joy187.re8joymod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;

public class BlockMucus extends Block{
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public BlockMucus() {
        super(Properties.copy(Blocks.GRASS).
                strength(3f,10f).sound(SoundType.SLIME_BLOCK));
    }

    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, Direction p_220071_4_) {
        return SHAPE;
    }

    public VoxelShape getShape(BlockState p_51171_, BlockGetter p_51172_, BlockPos p_51173_, CollisionContext p_51174_) {
        return SHAPE;
     }



    public void entityInside(BlockState p_196262_1_, Level p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        Vec3 vector3d1 = p_196262_4_.getDeltaMovement();
        p_196262_4_.level().addParticle(ParticleTypes.ITEM_SLIME, p_196262_4_.getX() + (p_196262_2_.random.nextDouble() - 0.5D) *
                (double)p_196262_4_.getBbWidth(), p_196262_4_.getY() + 0.1D, p_196262_4_.getZ() + (p_196262_2_.random.nextDouble() - 0.5D) *
                (double)p_196262_4_.getBbWidth(), p_196262_4_.position().x * -0.2D, 0.1D, p_196262_4_.position().z * -0.2D);

        p_196262_4_.setDeltaMovement(vector3d1.x*0.5, vector3d1.y, vector3d1.z*0.5);
        p_196262_4_.hurt(p_196262_4_.damageSources().cactus(), 1.0F);
    }
}
