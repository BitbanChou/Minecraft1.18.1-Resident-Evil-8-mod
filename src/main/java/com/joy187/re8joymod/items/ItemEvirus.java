package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLycan;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemEvirus extends Item{
    public ItemEvirus(){
        super(new Properties().stacksTo(64));
    }
    
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player player, InteractionHand p_77659_3_) {
        ItemStack itemstack = player.getItemInHand(p_77659_3_);
        player.startUsingItem(p_77659_3_);
        Random ran = new Random();
        int co = ran.nextInt(8);
        if(co==0 || co==7) player.addEffect(new MobEffectInstance(EffectInit.BURN.get(), 10*20, 0, true, true));
        else if(co==1) player.addEffect(new MobEffectInstance(EffectInit.ZENHEART.get(), 5*20, 0, true, true));
        else if(co==2) player.addEffect(new MobEffectInstance(EffectInit.ZENHEART.get(), 60*20, 2, false, true));
        else if(co==3) player.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 10*20, 2, false, true));
        else if(co==4) player.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 30*20, 0, false, true));
        else if(co==5) player.addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 5*20, 2, false, true));
        else player.addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 15*20, 0, true, true));

        itemstack.shrink(1);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(co==1)
        {
            pTarget.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 20*3, 0, true, true));
            if(pAttacker instanceof Player)
            {
                if(!((Player)pAttacker).getAbilities().instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==2){
            pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20*3, 0, true, true));
            pTarget.setDeltaMovement(0,0.01,0);
            if(pAttacker instanceof Player)
            {
                if(!((Player)pAttacker).getAbilities().instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==3){
            pTarget.discard();
            pAttacker.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.PLAYERS, 1.0F, 1.0F / (pAttacker.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            if(pAttacker instanceof Player)
            {
                if(!((Player)pAttacker).getAbilities().instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==4){
            EntityLycan e=new EntityLycan(EntityInit.LYCAN.get(),pAttacker.level());
            e.copyPosition(pTarget);
            pTarget.discard();
            pAttacker.level().playSound((Player)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (pAttacker.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            pAttacker.level().addFreshEntity(e);
            if(pAttacker instanceof Player)
            {
                if(!((Player)pAttacker).getAbilities().instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    
    
    public int getUseDuration() {
        return 100;
    }
}
