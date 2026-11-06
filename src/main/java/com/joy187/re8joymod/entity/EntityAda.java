package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.GolemRandomStrollInVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.OfferFlowerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityAda extends EntityChris{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	
    public EntityAda(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 4D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 6.0D);
    }
    
    protected void registerGoals() {
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D,true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new OfferFlowerGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityChris.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    
    
    protected void customServerAiStep() {

        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20,1,false,true));
        }
        else if(this.getHealth()<8.0F){
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,1,false,true));
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20,0,false,false));
        }
        
        super.customServerAiStep();
    }
        
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.HARM, 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));
            
            if(p_70652_1_ instanceof EntityMiranda1 || p_70652_1_ instanceof EntityMiranda2
            || p_70652_1_ instanceof EntityMiranda3 || p_70652_1_ instanceof EntityMiranda4
            || p_70652_1_ instanceof EntityRe8Dimi || p_70652_1_ instanceof EntityMuHeisen) {
                this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*3,1,false,true));
            }
        }

        return flag;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {

        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_ADA_AMBIENT1.get();
        }
        else if(co==1){
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
        int co = ran.nextInt(2);
        if(co==1){
            return SoundInit.ENTITY_ADA_DEATH.get();
        }
        return SoundInit.ENTITY_BELA_DEATH.get();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
    	
    	if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada.attack2"));
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

	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
}
