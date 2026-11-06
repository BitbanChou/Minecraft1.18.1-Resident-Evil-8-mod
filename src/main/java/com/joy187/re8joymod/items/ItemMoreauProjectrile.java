package com.joy187.re8joymod.items;


import com.joy187.re8joymod.Main;

import com.joy187.re8joymod.entity.DetonatorEntity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMoreauProjectrile extends Item {
    public ItemMoreauProjectrile(Properties properties) {
        super(properties);
    }

    
    public ItemMoreauProjectrile() {
    	super(new Properties().stacksTo(64));
    }
    
//    public DetonatorEntity createArrow(Level level, ItemStack stack, LivingEntity entityIn) {
//    	DetonatorEntity arrowentity = new DetonatorEntity(level, entityIn);
//        return arrowentity;
//    }
//    
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemMoreauProjectrile.class;
     }
    
//    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        ItemStack itemstack = player.getItemInHand(hand);
//        level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
//        if (!level.isClientSide) {
//           EntityMoreauProjectile bomb = new EntityMoreauProjectile(level, player);
//           bomb.setItem(itemstack);
//           bomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
//           level.addFreshEntity(bomb);
//        }
//
//        player.awardStat(Stats.ITEM_USED.get(this));
//        if (!player.getAbilities().instabuild) {
//           itemstack.shrink(1);
//        }
//
//        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
//     }
    
}