package com.joy187.re8joymod.entity;

import net.minecraft.world.entity.monster.Phantom;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class EntityDoll1 extends Phantom {
    public int explosionPower = 1;

    public EntityDoll1(EntityType<? extends Phantom> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 18;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.FOLLOW_RANGE, 50.0D).
                add(Attributes.ARMOR, 2.0D).
                add(Attributes.ATTACK_DAMAGE, 4.0D);
    }
    

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
//        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Entity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }
    
    protected void customServerAiStep() {

        if(this.getHealth() >= 0.1F && this.getHealth()<=7.0F)
        {
            this.level().explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Level.ExplosionInteraction.NONE);
        }
        super.customServerAiStep();
    }

    protected boolean isSunSensitive() {
        return false;
    }

    protected boolean isSunBurnTick() {
        return false;
    }

    public void aiStep() {
        if (this.isAlive()  && this.isSunBurnTick() ) {
            boolean flag = this.isSunSensitive() && this.isSunBurnTick();
            if (flag) {
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageableItem()) {
                        itemstack.setDamageValue(0);
                        if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
                            this.broadcastBreakEvent(EquipmentSlot.HEAD);
                            this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }
                    }
                    flag = false;
                }

                if (flag) {
                    this.setSecondsOnFire(0);
                }
            }
        }
        super.aiStep();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.ENTITY_DOLL_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }
}
