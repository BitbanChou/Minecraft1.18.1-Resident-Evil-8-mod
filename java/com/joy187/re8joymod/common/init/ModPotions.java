package com.joy187.re8joymod.common.init;


import com.joy187.re8joymod.Utils;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Utils.MOD_ID);

    public static final RegistryObject<Potion> BURN_POTION = POTIONS.register("burn_potion",
            () -> new Potion(new EffectInstance(ModEffects.BURN.get(), 200, 0)));

    public static final RegistryObject<Potion> DEADLY_POTION = POTIONS.register("deadly_potion",
            () -> new Potion(new EffectInstance(ModEffects.DEADLY.get(), 200, 0)));

    public static final RegistryObject<Potion> EROSION_POTION = POTIONS.register("erosion_potion",
            () -> new Potion(new EffectInstance(ModEffects.EROSION.get(), 200, 0)));

    public static final RegistryObject<Potion> ZENH_POTION = POTIONS.register("zenheart_potion",
            () -> new Potion(new EffectInstance(ModEffects.ZEN_HEART.get(), 200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}