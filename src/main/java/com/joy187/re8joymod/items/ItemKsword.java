package com.joy187.re8joymod.items;

import com.joy187.re8joymod.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class ItemKsword extends SwordItem{

    public float base_cd = 0;

    public ItemKsword(Tier toolMaterial, int attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    private static final Predicate<Entity> KS_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof Player);
    };

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(stack.getItem() == ItemInit.HAGWAND.get()){
            for (LivingEntity livingentity : attacker.level().getEntitiesOfClass(LivingEntity.class, attacker.getBoundingBox().inflate(6.0D), KS_AREA)) {

                attacker.playSound(SoundEvents.METAL_HIT, 3.0F, 1.0F);
                livingentity.hurt(livingentity.damageSources().mobAttack(attacker), CustomItemTier.TOOL_ZHIHU.getAttackDamageBonus());
            }
            return true;
        } else{
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.combatknife"));
    }
}