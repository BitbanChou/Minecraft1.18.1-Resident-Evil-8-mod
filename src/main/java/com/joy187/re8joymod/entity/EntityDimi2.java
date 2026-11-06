package com.joy187.re8joymod.entity;

//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.ai.control.MoveControl;
//import net.minecraft.world.entity.boss.wither.WitherBoss;
//import net.minecraft.world.entity.monster.Monster;
//import net.minecraft.world.entity.projectile.LargeFireball;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.AABB;
//import net.minecraft.world.phys.Vec3;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import software.bernie.geckolib.animatable.GeoEntity;
//import software.bernie.geckolib.core.object.PlayState;
//import software.bernie.geckolib.core.animation.AnimatableManager;
//import software.bernie.geckolib.core.animation.AnimationState;;
//import software.bernie.geckolib.core.animation.RawAnimation;
//import software.bernie.geckolib.core.animation.AnimationController;
//import software.bernie.geckolib.core.animatable.GeoAnimatable;
//import software.bernie.geckolib.util.GeckoLibUtil;
//import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
//import net.minecraft.core.Direction;
//
//import java.util.List;
//import java.util.Random;
//
//import com.joy187.re8joymod.init.EffectInit;
//import com.joy187.re8joymod.init.SoundInit;
//import com.joy187.re8joymod.util.CommonFunctions;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.util.Mth;
//
//public class EntityDimi2 extends WitherBoss implements GeoEntity{
//
//    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
//	private int done=0;
//
//	public EntityDimi2(EntityType<? extends WitherBoss> type, Level worldIn) {
//		super(type, worldIn);
//		this.xpReward = 300;
//		this.done=0;
//		this.moveControl = new MoveHelperController(this);
//	}
//
//
//	public static AttributeSupplier.Builder prepareAttributes() {
//		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 350.0D).
//				add(Attributes.MOVEMENT_SPEED, 0.85D).
//				add(Attributes.FOLLOW_RANGE, 30.0D).
//				add(Attributes.FLYING_SPEED, (double)0.85F).
//				add(Attributes.ARMOR, 9.0D);
//	}
//
//	@Override
//	protected SoundEvent getDeathSound() {
//		Random ran = new Random();
//		int co = ran.nextInt(3);
//		if(co==0)
//		{
//			return SoundInit.ENTITY_DIMI_DEATH1.get();
//		}
//		else if(co==1) return SoundInit.ENTITY_DIMI_DEATH2.get();
//		return SoundEvents.BEE_DEATH;
//	}
//
//	protected SoundEvent getAmbientSound() {
//		Random ran = new Random();
//		int co = ran.nextInt(2);
//		if(co==0)
//		{
//			return SoundInit.ENTITY_DIMI_AMBIENT1.get();
//		}
//		return  SoundInit.ENTITY_DIMI_AMBIENT2.get();
//	}
//
//	@Override
//	protected SoundEvent getHurtSound(DamageSource source) {
//		Random ran = new Random();
//		int co = ran.nextInt(2);
//		if(co==0)
//		{
//			return SoundInit.ENTITY_DIMI_HURT1.get();
//		}
//		return SoundInit.ENTITY_DIMI_HURT2.get();
//	}
//
//	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
//		if((this.getHealth()>200f && this.getHealth()<220f) || (this.getHealth()>100f && this.getHealth()<120f)
//				|| (this.getHealth()>300f && this.getHealth()<320f) || (this.getHealth()>20f && this.getHealth()<60f)) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.flyup"));
//			this.attackAnim=2;
//			exatt();
//			return PlayState.CONTINUE;
//		}
//
//		if(this.getHealth()<60f) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.idle"));
//			this.attackAnim=2;
//			exatt();
//			if(this.getHealth()%5==0)
//				spawnFlames(this.getX(),this.getZ(),this.getY()+5,this.getY(),0,0);
//			return PlayState.CONTINUE;
//		}
//
//		if((this.getHealth()<200f && this.getHealth()>120f) || (this.getHealth()<100f && this.getHealth()>60f)){
//			this.done=0;
//		}
//
//
//		if (event.isMoving()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.fly"));
//			this.attackAnim=1;
//			return PlayState.CONTINUE;
//		}
//
//		event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.fly"));
//		return PlayState.CONTINUE;
//	}
//
//	@Override
//	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//		data.add(new AnimationController(this, "controller",
//				0, this::predicate));
//	}
//
//
//	@Override
//    public AnimatableInstanceCache getAnimatableInstanceCache() {
//        return this.factory;
//    }
//
//	//@Override
//	public void exatt() {
//		//super.baseTick();
//		if(this.attackAnim==2)
//		{
//			if(this.done==0){
//				this.getNavigation().moveTo(this.getX()+8+3*this.random.nextDouble(),this.getY()+this.getMaxHealth()/this.getHealth()+5*this.random.nextDouble(),this.getZ()+8+2*this.random.nextDouble(),1.5D);
//				this.setDeltaMovement(4+this.random.nextFloat(),2-this.random.nextFloat(),4+this.random.nextFloat());
//			}
//			float f2 = 10.0F;
//			int k1 = Mth.floor(this.getX() - (double) f2 - 2.0D-this.random.nextFloat());
//			int l1 = Mth.floor(this.getX() + (double) f2 + 2.0D+this.random.nextFloat());
//			int i2 = Mth.floor(this.getY() - (double) f2 - 2.0D-this.random.nextFloat());
//			int i1 = Mth.floor(this.getY() + (double) f2 + 2.0D+this.random.nextFloat());
//			int j2 = Mth.floor(this.getZ() - (double) f2 - 2.0D-this.random.nextFloat());
//			int j1 = Mth.floor(this.getZ() + (double) f2 + 2.0D+this.random.nextFloat());
//			List<Entity> list = this.level().getEntities(this,
//					new AABB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
//			for (int k2 = 0; k2 < list.size(); ++k2) {
//				Entity entity = list.get(k2);
//				if (entity instanceof LivingEntity) {
//					//entity.hurt(damageSources().IN_FIRE, 3*this.random.nextFloat());
//					//((LivingEntity)entity).addEffect(EffectInit.DEADLY.get(),20*10,1,true,true);
//					if(this.done==0)
//						entity.setDeltaMovement(0,3+2*this.random.nextDouble(),0);
//					if(this.getHealth()>0.1F || !this.dead)
//					{
//						if(entity.getBbWidth()>1 && entity.getBbHeight()>1.5){
//							((LivingEntity)entity).hurt(damageSources().mobAttack(this),((LivingEntity) entity).getMaxHealth()*0.4f);
//						}
//						else{
//							((LivingEntity)entity).hurt(damageSources().mobAttack(this),((LivingEntity) entity).getMaxHealth()*0.2f);
//
//						}
//						((LivingEntity)entity).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 30,1,true,true));
//						if(k2%2==0)((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30,0,true,true));
//					}
//					else {
//						((LivingEntity)entity).removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
//						((LivingEntity)entity).removeEffect(EffectInit.DEADLY.get());
//					}
//					//entity.level().addParticle(ParticleTypes.FLAME, entity.getX(), entity.getY(), entity.getZ(), 0,0,0);
//					//System.out.println("particle!!!");
//					//CommonFunctions.spawnCubeParticleAround(((LivingEntity)entity),ParticleTypes.FLAME,1.0F);
//				}
//			}
//			this.done=1;
//			//this.attackAnim=1;
//		}
//
//	}
//
//	public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
//		BlockPos blockpos = this.blockPosition();
//		boolean flag = false;
//		double d0 = 0.0D;
//		do {
//			BlockPos blockpos1 = blockpos.below();
//			BlockState blockstate = this.level().getBlockState(blockpos1);
//			if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
//				if (!this.level().isEmptyBlock(blockpos)) {
//					BlockState blockstate1 = this.level().getBlockState(blockpos);
//					VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
//					if (!voxelshape.isEmpty()) {
//						d0 = voxelshape.max(Direction.Axis.Y);
//					}
//				}
//				flag = true;
//				break;
//			}
//			blockpos = blockpos.below();
//		} while (blockpos.getY() >= Mth.floor(maxY) - 1);
//
//		if (flag) {
////			DoomFireEntity fang = new DoomFireEntity(this.level(), x, (double) blockpos.getY() + d0, z, yaw, 1, this,
////					DoomConfig.SERVER.motherdemon_ranged_damage.get().floatValue());
//			LargeFireball fang = new LargeFireball(this.level(), this, x, (double) blockpos.getY() + d0, z, 2);
//			fang.setSecondsOnFire(tickCount);
//			fang.setInvisible(false);
//			this.level().addFreshEntity(fang);
//		}
//	}
//
//
//	static class MoveHelperController extends MoveControl {
//		private final EntityDimi2 parentEntity;
//		private int courseChangeCooldown;
//
//		public MoveHelperController(EntityDimi2 ghast) {
//			super(ghast);
//			this.parentEntity = ghast;
//		}
//
//		public void tick() {
//			if (this.operation == Operation.MOVE_TO) {
//				if (this.courseChangeCooldown-- <= 0) {
//					this.courseChangeCooldown += this.parentEntity.getRandom().nextInt(5) + 2;
//					Vec3 vector3d = new Vec3(this.wantedX - this.parentEntity.getX(),
//							this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
//					double d0 = vector3d.length();
//					vector3d = vector3d.normalize();
//					if (this.canReach(vector3d, Mth.ceil(d0))) {
//						this.parentEntity
//								.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
//					} else {
//						this.operation = Operation.WAIT;
//					}
//				}
//
//			}
//		}
//
//		private boolean canReach(Vec3 p_220673_1_, int p_220673_2_) {
//			AABB axisalignedbb = this.parentEntity.getBoundingBox();
//
//			for (int i = 1; i < p_220673_2_; ++i) {
//				axisalignedbb = axisalignedbb.move(p_220673_1_);
//				if (!this.parentEntity.level().noCollision(this.parentEntity, axisalignedbb)) {
//					return false;
//				}
//			}
//
//			return true;
//		}
//	}
//
//
//}

		import com.joy187.re8joymod.init.SoundInit;
		import net.minecraft.core.BlockPos;
		import net.minecraft.core.Direction;
		import net.minecraft.core.particles.BlockParticleOption;
		import net.minecraft.core.particles.DustParticleOptions;
		import net.minecraft.core.particles.ParticleType;
		import net.minecraft.core.particles.ParticleTypes;
		import net.minecraft.network.syncher.EntityDataAccessor;
		import net.minecraft.network.syncher.EntityDataSerializers;
		import net.minecraft.network.syncher.SynchedEntityData;
		import net.minecraft.server.level.ServerBossEvent;
		import net.minecraft.server.level.ServerLevel;
		import net.minecraft.server.level.ServerPlayer;
		import net.minecraft.sounds.SoundEvent;
		import net.minecraft.sounds.SoundEvents;
		import net.minecraft.sounds.SoundSource;
		import net.minecraft.util.Mth;
		import net.minecraft.world.BossEvent;
		import net.minecraft.world.entity.*;
		import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
		import net.minecraft.world.entity.ai.attributes.Attributes;
		import net.minecraft.world.entity.ai.control.MoveControl;
		import net.minecraft.world.entity.ai.goal.FloatGoal;
		import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
		import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
		import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
		import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
		import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
		import net.minecraft.world.entity.boss.wither.WitherBoss;
		import net.minecraft.world.entity.monster.Husk;
		import net.minecraft.world.entity.monster.Monster;
		import net.minecraft.world.entity.player.Player;
		import net.minecraft.world.entity.projectile.LargeFireball;
		import net.minecraft.world.level.Level;
		import net.minecraft.world.level.block.state.BlockState;
		import net.minecraft.world.phys.AABB;
		import net.minecraft.world.phys.Vec3;
		import net.minecraft.world.phys.shapes.VoxelShape;
		import software.bernie.geckolib.animatable.GeoEntity;
		import software.bernie.geckolib.constant.DefaultAnimations;
		import software.bernie.geckolib.core.animatable.GeoAnimatable;
		import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
		import software.bernie.geckolib.core.animation.AnimatableManager;
		import software.bernie.geckolib.core.animation.AnimationController;
		import software.bernie.geckolib.core.animation.RawAnimation;
		import software.bernie.geckolib.core.object.PlayState;
		import software.bernie.geckolib.util.GeckoLibUtil;

		import java.awt.*;
		import java.util.List;
		import java.util.Random;
		import java.util.function.Predicate;


public class EntityDimi2 extends WitherBoss implements GeoEntity {
	private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
//	private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.NOTCHED_10)).setDarkenScreen(false).setCreateWorldFog(false).setPlayBossMusic(false);
	private static final EntityDataAccessor<Integer> ISPUGONG =
			SynchedEntityData.defineId(EntityDimi2.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> ISSKILL =
			SynchedEntityData.defineId(EntityDimi2.class, EntityDataSerializers.BOOLEAN);
	public static final AnimationState attackAnimationState = new AnimationState();
	public static final AnimationState attackAnimationState2 = new AnimationState();
	public static final AnimationState attackAnimationState3 = new AnimationState();
	public static final AnimationState attackAnimationState4 = new AnimationState();
	public static final AnimationState attackAnimationState5 = new AnimationState();
	private boolean isAscending = false; // 是否正在升空
	private boolean isDescending = false; // 是否正在落下
	private double targetY; // 目标高度

	public int attackAnimationTimeout = 30;
	private Vec3 originalMotion = Vec3.ZERO; // 保存原始速度

	public AnimationState[] getAnimations() {
		return new AnimationState[]{attackAnimationState, attackAnimationState2, attackAnimationState3, attackAnimationState4, attackAnimationState5};
	}

	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
		return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
	};

	public EntityDimi2(EntityType<? extends WitherBoss> p_32889_, Level p_32890_) {
		super(p_32889_, p_32890_);
		this.xpReward = 70;
		this.isNonBoss();
		this.moveControl = new MoveHelperController(this);
	}

	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 350.0D).
				add(Attributes.MOVEMENT_SPEED, 0.85D).
				add(Attributes.FOLLOW_RANGE, 30.0D).
				add(Attributes.FLYING_SPEED, (double)0.85F).
				add(Attributes.ARMOR, 9.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		//this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.0D));
//        this.goalSelector.addGoal(1, new EntityTyrantdd.AttackGoal());

		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.addBehaviourGoals();
	}

	protected void addBehaviourGoals() {
		this.targetSelector.addGoal(0, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ISPUGONG, 0);
		this.entityData.define(ISSKILL, false);
	}

	@Override
	public void tick() {
		super.tick();
		this.setYRot(this.yBodyRot);
		// 更新Boss信息条
		//this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		LivingEntity target = this.getTarget();
		// 确保技能仅在服务器端运行，并且怪物存活
		if (target != null) {
			if (this.distanceToSqr(target) <= 64.0D) { // 检查目标是否在范围内
				if(this.attackAnimationTimeout==50){
					this.setNoAi(true);
					this.originalMotion = this.getDeltaMovement(); // 保存当前速度
					int t = this.random.nextInt(6);
					if (t % 6 == 5) {
						// 决定使用哪个技能
						attackAnimationState5.start(this.tickCount);
						this.setPuGong(5);
						this.isAscending = true;
					}
					else if (t % 6 == 4 || t % 6 == 0) {
						// 决定使用哪个技能
						attackAnimationState4.start(this.tickCount);
						this.setPuGong(4);
					}
					else if (t % 6 == 3) {
						// 决定使用哪个技能
						attackAnimationState3.start(this.tickCount);
						this.setPuGong(3);
					}
					else if(t % 6 == 2){
						this.setPuGong(2);
						attackAnimationState2.start(this.tickCount);
					}
					else {
						this.setPuGong(1);
						attackAnimationState.start(this.tickCount);
					}

					//System.out.println(this.isPuGong());
				}
				//System.out.println(this.attackAnimationTimeout);
//                if(this.isPuGong()!=0){
//                    this.setMotion(Vec3.ZERO); // 设置速度为 0
//                }
				if(this.attackAnimationTimeout==40  && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*2,1,this.getRandom().nextFloat()*2);
				}

				if(this.attackAnimationTimeout==35  && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*-2,-1,this.getRandom().nextFloat()*-2);
				}

				if(this.attackAnimationTimeout==28 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*2,1,this.getRandom().nextFloat()*-2);
				}


				if(this.attackAnimationTimeout==23 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*-2,-1,this.getRandom().nextFloat()*2);
				}

				if(this.attackAnimationTimeout==14 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*-2,1,this.getRandom().nextFloat()*-2);
				}

				if(this.attackAnimationTimeout==8 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*-2,-1,this.getRandom().nextFloat()*-2);
				}

				if(this.attackAnimationTimeout==-7 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*2,1,this.getRandom().nextFloat()*-2);
				}

				if(this.attackAnimationTimeout==-13 && this.isPuGong()==2) {
					this.performSkill("attack02", target);
					this.getDeltaMovement().add(this.getRandom().nextFloat()*-2,-1,this.getRandom().nextFloat()*2);
				}

				if(this.attackAnimationTimeout==20 && this.isPuGong()==3) {
					this.performSkill("attack03", target);
				}

				if(this.attackAnimationTimeout==-5 && this.isPuGong()==3) {
					this.performSkill("attack03", target);
				}

				if(this.attackAnimationTimeout==-5 && this.isPuGong()==4) {
					this.performSkill("attack04", target);
				}

				if(this.attackAnimationTimeout==30 && this.isPuGong()==5) {
					this.targetY = this.getY() + 6.0; // 设置目标高度
					this.isAscending=true;
					this.isDescending=false;
					this.performSkill("attack05r", target);
				}

				if(this.attackAnimationTimeout==10 && this.isPuGong()==5) {
					this.isAscending=false;
					this.isDescending=true;
					this.performSkill("attack05d", target);
				}
			}
		}

		this.attackAnimationTimeout--;
		if(this.attackAnimationTimeout<=-20){
			this.setPuGong(0);
			attackAnimationState.stop();
			attackAnimationState2.stop();
			attackAnimationState3.stop();
			attackAnimationState4.stop();
			attackAnimationState5.stop();
			this.attackAnimationTimeout=60;
			this.setMotion(this.originalMotion); // 恢复速度
			this.setNoAi(false);
			this.isAscending=false;
			this.isDescending=false;
			this.setTarget(null);
		}

		if (this.isAscending) {
			double currentY = this.getY();
			if (currentY < this.targetY) {
				// 计算升空速度
				double speed = 6.0 / 20; // 1 秒内升到 4 米高（20 ticks）
				this.setDeltaMovement(0, speed, 0);
			} else {
				this.isAscending = false; // 停止升空
				this.setDeltaMovement(0, 0, 0); // 停止运动

				// 延迟 0.5 秒后开始下落
				this.level().getServer().execute(() -> {
					if (this.isAlive()) {
						this.isDescending = true; // 开始下落
					}
				});
			}
		}

		// 下落阶段
		if (this.isDescending) {
			double currentY = this.getY();
			if (currentY > this.getY() - 4.0) {
				// 计算下落速度
				double speed = -4.0 / 10; // 0.5 秒内落到地面（10 ticks）
				this.setDeltaMovement(0, speed, 0);
			} else {
				this.isDescending = false; // 停止下落
				this.setDeltaMovement(0, 0, 0); // 停止运动

				// 触发子技能
				performSubSkill1();
				performSubSkill2();
			}
		}

	}

	// 假设的方法用于执行技能，这里只是伪代码示例
	private void performSkill(String skillName, LivingEntity target) {

		switch (skillName) {
			case "attack01":
				if (this.distanceTo(target) <= 8) {

					// 触发效果技能
					performEffectSkill();

					// 延迟 24 ticks 后，重复 16 次伤害技能
					for (int i = 0; i < 16; i++) {
						this.level().getServer().execute(() -> {
							if (this.isAlive() && target.isAlive()) {
								performDamageSkill(target,1);
							}
						});
//                        try {
//                            Thread.sleep(50); // 1 tick = 50ms
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
					}
					this.level().explode((Entity)null, target.getX(), target.getY(), target.getZ(), (float)2, false, Level.ExplosionInteraction.NONE);

				}
				break;
			case "attack02":
				// 执行技能 attack02 的逻辑
				if (this.distanceTo(target) <= 8) {

					// 触发效果技能
					performEffectSkill();
					// 延迟 24 ticks 后，重复 16 次伤害技能
					for (int i = 0; i < 16; i++) {
						this.level().getServer().execute(() -> {
							if (this.isAlive() && target.isAlive()) {
								performDamageSkill(target,-1);
							}
						});
//                        try {
//                            Thread.sleep(50); // 1 tick = 50ms
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
					}
					this.level().explode((Entity)null, target.getX(), target.getY(), target.getZ(), (float)2, false, Level.ExplosionInteraction.NONE);
					spawnFlames(this.getX(),this.getZ(),this.getY()+5,this.getY(),0,0);

				}
				break;
			case "attack03":
				// 检测目标是否在 90° 视野范围内
				if (isTargetInFieldOfView(target, 90)) {
					// 播放声音
					this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 1.0F);
					this.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, 2.0F, 0.5F);

					performSubSkill01(target);
					// 延迟 8 ticks 后，重复 19 次子技能 1，每次间隔 2 ticks
//                    if (this.level() instanceof ServerLevel) {
//                        ServerLevel serverLevel = (ServerLevel) this.level();

					// 计算目标方向
					Vec3 direction = target.position().subtract(this.position()).normalize();

					// 生成多个投射物
					for (int i = -5; i < 5; i++) { // 生成 15 个刀刃
						EntityMoreauProjectile blade = new EntityMoreauProjectile(this.level(), this);
						//System.out.println("Blade！");
						// 设置投射物位置和速度
						Vec3 spawnPos = this.position().add(0, 1.5, 0); // 从实体头部发射
						blade.setPos(spawnPos.x+i, spawnPos.y, spawnPos.z+i);
						blade.shoot(direction.x, direction.y, direction.z, 2.5F, 1.0F); // 设置速度和精度

						// 将投射物添加到世界中
						this.level().addFreshEntity(blade);
					}
//                    }

					// 延迟 8 ticks 后，执行子技能 2
//                    this.level().getServer().execute(() -> {
//                        if (this.isAlive() && target.isAlive()) {
//                            performSubSkill02(target);
//                        }
//                    });
					performSubSkill02(target);
				}
				break;
			case "attack04":
				if (isTargetInFieldOfView(target, 180)) {
					// 播放声音
					this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 1.0F);
					this.playSound(SoundEvents.WARDEN_SONIC_CHARGE, 3.0F, 1.0F);
					performSubSkill04(target);

				}
				break;
			case "attack05r":
				if (this.distanceTo(target) <= 10) {
					// 播放声音
					this.playSound(SoundEvents.ENDER_DRAGON_FLAP, 2.0F, 0.75F);
					playParticleEffects();
					// 延迟 22 ticks 后播放粒子效果
					performSubSkill1(); // 触发子技能 1
				}
				break;
			case "attack05d":
				if (this.distanceTo(target) <= 10) {
					// 播放声音
					this.playSound(SoundEvents.ENDER_DRAGON_FLAP, 2.0F, 0.75F);
					playParticleEffects();
					performSubSkill2(); // 触发子技能 2

				}
				break;
		}

	}

	// 设置实体的运动速度
	public void setMotion(Vec3 motion) {
		this.setDeltaMovement(motion);
	}

	// 触发效果技能
	private void performEffectSkill() {
		// 播放粒子效果
		if (this.level() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) this.level();
			Vec3 pos = this.position();
			serverLevel.sendParticles(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 64, 8, 1, 8, 0.01);
		}

		// 播放声音
		this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
				SoundEvents.SCULK_VEIN_PLACE, SoundSource.HOSTILE, 2.0F, 1.0F);
	}

	private void lerpAtTarget(LivingEntity target,int posorneg) {
		Vec3 vec3 = this.getDeltaMovement();
		Vec3 vec31 = new Vec3(target.getX() - this.getX(), 0.0D, target.getZ() - this.getZ());
		if (vec31.lengthSqr() > 1.0E-7D) {
			vec31 = vec31.normalize().scale(0.4D).add(vec3.scale(0.2D));
		}

		this.setDeltaMovement(vec31.x*2*posorneg, (double)1d, vec31.z*2*posorneg);
	}

	// 检测目标是否在视野范围内
	private boolean isTargetInFieldOfView(LivingEntity target, float angle) {
		Vec3 lookVec = this.getLookAngle().normalize(); // 实体的前方方向
		Vec3 toTargetVec = target.position().subtract(this.position()).normalize(); // 目标方向

		double dot = lookVec.dot(toTargetVec); // 点积
		double targetAngle = Math.acos(dot) * (180 / Math.PI); // 计算夹角

		return targetAngle <= angle / 2; // 判断是否在视野范围内
	}

	// 锁定模型动画
	private void lockModel(boolean lock) {
		// 这里调用动画库的锁定模型方法
		System.out.println("Model locked: " + lock);
	}



	// 子技能 1
	private void performSubSkill01(LivingEntity target) {
		// 播放声音
		this.playSound(SoundEvents.PUFFER_FISH_BLOW_OUT, 2.0F, 0.75F);

		// 播放粒子效果
		if (this.level() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) this.level();
			Vec3 pos = target.position();

			// 红色灰尘粒子
			DustParticleOptions redDust1 = new DustParticleOptions(Vec3.fromRGB24(7744369).toVector3f(), 1.0F);
			DustParticleOptions redDust2 = new DustParticleOptions(Vec3.fromRGB24(16384394).toVector3f(), 1.0F);

			serverLevel.sendParticles(redDust1, pos.x, pos.y + 1.0, pos.z, 5, 2.0, 1.0, 2.0, 0.3);
			serverLevel.sendParticles(redDust2, pos.x, pos.y + 1.0, pos.z, 5, 2.0, 1.0, 2.0, 0.3);
		}
	}

	// 子技能 2
	private void performSubSkill02(LivingEntity target) {
		// 播放声音
		this.playSound(SoundEvents.ENDER_DRAGON_FLAP, 2.0F, 0.75F);

		// 延迟 42 ticks 后执行额外效果
		this.level().getServer().execute(() -> {
			if (this.isAlive() && target.isAlive()) {
				// 播放额外声音
				this.playSound(SoundEvents.ENDER_DRAGON_FLAP, 2.0F, 0.75F);

				// 触发额外效果
				performFanEffect(target);
			}
		});
	}

	// 子技能
	private void performSubSkill04(LivingEntity target) {
		// 播放声音
		this.playSound(SoundEvents.PARROT_FLY, 3.0F, 0.75F);

		// 播放粒子效果
		if (this.level() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) this.level();
			Vec3 startPos = this.position().add(0, 1.5, 0); // 从实体头部发射
			Vec3 endPos = target.position();
			Vec3 direction = endPos.subtract(startPos).normalize();

			// 沿直线发射粒子
			for (int i = 0; i < 20; i++) {
				Vec3 particlePos = startPos.add(direction.scale(i * 0.5));
				serverLevel.sendParticles(ParticleTypes.FLASH, particlePos.x, particlePos.y, particlePos.z, 1, 0, 0, 0, 0);
			}
		}

		// 对范围内的目标造成伤害
		performDamageSkill(target,2);
	}

	// 获取直线范围内的实体
	private List<LivingEntity> getEntitiesInLine(LivingEntity target, double radius) {
		Vec3 startPos = this.position().add(0, 1.5, 0); // 从实体头部发射
		Vec3 endPos = target.position();
		Vec3 direction = endPos.subtract(startPos).normalize();

		AABB area = new AABB(startPos, endPos).inflate(radius); // 直线范围
		return this.level().getEntitiesOfClass(LivingEntity.class, area);
	}

	// 额外效果
	private void performFanEffect(LivingEntity target) {
		// 这里实现额外的粒子或声音效果
		//System.out.println("Performing fan effect");
	}

	// 播放粒子效果
	private void playParticleEffects() {
		if (this.level() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) this.level();
			Vec3 pos = this.position();

			// 播放 sweepAttack 粒子效果
			for (int i = 0; i < 5; i++) {
				serverLevel.sendParticles(ParticleTypes.SWEEP_ATTACK, pos.x, pos.y + 1.0, pos.z, 1, 2.0, 0.25, 2.0, 0);
			}

			// 播放 cloud 粒子效果
			for (int i = 0; i < 250; i++) {
				double angle = 2 * Math.PI * i / 250;
				double x = pos.x + 12 * Math.cos(angle);
				double z = pos.z + 12 * Math.sin(angle);
				serverLevel.sendParticles(ParticleTypes.CLOUD, x, pos.y - 0.5, z, 1, 0.1, 0.05, 0.1, 0);
			}

			// 播放 CAMPFIRE_COSY_SMOKE 粒子效果
			for (int i = 0; i < 15; i++) {
				serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.x, pos.y, pos.z, 5, 3.0, 2.5, 3.0, 0);
				serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.x, pos.y, pos.z, 15, 1.2, 1.2, 1.2, 0);
			}
		}
	}

	// 子技能 1：对半径 4 范围内的目标造成伤害
	private void performSubSkill1() {
		List<LivingEntity> entitiesInRadius = getEntitiesInRadius(4.0);
		for (LivingEntity entity : entitiesInRadius) {
			if (!(entity instanceof EntityDimi2)) {
				entity.hurt(this.damageSources().mobAttack(this), 60.0F); // 造成伤害
				this.playSound(SoundEvents.SCULK_BLOCK_FALL, 2.0F, 1.0F); // 播放声音
			}
		}
	}

	// 子技能 2：对半径 12 范围内的目标造成伤害并击飞
	private void performSubSkill2() {
		List<LivingEntity> entitiesInRadius = getEntitiesInRadius(12.0);
		for (LivingEntity entity : entitiesInRadius) {
			if (!(entity instanceof EntityDimi2) && entity.onGround()) {
				entity.hurt(this.damageSources().mobAttack(this), 7.0F); // 造成伤害
				entity.setDeltaMovement(0, 2.0, 0); // 击飞目标
				this.playSound(SoundEvents.FIREWORK_ROCKET_BLAST, 2.0F, 0.5F); // 播放声音
			}
		}
	}

	// 获取半径范围内的实体
	private List<LivingEntity> getEntitiesInRadius(double radius) {
		AABB area = new AABB(this.getX() - radius, this.getY() - radius, this.getZ() - radius,
				this.getX() + radius, this.getY() + radius, this.getZ() + radius);
		return this.level().getEntitiesOfClass(LivingEntity.class, area);
	}

	// 攻击目标的方法，简化版本，用于演示
	private void attackTarget(LivingEntity target, float damage, double velocityX, double velocityY, ParticleType particle, BlockState blockState) {
		// 对目标造成伤害
		target.hurt(this.damageSources().mobAttack(this), damage);

		// 创建粒子效果
		for (int i = 0; i < 10; ++i) {
			Vec3 vec3 = new Vec3(((double) this.random.nextFloat() - 0.5D) * 0.1D,
					((double) this.random.nextFloat() - 0.5D) * 0.1D + 1.0D,
					((double) this.random.nextFloat() - 0.5D) * 0.1D);
			this.level().addParticle(new BlockParticleOption(particle, blockState),
					target.getX(), target.getY() + 1.0D, target.getZ(),
					vec3.x, vec3.y, vec3.z);
		}

		// 投掷效果可以在这里实现，例如发射射弹实体或移动自身位置等
	}

	private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {

		// 检测生物是否死亡
//		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
//			event.setAndContinue(RawAnimation.begin().thenPlay("death")); // 播放死亡动画
//			return PlayState.CONTINUE;
//		}

		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.fly"));
			return PlayState.CONTINUE;
		}

		event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.idle"));
		return PlayState.CONTINUE;
	}

	public static <T extends EntityDimi2 & GeoAnimatable> AnimationController<T> genericAttackAnimation(T animatable, RawAnimation attackAnimation) {
		return new AnimationController<>(animatable, "Attack", 0, event -> {
			if (animatable.isPuGong()!=0)
			{
//				if (attackAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
//					event.setAnimation(RawAnimation.begin().thenPlay("attack"));
//					attackAnimationState.stop();
//					//return PlayState.CONTINUE;
//				}
				if (attackAnimationState2.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
					event.setAnimation(RawAnimation.begin().thenPlay("animation.dimi2.attack2"));
					attackAnimationState2.stop();
					//return PlayState.CONTINUE;
				}
				if (attackAnimationState3.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
					event.setAnimation(RawAnimation.begin().thenPlay("animation.dimi2.attack3"));
					attackAnimationState3.stop();
					//return PlayState.CONTINUE;
				}
//				if (attackAnimationState4.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
//					event.setAnimation(RawAnimation.begin().thenPlay("attack4"));
//					attackAnimationState4.stop();
//					//return PlayState.CONTINUE;
//				}
				if (attackAnimationState5.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
					event.setAnimation(RawAnimation.begin().thenPlay("animation.dimi2.attack5"));
					attackAnimationState5.stop();
					//return PlayState.CONTINUE;
				}
			}
//            else if(animatable.isSkill())
//            {
//
//            }
//            else if(animatable.isSonic())
//            {
//
//            }
			event.getController().forceAnimationReset();

			return PlayState.CONTINUE;
		});
	}

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

	public boolean isNonBoss()
	{
		return false;
	}

//	public void startSeenByPlayer(ServerPlayer p_184178_1_) {
//		super.startSeenByPlayer(p_184178_1_);
//		this.bossInfo.addPlayer(p_184178_1_);
//	}
//
//	public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
//		super.stopSeenByPlayer(p_184203_1_);
//		this.bossInfo.removePlayer(p_184203_1_);
//	}

	public void setPuGong(int attacking) {
		this.entityData.set(ISPUGONG, attacking);
	}

	public int isPuGong() {
		return this.entityData.get(ISPUGONG);
	}

	public void setSkill(boolean attacking) {
		this.entityData.set(ISSKILL, attacking);
	}

	public boolean isSkill() {
		return this.entityData.get(ISSKILL);
	}

	// 触发伤害技能
	private void performDamageSkill(LivingEntity target,int leftOrRight) {
		// 获取该生物的前方方向
		Vec3 forward = this.getLookAngle().normalize();

		// 遍历范围内的生物
		for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), LIVING_ENTITY_SELECTOR)) {
			if (!(lvt instanceof EntityDimi2)) {
				// 计算目标生物相对于该生物的方向
				Vec3 toTarget = lvt.position().subtract(this.position()).normalize();

				// 计算夹角（点积公式）
				double dot = forward.dot(toTarget); // 点积
				double angle = Math.acos(dot) * (180 / Math.PI); // 转换为角度

				// 判断是否在 180° 范围内
				if (angle <= 45*leftOrRight) { // 90° 表示前方 180° 范围
					// 击退逻辑
					double d00 = lvt.getX() - this.getX();
					double d10 = lvt.getZ() - this.getZ();
					double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
					lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);

					// 伤害逻辑
					lvt.hurt(lvt.damageSources().mobAttack(this), 5 + lvt.getMaxHealth() * 0.1F + lvt.getArmorValue());
				}
			}
		}

		// 播放粒子效果
		if (this.level() instanceof ServerLevel) {
			ServerLevel serverLevel = (ServerLevel) this.level();
			Vec3 pos = target.position();
			serverLevel.sendParticles(ParticleTypes.SMOKE, pos.x, pos.y, pos.z, 5, 0.75, 0.01, 0.01, 0.01);
		}

		// 播放声音
		this.level().playSound(null, target.getX(), target.getY(), target.getZ(),
				SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.HOSTILE, 2.0F, 0.5F);
	}

	// 检测范围内的生物
	private List<LivingEntity> getNearbyEntities(double radius) {
		AABB area = new AABB(this.getX() - radius, this.getY() - radius, this.getZ() - radius,
				this.getX() + radius, this.getY() + radius, this.getZ() + radius);
		return this.level().getEntitiesOfClass(LivingEntity.class, area);
	}

	static class MoveHelperController extends MoveControl {
		private final EntityDimi2 parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(EntityDimi2 ghast) {
			super(ghast);
			this.parentEntity = ghast;
		}

		public void tick() {
			if (this.operation == Operation.MOVE_TO) {
				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRandom().nextInt(5) + 2;
					Vec3 vector3d = new Vec3(this.wantedX - this.parentEntity.getX(),
							this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
					double d0 = vector3d.length();
					vector3d = vector3d.normalize();
					if (this.canReach(vector3d, Mth.ceil(d0))) {
						this.parentEntity
								.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
					} else {
						this.operation = Operation.WAIT;
					}
				}

			}
		}

		private boolean canReach(Vec3 p_220673_1_, int p_220673_2_) {
			AABB axisalignedbb = this.parentEntity.getBoundingBox();

			for (int i = 1; i < p_220673_2_; ++i) {
				axisalignedbb = axisalignedbb.move(p_220673_1_);
				if (!this.parentEntity.level().noCollision(this.parentEntity, axisalignedbb)) {
					return false;
				}
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
//			DoomFireEntity fang = new DoomFireEntity(this.level(), x, (double) blockpos.getY() + d0, z, yaw, 1, this,
//					DoomConfig.SERVER.motherdemon_ranged_damage.get().floatValue());
			LargeFireball fang = new LargeFireball(this.level(), this, x, (double) blockpos.getY() + d0, z, 2);
			fang.setSecondsOnFire(tickCount);
			fang.setInvisible(false);
			this.level().addFreshEntity(fang);
		}
	}
}
