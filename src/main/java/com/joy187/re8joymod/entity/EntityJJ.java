package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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

import java.util.List;
import java.util.Random;

public class EntityJJ extends Ravager implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityJJ.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityJJ.class,
			EntityDataSerializers.INT);
	private int flag=0,attr=0;

    public EntityJJ(EntityType<? extends Ravager> type, Level worldIn) {
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
                add(Attributes.MOVEMENT_SPEED, 0.23D).
                add(Attributes.FOLLOW_RANGE, 30.0D).
                add(Attributes.ARMOR, 3.0D).
                add(Attributes.ARMOR_TOUGHNESS, 5.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 5.0D);
    }
    
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
           if (this.isImmobile()) {
              this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
           } else {
              double d0 = this.getTarget() != null ? 0.25D : 0.23D;
              double d1 = this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
              this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(Mth.lerp(0.1D, d1, d0));
           }

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
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.walk"));
            return PlayState.CONTINUE;
        }

        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.urias.attack2"));
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
	
	   static class AttackGoal extends Goal {
	        private final EntityJJ parentEntity;
	        protected int attackTimer = 0;

	        public AttackGoal(EntityJJ mob) {
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

	                  if (this.attackTimer==3) {
	                	  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
	                	  {
							  this.parentEntity.getNavigation().moveTo(livingentity, 0.8D);
		                	  if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.40) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.50)) ||
		                		 (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.10) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.30)))
		                	  {
			                      this.parentEntity.setAttackingState(2);
			                      this.parentEntity.attr=2;	                		  
		                	  }
		                	  else {
								  this.parentEntity.getNavigation().stop();
								  this.parentEntity.setAttackingState(1);
			                      this.parentEntity.attr=1;	                		  
		                	  }	                		  
	                	  }
	                  }

	                  if(this.attackTimer>=21 && this.attackTimer%3==0 && this.parentEntity.getAttckingState()==1){
						  EntityBOWShoot abstractarrowentity = new EntityBOWShoot(this.parentEntity.level(), this.parentEntity);
						  abstractarrowentity.shootFromRotation(this.parentEntity, this.parentEntity.getXRot(), this.parentEntity.getYRot(), 0.0F, 15.5F, 0.75F);
						  abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
						  abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 1.5F, 1.5F);
						  abstractarrowentity.damage*=1.2;
						  this.parentEntity.level().addFreshEntity(abstractarrowentity);

					  }

					 if(this.attackTimer==34 && this.parentEntity.getAttckingState()==2){
						 for(int i = 0; i < 5; ++i) {
							 float f1 = f + (float)i * (float)Math.PI * 0.4F;
							 EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
									 BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
							 this.parentEntity.level().addFreshEntity(fallingBlockEntity);
						 }

						 for(int k = 0; k < 8; ++k) {
							 float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
							 EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
									 BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
							 this.parentEntity.level().addFreshEntity(fallingBlockEntity);
						 }

					 }

	                  if (this.attackTimer == 45) {
	                       this.parentEntity.setAttackingState(0);
	                       this.attackTimer = -5;
	                       //this.parentEntity.addEffect(MobEffectInstance)
	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*2,10,true,true));
	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*2,10,true,true));	       	               
	       	               this.parentEntity.setDefendingState(1);
	       	               this.parentEntity.attr=0;	                		 
	       	            //this.parentEntity.level().addParticle(ParticleTypes.ASH, this.parentEntity.getX(), this.parentEntity.getY(), this.parentEntity.getZ(), this.parentEntity.position().x, this.parentEntity.position().y, this.parentEntity.position().z);
	       	               //System.out.println("Begin inv.");
	                  }
	                  this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

				 }
	             else if (this.attackTimer > 0) {
	                  --this.attackTimer;
	             }
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
						((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, airborne, 0.0));
				}

			}
		}

	}

	public static void disableShield(LivingEntity livingEntity, int ticks) {
		((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
		livingEntity.getUseItem().hurtAndBreak(5+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
			p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
		});
		livingEntity.stopUsingItem();
		livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
	}

}
