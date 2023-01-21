package com.joy187.re8joymod.common.init;


import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.recipe.VirusGeneratorRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeInit
{
    public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Utils.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> VIRUS_GENERATOR_SERIALIZER =
            SERIALIZERS.register("virus_generator", () -> VirusGeneratorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}