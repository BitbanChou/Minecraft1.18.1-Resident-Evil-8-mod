package com.joy187.re8joymod.common.init;

import com.joy187.re8joymod.common.CustomArmorMaterial;
import com.joy187.re8joymod.common.CustomItemTier;
import com.joy187.re8joymod.common.items.*;
import com.joy187.re8joymod.common.items.ItemSniper.ItemF2;
import com.joy187.re8joymod.common.items.armor.*;
import com.joy187.re8joymod.common.items.itemBook.ItemStoryBook;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"re8joymod");


    public static RegistryObject<Item> BOTTLE1 = ITEMS.register("bottle1",()->
    {
        return new ItemTorsoFlask();
    });


    public static RegistryObject<Item> BOTTLE2 = ITEMS.register("bottle2",()->
    {
        return new ItemHeadFlask();
    });

    public static RegistryObject<Item> BOTTLE3 = ITEMS.register("bottle3",()->
    {
        return new ItemArmsFlask();
    });

    public static RegistryObject<Item> BOTTLE4 = ITEMS.register("bottle4",()->
    {
        return new ItemLegsFlask();
    });

    public static RegistryObject<Item> WINE = ITEMS.register("wine",()->
    {
        return new ItemWine();
    });

    public static RegistryObject<Item> XISHOUYE = ITEMS.register("xishouye",()->
    {
        return new ItemXiShouYe();
    });

    public static RegistryObject<Item> ROSEGENE = ITEMS.register("rosegene",()->
    {
        return new ItemRoseGene();
    });

    public static RegistryObject<Item> RESHIELD = ITEMS.register("reshield",()->
    {
        return new ItemShield();
    });

    public static RegistryObject<Item> SWATSHIELD = ITEMS.register("swatshield",()->
    {
        return new ItemShield();
    });

    public static RegistryObject<Item> PREATTACK = ITEMS.register("preciseattack",()->
    {
        return new ItemPreAttack();
    });

    public static RegistryObject<Item> GM79 = ITEMS.register("gm79",()->
    {
        return new ItemGM79();
    });

    public static RegistryObject<Item> GM79B = ITEMS.register("gm79b",()->
    {
        return new ItemGM79B();
    });

    public static RegistryObject<Item> CIGAR = ITEMS.register("cigar",()->
    {
        return new ItemCigar();
    });

    public static RegistryObject<Item> M1851 = ITEMS.register("m1851",()->
    {
        return new ItemM1851();
    });

    public static RegistryObject<Item> STAKE = ITEMS.register("stake",()->
    {
        return new ItemM1851();
    });

    public static RegistryObject<Item> BERETTA92FS = ITEMS.register("beretta92fs",()->
    {
        return new ItemM1851();
    });

    public static RegistryObject<Item> M1851B = ITEMS.register("m1851b",()->
    {
        return new ItemM1851B();
    });

    public static RegistryObject<Item> M1897 = ITEMS.register("m1897",()->
    {
        return new ItemM1897();
    });

    public static RegistryObject<Item> W870 = ITEMS.register("w870",()->
    {
        return new ItemM1897();
    });

    public static RegistryObject<Item> SYG12 = ITEMS.register("syg12",()->
    {
        return new ItemM1897();
    });

    public static RegistryObject<Item> M1897B = ITEMS.register("m1897b",()->
    {
        return new ItemM1897B();
    });

//    public static final RegistryObject<Item> MOREAUHEAD  = ITEMS.register("moreauhead", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));
    public static RegistryObject<Item> MOREAUHEAD = ITEMS.register("moreauhead",()->
    {
        return new ItemMoreauHead();
    });

    public static RegistryObject<Item> MOSPITTER = ITEMS.register("mospitter",()->
    {
        return new ItemMoSpitter();
    });

    public static RegistryObject<Item> MOPRO= ITEMS.register("mopro",()->
    {
        return new ItemMoreauProjectrile();
    });

    public static RegistryObject<Item> BOWSHOOT = ITEMS.register("bowa",()->
    {
        return new ItemBOWShoot();
    });

    public static RegistryObject<Item> CROSSBOW1 = ITEMS.register("crossbow1",()->
    {
        return new ItemCrossbow();
    });

    public static RegistryObject<Item> PIPEB = ITEMS.register("pipeb",()->
    {
        return new ItemPipeb();
    });

    public static RegistryObject<Item> BLACKBALL = ITEMS.register("blackball",()->
    {
        return new ItemBlackball();
    });

    public static RegistryObject<Item> EVIRUS = ITEMS.register("evirus",()->
    {
        return new ItemEvirus();
    });

    public static RegistryObject<Item> SNIPERAMMO = ITEMS.register("sniperammo",()->
    {
        return new ItemSniperAmmo();
    });

    public static RegistryObject<Item> RIFLEAMMO = ITEMS.register("rifleammo",()->
    {
        return new ItemRifleAmmo();
    });
//    public static final RegistryObject<Item> MOSPITTER  = ITEMS.register("mospitter", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static RegistryObject<Item> MACHINEHEARTS = ITEMS.register("machinehearts",()->
//    {
//        return new ItemRiser();
//    });



    public static final RegistryObject<Item> DESOLATE_GRASS_BLOCK  = ITEMS.register("desolate_grass", () ->
        new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> MACHINEHEARTS  = ITEMS.register("machinehearts", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> MACHINEHEARTB  = ITEMS.register("machineheartb", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> HERBGLASSES  = ITEMS.register("herbglass", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> LEI = ITEMS.register("lei", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> LEI2 = ITEMS.register("lei2", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> BLACKFEATHER = ITEMS.register("blackfeather", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> LYEYE = ITEMS.register("lyeye", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> BLACKSHEEP = ITEMS.register("blacksheep", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> BLACKSHEEPB = ITEMS.register("blacksheepbody", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> BLACKSHEEPH = ITEMS.register("blacksheephead", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<Item> DIMITORSO  = ITEMS.register("dimitorso", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> SOLARDISK  = ITEMS.register("solar_disk", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> HUMUS = ITEMS.register("humus", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> FANTOM_INGOT = ITEMS.register("fantom_ingot", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<Item> RUSTEDPART = ITEMS.register("rustedpart", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> RUSTEDPART = ITEMS.register("rustedpart", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(1).saturationMod(0.1F).
            effect(() -> new EffectInstance(ModEffects.EROSION.get(), 20*10, 2,false,true), 1.0F).
            alwaysEat().build())));

//    public static final RegistryObject<Item> SUMMONFRANK5_SPAWN_EGG = ITEMS.register("summonfrank5_core",
//            () -> new ItemSummonFrank5Core(CustomItemTier.TOOL_KEY2,2,-1.5F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> SUMMONDAUGHTER_SPAWN_EGG = ITEMS.register("summonbcd_core",
            () -> new ItemDaughterCore(CustomItemTier.TOOL_KEY2,2,-1.5F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));


    public static final RegistryObject<Item> CRYSTALSKULL = ITEMS.register("crystalskull", () ->
            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<Item> OBBOAT = ITEMS.register("obboat", () ->
//    {
//        return new ItemObBoat();
//    });
//    public static final RegistryObject<Item> MOREAUTORSO  = ITEMS.register("moreautorso", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<Item> HEISENTORSO  = ITEMS.register("heisentorso", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<Item> HEISENCAR = ITEMS.register("heisencar", () ->
//            new ItemHeisenCar(new Item.Properties().tab(RegistryEvents.RE8GROUP), BoatEntity.Type.OAK));

    public static final RegistryObject<Item> MCHEESE = ITEMS.register("mcheese", () -> new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(4).saturationMod(2.5F).
            effect(() -> new EffectInstance(Effects.REGENERATION, 200, 0,false,true), 1.0F).
            effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 1000, 1,false,true), 1.0F).
            effect(() -> new EffectInstance(Effects.WATER_BREATHING, 20*60*10, 2), 1.0F).
            effect(() -> new EffectInstance(Effects.CONFUSION, 300, 3,false,true), 1.0F).
            effect(() -> new EffectInstance(Effects.CONDUIT_POWER, 600, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> HERBFISH = ITEMS.register("herbfish", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(10).saturationMod(0.6F).
            effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 20*60, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> BIRDANDPILAF = ITEMS.register("birdandbeastpilaf", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(10).saturationMod(0.5F).
            effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*60, 1,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> THREEFLAVOR = ITEMS.register("threeflavoredmititei", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(12).saturationMod(0.8F).
            effect(() -> new EffectInstance(Effects.REGENERATION, 20*45, 3,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> TOCH = ITEMS.register("tochituradepui", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 20*300, 3,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> CIOR = ITEMS.register("ciorbadeporc", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*300, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> SARMAL = ITEMS.register("sarmaledepeste", () -> new Item(new Item.Properties().
            tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 20*300, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));
//    public static final RegistryObject<Item> HERB = ITEMS.register("herb1", () -> new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(2).saturationMod(0.5F).alwaysEat().build())));


    public static final RegistryObject<Item> HERB = ITEMS.register("herb1",
            ()-> new BlockItem(ModBlocks.HERB_BLOCK.get(),new Item.Properties()
                    .tab(RegistryEvents.RE8GROUP).food(new Food.Builder().nutrition(2).saturationMod(0.5F).alwaysEat().build())
            ));



    //Tool
    public static final RegistryObject<Item> DIMIHANBLADE  = ITEMS.register("dimihand", () ->
            new ItemSword(CustomItemTier.TOOL_DIMIHAND, 3, -2.0F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> URIASSHAMMER  = ITEMS.register("uriasshammer", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 34, -3.6F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> XUANFENGAXE  = ITEMS.register("xuanfengaxe", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 23, -3.2F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> FENBAOCHUI  = ITEMS.register("hammer", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 23, -3.2F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> URIASHAMMER  = ITEMS.register("uriashammer", () ->
            new ItemUrias(CustomItemTier.TOOL_KKUKRI, 30, -3.5F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> HSAW  = ITEMS.register("muhesenweap", () ->
            new ItemHSaw(CustomItemTier.TOOL_HSAW, 1, -3.3F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> FRANKDRILL  = ITEMS.register("frankdrill", () ->
            new ItemHSaw(CustomItemTier.TOOL_ZHIHU, 1, -2.2F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> FLYPAT  = ITEMS.register("flypat", () ->
            new ItemFlyPat(CustomItemTier.TOOL_FLYPAT, 1, -1.9F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> HAGWAND  = ITEMS.register("thehagwand", () ->
            new ItemHagWand(CustomItemTier.TOOL_HAGWAND, 1, -2.0F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<ItemPickaxe> KEY = ITEMS.register("abor_shovel",
//            () -> new ItemPickaxe(CustomItemTier.TOOL_KEY, 1, -2.8F, new Item.Properties().tab(RegistryEvents.RE8GROUP)));
    public static final RegistryObject<ItemPickaxe> KEY = ITEMS.register("labor_shovel",
            () -> new ItemRiser(CustomItemTier.TOOL_KEY,1,-2,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<ItemPickaxe> KEY2 = ITEMS.register("labor_shovel2",
            () -> new ItemRiser2(CustomItemTier.TOOL_KEY2,1,-1.8F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<ItemPickaxe> KEY3 = ITEMS.register("labor_shovel3",
            () -> new ItemRiser3(CustomItemTier.TOOL_KEY3,2,-1.5F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    //public static final RegistryObject<Item> STORYBOOK = ITEMS.register("storybook", ItemStoryBook::new);

//    public static final RegistryObject<Item> STORYBOOK  = ITEMS.register("storybook", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> STORYBOOK = ITEMS.register("storybook",
            () -> new ItemStoryBook(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static RegistryObject<Item> F2RIFLE = ITEMS.register("f2rifle",()->
    {
        return new ItemF2();
    });

    public static RegistryObject<Item> SA110 = ITEMS.register("sa110",()->
    {
        return new ItemSA110();
    });

    public static RegistryObject<Item> WCX = ITEMS.register("wcx",()->
    {
        return new ItemWCX();
    });

    public static RegistryObject<Item> DRAGOON = ITEMS.register("dragoon",()->
    {
        return new ItemWCX();
    });

    public static final RegistryObject<Item> SLIVERREN  = ITEMS.register("silverren", () ->
            new ItemSilverren());

    public static final RegistryObject<Item> EBONY_WOODEN_SWORD = ITEMS.register("ebony_wooden_sword",
            () -> new EbonySwordItem(CustomItemTier.EBONY_WOODEN, 2, 3f,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> EBONY_WOODEN_PICKAXE = ITEMS.register("ebony_wooden_pickaxe",
            () -> new PickaxeItem(CustomItemTier.EBONY_WOODEN, 1, 1f,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> EBONY_WOODEN_SHOVEL = ITEMS.register("ebony_wooden_shovel",
            () -> new ShovelItem(CustomItemTier.EBONY_WOODEN, 0, 1f,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> EBONY_WOODEN_AXE = ITEMS.register("ebony_wooden_axe",
            () -> new AxeItem(CustomItemTier.EBONY_WOODEN, 4, 0f,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> EBONY_WOODEN_HOE = ITEMS.register("ebony_wooden_hoe",
            () -> new HoeItem(CustomItemTier.EBONY_WOODEN, 0, 0f,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<ItemPickaxe> HCKEY = ITEMS.register("vehicle_core",
            () -> new ItemVehicleCore(CustomItemTier.TOOL_KEY3,2,-1.5F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> FRANK5KEY  = ITEMS.register("summonfrank5_core", () ->
            new ItemSummonFrank5Core(CustomItemTier.TOOL_KEY2,2,-1.5F,new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<Item> DIMIKEY  = ITEMS.register("summonbcd_core", () ->
//            new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));
    public static final RegistryObject<Item> HUMUS_INGOT = ITEMS.register("humus_ingot",
        () -> new Item(new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<Item> CRYSTALHAMMER = ITEMS.register("crystalhammer", () ->
            new ItemCrystalHammer(CustomItemTier.TOOL_XUANFENG, 29, -2.9F,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
    //Armor
//    public static final RegistryObject<Item> DIMI_HAT = ITEMS.register("dimihat", () -> new ItemArmor(CustomArmorMaterial.ARMOR_MATERIAL_DIMISUIT, EquipmentSlotType.HEAD, (new Item.Properties()).tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<Item> TIN_CHESTPLATE = ITEMS.register("tin_chestplate", () -> new ItemArmor(ArmorMaterial.ARMOR_TIN, EquipmentSlotType.CHEST, (new Item.Properties()).tab(MoresTabs.MORES_ARMOR)));
//    public static final RegistryObject<Item> TIN_LEGGINGS = ITEMS.register("tin_leggings", () -> new ItemArmor(ArmorMaterial.ARMOR_TIN, EquipmentSlotType.LEGS, (new Item.Properties()).tab(MoresTabs.MORES_ARMOR)));
//    public static final RegistryObject<Item> TIN_BOOTS = ITEMS.register("tin_boots", () -> new ItemArmor(ArmorMaterial.ARMOR_TIN, EquipmentSlotType.FEET, (new Item.Properties()).tab(MoresTabs.MORES_ARMOR)));


    public static final RegistryObject<Item> DIMI_HAT = ITEMS.register("dimihat",
            () -> new ArmorDimiHat(CustomArmorMaterial.ARMOR_MATERIAL_DIMISUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> DIMI_SUIT = ITEMS.register("dimisuit",
            () -> new ArmorDimiSuit(CustomArmorMaterial.ARMOR_MATERIAL_DIMI1SUIT,EquipmentSlotType.CHEST,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> MIRANDA_MASK = ITEMS.register("mirandamask",
            () -> new ArmorModelMirandaMask(CustomArmorMaterial.ARMOR_MATERIAL_MIRANDASUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> MIRANDA_SUIT = ITEMS.register("mirandasuit",
            () -> new ArmorMirandaSuit(CustomArmorMaterial.ARMOR_MATERIAL_MIRANDA1SUIT,EquipmentSlotType.CHEST,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> HEISEN_HEAD = ITEMS.register("heisenhead",
            () -> new ArmorHeisenHead(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> HEISEN_SUIT = ITEMS.register("heisensuit",
            () -> new ArmorHeisenSuit(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT,EquipmentSlotType.CHEST,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> HEISEN_LEGG = ITEMS.register("heisenlegg",
            () -> new ArmorHeisenLegg(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT,EquipmentSlotType.LEGS,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> HEISEN_BOOTS = ITEMS.register("heisenboots",
            () -> new ArmorHeisenBoots(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT,EquipmentSlotType.FEET,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );


    public static final RegistryObject<Item> FRANK_HEAD = ITEMS.register("frankhead",
            () -> new ArmorFrankHead(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> FRANK_CHEST = ITEMS.register("frankchest",
            () -> new ArmorFrankChest(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT,EquipmentSlotType.CHEST,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> FRANK_LEGG = ITEMS.register("franklegg",
            () -> new ArmorFrankLegg(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT,EquipmentSlotType.LEGS,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> FRANK_BOOTS = ITEMS.register("frankboots",
            () -> new ArmorFrankBoots(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT,EquipmentSlotType.FEET,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );

    public static final RegistryObject<Item> ADA_MASK = ITEMS.register("adamask",
            () -> new ArmorAdaMask(CustomArmorMaterial.ARMOR_MATERIAL_ADASUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)) );


    public static final RegistryObject<Item> HUMUS_HELMET = ITEMS.register("humus_helmet",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,EquipmentSlotType.HEAD,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)));
    public static final RegistryObject<Item> HUMUS_CHESTPLATE = ITEMS.register("humus_chest",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,EquipmentSlotType.CHEST,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)));
    public static final RegistryObject<Item> HUMUS_LEGGINGS = ITEMS.register("humus_leggings",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,EquipmentSlotType.LEGS,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)));
    public static final RegistryObject<Item> HUMUS_BOOTS = ITEMS.register("humus_boots",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,EquipmentSlotType.FEET,(new Item.Properties()).tab(RegistryEvents.RE8GROUP)));


    public static final RegistryObject<CustomSpawnEggItem> RE8DIMI_SPAWN_EGG = ITEMS.register("re8dimi_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.RE8DIMI, 9577503, 13423070,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<CustomSpawnEggItem> DIMI2_SPAWN_EGG = ITEMS.register("dimi2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DIMI2,  9577503, 14423070,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> BELA_SPAWN_EGG  = ITEMS.register("bela_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.BELA,  16719885, 6674,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> CASSANDRA_SPAWN_EGG  = ITEMS.register("cassandra_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.CASSANDRA,  14731821 ,6674,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DANIELA_SPAWN_EGG  = ITEMS.register("daniela_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DANIELA,   33079 ,6674,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<SpawnEggItem> DUCK_SPAWN_EGG  = ITEMS.register("duck_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.DUCK, 0x006808, 0xFFD400,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> ETHAN_SPAWN_EGG  = ITEMS.register("ethan_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.ETHAN,  1179648 ,9127181,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> BEI_SPAWN_EGG  = ITEMS.register("bei_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.BEI,  9482425, 256,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> ANGIE_SPAWN_EGG  = ITEMS.register("angie_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.ANGIE,   4721936 , 16052725,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DOLL1_SPAWN_EGG  = ITEMS.register("doll1_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DOLL1,   4721936 , 9109551,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DOLL2_SPAWN_EGG  = ITEMS.register("doll2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DOLL2,   4721936 , 10109551,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DOLL3_SPAWN_EGG  = ITEMS.register("doll3_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DOLL3,   4721936 , 12109551,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> HEISEN_SPAWN_EGG  = ITEMS.register("heisen_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.HEISEN,  4743253 , 14211028,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MUHEISEN_SPAWN_EGG  = ITEMS.register("muheisen_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MUHEISEN,  4743253 , 14311028,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MOREAU_SPAWN_EGG  = ITEMS.register("moreau_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MOREAU,  10858676, 13568,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MOREAU2_SPAWN_EGG  = ITEMS.register("moreau2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MOREAU2,  10858676, 9109551,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MOREAU3_SPAWN_EGG  = ITEMS.register("moreau3_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MOREAU3,  10858676, 3620969,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MOREAU4_SPAWN_EGG  = ITEMS.register("moreau4_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MOREAU4,  10858676, 3720969,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK1_SPAWN_EGG  = ITEMS.register("frank1_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK1,  3620969, 8454144,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK2_SPAWN_EGG  = ITEMS.register("frank2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK2,   3620969, 3290159,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK3_SPAWN_EGG  = ITEMS.register("frank3_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK3,   3620969, 3093063,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK4_SPAWN_EGG  = ITEMS.register("frank4_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK4,   3620969, 15657893,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK5_SPAWN_EGG  = ITEMS.register("frank5_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK5,   3620969, 15657974,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> FRANK6_SPAWN_EGG  = ITEMS.register("frank6_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.FRANK6,   3620969, 3093011,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DUND_SPAWN_EGG  = ITEMS.register("dund_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DUND,  3093009, 65536,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DUND2_SPAWN_EGG  = ITEMS.register("dund2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DUND2,  3093009, 965536,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> SAMCA_SPAWN_EGG  = ITEMS.register("samca_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.SAMCA,  3093009, 4390912,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> BEIBABY_SPAWN_EGG  = ITEMS.register("beibaby_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.BEIBABY,  9127215, 9109551,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> LYCAN_SPAWN_EGG  = ITEMS.register("lycan_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.LYCAN,  11871525 ,7834015,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> LYCAN1_SPAWN_EGG  = ITEMS.register("lycan1_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.LYCAN1,  11871525, 7434015,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<SpawnEggItem> LYCANA_SPAWN_EGG  = ITEMS.register("lycana_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.LYCANA,  11871525 ,7034015,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> VARCOLAC_SPAWN_EGG  = ITEMS.register("varcolac_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.VARCOLAC,  11871525, 7934015,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> CHRIS_SPAWN_EGG  = ITEMS.register("chris_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.CHRIS,  75045 , 6190,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> URIAS_SPAWN_EGG  = ITEMS.register("urias_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.URIAS,  11871525, 7275782,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> URIASS_SPAWN_EGG  = ITEMS.register("uriass_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.URIASS,  11871525, 14329463,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> THEHAG_SPAWN_EGG  = ITEMS.register("thehag_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.THEHAG,   591617, 12631455,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MYCETE_SPAWN_EGG  = ITEMS.register("mycete_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MYCETE,   9127215, 9458716,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MMYCETE_SPAWN_EGG  = ITEMS.register("mmycete_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MMYCETE,   9127215, 1835008,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MIRANDA1_SPAWN_EGG  = ITEMS.register("miranda1_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MIRANDA1,   6190, 15717433,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MIRANDA2_SPAWN_EGG  = ITEMS.register("miranda2_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MIRANDA2,   6190, 3355961,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MIRANDA3_SPAWN_EGG  = ITEMS.register("miranda3_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MIRANDA3,   6190, 3355962,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MIRANDA4_SPAWN_EGG  = ITEMS.register("miranda4_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MIRANDA4,   6190, 3355963,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> ROSE_SPAWN_EGG  = ITEMS.register("rose_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.ROSE,   2656074, 2653349,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> MIA_SPAWN_EGG  = ITEMS.register("mia_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.MIA,   16768178 , 9477988,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> ADA_SPAWN_EGG  = ITEMS.register("ada_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.ADA,   14496298 , 3,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> BP_SPAWN_EGG  = ITEMS.register("bp_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.BP,   0, 15379262,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> WP_SPAWN_EGG  = ITEMS.register("wp_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.WP,   0, 15067099,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> AXEMAN_SPAWN_EGG  = ITEMS.register("axeman_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.AXEMAN,   6816793, 721945,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

    public static final RegistryObject<SpawnEggItem> DUKE_SPAWN_EGG  = ITEMS.register("duke_spawn_egg",
            () -> new CustomSpawnEggItem(EntityInit.DUKE,   8098207, 14588790,
                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));

//    public static final RegistryObject<SpawnEggItem> EDMAN_SPAWN_EGG  = ITEMS.register("edman_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.EDMAN,   6098204, 14588790,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> ENDGUARD_SPAWN_EGG  = ITEMS.register("endguard_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.ENDGUARD,   5098204, 14588790,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> ENDKING_SPAWN_EGG  = ITEMS.register("endking_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.ENDKING,   4098204, 14588790,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> ENDSCI_SPAWN_EGG  = ITEMS.register("scienceblack_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.ENDSCIBLACK,   2098204, 14588790,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<SpawnEggItem> HC_SPAWN_EGG  = ITEMS.register("heisencar_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.HEISENCAR,   16168178 , 9177988,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//    public static final RegistryObject<SpawnEggItem> DX_SPAWN_EGG  = ITEMS.register("dx_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.DX,  5127215, 9109551,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> JX_SPAWN_EGG  = ITEMS.register("jx_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.JX,  5127215, 8109551,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> PH_SPAWN_EGG  = ITEMS.register("ph_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.PH,  5127215, 7109551,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));
//
//    public static final RegistryObject<SpawnEggItem> XF_SPAWN_EGG  = ITEMS.register("xf_spawn_egg",
//            () -> new CustomSpawnEggItem(EntityInit.XF,  5127215, 6109551,
//                    new Item.Properties().tab(RegistryEvents.RE8GROUP)));


}
