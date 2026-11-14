package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.RegeneratorVariant;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
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

import java.util.Random;
import java.util.function.Predicate;

public class EntityRegenerator extends EntityDund2 implements GeoEntity{

    /** 头 / 背 / 腿 寄生虫掩码。 */
    public static final int PLAGA_HEAD = 1;
    public static final int PLAGA_BACK = 2;
    public static final int PLAGA_LEG = 4;

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(EntityRegenerator.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PLAGA_MASK =
            SynchedEntityData.defineId(EntityRegenerator.class, EntityDataSerializers.INT);
    protected int attackTimer = 0;
    private boolean plagasRolled;

	public EntityRegenerator(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 55;
	}
	
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new DundAttackGoal(this, 1.0D,false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
     }
    
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 0.1D).
                add(Attributes.ARMOR_TOUGHNESS, 0.1D).
                add(Attributes.ATTACK_DAMAGE, 6.5D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }
    
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        this.heal(0.5f+this.random.nextFloat());

        return flag;
    }
    
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
            return PlayState.STOP;
        }

        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
        {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.death"));
            return PlayState.CONTINUE;
        }
    	
    	if (event.isMoving()) {
    	    if(this.getHealth()>=this.getMaxHealth()*0.5)
            {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.walk"));
                return PlayState.CONTINUE;
            }
            else{
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.walk2"));
                return PlayState.CONTINUE;
            }
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dund.idle"));
        return PlayState.CONTINUE;
    }
    
	
	
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.dund.attack"))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.dund.attack2"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
		data.add(new AnimationController<>(this, "plaga", 4, state -> {
			if (this.getPlagaMask() == 0) {
				return PlayState.STOP;
			}
			state.setAndContinue(RawAnimation.begin().thenLoop("animation.regenerator.plaga"));
			return PlayState.CONTINUE;
		}));
	}
	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		if (state == 1) {
			this.triggerAnim("controller1", "slash");
		} else if (state == 2) {
			this.triggerAnim("controller1", "heavy");
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1 || time == 2) && prev != time) {
			this.startAttackAnim(time);
		}
	}




	
	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        if(this.getHealth()<this.getMaxHealth()*0.6){
            this.setVariant(RegeneratorVariant.MID);
        }

        if(this.getHealth()<this.getMaxHealth()*0.3){
            this.setVariant(RegeneratorVariant.LOW);
        }

        if(this.getHealth()<0.5 && this.random.nextFloat()<0.15 && !(this instanceof EntityRegenerator2)){
            this.convertTo(EntityInit.REGENERATOR2.get(),true);
        }
        //System.out.println(this.getHealth());
    }

	@Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.level().isClientSide) {
            return false;
        }

        LivingEntity attacker = null;
        if (source.getEntity() instanceof LivingEntity living && living != this) {
            attacker = living;
        }

        int plagaHit = attacker == null ? -1 : this.resolvePlagaHit(attacker);
        if (plagaHit > 0) {
            float want = this.getMaxHealth() * 0.4F;
            float before = this.getHealth();
            boolean hurt = super.hurt(source, want);
            if (hurt) {
                this.clearPlaga(plagaHit);
                if (before - this.getHealth() < want - 0.5F) {
                    this.setHealth(Math.max(0.0F, before - want));
                    if (this.getHealth() <= 0.0F) {
                        this.die(source);
                    }
                }
                this.playSound(SoundEvents.SLIME_HURT, 1.2F, 0.7F);
            }
            return hurt;
        }

        if (source == this.damageSources().fellOutOfWorld()) {
            return super.hurt(source, amount);
        }
        // 本体极耐打：普通伤害压到 1
        return super.hurt(source, 1.0F);
    }

    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityRegenerator);
    };

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(PLAGA_MASK, 0);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason,
                                        @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        spawnData = super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
        if (!this.plagasRolled) {
            this.rollPlagas();
        }
        return spawnData;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
        if (tag.contains("PlagaMask")) {
            this.setPlagaMask(tag.getInt("PlagaMask"));
            this.plagasRolled = true;
        } else if (!this.level().isClientSide) {
            this.rollPlagas();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.putInt("PlagaMask", this.getPlagaMask());
    }

    public int getPlagaMask() {
        return this.entityData.get(PLAGA_MASK);
    }

    public void setPlagaMask(int mask) {
        this.entityData.set(PLAGA_MASK, mask & 7);
    }

    public boolean hasPlaga(int flag) {
        return (this.getPlagaMask() & flag) != 0;
    }

    public void clearPlaga(int flag) {
        this.setPlagaMask(this.getPlagaMask() & ~flag);
    }

    /** 随机生成 1~2 个寄生虫（头/背/腿）。 */
    public void rollPlagas() {
        int[] slots = {PLAGA_HEAD, PLAGA_BACK, PLAGA_LEG};
        for (int i = slots.length - 1; i > 0; --i) {
            int j = this.random.nextInt(i + 1);
            int tmp = slots[i];
            slots[i] = slots[j];
            slots[j] = tmp;
        }
        int count = 1 + this.random.nextInt(2);
        int mask = 0;
        for (int i = 0; i < count; ++i) {
            mask |= slots[i];
        }
        this.setPlagaMask(mask);
        this.plagasRolled = true;
    }

    private boolean isBackHit(Entity attacker) {
        Vec3 look = this.getLookAngle();
        Vec3 to = attacker.position().subtract(this.position());
        to = new Vec3(to.x, 0.0D, to.z);
        if (to.lengthSqr() < 1.0E-4D) {
            return false;
        }
        Vec3 flatLook = new Vec3(look.x, 0.0D, look.z);
        if (flatLook.lengthSqr() < 1.0E-4D) {
            return false;
        }
        return flatLook.normalize().dot(to.normalize()) < -0.5D;
    }

    /**
     * 根据攻击者相对位置/朝向判断打中了哪只寄生虫。
     * 背：身后；头：偏高或仰视；腿：偏低或俯视。
     */
    private int resolvePlagaHit(LivingEntity attacker) {
        int mask = this.getPlagaMask();
        if (mask == 0) {
            return -1;
        }
        boolean back = this.isBackHit(attacker);
        double relY = (attacker.getEyeY() - this.getY()) / Math.max(0.1D, this.getBbHeight());
        float pitch = attacker.getXRot();

        if (this.hasPlaga(PLAGA_BACK) && back) {
            return PLAGA_BACK;
        }
        if (this.hasPlaga(PLAGA_HEAD) && !back && (relY > 0.7D || pitch < -12.0F)) {
            return PLAGA_HEAD;
        }
        if (this.hasPlaga(PLAGA_LEG) && !back && (relY < 0.45D || pitch > 30.0F)) {
            return PLAGA_LEG;
        }
        // 只剩一只时稍微放宽对应部位
        if (Integer.bitCount(mask) == 1) {
            if (this.hasPlaga(PLAGA_BACK) && back) {
                return PLAGA_BACK;
            }
            if (this.hasPlaga(PLAGA_HEAD) && relY > 0.55D) {
                return PLAGA_HEAD;
            }
            if (this.hasPlaga(PLAGA_LEG) && (relY < 0.55D || pitch > 18.0F)) {
                return PLAGA_LEG;
            }
        }
        return -1;
    }

    public RegeneratorVariant getVariant() {
        return RegeneratorVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RegeneratorVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && !this.plagasRolled && this.tickCount == 1) {
            this.rollPlagas();
        }
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

            this.getNavigation().moveTo(livingentity, 1.1D);
            if (this.attackTimer == 5) {
                if (this.random.nextDouble() > 0.4)
                    this.setAttackingState(1);
                else
                    this.setAttackingState(2);
            }

            if (this.attackTimer == 15 && this.distanceTo(livingentity) < 3f && this.getAttckingState() == 1) {
                livingentity.hurt(livingentity.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
            }

            if (this.attackTimer == 15 && this.distanceTo(livingentity) < 2f && this.getAttckingState() == 2) {
                livingentity.hurt(livingentity.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
            }

            if (this.attackTimer == 20 && this.getAttckingState() == 2) {
                for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                    int val = lvt.getArmorValue();
                    if (lvt instanceof Player && ((Player) lvt).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(lvt, 50);
                    } else
                        lvt.hurt(lvt.damageSources().cactus(), val * (rand.nextInt(2) + 1) + lvt.getMaxHealth() * 0.2f);
                    this.heal(0.6f + this.random.nextFloat());
                }
            }

            if (this.attackTimer >= 21) {
                for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                    int val = lvt.getArmorValue();
                    if (lvt instanceof Player && ((Player) lvt).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
                        this.disableShield(lvt, 50);
                    } else
                        lvt.hurt(lvt.damageSources().cactus(), lvt.getMaxHealth() * 0.015f);
                }
            }

            if (this.attackTimer == 35) {
                this.setAttackingState(0);
                this.attackTimer = -5;
            }
            this.lookAt(livingentity, 30.0F, 30.0F);
        } else if (this.attackTimer > 0) {
            --this.attackTimer;
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
