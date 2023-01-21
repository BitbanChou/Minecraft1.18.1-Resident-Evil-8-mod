package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class ItemLegsFlask extends Item {
    public ItemLegsFlask(){
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(p_77644_3_.getHealth()<10.0F)
        {
            p_77644_2_.addEffect(new EffectInstance(Effects.LEVITATION, co * 10, 4));
        }
        else if(co>7){
            p_77644_3_.addEffect(new EffectInstance(Effects.INVISIBILITY, co * 10, 1));
        }
        else {
            p_77644_3_.addEffect(new EffectInstance(Effects.JUMP, co * 10, 2));
        }

        return false;
    }

//    @Override
//    public ActionResultType interactLivingEntity(ItemStack p_111207_1_, PlayerEntity p_111207_2_, LivingEntity p_111207_3_, Hand p_111207_4_) {
//        Random ran = new Random();
//        int co = ran.nextInt(10);
//        if(p_111207_2_.getHealth()<10.0F)
//        {
//            p_111207_3_.addEffect(new EffectInstance(Effects.LEVITATION, co * 10, 4));
//        }
//        else if(co>7){
//            p_111207_2_.addEffect(new EffectInstance(Effects.INVISIBILITY, co * 10, 1));
//        }
//        else {
//            p_111207_2_.addEffect(new EffectInstance(Effects.JUMP, co * 10, 2));
//        }
//        return ActionResultType.PASS;
//    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(co==1){
            p_77659_2_.addEffect(new EffectInstance(Effects.DIG_SPEED, 20*10, 4));
        }
        else if(co==2){
            p_77659_2_.addEffect(new EffectInstance(Effects.REGENERATION, 20*15, 2));
            p_77659_2_.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*60, 0));
        }
        else if(co==3){
            p_77659_2_.removeAllEffects();
            p_77659_2_.addEffect(new EffectInstance(Effects.BLINDNESS, 20*10, 2));
            p_77659_2_.addEffect(new EffectInstance(Effects.LEVITATION, 20*5, 3));
        }
        else {
            p_77659_2_.addEffect(new EffectInstance(Effects.NIGHT_VISION, 20*120, 1));
        }
        return ActionResult.success(itemstack);
    }

}
