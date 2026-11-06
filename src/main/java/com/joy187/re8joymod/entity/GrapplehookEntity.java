package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ItemInit;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.network.NetworkHooks;

public class GrapplehookEntity extends ThrowableItemProjectile {

    public double damage;
    private int ticksInGround;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(GrapplehookEntity.class, EntityDataSerializers.INT);

    public GrapplehookEntity(EntityType<?> entityIn, Level level) {
        super((EntityType<? extends GrapplehookEntity>) entityIn, level);
        //this.size(1.0F, 1.0F);
        this.damage = 6.0D;
        // TODO Auto-generated constructor stub
    }

    public GrapplehookEntity(Level world, LivingEntity entity) {
        super(EntityInit.GRAPPLE.get(), entity, world);
        this.damage= 6.0D;
    }


    public GrapplehookEntity(Level world, EntityMoreau3 parentEntity, double d2, double d3, double d4, float f) {
        // TODO Auto-generated constructor stub
        super(EntityInit.MOSPITTER.get(), parentEntity, world);
        this.damage= 3.0D;
    }

    public GrapplehookEntity(Level world, EntityMuHeisen parentEntity, double d2, double d3, double d4, float f) {
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

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        Entity entity = this.getOwner();

        if (!this.level().isClientSide && !this.isRemoved()) {
            if(result.getType() == HitResult.Type.BLOCK)
            {
                Vec3 vec3 = result.getLocation();
                BlockPos pos1 = ((BlockHitResult)result).getBlockPos();
                BlockPos pos = getPos(pos1);
                level().setBlock(pos, Blocks.COBWEB.defaultBlockState(),3);

                if (entity instanceof ServerPlayer) {
                    ServerPlayer serverplayer = (ServerPlayer)entity;
                    if (entity.isPassenger()) {
                        serverplayer.dismountTo(pos.getX(), pos.getY(), pos.getZ());
                    } else {
                        entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
                    }

                }
                else if (entity != null) {
                    entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
                    entity.resetFallDistance();
                }

            }

            this.discard();
        }
    }

    public BlockPos getPos(BlockPos pos){
        for(int x=-1;x<=1;x++)
        {
            for(int y=-1;y<=1;y++)
            {
                for(int z=-1;z<=1;z++)
                {
                    BlockPos pos1 = new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()+z);
                    if(level().getBlockState(pos1).is(Blocks.AIR) && level().getBlockState(pos1.above()).is(Blocks.AIR))
                    {
                        return pos1;
                    }
                }
            }
        }
        return pos;
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

//    public GrapplehookEntity(Level worldIn, double v, double v1, double v2) {
//        super(worldIn,v,v1,v2);
//    }


}