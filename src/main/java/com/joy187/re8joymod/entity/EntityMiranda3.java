package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Miranda (fly form) — no longer extends WitherBoss.
 *
 * Skills (encyclopedia):
 * 1 dive     — short-windup aerial-to-ground plunge, very high damage
 * 2 orbs     — charge 3 gray chaos orbs → tracking blaze fireballs
 * 3 barrage  — center ultimate: rapid endless flame volley
 */
public class EntityMiranda3 extends Monster implements GeoEntity {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private static final EntityDataAccessor<Integer> STATE =
            SynchedEntityData.defineId(EntityMiranda3.class, EntityDataSerializers.INT);

    public static final int STATE_IDLE = 0;
    public static final int STATE_DIVE = 1;
    public static final int STATE_ORBS = 2;
    public static final int STATE_BARRAGE = 3;

    private static final Predicate<LivingEntity> SURFACE_TARGET =
            e -> e.getMobType() != MobType.UNDEAD
                    && e.getMobType() != MobType.WATER
                    && e.attackable()
                    && isSurfaceTarget(e);

    private static final Predicate<LivingEntity> PLAYER_SURFACE =
            e -> e instanceof Player && isSurfaceTarget(e);

    private static boolean isSurfaceTarget(LivingEntity e) {
        if (e.isUnderWater()) {
            return false;
        }
        return !(e.isInWaterOrBubble() && !e.level().getFluidState(e.blockPosition().above(2)).isEmpty());
    }

    public EntityMiranda3(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 300;
        this.moveControl = new FlyingMoveControl(this, 16, true);
        this.setNoGravity(true);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FLYING_SPEED, 1.05D)
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .add(Attributes.ARMOR, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 14.0D);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation nav = new FlyingPathNavigation(this, level) {
            @Override
            public boolean isStableDestination(BlockPos pos) {
                return true;
            }
        };
        nav.setCanOpenDoors(false);
        nav.setCanFloat(true);
        nav.setCanPassDoors(true);
        return nav;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MirandaCombatGoal(this));
        this.goalSelector.addGoal(2, new HuntGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 8, false, false, PLAYER_SURFACE));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 8, false, false, SURFACE_TARGET));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, STATE_IDLE);
    }

    public int getCombatState() {
        return this.entityData.get(STATE);
    }

    public void setCombatState(int state) {
        this.entityData.set(STATE, state);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() || this.isControlledByLocalInstance()) {
            if (this.isInWater()) {
                this.moveRelative(0.02F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.8D).add(0.0, 0.08, 0.0));
            } else {
                if (!this.isNoGravity()) {
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.08D, 0.0));
                }
                this.moveRelative(0.05F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.91D));
            }
        }
        this.calculateEntityAnimation(false);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.fallDistance = 0.0F;
        this.setAirSupply(this.getMaxAirSupply());

        LivingEntity cur = this.getTarget();
        if (cur != null && !isSurfaceTarget(cur)) {
            this.setTarget(null);
            this.setCombatState(STATE_IDLE);
        }
        if (this.isInWaterOrBubble()) {
            this.setDeltaMovement(this.getDeltaMovement().x * 0.4D, 0.75D, this.getDeltaMovement().z * 0.4D);
            this.hasImpulse = true;
        }
        if (this.getCombatState() == STATE_IDLE && !this.isInWaterOrBubble()
                && this.getDeltaMovement().y < -0.08D) {
            this.setDeltaMovement(this.getDeltaMovement().x, -0.02D, this.getDeltaMovement().z);
        }
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.getHealth() >= 0.1F && this.getHealth() <= 10.0F) {
            this.convertTo(EntityInit.MIRANDA4.get(), true);
        }
    }

    private void flyToward(Vec3 dest, double speed) {
        Vec3 to = dest.subtract(this.position());
        if (to.lengthSqr() < 1.0E-4) {
            return;
        }
        Vec3 n = to.normalize().scale(speed);
        this.setDeltaMovement(this.getDeltaMovement().scale(0.3D).add(n));
        this.hasImpulse = true;
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    private void lookAtTarget(LivingEntity target) {
        this.getLookControl().setLookAt(target, 40.0F, 40.0F);
        double dx = target.getX() - this.getX();
        double dz = target.getZ() - this.getZ();
        this.setYRot((float) (Mth.atan2(dz, dx) * (180F / Math.PI)) - 90.0F);
        this.yBodyRot = this.getYRot();
    }

    /** Gray chaos orb gather VFX. */
    private void spawnOrbChargeParticles(int intensity) {
        if (!(this.level() instanceof ServerLevel server)) {
            return;
        }
        Vec3 c = this.position().add(0.0, this.getBbHeight() * 0.65, 0.0);
        for (int i = 0; i < intensity; i++) {
            double a = this.random.nextDouble() * Math.PI * 2.0;
            double r = 0.8 + this.random.nextDouble() * 1.6;
            server.sendParticles(ParticleTypes.ASH, c.x + Math.cos(a) * r, c.y + this.random.nextDouble(),
                    c.z + Math.sin(a) * r, 1, 0, 0.02, 0, 0);
            server.sendParticles(ParticleTypes.SMOKE, c.x + Math.cos(a) * r * 0.7, c.y,
                    c.z + Math.sin(a) * r * 0.7, 1, 0.05, 0.05, 0.05, 0.01);
        }
    }

    /** Chaos fireball — 20% of target max HP on hit. */
    private void shootChaosFireball(LivingEntity target, double sideOffset) {
        Vec3 from = this.position().add(0.0, this.getBbHeight() * 0.7, 0.0);
        Vec3 right = this.getLookAngle().yRot((float) Math.PI / 2F).normalize().scale(sideOffset);
        from = from.add(right);
        Vec3 aim = target.position().add(0.0, target.getBbHeight() * 0.45, 0.0).subtract(from);
        if (aim.lengthSqr() < 1.0E-4) {
            aim = this.getLookAngle();
        }
        aim = aim.normalize();
        Vec3 lead = aim.add(target.getDeltaMovement().scale(0.35));
        if (lead.lengthSqr() > 1.0E-4) {
            aim = lead.normalize();
        }
        EntityChaosFireball ball = new EntityChaosFireball(this.level(), this, aim.x, aim.y, aim.z);
        ball.setPos(from.x, from.y, from.z);
        this.level().addFreshEntity(ball);
        this.playSound(SoundEvents.GHAST_SHOOT, 1.4F, 0.7F + this.random.nextFloat() * 0.3F);
        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.FLAME, from.x, from.y, from.z, 12, 0.2, 0.2, 0.2, 0.04);
            server.sendParticles(ParticleTypes.LAVA, from.x, from.y, from.z, 4, 0.15, 0.15, 0.15, 0);
        }
    }

    private void shootBarrageBolt(LivingEntity target, float spreadDeg) {
        Vec3 from = this.position().add(0.0, this.getBbHeight() * 0.55, 0.0);
        Vec3 aim = target.position().add(0.0, target.getBbHeight() * 0.4, 0.0).subtract(from);
        if (aim.lengthSqr() < 1.0E-4) {
            aim = this.getLookAngle();
        }
        aim = aim.normalize();
        float yawOff = (this.random.nextFloat() - 0.5F) * spreadDeg * ((float) Math.PI / 180F);
        float pitchOff = (this.random.nextFloat() - 0.5F) * spreadDeg * 0.5F * ((float) Math.PI / 180F);
        aim = aim.yRot(yawOff).xRot(pitchOff);
        EntityChaosFireball ball = new EntityChaosFireball(this.level(), this, aim.x, aim.y, aim.z);
        ball.setPos(from.x, from.y, from.z);
        this.level().addFreshEntity(ball);
    }

    /**
     * Dive impact — encyclopedia: no defense → near red-blood (heavy % max HP).
     */
    private void diveImpact(LivingEntity target) {
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5F, 0.75F);
        this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 1.2F, 1.1F);
        AABB box = this.getBoundingBox().inflate(3.5D, 2.0D, 3.5D);
        for (LivingEntity e : this.level().getEntitiesOfClass(LivingEntity.class, box, SURFACE_TARGET)) {
            if (e == this) {
                continue;
            }
            float dmg = 18.0F + e.getMaxHealth() * 0.22F; // red-blood threat without shield
            e.hurt(this.damageSources().mobAttack(this), dmg);
            e.setDeltaMovement(e.getDeltaMovement().add(0.0, 0.7, 0.0));
            e.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 40, 1, false, true));
            e.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 0, false, true));
        }
        if (target != null && target.isAlive()) {
            float focus = 24.0F + target.getMaxHealth() * 0.18F;
            target.hurt(this.damageSources().mobAttack(this), focus);
            target.knockback(1.6F, this.getX() - target.getX(), this.getZ() - target.getZ());
        }
        EntityCameraShake.ScreenShake(this.level(), this.position(), 28.0F, 0.16F, 0, 40);
        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 2, 0.8, 0.2, 0.8, 0);
            server.sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 30, 1.5, 0.3, 1.5, 0.05);
            server.sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), 25, 2.0, 0.3, 2.0, 0.04);
        }
    }

    private <E extends GeoAnimatable> PlayState predicateMove(AnimationState<E> event) {
        if (this.getCombatState() != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (event.isMoving() || this.getDeltaMovement().horizontalDistanceSqr() > 0.01) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.miranda3.fly"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.miranda3.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        return switch (this.getCombatState()) {
            case STATE_DIVE -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda3.dive"));
                yield PlayState.CONTINUE;
            }
            case STATE_ORBS -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda3.cast_orbs"));
                yield PlayState.CONTINUE;
            }
            case STATE_BARRAGE -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda3.barrage"));
                yield PlayState.CONTINUE;
            }
            default -> PlayState.STOP;
        };
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 0, this::predicateMove));
        data.add(new AnimationController<>(this, "combat", 0, this::predicateCombat));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.random.nextBoolean() ? SoundInit.ENTITY_MIRA_DEATH1.get() : SoundInit.ENTITY_MIRA_DEATH2.get();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        int co = this.random.nextInt(3);
        if (co == 0) {
            return SoundInit.ENTITY_MIRA_AMBIENT1.get();
        } else if (co == 1) {
            return SoundInit.ENTITY_MIRA_AMBIENT3.get();
        }
        return SoundInit.ENTITY_MIRA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return this.random.nextBoolean() ? SoundInit.ENTITY_MIRA_HURT1.get() : SoundInit.ENTITY_MIRA_HURT2.get();
    }

    /** Descend / press surface targets — keep altitude low like Dimi2. */
    static class HuntGoal extends Goal {
        private final EntityMiranda3 mob;
        private int retarget;

        HuntGoal(EntityMiranda3 mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.mob.getCombatState() == STATE_IDLE;
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse();
        }

        @Override
        public void tick() {
            if (++this.retarget >= 20) {
                this.retarget = 0;
                this.ensureTarget();
            }
            LivingEntity target = this.mob.getTarget();
            if (target == null || !target.isAlive()) {
                this.ensureTarget();
                target = this.mob.getTarget();
                if (target == null) {
                    return;
                }
            }
            this.mob.getLookControl().setLookAt(target, 40.0F, 40.0F);
            double dy = this.mob.getY() - target.getY();
            double dist = this.mob.distanceTo(target);
            double engageY = target.getY() + Math.min(2.4D, Math.max(1.2D, target.getBbHeight()));
            if (dy > 5.0D) {
                this.mob.flyToward(new Vec3(target.getX(), engageY, target.getZ()), 1.1D);
            } else if (dist > 4.0D) {
                this.mob.flyToward(new Vec3(target.getX(), engageY, target.getZ()), 0.9D);
                this.mob.getNavigation().moveTo(target.getX(), engageY, target.getZ(), 1.55D);
            } else {
                double ang = this.mob.tickCount * 0.15D;
                Vec3 side = new Vec3(Math.cos(ang) * 2.2, 0.0, Math.sin(ang) * 2.2);
                this.mob.flyToward(target.position().add(side.x, engageY - target.getY(), side.z), 0.5D);
            }
        }

        private void ensureTarget() {
            if (this.mob.getTarget() != null && this.mob.getTarget().isAlive() && isSurfaceTarget(this.mob.getTarget())) {
                return;
            }
            Player p = this.mob.level().getNearestPlayer(this.mob, 48.0D);
            if (p != null && !p.isCreative() && !p.isSpectator() && isSurfaceTarget(p)) {
                this.mob.setTarget(p);
            }
        }
    }

    static class MirandaCombatGoal extends Goal {
        private final EntityMiranda3 mira;
        private int timer;
        private int chosen;
        private int cooldown;
        private int idlePressure;
        private Vec3 diveAim = Vec3.ZERO;
        private double soarY;

        MirandaCombatGoal(EntityMiranda3 mira) {
            this.mira = mira;
            // LOOK only — leave MOVE free so HuntGoal can keep pressing.
            this.setFlags(EnumSet.of(Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.mira.getTarget() != null && this.mira.getTarget().isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() || this.mira.getCombatState() != STATE_IDLE;
        }

        @Override
        public void start() {
            this.timer = 0;
            this.chosen = STATE_IDLE;
            this.cooldown = 8;
            this.idlePressure = 0;
            this.mira.setAggressive(true);
        }

        @Override
        public void stop() {
            this.mira.setAggressive(false);
            this.mira.setCombatState(STATE_IDLE);
            this.mira.setNoGravity(true);
            this.chosen = STATE_IDLE;
            this.timer = 0;
            this.idlePressure = 0;
        }

        @Override
        public void tick() {
            LivingEntity target = this.mira.getTarget();
            if (target == null) {
                this.mira.setCombatState(STATE_IDLE);
                return;
            }

            if (this.chosen != STATE_IDLE) {
                ++this.timer;
                this.mira.lookAtTarget(target);
                this.run(target);
                return;
            }

            this.mira.lookAtTarget(target);
            double dist = this.mira.distanceTo(target);
            double dy = this.mira.getY() - target.getY();
            // Always close distance even during cooldown — don't park in the sky.
            if (dist > 6.0D || dy > 3.5D) {
                double engageY = target.getY() + 1.8D;
                this.mira.flyToward(new Vec3(target.getX(), engageY, target.getZ()),
                        dy > 6.0D ? 1.15D : 0.8D);
            }

            if (this.cooldown > 0) {
                --this.cooldown;
                ++this.idlePressure;
                if (this.idlePressure >= 30 && dy > 2.5D) {
                    this.idlePressure = 0;
                    this.begin(STATE_DIVE);
                }
                return;
            }

            this.idlePressure = 0;

            // Far away: still attack instead of waiting.
            if (dist > 32.0D) {
                this.begin(dy > 4.0D ? STATE_DIVE : STATE_ORBS);
                return;
            }

            float hp = this.mira.getHealth() / this.mira.getMaxHealth();
            int roll = this.mira.getRandom().nextInt(100);
            if (hp < 0.45F && roll < 32) {
                this.begin(STATE_BARRAGE);
            } else if (dy > 3.0D && roll < 55) {
                this.begin(STATE_DIVE);
            } else if (roll < 42) {
                this.begin(STATE_DIVE);
            } else if (roll < 74) {
                this.begin(STATE_ORBS);
            } else if (hp < 0.7F) {
                this.begin(STATE_BARRAGE);
            } else {
                this.begin(STATE_ORBS);
            }
        }

        private void begin(int state) {
            this.chosen = state;
            this.timer = 0;
            this.mira.setCombatState(state);
            this.mira.getNavigation().stop();
            LivingEntity t = this.mira.getTarget();
            if (t != null) {
                this.diveAim = t.position();
                // Short windup lift — avoid climbing too high before dive.
                this.soarY = Math.max(this.mira.getY(), t.getY()) + 3.5D;
            } else {
                this.soarY = this.mira.getY() + 3.5D;
            }
            this.mira.playSound(SoundEvents.ENDER_DRAGON_FLAP, 1.4F, 1.1F);
        }

        private void finish() {
            this.chosen = STATE_IDLE;
            this.timer = 0;
            this.mira.setCombatState(STATE_IDLE);
            this.mira.setNoGravity(true);
            this.cooldown = 8 + this.mira.getRandom().nextInt(8);
            this.idlePressure = 0;
        }

        private void run(LivingEntity target) {
            switch (this.chosen) {
                case STATE_DIVE -> this.tickDive(target);
                case STATE_ORBS -> this.tickOrbs(target);
                case STATE_BARRAGE -> this.tickBarrage(target);
                default -> this.finish();
            }
        }

        /**
         * 1) Straight aerial-to-ground dive — short windup, extreme damage.
         * Anim ~1.2s → 24 ticks.
         */
        private void tickDive(LivingEntity target) {
            if (this.timer <= 6) {
                // Tiny windup: lift slightly then commit.
                this.mira.flyToward(new Vec3(target.getX(), this.soarY, target.getZ()), 0.55D);
            } else if (this.timer <= 22) {
                this.diveAim = target.position();
                this.mira.setNoGravity(false);
                this.mira.flyToward(this.diveAim.add(0.0, 0.2, 0.0), 1.35D);
                if (this.mira.distanceTo(target) < 3.2D || this.mira.onGround()) {
                    this.mira.diveImpact(target);
                    this.finish();
                }
            } else {
                this.mira.diveImpact(target);
                this.finish();
            }
        }

        /**
         * 2) Three chaos orbs — gray gather then tracking blaze fireballs.
         * Anim ~2.0s → 40 ticks. Charge 0-18, fire at 20/28/36.
         */
        private void tickOrbs(LivingEntity target) {
            this.mira.setDeltaMovement(this.mira.getDeltaMovement().multiply(0.55, 0.55, 0.55).add(0.0, 0.02, 0.0));
            if (this.timer <= 18) {
                this.mira.spawnOrbChargeParticles(6);
                if (this.timer % 5 == 0) {
                    this.mira.playSound(SoundEvents.BLAZE_AMBIENT, 0.7F, 0.5F);
                }
            }
            if (this.timer == 20) {
                this.mira.shootChaosFireball(target, -1.4D);
            }
            if (this.timer == 28) {
                this.mira.shootChaosFireball(target, 0.0D);
            }
            if (this.timer == 36) {
                this.mira.shootChaosFireball(target, 1.4D);
            }
            if (this.timer >= 42) {
                this.finish();
            }
        }

        /**
         * 3) Aerial chaos barrage — full-screen style rapid flame rain.
         * Anim ~3.0s → 60 ticks. Charge 0-16, spray 17-55.
         */
        private void tickBarrage(LivingEntity target) {
            // Hold above target, but not so high that chase pressure is lost.
            Vec3 center = new Vec3(target.getX(), target.getY() + 3.8D, target.getZ());
            this.mira.flyToward(center, 0.55D);

            if (this.timer <= 16) {
                this.mira.spawnOrbChargeParticles(10);
                if (this.timer % 4 == 0) {
                    this.mira.playSound(SoundEvents.BLAZE_BURN, 1.0F, 0.6F);
                }
            } else if (this.timer <= 55) {
                // Endless flame spray — several bolts per tick window.
                if (this.timer % 2 == 0) {
                    this.mira.shootBarrageBolt(target, 28.0F);
                    this.mira.shootBarrageBolt(target, 40.0F);
                }
                if (this.timer % 5 == 0) {
                    this.mira.playSound(SoundEvents.GHAST_SHOOT, 0.9F, 1.2F);
                }
                if (this.mira.level() instanceof ServerLevel server) {
                    Vec3 c = this.mira.position().add(0, 2, 0);
                    server.sendParticles(ParticleTypes.FLAME, c.x, c.y, c.z, 8, 1.2, 0.6, 1.2, 0.08);
                    server.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, c.x, c.y, c.z, 4, 0.8, 0.4, 0.8, 0.05);
                }
            }
            if (this.timer >= 60) {
                this.finish();
            }
        }
    }
}
