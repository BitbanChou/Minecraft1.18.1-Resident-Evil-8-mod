package com.joy187.re8joymod.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;

public class EntityIdlProjectile extends Entity {
    public LivingEntity shootingEntity;
    private int ticksAlive;
    protected int ticksInAir;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    //public ProjectileArgs args;
    boolean hitToDeflect = false;
//	
//    protected EntityIdlProjectile(Level worldIn)
//    {
//        super(worldIn);
//        args = new ProjectileArgs(1f);
//    }
    
	public EntityIdlProjectile(EntityType<?> p_19870_, Level p_19871_) {
		super(p_19870_, p_19871_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void defineSynchedData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return null;
	}



}