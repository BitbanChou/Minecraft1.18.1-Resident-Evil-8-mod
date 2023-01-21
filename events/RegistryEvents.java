package com.joy187.re8joymod.events;

import com.joy187.re8joymod.Main;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    public static final Logger LOGGER = Main.LOGGER;
    public static final String MOD_ID = "re8joymod";
    public static final ItemGroup RE8GROUP = Main.RE8Group;


}
