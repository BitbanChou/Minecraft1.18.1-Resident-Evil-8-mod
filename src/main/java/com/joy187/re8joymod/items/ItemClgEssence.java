package com.joy187.re8joymod.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class ItemClgEssence extends Item {

    public ItemClgEssence(Properties p_40626_) {
        super(p_40626_);
    }

    public InteractionResult useOn(UseOnContext p_40637_) {
        Level level = p_40637_.getLevel();
        BlockPos blockpos = p_40637_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(p_40637_.getClickedFace());
        if (applyBonemeal(p_40637_.getItemInHand(), level, blockpos, p_40637_.getPlayer())) {
            if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public static boolean applyBonemeal(ItemStack p_40628_, Level p_40629_, BlockPos p_40630_, Player player) {
        BlockState blockstate = p_40629_.getBlockState(p_40630_);
        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, p_40629_, p_40630_, blockstate, p_40628_);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof BonemealableBlock) {
            BonemealableBlock bonemealableblock = (BonemealableBlock)blockstate.getBlock();
            if (bonemealableblock.isValidBonemealTarget(p_40629_, p_40630_, blockstate, p_40629_.isClientSide)) {
                if (p_40629_ instanceof ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(p_40629_, p_40629_.random, p_40630_, blockstate)) {
                        bonemealableblock.performBonemeal((ServerLevel)p_40629_, p_40629_.random, p_40630_, blockstate);
                    }

                    p_40628_.hurtAndBreak(1, player, (p_40665_) -> {
                        p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                    });
                }

                return true;
            }
        }

        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);

        if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem()))
        {

            playerIn.getFoodData().eat(5,0.5F);
            playerIn.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);

            playerIn.getCooldowns().addCooldown(this,60);
            playerIn.getMainHandItem().hurtAndBreak(1, playerIn, (p_40665_) -> {
                p_40665_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return InteractionResultHolder.success(itemstack);
    }

    public static boolean growWaterPlant(ItemStack p_40632_, Level p_40633_, BlockPos p_40634_, @Nullable Direction p_40635_) {
        return false;
    }


    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.elge"));
    }

}
