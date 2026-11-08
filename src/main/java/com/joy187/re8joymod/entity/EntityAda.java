package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.Random;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
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
 * Ada combat states (each skill has its own animation):
 * 0 idle / walk
 * 1 melee punch -> animation.ada.melee_punch
 * 2 melee right kick -> animation.ada.melee_kick_r
 * 3 dash left + left kick -> animation.ada.melee_dash_kick
 * 4 ranged bullet -> animation.ada.ranged
 * 5 grapple escape + heal (30% when hp < 25%) -> animation.ada.grapple_escape
 * 6 rush after escape -> animation.ada.rush
 */
public class EntityAda extends EntityChris {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public static final int STATE_IDLE = 0;
    public static final int STATE_PUNCH = 1;
    public static final int STATE_KICK = 2;
    public static final int STATE_DASH_KICK = 3;
    public static final int STATE_RANGED = 4;
    public static final int STATE_GRAPPLE = 5;
    public static final int STATE_RUSH = 6;

    /** Only start punch/kick when this close — prevents far-range empty swings. */
    private static final double MELEE_RANGE = 2.6D;
    /** Dash kick may start a bit farther because the skill itself closes distance. */
    private static final double DASH_KICK_RANGE = 5.0D;
    /** Prefer closing in below this; shoot only at mid-far range. */
    private static final double RANGED_MIN = 6.0D;
    private static final double RANGED_MAX = 14.0D;

    private int escapeCooldown;
    private int meleeIndex;

    public EntityAda(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 18.0D)
                .add(Attributes.ARMOR, 4D)
                .add(Attributes.ARMOR_TOUGHNESS, 6.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AdaCombatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityChris.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.escapeCooldown > 0) {
            --this.escapeCooldown;
        }
        // Mid-health light regen only; critical escape is handled by AdaCombatGoal.
        if (this.getHealth() >= this.getMaxHealth() * 0.25F
                && this.getHealth() <= this.getMaxHealth() * 0.55F) {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0, false, true));
        }
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        // Damage is applied by timed combat goal hits; keep vanilla melee as fallback only.
        return super.doHurtTarget(target);
    }

    /** True if living entity is inside Ada's forward facing cone (horizontal). */
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
        double cosLimit = Math.cos(Math.toRadians(halfAngleDeg));
        return lookFlat.dot(toFlat) >= cosLimit;
    }

    /** Melee damage only hits targets in Ada's facing direction (front cone). */
    private void dealMeleeHit(LivingEntity target, float damage, float range) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, box)) {
            if (entity == this || this.isAlliedTo(entity)) {
                continue;
            }
            if (this.distanceTo(entity) > range + 0.5F) {
                continue;
            }
            // ~140° front arc: behind / side flanks take no hit.
            if (!this.isInFrontCone(entity, 70.0F)) {
                continue;
            }
            entity.hurt(this.damageSources().mobAttack(this), damage);
            if (entity == target || entity instanceof Player) {
                Vec3 push = this.getLookAngle();
                entity.knockback(0.35F, -push.x, -push.z);
            }
        }
    }

    private void fireBullet() {
        EntityBOWShoot bullet = new EntityBOWShoot(this.level(), this);
        bullet.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 2.4F, 0.8F);
        bullet.damage = 5.5D;
        this.level().addFreshEntity(bullet);
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.2F);
    }

    private Vec3 awayFrom(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position());
        if (away.lengthSqr() < 0.01) {
            away = this.getLookAngle().scale(-1.0);
        }
        return new Vec3(away.x, 0.0, away.z).normalize();
    }

    private void fireGrappleAwayFrom(LivingEntity target) {
        Vec3 away = this.awayFrom(target).add(0.0, 0.35, 0.0).normalize();

        GrapplehookEntity hook = new GrapplehookEntity(this.level(), this);
        hook.shoot(away.x, away.y, away.z, 1.75F, 1.0F);
        hook.damage = 2.0D;
        this.level().addFreshEntity(hook);
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 0.8F);

        // Hook only teleports if it hits a block — always apply real leap ourselves.
        this.leapAlong(away, 1.35D, 0.55D);
    }

    /** Force a horizontal leap (IronGolem navigation alone is too weak for skill dashes). */
    private void leapAlong(Vec3 dir, double horizontal, double upward) {
        Vec3 n = new Vec3(dir.x, 0.0, dir.z);
        if (n.lengthSqr() < 1.0E-6) {
            return;
        }
        n = n.normalize();
        this.setDeltaMovement(n.x * horizontal, upward, n.z * horizontal);
        this.hasImpulse = true;
        this.hurtMarked = true;
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

    /** Hard reposition away from target onto solid ground. */
    private void teleportAwayFrom(LivingEntity target, double distance) {
        Vec3 away = this.awayFrom(target);
        Vec3 dest = this.position().add(away.scale(distance));
        BlockPos column = BlockPos.containing(dest.x, dest.y, dest.z);
        int groundY = this.level().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, column.getX(), column.getZ());
        this.getNavigation().stop();
        this.teleportTo(dest.x, groundY + 0.1D, dest.z);
        this.setDeltaMovement(away.x * 0.4D, 0.2D, away.z * 0.4D);
        this.hasImpulse = true;
        this.resetFallDistance();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if (co == 0) {
            return SoundInit.ENTITY_ADA_AMBIENT1.get();
        } else if (co == 1) {
            return SoundInit.ENTITY_ADA_AMBIENT2.get();
        }
        return SoundInit.ENTITY_ADA_AMBIENT3.get();
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
        return SoundInit.ENTITY_BELA_DEATH.get();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int state = this.getAttckingState();
        if (state != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.ada.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.ada.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        int state = this.getAttckingState();
        switch (state) {
            case STATE_PUNCH -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.melee_punch"));
                return PlayState.CONTINUE;
            }
            case STATE_KICK -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.melee_kick_r"));
                return PlayState.CONTINUE;
            }
            case STATE_DASH_KICK -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.melee_dash_kick"));
                return PlayState.CONTINUE;
            }
            case STATE_RANGED -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.ranged"));
                return PlayState.CONTINUE;
            }
            case STATE_GRAPPLE -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.grapple_escape"));
                return PlayState.CONTINUE;
            }
            case STATE_RUSH -> {
                event.setAndContinue(RawAnimation.begin().thenLoop("animation.ada.rush"));
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

    static class AdaCombatGoal extends Goal {
        private final EntityAda ada;
        private int timer;
        private int chosenState;

        AdaCombatGoal(EntityAda ada) {
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
            this.ada.setAggressive(true);
        }

        @Override
        public void stop() {
            this.ada.setAggressive(false);
            this.ada.setAttackingState(STATE_IDLE);
            this.timer = 0;
            this.chosenState = STATE_IDLE;
        }

        @Override
        public void tick() {
            LivingEntity target = this.ada.getTarget();
            if (target == null) {
                this.ada.setAttackingState(STATE_IDLE);
                return;
            }

            this.ada.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double dist = this.ada.distanceTo(target);

            // Continue active skill
            if (this.chosenState != STATE_IDLE) {
                ++this.timer;
                this.runSkill(target, dist);
                return;
            }

            // Low HP escape: 30% chance when ready (failed rolls get a short defer CD).
            if (this.ada.getHealth() < this.ada.getMaxHealth() * 0.25F && this.ada.escapeCooldown <= 0) {
                if (this.ada.getRandom().nextFloat() < 0.30F) {
                    this.beginSkill(STATE_GRAPPLE);
                    return;
                }
                // Avoid re-rolling every tick into near-100% trigger.
                this.ada.escapeCooldown = 20 * 3;
            }

            // Far / mid: chase first. Only shoot in a mid-far band — never melee from afar.
            if (dist > MELEE_RANGE) {
                this.ada.getNavigation().moveTo(target, 1.6D);
                // Higher chance to shoot while closing in.
                if (dist >= RANGED_MIN && dist <= RANGED_MAX && this.ada.getRandom().nextInt(12) == 0) {
                    this.beginSkill(STATE_RANGED);
                }
                return;
            }

            // In melee range: stop and pick a close skill.
            this.ada.getNavigation().stop();
            int pick = this.ada.meleeIndex % 3;
            this.ada.meleeIndex++;
            if (pick == 0) {
                this.beginSkill(STATE_PUNCH);
            } else if (pick == 1) {
                this.beginSkill(STATE_KICK);
            } else if (dist <= DASH_KICK_RANGE) {
                this.beginSkill(STATE_DASH_KICK);
            } else {
                this.beginSkill(STATE_PUNCH);
            }
        }

        private void beginSkill(int state) {
            this.chosenState = state;
            this.timer = 0;
            this.ada.setAttackingState(state);
        }

        private void finishSkill() {
            this.chosenState = STATE_IDLE;
            this.timer = 0;
            this.ada.setAttackingState(STATE_IDLE);
        }

        private void runSkill(LivingEntity target, double dist) {
            switch (this.chosenState) {
                case STATE_PUNCH -> this.tickPunch(target);
                case STATE_KICK -> this.tickKick(target);
                case STATE_DASH_KICK -> this.tickDashKick(target);
                case STATE_RANGED -> this.tickRanged(target);
                case STATE_GRAPPLE -> this.tickGrapple(target);
                case STATE_RUSH -> this.tickRush(target, dist);
                default -> this.finishSkill();
            }
        }

        /** Double punch — synced to melee_punch (~0.93s). Cancel if target ran away. */
        private void tickPunch(LivingEntity target) {
            double dist = this.ada.distanceTo(target);
            if (dist > MELEE_RANGE + 1.5D) {
                this.finishSkill();
                return;
            }
            if (this.timer == 5 || this.timer == 11) {
                if (dist <= MELEE_RANGE + 0.35D) {
                    this.ada.dealMeleeHit(target, 5.0F, 2.4F);
                }
            }
            if (this.timer >= 19) {
                this.finishSkill();
            }
        }

        /** Right kick — synced to melee_kick_r (~0.87s, impact ~0.34s). */
        private void tickKick(LivingEntity target) {
            double dist = this.ada.distanceTo(target);
            if (dist > MELEE_RANGE + 1.5D) {
                this.finishSkill();
                return;
            }
            if (this.timer == 7 && dist <= MELEE_RANGE + 0.5D) {
                this.ada.dealMeleeHit(target, 7.0F, 2.6F);
            }
            if (this.timer >= 18) {
                this.finishSkill();
            }
        }

        /** Strafe to target's left with real displacement, then left kick. */
        private void tickDashKick(LivingEntity target) {
            Vec3 toTarget = target.position().subtract(this.ada.position());
            Vec3 flat = new Vec3(toTarget.x, 0.0, toTarget.z);
            if (flat.lengthSqr() < 1.0E-4) {
                flat = this.ada.getLookAngle();
            }
            flat = flat.normalize();
            Vec3 left = new Vec3(-flat.z, 0.0, flat.x);

            if (this.timer == 1) {
                this.ada.leapAlong(left.add(flat.scale(0.35)), 1.15D, 0.25D);
            }
            if (this.timer <= 9) {
                Vec3 sidePoint = target.position().add(left.scale(2.4));
                Vec3 toSide = sidePoint.subtract(this.ada.position());
                this.ada.getNavigation().moveTo(sidePoint.x, sidePoint.y, sidePoint.z, 1.95D);
                this.ada.moveAlong(toSide, 0.6D);
            } else {
                this.ada.getNavigation().stop();
            }
            if (this.timer == 15) {
                this.ada.moveAlong(flat, 0.5D);
                this.ada.dealMeleeHit(target, 8.0F, 3.0F);
            }
            if (this.timer >= 25) {
                this.finishSkill();
            }
        }

        /** Ranged — synced to ranged (~0.68s, fire ~0.3s). */
        private void tickRanged(LivingEntity target) {
            this.ada.getNavigation().stop();
            double dist = this.ada.distanceTo(target);
            if (dist < RANGED_MIN - 1.0D) {
                this.finishSkill();
                return;
            }
            if (this.timer == 6) {
                this.ada.fireBullet();
            }
            if (this.timer >= 14) {
                this.finishSkill();
            }
        }

        private void tickGrapple(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 3) {
                this.ada.fireGrappleAwayFrom(target);
            }
            if (this.timer >= 4 && this.timer <= 9) {
                this.ada.moveAlong(this.ada.awayFrom(target), 0.7D);
            }
            if (this.timer == 10) {
                if (this.ada.distanceTo(target) < 5.5D) {
                    this.ada.teleportAwayFrom(target, 7.5D);
                }
            }
            if (this.timer >= 5 && this.timer <= 22) {
                this.ada.heal(0.4F);
                if (this.timer % 4 == 0) {
                    this.ada.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1, false, true));
                }
            }
            if (this.timer == 25) {
                this.ada.escapeCooldown = 20 * 12;
                this.beginSkill(STATE_RUSH);
            }
        }

        private void tickRush(LivingEntity target, double dist) {
            this.ada.getNavigation().moveTo(target, 2.0D);
            Vec3 toward = target.position().subtract(this.ada.position());
            if (toward.lengthSqr() > 0.001) {
                this.ada.moveAlong(toward, 0.65D);
            }
            if (dist < MELEE_RANGE && this.timer >= 5) {
                this.ada.dealMeleeHit(target, 9.0F, 2.5F);
                this.finishSkill();
                return;
            }
            if (this.timer >= 25) {
                this.finishSkill();
            }
        }
    }
}
