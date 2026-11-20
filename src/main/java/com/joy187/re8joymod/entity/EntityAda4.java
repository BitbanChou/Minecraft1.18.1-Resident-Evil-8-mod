package com.joy187.re8joymod.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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
 * Ada4 combat states:
 * 0 idle / walk
 * 1 attack — left/right punches (animation.ada4.attack)
 * 2 attack2 — double kick + backflip to behind the target (animation.ada4.attack2)
 * 3 shoot — back off then fire; 20% spider-web shot (animation.ada4.shoot)
 * 4 gun_vault — signature gun hook to high ground (animation.ada4.gun_vault)
 *
 * Hitstun: taking a heavy hit (or a 35% chance on any hit) interrupts the
 * current skill and briefly slows her. During a skill she cannot re-target
 * her look direction until the skill ends (except right before firing).
 *
 * Against other mod monsters (not players, not fellow protagonists) she
 * dodges, caps a single hit, keeps shoot range, and regenerates out of combat.
 */
public class EntityAda4 extends EntityChris {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public static final int STATE_IDLE = 0;
    public static final int STATE_ATTACK = 1;
    public static final int STATE_ATTACK2 = 2;
    public static final int STATE_SHOOT = 3;
    public static final int STATE_GUN_VAULT = 4;

    private static final double MELEE_RANGE = 2.8D;
    private static final double SHOOT_MIN = 5.0D;
    private static final double SHOOT_MAX = 16.0D;

    private int vaultCooldown;
    private int meleeIndex;
    /** Ticks until the next dodge against a mod monster. */
    private int dodgeCooldown;
    /** Server tick of the last hit that actually connected. */
    private int lastHurtTick = -10000;

    private static final float MOD_HIT_CAP = 8.0F;
    private static final int DODGE_COOLDOWN_TICKS = 15;
    /** 18 so vanilla's >10 iframe check lasts about 0.4s. */
    private static final int DODGE_INVULN_TICKS = 18;
    private static final int OUT_OF_COMBAT_TICKS = 60;

    /** Temporary cobwebs (shoot / gun_vault) — auto-clear so nothing stays forever. */
    private final List<TempWeb> tempWebs = new ArrayList<>();

    private static final Predicate<Entity> ADA_AREA = Entity::isAlive;

    private static final class TempWeb {
        final BlockPos pos;
        int ticksLeft;

        TempWeb(BlockPos pos, int ticksLeft) {
            this.pos = pos.immutable();
            this.ticksLeft = ticksLeft;
        }
    }

    public EntityAda4(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 18.0D)
                .add(Attributes.ARMOR, 4D)
                .add(Attributes.ARMOR_TOUGHNESS, 6.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new Ada4CombatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.fallDistance = 0.0F;
        if (this.vaultCooldown > 0) {
            --this.vaultCooldown;
        }
        if (this.dodgeCooldown > 0) {
            --this.dodgeCooldown;
        }
        this.tickTempWebs();
        // Only (re)apply effects when missing / about to expire to avoid
        // spamming effect packets every tick.
        boolean midHealth = this.getHealth() >= 10.0F && this.getHealth() <= 20.0F;
        if (midHealth) {
            if (!this.hasEffect(MobEffects.REGENERATION)
                    || this.getEffect(MobEffects.REGENERATION).getDuration() <= 5) {
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1, false, true));
            }
        } else if (this.getHealth() < 8.0F) {
            // Give invisibility a real cooldown instead of permanent refresh.
            if (!this.hasEffect(MobEffects.INVISIBILITY)
                    || this.getEffect(MobEffects.INVISIBILITY).getDuration() <= 5) {
                this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, true));
                this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0, false, false));
            }
        }
        // Out of combat, top up anything under 30. The 10–20 band already has regen II.
        if (this.getHealth() < 30.0F
                && !midHealth
                && this.tickCount - this.lastHurtTick >= OUT_OF_COMBAT_TICKS) {
            if (!this.hasEffect(MobEffects.REGENERATION)
                    || this.getEffect(MobEffects.REGENERATION).getDuration() <= 5) {
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 0, false, true));
            }
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    // ------------------------------------------------------------------
    // Hitstun
    // ------------------------------------------------------------------

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!this.level().isClientSide && amount > 0.0F && this.invulnerableTime <= 10
                && this.isModMonsterThreat(source)) {
            if (this.dodgeCooldown <= 0 && this.getRandom().nextFloat() < 0.45F) {
                this.performDodge(source);
                return false;
            }
            amount = Math.min(amount, MOD_HIT_CAP);
        }
        boolean result = super.hurt(source, amount);
        if (result && !this.level().isClientSide) {
            this.lastHurtTick = this.tickCount;
            // Heavy hit always interrupts; light hits have a 35% chance.
            if (amount >= 4.0F || this.getRandom().nextFloat() < 0.35F) {
                this.interruptCurrentSkill();
            }
        }
        return result;
    }

    /**
     * Mod monster, or a projectile owned by one. Players and protagonists
     * (Ethan and subclasses) keep their normal damage.
     */
    private boolean isModMonsterThreat(DamageSource source) {
        return this.isModMonster(this.resolveAttacker(source));
    }

    private Entity resolveAttacker(DamageSource source) {
        Entity direct = source.getDirectEntity();
        if (direct instanceof Projectile projectile && projectile.getOwner() != null) {
            return projectile.getOwner();
        }
        Entity cause = source.getEntity();
        if (cause instanceof Projectile projectile && projectile.getOwner() != null) {
            return projectile.getOwner();
        }
        return cause != null ? cause : direct;
    }

    private boolean isModMonster(Entity entity) {
        if (entity == null || entity == this || entity instanceof Player || entity instanceof EntityEthan) {
            return false;
        }
        return entity.getClass().getName().startsWith("com.joy187.re8joymod.");
    }

    private int countNearbyModHostiles(double range) {
        int count = 0;
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, box, ADA_AREA)) {
            if (this.distanceTo(entity) <= range && this.isModMonster(entity)) {
                ++count;
            }
        }
        return count;
    }

    /** Side-step a mod-monster hit and take a short real invulnerability window. */
    private void performDodge(DamageSource source) {
        this.dodgeCooldown = DODGE_COOLDOWN_TICKS;
        this.invulnerableTime = DODGE_INVULN_TICKS;
        this.interruptCurrentSkill(false);

        Entity attacker = source.getEntity();
        Vec3 away = attacker != null
                ? this.position().subtract(attacker.position())
                : this.getLookAngle().scale(-1.0);
        Vec3 flat = new Vec3(away.x, 0.0, away.z);
        if (flat.lengthSqr() < 1.0E-4) {
            flat = new Vec3(-this.getLookAngle().z, 0.0, this.getLookAngle().x);
        }
        flat = flat.normalize();
        Vec3 side = this.getRandom().nextBoolean()
                ? new Vec3(-flat.z, 0.0, flat.x)
                : new Vec3(flat.z, 0.0, -flat.x);
        this.leapAlong(side, 0.7D, 0.32D);

        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.POOF, this.getX(), this.getY() + 0.9D, this.getZ(),
                    6, 0.25D, 0.35D, 0.25D, 0.01D);
        }
        this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 0.55F, 1.7F);
    }

    private void interruptCurrentSkill() {
        this.interruptCurrentSkill(true);
    }

    private void interruptCurrentSkill(boolean stagger) {
        this.goalSelector.getRunningGoals()
                .filter(g -> g.getGoal() instanceof Ada4CombatGoal)
                .forEach(g -> ((Ada4CombatGoal) g.getGoal()).forceInterrupt(stagger));
    }

    // ------------------------------------------------------------------
    // Temp webs
    // ------------------------------------------------------------------

    private void tickTempWebs() {
        if (this.level().isClientSide || this.tempWebs.isEmpty()) {
            return;
        }
        Iterator<TempWeb> it = this.tempWebs.iterator();
        while (it.hasNext()) {
            TempWeb web = it.next();
            --web.ticksLeft;
            if (web.ticksLeft <= 0) {
                this.clearWebAt(web.pos);
                it.remove();
            }
        }
    }

    private void clearWebAt(BlockPos pos) {
        if (this.level().getBlockState(pos).is(Blocks.COBWEB)) {
            this.level().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        }
    }

    /** Clear all leftover webs (called on death / removal so the world is not polluted). */
    private void clearAllTempWebs() {
        if (this.level().isClientSide) {
            return;
        }
        for (TempWeb web : this.tempWebs) {
            this.clearWebAt(web.pos);
        }
        this.tempWebs.clear();
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        this.clearAllTempWebs();
        super.remove(reason);
    }

    /** Place a timed cobweb; always registered for auto-removal. */
    private void placeTempWeb(BlockPos candidate, int lifeTicks) {
        BlockPos place = null;
        if (this.level().getBlockState(candidate).isAir()) {
            place = candidate.immutable();
        } else if (this.level().getBlockState(candidate.above()).isAir()) {
            place = candidate.above().immutable();
        }
        if (place == null) {
            return;
        }
        this.level().setBlock(place, Blocks.COBWEB.defaultBlockState(), 3);
        this.tempWebs.add(new TempWeb(place, lifeTicks));
    }

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------

    private boolean isInFrontCone(LivingEntity entity, float halfAngleDeg) {
        Vec3 look = this.getLookAngle();
        Vec3 lookFlat = new Vec3(look.x, 0.0, look.z);
        if (lookFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        lookFlat = lookFlat.normalize();
        Vec3 to = entity.position().add(0.0, entity.getBbHeight() * 0.5, 0.0)
                .subtract(this.position().add(0.0, this.getBbHeight() * 0.5, 0.0));
        Vec3 toFlat = new Vec3(to.x, 0.0, to.z);
        if (toFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        toFlat = toFlat.normalize();
        return lookFlat.dot(toFlat) >= Math.cos(Math.toRadians(halfAngleDeg));
    }

    private void dealMeleeHit(LivingEntity target, float damage, float range) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, box)) {
            if (entity == this || this.isAlliedTo(entity)) {
                continue;
            }
            if (this.distanceTo(entity) > range + 0.5F) {
                continue;
            }
            if (!this.isInFrontCone(entity, 70.0F)) {
                continue;
            }
            entity.hurt(this.damageSources().mobAttack(this), damage);
            if (entity == target || entity instanceof Player) {
                Vec3 push = this.getLookAngle();
                entity.knockback(0.4F, -push.x, -push.z);
            }
        }
    }

    private Vec3 awayFrom(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position());
        if (away.lengthSqr() < 0.01) {
            away = this.getLookAngle().scale(-1.0);
        }
        return new Vec3(away.x, 0.0, away.z).normalize();
    }

    private void leapAlong(Vec3 dir, double horizontal, double upward) {
        Vec3 n = new Vec3(dir.x, 0.0, dir.z);
        if (n.lengthSqr() < 1.0E-6) {
            return;
        }
        n = n.normalize();
        this.setDeltaMovement(n.x * horizontal, upward, n.z * horizontal);
        this.hasImpulse = true;
        this.hurtMarked = true;
        this.resetFallDistance();
    }

    private void moveAlong(Vec3 dir, double speed) {
        Vec3 n = new Vec3(dir.x, 0.0, dir.z);
        if (n.lengthSqr() < 1.0E-6) {
            return;
        }
        n = n.normalize().scale(speed);
        this.move(MoverType.SELF, n);
        this.setDeltaMovement(n.x, this.getDeltaMovement().y, n.z);
        this.hasImpulse = true;
    }

    /** Feet pos is standable: solid floor + two air cells for body. */
    private boolean isStandableFeet(BlockPos feet) {
        BlockPos ground = feet.below();
        if (!this.level().getBlockState(ground).isFaceSturdy(this.level(), ground, Direction.UP)) {
            return false;
        }
        if (!this.level().getBlockState(feet).getCollisionShape(this.level(), feet).isEmpty()) {
            return false;
        }
        if (!this.level().getBlockState(feet.above()).getCollisionShape(this.level(), feet.above()).isEmpty()) {
            return false;
        }
        // Keep collision box clear so we don't clip into walls in tight rooms.
        AABB probe = this.getBoundingBox().move(
                feet.getX() + 0.5D - this.getX(),
                feet.getY() - this.getY(),
                feet.getZ() + 0.5D - this.getZ());
        return this.level().noCollision(this, probe);
    }

    /**
     * Shoot step-back: only scan adjacent 3×3×3 (radius 1), same-ish floor.
     * Never teleport farther than ~1.25 blocks — closed rooms stay fightable.
     */
    private BlockPos findLocalRetreat(LivingEntity target) {
        BlockPos origin = this.blockPosition();
        Vec3 away = this.awayFrom(target);
        double curDist = this.distanceTo(target);

        BlockPos best = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) {
                        continue;
                    }
                    BlockPos feet = origin.offset(dx, dy, dz);
                    if (!this.isStandableFeet(feet)) {
                        continue;
                    }
                    Vec3 center = Vec3.atBottomCenterOf(feet);
                    if (center.distanceTo(this.position()) > 1.35D) {
                        continue;
                    }
                    double toTarget = center.distanceTo(target.position());
                    if (toTarget + 0.2D < curDist) {
                        continue;
                    }
                    Vec3 stepFlat = new Vec3(center.x - this.getX(), 0.0, center.z - this.getZ());
                    double awayAlign = stepFlat.lengthSqr() > 1.0E-4 ? stepFlat.normalize().dot(away) : 0.0;
                    double score = awayAlign * 2.0 + (toTarget - curDist) - Math.abs(dy) * 0.5;
                    if (score > bestScore) {
                        bestScore = score;
                        best = feet;
                    }
                }
            }
        }
        return best;
    }

    /** Tiny local step for shoot — no long teleport, no Heightmap roof pops. */
    private void retreatNearby(LivingEntity target) {
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
        BlockPos spot = this.findLocalRetreat(target);
        if (spot != null) {
            double dx = spot.getX() + 0.5D - this.getX();
            double dy = spot.getY() - this.getY();
            double dz = spot.getZ() + 0.5D - this.getZ();
            this.move(MoverType.SELF, new Vec3(dx, dy, dz));
            this.setDeltaMovement(Vec3.ZERO);
            this.hasImpulse = true;
            this.resetFallDistance();
            return;
        }
        this.moveAlong(this.awayFrom(target), 0.2D);
        this.setDeltaMovement(Vec3.ZERO);
    }

    private void fireBullet() {
        EntityBOWShoot bullet = new EntityBOWShoot(this.level(), this);
        bullet.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 2.6F, 0.7F);
        bullet.damage = 6.0D;
        this.level().addFreshEntity(bullet);
        this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getEyeY(), this.getZ(), 0.0, 0.0, 0.0);
        this.playSound(SoundInit.M1851.get(), 1.2F, 1.3F);
    }

    /** 20% spider-web shot: slow target and plant a short-lived cobweb. */
    private void fireWebShot(LivingEntity target) {
        EntityBOWShoot bullet = new EntityBOWShoot(this.level(), this);
        bullet.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 1.8F, 1.2F);
        bullet.damage = 2.5D;
        this.level().addFreshEntity(bullet);

        this.placeTempWeb(target.blockPosition(), 40);
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 2, false, true));
        target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 1, false, true));
        this.playSound(SoundEvents.SPIDER_AMBIENT, 1.0F, 1.4F);
        this.playSound(SoundInit.M1851.get(), 0.8F, 0.7F);
    }

    private void fireOrWeb(LivingEntity target) {
        if (this.getRandom().nextFloat() < 0.20F) {
            this.fireWebShot(target);
        } else {
            this.fireBullet();
        }
    }

    /** Signature move: fire gun-hook, then a short hop. The real landing is teleportToHighGround. */
    private void performGunVault(LivingEntity target) {
        Vec3 away = this.awayFrom(target).add(0.0, 0.85, 0.0).normalize();
        GrapplehookEntity hook = new GrapplehookEntity(this.level(), this);
        hook.shoot(away.x, away.y, away.z, 1.2F, 0.4F);
        hook.damage = 1.5D;
        this.level().addFreshEntity(hook);
        this.playSound(SoundInit.M1851.get(), 1.0F, 0.85F);
        this.leapAlong(away, 0.35D, 0.42D);
    }

    private boolean hasCeilingAbove(BlockPos feet, int maxUp) {
        for (int i = 1; i <= maxUp; i++) {
            BlockPos up = feet.above(i);
            if (this.level().getBlockState(up).isFaceSturdy(this.level(), up, Direction.DOWN)) {
                return true;
            }
        }
        return false;
    }

    /** Place a short-lived cobweb to sell the grappling-hook catch (~1.5s). */
    private void placeGrappleWeb(BlockPos feet) {
        this.placeTempWeb(feet, 30);
        this.playSound(SoundEvents.SPIDER_STEP, 0.9F, 1.35F);
    }

    /**
     * Standable block around the target, inside gun range.
     * Scored toward {@code preferredDist} and about two blocks up — not the
     * highest roof in a wide ring, which was launching her out of the fight.
     */
    private BlockPos findVaultLanding(LivingEntity target, double preferredDist) {
        double minDist = SHOOT_MIN;
        double maxDist = preferredDist + 1.5D;
        BlockPos origin = target.blockPosition();
        int horizontal = (int) Math.ceil(maxDist);
        BlockPos best = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (int dx = -horizontal; dx <= horizontal; dx++) {
            for (int dy = -1; dy <= 4; dy++) {
                for (int dz = -horizontal; dz <= horizontal; dz++) {
                    BlockPos feet = origin.offset(dx, dy, dz);
                    if (!this.isStandableFeet(feet)) {
                        continue;
                    }
                    Vec3 center = Vec3.atBottomCenterOf(feet);
                    double flat = Math.sqrt(
                            (center.x - target.getX()) * (center.x - target.getX())
                                    + (center.z - target.getZ()) * (center.z - target.getZ()));
                    if (flat < minDist || flat > maxDist) {
                        continue;
                    }
                    double score = -Math.abs(flat - preferredDist) * 3.0D
                            - Math.abs(dy - 2) * 0.7D
                            + this.getRandom().nextDouble() * 0.35D;
                    if (score > bestScore) {
                        bestScore = score;
                        best = feet;
                    }
                }
            }
        }
        return best;
    }

    private void teleportToHighGround(LivingEntity target, double preferredDist) {
        BlockPos best = this.findVaultLanding(target, preferredDist);
        if (best == null) {
            return;
        }

        this.getNavigation().stop();
        this.teleportTo(best.getX() + 0.5, best.getY() + 0.05, best.getZ() + 0.5);
        this.setDeltaMovement(0.0, 0.05, 0.0);
        this.hasImpulse = true;
        this.resetFallDistance();
        this.playSound(SoundEvents.ENDERMAN_TELEPORT, 0.7F, 1.4F);

        BlockPos landed = this.blockPosition();
        if (this.hasCeilingAbove(landed, 3)) {
            this.placeGrappleWeb(landed);
            this.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 35, 0, false, false));
        }
    }

    // ------------------------------------------------------------------
    // Attack2: backflip behind the target
    // ------------------------------------------------------------------

    /**
     * Find a standable spot behind the target (relative to the target's own facing).
     * Returns null if no valid spot exists (e.g. target backed against a wall).
     */
    private BlockPos findBehindTargetSpot(LivingEntity target, double behindDist, int radius) {
        Vec3 targetLook = target.getLookAngle();
        Vec3 targetLookFlat = new Vec3(targetLook.x, 0.0, targetLook.z);
        if (targetLookFlat.lengthSqr() < 1.0E-6) {
            targetLookFlat = new Vec3(0, 0, 1);
        }
        targetLookFlat = targetLookFlat.normalize();

        Vec3 behindCenter = target.position().subtract(targetLookFlat.scale(behindDist));
        BlockPos origin = BlockPos.containing(behindCenter);

        BlockPos best = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -2; dy <= 3; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos feet = origin.offset(dx, dy, dz);
                    if (!this.isStandableFeet(feet)) {
                        continue;
                    }
                    Vec3 center = Vec3.atBottomCenterOf(feet);
                    Vec3 toSpot = center.subtract(target.position());
                    Vec3 toSpotFlat = new Vec3(toSpot.x, 0.0, toSpot.z);
                    if (toSpotFlat.lengthSqr() < 1.0E-4) {
                        continue;
                    }
                    toSpotFlat = toSpotFlat.normalize();
                    // 1.0 = directly behind the target.
                    double behindAlign = toSpotFlat.dot(targetLookFlat);
                    if (behindAlign < 0.35D) {
                        continue;
                    }
                    double distToTarget = center.distanceTo(target.position());
                    if (distToTarget < behindDist * 0.6D) {
                        continue;
                    }
                    double score = behindAlign * 3.0
                            - Math.abs(distToTarget - behindDist)
                            - Math.abs(dy) * 0.4;
                    if (score > bestScore) {
                        bestScore = score;
                        best = feet;
                    }
                }
            }
        }
        return best;
    }

    /**
     * Parabolic leap to the given feet position. Computes a launch velocity
     * that lands at dest, instead of overriding horizontal speed each tick
     * (which was swallowing the vertical hop and clipping on walls).
     */
    private boolean leapTo(BlockPos dest, double maxHorizontalSpeed) {
        if (dest == null) {
            return false;
        }
        double dx = dest.getX() + 0.5D - this.getX();
        double dz = dest.getZ() + 0.5D - this.getZ();
        double dy = dest.getY() - this.getY();

        double horizontalDist = Math.sqrt(dx * dx + dz * dz);
        if (horizontalDist < 0.05D) {
            return false;
        }
        double hSpeed = Math.min(horizontalDist / 8.0D, maxHorizontalSpeed);

        // Assume ~8 ticks of airtime; solve for vertical launch velocity.
        double t = 8.0D;
        double gravity = 0.08D;
        double vUp = (dy + 0.5D * gravity * t * t) / t;
        vUp = Math.max(0.45D, Math.min(vUp, 1.2D));

        Vec3 dir = new Vec3(dx, 0.0, dz).normalize();
        this.setDeltaMovement(dir.x * hSpeed, vUp, dir.z * hSpeed);
        this.hasImpulse = true;
        this.hurtMarked = true;
        this.resetFallDistance();
        return true;
    }

    // ------------------------------------------------------------------
    // Sounds
    // ------------------------------------------------------------------

    @Override
    protected SoundEvent getAmbientSound() {
        int co = this.random.nextInt(3);
        if (co < 2) {
            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), ADA_AREA)) {
                if (lvt instanceof EntityLeon && co == 1) {
                    return SoundInit.ENTITY_ADA_ADA4LEON.get();
                }
            }
        }
        if (co == 0) {
            return SoundInit.ENTITY_ADA_ADA4D2.get();
        } else if (co == 1) {
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
        if (ran.nextInt(2) == 1) {
            return SoundInit.ENTITY_ADA_DEATH.get();
        }
        return SoundInit.ENTITY_ADA_ADA4LEON.get();
    }

    // ------------------------------------------------------------------
    // Animations
    // ------------------------------------------------------------------

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.getAttckingState() != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        int state = this.getAttckingState();
        switch (state) {
            case STATE_ATTACK -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack"));
                return PlayState.CONTINUE;
            }
            case STATE_ATTACK2 -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack2"));
                return PlayState.CONTINUE;
            }
            case STATE_SHOOT -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.shoot"));
                return PlayState.CONTINUE;
            }
            case STATE_GUN_VAULT -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.gun_vault"));
                return PlayState.CONTINUE;
            }
            default -> {
                return PlayState.STOP;
            }
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 0, this::predicate));
        data.add(new AnimationController<>(this, "combat", 0, this::predicateCombat));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    // ------------------------------------------------------------------
    // Combat goal
    // ------------------------------------------------------------------

    static class Ada4CombatGoal extends Goal {
        private final EntityAda4 ada;
        private int timer;
        private int chosenState;
        /** Landing spot chosen by attack2's backflip; used for landing correction. */
        private BlockPos vaultDest;

        Ada4CombatGoal(EntityAda4 ada) {
            this.ada = ada;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.ada.getTarget() != null && this.ada.getTarget().isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() || this.ada.getAttckingState() != STATE_IDLE;
        }

        @Override
        public void start() {
            this.timer = 0;
            this.chosenState = STATE_IDLE;
            this.vaultDest = null;
            this.ada.setAggressive(true);
        }

        @Override
        public void stop() {
            this.ada.setAggressive(false);
            this.ada.setAttackingState(STATE_IDLE);
            this.timer = 0;
            this.chosenState = STATE_IDLE;
            this.vaultDest = null;
        }

        /** Called by EntityAda4.hurt() to apply hitstun. A dodge cancels the skill without the slow. */
        void forceInterrupt(boolean stagger) {
            this.ada.setAttackingState(STATE_IDLE);
            this.chosenState = STATE_IDLE;
            this.timer = 0;
            this.vaultDest = null;
            this.ada.getNavigation().stop();
            this.ada.setDeltaMovement(Vec3.ZERO);
            if (stagger) {
                // Brief "stagger" — short slow, no long lock.
                this.ada.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2, false, false));
            }
        }

        @Override
        public void tick() {
            LivingEntity target = this.ada.getTarget();
            if (target == null) {
                this.ada.setAttackingState(STATE_IDLE);
                return;
            }

            double dist = this.ada.distanceTo(target);

            if (this.chosenState != STATE_IDLE) {
                ++this.timer;
                this.runSkill(target, dist);
                return;   // Skill locked: no re-selection, no auto look-at.
            }

            // Idle / decision: track the target normally.
            this.ada.getLookControl().setLookAt(target, 30.0F, 30.0F);

            if (this.ada.isModMonster(target)) {
                this.tickAgainstModMonster(target, dist);
                return;
            }

            // Signature gun vault — modest chance when off cooldown.
            if (this.ada.vaultCooldown <= 0 && this.ada.getRandom().nextFloat() < 0.12F) {
                this.beginSkill(STATE_GUN_VAULT);
                return;
            }

            if (dist > MELEE_RANGE) {
                this.ada.getNavigation().moveTo(target, 1.45D);
                if (dist >= SHOOT_MIN && dist <= SHOOT_MAX && this.ada.getRandom().nextInt(14) == 0) {
                    this.beginSkill(STATE_SHOOT);
                } else if (dist > SHOOT_MAX && this.ada.getRandom().nextInt(40) == 0) {
                    this.beginSkill(STATE_GUN_VAULT);
                }
                return;
            }

            this.ada.getNavigation().stop();
            int pick = this.ada.meleeIndex % 3;
            this.ada.meleeIndex++;
            if (pick == 0) {
                this.beginSkill(STATE_ATTACK);
            } else if (pick == 1) {
                this.beginSkill(STATE_ATTACK2);
            } else if (this.ada.getRandom().nextFloat() < 0.35F) {
                this.beginSkill(STATE_SHOOT);
            } else {
                this.beginSkill(STATE_ATTACK);
            }
        }

        /**
         * Versus mod monsters: keep the 5–16 block gun line, flip away if they
         * close, and hook out when two or more are inside 4 blocks.
         */
        private void tickAgainstModMonster(LivingEntity target, double dist) {
            int nearby = this.ada.countNearbyModHostiles(4.0D);
            boolean surrounded = nearby >= 2;

            if (surrounded && this.ada.vaultCooldown <= 0) {
                this.beginSkill(STATE_GUN_VAULT);
                return;
            }

            if (dist < SHOOT_MIN || surrounded) {
                Vec3 away = this.ada.awayFrom(target);
                this.ada.getNavigation().moveTo(
                        this.ada.getX() + away.x * 6.0D,
                        this.ada.getY(),
                        this.ada.getZ() + away.z * 6.0D,
                        1.5D);
                if (dist <= MELEE_RANGE && this.ada.getRandom().nextInt(surrounded ? 8 : 10) == 0) {
                    this.beginSkill(STATE_ATTACK2);
                } else if (dist >= SHOOT_MIN && dist <= SHOOT_MAX && this.ada.getRandom().nextInt(8) == 0) {
                    this.beginSkill(STATE_SHOOT);
                }
                return;
            }

            if (dist <= SHOOT_MAX) {
                this.ada.getNavigation().stop();
                if (this.ada.vaultCooldown <= 0 && this.ada.getRandom().nextFloat() < 0.06F) {
                    this.beginSkill(STATE_GUN_VAULT);
                    return;
                }
                if (this.ada.getRandom().nextInt(8) == 0) {
                    this.beginSkill(STATE_SHOOT);
                }
                return;
            }

            this.ada.getNavigation().moveTo(target, 1.45D);
            if (this.ada.vaultCooldown <= 0 && this.ada.getRandom().nextInt(40) == 0) {
                this.beginSkill(STATE_GUN_VAULT);
            }
        }

        private void beginSkill(int state) {
            this.chosenState = state;
            this.timer = 0;
            this.vaultDest = null;
            this.ada.setAttackingState(state);
        }

        private void finishSkill() {
            this.chosenState = STATE_IDLE;
            this.timer = 0;
            this.vaultDest = null;
            this.ada.setAttackingState(STATE_IDLE);
        }

        private void runSkill(LivingEntity target, double dist) {
            switch (this.chosenState) {
                case STATE_ATTACK -> this.tickAttack(target);
                case STATE_ATTACK2 -> this.tickAttack2(target);
                case STATE_SHOOT -> this.tickShoot(target);
                case STATE_GUN_VAULT -> this.tickGunVault(target);
                default -> this.finishSkill();
            }
        }

        /** Left / right punches — synced to attack (~1.2s). */
        private void tickAttack(LivingEntity target) {
            double dist = this.ada.distanceTo(target);
            if (dist > MELEE_RANGE + 1.6D) {
                this.finishSkill();
                return;
            }
            if (this.timer == 5 || this.timer == 14) {
                if (dist <= MELEE_RANGE + 0.4D) {
                    this.ada.dealMeleeHit(target, 5.5F, 2.5F);
                }
            }
            if (this.timer == 9 || this.timer == 19) {
                if (dist <= MELEE_RANGE + 0.4D) {
                    this.ada.dealMeleeHit(target, 6.0F, 2.5F);
                }
            }
            if (this.timer >= 24) {
                this.finishSkill();
            }
        }

        /**
         * Double kick then backflip to a spot behind the target.
         * Launch is a real parabolic hop; a small landing correction is
         * applied only if physics put us more than ~2 blocks off.
         */
        private void tickAttack2(LivingEntity target) {
            double dist = this.ada.distanceTo(target);

            // Front kicks.
            if (this.timer == 8 || this.timer == 10) {
                if (dist <= MELEE_RANGE + 0.6D) {
                    this.ada.dealMeleeHit(target, 7.5F, 2.8F);
                }
            }

            // Launch: pick a spot behind the target and leap there.
            if (this.timer == 14) {
                BlockPos behind = this.ada.findBehindTargetSpot(target, 3.5D, 4);
                if (behind != null && this.ada.leapTo(behind, 0.85D)) {
                    this.vaultDest = behind;
                } else {
                    // No valid behind-spot: fall back to a backwards hop.
                    this.ada.leapAlong(this.ada.awayFrom(target), 0.9D, 0.55D);
                    this.vaultDest = null;
                }
            }

            // Landing correction (only if physics put us significantly off).
            if (this.timer == 22 && this.vaultDest != null) {
                if (this.ada.blockPosition().distSqr(this.vaultDest) > 4.0D
                        && this.ada.isStandableFeet(this.vaultDest)) {
                    this.ada.teleportTo(
                            this.vaultDest.getX() + 0.5D,
                            this.vaultDest.getY() + 0.05D,
                            this.vaultDest.getZ() + 0.5D);
                    this.ada.resetFallDistance();
                }
            }

            if (this.timer >= 32) {
                this.finishSkill();
            }
        }

        /** Local step-back then shoot. Look-at is refreshed right before firing. */
        private void tickShoot(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 2) {
                this.ada.retreatNearby(target);
            }
            if (this.timer == 13) {
                // Re-aim just before firing since look tracking is locked during skills.
                this.ada.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }
            if (this.timer == 14) {
                this.ada.fireOrWeb(target);
            }
            if (this.timer >= 25) {
                this.finishSkill();
            }
        }

        /** Gun vault to relative high ground. */
        private void tickGunVault(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 5) {
                // Re-aim before hooking so the hook goes toward the target side.
                this.ada.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }
            if (this.timer == 6) {
                this.ada.performGunVault(target);
            }
            if (this.timer == 14) {
                this.ada.teleportToHighGround(target, 6.5D);
            }
            if (this.timer == 20) {
                this.ada.vaultCooldown = 20 * 10;
            }
            if (this.timer >= 30) {
                this.finishSkill();
            }
        }
    }
}
