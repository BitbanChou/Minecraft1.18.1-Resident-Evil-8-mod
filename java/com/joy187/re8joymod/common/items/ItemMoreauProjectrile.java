package com.joy187.re8joymod.common.items;


import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMoreauProjectrile extends Item {
    public ItemMoreauProjectrile(Properties properties) {
        super(properties);
    }


    public ItemMoreauProjectrile() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(64));
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
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