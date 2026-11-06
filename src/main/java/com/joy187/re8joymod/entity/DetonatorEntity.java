package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class DetonatorEntity extends ThrowableItemProjectile {
	private double damage;

    public DetonatorEntity(EntityType<?> p_37473_, Level p_37474_) {
        super((EntityType<? extends DetonatorEntity>)p_37473_, p_37474_);
        this.damage = 8.0D;

    }

    public DetonatorEntity(Level p_37481_, LivingEntity p_37482_) {
        super(EntityInit.DETONATOR_ENTITY.get(), p_37482_, p_37481_);
    }

    public DetonatorEntity(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(EntityInit.DETONATOR_ENTITY.get(), p_37477_, p_37478_, p_37479_, p_37476_);
    }

//    @Override
//    protected Item getDefaultItem() {
//        return ItemListener.DETONATOR.get();
//    }

    @Override
    protected Item getDefaultItem() {
        //return Items.TNT;
    	return ItemInit.DETONATOR.get();
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
            this.level().explode((Entity) null, this.getX(), this.getY(), this.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
            this.level().broadcastEntityEvent(this, (byte) 4);
            this.remove(RemovalReason.KILLED);
        }
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        if(p_70227_1_.getType()==HitResult.Type.BLOCK)
        {
            if(!this.level().isClientSide) {
                this.level().explode((Entity) null, this.getX(), this.getY(), this.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.remove(RemovalReason.KILLED);
            }
        }

    }

}