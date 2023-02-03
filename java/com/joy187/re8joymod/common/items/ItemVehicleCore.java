package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityDoll1;
import com.joy187.re8joymod.common.entity.EntityGM79B;
import com.joy187.re8joymod.common.entity.HeisenCarEntity;
import com.joy187.re8joymod.common.init.EntityInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

public class ItemVehicleCore extends ItemPickaxe {
    public ItemVehicleCore(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        HeisenCarEntity e = new HeisenCarEntity(EntityInit.HEISENCAR.get(), p_77659_2_.level);
        e.setPos(p_77659_2_.position().x,p_77659_2_.position().y,p_77659_2_.position().z);
        p_77659_2_.level.addFreshEntity(e);

        if (!p_77659_2_.abilities.instabuild) {
            itemstack.shrink(10000);
            if (itemstack.isEmpty()) {
                p_77659_2_.inventory.removeItem(itemstack);
            }
        }
        return ActionResult.success(itemstack);
    }

}
