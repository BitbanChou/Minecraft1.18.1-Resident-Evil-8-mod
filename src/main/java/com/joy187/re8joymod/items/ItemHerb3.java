package com.joy187.re8joymod.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ItemHerb3 extends ItemNameBlockItem {

    public ItemHerb3(Block p_41579_, Properties p_41580_) {
        super(p_41579_, p_41580_);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.herb3"));
    }

}
