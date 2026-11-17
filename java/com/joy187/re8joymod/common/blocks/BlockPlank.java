package com.joy187.re8joymod.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockPlank extends Block {
    public BlockPlank() {
        super(AbstractBlock.Properties.of(Material.WOOD).
                strength(2,2).harvestTool(ToolType.AXE)
                .harvestLevel(0).sound(SoundType.STONE));
    }
}
