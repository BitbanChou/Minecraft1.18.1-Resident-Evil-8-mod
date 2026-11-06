package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

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

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EntityKrauser2 extends Monster implements GeoEntity {

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityKrauser2.class,
            EntityDataSerializers.INT);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable() &&  !(p_31504_ instanceof EntityKrauser2) && !(p_31504_ instanceof EntityKrauser) && !(p_31504_ instanceof EntitySalazar);
    };
    private int preatt;
    public EntityKrauser2(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
        this.xpReward=200;
        this.preatt=0;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 6D).
                add(Attributes.ARMOR_TOUGHNESS, 9.0D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(0, new EntityRe8Dimi.DimiDoNothingGoal());
        this.goalSelector.addGoal(1, new FloatGoal(this));
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

    protected void customServerAiStep() {

        super.customServerAiStep();

        Random ran = new Random();
        this.fallDistance=0;

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    //}

    public void makeInvulnerable() {
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
        if(this.entityData.get(STATE)==0) {
            if (event.isMoving()) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.krauser.walk"));
                return PlayState.CONTINUE;
            }
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.krauser.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.krauser.attack"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 2 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.krauser.attack2"));
            return PlayState.CONTINUE;
        }
        if (this.entityData.get(STATE) == 3 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.krauser.attack3"));
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
    public boolean hurt(DamageSource p_37849_, float p_37850_)
    {
        if (!level().isClientSide()) {
            return super.hurt(p_37849_,Math.min(50,p_37850_));
        }
        return false;
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

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(4);
        if(co<2)
        {
            return SoundInit.ENTITY_KRAUSER_AMBIENT11.get();
        }
        else if(co==2) return SoundInit.ENTITY_KRAUSER_AMBIENT21.get();
        return SoundInit.ENTITY_KRAUSER_AMBIENT22.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_KRAUSER_HURT.get();
        }
        return SoundInit.ENTITY_KRAUSER_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_KRAUSER_DEATH.get();
    }

    private static final Predicate<Entity> KRAUSER_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityKrauser2);
    };

    static class AttackGoal extends Goal {
        private final EntityKrauser2 parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityKrauser2 mob) {
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


                if (this.attackTimer == 5) {
                    if (this.parentEntity.preatt!=1 && (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.86 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.9))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.82 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.85))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.76 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.79))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.42 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.45))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.51 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.54))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.2 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.23))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.1 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.14))) {
                        this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                        this.parentEntity.getNavigation().stop();
                        this.parentEntity.preatt = 1;
                    } else if (this.parentEntity.preatt!=2 && (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.71 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.75))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.55 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.59))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.64 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.68))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.47 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.51))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.3 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.34))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.03 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.08))
                            || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.25 && (this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.3))) {
                        this.parentEntity.getNavigation().stop();
                        this.parentEntity.setAttackingState(2);
                        this.parentEntity.preatt = 2;
                    } else {
                        this.parentEntity.getNavigation().stop();
                        this.parentEntity.setAttackingState(3);
                        this.parentEntity.preatt = 3;
                    }
                }

                if(this.attackTimer==13 && this.parentEntity.getAttckingState()==1){
                    this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                    if (livingentity != null && livingentity.isAlive() && this.parentEntity.distanceTo(livingentity) < 2.75f) {
                        livingentity.hurt(livingentity.damageSources().mobAttack((this.parentEntity)), (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float) this.parentEntity.random.nextInt(4));
                        this.parentEntity.heal(this.parentEntity.getMaxHealth()*0.02f);
                        livingentity.knockback(0.25, this.parentEntity.getX() - livingentity.getX(), this.parentEntity.getZ() - livingentity.getZ());
                    }
                }

                if(this.attackTimer==15 && this.parentEntity.getAttckingState()==2){
                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()+1.5,this.parentEntity.getZ(),2);
                }

                if(this.attackTimer==19 && this.parentEntity.getAttckingState()==2){
                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()-1,this.parentEntity.getZ(),2);
                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(4.0D), KRAUSER_AREA)) {
                        lvt.hurt(lvt.damageSources().mobAttack(this.parentEntity), lvt.getMaxHealth()*0.2F+lvt.getArmorValue());
                    }

                    for(int i = 0; i < 2; ++i) {
                        float f1 = f + (float)i * (float)Math.PI * 0.4F;
                        this.parentEntity.blockSmashAttack(i, f1, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, -0.5F, 150, 1.5F, 0.15F, 1.0F);

                    }

                    for(int k = 0; k < 3; ++k) {
                        float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
                        this.parentEntity.blockSmashAttack(k, f2, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, -0.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                }

                if(this.attackTimer==13 && this.parentEntity.getAttckingState()==3){
                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()+1.5,this.parentEntity.getZ(),2);
                    this.parentEntity.setDeltaMovement(0,1,0);
                }

                if(this.attackTimer==21 && this.parentEntity.getAttckingState()==3){
                    this.parentEntity.getNavigation().moveTo(this.parentEntity.getX(),this.parentEntity.getY()-1.2,this.parentEntity.getZ(),2);
                }

                if(this.attackTimer==25 && this.parentEntity.getAttckingState()==3){
                    this.parentEntity.getNavigation().stop();


                    for(int i = 0; i < 2; ++i) {
                        float f1 = f + (float)i * (float)Math.PI * 0.4F;
                        this.parentEntity.blockSmashAttack(i, f1, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(i, f1, -0.5F, 150, 1.5F, 0.15F, 1.0F);

                    }

                    for(int k = 0; k < 3; ++k) {
                        float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
                        this.parentEntity.blockSmashAttack(k, f2, 1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, -1.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 2F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, 0.5F, 150, 1.5F, 0.15F, 1.0F);
                        this.parentEntity.blockSmashAttack(k, f2, -0.5F, 150, 1.5F, 0.15F, 1.0F);
                    }
                }

                if(this.attackTimer==35 && this.parentEntity.getAttckingState()==3){
                    this.parentEntity.getNavigation().moveTo(livingentity,2);
                }

                if (this.attackTimer == 40) {
                    if(this.parentEntity.distanceTo(livingentity)<5f && livingentity.isAlive() && this.parentEntity.getAttckingState()==3){
                        this.parentEntity.getNavigation().moveTo(this.parentEntity.getX()+this.parentEntity.random.nextInt(7),this.parentEntity.getY(),this.parentEntity.getZ()+this.parentEntity.random.nextInt(7),2);
                        if (livingentity != null && livingentity.isAlive() && this.parentEntity.distanceTo(livingentity) < 3f) {
                            livingentity.hurt(livingentity.damageSources().mobAttack((this.parentEntity)), (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) + livingentity.getArmorValue());
                            livingentity.addEffect(new MobEffectInstance(EffectInit.PLAGAS.get(),200,0,true,true));
                            livingentity.knockback(0.25, this.parentEntity.getX() - livingentity.getX(), this.parentEntity.getZ() - livingentity.getZ());
                        }
                    }
                    this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,20,5));
                    this.parentEntity.setAttackingState(0);
                    this.attackTimer = -5;
                }            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

            }
            else if (this.attackTimer > 0) {
                --this.attackTimer;

            }
            //System.out.println(this.parentEntity.attackAnim);
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
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
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
