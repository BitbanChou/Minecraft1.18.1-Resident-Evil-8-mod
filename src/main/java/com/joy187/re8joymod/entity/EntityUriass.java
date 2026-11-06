package com.joy187.re8joymod.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityUriass extends EntityUrias implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityUriass.class,
			EntityDataSerializers.INT);
	
    public EntityUriass(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 100;
        //SpawnPlacements.register(EntityInit.FRANK1.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 120.0D).
                add(Attributes.MOVEMENT_SPEED, 0.23D).
                add(Attributes.FOLLOW_RANGE, 30.0D).
                add(Attributes.ARMOR, 12.0D).
                add(Attributes.ARMOR_TOUGHNESS, 30.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 24.0D);
    }
    
//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if (event.isMoving()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.walk"));
//            return PlayState.CONTINUE;
//        }
//
//
//        event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.idle"));
//        return PlayState.CONTINUE;
//    }
//
//	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
//		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.attack"));
//			return PlayState.CONTINUE;
//		}
//		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.attack2"));
//			return PlayState.CONTINUE;
//		}
//		return PlayState.STOP;
//	}

	private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {

		// 检测生物是否死亡
//		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("death")); // 播放死亡动画
//			return PlayState.CONTINUE;
//		}

		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.walk"));
			return PlayState.CONTINUE;
		}

		event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.idle"));
		return PlayState.CONTINUE;
	}

	public static <T extends EntityUriass & GeoAnimatable> AnimationController<T> genericAttackAnimation(T animatable, RawAnimation attackAnimation) {
		return new AnimationController<>(animatable, "Attack", 0, event -> {
			if (attackAnimationState.isStarted() && !(animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.attack"));

				return PlayState.CONTINUE;
			}
			if (attackAnimationState2.isStarted() && !(animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.strajer.attack2"));

				//return PlayState.CONTINUE;
			}

			event.getController().forceAnimationReset();
			return PlayState.CONTINUE;
		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller",
				0, this::predicate));
		data.add(genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE));

	}

//    @Override
//	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.add(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.add(new AnimationController(this, "controller1",
//                0, this::predicate1));
//	}
    
    
	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
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
	
	
}
