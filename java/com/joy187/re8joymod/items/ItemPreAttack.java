package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class ItemPreAttack extends SwordItem{
    public ItemPreAttack() {
        super(CustomItemTier.PreciseAttack,1000000001,-2,new Item.Properties().tab(Main.TUTORIAL_TAB));
    }
}
