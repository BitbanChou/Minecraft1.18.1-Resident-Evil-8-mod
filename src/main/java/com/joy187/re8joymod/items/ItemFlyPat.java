package com.joy187.re8joymod.items;

import com.joy187.re8joymod.entity.*;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ItemFlyPat extends SwordItem{
    private final int maxUses;
    public ItemFlyPat(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
        this.maxUses = toolMaterial.getUses();
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof EntityBela || target instanceof EntityCassandra || target instanceof EntityDaniela || target instanceof EntityRe8Dimi || target instanceof EntityFly || target instanceof EntityDimi2) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 3, 3, false, true));
            attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 3, 8, false, true));
        }
        return true;
    }
}
