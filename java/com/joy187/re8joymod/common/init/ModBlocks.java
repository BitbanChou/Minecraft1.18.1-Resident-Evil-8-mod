package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.common.blocks.*;
import com.joy187.re8joymod.common.blocks.virusgenerator.VirusGeneratorBlock;
import com.joy187.re8joymod.common.world.feature.EbonyTreeGrower;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,"re8joymod");
    public static final DeferredRegister<Item> ITEMS = ModItems.ITEMS;

    public static RegistryObject<Block> UMBERLLA_BLOCK = BLOCKS.register("umberllablock",()->
            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                    .strength(5f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static RegistryObject<Block> DUNGEON_BLOCK = BLOCKS.register("dungeonwall_block",()->

            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                    .strength(8f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static RegistryObject<Block> WASTELAND_BLOCK = BLOCKS.register("wasteland_grass",()->
            new Block(AbstractBlock.Properties.of(Material.GRASS, MaterialColor.COLOR_GRAY)
                    .strength(1f, 2f).harvestTool(ToolType.SHOVEL).harvestLevel(0)
                    .sound(SoundType.GRASS)));

    public static RegistryObject<Block> WASTELAND_ROCK_BLOCK = BLOCKS.register("wasteland_rock",()->
            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                    .strength(1f, 2f).harvestTool(ToolType.PICKAXE).harvestLevel(0)
                    .sound(SoundType.STONE)));

    public static RegistryObject<Block> DENSE_WASTELAND_ROCK_BLOCK = BLOCKS.register("dense_wasteland_rock",()->
            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                    .strength(4f, 4f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
                    .sound(SoundType.STONE)));

    public static RegistryObject<Block> FANTOM_BLOCK = BLOCKS.register("fantom_block",()->
            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
                    .strength(8f, 10f).harvestTool(ToolType.PICKAXE).harvestLevel(6)
                    .sound(SoundType.STONE)));

    public static RegistryObject<Block> MYCETE_BLOCK = BLOCKS.register("mutamycete_block",()->
            new BlockMucus());

    public static RegistryObject<Block> MUCUS_BLOCK = BLOCKS.register("mucus_block",()->
            new BlockMucus());

    public static RegistryObject<Block> DHANDS_BLOCK = BLOCKS.register("dhands_block",()->
            new BlockDhands());

    public static RegistryObject<Block> PLANK_BLOCK = BLOCKS.register("plank_block",()->
            new BlockPlank());

    public static final RegistryObject<Block> DEYE_BLOCK = BLOCKS.register("deye_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(4.0F, 4.0F).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel((p_235464_0_) -> {
        return 15;
    })));

    public static final RegistryObject<Block> DLIGHT_BLOCK = BLOCKS.register("dlight_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(4.0F, 4.0F).sound(SoundType.ANVIL).requiresCorrectToolForDrops().lightLevel((p_235464_0_) -> {
        return 15;
    })));

//    public static RegistryObject<Block> VIRUS_GENERATOR_BLOCK = BLOCKS.register("virus_generator",()->
//            new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
//                    .strength(5f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(1)
//                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FACT_IRON_BLOCK = BLOCKS.register("fact_iron_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(10.0F, 200.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FACTW_BLOCK = BLOCKS.register("factorywall_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(10.0F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PALEW_BLOCK = BLOCKS.register("palewall_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(12.0F, 12.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CASTLEW_BLOCK = BLOCKS.register("castlewall_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(10.0F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));

//    public static final RegistryObject<Block> MOREAUTORSO  = BLOCKS.register("moreautorso", () ->
//            new Block((AbstractBlock.Properties.of(Material.STONE, MaterialColor.GRASS).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(3.0F, 3.0F).sound(SoundType.SLIME_BLOCK).requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> CRYSTALTORSO = registerBlock("crystaltorso", () -> new BlockCrystalTorso());
    public static final RegistryObject<Block> DIMITORSO = registerBlock("dimitorso", () -> new BlockDimiTorso());
    public static final RegistryObject<Block> HEISENTORSO = registerBlock("heisentorso", () -> new BlockHeisenTorso());
    public static final RegistryObject<Block> MOREAUTORSO = registerBlock("moreautorso", () -> new BlockMoreauTorso());
    public static final RegistryObject<Block> CMH = registerBlock("complexmechanicalheart", () -> new BlockComplexMechanicalHeart());
    public static final RegistryObject<Block> MINE = registerBlock("mine", () -> new BlockMine());

    public static final RegistryObject<Block> FANTOM_ORE = registerBlock("fantom_ore",
            () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops()));

//    public static final RegistryObject<Block> HEISENTORSO  = BLOCKS.register("heisentorso", () ->
//            new Block((AbstractBlock.Properties.of(Material.METAL, MaterialColor.GRASS).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(10.0F, 10.0F).sound(SoundType.ANVIL).requiresCorrectToolForDrops())));

//    public static final RegistryObject<Block> DIMITORSO  = BLOCKS.register("dimitorso", () ->
//            new Block((AbstractBlock.Properties.of(Material.STONE, MaterialColor.GRASS).harvestTool(ToolType.PICKAXE).harvestLevel(1).strength(5.0F, 5.0F).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops())));

//    public static final RegistryObject<Item> DIMITORSO  = ITEMS.register("dimitorso", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<Block> DESOLATE_GRASS_BLOCK = BLOCKS.register("desolate_grass",
//            () -> new FlowerBlock(Effects.HARM, 0, AbstractBlock.Properties.of(Material.GRASS).dynamicShape().noCollission().instabreak()));

    public static RegistryObject<Block> HERB_BLOCK = BLOCKS.register("herb_block",()->
            new BlockHerb(AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    //    public static final RegistryObject<Block> PINK_ROSE = registerBlock("panic_rose",
//            () -> new FlowerBlock(Effects.WITHER, 8,
//                    AbstractBlock.Properties.copy(Blocks.DANDELION).noOcclusion()), RegistryEvents.RE8GROUP);
    public static final RegistryObject<Block> PINK_ROSE = BLOCKS.register("panic_rose",
            () -> new FlowerBlock(Effects.WITHER, 8, AbstractBlock.Properties.copy(Blocks.DANDELION).noOcclusion()));

    public static final RegistryObject<Block> EBONY_LOG = BLOCKS.register("ebony_log",
            () -> new BlockWooDRotatedPillar(AbstractBlock.Properties.copy(Blocks.OAK_LOG).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = BLOCKS.register("stripped_ebony_log",
            () -> new BlockWooDRotatedPillar(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> EBONY_WOOD = BLOCKS.register("ebony_wood",
            () -> new BlockWooDRotatedPillar(AbstractBlock.Properties.copy(Blocks.OAK_WOOD).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = BLOCKS.register("stripped_ebony_wood",
            () -> new BlockWooDRotatedPillar(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> ATERRIMUS_GLASS = BLOCKS.register("aterrimus_glass", createStainedGlassFromColor(DyeColor.BLACK));

    public static final RegistryObject<Block> ATERRIMUS_GLASS_PANE = BLOCKS.register("aterrimus_glass_pane",
            () -> new BlockAterrimusPane(AbstractBlock.Properties.of(Material.GLASS).strength(0.4F).sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE).noOcclusion()));

    public static final RegistryObject<Block> EBONY_PLANKS = BLOCKS.register("ebony_planks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EBONY_LEAVES = BLOCKS.register("ebony_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> EBONY_SAPLING = BLOCKS.register("ebony_sapling",
            () -> new SaplingBlock(new EbonyTreeGrower(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> HUMUS_SAND = BLOCKS.register("humus_sand",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK)
                    .harvestTool(ToolType.SHOVEL).harvestLevel(0).strength(1.0F, 1.0F).sound(SoundType.SAND).requiresCorrectToolForDrops()));


    public static RegistryObject<Block> VIRUS_GENERATOR_BLOCK = BLOCKS.register("virus_generator",
            ()-> new VirusGeneratorBlock(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops()));

//    public static final RegistryObject<Block> RE8_PORTAL = registerBlockWithoutBlockItem("re8_portal",
//            () -> new RE8PortalBlock(AbstractBlock.Properties.of(Material.PORTAL).noCollission().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((p_235463_0_) -> {
//                return 11;
//            })));
    //public static final RegistryObject<Block> RE8_PORTAL = BLOCKS.register("re8_portal",RE8PortalBlock::new);


    public static Supplier<Block> createStainedGlassFromColor(DyeColor color) {
        return () -> new StainedGlassBlock(color, AbstractBlock.Properties.of(Material.GLASS, color).strength(0.3F)
                .sound(SoundType.GLASS).noOcclusion().isValidSpawn(ModBlocks::never).isRedstoneConductor(ModBlocks::never).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(final String name,
                                                                     final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static Boolean never(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean)false;
    }

    public static boolean never(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    private static Boolean always(BlockState p_235437_0_, IBlockReader p_235437_1_, BlockPos p_235437_2_, EntityType<?> p_235437_3_) {
        return (boolean)true;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            ItemGroup tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }


    //    public static final RegistryObject<Block> FACTW_BLOCK = BLOCKS.register("factorywall_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_WHITE).harvestTool(ToolType.PICKAXE).harvestLevel(2).strength(10.0F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));

//    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new BlockOre(AbstractBlock.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).harvestTool(ToolType.PICKAXE).harvestLevel(0).strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));

//    public static final RegistryObject<Block> EXAMLPE_BLOCK = BLOCKS
//            .register("example_block",
//                    () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
//                            .hardnessAndResistance(5f, 6f).harvestTool(ToolType.PICKAXE).harvestLevel(2)
//                            .sound(SoundType.METAL)));


}
