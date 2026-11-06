package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import com.sun.jna.platform.win32.WinBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityMiranda1 extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private int defendflag=0;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMiranda1.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMiranda1.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityMiranda1.class,
            EntityDataSerializers.INT);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
    };

    public EntityMiranda1(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 280;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }


    protected boolean isSunSensitive() {
        return true;
    }

    public void aiStep() {
        super.aiStep();

        if(this.entityData.get(DEFENDSTATE)==1) {
            //System.out.println("DEFEND!");
            this.defend();
        }
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.32D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 5.0D).
                add(Attributes.ARMOR_TOUGHNESS, 5.0D).
                add(Attributes.ATTACK_DAMAGE, 8.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
    }


    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WITHER, 20,0,true,true));
            }
            return true;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_DEATH1.get();
        }
        return SoundInit.ENTITY_MIRA_DEATH2.get();
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_AMBIENT1.get();
        }
        else if(co==1) return  SoundInit.ENTITY_MIRA_AMBIENT3.get();
        return SoundInit.ENTITY_MIRA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_MIRA_HURT1.get();
        }
        return SoundInit.ENTITY_MIRA_HURT2.get();
    }

    public int getInvulnerableTicks() {
        return 200;
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 3F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        this.entityData.set(DATA_ID_INV, p_82215_1_);
    }

    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setInvulnerableTicks(p_70037_1_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }

    }

    public void setCustomName(@Nullable Component p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        if(this.isInWall()){
            this.teleportTo(this.getX()+2*this.random.nextFloat(),this.getY(),this.getZ()+2*this.random.nextFloat());
        }

        Random ran = new Random();
        if(this.getHealth() >= 10.0F && this.getHealth()<=18.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(2.0F*ran.nextFloat());
            this.level().addParticle(ParticleTypes.WHITE_ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
        }
//	        if(this.getHealth() >= 50.0F && this.getHealth()<=55.0F){
//	            //this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
//	            if(this.defendflag==1)
//	            {
//		        	defend();
//		            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*5,10,true,true));
//		            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*5,10,true,true));
//		            this.defendflag=2;
//	            }
//	       	}
//	        if(this.getHealth() >= 100.0F && this.getHealth()<=120.0F){
//	            //this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
//	            if(this.defendflag==0)
//	            {
//		        	defend();
//		            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*5,10,true,true));
//		            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*5,10,true,true));
//		            this.defendflag=1;
//	            }
//	       	}
        if(this.getHealth() >= 130.0F && this.getHealth()<=160.0F){
            this.level().addParticle(ParticleTypes.LANDING_OBSIDIAN_TEAR, this.getX()+ran.nextFloat(), this.getY(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
        }


        if(this.getHealth() >= 0.1F && this.getHealth()<=10.0F)
        {
            this.convertTo(EntityInit.MIRANDA2.get(),true);
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    //}

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
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

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda1.walk"));
            return PlayState.CONTINUE;
        }
        Random ran = new Random();
        int co = ran.nextInt(30);
        if(co==1) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda1.idle2"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda1.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda1.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda1.attack2"));
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

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    public int getDefendingState() {
        return this.entityData.get(DEFENDSTATE);
    }

    public void setDefendingState(int time) {
        this.entityData.set(DEFENDSTATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
    }

    static class AttackGoal extends Goal {
        private final EntityMiranda1 parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityMiranda1 mob) {
            this.parentEntity = mob;
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
            if (this.parentEntity.hasLineOfSight(livingentity)) {
                Level world = this.parentEntity.level();
                //++this.attackTimer;
                if(!this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE))
                {
                    ++this.attackTimer;
                }
                else {
                    this.parentEntity.setDefendingState(0);
                }
                Random rand = new Random();
                Vec3 vector3d = this.parentEntity.getViewVector(1.0F);
                double d0 = Math.min(livingentity.getY(), livingentity.getY());
                double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
                double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 2.0D);
                double d3 = livingentity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
                double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 2.0D);
                float f = (float) Mth.atan2(livingentity.getZ() - parentEntity.getZ(),
                        livingentity.getX() - parentEntity.getX());

                if (this.attackTimer == 10) {
                    if((this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.8 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.9))
                            || (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.4 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.5))
                            || (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.2 && (this.parentEntity.getHealth()>=this.parentEntity.getMaxHealth()*0.3)))
                    {
                        this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                        this.parentEntity.setAttackingState(2);
                        this.parentEntity.attackAnim=2;
                    }
                    else{
                        this.parentEntity.getNavigation().stop();
                        this.parentEntity.setAttackingState(1);
                        this.parentEntity.attackAnim=1;
                    }
                }

                if(this.attackTimer==15 && this.parentEntity.getAttckingState()==1){
                    this.parentEntity.getNavigation().moveTo(livingentity.getX()+2*this.parentEntity.random.nextInt(3),this.parentEntity.getY(),livingentity.getZ()+2*this.parentEntity.random.nextInt(3),3D);
                }

                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==1)
                {
                    this.parentEntity.getNavigation().moveTo(livingentity.getX()+2*this.parentEntity.random.nextInt(3),this.parentEntity.getY(),livingentity.getZ()+2*this.parentEntity.random.nextInt(3),3D);
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
                    }

                }

                if (this.attackTimer == 30) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                    if((this.parentEntity.getHealth() >= 50.0F && this.parentEntity.getHealth()<=55.0F) ||
                            (this.parentEntity.getHealth() >= 100.0F && this.parentEntity.getHealth()<=120.0F)   ) {
                        this.parentEntity.setDefendingState(1);
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*5,10,true,true));
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*5,10,true,true));
                    }
                }
            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
            }
            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
            //System.out.println(this.parentEntity.attackAnim);
        }

    }

    private void defend() {
        if (this.isAlive()) {

            Vec3 vec3 = this.getBoundingBox().getCenter();

//           for(int i = 0; i < 40; ++i) {
//              double d0 = this.random.nextGaussian() * 0.2D;
//              double d1 = this.random.nextGaussian() * 0.2D;
//              double d2 = this.random.nextGaussian() * 0.2D;
//              this.level().addParticle(ParticleTypes.DRIPPING_LAVA, vec3.x, vec3.y, vec3.z, d0, d1, d2);
//           }
            for(int j=0;j<3;j++)
            {
                for (int i = 0; i < 10; i++)
                {
                    float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                    Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y + j, vec3.z + 1 * Math.cos(0 + deltaOmega));
                    //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                    this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0,0,0);
                }
            }

            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double)mxy;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = (float)distance * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = (float)distance * Mth.cos((float)angle);
        double px = this.getX() + extraX + (double)(f * math);
        double pz = this.getZ() + extraZ + (double)(f1 * math);
        int hitX = Mth.floor((double)px);
        int hitZ = Mth.floor((double)pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = new BlockPos(pos).above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);
        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, BlockInit.EXAMPLE_BLOCK.get().defaultBlockState(), 10);
            fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity(fallingBlockEntity);
            if (!this.level().isClientSide && block.getBlock() != Blocks.BEDROCK) {
//                if (CMConfig.IgnisBlockBreaking) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
//                else if (ForgeEventFactory.getMobGriefingEvent((Level)this.level(), (Entity)this)) {
//                    this.level().m_46953_(pos, false, (Entity)this);
//                }
            }
        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
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
                        ((LivingEntity)entity).setDeltaMovement(((LivingEntity)entity).getDeltaMovement().add(0.0, (double)airborne + 0.5, 0.0));
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
