package com.joy187.re8joymod.entity;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;


public class EntityNovi extends FlyingBird implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private float R;
    private float G;
    private float B;
    private float NewR;
    private float NewG;
    private float NewB;
    private int colorSpeed = 4;

    private BlockState currentState;
    private int currentMultiplier;

    public EntityNovi(EntityType<? extends EntityNovi> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D,true));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    @Override
    public void tick() {
        if (this.isInWater() && !this.horizontalCollision) {
            this.setDeltaMovement(0,0.02D,0);
        }

        if(this.level().isClientSide)
        {
            changeColor(this);
        }

        if(R != NewR || G != NewG || B != NewB)
        {
            for(int i = 0; i < colorSpeed; i++)
            {
                if(R > NewR)
                {
                    R--;
                }
                else if (R < NewR)
                {
                    R++;
                }

                if(G > NewG)
                {
                    G--;
                }
                else if (G < NewG)
                {
                    G++;
                }

                if(B > NewB)
                {
                    B--;
                }
                else if (B < NewB)
                {
                    B++;
                }
            }
        }
        super.tick();
    }

    public float[] getSkinRGB()
    {
        return new float[]{R,G,B};
    }

    public void setSkinRGB(int[] RGB)
    {
        R = (float)RGB[0];
        G = (float)RGB[1];
        B = (float)RGB[2];
    }

    public float[] getNewSkinRGB()
    {
        return new float[]{NewR,NewG,NewB};
    }

    public void setNewSkinRGB(int[] RGB)
    {
        NewR = (float)RGB[0];
        NewG = (float)RGB[1];
        NewB = (float)RGB[2];
    }

    public int changeColor(Entity entity)
    {
        int i = Mth.floor(entity.getX());
        int j = Mth.floor(entity.getBoundingBox().minY);
        int k = Mth.floor(entity.getZ());

        if(entity.level().getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.AIR)
        {
            j = Mth.floor(entity.getBoundingBox().minY - 1);
        }

        BlockPos pos = new BlockPos(i, j, k);
        BlockState state = entity.level().getBlockState(pos);
        //System.out.println("当前方块为："+state);
        int colorMultiplier = Minecraft.getInstance().getBlockColors().getColor(state, level(), pos, 0);
        return colorMultiplier;
        //PrimitiveMobsLogger.info(worldObj, state + " " + colorMultiplier);
//        if(state.getBlock() != Blocks.AIR && (currentState != state || currentMultiplier != colorMultiplier))
//        {
//            currentState = state;
//            currentMultiplier = colorMultiplier;
//
//            int ii = colorMultiplier;
//            float f = (float)(ii >> 16 & 255) / 255.0F;
//            float f1 = (float)(ii >> 8 & 255) / 255.0F;
//            float f2 = (float)(ii & 255) / 255.0F;
//            int[] newColor = new int[]{f,f1,f2,255};//ColorUtil.getBlockStateColor(state, pos, level, true);
//
//            if(newColor != null)
//            {
//                if(ColorUtil.isColorInvalid(newColor))
//                {
//                    newColor = new int[]{63,118,42,255};
//                }
//                setNewSkinRGB(newColor);
//            }
//        }
    }
    
    @Override
    public float getStepHeight() {
        return 2.1F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SILVERFISH_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pdamageSources) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity living) {
//                int duration = switch (this.level().getDifficulty()) {
//                    case EASY -> 5f;
//                    case HARD -> 6.5f;
//                    default -> 6f;
//                };

                living.addEffect(new MobEffectInstance(MobEffects.HUNGER,   20*this.level().getDifficulty().getId(), 0));
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    protected boolean canRide(Entity entityIn) {
        return false;
    }

    @Override
    public boolean isSpooked() {
        return false;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.novi.fly"));
            return PlayState.CONTINUE;
        }


        event.setAndContinue(RawAnimation.begin().thenPlay("animation.novi.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.getTarget()!=null) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.novi.attack"));
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

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.fallDistance=0;
    }

}

