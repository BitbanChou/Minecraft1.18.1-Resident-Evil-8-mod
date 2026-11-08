package com.joy187.re8joymod.entity;


import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;


import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

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
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
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

import com.joy187.re8joymod.entity.EntityDimi2;
public class EntityRe8Dimi extends Ravager implements GeoEntity{

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityRe8Dimi.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityRe8Dimi.class,
			EntityDataSerializers.INT);
    public static final int STATE_IDLE = 0;
    public static final int STATE_ATTACK = 1;
    public static final int STATE_ATTACK2 = 2;
    public static final int STATE_FLY = 3;
    private static final int FLY_DURATION = 60; // 3 seconds
    /** animation.dimi.attack = 1.5s → 30 ticks */
    private static final int ATTACK1_LENGTH = 30;
    /** animation.dimi.attack2 = 0.75s → 15 ticks */
    private static final int ATTACK2_LENGTH = 15;
    private static final int ATTACK_COOLDOWN_MIN = 28;
    private static final int ATTACK_COOLDOWN_MAX = 40;
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
    public int attr = 0,raise=0;
    /** Completed attack/attack2 cycles toward next fly form. */
    private int hitCount = 0;
    /** Next fly form after this many hits (rolled 5–7). */
    private int flyThreshold = 5;
    @Nullable
    private EntityFly activeFly;

    public EntityRe8Dimi(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.rollFlyThreshold();
    }

    private void rollFlyThreshold() {
        this.flyThreshold = 5 + this.random.nextInt(3); // 5–7
    }

    public boolean isInFlyForm() {
        return this.getAttckingState() == STATE_FLY;
    }

    /** Become a fly for 3s: Lady D fully disappears, fly chases, then she reappears. */
    public void enterFlyForm(LivingEntity target) {
        if (this.level().isClientSide || this.isInFlyForm() || target == null || !target.isAlive()) {
            return;
        }
        this.setAttackingState(STATE_FLY);
        this.setInvisible(true);
        this.setInvulnerable(true);
        this.setNoGravity(true);
        this.noPhysics = true;
        this.setDeltaMovement(Vec3.ZERO);
        this.getNavigation().stop();
        this.ejectPassengers();
        double spawnX = this.getX();
        double spawnY = this.getY() + 1.2D;
        double spawnZ = this.getZ();
        // Park body out of the way so only the fly is visible/interactable.
        this.setPos(spawnX, this.getY() - 64.0D, spawnZ);
        EntityFly fly = EntityFly.createDimiSwarm(this.level(), this, target, FLY_DURATION);
        fly.moveTo(spawnX, spawnY, spawnZ);
        this.level().addFreshEntity(fly);
        this.activeFly = fly;
        this.playSound(SoundEvents.BEE_LOOP, 1.4F, 0.7F);
        this.hitCount = 0;
        this.rollFlyThreshold();
    }

    /** Called by EntityFly when the 3s swarm ends — Lady D reappears at the fly. */
    public void exitFlyForm(double x, double y, double z) {
        if (this.level().isClientSide) {
            return;
        }
        this.activeFly = null;
        this.noPhysics = false;
        this.setNoGravity(false);
        this.setInvisible(false);
        this.setInvulnerable(false);
        this.setAttackingState(STATE_IDLE);
        this.moveTo(x, Math.max(y, this.level().getMinBuildHeight() + 1), z);
        this.setDeltaMovement(Vec3.ZERO);
        this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.2F);
        if (this.level() instanceof net.minecraft.server.level.ServerLevel server) {
            server.sendParticles(ParticleTypes.SMOKE, x, y + 1.0, z, 20, 0.4, 0.6, 0.4, 0.02);
            server.sendParticles(ParticleTypes.CLOUD, x, y + 1.0, z, 12, 0.3, 0.4, 0.3, 0.01);
        }
    }

    @Override
    public boolean isPickable() {
        return !this.isInFlyForm() && super.isPickable();
    }

    @Override
    public boolean isPushable() {
        return !this.isInFlyForm() && super.isPushable();
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isInFlyForm() && super.canBeCollidedWith();
    }

   
    protected boolean isSunSensitive() {
        return true;
    }
    
    public void aiStep() {
        if (this.isInFlyForm()) {
            // Stay parked while the fly is out; don't run normal ravager AI particles.
            this.setDeltaMovement(Vec3.ZERO);
            return;
        }
        super.aiStep();
        Random ran = new Random();
        int co = ran.nextInt(4);
        if (co == 1) {
            for (int i = 0; i < 10; i++) {
                float deltaOmega = 1.0f * i;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),
                        this.position().y + 0.1f * this.random.nextFloat(),
                        this.position().z + 1 * Math.cos(0 + deltaOmega));
                this.level().addParticle(ParticleTypes.EFFECT, pos.x, pos.y, pos.z,
                        this.random.nextGaussian() * 0.07, 0.1, this.random.nextGaussian() * 0.07);
            }
        }

        if (this.attr >= 8 && this.attr <= 12 && this.getAttckingState() == STATE_ATTACK2) {
            this.level().addParticle(ParticleTypes.SWEEP_ATTACK, this.position().x, this.position().y + 1D,
                    this.position().z, this.random.nextGaussian() * 0.07, 0.1, this.random.nextGaussian() * 0.07);
        }
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 120.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
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
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_DEATH1.get();
        }
        else if(co==1) return SoundInit.ENTITY_DIMI_DEATH2.get();
        return SoundEvents.BEE_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_AMBIENT1.get();
        }
        return  SoundInit.ENTITY_DIMI_AMBIENT2.get();
        //return SoundEvents.ZOMBIE_AMBIENT;
    }
//
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_HURT1.get();
        }
        return SoundInit.ENTITY_DIMI_HURT2.get();
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
	
	        if(this.isSunSensitive()){
	            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*10,1,true,true));
	        }
	
	        Random ran = new Random();
	        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.0F*ran.nextFloat());
	        }
	
	        if(this.getHealth() >= 60.0F && this.getHealth()<=65.0F)
	        {
	            for(int i=0;i<4;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }
	
        if (!this.isInFlyForm() && this.getHealth() >= 0.1F && this.getHealth() <= 10.0F) {
            this.convertTo(EntityInit.DIMI2.get(), true);
        }

        // Keep boss bar / target while hidden as fly; bail if fly was removed early.
        if (this.isInFlyForm()) {
            if (this.activeFly == null || !this.activeFly.isAlive()) {
                LivingEntity t = this.getTarget();
                if (t != null && t.isAlive()) {
                    this.exitFlyForm(t.getX(), t.getY(), t.getZ());
                } else {
                    this.exitFlyForm(this.getX(), this.getY() + 64.0D, this.getZ());
                }
            } else if (this.getTarget() != null) {
                this.activeFly.setTarget(this.getTarget());
            }
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
        if (this.isInFlyForm() || this.isInvisible()) {
            return PlayState.STOP;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.walk"));
            return PlayState.CONTINUE;
        }
        Random ran = new Random();
        int co = ran.nextInt(30);
        if (co == 1) {
        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle"));
        return PlayState.CONTINUE;
    }
    
	private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying() || this.isInFlyForm()) {
			return PlayState.STOP;
		}
		if (this.entityData.get(STATE) == STATE_ATTACK) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.attack"));
			return PlayState.CONTINUE;
		}
		if (this.entityData.get(STATE) == STATE_ATTACK2) {
			event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.attack2"));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}
	
    @Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller", 2, this::predicate));
        data.add(new AnimationController<>(this, "controller1", 1, this::predicate1));
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

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
	}
	
    static class AttackGoal extends Goal {
        private final EntityRe8Dimi parentEntity;
        /** Ticks since current skill started (1 = first active tick). 0 = not in skill. */
        private int skillTimer = 0;
        private int cooldown = 16;
        private int chosen = STATE_IDLE;

        public AttackGoal(EntityRe8Dimi mob) {
             this.parentEntity = mob;
        }

        public boolean canUse() {
             return this.parentEntity.getTarget() != null && !this.parentEntity.isInFlyForm();
        }

        public boolean canContinueToUse() {
             return this.canUse();
        }

        public void start() {
             super.start();
             this.parentEntity.setAggressive(true);
             this.cooldown = 12;
             this.skillTimer = 0;
             this.chosen = STATE_IDLE;
        }

        @Override
        public void stop() {
             super.stop();
             this.parentEntity.setAggressive(false);
             if (!this.parentEntity.isInFlyForm()) {
                 this.parentEntity.setAttackingState(STATE_IDLE);
             }
             this.skillTimer = 0;
             this.chosen = STATE_IDLE;
             this.parentEntity.attr = 0;
        }

        public void tick() {
             LivingEntity livingentity = this.parentEntity.getTarget();
             if (livingentity == null || !livingentity.isAlive()) {
                 return;
             }
             this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

             if (this.cooldown > 0) {
                 --this.cooldown;
                 if (this.parentEntity.distanceTo(livingentity) > 3.5D) {
                     this.parentEntity.getNavigation().moveTo(livingentity, 1.0D);
                 }
                 return;
             }

             if (this.chosen == STATE_IDLE) {
                 this.beginSkill(livingentity);
                 return;
             }

             ++this.skillTimer;
             this.parentEntity.attr = this.skillTimer;

             if (this.chosen == STATE_ATTACK) {
                 this.tickAttack1(livingentity);
             } else if (this.chosen == STATE_ATTACK2) {
                 this.tickAttack2(livingentity);
             }
        }

        private void beginSkill(LivingEntity livingentity) {
            float hp = this.parentEntity.getHealth();
            boolean grabWindow = (hp > 40 && hp < 55) || (hp > 105 && hp < 120)
                    || (hp > 75 && hp < 90) || (hp > 60 && hp < 70) || (hp > 20 && hp < 35);
            if (grabWindow && this.parentEntity.distanceTo(livingentity) < 4.5D) {
                this.chosen = STATE_ATTACK;
            } else {
                this.chosen = STATE_ATTACK2;
            }
            this.skillTimer = 0;
            this.parentEntity.attr = 0;
            this.parentEntity.setAttackingState(this.chosen);
            if (this.chosen == STATE_ATTACK2) {
                this.parentEntity.getNavigation().stop();
            } else {
                this.parentEntity.getNavigation().moveTo(livingentity, 0.85D);
            }
        }

        private void tickAttack1(LivingEntity livingentity) {
            // Grab early in the 1.5s anim; bite near the end (tick 25 of 30).
            if (this.skillTimer == 6) {
                if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
                        && livingentity.getBbWidth() < 1.81F) {
                    livingentity.stopRiding();
                    livingentity.startRiding(this.parentEntity, true);
                }
            }
            if (this.skillTimer >= ATTACK1_LENGTH) {
                this.finishSkill(livingentity);
            }
        }

        private void tickAttack2(LivingEntity livingentity) {
            // Impact ~0.5s into 0.75s anim (tick 10).
            if (this.skillTimer == 10) {
                for (int l = 1; l < 14; l++) {
                    this.parentEntity.blockSmashAttack(l, 3F, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                    this.parentEntity.blockSmashAttack(l, 3F, -1.5F, 150, 1.5F, 0.2F, 1.0F);
                    this.parentEntity.blockSmashAttack(l, 3F, 2.8F, 150, 1.5F, 0.15F, 1.0F);
                    this.parentEntity.blockSmashAttack(l, 3F, -2.8F, 150, 1.5F, 0.15F, 1.0F);
                }
                this.parentEntity.roar();
            }
            if (this.skillTimer >= ATTACK2_LENGTH + 2) {
                this.finishSkill(livingentity);
            }
        }

        private void finishSkill(LivingEntity livingentity) {
            this.parentEntity.setAttackingState(STATE_IDLE);
            this.parentEntity.raise++;
            this.parentEntity.hitCount++;
            this.parentEntity.attr = 0;
            this.chosen = STATE_IDLE;
            this.skillTimer = 0;
            this.cooldown = ATTACK_COOLDOWN_MIN
                    + this.parentEntity.getRandom().nextInt(ATTACK_COOLDOWN_MAX - ATTACK_COOLDOWN_MIN + 1);
            if (this.parentEntity.hitCount >= this.parentEntity.flyThreshold) {
                this.parentEntity.enterFlyForm(livingentity);
            }
        }
   }

    @Override
    public void positionRider(Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            moveFunction.accept(passenger, getX(), getY() - 0.1f, getZ());
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = this.attr < 5 ? 0 : Math.min((this.attr * 3 - 30) * 0.2, 5.2F);
            float pullIn = this.attr < 15 ? 0 : Math.min((this.attr - 15) * 0.15F, 0.75F);
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            // Bite near end of attack anim (skillTimer ~25 of 30).
            if (this.attr == 25) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity) passenger).getMaxHealth() * 0.25F);
                passenger.stopRiding();
            }
        }
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
                if (flag) {
                    LivingEntity hit = (LivingEntity) entity;
                    hit.setDeltaMovement(hit.getDeltaMovement().add(0.0, airborne * 0.35, 0.0));
                    hit.knockback(1.35F + airborne * 0.25F, this.getX() - hit.getX(), this.getZ() - hit.getZ());
                }
                }

            }
        }

    }

    private void roar() {
        if (this.isAlive()) {

            Vec3 vec3 = this.getBoundingBox().getCenter();
            for (int i = 0; i < 5; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(vec3.x + 1 * Math.sin(0 + deltaOmega),  vec3.y , vec3.z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);

                this.level().addParticle(ParticleTypes.EXPLOSION_EMITTER, pos.x, pos.y, pos.z, 0,0,0);
            }
            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }

    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(3+livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }

}
