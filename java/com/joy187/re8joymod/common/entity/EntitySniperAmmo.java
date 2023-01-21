package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


public class EntitySniperAmmo extends ProjectileItemEntity {
    public int explosionPower = 1,id=91084;
    //    protected UUID uuid = MathHelper.createInsecureUUID(this.random);
    public Entity shootingEntity;
    private double damage;

    public EntitySniperAmmo(EntityType<? extends EntitySniperAmmo> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
        this.damage=24;
    }


//    public EntitySniperAmmo(World p_i46758_1_, LivingEntity p_i46758_2_) {
//        super(EntityInit.SniperAmmo.get(), p_i46758_2_, p_i46758_1_);
//    }

    public EntitySniperAmmo(World world, LivingEntity entity) {
        super(EntityInit.SNIPERAMMO.get(), entity, world);
        this.damage=24;
    }

    public EntitySniperAmmo(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityInit.SNIPERAMMO.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }



    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();

        int i = 24;
        if(entity instanceof BlazeEntity || entity instanceof RavagerEntity){
            i = 28;
        }
        if(entity instanceof EntityBei || entity instanceof EntityHeisen){
            i= 35;
        }
        if(entity instanceof EntityUrias || entity instanceof EntityUriass){
            i= 25;
        }
        if(entity instanceof EntityLycana || entity instanceof AbstractSkeletonEntity){
            i= 45;
        }
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));
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
//    @Override
//    public boolean isCritArrow() {
//        byte b0 = this.entityData.get(ID_FLAGS);
//        return (b0 & 1) != 0;
//    }
//    protected IParticleData getParticle() {
//            return ParticleTypes.FLAME;
//    }

//    public static AttributeModifierMap.MutableAttribute setAttributes() {
//        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 0.1D).
//                add(Attributes.ATTACK_DAMAGE, 60.0D);
//    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SNIPERAMMO.get();
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

//        Entity entity = this.getOwner();
//        int i = entity == null ? 0 : entity.getId();
//        return new SSpawnObjectPacket(this.getId(), this.uuid, this.getX(), this.getY(), this.getZ(), this.xRot, this.yRot, this.getType(), i, new Vector3d(this.getX(), this.getY(), this.getZ()));
    }
//
//    @Override
//    public IPacket<?> write() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }


    public IPacket<?> getEntitySpawningPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}