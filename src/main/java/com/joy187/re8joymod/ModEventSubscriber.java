package com.joy187.re8joymod;


import com.joy187.re8joymod.entity.model.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{
    public void init() {
    }

    public Player getClientSidePlayer() {
        return null;
    }

    public void clientInit() {

    }

    public void openRe8StoryBookGui(ItemStack book){

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelAngie.LAYER_LOCATION, ModelAngie::createBodyLayer);
        event.registerLayerDefinition(ModelEthan.LAYER_LOCATION, ModelEthan::createBodyLayer);
        event.registerLayerDefinition(ModelMycete.LAYER_LOCATION, ModelMycete::createBodyLayer);
        event.registerLayerDefinition(ModelMMycete.LAYER_LOCATION, ModelMMycete::createBodyLayer);
        event.registerLayerDefinition(ModelMannequin.LAYER_LOCATION, ModelMannequin::createBodyLayer);
        event.registerLayerDefinition(ModelHeisencar.LAYER_LOCATION, ModelHeisencar::createBodyLayer);
        event.registerLayerDefinition(ModelDoll1.LAYER_LOCATION, ModelDoll1::createBodyLayer);
        event.registerLayerDefinition(ModelDoll2.LAYER_LOCATION, ModelDoll2::createBodyLayer);
        event.registerLayerDefinition(ModelFrank4.LAYER_LOCATION, ModelFrank4::createBodyLayer);
        event.registerLayerDefinition(ModelTheHag.LAYER_LOCATION, ModelTheHag::createBodyLayer);
        event.registerLayerDefinition(ModelMoreau4.LAYER_LOCATION, ModelMoreau4::createBodyLayer);
        event.registerLayerDefinition(ModelMiranda4.LAYER_LOCATION, ModelMiranda4::createBodyLayer);
        //event.registerLayerDefinition(ModelObBoat.LAYER_LOCATION, ModelObBoat::createBodyLayer);
        event.registerLayerDefinition(ModelMoreauProjectile.LAYER_LOCATION, ModelMoreauProjectile::createBodyLayer);
        event.registerLayerDefinition(ModelMoSpitter.LAYER_LOCATION, ModelMoSpitter::createBodyLayer);

//        event.registerLayerDefinition(ModModelLayers.WALNUT_BOAT_LAYER, BoatModel::createBodyModel);
//        event.registerLayerDefinition(ModModelLayers.WALNUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

    }
}