package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

public class EntityBei extends Ravager implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(EntityBei.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityBei.class, EntityDataSerializers.INT);

    private int canSummon = 0;
    private int f = 0;

    // ==================== 参数 ====================
    private int summonedCount = 0;
    private int summonCooldown = 0;
    private static final int SUMMON_INTERVAL = 60;
    private static final int STUN_THRESHOLD = 7;
    private int stunTicks = 0;
    private static final int STUN_DURATION = 80;
    private int avatarCooldown = 0;

    public EntityBei(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 250;
        this.isNonBoss();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.summonCooldown = SUMMON_INTERVAL;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 150.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.FOLLOW_RANGE, 48.0D).
                add(Attributes.ARMOR, 10.0D).
                add(Attributes.ARMOR_TOUGHNESS, 17.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.45D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    // ==================== 进入化身（本体彻底消失） ====================
    public void enterAvatar(LivingEntity target) {
        if (this.level().isClientSide || target == null) return;

        double spawnX = this.getX();
        double spawnY = this.getY() + 1.0D;
        double spawnZ = this.getZ();

        // 1. 生成 Angie 替身
        EntityAngie angie = new EntityAngie(EntityInit.ANGIE.get(), this.level());
        angie.moveTo(spawnX, spawnY, spawnZ, this.getYRot(), 0);
        angie.setTarget(target);
        angie.setLastHurtByMob(target);

        // 把当前 Boss 的数据（血量、已召唤数）直接写入替身，以便3秒后重建
        angie.setAvatarHost(this, target, this.getHealth(), this.summonedCount);

        // 给替身一个初始冲刺速度
        Vec3 dir = target.position().subtract(angie.position()).normalize();
        angie.setDeltaMovement(dir.scale(0.8D));
        this.level().addFreshEntity(angie);

        // 2. 变身表现
        this.playSound(SoundInit.ENTITY_BEI_AMBIENT2.get(), 1.5F, 0.8F);
        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.SOUL_FIRE_FLAME,
                    spawnX, spawnY, spawnZ, 40, 0.6, 0.8, 0.6, 0.05);
        }

        // 3. 本体彻底从世界移除
        this.discard();
    }

    // ==================== 主 AI ====================
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.avatarCooldown > 0) this.avatarCooldown--;

        // 硬直
        if (this.stunTicks > 0) {
            this.stunTicks--;
            this.canSummon = 0;
            this.getNavigation().stop();
            this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
            if (this.stunTicks == 0) {
                this.summonedCount = 0;
                this.summonCooldown = SUMMON_INTERVAL;
                this.setNoAi(false);
            }
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
            return;
        }

        // 召唤
        if (this.summonCooldown > 0) this.summonCooldown--;

        LivingEntity target = this.getTarget();
        if (target != null && this.summonCooldown <= 0 && this.summonedCount < STUN_THRESHOLD) {
            this.summonOneMinion(target);
            this.summonCooldown = SUMMON_INTERVAL;
            this.summonedCount++;

            if (this.summonedCount >= STUN_THRESHOLD) {
                this.enterStun();
            }
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
            return;
        }

        // 非召唤行为
        this.canSummon = 0;
        Random ran = new Random();
        int co = ran.nextInt(100);
        if (co > 20 && co < 40) {
            if (co % 5 == 0) {
                this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 1, true, true));
            } else {
                this.level().addParticle(ParticleTypes.END_ROD, this.getX(), this.getY() + 0.1D, this.getZ(), 0, 0.1D, 0);
                f = (f + 2) % 30;
            }
        } else if (co > 95) {
            this.getNavigation().moveTo(this.getX() + 6, this.getY(), this.getZ() - 6, 5);
        } else {
            this.level().addParticle(ParticleTypes.SOUL, this.getX(), this.getY() + 0.1D, this.getZ(), 0, 0.1D, 0);
            f = (f + 1) % 30;
        }

        // 触发化身
        if (this.summonedCount >= STUN_THRESHOLD && this.avatarCooldown <= 0 && this.random.nextFloat() < 0.02F) {
            this.enterAvatar(this.getTarget());
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private void summonOneMinion(LivingEntity target) {
        Random ran = new Random();
        int type = ran.nextInt(4);
        double sx = this.getX() + 3 * (ran.nextDouble() - 0.5);
        double sy = this.getY() + 0.3 * ran.nextFloat();
        double sz = this.getZ() + 3 * (ran.nextDouble() - 0.5);

        Mob minion;
        switch (type) {
            case 0: minion = new EntityDoll1(EntityInit.DOLL1.get(), this.level()); break;
            case 1: minion = new EntityDoll2(EntityInit.DOLL2.get(), this.level()); break;
            case 3: minion = new EntityAngie(EntityInit.ANGIE.get(), this.level()); break;
            default: minion = new EntityDoll3(EntityInit.DOLL3.get(), this.level()); break;
        }
        minion.moveTo(sx, sy, sz, this.getYRot(), 0);
        if (target != null) {
            minion.setTarget(target);
            if (minion instanceof Monster m) m.setLastHurtByMob(target);
        }
        this.level().addFreshEntity(minion);
        this.canSummon = 1;
        if (target != null) {
            Vec3 back = target.position().subtract(target.getLookAngle().scale(4.0D));
            if (!this.randomTeleport(back.x, back.y, back.z, true)) this.moveTo(back.x, back.y, back.z);
        }
    }

    private void enterStun() {
        this.stunTicks = STUN_DURATION;
        this.canSummon = 0;
        this.setNoAi(true);
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
    }

    @Override
    protected void defineSynchedData() { super.defineSynchedData(); }
    public boolean isNonBoss() { return false; }
    public void startSeenByPlayer(ServerPlayer p) { super.startSeenByPlayer(p); this.bossInfo.addPlayer(p); }
    public void stopSeenByPlayer(ServerPlayer p) { super.stopSeenByPlayer(p); this.bossInfo.removePlayer(p); }

    @Override
    protected SoundEvent getAmbientSound() { return this.random.nextBoolean() ? SoundInit.ENTITY_BEI_AMBIENT1.get() : SoundInit.ENTITY_BEI_AMBIENT2.get(); }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundInit.ENTITY_BEI_HURT.get(); }
    @Override
    protected SoundEvent getDeathSound() { return this.random.nextBoolean() ? SoundInit.ENTITY_BEI_DEATH1.get() : SoundInit.ENTITY_BEI_DEATH2.get(); }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.stunTicks > 0) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.stun"));
            return PlayState.CONTINUE;
        }
        if (this.canSummon == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.summon"));
            return PlayState.CONTINUE;
        }
        if (this.canSummon == 0 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.bei.attack"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller", 0, this::predicate));
        data.add(new AnimationController(this, "controller1", 0, this::predicate1));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return this.factory; }
}
