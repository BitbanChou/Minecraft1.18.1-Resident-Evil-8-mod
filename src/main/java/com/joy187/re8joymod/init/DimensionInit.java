package com.joy187.re8joymod.init;

import com.joy187.re8joymod.Main;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
    public static final ResourceKey<Level> RE8_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Main.MOD_ID, "re8_dimension"));
    public static final ResourceKey<DimensionType> RE8_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE, RE8_KEY.location());

    public static void register() {
        System.out.println("Registering Resident Evil 8 Dimensions for " + Main.MOD_ID);
    }
}
