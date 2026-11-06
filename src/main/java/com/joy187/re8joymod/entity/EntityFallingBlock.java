package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import java.util.Optional;

public class EntityFallingBlock extends Entity {
    public int duration = 20;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(EntityFallingBlock.class, (EntityDataSerializer) EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(EntityFallingBlock.class, (EntityDataSerializer)EntityDataSerializers.BLOCK_STATE);

    public EntityFallingBlock(EntityType<EntityFallingBlock> type, Level level) {
        super(type, level);
    }

    public EntityFallingBlock(Level p_31953_, double p_31954_, double p_31955_, double p_31956_, BlockState p_31957_, int duration) {
        this(EntityInit.FALLBLOCK.get(), p_31953_);
        this.setBlock(p_31957_);
        this.setPos(p_31954_, p_31955_ + (double)((1.0f - this.getBbHeight()) / 2.0f), p_31956_);
        this.setDeltaMovement(Vec3.ZERO);
        this.duration = duration;
        this.xo = p_31954_;
        this.yo = p_31955_;
        this.zo = p_31956_;
        this.setStartPos(this.blockPosition());
    }

    public void setStartPos(BlockPos p_31960_) {
        this.entityData.set(DATA_START_POS, p_31960_);
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    protected void defineSynchedData() {
        this.entityData.define(DATA_START_POS,BlockPos.ZERO);
        this.getEntityData().define(BLOCK_STATE, Optional.of(Blocks.DIRT.defaultBlockState()));
    }

    public BlockState getBlock() {
        Optional bsOp = this.getEntityData().get(BLOCK_STATE);
        if(bsOp.isPresent())
            return this.getEntityData().get(BLOCK_STATE).get();
        return Blocks.GRASS_BLOCK.defaultBlockState();
    }

    public void setBlock(BlockState block) {
        this.getEntityData().set(BLOCK_STATE, Optional.of(block));
    }

    public void tick() {
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.95));
        if (this.onGround() && this.tickCount > this.duration) {
            this.discard();
        }
        if (this.tickCount > 300) {
            this.discard();
        }
    }

    protected void addAdditionalSaveData(CompoundTag p_31973_) {
        BlockState blockState = this.getBlock();
        if (blockState != null) {
            p_31973_.put("block", NbtUtils.writeBlockState(blockState));
        }
        p_31973_.putInt("Time", this.duration);
    }

    protected void readAdditionalSaveData(CompoundTag p_31964_) {
        Tag blockStateCompound = p_31964_.get("block");
        if (blockStateCompound != null) {
            HolderGetter<Block> holdergetter = (HolderGetter<Block>)(this.level() != null ? this.level().holderLookup(Registries.BLOCK) : BuiltInRegistries.BLOCK.asLookup());
            BlockState blockState = NbtUtils.readBlockState(holdergetter,(CompoundTag)blockStateCompound);
            this.setBlock(blockState);
        }
        this.duration = p_31964_.getInt("Time");
    }

    public boolean displayFireAnimation() {
        return false;
    }

    public BlockState getBlockState() {
        Optional bsOp = this.getEntityData().get(BLOCK_STATE);
        if(bsOp.isPresent())
            return this.getEntityData().get(BLOCK_STATE).get();
        //return bsOp.orElse(null);
        return Blocks.GRASS_BLOCK.defaultBlockState();
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

}
