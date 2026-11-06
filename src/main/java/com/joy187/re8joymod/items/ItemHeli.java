package com.joy187.re8joymod.items;

import com.joy187.re8joymod.entity.EntityHeli;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ItemHeli extends PickaxeItem {
    public ItemHeli(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        EntityHeli e = new EntityHeli(EntityInit.HELI.get(), p_77659_2_.level());
        e.setPos(p_77659_2_.position().x,p_77659_2_.position().y,p_77659_2_.position().z);
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