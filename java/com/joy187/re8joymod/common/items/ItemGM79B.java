package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityGM79B;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class ItemGM79B extends Item {
    public ItemGM79B() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(8));
    }

    public EntityGM79B createArrow(World p_200887_1_, ItemStack p_200887_2_, LivingEntity p_200887_3_) {
        EntityGM79B arrowentity = new EntityGM79B(p_200887_1_, p_200887_3_);
        return arrowentity;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ItemGM79B.class;
    }


//    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        ItemStack itemstack = playerIn.getItemInHand(handIn);
//        worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
//        if (!worldIn.isClientSide) {
//            EntityGM79B snowballentity = new EntityGM79B(worldIn, playerIn);
//            snowballentity.setItem(itemstack);
//            snowballentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 1.5F, 1.0F);
//            worldIn.addFreshEntity(snowballentity);
//        }
//
//        playerIn.awardStat(Stats.ITEM_USED.get(this));
//        if (!playerIn.abilities.instabuild) {
//            itemstack.shrink(1);
//        }
//
//        return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
//    }
}
