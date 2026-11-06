package com.joy187.re8joymod.init;

import com.google.common.base.Supplier;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.*;
//import com.joy187.re8joymod.items.armor.*;
//import com.joy187.re8joymod.items.itemBook.ItemStoryBook;
import com.joy187.re8joymod.items.armor.*;
import com.joy187.re8joymod.items.itemBook.ItemStoryBook;
import com.joy187.re8joymod.util.CustomArmorMaterial;
import com.joy187.re8joymod.items.CustomItemTier;
import com.joy187.re8joymod.items.ItemMeteor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Main.MOD_ID);

    public static final RegistryObject<Item> MOPRO = ITEMS.register("mopro", () ->
    {
        return new ItemMoreauProjectrile();
    });

    public static final RegistryObject<Item> GE = ITEMS.register("ge", () ->
    {
        return new ItemEG(new Item.Properties().stacksTo(16));
    });
//    //    public static final RegistryObject<Item> STORYBOOK = ITEMS.register("storybook",
////	    	() -> new ItemStoryBook());
    public static final RegistryObject<Item> PROPELLER = ITEMS.register("propeller",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FACTORYG = ITEMS.register("vehicle_core",
            () -> new ItemVehicleCore(CustomItemTier.TOOL_KEY3,2,-1.5F,new Item.Properties()));

    public static final RegistryObject<Item> HELIG = ITEMS.register("heli",
            () -> new ItemHeli(CustomItemTier.TOOL_KEY3,2,-1.5F,new Item.Properties()));

    public static final RegistryObject<Item> LYEYE = ITEMS.register("lyeye",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLEATHER = ITEMS.register("sleather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RESOURCEL = ITEMS.register("resourcel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RESOURCESM = ITEMS.register("resourcesm",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACKFEATHER = ITEMS.register("blackfeather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEI = ITEMS.register("lei",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEI2 = ITEMS.register("lei2",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MACHINEHEARTS = ITEMS.register("machinehearts",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MACHINEHEARTB = ITEMS.register("machineheartb",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACKSHEEP = ITEMS.register("blacksheep",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACKSHEEPB = ITEMS.register("blacksheepbody",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACKSHEEPH = ITEMS.register("blacksheephead",
            () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> GLOWITEM = ITEMS.register("glowing_redstone",
			() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PUPPET = ITEMS.register("puppet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HUMUS_INGOT = ITEMS.register("humus_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FANTOM_INGOT = ITEMS.register("fantom_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HERBGLASSES = ITEMS.register("herbglass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DESOLATE_GRASS_BLOCK = ITEMS.register("desolate_grass",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOLARDISK = ITEMS.register("solar_disk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HUMUS = ITEMS.register("humus", () ->
            new Item(new Item.Properties()));

    public static RegistryObject<Item> EVIRUS = ITEMS.register("evirus",()->
    {
        return new ItemEvirus();
    });

    public static RegistryObject<Item> SAMPLE = ITEMS.register("sample",()->
    {
        return new ItemSample();
    });

    public static RegistryObject<Item> ROSEGENE = ITEMS.register("rosegene",()->
    {
        return new ItemRoseGene();
    });

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


    public static RegistryObject<Item> PREATTACK =  ITEMS.register("preciseattack",()->
    {
        return new ItemPreAttack();
    });

    public static final RegistryObject<Item> SLIVERREN  =  ITEMS.register("silverren", ()->
    {
        return new ItemSilverren();
    });


    public static final RegistryObject<Item> FLYPAT =  ITEMS.register("flypat",
            () -> new ItemFlyPat(CustomItemTier.TOOL_FLYPAT, 1, -1.9F,
                    new Item.Properties()));

    public static final RegistryObject<Item> FRANKDRILL =  ITEMS.register("frankdrill",
            () -> new ItemHSaw(CustomItemTier.TOOL_ZHIHU, 1, -2.2F,
                    new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WOODEN_SWORD = ITEMS.register("ebony_wooden_sword",
            () -> new EbonySwordItem(CustomItemTier.EBONY_WOODEN, 2, 3f,
                    new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WOODEN_PICKAXE = ITEMS.register("ebony_wooden_pickaxe",
            () -> new PickaxeItem(CustomItemTier.EBONY_WOODEN, 1, 1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WOODEN_SHOVEL = ITEMS.register("ebony_wooden_shovel",
            () -> new ShovelItem(CustomItemTier.EBONY_WOODEN, 0, 1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WOODEN_AXE = ITEMS.register("ebony_wooden_axe",
            () -> new AxeItem(CustomItemTier.EBONY_WOODEN, 4, 0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> EBONY_WOODEN_HOE = ITEMS.register("ebony_wooden_hoe",
            () -> new HoeItem(CustomItemTier.EBONY_WOODEN, 0, 0f,
                    new Item.Properties()));


    public static final RegistryObject<Item> HERB = ITEMS.register("herb1",
            ()-> new ItemNameBlockItem(BlockInit.HERB_BLOCK.get(),new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.5F).alwaysEat().build())
            ));

    public static final RegistryObject<Item> HERB2 = ITEMS.register("herb2",
            ()-> new ItemHerb2(BlockInit.HERB2_BLOCK.get(),new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(1F).alwaysEat().build())
            ));

    public static final RegistryObject<Item> HERB3 = ITEMS.register("herb3",
            ()-> new ItemHerb3(BlockInit.HERB3_BLOCK.get(),new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(1F).alwaysEat().build())
            ));

    public static RegistryObject<Item> OBBOAT = ITEMS.register("obboat",()->
    {
        return new ItemObBoat();
    });

    public static RegistryObject<Item> ELGE = ITEMS.register("elge",()->
    {
        return new ItemClgEssence(new Item.Properties().durability(500));
    });

    public static RegistryObject<Item> MOREAUHEAD = ITEMS.register("moreauhead",()->
    {
        return new ItemMoreauHead();
    });

    public static RegistryObject<Item> MOSPITTER = ITEMS.register("mospitter",()->
    {
        return new ItemMoSpitter();
    });
//
////    public static RegistryObject<Item> M1897 = ITEMS.register("m1897",()->
////    {
////        return new ItemM1897();
////    });
////
////    public static RegistryObject<Item> SYG12 = ITEMS.register("syg12",()->
////    {
////        return new ItemM1897();
////    });
////
////    public static RegistryObject<Item> W870 = ITEMS.register("w870",()->
////    {
////        return new ItemM1897();
////    });
////
////    public static RegistryObject<Item> M1897B = ITEMS.register("m1897b",()->
////    {
////        return new ItemM1897B();
////    });
////
////
////    public static RegistryObject<Item> M1851 = ITEMS.register("m1851",()->
////    {
////        return new ItemM1851();
////    });
////
////    public static RegistryObject<Item> STAKE = ITEMS.register("stake",()->
////    {
////        return new ItemM1851();
////    });
////
////    public static RegistryObject<Item> BERETTA92FS = ITEMS.register("beretta92fs",()->
////    {
////        return new ItemM1851();
////    });
////
////    public static RegistryObject<Item> F2RIFLE = ITEMS.register("f2rifle",()->
////    {
////        return new ItemF2();
////    });
////
////    public static RegistryObject<Item> SA110 = ITEMS.register("sa110",()->
////    {
////        return new ItemSA110();
////    });
////    public static final RegistryObject<GunItem> PISTOL = ITEMS.register("pistol", () ->
////   	new GunItem(new Item.Properties().stacksTo(1)));
//
//    //    public static RegistryObject<Item> WCX = ITEMS.register("wcx",()->
////    {
////        return new ItemWcx();
////    });
////
////    public static RegistryObject<Item> DRAGOON = ITEMS.register("dragoon",()->
////    {
////        return new ItemWcx();
////    });
////
////    public static RegistryObject<Item> M1851B = ITEMS.register("m1851b",()->
////    {
////        return new ItemM1851B();
////    });
////
////    public static RegistryObject<Item> SNIPERAMMO = ITEMS.register("sniperammo",()->
////    {
////        return new ItemSniperAmmo();
////    });
////
////    public static RegistryObject<Item> RIFLEAMMO = ITEMS.register("rifleammo",()->
////    {
////        return new ItemRifleAmmo();
////    });
////
    public static RegistryObject<Item> CROSSBOW1 = ITEMS.register("crossbow1",()->
    {
        return new ItemCrossbow1();
    });

    public static RegistryObject<Item> ZEALOTCROSSBOW = ITEMS.register("zealotcrossbow",()->
    {
        return new ItemCrossbow1();
    });

    public static RegistryObject<Item> ZGUN = ITEMS.register("zgun",()->
    {
        return new ItemCrossbow2();
    });

    public static RegistryObject<Item> BOWSHOOT = ITEMS.register("bowa",()->
    {
        return new ItemBOWShoot();
    });

////    public static RegistryObject<Item> GM79 = ITEMS.register("gm79",()->
////    {
////        return new ItemGM79();
////    });
//
////    public static RegistryObject<Item> GM79B = ITEMS.register("gm79b",()->
////    {
////        return new ItemGM79B();
////    });
//
    public static RegistryObject<ItemSpear> DIMIHANBLADE = ITEMS.register("dimihand", () ->
    {
        return new ItemSpear(CustomItemTier.TOOL_DIMIHAND);
    });

    public static RegistryObject<Item> HAGWAND = ITEMS.register("thehagwand",()->
    {
        return new ItemHagWand(CustomItemTier.TOOL_HAGWAND, 1, -2.0F,
                new Item.Properties());
    });

    public static RegistryObject<Item> KSWORD = ITEMS.register("ksword",()->
    {
        return new ItemKsword(CustomItemTier.TOOL_ZHIHU, 4, -2.5F,
                new Item.Properties());
    });

    public static RegistryObject<Item> METEOR = ITEMS.register("meteor",()->
    {
        return new ItemMeteor(CustomItemTier.TOOL_ZHIHU, 2, -2.1F,
                new Item.Properties());
    });

    public static RegistryObject<Item> VTRIDENT = ITEMS.register("vtrident",
            () -> new ItemVTrident(CustomItemTier.RE4_SICKLE, 2, 2.5f,
                    new Item.Properties()));

    public static RegistryObject<Item> HARPON = ITEMS.register("harpoon",
            () -> new ItemHarpon(CustomItemTier.RE4_SICKLE, 2, 2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> SICKLE = ITEMS.register("sickle",
            () -> new SickleItem(CustomItemTier.RE4_SICKLE, 2, 2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> EROD = ITEMS.register("erod",
            () -> new ERodItem(CustomItemTier.RE4_SICKLE, 2, 2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> SPIKECLUB = ITEMS.register("spikeclub",
            () -> new ERodItem(CustomItemTier.RE4_SICKLE, 4, 2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> FENBAOCHUI  = ITEMS.register("hammer", () ->
            new ItemHammer(CustomItemTier.TOOL_XUANFENG, 34, -3.6F,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAMMERB  = ITEMS.register("hammerb", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 30, -3.5F,
                    new Item.Properties()));

    public static final RegistryObject<Item> SADDLERWAND  = ITEMS.register("wand", () ->
            new ItemWand(CustomItemTier.TOOL_HAGWAND, 5, -1.3F,
                    new Item.Properties()));

    public static final RegistryObject<Item> URIASHAMMER  = ITEMS.register("uriashammer", () ->
            new ItemUrias(CustomItemTier.TOOL_KKUKRI, 30, -3.5F,
                    new Item.Properties()));

    public static final RegistryObject<Item> URIASSHAMMER  = ITEMS.register("uriasshammer", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 34, -3.6F,
                    new Item.Properties()));

    public static final RegistryObject<Item> XUANFENGAXE  = ITEMS.register("xuanfengaxe", () ->
            new ItemUrias(CustomItemTier.TOOL_XUANFENG, 23, -3.2F,
                    new Item.Properties()));

    public static final RegistryObject<Item> CRYSTALHAMMER = ITEMS.register("crystalhammer", () ->
            new ItemCrystalHammer(CustomItemTier.TOOL_XUANFENG, 29, -2.9F,
                    new Item.Properties()));

    public static final RegistryObject<Item> SAW  = ITEMS.register("saw", () ->
            new ItemSaw(CustomItemTier.TOOL_XUANFENG, 1, -2.8F,
                    new Item.Properties()));

    public static final RegistryObject<Item> TENTA  = ITEMS.register("tenta", () ->
            new ItemTenta(CustomItemTier.TOOL_XUANFENG, 2, -2.0F,
                    new Item.Properties()));

    public static final RegistryObject<Item> HSAW  = ITEMS.register("muhesenweap", () ->
            new ItemHSaw(CustomItemTier.TOOL_HSAW, 1, -3.3F,
                    new Item.Properties()));

    public static final RegistryObject<Item> GBLADE  = ITEMS.register("garradorblade", () ->
            new ItemGBlade(CustomItemTier.TOOL_KKUKRI, 5, -2.6F,
                    new Item.Properties()));

    public static RegistryObject<Item> XISHOUYE = ITEMS.register("xishouye",()->
    {
        return new ItemXiShouYe();
    });

    public static RegistryObject<Item> MIXHERB = ITEMS.register("mixherb",()->
    {
        return new ItemMixHerb();
    });

    public static RegistryObject<Item> WINE = ITEMS.register("wine",()->
    {
        return new ItemWine();
    });

    public static RegistryObject<Item> RESHIELD = ITEMS.register("reshield",()->
    {
        return new ItemShield();
    });

    public static RegistryObject<Item> SWATSHIELD = ITEMS.register("swatshield",()->
    {
        return new ItemShield();
    });

    public static RegistryObject<Item> COMBATKNIFE = ITEMS.register("combatknife",()->
    {
        return new ItemCombatKnife();
    });

    public static RegistryObject<Item> KKNIFE = ITEMS.register("kknife",()->
    {
        return new ItemKKnife();
    });

    public static RegistryObject<Item> ZEALOTSHIELD = ITEMS.register("zealotshield",()->
    {
        return new ItemZealotShield();
    });

    public static final RegistryObject<Item> DETONATOR = ITEMS.register("detonator", () ->
    {
        return new DetonatorItem();
    });

    public static RegistryObject<Item> CIGAR = ITEMS.register("cigar",()->
    {
        return new ItemCigar();
    });

    public static RegistryObject<Item> BLACKBALL = ITEMS.register("blackball",()->
    {
        return new ItemBlackball();
    });

    public static final RegistryObject<Item> PIPEBOMB = ITEMS.register("pipebomb", () ->
    {
        return new ItemPipeb();
    });

    public static final RegistryObject<Item> HIGHEX = ITEMS.register("highex", () ->
    {
        return new HighEx();
    });

    public static final RegistryObject<Item> FLASH = ITEMS.register("flash", () ->
    {
        return new ItemFlash();
    });

    public static final RegistryObject<Item> FRAG = ITEMS.register("fragg", () ->
    {
        return new ItemFRAG();
    });
////    public static final RegistryObject<Item> OBBOAT = ITEMS.register("obboat", () ->
////    {
////    	return new ItemObBoat();
////	});
//
//    public static RegistryObject<Item> STORYBOOK = ITEMS.register("storybook",
//    		new GuidebookItem(new Item.Properties().stacksTo(1))
//    );
////    public static final RegistryObject<Item> STORYBOOK = ITEMS.register("guidebook",
////    		() -> new GuidebookItem(new Item.Properties()));
//
    public static final RegistryObject<Item> GRAPELGUN = ITEMS.register("grapnelgun",
            () -> new ItemGrapnelGun());

    public static final RegistryObject<Item> CEYE = ITEMS.register("chiefeye",
            () -> new ItemChiefEye());

    public static final RegistryObject<Item> STORYBOOK = ITEMS.register("storybook",
            () -> new ItemStoryBook(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MCHEESE = ITEMS.register("mcheese", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(2.5F).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0,false,true), 1.0F).
            effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 1,false,true), 1.0F).
            effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 20*60*10, 2), 1.0F).
            effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 3,false,true), 1.0F).
            effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 600, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));


    public static final RegistryObject<Item> HERBFISH = ITEMS.register("herbfish", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> BIRDANDPILAF = ITEMS.register("birdandbeastpilaf", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(10).saturationMod(0.5F).
            effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*60, 1,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> THREEFLAVOR = ITEMS.register("threeflavoredmititei", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(12).saturationMod(0.8F).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20*45, 3,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> TOCH = ITEMS.register("tochituradepui", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*300, 3,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> CIOR = ITEMS.register("ciorbadeporc", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20*300, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> SARMAL = ITEMS.register("sarmaledepeste", () -> new Item(new Item.Properties().
            food(new FoodProperties.Builder().nutrition(14).saturationMod(0.9F).
            effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*300, 2,false,true), 1.0F).
            alwaysEat().alwaysEat().build())));

    public static final RegistryObject<Item> RUSTPART = ITEMS.register("rustedpart",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).
                    effect(() -> new MobEffectInstance(EffectInit.EROSION.get(), 20*10, 2,false,true), 1.0F).
                    alwaysEat().build())));
////    public static final RegistryObject<Item> DIMI_SPAWN_EGG =
////    		ITEMS.register("re8dimi_spawn_egg", () ->
////    	new SupplierSpawnEggItem(EntityInit.RE8DIMI::get, 9577503, 13423070,
////    			new Item.Properties()));
//
    public static final RegistryObject<PickaxeItem> KEY = ITEMS.register("labor_shovel",
            () -> new ItemRiser(CustomItemTier.TOOL_KEY,1,-2,new Item.Properties()));

    public static final RegistryObject<PickaxeItem> KEY2 = ITEMS.register("labor_shovel2",
            () -> new ItemRiser2(CustomItemTier.TOOL_KEY2,1,-1.8F,new Item.Properties()));

    public static final RegistryObject<PickaxeItem> KEY3 = ITEMS.register("labor_shovel3",
            () -> new ItemRiser3(CustomItemTier.TOOL_KEY3,2,-1.5F,new Item.Properties()));

    public static final RegistryObject<PickaxeItem> PLAGASKEY = ITEMS.register("plagaskey",
            () -> new ItemRiserPlagas(CustomItemTier.TOOL_KEY3,1,-2,new Item.Properties()));

    public static final RegistryObject<Item> HUMUS_HELMET = ITEMS.register("humus_helmet",
            () -> new HUMUSArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT, ArmorItem.Type.HELMET,(new Item.Properties())));
    public static final RegistryObject<Item> HUMUS_CHESTPLATE = ITEMS.register("humus_chest",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,ArmorItem.Type.CHESTPLATE,(new Item.Properties())));
    public static final RegistryObject<Item> HUMUS_LEGGINGS = ITEMS.register("humus_leggings",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,ArmorItem.Type.LEGGINGS,(new Item.Properties())));
    public static final RegistryObject<Item> HUMUS_BOOTS = ITEMS.register("humus_boots",
            () -> new ArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HUMUSSUIT,ArmorItem.Type.BOOTS,(new Item.Properties())));

    public static final RegistryObject<DimihatArmorItem> DIMI_HAT = ITEMS.register("dimihat",
            () -> new DimihatArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_DIMISUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<DimisuitArmorItem> DIMI_SUIT = ITEMS.register("dimisuit",
            () -> new DimisuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_DIMI1SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));


    public static final RegistryObject<HeisensuitArmorItem> HEISEN_HEAD = ITEMS.register("heisenhead",
            () -> new HeisensuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<HeisensuitArmorItem> HEISEN_SUIT = ITEMS.register("heisensuit",
            () -> new HeisensuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<HeisensuitArmorItem> HEISEN_LEGG = ITEMS.register("heisenlegg",
            () -> new HeisensuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<HeisensuitArmorItem> HEISEN_BOOTS = ITEMS.register("heisenboots",
            () -> new HeisensuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HEISENSUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<FranksuitArmorItem> FRANK_HEAD = ITEMS.register("frankhead",
            () -> new FranksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<FranksuitArmorItem> FRANK_SUIT = ITEMS.register("frankchest",
            () -> new FranksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<FranksuitArmorItem> FRANK_LEGG = ITEMS.register("franklegg",
            () -> new FranksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<FranksuitArmorItem> FRANK_BOOTS = ITEMS.register("frankboots",
            () -> new FranksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_FRANKSUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<MirandamaskArmorItem> MIRANDA_MASK = ITEMS.register("mirandamask",
            () -> new MirandamaskArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_MIRANDASUIT, ArmorItem.Type.HELMET, new Item.Properties()));


    public static final RegistryObject<MirandasuitArmorItem> MIRANDA_SUIT = ITEMS.register("mirandasuit",
            () -> new MirandasuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_MIRANDA1SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<AdamaskArmorItem> ADA_MASK = ITEMS.register("adamask",
            () -> new AdamaskArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_ADASUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<LeonsuitArmorItem> LEON_HEAD = ITEMS.register("leonhead",
            () -> new LeonsuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_LEONSUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<LeonsuitArmorItem> LEON_SUIT = ITEMS.register("leonsuit",
            () -> new LeonsuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_LEONSUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<LeonsuitArmorItem> LEON_LEGG = ITEMS.register("leonlegg",
            () -> new LeonsuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_LEONSUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<LeonsuitArmorItem> LEON_BOOTS = ITEMS.register("leonboots",
            () -> new LeonsuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_LEONSUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<HanksuitArmorItem> HANK_HEAD = ITEMS.register("hankhead",
            () -> new HanksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HANKSUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<HanksuitArmorItem> HANK_SUIT = ITEMS.register("hanksuit",
            () -> new HanksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HANKSUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<HanksuitArmorItem> HANK_LEGG = ITEMS.register("hanklegg",
            () -> new HanksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HANKSUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<HanksuitArmorItem> HANK_BOOTS = ITEMS.register("hankboots",
            () -> new HanksuitArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_HANKSUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<SHatArmorItem> SHAT_MASK = ITEMS.register("shat",
            () -> new SHatArmorItem(CustomArmorMaterial.ARMOR_MATERIAL_ADASUIT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> DIMI_SPAWN_EGG = ITEMS.register("re8dimi_spawn_egg",
        () -> new ForgeSpawnEggItem(EntityInit.RE8DIMI, 9577503, 13423070, new Item.Properties()));

    public static final RegistryObject<Item> DIMI2_SPAWN_EGG = ITEMS.register("dimi2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DIMI2, 9577503, 14423070, new Item.Properties()));

    public static final RegistryObject<Item> ETHAN_SPAWN_EGG = ITEMS.register("ethan_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ETHAN, 1179648 ,9127181, new Item.Properties()));

    public static final RegistryObject<Item> DUND1_SPAWN_EGG = ITEMS.register("dund_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DUND1, 3093009, 65536, new Item.Properties()));

    public static final RegistryObject<Item> DUND2_SPAWN_EGG = ITEMS.register("dund2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DUND2, 3093009, 965536, new Item.Properties()));

    public static final RegistryObject<Item> SAMCA_SPAWN_EGG = ITEMS.register("samca_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SAMCA, 3093009, 4390912, new Item.Properties()));

    public static final RegistryObject<Item>  BELA_SPAWN_EGG = ITEMS.register("bela_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.BELA, 16719885, 6674, new Item.Properties()));

    public static final RegistryObject<Item>  CASSANDRA_SPAWN_EGG = ITEMS.register("cassandra_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CASSANDRA, 14731821 ,6674, new Item.Properties()));

    public static final RegistryObject<Item>  DANIELA_SPAWN_EGG = ITEMS.register("daniela_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DANIELA, 33079 ,6674, new Item.Properties()));

    public static final RegistryObject<Item>  BEI_SPAWN_EGG = ITEMS.register("bei_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.BEI, 9482425, 256, new Item.Properties()));

    public static final RegistryObject<Item>  ANGIE_SPAWN_EGG = ITEMS.register("angie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ANGIE, 4721936 , 16052725, new Item.Properties()));

    public static final RegistryObject<Item>  DOLL1_SPAWN_EGG = ITEMS.register("doll1_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DOLL1, 4721936 , 9109551, new Item.Properties()));

    public static final RegistryObject<Item>  DOLL2_SPAWN_EGG = ITEMS.register("doll2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DOLL2, 4721936 , 10109551, new Item.Properties()));

    public static final RegistryObject<Item>  DOLL3_SPAWN_EGG = ITEMS.register("doll3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DOLL3, 4721936 , 12109551, new Item.Properties()));

    public static final RegistryObject<Item>  BEIBABY_SPAWN_EGG = ITEMS.register("beibaby_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.BEIBABY, 9127215, 9109551, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK1_SPAWN_EGG = ITEMS.register("frank1_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK1, 3620969, 8454144, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK2_SPAWN_EGG = ITEMS.register("frank2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK2, 3620969, 3290159, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK3_SPAWN_EGG = ITEMS.register("frank3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK3, 3620969, 3093063, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK4_SPAWN_EGG = ITEMS.register("frank4_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK4, 3620969, 15657893, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK5_SPAWN_EGG = ITEMS.register("frank5_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK5, 3620969, 15657974, new Item.Properties()));

    public static final RegistryObject<Item>  FRANK6_SPAWN_EGG = ITEMS.register("frank6_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FRANK6, 3620969, 3093011, new Item.Properties()));

    public static final RegistryObject<Item>  LYCANA_SPAWN_EGG = ITEMS.register("lycana_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.LYCANA, 11871525 ,7034015, new Item.Properties()));

    public static final RegistryObject<Item>  MYCETE_SPAWN_EGG = ITEMS.register("mycete_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MYCETE,  9127215, 9458716, new Item.Properties()));

    public static final RegistryObject<Item>  MMYCETE_SPAWN_EGG = ITEMS.register("mmycete_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MMYCETE, 9127215, 1835008, new Item.Properties()));

    public static final RegistryObject<Item>  LYCAN_SPAWN_EGG = ITEMS.register("lycan_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.LYCAN, 11871525 ,7834015, new Item.Properties()));

    public static final RegistryObject<Item>  LYCAN1_SPAWN_EGG = ITEMS.register("lycan1_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.LYCAN1, 11871525, 7434015, new Item.Properties()));

    public static final RegistryObject<Item>  VARCOLAC_SPAWN_EGG = ITEMS.register("varcolac_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.VARCOLAC, 11871525, 7934015, new Item.Properties()));

    public static final RegistryObject<Item>  MOREAU_SPAWN_EGG = ITEMS.register("moreau_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MOREAU, 10858676, 13568, new Item.Properties()));

    public static final RegistryObject<Item>  MOREAU2_SPAWN_EGG = ITEMS.register("moreau2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MOREAU2, 10858676, 9109551, new Item.Properties()));

    public static final RegistryObject<Item>  MOREAU3_SPAWN_EGG = ITEMS.register("moreau3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MOREAU3, 10858676, 3620969, new Item.Properties()));

    public static final RegistryObject<Item>  HEISEN_SPAWN_EGG = ITEMS.register("heisen_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.HEISEN, 4743253 , 14211028, new Item.Properties()));

    public static final RegistryObject<Item>  MUHEISEN_SPAWN_EGG = ITEMS.register("muheisen_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MUHEISEN, 4743253 , 14311028, new Item.Properties()));

    public static final RegistryObject<Item>  MIA_SPAWN_EGG = ITEMS.register("mia_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MIA, 16768178 , 9477988, new Item.Properties()));

    public static final RegistryObject<Item>  URIAS_SPAWN_EGG = ITEMS.register("urias_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.URIAS, 11871525, 7275782, new Item.Properties()));

    public static final RegistryObject<Item>  URIASS_SPAWN_EGG = ITEMS.register("uriass_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.URIASS, 11871525, 14329463, new Item.Properties()));

    public static final RegistryObject<Item>  CHRIS_SPAWN_EGG = ITEMS.register("chris_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CHRIS, 75045 , 6190, new Item.Properties()));

    public static final RegistryObject<Item>  AXEMAN_SPAWN_EGG = ITEMS.register("axeman_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.AXEMAN, 6816793, 721945, new Item.Properties()));

    public static final RegistryObject<Item>  DUKE_SPAWN_EGG = ITEMS.register("duke_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DUKE, 8098207, 14588790, new Item.Properties()));

    public static final RegistryObject<Item>  THEHAG_SPAWN_EGG = ITEMS.register("thehag_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.THEHAG, 591617, 12631455, new Item.Properties()));

    public static final RegistryObject<Item>  MIRANDA1_SPAWN_EGG = ITEMS.register("miranda1_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MIRANDA1, 6190, 15717433, new Item.Properties()));

    public static final RegistryObject<Item>  MIRANDA2_SPAWN_EGG = ITEMS.register("miranda2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MIRANDA2, 6190, 3355961, new Item.Properties()));

    public static final RegistryObject<Item>  MIRANDA3_SPAWN_EGG = ITEMS.register("miranda3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MIRANDA3, 6190, 3355962, new Item.Properties()));

    public static final RegistryObject<Item>  MIRANDA4_SPAWN_EGG = ITEMS.register("miranda4_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MIRANDA4, 6190, 3355963, new Item.Properties()));

    public static final RegistryObject<Item>  ROSEMARY_SPAWN_EGG = ITEMS.register("rosemary_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ROSEMARY, 2656074, 2653349, new Item.Properties()));

    public static final RegistryObject<Item>  ADA_SPAWN_EGG = ITEMS.register("ada_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ADA, 14496298 , 3, new Item.Properties()));

    public static final RegistryObject<Item>  MOREAU4_SPAWN_EGG = ITEMS.register("moreau4_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MOREAU4, 10858676, 3720969, new Item.Properties()));

    public static final RegistryObject<Item>  ADA4_SPAWN_EGG = ITEMS.register("ada4_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ADA4, 12519973 , 15913150, new Item.Properties()));

    public static final RegistryObject<Item>  LEON_SPAWN_EGG = ITEMS.register("leon_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.LEON, 10515760 , 13607256, new Item.Properties()));

    public static final RegistryObject<Item>  CHIEF2_SPAWN_EGG = ITEMS.register("chief2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CHIEF2, 3280131 , 8417117, new Item.Properties()));

    public static final RegistryObject<Item>  CHIEF_SPAWN_EGG = ITEMS.register("chief_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CHIEF, 3280131 , 8017117, new Item.Properties()));

    public static final RegistryObject<Item>  GARRADOR_SPAWN_EGG = ITEMS.register("garrador_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.GARRADOR, 9123640 , 1968685, new Item.Properties()));

    public static final RegistryObject<Item>  PV_SPAWN_EGG = ITEMS.register("plagasvillager_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASVILLAGER, 9023640 , 1968685, new Item.Properties()));

    public static final RegistryObject<Item>  PZ_SPAWN_EGG = ITEMS.register("plagaszombie_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASZOMBIE, 3108670 , 1968685, new Item.Properties()));

    public static final RegistryObject<Item> SUMMONFRANK5_SPAWN_EGG = ITEMS.register("summonfrank5_core",
            () -> new ItemSummonFrank5Core(CustomItemTier.TOOL_KEY2,2,-1.5F,new Item.Properties()));

    public static final RegistryObject<Item> SUMMONDAUGHTER_SPAWN_EGG = ITEMS.register("summonbcd_core",
            () -> new ItemDaughterCore(CustomItemTier.TOOL_KEY2,2,-1.5F,new Item.Properties()));

    public static final RegistryObject<Item>  MERCHANT_SPAWN_EGG = ITEMS.register("merchant_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MERCHANT, 723985, 8073887, new Item.Properties()));

    public static final RegistryObject<Item>  GANADOR_SPAWN_EGG = ITEMS.register("ganado_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.VILLAGERGANADO, 8281941 ,13805713, new Item.Properties()));

    public static final RegistryObject<Item>  CVG_SPAWN_EGG = ITEMS.register("cvg_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CVG, 9773581 ,8281941, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGAS_SPAWN_EGG = ITEMS.register("plagas_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGAS, 2110250 ,9773581, new Item.Properties()));

    public static final RegistryObject<Item>  U3_SPAWN_EGG = ITEMS.register("u3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.U3, 9109551 ,12519973, new Item.Properties()));

    public static final RegistryObject<Item>  ELG_SPAWN_EGG = ITEMS.register("elg_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ELG, 10728399 ,10721933, new Item.Properties()));

    public static final RegistryObject<Item>  DELLAGO_SPAWN_EGG = ITEMS.register("dellago_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.DALLAGO, 1714811 ,10721933, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASENDERMAN_SPAWN_EGG = ITEMS.register("plagasenderman_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASENDERMAN, 8073887 ,723985, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASCREEPER_SPAWN_EGG = ITEMS.register("plagascreeper_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASCREEPER, 2110250 ,189786, new Item.Properties()));

    public static final RegistryObject<Item>  VERDUGO_SPAWN_EGG = ITEMS.register("verdugo_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.VERDUGO, 1383967 , 1058336, new Item.Properties()));

    public static final RegistryObject<Item>  MANNEQUIN_SPAWN_EGG = ITEMS.register("mannequin_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MANNEQUIN, 5992351 , 3152384, new Item.Properties()));

    public static final RegistryObject<Item>  ARMADURA_SPAWN_EGG = ITEMS.register("armadura_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ARMADURA, 15921901 , 16767488, new Item.Properties()));

    public static final RegistryObject<Item>  ZEALOT_SPAWN_EGG = ITEMS.register("zealot_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ZEALOT, 1710618 , 10793146, new Item.Properties()));

    public static final RegistryObject<Item> CRYSTALSKULL = ITEMS.register("crystalskull",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item>  SALAZAR_SPAWN_EGG = ITEMS.register("salazar_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SALAZAR, 1383967 , 3106729, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASARMADURA_SPAWN_EGG = ITEMS.register("plagasarmadura_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASARMADURA, 15900000 , 16760000, new Item.Properties()));

    public static final RegistryObject<Item>  ZEALOTA_SPAWN_EGG = ITEMS.register("zealota_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ZEALOTA, 1710618 , 9793146, new Item.Properties()));

    public static final RegistryObject<Item>  KRAUSER2_SPAWN_EGG = ITEMS.register("krauser2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.KRAUSER2, 14341547 , 4473129, new Item.Properties()));

    public static final RegistryObject<Item>  KRAUSER_SPAWN_EGG = ITEMS.register("krauser_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.KRAUSER, 14341547 , 2769193, new Item.Properties()));

    public static final RegistryObject<Item>  REGENERATOR_SPAWN_EGG = ITEMS.register("regenerator_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.REGENERATOR, 14341547 , 12519973, new Item.Properties()));

    public static final RegistryObject<Item>  REGENERATOR2_SPAWN_EGG = ITEMS.register("regenerator2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.REGENERATOR2, 14341547 , 12459973, new Item.Properties()));

    public static final RegistryObject<Item>  HANK_SPAWN_EGG = ITEMS.register("hank_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.HANK, 1710618 , 12519973, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASC_SPAWN_EGG = ITEMS.register("plagasc_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASC, 2110250 ,9443581, new Item.Properties()));

    public static final RegistryObject<Item>  EVILDOG_SPAWN_EGG = ITEMS.register("evildog_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.EVILDOG, 401194 ,3149074, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASDOG_SPAWN_EGG = ITEMS.register("plagasdog_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASDOG, 401194 ,5508370, new Item.Properties()));

    public static final RegistryObject<Item>  JJ_SPAWN_EGG = ITEMS.register("jj_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.JJ, 11871525, 2508155, new Item.Properties()));

    public static final RegistryObject<Item>  CHIEF3_SPAWN_EGG = ITEMS.register("chief3_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CHIEF3, 3280131 , 8217117, new Item.Properties()));

    public static final RegistryObject<Item>  SOLDI_SPAWN_EGG = ITEMS.register("soldi_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SOLDI, 2280131 , 7217117, new Item.Properties()));

    public static final RegistryObject<Item>  FE_SPAWN_EGG = ITEMS.register("fe_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.FE, 11716561 , 28, new Item.Properties()));

    public static final RegistryObject<Item>  NOVI_SPAWN_EGG = ITEMS.register("novi_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.NOVI, 2110250 ,7217117, new Item.Properties()));

    public static final RegistryObject<Item>  SADDLER_SPAWN_EGG = ITEMS.register("saddler_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SADDLER, 2210250 ,2508155, new Item.Properties()));

    public static final RegistryObject<Item>  STUFF_SPAWN_EGG = ITEMS.register("stuff_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.STUFF, 7364479, 14423070, new Item.Properties()));

    public static final RegistryObject<Item>  ASH_SPAWN_EGG = ITEMS.register("ash_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.ASH, 13457152, 394756, new Item.Properties()));

    public static final RegistryObject<Item>  PLAGASM_SPAWN_EGG = ITEMS.register("plagasm_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.PLAGASM, 2110250, 394756, new Item.Properties()));

    public static final RegistryObject<Item>  SALAZ_SPAWN_EGG = ITEMS.register("salaz_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SALAZ, 1383967 , 14496298, new Item.Properties()));

    public static final RegistryObject<Item>  LUIS_SPAWN_EGG = ITEMS.register("luis_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.LUIS, 12495493 , 14496298, new Item.Properties()));

    public static final RegistryObject<Item>  SADDLER2_SPAWN_EGG = ITEMS.register("saddler2_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SADDLER2, 2200250 ,2505155, new Item.Properties()));

    public static final RegistryObject<Item>  BRUTE_SPAWN_EGG = ITEMS.register("brute_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.BRUTE, 11871525, 1383967, new Item.Properties()));

    public static final RegistryObject<Item>  KLEE_SPAWN_EGG = ITEMS.register("klee_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.KLEE, 2577503, 13423070, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}