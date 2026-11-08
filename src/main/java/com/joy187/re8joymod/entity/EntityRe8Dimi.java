package com.joy187.re8joymod.entity;


import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntityFly extends Vex implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    @Nullable
    private LivingEntity owner; // 生物的所有者
    private int lifetime;
    double X,Y,Z; // 存活时间（以 ticks 为单位）
    private float ownerHealth; // 所有者的初始血量
    /** Lady D phase: chase target, DoT, then return control to EntityRe8Dimi. */
    private boolean dimiSwarm;


    public EntityFly(EntityType<? extends Vex> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
        this.lifetime=100;
        this.dimiSwarm = false;
    }

    // 自定义构造函数，传入 owner、血量和存活时间
    private EntityFly(EntityType<? extends EntityFly> p_33984_, Level p_33985_, LivingEntity owner, float ownerHealth, int lifetime,double x,double y,double z) {
        super(p_33984_, p_33985_);
        this.owner = owner;
        this.ownerHealth = ownerHealth;
        this.lifetime = lifetime;
        this.X=x;
        this.Y=y;
        this.Z=z;
    }




    // 静态方法，用于创建 EntityFly 实例
    public static EntityFly create(Level level, LivingEntity owner, float ownerHealth, int lifetime,double posX, double posY, double posZ) {
        return new EntityFly(EntityInit.FLY.get(), level, owner, ownerHealth, lifetime, posX, posY, posZ);
    }

    /** Dimi2 fly-breath swarm: short-lived flies that chase a target, no sister conversion. */
    public static EntityFly createBreathSwarm(Level level, LivingEntity target, double x, double y, double z, int lifetime) {
        EntityFly fly = new EntityFly(EntityInit.FLY.get(), level);
        fly.moveTo(x, y, z, level.getRandom().nextFloat() * 360.0F, 0.0F);
        fly.owner = null;
        fly.lifetime = lifetime;
        fly.dimiSwarm = false;
        fly.setTarget(target);
        fly.setNoGravity(true);
        return fly;
    }

    /** Re8Dimi fly form: one fly for ~3s, DoT on target, then restore Lady D. */
    public static EntityFly createDimiSwarm(Level level, EntityRe8Dimi dimi, LivingEntity target, int lifetime) {
        EntityFly fly = new EntityFly(EntityInit.FLY.get(), level);
        fly.moveTo(dimi.getX(), dimi.getY() + 1.2D, dimi.getZ(), dimi.getYRot(), 0.0F);
        fly.owner = dimi;
        fly.ownerHealth = dimi.getHealth();
        fly.lifetime = lifetime;
        fly.dimiSwarm = true;
        fly.setTarget(target);
        fly.setNoGravity(true);
        return fly;
    }

    public void setLifetimeTicks(int ticks) {
        this.lifetime = ticks;
    }

    // 准备生物属性
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    // 动画逻辑
    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.fly.fly"));
        return PlayState.CONTINUE;
    }

    // 目标选择逻辑
    private static final Predicate<Entity> WARLOCK_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player) && !(entity instanceof EntityFly);
    };

    // 注册目标选择器
    @Override
    protected void registerGoals() {
        super.registerGoals();
        // this.goalSelector.addGoal(2, new EntityFly.AttackGoal(this));
    }

    // AI 逻辑
    @Override
    public void aiStep() {
        super.aiStep();

        // 检查存活时间
        if (this.lifetime > 0) {
            this.lifetime--;
            if (this.lifetime % 6 == 0) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.08, 0.0));
            }
            // Home toward current target so breath swarm actually travels.
            LivingEntity chase = this.getTarget();
            if (chase != null && chase.isAlive()) {
                Vec3 to = chase.position().add(0.0, chase.getBbHeight() * 0.4, 0.0).subtract(this.position());
                if (to.lengthSqr() > 0.01) {
                    Vec3 n = to.normalize().scale(0.45);
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.6).add(n));
                }
            }
            if (this.lifetime <= 0) {
                if (this.dimiSwarm && this.owner instanceof EntityRe8Dimi dimi) {
                    dimi.exitFlyForm(this.getX(), this.getY(), this.getZ());
                } else if (this.owner != null) {
                    LivingEntity convertedEntity = null;
                    if (this.owner instanceof EntityDaniela) convertedEntity = this.convertTo(EntityInit.BELA.get(), false);
                    else if (this.owner instanceof EntityCassandra) convertedEntity = this.convertTo(EntityInit.CASSANDRA.get(), false);
                    else if (this.owner instanceof EntityBela) convertedEntity = this.convertTo(EntityInit.DANIELA.get(), false);
                    if (convertedEntity != null) {
                        convertedEntity.setHealth(this.ownerHealth);
                        convertedEntity.moveTo(this.X, this.Y, this.Z);
                        this.level().addFreshEntity(convertedEntity);
                    }
                }
                this.discard();
                return;
            }

            // Lady D swarm: continuous damage while chasing.
            if (this.dimiSwarm && this.tickCount % 8 == 0) {
                LivingEntity chase1 = this.getTarget();
                if (chase1 != null && chase1.isAlive() && this.distanceTo(chase1) < 2.4D) {
                    float dmg = 2.5F + chase1.getMaxHealth() * 0.015F;
                    chase1.hurt(this.damageSources().mobAttack(this.owner != null ? this.owner : this), dmg);
                }
            }
        }

        // 目标选择逻辑
        if (this.getTarget() == null || this.getTarget().isDeadOrDying()) {
            if (this.dimiSwarm && this.owner instanceof EntityRe8Dimi dimi && dimi.getTarget() != null) {
                this.setTarget(dimi.getTarget());
            } else {
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(30), WARLOCK_AREA)) {
                    if (livingentity != this.owner) {
                        this.setTarget(livingentity);
                    } else {
                        this.setTarget(null);
                    }
                }
            }
        }
    }

    // 设置 owner
    public void setOwner1(LivingEntity owner) {
        this.owner = owner;
    }

    // 注册动画控制器
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    // 获取动画缓存
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }
}
