package com.joy187.re8joymod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BlockHeisenTorso extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 13.0D, 15.0D);

    public BlockHeisenTorso() {
        super((AbstractBlock.Properties.of(Material.METAL, MaterialColor.GRASS).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(5.0F, 5.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    }

    public VoxelShape getShape(BlockState p_52988_, IBlockReader p_52989_, BlockPos p_52990_, ISelectionContext p_52991_) {
        return SHAPE;
    }

    @Override
    public BlockState rotate(BlockState blockstate, Rotation rot) {
        return blockstate.setValue(FACING, rot.rotate(blockstate.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockstate, Mirror mirror) {
        return blockstate.rotate(mirror.getRotation(blockstate.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getClockWise());
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}