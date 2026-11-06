package com.joy187.re8joymod.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.joy187.re8joymod.entity.EntityDund.DundAttackGoal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
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

public class EntityDund2 extends EntityDund implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityDund2(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 15;
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
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D).
                add(Attributes.ATTACK_DAMAGE, 5D);
    }
    
    

    
    protected void customServerAiStep() {
        Random ran = new Random();
        if(this.getHealth() >= 18.0F && this.getHealth()<=20.0F && !(this instanceof EntityRegenerator))
        {
            for(int i=0;i<2;i++)
                this.heal(2.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 5.0F && this.getHealth()<=7.0F && !(this instanceof EntityRegenerator))
        {
            for(int i=0;i<2;i++)
                this.heal(2.5F*ran.nextFloat());
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
        super.customServerAiStep();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
//        {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund2.death2"));
//            return PlayState.CONTINUE;
//        }

    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund2.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund2.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund2.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund2.attack2"));
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
	
    static class AttackGoal extends Goal {
        private final EntityDund2 parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityDund2 mob) {
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
                  if (this.attackTimer < 15) {
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

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33790_, DifficultyInstance p_33791_, MobSpawnType p_33792_, @Nullable SpawnGroupData p_33793_, @Nullable CompoundTag p_33794_) {
       p_33793_ = super.finalizeSpawn(p_33790_, p_33791_, p_33792_, p_33793_, p_33794_);

       if (p_33793_ == null) {
          p_33793_ = new Spider.SpiderEffectsGroupData();
          if (p_33790_.getDifficulty() == Difficulty.HARD && p_33790_.getRandom().nextFloat() < 0.1F * p_33791_.getSpecialMultiplier()) {
             ((Spider.SpiderEffectsGroupData)p_33793_).setRandomEffect(p_33790_.getRandom());
          }
       }

       return p_33793_;
    }
}
