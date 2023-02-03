package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Utils.MOD_ID);

    // Add more biomes here!
    static {
        createBiome("re8_biome", BiomeMaker::theVoidBiome);
        createBiome("re8_edesert_biome", BiomeMaker::theVoidBiome);
        createBiome("re8_eforest_biome", BiomeMaker::crimsonForestBiome);
        createBiome("re8_ehills_biome", BiomeMaker::soulSandValleyBiome);
        createBiome("re8_evalley_biome", BiomeMaker::theVoidBiome);

    }
//mountainBiome(1.0F, 0.5F,ConfiguredSurfaceBuilders.MOUNTAIN, false));

//    public static final BiomeDictionary.Type RE8WASTELAND = BiomeDictionary.Type.getType("RE8LAND");

//    BiomeDictionary.addTypes(BiomeInit.RE8_BIOME);

    // (and also here!)
    public static RegistryKey<Biome> RE8_WASTELAND_BIOME = registerBiome("re8_biome");
    public static RegistryKey<Biome> RE8_EDESERT_BIOME = registerBiome("re8_edesert_biome");
    public static RegistryKey<Biome> RE8_FOREST_BIOME = registerBiome("re8_eforest_biome");
    public static RegistryKey<Biome> RE8_EHILLS_BIOME = registerBiome("re8_ehills_biome");
    public static RegistryKey<Biome> RE8_EVALLEY_BIOME = registerBiome("re8_evalley_biome");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Utils.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }

//    public static RegistryObject<Biome> createBiome(String biomeName, Biome biome) {
//        return BIOMES.register(biomeName, biome);
//    }

    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RE8_WASTELAND_BIOME, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RE8_EDESERT_BIOME, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RE8_FOREST_BIOME, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RE8_EHILLS_BIOME, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(RE8_EVALLEY_BIOME, 0));

    }

//    public static void addBiomeTypes() {
//        BiomeDictionary.addTypes(RE8_BIOME, RE8WASTELAND , BiomeDictionary.Type.PLAINS);
//    }
   public static Biome basaltDeltasBiome() {
        MobSpawnInfo mobspawninfo = (new MobSpawnInfo.Builder()).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.GHAST, 40, 1, 1)).addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.MAGMA_CUBE, 100, 2, 5)).addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.STRIDER, 60, 1, 2)).build();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.BASALT_DELTAS).addStructureStart(StructureFeatures.RUINED_PORTAL_NETHER).addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE).addStructureStart(StructureFeatures.NETHER_BRIDGE).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.DELTA).addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA_DOUBLE).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.SMALL_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Features.LARGE_BASALT_COLUMNS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BASALT_BLOBS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BLACKSTONE_BLOBS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_DELTA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_FIRE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.PATCH_SOUL_FIRE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE_EXTRA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.GLOWSTONE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.BROWN_MUSHROOM_NETHER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.RED_MUSHROOM_NETHER).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_MAGMA).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.SPRING_CLOSED_DOUBLE).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_GOLD_DELTAS).addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Features.ORE_QUARTZ_DELTAS);
        DefaultBiomeFeatures.addAncientDebris(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.NETHER).depth(0.1F).scale(0.2F).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(4341314).fogColor(6840176).skyColor(calculateSkyColor(2.0F)).ambientParticle(new ParticleEffectAmbience(ParticleTypes.WHITE_ASH, 0.118093334F)).ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP).ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD, 6000, 8, 2.0D)).ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, 0.0111D)).backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS)).build()).mobSpawnSettings(mobspawninfo).generationSettings(biomegenerationsettings$builder.build()).build();
    }

    private static int calculateSkyColor(float p_244206_0_) {
        float lvt_1_1_ = p_244206_0_ / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

}
