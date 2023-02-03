package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class EntityChris extends IronGolemEntity {
    public EntityChris(EntityType<? extends IronGolemEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 100;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 500.0D).
                add(Attributes.MOVEMENT_SPEED, 0.24D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.9D).
                add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    protected void customServerAiStep() {
        Random ran = new Random();
        int co = ran.nextInt(20);
        if(co%9==0)
        {
            double d0 = this.getTarget() != null ? 0.28D : 0.30D;
            double d1 = this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(MathHelper.lerp(0.1D, d1, d0));
        }
        else{
            double d0 = this.getTarget() != null ? 0.24D : 0.24D;
            double d1 = this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(MathHelper.lerp(0.1D, d1, d0));
            if(co%5==0){
                this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20,1,true,true));
            }

        }

        if(this.getHealth() >= 1.0F && this.getHealth()<=10.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(4.0F);
            this.level.addParticle(ParticleTypes.ANGRY_VILLAGER, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
        }

        super.customServerAiStep();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_CHRIS_AMBIENT1.get();
        }
        else if(co==1) SoundInit.ENTITY_CHRIS_AMBIENT3.get();
        return SoundInit.ENTITY_CHRIS_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_ETHAN_HURT1.get();
        }
        return SoundInit.ENTITY_CHRIS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_CHRIS_DEATH.get();
    }

}
