package com.joy187.re8joymod.entity;

import java.util.EnumSet;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class EntitySamca extends Vex implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation AIM_LEFT_HAND = RawAnimation.begin().thenPlay("pose.aim.left");

    public EntitySamca(EntityType<? extends Vex> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.ATTACK_DAMAGE, 8.5D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.15D);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new EntitySamca.ChargeAttackGoal());
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }
    //我们生物的AI，决定使用哪种攻击方式
    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (EntitySamca.this.getTarget() != null && !EntitySamca.this.getMoveControl().hasWanted() && EntitySamca.this.random.nextInt(7) == 0) {
                return EntitySamca.this.distanceToSqr(EntitySamca.this.getTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return EntitySamca.this.getMoveControl().hasWanted() && EntitySamca.this.isCharging() && EntitySamca.this.getTarget() != null && EntitySamca.this.getTarget().isAlive();
        }

        public void start() {
            LivingEntity livingentity = EntitySamca.this.getTarget();
            Vec3 vector3d = livingentity.getEyePosition(1.0F);
            EntitySamca.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
            EntitySamca.this.setIsCharging(true);
            EntitySamca.this.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
        }

        public void stop() {
            EntitySamca.this.setIsCharging(false);
        }

        public void tick() {
            LivingEntity livingentity = EntitySamca.this.getTarget();
            if (EntitySamca.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                EntitySamca.this.doHurtTarget(livingentity);
                EntitySamca.this.setIsCharging(false);
            } else {
                double d0 = EntitySamca.this.distanceToSqr(livingentity);
                if (d0 < 9.0D) {
                    Vec3 vector3d = livingentity.getEyePosition(1.0F);
                    EntitySamca.this.moveControl.setWantedPosition(vector3d.x, vector3d.y, vector3d.z, 1.0D);
                }
            }

        }
    }
    //该状态播放器控制生物的各种动作
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> state) {
        //找到了敌人，就播放攻击动画
        if (this.isCharging())
        {
            this.attackAnim=1;
            state.setAndContinue(RawAnimation.begin().thenPlay("animation.samca.attack"));
            return PlayState.CONTINUE;
        }

        //平时就是飞行动画
        state.setAndContinue(RawAnimation.begin().thenPlay("animation.samca.fly"));
        return PlayState.CONTINUE;
    }

    //将我们之前的所有动画控制器进行注册
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

}
