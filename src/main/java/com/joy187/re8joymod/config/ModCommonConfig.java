package com.joy187.re8joymod.config;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;

public class ModCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final Biome BIOME = new Biome(BUILDER);
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> FANTOM_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> FANTOM_ORE_VEIN_SIZE;
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
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Soldat_Jet;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_Angie;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SCREEN_SHAKE;
    public static final ForgeConfigSpec.ConfigValue<Float> CAN_EXECUTE;

    static {
        BUILDER.push("Configs for Resident Evil 8 Mod");

        FANTOM_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Fantom Ore Veins spawn per chunk!")
                .define("Veins Per Chunk", 6);
        FANTOM_ORE_VEIN_SIZE = BUILDER.comment("How many Fantom Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 5, 4, 10);
        
        SPAWN_White_Pig = BUILDER.comment("Spawn White Pig").define("entity.whitepig.spawnrate", 2);
        SPAWN_Black_Pig = BUILDER.comment("Spawn Black Pig").define("entity.blackpig.spawnrate", 3);
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
        SPAWN_Lycan = BUILDER.comment("Spawn Lycan").define("entity.lycan.spawnrate", 7);
        SPAWN_Sturm = BUILDER.comment("Spawn Sturm,Soldat Panzer,Varcolac,Ada Wong")
        		.define("entity.sturm.spawnrate", 2);
        
        SPAWN_Moroaicas = BUILDER.comment("Spawn Moroaicas,Hauler,Soldat Eins")
                .define("entity.moroaicas.spawnrate", 8);
        
        SPAWN_Samca = BUILDER.comment("Spawn Samca")
                .define("entity.samca.spawnrate", 6);
 
        SPAWN_Soldat_Jet = BUILDER.comment("Spawn Soldat Jet")
                .define("entity.frank4.spawnrate", 3);
        
        SPAWN_Soldat_Zwei = BUILDER.comment("Spawn Moroaicas(Blood Thirsty),Soldat Zwei,Donna's Doll3,Lycan(Large),Lycan Archer(Only Spawn in the hell)")
    		  .define("entity.zwei.spawnrate", 5);

        SPAWN_Angie = BUILDER.comment("Spawn Angie(Only Spawn in the hell)")
    		  .define("entity.angie.spawnrate", 2);

        SCREEN_SHAKE = BUILDER.comment("Determining if the screen is shaking during an earthquake.")
                .define("entity.screenshake", true);

        CAN_EXECUTE = BUILDER.comment("Determine whether an execute operation can be performed.(the percentage of an enemy's max health)")
                .define("entity.execute", 0.2f);

        BUILDER.pop();
        SPEC = BUILDER.build();
    
    }
    
    
    public static class Biome {
        public static final String BIOME = "biome";
        public ForgeConfigSpec.IntValue subBiomeChance;
        public ForgeConfigSpec.IntValue oasisChance;
        public ForgeConfigSpec.IntValue weight;

        Biome(ForgeConfigSpec.Builder builder) {
            builder.push(BIOME);
            this.subBiomeChance = builder.comment("By default 1 in 30 Sand Plains biomes can contain either an Oasis or Dead Oasis. Set to 0 to disable both oases biomes.")
                    .translation("re8.config.oaseschances")
                    .defineInRange("Oases chance", 30, 0, 10000);
            this.oasisChance = builder.comment("Sets the percentage chance for oases to generate as an Oasis. The remaining oases will generate as an Dead Oasis. Set to 0 to only get Dead Oasis or to 100 to only get Oasis")
                    .translation("atum.config.oasispercentage")
                    .defineInRange("Oasis percentage", 50, 0, 10000);
            builder.pop();
        }

        public Biome(ForgeConfigSpec.Builder builder, String biomeName, int weight) {
            builder.push(BIOME);
            builder.push(biomeName);
            this.weight = builder.defineInRange("weight", weight, -1, 1000);
            builder.pop(2);
        }
    }

}
