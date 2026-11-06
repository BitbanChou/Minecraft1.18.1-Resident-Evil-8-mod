package com.joy187.re8joymod.entity;

import java.util.List;
import javax.annotation.Nullable;


import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.tags.ITag;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityPlagasc extends Spider implements GeoEntity {
    private static final EntityDataAccessor<Direction> ATTACHED_BLK = SynchedEntityData.defineId(EntityPlagasc.class, EntityDataSerializers.DIRECTION);
    private static final EntityDataAccessor<Boolean> SUMMONED = SynchedEntityData.defineId(EntityPlagasc.class, EntityDataSerializers.BOOLEAN);
    private static final Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    //private static final Item[] ParasiteDrop = { FURItemRegistry.PARASITE_COMMON, FURItemRegistry.PARASITE_DESERT, FURItemRegistry.PARASITE_JUNGLE, FURItemRegistry.PARASITE_COOKED };
    public int lifespawn;
    private boolean long_live;
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityPlagasc(EntityType<? extends EntityPlagasc> p_i48549_1_, Level worldIn) {
        super(p_i48549_1_, worldIn);
        this.long_live = false;
        this.lifespawn = 120 * 20;
        this.xpReward = 1;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, true, (p_213440_0_) -> {
            return !p_213440_0_.isPassenger();
        }));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityLycan.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityDund.class,true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EnderMan.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Guardian.class,false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Piglin.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Pig.class,false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Cow.class,false));

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.29D)
                .add(Attributes.FOLLOW_RANGE, 18.0D)
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagasc.walk"));
            return PlayState.CONTINUE;
        }


        event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagasc.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.getTarget()!=null) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.plagasc.attack"));
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACHED_BLK, Direction.DOWN);
        this.entityData.define(SUMMONED, Boolean.valueOf(false));
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.setHealth(this.getMaxHealth());
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Override
    public void tick() {
        if (this.lifespawn > 0) {
            if(!long_live) {
                this.lifespawn--;
            }
        } else if (!this.isSummoned() && this.getRandom().nextInt(100) < 40) {
            double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
            List<Player> list = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(d0));

            if(!list.isEmpty()) {
                this.lifespawn = 120 * 20;

//                if (!this.level().isClientSide) {
//                    this.playSound(FURSoundRegistry.PARASITE_WEAVE, 1.0F, 1.0F);
//
//                    VespaCocoonEntity pupa = FUREntityRegistry.VESPACOCOON.create(this.level());
//                    pupa.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
//                    pupa.setSkin(0);
//                    this.level().addFreshEntity(pupa);
//                }

                this.discard();
            } else
                this.hurt(damageSources().generic() , (float)this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE));
        } else if (!this.isSummoned() && this.getRandom().nextInt(100) < 10) {
            double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
            List<Player> list = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(d0));

            if(!list.isEmpty()) {
                this.lifespawn = 120 * 20;

//                if (!this.level().isClientSide) {
//                    this.playSound(FURSoundRegistry.PARASITE_WEAVE, 1.0F, 1.0F);
//
//                    VespaCocoonEntity pupa = FUREntityRegistry.BEELZEBUBPUPA.create(this.level());
//                    pupa.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
//                    this.level().addFreshEntity(pupa);
//                }

                this.discard();
            } else
                this.hurt(damageSources().generic() , (float)this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE));
        } else {
            this.hurt(damageSources().generic(), (float)this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE));
        }

        if (this.getVehicle() != null && this.getVehicle() instanceof LivingEntity && this.getVehicle().isAlive() && !this.level().isClientSide()) {
            Entity mount = this.getVehicle();

            if (!((LivingEntity) mount).hasEffect(EffectInit.PLAGAS.get()) && !this.isSummoned()) {
                this.stopRiding();
                this.hurt(damageSources().mobAttack(this) , (float)this.getAttributeBaseValue(Attributes.ATTACK_DAMAGE));
            } else if (mount.isAlive() && mount.isOnFire()) {
                this.setRemainingFireTicks(20);
                this.stopRiding();
            } else if (mount.isAlive() && this.tickCount % 20 == 0) {
                this.doHurtTarget(mount);
            }

        } else if (getVehicle() == null && this.long_live) {
            this.long_live = false;
        }

        if (!this.level().isClientSide()) {
            if (this.onGround() || this.isInWaterOrBubble() || this.isInLava()) {
                this.entityData.set(ATTACHED_BLK, Direction.DOWN);
            } else if (this.verticalCollision) {
                this.entityData.set(ATTACHED_BLK, Direction.UP);
            } else {
                Direction closestDirection = Direction.DOWN;
                double closestDistance = 100;

                for (Direction dir : DIRECTIONS) {
                    BlockPos antPos = new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ());
                    BlockPos offsetPos = antPos.relative(dir);
                    Vec3 offset = Vec3.atCenterOf(offsetPos);
                    if (closestDistance > this.position().distanceTo(offset) && level().loadedAndEntityCanStandOnFace(offsetPos, this, dir.getOpposite())) {
                        closestDistance = this.position().distanceTo(offset);
                        closestDirection = dir;
                    }
                }

                this.entityData.set(ATTACHED_BLK, closestDirection);
            }
        }
        super.tick();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.isEmpty()) {
            player.playSound(SoundEvents.ITEM_PICKUP, 1.0F, 1.0F);

//            if (!player.inventory.add(new ItemStack(ParasiteDrop[this.getSkin()]))) {
//                player.spawnAtLocation(new ItemStack(ParasiteDrop[this.getSkin()]));
//            }

            this.discard();

            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public double getMyRidingOffset() {
        if (this.isPassenger()) {
            if (this.getVehicle() instanceof Player || this.getVehicle() instanceof Zombie || this.getVehicle() instanceof EntityLycan) {
                return this.getVehicle().getBbHeight()/2  - 0.85F;
            } else {
                return this.getVehicle().getBbHeight() * 0.65D - 1.0D;
            }
        } else {
            return super.getMyRidingOffset();
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (!this.isSummoned() && this.random.nextDouble()<0.3) {
                if(entity instanceof LivingEntity)
                {
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 5*20, 0));
                    if(!(entity instanceof Player) && !(((LivingEntity) entity).hasEffect(EffectInit.BURN.get()))){
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(EffectInit.BURN.get(),60*20,1));
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,60*20,1));
                    }
                }
            }
            else {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 3*20, 0));
                if(!(entity instanceof Player) && !(((LivingEntity) entity).hasEffect(EffectInit.BURN.get()))){
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(EffectInit.BURN.get(),60*20,1));
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,60*20,1));
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public void push(Entity entityIn) {
        super.push(entityIn);

        if (entityIn instanceof LivingEntity && !(entityIn instanceof Player) && !this.isPassenger()) {
            if (!this.isSummoned()) {
                ((LivingEntity) entityIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 3*20, 0));
            }
            this.startRiding(entityIn);
            this.long_live = true;
        }
    }

    @Override
    public void playerTouch(Player playerIn) {
        super.playerTouch(playerIn);
        if (!playerIn.isCreative() && !this.isPassenger()) {
            if (!this.isSummoned()) {
                (playerIn).addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 3*20, 0));
            }
            this.startRiding(playerIn);
            this.long_live = true;
        }
    }

    public static EntityPlagasc gotParasite(List<Entity> listIn) {
        for(Entity C : listIn)
            if(C instanceof EntityPlagasc)
                return (EntityPlagasc)C;

        return null;
    }

    public Direction getAttachedBlock() {
        return this.getEntityData().get(ATTACHED_BLK);
    }

    public boolean isSummoned() {
        return this.getEntityData().get(SUMMONED).booleanValue();
    }

    public void setSummoned(boolean i) {
        this.getEntityData().set(SUMMONED, Boolean.valueOf(i));
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 0.1F;
    }

//    @Override
//    protected boolean isMovementNoisy() {
//        return false;
//    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SILVERFISH_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SILVERFISH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SILVERFISH_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SILVERFISH_STEP, 0.15F, 1.0F);
    }

//    @Nullable
//    @Override
//    protected ResourceLocation getDefaultLootTable() {
//        switch(this.getSkin()) {
//            case 1:
//                return new ResourceLocation("mod_lavacow", "entities/parasite1");
//            case 2:
//                return new ResourceLocation("mod_lavacow", "entities/parasite2");
//            case 0:
//            default:
//                return super.getDefaultLootTable();
//        }
//    }

    @Override
    public boolean shouldDropExperience() {
        return !this.isSummoned();
    }

    @Override
    protected boolean shouldDropLoot() {
        return !this.isSummoned();
    }

    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(EntityPlagasc p_i46676_1_) {
            super(p_i46676_1_, 1.0D, true);
        }

        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }

        public boolean canContinueToUse() {
            float f = this.mob.getLightLevelDependentMagicValue();
            if (this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }

        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            return (double)(0.1F + p_179512_1_.getBbWidth());
        }
    }

    public boolean killedEntity(ServerLevel p_219160_, LivingEntity livingentity) {
        boolean flag = super.killedEntity(p_219160_, livingentity);
        if(this.random.nextBoolean()){

            return flag;
        }

        if(livingentity instanceof Villager) {
            Villager villager = (Villager)livingentity;
            EntityVillagerGanado zombievillager = villager.convertTo(EntityInit.VILLAGERGANADO.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof EntityZealot) {
            EntityZealot villager = (EntityZealot)livingentity;
            EntityPlagasm zombievillager = villager.convertTo(EntityInit.PLAGASM.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Wolf)
        {
            Wolf villager = (Wolf)livingentity;
            EntityEvilDog zombievillager = villager.convertTo(EntityInit.EVILDOG.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Raider) {
            Raider villager = (Raider)livingentity;
            EntityZealot zombievillager = villager.convertTo(EntityInit.ZEALOT.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Zombie) {
            Zombie villager = (Zombie)livingentity;
            EntityLycan zombievillager = villager.convertTo(EntityInit.LYCAN.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof EntityFaceEater) {
            EntityFaceEater villager = (EntityFaceEater)livingentity;
            EntityRegenerator zombievillager = villager.convertTo(EntityInit.REGENERATOR.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof AbstractSkeleton) {
            AbstractSkeleton villager = (AbstractSkeleton)livingentity;
            EntityFaceEater zombievillager = villager.convertTo(EntityInit.FE.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Pig) {
            Pig villager = (Pig)livingentity;
            EntityJJ zombievillager = villager.convertTo(EntityInit.JJ.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }
        else if(livingentity instanceof Cow) {
            Cow villager = (Cow)livingentity;
            EntityBrute zombievillager = villager.convertTo(EntityInit.BRUTE.get(), false);
            zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag)null);
            //System.out.println("yes");
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(livingentity, zombievillager);
            if (!this.isSilent()) {
                p_219160_.levelEvent((Player)null, 1026, this.blockPosition(), 0);
            }
            flag = false;
        }

        return flag;
    }

}

