package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class EntityBOWShoot extends ThrowableItemProjectile{
    public int explosionPower = 1,id=91087;
    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityBOWShoot.class, EntityDataSerializers.INT);

	
	public EntityBOWShoot(EntityType<?> entityIn, Level level) {
		super((EntityType<? extends EntityBOWShoot>) entityIn, level);
        //this.size(1.0F, 1.0F);
        this.damage = 6D;
		// TODO Auto-generated constructor stub
	}
	
	public EntityBOWShoot(Level world, LivingEntity entity) {
	    super(EntityInit.BOWSHOOT.get(), entity, world);
	    this.damage= 6D;
	}
	
	
	@Override
	protected Item getDefaultItem() {
		return ItemInit.MOSPITTER.get();
	}
	   
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();


        int i = 6;
        if(entity instanceof Blaze || entity instanceof Ravager){
            i = 5;
        }


        if(entity instanceof EntityBei || entity instanceof EntityHeisen || entity instanceof EntityMiranda1){
            i= 4;
        }
        if(entity instanceof EntityUrias || entity instanceof EntityUriass || entity instanceof EntityRe8Dimi || entity instanceof EntityDimi2){
            i= 7;
        }
        if(entity instanceof LivingEntity)
        {
	        int co=random.nextInt(3);
	        if(co==2)
	        {
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 100,1,true,true));
	        }
	        else if(co==1)
	        {
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(EffectInit.BURN.get(), 50,1,true,true));
	        }
	        else {
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 60,1,true,true));
	        }       	
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
