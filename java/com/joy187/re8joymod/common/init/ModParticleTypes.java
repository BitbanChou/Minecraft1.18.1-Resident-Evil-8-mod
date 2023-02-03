package com.joy187.re8joymod.common.init;

import com.mojang.serialization.Codec;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class ModParticleTypes {
    //public static final BasicParticleType MYCETE1 = register("deadly", false);
    public static final ParticleType<RedstoneParticleData> MYCETE1 = register("deadly", RedstoneParticleData.DESERIALIZER, (p_239822_0_) -> {
        return RedstoneParticleData.CODEC;
    });


    private static BasicParticleType register(String p_218415_0_, boolean p_218415_1_) {
        return Registry.register(Registry.PARTICLE_TYPE, p_218415_0_, new BasicParticleType(p_218415_1_));
    }

    private static <T extends IParticleData> ParticleType<T> register(String p_218416_0_, IParticleData.IDeserializer<T> p_218416_1_, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
        return Registry.register(Registry.PARTICLE_TYPE, p_218416_0_, new ParticleType<T>(false, p_218416_1_) {
            public Codec<T> codec() {
                return p_218416_2_.apply(this);
            }
        });
    }
}
