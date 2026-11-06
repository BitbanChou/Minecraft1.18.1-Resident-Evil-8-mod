package com.joy187.re8joymod.items;

import java.util.Calendar;
import java.util.Random;

import com.joy187.re8joymod.entity.EntityBei;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.EntityUrias;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


public class ItemRiser extends PickaxeItem {

	double sq3 = 1.732;
	
    public ItemRiser(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState blockstate, Level level, BlockPos blockpos, Player playerIn) {
        ItemStack itemstack = playerIn.getMainHandItem();
        
        Random ran = new Random();
        if(blockstate.is(BlockInit.PALEW_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.ENTITY_EFFECT,level,blockpos,i);

            EntityRe8Dimi e = new EntityRe8Dimi(EntityInit.RE8DIMI.get(),playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            
            playerIn.level().addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, playerIn.getX() + 5*(ran.nextDouble() - 0.5D) * (double)playerIn.getBbWidth(), playerIn.getY() + 0.1D, playerIn.getZ() + 4*(ran.nextDouble() - 0.5D) * (double)playerIn.getBbWidth(), playerIn.position().x * -0.2D, 0.1D, playerIn.position().z * -0.2D);
    	    playerIn.level().addFreshEntity(e);
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
  	
        }
        else if(blockstate.is(BlockInit.DUNGEON_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.LARGE_SMOKE,level,blockpos,i);
        	
            EntityBei e = new EntityBei(EntityInit.BEI.get(), playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            playerIn.level().addFreshEntity(e);
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }
        else if(blockstate.is(BlockInit.DEYE_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.CAMPFIRE_COSY_SMOKE,level,blockpos,i);
            EntityUrias e = new EntityUrias(EntityInit.URIAS.get(),playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));            
            playerIn.level().addFreshEntity(e);
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }

        return true;
    }
    

}
