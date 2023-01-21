package com.joy187.re8joymod.common.world.gen;

import com.joy187.re8joymod.common.init.BiomeInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class ModStructureGeneration {
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(key.equals(BiomeInit.RE8_EDESERT_BIOME)){
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_TANK1_HOUSE);
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_FACT_HOUSE);
        }
        if(key.equals(BiomeInit.RE8_FOREST_BIOME)){
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_GRAVEY_HOUSE);
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_EHOUSE_HOUSE);
        }
        if(key.equals(BiomeInit.RE8_EHILLS_BIOME)){
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_BENEHOUSE_HOUSE);
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_LAB_HOUSE);
        }
        if(key.equals(BiomeInit.RE8_EVALLEY_BIOME)){
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_CASTLE_HOUSE);
            //event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_EHOUSE_HOUSE);
        }
        if(key.equals(BiomeInit.RE8_WASTELAND_BIOME)){
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_CHURCH_HOUSE);
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_VI_HOUSE);
        }
        // || types.contains(BiomeInit.RE8WASTELAND)
//        if(types.contains(BiomeDictionary.Type.PLAINS)) {
//
////            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();
//            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_TANK1_HOUSE);
//            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_CASTLE_HOUSE);
////            structures.add(() -> ModConfiguredStructures.CONFIGURED_TANK1_HOUSE);
//            //structures.add(() -> ModStructures.TANK1.get().configured(IFeatureConfig.NONE));
//        }
//        if(types.contains(BiomeDictionary.Type.SANDY) || types.contains(BiomeDictionary.Type.WASTELAND))
//        {
//            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_FACT_HOUSE);
//        }
//        if(types.contains(BiomeDictionary.Type.PLAINS) || types.contains(BiomeDictionary.Type.WASTELAND))
//        {
//            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_CHURCH_HOUSE);
//        }
        if(types.contains(BiomeDictionary.Type.SAVANNA) || types.contains(BiomeDictionary.Type.COLD))
        {
            event.getGeneration().getStructures().add(() -> ModConfiguredStructures.CONFIGURED_LAB_HOUSE);
        }
    }
}
