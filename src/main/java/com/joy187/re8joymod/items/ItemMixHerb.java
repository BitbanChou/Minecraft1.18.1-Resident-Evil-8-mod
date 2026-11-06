package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMixHerb extends ItemXiShouYe{

    public ItemMixHerb(){
        super();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);

        playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 2, false, true));

        itemstack.shrink(1);
        return InteractionResultHolder.consume(itemstack);
    }
}
