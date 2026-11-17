package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;

public class EntityMia extends EntityEthan{
    public EntityMia(EntityType<? extends IronGolemEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 50;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.30D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.45D).
                add(Attributes.ATTACK_DAMAGE, 9.2D);
    }

    protected void customServerAiStep() {
        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.2F);
            this.level.addParticle(ParticleTypes.ASH, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
        }

        super.customServerAiStep();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIA_AMBIENT1.get();
        }
        return SoundInit.ENTITY_MIA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_MIA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_MIA_DEATH.get();
    }
}
