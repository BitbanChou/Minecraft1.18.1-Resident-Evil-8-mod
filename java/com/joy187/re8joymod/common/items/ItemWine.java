package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class ItemWine extends Item {
    public ItemWine(){
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        if(p_77659_2_.getHealth()<=5.0F && p_77659_2_.getHealth()>=2.0F){
            p_77659_2_.addEffect(new EffectInstance(Effects.REGENERATION, 20*10, 2));
        }
        else if(p_77659_2_.getHealth()<2.0F){
            p_77659_2_.addEffect(new EffectInstance(Effects.REGENERATION, 20*8, 3));
            p_77659_2_.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*10, 2));
        }

        return ActionResult.success(itemstack);
    }
}
