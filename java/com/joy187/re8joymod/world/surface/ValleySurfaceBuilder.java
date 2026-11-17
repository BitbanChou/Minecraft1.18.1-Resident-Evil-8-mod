package com.joy187.re8joymod.common.world.surface;

import com.joy187.re8joymod.common.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;


public class ValleySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState WASTELAND_BLOCK = ModBlocks.WASTELAND_BLOCK.get().defaultBlockState();
    public static final BlockState WASTELAND_ROCK_BLOCK = ModBlocks.WASTELAND_BLOCK.get().defaultBlockState();
    public static final BlockState PODZ_STONE = ModBlocks.WASTELAND_BLOCK.get().defaultBlockState();


    public static final SurfaceBuilderConfig WASTELAND_BLOCK_CONFIG = new SurfaceBuilderConfig(WASTELAND_BLOCK,
            WASTELAND_BLOCK, WASTELAND_BLOCK);
    public static final SurfaceBuilderConfig WASTELAND_ROCK_BLOCK_CONFIG = new SurfaceBuilderConfig(WASTELAND_ROCK_BLOCK,
            WASTELAND_ROCK_BLOCK, WASTELAND_ROCK_BLOCK);
    public static final SurfaceBuilderConfig STONE_CONFIG = new SurfaceBuilderConfig(PODZ_STONE, PODZ_STONE, PODZ_STONE);

    public ValleySurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                      BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (random.nextInt(3) == 0) {
            SurfaceBuilder.MOUNTAIN.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, WASTELAND_BLOCK_CONFIG);
        } else if (random.nextInt(3) == 1) {
            SurfaceBuilder.MOUNTAIN.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, STONE_CONFIG);
        }
        else {
            SurfaceBuilder.MOUNTAIN.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                    defaultFluid, seaLevel, seed, WASTELAND_ROCK_BLOCK_CONFIG);
        }
    }
}