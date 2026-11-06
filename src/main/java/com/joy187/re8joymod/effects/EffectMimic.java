package com.joy187.re8joymod.effects;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;


public class EffectMimic extends BaseEffect {
    public EffectMimic(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 2 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        if(living instanceof Mob)
        {
            if(((Mob) living).getTarget() instanceof Player)
            {
                ((Mob) living).setTarget(null);
            }
        }

    }

    @Override
    public boolean isBeneficial()
    {
        return true;
    }
}
