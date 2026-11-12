package com.joy187.re8joymod.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityFrank5 extends EntityFrank1 implements GeoEntity, VibrationSystem {
    private static final int HEAR_MEMORY = 100;
    private static final int HEAR_RADIUS = 16;
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private final DynamicGameEventListener<VibrationSystem.Listener> dynamicGameEventListener;
    private final VibrationSystem.User vibrationUser;
    private final VibrationSystem.Data vibrationData = new VibrationSystem.Data();
    private int listenTicks;
    private int attackTimer;
    private float chargeYaw;
    @Nullable
    private BlockPos investigatePos;
    @Nullable
    private LivingEntity queuedTarget;
    @Nullable
    private BlockPos queuedPos;
    private final Set<UUID> chargeHit = new HashSet<>();

    public EntityFrank5(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.vibrationUser = new HearingUser();
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationSystem.Listener(this));
        this.xpReward = 50;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27D).
                add(Attributes.ATTACK_DAMAGE, 13.4D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D);
    }
    
    
    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(EntityFrank5.this, 1.0D, true);
        }

        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            float f = EntityFrank5.this.getBbWidth() - 0.1F;
            return (double)(f * 2.0F * f * 3.5F + p_179512_1_.getBbWidth());
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new AttackGoal());
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    protected void updateControlFlags() {
        if (this.getAttckingState() == 2 || this.attackTimer > 0) {
            this.goalSelector.setControlFlag(Goal.Flag.MOVE, false);
            this.goalSelector.setControlFlag(Goal.Flag.JUMP, false);
            this.goalSelector.setControlFlag(Goal.Flag.LOOK, false);
            this.goalSelector.setControlFlag(Goal.Flag.TARGET, true);
            return;
        }
        super.updateControlFlags();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            return;
        }
        VibrationSystem.Ticker.tick(this.level(), this.vibrationData, this.vibrationUser);
        this.tickHearing();
        this.tickChargeAttack();
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        if (this.getAttckingState() != 0 || this.attackTimer > 0) {
            return false;
        }
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60 * (int)f));
        }

        return flag;
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
            return PlayState.STOP;
        }

        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.walk"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank5.idle"));
        return PlayState.CONTINUE;
    }
    
	
	
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.frank5.attack"))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.frank5.attack2"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}
	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		if (state == 1) {
			this.triggerAnim("controller1", "slash");
		} else if (state == 2) {
			this.triggerAnim("controller1", "heavy");
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1 || time == 2) && prev != time) {
			this.startAttackAnim(time);
		}
	}





	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !this.level().isClientSide && source.getEntity() instanceof LivingEntity living) {
            this.noticeEntity(living, living.blockPosition());
        }
        return hurt;
    }

    private boolean isCharging() {
        return this.getAttckingState() == 2 || this.attackTimer > 0;
    }

    private boolean canHear(LivingEntity living) {
        if (living == this || !living.isAlive() || !living.attackable() || living instanceof EntityFrank5) {
            return false;
        }
        return !(living instanceof Player player) || !player.isSpectator();
    }

    private void noticeEntity(LivingEntity living, BlockPos pos) {
        if (!this.canHear(living)) {
            return;
        }
        this.listenTicks = HEAR_MEMORY;
        if (this.isCharging()) {
            this.queuedTarget = living;
            this.queuedPos = pos;
            return;
        }
        this.queuedTarget = null;
        this.queuedPos = null;
        this.investigatePos = null;
        this.setTarget(living);
        this.getNavigation().moveTo(living, 1.1D);
    }

    private void noticePosition(BlockPos pos) {
        if (this.getTarget() != null || this.queuedTarget != null) {
            return;
        }
        if (this.isCharging()) {
            this.queuedPos = pos;
            return;
        }
        this.investigatePos = pos;
        this.listenTicks = 80;
        this.getNavigation().moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 1.0D);
    }

    private void tickHearing() {
        if (this.listenTicks > 0) {
            --this.listenTicks;
        }
        if (!this.isCharging()) {
            if (this.queuedTarget != null) {
                LivingEntity queued = this.queuedTarget;
                BlockPos pos = this.queuedPos != null ? this.queuedPos : queued.blockPosition();
                this.queuedTarget = null;
                this.queuedPos = null;
                this.noticeEntity(queued, pos);
            } else if (this.queuedPos != null && this.getTarget() == null) {
                BlockPos pos = this.queuedPos;
                this.queuedPos = null;
                this.noticePosition(pos);
            }
        }

        LivingEntity target = this.getTarget();
        if (target != null && !this.canHear(target)) {
            this.setTarget(null);
            target = null;
        }
        if (target != null && this.listenTicks <= 0 && !this.isCharging()) {
            double reach = (this.getBbWidth() + target.getBbWidth()) * 0.5D + 2.0D;
            if (this.distanceToSqr(target) > reach * reach) {
                this.setTarget(null);
            } else {
                this.listenTicks = 40;
            }
        }
        if (!this.isCharging() && this.getTarget() != null) {
            this.lookAt(this.getTarget(), 30.0F, 30.0F);
        }
        if (!this.isCharging() && this.getTarget() == null && this.investigatePos != null) {
            if (this.listenTicks <= 0 || this.distanceToSqr(Vec3.atCenterOf(this.investigatePos)) < 4.0D) {
                this.tryGrabNearby();
            } else if (this.getNavigation().isDone()) {
                BlockPos pos = this.investigatePos;
                this.getNavigation().moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 1.0D);
            }
        }
    }

    private void tryGrabNearby() {
        AABB box = this.getBoundingBox().inflate(2.0D);
        LivingEntity found = null;
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, this::canHear)) {
            found = living;
            break;
        }
        this.investigatePos = null;
        this.listenTicks = 0;
        if (found != null) {
            this.noticeEntity(found, found.blockPosition());
        } else {
            this.getNavigation().stop();
        }
    }

    private void tickChargeAttack() {
        LivingEntity target = this.getTarget();
        if (!this.isCharging()) {
            if (this.attackTimer < 0) {
                if (target != null) {
                    ++this.attackTimer;
                }
                return;
            }
            if (target == null || this.distanceToSqr(target) > 36.0D) {
                return;
            }
        }

        ++this.attackTimer;
        if (this.attackTimer == 1) {
            if (target != null) {
                this.lookAt(target, 180.0F, 180.0F);
            }
            this.chargeYaw = this.getYRot();
            this.chargeHit.clear();
            this.getNavigation().stop();
            this.setAttackingState(2);
        }
        if (this.getAttckingState() == 2 && this.attackTimer >= 5 && this.attackTimer <= 15) {
            this.tickCharge();
        } else if (this.getAttckingState() == 2) {
            this.holdChargePose();
        }
        if (this.attackTimer >= 30) {
            this.setAttackingState(0);
            this.attackTimer = -15;
            this.chargeHit.clear();
        }
    }

    private void holdChargePose() {
        this.getNavigation().stop();
        this.setSpeed(0.0F);
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(0.0D, motion.y, 0.0D);
        this.setYRot(this.chargeYaw);
        this.setYBodyRot(this.chargeYaw);
        this.setYHeadRot(this.chargeYaw);
    }

    private void tickCharge() {
        this.getNavigation().stop();
        Vec3 before = this.position();
        float yaw = this.chargeYaw * ((float) Math.PI / 180F);
        this.move(MoverType.SELF, new Vec3(-Mth.sin(yaw) * 0.42D, 0.0D, Mth.cos(yaw) * 0.42D));
        this.setYRot(this.chargeYaw);
        this.setYBodyRot(this.chargeYaw);
        this.setYHeadRot(this.chargeYaw);
        Vec3 delta = this.position().subtract(before);
        if (delta.lengthSqr() < 1.0E-6D) {
            return;
        }
        double myVolume = boxVolume(this.getBoundingBox());
        AABB box = this.getBoundingBox().inflate(0.35D);
        for (Entity entity : this.level().getEntities(this, box, candidate -> candidate.isAlive() && candidate.isPushable())) {
            if (boxVolume(entity.getBoundingBox()) >= myVolume) {
                continue;
            }
            entity.setPos(entity.getX() + delta.x, entity.getY() + delta.y, entity.getZ() + delta.z);
            entity.setDeltaMovement(delta.x, entity.getDeltaMovement().y, delta.z);
            entity.hurtMarked = true;
            if (entity instanceof LivingEntity living && this.chargeHit.add(living.getUUID())) {
                living.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
            }
        }
    }

    private static double boxVolume(AABB box) {
        return box.getXsize() * box.getYsize() * box.getZsize();
    }

    private void onVibration(BlockPos pos, @Nullable Entity direct, @Nullable Entity projectileOwner) {
        Entity cause = projectileOwner != null ? projectileOwner : direct;
        if (cause instanceof Projectile projectile && projectile.getOwner() != null) {
            cause = projectile.getOwner();
        }
        if (cause == this || cause instanceof EntityFrank5) {
            return;
        }
        if (cause instanceof LivingEntity living) {
            this.noticeEntity(living, pos);
        } else {
            this.noticePosition(pos);
        }
    }

    @Override
    public VibrationSystem.Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public VibrationSystem.User getVibrationUser() {
        return this.vibrationUser;
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        if (this.level() instanceof ServerLevel server) {
            consumer.accept(this.dynamicGameEventListener, server);
        }
    }

    private class HearingUser implements VibrationSystem.User {
        private final PositionSource positionSource = new EntityPositionSource(EntityFrank5.this, EntityFrank5.this.getEyeHeight());

        @Override
        public int getListenerRadius() {
            return HEAR_RADIUS;
        }

        @Override
        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel level, BlockPos pos, GameEvent event, GameEvent.Context context) {
            if (EntityFrank5.this.isDeadOrDying() || EntityFrank5.this.isRemoved()) {
                return false;
            }
            Entity source = context == null ? null : context.sourceEntity();
            return source != EntityFrank5.this && !(source instanceof EntityFrank5);
        }

        @Override
        public void onReceiveVibration(ServerLevel level, BlockPos pos, GameEvent event, @Nullable Entity direct, @Nullable Entity projectileOwner, float distance) {
            EntityFrank5.this.onVibration(pos, direct, projectileOwner);
        }
    }
}
