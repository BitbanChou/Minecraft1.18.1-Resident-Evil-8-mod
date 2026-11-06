package com.joy187.re8joymod.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class BlockHumusSand extends Block {
	
    public BlockHumusSand() {
        super(Properties.copy(Blocks.SAND).strength(0.25F).sound(SoundType.SAND).randomTicks());
    }
    
}
