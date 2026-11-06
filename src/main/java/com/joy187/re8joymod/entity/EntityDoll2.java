package com.joy187.re8joymod.entity;

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

public class EntityDoll2 extends EntityDoll1{
    public int explosionPower = 2;

    public EntityDoll2(EntityType<? extends EntityDoll1> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 22;
    }


    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 45.0D).
                add(Attributes.MOVEMENT_SPEED, 0.43D).
                add(Attributes.ATTACK_DAMAGE, 5.5D);
    }

    protected void customServerAiStep() {

        if(this.getHealth() >= 0.5F && this.getHealth()<=7.0F)
        {
            this.level().explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, true, Level.ExplosionInteraction.NONE);
        }
        super.customServerAiStep();
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
