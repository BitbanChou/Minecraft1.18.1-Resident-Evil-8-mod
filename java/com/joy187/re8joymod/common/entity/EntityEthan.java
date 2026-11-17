package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;

public class EntityEthan extends IronGolemEntity {
    public EntityEthan(EntityType<? extends IronGolemEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 100;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.7D).
                add(Attributes.ATTACK_DAMAGE, 12.0D);
    }

    protected void customServerAiStep() {
        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(3.0F);
            this.level.addParticle(ParticleTypes.ASH, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
        }

        super.customServerAiStep();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(2, new ReturnToVillageGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new PatrolVillageGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new ShowVillagerFlowerGoal(this));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_234199_0_) -> {
            return p_234199_0_ instanceof IMob && !(p_234199_0_ instanceof CreeperEntity);
        }));
        this.targetSelector.addGoal(4, new ResetAngerGoal<>(this, false));
    }
    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_ETHAN_AMBIENT1.get();
        }
        return SoundInit.ENTITY_ETHAN_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_ETHAN_HURT1.get();
        }
        return SoundInit.ENTITY_ETHAN_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_ETHAN_DEATH.get();
    }

}
