package com.joy187.re8joymod.init;

import com.joy187.re8joymod.effects.*;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,"re8joymod");

    public static RegistryObject<MobEffect> EROSION = EFFECTS.register("erosion",()->
    {
        return new EffectErosion(MobEffectCategory.HARMFUL, 0x660033, false);
    });

    public static RegistryObject<MobEffect> DEADLY = EFFECTS.register("deadly",()->
    {
        return new EffectDeadly(MobEffectCategory.HARMFUL, 0x333333, false);
    });
    
    public static RegistryObject<MobEffect> BURN = EFFECTS.register("burn",()->
    {
        return new EffectBurn(MobEffectCategory.HARMFUL, 0x000033, false)
        		.addAttributeModifier(Attributes.MOVEMENT_SPEED, 
        		"7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.25F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    });

    public static RegistryObject<MobEffect> ZENHEART = EFFECTS.register("zen_heart",()->
    {
        return new EffectZenH(MobEffectCategory.BENEFICIAL, 0xcccc00, false);
    });

    public static RegistryObject<MobEffect> PLAGAS = EFFECTS.register("plagas",()->
    {
        return new EffectPlagas(MobEffectCategory.HARMFUL, 0x7EAAA3, false);
    });

    public static RegistryObject<MobEffect> STUN = EFFECTS.register("stun",()->
    {
        return new EffectStunOrFreeze(MobEffectCategory.HARMFUL, 0x2EAAA3, false);
    });

    public static RegistryObject<MobEffect> MIMIC = EFFECTS.register("mimic",()->
    {
        return new EffectMimic(MobEffectCategory.BENEFICIAL, 0xFFFFFF, false);
    });

	public static void register(IEventBus eventBus) {
		EFFECTS.register(eventBus);
	}
}
