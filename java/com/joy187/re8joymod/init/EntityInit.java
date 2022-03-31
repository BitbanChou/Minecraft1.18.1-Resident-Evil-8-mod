package com.joy187.re8joymod.init;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRe8Dimi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Main.MOD_ID);

//	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
//			() -> new Item(new Item.Properties().tab(Main.TUTORIAL_TAB)));
//
//	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
//		return ITEMS.register(name, item);
//	}
    public static final RegistryObject<EntityType<EntityRe8Dimi>> RE8DIMI = ENTITY_TYPES.register("re8dimi",
            () -> EntityType.Builder.of(EntityRe8Dimi::new, MobCategory.MONSTER).sized(0.8f,3.0f).setTrackingRange(30)
                    .build(new ResourceLocation(Main.MOD_ID, "re8dimi").toString()));
    

}