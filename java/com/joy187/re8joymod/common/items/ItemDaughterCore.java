package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntitySummonDaughter;
import com.joy187.re8joymod.common.init.EntityInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ItemDaughterCore extends PickaxeItem {
    public ItemDaughterCore(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial,attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        EntitySummonDaughter e = new EntitySummonDaughter(EntityInit.SUMMONDAUGHTER.get(), p_77659_2_.level);
        e.setPos(p_77659_2_.position().x,p_77659_2_.position().y,p_77659_2_.position().z);
        BlockPos pos = new BlockPos(p_77659_2_.blockPosition());
//        for(float i=1;i<=2;i+=0.5)
//            CommonFunctions.spawnHexAround(ParticleInit.MUCUS_PARTICLE.get(),p_77659_1_,pos,i);
        p_77659_2_.level.addFreshEntity(e);

        if (!p_77659_2_.abilities.instabuild) {
            itemstack.shrink(10000);
//            if (itemstack.isEmpty()) {
//                p_77659_2_..removeItem(itemstack);
//            }
        }
        return ActionResult.success(itemstack);
    }

}