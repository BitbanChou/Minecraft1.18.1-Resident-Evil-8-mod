package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.ArmaduraVariant;
import com.joy187.re8joymod.entity.variant.SoldiVariant;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.Random;

public class EntitySoldi extends EntityLycan{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntitySoldi(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 30;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D).
                add(Attributes.MOVEMENT_SPEED, 0.262D).
                add(Attributes.ATTACK_DAMAGE, 6D);
    }

    protected PathNavigation createNavigation(Level p_33802_) {
        return new WallClimberNavigation(this, p_33802_);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.frank3.attack2"));
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
        data.add(new AnimationController(this, "controller1",
                0, this::predicate1));
    }

    public SoldiVariant getVariant1() {
        return SoldiVariant.byId(this.getTypeVariant() & 255);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity && this.random.nextDouble()<0.25D)
            {
                float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
                if (entityIn instanceof Player && ((Player)entityIn).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                    this.disableShield((LivingEntity)entityIn, 20);
                }
                else{
                    ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.STUN.get(), 100 * (int)f,0,true,true));
                }
            }
            return true;
        }
        //System.out.println(attackTick);
        //System.out.println(attackTick);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

//        if(this.getHealth()>1.0F && this.getHealth()<5.0F && (this.random.nextFloat()<0.25)){
//            EntityPlagasVillager e=new EntityPlagasVillager(EntityInit.PLAGASVILLAGER.get(),this.level());
//            e.copyPosition(this);
//            this.discard();
//            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
//            this.level().addFreshEntity(e);
//        }

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        //ArmaduraVariant variant = Util.getRandom(ArmaduraVariant.values(), this.random);
        int co=this.random.nextInt(3);
        if(co==1){
            this.getAttribute(Attributes.ARMOR).setBaseValue(3.0D);
        }
        else if(co==2){
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        }

        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_SOLDI_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_SOLDI_AMBIENT2.get();
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_HURT;
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(4+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }
}
