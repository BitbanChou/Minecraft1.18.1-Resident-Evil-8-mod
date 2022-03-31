package com.joy187.re8joymod;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.model.ModelRe8Dimi;
import com.joy187.re8joymod.entity.render.RenderRe8Dimi;
import com.joy187.re8joymod.init.EntityInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber
{
//    private static final Logger LOGGER = LogManager.getLogger(Utils.MOD_ID + " Client Mod Event Subscriber");

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
//    @SubscribeEvent
//    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
//    {
//
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.RE8DIMI.get(), RenderRe8Dimi::new);
//    }
    
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelRe8Dimi.LAYER_LOCATION, ModelRe8Dimi::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.RE8DIMI.get(), RenderRe8Dimi::new);
    }
    
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityInit.RE8DIMI.get(), EntityRe8Dimi.prepareAttributes().build());
    }

} // end class