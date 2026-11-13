package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;
import java.util.function.Predicate;

public class EntitySalazar extends Ravager implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntitySalazar.class,
            EntityDataSerializers.INT);
    private static final int SUMMON_INTERVAL = 200;
    private static final int STUN_THRESHOLD = 6;
    private static final int STUN_DURATION = 80;
    private static final int ORBIT_DURATION = 100;
    private static final int ORBIT_COOLDOWN = 360;
    private static final double ORBIT_RADIUS = 4.5D;
    private static final double ORBIT_HEIGHT = 2.8D;
    private static final String PHANTOM_TAG = "salazar_phantom";

    private int spawnX,spawnY,spawnZ,attr;
    private int summonedCount;
    private int summonCooldown = 100;
    private boolean verdugoSummoned;
    private int stunTicks;
    private int orbitTicks;
    private int orbitCooldown = 240;
    private float orbitAngle;
    private int phantomLeftId = -1;
    private int phantomRightId = -1;
    public EntitySalazar(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.spawnX=0;
        this.spawnY=0;
        this.spawnZ=0;
        this.attr=0;
        this.xpReward = 50;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.24D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.10D).
                add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.ILLAGER && p_31504_.attackable();
    };

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        //this.goalSelector.addGoal(0, new EntityChief2.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new AttackGoal(this));
        //this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, AbstractVillager.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        //this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class,false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
//        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
            return PlayState.STOP;
        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.salazar.walk"));
            return PlayState.CONTINUE;
        }
//        Random ran = new Random();
//        int co = ran.nextInt(30);
//        if(co==1) {
//        	event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi.idle2"));
//            return PlayState.CONTINUE;
//        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.salazar.idle"));
        return PlayState.CONTINUE;
    }

    

    	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController<?> attackController =
				new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
						.triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.salazar.attack"));
		data.add(attackController);
		data.add(new AnimationController<>(this, "controller", 8, this::predicate));
	}



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        if(this.getHealth()<200.F){
            this.level().addParticle(ParticleTypes.SMOKE, this.position().x + this.random.nextGaussian() * (double)0.3F, this.position().y + this.random.nextGaussian() * (double)0.3F, this.position().z + this.random.nextGaussian() * (double)0.3F, 0.0D, 0.0D, 0.0D);
            if(this.hasEffect(MobEffects.JUMP)){
                this.addEffect(new MobEffectInstance(MobEffects.JUMP, 600,1,false,false));
            }
        }

        if(this.getHealth() >= 20.0F && this.getHealth()<=30.0F)
        {
            for(int i=0;i<5;i++)
                this.heal(1.0F*ran.nextFloat());
        }

        if(this.getHealth() >= 60.0F && this.getHealth()<=65.0F)
        {
            for(int i=0;i<4;i++)
                this.heal(2F*ran.nextFloat());
        }

        if(this.getHealth() <= 10.0F)
        {
            this.endOrbit();
            this.convertTo(EntityInit.SALAZ.get(),true);
            return;
        }

        if (this.stunTicks > 0) {
            this.stunTicks--;
            this.getNavigation().stop();
            if (this.stunTicks == 0) {
                this.summonedCount = 0;
                this.summonCooldown = SUMMON_INTERVAL;
            }
            return;
        }

        if (this.orbitTicks > 0) {
            return;
        }

        if (this.orbitCooldown > 0) {
            this.orbitCooldown--;
        }
        if (this.summonCooldown > 0) {
            this.summonCooldown--;
        }

        LivingEntity target = this.getTarget();
        if (target == null || !target.isAlive() || !this.hasLineOfSight(target)) {
            return;
        }
        if (this.orbitCooldown <= 0) {
            this.beginOrbit(target);
            return;
        }
        if (this.summonCooldown <= 0 && this.summonedCount < STUN_THRESHOLD) {
            this.summonOne(target);
            this.summonCooldown = SUMMON_INTERVAL;
        }

    }

    private void summonOne(LivingEntity target) {
        Mob minion;
        if (!this.verdugoSummoned && this.random.nextFloat() < 0.25F) {
            minion = new EntityVerdugo(EntityInit.VERDUGO.get(), this.level());
            this.verdugoSummoned = true;
        } else {
            int roll = this.random.nextInt(3);
            if (roll == 0) {
                minion = new EntityPlagas(EntityInit.PLAGAS.get(), this.level());
            } else if (roll == 1) {
                minion = new EntityZealot(EntityInit.ZEALOT.get(), this.level());
            } else {
                minion = new EntityZealota(EntityInit.ZEALOTA.get(), this.level());
            }
        }
        double sx = this.getX() + (this.random.nextDouble() - 0.5D) * 6.0D;
        double sz = this.getZ() + (this.random.nextDouble() - 0.5D) * 6.0D;
        minion.moveTo(sx, this.getY(), sz, this.getYRot(), 0.0F);
        minion.setTarget(target);
        this.level().addFreshEntity(minion);
        this.summonedCount++;
        this.setAttackingState(1);
        if (this.summonedCount >= STUN_THRESHOLD) {
            this.enterStun();
        }
    }

    private void enterStun() {
        this.stunTicks = STUN_DURATION;
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
        this.setAttackingState(0);
        this.ejectPassengers();
    }

    private void beginOrbit(LivingEntity target) {
        this.orbitTicks = ORBIT_DURATION;
        this.orbitAngle = (float) Math.atan2(this.getZ() - target.getZ(), this.getX() - target.getX());
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
        this.setNoGravity(true);
        this.noPhysics = true;
        this.fallDistance = 0.0F;
        this.ejectPassengers();
        this.setAttackingState(0);
        this.spawnPhantomPair();
        this.playSound(SoundInit.ENTITY_SALAZAR_AMBIENT2.get(), 1.6F, 0.7F);
    }

    private void endOrbit() {
        if (this.orbitTicks <= 0 && this.phantomLeftId < 0 && this.phantomRightId < 0 && !this.noPhysics) {
            return;
        }
        this.orbitTicks = 0;
        this.orbitCooldown = ORBIT_COOLDOWN;
        this.setNoGravity(false);
        this.noPhysics = false;
        this.discardPhantoms();
    }

    private void tickOrbit() {
        LivingEntity target = this.getTarget();
        if (target == null || !target.isAlive()) {
            this.endOrbit();
            return;
        }
        this.orbitTicks--;
        if (this.orbitTicks <= 0) {
            this.endOrbit();
            return;
        }

        this.orbitAngle += 0.14F;
        double x = target.getX() + Math.cos(this.orbitAngle) * ORBIT_RADIUS;
        double z = target.getZ() + Math.sin(this.orbitAngle) * ORBIT_RADIUS;
        double y = target.getY() + ORBIT_HEIGHT;
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.fallDistance = 0.0F;
        this.hurtMarked = true;
        this.lookAt(target, 180.0F, 180.0F);
        this.placePhantom(this.phantomLeftId, x, y, z, 1.0D);
        this.placePhantom(this.phantomRightId, x, y, z, -1.0D);
        this.applyPlagasTrail(x, y, z);
        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleInit.MUCUS_PARTICLE.get(), x, y - 0.4D, z, 8, 0.6D, 0.3D, 0.6D, 0.01D);
        }
    }

    private void spawnPhantomPair() {
        this.discardPhantoms();
        EntityVerdugo left = this.createPhantom();
        EntityVerdugo right = this.createPhantom();
        this.level().addFreshEntity(left);
        this.level().addFreshEntity(right);
        this.phantomLeftId = left.getId();
        this.phantomRightId = right.getId();
    }

    private EntityVerdugo createPhantom() {
        EntityVerdugo phantom = new EntityVerdugo(EntityInit.VERDUGO.get(), this.level());
        phantom.setNoAi(true);
        phantom.setInvulnerable(true);
        phantom.setSilent(true);
        phantom.setNoGravity(true);
        phantom.noPhysics = true;
        phantom.setPersistenceRequired();
        phantom.xpReward = 0;
        phantom.addTag(PHANTOM_TAG);
        phantom.setGlowingTag(true);
        phantom.setTarget(null);
        return phantom;
    }

    private void placePhantom(int id, double x, double y, double z, double side) {
        Entity phantom = this.level().getEntity(id);
        if (!(phantom instanceof EntityVerdugo) || !phantom.isAlive()) {
            return;
        }
        double px = x + Math.cos(this.orbitAngle + side * 1.2D) * 1.35D;
        double pz = z + Math.sin(this.orbitAngle + side * 1.2D) * 1.35D;
        phantom.setPos(px, y - 1.6D, pz);
        phantom.setDeltaMovement(Vec3.ZERO);
        phantom.setYRot(this.getYRot());
        phantom.yBodyRot = this.yBodyRot;
        phantom.hurtMarked = true;
    }

    private void applyPlagasTrail(double x, double y, double z) {
        AABB area = new AABB(x - 2.8D, y - ORBIT_HEIGHT - 0.5D, z - 2.8D, x + 2.8D, y + 1.2D, z + 2.8D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
            if (!this.shouldInfect(living)) {
                continue;
            }
            living.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(), 80, 0));
        }
    }

    private boolean shouldInfect(LivingEntity living) {
        if (!living.isAlive() || living == this || living.isAlliedTo(this)) {
            return false;
        }
        if (living instanceof EntitySalazar || living instanceof EntityVerdugo || living instanceof EntityZealot
                || living instanceof EntityZealota || living instanceof EntityPlagas) {
            return false;
        }
        return !living.getTags().contains(PHANTOM_TAG);
    }

    private void discardPhantoms() {
        this.discardPhantom(this.phantomLeftId);
        this.discardPhantom(this.phantomRightId);
        this.phantomLeftId = -1;
        this.phantomRightId = -1;
    }

    private void discardPhantom(int id) {
        if (id < 0) {
            return;
        }
        Entity phantom = this.level().getEntity(id);
        if (phantom != null && phantom.getTags().contains(PHANTOM_TAG)) {
            phantom.discard();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("SummonedCount", this.summonedCount);
        tag.putInt("SummonCooldown", this.summonCooldown);
        tag.putBoolean("VerdugoSummoned", this.verdugoSummoned);
        tag.putInt("StunTicks", this.stunTicks);
        tag.putInt("OrbitCooldown", this.orbitCooldown);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.summonedCount = tag.getInt("SummonedCount");
        if (tag.contains("SummonCooldown")) {
            this.summonCooldown = tag.getInt("SummonCooldown");
        }
        this.verdugoSummoned = tag.getBoolean("VerdugoSummoned");
        this.stunTicks = tag.getInt("StunTicks");
        if (tag.contains("OrbitCooldown")) {
            this.orbitCooldown = tag.getInt("OrbitCooldown");
        }
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        this.discardPhantoms();
        super.remove(reason);
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            if (this.orbitTicks > 0) {
                this.tickOrbit();
            } else if (this.stunTicks > 0) {
                this.getNavigation().stop();
                this.setPos(this.xo, this.getY(), this.zo);
                this.setDeltaMovement(0.0D, Math.min(this.getDeltaMovement().y, 0.0D), 0.0D);
                this.setYRot(this.yRotO);
            }
        }

        if(this.spawnX!=0 && this.spawnZ!=0) {
            for (int i = 0; i < 30; i++) {
                float deltaOmega = 1.0f * i;//ModConfig.DEBUG_CONF.HALO_OMEGA;
                Vec3 pos = new Vec3(this.spawnX + 1 * Math.sin(0 + deltaOmega), this.spawnY + 0.1f * this.random.nextFloat(), this.spawnZ + 1 * Math.cos(0 + deltaOmega));
                //this.level().spawnParticle(particleTypes, pos.x, pos.y, pos.z, 0,0,0);
                this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), this.spawnX, this.spawnY, this.spawnZ, 0, 0.1, 0);
            }
            //System.out.println(this.spawnX+" "+this.spawnY+" "+this.spawnZ+ " spawn!");
            this.spawnX=0;
            this.spawnZ=0;
            this.spawnY=0;
        }

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    	
	/** Trigger one-shot attack animation via GeckoLib triggerAnim. */
	protected void startAttackAnim(int state) {
		if (state == 1) {
			this.triggerAnim("controller1", "slash");
		}
	}

	public void setAttackingState(int time) {
		int prev = this.entityData.get(STATE);
		this.entityData.set(STATE, time);
		if ((time == 1) && prev != time) {
			this.startAttackAnim(time);
		}
	}


    static class AttackGoal extends Goal {
        private final EntitySalazar parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntitySalazar ghast) {
            this.parentEntity = ghast;
        }

        public boolean canUse() {
            return this.parentEntity.getTarget() != null && this.parentEntity.stunTicks <= 0 && this.parentEntity.orbitTicks <= 0;
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
                this.parentEntity.attr=this.attackTimer;
                //this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                if (this.attackTimer==15) {
                    if(this.parentEntity.getHealth() < 5 ||
                            (this.parentEntity.getHealth() > 180 && this.parentEntity.getHealth()<200) ||
                            (this.parentEntity.getHealth() > 140 && this.parentEntity.getHealth()<160) ||
                            (this.parentEntity.getHealth() > 110 && this.parentEntity.getHealth()<120) ||
                            (this.parentEntity.getHealth() > 90 && this.parentEntity.getHealth()<101) ||
                            (this.parentEntity.getHealth() > 50 && this.parentEntity.getHealth()<70) ||
                            (this.parentEntity.getHealth() > 15 && this.parentEntity.getHealth()<35))
                    {
                        this.parentEntity.setAttackingState(2);
                        if (!livingentity.hasPassenger(this.parentEntity) && !(livingentity instanceof EnderDragon)
                                && livingentity.getBbWidth() < 1.2F){
                            livingentity.stopRiding();
                            if(this.parentEntity.getRandom().nextFloat()<0.2f)
                                livingentity.startRiding(this.parentEntity, true);
                        }
                    }
                    else{
                        this.parentEntity.setAttackingState(3);
                        this.parentEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100,1,true,true));
                    }
                }
                else if(this.attackTimer == 1){
                    this.parentEntity.setAttackingState(1);
                }
                if (this.attackTimer == 60) {
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -20;
                }
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;
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

}
