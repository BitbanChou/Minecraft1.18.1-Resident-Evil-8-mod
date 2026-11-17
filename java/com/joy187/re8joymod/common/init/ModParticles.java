package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.common.particles.ParticleMycete;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles extends ParticleManager {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "re8joymod");


//    public static RegistryObject<ParticleType<?>> EROSION = PARTICLES.register("deadly", () ->
//    {
//        return new ParticleMycete();
//    });


    public ModParticles(ClientWorld worldIn, TextureManager tex) {
        super(worldIn, tex);
        this.registerProviders();
    }

    private void registerProviders() {
        this.register(ModParticleTypes.MYCETE1, ParticleMycete.Factory::new);
    }

}
