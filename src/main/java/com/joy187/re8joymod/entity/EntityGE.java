package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntityGE extends ThrowableItemProjectile {

    public EntityGE(EntityType<? extends ThrowableItemProjectile> p_37473_, Level p_37474_) {
        super(p_37473_, p_37474_);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.GE.get();
    }

    public EntityGE(Level p_37481_, LivingEntity p_37482_) {
        super(EntityInit.GOLDENEGG.get(), p_37482_, p_37481_);
    }

    protected void onHitEntity(EntityHitResult p_37486_) {
        super.onHitEntity(p_37486_);
        p_37486_.getEntity().hurt(damageSources().thrown(this, this.getOwner()), 10.0F);
    }

    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level().isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(12) == 0) {
                    i = 2;
                }

                for(int j = 0; j < i; ++j) {
//                    Chicken chicken = EntityType.CHICKEN.create(this.level());
//                    chicken.setAge(-24000);
//                    chicken.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    Vec3 vec3 = this.position();
                    ItemStack itemstack = new ItemStack(Items.GOLDEN_APPLE);
                    double d0 = (double) Mth.randomBetween(this.random, -0.2F, 0.2F);
                    double d1 = (double)Mth.randomBetween(this.random, 0.3F, 0.7F);
                    double d2 = (double)Mth.randomBetween(this.random, -0.2F, 0.2F);
                    ItemEntity itementity = new ItemEntity(this.level(), vec3.x(), vec3.y(), vec3.z(), itemstack, d0, d1, d2);
                    this.level().addFreshEntity(itementity);
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

}
