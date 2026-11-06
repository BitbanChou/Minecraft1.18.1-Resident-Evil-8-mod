package com.joy187.re8joymod.items;

import java.util.function.Supplier;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

public enum CustomItemTier implements Tier{

    TOOL_KKUKRI( 5, 1570, 10.0F, 9.0F, 80, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),

    TOOL_XUANFENG(8, 1870, 8.0F, 10.0F, 70, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_HSAW(10, 3500, 8.0F, 49.0F, 270, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_KEY2(10, 3, 10.0F, 9.0F, 40, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),

    TOOL_KEY3(15, 5, 16.0F, 19.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_SCRAP);
    }),

    TOOL_HAGWAND(5, 2090, 10.0F, 19.0F, 180, () -> {
        return Ingredient.of(Items.REDSTONE);
    }),

    TOOL_FLYPAT(4, 290, 10.0F, 4.0F, 180, () -> {
        return Ingredient.of(Items.REDSTONE);
    }),

    TOOL_ZHIHU(2, 370, 8.0F, 4.0F, 30, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    }),

    TOOL_SILIVERBLADE(5, 70, 8.0F, 12.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_DIMIHAND(8, 1670, 8.0F, 16.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_KEY(5, 1, 8.0F, 9.0F, 20, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    RE4_SICKLE(1, 101, 2.0F, 2.5F, 15, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),

    EBONY_WOODEN(0, 89, 2.0F, 0.5F, 15, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    
	PreciseAttack(3, 2, 8.0F, 10.0F, 100,() -> {
	        return Ingredient.of(Items.DIAMOND);
	});


	   private final int level; //挖掘等级
	   private final int uses;  //耐久
	   private final float speed; //攻速
	   private final float damage; //伤害
	   private final int enchantmentValue; //附魔属性值
	   private final LazyLoadedValue<Ingredient> repairIngredient; //修复材料

	   private CustomItemTier(int p_43332_, int p_43333_, float p_43334_, float p_43335_, int p_43336_, Supplier<Ingredient> p_43337_) {
	      this.level = p_43332_;
	      this.uses = p_43333_;
	      this.speed = p_43334_;
	      this.damage = p_43335_;
	      this.enchantmentValue = p_43336_;
	      this.repairIngredient = new LazyLoadedValue<>(p_43337_);
	   }

	   public int getUses() {
	      return this.uses;
	   }

	   public float getSpeed() {
	      return this.speed;
	   }

	   public float getAttackDamageBonus() {
	      return this.damage;
	   }



      public int getLevel() {
	      return this.level;
	   }

	   public int getEnchantmentValue() {
	      return this.enchantmentValue;
	   }

	   public Ingredient getRepairIngredient() {
	      return this.repairIngredient.get();
	   }

//	   @javax.annotation.Nullable public net.minecraft.tags.Tag<net.minecraft.world.level.block.Block> getTag() { return net.minecraftforge.common.ForgeHooks.getTagFromVanillaTier(this); }
}
