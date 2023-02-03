package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.common.entity.EntityGM79B;
import com.joy187.re8joymod.common.init.ModItems;
import com.joy187.re8joymod.common.init.SoundInit;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class ItemGM79 extends ShootableItem implements IVanishable {

    public ItemGM79() {
        super(new ItemM1897.Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }


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
                    itemstack = new ItemStack(ModItems.GM79B.get().asItem());
                }

                float f = getPowerForTime(i);

                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (itemstack.getItem() instanceof ItemGM79B && ((ItemGM79B)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, playerentity));
                    if (!p_77615_2_.isClientSide) {
                        ItemGM79B arrowitem = (ItemGM79B)(itemstack.getItem() instanceof ItemGM79B ? itemstack.getItem() : ModItems.GM79B.get().asItem());
                        EntityGM79B abstractarrowentity = arrowitem.createArrow(p_77615_2_, itemstack, playerentity);
                        abstractarrowentity = customArrow(abstractarrowentity);
                        abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, f * 3.0F, 1.0F);
                        abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z);

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
                        abstractarrowentity.playSound(SoundInit.GM79PRO.get(), 2.5F, 2.5F);

                    }

                    p_77615_2_.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundInit.GM79PRO.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !playerentity.abilities.instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.removeItem(itemstack);
                        }
                    }

                    playerentity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        //Making the tooltips
        //tooltip.add("Text: " + TextFormatting.COLOR + toolMaterial.get);
        tooltip.add(ITextComponent.nullToEmpty(TextFormatting.GOLD+"Press 'F' to offhand for scoping."));
        tooltip.add(ITextComponent.nullToEmpty(TextFormatting.GOLD+"Ammo Type:GM79 Bullet"));
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        boolean flag = !this.findAmmo(p_77659_2_).isEmpty();
//        boolean flag;
//        if (!(itemstack.getItem() instanceof ShootableItem)) {
//            flag=false;
//        }


        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, p_77659_1_, p_77659_2_, p_77659_3_, flag);
        if (ret != null) return ret;

        if (!p_77659_2_.abilities.instabuild && !flag) {
            return ActionResult.fail(itemstack);
        } else {
            p_77659_2_.startUsingItem(p_77659_3_);
            return ActionResult.consume(itemstack);
        }
    }

    public static float getPowerForTime(int p_185059_0_) {
        float f = (float)p_185059_0_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }



    public int getUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }

    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public  EntityGM79B customArrow(EntityGM79B arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 15;
    }


    protected ItemStack findAmmo(PlayerEntity player)
    {
        if (this.isGM79B(player.getItemInHand(Hand.OFF_HAND)))
        {
            return player.getItemInHand(Hand.OFF_HAND);
        }
        else if (this.isGM79B(player.getItemInHand(Hand.MAIN_HAND)))
        {
            return player.getItemInHand(Hand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getContainerSize(); ++i)
            {
                ItemStack itemstack = player.inventory.getItem(i);

                if (this.isGM79B(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isGM79B(ItemStack stack)
    {
        return stack.getItem() instanceof ItemGM79B;
    }

    public void inventoryTick(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if (p_77663_3_ instanceof PlayerEntity) {
            ItemStack item = ((PlayerEntity) p_77663_3_).getItemInHand(Hand.OFF_HAND);
            if(item.getItem() == ModItems.GM79.get())
            {
                Main.PROXY.GM79Scope();
            }
            else {
                Main.PROXY.NoScope();
            }

        }
//
//        if(item.re(item)>10)
//        {
//            System.out.println("SHOOT!");
//        }
    }

}
