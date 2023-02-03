package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityLycan;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.init.ModEffects;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class ItemEvirus extends Item {
    public ItemEvirus(){
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(64));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity player, Hand p_77659_3_) {
        ItemStack itemstack = player.getItemInHand(p_77659_3_);

        player.startUsingItem(p_77659_3_);
        Random ran = new Random();
        int co = ran.nextInt(8);
        if(co==0 || co==7) player.addEffect(new EffectInstance(ModEffects.BURN.get(), 10*20, 0, true, true));
        else if(co==1) player.addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(), 5*20, 0, true, true));
        else if(co==2) player.addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(), 60*20, 2, false, true));
        else if(co==3) player.addEffect(new EffectInstance(ModEffects.DEADLY.get(), 10*20, 2, false, true));
        else if(co==4) player.addEffect(new EffectInstance(ModEffects.DEADLY.get(), 30*20, 0, false, true));
        else if(co==5) player.addEffect(new EffectInstance(ModEffects.EROSION.get(), 5*20, 2, false, true));
        else player.addEffect(new EffectInstance(ModEffects.EROSION.get(), 15*20, 0, true, true));

        if(!player.abilities.instabuild) itemstack.shrink(1);
        return ActionResult.consume(itemstack);
    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        int co = ran.nextInt(10);
        if(co==1)
        {
            pTarget.addEffect(new EffectInstance(ModEffects.DEADLY.get(), 20*3, 0, true, true));
            if(pAttacker instanceof PlayerEntity)
            {
                if(!((PlayerEntity)pAttacker).abilities.instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==2){
            pTarget.addEffect(new EffectInstance(Effects.LEVITATION, 20*3, 0, true, true));
            pTarget.setDeltaMovement(0,0.01,0);
            if(pAttacker instanceof PlayerEntity)
            {
                if(!((PlayerEntity)pAttacker).abilities.instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==3){
            pTarget.remove();
            pAttacker.level.playSound((PlayerEntity)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.SLIME_BLOCK_HIT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
            if(pAttacker instanceof PlayerEntity)
            {
                if(!((PlayerEntity)pAttacker).abilities.instabuild)
                {
                    pStack.shrink(1);
                }
            }
        }
        else if(co==4){
            EntityLycan e=new EntityLycan(EntityInit.LYCAN.get(),pAttacker.level);
            e.copyPosition(pTarget);
            pTarget.remove();
            pAttacker.level.playSound((PlayerEntity)null, pTarget.getX(), pTarget.getY(), pTarget.getZ(), SoundEvents.ZOMBIE_INFECT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
            pAttacker.level.addFreshEntity(e);
            if(pAttacker instanceof PlayerEntity)
            {
                if(!((PlayerEntity)pAttacker).abilities.instabuild)
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
