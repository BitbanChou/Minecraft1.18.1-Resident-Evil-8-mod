package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class EntityAsh extends Animal implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> RIDE = SynchedEntityData.defineId(EntityAsh.class,
            EntityDataSerializers.INT);
    public EntityAsh(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.xpReward = 40;
        //this.rid=false;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D).
                add(Attributes.MOVEMENT_SPEED, 0.245D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ClimbOnTopOfPowderSnowGoal(this, this.level()));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, EntityChief.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, EntityZealot.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, EntityVillagerGanado.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(11, new LookAtPlayerGoal(this, Player.class, 10.0F));
    }

    @Override
    public void tick() {
        //System.out.println(this.getRidingState());
        if (this.getVehicle() != null && (this.getVehicle() instanceof EntityVillagerGanado || this.getVehicle() instanceof EntityZealot) && this.getVehicle().isAlive() && !this.level().isClientSide()) {
            Entity mount = this.getVehicle();
            if (mount instanceof LivingEntity && ((LivingEntity) mount).getHealth()<1F) {
                this.stopRiding();
                ExperienceOrb.award((ServerLevel)this.level(), this.position(), this.random.nextInt(20,40));
                //this.hurt(damageSources().mobAttack(this).bypassInvul().bypassArmor() , (float)this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE));
            }
//            else if (mount.isAlive() && mount.isOnFire()) {
//                this.setRemainingFireTicks(20);
//                this.stopRiding();
//            } else if (mount.isAlive() && this.tickCount % 20 == 0) {
//                this.doHurtTarget(mount);
//            }

        } else if (getVehicle() == null) {
            //this.rid=false;
        }

        super.tick();
    }

    public void stopRiding() {
        Entity entity = this.getVehicle();
        this.setRidingState(0);
        super.stopRiding();
        if (entity != null && entity != this.getVehicle() && !this.level().isClientSide) {
            this.dismountVehicle(entity);
        }
    }

    private void dismountVehicle(Entity p_21029_) {
        Vec3 vec3;
        if (this.isRemoved()) {
            vec3 = this.position();
        } else if (!p_21029_.isRemoved() && !this.level().getBlockState(p_21029_.blockPosition()).is(BlockTags.PORTALS)) {
            vec3 = p_21029_.getDismountLocationForPassenger(this);
        } else {
            double d0 = Math.max(this.getY(), p_21029_.getY());
            vec3 = new Vec3(this.getX(), d0, this.getZ());
        }

        this.dismountTo(vec3.x, vec3.y, vec3.z);
    }
//    @Override
//    public double getMyRidingOffset() {
//        if (this.isPassenger()) {
//            if (this.getVehicle() instanceof EntityVillagerGanado || this.getVehicle() instanceof EntityZealot) {
//                return this.getVehicle().getBbHeight()/2  - 0.85F;
//            } else {
//                return this.getVehicle().getBbHeight() * 0.65D - 1.0D;
//            }
//        } else {
//            return super.getMyRidingOffset();
//        }
//    }

    public boolean startRiding(Entity p_20330_) {
        this.setRidingState(1);
        //        return this.rid;
        return this.startRiding(p_20330_, false);
    }

    @Override
    public void push(Entity entityIn) {
        super.push(entityIn);

        if ((entityIn instanceof EntityVillagerGanado || entityIn instanceof EntityZealot) && !(entityIn instanceof Player) && !this.isPassenger()) {
//            if (!this.isSummoned()) {
//                ((LivingEntity) entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 3*20, 0));
//            }

            this.startRiding(entityIn);
//            this.long_live = true;
        }
    }

    public int getRidingState() {
        return this.entityData.get(RIDE);
    }

    public void setRidingState(int time) {
        this.entityData.set(RIDE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIDE, 0);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.getRidingState()==1) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ash.flee"));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ash.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.ash.idle"));
        return PlayState.CONTINUE;
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(this.getRidingState()==1){
            return SoundInit.ENTITY_ASH_HURT1.get();
        }
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==0)
        {
            return SoundInit.ENTITY_ASH_AMBIENT1.get();
        }
        else if(co==3) SoundInit.ENTITY_ASH_AMBIENT3.get();
        return SoundInit.ENTITY_ASH_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_ASH_HURT2.get();
        return SoundInit.ENTITY_ASH_HURT1.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_ASH_HURT1.get();
    }

    @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
}
