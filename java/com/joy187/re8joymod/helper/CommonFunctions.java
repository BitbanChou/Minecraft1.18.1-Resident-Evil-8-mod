package com.joy187.re8joymod.helper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;


public class CommonFunctions {

    public static double sq3 = 1.732;

    public static double flunctate(double ori, double radius, Random random) {
        return ori + (random.nextFloat() * 2 - 1) * radius;
    }

    public static void spawnHexAround(World level, BlockPos blockpos, PlayerEntity playerIn) {
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.5, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.6, blockpos.getY(), blockpos.getZ() + 0.4*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.7, blockpos.getY(), blockpos.getZ() + 0.3*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.8, blockpos.getY(), blockpos.getZ() + 0.2*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.9, blockpos.getY(), blockpos.getZ() + 0.1*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +1.0, blockpos.getY(), blockpos.getZ() , 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.9, blockpos.getY(), blockpos.getZ() - 0.1*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.8, blockpos.getY(), blockpos.getZ() - 0.2*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.7, blockpos.getY(), blockpos.getZ() - 0.3*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.6, blockpos.getY(), blockpos.getZ() - 0.4*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.5, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.3, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.1, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.1, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.3, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.5, blockpos.getY(), blockpos.getZ() - 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.6, blockpos.getY(), blockpos.getZ() - 0.4*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.7, blockpos.getY(), blockpos.getZ() - 0.3*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.8, blockpos.getY(), blockpos.getZ() - 0.2*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.9, blockpos.getY(), blockpos.getZ() - 0.1*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -1, blockpos.getY(), blockpos.getZ() , 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.9, blockpos.getY(), blockpos.getZ() + 0.1*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.8, blockpos.getY(), blockpos.getZ() + 0.2*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.7, blockpos.getY(), blockpos.getZ() + 0.3*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.6, blockpos.getY(), blockpos.getZ() + 0.4*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.5, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.3, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() -0.1, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.1, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
        level.addParticle(ParticleTypes.ENTITY_EFFECT, blockpos.getX() +0.3, blockpos.getY(), blockpos.getZ() + 0.5*sq3, 0,0,0);
    }

    public static void spawnHexAround(IParticleData particle, World level, BlockPos blockpos, float amp) {
        level.addParticle(particle, blockpos.getX() +0.5*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0.5,0);
        level.addParticle(particle, blockpos.getX() +0.6*amp, blockpos.getY(), blockpos.getZ() + 0.4*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.7*amp, blockpos.getY(), blockpos.getZ() + 0.3*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.8*amp, blockpos.getY(), blockpos.getZ() + 0.2*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.9*amp, blockpos.getY(), blockpos.getZ() + 0.1*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +1.0*amp, blockpos.getY(), blockpos.getZ() , 0*amp,0.5,0);
        level.addParticle(particle, blockpos.getX() +0.9*amp, blockpos.getY(), blockpos.getZ() - 0.1*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.8*amp, blockpos.getY(), blockpos.getZ() - 0.2*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.7*amp, blockpos.getY(), blockpos.getZ() - 0.3*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.6*amp, blockpos.getY(), blockpos.getZ() - 0.4*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.5*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0.5,0);
        level.addParticle(particle, blockpos.getX() +0.3*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.1*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.1*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.3*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.5*amp, blockpos.getY(), blockpos.getZ() - 0.5*sq3*amp, 0,0.5,0);
        level.addParticle(particle, blockpos.getX() -0.6*amp, blockpos.getY(), blockpos.getZ() - 0.4*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.7*amp, blockpos.getY(), blockpos.getZ() - 0.3*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.8*amp, blockpos.getY(), blockpos.getZ() - 0.2*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.9*amp, blockpos.getY(), blockpos.getZ() - 0.1*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -1*amp, blockpos.getY(), blockpos.getZ() , 0*amp,0.5,0);
        level.addParticle(particle, blockpos.getX() -0.9*amp, blockpos.getY(), blockpos.getZ() + 0.1*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.8*amp, blockpos.getY(), blockpos.getZ() + 0.2*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.7*amp, blockpos.getY(), blockpos.getZ() + 0.3*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.6*amp, blockpos.getY(), blockpos.getZ() + 0.4*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.5*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0.5,0);
        level.addParticle(particle, blockpos.getX() -0.3*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() -0.1*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.1*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0,0);
        level.addParticle(particle, blockpos.getX() +0.3*amp, blockpos.getY(), blockpos.getZ() + 0.5*sq3*amp, 0,0,0);
    }
}