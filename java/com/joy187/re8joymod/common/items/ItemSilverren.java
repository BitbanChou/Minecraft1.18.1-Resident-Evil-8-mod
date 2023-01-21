package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.CustomItemTier;
import com.joy187.re8joymod.common.entity.*;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;


public class ItemSilverren extends SwordItem {
    public ItemSilverren() {
        super(CustomItemTier.TOOL_SILIVERBLADE,10,-1,new Item.Properties().tab(RegistryEvents.RE8GROUP));
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof EntityBela || target instanceof EntityCassandra || target instanceof EntityDaniela || target instanceof EntityRe8Dimi
            || target instanceof EntityBeibaby || target instanceof EntityLycan1 || target instanceof WitherEntity) {
            attacker.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 30, 10, false, true));
        }
        return true;
    }


}