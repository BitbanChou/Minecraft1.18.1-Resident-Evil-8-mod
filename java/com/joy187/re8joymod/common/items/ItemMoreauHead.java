package com.joy187.re8joymod.common.items;

import com.joy187.re8joymod.common.entity.EntityMoSpitter;
import com.joy187.re8joymod.common.init.ModItems;
import com.joy187.re8joymod.common.init.SoundInit;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.function.Predicate;


public class ItemMoreauHead extends ShootableItem implements IVanishable {

    public ItemMoreauHead() {
        super(new ItemMoreauHead.Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
    }


    public void releaseUsing(ItemStack p_77615_1_, World p_77615_2_, LivingEntity p_77615_3_, int p_77615_4_) {
        if (p_77615_3_ instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)p_77615_3_;
            boolean flag = playerentity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0;
//            ItemStack itemstack = playerentity.getProjectile(p_77615_1_);
            playerentity.addEffect(new EffectInstance(Effects.WATER_BREATHING, 200,1,true,true));

            ItemStack itemstack = this.findAmmo(playerentity);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, p_77615_2_, playerentity, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ModItems.MOSPITTER.get().asItem());
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = playerentity.abilities.instabuild || (itemstack.getItem() instanceof ItemMoSpitter && ((ItemMoSpitter)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, playerentity));
                    if (!p_77615_2_.isClientSide) {
                        ItemMoSpitter arrowitem = (ItemMoSpitter)(itemstack.getItem() instanceof ItemMoSpitter ? itemstack.getItem() : ModItems.MOSPITTER.get().asItem());

                        EntityMoSpitter abstractarrowentity = arrowitem.createArrow(p_77615_2_, itemstack, playerentity);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot, playerentity.yRot, 0.2F, f * 30.0F, 0.75F);

                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x , abstractarrowentity.position().y, abstractarrowentity.position().z);
                        abstractarrowentity.playSound(SoundInit.ENTITY_MOREAU_HURT2.get(), 2.5F,2.5F);


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
                        });


                        abstractarrowentity.level.addParticle(ParticleTypes.BUBBLE_POP, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.08D, abstractarrowentity.position().z * -0.2D);

                        p_77615_2_.addFreshEntity(abstractarrowentity);
                        playerentity.addEffect(new EffectInstance(Effects.CONDUIT_POWER, 60,1,true,true));

                    }

                    p_77615_2_.playSound((PlayerEntity)null, playerentity.getX(), playerentity.getY(), playerentity.getZ(), SoundInit.ENTITY_MOREAU_HURT2.get(), SoundCategory.PLAYERS, 1.4F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
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
        return 600;
    }


    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_OR_FIREWORK;
    }

    public  EntityMoSpitter customArrow(EntityMoSpitter arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 11;
    }


    protected ItemStack findAmmo(PlayerEntity player)
    {
        if (this.isMoSpitter(player.getItemInHand(Hand.OFF_HAND)))
        {
            return player.getItemInHand(Hand.OFF_HAND);
        }
        else if (this.isMoSpitter(player.getItemInHand(Hand.MAIN_HAND)))
        {
            return player.getItemInHand(Hand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getContainerSize(); ++i)
            {
                ItemStack itemstack = player.inventory.getItem(i);

                if (this.isMoSpitter(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isMoSpitter(ItemStack stack)
    {
        return stack.getItem() instanceof ItemMoSpitter;
    }
}