package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.ArmaduraVariant;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
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

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;


public class EntityArmadura extends Ravager implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public EntityArmadura(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
    }

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityArmadura.class,
            EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(EntityArmadura.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityArmadura.class, EntityDataSerializers.BYTE);

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.2D).
                add(Attributes.ARMOR, 3.5D).
                add(Attributes.ATTACK_DAMAGE, 9D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(2, new ArmaduraAttackGoal(this, 1.0D));
        //this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
//        {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.knight.death"));
//            return PlayState.CONTINUE;
//        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.attack2"));
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

    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {

            if (this.entityData.get(STATE)==0) {
                this.roar();
            }
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(this.getHealth()>1.0F && this.getHealth()<6.0F && (this.random.nextFloat()<0.25)){
            EntityPlagasVillager e=new EntityPlagasVillager(EntityInit.PLAGASARMADURA.get(),this.level());
            e.copyPosition(this);
            this.discard();
            this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            this.level().addFreshEntity(e);
        }

    }

    private void roar() {
        if (this.isAlive()) {

            Vec3 vec3 = this.getBoundingBox().getCenter();

            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
            }
            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
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
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        //setSitting(tag.getBoolean("isSitting"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        //tag.putBoolean("isSitting", this.isSitting());
        tag.putInt("Variant", this.getTypeVariant());
    }

    private static final Predicate<Entity> ARMA_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityArmadura);
    };

    static class AttackGoal extends Goal {
        private final EntityArmadura parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityArmadura mob) {
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

//        public void tick() {
//            LivingEntity livingentity = this.parentEntity.getTarget();
//            if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
//                Level world = this.parentEntity.level();
//                ++this.attackTimer;
//                Random rand = new Random();
//                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
//                double d0 = Math.min(livingentity.getY(), livingentity.getY());
//                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
//                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
//                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
//                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
//                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
//                        livingentity.getX() - parentEntity.getX());
//
//                this.parentEntity.getNavigation().moveTo(livingentity, 1.1D);
//                if (this.attackTimer == 5) {
//                    this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20,5,true,false));
//                    if(this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.85 ||
//                            this.parentEntity.getHealth()<=this.parentEntity.getMaxHealth()*0.25 ||
//                            (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.45 && this.parentEntity.getHealth()<=this.parentEntity.getMaxHealth()*0.6))
//                        this.parentEntity.setAttackingState(2);
//                    else{
//                        this.parentEntity.setAttackingState(1);
//                    }
//                }
//                else if(this.attackTimer==23 && this.parentEntity.getAttckingState()==2){
//                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), ARMA_AREA)) {
//                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.4F);
//                    }
//                }
//                else if(this.attackTimer==25){
//                    if(this.parentEntity.getAttckingState()==1)
//                    {
//                        for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), ARMA_AREA)) {
//                            lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.3F);
//                        }
//                    }
//                    this.parentEntity.setAttackingState(0);
//                }
//
//                if (this.attackTimer == 30) {
//                    this.attackTimer = -5;
//                    this.parentEntity.setAttackingState(0);
//                }
//            }
//            else if (this.attackTimer > 0) {
//                this.attackTimer = -5;
//            }
//            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//        }

        public void tick() {
            LivingEntity livingentity = this.parentEntity.getTarget();
            if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
                Level world = this.parentEntity.level();
                ++this.attackTimer;
                //System.out.println(this.attackTimer+" "+this.parentEntity.getAttckingState());
                Random rand = new Random();
                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());
                this.parentEntity.getNavigation().moveTo(livingentity, 1.1D);
                if (this.attackTimer==5) {
                    if(this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.85 ||
                            this.parentEntity.getHealth()<=this.parentEntity.getMaxHealth()*0.25 ||
                            (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.45 && this.parentEntity.getHealth()<=this.parentEntity.getMaxHealth()*0.6))
                    {
                        this.parentEntity.setAttackingState(2);
                    }
                    else{
                        this.parentEntity.setAttackingState(1);
                    }
                }

                if(this.attackTimer==23 && this.parentEntity.getAttckingState()==2){
                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), ARMA_AREA)) {
                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.4F);
                    }
                }

                if(this.attackTimer==25){
                    if(this.parentEntity.getAttckingState()==1)
                    {
                        for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), ARMA_AREA)) {
                            lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.3F);
                        }
                    }
                    this.parentEntity.setAttackingState(0);
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

    public ArmaduraVariant getVariant2() {
        return ArmaduraVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(ArmaduraVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        ArmaduraVariant variant = Util.getRandom(ArmaduraVariant.values(), this.random);
        if(variant.getId()==1){
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
            this.getAttribute(Attributes.ARMOR).setBaseValue(6.0D);
        }
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.METAL_PLACE;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.METAL_HIT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.METAL_BREAK;
    }

    protected void playStepSound(BlockPos pos, BlockState blockstate) {
        this.playSound(SoundEvents.METAL_STEP, 0.15F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
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
        return 60;
    }
}
