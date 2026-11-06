package com.joy187.re8joymod.init;

import com.google.common.collect.ImmutableSet;
import com.joy187.re8joymod.Main;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillageInit {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Main.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Main.MOD_ID);


    public static final RegistryObject<PoiType> VIRUS_POI = POI_TYPES.register("virus_generator_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockInit.EXAMPLE_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 2));

    public static final RegistryObject<VillagerProfession> DUKE = VILLAGER_PROFESSIONS.register("duker",
            () -> new VillagerProfession("duker", x -> x.get() == VIRUS_POI.get(), x -> x.get() == VIRUS_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
