package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class EntitySalazar extends Ravager implements GeoEntity{
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityChief2.class,
            EntityDataSerializers.INT);
    private int spawnX,spawnY,spawnZ,attr;
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

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.salazar.attack"));
            return PlayState.CONTINUE;
        }
//        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.attack"));
//            return PlayState.CONTINUE;
//        }
//        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
//            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.kick"));
//            return PlayState.CONTINUE;
//        }
        return PlayState.CONTINUE;
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
            this.convertTo(EntityInit.SALAZ.get(),true);
        }

    }

    public void aiStep() {
        super.aiStep();

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

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    static class AttackGoal extends Goal {
        private final EntitySalazar parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntitySalazar ghast) {
            this.parentEntity = ghast;
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
                        if((this.parentEntity.getHealth()<110 && this.parentEntity.getHealth()>100) ||
                           (this.parentEntity.getHealth()<50 && this.parentEntity.getHealth()>40) )
                        {
                            EntityVerdugo e = new EntityVerdugo(EntityInit.VERDUGO.get(),this.parentEntity.level());
                            //BlockPos pos = new BlockPos();
                            e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                            this.parentEntity.level().addFreshEntity(e);

                        }
                        else{
                            EntityZealot e = new EntityZealot(EntityInit.ZEALOT.get(),this.parentEntity.level());
                            //BlockPos pos = new BlockPos();
                            e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                            this.parentEntity.level().addFreshEntity(e);

                        }
                    }
                }
                else if(this.attackTimer == 1){
                    this.parentEntity.setAttackingState(1);
                    EntityPlagas e = new EntityPlagas(EntityInit.PLAGAS.get(),this.parentEntity.level());
                    //e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                    this.parentEntity.level().addFreshEntity(e);

                }
                if (this.attackTimer == 60) {
                    this.parentEntity.setAttackingState(0);
                    if(this.parentEntity.random.nextFloat()<0.35)
                    {
                        EntityZealota e = new EntityZealota(EntityInit.ZEALOTA.get(),this.parentEntity.level());
                        //BlockPos pos = new BlockPos();
                        e.setPos(this.parentEntity.position().x+5*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().y+0.3*this.parentEntity.getRandom().nextFloat(),this.parentEntity.position().z+5*this.parentEntity.getRandom().nextFloat());
                        this.parentEntity.level().addFreshEntity(e);
                    }

                    this.attackTimer = -5;
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
