package com.joy187.re8joymod.common.init;


import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.blocks.virusgenerator.VirusGeneratorBlockEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {
    public static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);

//    public static final RegistryObject<TileEntityType<TileEntityVirusGenerator>> VIRUS_GENERATOR_BLOCK_ENTITY =
//            BLOCK_ENTITIES.register("virus_generator_block_entity",()->
//                            TileEntityType.Builder.of(FurnaceTileEntity::new, Blocks.FURNACE));
    public static RegistryObject<TileEntityType<VirusGeneratorBlockEntity>> VIRUS_GENERATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("virus_generator_block_entity", () -> TileEntityType.Builder.of(
                    VirusGeneratorBlockEntity::new, ModBlocks.VIRUS_GENERATOR_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}