package com.joy187.re8joymod.entity;

import java.util.UUID;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/**
 * Black mycelium spike that erupts from the ground. Visual is particles only.
 */
public class EntityMyceliumSpike extends Entity {
    private static final EntityDataAccessor<Integer> DELAY = SynchedEntityData.defineId(EntityMyceliumSpike.class, EntityDataSerializers.INT);

    private UUID ownerId;
    private float damage = 8.0F;
    private boolean struck;

    public EntityMyceliumSpike(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setNoGravity(true);
    }

    public static void rise(Level level, LivingEntity owner, Vec3 pos, float damage, int delay) {
        if (level.isClientSide) {
            return;
        }
        EntityMyceliumSpike spike = new EntityMyceliumSpike(EntityInit.MYCELIUM_SPIKE.get(), level);
        spike.setPos(pos.x, pos.y, pos.z);
        spike.ownerId = owner.getUUID();
        spike.damage = damage;
        spike.entityData.set(DELAY, Math.max(0, delay));
        level.addFreshEntity(spike);
    }

    public static Vec3 ground(Level level, double x, double y, double z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(net.minecraft.util.Mth.floor(x), net.minecraft.util.Mth.floor(y) + 2, net.minecraft.util.Mth.floor(z));
        for (int i = 0; i < 8; i++) {
            if (!level.getBlockState(pos).getCollisionShape(level, pos).isEmpty()
                    && level.getBlockState(pos.above()).getCollisionShape(level, pos.above()).isEmpty()) {
                return new Vec3(x, pos.getY() + 1.02D, z);
            }
            pos.move(Direction.DOWN);
        }
        return new Vec3(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        int delay = this.entityData.get(DELAY);
        if (this.level().isClientSide) {
            this.clientParticles(delay);
            return;
        }
        if (!this.struck && this.tickCount >= delay) {
            this.erupt();
        }
        if (this.tickCount > delay + 14) {
            this.discard();
        }
    }

    private void clientParticles(int delay) {
        if (this.tickCount < delay) {
            this.level().addParticle(net.minecraft.core.particles.ParticleTypes.ASH, this.getX(), this.getY() + 0.05D, this.getZ(), 0.0D, 0.01D, 0.0D);
            return;
        }
        int risen = Math.min(6, this.tickCount - delay + 1);
        for (int i = 0; i < risen; i++) {
            double y = this.getY() + i * 0.28D;
            this.level().addParticle(net.minecraft.core.particles.ParticleTypes.SQUID_INK, this.getX(), y, this.getZ(), 0.0D, 0.04D, 0.0D);
            if (i == risen - 1) {
                this.level().addParticle(net.minecraft.core.particles.ParticleTypes.MYCELIUM, this.getX(), y, this.getZ(), 0.0D, 0.08D, 0.0D);
            }
        }
    }

    private void erupt() {
        this.struck = true;
        this.level().playSound(null, this.blockPosition(), SoundEvents.POINTED_DRIPSTONE_LAND, SoundSource.HOSTILE, 0.7F, 0.55F);
        LivingEntity owner = this.owner();
        AABB box = this.getBoundingBox().inflate(0.55D, 0.35D, 0.55D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, living -> this.canHurt(owner, living))) {
            living.hurt(this.damageSources().mobAttack(owner == null ? living : owner), this.damage);
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 0));
        }
    }

    private LivingEntity owner() {
        if (this.ownerId == null || !(this.level() instanceof ServerLevel server)) {
            return null;
        }
        Entity entity = server.getEntity(this.ownerId);
        return entity instanceof LivingEntity living ? living : null;
    }

    static boolean canHurt(LivingEntity owner, LivingEntity living) {
        if (!living.isAlive() || living == owner || (owner != null && living.isAlliedTo(owner))) {
            return false;
        }
        if (living instanceof Player player && (player.isCreative() || player.isSpectator())) {
            return false;
        }
        return living.getMobType() != MobType.UNDEAD && living.attackable();
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
        this.entityData.define(DELAY, 0);
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
