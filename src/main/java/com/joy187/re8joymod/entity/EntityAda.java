package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.Random;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
 * Ada combat states:
 * 0 idle
 * 1 melee punch (double fists) -> animation.ada.attack
 * 2 melee right kick -> animation.ada.attack2
 * 3 dash left + left kick -> animation.ada.attack2
 * 4 ranged bullet -> animation.ada.attack
 * 5 grapple escape + heal -> animation.ada.attack2
 * 6 rush after escape -> animation.ada.walk / attack
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

    private void dealMeleeHit(LivingEntity target, float damage, float range) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, box)) {
            if (entity == this || this.isAlliedTo(entity)) {
                continue;
            }
            if (this.distanceTo(entity) <= range + 0.5F) {
                entity.hurt(this.damageSources().mobAttack(this), damage);
                if (entity == target || entity instanceof Player) {
                    entity.knockback(0.35F, this.getX() - entity.getX(), this.getZ() - entity.getZ());
                }
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

    private void fireGrappleAwayFrom(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position());
        if (away.lengthSqr() < 0.01) {
            away = this.getLookAngle().scale(-1.0);
        }
        away = away.normalize().add(0.0, 0.35, 0.0).normalize();

        GrapplehookEntity hook = new GrapplehookEntity(this.level(), this);
        hook.shoot(away.x, away.y, away.z, 1.75F, 1.0F);
        hook.damage = 2.0D;
        this.level().addFreshEntity(hook);
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 0.8F);
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
            case STATE_PUNCH, STATE_RANGED -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.attack"));
                return PlayState.CONTINUE;
            }
            case STATE_KICK, STATE_DASH_KICK, STATE_GRAPPLE -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.attack2"));
                return PlayState.CONTINUE;
            }
            case STATE_RUSH -> {
                event.setAndContinue(RawAnimation.begin().thenLoop("animation.ada.walk"));
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

            // Pick new skill
            if (this.ada.getHealth() < this.ada.getMaxHealth() * 0.25F && this.ada.escapeCooldown <= 0) {
                this.beginSkill(STATE_GRAPPLE);
                return;
            }

            if (dist > 8.0D) {
                this.ada.getNavigation().moveTo(target, 1.25D);
                if (dist < 14.0D && this.ada.getRandom().nextInt(12) == 0) {
                    this.beginSkill(STATE_RANGED);
                }
                return;
            }

            if (dist > 3.2D) {
                this.ada.getNavigation().moveTo(target, 1.35D);
                if (this.ada.getRandom().nextInt(18) == 0) {
                    this.beginSkill(STATE_RANGED);
                }
                return;
            }

            this.ada.getNavigation().stop();
            int pick = this.ada.meleeIndex % 3;
            this.ada.meleeIndex++;
            if (pick == 0) {
                this.beginSkill(STATE_PUNCH);
            } else if (pick == 1) {
                this.beginSkill(STATE_KICK);
            } else {
                this.beginSkill(STATE_DASH_KICK);
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

        /** Double punch: hits at ~0.4s and ~0.9s of attack anim (1.5s). */
        private void tickPunch(LivingEntity target) {
            if (this.timer == 8 || this.timer == 18) {
                this.ada.dealMeleeHit(target, 5.0F, 2.4F);
            }
            if (this.timer >= 30) {
                this.finishSkill();
            }
        }

        /** Right kick: impact around 0.7s of attack2. */
        private void tickKick(LivingEntity target) {
            if (this.timer == 14) {
                this.ada.dealMeleeHit(target, 7.0F, 2.6F);
            }
            if (this.timer >= 28) {
                this.finishSkill();
            }
        }

        /** Strafe to target's left, then left kick. */
        private void tickDashKick(LivingEntity target) {
            if (this.timer <= 12) {
                Vec3 toTarget = target.position().subtract(this.ada.position()).normalize();
                Vec3 left = new Vec3(-toTarget.z, 0.0, toTarget.x).normalize();
                Vec3 sidePoint = target.position().add(left.scale(2.2));
                this.ada.getNavigation().moveTo(sidePoint.x, sidePoint.y, sidePoint.z, 1.6D);
                Vec3 push = left.scale(0.22);
                this.ada.setDeltaMovement(this.ada.getDeltaMovement().add(push.x, 0.0, push.z));
            } else {
                this.ada.getNavigation().stop();
            }
            if (this.timer == 28) {
                this.ada.dealMeleeHit(target, 8.0F, 2.8F);
            }
            if (this.timer >= 40) {
                this.finishSkill();
            }
        }

        private void tickRanged(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 12) {
                this.ada.fireBullet();
            }
            if (this.timer >= 22) {
                this.finishSkill();
            }
        }

        private void tickGrapple(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 5) {
                this.ada.fireGrappleAwayFrom(target);
            }
            if (this.timer >= 8 && this.timer <= 35) {
                this.ada.heal(0.35F);
                if (this.timer % 5 == 0) {
                    this.ada.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 40, 1, false, true));
                }
            }
            if (this.timer == 40) {
                this.ada.escapeCooldown = 20 * 12;
                this.beginSkill(STATE_RUSH);
            }
        }

        private void tickRush(LivingEntity target, double dist) {
            this.ada.getNavigation().moveTo(target, 1.7D);
            Vec3 toward = target.position().subtract(this.ada.position());
            if (toward.lengthSqr() > 0.001) {
                Vec3 n = toward.normalize().scale(0.18);
                this.ada.setDeltaMovement(this.ada.getDeltaMovement().add(n.x, 0.0, n.z));
            }
            if (dist < 2.5D && this.timer >= 8) {
                this.ada.dealMeleeHit(target, 9.0F, 2.5F);
                this.finishSkill();
                return;
            }
            if (this.timer >= 35) {
                this.finishSkill();
            }
        }
    }
}
