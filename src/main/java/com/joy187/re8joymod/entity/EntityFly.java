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


    public EntityFly(EntityType<? extends Vex> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
        this.lifetime=100;
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
            if(this.lifetime%6==0) this.getDeltaMovement().add(0,0.1,0);
            if (this.lifetime <= 0) {
                // 存活时间结束，转化为 owner 并恢复血量
                if (this.owner != null) {
//                    this.owner.setHealth(this.ownerHealth); // 恢复 owner 的血量
//                    this.owner.teleportTo(this.getX(), this.getY(), this.getZ()); // 将 owner 传送到当前位置
//                    this.convertTo(this.owner.getType(),false);
                    LivingEntity convertedEntity = null;
                    if(this.owner instanceof EntityDaniela) convertedEntity = this.convertTo(EntityInit.BELA.get(), false);
                    else if(this.owner instanceof EntityCassandra)  convertedEntity = this.convertTo(EntityInit.CASSANDRA.get(), false);
                    else if(this.owner instanceof EntityBela)  convertedEntity = this.convertTo(EntityInit.DANIELA.get(), false);
                    if (convertedEntity != null) {
                        convertedEntity.setHealth(this.ownerHealth); // 恢复 owner 的血量
                        convertedEntity.moveTo(this.X, this.Y, this.Z); // 移动到当前位置
                        this.level().addFreshEntity(convertedEntity);
                    }
                }
                this.discard(); // 移除当前生物
                return;
            }
        }

        // 目标选择逻辑
        if (this.getTarget() == null || this.getTarget().isDeadOrDying()) {
            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(30), WARLOCK_AREA)) {
                if (livingentity != this.owner) {
                    this.setTarget(livingentity);
                } else {
                    this.setTarget(null);
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
