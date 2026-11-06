package com.joy187.re8joymod.entity;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityMiranda2 extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public int explosionPower = 1;

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMiranda2.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMiranda2.class,
			EntityDataSerializers.INT);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
     
    public EntityMiranda2(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 280;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

   
    protected boolean isSunSensitive() {
        return true;
    }
    
    public void aiStep() {
        super.aiStep();
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==1)
        {
            //this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleTypes.ENTITY_EFFECT, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 280.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.KNOCKBACK_RESISTANCE,0.99D).
                add(Attributes.ATTACK_DAMAGE, 8.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new AttackGoal(this));
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


    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            Random ran = new Random();
            int co = ran.nextInt(7);
            if(co==1 || co==2 || co==3) {
                if(entityIn instanceof LivingEntity)
                {
                    ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100,1,true,true));
                }
                if(entityIn instanceof Player || entityIn instanceof IronGolem || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris || entityIn instanceof EntityMuHeisen){
                    this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100,1,true,true));
                    this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100,1,true,true));
                }
            }
            else if(co==4) {
                if (entityIn instanceof Player || entityIn instanceof IronGolem || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris)
                {
                    this.addEffect(new MobEffectInstance(MobEffects.JUMP, 20,2,true,true));
                    this.level().explode((Entity)null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
                    this.level().addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 100,1,false,true));
            }
            else if(co==5){
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20*2,1,false,true));
            }
            else {
                if(co==0) {
                    ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,3,false,true));
                    this.level().addParticle(ParticleTypes.FLASH, this.getX()+ran.nextFloat(), this.getY(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                else ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*3,1,false,true));
            }

            return true;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_DEATH1.get();
        }
        return SoundInit.ENTITY_MIRA_DEATH2.get();
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_AMBIENT1.get();
        }
        else if(co==1) return  SoundInit.ENTITY_MIRA_AMBIENT3.get();
        return SoundInit.ENTITY_MIRA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_HURT1.get();
        }
        return SoundInit.ENTITY_MIRA_HURT2.get();
    }
    
    public int getInvulnerableTicks() {
        return 200;
     }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 3F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        this.entityData.set(DATA_ID_INV, p_82215_1_);
    }
     
    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable Component p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void customServerAiStep() {
    	
	        super.customServerAiStep();
	
	        Random ran = new Random();
	        if(this.getHealth() >= 10.0F && this.getHealth()<=18.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(3.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 50.0F && this.getHealth()<=58.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(2.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 135.0F && this.getHealth()<=140.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1F*ran.nextFloat());
	        }


	
	        if(this.getHealth() >= 1.0F && this.getHealth()<=7.0F)
	        {
	            this.convertTo(EntityInit.MIRANDA3.get(),true);
	        }
	
	        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());        	
        }

    //}

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossInfo.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
     }

  
    public boolean isNonBoss()
    {
        return false;
    }

    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.walk"));
            return PlayState.CONTINUE;
        }
        Random ran = new Random();
        int co = ran.nextInt(30);
        if(co==1) {
        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.idle2"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.attack2"));
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
	
    static class AttackGoal extends Goal {
        private final EntityMiranda2 parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityMiranda2 mob) {
             this.parentEntity = mob;
        }

        public boolean canUse() {
             return this.parentEntity.getTarget() != null;
        }

        public void start() {
             super.start();
             this.parentEntity.setAggressive(true);
        }

        @Override
        public void stop() {
             super.stop();
             this.parentEntity.setAggressive(false);
             this.parentEntity.setAttackingState(0);
             this.attackTimer = -1;
        }

        public void tick() {
             LivingEntity livingentity = this.parentEntity.getTarget();
             if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
                  Level world = this.parentEntity.level();
                  ++this.attackTimer;
                  Random rand = new Random();
                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                          livingentity.getX() - parentEntity.getX());

                  this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                  if (this.attackTimer == 10) {
                	  if((this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.8 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.9)) 
                	  || (this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.4 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.5))
                	  || (this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.2 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHeadYRot()*0.3)))
                	  {
	                      this.parentEntity.setAttackingState(2);
	                      this.parentEntity.attackAnim=2;                		  
                	  }
	                  else{
	                	  this.parentEntity.setAttackingState(1);
	                      this.parentEntity.attackAnim=1;
	                  }
                  } 
                  if (this.attackTimer == 30) {
                       this.parentEntity.setAttackingState(0);
                       this.attackTimer = -5;
                  }
                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

             } 
             else if (this.attackTimer > 0) {
                  --this.attackTimer;
                  
             }
             //System.out.println(this.parentEntity.attackAnim);
        }

   }
    
}
