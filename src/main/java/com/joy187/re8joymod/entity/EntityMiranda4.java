package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.Difficulty;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class EntityMiranda4 extends Ravager implements GeoEntity {

	public static final int SKILL_SLAM = 1;
	public static final int SKILL_THRUST = 2;
	public static final int SKILL_COMBO = 3;

	private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	private int defendflag=0;
    private int explosionPower = 2,randtick=0;
    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMiranda4.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMiranda4.class,
			EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityMiranda4.class, EntityDataSerializers.BYTE);

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
     
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "skills", 0, state -> PlayState.STOP)
                .triggerableAnim("slam", RawAnimation.begin().thenPlay("animation.miranda4.slam"))
                .triggerableAnim("thrust", RawAnimation.begin().thenPlay("animation.miranda4.thrust"))
                .triggerableAnim("combo", RawAnimation.begin().thenPlay("animation.miranda4.combo")));
        controllers.add(new AnimationController<>(this, "move", 8, this::movePredicate));
    }

    private PlayState movePredicate(AnimationState<EntityMiranda4> state) {
        if (this.getAttckingState() != 0) {
            return PlayState.STOP;
        }
        if (state.isMoving()) {
            state.setAndContinue(RawAnimation.begin().thenLoop("animation.miranda4.walk"));
        } else {
            state.setAndContinue(RawAnimation.begin().thenLoop("animation.miranda4.idle"));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    public EntityMiranda4(EntityType<? extends Ravager> type, Level worldIn) {
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
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 320.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27000001192092896D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 30.0D).
                add(Attributes.ARMOR_TOUGHNESS, 50.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).
                add(Attributes.ATTACK_DAMAGE, 10.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(0, new SkillGoal(this));
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

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }


    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_33820_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_33820_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            if(entityIn instanceof LivingEntity)
            {
                int i = 0;
                Random ran = new Random();
                int co = ran.nextInt(7);
                this.randtick=co;
                if(this.level().getDifficulty()== Difficulty.NORMAL)
                {
                    i=7;
                }
                else if(this.level().getDifficulty()== Difficulty.HARD)
                {
                    i=12;
                }
                if(i>0){
                    if(co<4){
                        if (!entityIn.hasPassenger(this) && !(entityIn instanceof EnderDragon)
                                && entityIn.getBbWidth() < 2.81F){
                            (entityIn).stopRiding();
                            (entityIn).startRiding(this, true);
                        }
                    }

                    if(co==0 || co==1) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, i*10,1,true,true));
                    else if(co==2 || co==3 || co==4) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, i*4,1,true,true));
                    else if(co==5) {
                        this.level().explode(null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
                        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, i*10,0,true,true));
                    }
                    else {
                        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40,2,true,true));
                        ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.BURN.get(), 60,2,true,true));
                        this.level().addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
                        this.spawnSoulSpeedParticle();
                    }
                }
                if(i+co>=12){
                    this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60,4,true,true));
                    if(i+co==13) ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 40,2,true,true));
                }
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
	
	        Random ran = new Random();
	        if(this.getHealth() >= 10.0F && this.getHealth()<=18.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(2.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }
	
	        if(this.getHealth() >= 270.0F && this.getHealth()<=285.0F)
	        {
	        	if(this.defendflag==0)
	        	{
		        	defend();
		            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*5,10,true,true));
		            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*5,10,true,true));	
		            this.defendflag=1;
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

	
	public int getAttckingState() {
		return this.entityData.get(STATE);
	}
	
	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if (!this.level().isClientSide && time != prev) {
			this.startSkillAnim(time);
		}
	}

	private void startSkillAnim(int state) {
		if (state == SKILL_SLAM) {
			this.triggerAnim("skills", "slam");
		} else if (state == SKILL_THRUST) {
			this.triggerAnim("skills", "thrust");
		} else if (state == SKILL_COMBO) {
			this.triggerAnim("skills", "combo");
		}
	}

	@Override
	public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
		if (this.getAttckingState() == SKILL_SLAM) {
			return false;
		}
		return super.causeFallDamage(fallDistance, multiplier, source);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
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

    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        //super.positionRider(passenger);
        if (this.hasPassenger(passenger) && passenger instanceof LivingEntity) {
            passenger.setDeltaMovement(0, passenger.getDeltaMovement().y, 0);
            //this.setAnimation(ANIMATION_EATPLAYER);
            double raiseUp = 3F;
            float pullIn = 0.5F;
            yBodyRot = getYRot();
            this.setYRot(0);
            float radius = -2.75F +pullIn;
            float angle = (0.01745329251F * this.yBodyRot) + 3.15F;
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = raiseUp;
            passenger.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
            if (this.randtick <= 3) {
                passenger.hurt(damageSources().mobAttack(this), ((LivingEntity)passenger).getMaxHealth()*0.4F);
                passenger.stopRiding();
            }
        }
    }

    static class SkillGoal extends Goal {
        private static final int SLAM_LEAP = 8;
        private static final int SLAM_DIVE = 24;
        private static final int SLAM_END = 44;
        private static final int THRUST_FIRST = 8;
        private static final int THRUST_SECOND = 14;
        private static final int THRUST_END = 20;
        private static final int[] COMBO_HITS = {6, 12, 18, 24, 30, 42};
        private static final int COMBO_END = 48;

        private final EntityMiranda4 boss;
        private int skill;
        private int timer;
        private int cooldown;
        private int comboIndex;
        private boolean airborne;
        private boolean slammed;

        SkillGoal(EntityMiranda4 boss) {
            this.boss = boss;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.boss.getTarget();
            return target != null && target.isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse();
        }

        @Override
        public void stop() {
            this.skill = 0;
            this.timer = 0;
            this.boss.setAttackingState(0);
            this.boss.setAggressive(false);
        }

        @Override
        public void tick() {
            LivingEntity target = this.boss.getTarget();
            if (target == null) {
                return;
            }
            if (this.skill == 0) {
                if (this.cooldown > 0) {
                    this.cooldown--;
                    this.boss.getNavigation().moveTo(target, 1.15D);
                    this.boss.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    return;
                }
                if (!this.boss.hasLineOfSight(target)) {
                    this.boss.getNavigation().moveTo(target, 1.25D);
                    return;
                }
                this.begin(this.chooseSkill(target));
                return;
            }

            this.boss.getNavigation().stop();
            this.timer++;
            switch (this.skill) {
                case SKILL_SLAM -> this.tickSlam(target);
                case SKILL_THRUST -> this.tickThrust(target);
                case SKILL_COMBO -> this.tickCombo(target);
                default -> this.finish();
            }
        }

        private int chooseSkill(LivingEntity target) {
            double distance = this.boss.distanceTo(target);
            float roll = this.boss.getRandom().nextFloat();
            if (distance <= 4.0D) {
                return roll < 0.65F ? SKILL_THRUST : SKILL_COMBO;
            }
            if (distance <= 12.0D) {
                return roll < 0.55F ? SKILL_COMBO : SKILL_SLAM;
            }
            return SKILL_SLAM;
        }

        private void begin(int next) {
            this.skill = next;
            this.timer = 0;
            this.comboIndex = 0;
            this.airborne = false;
            this.slammed = false;
            this.boss.setAggressive(true);
            this.boss.getNavigation().stop();
            this.boss.setDeltaMovement(Vec3.ZERO);
            this.boss.setAttackingState(next);
            if (next == SKILL_SLAM) {
                this.boss.level().playSound(null, this.boss.blockPosition(), SoundEvents.RAVAGER_ROAR, SoundSource.HOSTILE, 1.4F, 0.7F);
            }
        }

        private void finish() {
            this.skill = 0;
            this.timer = 0;
            this.cooldown = 30;
            this.boss.setAttackingState(0);
            this.boss.setAggressive(false);
            Vec3 motion = this.boss.getDeltaMovement();
            this.boss.setDeltaMovement(motion.x * 0.2D, motion.y, motion.z * 0.2D);
        }

        private void tickSlam(LivingEntity target) {
            if (this.timer < SLAM_LEAP) {
                this.boss.getLookControl().setLookAt(target, 40.0F, 20.0F);
                this.boss.setDeltaMovement(Vec3.ZERO);
            } else if (this.timer == SLAM_LEAP) {
                Vec3 to = target.position().subtract(this.boss.position());
                double horizontal = Math.max(0.1D, Math.sqrt(to.x * to.x + to.z * to.z));
                double speed = Mth.clamp(horizontal / 14.0D, 0.4D, 1.2D);
                this.boss.setDeltaMovement(to.x / horizontal * speed, 1.25D, to.z / horizontal * speed);
                this.boss.hasImpulse = true;
            } else if (this.timer < SLAM_DIVE) {
                if (!this.boss.onGround()) {
                    this.airborne = true;
                }
                Vec3 motion = this.boss.getDeltaMovement();
                if (motion.y < 0.15D) {
                    this.boss.setDeltaMovement(motion.x * 0.92D, 0.08D, motion.z * 0.92D);
                }
            } else if (this.timer == SLAM_DIVE) {
                Vec3 motion = this.boss.getDeltaMovement();
                this.boss.setDeltaMovement(motion.x * 0.35D, -1.8D, motion.z * 0.35D);
                this.boss.hasImpulse = true;
            } else if (!this.boss.onGround()) {
                this.airborne = true;
            }

            if (!this.slammed && ((this.airborne && this.boss.onGround() && this.timer > SLAM_DIVE) || this.timer >= 40)) {
                this.impact();
            }
            if (this.timer >= SLAM_END) {
                this.finish();
            }
        }

        private void impact() {
            this.slammed = true;
            this.boss.resetFallDistance();
            if (!(this.boss.level() instanceof ServerLevel server)) {
                return;
            }
            Vec3 center = this.boss.position();
            server.sendParticles(ParticleTypes.EXPLOSION, center.x, center.y + 0.2D, center.z, 6, 1.4D, 0.2D, 1.4D, 0.0D);
            server.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, center.x, center.y + 0.3D, center.z, 18, 1.8D, 0.15D, 1.8D, 0.02D);
            server.playSound(null, this.boss.blockPosition(), SoundEvents.GENERIC_EXPLODE, SoundSource.HOSTILE, 1.2F, 0.8F);
            float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.9D);
            AABB area = this.boss.getBoundingBox().inflate(4.5D, 1.2D, 4.5D);
            for (LivingEntity living : server.getEntitiesOfClass(LivingEntity.class, area, this.boss::canHit)) {
                living.hurt(this.boss.damageSources().mobAttack(this.boss), damage);
                living.knockback(1.15D, this.boss.getX() - living.getX(), this.boss.getZ() - living.getZ());
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
            }
        }

        private void tickThrust(LivingEntity target) {
            this.face(target, 360.0F);
            this.boss.setDeltaMovement(Vec3.ZERO);
            if (this.timer == THRUST_FIRST) {
                this.lunge(0.55D);
                this.hitFront(2.6D, 1.35D, 0.9F, 0.35D);
                this.boss.level().playSound(null, this.boss.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.HOSTILE, 1.0F, 0.75F);
            } else if (this.timer == THRUST_SECOND) {
                this.lunge(0.7D);
                this.hitFront(3.1D, 1.45D, 1.15F, 0.7D);
                this.boss.level().playSound(null, this.boss.blockPosition(), SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.HOSTILE, 1.0F, 0.6F);
            }
            if (this.timer >= THRUST_END) {
                this.finish();
            }
        }

        private void tickCombo(LivingEntity target) {
            if (this.comboIndex < COMBO_HITS.length && this.timer == COMBO_HITS[this.comboIndex]) {
                boolean last = this.comboIndex == COMBO_HITS.length - 1;
                this.face(target, last ? 360.0F : 12.0F);
                this.lunge(last ? 1.35D : 0.82D);
                this.hitFront(last ? 3.4D : 2.4D, last ? 1.6D : 1.15D, last ? 1.35F : 0.5F, last ? 1.05D : 0.25D);
                this.boss.level().playSound(null, this.boss.blockPosition(),
                        last ? SoundEvents.PLAYER_ATTACK_CRIT : SoundEvents.PLAYER_ATTACK_SWEEP,
                        SoundSource.HOSTILE, last ? 1.2F : 0.85F, last ? 0.7F : 1.1F);
                this.comboIndex++;
            }
            if (this.timer >= COMBO_END) {
                this.finish();
            }
        }

        private void face(LivingEntity target, float maxDegrees) {
            double dx = target.getX() - this.boss.getX();
            double dz = target.getZ() - this.boss.getZ();
            float wanted = (float) (Mth.atan2(dz, dx) * (180.0F / Math.PI)) - 90.0F;
            float turn = Mth.clamp(Mth.wrapDegrees(wanted - this.boss.getYRot()), -maxDegrees, maxDegrees);
            float yaw = this.boss.getYRot() + turn;
            this.boss.setYRot(yaw);
            this.boss.setYHeadRot(yaw);
            this.boss.yBodyRot = yaw;
        }

        private void lunge(double speed) {
            Vec3 look = this.boss.getLookAngle();
            this.boss.setDeltaMovement(look.x * speed, 0.06D, look.z * speed);
            this.boss.hasImpulse = true;
        }

        private void hitFront(double reach, double radius, float multiplier, double knockback) {
            if (!(this.boss.level() instanceof ServerLevel server)) {
                return;
            }
            Vec3 look = this.boss.getLookAngle().normalize();
            Vec3 origin = this.boss.position().add(0.0D, this.boss.getBbHeight() * 0.45D, 0.0D);
            AABB box = new AABB(origin, origin).inflate(radius, 0.8D, radius).expandTowards(look.scale(reach));
            float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * multiplier);
            for (LivingEntity living : server.getEntitiesOfClass(LivingEntity.class, box, this.boss::canHit)) {
                Vec3 toward = living.getEyePosition().subtract(origin);
                if (toward.lengthSqr() > 0.04D && toward.normalize().dot(look) < 0.2D) {
                    continue;
                }
                living.hurt(this.boss.damageSources().mobAttack(this.boss), damage);
                living.knockback(knockback, -look.x, -look.z);
            }
            Vec3 tip = origin.add(look.scale(reach * 0.65D));
            server.sendParticles(ParticleTypes.SWEEP_ATTACK, tip.x, tip.y, tip.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    private boolean canHit(LivingEntity living) {
        if (!living.isAlive() || living == this || living.isAlliedTo(this)) {
            return false;
        }
        if (living instanceof Player player && (player.isCreative() || player.isSpectator())) {
            return false;
        }
        return LIVING_ENTITY_SELECTOR.test(living);
    }

}
