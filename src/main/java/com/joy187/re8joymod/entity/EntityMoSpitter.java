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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class EntityMoSpitter extends ThrowableItemProjectile {

    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(EntityMoSpitter.class, EntityDataSerializers.INT);

	public EntityMoSpitter(EntityType<?> entityIn, Level level) {
		super((EntityType<? extends EntityMoSpitter>) entityIn, level);
        //this.size(1.0F, 1.0F);
        this.damage = 6.0D;
		// TODO Auto-generated constructor stub
	}
	
	public EntityMoSpitter(Level world, LivingEntity entity) {
	    super(EntityInit.MOSPITTER.get(), entity, world);
	    this.damage= 6.0D;
	}
    

	public EntityMoSpitter(Level world, EntityMoreau3 parentEntity, double d2, double d3, double d4, float f) {
		// TODO Auto-generated constructor stub
	    super(EntityInit.MOSPITTER.get(), parentEntity, world);
	    this.damage= 3.0D;
	}

	public EntityMoSpitter(Level world, EntityMuHeisen parentEntity, double d2, double d3, double d4, float f) {
		// TODO Auto-generated constructor stub
	    super(EntityInit.MOSPITTER.get(), parentEntity, world);
	    this.damage= f;
	}
	
	@Override
	protected Item getDefaultItem() {
		return ItemInit.MOSPITTER.get();
	}
	   
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();


        int i = 6;
        if(entity instanceof IronGolem || entity instanceof Ravager){
            i = 10;
        }
        if(entity instanceof EnderDragon || entity instanceof WitherBoss){
            i= 11;
        }
        if(entity instanceof EntityMoreau || entity instanceof EntityHeisen || entity instanceof EntityDimi2 || entity instanceof EntityMiranda2){
            i= 4;
        }
        entity.hurt(damageSources().thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));
        if(entity instanceof LivingEntity)
        {        
	        if(random.nextInt(3)==2)
	        {
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.POISON, 100,1,false,false));
	        }
	        else
	        {
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50,0,false,false));
	            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60,1,false,false));
	        }
        }
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
    
//    public EntityMoSpitter(Level worldIn, double v, double v1, double v2) {
//        super(worldIn,v,v1,v2);
//    }
	
	
}