package com.joy187.re8joymod.init;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.blocks.virusgenerator.VirusGeneratorRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Main.MOD_ID);

    public static final RegistryObject<RecipeSerializer<VirusGeneratorRecipe>> VIRUS_GENERATOR_SERIALIZER =
            SERIALIZERS.register("virus_generator", () -> VirusGeneratorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}
