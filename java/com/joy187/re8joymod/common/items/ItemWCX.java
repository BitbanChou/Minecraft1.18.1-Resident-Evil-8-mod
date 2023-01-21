package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.common.entity.EntityRifleAmmo;
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

public class ItemWCX extends ShootableItem implements IVanishable {

    public ItemWCX() {
        super(new ItemWCX.Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
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
                    itemstack = new ItemStack(ModItems.RIFLEAMMO.get().asItem());
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (itemstack.getItem() instanceof ItemRifleAmmo && ((ItemRifleAmmo)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, playerentity));
                    if (!p_77615_2_.isClientSide) {
                        ItemRifleAmmo arrowitem = (ItemRifleAmmo)(itemstack.getItem() instanceof ItemRifleAmmo ? itemstack.getItem() : ModItems.RIFLEAMMO.get().asItem());
                        EntityRifleAmmo abstractarrowentity = arrowitem.createArrow(p_77615_2_, itemstack, playerentity);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.0F, 3.0F, 1.0F);

                        abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 2.0F,2.0F);
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

                    p_77615_2_.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundInit.REFILEFIRE.get(), SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
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
        return 500;
    }


    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public  EntityRifleAmmo customArrow(EntityRifleAmmo arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 15;
    }


    protected ItemStack findAmmo(PlayerEntity player)
    {
        if (this.isRifleAmmo(player.getItemInHand(Hand.OFF_HAND)))
        {
            return player.getItemInHand(Hand.OFF_HAND);
        }
        else if (this.isRifleAmmo(player.getItemInHand(Hand.MAIN_HAND)))
        {
            return player.getItemInHand(Hand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getContainerSize(); ++i)
            {
                ItemStack itemstack = player.inventory.getItem(i);

                if (this.isRifleAmmo(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isRifleAmmo(ItemStack stack)
    {
        return stack.getItem() instanceof ItemRifleAmmo;
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        //Making the tooltips
        //tooltip.add("Text: " + TextFormatting.COLOR + toolMaterial.get);
        tooltip.add(ITextComponent.nullToEmpty(TextFormatting.GOLD+"Press 'F' to offhand for scoping."));
        tooltip.add(ITextComponent.nullToEmpty(TextFormatting.GOLD+"Press 'Shift' to auto fire"));
        tooltip.add(ITextComponent.nullToEmpty(TextFormatting.GOLD+"Ammo Type:Rifle Ammo"));

    }

    public void inventoryTick(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {

        if (p_77663_3_ instanceof PlayerEntity) {
            ItemStack itemstack = ((PlayerEntity) p_77663_3_).getItemInHand(Hand.OFF_HAND);
            ItemStack itemstack2 = ((PlayerEntity) p_77663_3_).getItemInHand(Hand.MAIN_HAND);
            if(itemstack.getItem() == ModItems.WCX.get() || itemstack.getItem() == ModItems.DRAGOON.get())
            {
                Main.PROXY.GM79Scope();
            }
            else {
                Main.PROXY.NoScope();
            }


            if(((PlayerEntity) p_77663_3_).isShiftKeyDown() && (itemstack.getItem() == ModItems.WCX.get() || itemstack2.getItem() == ModItems.WCX.get() ||
            itemstack.getItem() == ModItems.DRAGOON.get() || itemstack2.getItem() == ModItems.DRAGOON.get()))
            {

                ItemStack ammo = this.findAmmo((PlayerEntity) p_77663_3_);
                if(((PlayerEntity) p_77663_3_).abilities.instabuild)
                {
//                    if (!itemstack.isEmpty() || flag) {
                    if (ammo.isEmpty()) {
                        ammo = new ItemStack(ModItems.RIFLEAMMO.get().asItem());
                    }
                }

                boolean flag1 = ((PlayerEntity) p_77663_3_).abilities.instabuild || (ammo.getItem() instanceof ItemRifleAmmo && ((ItemRifleAmmo)ammo.getItem()).isInfinite(ammo, itemstack, ((PlayerEntity) p_77663_3_)));
                if (!p_77663_2_.isClientSide && !ammo.isEmpty()) {
                    ItemRifleAmmo arrowitem = (ItemRifleAmmo)(ammo.getItem() instanceof ItemRifleAmmo ? ammo.getItem() : ModItems.RIFLEAMMO.get().asItem());
                    EntityRifleAmmo abstractarrowentity = arrowitem.createArrow(p_77663_2_, ammo, ((PlayerEntity) p_77663_3_));

                    abstractarrowentity = customArrow(abstractarrowentity);
                    abstractarrowentity.setItem(ammo);
                    abstractarrowentity.shootFromRotation(((PlayerEntity) p_77663_3_), ((PlayerEntity) p_77663_3_).xRot, ((PlayerEntity) p_77663_3_).yRot, 0.0F, 3.0F, 1.0F);

                    abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z);
                    abstractarrowentity.playSound(SoundInit.REFILEFIRE.get(), 2.0F,2.0F);

                    ((PlayerEntity)p_77663_3_).setDeltaMovement(Math.sin(random.nextFloat()*0.03)*0.01D,0.0D,Math.sin(0.02*random.nextFloat())*0.01D);
                    //                        if (f == 1.0F) {
//                            abstractarrowentity.setCritArrow(true);
//                        }


//                    if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
//                        abstractarrowentity.setSecondsOnFire(100);
//                    }

                    itemstack.hurtAndBreak(1, ((PlayerEntity) p_77663_3_), (p_220009_1_) -> {
                        p_220009_1_.broadcastBreakEvent(((PlayerEntity) p_77663_3_).getUsedItemHand());
                    });


                    abstractarrowentity.level.addParticle(ParticleTypes.FLAME, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.1D, abstractarrowentity.position().z * -0.2D);
                    p_77663_2_.addFreshEntity(abstractarrowentity);

                    if (!flag1 && !((PlayerEntity) p_77663_3_).abilities.instabuild) {
                        ammo.shrink(1);
                        if (ammo.isEmpty()) {
                            ((PlayerEntity) p_77663_3_).inventory.removeItem(itemstack);
                        }
                    }
                    ((PlayerEntity) p_77663_3_).awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
}
