package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemXiShouYe extends Item{
	
	   
    public ItemXiShouYe(){
        super(new Properties().stacksTo(64));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
           ItemStack itemstack = playerIn.getItemInHand(handIn);
           playerIn.startUsingItem(handIn);
           
           playerIn.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60 * 10, 2, false, true));
           playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5000, 0, false, true));
           playerIn.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4000, 2, false, true));
           playerIn.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 3, false, true));
           playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 3, false, true));
           	
           itemstack.shrink(1);
           return InteractionResultHolder.consume(itemstack);
     }
    
    public int getUseDuration() {
        return 100;
    }
    

}
