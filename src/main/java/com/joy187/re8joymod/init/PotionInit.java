package com.joy187.re8joymod.init;

import com.joy187.re8joymod.Main;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionInit {
    
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MOD_ID);

	public static final RegistryObject<Potion> BURN_POTION = POTIONS.register("burn_potion",
	    () -> new Potion(new MobEffectInstance(EffectInit.BURN.get(), 200, 0)));
	
	public static final RegistryObject<Potion> DEADLY_POTION = POTIONS.register("deadly_potion",
		    () -> new Potion(new MobEffectInstance(EffectInit.DEADLY.get(), 200, 0)));
	
	public static final RegistryObject<Potion> EROSION_POTION = POTIONS.register("erosion_potion",
		    () -> new Potion(new MobEffectInstance(EffectInit.EROSION.get(), 200, 0)));
	
	public static final RegistryObject<Potion> ZENH_POTION = POTIONS.register("zenheart_potion",
		    () -> new Potion(new MobEffectInstance(EffectInit.ZENHEART.get(), 200, 0)));
	
	public static void register(IEventBus eventBus) {
		POTIONS.register(eventBus);
	}
}
