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

public class ItemHeadFlask extends Item {
    
	public ItemHeadFlask(){
        super(new Properties().stacksTo(1));
    }
    
    
    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
                                                        //entity                 player
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(co<3)
        {
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, co * 10, 4,true,true));
            attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, co * 10, 9));
        }
        else if(co>8){
            target.addEffect(new MobEffectInstance(MobEffects.POISON, co * 10, 2,true,true));
            attacker.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, co * 10, 2));
        }
        else{
            attacker.addEffect(new MobEffectInstance(MobEffects.GLOWING, co * 10, 9));
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(playerIn.getHealth()<=10.0F && co==1){
            playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*30, 4));
        }
        else if(co==2){
            playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*15, 2));
            playerIn.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20*60, 0));
        }
        else if(co==3){
            playerIn.removeAllEffects();
            playerIn.addEffect(new MobEffectInstance(MobEffects.POISON, 20*10, 2));
        }
        else{
            playerIn.addEffect(new MobEffectInstance(MobEffects.WITHER, 20*15, 1));
        }
        return InteractionResultHolder.success(itemstack);
    }
}