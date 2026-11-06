//package com.joy187.re8joymod.event;
//
//
//import com.joy187.re8joymod.init.EntityInit;
//import net.minecraft.core.Holder;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.MobCategory;
//import net.minecraft.world.level.biome.MobSpawnSettings;
//import net.minecraftforge.common.world.ModifiableBiomeInfo;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import com.joy187.re8joymod.init.EntityInit;
//import net.minecraft.core.Registry;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.MobCategory;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.MobSpawnSettings;
//import net.minecraftforge.event.AddReloadListenerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Mod.EventBusSubscriber(modid = "re8joymod", bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class MobGenEvent {
//
//    @SubscribeEvent
//    public static void onBiomeLoading(BiomeLoadingEvent event) {
//        // 检查生物群系是否匹配
//        if (isValidBiome(event)) {
//            // 添加生物的生成规则，权重从配置文件中读取
//            event.getSpawns().addSpawn(MobCategory.MONSTER,
//                    new MobSpawnSettings.SpawnerData(EntityInit.BELA.get(), ModCommonConfig.SPAWN_Bela.get(), 1, 2));
//            event.getSpawns().addSpawn(MobCategory.MONSTER,
//                    new MobSpawnSettings.SpawnerData(EntityInit.LYCAN.get(), ModCommonConfig.SPAWN_Lycan.get(), 1, 2));
//            // 其他生物的生成规则
//        }
//    }
//
//    private static boolean isValidBiome(BiomeLoadingEvent event) {
//        // 定义允许生成的生物群系
//        List<ResourceLocation> validBiomes = List.of(
//                new ResourceLocation("re8joymod", "re8_eforest_biome"),
//                new ResourceLocation("re8joymod", "re8_wasteland_biome"),
//                new ResourceLocation("minecraft", "plains"),
//                new ResourceLocation("minecraft", "savanna"),
//                new ResourceLocation("minecraft", "sunflower_plains"),
//                new ResourceLocation("minecraft", "bamboo_jungle"),
//                new ResourceLocation("minecraft", "warped_forest"),
//                new ResourceLocation("minecraft", "dripstone_caves"),
//                new ResourceLocation("minecraft", "lush_caves"),
//                new ResourceLocation("minecraft", "deep_dark"),
//                new ResourceLocation("minecraft", "forest")
//        );
//
//        // 检查当前生物群系是否在允许列表中
//        return validBiomes.contains(event.getName());
//    }
//}