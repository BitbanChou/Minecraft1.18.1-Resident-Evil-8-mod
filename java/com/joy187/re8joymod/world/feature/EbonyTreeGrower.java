package com.joy187.re8joymod.common.world.feature;


import com.joy187.re8joymod.common.world.gen.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class EbonyTreeGrower extends Tree {
//    @Nullable
//    @Override
//    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
//        return ModConfiguredFeatures.EBONY_TREE;
//    }

    @Override
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random p_225546_1_, boolean p_225546_2_) {
        return ModConfiguredFeatures.EBONY;
    }
}
