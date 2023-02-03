package com.joy187.re8joymod.helper;

import net.minecraftforge.common.ForgeConfigSpec;

public final class ModConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    //public static final ForgeConfigSpec.ConfigValue<Integer> mod_integer;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_White_Pig;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Black_Pig;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Ethan;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Mia;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_RoseMary;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Chris;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Mycete;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_MMycete;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_TheHag;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Doll1;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Doll2;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Abnormal_Baby;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Bela;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Cassandra;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Daniela;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Samca;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Moroaicas;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Soldat_Zwei;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Lycan;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Sturm;


    //public static final ForgeConfigSpec.ConfigValue<String> mod_string;

    static {
        BUILDER.push("Config for Resident Evil 8 mod");

        //mod_integer = BUILDER.comment("entity.wp.name").define("Spawn Integer", 3);
        //mod_string = BUILDER.comment("This is a string. Default value is \"Joy187\".").define("Example String", "Joy187");

        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.whitepig.spawnrate", 2);
        SPAWN_Black_Pig = BUILDER.comment("Spawn Black Pig").define("entity.blackpig.spawnrate", 3);
        SPAWN_Moroaicas = BUILDER.comment("Spawn Moroaicas,Hauler,Soldat Eins").define("entity.moroaicas.spawnrate", 13);
        SPAWN_Ethan = BUILDER.comment("Spawn Ethan").define("entity.ethan.spawnrate", 1);
        SPAWN_Mia = BUILDER.comment("Spawn Mia").define("entity.mia.spawnrate", 1);
        SPAWN_RoseMary = BUILDER.comment("Spawn RoseMary").define("entity.rosemary.spawnrate", 1);
        SPAWN_Chris = BUILDER.comment("Spawn Chris Redfield").define("entity.chris.spawnrate", 1);
        SPAWN_Mycete = BUILDER.comment("Spawn Mycete").define("entity.mycete.spawnrate", 1);
        SPAWN_MMycete = BUILDER.comment("Spawn Mega Mycete").define("entity.mmycete.spawnrate", 1);
        SPAWN_TheHag = BUILDER.comment("Spawn The Hag").define("entity.hag.spawnrate", 2);
        SPAWN_Doll1 = BUILDER.comment("Spawn Doll1").define("entity.doll1.spawnrate", 3);
        SPAWN_Doll2 = BUILDER.comment("Spawn Doll2").define("entity.doll2.spawnrate", 2);
        SPAWN_Abnormal_Baby = BUILDER.comment("Spawn baby").define("entity.baby.spawnrate", 8);
        SPAWN_Bela = BUILDER.comment("Spawn Bela").define("entity.bela.spawnrate", 2);
        SPAWN_Cassandra = BUILDER.comment("Spawn Cassandra").define("entity.cassandra.spawnrate", 2);
        SPAWN_Daniela = BUILDER.comment("Spawn Daniela").define("entity.daniela.spawnrate", 2);
        SPAWN_Samca = BUILDER.comment("Spawn Samca").define("entity.samca.spawnrate", 10);
        SPAWN_Soldat_Zwei = BUILDER.comment("Spawn Moroaicas(Blood Thirsty),Soldat Zwei,Donna's Doll3,Lycan(Large),Lycan Archer(Only Spawn in the hell)").define("entity.zwei.spawnrate", 5);
        SPAWN_Lycan = BUILDER.comment("Spawn Lycan").define("entity.lycan.spawnrate", 10);
        SPAWN_Sturm = BUILDER.comment("Spawn Sturm,Soldat Panzer,Varcolac,Ada Wong").define("entity.sturm.spawnrate", 2);




//        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.wp.name", 3);
//        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.wp.name", 3);
//        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.wp.name", 3);
//        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.wp.name", 3);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
