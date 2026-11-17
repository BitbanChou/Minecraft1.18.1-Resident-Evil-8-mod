package com.joy187.re8joymod.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntitySamca extends VexEntity {
    private boolean limitedLifespan;
    private int limitedLifeTicks;

    public EntitySamca(EntityType<? extends VexEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 30;
    }

    public void move(MoverType p_213315_1_, Vector3d p_213315_2_) {
        super.move(p_213315_1_, p_213315_2_);
        this.checkInsideBlocks();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(4, new EntitySamca.ChargeAttackGoal());
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, AbstractRaiderEntity.class)).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.15D).
                add(Attributes.ATTACK_DAMAGE, 8.5D);
    }

    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (EntitySamca.this.getTarget() != null && !EntitySamca.this.getMoveControl().hasWanted() && EntitySamca.this.random.nextInt(7) == 0) {
                return EntitySamca.this.distanceToSqr(EntitySamca.this.getTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return EntitySamca.this.getMoveControl().hasWanted() && EntitySamca.this.isCharging() && EntitySamca.this.getTarget() != null && EntitySamca.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity livingentity = EntitySamca.this.getTarget();
            Vector3d vector3d = livingentity.getEyePosition(1.0F);
            EntitySamca.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
            EntitySamca.this.setIsCharging(true);
            EntitySamca.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
        }

        public void stop() {
            EntitySamca.this.setIsCharging(false);
        }

        public void tick() {
            LivingEntity livingentity = EntitySamca.this.getTarget();
            if (EntitySamca.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                EntitySamca.this.doHurtTarget(livingentity);
                EntitySamca.this.setIsCharging(false);
            } else {
                double d0 = EntitySamca.this.distanceToSqr(livingentity);
                if (d0 < 9.0D) {
                    Vector3d vector3d = livingentity.getEyePosition(1.0F);
                    EntitySamca.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
                }
            }

        }
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.HARM, 10 * (int)f));
        }

        return flag;
    }
}