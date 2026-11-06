package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.entity.EntityAxeman;
import com.joy187.re8joymod.entity.EntityBei;
import com.joy187.re8joymod.entity.EntityHeisen;
import com.joy187.re8joymod.entity.EntityMoreau;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.EntityUrias;
import com.joy187.re8joymod.entity.EntityUriass;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemRiser2 extends PickaxeItem{

	double sq3 = 1.732;
	
    public ItemRiser2(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState blockstate, Level level, BlockPos blockpos, Player playerIn) {
        ItemStack itemstack = playerIn.getMainHandItem();
        Random ran = new Random();
        if(blockstate.is(BlockInit.MUCUS_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.ITEM_SLIME,level,blockpos,i);
            int co = ran.nextInt(2);
            if(co==1){
	            EntityMoreau e = new EntityMoreau(EntityInit.MOREAU.get(),playerIn.level());
	            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
	            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
	            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
	            
	            playerIn.level().addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, playerIn.getX() + 5*(ran.nextDouble() - 0.5D) * (double)playerIn.getBbWidth(), playerIn.getY() + 0.1D, playerIn.getZ() + 4*(ran.nextDouble() - 0.5D) * (double)playerIn.getBbWidth(), playerIn.position().x * -0.2D, 0.1D, playerIn.position().z * -0.2D);
	    	    playerIn.level().addFreshEntity(e);
	            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);
	        }
            else {
            	playerIn.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000));

            }
            if(!playerIn.isCreative()) itemstack.shrink(1);
  	
        }
        else if(blockstate.is(BlockInit.FACTW_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.FLAME,level,blockpos,i);
            int co = ran.nextInt(2);
            if(co==1){
	            EntityHeisen e = new EntityHeisen(EntityInit.HEISEN.get(), playerIn.level());
	            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
	            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
	            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
	            
	            playerIn.level().addFreshEntity(e);
	            playerIn.level().addParticle(ParticleTypes.LARGE_SMOKE, playerIn.getX(), playerIn.getY(), playerIn.getZ(), playerIn.position().x, playerIn.position().y, playerIn.position().z);
	            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);
	        }
            else {
            	playerIn.level().explode((Entity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), (float)1, Level.ExplosionInteraction.NONE);

            }
            if(!playerIn.isCreative()) itemstack.shrink(1);
        }
        else if(blockstate.is(BlockInit.DEYE_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.CAMPFIRE_COSY_SMOKE,level,blockpos,i);
            EntityUriass e = new EntityUriass(EntityInit.URIASS.get(),playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));            
            playerIn.level().addFreshEntity(e);
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }
        else if(blockstate.is(BlockInit.DUNGEON_BLOCK.get())){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.LANDING_LAVA,level,blockpos,i);
            EntityAxeman e = new EntityAxeman(EntityInit.AXEMAN.get(),playerIn.level());
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
