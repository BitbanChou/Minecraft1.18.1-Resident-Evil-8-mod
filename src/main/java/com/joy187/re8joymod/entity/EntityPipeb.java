package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;

import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;


public class EntityPipeb extends ThrowableItemProjectile{
	 public int explosionPower = 2,id=91088;
	    public double damage;
	    private int ticksInGround;
	    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityPipeb.class, EntityDataSerializers.INT);

		
		public EntityPipeb(EntityType<?> entityIn, Level level) {
			//super((EntityType<? extends EntitPipeb>) entityIn, level);
	        //this.size(1.0F, 1.0F)
			super((EntityType<? extends EntityPipeb>) entityIn, level);
	        this.damage = 30D;
			// TODO Auto-generated constructor stub
		}
		
		public EntityPipeb(Level world, LivingEntity entity) {
		    super(EntityInit.PIPEB.get(), entity, world);
		    this.damage= 30D;
		}



	@Override
		protected Item getDefaultItem() {
			return ItemInit.PIPEBOMB.get();
		}
		   
	    protected void onHitEntity(EntityHitResult result) {
	        super.onHitEntity(result);
	        Entity entity = result.getEntity();

	        int i = 25;
//	        if(entity instanceof Blaze || entity instanceof Ravager){
//	            i = 35;
//	        }
//	        if(entity instanceof EntityBei || entity instanceof EntityFrank5){
//	            i= 45;
//	        }
	        if(entity instanceof EntityBeibaby){
	            i= 80;
	        }

	        entity.hurt(damageSources().thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));

	    }
	    

	    protected void onHit(HitResult p_37218_) {
	        super.onHit(p_37218_);

	        if (!this.level().isClientSide) {
	            this.level().broadcastEntityEvent(this, (byte)3);
	        	this.level().explode(null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, false, Level.ExplosionInteraction.BLOCK);
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
	    
	    public void addAdditionalSaveData(CompoundTag p_37222_) {
	        super.addAdditionalSaveData(p_37222_);
	        p_37222_.putByte("ExplosionPower", (byte)this.explosionPower);
	     }

	     public void readAdditionalSaveData(CompoundTag p_37220_) {
	        super.readAdditionalSaveData(p_37220_);
	        if (p_37220_.contains("ExplosionPower", 99)) {
	           this.explosionPower = p_37220_.getByte("ExplosionPower");
	        }

	     }
	
}