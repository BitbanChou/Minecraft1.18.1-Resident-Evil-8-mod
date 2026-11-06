package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.*;
import com.joy187.re8joymod.init.EntityInit;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class ItemRoseGene extends Item {

    public ItemRoseGene() {
        super(new Properties().stacksTo(8));
    }
    
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
//        p_77659_1_.playSound((player)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!p_77659_1_.isClientSide) {
            Random ran = new Random();
            int co=ran.nextInt(9);

            if(co==0)
            {
                EntityRosemary snowballentity = new EntityRosemary(EntityInit.ROSEMARY.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==1)
            {
                EntityMia snowballentity = new EntityMia(EntityInit.MIA.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==2){
                EntityEthan snowballentity = new EntityEthan(EntityInit.ETHAN.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==3){
                EntityLeon snowballentity = new EntityLeon(EntityInit.LEON.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==4){
                EntityHank snowballentity = new EntityHank(EntityInit.HANK.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==5){
                EntityLuis snowballentity = new EntityLuis(EntityInit.LUIS.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else if(co==6){
                EntityAsh snowballentity = new EntityAsh(EntityInit.ASH.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }
            else{
                EntityMycete snowballentity = new EntityMycete(EntityInit.MYCETE.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }

        }

        p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_77659_2_.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, p_77659_1_.isClientSide());
    }
}