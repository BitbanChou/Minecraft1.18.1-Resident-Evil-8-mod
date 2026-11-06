package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.Main;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class ItemTorsoFlask extends Item {
    
	public ItemTorsoFlask(){
        super(new Properties().stacksTo(1));
    }
    
	
    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(co<5)
        {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, co * 10, 4,true,true));
        }
        else {
            attacker.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, co * 10, 4));
        }
        return false;
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(playerIn.getHealth()<=10.0F && co==1){
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*30,1));
        }
        else if(co==2){
            playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*8,2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*10,1));
        }
        else if(co==3){
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*30, 3));
        }
        else{
            playerIn.removeAllEffects();
            playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20*5, 2));
        }
        return InteractionResultHolder.success(itemstack);
     }
    
    
}
