package com.joy187.re8joymod.common.world.gen;

import com.joy187.re8joymod.common.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {
//    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD =
//            register("redwood", Feature.TREE.withConfiguration((
//                    new BaseTreeFeatureConfig.Builder(
//                            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),
//                            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),
//                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
//                            new StraightTrunkPlacer(6, 4, 3),
//                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

//    public static final ConfiguredFeature<?, ?> DESOLATE_GRASS_BLOCK_CONFIG = Feature.FLOWER.configured((
//            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DESOLATE_GRASS_BLOCK.get().defaultBlockState()),
//                    SimpleBlockPlacer.INSTANCE)).tries(6).build()).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(3);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EBONY = register("ebony", Feature.TREE.configured((
            new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.EBONY_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(ModBlocks.EBONY_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                    new StraightTrunkPlacer(4, 2, 3), new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DARKOAK = register("darkoak", Feature.TREE.configured((
            new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(Blocks.OAK_LEAVES.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 2),
                    new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(1, 0, 0))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DARKOAKOAK = register("darkoak", Feature.TREE.configured((
            new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.defaultBlockState()),
                    new SimpleBlockStateProvider(Blocks.DARK_OAK_LOG.defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 2),
                    new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(1, 0, 0))).ignoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> TALL_EBONY = register("tallebony", Feature.TREE.configured((
            new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.EBONY_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(ModBlocks.EBONY_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.of(3,5), FeatureSpread.of(2,4), 5),
                    new StraightTrunkPlacer(10, 12, 20), new TwoLayerFeature(11, 10, 12))).ignoreVines().build()));


    public static final ConfiguredFeature<?, ?> FANTOM_ORE_PLACED = register("fantom_ore_placed", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
            ModBlocks.FANTOM_ORE.get().defaultBlockState(), 8)).range(16).squared());


//    public static final ConfiguredFeature<?, ?> ORE_GOLD = register("ore_gold",
//            Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Features.States.GOLD_ORE, 9)).range(32).squared().count(2));

}
