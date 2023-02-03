package com.joy187.re8joymod.common.blocks;

import com.joy187.re8joymod.common.init.ModEffects;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockUmbrella extends Block {

    public int f=0;
    public BlockUmbrella() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(5,100).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.STONE));
    }

    public void stepOn(World p_176199_1_, BlockPos p_176199_2_, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            if(entityIn instanceof PlayerEntity) {
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(), 100));
                //spawnp(entityIn);
                this.f=1;
            }
            else{
                ((LivingEntity)entityIn).addEffect(new EffectInstance(ModEffects.EROSION.get(), 200));
                //((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40 * (int)f));

                this.f=0;
            }
        }
    }
}
