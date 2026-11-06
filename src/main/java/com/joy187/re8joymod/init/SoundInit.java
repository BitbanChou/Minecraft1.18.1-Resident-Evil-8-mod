package com.joy187.re8joymod.init;

import net.minecraftforge.eventbus.api.IEventBus;
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
    
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_AMBIENT1 = build("entity.ethan.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_AMBIENT2 = build("entity.ethan.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_HURT1 = build("entity.ethan.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_HURT2 = build("entity.ethan.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_DEATH = build("entity.ethan.death");

    public static final RegistryObject<SoundEvent> ENTITY_BELA_AMBIENT = build("entity.bela.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_BELA_HURT = build("entity.bela.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_BELA_DEATH = build("entity.bela.death");

    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_AMBIENT = build("entity.cassandra.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_HURT = build("entity.cassandra.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_DEATH1 = build("entity.cassandra.death1");
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_DEATH2 = build("entity.cassandra.death2");

    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_AMBIENT1 = build("entity.daniela.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_AMBIENT2 = build("entity.daniela.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_HURT = build("entity.daniela.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_DEATH = build("entity.daniela.death");
    
    public static final RegistryObject<SoundEvent> ENTITY_BEI_AMBIENT1 = build("entity.bei.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_BEI_AMBIENT2 = build("entity.bei.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_BEI_HURT = build("entity.bei.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_BEI_DEATH1 = build("entity.bei.death1");
    public static final RegistryObject<SoundEvent> ENTITY_BEI_DEATH2 = build("entity.bei.death2");

    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_AMBIENT1 = build("entity.angie.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_AMBIENT2 = build("entity.angie.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_HURT = build("entity.angie.hurt");

    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_AMBIENT1 = build("entity.beibaby.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_AMBIENT2 = build("entity.beibaby.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_HURT = build("entity.beibaby.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_DEATH = build("entity.beibaby.death");

    public static final RegistryObject<SoundEvent> ENTITY_DOLL_AMBIENT = build("entity.doll.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_DOLL_HURT = build("entity.doll.hurt");

    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_AMBIENT1 = build("entity.moreau.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_AMBIENT2 = build("entity.moreau.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_HURT1 = build("entity.moreau.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_HURT2 = build("entity.moreau.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_DEATH = build("entity.moreau.death");

    public static final RegistryObject<SoundEvent> ENTITY_MIA_AMBIENT1 = build("entity.mia.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_MIA_AMBIENT2 = build("entity.mia.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_MIA_HURT = build("entity.mia.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_MIA_DEATH = build("entity.mia.death");

    
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT1 = build("entity.hesen.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT2 = build("entity.hesen.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT3 = build("entity.hesen.ambient3");
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_HURT1 = build("entity.hesen.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_HURT2 = build("entity.hesen.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_DEATH = build("entity.hesen.death");

    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT1 = build("entity.chris.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT2 = build("entity.chris.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT3 = build("entity.chris.ambient3");
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_HURT = build("entity.chris.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_DEATH = build("entity.chris.death");
    
    public static final RegistryObject<SoundEvent> ENTITY_HEISENCAR_ROLLING = build("entity.heisencar.rolling");
    public static final RegistryObject<SoundEvent> ENTITY_HEISENCAR_FIRING = build("entity.heisencar.firing");

    public static final RegistryObject<SoundEvent> ENTITY_DUKE_AMBIENT1 = build("entity.duke.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_AMBIENT2 = build("entity.duke.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_HURT = build("entity.duke.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_TRADE = build("entity.duke.trade");    
   
    
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT1 = build("entity.miranda.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT2 = build("entity.miranda.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT3 = build("entity.miranda.ambient3");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_HURT1 = build("entity.miranda.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_HURT2 = build("entity.miranda.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_DEATH1 = build("entity.miranda.death1");
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_DEATH2 = build("entity.miranda.death2");

    public static final RegistryObject<SoundEvent> ENTITY_ROSE_AMBIENT1 = build("entity.rosemary.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_AMBIENT2 = build("entity.rosemary.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_HURT = build("entity.rosemary.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_DEATH1 = build("entity.rosemary.death1");
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_DEATH2 = build("entity.rosemary.death2");
    
    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT1 = build("entity.ada.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT2 = build("entity.ada.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT3 = build("entity.ada.ambient3");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_DEATH = build("entity.ada.death");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_ADA4 = build("entity.ada.ada4");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_ADA4D = build("entity.ada.ada4d");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_ADA4D2 = build("entity.ada.ada4d2");
    public static final RegistryObject<SoundEvent> ENTITY_ADA_ADA4LEON = build("entity.ada.ada4leon");

    public static final RegistryObject<SoundEvent> ENTITY_CHIEF_AMBIENT1 = build("entity.chief.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_CHIEF_AMBIENT2 = build("entity.chief.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_CHIEF_DEATH = build("entity.chief.death");

    public static final RegistryObject<SoundEvent> ENTITY_LEON_AMBIENT1 = build("entity.leon.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_LEON_AMBIENT2 = build("entity.leon.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_LEON_HURT = build("entity.leon.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_LEON_ADA = build("entity.leon.leonada");

    public static final RegistryObject<SoundEvent> GM79PRO = build("entity.gm79.gm79pro");
    public static final RegistryObject<SoundEvent> M1851 = build("entity.m1851.m1851");
    public static final RegistryObject<SoundEvent> R2FIRE = build("entity.m1851.f2rifle");
    public static final RegistryObject<SoundEvent> REFILEFIRE = build("entity.m1851.rifle");
    public static final RegistryObject<SoundEvent> CHAINSAW = build("entity.gm79.chainsaw");

    public static final RegistryObject<SoundEvent> ENTITY_MERCHANT_AMBIENT1 = build("entity.merchant.merchant1");
    public static final RegistryObject<SoundEvent> ENTITY_MERCHANT_AMBIENT2 = build("entity.merchant.merchant2");
    public static final RegistryObject<SoundEvent> ENTITY_MERCHANT_AMBIENT3 = build("entity.merchant.merchant3");
    public static final RegistryObject<SoundEvent> ENTITY_MERCHANT_TRADE = build("entity.merchant.trade");

    public static final RegistryObject<SoundEvent> ENTITY_SALAZAR_AMBIENT1 = build("entity.salazar.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_SALAZAR_AMBIENT2 = build("entity.salazar.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_SALAZAR_AMBIENT3 = build("entity.salazar.ambient3");

    public static final RegistryObject<SoundEvent> ENTITY_GANADO_AMBIENT1 = build("entity.ganado.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_GANADO_AMBIENT2 = build("entity.ganado.ambient2");

    public static final RegistryObject<SoundEvent> ENTITY_ZEALOT_AMBIENT1 = build("entity.zealot.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_ZEALOT_AMBIENT2 = build("entity.zealot.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ZEALOT_DEATH = build("entity.zealot.death");

    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_AMBIENT11 = build("entity.krauser.ambient11");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_AMBIENT12 = build("entity.krauser.ambient12");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_AMBIENT21 = build("entity.krauser.ambient21");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_AMBIENT22 = build("entity.krauser.ambient22");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_HURT = build("entity.krauser.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_HURT2 = build("entity.krauser.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_KRAUSER_DEATH = build("entity.krauser.death");

    public static final RegistryObject<SoundEvent> ENTITY_SOLDI_AMBIENT1 = build("entity.soldi.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_SOLDI_AMBIENT2 = build("entity.soldi.ambient2");

    public static final RegistryObject<SoundEvent> ENTITY_SADDLER_AMBIENT1 = build("entity.saddler.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_SADDLER_AMBIENT2 = build("entity.saddler.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_SADDLER_DEATH = build("entity.saddler.death");

    public static final RegistryObject<SoundEvent> ENTITY_ASH_AMBIENT1 = build("entity.ash.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_ASH_AMBIENT2 = build("entity.ash.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_ASH_AMBIENT3 = build("entity.ash.ambient3");
    public static final RegistryObject<SoundEvent> ENTITY_ASH_HURT1 = build("entity.ash.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_ASH_HURT2 = build("entity.ash.hurt2");

    public static final RegistryObject<SoundEvent> ENTITY_LUIS_AMBIENT1 = build("entity.luis.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_LUIS_AMBIENT2 = build("entity.luis.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_LUIS_DEATH = build("entity.luis.death");

    public static final RegistryObject<SoundEvent> ENTITY_KLEE_AMBIENT1 = build("entity.klee.ambient1");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_AMBIENT2 = build("entity.klee.ambient2");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_ATTACK1 = build("entity.klee.attack");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_ATTACK2 = build("entity.klee.attack2");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_HURT = build("entity.klee.hurt");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_BENGBENG = build("entity.klee.bengbeng");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_BENGBENG2 = build("entity.klee.bengbeng2");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_HONGHONG = build("entity.klee.honghong");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_HONGHONG2 = build("entity.klee.honghong2");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_DEATH1 = build("entity.klee.death1");
    public static final RegistryObject<SoundEvent> ENTITY_KLEE_DEATH2 = build("entity.klee.death2");


//    private static RegistryObject<SoundEvent> build(String id)
//    {
//        return SOUNDS.register(id, () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, id)));
//    }

    private static RegistryObject<SoundEvent> build(String name) {
        ResourceLocation id = new ResourceLocation(Main.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
