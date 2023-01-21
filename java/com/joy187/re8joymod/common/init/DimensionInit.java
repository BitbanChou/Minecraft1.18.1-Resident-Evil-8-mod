package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class DimensionInit {

    public static final RegistryKey<World> RE8_DIMENSTON_WORLD  = RegistryKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(RegistryEvents.MOD_ID,"re8_dimension"));
}

//public class DimensionInit {
////    public static final RegistryKey<World> RE8_DIMENSTON_WORLD = RegistryKey.create(Registry.DIMENSION_REGISTRY,
////            new ResourceLocation(Utils.MOD_ID,"re8_dimension"));
//
//    public static final RegistryKey<World> RE8_DIMENSTON_WORLD = createRegistryKey(new ResourceLocation(Utils.MOD_ID,"re8_dimension"));
//}
