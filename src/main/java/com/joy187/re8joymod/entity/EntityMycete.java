package com.joy187.re8joymod.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;
import net.minecraft.world.level.Level;

public class EntityMycete extends Zoglin{
    public EntityMycete(EntityType<? extends Zoglin> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 500.0D).
                add(Attributes.MOVEMENT_SPEED, 0.05D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.90D).
                add(Attributes.ARMOR, 20.0D).
                add(Attributes.ARMOR_TOUGHNESS, 30.0D).
                add(Attributes.ATTACK_DAMAGE, 100000.0D);
    }

    public boolean doHurtTarget(Entity p_34207_) {
        if (!(p_34207_ instanceof LivingEntity)) {
            return false;
        }
        else {
            if(p_34207_.getBbWidth()>2.2f && p_34207_.getBbHeight()>3.1f)
            {
                p_34207_.hurt(damageSources().mobAttack(this),((LivingEntity) p_34207_).getMaxHealth());
            }
            return HoglinBase.hurtAndThrowTarget(this, (LivingEntity)p_34207_);
        }
    }

    protected void customServerAiStep() {

        if(this.getLastHurtByMob()!=null){
            LivingEntity lvt=this.getLastHurtByMob();
            if(lvt.getBbWidth()>2.2f && lvt.getBbHeight()>3.0f){
                lvt.hurt(lvt.damageSources().mobAttack(this),(float)lvt.getArmorValue()+lvt.getHealth()*0.5f);
            }
            else if(lvt.getArmorValue()>50D){
                lvt.hurt(lvt.damageSources().mobAttack(this),lvt.getMaxHealth()*0.4f);
            }

        }

        super.customServerAiStep();
    }

}
