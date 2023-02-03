package com.joy187.re8joymod.common;


import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.render.*;
import com.joy187.re8joymod.common.init.EntityInit;
import com.joy187.re8joymod.common.items.itemBook.BookBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Sinhika
 */
@EventBusSubscriber(modid= Utils.MOD_ID, bus=EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
public class ClientModEventSubscriber extends ModEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Utils.MOD_ID + " Client Mod Event Subscriber");
    //private final Minecraft minecraft=Minecraft.getInstance();

    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.RE8DIMI.get(), RederRe8Dimi::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DIMI2.get(), RenderDimi2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BELA.get(), RenderBela::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.CASSANDRA.get(), RenderCassandra::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DANIELA.get(), RenderDaniela::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BEI.get(), RenderBei::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ANGIE.get(), RenderAngie::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DOLL1.get(), RenderDoll1::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DOLL2.get(), RenderDoll2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DOLL3.get(), RenderDoll3::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BEIBABY.get(), RenderBeibaby::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ETHAN.get(), RenderEthan::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HEISEN.get(), RenderHeisen::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MUHEISEN.get(), RenderMuHeisen::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOREAU.get(), RenderMoreau::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOREAU2.get(), RenderMoreau2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOREAU3.get(), RenderMoreau3::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOREAU4.get(), RenderMoreau4::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK1.get(), RenderFrank1::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK2.get(), RenderFrank2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK3.get(), RenderFrank3::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK4.get(), RenderFrank4::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK5.get(), RenderFrank5::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FRANK6.get(), RenderFrank6::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DUND.get(), RenderDund::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DUND2.get(), RenderDund2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SAMCA.get(), RenderSamca::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GM79B.get(), RenderGM79B::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LYCAN.get(), RenderLycan::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LYCAN1.get(), RenderLycan1::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityInit.LYCANA.get(), RenderLycana::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VARCOLAC.get(), RenderVarcolac::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.CHRIS.get(), RenderChris::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.URIAS.get(), RenderUrias::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.URIASS.get(), RenderUriass::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.THEHAG.get(), RenderTheHag::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MYCETE.get(), RenderMycete::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MMYCETE.get(), RenderMMycete::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MIRANDA1.get(), RenderMiranda1::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MIRANDA2.get(), RenderMiranda2::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MIRANDA3.get(), RenderMiranda3::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MIRANDA4.get(), RenderMiranda4::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MIA.get(), RenderMia::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROSE.get(), RenderRose::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.HEISENCAR.get(), RenderHeisenCar::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ADA.get(), RenderAda::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BP.get(), RenderBp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WP.get(), RenderWp::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.AXEMAN.get(), RenderAxeman::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DUKE.get(), RenderDuke::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GM79B.get(), RenderGM79B::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.M1851B.get(), RenderM1851B::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GM79B.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.M1851B.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.M1897B.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOSPITTER.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BOWShoot.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.PIPEB.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOPROJECTILE.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SNIPERAMMO.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.RIFLEAMMO.get(),
                renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.OBBOAT.get(), RenderObBoat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUMMONFRANK5.get(), RenderSummonSturm::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SUMMONDAUGHTER.get(), RenderSummonDaughter::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.EDMAN.get(), RenderEdMan::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ENDGUARD.get(), RenderEndGuard::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ENDKING.get(), RenderEndKing::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ENDSCIBLACK.get(), RenderEndScienceBlack::new);

//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DX.get(), RenderDx::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.JX.get(), RenderJx::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.PH.get(), RenderPh::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.XF.get(), RenderXf::new);

//        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DUCK.get(), DuckEntityRenderer::new);

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void openBestiaryGui(ItemStack book) {
        Minecraft.getInstance().setScreen(new BookBase(book));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void GM79Scope() {
        Minecraft.getInstance().options.fov=50;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void F2Scope() {
        Minecraft.getInstance().options.fov=12;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void NoScope() {
        Minecraft.getInstance().options.fov=70;
    }



} // end class