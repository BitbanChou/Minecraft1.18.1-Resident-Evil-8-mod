package com.joy187.re8joymod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.ItemInit;

import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ItemHagWand extends SwordItem{

    public float base_cd = 0;

    public ItemHagWand(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(stack.getItem() == ItemInit.HAGWAND.get()){
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0, false, false));
            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0, true, true));
            attacker.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1, false, true));
            if(this.base_cd<5) this.base_cd+=1;
            return true;
        } else{
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if(this.base_cd==5)
        {
            if (!worldIn.isClientSide) {
                Vec3 vec3d1 = playerIn.getLookAngle();
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

        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }

    public boolean isFoil(ItemStack p_77636_1_) {
        return this.base_cd==5;
    }

//    @OnlyIn(Dist.CLIENT)
//    public void appendHoverText(ItemStack p_77624_1_, @Nullable Level p_77624_2_, List<Component> p_77624_3_, TooltipFlag p_77624_4_) {
//        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
//        ItemStack.appendEnchantmentNames(p_77624_3_, getEnchantments(p_77624_1_));
//    }
//
//    public static ListNBT getEnchantments(ItemStack p_92110_0_) {
//        CompoundNBT compoundnbt = p_92110_0_.getTag();
//        return compoundnbt != null ? compoundnbt.getList("StoredEnchantments", 10) : new ListNBT();
//    }
}