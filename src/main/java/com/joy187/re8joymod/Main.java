package com.joy187.re8joymod;


import com.joy187.re8joymod.blocks.screen.VirusGeneratorScreen;
import com.joy187.re8joymod.config.ModClientConfig;
import com.joy187.re8joymod.config.ModCommonConfig;
import com.joy187.re8joymod.entity.EntityDellago;
import com.joy187.re8joymod.entity.EntityDuke;
import com.joy187.re8joymod.event.ClientEvent;
import com.joy187.re8joymod.init.*;
import com.joy187.re8joymod.packet.ModMessage;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "re8joymod";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static ModEventSubscriber PROXY = DistExecutor.runForDist(() -> ClientModEventSubscriber::new, () -> ModEventSubscriber::new);
    public static int renderExecute=0;

    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemTabInit.register(bus);

        ItemInit.register(bus);
        BlockInit.register(bus);
        EntityInit.ENTITY_TYPES.register(bus);
        BlockEntityInit.register(bus);
        SoundInit.register(bus);
        MenuInit.register(bus);
        RecipeInit.register(bus);
        VillageInit.register(bus);

        PotionInit.register(bus);
        EffectInit.register(bus);
        ParticleInit.register(bus);
        GeckoLib.initialize();

        DimensionInit.register();

        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModClientConfig.SPEC, "re8joymod-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.SPEC, "re8joymod-common.toml");

        PROXY.init();
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

//            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Potions.AWKWARD,
//                    ItemInit.HUMUS.get(), PotionInit.DEADLY_POTION.get()));
//
//            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Potions.AWKWARD,
//                    ItemInit.RUSTPART.get(), PotionInit.EROSION_POTION.get()));
//
//            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Potions.AWKWARD,
//                    ItemInit.DESOLATE_GRASS_BLOCK.get(), PotionInit.BURN_POTION.get()));

//            EntityDuke.registerPOIs();

            SpawnPlacements.register(EntityInit.ANGIE.get(), SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(EntityInit.DOLL1.get(), SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(EntityInit.DOLL2.get(), SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
            SpawnPlacements.register(EntityInit.FRANK4.get(), SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.DALLAGO.get(), SpawnPlacements.Type.NO_RESTRICTIONS,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityDellago::checkDelSpawnRules);
//            SpawnPlacements.register(EntityInit.DUND1.get(), SpawnPlacements.Type.ON_GROUND,
//                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ghast::checkGhastSpawnRules);

            SpawnPlacements.register(EntityInit.FRANK5.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.FRANK6.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);

            SpawnPlacements.register(EntityInit.DUND1.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.DUND2.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.FRANK1.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.FRANK2.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.FRANK3.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.LYCAN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.LYCAN1.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.LYCANA.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(EntityInit.VARCOLAC.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
//        event.enqueueWork(() -> {
//            EntityDuke.registerPOIs();
//        });
        ModMessage.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
//            event.accept(ModItems.SAPPHIRE);
//            event.accept(ModItems.RAW_SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(MenuInit.VIRUS_GENERATOR_MENU.get(), VirusGeneratorScreen::new);
            MinecraftForge.EVENT_BUS.register(new ClientEvent());
        }
    }


    private void clientSetup(final FMLClientSetupEvent event) {
        PROXY.clientInit();
    }

}
