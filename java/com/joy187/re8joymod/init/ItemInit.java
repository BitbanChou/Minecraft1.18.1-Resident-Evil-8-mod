package com.joy187.re8joymod.init;


import com.google.common.base.Supplier;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.ItemPreAttack;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Main.MOD_ID);

	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
			() -> new Item(new Item.Properties().tab(Main.TUTORIAL_TAB)));
	
    public static RegistryObject<Item> PREATTACK = register("preciseattack",()->
    {
        return new ItemPreAttack();
    });
	
    public static final RegistryObject<Item> THIEF_EGG = ITEMS.register("re8dimi_spawn_egg", 
    		() -> new ForgeSpawnEggItem(EntityInit.RE8DIMI, 9577503, 13423070, new Item.Properties().tab(Main.TUTORIAL_TAB)));

    
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
		
}
