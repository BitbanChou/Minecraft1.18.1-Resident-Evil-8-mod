package com.joy187.re8joymod.entity;


import com.joy187.re8joymod.entity.ai.DragonMoveController;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.ParticleInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SaddleItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static net.minecraft.world.entity.ai.attributes.Attributes.*;

public class EntityHeli extends TamableAnimal implements Saddleable, FlyingAnimal, PlayerRideable, GeoEntity
{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    // base attributes
    public static final double BASE_SPEED_GROUND = 0.3;
    public static final double BASE_SPEED_FLYING = 0.525;
    public static final double BASE_DAMAGE = 8;
    public static final double BASE_HEALTH = 60;
    public static final double BASE_FOLLOW_RANGE = 16;
    public static final double BASE_FOLLOW_RANGE_FLYING = BASE_FOLLOW_RANGE * 2;
    public static final int BASE_KB_RESISTANCE = 1;
    public static final float BASE_WIDTH = 2.75f; // adult sizes
    public static final float BASE_HEIGHT = 2.75f;
    public int time;
    public int shootingCooldown = 75;

    // data value IDs
    //private static final EntityDataAccessor<String> DATA_BREED = SynchedEntityData.defineId(EntityHeli.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> DATA_FLYING = SynchedEntityData.defineId(EntityHeli.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_SADDLED = SynchedEntityData.defineId(EntityHeli.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_AGE = SynchedEntityData.defineId(EntityHeli.class, EntityDataSerializers.INT);

    // data NBT IDs
    public static final String NBT_BREED = "Breed";
    private static final String NBT_SADDLED = "Saddle";
    private static final String NBT_REPRO_COUNT = "ReproCount";

    // other constants
    public static final int AGE_UPDATE_INTERVAL = 100;
    public static final UUID SCALE_MODIFIER_UUID = UUID.fromString("856d4ba4-9ffe-4a52-8606-890bb9be538b"); // just a random uuid I took online
    public static final int ALTITUDE_FLYING_THRESHOLD = 3;
    public static final int DEFAULT_REPRO_LIMIT = 2;
    public static final int DEFAULT_GROWTH_TIME = 72000;

    // server/client delegates
//    private final DragonAnimator animator;
//    private DragonBreed breed;
    private int reproCount;
    private float ageProgress;

    public EntityHeli(EntityType<? extends EntityHeli> type, Level level)
    {
        super(type, level);

        // enables walking over blocks
        maxUpStep = 1;
        noCulling = true;

        moveControl = new DragonMoveController(this);
//        animator = level.isClientSide? new DragonAnimator(this) : null;
//        breed = BreedRegistry.getFallback();
    }


    public static AttributeSupplier.Builder prepareAttributes()
    {
        return Mob.createMobAttributes()
                .add(MOVEMENT_SPEED, BASE_SPEED_GROUND)
                .add(MAX_HEALTH, BASE_HEALTH)
                .add(ATTACK_DAMAGE, BASE_FOLLOW_RANGE)
                .add(KNOCKBACK_RESISTANCE, BASE_KB_RESISTANCE)
                .add(ATTACK_DAMAGE, BASE_DAMAGE)
                .add(FLYING_SPEED, BASE_SPEED_FLYING);
    }

    @Override
    protected void registerGoals() // TODO: Much Smarter AI and features
    {
//        goalSelector.addGoal(1, new DragonLandGoal(this));
        //goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
//        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1));
//        goalSelector.addGoal(4, new DragonBabuFollowParent(this, 10));
//        goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.1, 10f, 3.5f));
        //goalSelector.addGoal(5, new DragonBreedGoal(this));
        //goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
//        goalSelector.addGoal(7, new LookAtPlayerGoal(this, LivingEntity.class, 16f));
        //goalSelector.addGoal(8, new RandomLookAroundGoal(this));
//
//        targetSelector.addGoal(0, new OwnerHurtByTargetGoal(this));
//        targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
//        targetSelector.addGoal(3, new NonTameRandomTargetGoal<>(this, Animal.class, false, e -> !(e instanceof EntityHeli)));
    }

    @Override
    protected void defineSynchedData()
    {
        super.defineSynchedData();

        //entityData.define(DATA_BREED,"");
        entityData.define(DATA_FLYING, false);
        entityData.define(DATA_SADDLED, true);
        entityData.define(DATA_AGE, 1000); // default to adult stage
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> data)
    {
//        if (DATA_BREED.equals(data)) updateBreed(BreedRegistry.get(entityData.get(DATA_BREED)));
//        else
            if (DATA_FLAGS_ID.equals(data)) refreshDimensions();
        else if (DATA_AGE.equals(data)) updateAgeProperties();
        else super.onSyncedDataUpdated(data);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        //compound.putString(NBT_BREED, breed.id().toString());
        compound.putBoolean(NBT_SADDLED, isSaddled());
        compound.putInt(NBT_REPRO_COUNT, reproCount);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        //setBreed(BreedRegistry.get(compound.getString(NBT_BREED)));
        setSaddled(compound.getBoolean(NBT_SADDLED));
        this.reproCount = compound.getInt(NBT_REPRO_COUNT);

        entityData.set(DATA_AGE, getAge());
    }

//    public void setBreed(DragonBreed dragonBreed)
//    {
//        entityData.set(DATA_BREED, dragonBreed.id().toString());
//    }
//
//    private void updateBreed(DragonBreed breed)
//    {
//        getBreed().close(this);
//        this.breed = breed;
//        getBreed().initialize(this);
//    }
//
//    public DragonBreed getBreed()
//    {
//        return breed;
//    }

    /**
     * Returns true if the dragon is saddled.
     */
    public boolean isSaddled()
    {
        return entityData.get(DATA_SADDLED);
    }

    @Override
    public boolean isSaddleable()
    {
        return true;
    }

    @Override
    public void equipSaddle(@Nullable SoundSource source)
    {
        setSaddled(true);
        level().playSound(null, getX(), getY(), getZ(), SoundEvents.HORSE_SADDLE, getSoundSource(), 1, 1);
    }

    /**
     * Set or remove the saddle of the dragon.
     */
    public void setSaddled(boolean saddled)
    {
        entityData.set(DATA_SADDLED, saddled);
    }

    public void addReproCount()
    {
        reproCount++;
    }

    public boolean canFly()
    {
        // hatchling's can't fly
        return true;
    }

    public boolean shouldFly()
    {
        return canFly() && !isInWater() && isHighEnough(ALTITUDE_FLYING_THRESHOLD);
    }

    /**
     * Returns true if the entity is flying.
     */
    public boolean isFlying()
    {
        return entityData.get(DATA_FLYING);
    }

    /**
     * Set the flying flag of the entity.
     */
    public void setFlying(boolean flying)
    {
        entityData.set(DATA_FLYING, flying);
    }

    public void aiStep() {
        super.aiStep();
        this.hurt(this.level().getEntities(this, this.getBoundingBox().inflate(1.0D), EntitySelector.NO_CREATIVE_OR_SPECTATOR));

    }

    @Override
    public void tick()
    {
        super.tick();

        if (isServer())
        {
            if (time < shootingCooldown) time++;
            if (age < 0 && tickCount % AGE_UPDATE_INTERVAL == 0) entityData.set(DATA_AGE, age);

            // update flying state based on the distance to the ground
            boolean flying = shouldFly();
            if (flying != isFlying())
            {
                // notify client
                setFlying(flying);

                // update AI follow range (needs to be updated before creating
                // new PathNavigate!)
                getAttribute(FOLLOW_RANGE).setBaseValue(flying? BASE_FOLLOW_RANGE_FLYING : BASE_FOLLOW_RANGE);

                // update pathfinding method
                if (flying) navigation = new FlyingPathNavigation(this, level());
                else navigation = new GroundPathNavigation(this, level());
            }
        }
        else
        {
            // update animations on the client
            //animator.tick();

            // because age isn't incremented on client, do it ourselves...
            int age = getAge();
            if (age < 0) setAge(++age);
            else if (age > 0) setAge(--age);
        }

        updateAgeProgress();
        //for (var ability : getBreed().abilities()) ability.tick(this);
    }

    @Override
    public void travel(Vec3 vec3)
    {
        boolean isFlying = isFlying();
        float speed = (float) getAttributeValue(isFlying? FLYING_SPEED : MOVEMENT_SPEED) * 0.6f;
        LivingEntity driver = (LivingEntity) getControllingPassenger();
        if (canBeControlledByRider() && driver!=null) // Were being controlled; override ai movement
        {
            double moveSideways = vec3.x;
            double moveY = vec3.y;
            double moveForward = Math.min(Math.abs(driver.zza) + Math.abs(driver.xxa), 1);

            // rotate head to match driver.
            float yaw = driver.yHeadRot;
            if (moveForward > 0) // rotate in the direction of the drivers controls
                yaw += (float) Mth.atan2(driver.zza, driver.xxa) * (180f / (float) Math.PI) - 90;
            yHeadRot = yaw;
            setXRot(driver.getXRot() * 0.68f);

            // rotate body towards the head
            setYRot(Mth.rotateIfNecessary(yHeadRot, getYRot(), 4));

            if (isControlledByLocalInstance()) // Client applies motion
            {
                if (isFlying)
                {
                    moveForward = moveForward > 0? moveForward : 0;
                    if (moveForward > 0) moveY = -driver.getXRot() * (Math.PI / 180);
                    else moveY = driver.jumping ? 1 : -0.01;
                }
                else if (driver.jumping && canFly()) liftOff();

                vec3 = new Vec3(moveSideways, moveY, moveForward);
                setSpeed(speed);
            }
            else if (driver instanceof Player) // other clients receive animations
            {
                calculateEntityAnimation(true);
                setDeltaMovement(Vec3.ZERO);
                return;
            }
        }

        if (isFlying)
        {
            // Move relative to yaw - handled in the move controller or by driver
            moveRelative(speed, vec3);
            move(MoverType.SELF, getDeltaMovement());
            if (getDeltaMovement().lengthSqr() < 0.1) // we're not actually going anywhere, bob up and down.
                setDeltaMovement(getDeltaMovement().add(0, Math.sin(tickCount / 4f) * 0.03, 0));
            setDeltaMovement(getDeltaMovement().scale(0.9f)); // smoothly slow down

            calculateEntityAnimation( true);
        }
        else super.travel(vec3);
    }

    public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {

        if (!this.level().isClientSide) {
            p_230254_1_.setYRot(this.getYRot());
            p_230254_1_.setXRot(this.getXRot());
            p_230254_1_.startRiding(this);
        }
        return InteractionResult.sidedSuccess(this.level().isClientSide);
    }
    /**
     * Returns the int-precision distance to solid ground.
     * Describe an inclusive limit to reduce iterations.
     */
    public double getAltitude(int limit)
    {
        var pointer = blockPosition().mutable().move(0, -1, 0);
        var min = level().dimensionType().minY();
        var i = 0;

        while(i <= limit && pointer.getY() > min && !level().getBlockState(pointer).isSolid())
            pointer.setY(getBlockY() - ++i);

        return i;
    }

    @Override
    public boolean startRiding(Entity p_21396_, boolean p_21397_) {
        this.time = 0;
        return super.startRiding(p_21396_, p_21397_);
    }

    /**
     * Returns the distance to the ground while the entity is flying.
     */
    public double getAltitude()
    {
        return getAltitude(level().getMaxBuildHeight());
    }

    public boolean isHighEnough(int height)
    {
        return getAltitude(height) >= height;
    }

    public void liftOff()
    {
        if (canFly()) jumpFromGround();
    }

    @Override
    protected float getJumpPower()
    {
        // stronger jumps for easier lift-offs
        return super.getJumpPower() * (canFly()? 3 : 1);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource)
    {
        return !canFly() && super.causeFallDamage(pFallDistance, pMultiplier, pSource);
    }


    @Override
    protected void tickDeath()
    {
        // unmount any riding entities
        ejectPassengers();

        this.level().explode(null, this.getX(), this.getY(), this.getZ(), (float)4, false, Level.ExplosionInteraction.BLOCK);

        // freeze at place
        setDeltaMovement(Vec3.ZERO);
        setYRot(yRotO);
        setYHeadRot(yHeadRotO);

        if (deathTime >= getMaxDeathTime()) remove(RemovalReason.KILLED); // actually delete entity after the time is up

        deathTime++;
    }

//    @Override
//    protected SoundEvent getAmbientSound()
//    {
//        double random = getRandom().nextDouble();
//
//        if (random < 0.2) return SoundEvents.ENDER_DRAGON_GROWL;
//        if (getBreed().specialSound().isPresent() && random < 0.5) return getBreed().getAmbientSound();
//        return DMLRegistry.DRAGON_BREATHE_SOUND.get();
//    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENDER_DRAGON_HURT;
    }
//
//    public SoundEvent getStepSound()
//    {
//        return DMLRegistry.DRAGON_STEP_SOUND.get();
//    }
//
//    /**
//     * Returns the sound this mob makes on death.
//     */
//    @Override
//    protected SoundEvent getDeathSound()
//    {
//        return DMLRegistry.DRAGON_DEATH_SOUND.get();
//    }

    @Override
    public SoundEvent getEatingSound(ItemStack itemStackIn)
    {
        return SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getAttackSound()
    {
        return SoundEvents.GENERIC_EAT;
    }

    public SoundEvent getWingsSound()
    {
        return SoundEvents.ENDER_DRAGON_FLAP;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
//    @Override
//    protected void playStepSound(BlockPos entityPos, BlockState state)
//    {
//        if (isInWater()) return;
//
//        // override sound type if the top block is snowy
//        SoundType soundType = state.getSoundType();
//        if (level.getBlockState(entityPos.above()).getBlock() == Blocks.SNOW)
//            soundType = Blocks.SNOW.getSoundType(state, level, entityPos, this);
//
//        // play stomping for bigger dragons
//        SoundEvent stepSound = getStepSound();
//        if (isHatchling()) stepSound = soundType.getStepSound();
//
//        playSound(stepSound, soundType.getVolume(), getVoicePitch());
//    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getAmbientSoundInterval()
    {
        return 240;
    }

    @Override
    protected float getSoundVolume()
    {
        return getScale();
    }

    @Override
    public float getVoicePitch()
    {
        return 2 - getScale();
    }

//    @Override
//    public void playSound(SoundEvent pSound, float pVolume, float pPitch)
//    {
//        if (pSound == breed.getAmbientSound()) pPitch /= 2;
//        super.playSound(pSound, pVolume, pPitch);
//    }
//
//    @Override
//    public ItemStack getPickedResult(HitResult target)
//    {
//        return DragonSpawnEgg.create(getBreed());
//    }
//
//    @Override
//    protected Component getTypeName()
//    {
//        return Component.translatable(getBreed().getTranslationKey());
//    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean isFoodItem(ItemStack stack)
    {
        return stack.getItem().isEdible() && stack.getItem().getFoodProperties().isMeat();
    }

    // the "food" that enables breeding mode
//    @Override
//    public boolean isFood(ItemStack stack)
//    {
//        return stack.is(getBreed().breedingItems());
//    }

    public void tamedFor(Player player, boolean successful)
    {
        if (successful)
        {
            setTame(true);
            navigation.stop();
            setTarget(null);
            setOwnerUUID(player.getUUID());
            level().broadcastEntityEvent(this, (byte) 7);
        }
        else
        {
            level().broadcastEntityEvent(this, (byte) 6);
        }
    }

    public boolean isTamedFor(Player player)
    {
        return isTame() && isOwnedBy(player);
    }

    /**
     * Returns the height of the eyes. Used for looking at other entities.
     */
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn)
    {
        return sizeIn.height * 1.2f;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    @Override
    public double getPassengersRidingOffset()
    {
        return getBbHeight() - 0.175;
    }

    /**
     * Returns render size modifier
     */
    @Override
    public float getScale()
    {
        return 0.33f + (0.67f * getAgeProgress());
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer)
    {
        return false;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean onClimbable()
    {
        // this better doesn't happen...
        return false;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn)
    {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);

        if (isSaddled()) spawnAtLocation(Items.SADDLE);
    }

//    @Override
//    protected ResourceLocation getDefaultLootTable()
//    {
//        return breed.deathLoot();
//    }

    @Override
    public boolean doHurtTarget(Entity entityIn)
    {
        boolean attacked = entityIn.hurt(damageSources().mobAttack(this), (float) getAttribute(ATTACK_DAMAGE).getValue());

        if (attacked) doEnchantDamageEffects(this, entityIn);

        return attacked;
    }

    public void onWingsDown(float speed)
    {
        if (!isInWater())
        {
            // play wing sounds
            float pitch = (1 - speed);
            float volume = 0.3f + (1 - speed) * 0.2f;
            pitch *= getVoicePitch();
            volume *= getSoundVolume();
            level().playLocalSound(getX(), getY(), getZ(), getWingsSound(), SoundSource.VOICE, volume, pitch, true);
        }
    }

    @Override
    public void swing(InteractionHand hand)
    {
        // play eating sound
        playSound(getAttackSound(), 1, 0.7f);
        super.swing(hand);
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean hurt(DamageSource src, float par2)
    {
        if (isInvulnerableTo(src)) return false;

        // don't just sit there!
        setOrderedToSit(false);

        return super.hurt(src, par2);
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMate(Animal mate)
    {
        if (mate == this) return false; // No. Just... no.
        else if (!(mate instanceof EntityHeli)) return false;
        else if (!canReproduce()) return false;

        EntityHeli dragonMate = (EntityHeli) mate;

        if (!dragonMate.isTame()) return false;
        else if (!dragonMate.canReproduce()) return false;
        else return isInLove() && dragonMate.isInLove();
    }

    public boolean canReproduce()
    {
        return isTame();
    }

//    @Override
//    public void spawnChildFromBreeding(ServerLevel level, Animal animal)
//    {
//        if (!(animal instanceof EntityHeli mate))
//        {
//            DragonMountsLegacy.LOG.warn("Tried to mate with non-dragon? Hello? {}", animal);
//            return;
//        }
//
//        DragonEgg egg = DMLRegistry.DRAGON_EGG.get().create(level);
//
//        // pick a breed to inherit from
//        egg.setEggBreed(getRandom().nextBoolean()? breed : mate.breed);
//
//        // mix the custom names in case both parents have one
//        if (hasCustomName() && animal.hasCustomName())
//        {
//            String p1Name = getCustomName().getString();
//            String p2Name = animal.getCustomName().getString();
//            String babyName;
//
//            if (p1Name.contains(" ") || p2Name.contains(" "))
//            {
//                // combine two words with space
//                // "Tempor Invidunt Dolore" + "Magna"
//                // = "Tempor Magna" or "Magna Tempor"
//                String[] p1Names = p1Name.split(" ");
//                String[] p2Names = p2Name.split(" ");
//
//                p1Name = StringUtils.capitalize(p1Names[getRandom().nextInt(p1Names.length)]);
//                p2Name = StringUtils.capitalize(p2Names[getRandom().nextInt(p2Names.length)]);
//
//                babyName = getRandom().nextBoolean()? p1Name + " " + p2Name : p2Name + " " + p1Name;
//            }
//            else
//            {
//                // scramble two words
//                // "Eirmod" + "Voluptua"
//                // = "Eirvolu" or "Volueir" or "Modptua" or "Ptuamod" or ...
//                if (getRandom().nextBoolean()) p1Name = p1Name.substring(0, (p1Name.length() - 1) / 2);
//                else p1Name = p1Name.substring((p1Name.length() - 1) / 2);
//
//                if (getRandom().nextBoolean()) p2Name = p2Name.substring(0, (p2Name.length() - 1) / 2);
//                else p2Name = p2Name.substring((p2Name.length() - 1) / 2);
//
//                p2Name = StringUtils.capitalize(p2Name);
//
//                babyName = getRandom().nextBoolean()? p1Name + p2Name : p2Name + p1Name;
//            }
//
//            egg.setCustomName(Component.literal(babyName));
//        }
//
//        // increase reproduction counter
//        addReproCount();
//        mate.addReproCount();
//        egg.setPos(getX(), getY(), getZ());
//        level.addFreshEntity(egg);
//    }
//
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob)
    {
        var offspring = EntityInit.HELI.get().create(level);
        //offspring.setBreed(getBreed());
        return offspring;
    }

    @Override
    public boolean wantsToAttack(LivingEntity target, LivingEntity owner)
    {
        return !(target instanceof TamableAnimal tameable) || !Objects.equals(tameable.getOwner(), owner);
    }

    @Override
    public boolean canAttackType(EntityType<?> typeIn)
    {
        return !isHatchling() && super.canAttackType(typeIn);
    }

    @Override
    public boolean canAttack(LivingEntity target)
    {
        return !isHatchling() && super.canAttack(target);
    }

    public boolean canBeControlledByRider()
    {
        return true;
    }

    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    @Override
    public LivingEntity getControllingPassenger()
    {
        List<Entity> list = getPassengers();
        return list.isEmpty()? null : (LivingEntity)list.get(0);
    }

    public void setRidingPlayer(Player player)
    {
        player.setYRot(getYRot());
        player.setXRot(getXRot());
        player.startRiding(this);
    }

    @Override
    public void positionRider(Entity passenger, MoveFunction moveFunction)
    {
        Entity riddenByEntity = getControllingPassenger();
        if (riddenByEntity != null)
        {
            Vec3 pos = new Vec3(0, getPassengersRidingOffset() + riddenByEntity.getMyRidingOffset(), getScale())
                    .yRot((float) Math.toRadians(-yBodyRot))
                    .add(position());
            passenger.setPos(pos.x, pos.y-2, pos.z-0.8);

            // fix rider rotation
            if (getFirstPassenger() instanceof LivingEntity)
            {
                LivingEntity rider = ((LivingEntity) riddenByEntity);
                rider.xRotO = rider.getXRot();
                rider.yRotO = rider.getYRot();
                rider.yBodyRot = yBodyRot;
            }
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource src)
    {
        Entity srcEnt = src.getEntity();
        if (srcEnt != null && (srcEnt == this || hasPassenger(srcEnt))) return true;

        if (src == damageSources().dragonBreath() // inherited from it anyway
                || src == damageSources().cactus()) // assume cactus needles don't hurt thick scaled lizards
            return true;

        return super.isInvulnerableTo(src);
    }

    /**
     * Returns the entity's health relative to the maximum health.
     *
     * @return health normalized between 0 and 1
     */
    public double getHealthRelative()
    {
        return getHealth() / (double) getMaxHealth();
    }

    public int getMaxDeathTime()
    {
        return 20;
    }

    /**
     * Public wrapper for protected final setScale(), used by DragonLifeStageHelper.
     */
    @Override
    public void refreshDimensions()
    {
        double posXTmp = getX();
        double posYTmp = getY();
        double posZTmp = getZ();
        boolean onGroundTmp = onGround();

        super.refreshDimensions();

        // workaround for a vanilla bug; the position is apparently not set correcty
        // after changing the entity size, causing asynchronous server/client positioning
        setPos(posXTmp, posYTmp, posZTmp);

        // otherwise, setScale stops the dragon from landing while it is growing
        setOnGround(onGroundTmp);
    }

    @Override
    public EntityDimensions getDimensions(Pose poseIn)
    {
        var height = isInSittingPose()? 2.15f : BASE_HEIGHT;
        var scale = getScale();
        return new EntityDimensions(BASE_WIDTH * scale, height * scale, false);
    }

    @Override
    public int getAge()
    {
        return age;
    }

    public void updateAgeProgress()
    {
        // no reason to recalculate this value several times per tick/frame...
        float growth = 1200;
        float min = Math.min(getAge(), 0);
        ageProgress = 1 - (min / growth);
    }

    public float getAgeProgress()
    {
        return ageProgress;
    }

    private void updateAgeProperties()
    {
        setAge(entityData.get(DATA_AGE));
        updateAgeProgress();
        refreshDimensions();

        var mod = new AttributeModifier(SCALE_MODIFIER_UUID, "Dragon size modifier", getScale(), AttributeModifier.Operation.ADDITION);
        for (var attribute : new Attribute[]{MAX_HEALTH, ATTACK_DAMAGE}) // avoid duped code
        {
            AttributeInstance instance = getAttribute(attribute);
            instance.removeModifier(mod);
            instance.addTransientModifier(mod);
        }
    }

    public boolean isHatchling()
    {
        return getAgeProgress() < 0.5f;
    }

    public boolean isJuvenile()
    {
        return getAgeProgress() >= 0.5f && getAgeProgress() < 1f;
    }

    public boolean isAdult()
    {
        return getAgeProgress() >= 1f;
    }

    @Override
    public boolean isBaby()
    {
        return !isAdult();
    }

    @Override
    public void setBaby(boolean baby)
    {
        setAge(100);
        entityData.set(DATA_AGE, age);
    }

    @Override
    public void ageUp(int p_146741_, boolean p_146742_)
    {
        super.ageUp(p_146741_, p_146742_);
        entityData.set(DATA_AGE, getAge());
    }

    // simple helper method to determine if we're on the server thread.
    public boolean isServer()
    {
        return !level().isClientSide;
    }

//    public DragonAnimator getAnimator()
//    {
//        return animator;
//    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public boolean fireImmune()
    {
        return super.fireImmune();
    }

    @Override
    protected void onChangedBlock(BlockPos pos)
    {
        super.onChangedBlock(pos);
        //for (var ability : getBreed().abilities()) ability.onMove(this);
    }

    @Override
    public boolean isInWall()
    {
        if (noPhysics) return false;
        else
        {
            var collider = getBoundingBox().deflate(getBbWidth() * 0.2f);
            return BlockPos.betweenClosedStream(collider).anyMatch((pos) ->
            {
                BlockState state = level().getBlockState(pos);
                return !state.isAir() && state.isSuffocating(level(), pos) && Shapes.joinIsNotEmpty(state.getCollisionShape(level(), pos).move(pos.getX(), pos.getY(), pos.getZ()), Shapes.create(collider), BooleanOp.AND);
            });
        }
    }

    @Override
    public Vec3 getLightProbePosition(float p_20309_)
    {
        return new Vec3(getX(), getY() + getBbHeight(), getZ());
    }


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.helicopter.fly"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.helicopter.idle"));
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

    private void hurt(List<Entity> p_70971_1_) {
        for(Entity entity : p_70971_1_) {
            if (entity instanceof LivingEntity) {
                if(!(entity instanceof Player)) {
                    entity.hurt(damageSources().mobAttack(this), 8.0F);
                    this.doEnchantDamageEffects(this, entity);
                    if(random.nextInt(10)>8)
                    {
                        this.heal(random.nextFloat()*2);
                    }
                }
            }
        }
    }

    public boolean shoot(Player player, EntityHeli heli, Level world) {
        Player playerEntity = (Player) player;
        ItemStack itemStack = new ItemStack(ItemInit.HIGHEX.get());
        EntityHeli tankEntity = (EntityHeli) heli;
//        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
//            ItemStack stack = playerEntity.getInventory().offhand.get(i);
//            if (stack.getCount() >= shellsUsed) {
//                itemStack = stack;
//                break;
//            }
//            player.displayClientMessage(Component.literal("You don't have any ammo!").withStyle(ChatFormatting.RED, ChatFormatting.BOLD), false);
//        }
        if (this.time < this.shootingCooldown) {
            player.displayClientMessage(Component.literal("Reloading " + (shootingCooldown - time) / 20 + " s !").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
            world.playSound(null, player.blockPosition(), SoundEvents.DISPENSER_FAIL, SoundSource.BLOCKS, 1.0f, 1.0f);
            return false;
        }
//        if (itemStack.is(ItemInit.MOPRO.get())) {
        else{
            player.displayClientMessage(Component.literal("Fire!").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD), false);
            Vec3 vec3 = this.getBoundingBox().getCenter();
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                this.level().addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, 0,0,0);
                EntityHighEx bomb = new EntityHighEx(level(), player,0);
                bomb.setItem(itemStack);
                bomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level().addFreshEntity(bomb);
            }
        }


//        ThrownTrident throwntrident = new ThrownTrident(world, player, new ItemStack(ItemInit.VTRIDENT.get()).copy());
//            //ThrownTrident throwntrident = new ThrownTrident(p_43395_, player);
//            throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
//            world.addFreshEntity(throwntrident);
//            System.out.println("shoot!");
//            Fire shellEntity = new ItemEntity(heli, world);
//            shellEntity.shootFromRotation(tankEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 3.5F, 0F);
//            world.addFreshEntity(shellEntity);
//            itemStack.shrink(shellsUsed);
//        }
        time = 0;
        return true;
    }

}