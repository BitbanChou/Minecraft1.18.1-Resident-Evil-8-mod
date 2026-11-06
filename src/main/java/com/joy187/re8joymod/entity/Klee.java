package com.joy187.re8joymod.entity;

//import com.github.L_Ender.cataclysm.config.CMConfig;
//import com.github.L_Ender.cataclysm.entity.Endermaptera_Entity;
//import com.github.L_Ender.cataclysm.entity.AI.CmAttackGoal;
//import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
//import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
//import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
//import com.github.L_Ender.cataclysm.init.ModSounds;
//import com.github.L_Ender.cataclysm.init.ModTag;
//import com.github.alexthe666.citadel.animation.Animation;
//import com.github.alexthe666.citadel.animation.AnimationHandler;


import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class Klee extends genshinBoss {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

//    public static final RawAnimation ANIMATION_ATTACK1 = new RawAnimation("riptide");
//    public static final RawAnimation ANIMATION_ATTACK2 = new RawAnimation("swing_hand");
//    public static final RawAnimation ANIMATION_EARTHQUAKE = new RawAnimation("climb");
//    public static final RawAnimation FLY_ATTACK = new RawAnimation("fly");
//    public static final RawAnimation KLEE_DEATH = new RawAnimation("death");
    public static final int FLY_ATTACK_COOLDOWN = 40;
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Klee.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Klee.class,
            EntityDataSerializers.INT);
    private int void_rune_attack_cooldown = 0;
    private int timeWithoutTarget;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    public boolean Breaking = true;//CMConfig.EndergolemBlockBreaking;

    public Klee(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        //this.maxUpStep = 1.5F;
//        this.navigation = this.createNavigation(world);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        //setConfigattribute(this, CMConfig.EnderGolemHealthMultiplier, CMConfig.EnderGolemDamageMultiplier);
        //this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
        //this.setItemSlot(EquipmentSlot.FEET, EnchantmentHelper.enchantItem(this.getRandom(), new ItemStack(Items.LEATHER_BOOTS), (int)(5.0F + p_217053_ * (float)p_217052_.nextInt(18))));
    }

    //@Override
//    public RawAnimation[] getAttckingStates() { // -1, 1,             2,                   3,                 4
//        return new RawAnimation[]{null, ANIMATION_ATTACK1, ANIMATION_ATTACK2, ANIMATION_EARTHQUAKE,FLY_ATTACK,KLEE_DEATH};
//    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new KleeAttackGoal(this,1.0));
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        //this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(0, new AwakenGoal());
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    public static Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ARMOR, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Klee);
    };

    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    private static int getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(4)) {
            case 0:
                return 1;//ANIMATION_ATTACK1;
            case 1:
                return 2;//ANIMATION_ATTACK2;
            case 2:
                return 3;//ANIMATION_EARTHQUAKE;
            case 3:
                return 3;//ANIMATION_EARTHQUAKE;
        }
        return 3;//ANIMATION_EARTHQUAKE;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAttckingState()==4
                || !this.getIsAwaken()) {
            if(!source.isCreativePlayer() || !source.is(DamageTypes.MAGIC)) {
                damage *= 0.5;
            }
        }
        double range = calculateRange(source);

        if (range > 4*4) {
            return false;
        }

        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage *= 0.5;
        }

        if(entity instanceof Bomb || entity instanceof EntityHonghong || entity instanceof JumpBomb)
            damage=0;

        if(entity instanceof LivingEntity && (entity.getBbHeight()>1.5F || entity.getBbHeight()>=2.4f))
            damage*=0.1;

        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_AWAKEN,false);
        this.entityData.define(STATE, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsAwaken(compound.getBoolean("is_Awaken"));
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.entityData.get(IS_AWAKEN);
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            if(this.getAttckingState()==2){
                event.setAndContinue(RawAnimation.begin().thenLoop("run"));
                this.setSpeed((float) (Attributes.MOVEMENT_SPEED.getDefaultValue()*2f));
                this.heal(1F);
            }
            else
            {
                event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
                this.setSpeed((float) (Attributes.MOVEMENT_SPEED.getDefaultValue()));
            }
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

//    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
//        if(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())
//        {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.death"));
//            return PlayState.CONTINUE;
//        }
//
//        if (event.isMoving()) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.walk"));
//            return PlayState.CONTINUE;
//        }
//
//        event.setAndContinue(RawAnimation.begin().thenPlay("animation.lycan.idle"));
//        return PlayState.CONTINUE;
//    }
    
    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("riptide"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("swing_hand"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("climb"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 4 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("fly"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
//        data.addAnimationController(new AnimationController(this, "controller",
//                0, this::predicate));
//        data.addAnimationController(new AnimationController(this, "controller1",
//                0, this::predicate1));
//    }

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
    public void tick() {
        super.tick();
        float fx=this.random.nextFloat()<0.35?1:-1;
        float fz=this.random.nextFloat()<0.55?1:-1;
        if(!this.onGround() && this.getAttckingState() == 4){
            this.setDeltaMovement(fx*this.random.nextFloat()*0.02,-0.05,fz*this.random.nextFloat()*0.02);
        }
        //System.out.println(this.getAttckingState());
        //this.yHeadRot = renderYawOffset;
        repelEntities(0.3F, 0.6f, 0.3F, 0.5F);
        //AnimationHandler.INSTANCE.updateAnimations(this);
        LivingEntity target = this.getTarget(); //.getTarget();
        prevdeactivateProgress = deactivateProgress;
//        if (!this.getIsAwaken() && deactivateProgress < 3F) {
//            deactivateProgress++;
//        }
//        if (this.getIsAwaken() && deactivateProgress > 0F) {
//            deactivateProgress--;
//
//        }
        if(this.tickCount%60==0 && !this.getIsAwaken()) {
            this.setIsAwaken(true);
        }
        else {
            this.setIsAwaken(false);
        }

        if(!this.getIsAwaken()) {
            if (this.tickCount % 30 == 0) {
                this.heal(2.0F);
            }
        }

        if (this.isAlive()) {
            if (this.tickCount % 200 == 0) {
                double throwSpeed = 0.7D;
                for(int i = 0; i < 4; ++i) {
                    if (this.getHealth() < this.getMaxHealth() / 20.0F) {
                        Bomb s1 = (EntityInit.BOMB.get()).create(this.level());

                        assert s1 != null;

                        s1.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                        s1.setOwner(this);
                        if (i == 0) {
                            s1.setDeltaMovement(-throwSpeed, 0.5D, -throwSpeed);
                        } else if (i == 1) {
                            s1.setDeltaMovement(-throwSpeed, 0.5D, throwSpeed);
                        } else if (i == 2) {
                            s1.setDeltaMovement(throwSpeed, 0.5D, -throwSpeed);
                        } else {
                            s1.setDeltaMovement(throwSpeed, 0.53D, throwSpeed);
                        }

                        this.level().addFreshEntity(s1);
                    }
                }
            }
                
            if (target != null && target.isAlive()) {
                if (void_rune_attack_cooldown <= 0 && this.getAttckingState()!=4 && target.onGround() && (this.random.nextInt(45) == 0 && this.distanceToSqr(target) < 4 || this.random.nextInt(24) == 0 && this.distanceToSqr(target) < 10)) {
                    void_rune_attack_cooldown = FLY_ATTACK_COOLDOWN;
                    //this.setAnimation(FLY_ATTACK);
                    float skill=this.random.nextFloat();
                    if(skill<0.4)
                    {
                        if(this.random.nextFloat()<0.4)
                            this.playSound(SoundInit.ENTITY_KLEE_HONGHONG.get(), 1, 1);
                        else
                            this.playSound(SoundInit.ENTITY_KLEE_HONGHONG2.get(), 1, 1);
                        this.setDeltaMovement(this.random.nextFloat(),1D+this.random.nextDouble(),this.random.nextFloat());
                        this.setAttackingState(4);
                        EntityHonghong enderBomb = new EntityHonghong(EntityInit.FIRE_ENTITY.get(), this.level());
                        enderBomb.setPos(this.position());
                        enderBomb.setTarget(this.getTarget());
                        enderBomb.setAttackType(0);
                        this.level().addFreshEntity(enderBomb);
                        //this.getNavigation().moveTo(target.getX()+this.random.nextFloat()*2*this.random.nextFloat()<0.2?1:-1,target.getY(),target.getZ()-this.random.nextFloat()*2*this.random.nextFloat()<0.2?1:-1,0.3F);
                        this.push(0.3+this.random.nextFloat()*fx,0,0.3+this.random.nextFloat()*fz);
                        this.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,80));
                        this.setAttackingState(0);
                    }
                    else if(skill>0.8){
                        double throwSpeed = 0.15D;
                        if(this.random.nextFloat()<0.5)
                            this.playSound(SoundInit.ENTITY_KLEE_BENGBENG.get(), 1, 1);
                        else
                            this.playSound(SoundInit.ENTITY_KLEE_BENGBENG2.get(), 1, 1);
                        for(int i = 0; i < 1; ++i) {
                            if (this.getHealth() > this.getMaxHealth() / 20.0F) {
                                JumpBomb s1 = (EntityInit.JUMPBOMB.get()).create(this.level());

                                assert s1 != null;

                                s1.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                                if(this.getTarget()!=null)
                                    s1.setTarget(this.getTarget());
                                s1.setOwner(this);
                                if (i == 0) {
                                    s1.setDeltaMovement(-throwSpeed, 0.3D, -throwSpeed);
                                } else if (i == 1) {
                                    s1.setDeltaMovement(-throwSpeed, 0.3D, throwSpeed);
                                } else if (i == 2) {
                                    s1.setDeltaMovement(throwSpeed, 0.3D, -throwSpeed);
                                } else {
                                    s1.setDeltaMovement(throwSpeed, 0.3D, throwSpeed);
                                }

                                this.level().addFreshEntity(s1);
                            }
                        }
                    }
                    else{
                        this.setAttackingState(2);
                        this.getNavigation().moveTo(target,0.3F);
                    }
                    //this.setDeltaMovement(this.random.nextFloat(),0,this.random.nextFloat());
                } else if (this.distanceToSqr(target) < 4D && this.getAttckingState() == 0) {
                    int animation = getRandomAttack(this.random);
                    //this.setAnimation(animation);
                    this.setAttackingState(animation);
                }
            }

            if (this.getAttckingState() == 3) {
                if (this.tickCount%6 == 0) {
                    EarthQuake(5,6);
                    EarthQuakeParticle();
                    //ScreenShake_Entity.ScreenShake(world, this.getPositionVec(), 15, 0.1f, 0, 10);
                    if (Breaking) {
                        for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                            double d00 = lvt.getX() - this.getX();
                            double d10 = lvt.getZ() - this.getZ();
                            double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                            lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
                            lvt.hurt(damageSources().mobAttack(this), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue());
                        }
                        //BlockBreaking(4,4,4);
                    } else {
                        if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            //BlockBreaking(4, 4, 4);
                            this.playSound(SoundInit.ENTITY_KLEE_BENGBENG.get(), 1, 1);
                            this.setAttackingState(0);
                            double throwSpeed = 0.15D;
                            for(int i = 0; i < 1; ++i) {
                                if (this.getHealth() > this.getMaxHealth() / 20.0F) {
                                    JumpBomb s1 = (EntityInit.JUMPBOMB.get()).create(this.level());

                                    assert s1 != null;

                                    s1.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                                    if(this.getTarget()!=null)
                                        s1.setTarget(this.getTarget());
                                    s1.setOwner(this);
                                    if (i == 0) {
                                        s1.setDeltaMovement(-throwSpeed, 0.3D, -throwSpeed);
                                    } else if (i == 1) {
                                        s1.setDeltaMovement(-throwSpeed, 0.3D, throwSpeed);
                                    } else if (i == 2) {
                                        s1.setDeltaMovement(throwSpeed, 0.3D, -throwSpeed);
                                    } else {
                                        s1.setDeltaMovement(throwSpeed, 0.3D, throwSpeed);
                                    }

                                    this.level().addFreshEntity(s1);
                                }
                            }
                        }
                    }
                }
            }
            if ((this.getAttckingState() == 1 || this.getAttckingState() == 2) && this.tickCount % 13==0) {
                if(this.getAttckingState()==2)
                    this.playSound(SoundInit.ENTITY_KLEE_ATTACK1.get(), 1, 1);
                if (target != null) {
                    if(this.getAttckingState() ==1 ){
                        this.playSound(SoundInit.ENTITY_KLEE_ATTACK2.get(), 1, 1);
                        float f7 = this.getYRot();
                        float f = this.getXRot();
                        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 0.8F * ((1.0F + 1) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        this.push((double)this.getLookAngle().x, 1D, (double)this.getLookAngle().z);
                        //this.startAutoSpinAttack(20);
                        if (this.onGround()) {
                            float f6 = 1.1999999F;
                            this.move(MoverType.SELF, new Vec3(0.0D, 0.1D, 0.0D));
                        }
                        this.setAttackingState(0);
                    }
                    if(this.getAttckingState() ==2 ){
                        EarthQuake(4.25f,4);
                        EarthQuakeParticle();
                        this.getNavigation().moveTo(target, 1.5D*this.getSpeed());
                    }
                    if (this.distanceToSqr(target) < 4.75F) {
                        target.hurt(damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getArmorValue());
                        this.heal(this.random.nextInt(4));
                        //target.knockback(0.5F, this.getX() - target.getX(), this.getZ() - target.getZ());
                    }
                }
            }
            if (this.getAttckingState() == 4) {
                if (this.tickCount%3==0) {
                    //ScreenShake_Entity.ScreenShake(world, this.getPositionVec(), 15, 0.1f, 0, 10);
                    if (!this.level().isClientSide) {
                        if (Breaking) {
                            //BlockBreaking(4, 4, 4);
                        } else {
                            if (ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                                //BlockBreaking(4, 4, 4);
                            }
                        }
                    }
                }
                if (this.tickCount%7==0) {
                    VoidRuneAttack();
                }
            }
        }
        if (void_rune_attack_cooldown > 0) void_rune_attack_cooldown--;
        if (!level().isClientSide) {
            timeWithoutTarget++;
            if (target != null) {
                timeWithoutTarget = 0;
                if(!this.getIsAwaken()) {
                    this.setIsAwaken(true);
                }
            }

            if (timeWithoutTarget > 400 && this.getIsAwaken() && target == null) {
                timeWithoutTarget = 0;
                this.setIsAwaken(false);
            }
        }

        if(this.tickCount%30==0){
            this.setAttackingState(0);
        }

    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        boolean flag = false;
        if (!this.level().isClientSide) {
            for (int k2 = -x; k2 <= x; ++k2) {
                for (int l2 = -z; l2 <= z; ++l2) {
                    for (int j = 0; j <= y; ++j) {
                        int i3 = MthX + k2;
                        int k = MthY + j;
                        int l = MthZ + l2;
                        BlockPos blockpos = new BlockPos(i3, k, l);
                        BlockState blockstate = this.level().getBlockState(blockpos);
                        Block block = blockstate.getBlock();
                        //ITag<Block> Tag = BlockTags. .getCollection().get(ModTag.ENDER_GOLEM_CAN_DESTROY);
                        if (block != Blocks.AIR && block != Blocks.BEDROCK) {
                            if (blockstate.canEntityDestroy(this.level(), blockpos, this) && ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                flag = this.level().destroyBlock(blockpos, true, this) || flag;
                            }
                        }
                    }
                }
            }
        }
    }


    private void EarthQuakeParticle() {
        if (this.level().isClientSide) {
            BlockState block = level().getBlockState(getOnPos().below());
            for (int i1 = 0; i1 < 20 + random.nextInt(12); i1++) {
                double motionX = random.nextGaussian() * 0.07D;
                double motionY = random.nextGaussian() * 0.07D;
                double motionZ = random.nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.rotOffs) + i1;
                double extraX = 4F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 4F * Mth.cos(angle);
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ, motionX, motionY, motionZ);
            }
        }
    }

    private void EarthQuake(float grow, int damage) {
        //this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.random.nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
            if (!isOnSameTeam(entity) && !(entity instanceof Klee) && entity != this) {
                entity.hurt(damageSources().magic(), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(damage));
                //launch(entity);
            }
        }
    }


    private void VoidRuneAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.yHeadRot * ((float) Math.PI / 180F)) * (2.0F);
            float f3 = Mth.sin(this.yHeadRot * ((float) Math.PI / 180F)) * (2.0F);
            for(int l = 0; l < 10; ++l) {
                double d2 = 1.5D * (double)(l + 1);
                int j = (int) (1.25f * l);
                this.spawnFangs(this.getX() + f2 + (double) Mth.cos(f) * d2, this.getZ() + f3 + (double) Mth.sin(f) * d2, d0, d1, f, j);
                this.spawnFangs(this.getX() - f2 + (double) Mth.cos(f) * d2, this.getZ() - f3 + (double) Mth.sin(f) * d2, d0, d1, f, j);
            }
            for (int k = 0; k < 6; ++k) {
                float f4 = f + (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 7.5F);
                this.spawnFangs(this.getX() + (double) Mth.cos(f4) * 2.5D, this.getZ() + (double) Mth.sin(f4) * 2.5D, d0, d1, f2, 5);
            }
            for (int k = 0; k < 8; ++k) {
                this.spawnFangs(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 15);
            }

        }
    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = new BlockPos(Mth.floor(x), Mth.floor(maxY), Mth.floor(z));
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
                        //d0 = voxelshape.(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            //this.level().addFreshEntity(new Void_Rune_Entity(this.level, x, (double)blockpos.getY() + d0, z, rotation, delay, this));
        }
    }

    private void launch(Entity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.1D : 0.2F, d1 / d2 * f);
    }

    public boolean isOnSameTeam(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
//        else if (super.(entityIn)) {
//            return true;
//        }
        else if (entityIn instanceof Klee) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setDeltaMovement(0, this.getDeltaMovement().y, 0);
        if (this.deathTime == 40) {
            //this.playSound(ModSounds.MONSTROSITYLAND.get(), 1, 1);
        }

    }


    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return null;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SHEEP_STEP, 1.0F, 1.0F);
    }

    protected SoundEvent getAmbientSound(DamageSource damageSourceIn) {
        if(this.random.nextFloat()<0.4)
            return SoundEvents.SLIME_HURT;
        return SoundInit.ENTITY_KLEE_HURT.get();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0) return SoundInit.ENTITY_KLEE_AMBIENT2.get();
        if(co==1) return SoundInit.ENTITY_KLEE_AMBIENT1.get();
        return SoundInit.ENTITY_KLEE_ATTACK2.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        if(this.random.nextFloat()<0.4)
            return SoundEvents.SLIME_HURT;
        return SoundInit.ENTITY_KLEE_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        if(this.random.nextFloat()<0.5)
            return SoundInit.ENTITY_KLEE_DEATH1.get();
        return SoundInit.ENTITY_KLEE_DEATH2.get();
    }

//    @Override
//    protected BodyController createBodyController() {
//        return new SmartBodyHelper2(this);
//    }

//    protected PathNavigation createNavigator(Level worldIn) {
//        return new CMPathNavigateGround(this, world);
//    }

//    protected PathNavigation createNavigation(Level level) {
//        return new KleePathNavigateGround(this, level);
//    }

    class KleeAttackGoal extends MeleeAttackGoal {

        private LivingEntity target;
        private int delayCounter;
        protected final double moveSpeed;

        public KleeAttackGoal(PathfinderMob creatureEntity, double moveSpeed) {
            super(creatureEntity, moveSpeed,true);
            this.moveSpeed = moveSpeed;
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && this.target.isAlive();
        }

        public void stop() {
            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }

        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
                double distSq = this.mob.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.mob.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.mob.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.mob.isPathFinding() && !this.mob.getNavigation().moveTo(target, 1.0D)) {
                            this.delayCounter += 5;
                        }
                    } else {
                        this.mob.getNavigation().moveTo(target, this.moveSpeed);
                    }
                }

            }
        }
    }
}