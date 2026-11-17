//package com.joy187.re8joymod.common.init;
//
//import com.joy187.re8joymod.Utils;
//import com.joy187.re8joymod.common.container.LightningChannelerTile;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class ModTileEntities {
//    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
//            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);
//
//    public static RegistryObject<TileEntityType<LightningChannelerTile>> LIGHTNING_CHANNELER_TILE =
//            TILE_ENTITIES.register("lightning_channeler_tile", () -> TileEntityType.Builder.of(
//                    LightningChannelerTile:: new, ModBlocks.UMBERLLA_BLOCK.get()).build(null));
//
////    public static RegistryObject<TileEntityType<TileEntityVirusGenerator>> VIRUS_GENERATOR_TILE =
////            TILE_ENTITIES.register("virus_generator_tile", () -> TileEntityType.Builder.of(
////                    TileEntityVirusGenerator:: new, ModBlocks.VIRUS_GENERATOR_BLOCK.get()).build(null));
//
//    public static void register(IEventBus eventBus) {
//        TILE_ENTITIES.register(eventBus);
//    }
//}
