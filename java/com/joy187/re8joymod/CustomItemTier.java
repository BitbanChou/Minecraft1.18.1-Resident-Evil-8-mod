package com.joy187.re8joymod.common;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CustomItemTier implements IItemTier {

    PreciseAttack(3, 2, 8.0F, 10.0F, 100,() -> {
        return Ingredient.of(Items.DIAMOND);
    }),

    TOOL_DIMIHAND(8, 1670, 8.0F, 16.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_SILIVERBLADE(5, 70, 8.0F, 12.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_KKUKRI( 5, 1570, 10.0F, 9.0F, 80, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),

    TOOL_XUANFENG(8, 1870, 8.0F, 10.0F, 70, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_HSAW(10, 3500, 8.0F, 49.0F, 270, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),

    TOOL_KEY(5, 1, 8.0F, 9.0F, 20, () -> {
        return Ingredient.of(Items.GOLD_NUGGET);
    }),

    TOOL_KEY2(10, 3, 10.0F, 9.0F, 40, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),

    TOOL_KEY3(15, 5, 16.0F, 19.0F, 100, () -> {
        return Ingredient.of(Items.NETHERITE_SCRAP);
    }),

    EBONY_WOODEN(0, 89, 2.0F, 0.5F, 15, () -> {
        return Ingredient.of(Items.OAK_PLANKS,Items.ACACIA_PLANKS,Items.BIRCH_PLANKS,Items.JUNGLE_PLANKS);
    }),

    TOOL_HAGWAND(5, 2090, 10.0F, 19.0F, 180, () -> {
        return Ingredient.of(Items.REDSTONE);
    }),

    TOOL_FLYPAT(4, 290, 10.0F, 4.0F, 180, () -> {
        return Ingredient.of(Items.REDSTONE);
    }),

    TOOL_ZHIHU(2, 370, 8.0F, 4.0F, 30, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairMaterial;

    private CustomItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial.get();
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial;
    }
}
