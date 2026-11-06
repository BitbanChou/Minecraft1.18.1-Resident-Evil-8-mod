package com.joy187.re8joymod.init;

import com.joy187.re8joymod.Main;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleInit {

    public static final DeferredRegister<ParticleType<?>> PARTICLE =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Main.MOD_ID);

    public static final RegistryObject<SimpleParticleType> MUCUS_PARTICLE =
            PARTICLE.register("mucus_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> DEFEND_PARTICLE =
            PARTICLE.register("defend_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> FLAME_PARTICLE =
            PARTICLE.register("flame_particle", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLE.register(eventBus);
    }
	
}
