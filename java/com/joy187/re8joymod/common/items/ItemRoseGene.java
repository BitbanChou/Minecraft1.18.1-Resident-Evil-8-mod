package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityEthan;
import com.joy187.re8joymod.common.entity.EntityMia;
import com.joy187.re8joymod.common.entity.EntityMycete;
import com.joy187.re8joymod.common.entity.EntityRose;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.sql.RowSet;
import java.awt.*;
import java.util.Random;

public class ItemRoseGene extends Item {

    public ItemRoseGene() {
        super(new Item.Properties().tab(RegistryEvents.RE8GROUP).stacksTo(8));
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
//        p_77659_1_.playSound((PlayerEntity)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!p_77659_1_.isClientSide) {
            Random ran = new Random();
            int co=ran.nextInt(4);
            if(co==0)
            {
                EntityRose snowballentity = new EntityRose(EntityInit.ROSE.get(),p_77659_1_);
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
            else{
                EntityMycete snowballentity = new EntityMycete(EntityInit.MYCETE.get(),p_77659_1_);
                snowballentity.copyPosition(p_77659_2_);
                p_77659_1_.addFreshEntity(snowballentity);
            }

        }

        p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_77659_2_.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return ActionResult.sidedSuccess(itemstack, p_77659_1_.isClientSide());
    }
}
