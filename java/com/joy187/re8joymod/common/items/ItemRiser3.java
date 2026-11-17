package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityMiranda1;
import com.joy187.re8joymod.common.entity.EntityMoreau4;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModBlocks;
import com.joy187.re8joymod.helper.CommonFunctions;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ItemRiser3 extends ItemPickaxe {
    public ItemRiser3(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState p_195938_1_, World p_195938_2_, BlockPos p_195938_3_, PlayerEntity p_195938_4_) {
        ItemStack itemstack = p_195938_4_.getMainHandItem();
        if(p_195938_1_.is(ModBlocks.MUCUS_BLOCK.get())){
            Random ran = new Random();
            int co = ran.nextInt(2);
            if(co==1){
                for(float i=1;i<=3;i+=0.5)
                    CommonFunctions.spawnHexAround(ParticleTypes.ITEM_SLIME,p_195938_2_,p_195938_3_,i);
                EntityMoreau4 e = new EntityMoreau4(EntityInit.MOREAU4.get(),p_195938_4_.level);
                e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
                e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
                e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
                //e.copyPosition(p_195938_4_);
                p_195938_4_.level.addFreshEntity(e);
                if (!p_195938_4_.isCreative()) itemstack.shrink(1);
            }
            else{
                p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY() + 0.1D, p_195938_4_.getZ(), p_195938_4_.position().x * -0.2D, 0.1D, p_195938_4_.position().z * -0.2D);
                p_195938_4_.level.addParticle(ParticleTypes.BUBBLE, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
                p_195938_4_.addEffect(new EffectInstance(Effects.CONFUSION, 100));
            }
            itemstack.shrink(1);
        }
        else if(p_195938_1_.is(ModBlocks.FANTOM_BLOCK.get())){
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.ENTITY_EFFECT,p_195938_2_,p_195938_3_,i);
             EntityMiranda1 e = new EntityMiranda1(EntityInit.MIRANDA1.get(),p_195938_4_.level);
//             e.copyPosition(p_195938_4_);
             e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
             e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
             e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
             p_195938_4_.level.addFreshEntity(e);
             if (!p_195938_4_.isCreative()) itemstack.shrink(1);
        }
        return true;
    }
}
