package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBOWShoot;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;


public class ItemBOWShoot extends Item{

	   public ItemBOWShoot(Properties name) {
	        super(name);
	    }
	    
	    public ItemBOWShoot() {
	        super(new Properties().stacksTo(16));
	    }
	    
	    public EntityBOWShoot createArrow(Level level, ItemStack stack, LivingEntity entityIn) {
	        EntityBOWShoot arrowentity = new EntityBOWShoot(level, entityIn);
	        return arrowentity;
	    }

	    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
	        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
	        return enchant <= 0 ? false : this.getClass() == ItemBOWShoot.class;
	     }
}