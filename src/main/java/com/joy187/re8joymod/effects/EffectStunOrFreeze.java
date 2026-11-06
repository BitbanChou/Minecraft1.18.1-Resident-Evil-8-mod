package com.joy187.re8joymod.effects;

import com.joy187.re8joymod.entity.EntityPlagasEnderman;
import com.joy187.re8joymod.entity.EntityPlagasVillager;
import com.joy187.re8joymod.entity.EntityPlagasZombie;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class EffectStunOrFreeze extends BaseEffect{

    public EffectStunOrFreeze(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 2 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified++;
        if(living.getEffect(EffectInit.STUN.get())!=null) {
            Vec3 vec =  living.getDeltaMovement();
            living.setDeltaMovement(-vec.x,vec.y,-vec.z);
        }
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
    
}
