package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHagWand extends ItemSword{

    public float base_cd = 0;

    public ItemHagWand(IItemTier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(stack.getItem() == ModItems.HAGWAND.get()){
            target.addEffect(new EffectInstance(Effects.WITHER, 200, 0, false, false));
            attacker.addEffect(new EffectInstance(Effects.REGENERATION, 100, 0, true, true));
            attacker.addEffect(new EffectInstance(Effects.INVISIBILITY, 200, 1, false, true));
            if(this.base_cd<5) this.base_cd+=1;
            return true;
        } else{
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if(this.base_cd==5)
        {
            if (!worldIn.isClientSide) {
                Vector3d vec3d1 = playerIn.getLookAngle();
                if (vec3d1 != null)
                {
                    //playerIn.setDeltaMovement(playerIn.position().x+vec3d1.x*1.5,vec3d1.y,vec3d1.z*1.5);
                    //playerIn.;
                    playerIn.moveTo(playerIn.position().x+vec3d1.x*7.5,playerIn.position().y+vec3d1.y,playerIn.position().z+vec3d1.z*7.5);
                }
                this.base_cd=0;
            }

            playerIn.awardStat(Stats.ITEM_USED.get(this));
        }

        return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
    }

    public boolean isFoil(ItemStack p_77636_1_) {
        return this.base_cd==5;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
        ItemStack.appendEnchantmentNames(p_77624_3_, getEnchantments(p_77624_1_));
    }

    public static ListNBT getEnchantments(ItemStack p_92110_0_) {
        CompoundNBT compoundnbt = p_92110_0_.getTag();
        return compoundnbt != null ? compoundnbt.getList("StoredEnchantments", 10) : new ListNBT();
    }
}
