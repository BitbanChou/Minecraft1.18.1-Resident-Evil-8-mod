package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityRosemary extends EntityChris{
	
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	
    public EntityRosemary(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 50;
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.30D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.45D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }
    
    protected void customServerAiStep() {
        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.0F);
            this.level().addParticle(ParticleTypes.ASH, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
        }

        super.customServerAiStep();
    }
    
    public void aiStep() {
        super.aiStep();
        if(this.getHealth()<20.F)
        {
        	//for(float i=1;i<=3;i+=0.5)
        	CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),this.level(),this.getOnPos(),1.0F);
        	//CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),this.level(),this.getOnPos(),1.0F);
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_ROSE_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_ROSE_DEATH1.get();
        return SoundInit.ENTITY_ROSE_AMBIENT2.get();

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_ROSE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_ROSE_DEATH1.get();
        }
        return SoundInit.ENTITY_ROSE_DEATH2.get();

    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.rose.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.rose.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.rose.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.rose.attack2"));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}
	
    @Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
        data.add(new AnimationController(this, "controller1",
                0, this::predicate1));
	}

	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
}
