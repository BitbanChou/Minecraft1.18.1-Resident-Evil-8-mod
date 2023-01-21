package com.joy187.re8joymod;

import com.google.common.collect.Lists;
import com.joy187.re8joymod.common.ClientModEventSubscriber;
import com.joy187.re8joymod.common.ModEventSubscriber;
import com.joy187.re8joymod.common.entity.*;
import com.joy187.re8joymod.common.init.*;
import com.joy187.re8joymod.common.items.CustomSpawnEggItem;
import com.joy187.re8joymod.common.screen.VirusGeneratorScreen;
import com.joy187.re8joymod.common.world.gen.ModConfiguredStructures;
import com.joy187.re8joymod.common.world.structure.ModStructures;
import com.joy187.re8joymod.events.RegistryEvents;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.joy187.re8joymod.helper.ModConfig.SPEC;

//import software.bernie.geckolib3.GeckoLib;


@Mod(Utils.MOD_ID)
@Mod.EventBusSubscriber(modid= Utils.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class Main {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup RE8Group = new RE8Group("RE8Item");
    private static final List<MMixPredicate<Potion>> POTION_MIXES = Lists.newArrayList();
    public static ModEventSubscriber PROXY = DistExecutor.safeRunForDist(() -> ClientModEventSubscriber::new, () -> ModEventSubscriber::new);

//    @Mod.Instance
//    public static Main instance;

    public Main(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        // Register the doClientStuff method for modloading
        bus.addListener(this::doClientStuff);


        SoundInit.SOUND_TYPES.register(bus);
        EntityInit.ENTITY_TYPES.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEffects.EFFECTS.register(bus);
        ModPotions.POTIONS.register(bus);
        //ModParticles.PARTICLES.register(bus);
        //ModTileEntities.register(bus);
        //ModContainers.register(bus);

        BlockEntityInit.register(bus);
        MenuInit.register(bus);
        RecipeInit.register(bus);

        ModStructures.register(bus);
        SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeInit.registerBiomes();
        EntityDuke.register(bus);
        EntityEdMan.register(bus);
        EntityEndGuard.register(bus);
        EntityEndKing.register(bus);
        EntityEndScienceBlack.register(bus);

        ModPOIs.register(bus);
        //KeyboardManager.init();
        //GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON,SPEC,"re8joymod-common.toml");
        //        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC, "tutorialmod-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("deprecation")
    private void setup(final FMLCommonSetupEvent event) {

        // .build() used to be .create() not sure of that's good
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.RE8DIMI.get(), EntityRe8Dimi.setAttributes().build()));
//        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DUCK.get(), DuckEntity.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ANGIE.get(), EntityAngie.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DOLL1.get(), EntityDoll1.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DOLL2.get(), EntityDoll2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DOLL3.get(), EntityDoll3.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ETHAN.get(), EntityEthan.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DIMI2.get(), EntityDimi2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.BELA.get(), EntityBela.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.CASSANDRA.get(), EntityCassandra.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DANIELA.get(), EntityDaniela.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.BEI.get(), EntityBei.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.BEIBABY.get(), EntityBeibaby.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.HEISEN.get(), EntityHeisen.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MUHEISEN.get(), EntityMuHeisen.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MOREAU.get(), EntityMoreau.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MOREAU2.get(), EntityMoreau2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MOREAU3.get(), EntityMoreau3.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MOREAU4.get(), EntityMoreau4.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK1.get(), EntityFrank1.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK2.get(), EntityFrank2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK3.get(), EntityFrank3.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK4.get(), EntityFrank4.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK5.get(), EntityFrank5.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.FRANK6.get(), EntityFrank6.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DUND.get(), EntityDund.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DUND2.get(), EntityDund2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.SAMCA.get(), EntitySamca.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.LYCAN.get(), EntityLycan.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.LYCAN1.get(), EntityLycan1.setAttributes().build()));
        //DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.LYCANA.get(), EntityLycana.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.VARCOLAC.get(), EntityVarcolac.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.CHRIS.get(), EntityChris.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.URIAS.get(), EntityUrias.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.URIASS.get(), EntityUriass.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.THEHAG.get(), EntityTheHag.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MYCETE.get(), EntityMycete.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MMYCETE.get(), EntityMMycete.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MIRANDA1.get(), EntityMiranda1.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MIRANDA2.get(), EntityMiranda2.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MIRANDA3.get(), EntityMiranda3.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MIRANDA4.get(), EntityMiranda4.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.MIA.get(), EntityMia.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ROSE.get(), EntityRose.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.HEISENCAR.get(), HeisenCarEntity.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ADA.get(), EntityAda.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.BP.get(), EntityBp.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.WP.get(), EntityWp.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.AXEMAN.get(), EntityAxeman.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DUKE.get(), EntityDuke.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.SUMMONFRANK5.get(), EntitySummonSturm.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.SUMMONDAUGHTER.get(), EntitySummonDaughter.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.EDMAN.get(), EntityEdMan.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ENDGUARD.get(), EntityEndGuard.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ENDKING.get(), EntityEndKing.setAttributes().build()));
        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.ENDSCIBLACK.get(), EntityEndScienceBlack.setAttributes().build()));

        event.enqueueWork(() -> {
            ModStructures.setupStructures();
            ModConfiguredStructures.registerConfiguredStructures();
        });

//        BrewingRecipeRegistry.addRecipe(Ingredient.of(Potions.AWKWARD),Ingredient.of(ModItems.HUMUS.get()), ModPotions.DEADLY_POTION.get());
//        addMix(Potions.AWKWARD,ModItems.RUSTEDPART.get(), ModPotions.EROSION_POTION.get());
//        addMix(Potions.AWKWARD,ModItems.DESOLATE_GRASS_BLOCK.get(), ModPotions.BURN_POTION.get());

        //EntityDuke.registerPOIs();
        //DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.GM79B.get(), EntityGM79B.setAttributes().build()));

//        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.DX.get(), EntityDx.setAttributes().build()));
//        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.JX.get(), EntityJx.setAttributes().build()));
//        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.PH.get(), EntityPh.setAttributes().build()));
//        DeferredWorkQueue.runLater(() -> GlobalEntityTypeAttributes.put(EntityInit.XF.get(), EntityXf.setAttributes().build()));

        //        LOGGER.info("PreInit");
        //        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

            RenderTypeLookup.setRenderLayer(ModBlocks.HERB_BLOCK.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.EBONY_LEAVES.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.EBONY_SAPLING.get(), RenderType.cutout());

            //MenuScreens.register(MenuInit.VIRUS_GENERATOR_MENU.get(), VirusGeneratorScreen::new);
            ScreenManager.register(MenuInit.VIRUS_GENERATOR_MENU.get(), VirusGeneratorScreen::new);
            //ScreenManager.register(BookBase::new);

        });
    }


    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(RegistryEvents.RE8GROUP))
                    .setRegistryName(block.getRegistryName()));
        });
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }

    public static class RE8Group extends ItemGroup {
        public RE8Group(String name){
            super(name);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.UMBERLLA_BLOCK.get());
        }
    }

    private static void addMix(Potion p_193357_0_, Item p_193357_1_, Potion p_193357_2_) {
        POTION_MIXES.add(new MMixPredicate<>(p_193357_0_, Ingredient.of(p_193357_1_), p_193357_2_));
    }

    static class MMixPredicate<T extends net.minecraftforge.registries.ForgeRegistryEntry<T>> {
        private final net.minecraftforge.registries.IRegistryDelegate<T> from;
        private final Ingredient ingredient;
        private final net.minecraftforge.registries.IRegistryDelegate<T> to;

        public MMixPredicate(T p_i47570_1_, Ingredient p_i47570_2_, T p_i47570_3_) {
            this.from = p_i47570_1_.delegate;
            this.ingredient = p_i47570_2_;
            this.to = p_i47570_3_.delegate;
        }
    }
}

