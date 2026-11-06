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

public class ItemLegsFlask extends Item {
	public ItemLegsFlask(){
        super(new Properties().stacksTo(1));
    }
	
    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity target, LivingEntity attacker) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(attacker.getHealth()<10.0F)
        {
            target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, co * 10, 4));
        }
        else if(co>7){
            attacker.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, co * 10, 1));
        }
        else {
            attacker.addEffect(new MobEffectInstance(MobEffects.JUMP, co * 10, 2));
        }

        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(co==1){
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20*10, 4));
        }
        else if(co==2){
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20*15, 2));
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*60, 0));
        }
        else if(co==3){
            p_77659_2_.removeAllEffects();
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20*10, 2));
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20*5, 3));
        }
        else {
            p_77659_2_.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20*120, 1));
        }
        return InteractionResultHolder.success(itemstack);
    }

}