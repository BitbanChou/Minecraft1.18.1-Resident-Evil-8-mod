package com.joy187.re8joymod.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;


public class BlockMine extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 14.0D, 4.0D, 14.0D);

    public BlockMine() {
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

    @Override
    public void stepOn(World p_154573_, BlockPos p_154574_, Entity p_154576_) {
        if(p_154576_ instanceof LivingEntity)
        {
            ((LivingEntity)p_154576_).addEffect(new EffectInstance(Effects.HARM, 1, 1,true,true));
            p_154576_.hurt(DamageSource.IN_FIRE, (float)15.0F);
        }
        p_154573_.explode((Entity)null, p_154574_.getX(), p_154574_.getY(), p_154574_.getZ(), (float)3, false, Explosion.Mode.DESTROY);
        super.stepOn(p_154573_, p_154574_, p_154576_);
    }
}