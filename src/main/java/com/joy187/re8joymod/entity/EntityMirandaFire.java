package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Barrage fireball. Same burn-on-hit as a small fireball, without lighting blocks.
 */
public class EntityMirandaFire extends SmallFireball {
    public EntityMirandaFire(EntityType<? extends SmallFireball> type, Level level) {
        super(type, level);
    }

    public EntityMirandaFire(Level level, LivingEntity owner, double x, double y, double z, double dx, double dy, double dz) {
        this(EntityInit.MIRANDA_FIRE.get(), level);
        this.setOwner(owner);
        this.setPos(x, y, z);
        this.shoot(dx, dy, dz, 0.95F, 11.0F);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
    }
}
