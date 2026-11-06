package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

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
import java.util.function.Predicate;

public class EntityAda4 extends EntityChris{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);


    public EntityAda4(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 50.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 4D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 6.0D);
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
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
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

    private static final Predicate<Entity> ADA_AREA = (entity) -> {
        return entity.isAlive();
    };

    @Override
    protected SoundEvent getAmbientSound() {

        Random ran = new Random();
        int co = ran.nextInt(3);

        if(co<2){
            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), ADA_AREA)) {
                if(lvt instanceof EntityLeon && co==1)
                    return SoundInit.ENTITY_ADA_ADA4LEON.get();
            }
        }

        if(co==0)
        {
            return SoundInit.ENTITY_ADA_ADA4D2.get();
        }
        else if(co==1){
            return SoundInit.ENTITY_ADA_ADA4D.get();
        }
        return SoundInit.ENTITY_ADA_ADA4.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_BLOCK_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==1){
            return SoundInit.ENTITY_ADA_DEATH.get();
        }
        return SoundInit.ENTITY_ADA_ADA4LEON.get();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack2"));
			return PlayState.CONTINUE;
		}
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.shoot"));
            return PlayState.CONTINUE;
        }
		return PlayState.CONTINUE;
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
        private final EntityAda4 parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityAda4 mob) {
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
                if (this.attackTimer==16) {
                    if(this.parentEntity.getHealth() < 5 ||
                            (this.parentEntity.getHealth() > 26 && this.parentEntity.getHealth()<30) ||
                            (this.parentEntity.getHealth() > 13 && this.parentEntity.getHealth()<18) )
                    {
                        this.parentEntity.setAttackingState(2);
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20,10,true,true));
                    }
                    else{
                        this.parentEntity.setAttackingState(3);
                        EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
                        abstractarrowentity.shootFromRotation(this.parentEntity, this.parentEntity.getXRot(), this.parentEntity.getYRot(), 0.0F, 15.5F, 0.75F);

                        abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundInit.M1851.get(), 1.5F, 1.5F);
                        abstractarrowentity.damage*=1.2;

                        this.parentEntity.level().addFreshEntity(abstractarrowentity);
                    }
                }
                else if(this.attackTimer == 1){
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
