package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

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
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EntityChief extends Ravager implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public int explosionPower = 5, attr = 0,pre=0;
    public boolean isaoe = false;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    //private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityChief2.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
    };

    public EntityChief(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }


    protected boolean isSunSensitive() {
        return true;
    }

    public void aiStep() {
        super.aiStep();
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==1 && this.attr!=2 && this.attr!=3)
        {
            //this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 30; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleInit.FLAME_PARTICLE.get(), pos.x, pos.y, pos.z,
                        this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07);
            }
        }

        if(this.entityData.get(STATE) == 3) {
            this.defend();
        }

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.50D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(0, new EntityChief2.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, AbstractVillager.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        //this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }


//    public boolean doHurtTarget(Entity p_70652_1_) {
//        Random ran = new Random();
//        int co = ran.nextInt(4);
//        this.level().broadcastEntityEvent(this, (byte)4);
//        float f = this.getAttackDamage();
//        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
//        boolean flag = p_70652_1_.hurt(damageSources().mobAttack(this), f1);
//        if (flag) {
//            p_70652_1_.setDeltaMovement(p_70652_1_.getDeltaMovement().add(0.0D, (double)0.4F, 0.0D));
//            this.doEnchantDamageEffects(this, p_70652_1_);
//        }
//
//        if(co==0){
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60,1,true,true));
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100,1,true,true));
//        }
//        if(co==1 && this.isaoe){
//            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,1,true,true));
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20,1,true,true));
//        }
//        else if(co==2 && this.attr!=4 && this.isaoe!=true){
//            this.level().explode((Entity)null, p_70652_1_.getX(), p_70652_1_.getY(), p_70652_1_.getZ(), (float)1, true, Level.ExplosionInteraction.BLOCK);
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 60,2,true,true));
//        }
//        else{
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40,1,true,true));
//        }
//        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
//        return flag;
//    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_CHIEF_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_CHIEF_AMBIENT2.get();
        return SoundEvents.RAVAGER_ROAR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundEvents.RAVAGER_HURT;
        return SoundInit.ENTITY_HESEN_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_CHIEF_DEATH.get();
    }

    public int getInvulnerableTicks() {
        return 200;
    }

    protected float getStandingEyeHeight(PoseStack.Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 1.5F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        //this.entityData.set(DATA_ID_INV, p_82215_1_);
    }

    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        //this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable Component p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        if(this.getHealth()<200.F){
            this.level().addParticle(ParticleTypes.SMOKE, this.position().x + this.random.nextGaussian() * (double)0.3F, this.position().y + this.random.nextGaussian() * (double)0.3F, this.position().z + this.random.nextGaussian() * (double)0.3F, 0.0D, 0.0D, 0.0D);
            if(this.hasEffect(MobEffects.JUMP)){
                this.addEffect(new MobEffectInstance(MobEffects.JUMP, 600,1,false,false));
            }
        }

        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 60.0F && this.getHealth()<=65.0F)
        {
            for(int i=0;i<4;i++)
                this.heal(2F*ran.nextFloat());
        }

        if(this.getHealth() <= 10.0F)
        {
            this.convertTo(EntityInit.CHIEF2.get(),true);
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private void defend() {
        if (this.isAlive()) {

            Vec3 vec3 = this.getBoundingBox().getCenter();

            for(int j=0;j<3;j++)
            {
                for (int i = 0; i < 10; i++)
                {
                    float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                    Vec3 pos = new Vec3(vec3.x + 3 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 3 * Math.cos(0 + deltaOmega));
                    //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                    this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
                }
            }

            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

    }

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossInfo.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
    }


    public boolean isNonBoss()
    {
        return false;
    }

    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.walk"));
            return PlayState.CONTINUE;
        }
//        Random ran = new Random();
//        int co = ran.nextInt(30);
//        if(co==1) {
//        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
//            return PlayState.CONTINUE;
//        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.attack2"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.kick"));
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

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    public int getDefendingState() {
        return this.entityData.get(DEFENDSTATE);
    }

    public void setDefendingState(int time) {
        this.entityData.set(DEFENDSTATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
    }

    @Override
    protected void updateControlFlags() {
        boolean flag = this.getTarget() != null && this.hasLineOfSight(this.getTarget());
        this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
        super.updateControlFlags();
    }

    public static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityChief);
    };

    static class AttackGoal extends Goal {
        private final EntityChief parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityChief ghast) {
            this.parentEntity = ghast;
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
                this.parentEntity.attr=this.attackTimer;
                this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer==18) {
                    if(this.parentEntity.getHealth() < 5 ||
                            (this.parentEntity.getHealth() > 120 && this.parentEntity.getHealth()<130) ||
                            (this.parentEntity.getHealth() > 90 && this.parentEntity.getHealth()<101) ||
                            (this.parentEntity.getHealth() > 70 && this.parentEntity.getHealth()<75) ||
                            (this.parentEntity.getHealth() > 26 && this.parentEntity.getHealth()<35) ||
                            (this.parentEntity.getHealth() > 10 && this.parentEntity.getHealth()<18) )
                    {
                        this.parentEntity.setAttackingState(2);
                        if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
                                && livingentity.getBbWidth() < 1.81F){
                            livingentity.stopRiding();
                            livingentity.startRiding(this.parentEntity, true);
                        }
                    }
                    else{
                        this.parentEntity.setAttackingState(3);
                    }
                }
                else if(this.attackTimer == 1){
                    this.parentEntity.setAttackingState(1);
                }

                if(this.attackTimer==9 || this.parentEntity.getAttckingState()==1){
                    for(int l = 1; l < 10; l++)
                    {
                        this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, 5.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -5.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, 6.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(l, 3F, -6.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                }

                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==3){
                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                        double d00 = lvt.getX() - this.parentEntity.getX();
                        double d10 = lvt.getZ() - this.parentEntity.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue());
                    }
                }

                if (this.attackTimer == 40) {
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

    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = this.attr < 10 ? 0 : Math.min((this.attr * 3 - 30) * 0.2, 5.2F);
            float pullIn = this.attr < 15 ? 0 : Math.min((this.attr - 15) * 0.15F, 0.75F);
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            if (this.attr == 32 && this.getAttckingState()==2) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity)passenger).getMaxHealth()*0.4F);
                passenger.stopRiding();
            }
        }
    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);

        AABB selection = new AABB(px - 1, minY, pz - 1, px + 1, maxY, pz + 1);
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (Object entity : hit) {
            if(entity instanceof LivingEntity)
            {
                if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityHeisen || (LivingEntity)entity == this) continue;
                if (entity instanceof Player && ((Player)entity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
                    this.disableShield((LivingEntity)entity, shieldbreakticks);
                }
                else{
                    boolean flag = ((LivingEntity)entity).hurt(damageSources().mobAttack(this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(((LivingEntity)entity).getMaxHealth() * hpdamage)));
                    if(flag)
                        ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, airborne, 0.0));
                }

            }
        }

    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(4+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }
}