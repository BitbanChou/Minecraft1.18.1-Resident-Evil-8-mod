package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityBei;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.joy187.re8joymod.common.entity.EntityUrias;
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

public class ItemRiser extends ItemPickaxe {

    public ItemRiser(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState p_195938_1_, World level, BlockPos blockpos, PlayerEntity playerIn) {
        ItemStack itemstack = playerIn.getMainHandItem();
        CommonFunctions.spawnHexAround(level,blockpos,playerIn);

        if (p_195938_1_.is(ModBlocks.PALEW_BLOCK.get())) {
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.ENTITY_EFFECT,level,blockpos,i);
            //CommonFunctions.spawnHexAround(level,blockpos,playerIn);

            EntityRe8Dimi e = new EntityRe8Dimi(EntityInit.RE8DIMI.get(), playerIn.level);
           //e.copyPosition(playerIn);
           e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(), playerIn.yRot, playerIn.xRot);
           e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
           e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
           playerIn.level.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, playerIn.getX() + 5 * (this.random.nextDouble() - 0.5D) * (double) playerIn.getBbWidth(), playerIn.getY() + 0.1D, playerIn.getZ() + 4 * (this.random.nextDouble() - 0.5D) * (double) playerIn.getBbWidth(), playerIn.position().x * -0.2D, 0.1D, playerIn.position().z * -0.2D);
           playerIn.level.addFreshEntity(e);

            if (!playerIn.isCreative()) itemstack.shrink(1);
        } else if (p_195938_1_.is(ModBlocks.DUNGEON_BLOCK.get())) {
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.LARGE_SMOKE,level,blockpos,i);

            EntityBei e = new EntityBei(EntityInit.BEI.get(), playerIn.level);
            //e.copyPosition(playerIn);
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(), playerIn.yRot, playerIn.xRot);
            e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
            e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
            playerIn.level.addFreshEntity(e);
            playerIn.level.addParticle(ParticleTypes.LARGE_SMOKE, playerIn.getX(), playerIn.getY(), playerIn.getZ(), playerIn.position().x, playerIn.position().y, playerIn.position().z);
            if (!playerIn.isCreative()) itemstack.shrink(1);
        } else if (p_195938_1_.is(ModBlocks.DEYE_BLOCK.get())) {
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.CAMPFIRE_COSY_SMOKE,level,blockpos,i);

            EntityUrias e = new EntityUrias(EntityInit.URIAS.get(), playerIn.level);
            //e.copyPosition(playerIn);
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(), playerIn.yRot, playerIn.xRot);
            e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60,10));
            e.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 60,10));
            playerIn.level.addFreshEntity(e);
            playerIn.level.addParticle(ParticleTypes.EXPLOSION_EMITTER, playerIn.getX(), playerIn.getY(), playerIn.getZ(), playerIn.position().x, playerIn.position().y, playerIn.position().z);
            if (!playerIn.isCreative()) itemstack.shrink(1);
        }
        CommonFunctions.spawnHexAround(level,blockpos,playerIn);

        return true;
    }

}