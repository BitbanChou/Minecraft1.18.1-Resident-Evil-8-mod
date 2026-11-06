package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.Main;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemWine extends Item {
    public ItemWine(){
        super(new Properties().stacksTo(1));
    }

    
    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        if(p_77659_2_.getHealth()<=5.0F && p_77659_2_.getHealth()>=2.0F){
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*10, 2));
        }
        else if(p_77659_2_.getHealth()<2.0F){
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*8, 3));
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*10, 2));
        }

        return InteractionResultHolder.success(itemstack);
    }
}