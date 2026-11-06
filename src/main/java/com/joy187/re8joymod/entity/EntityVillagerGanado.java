package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.LycanVariant;
import com.joy187.re8joymod.entity.variant.VillagerGanadoVariant;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityVillagerGanado extends EntityLycan{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityVillagerGanado(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D).
                add(Attributes.MOVEMENT_SPEED, 0.26D).
                add(Attributes.ATTACK_DAMAGE, 5.5D);
    }

    protected PathNavigation createNavigation(Level p_33802_) {
        return new WallClimberNavigation(this, p_33802_);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
//        {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.death2"));
//            return PlayState.CONTINUE;
//        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.death"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.attack2"));
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

    public VillagerGanadoVariant getVariant1() {
        return VillagerGanadoVariant.byId(this.getTypeVariant() & 255);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(this.getHealth()>1.0F && this.getHealth()<5.0F && (this.random.nextFloat()<0.25)){
            EntityPlagasVillager e=new EntityPlagasVillager(EntityInit.PLAGASVILLAGER.get(),this.level());
            e.copyPosition(this);
            this.discard();
            this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            this.level().addFreshEntity(e);
        }

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_GANADO_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_GANADO_AMBIENT2.get();
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_HURT;
    }
}
