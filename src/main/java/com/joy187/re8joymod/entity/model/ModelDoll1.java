package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll1;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ModelDoll1<T extends EntityDoll1> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/doll1.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelDoll1(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.1047F, 0.0873F, 0.48F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(12, 34).addBox(-2.9869F, 5.8325F, -4.2833F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -8.3897F, -0.6637F, 0.3927F, 0.0F, -0.48F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1699F, -6.4495F, -1.8643F, 0.3927F, -1.1345F, -0.0873F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(11, 43).addBox(1.5F, -2.9F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 24).addBox(1.0F, -1.9F, -1.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 6).addBox(0.5F, -0.9F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7223F, -2.9771F, -1.5772F, 0.3927F, -0.3054F, -0.0873F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 13).addBox(-4.9869F, 5.8325F, -5.2833F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -9.3897F, -0.6637F, 0.3927F, 0.0F, -0.48F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(7, 0).addBox(-3.0F, 6.0F, -2.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r5 = Body.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(29, 11).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4171F, 6.7881F, 2.5307F, 0.3927F, -0.0436F, -0.0436F));

		PartDefinition Head_r6 = Body.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(30, 18).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4171F, 6.7881F, 2.5307F, 0.3927F, 0.0F, 0.0873F));

		PartDefinition move_r1 = Body.addOrReplaceChild("move_r1", CubeListBuilder.create().texOffs(14, 32).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9071F, 10.5F, -2.1269F, 0.0F, 1.8762F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 7.0F, 0.0F, -0.1745F, 0.6109F, 0.0F));

		PartDefinition hand1_r1 = RightArm.addOrReplaceChild("hand1_r1", CubeListBuilder.create().texOffs(43, 26).addBox(-0.4952F, -4.6749F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5048F, 9.5604F, -0.3124F, 0.0436F, -0.5236F, 0.1309F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(3, 3).addBox(-0.203F, -1.076F, -0.6841F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0608F, -0.1946F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 3.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition hand2_r1 = LeftArm.addOrReplaceChild("hand2_r1", CubeListBuilder.create().texOffs(43, 26).addBox(-1.5287F, -1.5F, 0.1634F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5287F, 9.6418F, -1.1634F, 0.0436F, -0.5236F, 0.0436F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(13, 16).addBox(-1.5F, -1.0373F, -1.1093F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition scissors = LeftArm.addOrReplaceChild("scissors", CubeListBuilder.create(), PartPose.offset(-2.5F, 7.0F, -4.0F));

		PartDefinition Body_r1 = scissors.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(48, 20).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.2304F, 4.5649F, -5.9772F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r2 = scissors.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(50, 25).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.2836F, 4.122F, -5.9772F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r3 = scissors.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(45, 61).addBox(2.0F, -0.5F, -0.1F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4029F, 3.639F, -5.2826F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r4 = scissors.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(46, 13).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.842F, 7.5524F, -5.9772F, 0.0F, 0.1745F, 1.3526F));

		PartDefinition Body_r5 = scissors.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(47, 11).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2763F, 7.4508F, -5.9772F, 0.0F, 0.1745F, 1.1345F));

		PartDefinition Body_r6 = scissors.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(36, 47).addBox(2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(16, 49).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4029F, 3.639F, -5.2826F, 0.0F, 0.1745F, 1.309F));

		PartDefinition Body_r7 = scissors.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(7, 47).addBox(2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1747F, -1.1832F, -3.8934F, 0.0F, 0.1745F, 0.5672F));

		PartDefinition Body_r8 = scissors.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1213F, 0.0F, -3.8934F, 0.0F, 0.1745F, 0.0F));

		PartDefinition Body_r9 = scissors.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(6, 50).addBox(-1.5F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.354F, 0.5F, -1.5901F, 0.0F, 1.0908F, 0.0F));

		PartDefinition Body_r10 = scissors.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(16, 47).addBox(-0.5F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 2.0F, 0.0F, 1.4835F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));

		PartDefinition Rightll_r1 = RightLeg.addOrReplaceChild("Rightll_r1", CubeListBuilder.create().texOffs(17, 4).addBox(0.732F, 1.7511F, -2.2535F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7933F, 0.2683F, 0.5F, -0.1745F, 0.0F, -0.0436F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(4, 27).addBox(-1.0F, -1.6749F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1874F, 8.6749F, 0.8632F, 0.0436F, 0.0F, 0.1309F));

		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(4, 27).addBox(-1.6027F, 3.3871F, -0.4323F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0236F, 3.5F, 0.5824F, 0.0436F, 0.0F, -0.0873F));

		PartDefinition LeftLeg_r3 = LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(18, 5).addBox(-1.6027F, -1.6129F, -1.4323F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0236F, 3.5F, 0.5824F, 0.1745F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftArm.getChild("scissors").yRot = headPitch * 0.017453292F;
		this.LeftArm.getChild("scissors").zRot = headPitch * 0.017453292F;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
	}

	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		Body.render(poseStack, buffer, packedLight, packedOverlay);
		RightArm.render(poseStack, buffer, packedLight, packedOverlay);
		LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}