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

public class ItemArmsFlask extends Item {
	public ItemArmsFlask(){
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(attacker.getHealth()<10.0F)
        {
            target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, co * 10, 4,true,true));
        }
        else if(co>7){
            attacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, co * 10, 1));
        }
        else{
            attacker.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, co * 10, 1));
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(playerIn.getHealth()<=10.0F && co==1){
            playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20*10, 4));
        }
        else if(co==2){
            playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*15, 2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 20*20, 1));
        }
        else if(co==3){
            playerIn.removeAllEffects();
            playerIn.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20*15, 2));
        }
        else{
            playerIn.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20*120, 1));
        }
        return InteractionResultHolder.success(itemstack);
    }

}