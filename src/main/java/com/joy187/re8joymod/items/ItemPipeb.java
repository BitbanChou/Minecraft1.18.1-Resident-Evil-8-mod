package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;

import com.joy187.re8joymod.entity.EntityPipeb;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ItemPipeb extends Item{
	public ItemPipeb(Properties properties) {
	    super(properties);
	}
	
	
	public ItemPipeb() {
		super(new Properties().stacksTo(16));
	}
	

	public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
	    int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
	    return enchant <= 0 ? false : this.getClass() == ItemPipeb.class;
	 }
	
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
	    ItemStack itemstack = player.getItemInHand(hand);
	    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIREWORK_ROCKET_SHOOT, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
	    if (!level.isClientSide) {
	       EntityPipeb bomb = new EntityPipeb(level, player);
	       bomb.setItem(itemstack);
	       bomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
	       level.addFreshEntity(bomb);
	    }
	
	    player.awardStat(Stats.ITEM_USED.get(this));
	    if (!player.getAbilities().instabuild) {
	       itemstack.shrink(1);
	    }
	
	    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	 }
}
