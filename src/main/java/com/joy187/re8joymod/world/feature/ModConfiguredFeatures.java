package com.joy187.re8joymod.world.feature;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FANTOM_ORES = registerKey("fantom_ore");
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
//            DeferredRegister.create(Registry.DEFAULT, Main.MOD_ID);
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_TREE = registerKey("ebony");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldFantomOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                BlockInit.FANTOM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, BlockInit.DEEPSLATE_FANTOM_ORE.get().defaultBlockState()));

        register(context, FANTOM_ORES, Feature.ORE, new OreConfiguration(overworldFantomOres, 7));

        register(context, EBONY_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.EBONY_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),

                BlockStateProvider.simple(BlockInit.EBONY_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),

                new TwoLayersFeatureSize(1, 0, 2)).build());

    }


//    public static final RegistryObject<ConfiguredFeature<?, ?>> EBONY_TREE =
//            CONFIGURED_FEATURES.register("ebony", ()->
//                    new ConfiguredFeature<>(Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(BlockInit.EBONY_LOG.get()),
//                    new StraightTrunkPlacer(5, 6, 3),
//                    BlockStateProvider.simple(BlockInit.EBONY_LEAVES.get()),
//                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
//                    new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Main.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

//import com.google.common.base.Suppliers;
//import com.joy187.re8joymod.Main;
//import com.joy187.re8joymod.init.BlockInit;
//import com.joy187.re8joymod.config.ModCommonConfig;
//import net.minecraft.core.Holder;
//import net.minecraft.core.Registry;
//import net.minecraft.data.worldgen.features.FeatureUtils;
//import net.minecraft.data.worldgen.features.OreFeatures;
//import net.minecraft.data.worldgen.features.TreeFeatures;
//import net.minecraft.data.worldgen.placement.PlacementUtils;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.util.valueproviders.ConstantInt;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
//import net.minecraft.world.level.levelgen.feature.configurations.*;
//import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
//import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
//import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
//import net.minecraft.world.level.levelgen.placement.PlacedFeature;
//import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
//import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
//import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.RegistryObject;
//
//import java.util.List;
//import java.util.function.Supplier;
//
//public class ModConfiguredFeatures {
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
//            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Main.MOD_ID);
//
////    public static final RegistryObject<ConfiguredFeature<?, ?>> EBONY_TREE =
////            CONFIGURED_FEATURES.register("ebony", ()->
////                    new ConfiguredFeature<>(Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
////                    BlockStateProvider.simple(BlockInit.EBONY_LOG.get()),
////                    new StraightTrunkPlacer(5, 6, 3),
////                    BlockStateProvider.simple(BlockInit.EBONY_LEAVES.get()),
////                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
////                    new TwoLayersFeatureSize(1, 0, 2)).build()));
//
////    public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_ROSE = CONFIGURED_FEATURES.register("flower_pink_rose",
////            () -> new ConfiguredFeature<>(Feature.FLOWER,
////                    new RandomPatchConfiguration(8, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
////                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.PINK_ROSE.get()))))));
//
//
//    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_FANTOM_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), BlockInit.FANTOM_ORE.get().defaultBlockState()),
//            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockInit.DEEPSLATE_FANTOM_ORE.get().defaultBlockState())));
//
//
//    public static final RegistryObject<ConfiguredFeature<?, ?>> FANTOM_ORES = CONFIGURED_FEATURES.register("fantom_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_FANTOM_ORES.get(),7)));
//
//    public static void register(IEventBus eventBus) {
//        CONFIGURED_FEATURES.register(eventBus);
//    }
//
//}
