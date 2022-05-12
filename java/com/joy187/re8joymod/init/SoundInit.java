package com.joy187.re8joymod.init;

import net.minecraftforge.registries.RegistryObject;

import com.joy187.re8joymod.Main;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {


    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);

    public static final RegistryObject<SoundEvent> ENTITY_DIMI_AMBIENT1 = build("entity.dimi.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_AMBIENT2 = build("entity.dimi.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT1 = build("entity.dimi.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT2 = build("entity.dimi.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH1 = build("entity.dimi.death1");
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH2 = build("entity.dimi.death2");

    
    private static RegistryObject<SoundEvent> build(String id)
    {
        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, id)));
    }
}
