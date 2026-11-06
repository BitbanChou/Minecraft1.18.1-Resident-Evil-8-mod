package com.joy187.re8joymod.entity;



import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.*;
import com.joy187.re8joymod.util.CommonFunctions;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
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
import net.minecraft.world.entity.*;
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
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.FireChargeItem;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.core.Direction;

public class EntityMuHeisen extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public int explosionPower = 5, attr = 0,pre=0,attackTimer,aoeSkillCooldown;
	public boolean isaoe = false;
	private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    //private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMuHeisen.class,true), EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMuHeisen.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityMuHeisen.class,
			EntityDataSerializers.INT);
	public static final AnimationState attackAnimationState = new AnimationState();
	public static final AnimationState attackAnimationState2 = new AnimationState();
	public static final AnimationState attackAnimationState3 = new AnimationState();
	public static final AnimationState attackAnimationState4 = new AnimationState();

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };

    public EntityMuHeisen(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 750;
        this.isNonBoss();
        this.isSunSensitive();
        this.attackTimer=0;
        this.aoeSkillCooldown=120;
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
            for (int i = 0; i < 30; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0,0,0);
            }
        }

        if(this.entityData.get(DEFENDSTATE)==1) {
      	   this.defend();
         }

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 500.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.90D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityMuHeisen.DimiDoNothingGoal());
        //this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, AbstractVillager.class, 8.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		//this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }


    public boolean doHurtTarget(Entity p_70652_1_) {
        Random ran = new Random();
        int co = ran.nextInt(4);
        this.level().broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean flag = p_70652_1_.hurt(damageSources().mobAttack(this), f1);
        if (flag) {
            p_70652_1_.setDeltaMovement(p_70652_1_.getDeltaMovement().add(0.0D, (double)0.4F, 0.0D));
            this.doEnchantDamageEffects(this, p_70652_1_);
        }

        if(co==0){
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60,1,true,true));
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100,1,true,true));
        }
        if(co==1 && this.isaoe){
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,1,true,true));
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20,1,true,true));
        }
        else if(co==2 && this.attr!=4 && this.isaoe!=true){
            this.level().explode((Entity)null, p_70652_1_.getX(), p_70652_1_.getY(), p_70652_1_.getZ(), (float)1, true, Level.ExplosionInteraction.BLOCK);
            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 60,2,true,true));
        }
//        else{
//            ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40,1,true,true));
//        }
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
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

        if(this.isOnFire()){
        	this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,300,0,false,false));
		}

        if(this.getHealth()<300.F){
            this.level().addParticle(ParticleTypes.SMOKE,
					this.position().x + this.random.nextGaussian() * (double)0.3F, this.position().y + this.random.nextGaussian() * (double)0.3F, this.position().z + this.random.nextGaussian() * (double)0.3F, 0.0D, 0.0D, 0.0D);
        }

        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 160.0F && this.getHealth()<=165.0F)
        {
            for(int i=0;i<4;i++)
                this.heal(2F*ran.nextFloat());
        }

        if(this.getHealth()>1.0F && this.getHealth()<5.0F){
            this.level().explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
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
	               Vec3 pos = new Vec3(vec3.x + 3 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 3 * Math.cos(0 + deltaOmega));
	               //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
	               this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
	           }
           }

           this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

     }

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

//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//        if (event.isMoving()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.walk"));
//            return PlayState.CONTINUE;
//        }
////        Random ran = new Random();
////        int co = ran.nextInt(30);
////        if(co==1) {
////        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
////            return PlayState.CONTINUE;
////        }
//
//        event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.idle"));
//        return PlayState.CONTINUE;
//    }

	private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {

		// 检测生物是否死亡
//		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("death")); // 播放死亡动画
//			return PlayState.CONTINUE;
//		}

		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.walk"));
			return PlayState.CONTINUE;
		}

		event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.idle"));
		return PlayState.CONTINUE;
	}

	public static <T extends EntityMuHeisen & GeoAnimatable> AnimationController<T> genericAttackAnimation(T animatable, RawAnimation attackAnimation) {
		return new AnimationController<>(animatable, "Attack", 0, event -> {
			if (attackAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.attack"));

				return PlayState.CONTINUE;
			}
			if (attackAnimationState2.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.aoe"));

				//return PlayState.CONTINUE;
			}
			if (attackAnimationState3.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.attack2"));

				//return PlayState.CONTINUE;
			}
			if (attackAnimationState4.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
				event.setAndContinue(RawAnimation.begin().thenPlay("animation.muheisen.attack3"));

				//return PlayState.CONTINUE;
			}

			event.getController().forceAnimationReset();
			return PlayState.CONTINUE;
		});
	}
//
//    @Override
//	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.add(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.add(new AnimationController(this, "controller1",
//                0, this::predicate1));
//	}


	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller",
				0, this::predicate));
		data.add(genericAttackAnimation(this, DefaultAnimations.ATTACK_STRIKE));

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

	public int getDefendingState() {
		return this.entityData.get(DEFENDSTATE);
	}

	public void setDefendingState(int time) {
		this.entityData.set(DEFENDSTATE, time);
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

	@Override
	public void tick() {
		super.tick();
		this.setYRot(this.yBodyRot);
		// 更新Boss信息条
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		LivingEntity target = this.getTarget();

		// 模拟 AttackGoal 中的攻击计时器
		if (this.attackTimer > 0) {
			if (!this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
				//this.attackTimer = Math.min(this.attackTimer + 1, 100);
			} else {
				this.setDefendingState(0);
			}
		}

		// 减少 AOE 技能冷却时间
		if (this.aoeSkillCooldown > 0) {
			--this.aoeSkillCooldown;
		}

		if (target != null) {
			Random rand = new Random();
			Vec3 vector3d = this.getViewVector(1.0F);
			double d0 = Math.min(target.getY(), target.getY());
			double d1 = Math.max(target.getY(), target.getY()) + 1.0D;
			double d2 = target.getX() - (this.getX() + vector3d.x * 2.0D);
			double d3 = target.getY(0.5D) - (0.5D + this.getY(0.5D));
			double d4 = target.getZ() - (this.getZ() + vector3d.z * 2.0D);
			float f = (float) Mth.atan2(target.getZ() - this.getZ(),
					target.getX() - this.getX());

			if (this.attackTimer == 5) {
				int randomSkill = rand.nextInt(4);
				System.out.println(randomSkill);
				switch (randomSkill) {
					case 0:
						this.getNavigation().stop();
						this.setAttackingState(2);
						attackAnimationState4.start(this.tickCount);
						break;
					case 1:
						if (this.aoeSkillCooldown <= 0) {
							this.getNavigation().stop();
							for (int l = 0; l < 16; ++l) {
								float f1 = f + (float) l * (float) Math.PI * 0.4F;
								for (int y = 0; y < 5; ++y) {
									this.performRangedAttack(target, f);
								}
								this.level().playLocalSound(this.getX(), this.getY(),
										this.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), SoundSource.HOSTILE,
										1.0F, 1.0F, true);
							}
							this.pre = this.attr;
							this.attr = 4;
							this.setAttackingState(4);
							// 设置 AOE 技能冷却时间
							this.aoeSkillCooldown = 120; // 例如设置为 120 刻的冷却时间
							attackAnimationState2.start(this.tickCount);
						}
						else{
							this.getNavigation().stop();
							this.pre = this.attr;
							this.attr = 3;
							this.setAttackingState(3);
							attackAnimationState3.start(this.tickCount);
						}

						break;
					case 2:
						// 检查 AOE 技能是否冷却完毕
						if (aoeSkillCooldown <= 0) {
							this.getNavigation().stop();
							for (int l = 0; l < 16; ++l) {
								float f1 = f + (float) l * (float) Math.PI * 0.4F;
								for (int y = 0; y < 5; ++y) {
									this.performRangedAttack(target, f);
								}
								this.level().playLocalSound(this.getX(), this.getY(),
										this.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), SoundSource.HOSTILE,
										1.0F, 1.0F, true);
							}
							this.pre = this.attr;
							this.attr = 4;
							this.setAttackingState(4);
							// 设置 AOE 技能冷却时间
							aoeSkillCooldown = 120; // 例如设置为 120 刻的冷却时间
							attackAnimationState2.start(this.tickCount);
						} else {
							// 如果 AOE 技能未冷却完毕，执行普通攻击
							this.getNavigation().moveTo(target, 1.1D);
							this.pre = this.attr;
							this.attr = 1;
							this.setAttackingState(1);
							attackAnimationState.start(this.tickCount);
						}
						break;
					case 3:
						this.getNavigation().moveTo(target, 1.1D);
						this.pre = this.attr;
						this.attr = 1;
						this.setAttackingState(1);
						attackAnimationState.start(this.tickCount);
						break;
				}
			}

			// 后续技能执行逻辑保持不变...
			if (this.attackTimer >= 33 && this.attackTimer <= 34 && this.getAttckingState() == 3) {
				this.getNavigation().moveTo(target, 1.4D);

				for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2))) {
					if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) continue;
					entity.hurt(this.damageSources().mobAttack(this), entity.getMaxHealth() * 0.2f + (float) this.random.nextInt(2));
				}

				for (int l = 0; l < 16; ++l) {
					float f1 = f + (float) l * (float) Math.PI * 0.4F;
					for (int y = 0; y < 5; ++y) {
						this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.getX() + (double) Mth.cos(f1) * rand.nextDouble() * 5.5D,
								d0 + rand.nextFloat() * 3, this.getZ() + (double) Mth.sin(f1) * rand.nextDouble() * 11.5D, rand.nextGaussian() * 0.07, rand.nextGaussian() * 0.07, rand.nextGaussian() * 0.07);
					}

					this.level().playLocalSound(this.getX(), this.getY(),
							this.getZ(), SoundEvents.METAL_FALL, SoundSource.HOSTILE,
							1.0F, 1.0F, true);
				}
			}

			if (this.attackTimer == 45 && this.getAttckingState() == 4) {
				this.getNavigation().stop();
				for (int l = 0; l < 16; ++l) {
					float f1 = f + (float) l * (float) Math.PI * 0.4F;
					for (int y = 0; y < 5; ++y) {
						this.spawnFlames(
								this.getX() + (double) Mth.cos(f1) * rand.nextDouble() * 11.5D,
								this.getZ() + (double) Mth.sin(f1) * rand.nextDouble() * 11.5D, d0, d1,
								f1, 0);
					}
					this.level().playLocalSound(this.getX(), this.getY(),
							this.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), SoundSource.HOSTILE,
							1.0F, 1.0F, true);
				}
			}

			if (this.attackTimer == 65 && this.getAttckingState() == 4) {
				// 定义吸引范围，可根据需要调整
				double range = 10.0;

				// 获取范围内的所有生物
				List<LivingEntity> nearbyEntities = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(range), entity -> entity != this);

				for (LivingEntity nearbyEntity : nearbyEntities) {
					// 为范围内的生物添加 Levitation 效果
					nearbyEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 1));

					// 计算生物相对于该生物的位置向量
					Vec3 direction = new Vec3(this.getX() - nearbyEntity.getX(), this.getY() - nearbyEntity.getY(), this.getZ() - nearbyEntity.getZ());
					direction = direction.normalize();

					// 定义吸力大小，可根据需要调整
					double pullStrength = 0.1;

					// 给生物施加朝向该生物的力
					nearbyEntity.push(direction.x * pullStrength, direction.y * pullStrength, direction.z * pullStrength);
				}
			}

			if (this.attackTimer == 39 && this.getAttckingState() == 1) {
				for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2))) {
					if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) continue;
					entity.hurt(this.damageSources().mobAttack(this), entity.getMaxHealth() * 0.3f + (float) this.random.nextInt(2));
				}
			}

			if (this.attackTimer == 30 && this.getAttckingState() == 2) {
				for (int i = 0; i < 5; ++i) {
					float f1 = f + (float) i * (float) Math.PI * 1.4F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f1) * 1.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f1) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}

				for (int k = 0; k < 8; ++k) {
					float f2 = f + (float) k * (float) Math.PI * 9.0F / 8.0F + 1.2566371F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f2) * 1.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f2) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}
			}

			if (this.attackTimer == 45 && this.getAttckingState() == 2) {
				for (int i = 0; i < 5; ++i) {
					float f1 = f + (float) i * (float) Math.PI * 2.8F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f1) * 3.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f1) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}

				for (int k = 0; k < 8; ++k) {
					float f2 = f + (float) k * (float) Math.PI * 1.8F / 8.0F + 1.2566371F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f2) * 3.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f2) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}
			}

			if (this.attackTimer == 70 && this.getAttckingState() == 2) {
				for (int i = 0; i < 5; ++i) {
					float f1 = f + (float) i * (float) Math.PI * 1.6F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f1) * 5.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f1) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}

				for (int k = 0; k < 8; ++k) {
					float f2 = f + (float) k * (float) Math.PI * 8.0F / 8.0F + 1.2566371F;
					EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), this.getX() + (double) Mth.cos(f2) * 5.5D, this.getY() + this.random.nextDouble(), this.getZ() + (double) Mth.sin(f2) * 1.5D,
							BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
					this.level().addFreshEntity(fallingBlockEntity);
				}

				// 获取生物面向的方向向量
				Vec3 lookAngle = this.getLookAngle();
				// 设置俯冲的速度，这里可以根据需要调整
				double speed = 1.5;
				// 给生物施加向前的动量
				this.getDeltaMovement().add(lookAngle.x * speed, lookAngle.y * speed, lookAngle.z * speed);
			}

			this.lookAt(target, 30.0F, 30.0F);
		}
//		else if (this.attackTimer < 100) {
//			this.attackTimer=(this.attackTimer+1)%101;
//		}
		this.attackTimer++;
		if (this.attackTimer >= 120) {
			this.setAttackingState(0);
			this.attr = 0;
			this.attackTimer = -5;
			this.setDefendingState(1);
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 10, true, true));
			this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 2, true, true));
			// 停止所有动画状态
			attackAnimationState.stop();
			attackAnimationState2.stop();
			attackAnimationState3.stop();
			attackAnimationState4.stop();
		}

		//System.out.println("----"+this.attackTimer);
	}
//	static class AttackGoal extends Goal {
//		private final EntityMuHeisen parentEntity;
//		protected int attackTimer = 0;
//
//		public AttackGoal(EntityMuHeisen ghast) {
//			this.parentEntity = ghast;
//		}
//
//		public boolean canUse() {
//			return this.parentEntity.getTarget() != null;
//		}
//
//		public void start() {
//			super.start();
//			this.parentEntity.setAggressive(true);
//		}
//
//		@Override
//		public void stop() {
//			super.stop();
//			this.parentEntity.setAggressive(false);
//			this.parentEntity.setAttackingState(0);
//			this.attackTimer = -1;
//		}
//
//		public void tick() {
//			LivingEntity livingentity = this.parentEntity.getTarget();
//			if (livingentity!=null && this.parentEntity.hasLineOfSight(livingentity)) {
//				Level world = this.parentEntity.level();
//                if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
//                {
//              	  ++this.attackTimer;
//                }
//                else {
//     	          this.parentEntity.setDefendingState(0);
//                }
//				Random rand = new Random();
//				Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
//				double d0 = Math.min(livingentity.getY(), livingentity.getY());
//				double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
//				double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
//				double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
//				double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
//				float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
//						livingentity.getX() - parentEntity.getX());
//
//				if (this.attackTimer == 5) {
//					if ((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.50) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.53))
//					|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.30) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.33))
//					|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.10) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.16))) {
//						this.parentEntity.getNavigation().stop();
//
//						this.parentEntity.setAttackingState(2);
//					}
//					else if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.70) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.75))
//					|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.89) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.95))
//					|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.19) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.26)))
//					{
//						this.parentEntity.getNavigation().stop();
//						this.parentEntity.pre=this.parentEntity.attr;
//			        	this.parentEntity.attr=3;
//			        	this.parentEntity.setAttackingState(3);
//
//					}
//					else if((parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.81) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.85))
//						|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.61) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.65))
//						|| (parentEntity.getHealth() >= (parentEntity.getMaxHealth() * 0.03) && parentEntity.getHealth() <= (parentEntity.getMaxHealth() * 0.08)))
//					{
//						this.parentEntity.getNavigation().stop();
//						for (int l = 0; l < 16; ++l) {
//							float f1 = f + (float) l * (float) Math.PI * 0.4F;
//							for (int y = 0; y < 5; ++y) {
//								this.parentEntity.performRangedAttack(livingentity, f);
//							}
//							parentEntity.level().playLocalSound(this.parentEntity.getX(), this.parentEntity.getY(),
//									this.parentEntity.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), SoundSource.HOSTILE,
//									1.0F, 1.0F, true);
//							this.parentEntity.pre=this.parentEntity.attr;
//				        	this.parentEntity.attr=4;
//				        	this.parentEntity.setAttackingState(4);
//						}
//					}
//					else
//					{
//						this.parentEntity.getNavigation().moveTo(livingentity,1.1D);
//						this.parentEntity.pre=this.parentEntity.attr;
//						this.parentEntity.attr=1;
//						this.parentEntity.setAttackingState(1);
//					}
//				}
//
//				if(this.attackTimer>=31 && this.attackTimer<=32 && this.parentEntity.getAttckingState()==3){
//					this.parentEntity.getNavigation().moveTo(livingentity,1.4D);
//
//					for (LivingEntity entity : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2))) {
//						if (this.parentEntity.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this.parentEntity) continue;
//						entity.hurt(this.parentEntity.damageSources().mobAttack(this.parentEntity), entity.getMaxHealth()*0.2f+ (float)this.parentEntity.random.nextInt(2));
//						//entity.hurt(damageSources().mobAttack((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_) + (float)this.random.nextInt(damage));
//					}
//
//					//EntityScreenShake.ScreenShake(this.parentEntity.level(), this.parentEntity.position(), 30.0f, 0.13f, 0, 40);
//					//System.out.println("yes!");
//
//					for (int l = 0; l < 16; ++l) {
//						float f1 = f + (float) l * (float) Math.PI * 0.4F;
//						for (int y = 0; y < 5; ++y) {
//							this.parentEntity.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), parentEntity.getX() + (double) Mth.cos(f1) * rand.nextDouble() * 5.5D,
//									d0+rand.nextFloat()*3, this.parentEntity.getZ() + (double) Mth.sin(f1) * rand.nextDouble() * 11.5D, rand.nextGaussian()*0.07, rand.nextGaussian()*0.07, rand.nextGaussian()*0.07);
//						}
//
//						parentEntity.level().playLocalSound(this.parentEntity.getX(), this.parentEntity.getY(),
//								this.parentEntity.getZ(), SoundEvents.METAL_FALL, SoundSource.HOSTILE,
//								1.0F, 1.0F, true);
//					}
//
//				}
//
//				if(this.attackTimer==45 && this.parentEntity.getAttckingState()==2){
//					for (int l = 0; l < 16; ++l) {
//						float f1 = f + (float) l * (float) Math.PI * 0.4F;
//						for (int y = 0; y < 5; ++y) {
//							parentEntity.spawnFlames(
//									parentEntity.getX() + (double) Mth.cos(f1) * rand.nextDouble() * 11.5D,
//									parentEntity.getZ() + (double) Mth.sin(f1) * rand.nextDouble() * 11.5D, d0, d1,
//									f1, 0);
//						}
//						parentEntity.level().playLocalSound(this.parentEntity.getX(), this.parentEntity.getY(),
//								this.parentEntity.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), SoundSource.HOSTILE,
//								1.0F, 1.0F, true);
//					}
//				}
//
//				if(this.attackTimer==39 && this.parentEntity.getAttckingState()==1){
//					for (LivingEntity entity : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(2))) {
//						if (this.parentEntity.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this.parentEntity) continue;
//						entity.hurt(this.parentEntity.damageSources().mobAttack(this.parentEntity), entity.getMaxHealth()*0.3f+ (float)this.parentEntity.random.nextInt(2));
//						//entity.hurt(damageSources().mobAttack((LivingEntity)this), (float)this.m_21133_(Attributes.f_22281_) + (float)this.random.nextInt(damage));
//					}
//				}
//
//				if(attackTimer==22 && this.parentEntity.getAttckingState()==4){
//					for(int i = 0; i < 5; ++i) {
//						float f1 = f + (float)i * (float)Math.PI * 1.4F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//
//					for(int k = 0; k < 8; ++k) {
//						float f2 = f + (float)k * (float)Math.PI * 9.0F / 8.0F + 1.2566371F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 1.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//				}
//
//				if(attackTimer==39 && this.parentEntity.getAttckingState()==4){
//					for(int i = 0; i < 5; ++i) {
//						float f1 = f + (float)i * (float)Math.PI * 2.8F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 3.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//
//					for(int k = 0; k < 8; ++k) {
//						float f2 = f + (float)k * (float)Math.PI * 1.8F / 8.0F + 1.2566371F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 3.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//				}
//
//				if(attackTimer==58 && this.parentEntity.getAttckingState()==4){
//					for(int i = 0; i < 5; ++i) {
//						float f1 = f + (float)i * (float)Math.PI * 1.6F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f1) * 5.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f1) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//
//					for(int k = 0; k < 8; ++k) {
//						float f2 = f + (float)k * (float)Math.PI * 8.0F / 8.0F + 1.2566371F;
//						EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX() + (double)Mth.cos(f2) * 5.5D, this.parentEntity.getY() + this.parentEntity.random.nextDouble(), this.parentEntity.getZ() + (double)Mth.sin(f2) * 1.5D,
//								BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
//						this.parentEntity.level().addFreshEntity(fallingBlockEntity);
//					}
//				}
//
//				if (this.attackTimer == 60) {
//					this.parentEntity.setAttackingState(0);
//					this.parentEntity.attr=0;
//					this.attackTimer = -5;
//					this.parentEntity.setDefendingState(1);
//      	            this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5,10,true,true));
//   	                this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5,2,true,true));
//                    //System.out.println("DD");
//
//				}
//			} else if (this.attackTimer > 0) {
//				--this.attackTimer;
//			}
//			this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
//		}
//
//	}

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
			//System.out.println("Fire!!!");
			SmallFireball fang = new SmallFireball(this.level(), x, (double) blockpos.getY() + d0, z,yaw,1,1);
			//fireballentity1.setPos((this.parentEntity.getX() + 3) + vector3d.x * 1.0D,
			//		this.parentEntity.getY(0.5D) + 0.5D, fireballentity.getZ() + vector3d.z * 1.0D);			//fang.level.addParticle(ParticleInit.MUCUS_PARTICLE.get(), blockpos.getX(), blockpos.getY(), blockpos.getZ(), 0,0,0);
        	//CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),this.level(), blockpos ,1.0F);
        	//CommonFunctions.spawnHexAround(ParticleTypes.DRIPPING_OBSIDIAN_TEAR,this.level(), this.blockPosition() ,1.0F);
//			DoomFireEntity fang = new DoomFireEntity(this.level(), x, (double) blockpos.getY() + d0, z, yaw, 1, this,
//					DoomConfig.SERVER.motherdemon_ranged_damage.get().floatValue());
			fang.setSecondsOnFire(tickCount);
			fang.setInvisible(false);
			this.level().addFreshEntity(fang);
		}
	}

	   public void performRangedAttack(LivingEntity p_34143_, float p_34144_) {
			//System.out.println("AOE!!!");
		         Vec3 vec3 = p_34143_.getDeltaMovement();
		         Random ran = new Random();
		         double d0 = p_34143_.getX() + vec3.x - this.getX();
		         double d1 = p_34143_.getEyeY() - (double)3.1F - this.getY();
		         double d2 = p_34143_.getZ() + vec3.z - this.getZ();
		         double d3 = Math.sqrt(d0 * d0 + d2 * d2);


		         Potion potion = PotionInit.DEADLY_POTION.get();


		         ThrownPotion thrownpotion = new ThrownPotion(this.level(), this);
		         thrownpotion.setItem(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
		         thrownpotion.setXRot(thrownpotion.getXRot() - -20.0F);
		         thrownpotion.shoot(d0, d1 + d3 * 0.2D, d2, 0.75F, 8.0F);
		         if (!this.isSilent()) {
		            this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundInit.ENTITY_HESEN_AMBIENT3.get(), this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
		         }

		         this.level().addFreshEntity(thrownpotion);
		   }

	private void spawnAttackparticle(float vec, float math) {
		if (this.level().isClientSide) {
			for (int i1 = 0; i1 < 40 + this.random.nextInt(12); ++i1) {
				double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
				double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
				double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
				float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
				float f = Mth.cos((this.getYRot() * ((float)Math.PI / 180)));
				float f1 = Mth.sin((this.getYRot() * ((float)Math.PI / 180)));
				double extraX = 1.2 * (double)Mth.sin(((float)(Math.PI + (double)angle)));
				double extraY = 3f;
				double extraZ = 1.2 * (double)Mth.cos((float)angle);
				double theta = (double)this.yBodyRot * (Math.PI / 180);
				double vecX = Math.cos(theta += 1.5707963267948966);
				double vecZ = Math.sin(theta);
				this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.getX() + (double)vec * vecX + extraX*5 + (double)(f * math),
						this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ*5 + (double)(f1 * math), 0, DeltaMovementY, 0);
			}
		}
	}
}

