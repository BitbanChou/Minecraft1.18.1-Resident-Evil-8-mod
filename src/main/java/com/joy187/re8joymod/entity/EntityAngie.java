package com.joy187.re8joymod.entity;

import java.util.Random;
import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityAngie extends Phantom {

    // 记录被替换的本体与剩余时间
    @Nullable
    private EntityBei avatarHost;
    @Nullable
    private LivingEntity avatarTarget;
    private float savedHealth = 0;
    private int savedSummonedCount = 0;
    private int lifeTicks = 0;

    public EntityAngie(EntityType<? extends Phantom> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 40;
    }

    public void setAvatarHost(EntityBei host, LivingEntity target, float health, int summonedCount) {
        this.avatarHost = host;
        this.avatarTarget = target;
        this.savedHealth = health;
        this.savedSummonedCount = summonedCount;
        this.lifeTicks = 60; // 3 秒
    }

    // ==================== 替身无敌 ====================
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        if (this.avatarHost != null) return true;
        return super.isInvulnerableTo(source);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.avatarHost != null) return false;
        return super.hurt(source, amount);
    }

    // ==================== 计时与变回本体 ====================
    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.avatarHost != null) {
            // 倒计时
            this.lifeTicks--;
            if (this.lifeTicks <= 0) {
                this.restoreHost();
            }
        }
    }

    private void restoreHost() {
        if (this.level() instanceof ServerLevel server) {
            double spawnX = this.getX();
            double spawnY = this.getY();
            double spawnZ = this.getZ();

            // 计算目标身后 3 格的位置
            if (this.avatarTarget != null && this.avatarTarget.isAlive()) {
                Vec3 back = this.avatarTarget.position().subtract(this.avatarTarget.getLookAngle().scale(1.0D));
                spawnX = back.x;
                spawnY = back.y;
                spawnZ = back.z;
            }

            // 生成新的 Boss
            EntityBei newBoss = new EntityBei(EntityInit.BEI.get(), server);
            newBoss.moveTo(spawnX, spawnY, spawnZ, this.getYRot(), 0);

            // 恢复血量与状态
            newBoss.setHealth(this.savedHealth);
            newBoss.setTarget(this.avatarTarget);
            // 你可以在 EntityBei 加个 setSummonedCount 方法来恢复这个值

            server.addFreshEntity(newBoss);

            // 变身回来的特效
            server.sendParticles(ParticleTypes.SMOKE, spawnX, spawnY + 1.0, spawnZ, 25, 0.4, 0.6, 0.4, 0.02);
            newBoss.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.2F);
        }

        // 替身功成身退，移除自己
        this.discard();
    }

    // ==================== 其余原版逻辑 ====================
    protected boolean isSunSensitive() { return false; }
    protected boolean isSunBurnTick() { return false; }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.FOLLOW_RANGE, 50.0D).
                add(Attributes.ARMOR, 4.0D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    public void aiStep() {
        if (this.isAlive() && this.isSunBurnTick()) {
            boolean flag = this.isSunSensitive() && this.isSunBurnTick();
            if (flag) {
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageableItem()) {
                        itemstack.setDamageValue(0);
                        if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                            this.broadcastBreakEvent(EquipmentSlot.HEAD);
                            this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }
                    flag = false;
                }
                if (flag) this.setSecondsOnFire(0);
            }
        }
        super.aiStep();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextBoolean() ? SoundInit.ENTITY_ANGIE_AMBIENT1.get() : SoundInit.ENTITY_ANGIE_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_ANGIE_HURT.get();
    }
}
