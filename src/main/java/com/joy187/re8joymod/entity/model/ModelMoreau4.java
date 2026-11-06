package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau4;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
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
// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelMoreau4<T extends EntityMoreau4> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/moreau4.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart vicer;
	private final ModelPart LeftLeg;
	private final ModelPart otherp;

	public ModelMoreau4(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.vicer = root.getChild("vicer");
		this.LeftLeg = root.getChild("LeftLeg");
		this.otherp = root.getChild("otherp");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 20.0F, 3.0F, -0.1047F, 0.0873F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-4.9558F, -20.8069F, 2.0515F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -0.7511F, -10.0347F, 0.1309F, 0.0F, 0.1309F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -20.8586F, -7.5095F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 30).addBox(-14.9F, 14.4108F, 25.9051F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-6.0F, -14.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-2.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-10.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(6, 36).addBox(-10.0F, -10.0F, 3.0F, 20.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-6.0F, 2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).addBox(-16.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).mirror().addBox(10.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 12).addBox(-0.2324F, -7.8915F, -8.0016F, 3.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6973F, -1.8708F, -9.1161F, 0.2179F, 0.8112F, -1.5166F));

		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(18, 12).addBox(-0.2324F, -7.8915F, -8.0016F, 3.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6973F, 2.1292F, -11.1161F, 0.2014F, 0.5497F, -0.3925F));

		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(18, 23).addBox(-2.3059F, 0.8552F, -5.8216F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.5304F, 0.1496F, -1.3718F));

		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(18, 23).addBox(-5.4811F, 1.1962F, -5.231F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.5185F, -0.0935F, -0.9568F));

		PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(18, 23).addBox(-1.7271F, 2.2292F, -5.3925F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2095F, 11.64F, -6.9824F, 0.011F, -0.8286F, 0.3867F));

		PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(18, 23).addBox(-5.3743F, 0.2401F, -6.4819F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2095F, 11.64F, -6.9824F, -0.3567F, -0.5318F, 1.346F));

		PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(18, 23).addBox(-2.2777F, -3.7855F, -7.4234F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6973F, -1.8708F, -9.1161F, 0.6904F, 0.0734F, 0.2976F));

		PartDefinition Body_r8 = Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(18, 23).addBox(-2.2777F, -3.7855F, -7.4234F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6973F, 2.1292F, -11.1161F, 0.4376F, 0.147F, 1.4041F));

		PartDefinition Body_r9 = Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(16, 22).addBox(-2.0229F, 0.2156F, -6.6246F, 8.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0955F, 1.0612F, -8.7486F, -0.6734F, 0.1526F, 1.5146F));

		PartDefinition Body_r10 = Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(18, 23).addBox(-5.9255F, 0.7501F, -3.5141F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0955F, 1.0612F, -8.7486F, -0.461F, -0.2717F, 2.2846F));

		PartDefinition Body_r11 = Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.2141F, 5.8971F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Body_r12 = Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(42, 54).addBox(-3.0F, -5.0F, -17.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 41).addBox(-6.0F, -7.0F, -9.5F, 12.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 5.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Body_r13 = Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(12, 29).mirror().addBox(-1.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -6.0F, 10.5F, 0.0F, 0.1745F, -0.48F));

		PartDefinition Body_r14 = Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(12, 29).addBox(-2.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.0F, 10.5F, 0.0F, -0.1745F, 0.48F));

		PartDefinition Body_r15 = Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.3807F, 13.7163F, 9.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Body_r16 = Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 29).addBox(-5.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3807F, 13.7163F, 9.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Body_r17 = Body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-3.0F, -6.0F, -11.0F, 6.0F, 15.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 32).mirror().addBox(-3.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0897F, 15.2773F, 9.0F, 0.0F, 0.0F, 1.3963F));

		PartDefinition Body_r18 = Body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(0, 29).addBox(8.0F, -5.0F, -2.0F, 7.0F, 10.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(4.0F, -3.0F, 23.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(4.0F, -5.0F, 7.0F, 4.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2121F, 21.993F, 55.785F, 0.0F, -0.0436F, -1.6144F));

		PartDefinition chin3_r1 = Body.addOrReplaceChild("chin3_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0172F, 7.5832F, 103.8805F, -0.0873F, 0.6981F, -2.2689F));

		PartDefinition chin2_r1 = Body.addOrReplaceChild("chin2_r1", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0172F, 7.5832F, 103.8805F, 0.48F, 0.6981F, -2.2689F));

		PartDefinition chin1_r1 = Body.addOrReplaceChild("chin1_r1", CubeListBuilder.create().texOffs(16, 17).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8773F, 12.7897F, 99.7652F, -0.48F, 0.6981F, -2.2689F));

		PartDefinition Body_r19 = Body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8773F, 12.7897F, 99.7652F, 0.0F, 0.6981F, -2.2689F));

		PartDefinition Body_r20 = Body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(0, 29).addBox(1.0F, -5.0F, -6.0F, 6.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2121F, 21.993F, 55.785F, 0.0F, 0.2182F, -1.6144F));

		PartDefinition Body_r21 = Body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.989F, 16.8828F, 44.0F, 0.0F, -0.2618F, -1.6144F));

		PartDefinition Body_r22 = Body.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0897F, 15.2773F, 9.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition Body_r23 = Body.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(7, 22).mirror().addBox(-7.0F, -4.5F, 9.0F, 6.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 22).mirror().addBox(-5.0F, -4.5F, -7.0F, 8.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2275F, 4.0987F, 62.3715F, 0.0436F, -0.3054F, -1.6144F));

		PartDefinition Body_r24 = Body.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(11, 56).mirror().addBox(-0.5F, -0.5F, 24.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(11, 56).mirror().addBox(7.5F, -0.5F, 22.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 47).mirror().addBox(1.5F, -0.5F, 13.0F, 6.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 22).mirror().addBox(-5.5F, -5.5F, 11.0F, 6.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 30).mirror().addBox(-3.5F, -6.5F, -10.0F, 5.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5989F, -12.2009F, 25.6123F, 0.0436F, -0.3054F, -1.789F));

		PartDefinition Body_r25 = Body.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(12, 35).mirror().addBox(-3.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.089F, -9.2031F, 25.7953F, 0.2182F, -0.3491F, -0.9599F));

		PartDefinition Body_r26 = Body.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(12, 35).addBox(0.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.089F, -9.2031F, 25.7953F, 0.2182F, 0.3491F, 0.9599F));

		PartDefinition Body_r27 = Body.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(12, 35).mirror().addBox(-7.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.8543F, 5.3439F, 26.3663F, -0.2618F, -0.2618F, 0.0F));

		PartDefinition Body_r28 = Body.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(12, 35).addBox(1.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.8543F, 5.3439F, 26.3663F, -0.2618F, 0.2618F, 0.0F));

		PartDefinition Body_r29 = Body.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(12, 35).mirror().addBox(-5.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 7.5F, 31.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Body_r30 = Body.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(10, 32).mirror().addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.2337F, 3.3197F, 50.3251F, -0.0436F, -0.2618F, 0.0F));

		PartDefinition Body_r31 = Body.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(10, 32).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2337F, 3.3197F, 50.3251F, -0.0436F, 0.2618F, 0.0F));

		PartDefinition Body_r32 = Body.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(12, 35).mirror().addBox(-6.0F, -6.5F, 7.0F, 7.0F, 9.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 7.5F, 31.0F, -0.3491F, -0.2618F, 0.0F));

		PartDefinition Body_r33 = Body.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(12, 35).addBox(-1.0F, -6.5F, 7.0F, 7.0F, 9.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 7.5F, 31.0F, -0.3491F, 0.2618F, 0.0F));

		PartDefinition Body_r34 = Body.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(12, 35).addBox(-1.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 7.5F, 31.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Body_r35 = Body.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -1.5F, -11.5F, 13.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6711F, -13.1278F, 6.5F, 0.2182F, 0.0F, 0.3927F));

		PartDefinition Body_r36 = Body.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -2.5F, -11.5F, 13.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -14.5F, 6.5F, 0.2182F, 0.0F, -0.3927F));

		PartDefinition Body_r37 = Body.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(0, 57).addBox(-2.1075F, 3.2583F, 4.3703F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(-2.1075F, 3.2583F, -0.6297F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6973F, 2.1292F, -11.1161F, 0.1745F, 0.3491F, -0.3491F));

		PartDefinition Body_r38 = Body.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(0, 58).addBox(-4.9962F, -1.3778F, 3.7196F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.8665F, 0.0259F, -0.988F));

		PartDefinition Body_r39 = Body.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(0, 58).addBox(3.0906F, -0.3443F, -3.4187F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(3.0906F, -1.3443F, 2.5813F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.9183F, 0.2392F, -1.3728F));

		PartDefinition Body_r40 = Body.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(0, 58).addBox(3.3937F, 1.757F, 3.3439F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(3.3937F, 2.757F, -0.6561F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(0.3937F, 2.757F, -5.6561F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(-4.6063F, -1.243F, -5.6561F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2095F, 11.64F, -6.9824F, 0.1745F, -0.9599F, 0.0F));

		PartDefinition Body_r41 = Body.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(0, 59).addBox(-4.6737F, -4.3266F, 1.9111F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-4.6737F, -2.3266F, -4.0889F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2095F, 11.64F, -6.9824F, -0.5172F, -0.7533F, 0.8239F));

		PartDefinition Body_r42 = Body.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(0, 59).addBox(-5.6891F, -3.3731F, 0.4253F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-1.6891F, -4.3731F, 5.4253F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(6.3109F, 1.6269F, -1.5747F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(2.3109F, -0.3731F, -3.5747F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-1.6891F, -2.3731F, -6.5747F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0955F, 1.0612F, -8.7486F, -0.6169F, -0.8939F, 1.8919F));

		PartDefinition Body_r43 = Body.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(0, 59).addBox(-6.1773F, -1.9933F, -1.4206F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0955F, 1.0612F, -8.7486F, -1.2415F, -1.1029F, 2.6216F));

		PartDefinition Body_r44 = Body.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(0, 58).addBox(-0.7229F, 0.8209F, -4.1531F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.8679F, 0.0479F, -1.0257F));

		PartDefinition Body_r45 = Body.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(0, 58).addBox(-4.3375F, 0.866F, -0.8976F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5959F, 12.0421F, -8.2868F, -0.8985F, -0.1912F, -0.6074F));

		PartDefinition Body_r46 = Body.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(0, 58).addBox(-2.1075F, -6.5001F, -6.0001F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6973F, 2.1292F, -11.1161F, 0.5236F, 0.3491F, -0.3491F));

		PartDefinition Body_r47 = Body.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(0, 58).addBox(-3.6973F, -5.5801F, 4.8613F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6973F, 2.1292F, -11.1161F, 0.5236F, 0.7418F, -0.3491F));

		PartDefinition RightLeg_r1 = Body.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(17, 30).addBox(-3.0F, 0.5F, -0.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9F, 15.1551F, 25.396F, 0.2182F, 0.4363F, 0.0F));

		PartDefinition RightLeg_r2 = Body.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(19, 31).addBox(-2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9F, 14.9108F, 22.9051F, 0.0F, 0.1745F, 0.0F));

		PartDefinition RightLeg_r3 = Body.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(18, 30).addBox(-4.0F, 2.5F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.9F, 12.2285F, 38.6185F, -1.3963F, 0.0F, 0.0F));

		PartDefinition RightLeg_r4 = Body.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(17, 29).addBox(4.0F, -0.5F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9F, 14.9108F, 22.9051F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LeftLeg_r1 = Body.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.9F, 10.5794F, 32.4782F, 0.48F, 0.0F, 0.0F));

		PartDefinition eye_r1 = Body.addOrReplaceChild("eye_r1", CubeListBuilder.create().texOffs(42, 0).addBox(-7.5F, -2.0F, 6.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(42, 0).addBox(-4.5F, -2.0F, 12.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.75F, -17.0753F, 5.9689F, -0.0873F, 0.0F, 0.5236F));

		PartDefinition eye_r2 = Body.addOrReplaceChild("eye_r2", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(2.5F, 0.0F, 12.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(42, 0).mirror().addBox(2.5F, -2.0F, 6.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.75F, -17.0753F, 5.9689F, -0.0873F, 0.0F, -0.5236F));

		PartDefinition eye_r3 = Body.addOrReplaceChild("eye_r3", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(-2.5F, 0.0F, 4.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.75F, -17.0753F, 5.9689F, -0.0873F, 0.0F, -1.0472F));

		PartDefinition eye_r4 = Body.addOrReplaceChild("eye_r4", CubeListBuilder.create().texOffs(42, 0).addBox(-2.5F, 0.0F, 4.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.75F, -17.0753F, 5.9689F, -0.0873F, 0.0F, 1.0472F));

		PartDefinition eye_r5 = Body.addOrReplaceChild("eye_r5", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(3.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.3531F, -12.8047F, 4.7609F, 0.2618F, 0.0F, -1.0472F));

		PartDefinition eye_r6 = Body.addOrReplaceChild("eye_r6", CubeListBuilder.create().texOffs(44, 0).addBox(-7.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3531F, -12.8047F, 4.7609F, 0.2618F, 0.0F, 1.0472F));

		PartDefinition eye_r7 = Body.addOrReplaceChild("eye_r7", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5939F, -9.9381F, 23.5951F, -0.0873F, 1.5272F, 1.0908F));

		PartDefinition eye_r8 = Body.addOrReplaceChild("eye_r8", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.5939F, -9.9381F, 23.5951F, -0.0873F, -1.5272F, -1.0908F));

		PartDefinition eye_r9 = Body.addOrReplaceChild("eye_r9", CubeListBuilder.create().texOffs(44, 0).addBox(-16.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-22.0F, 4.0F, -13.3F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-17.0F, -1.0F, -7.3F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-13.0F, -2.0F, -7.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-7.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3531F, -12.8047F, 4.7609F, 0.2618F, 1.7453F, 1.0472F));

		PartDefinition eye_r10 = Body.addOrReplaceChild("eye_r10", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(12.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(13.0F, -1.0F, -7.3F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.3531F, -12.8047F, 4.7609F, 0.2618F, -1.7453F, -1.0472F));

		PartDefinition eye_r11 = Body.addOrReplaceChild("eye_r11", CubeListBuilder.create().texOffs(44, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9719F, -13.4681F, 25.4689F, 0.2618F, 1.0036F, 1.0472F));

		PartDefinition eye_r12 = Body.addOrReplaceChild("eye_r12", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.9719F, -13.4681F, 25.4689F, 0.2618F, -1.0036F, -1.0472F));

		PartDefinition eye_r13 = Body.addOrReplaceChild("eye_r13", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.045F, -16.4999F, 24.7841F, 1.4835F, -2.3998F, -1.0472F));

		PartDefinition eye_r14 = Body.addOrReplaceChild("eye_r14", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-3.5F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-0.5F, -2.0F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9869F, -10.8612F, -3.5574F, 0.6981F, 0.0F, -1.0472F));

		PartDefinition eye_r15 = Body.addOrReplaceChild("eye_r15", CubeListBuilder.create().texOffs(44, 0).addBox(-0.5F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-3.5F, -2.0F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9869F, -10.8612F, -3.5574F, 0.6981F, 0.0F, 1.0472F));

		PartDefinition eye_r16 = Body.addOrReplaceChild("eye_r16", CubeListBuilder.create().texOffs(45, 1).mirror().addBox(3.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9869F, -10.8612F, -3.5574F, 0.7418F, 0.0F, -0.7418F));

		PartDefinition eye_r17 = Body.addOrReplaceChild("eye_r17", CubeListBuilder.create().texOffs(47, 1).mirror().addBox(2.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(47, 1).mirror().addBox(-1.0F, 2.5F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(47, 1).mirror().addBox(-1.0F, 2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.8537F, -8.1863F, 25.3424F, 0.5236F, -2.6616F, 0.7418F));

		PartDefinition eye_r18 = Body.addOrReplaceChild("eye_r18", CubeListBuilder.create().texOffs(47, 1).addBox(-4.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(47, 1).addBox(-1.0F, 2.5F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(47, 1).addBox(-1.0F, 2.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.8537F, -8.1863F, 25.3424F, 0.5236F, 2.6616F, -0.7418F));

		PartDefinition eye_r19 = Body.addOrReplaceChild("eye_r19", CubeListBuilder.create().texOffs(47, 1).mirror().addBox(-4.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.9745F, -12.4879F, 17.0983F, -0.4363F, -2.5307F, 1.4835F));

		PartDefinition eye_r20 = Body.addOrReplaceChild("eye_r20", CubeListBuilder.create().texOffs(47, 1).addBox(2.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9745F, -12.4879F, 17.0983F, -0.4363F, 2.5307F, -1.4835F));

		PartDefinition eye_r21 = Body.addOrReplaceChild("eye_r21", CubeListBuilder.create().texOffs(45, 1).mirror().addBox(1.5F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.123F, -8.1355F, 27.7045F, 0.9163F, -2.6616F, 0.7418F));

		PartDefinition eye_r22 = Body.addOrReplaceChild("eye_r22", CubeListBuilder.create().texOffs(45, 1).addBox(-4.5F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.123F, -8.1355F, 27.7045F, 0.9163F, 2.6616F, -0.7418F));

		PartDefinition eye_r23 = Body.addOrReplaceChild("eye_r23", CubeListBuilder.create().texOffs(45, 1).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0726F, -14.8863F, 14.6231F, 0.2618F, 2.6616F, -0.7418F));

		PartDefinition eye_r24 = Body.addOrReplaceChild("eye_r24", CubeListBuilder.create().texOffs(45, 1).addBox(-6.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9869F, -10.8612F, -3.5574F, 0.7418F, 0.0F, 0.7418F));

		PartDefinition eye_r25 = Body.addOrReplaceChild("eye_r25", CubeListBuilder.create().texOffs(41, 0).addBox(-5.5F, 6.0F, -8.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(41, 0).addBox(-2.5F, 6.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0335F, -24.7445F, 5.5359F, 0.5236F, 0.0F, 0.0436F));

		PartDefinition eye_r26 = Body.addOrReplaceChild("eye_r26", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(20.5F, 13.0F, -8.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-29.5F, -3.6519F, -1.5311F, 0.5236F, 0.0F, -1.0472F));

		PartDefinition eye_r27 = Body.addOrReplaceChild("eye_r27", CubeListBuilder.create().texOffs(42, 0).addBox(-25.5F, 13.0F, -8.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5F, -3.6519F, -1.5311F, 0.5236F, 0.0F, 1.0472F));

		PartDefinition hairr = Body.addOrReplaceChild("hairr", CubeListBuilder.create(), PartPose.offset(3.045F, -16.4999F, 24.7841F));

		PartDefinition hair_r1 = hairr.addOrReplaceChild("hair_r1", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(-0.5F, -3.5F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.8611F, -17.681F, 20.5035F, -0.7471F, -0.5466F, 1.0396F));

		PartDefinition hair_r2 = hairr.addOrReplaceChild("hair_r2", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(-0.5F, -12.5F, -0.5F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6347F, -17.2185F, 31.2371F, 1.4835F, -2.3998F, -1.5272F));

		PartDefinition hair_r3 = hairr.addOrReplaceChild("hair_r3", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1052F, -0.8438F, 1.2893F));

		PartDefinition hair_r4 = hairr.addOrReplaceChild("hair_r4", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5816F, -0.8438F, 1.2893F));

		PartDefinition hair_r5 = hairr.addOrReplaceChild("hair_r5", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.4835F, -2.3998F, -1.0472F));

		PartDefinition hairr2 = Body.addOrReplaceChild("hairr2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.955F, -16.4999F, 24.7841F, 0.0F, -0.2618F, 0.0F));

		PartDefinition hair_r6 = hairr2.addOrReplaceChild("hair_r6", CubeListBuilder.create().texOffs(1, 46).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6347F, -17.2185F, 31.2371F, 1.4835F, -2.3998F, -1.5272F));

		PartDefinition hair_r7 = hairr2.addOrReplaceChild("hair_r7", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.4835F, -2.3998F, -1.0472F));

		PartDefinition hairr3 = Body.addOrReplaceChild("hairr3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.955F, -16.4999F, 24.7841F, 0.0F, -0.6981F, 0.0F));

		PartDefinition hair_r8 = hairr3.addOrReplaceChild("hair_r8", CubeListBuilder.create().texOffs(4, 41).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.9247F, -11.5807F, 24.3213F, -1.9475F, -0.711F, 1.8074F));

		PartDefinition hair_r9 = hairr3.addOrReplaceChild("hair_r9", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, -1.8902F, -0.6185F, 2.2411F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.6068F, 9.1652F, -14.8153F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition bottle2_r1 = RightArm.addOrReplaceChild("bottle2_r1", CubeListBuilder.create().texOffs(32, 41).addBox(-21.141F, -12.8317F, -4.4352F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1068F, 19.6644F, 8.0039F, -0.1745F, 0.0F, 0.5672F));

		PartDefinition bottle3_r1 = RightArm.addOrReplaceChild("bottle3_r1", CubeListBuilder.create().texOffs(13, 25).addBox(-5.0F, -1.0F, -6.5F, 10.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6068F, -6.6614F, 0.8752F, 1.9199F, 2.5307F, 2.5744F));

		PartDefinition bottle2_r2 = RightArm.addOrReplaceChild("bottle2_r2", CubeListBuilder.create().texOffs(32, 42).addBox(-3.0642F, -3.1314F, -9.5661F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8765F, 0.9772F, 7.1106F, -1.0035F, -0.9377F, 0.0885F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, 14.5067F, -4.8661F, 0.2094F, 0.3927F, -0.48F));

		PartDefinition leftfront = LeftArm.addOrReplaceChild("leftfront", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 12.4933F, -1.1339F, -0.48F, 0.0F, 0.0F));

		PartDefinition bottle3_r2 = leftfront.addOrReplaceChild("bottle3_r2", CubeListBuilder.create().texOffs(32, 41).addBox(-11.8907F, -18.0872F, -9.3947F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.8296F, -2.8114F, -0.1745F, 0.0F, 0.5672F));

		PartDefinition bottle2_r3 = leftfront.addOrReplaceChild("bottle2_r3", CubeListBuilder.create().texOffs(32, 42).addBox(-1.0F, -13.8569F, -11.4712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 42).addBox(0.0F, -13.8569F, -10.4712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 42).addBox(0.0F, -13.8569F, -9.4712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 42).addBox(-1.0F, -13.8569F, -9.4712F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9487F, -0.0622F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(20, 28).addBox(-4.8953F, -5.2761F, -0.8752F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 30).addBox(-2.8953F, 6.1347F, -22.9701F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.9F, 9.0F, 13.0F, 0.3665F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r5 = RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(18, 30).addBox(3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.879F, -16.4792F, 0.2182F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r6 = RightLeg.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(17, 30).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.879F, -16.4792F, 0.2182F, 0.4363F, 0.0F));

		PartDefinition RightLeg_r7 = RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(17, 29).addBox(4.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.6347F, -18.9701F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightLeg_r8 = RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.6347F, -18.9701F, 0.0F, 0.1745F, 0.0F));

		PartDefinition RightLeg_r9 = RightLeg.addOrReplaceChild("RightLeg_r9", CubeListBuilder.create().texOffs(18, 30).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 22).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, 9.1672F, -5.9117F, -1.789F, 0.0F, 0.0F));

		PartDefinition RightLeg_r10 = RightLeg.addOrReplaceChild("RightLeg_r10", CubeListBuilder.create().texOffs(26, 29).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1047F, 10.5309F, 6.912F, -1.3963F, 0.0F, 0.0F));

		PartDefinition RightLeg_r11 = RightLeg.addOrReplaceChild("RightLeg_r11", CubeListBuilder.create().texOffs(23, 29).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1047F, 9.3278F, -1.3001F, 0.3491F, 0.0F, 0.0F));

		PartDefinition viceleft = RightLeg.addOrReplaceChild("viceleft", CubeListBuilder.create(), PartPose.offset(0.1047F, 1.7239F, -3.8752F));

		PartDefinition vicer = partdefinition.addOrReplaceChild("vicer", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(9.0F, 5.5253F, 22.6973F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.9F, 9.8855F, 0.2078F));

		PartDefinition RightLeg_r12 = vicer.addOrReplaceChild("RightLeg_r12", CubeListBuilder.create().texOffs(17, 29).mirror().addBox(-5.0F, -0.5F, -2.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 6.0253F, 22.6973F, 0.0F, 0.3491F, 0.0F));

		PartDefinition RightLeg_r13 = vicer.addOrReplaceChild("RightLeg_r13", CubeListBuilder.create().texOffs(17, 30).mirror().addBox(1.0F, 0.5F, -1.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 6.2696F, 25.1882F, 0.2182F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r14 = vicer.addOrReplaceChild("RightLeg_r14", CubeListBuilder.create().texOffs(19, 31).mirror().addBox(0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 6.0253F, 22.6973F, 0.0F, -0.1745F, 0.0F));

		PartDefinition RightLeg_r15 = vicer.addOrReplaceChild("RightLeg_r15", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(0.0F, 2.5F, -2.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 7.9527F, 36.8319F, -1.7017F, 0.0F, 0.0F));

		PartDefinition LeftLeg_r2 = vicer.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(0, 47).addBox(9.0F, 0.0F, 30.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(0.1359F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(19.45F, 8.457F, 12.5608F, 0.3054F, 0.0F, -0.0349F));

		PartDefinition RightLeg_r16 = LeftLeg.addOrReplaceChild("RightLeg_r16", CubeListBuilder.create().texOffs(17, 29).mirror().addBox(-6.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.032F, -20.3604F, 0.0F, 0.3491F, 0.0F));

		PartDefinition RightLeg_r17 = LeftLeg.addOrReplaceChild("RightLeg_r17", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(0.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.032F, -20.3604F, 0.0F, -0.1745F, 0.0F));

		PartDefinition RightLeg_r18 = LeftLeg.addOrReplaceChild("RightLeg_r18", CubeListBuilder.create().texOffs(17, 30).mirror().addBox(1.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.2763F, -17.8695F, 0.2182F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r19 = LeftLeg.addOrReplaceChild("RightLeg_r19", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(0.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 22).mirror().addBox(-1.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1359F, 9.5644F, -7.3021F, -1.789F, 0.0F, 0.0F));

		PartDefinition RightLeg_r20 = LeftLeg.addOrReplaceChild("RightLeg_r20", CubeListBuilder.create().texOffs(26, 29).mirror().addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8641F, 10.9282F, 5.5217F, -1.3963F, 0.0F, 0.0F));

		PartDefinition RightLeg_r21 = LeftLeg.addOrReplaceChild("RightLeg_r21", CubeListBuilder.create().texOffs(23, 29).mirror().addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 9.7251F, -2.6905F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightLeg_r22 = LeftLeg.addOrReplaceChild("RightLeg_r22", CubeListBuilder.create().texOffs(20, 28).mirror().addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 8.1212F, -5.2655F, -0.2182F, 0.0F, 0.0F));

		PartDefinition otherp = partdefinition.addOrReplaceChild("otherp", CubeListBuilder.create().texOffs(18, 44).mirror().addBox(32.8F, -11.0F, -10.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.9F, 12.0F, 10.0F));

		PartDefinition RightLeg_r23 = otherp.addOrReplaceChild("RightLeg_r23", CubeListBuilder.create().texOffs(20, 28).addBox(-1.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 28).addBox(1.0F, -3.5F, -7.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.5F, -5.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightLeg_r24 = otherp.addOrReplaceChild("RightLeg_r24", CubeListBuilder.create().texOffs(20, 28).addBox(-5.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.9959F, -5.9183F, -0.4363F, 0.0F, 0.0F));

		PartDefinition RightLeg_r25 = otherp.addOrReplaceChild("RightLeg_r25", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6946F, 11.6242F, -10.8151F, 0.3981F, 0.1611F, 0.0674F));

		PartDefinition RightLeg_r26 = otherp.addOrReplaceChild("RightLeg_r26", CubeListBuilder.create().texOffs(20, 28).addBox(2.0F, -3.5F, -8.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.7367F, -4.4389F, -0.5236F, 0.0F, 0.0F));

		PartDefinition RightLeg_r27 = otherp.addOrReplaceChild("RightLeg_r27", CubeListBuilder.create().texOffs(20, 36).mirror().addBox(-4.0F, -4.5F, -8.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(36.8F, 4.0808F, -5.211F, -0.9163F, 0.0F, 0.0F));

		PartDefinition RightLeg_r28 = otherp.addOrReplaceChild("RightLeg_r28", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(0.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(36.525F, 8.6385F, -9.0941F, 0.2657F, -0.1685F, -0.0456F));

		PartDefinition RightLeg_r29 = otherp.addOrReplaceChild("RightLeg_r29", CubeListBuilder.create().texOffs(20, 28).mirror().addBox(3.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(32.8F, -1.0041F, -4.9183F, -0.5672F, 0.0F, 0.0F));

		PartDefinition RightLeg_r30 = otherp.addOrReplaceChild("RightLeg_r30", CubeListBuilder.create().texOffs(20, 28).mirror().addBox(-4.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(36.8F, -6.5F, -4.5F, 0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.Body.getChild("hairr2").xRot = netHeadYaw * 0.007453292F;
		this.Body.getChild("eye_r2").zRot = netHeadYaw * 0.002453292F;
		this.Body.getChild("eye_r1").zRot = netHeadYaw * 0.002453292F;

//		this.hairr2.xRot = netHeadYaw * 0.007453292F;
//		this.eye_r2.zRot = netHeadYaw * 0.002453292F;
//		this.eye_r1.zRot = netHeadYaw * 0.002453292F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		vicer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		otherp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
	}
	
}