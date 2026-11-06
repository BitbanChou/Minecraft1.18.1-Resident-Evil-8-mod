package com.joy187.re8joymod.world.poi;

import com.google.common.collect.ImmutableSet;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.blocks.BlockRe8Portal;
import com.joy187.re8joymod.init.BlockInit;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

//public class ModPois {
//    public static final DeferredRegister<PoiType> POI
//            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Main.MOD_ID);
//
//
//    public static final RegistryObject<PoiType> RE8_PORTAL = POI.register("re8_portal",
//            () -> new PoiType(ImmutableSet.copyOf(BlockInit.RE8_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
//
//    public static final RegistryObject<PoiType> VIRUS_POI = POI.register("virus_generator_poi",
//            () -> new PoiType(ImmutableSet.copyOf(BlockInit.EXAMPLE_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 2));
//
//
//    public static void register(IEventBus eventBus) {
//        POI.register(eventBus);
//    }
//}