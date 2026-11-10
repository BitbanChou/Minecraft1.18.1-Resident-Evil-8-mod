package com.joy187.re8joymod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Urias Strajer variant — same combat state machine as Urias, but more aggressive:
 * higher charge rate, ~50% max-HP charge damage, and charge blockSmash pulses.
 */
public class EntityUriass extends EntityUrias implements GeoEntity {
	private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityUriass(EntityType<? extends Ravager> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 100;
	}

	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 120.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23D)
				.add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ARMOR, 12.0D)
				.add(Attributes.ARMOR_TOUGHNESS, 30.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.85D)
				.add(Attributes.ATTACK_DAMAGE, 24.0D);
	}

	@Override
	protected int getChargeChance() {
		return 58;
	}

	@Override
	protected double getChargeMinDist() {
		return 5.5D;
	}

	@Override
	protected double getChargeMaxDist() {
		return 20.0D;
	}

	@Override
	protected double getChargeDashSpeed() {
		return 1.55D;
	}

	@Override
	protected float getChargeAttackDamage(LivingEntity target) {
		// Brutal charge: weapon hit + 50% of target max HP
		return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.85F
				+ target.getMaxHealth() * 0.5F;
	}

	@Override
	protected double getChargeKnockback() {
		return 1.45D;
	}

	@Override
	protected boolean chargeUsesBlockSmash() {
		return true;
	}

	@Override
	protected boolean chargeDamageOncePerTarget() {
		return true;
	}

	@Override
	protected void performChargeBlockSmash() {
		// Forward smash AOE / shield-break / launch (HP% kept modest; main 50% is on direct charge hit)
		for (int l = 1; l < 10; l++) {
			this.blockSmashAttack(l, 4.0F, 0.0F, 180, 2.0F, 0.08F, 1.35F);
			this.blockSmashAttack(l, 4.0F, 1.5F, 180, 1.7F, 0.06F, 1.2F);
			this.blockSmashAttack(l, 4.0F, -1.5F, 180, 1.7F, 0.06F, 1.2F);
			this.blockSmashAttack(l, 4.0F, 2.8F, 180, 1.45F, 0.05F, 1.05F);
			this.blockSmashAttack(l, 4.0F, -2.8F, 180, 1.45F, 0.05F, 1.05F);
			this.blockSmashAttack(l, 4.0F, 4.2F, 180, 1.25F, 0.04F, 0.95F);
			this.blockSmashAttack(l, 4.0F, -4.2F, 180, 1.25F, 0.04F, 0.95F);
		}
	}

	@Override
	protected String animWalk() {
		return "animation.strajer.walk";
	}

	@Override
	protected String animIdle() {
		return "animation.strajer.idle";
	}

	@Override
	protected String animRecover() {
		return "animation.strajer.recover";
	}

	@Override
	protected String animSlash() {
		return "animation.strajer.attack";
	}

	@Override
	protected String animHeavy() {
		return "animation.strajer.attack2";
	}

	@Override
	protected String animCharge() {
		return "animation.strajer.charge";
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.factory;
	}
}
