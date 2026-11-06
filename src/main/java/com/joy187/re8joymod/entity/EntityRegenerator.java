package com.joy187.re8joymod.entity;

import com.google.common.collect.ImmutableList;
import com.joy187.re8joymod.entity.variant.LycanVariant;
import com.joy187.re8joymod.entity.variant.RegeneratorVariant;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.items.ItemShield;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EntityRegenerator extends EntityDund2 implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(EntityRegenerator.class, EntityDataSerializers.INT);
    protected int attackTimer = 0;

	public EntityRegenerator(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 55;
	}
	
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new DundAttackGoal(this, 1.0D,false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
     }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 0.1D).
                add(Attributes.ARMOR_TOUGHNESS, 0.1D).
                add(Attributes.ATTACK_DAMAGE, 6.5D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }
    
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        this.heal(0.5f+this.random.nextFloat());

        return flag;
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
    	    if(this.getHealth()>=this.getMaxHealth()*0.5)
            {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.walk"));
                return PlayState.CONTINUE;
            }
            else{
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.walk2"));
                return PlayState.CONTINUE;
            }
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.attack2"));
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
	
	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(this.getHealth()<this.getMaxHealth()*0.6){
            this.setVariant(RegeneratorVariant.MID);
        }

        if(this.getHealth()<this.getMaxHealth()*0.3){
            this.setVariant(RegeneratorVariant.LOW);
        }

        if(this.getHealth()<0.5 && this.random.nextFloat()<0.15 && !(this instanceof EntityRegenerator2)){
            this.convertTo(EntityInit.REGENERATOR2.get(),true);
        }
        //System.out.println(this.getHealth());
    }

	@Override
    public boolean hurt(DamageSource p_37849_, float p_37850_)
    {
        if (!level().isClientSide()) {
            boolean isHurt = true;
            if (p_37849_ != damageSources().fellOutOfWorld() && p_37850_ > 1.0F) {
                this.hurt(p_37849_,1F);
            }
            //System.out.println(isHurt);
            if(isHurt)
                return super.hurt(p_37849_,1);
        }
        return false;
    }

    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityRegenerator);
    };

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    public RegeneratorVariant getVariant() {
        return RegeneratorVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RegeneratorVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && this.hasLineOfSight(livingentity)) {
            Level world = this.level();
            ++this.attackTimer;
            Random rand = new Random();
            Vec3 vector3d = this.getViewVector(1.0F);
            double d0 = Math.min(livingentity.getY(), livingentity.getY());
            double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
            double d2 = livingentity.getX() - (this.getX() + vector3d.x * 2.0D);
            double d3 = livingentity.getY(0.5D) - (0.5D + this.getY(0.5D));
            double d4 = livingentity.getZ() - (this.getZ() + vector3d.z * 2.0D);
            float f = (float) Mth.atan2(livingentity.getZ() - this.getZ(),
                    livingentity.getX() - this.getX());

            this.getNavigation().moveTo(livingentity, 1.1D);
            if (this.attackTimer == 5) {
                if (this.random.nextDouble() > 0.4)
                    this.setAttackingState(1);
                else
                    this.setAttackingState(2);
            }

            if (this.attackTimer == 15 && this.distanceTo(livingentity) < 3f && this.getAttckingState() == 1) {
                livingentity.hurt(livingentity.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
            }

            if (this.attackTimer == 15 && this.distanceTo(livingentity) < 2f && this.getAttckingState() == 2) {
                livingentity.hurt(livingentity.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
            }

            if (this.attackTimer == 20 && this.getAttckingState() == 2) {
                for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                    int val = lvt.getArmorValue();
                    if (lvt instanceof Player && ((Player) lvt).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(lvt, 50);
                    } else
                        lvt.hurt(lvt.damageSources().cactus(), val * (rand.nextInt(2) + 1) + lvt.getMaxHealth() * 0.2f);
                    this.heal(0.6f + this.random.nextFloat());
                }
            }

            if (this.attackTimer >= 21) {
                for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                    int val = lvt.getArmorValue();
                    if (lvt instanceof Player && ((Player) lvt).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(lvt, 50);
                    } else
                        lvt.hurt(lvt.damageSources().cactus(), lvt.getMaxHealth() * 0.015f);
                }
            }

            if (this.attackTimer == 35) {
                this.setAttackingState(0);
                this.attackTimer = -5;
            }
            this.lookAt(livingentity, 30.0F, 30.0F);
        } else if (this.attackTimer > 0) {
            --this.attackTimer;
        }

    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(3+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }
}
