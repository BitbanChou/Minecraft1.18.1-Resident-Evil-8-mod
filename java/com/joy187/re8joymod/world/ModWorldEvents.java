package com.joy187.re8joymod.common.world;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.world.gen.ModFlowerGeneration;
import com.joy187.re8joymod.common.world.gen.ModOreGeneration;
import com.joy187.re8joymod.common.world.gen.ModStructureGeneration;
import com.joy187.re8joymod.common.world.gen.ModTreeGeneration;
import com.joy187.re8joymod.common.world.structure.ModStructures;
import com.mojang.serialization.Codec;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class ModWorldEvents {

      //StructureTutorialMain.java

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModStructureGeneration.generateStructures(event);

        ModOreGeneration.generateOres(event);
        ModFlowerGeneration.generateFlowers(event);
        ModTreeGeneration.generateTrees(event);
    }

    @SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();

            try {
                Method GETCODEC_METHOD =
                        ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                 ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey(
                        (Codec<? extends ChunkGenerator>)GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));

                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) {
                    return;
                }
            } catch (Exception e) {
                LogManager.getLogger().error("Was unable to check if " + serverWorld.getLevel()
                        + " is using Terraforged's ChunkGenerator.");
            }

            // Prevent spawning our structure in Vanilla's superflat world
            if (serverWorld.getChunkSource().generator instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)) {
                return;
            }

            // Adding our Structure to the Map
            Map<Structure<?>, StructureSeparationSettings> tempMap =
                    new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(ModStructures.TANK1.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.TANK1.get()));
            tempMap.putIfAbsent(ModStructures.CASTLE.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.CASTLE.get()));
            tempMap.putIfAbsent(ModStructures.FACT.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.FACT.get()));
            tempMap.putIfAbsent(ModStructures.CHURCH.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.CHURCH.get()));
            tempMap.putIfAbsent(ModStructures.GRAVEY.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.GRAVEY.get()));
            tempMap.putIfAbsent(ModStructures.EHOUSE.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.EHOUSE.get()));
            tempMap.putIfAbsent(ModStructures.BENEHOUSE.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.BENEHOUSE.get()));
            tempMap.putIfAbsent(ModStructures.VI.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.VI.get()));
            tempMap.putIfAbsent(ModStructures.LAB.get(),
                    DimensionStructuresSettings.DEFAULTS.get(ModStructures.LAB.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }

}