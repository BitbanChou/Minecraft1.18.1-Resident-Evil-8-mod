package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class EntityCameraShake extends Entity {
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(EntityCameraShake.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> MAGNITUDE = SynchedEntityData.defineId(EntityCameraShake.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(EntityCameraShake.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FADE_DURATION = SynchedEntityData.defineId(EntityCameraShake.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public EntityCameraShake(EntityType<?> type, Level world) {
        super(type, world);
    }

    public EntityCameraShake(Level world, Vec3 position, float radius, float magnitude, int duration, int fadeDuration) {
        super(EntityInit.SCSHAKE.get(), world);
        this.setRadius(radius);
        this.setMagnitude(magnitude);
        this.setDuration(duration);
        this.setFadeDuration(fadeDuration);
        this.setPos(position.x, position.y, position.z);
    }

    @OnlyIn(value=Dist.CLIENT)
    public float getShakeAmount(Player player, float delta) {
        float ticksDelta = (float)this.tickCount + delta;
        float timeFrac = 1.0f - (ticksDelta - (float)this.getDuration()) / ((float)this.getFadeDuration() + 1.0f);
        float baseAmount = ticksDelta < (float)this.getDuration() ? this.getMagnitude() : timeFrac * timeFrac * this.getMagnitude();
        Vec3 playerPos = player.getEyePosition(delta);
        float distFrac = (float)(1.0 - Mth.clamp((this.position().distanceTo(playerPos) / (double)this.getRadius()), 0.0, 1.0));
        return baseAmount * distFrac * distFrac;
    }

    public void tick() {
        super.tick();
        if (this.tickCount > this.getDuration() + this.getFadeDuration()) {
            this.discard();
        }
    }

    protected void defineSynchedData() {
        this.entityData.define(RADIUS, 10.0f);
        this.entityData.define(MAGNITUDE, 1.0f);
        this.entityData.define(DURATION, 0);
        this.entityData.define(FADE_DURATION, 5);
    }

    public float getRadius() {
        return this.entityData.get(RADIUS);
    }

    public void setRadius(float radius) {
        this.entityData.set(RADIUS, radius);
    }

    public float getMagnitude() {
        return this.entityData.get(MAGNITUDE);
    }

    public void setMagnitude(float magnitude) {
        this.entityData.set(MAGNITUDE, magnitude);
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        this.entityData.set(DURATION, duration);
    }

    public int getFadeDuration() {
        return this.entityData.get(FADE_DURATION);
    }

    public void setFadeDuration(int fadeDuration) {
        this.entityData.set(FADE_DURATION, fadeDuration);
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setRadius(compound.getFloat("radius"));
        this.setMagnitude(compound.getFloat("magnitude"));
        this.setDuration(compound.getInt("duration"));
        this.setFadeDuration(compound.getInt("fade_duration"));
        this.tickCount = compound.getInt("ticks_existed");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("radius", this.getRadius());
        compound.putFloat("magnitude", this.getMagnitude());
        compound.putInt("duration", this.getDuration());
        compound.putInt("fade_duration", this.getFadeDuration());
        compound.putInt("ticks_existed", this.tickCount);
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static void ScreenShake(Level world, Vec3 position, float radius, float magnitude, int duration, int fadeDuration) {
        if (!world.isClientSide) {
            EntityCameraShake ScreenShake = new EntityCameraShake(world, position, radius, magnitude, duration, fadeDuration);
            world.addFreshEntity(ScreenShake);
        }
    }
}
