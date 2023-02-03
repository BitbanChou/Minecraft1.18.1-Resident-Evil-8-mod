package com.joy187.re8joymod.common.init;


import com.joy187.re8joymod.Utils;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPOIs {
    public static final DeferredRegister<PointOfInterestType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, Utils.MOD_ID);

//    public static final RegistryObject<PointOfInterestType> RE8_PORTAL =
//            POI.register("re8_portal", () -> new PointOfInterestType("re8_portal",
//                    PointOfInterestType.getBlockStates(ModBlocks.RE8_PORTAL.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}