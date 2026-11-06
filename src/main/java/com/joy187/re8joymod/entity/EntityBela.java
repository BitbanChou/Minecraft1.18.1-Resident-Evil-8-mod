package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityBela extends EntityDund2 implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityBela(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 25;
	}
	
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
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
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 60.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 8D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.ENTITY_BELA_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_BELA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_BELA_DEATH.get();
    }
    
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));

        }

        return flag;
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.bela.attack2"));
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

    public void transformToBat() {
        // 变身为蝙蝠的逻辑
        //this.convertTo(EntityInit.FLY.get(),false);
        EntityFly f = EntityFly.create(this.level(),this,this.getHealth(),100,this.getX(), this.getY(), this.getZ());
        f.moveTo(this.getX(), this.getY(), this.getZ()); // 移动到当前位置
        //System.out.println("yes");
        this.level().addFreshEntity(f);
        this.discard();
	}

    public void transformBack() {
        // 变回原形的逻辑
        //this.convertTo(EntityInit.BELA.get(),false);
    }

//    static class AttackGoal extends Goal {
//        private final EntityBela parentEntity;
//        protected int attackTimer = 0;
//
//        public AttackGoal(EntityBela mob) {
//             this.parentEntity = mob;
//        }
//
//        public boolean canUse() {
//             return this.parentEntity.getTarget() != null;
//        }
//
//        public void start() {
//             super.start();
//             this.parentEntity.setAggressive(true);
//        }
//
//        @Override
//        public void stop() {
//             super.stop();
//             this.parentEntity.setAggressive(false);
//             this.parentEntity.setAttackingState(0);
//             this.attackTimer = -1;
//        }
//
//        public void tick() {
//             LivingEntity livingentity = this.parentEntity.getTarget();
//             if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
//                  Level world = this.parentEntity.level();
//                  ++this.attackTimer;
//                  Random rand = new Random();
//                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
//                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
//                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
//                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
//                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
//                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
//                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
//                          livingentity.getX() - parentEntity.getX());
//
//                  this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
//                  if (this.attackTimer < 15) {
//                      this.parentEntity.setAttackingState(2);
//                  }
//                  else{
//                	  this.parentEntity.setAttackingState(1);
//                  }
//                  if (this.attackTimer == 30) {
//                       this.parentEntity.setAttackingState(0);
//                       this.attackTimer = -5;
//                  }
//                 this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//             }
//             else if (this.attackTimer > 0) {
//                  --this.attackTimer;
//             }
//        }
//
//   }

    static class AttackGoal extends Goal {
        private final EntityBela parentEntity;
        protected int attackTimer = 0;
        private boolean isTransformed = false;
        private int transformationTimer = 0;

        public AttackGoal(EntityBela mob) {
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
            if (isTransformed) {
                parentEntity.transformBack();
                isTransformed = false;
            }
        }

        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            if (livingentity != null && this.parentEntity.hasLineOfSight(livingentity)) {
                Level world = this.parentEntity.level();
                ++this.attackTimer;
                Random rand = new Random();
                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());

                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer < 15) {
                    this.parentEntity.setAttackingState(2);
                } else {
                    this.parentEntity.setAttackingState(1);
                }

                // 变身为蝙蝠的逻辑
                if (this.attackTimer == 40 && !isTransformed) {
                    parentEntity.transformToBat();
                    isTransformed = true;
                    transformationTimer = 0;

                    // 对周围生物造成伤害
                    List<LivingEntity> nearbyEntities = world.getEntitiesOfClass(LivingEntity.class,
                            parentEntity.getBoundingBox().inflate(5.0D), e -> e != parentEntity);
                    int damagedEntitiesCount = 0;
                    for (LivingEntity entity : nearbyEntities) {
                        if (entity.hurt(this.parentEntity.damageSources().mobAttack(parentEntity), 5.0F)) {
                            damagedEntitiesCount++;
                        }
                    }

                    // 回血
                    parentEntity.setHealth(parentEntity.getHealth() + damagedEntitiesCount * 5);
                }

                // 5 秒后变回原形
                if (isTransformed) {
                    transformationTimer++;
                    if (transformationTimer >= 20 * 5) { // 20 刻为 1 秒，5 秒即 20 * 5 刻
                        parentEntity.transformBack();
                        isTransformed = false;
                        transformationTimer = 0;
                    }
                }

                if (this.attackTimer == 50) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
            } else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
        }
    }
}
