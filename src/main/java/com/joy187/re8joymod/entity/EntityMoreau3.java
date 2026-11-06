package com.joy187.re8joymod.entity;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.PotionInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;


import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.core.Direction;


public class EntityMoreau3 extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	
	public int explosionPower = 5, attr = 0;
	public boolean isaoe = false;
	private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    //private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMoreau3.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMoreau3.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityMoreau3.class,
			EntityDataSerializers.INT);
	
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
     
    public EntityMoreau3(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 350;
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
        if(co==1 && this.attr!=2 && this.attr!=3)
        {
            //this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleTypes.ITEM_SLIME, pos.x, pos.y, pos.z, this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07);
            }
        }
        if(this.entityData.get(DEFENDSTATE)==1) {
     	   //System.out.println("DEFEND!");
     	   this.defend();
        }

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 270.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 20.0D).
                add(Attributes.ATTACK_DAMAGE, 11.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));

		//this.goalSelector.addGoal(0, new EntityMoreau3.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new FloatGoal(this));   	
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }


    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20,0,true,true));
            }
            return true;
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
	               this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07);
	           }           	   
           }

           this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

     }
    
    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_MOREAU_AMBIENT1.get();
        return SoundInit.ENTITY_MOREAU_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_MOREAU_HURT1.get();
        return SoundInit.ENTITY_MOREAU_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_MOREAU_DEATH.get();
    }
    
    public int getInvulnerableTicks() {
        return 200;
     }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 1.5F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        //this.entityData.set(DATA_ID_INV, p_82215_1_);
    }
     
    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        //this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
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
	        if(this.getHealth() >= 100.0F && this.getHealth()<=105.0F)
	        {
	            this.level().addParticle(ParticleTypes.BUBBLE, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
	            for(int i=0;i<5;i++)
	                this.heal(2.0F*ran.nextFloat());
	        }
	        if(this.getHealth() >= 50.0F && this.getHealth()<=55.0F)
	        {
	            this.level().addParticle(ParticleTypes.BUBBLE_COLUMN_UP, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
	            for(int i=0;i<5;i++)
	                this.heal(2.5F*ran.nextFloat());
	        }
	        if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
	        {
//	            Vec3d vec3d = this.getLook(1.0F);
	            this.level().addParticle(ParticleTypes.EXPLOSION_EMITTER, this.getX() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + (this.random.nextDouble() - 0.5D) * (double)this.getBbWidth(), this.position().x * -0.2D, 0.1D, this.position().z * -0.2D);
	            this.level().explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
	        }
//	        if(this.isaoe==true)
//	        {
//	        	AreaEffectCloud areaeffectcloudentity = new AreaEffectCloud(this.level(), this.getX(), this.getY(),
//						this.getZ());
////				areaeffectcloudentity.setParticle(ParticleInit.MUCUS_PARTICLE.get());
//	        	areaeffectcloudentity.setParticle(ParticleTypes.EXPLOSION);
//				areaeffectcloudentity.setRadius(10.0F);
//				areaeffectcloudentity.setDuration(55);
//				areaeffectcloudentity.setPos(this.getX(), this.getY(), this.getZ());
//				this.level().addFreshEntity(areaeffectcloudentity);
//				this.goalSelector.getRunningGoals().forEach(WrappedGoal::stop);
//				this.setLastHurtMob(this.getLastHurtByMob());
//				this.level().broadcastEntityEvent(this, (byte) 3);
//	        }

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
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.moreau3.walk"));
            return PlayState.CONTINUE;
        }
//        Random ran = new Random();
//        int co = ran.nextInt(30);
//        if(co==1) {
//        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
//            return PlayState.CONTINUE;
//        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.moreau3.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.moreau3.attack"));
			this.isaoe=false;
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.moreau3.aoe"));
			this.isaoe=true;
			//System.out.println("AOE!!!");
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.moreau3.attack2"));
			this.isaoe=false;
			//System.out.println("AOE!!!");
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
	protected void updateControlFlags() {
		boolean flag = this.getTarget() != null && this.hasLineOfSight(this.getTarget());
		this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
		super.updateControlFlags();
	}


	static class AttackGoal extends Goal {
		private final EntityMoreau3 parentEntity;
		protected int attackTimer = 0;

		public AttackGoal(EntityMoreau3 ghast) {
			this.parentEntity = ghast;
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

				if (this.attackTimer == 15) {
					if ((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.40) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.50))
					|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.20) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.30))) {
						for (int l = 0; l < 16; ++l) {
							float f1 = f + (float) l * (float) Math.PI * 0.4F;
							for (int y = 0; y < 5; ++y) {
//								parentEntity.spawnFlames(
//										parentEntity.getX() + (double) Mth.cos(f1) * rand.nextDouble() * 11.5D,
//										parentEntity.getZ() + (double) Mth.sin(f1) * rand.nextDouble() * 11.5D, d0, d1,
//										f1, 0);
//					        	CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),parentEntity.level, 
//					        			blockpos ,1.0F);
								
								parentEntity.performRangedAttack(livingentity, y);
							}
							parentEntity.level().playLocalSound(this.parentEntity.getX(), this.parentEntity.getY(),
									this.parentEntity.getZ(), SoundInit.GM79PRO.get(), SoundSource.HOSTILE,
									1.0F, 1.0F, true);
							this.parentEntity.attr=2;
							this.parentEntity.setAttackingState(2);
							this.parentEntity.getNavigation().stop();
						}
						//TentacleEntity lost_soul = ModEntityTypes.TENTACLE.get().create(world);
						//lost_soul.moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 0, 0);
						//world.addFreshEntity(lost_soul);
					} else if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.70) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.80)) ||
							(parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.51) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.6)) ||
							(parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.11) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.19)))
					{
						this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
			        	this.parentEntity.attr=3;
			        	this.parentEntity.setAttackingState(3);
					}
					else	
					{
						this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
						parentEntity.level().playLocalSound(this.parentEntity.getX(), this.parentEntity.getY(),
								this.parentEntity.getZ(), SoundInit.GM79PRO.get(), SoundSource.HOSTILE, 1.0F,
								1.0F, true);
						this.parentEntity.setDeltaMovement(this.parentEntity.getViewVector(1).add(2,1,2));
						this.parentEntity.attr=1;
						this.parentEntity.setAttackingState(1);
					}
				}

				if(this.attackTimer==40 && this.parentEntity.getAttckingState()==3){
					this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+8,this.parentEntity.getY(),this.parentEntity.getZ()+8,1.2D);
					for (Entity entity : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D))) {
						if (!this.parentEntity.isAlliedTo(entity) && !(entity instanceof EntityHeisen) && entity != this.parentEntity) {
							entity.hurt(this.parentEntity.damageSources().mobAttack(this.parentEntity), livingentity.getMaxHealth()*0.4f + rand.nextFloat() );
						}
					}
				}

				if (this.attackTimer == 45) {
					this.parentEntity.setAttackingState(0);
					this.attackTimer = -5;
    	            this.parentEntity.setDefendingState(1);
    	            this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*2,10,true,true));
    	            this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*2,10,true,true));	   
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}
			this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
		}

	}

	public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
		BlockPos blockpos = this.blockPosition();
		boolean flag = false;
		double d0 = 0.0D;
		do {
			BlockPos blockpos1 = blockpos.below();
			BlockState blockstate = this.level().getBlockState(blockpos1);
			if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
				if (!this.level().isEmptyBlock(blockpos)) {
					BlockState blockstate1 = this.level().getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.max(Direction.Axis.Y);
					}
				}
				flag = true;
				break;
			}
			blockpos = blockpos.below();
		} while (blockpos.getY() >= Mth.floor(maxY) - 1);

		if (flag) {
			//EntityMoreauProjectile fang = new EntityMoreauProjectile(this.level(), x, (double) blockpos.getY() + d0, z, yaw, 1, this,
			//		4.0F);
			//fang.level.addParticle(ParticleInit.MUCUS_PARTICLE.get(), blockpos.getX(), blockpos.getY(), blockpos.getZ(), 0,0,0);
        	//CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),this.level(), blockpos ,1.0F);
        	//CommonFunctions.spawnHexAround(ParticleTypes.DRIPPING_OBSIDIAN_TEAR,this.level(), this.blockPosition() ,1.0F);
//			fang.setSecondsOnFire(tickCount);
//			fang.setInvisible(false);
//			this.level().addFreshEntity(fang);
		}
	}

	   public void performRangedAttack(LivingEntity p_34143_, float p_34144_) {
		         Vec3 vec3 = p_34143_.getDeltaMovement();
		         Random ran = new Random();
		         double d0 = p_34143_.getX() + vec3.x - this.getX();
		         double d1 = p_34143_.getEyeY() - (double)6.1F - this.getY();
		         double d2 = p_34143_.getZ() + vec3.z - this.getZ();
		         double d3 = Math.sqrt(d0 * d0 + d2 * d2);
		         for (int i = 0; i < 20; i++)
		         {
		             float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
		             Vec3 pos = new Vec3(d0 + 1 * Math.sin(0 + deltaOmega),  d1 + 0.1f * this.random.nextFloat(), d2 + 1 * Math.cos(0 + deltaOmega));
		                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
		             //this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
		             this.level().addParticle(ParticleTypes.EXPLOSION, pos.x, pos.y, pos.z, this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07,this.random.nextGaussian()*0.07);
		         }
		            
		         Potion potion = PotionInit.EROSION_POTION.get();
		         if(ran.nextInt(2)==0) {
			        potion = PotionInit.BURN_POTION.get();
		         }

		         ThrownPotion thrownpotion = new ThrownPotion(this.level(), this);
		         thrownpotion.setItem(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
		         thrownpotion.setXRot(thrownpotion.getXRot() - -20.0F);
		         thrownpotion.shoot(d0, d1 + d3 * 0.2D, d2, 0.75F, 8.0F);
		         if (!this.isSilent()) {
		            this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundInit.ENTITY_MOREAU_HURT1.get(), this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
		         }

		         this.level().addFreshEntity(thrownpotion);
		   }
}