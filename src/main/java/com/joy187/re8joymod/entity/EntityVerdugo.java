package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.ParticleInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
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

import java.util.Random;
import java.util.function.Predicate;

public class EntityVerdugo extends Ravager implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityVerdugo.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityVerdugo.class,
			EntityDataSerializers.INT);
	private int flag=0,attr=0;

    public EntityVerdugo(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 70;
        //SpawnPlacements.register(EntityInit.FRANK1.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.4D));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 100.0D).
                add(Attributes.MOVEMENT_SPEED, 0.4D).
                add(Attributes.FOLLOW_RANGE, 50.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 5.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.3D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }
    
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
//           if (this.isImmobile()) {
//              this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
//           } else {
//              double d0 = this.getTarget() != null ? 0.25D : 0.23D;
//              double d1 = this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
//              this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(Mth.lerp(0.1D, d1, d0));
//           }

           if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
              boolean flag = false;
              AABB aabb = this.getBoundingBox().inflate(0.2D);

              for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                 BlockState blockstate = this.level().getBlockState(blockpos);
                 Block block = blockstate.getBlock();
                 if (block instanceof LeavesBlock) {
                    flag = this.level().destroyBlock(blockpos, true, this) || flag;
                 }
              }

              if (!flag && this.onGround()) {
                 this.jumpFromGround();
              }
           }

           if(this.getHealth()<0.5 && this.getHealth()>0.4 && !this.hasEffect(MobEffects.INVISIBILITY)){
           	 	this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,200));
		   }
           if (this.entityData.get(STATE)==2) {
                 this.roar();
           }
           if(this.entityData.get(DEFENDSTATE)==1) {
        	   //System.out.println("DEFEND!");
        	   this.defend();
           }
        }
    }
    
    private void roar() {
        if (this.isAlive()) {

           Vec3 vec3 = this.getBoundingBox().getCenter();

//           for(int i = 0; i < 40; ++i) {
//              double d0 = this.random.nextGaussian() * 0.2D;
//              double d1 = this.random.nextGaussian() * 0.2D;
//              double d2 = this.random.nextGaussian() * 0.2D;
//              this.level().addParticle(ParticleTypes.DRIPPING_LAVA, vec3.x, vec3.y, vec3.z, d0, d1, d2);
//           }
           for (int i = 0; i < 10; i++)
           {
               float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
               Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
               //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
               this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
           }   
           this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

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


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.walk"));
            return PlayState.CONTINUE;
        }

        if(this.isDeadOrDying()){
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.death"));
			return PlayState.CONTINUE;
		}
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.attack2"));
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
    
	public int getDefendingState() {
		return this.entityData.get(DEFENDSTATE);
	}
	
	public void setDefendingState(int time) {
		this.entityData.set(DEFENDSTATE, time);
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
	
	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

	private static final Predicate<Entity> VER_AREA = (entity) -> {
		return entity.isAlive() && !(entity instanceof EntityVerdugo);
	};

	   static class AttackGoal extends Goal {
	        private final EntityVerdugo parentEntity;
	        protected int attackTimer = 0;

	        public AttackGoal(EntityVerdugo mob) {
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
	             if (this.parentEntity.distanceTo(livingentity)<20D) {
//	                  Level world = this.parentEntity.level();
	                  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
	                  {
	                	  ++this.attackTimer;
	                  }
	                  else {
	       	               this.parentEntity.setDefendingState(0);
	                  }
	                  Random rand = new Random();
	                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
	                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
	                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
	                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
	                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
	                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
	                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
	                          livingentity.getX() - parentEntity.getX());

	                  if (this.attackTimer==15) {
	                	  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
	                	  {
		                	  if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.75) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.90)) ||
		                	  		(parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.40) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.60)) ||
		                		 (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.10) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.30)))
		                	  {
								  this.parentEntity.getNavigation().stop();
			                      this.parentEntity.setAttackingState(2);
			                      this.parentEntity.attr=2;	                		  
		                	  }
		                	  else {
								  this.parentEntity.getNavigation().moveTo(livingentity, 3D);
			                	  this.parentEntity.setAttackingState(1);
			                      this.parentEntity.attr=1;	                		  
		                	  }	                		  
	                	  }
	                  }

	                  if((this.attackTimer==20 || this.attackTimer==25 || this.attackTimer==30)&& this.parentEntity.getAttckingState()==2){
						  for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(3.0D), VER_AREA)) {
							  double d00 = lvt.getX() - this.parentEntity.getX();
							  double d10 = lvt.getZ() - this.parentEntity.getZ();
							  double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
							  lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), (float)this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.2F);
							  this.parentEntity.heal(2F);
						  }
					  }
	                  if (this.attackTimer == 35) {
	                       this.parentEntity.setAttackingState(0);
	                       this.attackTimer = -5;
	                       //this.parentEntity.addEffect(MobEffectInstance)
	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*2,2,true,true));
	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*2,10,true,true));	       	               
	       	               this.parentEntity.setDefendingState(1);
	       	               this.parentEntity.attr=0;	                		 
	       	            //this.parentEntity.level().addParticle(ParticleTypes.ASH, this.parentEntity.getX(), this.parentEntity.getY(), this.parentEntity.getZ(), this.parentEntity.position().x, this.parentEntity.position().y, this.parentEntity.position().z);
	       	               //System.out.println("Begin inv.");
	                  }
	             } 
	             else if (this.attackTimer > 0) {
	                  --this.attackTimer;
	             }
	             this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
	             //System.out.println(this.attackTimer+" , "+this.parentEntity.attr);
	        }

	   }
	   

	   public boolean doHurtTarget(Entity p_33328_) {
		   if(this.attr==1 || this.attr==2)
		   {
			  //System.out.println("ATT!");
		      this.level().broadcastEntityEvent(this, (byte)4);
		      this.playSound(SoundEvents.RAVAGER_ATTACK, 1.0F, 1.0F);
		      return super.doHurtTarget(p_33328_);			   
		   }
		   return false;
	    }
}
