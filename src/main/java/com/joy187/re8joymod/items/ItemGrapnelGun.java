package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.GrapplehookEntity;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WebBlock;
import net.minecraft.world.level.block.state.BlockState;


public class ItemGrapnelGun extends Item  {

    public ItemGrapnelGun() {
        super(new Properties().stacksTo(1).durability(250));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem())) {
            GrapplehookEntity abstractarrowentity = new GrapplehookEntity(level, playerIn); //arrowitem.createArrow(level, itemstack, Player);

//        abstractarrowentity = customArrow(abstractarrowentity);
            //abstractarrowentity.setItem(itemstack);
            abstractarrowentity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 15.5F, 0.75F);

            abstractarrowentity.level().addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x, abstractarrowentity.position().y, abstractarrowentity.position().z);
            abstractarrowentity.playSound(SoundEvents.ARROW_SHOOT, 1F, 1F);
            abstractarrowentity.damage*=1.25;

            level.addFreshEntity(abstractarrowentity);

            if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, itemstack) > 0) {
                abstractarrowentity.setSecondsOnFire(100);
            }

            playerIn.getCooldowns().addCooldown(this,100);

            itemstack.hurtAndBreak(1, playerIn, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if (!p_43283_.isClientSide && p_43284_.getBlock() instanceof WebBlock) {
            p_43283_.removeBlock(p_43285_,false);
            p_43282_.hurtAndBreak(2, p_43286_, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack p_43084_, BlockState p_43085_) {
        if (p_43085_.is(Blocks.COBWEB) || p_43085_.getBlock() instanceof WebBlock) {
            return 10.0F;
        }
        else {
            return 1.0F;
        }
    }

    public boolean isCorrectToolForDrops(BlockState p_43087_) {
        return p_43087_.is(Blocks.COBWEB);
    }
}

