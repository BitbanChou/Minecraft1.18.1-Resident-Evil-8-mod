package com.joy187.re8joymod.entity;

import java.util.UUID;

import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/**
 * Mycelium pillar that rises in place and sprays fireballs.
 */
public class EntityFireTree extends Entity {
    private static final int LIFE = 78;
    private UUID ownerId;

    public EntityFireTree(EntityType<?> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setNoGravity(true);
    }

    public static void rise(Level level, LivingEntity owner, Vec3 pos) {
        if (level.isClientSide) {
            return;
        }
        EntityFireTree tree = new EntityFireTree(EntityInit.FIRE_TREE.get(), level);
        tree.setPos(pos.x, pos.y, pos.z);
        tree.ownerId = owner.getUUID();
        level.addFreshEntity(tree);
        level.playSound(null, tree.blockPosition(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.HOSTILE, 1.3F, 0.5F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.clientColumn();
            return;
        }
        if (this.tickCount > 12 && this.tickCount < LIFE && (this.tickCount - 12) % 5 == 0) {
            this.volley();
        }
        if (this.tickCount % 10 == 0) {
            this.scorchTouch();
        }
        if (this.tickCount > LIFE) {
            this.discard();
        }
    }

    private void clientColumn() {
        int height = Math.min(5, 1 + this.tickCount / 3);
        for (int i = 0; i < height; i++) {
            double y = this.getY() + i * 0.75D;
            this.level().addParticle(ParticleTypes.SQUID_INK, this.getX(), y, this.getZ(), 0.0D, 0.03D, 0.0D);
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), y, this.getZ(), 0.0D, 0.02D, 0.0D);
        }
        double top = this.getY() + height * 0.75D;
        this.level().addParticle(ParticleTypes.FLAME, this.getX(), top, this.getZ(), 0.0D, 0.06D, 0.0D);
        this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX(), top + 0.2D, this.getZ(), 0.0D, 0.04D, 0.0D);
    }

    private void volley() {
        LivingEntity owner = this.owner();
        if (owner == null) {
            this.discard();
            return;
        }
        LivingEntity target = owner instanceof Mob mob ? mob.getTarget() : null;
        Vec3 origin = new Vec3(this.getX(), this.getY() + 3.5D, this.getZ());
        for (int i = 0; i < 2; i++) {
            double dx;
            double dy;
            double dz;
            if (target != null && target.isAlive()) {
                dx = target.getX() - origin.x;
                dy = target.getEyeY() - origin.y;
                dz = target.getZ() - origin.z;
            } else {
                double ang = this.random.nextDouble() * Math.PI * 2.0D;
                dx = Math.cos(ang);
                dy = 0.15D;
                dz = Math.sin(ang);
            }
            this.level().addFreshEntity(new EntityMirandaFire(this.level(), owner, origin.x, origin.y, origin.z, dx, dy, dz));
        }
        if (this.tickCount % 10 == 0) {
            this.level().playSound(null, this.blockPosition(), SoundEvents.BLAZE_SHOOT, SoundSource.HOSTILE, 0.8F, 0.7F);
        }
    }

    private void scorchTouch() {
        LivingEntity owner = this.owner();
        AABB box = this.getBoundingBox().inflate(0.35D, 0.2D, 0.35D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, living -> EntityMyceliumSpike.canHurt(owner, living))) {
            LivingEntity attacker = owner == null ? living : owner;
            living.hurt(this.damageSources().mobAttack(attacker), 6.0F);
            living.setSecondsOnFire(3);
        }
    }

    private LivingEntity owner() {
        if (this.ownerId == null || !(this.level() instanceof ServerLevel server)) {
            return null;
        }
        Entity entity = server.getEntity(this.ownerId);
        return entity instanceof LivingEntity living && !living.isRemoved() ? living : null;
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
