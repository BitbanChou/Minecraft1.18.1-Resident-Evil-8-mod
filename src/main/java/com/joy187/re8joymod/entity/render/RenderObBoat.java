//package com.joy187.re8joymod.entity.render;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//import com.google.common.collect.ImmutableMap;
//import com.joy187.re8joymod.Main;
//import com.joy187.re8joymod.entity.EntityObBoat;
//
//import com.joy187.re8joymod.entity.model.ModelObBoat;
//import com.mojang.datafixers.util.Pair;
//
//
//import net.minecraft.client.model.BoatModel;
//import net.minecraft.client.model.ChestBoatModel;
//import net.minecraft.client.model.ListModel;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelLayers;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.renderer.entity.BoatRenderer;
//import net.minecraft.client.renderer.entity.EntityRenderer;
//import net.minecraft.client.renderer.entity.EntityRendererProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.vehicle.Boat;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
////public class RenderObBoat extends EntityRenderer<EntityObBoat> {
////   private final Map<EntityObBoat.Type, Pair<ResourceLocation, BoatModel>> boatResources;
////
////   public RenderObBoat(EntityRendererProvider.Context p_173936_) {
////      super(p_173936_);
////      this.shadowRadius = 0.8F;
////      this.boatResources = Stream.of(Boat.Type.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
////         return p_173938_;
////      }, (p_234575_) -> {
////         return Pair.of(new ResourceLocation(Main.MOD_ID, "textures/entity/obboat.png"), this.createBoatModel(p_173936_, p_234575_, true));
////      }));
////   }
////
////   private BoatModel createBoatModel(EntityRendererProvider.Context p_234569_, Boat.Type p_234570_, boolean p_234571_) {
////      ModelLayerLocation modellayerlocation = p_234571_ ? ModelLayers.createChestBoatModelName(p_234570_) : ModelLayers.createBoatModelName(p_234570_);
////      return new BoatModel(p_234569_.bakeLayer(modellayerlocation));
////   }
////
////   public void render(EntityObBoat p_113929_, float p_113930_, float p_113931_, PoseStack p_113932_, MultiBufferSource p_113933_, int p_113934_) {
////      p_113932_.pushPose();
////      p_113932_.translate(0.0D, 0.375D, 0.0D);
////      p_113932_.mulPose(Axis.YP.rotationDegrees(180.0F - p_113930_));
////      float f = (float)p_113929_.getHurtTime() - p_113931_;
////      float f1 = p_113929_.getDamage() - p_113931_;
////      if (f1 < 0.0F) {
////         f1 = 0.0F;
////      }
////
////      if (f > 0.0F) {
////         p_113932_.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float)p_113929_.getHurtDir()));
////      }
////
////      float f2 = p_113929_.getBubbleAngle(p_113931_);
////      if (!Mth.equal(f2, 0.0F)) {
////         p_113932_.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), p_113929_.getBubbleAngle(p_113931_), true));
////      }
////
////      Pair<ResourceLocation, BoatModel> pair = getModelWithLocation(p_113929_);
////      ResourceLocation resourcelocation = pair.getFirst();
////      BoatModel boatmodel = pair.getSecond();
////      p_113932_.scale(-1.0F, -1.0F, 1.0F);
////      p_113932_.mulPose(Axis.YP.rotationDegrees(90.0F));
////      boatmodel.setupAnim(p_113929_, p_113931_, 0.0F, -0.1F, 0.0F, 0.0F);
////      VertexConsumer vertexconsumer = p_113933_.getBuffer(boatmodel.renderType(resourcelocation));
////      boatmodel.renderToBuffer(p_113932_, vertexconsumer, p_113934_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
////      if (!p_113929_.isUnderWater()) {
////         VertexConsumer vertexconsumer1 = p_113933_.getBuffer(RenderType.waterMask());
////         boatmodel.waterPatch().render(p_113932_, vertexconsumer1, p_113934_, OverlayTexture.NO_OVERLAY);
////      }
////
////      p_113932_.popPose();
////      super.render(p_113929_, p_113930_, p_113931_, p_113932_, p_113933_, p_113934_);
////   }
////
////   @Deprecated // forge: override getModelWithLocation to change the texture / model
////   public ResourceLocation getTextureLocation(EntityObBoat p_113927_) {
////      return getModelWithLocation(p_113927_).getFirst();
////   }
////
////   public Pair<ResourceLocation, BoatModel> getModelWithLocation(EntityObBoat boat) { return this.boatResources.get(boat.getBoatType()); }
////}
////
//
//
//public class RenderObBoat extends BoatRenderer {
//   private final Map<EntityObBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;
//
//   public RenderObBoat(EntityRendererProvider.Context pContext, boolean pChestBoat) {
//      super(pContext, pChestBoat);
//      this.boatResources = Stream.of(EntityObBoat.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> type,
//              (type) -> Pair.of(new ResourceLocation(Main.MOD_ID, getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, Boat.Type.BAMBOO, pChestBoat))));
//   }
//
//   private static String getTextureLocation(EntityObBoat.Type pType, boolean pChestBoat) {
//      return pChestBoat ? "textures/entity/chest_boat/obboat1.png" : "textures/entity/boat/obboat1.png";
//   }
//
////   private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, EntityObBoat.Type pType, boolean pChestBoat) {
////      ModelLayerLocation modellayerlocation = pChestBoat ? ModelObBoat.LAYER_LOCATION : ModelObBoat.LAYER_LOCATION;//RenderObBoat.createBoatModelName(pType);
////      ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
////      return ModelLayers.createBoatModelName(Boat.Type.BAMBOO);
////   }
//
//   private ListModel<Boat> createBoatModel(EntityRendererProvider.Context p_234569_, Boat.Type p_234570_, boolean p_234571_) {
//      ModelLayerLocation modellayerlocation = p_234571_ ? ModelLayers.createChestBoatModelName(p_234570_) : ModelLayers.createBoatModelName(p_234570_);
//      return new BoatModel(p_234569_.bakeLayer(modellayerlocation));
//   }
//
//   public static ModelLayerLocation createBoatModelName(EntityObBoat.Type pType) {
//      return createLocation("boat/" + pType.getName(), "main");
//   }
//
//   public static ModelLayerLocation createChestBoatModelName(EntityObBoat.Type pType) {
//      return createLocation("chest_boat/" + pType.getName(), "main");
//   }
//
//   private static ModelLayerLocation createLocation(String pPath, String pModel) {
//      return new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, pPath), pModel);
//   }
//
//   public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
//      if(boat instanceof EntityObBoat modBoat) {
//         return this.boatResources.get(modBoat.getModVariant());
//      }
////      else if(boat instanceof ModChestBoatEntity modChestBoatEntity) {
////         return this.boatResources.get(modChestBoatEntity.getModVariant());
////      }
//      else {
//         return null;
//      }
//   }
//}