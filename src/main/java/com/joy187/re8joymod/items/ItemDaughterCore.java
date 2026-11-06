package com.joy187.re8joymod.items;

import com.joy187.re8joymod.entity.EntitySummonDaughter;
import com.joy187.re8joymod.entity.EntitySummonSturm;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.util.CommonFunctions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;


public class ItemDaughterCore extends PickaxeItem {
    public ItemDaughterCore(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        EntitySummonDaughter e = new EntitySummonDaughter(EntityInit.SUMMONDAUGHTER.get(), p_77659_2_.level());
        e.setPos(p_77659_2_.position().x,p_77659_2_.position().y,p_77659_2_.position().z);
        BlockPos pos = new BlockPos(p_77659_2_.blockPosition());
        for(float i=1;i<=2;i+=0.5)
    		CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),p_77659_1_,pos,i);
        p_77659_2_.level().addFreshEntity(e);

        if (!p_77659_2_.getAbilities().instabuild) {
            itemstack.shrink(10000);
            if (itemstack.isEmpty()) {
                p_77659_2_.getInventory().removeItem(itemstack);
            }
        }
        return InteractionResultHolder.success(itemstack);
    }

}