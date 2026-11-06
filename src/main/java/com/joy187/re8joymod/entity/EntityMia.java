package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.OfferFlowerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
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

public class EntityMia extends EntityEthan implements GeoEntity{
	
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMia.class,
			EntityDataSerializers.INT);
	
    public EntityMia(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 50;
    }
    
    protected void registerGoals() {
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D,true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new OfferFlowerGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        //this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
           return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
        }));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));
    }
        

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.30D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.45D).
                add(Attributes.ATTACK_DAMAGE, 9.2D);
    }
    
    protected void customServerAiStep() {
        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.2F*this.random.nextFloat());
        }

        //super.customServerAiStep();
    }

    public void aiStep() {
        super.aiStep();
        if(this.getHealth()<15.F)
        {
        	//for(float i=1;i<=3;i+=0.5)
        	CommonFunctions.spawnHexAround(ParticleTypes.HEART,this.level(),this.getOnPos(),1.0F);
        }
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
	
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.mia.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.mia.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.mia.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.mia.attack2"));
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
        private final EntityMia parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityMia mob) {
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
	
    
	
}
