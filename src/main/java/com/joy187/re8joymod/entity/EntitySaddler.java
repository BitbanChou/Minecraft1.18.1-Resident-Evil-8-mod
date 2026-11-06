package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
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

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class EntitySaddler extends Monster implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    //private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntitySaddler2.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntitySaddler.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntitySaddler.class,
            EntityDataSerializers.INT);
    public int explosionPower = 5, attr = 0,pre=0;
    public EntitySaddler(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 200;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.24D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.10D).
                add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.ILLAGER && p_31504_.attackable() && !(p_31504_ instanceof EntitySaddler);
    };

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(0, new EntitySaddler2.DimiDoNothingGoal());
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
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

    @Override
    public boolean hurt(DamageSource p_37849_, float p_37850_)
    {
        if (!level().isClientSide()) {
            boolean isHurt = true;
            if (p_37849_.getEntity() instanceof EntityFaceEater) {
                return super.hurt(p_37849_,1);
            }
            //System.out.println(isHurt);
            if(isHurt)
                return super.hurt(p_37849_,p_37850_);
        }
        return false;
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
            this.convertTo(EntityInit.SADDLER2.get(),true);
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.walk"));
            return PlayState.CONTINUE;
        }
//        Random ran = new Random();
//        int co = ran.nextInt(30);
//        if(co==1) {
//        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
//            return PlayState.CONTINUE;
//        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.attack2"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.attack"));
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

    static class AttackGoal extends Goal {
        private final EntitySaddler parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntitySaddler ghast) {
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
                //this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer==15) {
                    if(this.parentEntity.getHealth() < 5 ||
                            (this.parentEntity.getHealth() > 180 && this.parentEntity.getHealth()<200) ||
                            (this.parentEntity.getHealth() > 140 && this.parentEntity.getHealth()<160) ||
                            (this.parentEntity.getHealth() > 110 && this.parentEntity.getHealth()<120) ||
                            (this.parentEntity.getHealth() > 90 && this.parentEntity.getHealth()<101) ||
                            (this.parentEntity.getHealth() > 50 && this.parentEntity.getHealth()<70) ||
                            (this.parentEntity.getHealth() > 15 && this.parentEntity.getHealth()<35))
                    {
                        this.parentEntity.getNavigation().moveTo(livingentity,0.2D);
                        this.parentEntity.setAttackingState(2);
                    }
                    else{
//                        this.parentEntity.setAttackingState(3);
//                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100,1,true,true));
//                        if((this.parentEntity.getHealth()<110 && this.parentEntity.getHealth()>100) ||
//                                (this.parentEntity.getHealth()<50 && this.parentEntity.getHealth()>40) )
//                        {
//                            EntityVerdugo e = new EntityVerdugo(EntityInit.VERDUGO.get(),this.parentEntity.level());
//                            BlockPos pos = new BlockPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
//                            e.setPos(pos.getX(), pos.getY(),pos.getZ());
//                            this.parentEntity.level().addFreshEntity(e);
//
//                        }
//                        else{
//                            EntityZealot e = new EntityZealot(EntityInit.ZEALOT.get(),this.parentEntity.level());
//                            BlockPos pos = new BlockPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
//                            e.setPos(pos.getX(), pos.getY(),pos.getZ());
//                            this.parentEntity.level().addFreshEntity(e);
//
//                        }
                    }
                }
                else if(this.attackTimer == 1){
                    this.parentEntity.getNavigation().stop();
                    this.parentEntity.setAttackingState(1);
                    EntityFaceEater e = new EntityFaceEater(EntityInit.FE.get(),this.parentEntity.level());
                    //Position pos = new BlockPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                    e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                    this.parentEntity.level().addFreshEntity(e);

                }

                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==2){
                    if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
                            && livingentity.getBbWidth() < 2.4F){
                        livingentity.stopRiding();
                        if(this.parentEntity.getRandom().nextFloat()<0.8f && !(livingentity instanceof Slime))
                            livingentity.stopRiding();
                            livingentity.startRiding(this.parentEntity, true);
                    }

                }

                if(this.attackTimer==35 && this.parentEntity.getAttckingState()==1){
                    this.parentEntity.getNavigation().moveTo(livingentity.getX()+this.parentEntity.random.nextInt(4),livingentity.getY(),livingentity.getZ()+this.parentEntity.random.nextInt(6),60D);
                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), LIVING_ENTITY_SELECTOR)) {
                        double d00 = lvt.getX() - this.parentEntity.getX();
                        double d10 = lvt.getZ() - this.parentEntity.getZ();
                        double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                        lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue());
                    }
                }

                if (this.attackTimer == 45) {
                    this.parentEntity.setAttackingState(0);
                    if(this.parentEntity.random.nextFloat()<0.35)
                    {
                        EntityNovi e = new EntityNovi(EntityInit.NOVI.get(),this.parentEntity.level());
                        e.addEffect(new MobEffectInstance(MobEffects.LEVITATION,10,0));
                        //BlockPos pos = new BlockPos();
                        e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                        this.parentEntity.level().addFreshEntity(e);
                    }

                    this.attackTimer = -5;
                }
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
        }

    }

    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_SADDLER_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_SADDLER_AMBIENT2.get();
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_SADDLER_DEATH.get();
    }

    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = this.attr-25 < 10 ? 0 : Math.min(((this.attr-25) * 3 - 30) * 0.2, 5.2F);
            float pullIn = this.attr-25 < 15 ? 0 : Math.min(((this.attr-25) - 15) * 0.15F, 0.75F);
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            if (this.attr == 42 && this.getAttckingState()==2) {
                passenger.hurt(damageSources().fellOutOfWorld(), ((LivingEntity)passenger).getMaxHealth()*0.2F+((LivingEntity) passenger).getArmorValue());
                passenger.stopRiding();
            }
        }
    }


}
