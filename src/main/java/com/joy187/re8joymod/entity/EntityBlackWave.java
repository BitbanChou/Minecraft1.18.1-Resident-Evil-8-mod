package com.joy187.re8joymod.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/**
 * Traveling black wave. Shock is a narrow-looking fan with a larger hit.
 * Mold is a wide ground surge that poisons.
 */
public class EntityBlackWave extends Entity {
    public static final int SHOCK = 0;
    public static final int MOLD = 1;

    private static final EntityDataAccessor<Integer> KIND = SynchedEntityData.defineId(EntityBlackWave.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(EntityBlackWave.class, EntityDataSerializers.FLOAT);

    private UUID ownerId;
    private float damage = 8.0F;
    private final Set<UUID> hit = new HashSet<>();

    public EntityBlackWave(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setNoGravity(true);
    }

    public static void shock(Level level, LivingEntity owner, Vec3 pos, float yaw, float damage) {
        spawn(level, owner, pos, yaw, damage, SHOCK);
    }

    public static void mold(Level level, LivingEntity owner, Vec3 pos, float yaw, float damage) {
        spawn(level, owner, pos, yaw, damage, MOLD);
    }

    private static void spawn(Level level, LivingEntity owner, Vec3 pos, float yaw, float damage, int kind) {
        if (level.isClientSide) {
            return;
        }
        EntityBlackWave wave = new EntityBlackWave(EntityInit.BLACK_WAVE.get(), level);
        wave.setPos(pos.x, pos.y, pos.z);
        wave.ownerId = owner.getUUID();
        wave.damage = damage;
        wave.entityData.set(KIND, kind);
        wave.entityData.set(YAW, yaw);
        level.addFreshEntity(wave);
    }

    @Override
    public void tick() {
        super.tick();
        int kind = this.entityData.get(KIND);
        Vec3 dir = Vec3.directionFromRotation(0.0F, this.entityData.get(YAW));
        if (this.level().isClientSide) {
            this.clientParticles(kind, dir);
            return;
        }
        double speed = kind == MOLD ? 0.30D : 0.58D;
        this.setDeltaMovement(dir.scale(speed));
        this.move(MoverType.SELF, this.getDeltaMovement());
        if (this.tickCount == 1) {
            this.level().playSound(null, this.blockPosition(),
                    kind == MOLD ? SoundEvents.SCULK_CATALYST_BLOOM : SoundEvents.EVOKER_CAST_SPELL,
                    SoundSource.HOSTILE, 1.1F, kind == MOLD ? 0.6F : 0.8F);
        }
        this.damageAlong(kind, dir);
        int life = kind == MOLD ? 36 : 22;
        if (this.tickCount > life) {
            this.discard();
        }
    }

    private void clientParticles(int kind, Vec3 dir) {
        Vec3 side = new Vec3(-dir.z, 0.0D, dir.x);
        if (kind == MOLD) {
            for (int i = -4; i <= 4; i++) {
                Vec3 p = this.position().add(side.scale(i * 0.48D));
                this.level().addParticle(ParticleTypes.SQUID_INK, p.x, p.y + 0.15D, p.z, 0.0D, 0.02D, 0.0D);
                this.level().addParticle(ParticleTypes.MYCELIUM, p.x, p.y + 0.05D, p.z, side.x * 0.02D, 0.01D, side.z * 0.02D);
            }
            return;
        }
        double spread = Math.min(0.5D, 0.16D + this.tickCount * 0.028D);
        for (int i = -3; i <= 3; i++) {
            Vec3 p = this.position().add(side.scale(i * spread)).add(dir.scale(0.3D));
            this.level().addParticle(ParticleTypes.SQUID_INK, p.x, p.y + 0.4D, p.z, dir.x * 0.05D, 0.02D, dir.z * 0.05D);
            if (i % 2 == 0) {
                this.level().addParticle(ParticleTypes.SMOKE, p.x, p.y + 0.55D, p.z, 0.0D, 0.01D, 0.0D);
            }
        }
    }

    private void damageAlong(int kind, Vec3 dir) {
        LivingEntity owner = this.owner();
        double radius = kind == MOLD ? 2.3D : 2.8D;
        double dotMin = kind == MOLD ? 0.0D : 0.2D;
        AABB box = this.getBoundingBox().inflate(radius, 1.0D, radius);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, living -> EntityMyceliumSpike.canHurt(owner, living))) {
            if (!this.hit.add(living.getUUID())) {
                continue;
            }
            Vec3 flat = new Vec3(living.getX() - this.getX(), 0.0D, living.getZ() - this.getZ());
            if (flat.lengthSqr() > 0.04D && flat.normalize().dot(dir) < dotMin) {
                this.hit.remove(living.getUUID());
                continue;
            }
            LivingEntity attacker = owner == null ? living : owner;
            living.hurt(this.damageSources().mobAttack(attacker), this.damage);
            if (kind == MOLD) {
                living.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 1));
            } else {
                living.knockback(1.05D, -dir.x, -dir.z);
            }
        }
    }

    private LivingEntity owner() {
        if (this.ownerId == null || !(this.level() instanceof ServerLevel server)) {
            return null;
        }
        Entity entity = server.getEntity(this.ownerId);
        return entity instanceof LivingEntity living ? living : null;
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(KIND, SHOCK);
        this.entityData.define(YAW, 0.0F);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.discard();
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
