//package com.joy187.re8joymod.entity.model;
////import com.joy187.re8joymod.entity.EntityObBoat;
//
//import com.joy187.re8joymod.Main;
//import com.joy187.re8joymod.entity.EntityObBoat;
//import net.minecraft.client.model.EntityModel;
//
//// Made with Blockbench 4.2.2
//// Exported for Minecraft version 1.17 with Mojang mappings
//// Paste this class into your mod and generate all required imports
//
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.CubeDeformation;
//import net.minecraft.client.model.geom.builders.CubeListBuilder;
//import net.minecraft.client.model.geom.builders.LayerDefinition;
//import net.minecraft.client.model.geom.builders.MeshDefinition;
//import net.minecraft.client.model.geom.builders.PartDefinition;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.Mth;
//
//public class ModelObBoat<T extends EntityObBoat> extends EntityModel<T> {
//	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/boat/obboat1.png"), "");
////	public static final ModelLayerLocation WALNUT_BOAT_LAYER = new ModelLayerLocation(
////			new ResourceLocation(MCCourseMod.MOD_ID, "boat/walnut"), "main");
//	private final ModelPart obboat;
//
//	public ModelObBoat(ModelPart root) {
//		this.obboat = root.getChild("obboat");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition obboat = partdefinition.addOrReplaceChild("obboat", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1091F, 28.0951F, -0.1605F, 0.0F, 0.0F, -0.4363F));
//
//		PartDefinition right = obboat.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
//
//		PartDefinition cube_r1 = right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, 1.0F, -5.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4928F, -0.6057F, -0.419F, 0.0F, 0.0F, -0.9599F));
//
//		PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, 1.0F, 8.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8388F, 2.2856F, -0.0539F, 0.4363F, 0.1309F, -0.9599F));
//
//		PartDefinition cube_r3 = right.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, 1.0F, -18.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3981F, 0.2992F, -0.2585F, -0.3859F, -0.0651F, -0.9065F));
//
//		PartDefinition left = obboat.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(-9.2317F, -4.9991F, 0.1554F));
//
//		PartDefinition cube_r4 = left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 1.0F, -18.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4732F, 0.0651F, 1.9973F));
//
//		PartDefinition cube_r5 = left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 1.0F, 8.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.416F, 0.0144F, 0.2097F, 0.4363F, -0.1309F, 2.0508F));
//
//		PartDefinition cube_r6 = left.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 1.0F, -5.0F, 5.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.2252F, 0.7475F, -0.1554F, 0.0F, 0.0F, 2.0508F));
//
//		PartDefinition bottom = obboat.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(-7.0064F, -4.2516F, 0.0F));
//
//		PartDefinition cube_r7 = bottom.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.6027F, 4.0F, -10.0F, 7.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.7053F));
//
//		return LayerDefinition.create(meshdefinition, 16, 16);
//	}
//
//	@Override
//	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		obboat.render(poseStack, buffer, packedLight, packedOverlay);
//	}
//}