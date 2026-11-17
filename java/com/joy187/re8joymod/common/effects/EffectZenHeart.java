package com.joy187.re8joymod.common.effects;

import com.joy187.re8joymod.helper.CommonFunctions;
import net.minecraft.util.math.vector.Vector3d;import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.Random;

public class EffectZenHeart extends BaseEffect {

    public EffectZenHeart(EffectType type, int color, boolean isInstant) {
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
        for (int j = 0; j < 10; j++)
        {
            Vector3d pos = new Vector3d(living.position().x,living.position().y,living.position().z);
            Random random = living.getRandom();
            float flunc = (float) CommonFunctions.flunctate(0, 0.8, random);
            living.level.addParticle(ParticleTypes.DRAGON_BREATH, pos.x + 0.8, pos.y, pos.z + flunc, 0,0,0);
            living.level.addParticle(ParticleTypes.DRAGON_BREATH, pos.x - 0.8, pos.y, pos.z + flunc, 0,0,0);
            living.level.addParticle(ParticleTypes.DRAGON_BREATH, pos.x + flunc, pos.y, pos.z + 0.8, 0,0,0);
            living.level.addParticle(ParticleTypes.DRAGON_BREATH, pos.x + flunc, pos.y, pos.z - 0.8, 0,0,0);
            //living.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0,0,0);
        }
        //EntityUtil.spawnCubeParticleAround(living, ModParticles.Deadash,0.5);
        if(co!=4) living.heal(ran.nextFloat()*co);
    }

    @Override
    public boolean isBeneficial() {
        return true;
    }

    @SubscribeEvent
    public static void onCreatureHurt(LivingHurtEvent event) {
        World world = event.getEntity().level;
        LivingEntity hurtOne = event.getEntityLiving();

        if (event.isCanceled() || !event.getSource().isMagic())
        {
            return;
        }

        //Magic Damage Reduction
        Collection<EffectInstance> activePotionEffects = hurtOne.getActiveEffects();
        for (int i = 0; i < activePotionEffects.size(); i++) {
            EffectInstance buff = (EffectInstance)activePotionEffects.toArray()[i];
            if (buff.getEffect() instanceof EffectZenHeart)
            {
                EffectZenHeart modBuff = (EffectZenHeart)buff.getEffect();
                if (!world.isClientSide)
                {
                    float reduceRatio = modBuff.resistancePerLevel * (buff.getAmplifier());
                    event.setAmount(Math.max(1 - reduceRatio, 0f) * event.getAmount());
                }
            }
        }

    }
}