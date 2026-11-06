package com.joy187.re8joymod.entity.model;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMMycete;
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
// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelMMycete<T extends EntityMMycete> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/mycete.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelMMycete(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(74, 19).addBox(-17.2737F, -17.1231F, -20.5922F, 32.0F, 32.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(11.0263F, -16.1231F, -18.5922F, 4.0F, 8.0F, 12.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(-7.1F, -44.5438F, 19.5862F, -0.1484F, 0.0873F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(145, 108).addBox(-24.0F, -43.0F, 14.0F, 32.0F, 48.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition backArm_r1 = Body.addOrReplaceChild("backArm_r1", CubeListBuilder.create().texOffs(44, 56).mirror().addBox(2.5F, -21.5F, -6.5F, 4.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.3494F, -20.8085F, 29.2998F, -2.0071F, -0.0873F, 0.3054F));

		PartDefinition backArm_r2 = Body.addOrReplaceChild("backArm_r2", CubeListBuilder.create().texOffs(32, 48).mirror().addBox(-3.5F, -13.5F, -0.5F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.4728F, -14.7772F, 53.986F, -2.0071F, -0.1309F, -0.1745F));

		PartDefinition backArm_r3 = Body.addOrReplaceChild("backArm_r3", CubeListBuilder.create().texOffs(32, 48).addBox(-3.5F, -13.5F, -0.5F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.4775F, -19.1616F, 50.8027F, -2.0071F, 0.1309F, 0.1745F));

		PartDefinition backArm_r4 = Body.addOrReplaceChild("backArm_r4", CubeListBuilder.create().texOffs(32, 48).addBox(-11.5F, -17.5F, -7.5F, 4.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5118F, -21.1369F, 28.249F, -2.0071F, 0.3927F, -0.1745F));

		PartDefinition tente5 = Body.addOrReplaceChild("tente5", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 16.0398F, 3.7938F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Body_r1 = tente5.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(9, 134).mirror().addBox(-35.437F, 19.8905F, -107.3705F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.3509F, -151.2761F, 98.4882F, 1.2654F, -0.9599F, 0.0F));

		PartDefinition Body_r2 = tente5.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(74, 235).mirror().addBox(-54.513F, -81.6613F, -73.1003F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.9092F, -136.1811F, 128.4685F, 2.0944F, -0.9599F, 0.0F));

		PartDefinition Body_r3 = tente5.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(29, 211).mirror().addBox(22.6481F, 63.3864F, -70.2138F, 4.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-38.5173F, -129.5204F, 92.5093F, 0.7418F, 0.6981F, 0.0F));

		PartDefinition Body_r4 = tente5.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(2, 76).mirror().addBox(-3.5017F, 80.2055F, 40.5765F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.2368F, -135.4803F, 101.6637F, -0.7854F, 0.1745F, 0.0F));

		PartDefinition Body_r5 = tente5.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(17, 203).mirror().addBox(-0.0017F, 62.0144F, -64.4094F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-29.2177F, -123.0467F, 110.3229F, 0.4363F, 0.1745F, 0.0F));

		PartDefinition Body_r6 = tente5.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(0, 114).mirror().addBox(-20.0321F, 61.3514F, -74.5422F, 4.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-31.3269F, -124.7372F, 115.3523F, 0.4363F, -0.4363F, 0.0F));

		PartDefinition Body_r7 = tente5.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(0, 189).mirror().addBox(-25.0321F, 69.1157F, -56.7091F, 8.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.3773F, -113.2801F, 92.9792F, 0.2618F, -0.4363F, 0.0F));

		PartDefinition Body_r8 = tente5.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-11.0321F, 52.1157F, -52.7091F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-23.3936F, -92.7182F, 77.0434F, 0.2618F, -0.4363F, 0.0F));

		PartDefinition tente = Body.addOrReplaceChild("tente", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.9533F, -55.3471F, 22.0183F, 0.2182F, 0.5236F, 0.0F));

		PartDefinition Body_r9 = tente.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(3, 94).addBox(4.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8501F, -69.0471F, 48.4201F, 0.2618F, 0.1745F, 0.0F));

		PartDefinition Body_r10 = tente.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(3, 94).addBox(-0.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3236F, -1.9884F, 45.4055F, 0.8727F, 0.1745F, 0.0F));

		PartDefinition Body_r11 = tente.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(3, 94).addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3236F, -1.9884F, 45.4055F, 0.0873F, 0.1745F, 0.0F));

		PartDefinition Body_r12 = tente.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(3, 94).addBox(-3.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(3, 94).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9111F, 8.8107F, 29.8528F, 1.0036F, 0.1745F, 0.0F));

		PartDefinition Body_r13 = tente.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(3, 94).addBox(4.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9152F, -62.7973F, 47.9635F, 0.6981F, 0.1745F, 0.0F));

		PartDefinition tente2 = Body.addOrReplaceChild("tente2", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0467F, -55.3471F, 22.0183F, 0.2182F, -0.5236F, 0.0F));

		PartDefinition Body_r14 = tente2.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-11.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.8501F, -69.0471F, 48.4201F, 0.2618F, -0.1745F, 0.0F));

		PartDefinition Body_r15 = tente2.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3236F, -1.9884F, 45.4055F, 0.8727F, -0.1745F, 0.0F));

		PartDefinition Body_r16 = tente2.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3236F, -1.9884F, 45.4055F, 0.0873F, -0.1745F, 0.0F));

		PartDefinition Body_r17 = tente2.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 94).mirror().addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9111F, 8.8107F, 29.8528F, 1.0036F, -0.1745F, 0.0F));

		PartDefinition Body_r18 = tente2.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-10.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9152F, -62.7973F, 47.9635F, 0.6981F, -0.1745F, 0.0F));

		PartDefinition tente4 = Body.addOrReplaceChild("tente4", CubeListBuilder.create(), PartPose.offset(-20.9156F, -41.6637F, 24.7039F));

		PartDefinition Body_r19 = tente4.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(3, 94).addBox(-1.0F, -17.0F, 12.0F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(3, 94).addBox(-2.0F, -1.0F, 6.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8121F, -15.6759F, 15.4043F, -0.3455F, -1.4321F, 1.3814F));

		PartDefinition Body_r20 = tente4.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(3, 94).addBox(-2.0F, -3.0F, -7.0F, 5.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8121F, -15.6759F, 15.4043F, -0.3455F, -1.6939F, 1.3814F));

		PartDefinition Body_r21 = tente4.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(3, 94).addBox(1.0F, -17.0F, 9.0F, 6.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.3455F, -1.083F, 1.3814F));

		PartDefinition tente7 = Body.addOrReplaceChild("tente7", CubeListBuilder.create(), PartPose.offset(3.9156F, -41.6637F, 24.7039F));

		PartDefinition Body_r22 = tente7.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(88, 237).mirror().addBox(-2.0F, -16.0F, 15.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.8682F, -24.938F, 16.2358F, -1.1745F, 1.4321F, -1.3814F));

		PartDefinition Body_r23 = tente7.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.0F, -17.0F, 12.0F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 94).mirror().addBox(-2.0F, -1.0F, 6.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8121F, -15.6759F, 15.4043F, -0.3455F, 1.4321F, -1.3814F));

		PartDefinition Body_r24 = tente7.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-3.0F, -3.0F, -7.0F, 5.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.8121F, -15.6759F, 15.4043F, -0.3455F, 1.6939F, -1.3814F));

		PartDefinition Body_r25 = tente7.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-9.0F, -17.0F, 9.0F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.3455F, 1.083F, -1.3814F));

		PartDefinition tente3 = Body.addOrReplaceChild("tente3", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.9194F, -56.6247F, 38.5457F, 0.5236F, 0.0873F, 0.0F));

		PartDefinition Body_r26 = tente3.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-11.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.7228F, -70.7694F, 24.8928F, 0.2618F, -0.1745F, 0.0F));

		PartDefinition Body_r27 = tente3.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(0.5F, -11.5F, -1.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.3328F, 3.7858F, 30.2164F, 1.0908F, -0.9599F, 0.0F));

		PartDefinition Body_r28 = tente3.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-5.5F, 0.5F, -1.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4509F, -3.7107F, 21.8782F, -0.2618F, -0.9599F, 0.0F));

		PartDefinition Body_r29 = tente3.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4509F, -3.7107F, 21.8782F, 0.8727F, -0.1745F, 0.0F));

		PartDefinition Body_r30 = tente3.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4509F, -3.7107F, 21.8782F, 0.0873F, -0.1745F, 0.0F));

		PartDefinition Body_r31 = tente3.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-2.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 94).mirror().addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7838F, 7.0883F, 6.3255F, 1.0036F, -0.1745F, 0.0F));

		PartDefinition Body_r32 = tente3.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(3, 94).addBox(-4.0F, 0.0F, 8.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0568F, 26.3494F, -12.9326F, -0.2545F, -0.5227F, 1.1555F));

		PartDefinition Body_r33 = tente3.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-1.0F, 0.0F, 9.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(17.8956F, 26.3494F, -8.9326F, -1.0472F, 0.9163F, -1.6144F));

		PartDefinition Body_r34 = tente3.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(3, 94).addBox(-5.0F, -1.0F, -3.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9962F, 24.961F, -13.8418F, -0.3455F, -0.2976F, 1.3814F));

		PartDefinition Body_r35 = tente3.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-1.0F, -1.0F, -3.0F, 6.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(17.835F, 24.961F, -9.8418F, -1.0472F, 0.6109F, -1.6144F));

		PartDefinition Body_r36 = tente3.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(3, 94).mirror().addBox(-10.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.7878F, -64.5196F, 24.4362F, 0.6981F, -0.1745F, 0.0F));

		PartDefinition tente6 = Body.addOrReplaceChild("tente6", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0F, 16.0398F, 3.7938F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Body_r37 = tente6.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(9, 134).addBox(31.437F, 19.8905F, -107.3705F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3509F, -151.2761F, 98.4882F, 1.2654F, 0.9599F, 0.0F));

		PartDefinition Body_r38 = tente6.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(74, 235).addBox(50.513F, -81.6613F, -73.1003F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.9092F, -136.1811F, 128.4685F, 2.0944F, 0.9599F, 0.0F));

		PartDefinition Body_r39 = tente6.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(29, 211).addBox(-26.6481F, 63.3864F, -70.2138F, 4.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.5173F, -129.5204F, 92.5093F, 0.7418F, -0.6981F, 0.0F));

		PartDefinition Body_r40 = tente6.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(2, 76).addBox(-0.4983F, 80.2055F, 40.5765F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.2368F, -135.4803F, 101.6637F, -0.7854F, -0.1745F, 0.0F));

		PartDefinition Body_r41 = tente6.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(17, 203).addBox(-3.9983F, 62.0144F, -64.4094F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.2177F, -123.0467F, 110.3229F, 0.4363F, -0.1745F, 0.0F));

		PartDefinition Body_r42 = tente6.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(0, 114).addBox(16.0321F, 61.3514F, -74.5422F, 4.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.3269F, -124.7372F, 115.3523F, 0.4363F, 0.4363F, 0.0F));

		PartDefinition Body_r43 = tente6.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(0, 189).addBox(17.0321F, 69.1157F, -56.7091F, 8.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.3773F, -113.2801F, 92.9792F, 0.2618F, 0.4363F, 0.0F));

		PartDefinition Body_r44 = tente6.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(3, 94).addBox(3.0321F, 52.1157F, -52.7091F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.3936F, -92.7182F, 77.0434F, 0.2618F, 0.4363F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-7.0F, 47.575F, 71.3688F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(20.0F, -119.3072F, 2.5061F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(40, 16).addBox(-7.0F, 47.575F, 71.3688F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -120.4768F, 3.4727F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightArm_r3 = RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(40, 16).addBox(-6.0F, 86.2012F, -17.6084F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -135.5822F, 8.412F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, -1.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(-8.0F, 86.377F, -34.6896F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -118.5957F, 75.9846F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftfront = LeftArm.addOrReplaceChild("leftfront", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.3665F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(25, 48).mirror().addBox(-6.5478F, 91.5942F, 31.0367F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.2375F, -79.4103F, 39.6097F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(25, 49).addBox(-3.1496F, 4.7077F, -105.6159F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.1812F, -78.9176F, 50.1004F, 0.9599F, 0.0F, 0.0F));

		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(25, 43).mirror().addBox(-6.478F, 79.383F, -6.0715F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.1677F, -54.611F, 67.473F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightLeg_r4 = RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(27, 45).addBox(-3.1496F, 98.2193F, 1.1519F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.1812F, -82.6089F, 67.963F, -0.6981F, 0.0F, 0.0F));

		PartDefinition RightLeg_r5 = RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(28, 42).addBox(-3.1496F, 20.1121F, 85.6364F, 12.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.1812F, -82.6089F, 67.963F, -1.7453F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.0873F, 0.0F, -0.0349F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(23, 41).addBox(-11.4183F, 26.1792F, 77.4962F, 11.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7607F, -98.7314F, 22.4149F, -1.1781F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = netHeadYaw * 0.009453292F;
		this.Body.getChild("tente4").xRot = netHeadYaw * 0.009453292F;
		this.Body.getChild("tente7").xRot = netHeadYaw * 0.009453292F;

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