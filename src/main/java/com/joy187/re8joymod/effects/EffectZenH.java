package com.joy187.re8joymod.effects;

import java.util.Collection;
import java.util.Random;

import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EffectZenH extends BaseEffect{

    public EffectZenH(MobEffectCategory type, int color, boolean isInstant) {
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
            Vec3 pos = new Vec3(living.position().x,living.position().y,living.position().z);
            Random random = new Random();
            float flunc = (float) CommonFunctions.flunctate(0, 0.8, random);
            living.level().addParticle(ParticleTypes.DRAGON_BREATH, pos.x + 0.8, pos.y, pos.z + flunc, 0,0,0);
            living.level().addParticle(ParticleTypes.DRAGON_BREATH, pos.x - 0.8, pos.y, pos.z + flunc, 0,0,0);
            living.level().addParticle(ParticleTypes.DRAGON_BREATH, pos.x + flunc, pos.y, pos.z + 0.8, 0,0,0);
            living.level().addParticle(ParticleTypes.DRAGON_BREATH, pos.x + flunc, pos.y, pos.z - 0.8, 0,0,0);
            //living.level().addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0,0,0);
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
	      Level world = event.getEntity().level();
	      LivingEntity hurtOne = event.getEntity();

	        if (event.isCanceled() || !event.getSource().is(DamageTypes.MAGIC))
	        {
	            return;
	        }

	        //Magic Damage Reduction
	        Collection<MobEffectInstance> activePotionEffects = hurtOne.getActiveEffects();
	        for (int i = 0; i < activePotionEffects.size(); i++) {
	            MobEffectInstance buff = (MobEffectInstance)activePotionEffects.toArray()[i];
	            if (buff.getEffect() instanceof EffectZenH)
	            {
	            	EffectZenH modBuff = (EffectZenH)buff.getEffect();
	                if (!world.isClientSide)
	                {
	                    float reduceRatio = modBuff.resistancePerLevel * (buff.getAmplifier());
	                    event.setAmount(Math.max(1 - reduceRatio, 0f) * event.getAmount());
	                }
	            }
	        }

	 }
}
