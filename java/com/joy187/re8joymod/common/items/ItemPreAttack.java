package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.CustomItemTier;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ItemPreAttack extends SwordItem {
    public ItemPreAttack() {
        super(CustomItemTier.PreciseAttack,1000000001,-2,new Item.Properties().tab(RegistryEvents.RE8GROUP));
    }
}