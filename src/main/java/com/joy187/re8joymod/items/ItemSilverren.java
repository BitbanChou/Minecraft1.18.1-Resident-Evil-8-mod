package com.joy187.re8joymod.items;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBeibaby;
import com.joy187.re8joymod.entity.EntityBela;
import com.joy187.re8joymod.entity.EntityCassandra;
import com.joy187.re8joymod.entity.EntityDaniela;
import com.joy187.re8joymod.entity.EntityRe8Dimi;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemSilverren extends SwordItem{
	public ItemSilverren() {
	    super(CustomItemTier.TOOL_SILIVERBLADE,8,-1,new Properties());
	}
	
	public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
	    if(target instanceof EntityBela || target instanceof EntityCassandra || target instanceof EntityDaniela || target instanceof EntityRe8Dimi
	        || target instanceof EntityBeibaby || target instanceof WitherBoss || target instanceof Ravager) {
	        attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30, 10, false, true));
	    }
	    return true;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("tooltip.combatknife"));
	}

}
