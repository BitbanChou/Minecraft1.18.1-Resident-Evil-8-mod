package com.joy187.re8joymod.common.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.UseAction;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;


public class ItemShield extends ShieldItem {

    protected static final UUID OFF_HAND_MODIFIER = UUID.fromString("9271eeea-5f74-4e12-97b6-7cf3c60ef7a0");
    protected static final UUID MAIN_HAND_MODIFIER = UUID.fromString("7d766720-0695-46c6-b320-44529f3da63f");

    public ItemShield() {
        super(new Properties().tab(RegistryEvents.RE8GROUP).stacksTo(1));
        //setRangedWeapon();
        //useable = true;
        //setMaxStackSize(1);
    }

//    public ItemShield(String name, CreativeTabs tab) {
//        super(name);
//        setRangedWeapon();
//        setCreativeTab(tab);
//        useable = true;
//        setMaxStackSize(1);
//        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
//        {
//            @OnlyIn(Dist.CLIENT)
//            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
//            {
//                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//            }
//        });
//    }

    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.BLOCK;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);
        return ActionResult.consume(itemstack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 768;
    }

    public boolean isValidRepairItem(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        return ItemTags.PLANKS.contains(p_82789_2_.getItem()) || super.isValidRepairItem(p_82789_1_, p_82789_2_);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.<Attribute, AttributeModifier>create();
        if (equipmentSlot == EquipmentSlotType.OFFHAND )
        {
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.3, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6, AttributeModifier.Operation.fromValue(0)));
        }

        if (equipmentSlot == EquipmentSlotType.MAINHAND)
        {
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6, AttributeModifier.Operation.fromValue(0)));
            //multimap.put(GlobalEntityTypeAttributes.ATTACK_DAMAGE, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6 / 2f, AttributeModifier.Operation.fromValue(0)));
        }
        return multimap;
    }
}
