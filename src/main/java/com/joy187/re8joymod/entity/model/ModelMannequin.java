package com.joy187.re8joymod.entity.model;

// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMannequin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

//public class ModelMannequin<T extends EntityMannequin> extends EntityModel<T> {
//	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ethan"), "main");
//	private final ModelPart Head;
//	private final ModelPart Body;
//	private final ModelPart RightArm;
//	private final ModelPart LeftArm;
//	private final ModelPart RightLeg;
//	private final ModelPart LeftLeg;
//
//	public ModelMannequin(ModelPart root) {
//		this.Head = root.getChild("Head");
//		this.Body = root.getChild("Body");
//		this.RightArm = root.getChild("RightArm");
//		this.LeftArm = root.getChild("LeftArm");
//		this.RightLeg = root.getChild("RightLeg");
//		this.LeftLeg = root.getChild("LeftLeg");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F, 0.0F));
//
//		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(14, 14).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
//
//		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -6.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
//
//		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, -1.0F, 0.2094F, 0.0F, 0.0F));
//
//		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
//
//		PartDefinition leftfront = LeftArm.addOrReplaceChild("leftfront", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.48F, 0.0F, 0.0F));
//
//		PartDefinition bottle2_r1 = leftfront.addOrReplaceChild("bottle2_r1", CubeListBuilder.create().texOffs(32, 41).addBox(0.5F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.8296F, -2.8114F, -0.1745F, 0.0F, 0.5672F));
//
//		PartDefinition bottle1_r1 = leftfront.addOrReplaceChild("bottle1_r1", CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, 6.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
//		.texOffs(32, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9487F, -0.0622F, -0.1745F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.3665F, 0.0F, 0.0349F));
//
//		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(16, 49).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.026F, -2.953F, 0.2182F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(16, 49).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.6981F, 0.0F, 0.0F));
//
//		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.0873F, 0.0F, -0.0349F));
//
//		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.953F, 0.5264F, 0.5672F, 0.0F, 0.0F));
//
//		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, -7.0F, -3.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.8264F, 0.9848F, -0.0873F, 0.0F, 0.0F));
//
//		return LayerDefinition.create(meshdefinition, 64, 64);
//	}
//
//	@Override
//	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
//		this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;
//
//		this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
//		this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;
//
//		this.Head.yRot = netHeadYaw * 0.017453292F;
//		this.Head.xRot = headPitch * 0.017453292F;
//	}
//
//	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
//		ModelPart.xRot = x;
//		ModelPart.yRot= y;
//		ModelPart.zRot = z;
//	}
//
//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		Head.render(poseStack, buffer, packedLight, packedOverlay);
//		Body.render(poseStack, buffer, packedLight, packedOverlay);
//		RightArm.render(poseStack, buffer, packedLight, packedOverlay);
//		LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
//		RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
//		LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
//	}
//}
public class ModelMannequin<T extends EntityMannequin> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/mannequin.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelMannequin(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(14, 14).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(42, 16).addBox(-1.0F, -6.0F, -1.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, -1.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -6.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftfront = LeftArm.addOrReplaceChild("leftfront", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.3665F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(16, 53).addBox(-1.9F, -0.021F, -2.0003F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5936F, -2.9174F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition RightLeg_r2_r1 = RightLeg_r2.addOrReplaceChild("RightLeg_r2_r1", CubeListBuilder.create().texOffs(16, 48).addBox(-3.9F, -11.3906F, -3.8051F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 6.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.0873F, 0.0F, -0.0349F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.953F, 0.5264F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LeftLeg_r1_r1 = LeftLeg_r1.addOrReplaceChild("LeftLeg_r1_r1", CubeListBuilder.create().texOffs(17, 53).addBox(-0.2018F, -8.0688F, -3.0787F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 8.3385F, -4.1589F, -0.48F, 0.0028F, -0.0013F));

		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.8264F, 0.9848F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftLeg_r2_r1 = LeftLeg_r2.addOrReplaceChild("LeftLeg_r2_r1", CubeListBuilder.create().texOffs(16, 48).addBox(-0.1018F, -13.226F, -1.4175F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 6.1736F, -0.9848F, 0.0872F, 0.003F, 0.0007F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
	}
}