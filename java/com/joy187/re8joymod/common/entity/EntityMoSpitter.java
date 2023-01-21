package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


public class EntityMoSpitter extends ProjectileItemEntity {
    public int explosionPower = 1,id=91087;
    //    protected UUID uuid = MathHelper.createInsecureUUID(this.random);
    public Entity shootingEntity;
    private double damage;

    public EntityMoSpitter(EntityType<? extends EntityMoSpitter> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
        this.damage=8;
    }


    public EntityMoSpitter(World world, LivingEntity entity) {
        super(EntityInit.MOSPITTER.get(), entity, world);
        this.damage=8;
    }

    public EntityMoSpitter(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityInit.MOSPITTER.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }



    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();


        int i = 6;
        if(entity instanceof IronGolemEntity || entity instanceof RavagerEntity){
            i = 10;
        }
        if(entity instanceof EnderDragonEntity || entity instanceof WitherEntity){
            i= 11;
        }
        if(entity instanceof EntityMoreau || entity instanceof EntityHeisen || entity instanceof EntityDimi2 || entity instanceof EntityMiranda2){
            i= 4;
        }
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));
        if(random.nextInt(3)==2)
        {
            ((LivingEntity)entity).addEffect(new EffectInstance(Effects.POISON, 100,1,true,true));
        }
        else
        {
            ((LivingEntity)entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 50,0,true,true));
            ((LivingEntity)entity).addEffect(new EffectInstance(Effects.BLINDNESS, 60,1,true,true));
        }
    }


    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.FLAME : new ItemParticleData(ParticleTypes.ITEM, itemstack));
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            IParticleData iparticledata = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.MOSPITTER.get();
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

}