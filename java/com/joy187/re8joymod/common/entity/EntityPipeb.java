package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModItems;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


public class EntityPipeb extends ProjectileItemEntity {

    public int explosionPower = 2;
    public EntityPipeb(EntityType<? extends EntityPipeb> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public EntityPipeb(World p_i1774_1_, LivingEntity p_i1774_2_) {
        super(EntityInit.PIPEB.get(), p_i1774_2_, p_i1774_1_);
    }

    public EntityPipeb(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityInit.PIPEB.get(), p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }



    protected Item getDefaultItem() {
        return ModItems.PIPEB.get();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ASH : new ItemParticleData(ParticleTypes.ITEM, itemstack));
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

    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
//        int i = entity instanceof BlazeEntity ? 3 : 0;
        int damage=21;
        if(entity instanceof WitherEntity) damage=25;
        else if(entity instanceof EntityBeibaby) damage=65;
        else if(entity instanceof EntityMuHeisen) damage=40;
        else if(entity instanceof EntityMiranda1 || entity instanceof EntityMiranda2) damage=35;
        else if(entity instanceof EntityBei || entity instanceof EntityRe8Dimi) damage=30;
        else if(entity instanceof EntityMoreau3) damage=45;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)damage);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, false, Explosion.Mode.DESTROY);
            this.remove();
        }
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
