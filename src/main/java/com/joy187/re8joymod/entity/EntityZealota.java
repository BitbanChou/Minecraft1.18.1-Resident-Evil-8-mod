package com.joy187.re8joymod.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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

public class EntityZealota extends Skeleton implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityZealota(EntityType<? extends Skeleton> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 15;
        this.setItemSlot(EquipmentSlot.HEAD,new ItemStack(Items.CHAINMAIL_HELMET));
    }
    
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
     }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycana.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycana.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycana.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if(this.getTarget()!=null && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()))
		{
		    
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycana.attack"));
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
            if(this.tickCount % 20==1){
                EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.level(), this);
                abstractarrowentity.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 15.5F, 0.75F);

                abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
                abstractarrowentity.playSound(SoundEvents.EGG_THROW, 1.5F, 1.5F);

                this.level().addFreshEntity(abstractarrowentity);
            }
	        
	        BlockPos blockpos = this.blockPosition();
	        FluidState fluidstate = this.level().getFluidState(blockpos);
	        BlockState blockstate0 = this.level().getBlockState(blockpos.below());
	        BlockState blockstate = this.level().getBlockState(blockpos.below().below().below().below());
	        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 34.99F && this.getHealth()<=35.0F)
	        {
	        	this.discard();
	        }
	     	if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 34.99F && this.getHealth()<=35.0F) {
	        	this.discard();
	     	}
	    }
}
