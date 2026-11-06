package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank4;

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

public class ModelFrank4<T extends EntityFrank4> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/frank4.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelFrank4(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(2, 4).addBox(-3.5F, -2.637F, -4.4195F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(38, 9).addBox(-1.0F, 0.363F, -2.4195F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3465F, 0.1059F, -0.1047F, 0.0873F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(43, 9).addBox(-1.0F, 1.3F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.912F, -5.7491F, 1.789F, 0.0F, 0.0F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(3, 3).mirror().addBox(-3.0F, -1.0F, -4.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.2179F, -3.1127F, 1.2151F, 0.0F, 0.1309F, 0.2182F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(3, 3).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2179F, -3.1127F, 1.2151F, 0.0F, -0.1309F, -0.2182F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(15, 35).addBox(-3.5F, -2.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9338F, -1.7196F, -1.3241F, 0.0F, -0.2618F, -0.2182F));

		PartDefinition Head_r5 = Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(3, 3).addBox(-3.5F, -2.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.637F, -0.9195F, 0.0F, 0.3054F, 0.1309F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(15, 14).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 14.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(44, 51).addBox(-3.0F, -2.0F, 3.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 51).addBox(1.0F, 7.0F, 5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 51).addBox(-3.0F, 7.0F, 5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r6 = Body.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(43, 9).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9728F, -1.4134F, -2.532F, 1.6581F, 0.0F, 0.8727F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(15, 14).addBox(-1.5F, -0.5F, -1.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7082F, -1.7785F, -5.0593F, 0.0F, -2.8362F, 0.4363F));

		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(1, 37).addBox(-7.5F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4242F, -3.0451F, 2.7678F, 0.0F, -1.7453F, 0.4363F));

		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(3, 36).addBox(-2.5F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5872F, -2.6547F, 2.3852F, 0.0F, -0.6109F, 0.4363F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -5.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(27, 60).addBox(-1.5F, 15.5F, -0.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-2.0F, 9.5F, -0.8F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-2.5F, 2.5F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7091F, 1.2678F, -1.5708F, 0.0F, 0.0F));

		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 36).addBox(-2.5F, -3.5F, -2.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7611F, 5.0939F, -0.483F, -0.3054F, 0.0F, 0.0873F));

		PartDefinition knife = RightArm.addOrReplaceChild("knife", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6786F, 8.2577F, -6.9476F, 3.0543F, -1.6144F, 0.1309F));

		PartDefinition RightArm_r3 = knife.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(22, 59).addBox(-0.8916F, 2.4489F, -3.8882F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -3.7813F, 0.7669F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm_r4 = knife.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(22, 59).addBox(-0.8916F, 2.0085F, 2.0981F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -4.1893F, 0.507F, -0.5672F, 0.0F, 0.0F));

		PartDefinition RightArm_r5 = knife.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 4.0981F, 0.0085F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 60).addBox(-0.8916F, 0.0981F, 1.0085F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -2.7934F, 0.5466F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RightArm_r6 = knife.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, -0.2215F, 3.4119F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -2.7934F, 0.5466F, -0.6981F, 0.0F, 0.0F));

		PartDefinition RightArm_r7 = knife.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 1.1383F, 2.8734F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -2.7934F, 0.5466F, -0.48F, 0.0F, 0.0F));

		PartDefinition RightArm_r8 = knife.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 6.4291F, 0.0165F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -2.7498F, -0.4525F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm_r9 = knife.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 1.0758F, -3.9872F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -2.7498F, -0.4525F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RightArm_r10 = knife.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, -0.5285F, -5.6297F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 54).addBox(-3.8916F, 1.4715F, -6.6297F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(21, 54).addBox(-0.8916F, 2.4715F, -8.6297F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3916F, -0.9698F, 4.63F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm_r11 = knife.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(21, 54).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.244F, 0.157F, -1.0908F, 0.0F, 0.0F));

		PartDefinition RightArm_r12 = knife.addOrReplaceChild("RightArm_r12", CubeListBuilder.create().texOffs(21, 54).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.744F, -0.843F, -1.5708F, 0.0F, 0.0F));

		PartDefinition RightArm_r13 = knife.addOrReplaceChild("RightArm_r13", CubeListBuilder.create().texOffs(21, 54).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.7013F, 0.1125F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(33, 51).addBox(-0.5F, 1.5F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(33, 51).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(33, 51).addBox(-2.0F, -3.5F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.981F, -7.4918F, -1.5272F, 0.0F, 0.0F));

		PartDefinition LeftArm_r2 = LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(33, 51).addBox(-1.5F, -1.2812F, -3.4483F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.2012F, 0.8802F, -0.9163F, 0.0F, 0.0F));

		PartDefinition LeftArm_r3 = LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(12, 22).addBox(-1.5F, -8.9776F, -2.1344F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition knife2 = LeftArm.addOrReplaceChild("knife2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3577F, 8.1394F, -7.01F, -2.7489F, 1.6144F, -3.0107F));

		PartDefinition RightArm_r14 = knife2.addOrReplaceChild("RightArm_r14", CubeListBuilder.create().texOffs(22, 59).addBox(-0.8916F, 2.9872F, -10.0758F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -11.9346F, -2.9047F, 1.0472F, 0.0F, 0.0F));

		PartDefinition RightArm_r15 = knife2.addOrReplaceChild("RightArm_r15", CubeListBuilder.create().texOffs(22, 59).addBox(-0.8916F, 3.4489F, -3.8882F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -9.1146F, -1.5524F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm_r16 = knife2.addOrReplaceChild("RightArm_r16", CubeListBuilder.create().texOffs(22, 59).addBox(1.1084F, 4.0085F, 2.0981F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -9.5225F, -1.8123F, -0.5672F, 0.0F, 0.0F));

		PartDefinition RightArm_r17 = knife2.addOrReplaceChild("RightArm_r17", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 4.0981F, 0.0085F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 60).addBox(-0.8916F, 2.0981F, 1.0085F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -8.1267F, -1.7728F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RightArm_r18 = knife2.addOrReplaceChild("RightArm_r18", CubeListBuilder.create().texOffs(21, 60).addBox(1.1084F, 5.0981F, 2.0085F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.679F, -8.3489F, 0.0125F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RightArm_r19 = knife2.addOrReplaceChild("RightArm_r19", CubeListBuilder.create().texOffs(21, 60).addBox(0.1084F, 1.7785F, 2.4119F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -8.1267F, -1.7728F, -0.6981F, 0.0F, 0.0F));

		PartDefinition RightArm_r20 = knife2.addOrReplaceChild("RightArm_r20", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 2.1383F, 2.8734F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -8.1267F, -1.7728F, -0.48F, 0.0F, 0.0F));

		PartDefinition RightArm_r21 = knife2.addOrReplaceChild("RightArm_r21", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 2.0758F, -3.9872F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -8.083F, -2.7718F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RightArm_r22 = knife2.addOrReplaceChild("RightArm_r22", CubeListBuilder.create().texOffs(21, 60).addBox(-0.8916F, 1.4715F, -5.6297F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6951F, -6.303F, 2.3107F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, -0.2007F, 0.0F, 0.0349F));

		PartDefinition Rightll_r1 = RightLeg.addOrReplaceChild("Rightll_r1", CubeListBuilder.create().texOffs(17, 49).addBox(-3.9F, -14.0F, -4.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(45, 32).addBox(-3.4F, 0.0F, -3.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 4.494F, -0.0683F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.2618F, 0.0F, -0.0349F));

		PartDefinition Leftll_r1 = LeftLeg.addOrReplaceChild("Leftll_r1", CubeListBuilder.create().texOffs(44, 21).addBox(-3.1F, -4.0F, 1.5F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4764F, 9.2308F, 1.6216F, 0.829F, 0.0F, 0.0F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(42, 23).addBox(-2.0F, -5.5F, -1.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0236F, 3.5F, 0.5824F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 0.9F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.9F * limbSwingAmount;
		this.RightLeg.getChild("RightLeg_r1").yRot = headPitch * 0.017453292F;
		this.LeftArm.getChild("LeftArm_r2").yRot = headPitch * 0.017453292F;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;
		this.RightArm.getChild("knife").yRot = headPitch * 0.017453292F;
		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
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
	
	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}