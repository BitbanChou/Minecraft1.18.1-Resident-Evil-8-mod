package com.joy187.re8joymod.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;


public class EntityPlagasm extends EntityLycan{

    public EntityPlagasm(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.setItemSlot(EquipmentSlot.HEAD,new ItemStack(Items.CHAINMAIL_HELMET));
        this.xpReward = 20;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().
                add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.MOVEMENT_SPEED, 0.265D).
                add(Attributes.ARMOR, 2D).
                add(Attributes.ARMOR_TOUGHNESS, 2D).
                add(Attributes.ATTACK_DAMAGE, 8D);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.zealot.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.zealot.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.zealot.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.zealot.attack2"));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
        data.add(new AnimationController(this, "controller1",
                0, this::predicate1));
    }


    @Nullable
    protected SoundEvent getAmbientSound() {

        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

}
