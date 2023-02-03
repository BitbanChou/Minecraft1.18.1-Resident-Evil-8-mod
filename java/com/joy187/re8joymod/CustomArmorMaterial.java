package com.joy187.re8joymod.common;


import com.joy187.re8joymod.common.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundEvent;
import java.util.function.Supplier;

public enum CustomArmorMaterial implements IArmorMaterial {
//    ARMOR_TIN("tin", 5, new int[] {1, 4, 4, 1}, 13, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemInit.TIN_INGOT.get())),
//    ARMOR_COPPER("copper", 6, new int[] {1, 4, 5, 1}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemInit.COPPER_INGOT.get())),
//    ARMOR_SILVER("silver", 13, new int[] {1, 4, 5, 1}, 24, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.of(ItemInit.SILVER_INGOT.get())),
//    ARMOR_BRONZE("bronze", 16, new int[] {2, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ItemInit.BRONZE_INGOT.get())),
//    ARMOR_STERLING("sterling", 18, new int[] {2, 5, 6, 2}, 14, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> Ingredient.of(ItemInit.STERLING_INGOT.get())),
//    ARMOR_COBALT("cobalt", 20, new int[] {2, 5, 7, 2}, 20, SoundEvents.ARMOR_EQUIP_GOLD, 0.5F, 0.0F, () -> Ingredient.of(ItemInit.COBALT_INGOT.get())),
//    ARMOR_STEEL("steel", 22, new int[] {2, 6, 7, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 1.0F, 0.1F, () -> Ingredient.of(ItemInit.STEEL_INGOT.get())),
//    ARMOR_OBSIDIAN("obsidian", 44, new int[] {2, 5, 7, 3}, 6, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.0F, 0.2F, () -> Ingredient.of(Items.OBSIDIAN)),
//    ARMOR_AMETHYST("amethyst", 22, new int[] {2, 6, 7, 2}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(ItemInit.AMETHYST_GEM.get())),
//    ARMOR_EMERALD("emerald", 24, new int[] {2, 5, 7, 3}, 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Items.EMERALD)),
//    ARMOR_TOPAZ("topaz", 26, new int[] {3, 6, 7, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.5F, 0.0F, () -> Ingredient.of(ItemInit.TOPAZ_GEM.get())),
//    ARMOR_TOURMALINE("tourmaline", 27, new int[] {2, 5, 7, 2}, 22, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.of(ItemInit.TOURMALINE_GEM.get())),
//    ARMOR_TANZANITE("tanzanite", 36, new int[] {2, 5, 6, 2}, 24, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ItemInit.TANZANITE_GEM.get())),
//    ARMOR_RUBY("ruby", 38, new int[] {2, 6, 7, 2}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ItemInit.RUBY_GEM.get())),
//    ARMOR_SAPPHIRE("sapphire", 39, new int[] {3, 6, 8, 3}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ItemInit.SAPPHIRE_GEM.get())),
//    ARMOR_MOISSANITE("moissanite", 42, new int[] {3, 7, 8, 4}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ItemInit.MOISSANITE_GEM.get())),
//    ARMOR_ONYX("onyx", 50, new int[] {3, 7, 8, 4}, 18, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(ItemInit.ONYX_GEM.get())),
//    ARMOR_TURQUOISE("turquoise", 38, new int[] {2, 6, 7, 3}, 22, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.01F, () -> Ingredient.of(ItemInit.TURQUOISE_GEM.get())),
//    ARMOR_GRAPHENE("graphene", 60, new int[] {3, 7, 8, 4}, 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.1F, () -> Ingredient.of(ItemInit.GRAPHENE_GEM.get()));
    ARMOR_MATERIAL_HUMUSSUIT("humussuit", 80, new int[]{4, 6, 8, 4}, 25, SoundEvents.SLIME_BLOCK_PLACE, 1.5F, 0.2F, () -> {
        return Ingredient.of(ModItems.HUMUS_INGOT.get());
    }),
    ARMOR_MATERIAL_FRANKSUIT("franksuit", 80, new int[] {8, 13, 20, 12}, 35, SoundEvents.ARMOR_EQUIP_IRON, 7.0F, 0.8F, () -> Ingredient.of(ModItems.MACHINEHEARTS.get())),
    ARMOR_MATERIAL_MIRANDASUIT("mirandasuit", 150, new int[] {20, 40, 48, 28}, 95, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.8F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
    ARMOR_MATERIAL_MIRANDA1SUIT("miranda1suit", 160, new int[] {20, 49, 40, 28}, 125, SoundEvents.ARMOR_EQUIP_NETHERITE, 15.0F, 0.9F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
    ARMOR_MATERIAL_DIMISUIT("dimisuit", 100, new int[] {15, 30, 40, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
    ARMOR_MATERIAL_HEISENSUIT("heisensuit", 100, new int[] {18, 25, 35, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 30.0F, 0.9F, () -> Ingredient.of(Items.IRON_INGOT)),
    ARMOR_MATERIAL_DIMI1SUIT("dimi1suit", 120, new int[] {15, 35, 25, 20}, 75, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get())),
    ARMOR_MATERIAL_ADASUIT("adamask", 80, new int[] {8, 12, 22, 14}, 50, SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.6F, () -> Ingredient.of(ModItems.BLACKFEATHER.get()));


    private static final int[] baseDurability = { 13, 15, 16, 11 };
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorVal;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private Ingredient repairIngredient;

    /**
     * Constructor that adds the armormaterial
     * @param name Armor name
     * @param durabilityMultiplier Armor durability multiplier
     * @param armorVal Armor values per body part
     * @param enchantability Armor enchantability
     * @param equipSound Armor equipping sound
     * @param toughness Armor toughness points
     * @param knockbackResistance Armor knockback resistance
     * @param repairIngredient Armor repair item
     */
    CustomArmorMaterial(String name, int durabilityMultiplier, int[] armorVal, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorVal = armorVal;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient.get();
    }

    /**
     * Gets the durability for a certain slot
     * @param slot Armor slot
     * @return Base durability times multiplier for that slot
     */
    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return baseDurability[slot.getIndex()] * durabilityMultiplier;
    }

    /**
     * Gets the defense for a certain slot
     * @param slot Armor slot
     * @return Armor value for that slot
     */
    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return this.armorVal[slot.getIndex()];
    }

    /**
     * Gets the enchantability for a certain armor
     * @return Enchantability value
     */
    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    /**
     * Gets the equip sound for a certain armor
     * @return Equip sound
     */
    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    /**
     * Gets the repair item for a certain armor
     * @return Repair item
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    /**
     * Gets the name for a certain armor
     * @return Name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the toughness value for a certain armor
     * @return Toughness value
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the knockback resistance for a certain armor
     * @return Knockback resistance value
     */
    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}