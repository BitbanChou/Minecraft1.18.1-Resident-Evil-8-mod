package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntitySniperAmmo;
import com.joy187.re8joymod.common.init.ModItems;
import com.joy187.re8joymod.common.init.SoundInit;
import com.joy187.re8joymod.common.items.ItemSniper.ItemF2;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemSA110 extends ItemF2 {

    public ItemSA110(){ super();}

    public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
        if (p_77615_3_ instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)p_77615_3_;
            boolean flag = playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0;
//            ItemStack itemstack = playerentity.getProjectile(p_77615_1_);
            ItemStack itemstack = this.findAmmo(playerentity);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, p_77615_2_, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ModItems.SNIPERAMMO.get().asItem());
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (itemstack.getItem() instanceof ItemSniperAmmo && ((ItemSniperAmmo)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, playerentity));
                    if (!p_77615_2_.isClientSide) {
                        ItemSniperAmmo arrowitem = (ItemSniperAmmo)(itemstack.getItem() instanceof ItemSniperAmmo ? itemstack.getItem() : ModItems.SNIPERAMMO.get().asItem());
                        EntitySniperAmmo abstractarrowentity = arrowitem.createArrow(p_77615_2_, itemstack, playerentity);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F,  6F, 1.0F);

                        abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundInit.R2FIRE.get(), 2.0F,2.0F);
//                        if (f == 1.0F) {
//                            abstractarrowentity.setCritArrow(true);
//                        }


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                        });


                        abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.1D, abstractarrowentity.position().z * -0.2D);
                        p_77615_2_.addFreshEntity(abstractarrowentity);

                    }

                    p_77615_2_.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundInit.R2FIRE.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.removeItem(itemstack);
                        }
                    }


                    playerentity.getCooldowns().addCooldown(this, 20);

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
}
