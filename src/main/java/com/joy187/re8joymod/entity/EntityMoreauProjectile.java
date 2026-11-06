package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;

import io.netty.buffer.Unpooled;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;


public class EntityMoreauProjectile extends ThrowableItemProjectile  {

	private double damage;

    public EntityMoreauProjectile(EntityType<?> p_37473_, Level p_37474_) {
        super((EntityType<? extends EntityMoreauProjectile>)p_37473_, p_37474_);
        this.damage = 8.0D;

    }

    public EntityMoreauProjectile(Level p_37481_, LivingEntity p_37482_) {
        super(EntityInit.MOPROJECTILE.get(), p_37482_, p_37481_);
        this.damage = 8.0D;

    }
//
    public EntityMoreauProjectile(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(EntityInit.MOPROJECTILE.get(), p_37477_, p_37478_, p_37479_, p_37476_);
        this.damage =8.0D;

    }

//    @Override
//    protected Item getDefaultItem() {
//        return ItemListener.DETONATOR.get();
//    }

    public EntityMoreauProjectile(Level level, double x, double d, double z, float yaw, int i,
			EntityMoreau3 entityMoreau3, float f) {
		// TODO Auto-generated constructor stub
        super(EntityInit.MOPROJECTILE.get(), x, d, z, level);
        this.damage = 8.0D;
	}

	@Override
    protected Item getDefaultItem() {
        return ItemInit.MOPRO.get();
    	//return ItemInit.DETONATOR.get();
    }
    
    @Override

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        FriendlyByteBuf pack = new FriendlyByteBuf(Unpooled.buffer());
        pack.writeDouble(getX());
        pack.writeDouble(getY());
        pack.writeDouble(getZ());
        pack.writeInt(getId());
        pack.writeUUID(getUUID());

        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(!this.level().isClientSide) {
            this.level().explode((Entity) null, this.getX(), this.getY(), this.getZ(), 3.0F, Level.ExplosionInteraction.TNT);
            this.level().broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

    protected void onHit(EntityHitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if(!this.level().isClientSide) {
            this.level().explode((Entity) null, this.getX(), this.getY(), this.getZ(), 3.0F, Level.ExplosionInteraction.TNT);
            this.level().broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }



}