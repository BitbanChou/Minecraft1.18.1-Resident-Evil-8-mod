package com.joy187.re8joymod.common.effects;


import com.joy187.re8joymod.helper.CommonFunctions;
import net.minecraft.util.math.vector.Vector3d;import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

import java.util.Random;

public class EffectDeadly extends BaseEffect {

    public EffectDeadly(EffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 7 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        Random ran = new Random();
        int co = ran.nextInt(5);
        //EntityUtil.spawnCubeParticleAround(living, ParticleTypes.SOUL,1);
        if(co==0 || co==1) living.setDeltaMovement(Math.sin(0.02)*0.02D,0.0D,0.0D);
        else living.setDeltaMovement( -0.02D,0.0D,0.0D);
        if(co==2 || co==1) living.setDeltaMovement(0.0D,0.0D,0.02D);
        else living.setDeltaMovement(0.0D,0.0D,-Math.sin(0.02)*0.02D);
//        living.motionY += (0.05D * (double)(living.getActivePotionEffect(ModPotions.DEADLY).getAmplifier() + 1) - living.motionY) * 0.2D;
        //if(co==3) living.heal(ran.nextFloat());
        if(co==4 && living.getHealth()>1F) {
            if(amplified>1) living.hurt(DamageSource.MAGIC, amplified*0.5F);
            else living.hurt(DamageSource.MAGIC, 1);
        }

        for (int j = 0; j < 10; j++)
        {
            Vector3d pos = new Vector3d(living.position().x + 0.5 * Math.sin(0 ),  living.position().y, living.position().z + 0.5 * Math.cos(0));
            Random random = living.getRandom();
            float flunc = (float) CommonFunctions.flunctate(0, 0.5, random);
            living.level.addParticle(ParticleTypes.SOUL, pos.x + 0.5, pos.y, pos.z + flunc, 0,0,0);
            living.level.addParticle(ParticleTypes.SOUL, pos.x - 0.5, pos.y, pos.z + flunc, 0,0,0);
            living.level.addParticle(ParticleTypes.SOUL, pos.x + flunc, pos.y, pos.z + 0.5, 0,0,0);
            living.level.addParticle(ParticleTypes.SOUL, pos.x + flunc, pos.y, pos.z - 0.5, 0,0,0);
        }
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }

}
