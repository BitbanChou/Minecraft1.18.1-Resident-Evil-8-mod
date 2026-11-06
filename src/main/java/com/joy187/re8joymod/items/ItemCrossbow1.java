package com.joy187.re8joymod.items;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBOWShoot;
import com.joy187.re8joymod.init.ItemInit;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;


public class ItemCrossbow1 extends ProjectileWeaponItem implements Vanishable {

    public ItemCrossbow1() {
        super(new Properties().stacksTo(1));
    }
    
	public ItemCrossbow1(Properties name) {
		  super(name);
	}


    public void releaseUsing(ItemStack p_77615_1_, Level level, LivingEntity p_77615_3_, int p_77615_4_) {
        if (p_77615_3_ instanceof Player) {
            Player Player = (Player)p_77615_3_;
            boolean flag = Player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_77615_1_) > 0;
//            ItemStack itemstack = Player.getProjectile(p_77615_1_);

            ItemStack itemstack = this.findAmmo(Player);

            int i = this.getUseDuration(p_77615_1_) - p_77615_4_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_77615_1_, level, Player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ItemInit.BOWSHOOT.get().asItem());
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = Player.getAbilities().instabuild || (itemstack.getItem() instanceof ItemBOWShoot && ((ItemBOWShoot)itemstack.getItem()).isInfinite(itemstack, p_77615_1_, Player));
                    if (!level.isClientSide) {
                        ItemBOWShoot arrowitem = (ItemBOWShoot)(itemstack.getItem() instanceof ItemBOWShoot ? itemstack.getItem() : ItemInit.BOWSHOOT.get().asItem());
                        EntityBOWShoot abstractarrowentity = arrowitem.createArrow(level, itemstack, Player);

                        abstractarrowentity = customArrow(abstractarrowentity);
                        //abstractarrowentity.setItem(itemstack);
                        abstractarrowentity.shootFromRotation(Player, Player.getXRot(), Player.getYRot(), 0.2F, f * 30.0F, 0.75F);

                        abstractarrowentity.playSound( SoundEvents.ARROW_SHOOT, 2.5F,2.5F);


                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_77615_1_) > 0) {
                            abstractarrowentity.setSecondsOnFire(100);
                        }

                        p_77615_1_.hurtAndBreak(1, Player, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(Player.getUsedItemHand());
                        });


                        abstractarrowentity.level().addParticle(ParticleTypes.BUBBLE_POP, abstractarrowentity.getX(), abstractarrowentity.getY(), abstractarrowentity.getZ(), abstractarrowentity.position().x * -0.2D, 0.08D, abstractarrowentity.position().z * -0.2D);

                        level.addFreshEntity(abstractarrowentity);

                    }
                    level.playSound((Player)null, Player.getX(), Player.getY(), Player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.4F, 1.4F / (Player.getRandom().nextFloat() * 0.2F + 1.2F) + f * 0.5F);
                    if (!flag1 && !Player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            Player.getInventory().removeItem(itemstack);
                        }
                    }

                    Player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player palyerIn, InteractionHand handIn) {
        ItemStack itemstack = palyerIn.getItemInHand(handIn);
        boolean flag = !this.findAmmo(palyerIn).isEmpty();
//        boolean flag;
//        if (!(itemstack.getItem() instanceof ShootableItem)) {
//            flag=false;
//        }


        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, level, palyerIn, handIn, flag);
        if (ret != null) return ret;

        if (!palyerIn.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            palyerIn.startUsingItem(handIn);
            return InteractionResultHolder.consume(itemstack);
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

    public  EntityBOWShoot customArrow(EntityBOWShoot arrow) {
        return arrow;
    }
    public int getDefaultProjectileRange() {
        return 11;
    }

    protected ItemStack findAmmo(Player player)
    {
        if (this.isBOWShoot(player.getItemInHand(InteractionHand.OFF_HAND)))
        {
            return player.getItemInHand(InteractionHand.OFF_HAND);
        }
        else if (this.isBOWShoot(player.getItemInHand(InteractionHand.MAIN_HAND)))
        {
            return player.getItemInHand(InteractionHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i)
            {
                ItemStack itemstack = player.getInventory().getItem(i);

                if (this.isBOWShoot(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isBOWShoot(ItemStack stack)
    {
        return stack.getItem() instanceof ItemBOWShoot;
    }
	
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
    	tooltip.add(Component.nullToEmpty(ChatFormatting.GOLD+"Press 'F' to offhand for scoping."));
    	tooltip.add(Component.nullToEmpty(ChatFormatting.GOLD+"Ammo Type:BOW Shoot"));
    }
//    public UseAnim getUseAnimation(ItemStack p_40678_) {
//        return UseAnim.BOW;
//     }
}