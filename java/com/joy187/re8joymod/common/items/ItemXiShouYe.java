package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemXiShouYe extends Item {
    public ItemXiShouYe(){
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(64));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);

        p_77659_2_.startUsingItem(p_77659_3_);
        p_77659_2_.addEffect(new EffectInstance(Effects.REGENERATION, 60 * 10, 2, false, true));
        p_77659_2_.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 5000, 0, false, true));
        p_77659_2_.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 4000, 2, false, true));
        p_77659_2_.addEffect(new EffectInstance(Effects.ABSORPTION, 3000, 3, false, true));
        p_77659_2_.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 3000, 3, false, true));

        itemstack.shrink(1);
        return ActionResult.consume(itemstack);
    }

    public int getUseDuration() {
        return 100;
    }

}
