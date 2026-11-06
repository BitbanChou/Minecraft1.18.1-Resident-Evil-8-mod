package com.joy187.re8joymod.items;


import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCrossbow2 extends ItemCrossbow1{
    public ItemCrossbow2() {
        super();
    }
    public int shootingCooldown=20;
    public int time=20;


    public void inventoryTick(ItemStack stack, Level level, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if (!level.isClientSide && stack.getItem()== ItemInit.ZGUN.get()) {
            if(p_41406_ instanceof Player && ((ItemCrossbow2)stack.getItem()).time<this.shootingCooldown){
                this.time++;
            }
            //System.out.println("bow"+this.time);
        }

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.nullToEmpty(ChatFormatting.GOLD+"Press 'V' to fire."));
        tooltip.add(Component.nullToEmpty(ChatFormatting.GOLD+"Ammo Type:BOW Shoot"));
    }
}
