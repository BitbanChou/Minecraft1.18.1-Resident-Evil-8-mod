package com.joy187.re8joymod.common.entity;


import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityMoreauProjectile extends ProjectileItemEntity {

    private double damage;

    public EntityMoreauProjectile(EntityType<?> p_37473_, World p_37474_) {
        super((EntityType<? extends EntityMoreauProjectile>)p_37473_, p_37474_);
        this.damage = 8.0D;

    }

    public EntityMoreauProjectile(World p_37481_, LivingEntity p_37482_) {
        super(EntityInit.MOPROJECTILE.get(), p_37482_, p_37481_);
        this.damage = 8.0D;

    }
    //
    public EntityMoreauProjectile(World p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(EntityInit.MOPROJECTILE.get(), p_37477_, p_37478_, p_37479_, p_37476_);
        this.damage =8.0D;

    }

//    @Override
//    protected Item getDefaultItem() {
//        return ItemListener.DETONATOR.get();
//    }

    public EntityMoreauProjectile(World level, double x, double d, double z, float yaw, int i,
                                  EntityMoreau3 entityMoreau3, float f) {
        // TODO Auto-generated constructor stub
        super(EntityInit.MOPROJECTILE.get(), x, d, z, level);
        this.damage = 8.0D;
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MOPRO.get();
        //return ItemInit.DETONATOR.get();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        PacketBuffer pack = new PacketBuffer(Unpooled.buffer());
        pack.writeDouble(getX());
        pack.writeDouble(getY());
        pack.writeDouble(getZ());
        pack.writeInt(getId());
        pack.writeUUID(getUUID());


        return NetworkHooks.getEntitySpawningPacket(this);

    }

    public IPacket<?> getEntitySpawningPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        if(!this.level.isClientSide) {
            this.level.explode((Entity) null, this.getX(), this.getY(), this.getZ(), 3.0F, Explosion.Mode.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove();
        }
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if(!this.level.isClientSide) {
            this.level.explode((Entity) null, this.getX(), this.getY(), this.getZ(), 3.0F, Explosion.Mode.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 4);
            this.remove();
        }
    }



}