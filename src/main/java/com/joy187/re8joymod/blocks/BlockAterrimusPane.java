package com.joy187.re8joymod.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;

public class BlockAterrimusPane extends IronBarsBlock {

    public BlockAterrimusPane() {
        super(Properties.copy(Blocks.GLASS).strength(0.4F).sound(SoundType.GLASS).noOcclusion());
    }
}