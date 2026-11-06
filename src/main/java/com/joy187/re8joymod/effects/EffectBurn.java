package com.joy187.re8joymod.effects;

import java.util.Random;

import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EffectBurn extends BaseEffect{

    public EffectBurn(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 5 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified ++;
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(living instanceof Player)
            ((Player)living).causeFoodExhaustion(2F*amplified);
        living.hurt(living.damageSources().wither(), 0.5F*amplified);
        //living.addVelocity(3D,0.0D,0.2D);
        //EntityUtil.spawnCubeParticleAround(living, EnumParticleTypes.CRIT_MAGIC,0.5);
        if(co==3) {
        	CommonFunctions.spawnHaloParticleAround(living,ParticleTypes.SMALL_FLAME,1.0F);
        }
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
    
}
