package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
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
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Predicate;

/**
 * Krauser phase 2 — synced with phase-1 combat: triggerAnim, anim-timed displacement, recover hard-stun.
 * Slightly more aggressive numbers than {@link EntityKrauser}.
 */
public class EntityKrauser2 extends Monster implements GeoEntity {

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityKrauser2.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityKrauser2.class,
			EntityDataSerializers.INT);

	private int attackTimer = 0;
	private int preatt = 0;
	/** Victim currently locked by grab skill (STATE 4). */
	private LivingEntity grabVictim;

	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (e) ->
			e.getMobType() != MobType.UNDEAD && e.attackable()
					&& !(e instanceof EntityKrauser2)
					&& !(e instanceof EntityKrauser)
					&& !(e instanceof EntitySalazar);

	private static final Predicate<Entity> KRAUSER_AREA = (entity) ->
			entity.isAlive() && !(entity instanceof EntityKrauser2);

	public EntityKrauser2(EntityType<? extends Monster> type, Level level) {
		super(type, level);
		this.xpReward = 200;
		this.preatt = 0;
		this.attackTimer = 0;
	}

	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 200.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.FOLLOW_RANGE, 18.0D)
				.add(Attributes.ARMOR, 6D)
				.add(Attributes.ARMOR_TOUGHNESS, 9.0D)
				.add(Attributes.ATTACK_DAMAGE, 9.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
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

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.fallDistance = 0;
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public void makeInvulnerable() {
		this.bossInfo.setProgress(0.0F);
		this.setHealth(this.getMaxHealth() / 3.0F);
	}

	public boolean isNonBoss() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
		int atk = this.entityData.get(STATE);
		if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
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
			this.triggerAnim("controller1", "special");
		} else if (state == 4) {
			this.triggerAnim("controller1", "grab");
		}
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.krauser.attack"))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.krauser.attack2"))
						.triggerableAnim("special", RawAnimation.begin().thenPlay("animation.krauser.attack3"))
						.triggerableAnim("grab", RawAnimation.begin().thenPlay("animation.krauser.grab"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.factory;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (!this.level().isClientSide()) {
			return super.hurt(source, Math.min(50, amount));
		}
		return false;
	}

	public int getAttckingState() {
		return this.entityData.get(STATE);
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1 || time == 2 || time == 3 || time == 4) && prev != time) {
			this.startAttackAnim(time);
		}
		if (time == 0) {
			this.grabVictim = null;
		}
	}

	public int getDefendingState() {
		return this.entityData.get(DEFENDSTATE);
	}

	public void setDefendingState(int time) {
		this.entityData.set(DEFENDSTATE, time);
	}

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
		this.grabVictim = null;
		this.setAttackingState(0);
		this.attackTimer = -10;
		this.preatt = 0;
		this.setDefendingState(1);
		this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 2, 5, true, true));
		this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * 2, 2, true, true));
		this.getNavigation().stop();
	}

	/** Prefer slash / heavy / slam by HP band; close-range grab chance. */
	private int pickSkill(LivingEntity target) {
		double dist = this.distanceTo(target);
		if (dist < 6.0D && this.preatt != 4 && this.random.nextInt(100) < 28) {
			return 4;
		}

		float pct = this.getHealth() / this.getMaxHealth();
		boolean preferSlash = (pct >= 0.86F && pct <= 0.90F) || (pct >= 0.82F && pct <= 0.85F)
				|| (pct >= 0.76F && pct <= 0.79F) || (pct >= 0.42F && pct <= 0.45F)
				|| (pct >= 0.51F && pct <= 0.54F) || (pct >= 0.20F && pct <= 0.23F)
				|| (pct >= 0.10F && pct <= 0.14F);
		boolean preferHeavy = (pct >= 0.71F && pct <= 0.75F) || (pct >= 0.55F && pct <= 0.59F)
				|| (pct >= 0.64F && pct <= 0.68F) || (pct >= 0.47F && pct <= 0.51F)
				|| (pct >= 0.30F && pct <= 0.34F) || (pct >= 0.03F && pct <= 0.08F)
				|| (pct >= 0.25F && pct <= 0.30F);

		if (preferSlash && this.preatt != 1) {
			return 1;
		}
		if (preferHeavy && this.preatt != 2) {
			return 2;
		}
		if (preferSlash || preferHeavy) {
			return this.preatt == 1 ? 2 : 1;
		}
		int roll = this.random.nextInt(100);
		if (roll < 28) {
			return 1;
		}
		if (roll < 58) {
			return 2;
		}
		if (roll < 82) {
			return 3;
		}
		return dist < 7.0D ? 4 : 3;
	}

	private void holdGrabVictim() {
		if (this.grabVictim == null || !this.grabVictim.isAlive()) {
			return;
		}
		Vec3 look = this.getLookAngle();
		Vec3 flat = new Vec3(look.x, 0.0D, look.z);
		if (flat.lengthSqr() < 1.0E-4D) {
			flat = new Vec3(0.0D, 0.0D, 1.0D);
		}
		flat = flat.normalize();
		double x = this.getX() + flat.x * 1.05D;
		double y = this.getY() + 0.2D;
		double z = this.getZ() + flat.z * 1.05D;
		this.grabVictim.teleportTo(x, y, z);
		this.grabVictim.setDeltaMovement(Vec3.ZERO);
		this.grabVictim.hurtMarked = true;
		// Keep victim locked for the hold window (refresh each tick).
		this.grabVictim.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8, 6, false, false));
		this.grabVictim.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 8, 2, false, false));
	}

	private void stabGrabVictim() {
		if (this.grabVictim == null || !this.grabVictim.isAlive()) {
			return;
		}
		float dmg = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.85F
				+ this.grabVictim.getArmorValue() * 0.35F;
		this.grabVictim.hurt(this.damageSources().mobAttack(this), dmg);
		this.heal(this.getMaxHealth() * 0.015f);
	}

	private void doSmashRing(float f) {
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

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
		this.entityData.define(DEFENDSTATE, 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		int co = this.random.nextInt(4);
		if (co < 2) {
			return SoundInit.ENTITY_KRAUSER_AMBIENT11.get();
		}
		if (co == 2) {
			return SoundInit.ENTITY_KRAUSER_AMBIENT21.get();
		}
		return SoundInit.ENTITY_KRAUSER_AMBIENT22.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return this.random.nextInt(2) == 0
				? SoundInit.ENTITY_KRAUSER_HURT.get()
				: SoundInit.ENTITY_KRAUSER_HURT2.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_KRAUSER_DEATH.get();
	}

	@Override
	public void tick() {
		super.tick();

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
		if (target == null) {
			if (this.getAttckingState() == 4) {
				this.beginRecover();
			} else if (this.getAttckingState() != 0) {
				this.setAttackingState(0);
				this.attackTimer = 0;
				this.preatt = 0;
			}
		} else if (!this.hasLineOfSight(target) && this.getAttckingState() != 0) {
			if (this.getAttckingState() == 4) {
				this.beginRecover();
			} else {
				this.setAttackingState(0);
				this.preatt = 0;
			}
		}

		if (target != null && this.hasLineOfSight(target)) {
			++this.attackTimer;
			float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
			int atk = this.getAttckingState();

			if (atk != 0) {
				this.getNavigation().stop();
			} else {
				this.getNavigation().moveTo(target, 1.05D);
			}

			if (this.attackTimer == 5) {
				int skill = this.pickSkill(target);
				this.getNavigation().stop();
				this.preatt = skill;
				this.setAttackingState(skill);
				atk = this.getAttckingState();
			}

			// STATE 1 slash — step-in paired with knife swings (~1.25s anim)
			if (atk == 1) {
				if (this.attackTimer >= 6 && this.attackTimer <= 10 && this.distanceTo(target) > 2.6f) {
					this.dashToward(target, 0.55D, 0.0D);
				}
				if (this.attackTimer >= 11 && this.attackTimer <= 13) {
					this.dashToward(target, 0.72D, 0.0D);
				}
				if (this.attackTimer == 14 && target.isAlive() && this.distanceTo(target) < 2.9f) {
					target.hurt(this.damageSources().mobAttack(this),
							(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(5));
					this.heal(this.getMaxHealth() * 0.025f);
					target.knockback(0.28, this.getX() - target.getX(), this.getZ() - target.getZ());
				}
				if (this.attackTimer >= 17 && this.attackTimer <= 18) {
					this.dashToward(target, 0.45D, 0.0D);
				}
				if (this.attackTimer == 19 && target.isAlive() && this.distanceTo(target) < 2.9f) {
					target.hurt(this.damageSources().mobAttack(this),
							(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getArmorValue());
					this.heal(this.getMaxHealth() * 0.025f);
					target.knockback(0.32, this.getX() - target.getX(), this.getZ() - target.getZ());
				}
			}

			// STATE 2 leap-smash — crouch → leap → dive impact (~1.5s anim)
			if (atk == 2) {
				if (this.attackTimer == 12) {
					this.leapUp(0.78D);
				}
				if (this.attackTimer >= 16 && this.attackTimer <= 19) {
					double speed = this.attackTimer == 16 ? 1.35D : 0.85D;
					double vy = this.attackTimer == 16 ? -0.22D : 0.0D;
					this.dashToward(target, speed, vy);
				}
				if (this.attackTimer == 20) {
					for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class,
							this.getBoundingBox().inflate(4.2D), KRAUSER_AREA)) {
						lvt.hurt(this.damageSources().mobAttack(this),
								lvt.getMaxHealth() * 0.22F + lvt.getArmorValue());
					}
					this.doSmashRing(f);
				}
			}

			// STATE 3 high leap + controlled late rush (~2.0s anim)
			if (atk == 3) {
				if (this.attackTimer == 12) {
					this.leapUp(1.05D);
				}
				if (this.attackTimer == 28) {
					this.getNavigation().stop();
					this.doSmashRing(f);
				}
				if (this.attackTimer >= 32 && this.attackTimer <= 36) {
					double speed = 1.55D - (this.attackTimer - 32) * 0.18D;
					this.dashToward(target, Math.max(0.65D, speed), 0.0D);
				}
				if (this.attackTimer == 40 && target.isAlive() && this.distanceTo(target) < 3.75f) {
					target.hurt(this.damageSources().mobAttack(this),
							(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getArmorValue());
					target.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 200, 0, true, true));
					target.knockback(0.4, this.getX() - target.getX(), this.getZ() - target.getZ());
				}
			}

			// STATE 4 grab → hold → stab → release (~1.8s anim)
			if (atk == 4) {
				if (this.attackTimer >= 8 && this.attackTimer <= 11) {
					this.dashToward(target, this.attackTimer == 8 ? 1.05D : 0.7D, 0.0D);
				}
				if (this.attackTimer >= 12 && this.attackTimer <= 14
						&& this.grabVictim == null
						&& target.isAlive()
						&& !(target instanceof EntityKrauser)
						&& !(target instanceof EntityKrauser2)
						&& this.distanceTo(target) < 2.7f) {
					this.grabVictim = target;
					target.setDeltaMovement(Vec3.ZERO);
					target.hurtMarked = true;
					target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 6, false, false));
					target.hurt(this.damageSources().mobAttack(this),
							(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.55F);
				}
				if (this.attackTimer == 15 && this.grabVictim == null) {
					this.beginRecover();
					atk = 0;
				} else if (this.grabVictim != null) {
					if (!this.grabVictim.isAlive()) {
						this.grabVictim = null;
						this.beginRecover();
						atk = 0;
					} else if (this.attackTimer >= 14 && this.attackTimer <= 34) {
						this.setDeltaMovement(Vec3.ZERO);
						this.holdGrabVictim();
						if (this.attackTimer == 16 || this.attackTimer == 22 || this.attackTimer == 28) {
							this.stabGrabVictim();
						}
					} else if (this.attackTimer == 36) {
						this.grabVictim.knockback(0.9D,
								this.getX() - this.grabVictim.getX(),
								this.getZ() - this.grabVictim.getZ());
						this.grabVictim.setDeltaMovement(
								this.grabVictim.getDeltaMovement().add(0.0D, 0.32D, 0.0D));
						this.grabVictim.hurtMarked = true;
						this.grabVictim = null;
						// small shove-back to sell the throw
						Vec3 back = this.getLookAngle().multiply(-0.35D, 0.0D, -0.35D);
						this.setDeltaMovement(back.x, 0.12D, back.z);
						this.hasImpulse = true;
					}
				}
			}

			// End after anim (+ short settle): slash 1.25s, heavy 1.5s, grab 1.8s, special 2.0s
			int endTick = switch (atk) {
				case 1 -> 32;
				case 2 -> 38;
				case 4 -> 42;
				case 3 -> 48;
				default -> 42;
			};
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

	private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
		int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
		double minY = this.getY() - 2.0;
		double maxY = this.getY() + (double) mxy;
		float angle = (float) Math.PI / 180 * this.yBodyRot;
		float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180));
		float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180));
		double extraX = (float) distance * Mth.sin((float) (Math.PI + (double) angle));
		double extraZ = (float) distance * Mth.cos(angle);
		double px = this.getX() + extraX + (double) (f * math);
		double pz = this.getZ() + extraZ + (double) (f1 * math);
		int hitX = Mth.floor(px);
		int hitZ = Mth.floor(pz);
		BlockPos pos = new BlockPos(hitX, hitY, hitZ);
		BlockPos abovePos = pos.above();
		BlockState block = this.level().getBlockState(pos);
		BlockState blockAbove = this.level().getBlockState(abovePos);
		if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
			EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(),
					(double) hitX + 0.5, (double) hitY + 1.0, (double) hitZ + 0.5, block, 10);
			fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
			this.level().addFreshEntity(fallingBlockEntity);
		}
		AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
		List<LivingEntity> hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
		for (LivingEntity entity : hit) {
			if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) {
				continue;
			}
			if (entity instanceof Player && entity.getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
				disableShield(entity, shieldbreakticks);
			} else {
				boolean flag = entity.hurt(this.damageSources().mobAttack(this),
						(float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double) damage
								+ (double) (entity.getMaxHealth() * hpdamage)));
				if (flag) {
					entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, airborne + 0.5, 0.0));
				}
			}
		}
	}

	public static void disableShield(LivingEntity livingEntity, int ticks) {
		((Player) livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
		livingEntity.getUseItem().hurtAndBreak(4 + livingEntity.getRandom().nextInt(2), livingEntity, (e) -> {
			e.broadcastBreakEvent(livingEntity.getUsedItemHand());
		});
		livingEntity.stopUsingItem();
		livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
	}
}
