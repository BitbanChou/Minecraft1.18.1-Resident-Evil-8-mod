package com.joy187.re8joymod.events;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.helper.ModConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Event that handles all natural entity spawning
 * @author Leronus
 */
@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class EntityEvents {
    /**
     * Called when a biome is loaded
     * @author Leronus
     */
    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent biomeLoadingEvent){
        if (biomeLoadingEvent.getName() == null){
            return;
        }

        MobSpawnInfoBuilder spawns = biomeLoadingEvent.getSpawns();
        boolean beach = biomeLoadingEvent.getCategory().equals(Biome.Category.BEACH);
        boolean river = biomeLoadingEvent.getCategory().equals(Biome.Category.RIVER);
        boolean swamp = biomeLoadingEvent.getCategory().equals(Biome.Category.SWAMP);
        boolean ocean = biomeLoadingEvent.getCategory().equals(Biome.Category.OCEAN);
        boolean savanna = biomeLoadingEvent.getCategory().equals(Biome.Category.SAVANNA);
        boolean jungle = biomeLoadingEvent.getCategory().equals(Biome.Category.JUNGLE);
        boolean plain = biomeLoadingEvent.getCategory().equals(Biome.Category.PLAINS);
        boolean taiga = biomeLoadingEvent.getCategory().equals(Biome.Category.TAIGA);
        boolean forest = biomeLoadingEvent.getCategory().equals(Biome.Category.FOREST);
        boolean de = biomeLoadingEvent.getCategory().equals(Biome.Category.DESERT);
        boolean icy = biomeLoadingEvent.getCategory().equals(Biome.Category.ICY);
        boolean nether = biomeLoadingEvent.getCategory().equals(Biome.Category.NETHER);
        boolean mesa = biomeLoadingEvent.getCategory().equals(Biome.Category.MESA);
        boolean hills = biomeLoadingEvent.getCategory().equals(Biome.Category.EXTREME_HILLS);

//        if (re8) {
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK1.get(), 4, 1, 2));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK4.get(), 3, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.SAMCA.get(), 3, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK5.get(), 2, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK6.get(), 2, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DUND2.get(), 3, 1, 2));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.ANGIE.get(), 1, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL1.get(), 1, 1, 2));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL3.get(), 4, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.THEHAG.get(), 1, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DUND.get(), 4, 1, 2));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCAN.get(), 3, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCANA.get(), 3, 1, 1));
//        }
        if(beach || river || forest || swamp){
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.SAMCA.get(),  ModConfig.SPAWN_Samca.get(), 1, 2));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DUND.get(), ModConfig.SPAWN_Moroaicas.get(), 1, 2));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK1.get(), ModConfig.SPAWN_Moroaicas.get(), 1, 2));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DUND2.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL3.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCAN1.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ADA.get(), ModConfig.SPAWN_Sturm.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK5.get(), ModConfig.SPAWN_Sturm.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK6.get(), ModConfig.SPAWN_Sturm.get(),1,1));

        }
        if(plain || savanna){
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK2.get(), ModConfig.SPAWN_Moroaicas.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK3.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.BP.get(), ModConfig.SPAWN_Black_Pig.get(),1,3));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DUND.get(), ModConfig.SPAWN_Moroaicas.get(), 1, 2));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK5.get(), ModConfig.SPAWN_Sturm.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.FRANK6.get(), ModConfig.SPAWN_Sturm.get(),1,1));
        }
        if(savanna){
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.MYCETE.get(), ModConfig.SPAWN_Mycete.get()+2,1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.BEIBABY.get(), ModConfig.SPAWN_Abnormal_Baby.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCAN.get(), ModConfig.SPAWN_Lycan.get(),1,1));

        }
//        if(ocean || swamp || icy){
////            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.MOREAU4.get(), 2, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL2.get(), 2, 1, 1));
//            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL1.get(), 1, 1, 2));
//
//        }
        if(jungle || taiga || forest){
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL1.get(), ModConfig.SPAWN_Doll1.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.BELA.get(), ModConfig.SPAWN_Bela.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.CASSANDRA.get(), ModConfig.SPAWN_Cassandra.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DANIELA.get(), ModConfig.SPAWN_Daniela.get(),1,1));
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ADA.get(), ModConfig.SPAWN_Ethan.get(),1,1));

        }
        if(de || nether || mesa){
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCAN.get(), ModConfig.SPAWN_Lycan.get(), 1, 1));
            //spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCANA.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LYCAN1.get(), ModConfig.SPAWN_Soldat_Zwei.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.VARCOLAC.get(), ModConfig.SPAWN_Sturm.get(), 1, 1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.DOLL2.get(), ModConfig.SPAWN_Doll2.get(), 1, 1));

        }
        if(hills){
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ETHAN.get(), ModConfig.SPAWN_Ethan.get(),1,1));
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.MIA.get(), ModConfig.SPAWN_Mia.get(),1,1));
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CHRIS.get(), ModConfig.SPAWN_Chris.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.MYCETE.get(), ModConfig.SPAWN_Mycete.get(),1,1));
        }
        if(nether){
            spawns.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.ROSE.get(), ModConfig.SPAWN_RoseMary.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.MMYCETE.get(), ModConfig.SPAWN_MMycete.get(),1,1));
            spawns.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.THEHAG.get(), ModConfig.SPAWN_TheHag.get(),1,1));

        }


    }
}
