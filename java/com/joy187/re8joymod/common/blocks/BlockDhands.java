package com.joy187.re8joymod.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockDhands extends Block {

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);


    public BlockDhands() {
        super(AbstractBlock.Properties.of(Material.STONE).
                strength(5,5).
                harvestTool(ToolType.PICKAXE).
                harvestLevel(2).
                sound(SoundType.BONE_BLOCK));
    }

    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState p_230335_1_, IBlockReader p_230335_2_, BlockPos p_230335_3_) {
        return VoxelShapes.block();
    }

    public VoxelShape getVisualShape(BlockState p_230322_1_, IBlockReader p_230322_2_, BlockPos p_230322_3_, ISelectionContext p_230322_4_) {
        return VoxelShapes.block();
    }

    public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        Vector3d vector3d1 = p_196262_4_.getDeltaMovement();
        p_196262_4_.level.addParticle(ParticleTypes.WHITE_ASH, p_196262_4_.getX() + (p_196262_2_.random.nextDouble() - 0.5D) *
                (double)p_196262_4_.getBbWidth(), p_196262_4_.getY() + 0.1D, p_196262_4_.getZ() + (p_196262_2_.random.nextDouble() - 0.5D) *
                (double)p_196262_4_.getBbWidth(), p_196262_4_.position().x * -0.2D, 0.1D, p_196262_4_.position().z * -0.2D);

        p_196262_4_.setDeltaMovement(vector3d1.x*0.35, vector3d1.y, vector3d1.z*0.35);
    }



}
