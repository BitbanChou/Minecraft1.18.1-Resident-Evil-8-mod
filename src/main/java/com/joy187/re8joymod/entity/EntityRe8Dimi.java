package com.joy187.re8joymod.entity;


import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;


import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import com.joy187.re8joymod.entity.EntityDimi2;
public class EntityRe8Dimi extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityRe8Dimi.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityRe8Dimi.class,
			EntityDataSerializers.INT);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
    public int attr = 0,raise=0;

    public EntityRe8Dimi(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
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
                this.level().addParticle(ParticleTypes.EFFECT, pos.x, pos.y, pos.z, this.random.nextGaussian()*0.07,0.1,this.random.nextGaussian()*0.07);
            }
        }

        if(this.attr>=15 && this.attr<=20 && this.getAttckingState()==2){
            this.level().addParticle(ParticleTypes.SWEEP_ATTACK, this.position().x, this.position().y+1D, this.position().z, this.random.nextGaussian()*0.07,0.1,this.random.nextGaussian()*0.07);
        }


    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 120.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
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
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 20,0,true,true));
            }
            return true;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_DEATH1.get();
        }
        else if(co==1) return SoundInit.ENTITY_DIMI_DEATH2.get();
        return SoundEvents.BEE_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_AMBIENT1.get();
        }
        return  SoundInit.ENTITY_DIMI_AMBIENT2.get();
        //return SoundEvents.ZOMBIE_AMBIENT;
    }
//
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_HURT1.get();
        }
        return SoundInit.ENTITY_DIMI_HURT2.get();
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
	
	        if(this.isSunSensitive()){
	            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*10,1,true,true));
	        }
	
	        Random ran = new Random();
	        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.0F*ran.nextFloat());
	        }
	
	        if(this.getHealth() >= 60.0F && this.getHealth()<=65.0F)
	        {
	            for(int i=0;i<4;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }
	
	        if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
	        {
	            this.convertTo(EntityInit.DIMI2.get(),true);
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
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.walk"));
            return PlayState.CONTINUE;
        }
        Random ran = new Random();
        int co = ran.nextInt(30);
        if(co==1) {
        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.attack2"));
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
        private final EntityRe8Dimi parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityRe8Dimi mob) {
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
                  this.parentEntity.attr=attackTimer;
                  Random rand = new Random();
                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                          livingentity.getX() - parentEntity.getX());


                  if (this.attackTimer == 10) {
                      if((this.parentEntity.getHealth() > 40 && this.parentEntity.getHealth()<55) ||
                              (this.parentEntity.getHealth() > 105 && this.parentEntity.getHealth()<120) ||
                              (this.parentEntity.getHealth() > 75 && this.parentEntity.getHealth()<90) ||
                              (this.parentEntity.getHealth() > 60 && this.parentEntity.getHealth()<70) ||
                              (this.parentEntity.getHealth()> 20 && this.parentEntity.getHealth()<35)){
                          this.parentEntity.setAttackingState(1);
                          this.parentEntity.getNavigation().moveTo(livingentity, 0.8D);
                          if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
                                  && livingentity.getBbWidth() < 1.81F){
                              livingentity.stopRiding();
                              livingentity.startRiding(this.parentEntity, true);
                          }
                      }
                      else{
                          this.parentEntity.getNavigation().stop();
                          this.parentEntity.setAttackingState(2);
                      }
                  }

                  if(this.attackTimer==20 && this.parentEntity.getAttckingState()==2){
                      for(int l = 1; l < 20; l++)
                      {
                          this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.2F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.2F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.2F, 1.0F);
                      }

                  }

                 if(this.attackTimer>20 && this.attackTimer<24 && this.parentEntity.getAttckingState()==2){
                     this.parentEntity.roar();
                 }

                 if(this.attackTimer==40 && this.parentEntity.random.nextInt(100)<20){
                    for(int i=0;i<3;i++) this.parentEntity.transformToBat(livingentity);
                 }

                 if (this.attackTimer == 45) {
                       this.parentEntity.setAttackingState(0);
                       this.parentEntity.raise++;
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

    public void transformToBat(LivingEntity target) {
        // 变身为蝙蝠的逻辑
        //this.convertTo(EntityInit.FLY.get(),false);
        EntityFly f = EntityFly.create(this.level(),null,10,100,this.getX(),this.getY(),this.getZ());
        f.moveTo(this.getX(), this.getY()+0.3, this.getZ()); // 移动到当前位置
        f.setTarget(target);
        this.level().addFreshEntity(f);
    }

    @Override
    public void positionRider(Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            moveFunction.accept(passenger, getX(), getY() - 0.1f, getZ());
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = this.attr < 5 ? 0 : Math.min((this.attr * 3 - 30) * 0.2, 5.2F);
            float pullIn = this.attr < 15 ? 0 : Math.min((this.attr - 15) * 0.15F, 0.75F);
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            if (this.attr == 25) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity)passenger).getMaxHealth()*0.25F);
                passenger.stopRiding();
            }
        }
    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);

        AABB selection = new AABB(px - 1, minY, pz - 1, px + 1, maxY, pz + 1);
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (Object entity : hit) {
            if(entity instanceof LivingEntity)
            {
                if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityHeisen || (LivingEntity)entity == this) continue;
                if (entity instanceof Player && ((Player)entity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
                    this.disableShield((LivingEntity)entity, shieldbreakticks);
                }
                else{
                    boolean flag = ((LivingEntity)entity).hurt(damageSources().mobAttack(this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(((LivingEntity)entity).getMaxHealth() * hpdamage)));
                    if(flag)
                        ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, airborne*0.2, 0.0));
                }

            }
        }

    }

    private void roar() {
        if (this.isAlive()) {

            Vec3 vec3 = this.getBoundingBox().getCenter();
            for (int i = 0; i < 5; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);

                this.level().addParticle(ParticleTypes.EXPLOSION_EMITTER, pos.x, pos.y, pos.z, 0,0,0);
            }
            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
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
