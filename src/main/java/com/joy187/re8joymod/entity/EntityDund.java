package com.joy187.re8joymod.entity;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;

public class EntityDund extends Monster implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	private boolean canBreakDoors;
    public boolean playAttackAnimation = false;
    public int attackTick=1;
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityDund.class,
			EntityDataSerializers.INT);
	
	private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
	   private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (mode) -> {
		      return mode == Difficulty.HARD || mode == Difficulty.NORMAL;
		   };

    public EntityDund(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 10;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new DundAttackGoal(this, 1.0D,false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
     }

    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 30.0D).
                add(Attributes.MOVEMENT_SPEED, 0.32D).
                add(Attributes.ATTACK_DAMAGE, 5.5D);
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
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 100 * (int)f,0,true,true));
            }
        	this.playAttackAnimation=true;
            return true;
        }
        //System.out.println(attackTick);
        //System.out.println(attackTick);
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if (this.isDeadOrDying()){
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.death2"));
//            return PlayState.CONTINUE;
//        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.walk"));
            return PlayState.CONTINUE;
        }
        
//        if (this.isPathFinding()) {
//          event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
//          return PlayState.CONTINUE;        	
//        }
//        if (this.isSitting()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
//            return PlayState.CONTINUE;
//        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
			return PlayState.CONTINUE;
		}
//		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("fire"));
//			return PlayState.CONTINUE;
//		}
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
		// TODO Auto-generated method stub
		return this.factory;
	}
	
	   @Nullable
	protected SoundEvent getAmbientSound() {
	      return SoundEvents.RAVAGER_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource source) {
	      return SoundEvents.RAVAGER_HURT;
	}

	protected SoundEvent getDeathSound() {
	      return SoundEvents.RAVAGER_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockstate) {
	      this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
	}

    static class DundAttackGoal extends MeleeAttackGoal {
        private final EntityDund zombie;

        public DundAttackGoal(EntityDund entity, double p_i46803_2_, boolean p_i46803_4_) {
            super(entity, p_i46803_2_, p_i46803_4_);
            this.zombie=entity;
        }
    }
    
    public boolean canBreakDoors() {
        return this.canBreakDoors;
    }
    
    protected boolean supportsBreakDoorGoal() {
        return true;
    }
    
    public void setCanBreakDoors(boolean p_34337_) {
        if (this.supportsBreakDoorGoal() && GoalUtils.hasGroundPathNavigation(this)) {
           if (this.canBreakDoors != p_34337_) {
              this.canBreakDoors = p_34337_;
              ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(p_34337_);
              if (p_34337_) {
                 this.goalSelector.addGoal(1, this.breakDoorGoal);
              } else {
                 this.goalSelector.removeGoal(this.breakDoorGoal);
              }
           }
        } else if (this.canBreakDoors) {
           this.goalSelector.removeGoal(this.breakDoorGoal);
           this.canBreakDoors = false;
        }

     }
    
	public int getAttckingState() {
		return this.entityData.get(STATE);
	}
	
	public void setAttackingState(int time) {
		this.entityData.set(STATE, time);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
	}
	
    static class AttackGoal extends Goal {
        private final EntityDund parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityDund mob) {
             this.parentEntity = mob;
        }

        public boolean canUse() {
             return this.parentEntity.getTarget() != null;
        }

        public void start() {
             super.start();
             this.parentEntity.setAggressive(true);
        }

        @Override
        public void stop() {
             super.stop();
             this.parentEntity.setAggressive(false);
             this.parentEntity.setAttackingState(0);
             this.attackTimer = -1;
        }

        public void tick() {
             LivingEntity livingentity = this.parentEntity.getTarget();
             if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
                  Level world = this.parentEntity.level();
                  ++this.attackTimer;
                  Random rand = new Random();
                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                          livingentity.getX() - parentEntity.getX());

                  this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                  if (this.attackTimer == 15) {
                      this.parentEntity.setAttackingState(2);
                  } 
                  else{
                	  this.parentEntity.setAttackingState(1);
                  }
                  if (this.attackTimer == 30) {
                       this.parentEntity.setAttackingState(0);
                       this.attackTimer = -5;
                  }
                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
             } 
             else if (this.attackTimer > 0) {
                  --this.attackTimer;
             }
        }
   }

   protected void customServerAiStep() {
    	
        super.customServerAiStep();

        BlockPos blockpos = this.blockPosition();
        FluidState fluidstate = this.level().getFluidState(blockpos);
        BlockState blockstate0 = this.level().getBlockState(blockpos.below());
        BlockState blockstate = this.level().getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F)
        {
        	this.discard();
        }
     	if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F) {
        	this.discard();
     	}
    }

    @Override
    protected void tickDeath()
    {
        // freeze at place
        setDeltaMovement(Vec3.ZERO);
        setYRot(yRotO);
        setYHeadRot(yHeadRotO);

        if (deathTime >= getMaxDeathTime()) remove(RemovalReason.KILLED); // actually delete entity after the time is up

        deathTime++;
    }

    public int getMaxDeathTime()
    {
        return 75;
    }
}
