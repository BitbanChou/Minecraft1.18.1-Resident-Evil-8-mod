package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class ItemArmsFlask extends Item {
    public ItemArmsFlask(){ super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));}


    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
                                                        //entity                 player
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(p_77644_3_.getHealth()<10.0F)
        {
            p_77644_2_.addEffect(new EffectInstance(Effects.CONFUSION, co * 10, 4,true,true));
        }
        else if(co>7){
            p_77644_3_.addEffect(new EffectInstance(Effects.DIG_SPEED, co * 10, 1));
        }
        else{
            p_77644_3_.addEffect(new EffectInstance(Effects.HEALTH_BOOST, co * 10, 1));
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(p_77659_2_.getHealth()<=10.0F && co==1){
            p_77659_2_.addEffect(new EffectInstance(Effects.ABSORPTION, 20*10, 4));
        }
        else if(co==2){
            p_77659_2_.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*15, 2));
            p_77659_2_.addEffect(new EffectInstance(Effects.CONDUIT_POWER, 20*20, 1));
        }
        else if(co==3){
            p_77659_2_.removeAllEffects();
            p_77659_2_.addEffect(new EffectInstance(Effects.CONFUSION, 20*15, 2));
        }
        else{
            p_77659_2_.addEffect(new EffectInstance(Effects.WATER_BREATHING, 20*120, 1));
        }
        return ActionResult.success(itemstack);
    }

}
