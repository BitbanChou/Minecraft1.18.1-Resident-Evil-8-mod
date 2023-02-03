package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities {

    @CapabilityInject(Scope.class)
    public static final Capability<Scope> SCOPE = null;

    @CapabilityInject(LivingExtension.class)
    public static final Capability<LivingExtension<?, ?>> LIVING_EXTENSION = null;

//    static {
//        CapabilityManager.INSTANCE.register(Scope.class, EmptyStorage.getInstance(),
//                Capabilities::unsupported);
//    }
}
