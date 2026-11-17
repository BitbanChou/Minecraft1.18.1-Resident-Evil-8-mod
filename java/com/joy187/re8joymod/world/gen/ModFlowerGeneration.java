package com.joy187.re8joymod.common.world.gen;

import com.joy187.re8joymod.common.init.BiomeInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModFlowerGeneration {
    public static void generateFlowers(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);


//        if (types.contains(BiomeDictionary.Type.HILLS)) {
//            List<Supplier<ConfiguredFeature<?, ?>>> base =
//                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
//
//            //base.add(() -> ModConfiguredFeatures.DESOLATE_GRASS_BLOCK_CONFIG);
//            base.add(() -> ModConfiguredFeatures.EBONY);
//
//        }

        if (key.equals(BiomeInit.RE8_FOREST_BIOME)) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.TOP_LAYER_MODIFICATION);
            base.add(() -> ModConfiguredFeatures.EBONY);
            base.add(() -> Features.OAK);

        }
    }
}
