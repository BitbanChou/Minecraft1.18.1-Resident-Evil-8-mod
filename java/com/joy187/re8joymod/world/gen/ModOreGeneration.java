package com.joy187.re8joymod.common.world.gen;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.function.Supplier;

public class ModOreGeneration {
        public static void generateOres(final BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModConfiguredFeatures.FANTOM_ORE_PLACED);

//        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
//            base.add(ModPlacedFeatures.END_CITRINE_ORE_PLACED);
//        }
//
//        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
//            base.add(ModPlacedFeatures.NETHER_CITRINE_ORE_PLACED);
//        }
        }


}
