package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.util.CommonFunctions;

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
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
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
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import software.bernie.geckolib.core.animation.AnimationController;

public class EntityUrias extends Ravager implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityUrias.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityUrias.class,
			EntityDataSerializers.INT);
	private int flag=0,attr=0,attackTimer=0;

	public static final AnimationState attackAnimationState = new AnimationState();
	public static final AnimationState attackAnimationState2 = new AnimationState();


	public EntityUrias(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 70;
        this.attackTimer=0;
        //SpawnPlacements.register(EntityInit.FRANK1.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.4D));
        //this.goalSelector.addGoal(1, new AttackGoal(this));
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
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 25.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 19.0D);
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
    
	protected String animWalk() {
		return "animation.urias.walk";
	}

	protected String animIdle() {
		return "animation.urias.idle";
	}

	protected String animRecover() {
		return "animation.urias.recover";
	}

	protected String animSlash() {
		return "animation.urias.attack";
	}

	protected String animHeavy() {
		return "animation.urias.attack2";
	}

	protected String animCharge() {
		return "animation.urias.charge";
	}

	protected <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
		int atk = this.entityData.get(STATE);
		if (atk == 1 || atk == 2 || atk == 3) {
			return PlayState.STOP;
		}
		// Post-attack recovery / stagger
		if (this.getDefendingState() == 1 || this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
			event.setAndContinue(RawAnimation.begin().thenLoop(this.animRecover()));
			return PlayState.CONTINUE;
		}
		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenPlay(this.animWalk()));
			return PlayState.CONTINUE;
		}
		event.setAndContinue(RawAnimation.begin().thenPlay(this.animIdle()));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay(this.animSlash()))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay(this.animHeavy()))
						.triggerableAnim("charge", RawAnimation.begin().thenPlay(this.animCharge()));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}


//    @Override
//	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.add(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.add(new AnimationController(this, "controller1",
//                0, this::predicate1));
//	}
//
	public int getDefendingState() {
		return this.entityData.get(DEFENDSTATE);
	}
	
	public void setDefendingState(int time) {
		this.entityData.set(DEFENDSTATE, time);
	}
    
	public int getAttckingState() {
		return this.entityData.get(STATE);
	}
	
	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		if (state == 1) {
			this.triggerAnim("controller1", "slash");
		} else if (state == 2) {
			this.triggerAnim("controller1", "heavy");
		} else if (state == 3) {
			this.triggerAnim("controller1", "charge");
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1 || time == 2 || time == 3) && prev != time) {
			this.startAttackAnim(time);
		}
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

	private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
		return entity.isAlive() && !(entity instanceof EntityUrias);
	};

//	@Override
//	public void tick() {
//		super.tick();
//		LivingEntity target = this.getTarget();
//		if (target != null && this.hasLineOfSight(target)) {
//			Level world = this.level();
//			if (!this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
//				++attackTimer;
//			} else {
//				this.setDefendingState(0);
//			}
//			Random rand = new Random();
//			Vec3 vector3d = this.getViewVector(1.0F);
//			double d0 = Math.min(target.getY(), target.getY());
//			double d1 = Math.max(target.getY(), target.getY()) + 1.0D;
//			double d2 = target.getX() - (this.getX() + vector3d.x * 2.0D);
//			double d3 = target.getY(0.5D) - (0.5D + this.getY(0.5D));
//			double d4 = target.getZ() - (this.getZ() + vector3d.z * 2.0D);
//			float f = (float) Mth.atan2(target.getZ() - this.getZ(),
//					target.getX() - this.getZ());
//
//			this.getNavigation().moveTo(target, 0.8D);
//
//			if (attackTimer == 3) {
//				if (!this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
//					int randomSkill = rand.nextInt(2);
//					if (randomSkill == 0) {
//						this.setAttackingState(2);
//						this.attr = 2;
//					} else {
//						this.setAttackingState(1);
//						this.attr = 1;
//					}
//				}
//			}
//
//			if (this instanceof EntityBrute && attackTimer >= 10 && attackTimer <= 30 && this.getAttckingState() == 1) {
//				for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.0D), PIGEON_AREA)) {
//					if (!(lvt instanceof EntityBrute)) {
//						lvt.hurt(lvt.damageSources().cactus(), lvt.getMaxHealth() * 0.05f);
//					}
//				}
//			}
//
//
//		}
//
//
//	}

	@Override
	public void tick() {
		super.tick();

		// Post-attack recovery: stand still + recover anim for the resistance window
		if (this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
			this.setDefendingState(1);
			this.getNavigation().stop();
			this.setDeltaMovement(this.getDeltaMovement().multiply(0.15D, 1.0D, 0.15D));
			LivingEntity recoverTarget = this.getTarget();
			if (recoverTarget != null) {
				this.lookAt(recoverTarget, 30.0F, 30.0F);
			}
			return;
		} else if (this.getDefendingState() == 1) {
			this.setDefendingState(0);
		}

		// 模拟 canUse 逻辑
		if (this.getTarget() != null) {
			// 模拟 start 逻辑
			this.setAggressive(true);

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

				int atkState = this.getAttckingState();
				double dist = this.distanceTo(livingentity);

				// Charge windup: plant feet and face target
				if (atkState == 3 && this.attackTimer < 18) {
					this.getNavigation().stop();
					this.setDeltaMovement(this.getDeltaMovement().multiply(0.2D, 1.0D, 0.2D));
				} else if (atkState != 3) {
					this.getNavigation().moveTo(livingentity, 0.8D);
				}

				if (this.attackTimer == 3) {
					if (!this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
						int roll = rand.nextInt(100);
						// Mid-range: prefer charge rush
						if (dist >= 7.0D && dist <= 18.0D && roll < 40) {
							this.setAttackingState(3);
							this.attr = 3;
						} else if ((this.getHealth() >= (this.getMaxHealth() * 0.40) && this.getHealth() <= (this.getMaxHealth() * 0.60)) ||
								(this.getHealth() >= (this.getMaxHealth() * 0.10) && this.getHealth() <= (this.getMaxHealth() * 0.30)) ||
								roll < 45) {
							this.setAttackingState(2);
							attackAnimationState2.start(this.tickCount);
							this.attr = 2;
						} else {
							this.setAttackingState(1);
							attackAnimationState.start(this.tickCount);
							this.attr = 1;
						}
					}
				}

				// Charge dash toward target after windup
				if (atkState == 3 && this.attackTimer >= 18 && this.attackTimer <= 40) {
					Vec3 to = livingentity.position().subtract(this.position());
					Vec3 flat = new Vec3(to.x, 0.0D, to.z);
					if (flat.lengthSqr() > 1.0E-4D) {
						Vec3 dir = flat.normalize().scale(1.35D);
						this.setDeltaMovement(dir.x, this.getDeltaMovement().y, dir.z);
						this.hasImpulse = true;
					}
					this.getNavigation().stop();
					if (this.attackTimer >= 22 && this.attackTimer <= 38) {
						for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.6D), PIGEON_AREA)) {
							if (!(lvt instanceof EntityUrias)) {
								lvt.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.15F);
								lvt.knockback(1.1D, this.getX() - lvt.getX(), this.getZ() - lvt.getZ());
							}
						}
					}
				}

				if ((this instanceof EntityBrute) && this.attackTimer >= 10 && this.attackTimer <= 30 && this.getAttckingState() == 1) {
					for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.0D), PIGEON_AREA)) {
						if (!(lvt instanceof EntityBrute))
							lvt.hurt(lvt.damageSources().cactus(), lvt.getMaxHealth() * 0.05f);
					}
				}

				// Overhead smash hit
				if (this.attackTimer == 32 && this.getAttckingState() == 1) {
					for (int l = 1; l < 10; l++) {
						this.blockSmashAttack(l, 3F, 1.5F, 150, 2.5F, 0.15F, 1.0F);
						this.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.2F, 1.0F);
						this.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
						this.blockSmashAttack(l, 3F, -2.5F, 150, 2.5F, 0.15F, 1.0F);
						this.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.2F, 1.0F);
						this.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
						this.blockSmashAttack(l, 3F, 4.5F, 150, 2.5F, 0.15F, 1.0F);
						this.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.2F, 1.0F);
					}
				}

				// Horizontal sweep hit
				if (this.attackTimer == 28 && this.getAttckingState() == 2) {
					for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.2D, 1.5D, 3.2D), PIGEON_AREA)) {
						if (!(lvt instanceof EntityUrias)) {
							lvt.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.35F);
							lvt.knockback(0.85D, this.getX() - lvt.getX(), this.getZ() - lvt.getZ());
						}
					}
					for (int i = 0; i < 5; ++i) {
						float f1 = f + (float) i * (float) Math.PI * 0.4F;
						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f1) * 1.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f1) * 1.5D,
								BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
						this.level().addFreshEntity(fallingBlockEntity);
					}
				}

				if (this.attackTimer == 34 && this.getAttckingState() == 2) {
					if (this instanceof EntityBrute) {
						for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.0D), PIGEON_AREA)) {
							if (!(lvt instanceof EntityBrute))
								lvt.hurt(lvt.damageSources().fellOutOfWorld(), lvt.getMaxHealth() * 0.3f + livingentity.getArmorValue());
						}
					} else {
						for (int k = 0; k < 8; ++k) {
							float f2 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
							EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f2) * 1.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f2) * 1.5D,
									BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
							this.level().addFreshEntity(fallingBlockEntity);
						}
					}
				}

				this.lookAt(livingentity, 30.0F, 30.0F);
			}
//			else if (this.attackTimer > 0) {
//				--this.attackTimer;
//			}

		}

		if (this.attackTimer >= 50) {
			this.setAttackingState(0);
			this.attackTimer = -10;
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 2, 10, true, true));
			this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * 2, 10, true, true));
			this.setDefendingState(1);
			attackAnimationState.stop();
			attackAnimationState2.stop();
			this.attr = 0;
		}
//		else {
//			// 模拟 stop 逻辑
//			this.setAggressive(false);
//			this.setAttackingState(0);
//			this.attackTimer = -1;
//		}
	}

//	   static class AttackGoal extends Goal {
//	        private final EntityUrias parentEntity;
//	        protected int attackTimer = 0;
//
//	        public AttackGoal(EntityUrias mob) {
//	             this.parentEntity = mob;
//	        }
//
//	        public boolean canUse() {
//	             return this.parentEntity.getTarget() != null;
//	        }
//
//	        public void start() {
//	             super.start();
//	             this.parentEntity.setAggressive(true);
//	        }
//
//	        @Override
//	        public void stop() {
//	             super.stop();
//	             this.parentEntity.setAggressive(false);
//	             this.parentEntity.setAttackingState(0);
//	             this.attackTimer = -1;
//	        }
//
//	        public void tick() {
//	             LivingEntity livingentity = this.parentEntity.getTarget();
//	             if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
//	                  Level world = this.parentEntity.level();
//	                  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
//	                  {
//	                	  ++this.attackTimer;
//	                  }
//	                  else {
//	       	               this.parentEntity.setDefendingState(0);
//	                  }
//	                  Random rand = new Random();
//	                  Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
//	                  double d0 = Math.min(livingentity.getY(), livingentity.getY());
//	                  double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
//	                  double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
//	                  double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
//	                  double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
//	                  float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
//	                          livingentity.getX() - parentEntity.getX());
//
//	                  this.parentEntity.getNavigation().moveTo(livingentity, 0.8D);
//	                  if (this.attackTimer==3) {
//	                	  if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
//	                	  {
//		                	  if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.40) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.60)) ||
//		                		 (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.10) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.30)))
//		                	  {
//			                      this.parentEntity.setAttackingState(2);
//			                      this.parentEntity.attr=2;
//		                	  }
//		                	  else {
//			                	  this.parentEntity.setAttackingState(1);
//			                      this.parentEntity.attr=1;
//		                	  }
//	                	  }
//	                  }
//
//					 if((this.parentEntity instanceof EntityBrute) && this.attackTimer>=10 && this.attackTimer<=30 && this.parentEntity.getAttckingState()==1) {
//						 for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2.0D), PIGEON_AREA)) {
//						 	if(!(lvt instanceof EntityBrute))
//						 		lvt.hurt(lvt.damageSources().cactus(),lvt.getMaxHealth()*0.05f);
//						 }
//					 }
//
//	                  if(this.attackTimer==32 && this.parentEntity.getAttckingState()==1){
//						  for(int l = 1; l < 10; l++)
//						  {
//							  this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 2.5F, 0.15F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.2F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 2.5F, 0.15F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.2F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 2.5F, 0.15F, 1.0F);
//							  this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.2F, 1.0F);
//						  }
//
//					  }
//
//
//					 if(this.attackTimer==34 && this.parentEntity.getAttckingState()==2){
//						if(this.parentEntity instanceof EntityBrute)
//						{
//							for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2.0D), PIGEON_AREA)) {
//								if(!(lvt instanceof EntityBrute))
//									lvt.hurt(lvt.damageSources().fellOutOfWorld(),lvt.getMaxHealth()*0.3f+livingentity.getArmorValue());
//							}
//						}
//						else{
//							for(int i = 0; i < 5; ++i) {
//								float f1 = f + (float)i * (float)Math.PI * 0.4F;
//								EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
//										BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
//								this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//							}
//
//							for(int k = 0; k < 8; ++k) {
//								float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
//								EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
//										BlockInit.DEYE_BLOCK.get().defaultBlockState(), 10);
//								this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//							}
//						}
//					 }
//
//	                  if (this.attackTimer == 35) {
//	                       this.parentEntity.setAttackingState(0);
//	                       this.attackTimer = -5;
//	                       //this.parentEntity.addEffect(MobEffectInstance)
//	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*2,10,true,true));
//	       	               this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*2,10,true,true));
//	       	               this.parentEntity.setDefendingState(1);
//	       	               this.parentEntity.attr=0;
//	       	            //this.parentEntity.level().addParticle(ParticleTypes.ASH, this.parentEntity.getX(), this.parentEntity.getY(), this.parentEntity.getZ(), this.parentEntity.position().x, this.parentEntity.position().y, this.parentEntity.position().z);
//	       	               //System.out.println("Begin inv.");
//	                  }
//	             }
//	             else if (this.attackTimer > 0) {
//	                  --this.attackTimer;
//	             }
//	             this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//	             //System.out.println(this.attackTimer+" , "+this.parentEntity.attr);
//	        }
//
//	   }
	   

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
				if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityUrias) continue;
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
