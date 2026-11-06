package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Predicate;

public class EntityHighEx extends ThrowableItemProjectile {
    public int explosionPower = 2,id=91088;
    public double damage;
    private int gtype,explodeTick;
    private boolean hit;

    public EntityHighEx(EntityType<?> entityIn, Level level) {
        //super((EntityType<? extends EntitHighEx>) entityIn, level);
        //this.size(1.0F, 1.0F)
        super((EntityType<? extends EntityHighEx>) entityIn, level);
        this.damage = 15D;
        this.gtype=0;
        this.explodeTick=0;
        this.hit=false;
        // TODO Auto-generated constructor stub
    }

    public EntityHighEx(Level world, LivingEntity entity,int type) {
        super(EntityInit.HIGHEX.get(), entity, world);
        this.damage= 15D;
        this.gtype=type;
        this.explodeTick=0;
        this.hit=false;
    }



    @Override
    protected Item getDefaultItem() {
        return ItemInit.HIGHEX.get();
    }

    private static final Predicate<Entity> GRENADA_AREA = (entity) -> {
        return entity.isAlive();
    };




    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        this.hit=true;
        int i = 20;
        if(this.gtype==2)
        {
            for (LivingEntity lvt : entity.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), GRENADA_AREA)) {
                double d00 = lvt.getX() - entity.getX();
                double d10 = lvt.getZ() - entity.getZ();
                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                lvt.hurt(lvt.damageSources().thrown(this, this.getOwner()), (float)(i*random.nextFloat()+this.damage*0.75));
                lvt.push(d00 / d20 * 2.0D, 0.2D, d10 / d20 * 2.0D);
            }
        }
        else{
            for (LivingEntity lvt : entity.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.0D), GRENADA_AREA)) {
                double d00 = lvt.getX() - entity.getX();
                double d10 = lvt.getZ() - entity.getZ();
                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                lvt.hurt(lvt.damageSources().thrown(this, this.getOwner()), (float)(i*random.nextFloat()+this.damage*0.5));
                lvt.push(d00 / d20 * 2.0D, 0.2D, d10 / d20 * 2.0D);
                if(this.gtype==1){
                    lvt.addEffect(new MobEffectInstance(EffectInit.STUN.get(), 100, 0));
                    if(lvt instanceof EntityPlagasZombie || lvt instanceof EntityPlagasVillager ||
                            lvt instanceof EntityPlagasEnderman)
                        lvt.hurt(lvt.damageSources().thrown(this, this.getOwner()), (float)(lvt.getMaxHealth()*0.8));
                }
                else
                    lvt.hurt(lvt.damageSources().thrown(this, this.getOwner()), (float)(0.5*this.damage));
            }
            entity.hurt(damageSources().thrown(this, this.getOwner()), (float)(i+random.nextFloat()*0.5*this.damage));
        }
    }


    protected void onHit(HitResult p_37218_) {
        super.onHit(p_37218_);
        this.hit=true;
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