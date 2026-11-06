package com.joy187.re8joymod.blocks;

import com.joy187.re8joymod.entity.EntityVerdugo;
import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Predicate;

public class BlockLiquidNitrogen extends Block {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 20.0D, 14.0D);

    public BlockLiquidNitrogen() {
        super(Properties.copy(Blocks.STONE).
                strength(3f,3f).sound(SoundType.METAL).requiresCorrectToolForDrops());
    }

    private static final Predicate<Entity> OIL_AREA = (entity) -> {
        return entity.isAlive();
    };

    @Override
    public void onProjectileHit(Level p_57381_, BlockState p_57382_, BlockHitResult p_57383_, Projectile p_57384_) {
        int i = 1;
        Entity entity = p_57384_.getOwner();
        if (entity instanceof ServerPlayer serverplayer) {
            serverplayer.awardStat(Stats.TARGET_HIT);
            CriteriaTriggers.TARGET_BLOCK_HIT.trigger(serverplayer, p_57384_, p_57383_.getLocation(), i);
        }
        //BlockPos pos = new BlockPos(p_57383_.getLocation());
        Vec3 location = p_57383_.getLocation();
        BlockPos pos = new BlockPos((int) location.x, (int) location.y, (int) location.z);        AABB aabb = (new AABB(pos)).inflate(3D);
        for (LivingEntity lvt : p_57381_.getEntitiesOfClass(LivingEntity.class, aabb, OIL_AREA)) {
            lvt.addEffect(new MobEffectInstance(EffectInit.STUN.get(), 200, 0));
            if(lvt instanceof EntityVerdugo){
                lvt.hurt(lvt.damageSources().magic(),lvt.getMaxHealth()*0.25f);
            }
        }

        for(int x=-1;x<=1;x++)
        {
            for(int y=-1;y<=1;y++)
            {
                for(int z=-1;z<=1;z++)
                {
                    BlockPos pos1 = new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()+z);
                    if(p_57381_.getBlockState(pos1).is(Blocks.FIRE) || p_57381_.getBlockState(pos1).is(Blocks.SOUL_FIRE))
                    {
                        p_57381_.removeBlock(pos1,false);
                    }
                    if(p_57381_.getBlockState(pos1).is(Blocks.LAVA))
                    {
                        p_57381_.setBlock(pos1,Blocks.OBSIDIAN.defaultBlockState(), 2);
                    }

                    if(p_57381_.getBlockState(pos1).is(Blocks.WATER))
                    {
                        p_57381_.setBlock(pos1,Blocks.BLUE_ICE.defaultBlockState(), 2);
                    }
                }
            }
        }

        p_57381_.removeBlock(pos,false);
        p_57381_.explode((Entity) null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, Level.ExplosionInteraction.NONE);
    }

    public VoxelShape getShape(BlockState p_52988_, BlockGetter p_52989_, BlockPos p_52990_, CollisionContext p_52991_) {
        return SHAPE;
    }
}
