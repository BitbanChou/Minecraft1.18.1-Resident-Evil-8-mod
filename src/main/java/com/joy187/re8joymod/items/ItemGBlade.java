package com.joy187.re8joymod.items;

import com.joy187.re8joymod.init.ItemInit;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;


public class ItemGBlade extends ItemUrias{

    public ItemGBlade(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem())) {

            playerIn.setDeltaMovement(playerIn.getViewVector(1));

            playerIn.getCooldowns().addCooldown(this,200);

            itemstack.hurtAndBreak(1, playerIn, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return InteractionResultHolder.success(itemstack);
    }

    public void inventoryTick(ItemStack stack, Level level, Entity p_41406_, int p_41407_, boolean p_41408_) {
        if (!level.isClientSide && stack.getItem()== ItemInit.GBLADE.get()) {
            if(p_41406_ instanceof Player){
                if(((Player)p_41406_).getMainHandItem().getItem()==ItemInit.GBLADE.get() &&
                        ((Player)p_41406_).getOffhandItem().getItem()==ItemInit.GBLADE.get())
                {
                    if(!((Player)p_41406_).hasEffect(MobEffects.MOVEMENT_SPEED))
                    {
                        ((Player)p_41406_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2,true,false));
                    }
                }
            }
        }

    }

}