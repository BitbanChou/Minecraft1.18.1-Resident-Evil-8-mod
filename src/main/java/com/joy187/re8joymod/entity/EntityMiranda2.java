package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;
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
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityMiranda2 extends Ravager implements GeoEntity{

    public static final int SKILL_SPIKE = 1;
    public static final int SKILL_SWEEP = 2;
    public static final int SKILL_SHOCK = 3;
    public static final int SKILL_MOLD = 4;
    public static final int SKILL_TREE = 5;
    public static final int SKILL_STAGGER = 6;
    /** One weapon hit removes at most this fraction of max health. */
    public static final float WEAPON_HIT_CAP = 0.15F;
    private static final int STAGGER_DURATION = 40;

    private int staggerTime;

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public int explosionPower = 1;

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityMiranda2.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityMiranda2.class,
			EntityDataSerializers.INT);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
     };
     
    public EntityMiranda2(EntityType<? extends Ravager> type, Level worldIn) {
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
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co==1)
        {
            //this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), this.position().x, this.position().y, this.position().z);
            for (int i = 0; i < 10; i++)
            {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega),  this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleTypes.ENTITY_EFFECT, pos.x, pos.y, pos.z, 0,0,0);
            }
        }
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 280.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.KNOCKBACK_RESISTANCE,0.99D).
                add(Attributes.ATTACK_DAMAGE, 8.0D);
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


    public boolean doHurtTarget(Entity entityIn) {
        if(!super.doHurtTarget(entityIn))
        {
            return false;
        }
        else{
            Random ran = new Random();
            int co = ran.nextInt(7);
            if(co==1 || co==2 || co==3) {
                if(entityIn instanceof LivingEntity)
                {
                    ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100,1,true,true));
                }
                if(entityIn instanceof Player || entityIn instanceof IronGolem || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris || entityIn instanceof EntityMuHeisen){
                    this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100,1,true,true));
                    this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100,1,true,true));
                }
            }
            else if(co==4) {
                if (entityIn instanceof Player || entityIn instanceof IronGolem || entityIn instanceof EntityEthan ||entityIn instanceof EntityChris)
                {
                    this.addEffect(new MobEffectInstance(MobEffects.JUMP, 20,2,true,true));
                    this.level().explode((Entity)null, entityIn.position().x, entityIn.position().y, entityIn.position().z, (float)this.explosionPower, true, Level.ExplosionInteraction.BLOCK);
                    this.level().addParticle(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY()+ran.nextFloat(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 100,1,false,true));
            }
            else if(co==5){
                ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20*2,1,false,true));
            }
            else {
                if(co==0) {
                    ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,3,false,true));
                    this.level().addParticle(ParticleTypes.FLASH, this.getX()+ran.nextFloat(), this.getY(), this.getZ()+ran.nextFloat(), this.position().x, this.position().y, this.position().z);
                }
                else ((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*3,1,false,true));
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
	                this.heal(3.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 50.0F && this.getHealth()<=58.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(2.0F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 100.0F && this.getHealth()<=110.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1.5F*ran.nextFloat());
	        }

	        if(this.getHealth() >= 135.0F && this.getHealth()<=140.0F)
	        {
	            for(int i=0;i<5;i++)
	                this.heal(1F*ran.nextFloat());
	        }


	
	        if(this.getHealth() >= 1.0F && this.getHealth()<=7.0F)
	        {
	            this.convertTo(EntityInit.MIRANDA3.get(),true);
	        }
	
	        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	        this.tickStagger();
        }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean weaponHit = this.isWeaponHit(source);
        if (weaponHit) {
            float cap = this.getMaxHealth() * WEAPON_HIT_CAP;
            if (amount > cap) {
                amount = cap;
            }
        }
        return super.hurt(source, amount);
    }

    private boolean isWeaponHit(DamageSource source) {
        return source.getEntity() instanceof Player && !source.is(DamageTypes.THORNS);
    }

    public boolean isStaggered() {
        return this.staggerTime > 0;
    }

    private void beginStagger() {
        this.staggerTime = STAGGER_DURATION;
        this.setDeltaMovement(Vec3.ZERO);
        this.getNavigation().stop();
        this.setAttackingState(SKILL_STAGGER);
        this.level().playSound(null, this.blockPosition(), SoundEvents.RAVAGER_STUNNED, SoundSource.HOSTILE, 1.1F, 0.85F);
    }

    private void tickStagger() {
        if (this.staggerTime <= 0) {
            return;
        }
        this.getNavigation().stop();
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(0.0D, Math.min(0.0D, motion.y), 0.0D);
        if (--this.staggerTime <= 0 && this.getAttckingState() == SKILL_STAGGER) {
            this.setAttackingState(0);
        }
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
        if (this.entityData.get(STATE) != 0) {
            return PlayState.STOP;
        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.walk"));
            return PlayState.CONTINUE;
        }
        Random ran = new Random();
        int co = ran.nextInt(30);
        if(co==1) {
        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.idle2"));
            return PlayState.CONTINUE;
        }
        
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.miranda2.idle"));
        return PlayState.CONTINUE;
    }
    
		
    	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.miranda2.attack"))
						.triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.miranda2.attack2"))
						.triggerableAnim("spike", RawAnimation.begin().thenPlay("animation.miranda2.spike"))
						.triggerableAnim("sweep", RawAnimation.begin().thenPlay("animation.miranda2.sweep"))
						.triggerableAnim("shock", RawAnimation.begin().thenPlay("animation.miranda2.shock"))
						.triggerableAnim("mold", RawAnimation.begin().thenPlay("animation.miranda2.mold"))
						.triggerableAnim("tree", RawAnimation.begin().thenPlay("animation.miranda2.tree"))
						.triggerableAnim("stagger", RawAnimation.begin().thenPlay("animation.miranda2.stagger"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}


	@Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
	
	public int getAttckingState() {
		return this.entityData.get(STATE);
	}
	
	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		String name = switch (state) {
			case SKILL_SPIKE -> "spike";
			case SKILL_SWEEP -> "sweep";
			case SKILL_SHOCK -> "shock";
			case SKILL_MOLD -> "mold";
			case SKILL_TREE -> "tree";
			case SKILL_STAGGER -> "stagger";
			default -> null;
		};
		if (name != null) {
			this.triggerAnim("controller1", name);
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if (time >= SKILL_SPIKE && time <= SKILL_STAGGER && prev != time) {
			this.startAttackAnim(time);
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

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(STATE, 0);
	}
	
    static class SkillGoal extends Goal {
        private static final int SPIKE_CAST = 8;
        private static final int SPIKE_END = 24;
        private static final int SWEEP_HIT = 6;
        private static final int SWEEP_END = 16;
        private static final int SHOCK_CAST = 8;
        private static final int SHOCK_END = 20;
        private static final int MOLD_CAST = 8;
        private static final int MOLD_END = 22;
        private static final int TREE_BURY = 12;
        private static final int TREE_RISE = 52;
        private static final int TREE_END = 64;

        private final EntityMiranda2 boss;
        private int skill;
        private int timer;
        private int cooldown;
        private boolean lineSpikes;
        private boolean treeSpawned;
        private Vec3 arena = Vec3.ZERO;

        SkillGoal(EntityMiranda2 boss) {
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
            if (this.skill == SKILL_TREE && (this.boss.isInvulnerable() || this.boss.noPhysics)) {
                this.boss.teleportTo(this.arena.x + 2.2D, this.arena.y, this.arena.z);
            }
            this.skill = 0;
            this.timer = 0;
            this.boss.noPhysics = false;
            this.boss.setInvulnerable(false);
            this.boss.resetFallDistance();
            if (!this.boss.isStaggered()) {
                this.boss.setAttackingState(0);
            }
            this.boss.setAggressive(false);
        }

        @Override
        public void tick() {
            LivingEntity target = this.boss.getTarget();
            if (this.boss.isStaggered()) {
                this.interruptForStagger();
                return;
            }
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
                this.begin(this.chooseSkill(target), target);
                return;
            }

            this.boss.getNavigation().stop();
            this.timer++;
            switch (this.skill) {
                case SKILL_SPIKE -> this.tickSpike(target);
                case SKILL_SWEEP -> this.tickSweep(target);
                case SKILL_SHOCK -> this.tickShock(target);
                case SKILL_MOLD -> this.tickMold(target);
                case SKILL_TREE -> this.tickTree(target);
                default -> this.finish();
            }
        }

        private int chooseSkill(LivingEntity target) {
            double distance = this.boss.distanceTo(target);
            float roll = this.boss.getRandom().nextFloat();
            float health = this.boss.getHealth() / this.boss.getMaxHealth();
            if (distance <= 3.6D) {
                return roll < 0.72F ? SKILL_SWEEP : SKILL_MOLD;
            }
            if (health < 0.45F && distance > 6.0D && roll < 0.38F) {
                return SKILL_TREE;
            }
            if (distance <= 9.0D) {
                if (roll < 0.34F) {
                    return SKILL_SPIKE;
                }
                if (roll < 0.67F) {
                    return SKILL_SHOCK;
                }
                return SKILL_MOLD;
            }
            if (roll < 0.42F) {
                return SKILL_SPIKE;
            }
            if (roll < 0.72F) {
                return SKILL_SHOCK;
            }
            return SKILL_TREE;
        }

        private void begin(int next, LivingEntity target) {
            this.skill = next;
            this.timer = 0;
            this.treeSpawned = false;
            this.lineSpikes = this.boss.distanceTo(target) <= 9.0D;
            this.boss.setAggressive(true);
            this.boss.getNavigation().stop();
            this.boss.setDeltaMovement(Vec3.ZERO);
            this.boss.setAttackingState(next);
            if (next == SKILL_TREE) {
                this.arena = EntityMyceliumSpike.ground(this.boss.level(),
                        (this.boss.getX() + target.getX()) * 0.5D,
                        Math.max(this.boss.getY(), target.getY()),
                        (this.boss.getZ() + target.getZ()) * 0.5D);
                this.boss.level().playSound(null, this.boss.blockPosition(), SoundEvents.EVOKER_PREPARE_ATTACK, SoundSource.HOSTILE, 1.2F, 0.6F);
            }
        }

        private void interruptForStagger() {
            if (this.skill == SKILL_TREE && (this.boss.isInvulnerable() || this.boss.noPhysics)) {
                this.boss.teleportTo(this.arena.x + 2.2D, this.arena.y, this.arena.z);
            }
            this.skill = 0;
            this.timer = 0;
            this.cooldown = Math.max(this.cooldown, 20);
            this.boss.noPhysics = false;
            this.boss.setInvulnerable(false);
            this.boss.resetFallDistance();
            this.boss.getNavigation().stop();
            this.boss.setDeltaMovement(Vec3.ZERO);
        }

        private void finish() {
            this.skill = 0;
            this.timer = 0;
            this.cooldown = 36;
            this.boss.noPhysics = false;
            this.boss.setInvulnerable(false);
            this.boss.resetFallDistance();
            this.boss.setAttackingState(0);
            this.boss.setAggressive(false);
            Vec3 motion = this.boss.getDeltaMovement();
            this.boss.setDeltaMovement(motion.x * 0.2D, motion.y, motion.z * 0.2D);
        }

        private void tickSpike(LivingEntity target) {
            this.face(target, 360.0F);
            this.boss.setDeltaMovement(Vec3.ZERO);
            if (this.timer == SPIKE_CAST) {
                this.castSpikes(target);
            }
            if (this.timer >= SPIKE_END) {
                this.finish();
            }
        }

        private void castSpikes(LivingEntity target) {
            float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.05D);
            Vec3 look = this.horizontalLook(target);
            this.boss.level().playSound(null, this.boss.blockPosition(), SoundEvents.EVOKER_FANGS_ATTACK, SoundSource.HOSTILE, 1.0F, 0.7F);
            if (this.lineSpikes) {
                for (int i = 1; i <= 8; i++) {
                    Vec3 at = this.boss.position().add(look.scale(1.45D * i));
                    Vec3 ground = EntityMyceliumSpike.ground(this.boss.level(), at.x, this.boss.getY(), at.z);
                    EntityMyceliumSpike.rise(this.boss.level(), this.boss, ground, damage, i * 2);
                }
                return;
            }
            double base = Math.atan2(look.z, look.x);
            int index = 0;
            for (int ring = 1; ring <= 2; ring++) {
                for (int i = -3; i <= 3; i++) {
                    double ang = base + Math.toRadians(i * 12.0D);
                    double dist = 2.6D * ring;
                    Vec3 at = new Vec3(this.boss.getX() + Math.cos(ang) * dist, this.boss.getY(), this.boss.getZ() + Math.sin(ang) * dist);
                    Vec3 ground = EntityMyceliumSpike.ground(this.boss.level(), at.x, at.y, at.z);
                    EntityMyceliumSpike.rise(this.boss.level(), this.boss, ground, damage, index);
                    index += 2;
                }
            }
        }

        private void tickSweep(LivingEntity target) {
            this.face(target, 20.0F);
            this.boss.setDeltaMovement(Vec3.ZERO);
            if (this.timer == SWEEP_HIT) {
                this.wingHit();
            }
            if (this.timer >= SWEEP_END) {
                this.finish();
            }
        }

        private void wingHit() {
            if (!(this.boss.level() instanceof ServerLevel server)) {
                return;
            }
            Vec3 look = this.horizontalLook(this.boss.getTarget());
            float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.4D);
            AABB box = this.boss.getBoundingBox().inflate(2.5D, 0.8D, 2.5D);
            for (LivingEntity living : server.getEntitiesOfClass(LivingEntity.class, box, this.boss::canHit)) {
                Vec3 flat = new Vec3(living.getX() - this.boss.getX(), 0.0D, living.getZ() - this.boss.getZ());
                if (flat.lengthSqr() > 0.04D && flat.normalize().dot(look) < 0.15D) {
                    continue;
                }
                living.hurt(this.boss.damageSources().mobAttack(this.boss), damage);
                living.knockback(0.95D, -look.x, -look.z);
            }
            Vec3 tip = this.boss.position().add(0.0D, this.boss.getBbHeight() * 0.55D, 0.0D).add(look.scale(1.8D));
            server.sendParticles(ParticleTypes.SWEEP_ATTACK, tip.x, tip.y, tip.z, 2, 0.4D, 0.15D, 0.4D, 0.0D);
            server.playSound(null, this.boss.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.HOSTILE, 1.15F, 0.65F);
        }

        private void tickShock(LivingEntity target) {
            this.face(target, 360.0F);
            this.boss.setDeltaMovement(Vec3.ZERO);
            if (this.timer == SHOCK_CAST) {
                Vec3 look = this.horizontalLook(target);
                Vec3 pos = EntityMyceliumSpike.ground(this.boss.level(),
                        this.boss.getX() + look.x * 1.6D, this.boss.getY(), this.boss.getZ() + look.z * 1.6D);
                float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.2D);
                EntityBlackWave.shock(this.boss.level(), this.boss, pos, this.boss.getYRot(), damage);
            }
            if (this.timer >= SHOCK_END) {
                this.finish();
            }
        }

        private void tickMold(LivingEntity target) {
            this.face(target, 360.0F);
            this.boss.setDeltaMovement(Vec3.ZERO);
            if (this.timer == MOLD_CAST) {
                Vec3 look = this.horizontalLook(target);
                Vec3 pos = EntityMyceliumSpike.ground(this.boss.level(),
                        this.boss.getX() + look.x * 1.4D, this.boss.getY(), this.boss.getZ() + look.z * 1.4D);
                float damage = (float) (this.boss.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.9D);
                EntityBlackWave.mold(this.boss.level(), this.boss, pos, this.boss.getYRot(), damage);
            }
            if (this.timer >= MOLD_END) {
                this.finish();
            }
        }

        private void tickTree(LivingEntity target) {
            if (this.timer < TREE_BURY) {
                this.face(target, 30.0F);
                this.boss.noPhysics = true;
                this.boss.setDeltaMovement(0.0D, -0.38D, 0.0D);
                this.boss.hasImpulse = true;
            } else if (this.timer == TREE_BURY) {
                this.boss.teleportTo(this.arena.x, this.arena.y - 3.2D, this.arena.z);
                this.boss.setDeltaMovement(Vec3.ZERO);
                this.boss.setInvulnerable(true);
                if (!this.treeSpawned) {
                    EntityFireTree.rise(this.boss.level(), this.boss, this.arena);
                    this.treeSpawned = true;
                }
            } else if (this.timer < TREE_RISE) {
                this.boss.setDeltaMovement(Vec3.ZERO);
            } else if (this.timer == TREE_RISE) {
                this.boss.teleportTo(this.arena.x + 2.2D, this.arena.y, this.arena.z);
                this.boss.noPhysics = false;
                this.boss.setInvulnerable(false);
                this.boss.resetFallDistance();
                this.boss.setDeltaMovement(Vec3.ZERO);
            }
            if (this.timer >= TREE_END) {
                this.finish();
                this.boss.beginStagger();
            }
        }

        private Vec3 horizontalLook(LivingEntity target) {
            if (target == null) {
                Vec3 look = this.boss.getLookAngle();
                double len = Math.sqrt(look.x * look.x + look.z * look.z);
                return len < 1.0E-4D ? new Vec3(0.0D, 0.0D, 1.0D) : new Vec3(look.x / len, 0.0D, look.z / len);
            }
            double dx = target.getX() - this.boss.getX();
            double dz = target.getZ() - this.boss.getZ();
            double len = Math.sqrt(dx * dx + dz * dz);
            return len < 1.0E-4D ? new Vec3(0.0D, 0.0D, 1.0D) : new Vec3(dx / len, 0.0D, dz / len);
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
    }

}
