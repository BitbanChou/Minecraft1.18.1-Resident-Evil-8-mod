package com.joy187.re8joymod.items;

import com.joy187.re8joymod.entity.EntityChief;
import com.joy187.re8joymod.entity.GrapplehookEntity;
import com.joy187.re8joymod.init.SoundInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ItemSaw extends ItemUrias{

    public ItemSaw(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    private static final Predicate<Entity> SAW_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player);
    };

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem())) {


            for (LivingEntity lvt : playerIn.level().getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(3.0D), SAW_AREA)) {
                double d00 = lvt.getX() - playerIn.getX();
                double d10 = lvt.getZ() - playerIn.getZ();
                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                lvt.hurt(playerIn.damageSources().mobAttack(playerIn),lvt.getMaxHealth()*0.25f);
                lvt.push(d00 / d20 * 4.0D, 0.2D, d10 / d20 * 4.0D);
            }

            level.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundInit.CHAINSAW.get(), SoundSource.PLAYERS, 4.5F, 4.5F / (playerIn.getRandom().nextFloat() * 0.2F + 1.2F) + 1 * 0.5F);
            playerIn.getCooldowns().addCooldown(this,120);

            itemstack.hurtAndBreak(1, playerIn, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return InteractionResultHolder.success(itemstack);
    }

}
