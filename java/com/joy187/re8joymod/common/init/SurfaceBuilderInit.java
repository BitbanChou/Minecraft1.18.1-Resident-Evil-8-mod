package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.world.surface.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Utils.MOD_ID);

    public static final RegistryObject<WasteLandSurfaceBuilder> EXAMPLE_SURFACE_BUILDER = SURFACE_BUILDERS.register("re8_wasteland",
            () -> new WasteLandSurfaceBuilder(SurfaceBuilderConfig.CODEC));

    public static final RegistryObject<DesertSurfaceBuilder> EXAMPLE_SURFACE_BUILDER2 = SURFACE_BUILDERS.register("re8_edesert_biome",
            () -> new DesertSurfaceBuilder(SurfaceBuilderConfig.CODEC));

    public static final RegistryObject<ForestSurfaceBuilder> EXAMPLE_SURFACE_BUILDER3 = SURFACE_BUILDERS.register("re8_eforest_biome",
            () -> new ForestSurfaceBuilder(SurfaceBuilderConfig.CODEC));
    public static final RegistryObject<HillsSurfaceBuilder> EXAMPLE_SURFACE_BUILDER4 = SURFACE_BUILDERS.register("re8_ehills_biome",
            () -> new HillsSurfaceBuilder(SurfaceBuilderConfig.CODEC));
    public static final RegistryObject<ValleySurfaceBuilder> EXAMPLE_SURFACE_BUILDER5 = SURFACE_BUILDERS.register("re8_evalley_biome",
            () -> new ValleySurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
