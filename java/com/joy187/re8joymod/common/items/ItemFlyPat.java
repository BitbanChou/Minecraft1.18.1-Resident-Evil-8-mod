package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.CustomItemTier;
import com.joy187.re8joymod.common.entity.EntityBela;
import com.joy187.re8joymod.common.entity.EntityCassandra;
import com.joy187.re8joymod.common.entity.EntityDaniela;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemFlyPat extends ItemSword{
    private final int maxUses;
    public ItemFlyPat(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
        this.maxUses = toolMaterial.getUses();
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof EntityBela || target instanceof EntityCassandra || target instanceof EntityDaniela || target instanceof EntityRe8Dimi) {
            target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20 * 3, 3, false, true));
            attacker.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20 * 3, 8, false, true));
        }
        return true;
    }

}
