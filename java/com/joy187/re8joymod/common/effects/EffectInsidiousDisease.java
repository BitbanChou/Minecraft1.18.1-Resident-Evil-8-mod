package com.joy187.re8joymod.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

import java.util.Random;

public class EffectInsidiousDisease extends BaseEffect {
    public EffectInsidiousDisease(EffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 7 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified ++;
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(living instanceof PlayerEntity)
            ((PlayerEntity)living).causeFoodExhaustion(2F*amplified);
        living.hurt(DamageSource.WITHER, 0.5F*amplified);
        //living.addVelocity(3D,0.0D,0.2D);
        //EntityUtil.spawnCubeParticleAround(living, EnumParticleTypes.CRIT_MAGIC,0.5);

    }

    @Override
    public boolean isBeneficial() {
        return false;
    }

}