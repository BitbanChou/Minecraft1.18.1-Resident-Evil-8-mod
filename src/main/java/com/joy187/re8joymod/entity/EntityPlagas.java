package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.ClimbOnTopOfPowderSnowGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import java.util.function.Predicate;

public class EntityPlagas extends Silverfish implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityLycan.class, EntityDataSerializers.BYTE);

    public EntityPlagas(EntityType<? extends Silverfish> p_33523_, Level p_33524_) {
        super(p_33523_, p_33524_);
        this.xpReward = 20;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.27D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> !(p_31504_ instanceof EntityChief) && !(p_31504_ instanceof EntityArmadura)
            && !(p_31504_ instanceof EntityMannequin) && !(p_31504_ instanceof EntityLycan) && !(p_31504_ instanceof EntityDund)
            && !(p_31504_ instanceof EntityBeibaby) && !(p_31504_ instanceof EntityUrias);

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D,true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Piglin.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EnderMan.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Wolf.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityRegenerator.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, EntityEvilDog.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, true));
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }

    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                if(entityIn instanceof Villager)
                {
                    if(this.random.nextFloat()<0.09 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof Raider)
                {
                    if(this.random.nextFloat()<0.1 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof AbstractSkeleton)
                {
                    if(this.random.nextFloat()<0.09 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof EntityRegenerator)
                {
                    if(this.random.nextFloat()<0.25 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof EntityEvilDog)
                {
                    if(this.random.nextFloat()<0.2 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof EnderMan)
                {
                    if(this.random.nextFloat()<0.18 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                if(entityIn instanceof Creeper)
                {
                    if(this.random.nextFloat()<0.55 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        this.discard();
                    }
                }
                else if(entityIn instanceof Zombie || entityIn instanceof Piglin) {
                    if(this.random.nextFloat()<0.12 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100,1,true,true));
                        this.discard();
                    }
                }
                else if(entityIn instanceof Player){
                    if(this.random.nextFloat()<0.15 && !((LivingEntity) entityIn).hasEffect(EffectInit.PLAGAS.get()))
                    {
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200,0,true,true));
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,2,true,true));
                        this.discard();
                    }
                }
            }
            return true;
        }
    }

    public boolean killedEntity(ServerLevel p_219160_, LivingEntity livingentity) {
        boolean flag = super.killedEntity(p_219160_, livingentity);
        if(this.random.nextBoolean()){

            return flag;
        }

        if(livingentity instanceof Villager) {
            Villager villager = (Villager)livingentity;
            EntityVillagerGanado zombievillager = villager.convertTo(EntityInit.VILLAGERGANADO.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Wolf)
        {
            Wolf villager = (Wolf)livingentity;
            EntityEvilDog zombievillager = villager.convertTo(EntityInit.EVILDOG.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Raider) {
            Raider villager = (Raider)livingentity;
            EntityZealot zombievillager = villager.convertTo(EntityInit.ZEALOT.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Zombie) {
            Zombie villager = (Zombie)livingentity;
            EntityLycan zombievillager = villager.convertTo(EntityInit.LYCAN.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }

        return flag;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_33820_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_33820_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagas.walk"));
            return PlayState.CONTINUE;
        }


        event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagas.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.getTarget()!=null) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagas.attack"));
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
}
