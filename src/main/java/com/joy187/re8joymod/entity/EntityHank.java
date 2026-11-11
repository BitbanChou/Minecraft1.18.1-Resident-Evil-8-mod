package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
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

import java.util.Random;
import java.util.function.Predicate;

/**
 * Hunk (EntityHank) — shoot / kick / close-range melee knife slash.
 * STATE 1 shoot ({@code animation.hank.attack}),
 * STATE 2 kick ({@code animation.hank.attack2}),
 * STATE 3 melee ({@code animation.hank.attack3}).
 */
public class EntityHank extends EntityEthan implements GeoEntity {
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityHank.class,
			EntityDataSerializers.INT);

	private static final int STATE_IDLE = 0;
	private static final int STATE_SHOOT = 1;
	private static final int STATE_KICK = 2;
	private static final int STATE_MELEE = 3;

	private int attackTimer;
	private int lastSkill;

	private static final Predicate<LivingEntity> AREA_HIT = (e) ->
			e.isAlive() && !(e instanceof IronGolem) && !(e instanceof EntityHank);

	public EntityHank(EntityType<? extends IronGolem> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 100;
		this.attackTimer = 0;
		this.lastSkill = 0;
	}

	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 100.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.24D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.9D)
				.add(Attributes.ATTACK_DAMAGE, 10.0D)
				.add(Attributes.FOLLOW_RANGE, 28.0D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		// Pathing only when target is grounded — combat tick handles air targets.
		this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1.05D, 32.0F) {
			@Override
			public boolean canUse() {
				LivingEntity t = EntityHank.this.getTarget();
				return super.canUse() && !AerialCombatHelper.isAerialTarget(EntityHank.this, t);
			}

			@Override
			public boolean canContinueToUse() {
				LivingEntity t = EntityHank.this.getTarget();
				return super.canContinueToUse() && !AerialCombatHelper.isAerialTarget(EntityHank.this, t);
			}
		});
		this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false,
				(e) -> e instanceof Enemy && !(e instanceof Creeper)));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));
	}

	public int getAttckingState() {
		return this.entityData.get(STATE);
	}

	public void setAttackingState(int time) {
		this.entityData.set(STATE, time);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENDERMAN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		Random ran = new Random();
		return ran.nextInt(2) == 0
				? SoundInit.ENTITY_ETHAN_HURT1.get()
				: SoundInit.ENTITY_CHRIS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_CHRIS_DEATH.get();
	}

	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
		if (this.getAttckingState() != STATE_IDLE) {
			return PlayState.STOP;
		}
		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenLoop("animation.hank.walk"));
			return PlayState.CONTINUE;
		}
		event.setAndContinue(RawAnimation.begin().thenLoop("animation.hank.idle"));
		return PlayState.CONTINUE;
	}

	private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
			return PlayState.STOP;
		}
		return switch (this.getAttckingState()) {
			case STATE_SHOOT -> {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack"));
				yield PlayState.CONTINUE;
			}
			case STATE_KICK -> {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack2"));
				yield PlayState.CONTINUE;
			}
			case STATE_MELEE -> {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.hank.attack3"));
				yield PlayState.CONTINUE;
			}
			default -> PlayState.STOP;
		};
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "controller", 4, this::predicate));
		data.add(new AnimationController<>(this, "combat", 2, this::predicateCombat));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.factory;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (!level().isClientSide()) {
			boolean isHurt = false;
			if (source != damageSources().fellOutOfWorld() && source != damageSources().onFire() && amount > 1.0F) {
				isHurt = true;
			}
			float predam = amount;
			if (amount > this.getMaxHealth() * 0.22) {
				amount = 1;
			}

			if (source.getEntity() instanceof Player player) {
				ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
				if (stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem) {
					amount = predam;
				}
			}

			if (source == damageSources().wither()) {
				isHurt = false;
			}
			if (source == damageSources().explosion(this, this.getLastHurtByMob())) {
				isHurt = false;
			}
			if (isHurt) {
				if (source.getEntity() instanceof Projectile) {
					if (amount >= 19.5) {
						amount = 1;
					} else {
						amount = amount / 3;
					}
				}
				return super.hurt(source, amount);
			}
		}
		return false;
	}

	private void dashToward(LivingEntity target, double speed) {
		Vec3 to = target.position().subtract(this.position());
		Vec3 flat = new Vec3(to.x, 0.0D, to.z);
		if (flat.lengthSqr() < 1.0E-4D) {
			return;
		}
		Vec3 dir = flat.normalize().scale(speed);
		this.setDeltaMovement(dir.x, this.getDeltaMovement().y, dir.z);
		this.hasImpulse = true;
	}

	/** Prefer melee/kick up close; shoot at mid-far range. Air targets always shoot. */
	private int pickSkill(LivingEntity target) {
		if (AerialCombatHelper.isAerialTarget(this, target)) {
			return STATE_SHOOT;
		}
		double dist = this.distanceTo(target);
		if (dist < 3.4D) {
			if (this.lastSkill == STATE_MELEE) {
				return this.random.nextBoolean() ? STATE_KICK : STATE_MELEE;
			}
			if (this.lastSkill == STATE_KICK) {
				return this.random.nextDouble() < 0.65D ? STATE_MELEE : STATE_KICK;
			}
			return this.random.nextDouble() < 0.58D ? STATE_MELEE : STATE_KICK;
		}
		if (dist < 7.5D) {
			int roll = this.random.nextInt(100);
			if (roll < 35) {
				return STATE_KICK;
			}
			if (roll < 55) {
				return STATE_MELEE;
			}
			return STATE_SHOOT;
		}
		return STATE_SHOOT;
	}

	private void endSkill() {
		this.setAttackingState(STATE_IDLE);
		this.attackTimer = -12;
		this.getNavigation().stop();
	}

	private void fireBurstShot(LivingEntity target) {
		EntityBOWShoot shot = new EntityBOWShoot(this.level(), this);
		AerialCombatHelper.aimBowShot(this, shot, target, 15.5F, 0.75F);
		this.level().addParticle(ParticleTypes.FLAME, shot.getX(), shot.getY(), shot.getZ(),
				shot.getDeltaMovement().x, shot.getDeltaMovement().y, shot.getDeltaMovement().z);
		shot.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
		shot.damage *= 1.15F;
		this.level().addFreshEntity(shot);
	}

	@Override
	public void tick() {
		super.tick();

		LivingEntity target = this.getTarget();
		if (target == null || !target.isAlive()) {
			if (this.getAttckingState() != STATE_IDLE) {
				this.endSkill();
			}
			return;
		}

		boolean aerial = AerialCombatHelper.isAerialTarget(this, target);

		if (!this.hasLineOfSight(target)) {
			if (this.getAttckingState() != STATE_IDLE) {
				this.endSkill();
			}
			if (!aerial) {
				this.getNavigation().moveTo(target, 1.05D);
			} else {
				AerialCombatHelper.holdShootDistance(this, target);
			}
			return;
		}

		++this.attackTimer;
		this.setAggressive(true);
		if (aerial) {
			AerialCombatHelper.holdShootDistance(this, target);
		} else {
			this.lookAt(target, 30.0F, 30.0F);
		}

		int atk = this.getAttckingState();
		if (atk == STATE_IDLE) {
			if (!aerial) {
				this.getNavigation().moveTo(target, 1.1D);
			}
			if (this.attackTimer >= (aerial ? 2 : 5)) {
				int skill = this.pickSkill(target);
				this.lastSkill = skill;
				this.setAttackingState(skill);
				this.getNavigation().stop();
				this.attackTimer = 0;
				atk = skill;
			}
		} else if (!aerial) {
			this.getNavigation().stop();
		}

		// STATE 1 — rifle burst (anim ~1.375s); loops while target stays airborne
		if (atk == STATE_SHOOT) {
			if (this.attackTimer == 6 || this.attackTimer == 12 || this.attackTimer == 18) {
				this.fireBurstShot(target);
			}
			if (this.attackTimer >= 30) {
				if (aerial) {
					// Pulse state so shoot anim restarts, stay in anti-air mode.
					this.setAttackingState(STATE_IDLE);
					this.setAttackingState(STATE_SHOOT);
					this.attackTimer = 0;
				} else {
					this.endSkill();
				}
			}
		}

		// STATE 2 — kick (anim ~1.5s, impact ~0.5s)
		if (atk == STATE_KICK) {
			if (this.attackTimer >= 8 && this.attackTimer <= 11) {
				this.dashToward(target, 0.55D);
			}
			if (this.attackTimer == 12) {
				for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class,
						this.getBoundingBox().inflate(2.6D), AREA_HIT)) {
					lvt.hurt(this.damageSources().mobAttack(this),
							(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.95F
									+ lvt.getArmorValue() * 0.25F);
					lvt.knockback(0.55D, this.getX() - lvt.getX(), this.getZ() - lvt.getZ());
				}
			}
			if (this.attackTimer >= 34) {
				this.endSkill();
			}
		}

		// STATE 3 — melee knife slash (anim ~1.05s)
		if (atk == STATE_MELEE) {
			if (this.attackTimer >= 5 && this.attackTimer <= 9) {
				this.dashToward(target, 0.7D);
			}
			if (this.attackTimer == 10 && target.isAlive() && this.distanceTo(target) < 3.0F) {
				target.hurt(this.damageSources().mobAttack(this),
						(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE)
								+ this.random.nextInt(3));
				target.knockback(0.35D, this.getX() - target.getX(), this.getZ() - target.getZ());
			}
			if (this.attackTimer == 16 && target.isAlive() && this.distanceTo(target) < 3.0F) {
				target.hurt(this.damageSources().mobAttack(this),
						(float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.85F
								+ target.getArmorValue() * 0.2F);
				target.knockback(0.4D, this.getX() - target.getX(), this.getZ() - target.getZ());
			}
			if (this.attackTimer >= 24) {
				this.endSkill();
			}
		}

		if (this.attackTimer >= 70 && atk != STATE_IDLE) {
			this.endSkill();
		}
	}
}
