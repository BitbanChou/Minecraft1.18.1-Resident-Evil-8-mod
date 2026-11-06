// 
// Decompiled by Procyon v0.5.36
// 

package com.joy187.re8joymod.entity;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import java.util.HashMap;


import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import javax.annotation.Nullable;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;

import java.util.Random;
import java.util.EnumSet;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.registries.tags.ITag;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import java.util.UUID;
import java.util.Map;
import java.util.function.Predicate;




public class EntityDellago extends Monster implements GeoEntity
{

    public static final EntityDataAccessor<Integer> ATTACKING = SynchedEntityData.defineId(EntityDellago.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TARGET_ENTITY = SynchedEntityData.defineId(EntityDellago.class,
            EntityDataSerializers.INT);
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    private LivingEntity targetedEntity;
    private static Map<Integer, UUID> targetedEntities;
    private int clientSideAttackTime;
    private boolean clientSideTouchedGround;
    protected RandomStrollGoal wander;
    private boolean initAttack;
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    
    public EntityDellago(final EntityType<? extends EntityDellago> type, final Level worldIn) {
        super(type, worldIn);
        this.initAttack = false;
        this.xpReward = 100;
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0f);
        this.moveControl = new MoveHelperController(this);
        //EntityUtils.setConfigHealth((LivingEntity)this, (double)OutvotedConfig.COMMON.healthkraken.get());
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.85D).
                add(Attributes.FOLLOW_RANGE, 30.0D).
                add(Attributes.ATTACK_DAMAGE, 8.0D).
                add(Attributes.ARMOR, 9.0D);
    }

    public <E extends GeoAnimatable> PlayState predicate(final AnimationState<E> event) {
        if (this.getAttackPhase() != 0) {
//            if (this.hasTargetedEntity()) {
//                GeckoLibCache. .getInstance().parser.setValue("distance", this.distanceToSqr(this.getTargetedEntity()) + 15.0);
//            }
            if(this.getAttackPhase()==2)
            {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dellago.attack"));
                return PlayState.CONTINUE;
            }
            else{
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dellago.attack2"));
                return PlayState.CONTINUE;
            }
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dellago.swim"));
        return PlayState.CONTINUE;
    }
    

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller",
                5, this::predicate));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
    
//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//        return MonsterEntity.func_233639_cI_().func_233815_a_(Attributes.field_233823_f_, 6.0).func_233815_a_(Attributes.field_233821_d_, 0.1).func_233815_a_(Attributes.field_233819_b_, 48.0);
//    }
    
    protected void registerGoals() {
        final MoveTowardsRestrictionGoal movetowardsrestrictiongoal = new MoveTowardsRestrictionGoal(this, 1.0);
        this.wander = new RandomStrollGoal(this, 1.0, 80);
        this.goalSelector.addGoal(3, (Goal)new AttackGoal(this));
        this.goalSelector.addGoal(4, (Goal)new ChaseGoal(this, 6.0, 48.0f));
        this.goalSelector.addGoal(5, (Goal)new AvoidEntityGoal(this, (Class)EntityDellago.class, 72.0f, 4.0, 4.0));
        this.goalSelector.addGoal(6, (Goal)movetowardsrestrictiongoal);
        this.goalSelector.addGoal(7, (Goal)this.wander);
        this.goalSelector.addGoal(8, (Goal)new LookAtPlayerGoal(this, (Class)Player.class, 8.0f));
        this.goalSelector.addGoal(9, (Goal)new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new DJumpGoal(this, 10));
        this.wander.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        movetowardsrestrictiongoal.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class,true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, IronGolem.class,true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, AbstractVillager.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, EntityLycan.class,true));
    }
    
//    public static boolean checkDelSpawnRules(final EntityType<EntityDellago> entity, ServerLevelAccessor world, MobSpawnType spawnReason, final BlockPos blockPos, final Random random) {
//        return world.getDifficulty() != Difficulty.PEACEFUL && blockPos.getY() <= 45.0 && (spawnReason == MobSpawnType.SPAWNER || world.getFluidState(blockPos).is(FluidTags.WATER));
//    }

    public static boolean checkDelSpawnRules(EntityType<? extends Mob> p_217058_, LevelAccessor world, MobSpawnType spawnReason, BlockPos blockPos, RandomSource p_217062_) {
        return world.getDifficulty() != Difficulty.PEACEFUL && blockPos.getY() <= 45.0 && (spawnReason == MobSpawnType.SPAWNER || world.getFluidState(blockPos).is(FluidTags.WATER));    }

    protected PathNavigation createNavigation(final Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }
    
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EntityDellago.TARGET_ENTITY, 0);
        this.entityData.define(EntityDellago.ATTACKING, 0);
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
//    public CreatureAttribute func_70668_bt() {
//        return CreatureAttribute.field_203100_e;
//    }
    
    protected void updateAir(final int air) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(air - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(damageSources().drown(), 5.0f);
            }
        }
        else {
            this.setAirSupply(300);
        }
    }
    
    public int getAttackDuration() {
        return 60;
    }
    
    private void setTargetedEntity(final int entityId) {
        this.entityData.set((EntityDataAccessor)EntityDellago.TARGET_ENTITY, entityId);
    }
    
    public boolean hasTargetedEntity() {
        return (int)this.entityData.get((EntityDataAccessor)EntityDellago.TARGET_ENTITY) != 0;
    }
    
    private void setAttacking(final int attacking) {
        this.entityData.set(EntityDellago.ATTACKING, attacking);
    }
    
    public int getAttackPhase() {
        return (int)this.entityData.get(EntityDellago.ATTACKING);
    }
    
    @Nullable
    public LivingEntity getTargetedEntity() {
        if (!this.hasTargetedEntity()) {
            return null;
        }
        if (!this.level().isClientSide) {
            return this.getTarget();
        }
        if (this.targetedEntity != null) {
            return this.targetedEntity;
        }
        final Entity entity = this.level().getEntity((int)this.entityData.get((EntityDataAccessor)EntityDellago.TARGET_ENTITY));
        if (entity instanceof LivingEntity) {
            return this.targetedEntity = (LivingEntity)entity;
        }
        return null;
    }

    public void onSyncedDataUpdated(final EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (EntityDellago.TARGET_ENTITY.equals(key)) {
            this.clientSideAttackTime = 0;
            this.targetedEntity = null;
        }
    }
    
    public int getAmbientSoundInterval() {
        return 160;
    }

    
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.GUARDIAN_HURT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.GUARDIAN_AMBIENT;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GUARDIAN_DEATH;
    }

    protected boolean isMovementNoisy() {
        return false;
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

//    protected float getEyeY(final Pose poseIn, EntitySize sizeIn) {
//        return this.getBbHeight * 0.4f;
//    }
    
    public float getWalkTargetValue(final BlockPos pos, final LevelReader worldIn) {
        return worldIn.getFluidState(pos).is(FluidTags.WATER) ? (10.0f + worldIn.getBrightness(LightLayer.BLOCK,pos) - 0.5f) : super.getWalkTargetValue(pos, worldIn);
    }
    
    public void die(final DamageSource cause) {
        EntityDellago.targetedEntities.remove(this.entityData.get((EntityDataAccessor)EntityDellago.TARGET_ENTITY));
        super.die(cause);
    }

    public void makeInvulnerable() {
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

    public void knockback(final float strength, final double ratioX, final double ratioZ) {
        super.knockback(strength / 4.0f, ratioX, ratioZ);
    }

    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            if (this.level().isClientSide) {
                if (!this.isInWater()) {
                    final Vec3 vector3d = this.getDeltaMovement();
                    if (vector3d.y > 0.0 && this.clientSideTouchedGround && !this.isSilent()) {
                        this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getFlopSound(), this.getSoundSource(), 1.0f, 1.0f, false);
                    }
                    this.clientSideTouchedGround = (vector3d.y < 0.0 && this.level().loadedAndEntityCanStandOn(this.blockPosition().below(), (Entity)this));
                }
                if (this.hasTargetedEntity() && this.clientSideAttackTime < this.getAttackDuration()) {
                    ++this.clientSideAttackTime;
                }
            }
            if (this.hasTargetedEntity()) {
                this.setYRot(this.yHeadRot);
                final LivingEntity livingentity = this.getTargetedEntity();
                if (livingentity != null) {
                    this.getLookControl().setLookAt(livingentity, 90.0f, 90.0f);
                    this.getLookControl().tick();
                    final double d5 = this.getAttackAnimationScale(0.0f);
                    double d6 = livingentity.getX() - this.getX();
                    double d7 = livingentity.getY(0.5) - this.getEyeY();
                    double d8 = livingentity.getZ() - this.getZ();
                    final double d9 = Math.sqrt(d6 * d6 + d7 * d7 + d8 * d8);
                    d6 /= d9;
                    d7 /= d9;
                    d8 /= d9;
                    double d10 = this.random.nextDouble();
                    if (this.getAttackPhase() == 0) {
                        this.setAttacking(1);
                    }
                    while (d10 < d9) {
                        d10 += 1.8 - d5 + this.random.nextDouble() * (1.7 - d5);
                        livingentity.moveTo(this.getX() + d6 * d9, this.getEyeY() + d7, this.getZ() + d8 * d9, livingentity.getYRot(), livingentity.getXRot());
                        livingentity.setSwimming(false);
                        livingentity.updateSwimming();
                        if (!this.level().isClientSide && livingentity.isPassenger() && livingentity.getRootVehicle() instanceof Boat) {
                            final Entity boat = livingentity.getRootVehicle();
                            livingentity.stopRiding();
                            boat.spawnAtLocation(((Boat)boat).getDropItem());
                            try {
                                Containers.dropContents(boat.level(), boat, (Container)boat);
                            }
                            catch (Exception ex) {}
                                boat.discard();
                        }
                        if (this.getAttackPhase() != 2 || this.getAttackPhase()!=0) {
                            if (!this.initAttack) {
                                livingentity.hurt(livingentity.damageSources().drown(), 6f);
                                this.initAttack = true;
                            }
                            livingentity.push(-d6 / 50.0, -d7 / 50.0, -d8 / 50.0);
                        }
                        else {
                            if (!this.initAttack) {
                                continue;
                            }
                            this.initAttack = false;
                        }
                    }
                }
            }
            if (this.isInWaterOrBubble()) {
                this.setAirSupply(300);
            }
            else if (this.onGround()) {
                this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0f - 1.0f) * 0.1f), 0.5, (double)((this.random.nextFloat() * 2.0f - 1.0f) * 0.1f)));
                this.setYRot(this.random.nextFloat() * 360.0f);
                this.setOnGround(false);
                this.hasImpulse = true;
            }
        }
    }

    public void baseTick() {
        final int i = this.getAirSupply();
        super.baseTick();
        this.updateAir(i);
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.GUARDIAN_AMBIENT;
    }

    public float getAttackAnimationScale(final float f) {
        return (this.clientSideAttackTime + f) / this.getAttackDuration();
    }

//    public boolean checkSpawnObstruction(final ILevelReader worldIn) {
//        return worldIn.func_226668_i_((Entity)this);
//    }

    public boolean hurt(final DamageSource source, final float amount) {
        if (this.wander != null) {
            this.wander.trigger();
        }
        return super.hurt(source, amount);
    }

    public void travel(final Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1f, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getSpeed() == 0.0f && this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.001, 0.0));
            }
            else if (this.getTarget() != null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        }
        else {
            super.travel(travelVector);
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (!this.hasRestriction()) {
            this.restrictTo(this.blockPosition(), 96);
        }

        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.0F*this.random.nextFloat());
        }



        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public boolean waterCheck(final LivingEntity livingentity) {
        if (livingentity.getVehicle() != null) {
            return livingentity.getVehicle().isInWater();
        }
        return livingentity.isInWater() && livingentity.getEffect(MobEffects.DOLPHINS_GRACE) == null && (EntityDellago.targetedEntities.get(livingentity.getId()) == null || EntityDellago.targetedEntities.get(livingentity.getId()) == this.getUUID());
    }

    static {
//        ATTACKING = EntityDataAccessor.defineId((Class)EntityDellago.class, DataSerializers.field_187192_b);
//        TARGET_ENTITY = EntityDataManager.defineId((Class)EntityDellago.class, DataSerializers.field_187192_b);

        EntityDellago.targetedEntities = new HashMap<Integer, UUID>();
    }

    static class ChaseGoal extends MoveTowardsTargetGoal
    {
        private final EntityDellago entity;
        private final double speed;

        public ChaseGoal(final EntityDellago kraken, final double speedIn, final float maxDistanceIn) {
            super(kraken, speedIn, maxDistanceIn);
            this.entity = kraken;
            this.speed = speedIn;
        }

        public void stop() {
        }

        public boolean canUse() {
            final LivingEntity livingentity = this.entity.getTarget();
            return livingentity != null && super.canUse() && this.entity.waterCheck(livingentity) && this.entity.isWithinRestriction();
        }

        public boolean canContinueToUse() {
            final LivingEntity livingentity = this.entity.getTarget();
            return livingentity != null && super.canContinueToUse() && this.entity.waterCheck(livingentity) && this.entity.isWithinRestriction();
        }

        public void start() {
        }

        public void tick() {
            final LivingEntity livingentity = this.entity.getTarget();
            if (livingentity != null) {
                this.entity.getNavigation().moveTo(livingentity, this.speed);
            }
        }
    }

    private static final Predicate<Entity> DEL_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityDellago);
    };

    static class AttackGoal extends Goal
    {
        private final EntityDellago entity;
        private int tickCounter;

        public AttackGoal(final EntityDellago entity) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            final LivingEntity livingentity = this.entity.getTarget();
            return livingentity != null && livingentity.isAlive() && this.entity.waterCheck(livingentity) && this.entity.distanceToSqr((Entity)this.entity.getTarget()) < 64.0;
        }

        public boolean canContinueToUse() {
            return this.entity.getTarget() != null && this.entity.distanceToSqr((Entity)this.entity.getTarget()) < 90.5 && this.entity.getTarget().getEffect(MobEffects.DOLPHINS_GRACE) == null && this.entity.waterCheck(this.entity.getTarget());
        }

        public void start() {
            this.tickCounter = -10;
            this.entity.getNavigation().stop();
            this.entity.getLookControl().setLookAt(this.entity.getTarget(), 90.0f, 90.0f);
            this.entity.hasImpulse = true;
        }

        public void stop() {
            EntityDellago.targetedEntities.remove(this.entity.entityData.get(EntityDellago.TARGET_ENTITY));
            this.entity.setTargetedEntity(0);
            this.entity.setTarget(null);
            this.entity.wander.trigger();
            this.entity.setAttacking(0);
        }

        public void tick() {
            final LivingEntity livingentity = this.entity.getTarget();
            //System.out.println(this.tickCounter+" "+this.entity.getAttackPhase());
            if (livingentity != null) {
                this.entity.getNavigation().stop();
                this.entity.getLookControl().setLookAt(livingentity, 90.0f, 90.0f);
                if (!this.entity.hasLineOfSight(livingentity)) {
                    this.entity.setTarget(null);
                }
                else {
                    ++this.tickCounter;
                    if (this.tickCounter >= 0) {
                        this.entity.setTargetedEntity(this.entity.getTarget().getId());
                        EntityDellago.targetedEntities.put(livingentity.getId(), this.entity.getUUID());
                    }
                    else if (this.tickCounter >= this.entity.getAttackDuration() && this.tickCounter % 20 == 0) {
                        if (livingentity.getEffect(MobEffects.WATER_BREATHING) != null && livingentity.getAirSupply() == 0) {
                            livingentity.hurt(livingentity.damageSources().drown(), 5.0f);
                        }
                        this.entity.setAttacking(0);
                        livingentity.setAirSupply(Math.max(livingentity.getAirSupply() - 45, 0));
                    }

                    if(this.tickCounter==15){
                        if(this.entity.distanceToSqr(livingentity)>10.0D)
                        {
                            this.entity.setAttacking(2);
                            Vec3 vec3 = this.entity.position().add(0.0D, (double)1.6F, 0.0D);
                            Vec3 vec31 = livingentity.getEyePosition().subtract(vec3);
                            Vec3 vec32 = vec31.normalize();

                            for(int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
                                Vec3 vec33 = vec3.add(vec32.scale((double)i));
                            }

                            this.entity.playSound(SoundEvents.SOUL_ESCAPE, 3.0F, 1.0F);
                            if(livingentity instanceof IronGolem)
                                livingentity.hurt(livingentity.damageSources().mobAttack(this.entity), livingentity.getHealth()*0.25F);
                            else
                                livingentity.hurt(livingentity.damageSources().mobAttack(this.entity), 10.0F);
                            double d1 = 0.25D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                            double d0 = 1.5D * (1.0D - livingentity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                            livingentity.push(-vec32.x() * d0, vec32.y() * d1, -vec32.z() * d0);
                        }
                        else{
                            this.entity.setAttacking(1);
                        }

                        if(this.tickCounter==50 && this.entity.getAttackPhase()==1){
                            for (LivingEntity lvt : this.entity.level().getEntitiesOfClass(LivingEntity.class, this.entity.getBoundingBox().inflate(3.0D), DEL_AREA)) {
                                double d00 = lvt.getX() - this.entity.getX();
                                double d10 = lvt.getZ() - this.entity.getZ();
                                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                                lvt.hurt(lvt.damageSources().mobAttack(this.entity), (float)this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.2F);
                            }
                        }
                    }

                    if(this.tickCounter>=60){
                        this.tickCounter=-20;
                        this.entity.setAttacking(0);
                    }

                }
            }
        }
    }

    static class MoveHelperController extends MoveControl
    {
        private final EntityDellago entity;

        public MoveHelperController(final EntityDellago entity) {
            super(entity);
            this.entity = entity;
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
                final Vec3 vector3d = new Vec3(this.wantedX - this.entity.getX(), this.wantedY - this.entity.getY(), this.wantedZ - this.entity.getZ());
                final double d0 = vector3d.length();
                final double d2 = vector3d.x / d0;
                final double d3 = vector3d.y / d0;
                final double d4 = vector3d.z / d0;
                final float f = (float)(Mth.atan2(vector3d.z, vector3d.x) * 57.2957763671875) - 90.0f;
                this.entity.setYRot(this.rotlerp(this.entity.getYRot(), f, 90.0f));
                this.entity.yBodyRot = this.entity.getYRot();
                final float f2 = (float)(this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                final float f3 = Mth.lerp(0.125f, this.entity.getSpeed(), f2);
                this.entity.setSpeed(f3);
                final double d5 = Math.sin((this.entity.tickCount + this.entity.getId()) * 0.5) * 0.05;
                final double d6 = Math.cos(this.entity.getYRot() * 0.017453292f);
                final double d7 = Math.sin(this.entity.getYRot() * 0.017453292f);
                final double d8 = Math.sin((this.entity.tickCount + this.entity.getId()) * 0.75) * 0.05;
                this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(d5 * d6, d8 * (d7 + d6) * 0.25 + f3 * d3 * 0.1, d5 * d7));
                final LookControl lookcontroller = this.entity.getLookControl();
                final double d9 = this.entity.getX() + d2 * 2.0;
                final double d10 = this.entity.getEyeY() + d3 / d0;
                final double d11 = this.entity.getZ() + d4 * 2.0;
                double d12 = lookcontroller.getWantedX();
                double d13 = lookcontroller.getWantedY();
                double d14 = lookcontroller.getWantedZ();
                if (!lookcontroller.isLookingAtTarget()) {
                    d12 = d9;
                    d13 = d10;
                    d14 = d11;
                }
                this.entity.getLookControl().setLookAt(Mth.lerp(0.125, d12, d9), Mth.lerp(0.125, d13, d10), Mth.lerp(0.125, d14, d11), 10.0f, 40.0f);
            }
            else {
                this.entity.setSpeed(0.0f);
            }
        }
    }

    static class DJumpGoal extends JumpGoal {
        private final int[] STEPS_TO_CHECK = new int[]{0, 1, 4, 5, 6, 7};
        private final EntityDellago dolphin;
        private final int interval;
        private boolean breached;

        public DJumpGoal(EntityDellago p_25168_, int p_25169_) {
            this.dolphin = p_25168_;
            this.interval = reducedTickDelay(p_25169_);
        }

        public boolean canUse() {
            if (this.dolphin.getRandom().nextInt(this.interval) != 0) {
                return false;
            } else {
                Direction direction = this.dolphin.getMotionDirection();
                int i = direction.getStepX();
                int j = direction.getStepZ();
                BlockPos blockpos = this.dolphin.blockPosition();

                for(int k : STEPS_TO_CHECK) {
                    if (!this.waterIsClear(blockpos, i, j, k) || !this.surfaceIsClear(blockpos, i, j, k)) {
                        return false;
                    }
                }

                return true;
            }
        }

        private boolean waterIsClear(BlockPos p_25173_, int p_25174_, int p_25175_, int p_25176_) {
            BlockPos blockpos = p_25173_.offset(p_25174_ * p_25176_, 0, p_25175_ * p_25176_);
            return this.dolphin.level().getFluidState(blockpos).is(FluidTags.WATER) && !this.dolphin.level().getBlockState(blockpos).blocksMotion();
        }

        private boolean surfaceIsClear(BlockPos p_25179_, int p_25180_, int p_25181_, int p_25182_) {
            return this.dolphin.level().getBlockState(p_25179_.offset(p_25180_ * p_25182_, 1, p_25181_ * p_25182_)).isAir() && this.dolphin.level().getBlockState(p_25179_.offset(p_25180_ * p_25182_, 2, p_25181_ * p_25182_)).isAir();
        }

        public boolean canContinueToUse() {
            double d0 = this.dolphin.getDeltaMovement().y;
            return (!(d0 * d0 < (double)0.03F) || this.dolphin.getXRot() == 0.0F || !(Math.abs(this.dolphin.getXRot()) < 10.0F) || !this.dolphin.isInWater()) && !this.dolphin.onGround();
        }

        public boolean isInterruptable() {
            return false;
        }

        public void start() {
            Direction direction = this.dolphin.getMotionDirection();
            this.dolphin.setDeltaMovement(this.dolphin.getDeltaMovement().add((double)direction.getStepX() * 0.6D, 0.7D, (double)direction.getStepZ() * 0.6D));
            this.dolphin.getNavigation().stop();
        }

        public void stop() {
            this.dolphin.setXRot(0.0F);
        }

        public void tick() {
            boolean flag = this.breached;
            if (!flag) {
                FluidState fluidstate = this.dolphin.level().getFluidState(this.dolphin.blockPosition());
                this.breached = fluidstate.is(FluidTags.WATER);
            }

            if (this.breached && !flag) {
                this.dolphin.playSound(SoundEvents.DOLPHIN_JUMP, 1.0F, 1.0F);
            }

            Vec3 vec3 = this.dolphin.getDeltaMovement();
            if (vec3.y * vec3.y < (double)0.03F && this.dolphin.getXRot() != 0.0F) {
                this.dolphin.setXRot(Mth.rotLerp(this.dolphin.getXRot(), 0.0F, 0.2F));
            } else if (vec3.length() > (double)1.0E-5F) {
                double d0 = vec3.horizontalDistance();
                double d1 = Math.atan2(-vec3.y, d0) * (double)(180F / (float)Math.PI);
                this.dolphin.setXRot((float)d1);
            }

        }
    }
}
