package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EntityU3 extends EntityBeibaby{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    //private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityChief2.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);
    private int attr = 0,attackTimer=0;
    private boolean zuan = false;
    public static final AnimationState attackAnimationState = new AnimationState();
    public static final AnimationState attackAnimationState2 = new AnimationState();
    public static final AnimationState attackAnimationState3 = new AnimationState();

    public EntityU3(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.attackTimer=0;
        this.zuan = false;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250.0D).
                add(Attributes.MOVEMENT_SPEED, 0.2D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 5.0D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.75D).
                add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(1, new AttackGoal(this));

    }

//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if (event.isMoving()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.walk"));
//            return PlayState.CONTINUE;
//        }
//
//
//        event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.idle"));
//        return PlayState.CONTINUE;
//    }
//
//    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
//        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack"));
//            return PlayState.CONTINUE;
//        }
//        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack2"));
//            return PlayState.CONTINUE;
//        }
//        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack3"));
//            return PlayState.CONTINUE;
//        }
//        return PlayState.CONTINUE;
//    }

    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {

        // 检测生物是否死亡
//		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("death")); // 播放死亡动画
//			return PlayState.CONTINUE;
//		}

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.idle"));
        return PlayState.CONTINUE;
    }

    public static <T extends EntityU3 & GeoAnimatable> AnimationController<T> genericAttackAnimation(T animatable, RawAnimation attackAnimation) {
        return new AnimationController<>(animatable, "Attack", 0, event -> {
            if (attackAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack"));

                return PlayState.CONTINUE;
            }
            if (attackAnimationState2.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack2"));

                //return PlayState.CONTINUE;
            }
            if (attackAnimationState3.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack3"));

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

    protected void customServerAiStep() {
        super.customServerAiStep();

        if((this.getHealth()<105 && this.getHealth()>95) ||
                (this.getHealth()<60 && this.getHealth()>45) || (this.getHealth()<227 && this.getHealth()>200)
        || (this.getHealth()<150 && this.getHealth()>120) || (this.getHealth()<190 && this.getHealth()>170) ||
                (this.getHealth()<24 && this.getHealth()>0) || (this.getHealth()<80 && this.getHealth()>65)){
            if(this.zuan){
                this.setPos(this.getX(),this.getY()+12,this.getZ());
                this.level().explode((Entity) null, this.getX()+this.random.nextInt(3), this.getY(), this.getZ()+this.random.nextInt(5), 2.0F, Level.ExplosionInteraction.NONE);
                this.level().explode((Entity) null, this.getX()+this.random.nextInt(4), this.getY(), this.getZ()+this.random.nextInt(4), 2.0F, Level.ExplosionInteraction.NONE);
                this.level().explode((Entity) null, this.getX()+this.random.nextInt(5), this.getY(), this.getZ()+this.random.nextInt(3), 2.0F, Level.ExplosionInteraction.NONE);
                this.zuan=false;
                //System.out.println("Back!");
            }
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundEvents.RAVAGER_CELEBRATE;
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {

        return SoundEvents.RAVAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_ROAR;
    }

//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.add(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.add(new AnimationController(this, "controller1",
//                0, this::predicate1));
//    }

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

    private static final Predicate<Entity> U3_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityU3);
    };

    @Override
    public void tick() {
        super.tick();
        if (!(this instanceof EntityElg)){
            LivingEntity livingentity = this.getTarget();
            if (livingentity != null && this.hasLineOfSight(livingentity)) {
                // 模拟 start 逻辑
                this.setAggressive(true);

                Level world = this.level();
                ++this.attackTimer;
                Random rand = new Random();
                Vec3 vector3d = this.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.getY(0.5D));
                double d4 = livingentity.getZ() - (this.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(),
                        livingentity.getX() - this.getX());
                this.attr = this.attackTimer;

                // 根据随机数决定是否钻地
                if (this.attackTimer == 1 && rand.nextInt(100) < 20 && !this.zuan) { // 20% 概率钻地
                    BlockPos pos = new BlockPos(this.getOnPos());
                    this.setPos(pos.getX(), pos.getY() - 10, pos.getZ());
                    world.explode((Entity) null, pos.getX() + rand.nextInt(5), pos.getY(), pos.getZ() + rand.nextInt(5), 0F, Level.ExplosionInteraction.NONE);
                    this.heal(20 * rand.nextFloat() + 5);
                    this.zuan = true;
                }
                if (this.zuan) {
                    this.roar();
                } else {
                    if (this.attackTimer == 5) {
                        int k = rand.nextInt(6);
                        // 根据随机数选择攻击状态
                        if (k > 4) { // 30% 概率选择攻击状态 3
                            this.setAttackingState(3);
                            attackAnimationState3.start(this.tickCount);
                            this.getNavigation().moveTo(livingentity, 1.05D);
                            if (!livingentity.hasPassenger(this) && !(livingentity instanceof EnderDragon)
                                    && livingentity.getBbWidth() < 1.81F) {
                                livingentity.stopRiding();
                                livingentity.startRiding(this, true);
                            }
                        } else if(k<2){
                            this.getNavigation().stop();
                            this.setAttackingState(2);
                            attackAnimationState2.start(this.tickCount);
                        } else {
                            this.getNavigation().moveTo(livingentity, 1.5D);
                            this.setAttackingState(1);
                            attackAnimationState.start(this.tickCount);
                        }
                    }
                }

                if (this.attackTimer == 12 && this.getAttckingState() == 1) {
                    for (int l = 1; l < 10; l++) {
                        this.blockSmashAttack(l, 3F, 1.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -1.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 2.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -2.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 3.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -3.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 4.5F, 60, 3F, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -4.5F, 60, 3F, 0.15F, 1.0F);
                    }
                }

                if (this.attackTimer == 13 && this.getAttckingState() == 1) {
                    for (int l = 1; l < 3; l++) {
                        this.blockSmashAttack(l, 3F, 1.5F, 10, this.getHealth() * 0.015f, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, -1.5F, 60, this.getHealth() * 0.015f, 0.15F, 1.0F);
                        this.blockSmashAttack(l, 3F, 2.5F, 10, this.getHealth() * 0.015f, 0.15F, 1.0F);
                    }
                }

                if (this.attackTimer == 10 && this.getAttckingState() == 2) {
                    for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), U3_AREA)) {
                        double d00 = lvt.getX() - this.getX();
                        double d10 = lvt.getZ() - this.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        lvt.hurt(lvt.damageSources().mobAttack(this), (float) lvt.getArmorValue() * 1f + lvt.getMaxHealth() * 0.15f);
                    }
                }

                if (this.attackTimer == 25 && this.getAttckingState() == 2) {
                    for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), U3_AREA)) {
                        double d00 = livingentity.getX() - this.getX();
                        double d10 = livingentity.getZ() - this.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        livingentity.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
                    }
                }


                this.lookAt(livingentity, 30.0F, 30.0F);

            }

            if (this.attackTimer >= 50) {
                this.setAttackingState(0);
                this.attackTimer = -10;
                attackAnimationState.stop();
                attackAnimationState2.stop();
                attackAnimationState3.stop();
                this.attr = 0;
            }
        }

//        else {
//            // 模拟 stop 逻辑
//            this.setAggressive(false);
//            this.setAttackingState(0);
//            this.attackTimer = -1;
//            this.zuan = false;
//        }

    }


//    static class AttackGoal extends Goal {
//        private final EntityU3 parentEntity;
//        protected int attackTimer = 0;
//        protected boolean zuan = false;
//
//        public AttackGoal(EntityU3 ghast) {
//            this.parentEntity = ghast;
//        }
//
//        public boolean canUse() {
//            return this.parentEntity.getTarget() != null;
//        }
//
//        public void start() {
//            super.start();
//            this.parentEntity.setAggressive(true);
//        }
//
//        @Override
//        public void stop() {
//            super.stop();
//            this.parentEntity.setAggressive(false);
//            this.parentEntity.setAttackingState(0);
//            this.attackTimer = -1;
//            this.zuan = false;
//        }
//
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
//                this.parentEntity.attr=this.attackTimer;
//                if((this.parentEntity.getHealth() > 230 && this.parentEntity.getHealth()<240) ||
//                     (this.parentEntity.getHealth() > 190 && this.parentEntity.getHealth()<210) ||
//                    (this.parentEntity.getHealth() > 150 && this.parentEntity.getHealth()<160) ||
//                        (this.parentEntity.getHealth() > 110 && this.parentEntity.getHealth()<130) ||
//                        (this.parentEntity.getHealth() > 85 && this.parentEntity.getHealth()<100) ||
//                    (this.parentEntity.getHealth() > 60 && this.parentEntity.getHealth()<70) ||
//                        (this.parentEntity.getHealth()> 20 && this.parentEntity.getHealth()<35)){
//                    if(!this.zuan)
//                    {
//                        //System.out.println("Zuan!");
//                        BlockPos pos = new BlockPos(this.parentEntity.getOnPos());
//                        this.parentEntity.setPos(pos.getX(),pos.getY()-10,pos.getZ());
//                        world.explode((Entity) null, pos.getX()+rand.nextInt(5), pos.getY(), pos.getZ()+rand.nextInt(5), 2.0F, Level.ExplosionInteraction.NONE);
//                        this.parentEntity.heal(20*rand.nextFloat()+5);
//                        this.zuan=true;
//                        this.parentEntity.zuan=1;
//                    }
//                    else{
//                        this.parentEntity.roar();
//                    }
//                }
//                else{
//                    if (this.attackTimer==5) {
//                        if(this.parentEntity.getHealth() < 5 ||
//                                (this.parentEntity.getHealth() > 170 && this.parentEntity.getHealth()<200) ||
//                                (this.parentEntity.getHealth() > 120 && this.parentEntity.getHealth()<130) ||
//                                (this.parentEntity.getHealth() > 90 && this.parentEntity.getHealth()<101) ||
//                                (this.parentEntity.getHealth() > 70 && this.parentEntity.getHealth()<75) ||
//                                (this.parentEntity.getHealth() > 26 && this.parentEntity.getHealth()<35) ||
//                                (this.parentEntity.getHealth() > 10 && this.parentEntity.getHealth()<18))
//                        {
//                            this.parentEntity.setAttackingState(3);
//                            this.parentEntity.getNavigation().moveTo(livingentity, 1.05D);
//                            if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
//                                    && livingentity.getBbWidth() < 1.81F){
//                                livingentity.stopRiding();
//                                livingentity.startRiding(this.parentEntity, true);
//                            }
//                        }
//                        else{
//                            this.parentEntity.getNavigation().stop();
//                            this.parentEntity.setAttackingState(2);
//                        }
//                    }
//                    else if(this.attackTimer == 1){
//                        this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
//                        this.parentEntity.setAttackingState(1);
//                    }
//                }
//
//                if(this.attackTimer==12 && this.parentEntity.getAttckingState()==1){
//                    for(int l = 1; l < 10; l++)
//                    {
//                        this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 60,3F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 60,3F, 0.15F, 1.0F);
//                    }
//                }
//
//                if(this.attackTimer==13 && this.parentEntity.getAttckingState()==1){
//                    for(int l = 1; l < 3; l++)
//                    {
//                        this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 10,this.parentEntity.getHealth()*0.015f, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 60,this.parentEntity.getHealth()*0.015f, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 10,this.parentEntity.getHealth()*0.015f, 0.15F, 1.0F);
//                    }
//                }
//
//                if(this.attackTimer==10 && this.parentEntity.getAttckingState()==2){
//                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), U3_AREA)) {
//                        double d00 = lvt.getX() - this.parentEntity.getX();
//                        double d10 = lvt.getZ() - this.parentEntity.getZ();
//                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
//                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity),(float)lvt.getArmorValue()*1f+lvt.getMaxHealth()*0.15f);
//                    }
//                }
//
//                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==2){
//                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), U3_AREA)) {
//                        double d00 = livingentity.getX() - this.parentEntity.getX();
//                        double d10 = livingentity.getZ() - this.parentEntity.getZ();
//                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
//                        livingentity.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
//                    }
//                }
//
//                if (this.attackTimer == 40) {
//                    this.parentEntity.setAttackingState(0);
//                    this.attackTimer = -5;
//                }
//            }
//            else if (this.attackTimer > 0) {
//                --this.attackTimer;
//            }
//            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//        }
//
//    }

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
            if (this.attr == 35) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity)passenger).getMaxHealth()*0.4F);
                passenger.stopRiding();
            }
        }
    }

    private void roar() {
        if (this.isAlive()) {
            Vec3 vec3 = this.getBoundingBox().getCenter();

//           for(int i = 0; i < 40; ++i) {
//              double d0 = this.random.nextGaussian() * 0.2D;
//              double d1 = this.random.nextGaussian() * 0.2D;
//              double d2 = this.random.nextGaussian() * 0.2D;
//              this.level().addParticle(ParticleTypes.DRIPPING_LAVA, vec3.x, vec3.y, vec3.z, d0, d1, d2);
//           }
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

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);
        int hitX = Mth.floor((double)px);
        int hitZ = Mth.floor((double)pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = new BlockPos(pos).above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);
        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
            fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity(fallingBlockEntity);
            if (!this.level().isClientSide && block.getBlock() != Blocks.BEDROCK) {
//                if (CMConfig.IgnisBlockBreaking) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
//                else if (ForgeEventFactory.getMobGriefingEvent((Level)this.level(), (Entity)this)) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
            }
        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (Object entity : hit) {
            if(entity instanceof LivingEntity)
            {
                if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityHeisen || (LivingEntity)entity == this) continue;
                if (entity instanceof Player && ((Player)entity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
                    this.disableShield((LivingEntity)entity, shieldbreakticks);
                }
                boolean flag = ((LivingEntity)entity).hurt(damageSources().mobAttack(this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(((LivingEntity)entity).getMaxHealth() * hpdamage)));
                if(flag)
                    ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, (double)airborne + 0.5, 0.0));
            }
        }

    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(6+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }
}
