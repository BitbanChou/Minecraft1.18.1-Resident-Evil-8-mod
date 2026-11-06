package com.joy187.re8joymod.blocks;

import com.joy187.re8joymod.entity.EntityChief;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Predicate;

public class BlockOilDrums extends Block {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);

    public BlockOilDrums() {
        super(Properties.copy(Blocks.STONE).
                strength(3f,3f).sound(SoundType.METAL).requiresCorrectToolForDrops());
    }

    private static final Predicate<Entity> OIL_AREA = (entity) -> {
        return entity.isAlive();
    };

    public void onProjectileHit(Level p_57381_, BlockState p_57382_, BlockHitResult p_57383_, Projectile p_57384_) {
        int i = 1;
        Entity entity = p_57384_.getOwner();
        if (entity instanceof ServerPlayer serverplayer) {
            serverplayer.awardStat(Stats.TARGET_HIT);
            CriteriaTriggers.TARGET_BLOCK_HIT.trigger(serverplayer, p_57384_, p_57383_.getLocation(), i);
        }
        BlockPos pos = new BlockPos(p_57383_.getBlockPos());
        AABB aabb = (new AABB(pos)).inflate(2D);
        for (LivingEntity lvt : p_57381_.getEntitiesOfClass(LivingEntity.class, aabb, OIL_AREA)) {
            lvt.hurt(lvt.damageSources().explosion(lvt,lvt),lvt.getMaxHealth()*0.3f);
        }
        p_57381_.removeBlock(pos,false);
        p_57381_.setBlock(pos, Blocks.FIRE.defaultBlockState(),2);
        p_57381_.explode((Entity) null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, Level.ExplosionInteraction.NONE);
    }

    public VoxelShape getShape(BlockState p_52988_, BlockGetter p_52989_, BlockPos p_52990_, CollisionContext p_52991_) {
        return SHAPE;
    }
}
