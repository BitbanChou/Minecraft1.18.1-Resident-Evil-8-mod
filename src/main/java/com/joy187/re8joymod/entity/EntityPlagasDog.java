package com.joy187.re8joymod.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityPlagasDog extends Monster implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityPlagasDog(EntityType<? extends Monster> p_30369_, Level p_30370_) {
        super(p_30369_, p_30370_);
        this.xpReward = 15;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().
                add(Attributes.MAX_HEALTH, 20.0D).
                add(Attributes.MOVEMENT_SPEED, 0.5D).
                add(Attributes.ATTACK_DAMAGE, 4D).
                add(Attributes.FOLLOW_RANGE, 50.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(Monster.class));
        this.goalSelector.addGoal(2, new DogAttackGoal(this, 1.0D,false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    static class DogAttackGoal extends MeleeAttackGoal {
        private final EntityPlagasDog zombie;

        public DogAttackGoal(EntityPlagasDog entity, double p_i46803_2_, boolean p_i46803_4_) {
            super(entity, p_i46803_2_, p_i46803_4_);
            this.zombie=entity;
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            this.setDeltaMovement(0,0.5*this.random.nextFloat(),0);
            return true;
        }
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.evildog.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.evildog.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if(this.getTarget()!=null)
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.evildog.attack"));
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
}
