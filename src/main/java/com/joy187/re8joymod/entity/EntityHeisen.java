package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.phys.AABB;
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

public class EntityHeisen extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	private boolean canBreakDoors;
    public boolean playAttackAnimation = false;
    public int attackTick=1,pre=0;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityHeisen.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityHeisen.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityHeisen.class,
			EntityDataSerializers.INT);
	
	private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
	   private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (mode) -> {
		      return mode == Difficulty.HARD || mode == Difficulty.NORMAL;
		   };
		   
	public EntityHeisen(EntityType<? extends Ravager> type, Level worldIn) {
		super(type, worldIn);
        this.isNonBoss();
        this.xpReward = 350;
	}
	
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }
    
    protected void addBehaviourGoals() {
		this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new HeisenAttackGoal(this, 1.0D,false));
        //this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
     }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 20.0D).
                add(Attributes.ARMOR_TOUGHNESS, 15.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
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
		this.entityData.define(DEFENDSTATE, 0);
	}

	public int getDefendingState() {
		return this.entityData.get(DEFENDSTATE);
	}
	
	public void setDefendingState(int time) {
		this.entityData.set(DEFENDSTATE, time);
	}
    
    protected void customServerAiStep() {
    	super.customServerAiStep();  
    	if(this.getHealth() >= 0.1F && this.getHealth()<=7.0F)
        {
            this.convertTo(EntityInit.MUHEISEN.get(),true);
        }
                  
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());

    }

    private void defend() {
        if (this.isAlive()) {

           Vec3 vec3 = this.getBoundingBox().getCenter();

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
    
	@Override
	protected void updateControlFlags() {
		boolean flag = this.getTarget() != null && this.hasLineOfSight(this.getTarget());
		this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
		super.updateControlFlags();
	}
	
    static class HeisenAttackGoal extends MeleeAttackGoal {
        private final EntityHeisen zombie;

        public HeisenAttackGoal(EntityHeisen entity, double p_i46803_2_, boolean p_i46803_4_) {
            super(entity, p_i46803_2_, p_i46803_4_);
            this.zombie=entity;
        }
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
//        {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.Heisen.death"));
//            return PlayState.CONTINUE;
//        }
//    	if(this.entityData.get(STATE)!=0)
//    	{
//			if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//				event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.attack"));
//				System.out.println("Hammer strike!");
//				return PlayState.CONTINUE;
//			}
//			else if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//				event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.attack2"));
//				return PlayState.CONTINUE;
//			}    	
//			return PlayState.STOP;
//    	}
		if(this.entityData.get(STATE)==0)
    	{
	    	if (event.isMoving()) {
	            event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.walk"));
	            return PlayState.CONTINUE;
	        }
    	}
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.idle"));
        return PlayState.CONTINUE;  
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.attack"));
			//System.out.println("Hammer strike!");
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.attack2"));
			return PlayState.CONTINUE;
		}
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.heisen.attack3"));
            return PlayState.CONTINUE;
        }
		return PlayState.STOP;
	}
	
    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 1.5F;
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
	
    public void aiStep() {
        super.aiStep();

        if(this.entityData.get(DEFENDSTATE)==1) {
     	   //System.out.println("DEFEND!");
     	   this.defend();
        }

    }
    
    static class AttackGoal extends Goal {
        private final EntityHeisen parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityHeisen mob) {
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
//                  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
//                  {
                	  ++this.attackTimer;
//                  }
//                  else {
//       	               this.parentEntity.setDefendingState(0);
//                  }
                  Random rand = new Random();
                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                          livingentity.getX() - parentEntity.getX());

                  if (this.attackTimer == 5) {
                	  if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.80) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.93))
                		|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.62) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.72))
                              || (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.35) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.47)))
                      {
                          this.parentEntity.setAttackingState(2);
                          this.parentEntity.getNavigation().stop();
                          //this.parentEntity.addEffect();
                      }
                      else if((parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.15D)) ||
                              (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.48) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.6))
                      ||     (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.23) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.32))){
                          this.parentEntity.setAttackingState(1);
                          this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                      }
                      else{
                          this.parentEntity.setAttackingState(3);
                          this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+14*1,this.parentEntity.getY()+1.5,this.parentEntity.getZ()+14*Mth.sqrt(3),4);
                      }
                    //System.out.println(this.attackTimer+" "+this.parentEntity.getAttckingState());
                  }

                 if(this.attackTimer==15 && this.parentEntity.getAttckingState()==3){
                     this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+14*1,this.parentEntity.getY(),this.parentEntity.getZ()-14*Mth.sqrt(3),2);
                 }

                 if(this.attackTimer==25 && this.parentEntity.getAttckingState()==3){
                     this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()-14*1,this.parentEntity.getY()+1.5,this.parentEntity.getZ()-14*Mth.sqrt(3),4);
                 }

                 if(this.attackTimer==35 && this.parentEntity.getAttckingState()==3){
                     this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()-14*1,this.parentEntity.getY()+0.5,this.parentEntity.getZ(),4);
                     this.parentEntity.spawnGroundEffects();
                     for (Entity entity : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2.0D))) {
                         if (!this.parentEntity.isAlliedTo(entity) && !(entity instanceof EntityHeisen) && entity != this.parentEntity) {
                             entity.hurt(entity.damageSources().mobAttack(this.parentEntity), 8.0F + rand.nextFloat() );
                             this.parentEntity.launch(entity, true);
                         }
                     }
                 }

                 if(this.attackTimer==43 && this.parentEntity.getAttckingState()==3){
                     this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+14*1,this.parentEntity.getY(),this.parentEntity.getZ()+14*Mth.sqrt(3),4);
                     this.parentEntity.spawnGroundEffects();
                     for (Entity entity : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2.0D))) {
                         if (!this.parentEntity.isAlliedTo(entity) && !(entity instanceof EntityHeisen) && entity != this.parentEntity) {
                             entity.hurt(entity.damageSources().mobAttack(this.parentEntity), livingentity.getMaxHealth()*0.25f + rand.nextFloat());
                             this.parentEntity.launch(entity, true);
                         }
                     }

                         for(int i = 0; i < 5; ++i) {
                             float f1 = f + (float)i * (float)Math.PI * 0.4F;
                             EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
                                     BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
                             this.parentEntity.level().addFreshEntity(fallingBlockEntity);
                         }

                         for(int k = 0; k < 8; ++k) {
                             float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
                             EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
                                     BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
                             this.parentEntity.level().addFreshEntity(fallingBlockEntity);
                         }

                 }

                 if(this.attackTimer==25 && this.parentEntity.getAttckingState()==1 && this.parentEntity.distanceTo(livingentity) < 3F){
                     livingentity.hurt(livingentity.damageSources().onFire(), 9.0F);
                 }

                  if(this.attackTimer==42 && this.parentEntity.getAttckingState()==1 && this.parentEntity.distanceTo(livingentity) < 3F){
                      //livingentity.hurt(livingentity.damageSources().ON_FIRE, 9.0F);
                      this.parentEntity.ironQuake(4.25f, 2);
                      this.parentEntity.ironQuakeParticle();
                  }

                  if(this.attackTimer==40 && this.parentEntity.getAttckingState()==2){

                      for(int l = 1; l < 10; l++)
                      {
                          this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 5.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -5.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 6.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -6.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 7.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -7.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 8.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -8.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, 9.5F, 150, 1.5F, 0.15F, 1.0F);
                          this.parentEntity.blockSmashAttack(l, 3F, -9.5F, 150, 1.5F, 0.15F, 1.0F);
                      }
                  }

                  if (this.attackTimer == 45) {
                       this.parentEntity.setAttackingState(0);
       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,10,true,true));
    	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*3,10,true,true));	       	          
                       //System.out.println("DD");
    	               this.attackTimer = -5;
                  }
                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

             }
             else if (this.attackTimer > 0) {
                 --this.attackTimer;
            }
             //System.out.println(this.attackTimer);
        }
   }

    public void spawnGroundEffects() {
        float radius = 2.3F;
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 20 + random.nextInt(12); i1++) {
                double motionX = getRandom().nextGaussian() * 0.07D;
                double motionY = getRandom().nextGaussian() * 0.07D;
                double motionZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = radius * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.8F;
                double extraZ = radius * Mth.cos(angle);
                BlockPos ground = getGround(new BlockPos(Mth.floor(this.getX() + extraX), Mth.floor(this.getY() + extraY) - 1, Mth.floor(this.getZ() + extraZ)));
                BlockState BlockState = this.level().getBlockState(ground);
                if (BlockState.getBlock() instanceof AirBlock) {
                    if (level().isClientSide) {
                        level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, BlockState), true, this.getX() + extraX, ground.getY() + extraY, this.getZ() + extraZ, motionX, motionY, motionZ);
                    }
                }
            }
        }
    }

    private void launch(Entity e, boolean huge) {
        if (e.onGround()) {
            double d0 = e.getX() - this.getX();
            double d1 = e.getZ() - this.getZ();
            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
            float f = huge ? 2F : 0.5F;
            e.push(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
        }
    }

    private BlockPos getGround(BlockPos in) {
        BlockPos position = new BlockPos(in.getX(), this.getBlockY(), in.getZ());
        while (position.getY() > -62 && !level().getBlockState(position).isSolid() && level().getFluidState(position).isEmpty()) {
            position = position.below();
        }
        return position;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_HESEN_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_HESEN_AMBIENT2.get();
        return SoundInit.ENTITY_HESEN_AMBIENT3.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_HESEN_HURT1.get();
        return SoundInit.ENTITY_HESEN_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_HESEN_DEATH.get();
    }

    private void ironQuakeParticle() {
        if (this.level().isClientSide) {
            BlockState block = this.level().getBlockState(this.blockPosition().below());
            for (int i1 = 0; i1 <  20 + this.random.nextInt(12); ++i1) {
                double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = 4.0f * Mth.sin(((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = 4.0f * Mth.cos(angle);
                this.level().addParticle(ParticleTypes.FLAME, this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
        }
    }

    private void ironQuake(float grow, int damage) {
        this.playSound(SoundEvents.METAL_BREAK, 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate((double)grow))) {
            if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) continue;
            entity.hurt(damageSources().mobAttack(this), entity.getMaxHealth()*0.3f+ (float)this.random.nextInt(damage));
            //entity.hurt(damageSources().mobAttack((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_) + (float)this.random.nextInt(damage));
            this.launch(entity, true);
        }
    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);
        int hitX = Mth.floor((double)px);
        int hitZ = Mth.floor((double)pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = new BlockPos(pos).above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);
        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
            fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity(fallingBlockEntity);
            if (!this.level().isClientSide && block.getBlock() != Blocks.BEDROCK) {
//                if (CMConfig.IgnisBlockBreaking) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
//                else if (ForgeEventFactory.getMobGriefingEvent((Level)this.level(), (Entity)this)) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
            }
        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
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
                        ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, (double)airborne + 0.5, 0.0));
                }
            }
        }

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
