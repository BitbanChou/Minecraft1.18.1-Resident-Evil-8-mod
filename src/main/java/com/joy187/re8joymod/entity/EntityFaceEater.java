package com.joy187.re8joymod.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.warden.AngerLevel;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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


public class EntityFaceEater extends WitherSkeleton implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityFaceEater.class,
            EntityDataSerializers.INT);

    public EntityFaceEater(EntityType<? extends WitherSkeleton> p_34166_, Level p_34167_) {
        super(p_34166_, p_34167_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EnderMan.class, true,true));
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH,20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.ARMOR, 2.0D)
                .add(Attributes.FOLLOW_RANGE, 25.0D);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

        if(this.getTarget()!=null){
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.fe.attack"));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.fe.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.fe.idle"));
        return PlayState.CONTINUE;
    }


    @Override
    public void aiStep() {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        super.aiStep();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
    }

    static class AttackGoal extends Goal
    {
        private final EntityFaceEater parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityFaceEater mob) {
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
            if (this.parentEntity.hasLineOfSight(livingentity)) {
                ++this.attackTimer;

                if (this.attackTimer == 15) {
                    if(this.parentEntity.distanceToSqr(livingentity)>8.0D)
                    {
                        //this.parentEntity.setAttackingState(2);
                        Vec3 vec3 = this.parentEntity.position().add(0.0D, (double)1.6F, 0.0D);
                        Vec3 vec31 = livingentity.getEyePosition().subtract(vec3);
                        Vec3 vec32 = vec31.normalize();

                        for(int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
                            Vec3 vec33 = vec3.add(vec32.scale((double)i));
                            ((ServerLevel)this.parentEntity.level()).sendParticles(ParticleTypes.ENCHANT, vec33.x, vec33.y, vec33.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                        }

                        this.parentEntity.playSound(SoundEvents.VEX_CHARGE, 3.0F, 1.0F);
                        livingentity.hurt(livingentity.damageSources().sonicBoom(this.parentEntity), livingentity.getMaxHealth()*0.25F);
                        double d1 = 0.25D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        double d0 = 1.5D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        livingentity.push(-vec32.x() * d0, vec32.y() * d1, -vec32.z() * d0);
                    }
                }
                else{
                    this.parentEntity.setAttackingState(1);
                }
                if (this.attackTimer == 30) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }
            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
        }
    }
}

