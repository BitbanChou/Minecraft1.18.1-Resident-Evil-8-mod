package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModEffects;
import com.joy187.re8joymod.common.init.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


public class EntityBOWShoot extends ProjectileItemEntity {
    public int explosionPower = 1,id=91087;
    //    protected UUID uuid = MathHelper.createInsecureUUID(this.random);
    public Entity shootingEntity;
    private double damage;

    public EntityBOWShoot(EntityType<? extends EntityBOWShoot> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
        this.damage=6;
    }


//    public EntityM1851B(World p_i46758_1_, LivingEntity p_i46758_2_) {
//        super(EntityInit.M1851B.get(), p_i46758_2_, p_i46758_1_);
//    }

    public EntityBOWShoot(World world, LivingEntity entity) {
        super(EntityInit.BOWShoot.get(), entity, world);
        this.damage=6;
    }

    public EntityBOWShoot(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityInit.BOWShoot.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }


    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();

        int i = 6;
        if(entity instanceof BlazeEntity || entity instanceof RavagerEntity){
            i = 8;
        }
        if(entity instanceof EntityBei || entity instanceof EntityHeisen || entity instanceof EntityMiranda1){
            i= 10;
        }
        if(entity instanceof EntityUrias || entity instanceof EntityUriass || entity instanceof EntityRe8Dimi || entity instanceof EntityDimi2){
            i= 12;
        }

        if(entity instanceof LivingEntity)
        {
            int co=random.nextInt(3);
            if(co==2)
            {
                ((LivingEntity)entity).addEffect(new EffectInstance(ModEffects.DEADLY.get(), 100,1,true,true));
            }
            else if(co==1)
            {
                ((LivingEntity)entity).addEffect(new EffectInstance(ModEffects.BURN.get(), 50,1,true,true));
            }
            else {
                ((LivingEntity)entity).addEffect(new EffectInstance(ModEffects.EROSION.get(), 60,1,true,true));
            }
        }
        
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)(i+this.damage));
    }


    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
//            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, false, Explosion.Mode.DESTROY);
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
        return ModItems.BOWSHOOT.get();
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