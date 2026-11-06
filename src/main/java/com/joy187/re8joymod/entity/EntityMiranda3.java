package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
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


public class EntityMiranda3 extends WitherBoss implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityMiranda3(EntityType<? extends WitherBoss> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 300;
		this.moveControl = new MoveHelperController(this);
	}


	public static AttributeSupplier.Builder prepareAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 300.0D).
				add(Attributes.MOVEMENT_SPEED, 0.65D).
				add(Attributes.FOLLOW_RANGE, 30.0D).
				add(Attributes.ARMOR, 15.0D);
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
	private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

		if (event.isMoving()) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda3.fly"));
			if((this.getHealth()>200f && this.getHealth()<240f) || (this.getHealth()>100f && this.getHealth()<125f)
					|| (this.getHealth()>30f && this.getHealth()<60f))
			{
				this.attackAnim=2;
				exatt();
			}
			else {
				this.attackAnim=1;
			}
			return PlayState.CONTINUE;
		}

		event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda3.idle"));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller",
				0, this::predicate));
	}


	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }



	//@Override
	public void exatt() {
		//super.baseTick();
		if(this.attackAnim==2)
		{
			float f2 = 10.0F;
			int k1 = Mth.floor(this.getX() - (double) f2 - 5.0D);
			int l1 = Mth.floor(this.getX() + (double) f2 + 5.0D);
			int i2 = Mth.floor(this.getY() - (double) f2 - 5.0D);
			int i1 = Mth.floor(this.getY() + (double) f2 + 5.0D);
			int j2 = Mth.floor(this.getZ() - (double) f2 - 5.0D);
			int j1 = Mth.floor(this.getZ() + (double) f2 + 5.0D);
			List<Entity> list = this.level().getEntities(this,
					new AABB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
			for (int k2 = 0; k2 < list.size(); ++k2) {
				Entity entity = list.get(k2);
				if (entity instanceof LivingEntity) {
					//entity.hurt(damageSources().IN_FIRE, 3*this.random.nextFloat());
					//((LivingEntity)entity).addEffect(EffectInit.DEADLY.get(),20*10,1,true,true);
					if(((LivingEntity) entity).hasEffect(EffectInit.DEADLY.get())){
						entity.teleportTo(this.getX()+this.random.nextInt(3),this.getY(),this.getZ()+this.random.nextInt(3));
					}
					if(this.getHealth()>0.1F || !this.dead)
					{
						((LivingEntity)entity).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 30,1,true,true));
						if(k2%2==0)((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30,0,true,true));
					}
					else {
						((LivingEntity)entity).removeEffect(MobEffects.BLINDNESS);
						((LivingEntity)entity).removeEffect(EffectInit.DEADLY.get());
					}
					//entity.level().addParticle(ParticleTypes.FLAME, entity.getX(), entity.getY(), entity.getZ(), 0,0,0);
					//System.out.println("particle!!!");
					//CommonFunctions.spawnCubeParticleAround(((LivingEntity)entity),ParticleTypes.FLAME,1.0F);
				}
			}
			//this.attackAnim=1;
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
//			DoomFireEntity fang = new DoomFireEntity(this.level(), x, (double) blockpos.getY() + d0, z, yaw, 1, this,
//					DoomConfig.SERVER.motherdemon_ranged_damage.get().floatValue());
			LargeFireball fang = new LargeFireball(this.level(), this, x, (double) blockpos.getY() + d0, z, 2);
			fang.setSecondsOnFire(tickCount);
			fang.setInvisible(false);
			this.level().addFreshEntity(fang);
		}
	}


	static class MoveHelperController extends MoveControl {
		private final EntityMiranda3 parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(EntityMiranda3 ghast) {
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

	protected void customServerAiStep() {

		super.customServerAiStep();



		if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
		{
			this.convertTo(EntityInit.MIRANDA4.get(),true);
		}
	}


}