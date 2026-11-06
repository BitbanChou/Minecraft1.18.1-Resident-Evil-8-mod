package com.joy187.re8joymod.init;

import java.util.function.Function;

import javax.annotation.Nonnull;

import com.google.common.base.Supplier;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.blocks.*;

import com.joy187.re8joymod.blocks.virusgenerator.VirusGeneratorBlock;
import com.joy187.re8joymod.world.feature.tree.EbonyTreeGrower;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Main.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

//	public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block",
//			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(5f, 6f)
//					.sound(SoundType.METAL).requiresCorrectToolForDrops()),
//			);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(5f, 6f).sound(SoundType.METAL).noLootTable()));

	public static final RegistryObject<Block> CASTLEW_BLOCK = registerBlock("castlewall_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(10f, 10f)
					.sound(SoundType.STONE).requiresCorrectToolForDrops())
			);

	public static final RegistryObject<Block> DUNGEON_BLOCK = registerBlock("dungeonwall_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(8f, 6f)
					.sound(SoundType.STONE).requiresCorrectToolForDrops())
			);

	public static final RegistryObject<Block> FACT_IRON_BLOCK = registerBlock("fact_iron_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(10f, 200f)
					.sound(SoundType.METAL).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> FACTW_BLOCK = registerBlock("factorywall_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(10f, 10f)
					.sound(SoundType.METAL).requiresCorrectToolForDrops())
			);
//
////	public static final RegistryObject<Block> PLANK_BLOCK = registerBlock("plank_block",
////			() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F)
////					.sound(SoundType.WOOD).requiresCorrectToolForDrops()),
////			);
//
	public static final RegistryObject<Block> PLANK_BLOCK = registerBlock("plank_block",
            () -> new BlockWooDRotatedPillar(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> DHANDS_BLOCK = registerBlock("dhands_block",
			() -> new BlockDhands()
			);

    public static final RegistryObject<Block> PALEW_BLOCK = registerBlock("palewall_block",
    		() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(12.0F, 12.0F)
    				.sound(SoundType.STONE).requiresCorrectToolForDrops())
    		);

    public static final RegistryObject<Block> OILDRUMS = registerBlock("oildrums",
            () -> new BlockOilDrums());

    public static final RegistryObject<Block> LIQUIDNITROGEN = registerBlock("liquidnitrogen",
            () -> new BlockLiquidNitrogen()
            );

    public static final RegistryObject<Block> TRAP = registerBlock("trapblock",
            () -> new BlockTrap()
            );

    public static final RegistryObject<Block> DLAND_SAPLING = registerBlock("dland_sapling",
            () -> new BlockDHandSapling(new EbonyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING),
                    () -> Blocks.END_STONE));

    public static final RegistryObject<Block> PINK_ROSE = registerBlock("panic_rose",
            () -> new FlowerBlock(MobEffects.WITHER, 8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));

    public static final RegistryObject<Block> EBONY_LOG = registerBlock("ebony_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG))
            );

    public static final RegistryObject<Block> EBONY_WOOD = registerBlock("ebony_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD))
            );

    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD))
            );

    public static final RegistryObject<Block> WASTELAND_BLOCK = registerBlock("wasteland_grass",
    		()-> new GrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK))
			);

    public static final RegistryObject<Block> WASTELAND_ROCK_BLOCK = registerBlock("wasteland_rock",
    		()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f, 2f)
    				.sound(SoundType.STONE).requiresCorrectToolForDrops())
			);


    public static final RegistryObject<Block> DENSE_WASTELAND_ROCK_BLOCK = registerBlock("dense_wasteland_rock",
    		()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f, 4f)
    				.sound(SoundType.STONE).requiresCorrectToolForDrops())
			);

    public static final RegistryObject<Block> FANTOM_BLOCK = registerBlock("fantom_block",
    		()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(8f, 10f)
    				.sound(SoundType.STONE).requiresCorrectToolForDrops())
			);

    public static final RegistryObject<Block> DEYE_BLOCK = registerBlock("deye_block",
    		()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f, 4f)
    				.sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel((p_235464_0_) -> {return 15;})));
//
////    public static final RegistryObject<Block> GLOWSTONE = registerBlock("glowstone", ()-> new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SAND).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_50872_) -> {
////        return 15;
////     })));

   public static final RegistryObject<Block> DLIGHT_BLOCK = registerBlock("dlight_block",
    		()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f, 5f)
    				.sound(SoundType.ANVIL).requiresCorrectToolForDrops().lightLevel((p_235464_0_) -> {return 15;}))
			);
////   public static final Block GLOWSTONE = registerBlock("glowstone", new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.SAND).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_50872_) -> {
////	      return 15;
////	   })));

    public static final RegistryObject<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

	public static final RegistryObject<Block> MYCETE_BLOCK = registerBlock("mutamycete_block",
			() -> new BlockMucus()
			);

	public static final RegistryObject<Block> MUCUS_BLOCK = registerBlock("mucus_block",
			() -> new BlockMucus());

    public static RegistryObject<Block> HERB_BLOCK = BLOCKS.register("herb_block",
    		()-> new BlockHerb(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static RegistryObject<Block> HERB2_BLOCK = BLOCKS.register("herb2_block",
            ()-> new BlockHerb2(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static RegistryObject<Block> HERB3_BLOCK = registerBlock("herb3_block",
            ()-> new BlockHerb3(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

//    //    public static final RegistryObject<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
////            () -> new BlockDHandSapling(new EbonyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING),
////                    () -> Blocks.END_STONE), Main.TUTORIAL_TAB);
    public static final RegistryObject<Block> MOREAUTORSO = registerBlock("moreautorso",
            () -> new BlockMoreauTorso());

    public static final RegistryObject<Block> HEISENTORSO = registerBlock("heisentorso",
            () -> new BlockHeisenTorso());

    public static final RegistryObject<Block> DIMITORSO = registerBlock("dimitorso",
            () -> new BlockDimiTorso());

    public static final RegistryObject<Block> CRYSTALTORSO = registerBlock("crystaltorso",
            () -> new BlockCrystalTorso());

    public static final RegistryObject<Block> CMH = registerBlock("complexmechanicalheart",
            () -> new BlockComplexMechanicalHeart());

    public static final RegistryObject<Block> MINE = registerBlock("mine",
            () -> new BlockMine());

    public static final RegistryObject<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
            () -> new SaplingBlock(new EbonyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
//    public static final Block OAK_SAPLING = registerBlock("oak_sapling",
//    		new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FANTOM_ORE = registerBlock("fantom_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 10)));

    public static final RegistryObject<Block> DEEPSLATE_FANTOM_ORE = registerBlock("deepslate_fantom_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VIRUS_GENERATOR_BLOCK = registerBlock("virus_generator",
            () -> new VirusGeneratorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

//    public static final RegistryObject<Block>  RE8_PORTAL = registerBlockWithoutBlockItem("re8_portal",
//    		BlockRe8Portal::new);

    public static final RegistryObject<Block> RE8_PORTAL = registerBlock("re8_portal",
            () -> new BlockRe8Portal(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable().noOcclusion().noCollission()));

    public static final RegistryObject<Block> HUMUS_SAND = registerBlock("humus_sand",
            BlockHumusSand::new);

//    public static final RegistryObject<Block> BLACK_STAINED_DEADWOOD_FRAMED_CRYSTAL_GLASS_PANE = registerBlock(
//    		"black_stained_deadwood_framed_crystal_glass_pane",() -> new StainedGlassPaneBlock(DyeColor.BLACK, copy(ATERRIMUS_GLASS_PANE.get())));

    public static final RegistryObject<Block> ATERRIMUS_GLASS = registerBlock(
    		"aterrimus_glass",createStainedGlassFromColor(DyeColor.BLACK)
    	);

    public static final RegistryObject<Block> ATERRIMUS_GLASS_PANE = registerBlock(
    		"aterrimus_glass_pane",BlockAterrimusPane::new
    	);

//
//	private static <T extends Block> RegistryObject<T> registerBlock(final String name,
//			final Supplier<? extends T> block) {
//		return BLOCKS.register(name, block);
//	}
//
//	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
//			Function<RegistryObject<T>, Supplier<? extends Item>> item) {
//		RegistryObject<T> obj = registerBlock(name, block);
//		ITEMS.register(name, item.apply(obj));
//		return obj;
//	}
//
//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn, tab);
//        return toReturn;
//    }
//
//    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
//                                                                            CreativeModeTab tab) {
//        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
//                new Item.Properties().tab(tab)));
//    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static Supplier<Block> createStainedGlassFromColor(DyeColor color) {
        return () -> new StainedGlassBlock(color, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3F)
        		.sound(SoundType.GLASS).noOcclusion().isValidSpawn(BlockInit::never).isRedstoneConductor(BlockInit::never).isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never));
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }


    public static boolean always(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

//    public static boolean never(BlockState state, BlockGetter reader, BlockPos pos) {
//        return false;
//    }

//    public static boolean always(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entityType) {
//        return true;
//    }
//

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
