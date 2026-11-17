package com.joy187.re8joymod.common.world.gen;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.world.structure.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class ModConfiguredStructures {
    /**
     * Static instance of our structure so we can reference it and add it to biomes easily.
     */
    public static StructureFeature<?, ?> CONFIGURED_TANK1_HOUSE = ModStructures.TANK1.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_CASTLE_HOUSE = ModStructures.CASTLE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_FACT_HOUSE = ModStructures.FACT.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_CHURCH_HOUSE = ModStructures.CHURCH.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_GRAVEY_HOUSE = ModStructures.GRAVEY.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_EHOUSE_HOUSE = ModStructures.EHOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_BENEHOUSE_HOUSE = ModStructures.BENEHOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_VI_HOUSE = ModStructures.VI.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_LAB_HOUSE = ModStructures.LAB.get().configured(IFeatureConfig.NONE);

    /**
     * Registers the configured structure which is what gets added to the biomes.
     * Noticed we are not using a forge registry because there is none for configured structures.
     *
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in FMLCommonSetupEvent.
     */
    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;


        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_tank1_house"), CONFIGURED_TANK1_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_castle_house"), CONFIGURED_CASTLE_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_fact_house"), CONFIGURED_FACT_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_church_house"), CONFIGURED_CHURCH_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_gravey_house"), CONFIGURED_GRAVEY_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_ehouse_house"), CONFIGURED_EHOUSE_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_benehouse_house"), CONFIGURED_BENEHOUSE_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_vi_house"), CONFIGURED_VI_HOUSE);
        Registry.register(registry, new ResourceLocation(Utils.MOD_ID, "configured_lab_house"), CONFIGURED_LAB_HOUSE);

        /* Ok so, this part may be hard to grasp but basically, just add your structure to this to
         * prevent any sort of crash or issue with other mod's custom ChunkGenerators. If they use
         * FlatGenerationSettings.STRUCTURE_FEATURES in it and you don't add your structure to it, the game
         * could crash later when you attempt to add the StructureSeparationSettings to the dimension.
         *
         * (It would also crash with superflat worldtype if you omit the below line
         * and attempt to add the structure's StructureSeparationSettings to the world)
         *
         * Note: If you want your structure to spawn in superflat, remove the FlatChunkGenerator check
         * in StructureTutorialMain.addDimensionalSpacing and then create a superflat world, exit it,
         * and re-enter it and your structures will be spawning. I could not figure out why it needs
         * the restart but honestly, superflat is really buggy and shouldn't be your main focus in my opinion.
         *
         * Requires AccessTransformer ( see resources/META-INF/accesstransformer.cfg )
         */
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.TANK1.get(), CONFIGURED_TANK1_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.CASTLE.get(), CONFIGURED_CASTLE_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.FACT.get(), CONFIGURED_FACT_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.CHURCH.get(), CONFIGURED_CHURCH_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.GRAVEY.get(), CONFIGURED_GRAVEY_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.EHOUSE.get(), CONFIGURED_EHOUSE_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.BENEHOUSE.get(), CONFIGURED_BENEHOUSE_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.VI.get(), CONFIGURED_VI_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.LAB.get(), CONFIGURED_LAB_HOUSE);

    }
}
