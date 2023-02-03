package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUND_TYPES = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> ENTITY_DIMI_AMBIENT1 = SOUND_TYPES.register(
            "entity.dimi.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_AMBIENT2 = SOUND_TYPES.register(
            "entity.dimi.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT1 = SOUND_TYPES.register(
            "entity.dimi.hurt1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.hurt1")));
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_HURT2 = SOUND_TYPES.register(
            "entity.dimi.hurt2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.hurt2")));
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH1 = SOUND_TYPES.register(
            "entity.dimi.death1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.death1")));
    public static final RegistryObject<SoundEvent> ENTITY_DIMI_DEATH2 = SOUND_TYPES.register(
            "entity.dimi.death2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.dimi.death2")));


    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_AMBIENT1 = SOUND_TYPES.register(
            "entity.ethan.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ethan.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_AMBIENT2 = SOUND_TYPES.register(
            "entity.ethan.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ethan.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_HURT1 = SOUND_TYPES.register(
            "entity.ethan.hurt1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ethan.hurt1")));
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_HURT2 = SOUND_TYPES.register(
            "entity.ethan.hurt2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ethan.hurt2")));
    public static final RegistryObject<SoundEvent> ENTITY_ETHAN_DEATH = SOUND_TYPES.register(
            "entity.ethan.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ethan.death")));

    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_AMBIENT1 = SOUND_TYPES.register(
            "entity.moreau.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.moreau.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_AMBIENT2 = SOUND_TYPES.register(
            "entity.moreau.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.moreau.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_HURT1 = SOUND_TYPES.register(
            "entity.moreau.hurt1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.moreau.hurt1")));
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_HURT2 = SOUND_TYPES.register(
            "entity.moreau.hurt2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.moreau.hurt2")));
    public static final RegistryObject<SoundEvent> ENTITY_MOREAU_DEATH = SOUND_TYPES.register(
            "entity.moreau.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.moreau.death")));

    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT1 = SOUND_TYPES.register(
            "entity.hesen.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT2 = SOUND_TYPES.register(
            "entity.hesen.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_AMBIENT3 = SOUND_TYPES.register(
            "entity.hesen.ambient3", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.ambient3")));
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_HURT1 = SOUND_TYPES.register(
            "entity.hesen.hurt1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.hurt1")));
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_HURT2 = SOUND_TYPES.register(
            "entity.hesen.hurt2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.hurt2")));
    public static final RegistryObject<SoundEvent> ENTITY_HESEN_DEATH = SOUND_TYPES.register(
            "entity.hesen.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.hesen.death")));

    public static final RegistryObject<SoundEvent> ENTITY_BEI_AMBIENT1 = SOUND_TYPES.register(
            "entity.bei.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bei.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_BEI_AMBIENT2 = SOUND_TYPES.register(
            "entity.bei.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bei.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_BEI_HURT = SOUND_TYPES.register(
            "entity.bei.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bei.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_BEI_DEATH1 = SOUND_TYPES.register(
            "entity.bei.death1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bei.death1")));
    public static final RegistryObject<SoundEvent> ENTITY_BEI_DEATH2 = SOUND_TYPES.register(
            "entity.bei.death2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bei.death2")));

    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_AMBIENT1 = SOUND_TYPES.register(
            "entity.angie.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.angie.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_AMBIENT2 = SOUND_TYPES.register(
            "entity.angie.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.angie.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_ANGIE_HURT = SOUND_TYPES.register(
            "entity.angie.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.angie.hurt")));


    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_AMBIENT1 = SOUND_TYPES.register(
            "entity.beibaby.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.beibaby.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_AMBIENT2 = SOUND_TYPES.register(
            "entity.beibaby.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.beibaby.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_HURT = SOUND_TYPES.register(
            "entity.beibaby.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.beibaby.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_BEIBABY_DEATH = SOUND_TYPES.register(
            "entity.beibaby.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.beibaby.death")));


    public static final RegistryObject<SoundEvent> ENTITY_BELA_AMBIENT = SOUND_TYPES.register(
            "entity.bela.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bela.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_BELA_HURT = SOUND_TYPES.register(
            "entity.bela.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bela.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_BELA_DEATH = SOUND_TYPES.register(
            "entity.bela.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.bela.death")));

    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_AMBIENT = SOUND_TYPES.register(
            "entity.cassandra.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.cassandra.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_HURT = SOUND_TYPES.register(
            "entity.cassandra.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.cassandra.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_DEATH1 = SOUND_TYPES.register(
            "entity.cassandra.death1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.cassandra.death1")));
    public static final RegistryObject<SoundEvent> ENTITY_CASSANDRA_DEATH2 = SOUND_TYPES.register(
            "entity.cassandra.death2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.cassandra.death2")));

    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_AMBIENT1 = SOUND_TYPES.register(
            "entity.daniela.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.daniela.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_AMBIENT2 = SOUND_TYPES.register(
            "entity.daniela.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.daniela.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_HURT = SOUND_TYPES.register(
            "entity.daniela.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.daniela.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_DANIELA_DEATH = SOUND_TYPES.register(
            "entity.daniela.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.daniela.death")));

    public static final RegistryObject<SoundEvent> ENTITY_DOLL_AMBIENT = SOUND_TYPES.register(
            "entity.doll.ambient", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.doll.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_DOLL_HURT = SOUND_TYPES.register(
            "entity.doll.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.doll.hurt")));


    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT1 = SOUND_TYPES.register(
            "entity.chris.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.chris.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT2 = SOUND_TYPES.register(
            "entity.chris.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.chris.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_HURT = SOUND_TYPES.register(
            "entity.chris.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.chris.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_DEATH = SOUND_TYPES.register(
            "entity.chris.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.chris.death")));
    public static final RegistryObject<SoundEvent> ENTITY_CHRIS_AMBIENT3 = SOUND_TYPES.register(
            "entity.chris.ambient3", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.chris.ambient3")));


    public static final RegistryObject<SoundEvent> ENTITY_MIA_AMBIENT1 = SOUND_TYPES.register(
            "entity.mia.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.mia.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_MIA_AMBIENT2 = SOUND_TYPES.register(
            "entity.mia.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.mia.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_MIA_HURT = SOUND_TYPES.register(
            "entity.mia.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.mia.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_MIA_DEATH = SOUND_TYPES.register(
            "entity.mia.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.mia.death")));

    public static final RegistryObject<SoundEvent> ENTITY_ROSE_AMBIENT1 = SOUND_TYPES.register(
            "entity.rosemary.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.rosemary.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_AMBIENT2 = SOUND_TYPES.register(
            "entity.rosemary.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.rosemary.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_HURT = SOUND_TYPES.register(
            "entity.rosemary.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.rosemary.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_DEATH1 = SOUND_TYPES.register(
            "entity.rosemary.death1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.rosemary.death1")));
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_DEATH2 = SOUND_TYPES.register(
            "entity.rosemary.death2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.rosemary.death2")));

    public static final RegistryObject<SoundEvent> GM79PRO = SOUND_TYPES.register(
            "entity.gm79.gm79pro", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.gm79.gm79pro")));
    public static final RegistryObject<SoundEvent> M1851 = SOUND_TYPES.register(
            "entity.m1851.m1851", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.m1851.m1851")));
    public static final RegistryObject<SoundEvent> R2FIRE = SOUND_TYPES.register(
            "entity.m1851.f2rifle", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.m1851.f2rifle")));
    public static final RegistryObject<SoundEvent> REFILEFIRE = SOUND_TYPES.register(
            "entity.m1851.rifle", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.m1851.rifle")));


    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT1 = SOUND_TYPES.register(
            "entity.miranda.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT2 = SOUND_TYPES.register(
            "entity.miranda.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_AMBIENT3 = SOUND_TYPES.register(
            "entity.miranda.ambient3", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.ambient3")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_HURT1 = SOUND_TYPES.register(
            "entity.miranda.hurt1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.hurt1")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_HURT2 = SOUND_TYPES.register(
            "entity.miranda.hurt2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.hurt2")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_DEATH1 = SOUND_TYPES.register(
            "entity.miranda.death1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.death1")));
    public static final RegistryObject<SoundEvent> ENTITY_MIRA_DEATH2 = SOUND_TYPES.register(
            "entity.miranda.death2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.miranda.death2")));

    public static final RegistryObject<SoundEvent> ENTITY_HEISENCAR_ROLLING = SOUND_TYPES.register(
            "entity.heisencar.rolling", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.heisencar.rolling")));
    public static final RegistryObject<SoundEvent> ENTITY_HEISENCAR_FIRING = SOUND_TYPES.register(
            "entity.heisencar.firing", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.heisencar.firing")));

    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT1 = SOUND_TYPES.register(
            "entity.ada.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ada.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT2 = SOUND_TYPES.register(
            "entity.ada.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ada.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_ADA_AMBIENT3 = SOUND_TYPES.register(
            "entity.ada.ambient3", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ada.ambient3")));
    public static final RegistryObject<SoundEvent> ENTITY_ADA_DEATH = SOUND_TYPES.register(
            "entity.ada.death", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.ada.death")));

    public static final RegistryObject<SoundEvent> ENTITY_DUKE_AMBIENT1 = SOUND_TYPES.register(
            "entity.duke.ambient1", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.duke.ambient1")));
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_AMBIENT2 = SOUND_TYPES.register(
            "entity.duke.ambient2", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.duke.ambient2")));
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_HURT = SOUND_TYPES.register(
            "entity.duke.hurt", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.duke.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_DUKE_TRADE = SOUND_TYPES.register(
            "entity.duke.trade", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "entity.duke.trade")));


    //    public static final RegistryObject<SoundEvent> DYING_DUCK_SOUND = SOUND_TYPES.register(
//            "dying_duck_sound", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "dying_duck_sound")));
//    public static final RegistryObject<SoundEvent> HURT_DUCK_SOUND = SOUND_TYPES.register(
//            "hurt_duck_sound", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "hurt_duck_sound")));
//
//    public static final RegistryObject<SoundEvent> DARUDE_SANDSTORM = SOUND_TYPES.register(
//            "darude_sandstorm", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "darude_sandstorm")));
//    public static final RegistryObject<SoundEvent> RICK_ASTLEY = SOUND_TYPES.register(
//            "rick_astley", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "rick_astley")));
//    public static final RegistryObject<SoundEvent> CRAZY_FROG = SOUND_TYPES.register(
//            "crazy_frog", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "crazy_frog")));
//    public static final RegistryObject<SoundEvent> IM_BLUE = SOUND_TYPES.register(
//            "im_blue", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "im_blue")));
//    public static final RegistryObject<SoundEvent> MY_HORSE = SOUND_TYPES.register(
//            "my_horse", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "my_horse")));
//
//    public static final RegistryObject<SoundEvent> THAT_DUCK = SOUND_TYPES.register(
//            "that_duck", () -> new SoundEvent(new ResourceLocation(Mores.MOD_ID, "that_duck")));
}
