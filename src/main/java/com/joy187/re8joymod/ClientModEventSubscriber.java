package com.joy187.re8joymod;

import com.joy187.re8joymod.entity.model.*;
import com.joy187.re8joymod.entity.render.*;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.items.itemBook.BookBase;
import com.joy187.re8joymod.particles.ParticleDefend;
import com.joy187.re8joymod.particles.ParticleFlame;
import com.joy187.re8joymod.particles.ParticleMucus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import static com.joy187.re8joymod.init.KeyBindInit.KEY_FIRE;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEventSubscriber extends ModEventSubscriber{

    @Override
    public void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModEventSubscriber::setupParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModEventSubscriber::onKeyRegister);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModEventSubscriber::onRegisterLayers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModEventSubscriber::registerRenderers);

    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {

        //event.registerEntityRenderer(EntityInit.SAMCA.get(), RenderSamca::new);
        event.registerEntityRenderer(EntityInit.FLY.get(), RenderFly::new);
        event.registerEntityRenderer(EntityInit.RE8DIMI.get(), RenderRe8Dimi::new);
        event.registerEntityRenderer(EntityInit.DIMI2.get(), RenderDimi2::new);
        event.registerEntityRenderer(EntityInit.ETHAN.get(), RenderEthan::new);
        event.registerEntityRenderer(EntityInit.MOSPITTER.get(), RenderMoSpitter::new);
        event.registerEntityRenderer(EntityInit.DUND1.get(), RenderDund::new);
        event.registerEntityRenderer(EntityInit.DUND2.get(), RenderDund2::new);
        event.registerEntityRenderer(EntityInit.SAMCA.get(), RenderSamca::new);
        event.registerEntityRenderer(EntityInit.BELA.get(), RenderBela::new);
        event.registerEntityRenderer(EntityInit.CASSANDRA.get(), RenderCassandra::new);
        event.registerEntityRenderer(EntityInit.DANIELA.get(), RenderDaniela::new);
        event.registerEntityRenderer(EntityInit.BEI.get(), RenderBei::new);
        event.registerEntityRenderer(EntityInit.ANGIE.get(), RenderAngie::new);
        event.registerEntityRenderer(EntityInit.DOLL1.get(), RenderDoll1::new);
        event.registerEntityRenderer(EntityInit.DOLL2.get(), RenderDoll2::new);
        event.registerEntityRenderer(EntityInit.DOLL3.get(), RenderDoll3::new);
        event.registerEntityRenderer(EntityInit.BEIBABY.get(), RenderBeibaby::new);
        event.registerEntityRenderer(EntityInit.FRANK1.get(), RenderFrank1::new);
        event.registerEntityRenderer(EntityInit.FRANK2.get(), RenderFrank2::new);
        event.registerEntityRenderer(EntityInit.FRANK3.get(), RenderFrank3::new);
        event.registerEntityRenderer(EntityInit.FRANK4.get(), RenderFrank4::new);
        event.registerEntityRenderer(EntityInit.FRANK5.get(), RenderFrank5::new);
        event.registerEntityRenderer(EntityInit.FRANK6.get(), RenderFrank6::new);
        event.registerEntityRenderer(EntityInit.M1851B.get(), RenderM1851B::new);
        event.registerEntityRenderer(EntityInit.M1897B.get(), RenderM1897B::new);
        event.registerEntityRenderer(EntityInit.BOWSHOOT.get(), RenderBOWShoot::new);
        event.registerEntityRenderer(EntityInit.GM79B.get(), RenderGM79B::new);
        event.registerEntityRenderer(EntityInit.LYCANA.get(), RenderLycana::new);
        event.registerEntityRenderer(EntityInit.MYCETE.get(), RenderMycete::new);
        event.registerEntityRenderer(EntityInit.MMYCETE.get(), RenderMMycete::new);
        event.registerEntityRenderer(EntityInit.VARCOLAC.get(), RenderVarcolac::new);
        event.registerEntityRenderer(EntityInit.LYCAN.get(), RenderLycan::new);
        event.registerEntityRenderer(EntityInit.LYCAN1.get(), RenderLycan1::new);
        event.registerEntityRenderer(EntityInit.PIPEB.get(), RenderPipeb::new);
        event.registerEntityRenderer(EntityInit.MOREAU.get(), RenderMoreau::new);
        event.registerEntityRenderer(EntityInit.MOREAU2.get(), RenderMoreau2::new);
        event.registerEntityRenderer(EntityInit.MOREAU3.get(), RenderMoreau3::new);
        event.registerEntityRenderer(EntityInit.HEISEN.get(), RenderHeisen::new);
        event.registerEntityRenderer(EntityInit.MUHEISEN.get(), RenderMuHeisen::new);
        event.registerEntityRenderer(EntityInit.MIA.get(), RenderMia::new);
        event.registerEntityRenderer(EntityInit.URIAS.get(), RenderUrias::new);
        event.registerEntityRenderer(EntityInit.URIASS.get(), RenderUriass::new);
        event.registerEntityRenderer(EntityInit.CHRIS.get(), RenderChris::new);
        event.registerEntityRenderer(EntityInit.AXEMAN.get(), RenderAxeman::new);
        event.registerEntityRenderer(EntityInit.HEISENCAR.get(), RenderHeisencar::new);
        event.registerEntityRenderer(EntityInit.DUKE.get(), RenderDuke::new);
        event.registerEntityRenderer(EntityInit.THEHAG.get(), RenderTheHag::new);
        event.registerEntityRenderer(EntityInit.MIRANDA1.get(), RenderMiranda1::new);
        event.registerEntityRenderer(EntityInit.MIRANDA2.get(), RenderMiranda2::new);
        event.registerEntityRenderer(EntityInit.MIRANDA3.get(), RenderMiranda3::new);
        event.registerEntityRenderer(EntityInit.MIRANDA4.get(), RenderMiranda4::new);
        event.registerEntityRenderer(EntityInit.ROSEMARY.get(), RenderRosemary::new);
        event.registerEntityRenderer(EntityInit.ADA.get(), RenderAda::new);
        event.registerEntityRenderer(EntityInit.MOREAU4.get(), RenderMoreau4::new);
        //event.registerEntityRenderer(EntityInit.OBBOAT.get(), RenderObBoat::new);
        //event.registerEntityRenderer(EntityInit.OBBOAT.get(), pContext -> new RenderObBoat(pContext, false));
        event.registerEntityRenderer(EntityInit.MOPROJECTILE.get(), RenderMoreauProjectile::new);
        event.registerEntityRenderer(EntityInit.SUMMONFRANK5.get(), RenderSummonSturm::new);
        event.registerEntityRenderer(EntityInit.SUMMONDAUGHTER.get(), RenderSummonDaughter::new);
        event.registerEntityRenderer(EntityInit.SNIPERAMMO.get(), RenderSniperAmmo::new);
        event.registerEntityRenderer(EntityInit.RIFLEAMMO.get(), RenderRifleAmmo::new);
        event.registerEntityRenderer(EntityInit.ADA4.get(), RenderAda4::new);
        event.registerEntityRenderer(EntityInit.LEON.get(), RenderLeon::new);
        event.registerEntityRenderer(EntityInit.CHIEF2.get(), RenderChief2::new);
        event.registerEntityRenderer(EntityInit.CHIEF.get(), RenderChief::new);
        event.registerEntityRenderer(EntityInit.GARRADOR.get(), RenderGarrador::new);
        event.registerEntityRenderer(EntityInit.GRAPPLE.get(), RenderGrapple::new);
        event.registerEntityRenderer(EntityInit.MERCHANT.get(), RenderMerchant::new);
        event.registerEntityRenderer(EntityInit.VILLAGERGANADO.get(), RenderVillagerGanado::new);
        event.registerEntityRenderer(EntityInit.CVG.get(), RenderCvg::new);
        event.registerEntityRenderer(EntityInit.PLAGAS.get(), RenderPlagas::new);
        event.registerEntityRenderer(EntityInit.U3.get(), RenderU3::new);
        event.registerEntityRenderer(EntityInit.ELG.get(), RenderElg::new);
        event.registerEntityRenderer(EntityInit.PLAGASVILLAGER.get(), RenderPlagasVillager::new);
        event.registerEntityRenderer(EntityInit.PLAGASZOMBIE.get(), RenderPlagasZombie::new);
        //event.registerEntityRenderer(EntityInit.MOPROJECTILE.get(), RenderMoreauProjectile::new);
        event.registerEntityRenderer(EntityInit.DALLAGO.get(), RenderDellago::new);
        event.registerEntityRenderer(EntityInit.PLAGASENDERMAN.get(), RenderPlagasEnderman::new);
        event.registerEntityRenderer(EntityInit.PLAGASCREEPER.get(), RenderPlagasCreeper::new);
        event.registerEntityRenderer(EntityInit.HIGHEX.get(), RenderHighEx::new);
        event.registerEntityRenderer(EntityInit.VERDUGO.get(), RenderVerdugo::new);
        event.registerEntityRenderer(EntityInit.MANNEQUIN.get(), RenderMannequin::new);
        event.registerEntityRenderer(EntityInit.ARMADURA.get(), RenderArmadura::new);
        event.registerEntityRenderer(EntityInit.ZEALOT.get(), RenderZealot::new);
        event.registerEntityRenderer(EntityInit.HELI.get(), RenderHeli::new);
        event.registerEntityRenderer(EntityInit.SALAZAR.get(), RenderSalazar::new);
        event.registerEntityRenderer(EntityInit.FALLBLOCK.get(), RenderEntityFallingBlock::new);
        event.registerEntityRenderer(EntityInit.PLAGASARMADURA.get(), RenderPlagasArmadura::new);
        event.registerEntityRenderer(EntityInit.ZEALOTA.get(), RenderZealota::new);
        event.registerEntityRenderer(EntityInit.KRAUSER2.get(), RenderKrauser2::new);
        event.registerEntityRenderer(EntityInit.KRAUSER.get(), RenderKrauser::new);
        event.registerEntityRenderer(EntityInit.REGENERATOR.get(), RenderRegenerator::new);
        event.registerEntityRenderer(EntityInit.REGENERATOR2.get(), RenderRegenerator2::new);
        event.registerEntityRenderer(EntityInit.HANK.get(), RenderHank::new);
        event.registerEntityRenderer(EntityInit.PLAGASC.get(), RenderPlagasc::new);
        event.registerEntityRenderer(EntityInit.EVILDOG.get(), RenderEvilDog::new);
        event.registerEntityRenderer(EntityInit.PLAGASDOG.get(), RenderPlagasDog::new);
        event.registerEntityRenderer(EntityInit.JJ.get(), RenderJJ::new);
        event.registerEntityRenderer(EntityInit.SCSHAKE.get(), RenderNull::new);
        event.registerEntityRenderer(EntityInit.CHIEF3.get(), RenderChief3::new);
        event.registerEntityRenderer(EntityInit.FIREENTITY.get(), RenderFireEntity::new);
        event.registerEntityRenderer(EntityInit.SOLDI.get(), RenderSoldi::new);
        event.registerEntityRenderer(EntityInit.FE.get(), RenderFaceEater::new);
        event.registerEntityRenderer(EntityInit.NOVI.get(), RenderNovi::new);
        event.registerEntityRenderer(EntityInit.SADDLER.get(), RenderSaddler::new);
        event.registerEntityRenderer(EntityInit.STUFF.get(), RenderStuff::new);
        event.registerEntityRenderer(EntityInit.ASH.get(), RenderAsh::new);
        event.registerEntityRenderer(EntityInit.PLAGASM.get(), RenderPlagasm::new);
        event.registerEntityRenderer(EntityInit.SALAZ.get(), RenderSalaz::new);
        event.registerEntityRenderer(EntityInit.GOLDENEGG.get(), RenderGE::new);
        event.registerEntityRenderer(EntityInit.LUIS.get(), RenderLuis::new);
        event.registerEntityRenderer(EntityInit.SADDLER2.get(), RenderSaddler2::new);
        event.registerEntityRenderer(EntityInit.BRUTE.get(), RenderBrute::new);
        event.registerEntityRenderer(EntityInit.CHAOS_FIREBALL.get(),
                ctx -> new net.minecraft.client.renderer.entity.ThrownItemRenderer<>(ctx, 3.0F, true));
        event.registerEntityRenderer(EntityInit.KLEE.get(), RenderKlee::new);
        event.registerEntityRenderer(EntityInit.BOMB.get(), RenderBomb::new);
        event.registerEntityRenderer(EntityInit.JUMPBOMB.get(), RenderJumpBomb::new);
        event.registerEntityRenderer(EntityInit.FIRE_ENTITY.get(), RenderHonghong::new);
        
        //event.registerEntityRenderer(EntityInit.OBBOAT.get(), RenderObBoat::new);
        event.registerEntityRenderer(EntityInit.DETONATOR_ENTITY.get(), RenderDetonatorEntity::new);
    }

    @OnlyIn(Dist.CLIENT)
    public void openRe8StoryBookGui(ItemStack book) {
        Minecraft.getInstance().setScreen(new BookBase(book));
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KEY_FIRE);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //event.registerLayerDefinition(ModelRe8Dimi.LAYER_LOCATION, ModelRe8Dimi::createBodyLayer);
        //event.registerLayerDefinition(ModelDimi2.LAYER_LOCATION, ModelDimi2::createBodyLayer);
        event.registerLayerDefinition(ModelEthan.LAYER_LOCATION, ModelEthan::createBodyLayer);
        //event.registerLayerDefinition(ModelDund.LAYER_LOCATION, ModelDund::createBodyLayer);
        event.registerLayerDefinition(ModelAngie.LAYER_LOCATION, ModelAngie::createBodyLayer);
        event.registerLayerDefinition(ModelDoll1.LAYER_LOCATION, ModelDoll1::createBodyLayer);
        event.registerLayerDefinition(ModelDoll2.LAYER_LOCATION, ModelDoll2::createBodyLayer);
        event.registerLayerDefinition(ModelFrank4.LAYER_LOCATION, ModelFrank4::createBodyLayer);
        event.registerLayerDefinition(ModelMycete.LAYER_LOCATION, ModelMycete::createBodyLayer);
        event.registerLayerDefinition(ModelMMycete.LAYER_LOCATION, ModelMMycete::createBodyLayer);
        event.registerLayerDefinition(ModelHeisencar.LAYER_LOCATION, ModelHeisencar::createBodyLayer);
        event.registerLayerDefinition(ModelTheHag.LAYER_LOCATION, ModelTheHag::createBodyLayer);
        event.registerLayerDefinition(ModelMiranda4.LAYER_LOCATION, ModelMiranda4::createBodyLayer);
        event.registerLayerDefinition(ModelMoreau4.LAYER_LOCATION, ModelMoreau4::createBodyLayer);
        event.registerLayerDefinition(ModelMannequin.LAYER_LOCATION, ModelMannequin::createBodyLayer);
        //event.registerLayerDefinition(ModelObBoat.LAYER_LOCATION, ModelObBoat::createBodyLayer);

        //event.registerLayerDefinition(ModelRE8Elytra.RE8_ELYTRA, () -> ModelRE8Elytra.createLayer(new CubeDeformation(1.0F)));

        //event.registerLayerDefinition(ModelObBoat.LAYER_LOCATION, ModelObBoat::createBodyLayer);

    }

    public static void setupParticles(RegisterParticleProvidersEvent registry) {
        registry.registerSpriteSet(ParticleInit.MUCUS_PARTICLE.get(), ParticleMucus.Provider::new);
        registry.registerSpriteSet(ParticleInit.DEFEND_PARTICLE.get(), ParticleDefend.Provider::new);
        registry.registerSpriteSet(ParticleInit.FLAME_PARTICLE.get(), ParticleFlame.Provider::new);
    }



}
