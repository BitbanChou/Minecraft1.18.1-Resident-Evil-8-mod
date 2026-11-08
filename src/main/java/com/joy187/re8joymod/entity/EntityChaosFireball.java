package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * Miranda chaos fireball — hit deals 20% of target max health.
 */
public class EntityChaosFireball extends LargeFireball {
    public static final float MAX_HP_RATIO = 0.20F;

    public EntityChaosFireball(EntityType<? extends LargeFireball> type, Level level) {
        super(type, level);
    }

    public EntityChaosFireball(Level level, LivingEntity owner, double dirX, double dirY, double dirZ) {
        this(EntityInit.CHAOS_FIREBALL.get(), level);
        this.setOwner(owner);
        this.setPos(owner.getX(), owner.getEyeY() - 0.2D, owner.getZ());
        double len = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
        if (len != 0.0D) {
            this.xPower = dirX / len * 0.12D;
            this.yPower = dirY / len * 0.12D;
            this.zPower = dirZ / len * 0.12D;
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (this.level().isClientSide) {
            return;
        }
        Entity hit = result.getEntity();
        Entity owner = this.getOwner();
        if (hit instanceof LivingEntity living && hit != owner) {
            float dmg = Math.max(8.0F, living.getMaxHealth() * MAX_HP_RATIO);
            LivingEntity attacker = owner instanceof LivingEntity livingOwner ? livingOwner : null;
            living.hurt(this.damageSources().explosion(this, attacker), dmg);
            living.setSecondsOnFire(6);
        }
        this.level().explode(owner, this.getX(), this.getY(), this.getZ(), 1.25F, false, Level.ExplosionInteraction.NONE);
        this.discard();
    }

    @Override
    protected void onHit(HitResult result) {
        if (result.getType() == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult) result);
            return;
        }
        if (!this.level().isClientSide) {
            this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 1.0F, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }
}
