package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityAxeman;
import com.joy187.re8joymod.common.entity.EntityHeisen;
import com.joy187.re8joymod.common.entity.EntityMoreau;
import com.joy187.re8joymod.common.entity.EntityUriass;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModBlocks;
import com.joy187.re8joymod.helper.CommonFunctions;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class ItemRiser2 extends ItemPickaxe {

    public ItemRiser2(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
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
                EntityMoreau e = new EntityMoreau(EntityInit.MOREAU.get(),p_195938_4_.level);
                e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
                e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
                e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
                //e.copyPosition(p_195938_4_);
                p_195938_4_.level.addFreshEntity(e);
                //p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
            }
            else{
                p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY() + 0.1D, p_195938_4_.getZ(), p_195938_4_.position().x * -0.2D, 0.1D, p_195938_4_.position().z * -0.2D);
                p_195938_4_.level.addParticle(ParticleTypes.BUBBLE, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
                p_195938_4_.addEffect(new EffectInstance(Effects.CONFUSION, 1000));
            }
            if (!p_195938_4_.isCreative()) itemstack.shrink(1);
        }
        else if(p_195938_1_.is(ModBlocks.FACTW_BLOCK.get())){
            Random ran = new Random();
            int co = ran.nextInt(2);
            if(co==1){
                for(float i=1;i<=3;i+=0.5)
                    CommonFunctions.spawnHexAround(ParticleTypes.FLAME,p_195938_2_,p_195938_3_,i);

                EntityHeisen e = new EntityHeisen(EntityInit.HEISEN.get(),p_195938_4_.level);
                e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
                e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
                e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
                //e.copyPosition(p_195938_4_);
                p_195938_4_.level.addFreshEntity(e);
                p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
            }
            else{
                p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY() + 0.1D, p_195938_4_.getZ(), p_195938_4_.position().x * -0.2D, 0.1D, p_195938_4_.position().z * -0.2D);
                p_195938_4_.level.addParticle(ParticleTypes.LARGE_SMOKE, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
                p_195938_4_.level.explode((Entity)null, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), (float)1, true, Explosion.Mode.NONE);
            }
            if (!p_195938_4_.isCreative()) itemstack.shrink(1);
        }
        else if(p_195938_1_.is(ModBlocks.DEYE_BLOCK.get())){
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.CAMPFIRE_COSY_SMOKE,p_195938_2_,p_195938_3_,i);

            EntityUriass e = new EntityUriass(EntityInit.URIASS.get(),p_195938_4_.level);
            e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
            e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
            e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
            //e.copyPosition(p_195938_4_);
            p_195938_4_.level.addFreshEntity(e);
            //e.copyPosition(p_195938_4_);
            p_195938_4_.level.addFreshEntity(e);
            p_195938_4_.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
            if (!p_195938_4_.isCreative()) itemstack.shrink(1);
        }
        else if(p_195938_1_.is(ModBlocks.DUNGEON_BLOCK.get())){
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.LANDING_LAVA,p_195938_2_,p_195938_3_,i);
            EntityAxeman e = new EntityAxeman(EntityInit.AXEMAN.get(),p_195938_4_.level);
            e.moveTo(p_195938_3_.getX(), p_195938_3_.getY(), p_195938_3_.getZ(), p_195938_4_.yRot, p_195938_4_.xRot);
            e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
            e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
            //e.copyPosition(p_195938_4_);
            p_195938_4_.level.addFreshEntity(e);
            //p_195938_4_.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, p_195938_4_.getX(), p_195938_4_.getY(), p_195938_4_.getZ(), p_195938_4_.position().x, p_195938_4_.position().y, p_195938_4_.position().z);
            if (!p_195938_4_.isCreative()) itemstack.shrink(1);
        }
        return true;
    }
}
