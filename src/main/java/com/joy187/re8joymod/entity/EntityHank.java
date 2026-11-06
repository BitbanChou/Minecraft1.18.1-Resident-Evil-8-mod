package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import java.util.Random;
import java.util.function.Predicate;

public class EntityHank extends EntityEthan implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityHank.class,
			EntityDataSerializers.INT);
    private int attackTimer;
    public EntityHank(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 100;
        this.attackTimer=0;
    }

    public static final AnimationState attackAnimationState = new AnimationState();
    public static final AnimationState attackAnimationState2 = new AnimationState();

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100.0D).
        	    add(Attributes.MOVEMENT_SPEED, 0.24D).
        	    add(Attributes.KNOCKBACK_RESISTANCE, 0.9D).
        	    add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    protected void registerGoals() {
		//this.goalSelector.addGoal(1, new AttackGoal(this));
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
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
           return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper);
        }));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));
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
	
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
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

//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//    	
//    	if (event.isMoving()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.walk"));
//            return PlayState.CONTINUE;
//        }
//
//        event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.idle"));
//        return PlayState.CONTINUE;
//    }
//    
//	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
//		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack"));
//			return PlayState.CONTINUE;
//		}
//		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack2"));
//			return PlayState.CONTINUE;
//		}
//		return PlayState.CONTINUE;
//	}
//	
//    @Override
//	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.add(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.add(new AnimationController(this, "controller1",
//                0, this::predicate1));
//	}

    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {

        // 检测生物是否死亡
//		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("death")); // 播放死亡动画
//			return PlayState.CONTINUE;
//		}

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.idle"));
        return PlayState.CONTINUE;
    }

    public static <T extends EntityHank & GeoAnimatable> AnimationController<T> genericAttackAnimation(T animatable, RawAnimation attackAnimation) {
        return new AnimationController<>(animatable, "Attack", 0, event -> {
            if (attackAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack"));

                return PlayState.CONTINUE;
            }
            if (attackAnimationState2.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack2"));

                //return PlayState.CONTINUE;
            }

            event.getController().forceAnimationReset();
            return PlayState.CONTINUE;
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
        data.add(genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE));

    }

	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public boolean hurt(DamageSource p_37849_, float p_37850_)
    {
        if (!level().isClientSide()) {
            boolean isHurt = false;
            if (p_37849_ != damageSources().fellOutOfWorld() && p_37849_ != damageSources().onFire() && p_37850_ > 1.0F) {
                isHurt=true;
            }
            float predam=p_37850_;
            if(p_37850_>this.getMaxHealth()*0.22){
                p_37850_=1;
            }

            if(p_37849_.getEntity() instanceof Player player)
            {
                ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
                if(stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem)
                {
                    p_37850_=predam;
                }
            }

            if(p_37849_ == damageSources().wither()) isHurt=false;
            if(p_37849_ == damageSources().explosion(this,this.getLastHurtByMob())) isHurt=false;
            //System.out.println(isHurt);
            if(isHurt){
                if(p_37849_.getEntity() instanceof Projectile)
                {
                    if(p_37850_>=19.5)
                        p_37850_=1;
                    else
                        p_37850_=p_37850_/3;
                }
                return super.hurt(p_37849_,p_37850_);
            }

        }
        return false;
    }

    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof IronGolem);
    };

//    static class AttackGoal extends Goal {
//        private final EntityHank parentEntity;
//        protected int attackTimer = 0;
//
//        public AttackGoal(EntityHank mob) {
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
//                  //this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
//                  if (this.attackTimer == 2) {
//                      if(this.parentEntity.random.nextDouble()>0.3)
//                        this.parentEntity.setAttackingState(1);
//                      else
//                          this.parentEntity.setAttackingState(2);
//                  } 
//
//                  if(this.parentEntity.getAttckingState()==1 && (this.attackTimer%2==0 && this.attackTimer<=20)){
//                      EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
//                      abstractarrowentity.shootFromRotation(this.parentEntity, this.parentEntity.getXRot(), this.parentEntity.getYRot(), 0.0F, 15.5F, 0.75F);
//                      abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
//                      abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
//                      abstractarrowentity.damage*=1.2;
//                      this.parentEntity.level().addFreshEntity(abstractarrowentity);
//                  }
//
//                 if(this.parentEntity.getAttckingState()==2){
//                     for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(3.0D), PIGEON_AREA)) {
//                         double d00 = lvt.getX() - this.parentEntity.getX();
//                         double d10 = lvt.getZ() - this.parentEntity.getZ();
//                         double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
//                         lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue());
//                     }
//                 }
//
//                  if (this.attackTimer == 35) {
//                       this.parentEntity.setAttackingState(0);
//
//                      EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
//                      abstractarrowentity.shootFromRotation(this.parentEntity, this.parentEntity.getXRot(), this.parentEntity.getYRot(), 0.0F, 15.5F, 0.75F);
//
//                      abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
//                      abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
//                      abstractarrowentity.damage*=1.2;
//
//                      this.parentEntity.level().addFreshEntity(abstractarrowentity);
//                       this.attackTimer = -5;
//                  }
//                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//
//             } 
//             else if (this.attackTimer > 0) {
//                  --this.attackTimer;
//             }
//        }
//
//   }

    @Override
    public void tick() {
        super.tick();

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && this.hasLineOfSight(livingentity)) {
            // 模拟 start 逻辑
            this.setAggressive(true);

            Random rand = new Random();
            Vec3 vector3d = this.getViewVector(1.0F);
            double d0 = Math.min(livingentity.getY(), livingentity.getY());
            double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
            double d2 = livingentity.getX() - (this.getX() + vector3d.x * 2.0D);
            double d3 = livingentity.getY(0.5D) - (0.5D + this.getY(0.5D));
            double d4 = livingentity.getZ() - (this.getZ() + vector3d.z * 2.0D);
            float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(),
                    livingentity.getX() - this.getX());

            if (this.attackTimer == 2) {
                if (this.random.nextDouble() > 0.3) {
                    this.setAttackingState(1);
                    attackAnimationState.start(this.tickCount);
                } else {
                    this.setAttackingState(2);
                    attackAnimationState2.start(this.tickCount);
                }
            }

            if (this.getAttckingState() == 1 && (this.attackTimer % 2 == 0 && this.attackTimer <= 20)) {
                EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.level(), this);
                abstractarrowentity.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 15.5F, 0.75F);
                this.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
                abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
                abstractarrowentity.damage *= 1.2;
                this.level().addFreshEntity(abstractarrowentity);
            }

            if (this.getAttckingState() == 2) {
                for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.0D), PIGEON_AREA)) {
                    double d00 = lvt.getX() - this.getX();
                    double d10 = lvt.getZ() - this.getZ();
                    double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                    lvt.hurt(lvt.damageSources().mobAttack(this), ((LivingEntity) lvt).getMaxHealth() * 0.1F + lvt.getArmorValue());
                }
            }

            if (this.attackTimer == 35) {
                this.setAttackingState(0);

                EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.level(), this);
                abstractarrowentity.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 15.5F, 0.75F);
                this.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
                abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
                abstractarrowentity.damage *= 1.2;
                this.level().addFreshEntity(abstractarrowentity);

                this.attackTimer = -5;
            }

            this.lookAt(livingentity, 30.0F, 30.0F);
        }

        this.attackTimer++;
        if (this.attackTimer >= 50) {
            this.setAttackingState(0);
            this.attackTimer = -10;
            attackAnimationState.stop();
            attackAnimationState2.stop();
        }
//        else {
//            // 模拟 stop 逻辑
//            this.setAggressive(false);
//            this.setAttackingState(0);
//            this.attackTimer = -1;
//        }
//
//        if (this.attackTimer > 0 && (livingentity == null || !this.hasLineOfSight(livingentity))) {
//            --this.attackTimer;
//        }
    }
}
