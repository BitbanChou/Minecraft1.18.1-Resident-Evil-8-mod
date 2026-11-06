package com.joy187.re8joymod.items;

import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;


public class ItemRiserPlagas extends PickaxeItem {

	double sq3 = 1.732;

    public ItemRiserPlagas(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    public boolean canAttackBlock(BlockState blockstate, Level level, BlockPos blockpos, Player playerIn) {
        ItemStack itemstack = playerIn.getMainHandItem();
        
        Random ran = new Random();
        if(blockstate.is(Blocks.BELL)){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.ENTITY_EFFECT,level,blockpos,i);

            EntitySalazar e = new EntitySalazar(EntityInit.SALAZAR.get(), playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            playerIn.level().addFreshEntity(e);
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);
            CommonFunctions.spawnFireFlame(e,ParticleInit.FLAME_PARTICLE.get());
            if(!playerIn.isCreative()) itemstack.shrink(1);

        }
        else if(blockstate.is(Blocks.BLACKSTONE)){
        	for(float i=1;i<=3;i+=0.5)
        		CommonFunctions.spawnHexAround(ParticleTypes.ASH,level,blockpos,i);

            EntityVerdugo e = new EntityVerdugo(EntityInit.VERDUGO.get(), playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            playerIn.level().addFreshEntity(e);
            CommonFunctions.spawnFireFlame(e,ParticleInit.FLAME_PARTICLE.get());
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }
        else if(blockstate.is(BlockInit.FACTW_BLOCK.get())){
            for(float i=1;i<=3;i+=0.5)
                CommonFunctions.spawnHexAround(ParticleTypes.ASH,level,blockpos,i);

            EntityKrauser e = new EntityKrauser(EntityInit.KRAUSER.get(), playerIn.level());
            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            playerIn.level().addFreshEntity(e);
            CommonFunctions.spawnFireFlame(e,ParticleInit.FLAME_PARTICLE.get());
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }
        else if(blockstate.is(BlockInit.FANTOM_BLOCK.get())){
            EntitySaddler e = new EntitySaddler(EntityInit.SADDLER.get(),playerIn.level());
            CommonFunctions.spawnFireFlame(e,ParticleInit.FLAME_PARTICLE.get());

            e.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ(),playerIn.getYRot(),playerIn.getXRot());
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*3,5,false,false));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*3,5,false,false));
            playerIn.level().addFreshEntity(e);
            //CommonFunctions.spawnFireFlame(e,ParticleInit.FLAME_PARTICLE.get());
            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.4F, 1.4F / (playerIn.getRandom().nextFloat() * 0.4F + 1.2F) +1 * 0.5F);

            if(!playerIn.isCreative()) itemstack.shrink(1);
        }

        return true;
    }
    

}
