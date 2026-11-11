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

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Hunk (EntityHank) — shoot / kick / melee.
 * Animations use triggerAnim (same pattern as Leon/Krauser) so client actually plays them.
 * STATE 1 shoot, 2 kick, 3 melee; air targets stay on shoot + hold distance.
 */
public class EntityHank extends EntityEthan implements GeoEntity {
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityHank.class,
			EntityDataSerializers.INT);

	public static final int STATE_IDLE = 0;
	public static final int STATE_SHOOT = 1;
	public static final int STATE_KICK = 2;
	public static final int STATE_MELEE = 3;

	private static final Predicate<LivingEntity> AREA_HIT = (e) ->
			e.isAlive() && !(e instanceof IronGolem) && !(e instanceof EntityHank);

	public EntityHank(EntityType<? extends IronGolem> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 100;
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
		this.goalSelector.addGoal(1, new HankCombatGoal(this));
		this.goalSelector.addGoal(5, new MoveBackToVillageGoal(this, 0.6D, false));
		this.goalSelector.addGoal(6, new GolemRandomStrollInVillageGoal(this, 0.6D));
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
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == STATE_SHOOT || time == STATE_KICK || time == STATE_MELEE) && prev != time) {
			this.startAttackAnim(time);
		}
	}

	protected void startAttackAnim(int state) {
		if (state == STATE_SHOOT) {
			this.triggerAnim("combat", "shoot");
		} else if (state == STATE_KICK) {
			this.triggerAnim("combat", "kick");
		} else if (state == STATE_MELEE) {
			this.triggerAnim("combat", "melee");
		}
	}

	/** Force-restart shoot anim (anti-air volleys). */
	public void retriggerShootAnim() {
		this.triggerAnim("combat", "shoot");
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

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		// Attack controller: idle STOP + triggerable one-shots (reliable client playback)
		data.add(new AnimationController<>(this, "combat", 3, state -> PlayState.STOP)
				.triggerableAnim("shoot", RawAnimation.begin().thenPlay("animation.hank.attack"))
				.triggerableAnim("kick", RawAnimation.begin().thenPlay("animation.hank.attack2"))
				.triggerableAnim("melee", RawAnimation.begin().thenPlay("animation.hank.attack3")));
		data.add(new AnimationController<>(this, "controller", 4, this::predicate));
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

	private void fireBurstShot(LivingEntity target) {
		EntityBOWShoot shot = new EntityBOWShoot(this.level(), this);
		AerialCombatHelper.aimBowShot(this, shot, target, 15.5F, 0.75F);
		this.level().addParticle(ParticleTypes.FLAME, shot.getX(), shot.getY(), shot.getZ(),
				shot.getDeltaMovement().x, shot.getDeltaMovement().y, shot.getDeltaMovement().z);
		shot.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
		shot.damage *= 1.15F;
		this.level().addFreshEntity(shot);
	}

	static class HankCombatGoal extends Goal {
		private final EntityHank hank;
		private int timer;
		private int chosen;
		private int lastSkill;

		HankCombatGoal(EntityHank hank) {
			this.hank = hank;
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			LivingEntity t = this.hank.getTarget();
			return t != null && t.isAlive();
		}

		@Override
		public boolean canContinueToUse() {
			return this.canUse() || this.hank.getAttckingState() != STATE_IDLE;
		}

		@Override
		public void start() {
			this.timer = 0;
			this.chosen = STATE_IDLE;
			this.hank.setAggressive(true);
		}

		@Override
		public void stop() {
			this.timer = 0;
			this.chosen = STATE_IDLE;
			this.hank.setAttackingState(STATE_IDLE);
			this.hank.setAggressive(false);
			this.hank.getNavigation().stop();
		}

		@Override
		public void tick() {
			LivingEntity target = this.hank.getTarget();
			if (target == null || !target.isAlive()) {
				this.finish();
				return;
			}

			boolean aerial = AerialCombatHelper.isAerialTarget(this.hank, target);
			boolean los = this.hank.hasLineOfSight(target);

			if (aerial) {
				AerialCombatHelper.holdShootDistance(this.hank, target);
			} else {
				this.hank.getLookControl().setLookAt(target, 30.0F, 30.0F);
			}

			if (!los) {
				if (!aerial) {
					this.hank.getNavigation().moveTo(target, 1.1D);
				}
				if (this.chosen != STATE_IDLE) {
					this.finish();
				}
				return;
			}

			++this.timer;

			if (this.chosen == STATE_IDLE) {
				if (!aerial) {
					this.hank.getNavigation().moveTo(target, 1.15D);
				}
				if (this.timer >= (aerial ? 3 : 6)) {
					this.begin(this.pick(target, aerial));
				}
				return;
			}

			this.hank.getNavigation().stop();
			switch (this.chosen) {
				case STATE_SHOOT -> this.tickShoot(target, aerial);
				case STATE_KICK -> this.tickKick(target);
				case STATE_MELEE -> this.tickMelee(target);
				default -> this.finish();
			}
		}

		private int pick(LivingEntity target, boolean aerial) {
			if (aerial) {
				return STATE_SHOOT;
			}
			double dist = this.hank.distanceTo(target);
			if (dist < 3.4D) {
				if (this.lastSkill == STATE_MELEE) {
					return this.hank.getRandom().nextBoolean() ? STATE_KICK : STATE_MELEE;
				}
				if (this.lastSkill == STATE_KICK) {
					return this.hank.getRandom().nextDouble() < 0.65D ? STATE_MELEE : STATE_KICK;
				}
				return this.hank.getRandom().nextDouble() < 0.58D ? STATE_MELEE : STATE_KICK;
			}
			if (dist < 7.5D) {
				int roll = this.hank.getRandom().nextInt(100);
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

		private void begin(int state) {
			this.chosen = state;
			this.lastSkill = state;
			this.timer = 0;
			this.hank.getNavigation().stop();
			this.hank.setAttackingState(state);
		}

		private void finish() {
			this.chosen = STATE_IDLE;
			this.timer = 0;
			this.hank.setAttackingState(STATE_IDLE);
		}

		private void tickShoot(LivingEntity target, boolean aerial) {
			if (aerial) {
				AerialCombatHelper.holdShootDistance(this.hank, target);
			}
			if (this.timer == 6 || this.timer == 12 || this.timer == 18) {
				this.hank.fireBurstShot(target);
			}
			if (this.timer >= 28) {
				if (aerial) {
					// Keep shoot state; re-trigger anim for the next volley.
					AerialCombatHelper.ensureShootState(this.hank::getAttckingState, this.hank::setAttackingState, STATE_SHOOT);
					this.hank.retriggerShootAnim();
					this.timer = 0;
				} else {
					this.finish();
				}
			}
		}

		private void tickKick(LivingEntity target) {
			if (this.timer >= 8 && this.timer <= 11) {
				this.hank.dashToward(target, 0.55D);
			}
			if (this.timer == 12) {
				for (LivingEntity lvt : this.hank.level().getEntitiesOfClass(LivingEntity.class,
						this.hank.getBoundingBox().inflate(2.6D), AREA_HIT)) {
					lvt.hurt(this.hank.damageSources().mobAttack(this.hank),
							(float) this.hank.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.95F
									+ lvt.getArmorValue() * 0.25F);
					lvt.knockback(0.55D, this.hank.getX() - lvt.getX(), this.hank.getZ() - lvt.getZ());
				}
			}
			if (this.timer >= 34) {
				this.finish();
			}
		}

		private void tickMelee(LivingEntity target) {
			if (this.timer >= 5 && this.timer <= 9) {
				this.hank.dashToward(target, 0.7D);
			}
			if (this.timer == 10 && target.isAlive() && this.hank.distanceTo(target) < 3.0F) {
				target.hurt(this.hank.damageSources().mobAttack(this.hank),
						(float) this.hank.getAttributeValue(Attributes.ATTACK_DAMAGE)
								+ this.hank.getRandom().nextInt(3));
				target.knockback(0.35D, this.hank.getX() - target.getX(), this.hank.getZ() - target.getZ());
			}
			if (this.timer == 16 && target.isAlive() && this.hank.distanceTo(target) < 3.0F) {
				target.hurt(this.hank.damageSources().mobAttack(this.hank),
						(float) this.hank.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.85F
								+ target.getArmorValue() * 0.2F);
				target.knockback(0.4D, this.hank.getX() - target.getX(), this.hank.getZ() - target.getZ());
			}
			if (this.timer >= 24) {
				this.finish();
			}
		}
	}
}
