package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.screen.VirusGeneratorMenu;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class MenuInit {
    public static final DeferredRegister<ContainerType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Utils.MOD_ID);

    public static final RegistryObject<ContainerType<VirusGeneratorMenu>> VIRUS_GENERATOR_MENU =
            registerMenuType(VirusGeneratorMenu::new, "virus_generator_menu");



    private static <T extends Container>RegistryObject<ContainerType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                          String name) {
        return MENUS.register(name, () -> IForgeContainerType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
