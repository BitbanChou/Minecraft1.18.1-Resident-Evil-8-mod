package com.joy187.re8joymod.entity;

import java.util.*;
import java.util.function.Predicate;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import com.joy187.re8joymod.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntitySalaz extends Monster implements RangedAttackMob,GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final float[] xRotHeads = new float[2];
    private final float[] yRotHeads = new float[2];
    private final float[] xRotOHeads = new float[2];
    private final float[] yRotOHeads = new float[2];
    private final int[] nextHeadUpdate = new int[2];
    private final int[] idleHeadUpdates = new int[2];
    public float Laser_Mode_Progress;
    public float prev_Laser_Mode_Progress;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    //private final CMBossInfoServer bossEvent;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntitySalaz.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ISCHARGE = SynchedEntityData.defineId(EntitySalaz.class,
            EntityDataSerializers.BOOLEAN);

    private int mode_change_cooldown;
    private int skill_cooldown;

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.attackable() && !(p_31504_ instanceof EntitySalaz);
    };
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(20.0D).selector(LIVING_ENTITY_SELECTOR);


    public EntitySalaz(EntityType entity, Level world) {
        super(entity, world);
        this.mode_change_cooldown = 0;
        this.skill_cooldown = 160;
        this.xpReward = 300;
        this.moveControl = new FlyingMoveControl(this, 10, false);
    }

    protected PathNavigation createNavigation(Level p_186262_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_186262_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(1, new EntitySalaz.MissileLaunchGoal2(this, MISSILE_FIRE_FAST_ANIAMATION));
        //this.goalSelector.addGoal(1, new AttackAniamtionGoal3(this, STUN_ANIAMATION));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    public static Builder prepareAttributes() {
        return Monster.createMonsterAttributes().
                add(Attributes.MAX_HEALTH, 350.0D).
                add(Attributes.MOVEMENT_SPEED, 0.601D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.60000002384185).
                add(Attributes.FLYING_SPEED,0.701D).
                add(Attributes.ARMOR,10.01D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

//    public ItemEntity spawnAtLocation(ItemStack stack) {
//        ItemEntity itementity = this.m_5552_(stack, 0.0F);
//        if (itementity != null) {
//            itementity.m_146915_(true);
//            itementity.m_32064_();
//        }
//
//        return itementity;
//    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ISCHARGE, false);
        //this.entityData.define(IS_ACT, true);
        this.entityData.define(STATE, 0);
    }

//    public void addAdditionalSaveData(CompoundTag compound) {
//        super.addAdditionalSaveData(compound);
//        compound.m_128379_("Is_Act", this.getIsAct());
//    }
//
//    public void readAdditionalSaveData(CompoundTag compound) {
//        super.readAdditionalSaveData(compound);
//        this.setIsAct(compound.m_128471_("Is_Act"));
//        if (this.m_8077_()) {
//            this.bossEvent.m_6456_(this.m_5446_());
//        }
//
//        this.bossEvent.setId(this.m_20148_());
//    }

    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        //this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }
    
    public double calculateRange(DamageSource damagesource) {
        return damagesource.getEntity() != null ? this.distanceToSqr(damagesource.getEntity()) : -1.0D;
    }
    
    public boolean hurt(DamageSource source, float damage) {
        Entity entity1 = source.getEntity();
        if (entity1 instanceof EntitySalaz) {
            return false;
        }
        else if(source == damageSources().lightningBolt() || source == damageSources().fellOutOfWorld()){
            return super.hurt(source,damage);
        }
        else if(entity1 instanceof EntitySaddler || entity1 instanceof EntitySaddler2){
            return super.hurt(source,damage*5);
        }
        else if(source.getDirectEntity() instanceof ThrownEgg){
            return super.hurt(source,10);
        }
        else if(source.getDirectEntity() instanceof EntityGE){
            return super.hurt(source,this.getMaxHealth()*0.6f);
        }
        else if(source.getEntity() instanceof EntityChief || source.getEntity() instanceof EntitySaddler){
            return super.hurt(source,damage/3);
        }
        else if(source.getEntity() instanceof IronGolem){
            return super.hurt(source,damage/4);
        }
        else {
            for(int i = 0; i < this.idleHeadUpdates.length; ++i) {
                int[] var10000 = this.idleHeadUpdates;
                var10000[i] += 3;
            }

            double range = this.calculateRange(source);
            if (range > 8D) {
                return false;
            } else {
                if (this.destroyBlocksTick <= 0) {
                    this.destroyBlocksTick = 20;
                }

                if (!source.isIndirect()) {
                    damage = Math.min(10, damage);
                }

//                if (this.getAnimation() != STUN_ANIAMATION && this.getAnimation() != DEATHLASER_ANIMATION && "cataclysm.emp".equals(source.m_19385_())) {
//                    AnimationHandler.INSTANCE.sendAnimationMessage(this, STUN_ANIAMATION);
//                }

//                if (this.m_7090_()) {
                    Entity entity = source.getDirectEntity();
                    if (entity instanceof AbstractArrow) {
                        return false;
                    }
//                }

                return !source.isIndirect() ? false : super.hurt(source, damage);
            }
        }
    }

    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    public void aiStep() {
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D);
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        this.prev_Laser_Mode_Progress = this.Laser_Mode_Progress;
//        if (this.getHealth()<this.getMaxHealth()* 0.5f) {
//            //++this.Laser_Mode_Progress;
//            this.setAttackingState(2);
//        }
//
//        if (!this.getIsLaserMode() && this.Laser_Mode_Progress > 0.0F) {
//            --this.Laser_Mode_Progress;
//        }

        this.prevdeactivateProgress = this.deactivateProgress;
        if (!this.getIsAct() && this.deactivateProgress < 40.0F) {
            this.deactivateProgress = 40.0F;
        }

        if (this.getIsAct() && this.deactivateProgress > 0.0F) {
            --this.deactivateProgress;
        }

        if (this.getIsAct()) {
            if (this.skill_cooldown > 0) {
                --this.skill_cooldown;
            }

//            if (this.tickCount % 4 == 0) {
//                this.bossInfo.update();
//            }
        }

        if (!this.isSilent() && !this.level().isClientSide && this.deactivateProgress == 0.0F) {
            this.level().broadcastEntityEvent(this, (byte)67);
        }

        Entity entity = this.level().getEntity(this.getAlternativeTarget(0));
//        if (!this.level().isClientSide && this.getAlternativeTarget(0) > 0 && this.isAlive() && !this.getIsCharge() && this.getAnimation() != STUN_ANIAMATION && entity != null) {
//            double d0 = vec3.y;
//            double l0 = this.getAnimation() != MISSILE_FIRE_FAST_ANIAMATION && this.getAnimation() != MISSILE_FIRE_ANIAMATION && this.getAnimation() != LAUNCH_ANIAMATION ? 2.25D : 1.0D;
//            if (this.getY() < entity.getY() + l0) {
//                d0 = Math.max(0.0D, d0);
//                d0 += 0.3D - d0 * 0.6000000238418579D;
//            }
//
//            vec3 = new Vec3(vec3.x, d0, vec3.z);
//            Vec3 vec31 = new Vec3(entity.getX() - this.getX(), 0.0D, entity.getZ() - this.getZ());
//            if (vec31.horizontalDistanceSqr() > 25.0D && (this.getAnimation() != DEATHLASER_ANIMATION || this.getAnimationTick() <= 13) && this.getAnimation() != MISSILE_FIRE_ANIAMATION && this.getAnimation() != MISSILE_FIRE_FAST_ANIAMATION) {
//                Vec3 vec32 = vec31.normalize();
//                vec3 = vec3.add(vec32.x * 0.3D - vec3.x * 0.6D, 0.0D, vec32.z * 0.3D - vec3.z * 0.6D);
//            }
//        }

        LivingEntity target = this.getTarget();
//        if (this.getIsAct() && this.isAlive() && this.deactivateProgress == 0.0F && target != null && target.isAlive() && this.skill_cooldown <= 0 && (this.Laser_Mode_Progress == 30.0F || this.Laser_Mode_Progress == 0.0F)) {
//            if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() >= 3 && this.getRandom().nextFloat() * 100.0F < 3.0F) {
//                this.skill_cooldown = 240;
//                this.setAnimation(DEATHLASER_ANIMATION);
//            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.distanceToSqr(target) < 64.0D && (this.getRandom().nextFloat() * 100.0F < 4.0F && this.hasLineOfSight(target) || this.getRandom().nextFloat() * 100.0F < 20.0F && !this.hasLineOfSight(target))) {
//                this.skill_cooldown = 240;
//                this.setAnimation(CHARGE_ANIMATION);
//            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 3.0F && this.Laser_Mode_Progress == 0.0F) {
//                this.skill_cooldown = 240;
//                this.setAnimation(LAUNCH_ANIAMATION);
//            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 1.5F) {
//                this.skill_cooldown = 240;
//                Animation missile = this.m_7090_() ? MISSILE_FIRE_FAST_ANIAMATION : MISSILE_FIRE_ANIAMATION;
//                this.setAnimation(missile);
//            }
//        }

        this.setDeltaMovement(vec3);
        if (vec3.horizontalDistanceSqr() > 0.05D) {
            this.setYRot((float)Mth.atan2(vec3.z, vec3.x) * 57.295776F - 90.0F);
        }

        super.aiStep();

        int j;
        for(j = 0; j < 2; ++j) {
            this.yRotOHeads[j] = this.yRotHeads[j];
            this.xRotOHeads[j] = this.xRotHeads[j];
        }

        for(j = 0; j < 2; ++j) {
            int k = j ;
            Entity entity1 = null;
            if (k > 0) {
                entity1 = this.level().getEntity(k);
            }

            if (entity1 != null) {
                double d9 = this.getHeadX(j + 1);
                double d1 = this.getHeadY(j + 1);
                double d3 = this.getHeadZ(j + 1);
                double d4 = entity1.getX() - d9;
                double d5 = entity1.getEyeY() - d1;
                double d6 = entity1.getZ() - d3;
                double d7 = Math.sqrt(d4 * d4 + d6 * d6);
                float f = (float)(Mth.atan2(d6, d4) * 57.2957763671875D) - 90.0F;
                float f1 = (float)(-(Mth.atan2(d5, d7) * 57.2957763671875D));
                this.xRotHeads[j] = this.m_31442_(this.xRotHeads[j], f1, 40.0F);
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], f, 10.0F);
            } else {
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], this.yBodyRot, 10.0F);
            }
        }

        if (this.level().isClientSide && this.getIsAct()) {
            double d0 = (double)(this.random.nextFloat() - 0.5F) + this.getDeltaMovement().x;
            double d1 = (double)(this.random.nextFloat() - 0.5F) + this.getDeltaMovement().y;
            double d2 = (double)(this.random.nextFloat() - 0.5F) + this.getDeltaMovement().z;
            double dist = (double)(1.0F + this.random.nextFloat() * 0.2F);
            double d3 = d0 * dist;
            double d4 = d1 * dist;
            double d5 = d2 * dist;
            this.level().addParticle(ParticleInit.FLAME_PARTICLE.get(), this.getX() + d0, this.getY() + 2.0D, this.getZ() + d2, d3, d4, d5);
            if (entity != null && this.getAttckingState() != 0) {
                float f = Mth.cos(this.yBodyRot * 0.017453292F);
                float f1 = Mth.sin(this.yBodyRot * 0.017453292F);
                double theta = (double)this.yBodyRot * 0.017453292519943295D;
                ++theta;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                double vec = -1.75D;
                double math = 1.35D;

                int i1;
                float angle;
                double extraX;
                double extraY;
                double extraZ;
                for(i1 = 0; i1 < 10; ++i1) {
                    angle = 0.017453292F * this.yBodyRot + (float)i1;
                    extraX = (double)(0.2F * Mth.sin((float)(3.141592653589793D + (double)angle)));
                    extraY = 2.75D;
                    extraZ = (double)(0.2F * Mth.cos(angle));
                    this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.getX() + vec * vecX + extraX + (double)f * math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * math, 0.0D, -0.07D, 0.0D);
                    this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.getX() + vec * vecX + extraX + (double)f * -math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * -math, 0.0D, -0.07D, 0.0D);
                }

                for(i1 = 0; i1 < 5; ++i1) {
                    angle = 0.017453292F * this.yBodyRot + (float)i1;
                    extraX = (double)(0.2F * Mth.sin((float)(3.141592653589793D + (double)angle)));
                    extraY = 2.75D;
                    extraZ = (double)(0.2F * Mth.cos(angle));
                    this.level().addParticle(ParticleTypes.SQUID_INK, this.getX() + vec * vecX + extraX + (double)f * math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * math, 0.0D, -0.07D, 0.0D);
                    this.level().addParticle(ParticleTypes.SQUID_INK, this.getX() + vec * vecX + extraX + (double)f * -math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * -math, 0.0D, -0.07D, 0.0D);
                }
            }

            if (this.getAttckingState() == 2) {
                for(int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX(1.5D), this.getRandomY(), this.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }

    }

    private void blockbreak() {
        if (this.getIsCharge()) {
            if (!this.level().isClientSide && ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                boolean flag = false;
                AABB aabb = this.getBoundingBox().inflate(1.5D, 0.2D, 1.5D);
                Iterator var3 = BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ)).iterator();

                label95:
                while(true) {
                    while(true) {
                        BlockPos blockpos;
                        BlockState blockstate;
                        do {
                            FluidState fluidState;
                            do {
                                do {
                                    do {
                                        do {
                                            if (!var3.hasNext()) {
                                                if (flag) {
                                                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                                                }
                                                break label95;
                                            }

                                            blockpos = (BlockPos)var3.next();
                                            blockstate = this.level().getBlockState(blockpos);
                                            fluidState = this.level().getFluidState(blockpos);
                                        } while(blockstate.getBlock() instanceof AirBlock);
                                    } while(!blockstate.canEntityDestroy(this.level(), blockpos, this));
                                } while(!fluidState.isEmpty());
                            } while(blockstate.is(Blocks.BEDROCK));
                        } while(!ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate));

                        if (this.random.nextInt(3) == 0 && !blockstate.hasBlockEntity()) {
                            FireEntity fallingBlockEntity = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
                            fallingBlockEntity.setBlock(Blocks.BLACKSTONE.defaultBlockState());
                            flag = this.level().destroyBlock(blockpos, false, this) || flag;
                            fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + this.random.nextDouble()) / 3.0D, 0.2D + this.getRandom().nextGaussian() * 0.15D, (-1.2D + this.random.nextDouble()) / 3.0D)));
                            this.level().addFreshEntity(fallingBlockEntity);
                        } else {
                            flag = this.level().destroyBlock(blockpos, false, this) || flag;
                        }
                    }
                }
            }

            if (this.tickCount % 4 == 0) {
                Iterator var11 = this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5D)).iterator();

                while(var11.hasNext()) {
                    LivingEntity Lentity = (LivingEntity)var11.next();
                    if (!this.isAlliedTo(Lentity) && !(Lentity instanceof EntitySalaz) && Lentity != this) {
                        boolean flag = Lentity.hurt(Lentity.damageSources().mobAttack(this), (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(5)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)Lentity.getMaxHealth() * 0.2D)));
                        if (flag && Lentity.onGround()) {
                            double d0 = Lentity.getX() - this.getX();
                            double d1 = Lentity.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            float f = 1.5F;
                            Lentity.push(d0 / d2 * (double)f, 0.5D, d1 / d2 * (double)f);
                        }
                    }
                }
            }
        }

    }

    private void destoryblock2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
        } else {
            boolean flag = false;
            if (!this.getIsCharge() && !this.level().isClientSide && this.blockBreakCounter == 0 && ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                AABB aabb = this.getBoundingBox().inflate(0.2D);
                Iterator var3 = BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ)).iterator();

                label71:
                while(true) {
                    while(true) {
                        BlockPos pos;
                        BlockState blockstate;
                        FluidState fluidState;
                        do {
                            do {
                                do {
                                    do {
                                        if (!var3.hasNext()) {
                                            break label71;
                                        }

                                        pos = (BlockPos)var3.next();
                                        blockstate = this.level().getBlockState(pos);
                                        fluidState = this.level().getFluidState(pos);
                                    } while(blockstate.getBlock() instanceof AirBlock);
                                } while(!blockstate.canEntityDestroy(this.level(), pos, this));
                            } while(!fluidState.isEmpty());
                        } while(blockstate.is(Blocks.BEDROCK));

                        if (this.random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                            FireEntity fallingBlockEntity = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
                            fallingBlockEntity.setBlock(Blocks.BLACKSTONE.defaultBlockState());
                            flag = this.level().destroyBlock(pos, false, this) || flag;
                            fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + this.random.nextDouble()) / 3.0D, 0.2D + this.getRandom().nextGaussian() * 0.15D, (-1.2D + this.random.nextDouble()) / 3.0D)));
                            this.level().addFreshEntity(fallingBlockEntity);
                        } else {
                            flag = this.level().destroyBlock(pos, false, this) || flag;
                            this.setDeltaMovement(this.getDeltaMovement().multiply(0.6000000238418579D, 1.0D, 0.6000000238418579D));
                        }
                    }
                }
            }

            if (flag) {
                this.blockBreakCounter = 10;
                this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
            }

        }
    }

    private void destroyBlock() {
        if (!this.level().isClientSide && this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0 && ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                int j1 = Mth.floor(this.getY());
                int i2 = Mth.floor(this.getX());
                int j2 = Mth.floor(this.getZ());
                boolean flag = false;

                for(int j = -1; j <= 1; ++j) {
                    for(int k2 = -1; k2 <= 1; ++k2) {
                        for(int k = 0; k <= 3; ++k) {
                            int l2 = i2 + j;
                            int l = j1 + k;
                            int i1 = j2 + k2;
                            BlockPos blockpos = new BlockPos(l2, l, i1);
                            BlockState blockstate = this.level().getBlockState(blockpos);
                            if (!(blockstate.getBlock() instanceof AirBlock) && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(Blocks.BEDROCK) && ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                if (this.random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                                    FireEntity fallingBlockEntity = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
                                    fallingBlockEntity.setBlock(Blocks.LAVA.defaultBlockState());
                                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                                    fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + this.random.nextDouble()) / 3.0D, 0.2D + this.getRandom().nextGaussian() * 0.15D, (-1.2D + this.random.nextDouble()) / 3.0D)));
                                    this.level().addFreshEntity(fallingBlockEntity);
                                } else {
                                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                                }
                            }
                        }
                    }
                }

                if (flag) {
                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                }
            }
        }

    }

//    public InteractionResult m_6071_(Player player, InteractionHand hand) {
//        ItemStack itemstack = player.m_21120_(hand);
//        Item item = itemstack.m_41720_();
//        if (item == Items.f_42686_ && !this.getIsAct()) {
//            if (!player.m_7500_()) {
//                itemstack.m_41774_(1);
//            }
//
//            this.setIsAct(true);
//            return InteractionResult.SUCCESS;
//        } else {
//            return super.m_6071_(player, hand);
//        }
//    }

    protected void customServerAiStep() {
        this.fallDistance=0;
        if (this.getIsAct()) {
            if (this.deactivateProgress > 0.0F) {
                float k1 = this.deactivateProgress - 1.0F;
                if (k1 <= 0.0F && !this.isSilent()) {
                    this.level().globalLevelEvent(1023, this.blockPosition(), 0);
                }
            } else {
                super.customServerAiStep();

                for(int i = 1; i < 3; ++i) {
                    if (this.tickCount >= this.nextHeadUpdate[i - 1]) {
                        this.nextHeadUpdate[i - 1] = this.tickCount + 10 + this.random.nextInt(10);
                        int l1 = this.getAlternativeTarget(i);
                        if (l1 <= 0) {
                            List<LivingEntity> list = this.level().getNearbyEntities(LivingEntity.class, TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D));
                            if (!list.isEmpty()) {
                                LivingEntity livingentity1 = (LivingEntity)list.get(this.random.nextInt(list.size()));
                                this.setAlternativeTarget(i, livingentity1.getId());
                            }
                        } else {
                            LivingEntity livingentity = (LivingEntity)this.level().getEntity(l1);
                            if (livingentity != null && this.canAttack(livingentity) && this.distanceToSqr(livingentity) <= 1600.0D && this.hasLineOfSight(livingentity) && (this.Laser_Mode_Progress == 30.0F || this.Laser_Mode_Progress == 0.0F) && this.getAttckingState() == 1) {
                                this.performRangedAttack(i + 1, livingentity);
                                int f = this.getTarget()==null ? 15 + this.random.nextInt(5) : 30 + this.random.nextInt(20);
                                this.nextHeadUpdate[i - 1] = this.tickCount + f;
                                this.idleHeadUpdates[i - 1] = 0;
                            } else {
                                this.setAlternativeTarget(i, 0);
                            }
                        }
                    }
                }

                this.blockbreak();
                this.destroyBlock();
                if (this.getTarget() != null) {
                    this.destoryblock2();
                }

                if (this.mode_change_cooldown < 300) {
                    ++this.mode_change_cooldown;
                }
//                else if (this.getAnimation() == NO_ANIMATION) {
//                    this.setIsLaserMode(!this.getIsLaserMode());
//                    this.m_5496_((SoundEvent)ModSounds.HARBINGER_MODE_CHANGE.get(), 3.0F, 1.0F);
//                    this.mode_change_cooldown = this.random.nextInt(50);
//                }

                if (this.getTarget() != null) {
                    this.setAlternativeTarget(0, this.getTarget().getId());
                } else {
                    this.setAlternativeTarget(0, 0);
                }

                if (this.tickCount % 20 == 0) {
                    this.heal(1.0F);
                }
            }
        }

    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_SALAZAR_AMBIENT1.get();
        if(co==1) return SoundInit.ENTITY_SALAZAR_AMBIENT2.get();
        return SoundInit.ENTITY_SALAZAR_AMBIENT3.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundEvents.RAVAGER_HURT;
        return SoundEvents.SLIME_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==1) return SoundInit.ENTITY_MOREAU_DEATH.get();
        return SoundInit.ENTITY_SALAZAR_AMBIENT3.get();
    }

//    protected void onDeathAIUpdate() {
//        super.onDeathAIUpdate();
//        this.m_6478_(MoverType.SELF, new Vec3(0.0D, 0.15000000596046448D, 0.0D));
//        this.setYRot(this.f_19859_);
//        this.yBodyRot = this.m_146908_();
//        this.f_20885_ = this.m_146908_();
//        if (this.f_20919_ == 123 && !this.level().isClientSide) {
//            BlockInteraction explosion$blockinteraction = ForgeEventFactory.getMobGriefingEvent(this.level(), this) ? BlockInteraction.DESTROY : BlockInteraction.NONE;
//            this.level().m_46518_(this, this.getX(), this.getEyeY(), this.getZ(), 7.0F, false, explosion$blockinteraction);
//        }
//
//    }

    private double getHeadX(int head) {
        if (head <= 0) {
            return this.getX();
        } else {
            float f = (this.yBodyRot + (float)(180 * (head - 1))) * 0.017453292F;
            float f1 = Mth.cos(f);
            double f2 = this.getTarget()==null ? 1.65D : 1.5D;
            return this.getX() + (double)f1 * f2;
        }
    }

    private double getHeadY(int head) {
        return head <= 0 ? this.getY() + 3.0D : this.getY() + 2.6D;
    }

    private double getHeadZ(int head) {
        if (head <= 0) {
            return this.getZ();
        } else {
            float f = (this.yBodyRot + (float)(180 * (head - 1))) * 0.017453292F;
            float f1 = Mth.sin(f);
            double f2 = this.getTarget()==null ? 1.65D : 1.5D;
            return this.getZ() + (double)f1 * f2;
        }
    }

    private float m_31442_(float p_31443_, float p_31444_, float p_31445_) {
        float f = Mth.wrapDegrees(p_31444_ - p_31443_);
        if (f > p_31445_) {
            f = p_31445_;
        }

        if (f < -p_31445_) {
            f = -p_31445_;
        }

        return p_31443_ + f;
    }

    private void performRangedAttack(int head, LivingEntity target) {
        this.performRangedAttack(head, target.getX(), target.getY() + (double)target.getRandomY() * 0.5D, target.getZ(), target);
    }

    private void performRangedAttack(int head, double targetX, double targetY, double targetZ, LivingEntity target) {
        double d0 = this.getHeadX(head);
        double d1 = this.getHeadY(head);
        double d2 = this.getHeadZ(head);
        double d3 = targetX - d0;
        double d4 = targetY - d1;
        double d5 = targetZ - d2;
        if (this.getTarget()!=null && this.getAttckingState()==2) {

            DetonatorEntity laserBeam = new DetonatorEntity(this.level(), this);
            laserBeam.shoot(d3, d4, d5, 1.0F, 1.0F);
            laserBeam.setPosRaw(d0, d1, d2);
            this.level().addFreshEntity(laserBeam);
        } else {
            if (!this.isSilent()) {
                this.level().levelEvent((Player)null, 1024, this.blockPosition(), 0);
            }

//            DetonatorEntity witherskull = new DetonatorEntity(this, d3, d4, d5, this.level());
//            witherskull.shoot(d0, d1, d2);
//            this.level().addFreshEntity(witherskull);
        }

    }



//    protected void repelEntities(float x, float y, float z, float radius) {
//        super.repelEntities(x, y, z, radius);
//    }
//
//    public float getHeadYRot(int head) {
//        return this.yRotHeads[head];
//    }
//
//    public float getHeadXRot(int head) {
//        return this.xRotHeads[head];
//    }
//
    public int getAlternativeTarget(int head) {
        return 0;
    }

    public void setAlternativeTarget(int targetOffset, int newId) {
        //this.entityData.set(HEAD_TARGETS, newId);
    }
//
//    public void setIsLaserMode(boolean isLaserMode) {
//        this.entityData.set(LASER_MODE, isLaserMode);
//    }
//
//    public boolean getIsLaserMode() {
//        return (Boolean)this.entityData.get(LASER_MODE);
//    }

//    public void setIsAct(boolean isAct) {
//        this.entityData.set(IS_ACT, isAct);
//    }

    public boolean getIsAct() {
        return this.getAttckingState()==1;
    }

    public void setIsCharge(boolean isCharge) {
        this.entityData.set(ISCHARGE, isCharge);
    }

    public boolean getIsCharge() {
        return (Boolean)this.entityData.get(ISCHARGE);
    }

//    public void setOverload(int Overload) {
//        this.entityData.set(OVERLOAD, Overload);
//    }
//
//    public int getOverload() {
//        return (Integer)this.entityData.get(OVERLOAD);
//    }

    public boolean m_7090_() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public boolean canChangeDimensions() {
        return false;
    }


    public boolean canBeAffected(MobEffectInstance p_31495_) {
        return p_31495_.getEffect() != MobEffects.MOVEMENT_SLOWDOWN && p_31495_.getEffect() != MobEffects.POISON && p_31495_.getEffect() != EffectInit.BURN.get() && p_31495_.getEffect() != MobEffects.WITHER && p_31495_.getEffect() != EffectInit.PLAGAS.get() && super.canBeAffected(p_31495_);
    }

    @Override
    public void performRangedAttack(LivingEntity p_31468_, float p_31469_) {
        this.performRangedAttack(0, p_31468_);
    }


    static class AttackGoal extends Goal {
        private final EntitySalaz parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntitySalaz ghast) {
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
                ++this.attackTimer;
                Random rand = new Random();
                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());

                if (this.attackTimer==5) {
                    if((this.parentEntity.getHealth()<this.parentEntity.getMaxHealth() && this.parentEntity.getHealth()>this.parentEntity.getMaxHealth()*0.9) ||  (this.parentEntity.getHealth()<this.parentEntity.getMaxHealth()*0.5 && this.parentEntity.getHealth()>this.parentEntity.getMaxHealth()*0.65)
                            ||  (this.parentEntity.getHealth()<this.parentEntity.getMaxHealth()*0.35 && this.parentEntity.getHealth()>this.parentEntity.getMaxHealth()*0.3))
                    {
                        this.parentEntity.setAttackingState(1);
                        this.parentEntity.setIsCharge(true);
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION,40,0));
                    }
                    else if(this.parentEntity.getHealth()<this.parentEntity.getMaxHealth()*0.15 || (this.parentEntity.getHealth()<this.parentEntity.getMaxHealth()*0.5 && this.parentEntity.getHealth()>this.parentEntity.getMaxHealth()*0.35) ||  (this.parentEntity.getHealth()<this.parentEntity.getMaxHealth()*0.8 && this.parentEntity.getHealth()>this.parentEntity.getMaxHealth()*0.65))
                        this.parentEntity.setAttackingState(2);
                    else{
                        this.parentEntity.setAttackingState(3);
                    }
                }

                if(this.parentEntity.getAttckingState()==1){
                    if (this.attackTimer == 16) {
                        this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                        this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
                        this.parentEntity.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
                    }

                    if (this.attackTimer == 24) {
                        this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                        Vec3 rot = livingentity.position().subtract(0.0D, 2.0D, 0.0D).add(this.parentEntity.position().multiply(-1.0D, -1.0D, -1.0D)).normalize();
                        this.parentEntity.setDeltaMovement(rot.multiply(4.0D, 5.0D, 4.0D));

                        for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), LIVING_ENTITY_SELECTOR)) {
                            double d00 = lvt.getX() - this.parentEntity.getX();
                            double d10 = lvt.getZ() - this.parentEntity.getZ();
                            double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                            lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue());
                        }
                    }

                }

                if(this.parentEntity.getAttckingState()==2){
                    if (this.attackTimer == 18 && !this.parentEntity.level().isClientSide) {
                        this.parentEntity.getNavigation().moveTo(livingentity.getX()+this.parentEntity.random.nextInt(4),livingentity.getY()+this.parentEntity.random.nextInt(4),livingentity.getZ()+this.parentEntity.random.nextInt(4),0.9D);
                        for(int i=-4;i<4;i++)
                        {
                            EntityFallingBlock DeathBeam = new EntityFallingBlock(this.parentEntity.level(), this.parentEntity.getX()+i*this.parentEntity.getRandom().nextFloat()<0.5?1:-1, this.parentEntity.getY() + 2.9D, this.parentEntity.getZ()+i*this.parentEntity.getRandom().nextFloat()<0.5?1:-1, BlockInit.EXAMPLE_BLOCK.get().defaultBlockState(),30);
                            this.parentEntity.level().addFreshEntity(DeathBeam);

                        }

                    }

                    if (this.attackTimer == 45) {
                        this.parentEntity.getLookControl().setLookAt(livingentity.getX(), livingentity.getY() + (double)(livingentity.getBbHeight() / 2.0F), livingentity.getZ(), 6.0F, 90.0F);
                        this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
                        this.parentEntity.destoryblock2();
                    }

                    if(this.attackTimer==65){
                        for(int l = 1; l < 10; l++)
                        {
                            this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 2.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -2.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 3.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -3.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 4.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -4.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 5.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -5.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 6.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -6.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 7.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -7.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 8.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -8.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, 9.5F, 150, 1.5F, 0.15F, 1.0F);
                            this.parentEntity.blockSmashAttack(l, 3F, -9.5F, 150, 1.5F, 0.15F, 1.0F);
                        }
//                    this.parentEntity.level().addFreshEntity(new EntityCameraShake(this.parentEntity.level(),new Vec3(this.parentEntity.getX(),this.parentEntity.getY(),this.parentEntity.getZ()),
//                            35.0f, 0.1f, 10, 10));
                        EntityCameraShake.ScreenShake(this.parentEntity.level(), new Vec3(this.parentEntity.getX(),this.parentEntity.getY(),this.parentEntity.getZ()), 30.0f, 0.15f, 0, 50);
                        for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(1.1D), LIVING_ENTITY_SELECTOR)) {
                            double d00 = lvt.getX() - this.parentEntity.getX();
                            double d10 = lvt.getZ() - this.parentEntity.getZ();
                            double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                            lvt.getDeltaMovement().add(d00*0.2D,d20+rand.nextDouble(),d10*0.2D);
                        }
                    }

                }

                if(this.parentEntity.getAttckingState()==3){
                    if (this.attackTimer == 18 || this.attackTimer == 24 || this.attackTimer == 28) {
                        this.mlaunch(2, livingentity);
                    }

                    if (this.attackTimer == 28 || this.attackTimer == 32 || this.attackTimer == 36) {
                        this.mlaunch(1, livingentity);
                    }

                    if(this.attackTimer==45){
                        for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(6.0D), LIVING_ENTITY_SELECTOR)) {
                            double d00 = lvt.getX() - this.parentEntity.getX();
                            double d10 = lvt.getZ() - this.parentEntity.getZ();
                            double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                            lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), ((LivingEntity)lvt).getMaxHealth()*0.3F);
                        }
                    }

                }

                if (this.attackTimer == 90) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
        }


        private void mlaunch(int head, LivingEntity target) {
            if (!this.parentEntity.isSilent()) {
                this.parentEntity.level().levelEvent((Player)null, 1024, this.parentEntity.blockPosition(), 0);
            }

            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);
            EntityFallingBlock laserBeam = new EntityFallingBlock(this.parentEntity.level(), d0, d1, d2,Blocks.BLACKSTONE.defaultBlockState(),20);
            //laserBeam.m_20343_(d0, d1, d2);

            this.parentEntity.level().addFreshEntity(laserBeam);
        }

        private double getLauncherX(int head) {
            if (head <= 0) {
                return this.parentEntity.getX();
            } else {
                double theta = (double)this.parentEntity.yBodyRot * 0.017453292519943295D;
                ++theta;
                double vecX = Math.cos(theta);
                float f = (this.parentEntity.yBodyRot + (float)(180 * (head - 1))) * 0.017453292F;
                float f1 = Mth.cos(f);
                return this.parentEntity.getX() + (double)f1 * 1.25D + vecX * 1.35D;
            }
        }

        private double getLauncherY(int head) {
            return head <= 0 ? this.parentEntity.getY() + 3.0D : this.parentEntity.getY() + 3.8D;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return this.parentEntity.getZ();
            } else {
                double theta = (double)this.parentEntity.yBodyRot * 0.017453292519943295D;
                ++theta;
                double vecZ = Math.sin(theta);
                float f = (this.parentEntity.yBodyRot + (float)(180 * (head - 1))) * 0.017453292F;
                float f1 = Mth.sin(f);
                return this.parentEntity.getZ() + (double)f1 * 1.25D + vecZ * 1.35D;
            }
        }

    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.sala.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.sala.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.sala.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.sala.aoe"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.sala.idle"));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
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
                if (this.isAlliedTo((LivingEntity)entity) || entity instanceof EntityHeisen || (LivingEntity)entity == this) continue;
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
        livingEntity.getUseItem().hurtAndBreak(4+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }
}
