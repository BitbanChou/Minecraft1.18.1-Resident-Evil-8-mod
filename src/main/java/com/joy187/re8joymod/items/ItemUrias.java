package com.joy187.re8joymod.items;

import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public class ItemUrias extends AxeItem{
    public ItemUrias(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    private static final Predicate<Entity> US_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player);
    };

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(stack.getItem() instanceof ItemUrias){
            for (LivingEntity livingentity : attacker.level().getEntitiesOfClass(LivingEntity.class, attacker.getBoundingBox().inflate(8.0D), US_AREA)) {

                attacker.playSound(SoundEvents.METAL_HIT, 3.0F, 1.0F);
                livingentity.hurt(attacker.damageSources().mobAttack(attacker), CustomItemTier.TOOL_XUANFENG.getAttackDamageBonus());
            }
            return true;
        } else{
            return super.hurtEnemy(stack, target, attacker);
        }
    }

//    public void inventoryTick(ItemStack stack, Level level, Entity p_41406_, int p_41407_, boolean p_41408_) {
//        if (!level.isClientSide && stack.getItem() instanceof ItemUrias) {
//            if(p_41406_ instanceof Player){
//                if(((Player)p_41406_).getCooldowns().isOnCooldown(stack.getItem()))
//                {
//
//
//                    ((Player)p_41406_).getCooldowns().addCooldown(stack.getItem(),200);
//                }
//            }
//        }
//    }

}
