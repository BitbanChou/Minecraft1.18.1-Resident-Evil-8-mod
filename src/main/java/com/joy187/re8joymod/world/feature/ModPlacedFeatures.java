package com.joy187.re8joymod.world.feature;

import com.joy187.re8joymod.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FANTOM_ORES_PLACED_KEY = registerKey("fantom_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, FANTOM_ORES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FANTOM_ORES),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(60))));

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Main.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

//import com.joy187.re8joymod.Main;
//import net.minecraft.core.Holder;
//import net.minecraft.core.Registry;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.data.worldgen.placement.VegetationPlacements;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.levelgen.VerticalAnchor;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.placement.*;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//import java.util.List;
//
//import static com.joy187.re8joymod.world.feature.ModOrePlacement.commonOrePlacement;
//
//public class ModPlacedFeatures {
//
////    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
////            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Main.MOD_ID);
//    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(ForgeRegistries.,
//            Main.MOD_ID);
//
////    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("panic_rose_placed",
////            ModConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16),
////            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
//
//
//
//    public static final RegistryObject<PlacedFeature> PINK_ROSE_PLACED = PLACED_FEATURES.register("pink_rose_placed",
//            () -> new PlacedFeature(ModConfiguredFeatures.PINK_ROSE.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(16),
//                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
//
////    public static final RegistryObject<PlacedFeature> PINK_ROSE_PLACED = PLACED_FEATURES.register("red_maple_placed",
////            () -> new PlacedFeature(ModConfiguredFeatures.RED_MAPLE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
////                    PlacementUtils.countExtra(3, 0.1f, 2))));
////
//
////    public static final Holder<PlacedFeature> FANTOM_ORE_PLACED = PlacementUtils.register("fantom_ore_placed",
////            ModConfiguredFeatures.FANTOM_ORE, commonOrePlacement(
////            		ModCommonConfig.FANTOM_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
////                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-30), VerticalAnchor.aboveBottom(30))));
//
////    public static final Holder<PlacedFeature> END_CITRINE_ORE_PLACED = PlacementUtils.register("end_citrine_ore_placed",
////            ModConfiguredFeatures.END_CITRINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
////                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
////
////    public static final Holder<PlacedFeature> NETHER_CITRINE_ORE_PLACED = PlacementUtils.register("nether_citrine_ore_placed",
////            ModConfiguredFeatures.NETHER_CITRINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
////                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
//
//
//    public static final RegistryObject<PlacedFeature> FANTOM_ORE_PLACED = PLACED_FEATURES.register("fantom_ore_placed",
//            () -> new PlacedFeature(ModConfiguredFeatures.FANTOM_ORES.getHolder().get(),
//                    commonOrePlacement(7,
//                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60), VerticalAnchor.aboveBottom(60))))); //-60，60分别指矿石生成高度范围介于[-60,60]
//
//    public static void register(IEventBus eventBus) {
//        PLACED_FEATURES.register(eventBus);
//    }
//}
