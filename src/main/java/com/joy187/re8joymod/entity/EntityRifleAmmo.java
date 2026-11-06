package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;


public class EntityRifleAmmo extends ThrowableItemProjectile{
    
	public int explosionPower = 1,id=91082;
    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityRifleAmmo.class, EntityDataSerializers.INT);

	
	public EntityRifleAmmo(EntityType<?> entityIn, Level level) {
		super((EntityType<? extends EntityRifleAmmo>) entityIn, level);
        //this.size(1.0F, 1.0F);
        this.damage = 6D;
		// TODO Auto-generated constructor stub
	}
	
	public EntityRifleAmmo(Level world, LivingEntity entity) {
	    super(EntityInit.RIFLEAMMO.get(), entity, world);
	    this.damage= 6D;
	}
	
	
	@Override
	protected Item getDefaultItem() {
		return null;
	}
	   
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();


        int i = 6;
        if(entity instanceof Blaze || entity instanceof Ravager){
            i = 7;
        }
        if(entity instanceof EntityBei || entity instanceof EntityHeisen || entity instanceof Creeper){
            i= 8;
        }
        if(entity instanceof EntityUrias || entity instanceof EntityUriass){
            i= 9;
        }
        if(entity instanceof EntityLycana || entity instanceof AbstractSkeleton){
            i= 10;
        }
        entity.hurt(damageSources().thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));

    }
  

    
    protected void onHit(EntityHitResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.remove(RemovalReason.KILLED);
        }
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
    
}