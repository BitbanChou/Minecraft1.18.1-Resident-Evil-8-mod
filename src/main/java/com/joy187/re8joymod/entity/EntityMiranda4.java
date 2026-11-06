package com.joy187.re8joymod.entity;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
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
import net.minecraft.world.Difficulty;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class EntityMiranda4 extends Ravager{

	private int defendflag=0;
    private int explosionPower = 2,randtick=0;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMiranda4.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMiranda4.class,
			EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityMiranda4.class, EntityDataSerializers.BYTE);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
     
    public EntityMiranda4(EntityType<? extends Ravager> type, Level worldIn) {
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
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 320.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27000001192092896D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 30.0D).
                add(Attributes.ARMOR_TOUGHNESS, 50.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).
                add(Attributes.ATTACK_DAMAGE, 10.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
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

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }


    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_33820_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_33820_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                int i = 0;
                Random ran = new Random();
                int co = ran.nextInt(7);
                this.randtick=co;
                if(this.level().getDifficulty()== Difficulty.NORMAL)
                {
                    i=7;
                }
                else if(this.level().getDifficulty()== Difficulty.HARD)
                {
                    i=12;
                }
                if(i>0){
                    if(co<4){
                        if (!entityIn.hasPassenger(this) && !(entityIn instanceof EnderDragon)
                                && entityIn.getBbWidth() < 2.81F){
                            (entityIn).stopRiding();
                            (entityIn).startRiding(this, true);
                        }
                    }

                    if(co==0 || co==1) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, i*10,1,true,true));
                    else if(co==2 || co==3 || co==4) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, i*4,1,true,true));
                    else if(co==5) {
                        this.level().explode(null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
                        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, i*10,0,true,true));
                    }
                    else {
                        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40,2,true,true));
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.BURN.get(), 60,2,true,true));
                        this.level().addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
                        this.spawnSoulSpeedParticle();
                    }
                }
                if(i+co>=12){
                    this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60,4,true,true));
                    if(i+co==13) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 40,2,true,true));
                }
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
	                this.heal(2.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }
	
	        if(this.getHealth() >= 270.0F && this.getHealth()<=285.0F)
	        {
	        	if(this.defendflag==0)
	        	{
		        	defend();
		            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*5,10,true,true));
		            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*5,10,true,true));	
		            this.defendflag=1;
	        	}
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
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }
	    
    private void defend() {
        if (this.isAlive()) {

           Vec3 vec3 = this.getBoundingBox().getCenter();

//           for(int i = 0; i < 40; ++i) {
//              double d0 = this.random.nextGaussian() * 0.2D;
//              double d1 = this.random.nextGaussian() * 0.2D;
//              double d2 = this.random.nextGaussian() * 0.2D;
//              this.level().addParticle(ParticleTypes.DRIPPING_LAVA, vec3.x, vec3.y, vec3.z, d0, d1, d2);
//           }
           for(int j=0;j<3;j++)
           {
	           for (int i = 0; i < 10; i++)
	           {
	               float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
	               Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 1 * Math.cos(0 + deltaOmega));
	               //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
	               this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
	           }           	   
           }

           this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

     }

    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = 3F;
            float pullIn = 0.5F;
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            if (this.randtick <= 3) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity)passenger).getMaxHealth()*0.4F);
                passenger.stopRiding();
            }
        }
    }

}
