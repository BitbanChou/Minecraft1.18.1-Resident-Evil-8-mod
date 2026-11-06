package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityFrank3 extends EntityFrank1 implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityFrank3(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 25;
        //SpawnPlacements.register(EntityInit.FRANK3.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D).
                add(Attributes.ATTACK_DAMAGE, 8.5D).
                add(Attributes.ARMOR, 2.0D).
                add(Attributes.ARMOR_TOUGHNESS, 4.1D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.35D);
    }
    
    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
        	this.playAttackAnimation=false;
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));
            }
        	this.playAttackAnimation=true;
            return true;
        }
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.walk"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.attack2"));
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
	
	   protected void customServerAiStep() {
	    	
	        super.customServerAiStep();

	        BlockPos blockpos = this.blockPosition();
	        FluidState fluidstate = this.level().getFluidState(blockpos);
	        BlockState blockstate0 = this.level().getBlockState(blockpos.below());
	        BlockState blockstate = this.level().getBlockState(blockpos.below().below().below().below());
	        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 39.99F && this.getHealth()<=40.0F)
	        {
	        	this.discard();
	        }
	     	if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 39.99F && this.getHealth()<=40.0F) {
	        	this.discard();
	     	}
	    }
	
}
