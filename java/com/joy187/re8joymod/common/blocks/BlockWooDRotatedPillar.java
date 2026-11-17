package com.joy187.re8joymod.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;


public class BlockWooDRotatedPillar extends RotatedPillarBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public BlockWooDRotatedPillar(AbstractBlock.Properties p_i48339_1_) {
        super(p_i48339_1_);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        switch(p_185499_2_) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch((Direction.Axis)p_185499_1_.getValue(AXIS)) {
                    case X:
                        return p_185499_1_.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return p_185499_1_.setValue(AXIS, Direction.Axis.X);
                    default:
                        return p_185499_1_;
                }
            default:
                return p_185499_1_;
        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AXIS);
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(AXIS, p_196258_1_.getClickedFace().getAxis());
    }
}