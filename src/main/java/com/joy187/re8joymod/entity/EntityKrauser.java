package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.animatable.GeoEntity;
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

public class EntityKrauser extends Monster implements GeoEntity {

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityKrauser.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityKrauser.class,
            EntityDataSerializers.INT);
    private int attackTimer = 0;
    private int preatt = 0;

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable() && !(p_31504_ instanceof EntityKrauser) && !(p_31504_ instanceof EntityKrauser2) && !(p_31504_ instanceof EntitySalazar);
    };

    public EntityKrauser(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        this.xpReward=150;
        this.preatt=0;
        this.attackTimer=0;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.35D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 4D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        Random ran = new Random();
        this.fallDistance=0;

        if(this.getHealth() >= 1.0F && this.getHealth()<=8.0F)
        {
            this.convertTo(EntityInit.KRAUSER2.get(),true);
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    //}

    public void makeInvulnerable() {
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



    /** 走路/待机/硬直：攻击期间让出骨骼；硬直播 recover。 */
    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3) {
            return PlayState.STOP;
        }
        if (this.getDefendingState() == 1) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.krauser.recover"));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.krauser.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.krauser.idle"));
        return PlayState.CONTINUE;
    }

    protected void startAttackAnim(int state) {
        if (state == 1) {
            this.triggerAnim("controller1", "slash");
        } else if (state == 2) {
            this.triggerAnim("controller1", "heavy");
        } else if (state == 3) {
            this.triggerAnim("controller1", "slam");
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        AnimationController<?> attackController =
                new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
                        .triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.krauser.attack"))
                        .triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.krauser.attack2"))
                        .triggerableAnim("slam", RawAnimation.begin().thenPlay("animation.krauser.attack3"));
        data.add(attackController);
        data.add(new AnimationController<>(this, "controller", 8, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        int prev = this.entityData.get(STATE);
        this.entityData.set(STATE, time);
        if ((time == 1 || time == 2 || time == 3) && prev != time) {
            this.startAttackAnim(time);
        }
    }

    public int getDefendingState() {
        return this.entityData.get(DEFENDSTATE);
    }

    public void setDefendingState(int time) {
        this.entityData.set(DEFENDSTATE, time);
    }

    /** Impulse dash toward target on XZ; optional vertical boost. */
    private void dashToward(LivingEntity target, double horizontalSpeed, double verticalBoost) {
        Vec3 flat;
        if (target != null) {
            Vec3 to = target.position().subtract(this.position());
            flat = new Vec3(to.x, 0.0D, to.z);
        } else {
            Vec3 look = this.getLookAngle();
            flat = new Vec3(look.x, 0.0D, look.z);
        }
        if (flat.lengthSqr() < 1.0E-4D) {
            return;
        }
        Vec3 dir = flat.normalize().scale(horizontalSpeed);
        this.setDeltaMovement(dir.x, this.getDeltaMovement().y + verticalBoost, dir.z);
        this.hasImpulse = true;
    }

    private void leapUp(double vy) {
        Vec3 m = this.getDeltaMovement();
        this.setDeltaMovement(m.x * 0.2D, vy, m.z * 0.2D);
        this.hasImpulse = true;
    }

    private void beginRecover() {
        this.setAttackingState(0);
        this.attackTimer = -10;
        this.preatt = 0;
        this.setDefendingState(1);
        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 2, 5, true, true));
        this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * 2, 2, true, true));
        this.getNavigation().stop();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co<2)
        {
            return SoundInit.ENTITY_KRAUSER_AMBIENT11.get();
        }
        else if(co==2) return SoundInit.ENTITY_KRAUSER_AMBIENT12.get();
        return SoundInit.ENTITY_KRAUSER_AMBIENT21.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_KRAUSER_HURT.get();
        }
        return SoundInit.ENTITY_KRAUSER_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_KRAUSER_DEATH.get();
    }

    private static final Predicate<Entity> KRAUSER_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityKrauser);
    };

    @Override
    public void tick() {
        super.tick();

        // Post-attack recover / stagger window
        if (this.getDefendingState() == 1 && this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            this.getNavigation().stop();
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.15D, 1.0D, 0.15D));
            LivingEntity recoverTarget = this.getTarget();
            if (recoverTarget != null) {
                this.lookAt(recoverTarget, 30.0F, 30.0F);
            }
            return;
        } else if (this.getDefendingState() == 1) {
            this.setDefendingState(0);
        }

        LivingEntity target = this.getTarget();
        // Losing target/LOS must clear skill STATE so locomotion can resume
        if (target == null) {
            if (this.getAttckingState() != 0) {
                this.setAttackingState(0);
                this.attackTimer = 0;
                this.preatt = 0;
            }
        } else if (!this.hasLineOfSight(target) && this.getAttckingState() != 0) {
            this.setAttackingState(0);
            this.preatt = 0;
        }

        if (target != null && this.hasLineOfSight(target)) {
            ++this.attackTimer;
            Random rand = new Random();
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            int atk = this.getAttckingState();

            // Hold feet during skill windup / aerial beats so nav doesn't cancel impulse
            if (atk == 2 || atk == 3) {
                this.getNavigation().stop();
            } else if (atk != 1) {
                this.getNavigation().moveTo(target, 1.0D);
            }

            if (this.attackTimer == 5) {
                int randomSkill = rand.nextInt(3);
                switch (randomSkill) {
                    case 0:
                        if (this.preatt != 1) {
                            this.getNavigation().moveTo(target, 1.2D);
                            this.preatt = 1;
                            this.setAttackingState(1);
                        } else {
                            this.preatt = 2;
                            this.getNavigation().stop();
                            this.setAttackingState(2);
                        }
                        break;
                    case 1:
                        if (this.preatt != 2) {
                            this.getNavigation().stop();
                            this.setAttackingState(2);
                            this.preatt = 2;
                        } else {
                            this.preatt = 1;
                            this.setAttackingState(1);
                        }
                        break;
                    case 2:
                        this.getNavigation().stop();
                        this.setAttackingState(3);
                        this.preatt = 3;
                        break;
                }
                atk = this.getAttckingState();
            }

            // ===== STATE 1 slash: anim ~1.17s, small forward lunge at ~0.58s =====
            if (atk == 1) {
                if (this.attackTimer >= 16 && this.attackTimer <= 18) {
                    this.dashToward(target, 0.55D, 0.0D);
                }
                if (this.attackTimer == 13 && target.isAlive() && this.distanceTo(target) < 2.75f) {
                    if (target instanceof Player && ((Player) target).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(target, 20);
                    } else {
                        this.heal(this.getMaxHealth() * 0.02f);
                        target.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float) this.random.nextInt(4));
                    }
                }
                if (this.attackTimer == 18 && target.isAlive() && this.distanceTo(target) < 2.75f) {
                    if (target instanceof Player && ((Player) target).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(target, 20);
                    } else {
                        target.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getArmorValue());
                        this.heal(this.getMaxHealth() * 0.02f);
                        target.knockback(0.25, this.getX() - target.getX(), this.getZ() - target.getZ());
                    }
                }
                if (this.attackTimer == 35) {
                    EntityBOWShoot arrow = new EntityBOWShoot(this.level(), this);
                    arrow.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 15.5F, 0.75F);
                    arrow.level().addParticle(ParticleTypes.FLAME, arrow.getX(), arrow.getY(), arrow.getZ(), 0, 0, 0);
                    arrow.playSound(SoundInit.M1851.get(), 1.5F, 1.5F);
                    arrow.damage *= 1.2;
                    this.level().addFreshEntity(arrow);
                }
            }

            // ===== STATE 2 leap-smash: crouch→jump Y@0.5s → slam+Z@0.67s =====
            if (atk == 2) {
                if (this.attackTimer == 15) {
                    this.leapUp(0.68D);
                }
                if (this.attackTimer >= 18 && this.attackTimer <= 22) {
                    this.dashToward(target, 1.35D, this.attackTimer == 18 ? -0.15D : 0.0D);
                }
                if (this.attackTimer == 19) {
                    for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0D), KRAUSER_AREA)) {
                        if (lvt instanceof Player && ((Player) lvt).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                            this.disableShield(lvt, 20);
                        } else {
                            lvt.hurt(this.damageSources().mobAttack(this), lvt.getMaxHealth() * 0.25F + lvt.getArmorValue());
                        }
                    }
                }
            }

            // ===== STATE 3 high leap + late dash: Y@0.5s, smash~1.0s, Z dash@1.58s =====
            if (atk == 3) {
                if (this.attackTimer == 15) {
                    this.leapUp(0.95D);
                }
                if (this.attackTimer == 28) {
                    this.getNavigation().stop();
                    for (int i = 0; i < 2; ++i) {
                        float f1 = f + (float) i * (float) Math.PI * 0.4F;
                        this.blockSmashAttack(i, f1, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(i, f1, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(i, f1, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(i, f1, -0.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                    for (int k = 0; k < 3; ++k) {
                        float f2 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
                        this.blockSmashAttack(k, f2, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(k, f2, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(k, f2, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.blockSmashAttack(k, f2, -0.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                }
                if (this.attackTimer >= 32 && this.attackTimer <= 38) {
                    this.dashToward(target, 1.85D, 0.0D);
                }
                if (this.attackTimer == 40 && target.isAlive() && this.distanceTo(target) < 3.5f) {
                    if (target instanceof Player && ((Player) target).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(target, 20);
                    } else {
                        target.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getArmorValue());
                        target.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200, 0, true, true));
                        target.knockback(0.35, this.getX() - target.getX(), this.getZ() - target.getZ());
                    }
                }
            }

            // End skill → recover (attack3 anim is 2s → ~tick 45)
            int endTick = (atk == 3) ? 48 : 42;
            if (this.attackTimer >= endTick && atk != 0) {
                this.beginRecover();
            }

            this.lookAt(target, 30.0F, 30.0F);
        }

        if (target == null || !this.hasLineOfSight(target)) {
            if (this.attackTimer > 0) {
                ++this.attackTimer;
            }
        }
        if (this.attackTimer >= 70 && this.getAttckingState() != 0) {
            this.beginRecover();
        }
    }

//    static class AttackGoal extends Goal {
//        private final EntityKrauser parentEntity;
//        protected int attackTimer = 0;
//
//        public AttackGoal(EntityKrauser mob) {
//            this.parentEntity = mob;
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
//
//
//                if (this.attackTimer == 5) {
//                    if (this.parentEntity.preatt!=1 && (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.86 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.9))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.82 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.85))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.76 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.79))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.42 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.45))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.51 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.54))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.2 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.23))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.1 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.14))) {
//                        this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
//                        this.parentEntity.getNavigation().stop();
//                        this.parentEntity.preatt = 1;
//                    } else if (this.parentEntity.preatt!=2 && (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.71 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.75))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.55 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.59))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.64 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.68))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.47 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.51))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.3 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.34))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.03 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.08))
//                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.25 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.3))) {
//                        this.parentEntity.getNavigation().stop();
//                        this.parentEntity.setAttackingState(2);
//                        this.parentEntity.preatt = 2;
//                    } else {
//                        this.parentEntity.getNavigation().stop();
//                        this.parentEntity.setAttackingState(3);
//                        this.parentEntity.preatt = 3;
//                    }
//                }
//
//                if(this.attackTimer==13 && this.parentEntity.getAttckingState()==1){
//                    if (livingentity != null && livingentity.isAlive() && this.parentEntity.distanceTo(livingentity) < 2.75f) {
//                        if (livingentity instanceof Player && ((Player)livingentity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
//                            this.parentEntity.disableShield((LivingEntity)livingentity, 20);
//                        }
//                        else{
//                            this.parentEntity.heal(this.parentEntity.getMaxHealth()*0.02f);
//                            livingentity.hurt(livingentity.damageSources().mobAttack((this.parentEntity)), (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float) this.parentEntity.random.nextInt(4));
//                        }
//                    }
//                }
//
//                if(this.attackTimer==18 && this.parentEntity.getAttckingState()==1){
//                    if (livingentity != null && livingentity.isAlive() && this.parentEntity.distanceTo(livingentity) < 2.75f) {
//
//                        if (livingentity instanceof Player && ((Player)livingentity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
//                            this.parentEntity.disableShield((LivingEntity)livingentity, 20);
//                        }
//                        else{
//                            livingentity.hurt(livingentity.damageSources().mobAttack((this.parentEntity)), (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
//                            this.parentEntity.heal(this.parentEntity.getMaxHealth()*0.02f);
//                            livingentity.knockback(0.25, this.parentEntity.getX() - livingentity.getX(), this.parentEntity.getZ() - livingentity.getZ());
//                        }
//                    }
//                }
//
//                if(this.attackTimer==15 && this.parentEntity.getAttckingState()==2){
//                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()+1.5,this.parentEntity.getZ(),2);
//                }
//
//                if(this.attackTimer==19 && this.parentEntity.getAttckingState()==2){
//                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()-1,this.parentEntity.getZ(),2);
//                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), KRAUSER_AREA)) {
//                        if (livingentity instanceof Player && ((Player)livingentity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
//                            this.parentEntity.disableShield((LivingEntity)livingentity, 20);
//                        }
//                        else{
//                            lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.25F+lvt.getArmorValue());
//                        }
//                    }
//                }
//
//                if(this.attackTimer==13 && this.parentEntity.getAttckingState()==3){
//                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()+1.5,this.parentEntity.getZ(),2);
//                    this.parentEntity.setDeltaMovement(0,1,0);
//                }
//
//                if(this.attackTimer==21 && this.parentEntity.getAttckingState()==3){
//                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()-1.2,this.parentEntity.getZ(),2);
//                }
//
//                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==3){
//                    this.parentEntity.getNavigation().stop();
//
//
//                    for(int i = 0; i < 2; ++i) {
//                        float f1 = f + (float)i * (float)Math.PI * 0.4F;
//                        this.parentEntity.blockSmashAttack(i, f1, 1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(i, f1, -1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(i, f1, 0.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(i, f1, -0.5F, 150, 1.5F, 0.15F, 1.0F);
//
//                    }
//
//                    for(int k = 0; k < 3; ++k) {
//                        float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
//                        this.parentEntity.blockSmashAttack(k, f2, 1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(k, f2, -1.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(k, f2, 0.5F, 150, 1.5F, 0.15F, 1.0F);
//                        this.parentEntity.blockSmashAttack(k, f2, -0.5F, 150, 1.5F, 0.15F, 1.0F);
//                    }
//                }
//
//                if(this.attackTimer==35 && this.parentEntity.getAttckingState()==3){
//                    this.parentEntity.getNavigation().moveTo(livingentity,2);
//                }
//
//                if(this.attackTimer==35 && this.parentEntity.getAttckingState()==1){
//                    EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
//                    abstractarrowentity.shootFromRotation(this.parentEntity, this.parentEntity.getXRot(), this.parentEntity.getYRot(), 0.0F, 15.5F, 0.75F);
//
//                    abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
//                    abstractarrowentity.playSound(SoundInit.M1851.get(), 1.5F, 1.5F);
//                    abstractarrowentity.damage*=1.2;
//
//                    this.parentEntity.level().addFreshEntity(abstractarrowentity);
//                }
//
//                if (this.attackTimer == 40) {
//                    if(this.parentEntity.distanceTo(livingentity)<5f && livingentity.isAlive() && this.parentEntity.getAttckingState()==3){
//                        this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+this.parentEntity.random.nextInt(7),this.parentEntity.getY(),this.parentEntity.getZ()+this.parentEntity.random.nextInt(7),2);
//                        if (livingentity != null && livingentity.isAlive() && this.parentEntity.distanceTo(livingentity) < 3f) {
//                            if (livingentity instanceof Player && ((Player)livingentity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
//                                this.parentEntity.disableShield((LivingEntity)livingentity, 20);
//                            }
//                            else{
//                                livingentity.hurt(livingentity.damageSources().mobAttack((this.parentEntity)), (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
//                                livingentity.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(),200,0,true,true));
//                                livingentity.knockback(0.25, this.parentEntity.getX() - livingentity.getX(), this.parentEntity.getZ() - livingentity.getZ());
//                            }
//                        }
//                    }
//                    this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,20,5));
//                    this.parentEntity.setAttackingState(0);
//                    this.attackTimer = -5;
//                }
//            }
//            else if (this.attackTimer > 0) {
//                --this.attackTimer;
//
//            }
//            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//            //System.out.println(this.parentEntity.attackAnim);
//        }
//
//    }

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
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
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
        livingEntity.getUseItem().hurtAndBreak(4+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }

}
