package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class ItemTorsoFlask extends Item {

    public ItemTorsoFlask() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
                                                                //entity                 player
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(co<5)
        {
            p_77644_2_.addEffect(new EffectInstance(Effects.WEAKNESS, co * 10, 4,true,true));
        }
        else {
            p_77644_3_.addEffect(new EffectInstance(Effects.ABSORPTION, co * 10, 4));
        }
        return false;
    }

//    @Override
//    public ActionResultType interactLivingEntity(ItemStack p_111207_1_, PlayerEntity p_111207_2_, LivingEntity p_111207_3_, Hand p_111207_4_) {
//        Random ran = new Random();
//        int co = ran.nextInt(10);
//        if(co<5)
//        {
//            p_111207_3_.addEffect(new EffectInstance(Effects.WEAKNESS, co * 10, 4,true,true));
//        }
//        else {
//            p_111207_2_.addEffect(new EffectInstance(Effects.ABSORPTION, co * 10, 4));
//        }
//        return ActionResultType.PASS;
//    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
            ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
            Random ran = new Random();
            int co = ran.nextInt(5);
            if(p_77659_2_.getHealth()<=10.0F && co==1){
                p_77659_2_.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*30,1));
            }
            else if(co==2){
                p_77659_2_.addEffect(new EffectInstance(Effects.REGENERATION, 20*8,2));
                p_77659_2_.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*10,1));
            }
            else if(co==3){
                p_77659_2_.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20*30, 3));
            }
            else{
                p_77659_2_.removeAllEffects();
                p_77659_2_.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20*5, 2));
            }
            return ActionResult.success(itemstack);
    }
}
