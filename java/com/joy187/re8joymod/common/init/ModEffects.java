package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.common.effects.EffectDeadly;
import com.joy187.re8joymod.common.effects.EffectErosion;
import com.joy187.re8joymod.common.effects.EffectInsidiousDisease;
import com.joy187.re8joymod.common.effects.EffectZenHeart;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS,"re8joymod");

    public static RegistryObject<Effect> EROSION = EFFECTS.register("erosion",()->
    {
        return new EffectErosion(EffectType.HARMFUL, 0x660033, false);
    });
    //public static ModEffect DEADLY = new EffectDeadly(EffectType.NEUTRAL, 0x333333, false);
    public static RegistryObject<Effect> DEADLY = EFFECTS.register("deadly",()->
    {
        return new EffectDeadly(EffectType.HARMFUL, 0x333333, false);
    });

    public static RegistryObject<Effect> BURN = EFFECTS.register("burn",()->
    {
        return new EffectInsidiousDisease(EffectType.HARMFUL, 0x000033, false)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890",
            (double)-0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    });

    public static RegistryObject<Effect> ZEN_HEART = EFFECTS.register("zen_heart",()->
    {
        return new EffectZenHeart(EffectType.BENEFICIAL, 0xcccc00, false)
                .addAttributeModifier(Attributes.MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 30.0D, AttributeModifier.Operation.ADDITION);
    });
}
