package com.joy187.re8joymod.util;

import java.util.function.Supplier;

import com.joy187.re8joymod.init.ItemInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum CustomArmorMaterial implements ArmorMaterial{

    ARMOR_MATERIAL_HANKSUIT("hanksuit", 80, new int[]{8, 10, 12, 8}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.75F, () -> {
        return Ingredient.of(ItemInit.SLEATHER.get());
    }),
    ARMOR_MATERIAL_LEONSUIT("leonsuit", 80, new int[]{8, 10, 12, 8}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.2F, () -> {
        return Ingredient.of(Items.LEATHER);
    }),
	ARMOR_MATERIAL_MIRANDASUIT("mirandasuit", 150, new int[]{20, 40, 48, 28}, 95, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.8F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_MIRANDA1SUIT("miranda1suit", 160, new int[]{20, 49, 40, 28}, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, 15.0F, 0.9F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_DIMISUIT("dimisuit", 100, new int[]{15, 30, 40, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_HEISENSUIT("heisensuit", 100, new int[]{18, 25, 35, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 30.0F, 0.9F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_DIMI1SUIT("dimi1suit", 120, new int[]{15, 35, 25, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_ADASUIT("adamask", 80, new int[]{8, 12, 22, 14}, 50, SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.6F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	ARMOR_MATERIAL_FRANKSUIT("franksuit", 80, new int[]{8, 13, 20, 12}, 35, SoundEvents.ARMOR_EQUIP_IRON, 7.0F, 0.8F, () -> {
	      return Ingredient.of(ItemInit.BLACKFEATHER.get());
	   }),
	
	ARMOR_MATERIAL_HUMUSSUIT("humussuit", 80, new int[]{4, 6, 8, 4}, 25, SoundEvents.SLIME_BLOCK_PLACE, 1.5F, 0.2F, () -> {
		      return Ingredient.of(ItemInit.HUMUS_INGOT.get());
		   });
//	public enum ModEquipmentSlot {
//		ARMOR_MATERIAL_FRANKSUIT("franksuit", 80, new int[] {8, 13, 20, 12}, 35, SoundEvents.ARMOR_EQUIP_IRON, 7.0F, 0.8F      return Ingredient.of(Items.LEATHER);)),
//	    ARMOR_MATERIAL_MIRANDASUIT("mirandasuit", 150, new int[] {20, 40, 48, 28}, 95, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.8F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//	    ARMOR_MATERIAL_MIRANDA1SUIT("miranda1suit", 160, new int[] {20, 49, 40, 28}, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, 15.0F, 0.9F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//	    ARMOR_MATERIAL_DIMISUIT("dimisuit", 100, new int[] {15, 30, 40, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//	    ARMOR_MATERIAL_HEISENSUIT("heisensuit", 100, new int[] {18, 25, 35, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 30.0F, 0.9F, () -> Ingredient.of(Items.IRON_INGOT)),
//	    ARMOR_MATERIAL_DIMI1SUIT("dimi1suit", 120, new int[] {15, 35, 25, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//	    ARMOR_MATERIAL_ADASUIT("adamask", 80, new int[] {8, 12, 22, 14}, 50, SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get()));
//
//		ModEquipmentSlot(String string, int i, int[] js, int j, SoundEvent armorEquipIron, float f, float g,
//				Object object) {
//			// TODO Auto-generated constructor stub
//		}
//
//	}
	//public static final ArmorMaterial = C
//	ARMOR_MATERIAL_FRANKSUIT("franksuit", 80, new int[] {8, 13, 20, 12}, 35, SoundEvents.ARMOR_EQUIP_IRON, 7.0F, 0.8F, () -> Ingredient.of(ModItems.MACHINEHEARTS.get())),
//    ARMOR_MATERIAL_MIRANDASUIT("mirandasuit", 150, new int[] {20, 40, 48, 28}, 95, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.8F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//    ARMOR_MATERIAL_MIRANDA1SUIT("miranda1suit", 160, new int[] {20, 49, 40, 28}, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, 15.0F, 0.9F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//    ARMOR_MATERIAL_DIMISUIT("dimisuit", 100, new int[] {15, 30, 40, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//    ARMOR_MATERIAL_HEISENSUIT("heisensuit", 100, new int[] {18, 25, 35, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 30.0F, 0.9F, () -> Ingredient.of(Items.IRON_INGOT)),
//    ARMOR_MATERIAL_DIMI1SUIT("dimi1suit", 120, new int[] {15, 35, 25, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
//    ARMOR_MATERIAL_ADASUIT("adamask", 80, new int[] {8, 12, 22, 14}, 50, SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get()));

	  
    private static final int[] baseDurability = { 13, 15, 16, 11 };
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;
	
	
    private CustomArmorMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability, SoundEvent equipSound, 
    		float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
     }
    

    
    @Override
    public int getDefenseForType(ArmorItem.Type slot) {
        return this.armorVal[slot.getSlot().getIndex()];
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type slot) {
        return baseDurability[slot.getSlot().getIndex()] * durabilityMultiplier;
    }


    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }


    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }


    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
     }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
