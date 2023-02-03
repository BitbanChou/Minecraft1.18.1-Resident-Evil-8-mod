package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityBOWShoot;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemBOWShoot extends Item {
    public ItemBOWShoot() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(8));
    }

    public EntityBOWShoot createArrow(World p_200887_1_, ItemStack p_200887_2_, LivingEntity p_200887_3_) {
        EntityBOWShoot arrowentity = new EntityBOWShoot(p_200887_1_, p_200887_3_);
        return arrowentity;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemBOWShoot.class;
    }
}