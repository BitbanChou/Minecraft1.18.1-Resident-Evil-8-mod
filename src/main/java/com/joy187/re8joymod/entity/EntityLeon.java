package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
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

import java.util.Random;

public class EntityLeon extends EntityChris{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);


    public EntityLeon(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 50.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 4D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 8.0D);
    }
    
    protected void registerGoals() {
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true) {
            @Override
            public boolean canUse() {
                LivingEntity t = EntityLeon.this.getTarget();
                return super.canUse() && !AerialCombatHelper.isAerialTarget(EntityLeon.this, t);
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity t = EntityLeon.this.getTarget();
                return super.canContinueToUse() && !AerialCombatHelper.isAerialTarget(EntityLeon.this, t);
            }
        });
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F) {
            @Override
            public boolean canUse() {
                LivingEntity t = EntityLeon.this.getTarget();
                return super.canUse() && !AerialCombatHelper.isAerialTarget(EntityLeon.this, t);
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity t = EntityLeon.this.getTarget();
                return super.canContinueToUse() && !AerialCombatHelper.isAerialTarget(EntityLeon.this, t);
            }
        });
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new OfferFlowerGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    
    
    protected void customServerAiStep() {

        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20,1,false,true));
        }
        else if(this.getHealth()<8.0F){
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,1,false,true));
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20,0,false,false));
        }
        
        super.customServerAiStep();
    }
        
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            float dam=(float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
//            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
            ((LivingEntity)p_70652_1_).hurt(damageSources().mobAttack(this),dam*(this.random.nextFloat()+1));
//            else
//                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));
//
            if(p_70652_1_ instanceof EntityMiranda1 || p_70652_1_ instanceof EntityMiranda2
            || p_70652_1_ instanceof EntityMiranda3 || p_70652_1_ instanceof EntityMiranda4
            || p_70652_1_ instanceof EntityRe8Dimi || p_70652_1_ instanceof EntityMuHeisen) {
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*3,1,false,true));
            }
        }

        return flag;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_LEON_AMBIENT1.get();
        }
        else if(co==1) SoundInit.ENTITY_LEON_AMBIENT2.get();
        return SoundInit.ENTITY_LEON_ADA.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_LEON_HURT.get();
        }
        return SoundInit.ENTITY_CHRIS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_LEON_ADA.get();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
            return PlayState.STOP;
        }

    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.leon.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.leon.idle"));
        return PlayState.CONTINUE;
    }
    
	
	
    	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.leon.attack"))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.leon.attack2"))
						.triggerableAnim("special", RawAnimation.begin().thenPlay("animation.leon.shoot"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}
	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		if (state == 1) {
			this.triggerAnim("controller1", "slash");
		} else if (state == 2) {
			this.triggerAnim("controller1", "heavy");
		} else if (state == 3) {
			this.triggerAnim("controller1", "special");
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1 || time == 2 || time == 3) && prev != time) {
			this.startAttackAnim(time);
		}
	}





	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    static class AttackGoal extends Goal {
        private final EntityLeon parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityLeon mob) {
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
            if (livingentity != null && this.parentEntity.hasLineOfSight(livingentity)) {
                ++this.attackTimer;
                boolean aerial = AerialCombatHelper.isAerialTarget(this.parentEntity, livingentity);

                if (aerial) {
                    AerialCombatHelper.holdShootDistance(this.parentEntity, livingentity);
                    // Stay in shoot stance vs air units; never melee-chase underneath.
                    if (this.attackTimer == 1 || this.parentEntity.getAttckingState() != 3) {
                        this.parentEntity.setAttackingState(3);
                    }
                    if (this.attackTimer == 8 || this.attackTimer == 16 || this.attackTimer == 24) {
                        EntityBOWShoot shot = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
                        AerialCombatHelper.aimBowShot(this.parentEntity, shot, livingentity, 15.5F, 0.75F);
                        shot.level().addParticle(ParticleTypes.FLAME, shot.getX(), shot.getY(), shot.getZ(),
                                shot.getDeltaMovement().x, shot.getDeltaMovement().y, shot.getDeltaMovement().z);
                        shot.playSound(SoundInit.M1851.get(), 1.5F, 1.5F);
                        shot.damage *= 1.2;
                        this.parentEntity.level().addFreshEntity(shot);
                    }
                    if (this.attackTimer >= 30) {
                        this.parentEntity.setAttackingState(0);
                        this.parentEntity.setAttackingState(3);
                        this.attackTimer = 0;
                    }
                    return;
                }

                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer == 16) {
                    if (this.parentEntity.getHealth() < 5
                            || (this.parentEntity.getHealth() > 26 && this.parentEntity.getHealth() < 30)
                            || (this.parentEntity.getHealth() > 13 && this.parentEntity.getHealth() < 18)) {
                        this.parentEntity.setAttackingState(2);
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 10, true, true));
                    } else {
                        this.parentEntity.setAttackingState(3);
                        EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
                        AerialCombatHelper.aimBowShot(this.parentEntity, abstractarrowentity, livingentity, 15.5F, 0.75F);
                        abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(),
                                abstractarrowentity.getDeltaMovement().x, abstractarrowentity.getDeltaMovement().y, abstractarrowentity.getDeltaMovement().z);
                        abstractarrowentity.playSound(SoundInit.M1851.get(), 1.5F, 1.5F);
                        abstractarrowentity.damage *= 1.2;
                        this.parentEntity.level().addFreshEntity(abstractarrowentity);
                    }
                } else if (this.attackTimer == 1) {
                    this.parentEntity.setAttackingState(1);
                }
                if (this.attackTimer == 30) {
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
