package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.entity.EntityMycete;

// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.joy187.re8joymod.Main;
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

public class ModelMycete<T extends EntityMycete> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/mycete.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelMycete(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(19, 5).addBox(-5.9F, -3.5F, -2.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(14, 19).addBox(1.4F, -1.5F, -2.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 8.4562F, -3.4138F, -0.1484F, 0.0873F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(36, 27).addBox(-4.0F, 8.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition backArm_r1 = Body.addOrReplaceChild("backArm_r1", CubeListBuilder.create().texOffs(32, 48).mirror().addBox(-2.5F, -2.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.2085F, 17.1689F, 3.3347F, -2.0071F, -0.0873F, 0.3054F));

		PartDefinition backArm_r2 = Body.addOrReplaceChild("backArm_r2", CubeListBuilder.create().texOffs(32, 48).mirror().addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.7156F, 18.4391F, 6.5726F, -2.0071F, -0.1309F, -0.1745F));

		PartDefinition backArm_r3 = Body.addOrReplaceChild("backArm_r3", CubeListBuilder.create().texOffs(32, 48).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7156F, 16.4391F, 7.5726F, -2.0071F, 0.1309F, 0.1745F));

		PartDefinition backArm_r4 = Body.addOrReplaceChild("backArm_r4", CubeListBuilder.create().texOffs(32, 48).addBox(0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2085F, 15.1689F, 4.3347F, -2.0071F, 0.6545F, -0.3054F));

		PartDefinition tente = Body.addOrReplaceChild("tente", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 12.0398F, 2.7938F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Body_r1 = tente.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(1, 23).addBox(2.0074F, -2.0829F, -3.3812F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3674F, -5.6236F, 12.4718F, 0.4363F, 0.9599F, 0.0F));

		PartDefinition Body_r2 = tente.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 47).addBox(-0.5F, -3.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2058F, -5.0825F, 17.0114F, 0.2618F, -0.1745F, 0.0F));

		PartDefinition Body_r3 = tente.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 47).addBox(-0.3956F, -2.2676F, -0.93F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7583F, -6.3571F, 13.2763F, -0.7854F, -0.1745F, 0.0F));

		PartDefinition Body_r4 = tente.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(2, 36).addBox(-0.8956F, -1.9784F, 2.3429F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0969F, -3.7218F, 8.5642F, 0.4363F, -0.1745F, 0.0F));

		PartDefinition Body_r5 = tente.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(2, 28).addBox(-1.2542F, -1.9984F, -1.6999F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0969F, -3.7218F, 8.5642F, 0.4363F, 0.4363F, 0.0F));

		PartDefinition Body_r6 = tente.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(4, 28).addBox(-0.7542F, -3.0652F, -2.0984F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4376F, -6.6041F, 8.3333F, 1.0036F, 0.4363F, 0.0F));

		PartDefinition Body_r7 = tente.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(5, 39).addBox(-0.2542F, -1.1815F, 4.0936F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, 0.4363F, 0.0F));

		PartDefinition Body_r8 = tente.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(4, 46).addBox(-0.2542F, -2.7014F, 2.5202F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(5, 30).addBox(-2.2542F, -1.7014F, 2.5202F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(5, 30).addBox(-2.2542F, -1.7014F, -0.4798F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(5, 30).addBox(-0.2542F, -2.7014F, -0.4798F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.4363F, 0.0F));

		PartDefinition Body_r9 = tente.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(15, 44).addBox(0.7429F, -0.0943F, 0.5134F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1882F, -1.7279F, 5.5119F, 0.9163F, 0.4363F, -1.0472F));

		PartDefinition Body_r10 = tente.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(5, 30).addBox(-2.2542F, -1.8818F, 5.1277F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3452F, -1.2272F, 0.7403F, 0.0436F, 0.4363F, 0.0F));

		PartDefinition Body_r11 = tente.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(5, 30).mirror().addBox(-0.1048F, -2.0544F, 1.759F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7729F, 1.2374F, 2.4708F, 0.2618F, 0.48F, 0.0F));

		PartDefinition Body_r12 = tente.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(5, 30).mirror().addBox(0.2253F, -2.0374F, 0.8224F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 30).mirror().addBox(-0.7747F, -2.4374F, -2.1776F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7729F, 1.2374F, 2.4708F, 0.2618F, -0.0873F, 0.0F));

		PartDefinition tente3 = Body.addOrReplaceChild("tente3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 10.0398F, 2.7938F, 0.829F, 0.0F, 0.0F));

		PartDefinition Body_r13 = tente3.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(1, 20).addBox(-1.283F, 0.9929F, -0.4238F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1083F, -2.6982F, 5.7043F, 0.1309F, 0.4363F, 3.0107F));

		PartDefinition Body_r14 = tente3.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(1, 20).addBox(-1.1232F, -2.0989F, -2.1424F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4376F, -6.6041F, 8.3333F, 1.0036F, 0.4363F, 0.0F));

		PartDefinition Body_r15 = tente3.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(12, 56).addBox(-0.6232F, -0.2584F, 4.3828F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, 0.4363F, 0.0F));

		PartDefinition Body_r16 = tente3.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(3, 38).addBox(-0.6232F, -1.9593F, 3.1406F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-0.6232F, -1.9593F, 0.1406F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.4363F, 0.0F));

		PartDefinition tente4 = Body.addOrReplaceChild("tente4", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 10.0398F, 2.7938F, 0.829F, 0.0F, 0.0F));

		PartDefinition Body_r17 = tente4.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(14, 14).mirror().addBox(0.1232F, -2.0989F, -2.1424F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4376F, -6.6041F, 8.3333F, 1.0036F, -0.4363F, 0.0F));

		PartDefinition Body_r18 = tente4.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 48).mirror().addBox(-0.3768F, -0.2584F, 4.3828F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, -0.4363F, 0.0F));

		PartDefinition Body_r19 = tente4.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(15, 57).mirror().addBox(-1.3768F, -1.9593F, 3.1406F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 41).mirror().addBox(-1.3768F, -1.9593F, 0.1406F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.4363F, 0.0F));

		PartDefinition tente2 = Body.addOrReplaceChild("tente2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 12.0398F, 3.7938F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Body_r20 = tente2.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(11, 42).mirror().addBox(-3.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.3674F, -5.6236F, 12.4718F, 0.4363F, -0.9599F, 0.0F));

		PartDefinition Body_r21 = tente2.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(6, 36).mirror().addBox(-0.5899F, -1.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7583F, -6.3571F, 13.2763F, -0.7854F, 0.1745F, 0.0F));

		PartDefinition Body_r22 = tente2.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(8, 48).mirror().addBox(-0.0899F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0969F, -3.7218F, 8.5642F, 0.4363F, 0.1745F, 0.0F));

		PartDefinition Body_r23 = tente2.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(3, 47).mirror().addBox(0.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0969F, -3.7218F, 8.5642F, 0.4363F, -0.4363F, 0.0F));

		PartDefinition Body_r24 = tente2.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(3, 49).mirror().addBox(-1.7812F, -2.7446F, 2.4532F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(9, 40).mirror().addBox(-1.7812F, -2.7446F, -0.5468F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.4363F, 0.0F));

		PartDefinition tente5 = Body.addOrReplaceChild("tente5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 16.0398F, 3.7938F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Body_r25 = tente5.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(11, 39).mirror().addBox(-3.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.3674F, -5.6236F, 12.4718F, 0.4363F, -0.9599F, 0.0F));

		PartDefinition Body_r26 = tente5.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(5, 49).mirror().addBox(-0.5899F, -0.2265F, 1.9944F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7583F, -6.3571F, 13.2763F, 0.7418F, 0.1745F, 0.0F));

		PartDefinition Body_r27 = tente5.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(5, 49).mirror().addBox(-0.5899F, -2.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7583F, -6.3571F, 13.2763F, -0.7854F, 0.1745F, 0.0F));

		PartDefinition Body_r28 = tente5.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(5, 47).mirror().addBox(-0.0899F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0969F, -3.7218F, 8.5642F, 0.4363F, 0.1745F, 0.0F));

		PartDefinition Body_r29 = tente5.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(0.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0969F, -3.7218F, 8.5642F, 0.4363F, -0.4363F, 0.0F));

		PartDefinition Body_r30 = tente5.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(2, 47).mirror().addBox(-1.7812F, -2.7446F, 2.4532F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(4, 49).mirror().addBox(-1.7812F, -2.7446F, -0.5468F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.4363F, 0.0F));

		PartDefinition tente6 = Body.addOrReplaceChild("tente6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 16.0398F, 3.7938F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Body_r31 = tente6.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(11, 39).addBox(2.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3674F, -5.6236F, 12.4718F, 0.4363F, 0.9599F, 0.0F));

		PartDefinition Body_r32 = tente6.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(5, 49).addBox(-0.4101F, -0.1762F, -4.3801F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8198F, -7.3791F, 18.5988F, 0.3491F, -0.1745F, 0.0F));

		PartDefinition Body_r33 = tente6.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(5, 49).addBox(-0.4101F, -0.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7583F, -6.3571F, 13.2763F, -0.7854F, -0.1745F, 0.0F));

		PartDefinition Body_r34 = tente6.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(5, 47).addBox(-0.9101F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0969F, -3.7218F, 8.5642F, 0.4363F, -0.1745F, 0.0F));

		PartDefinition Body_r35 = tente6.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0408F, -2.1498F, -2.9669F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4431F, -3.7218F, 8.3078F, 0.4363F, -1.0908F, 0.0F));

		PartDefinition Body_r36 = tente6.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(0, 44).addBox(-2.3443F, -2.0422F, -4.7361F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8312F, -3.7218F, 9.6207F, 0.4363F, -0.3054F, 0.0F));

		PartDefinition Body_r37 = tente6.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(0, 44).addBox(-1.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0969F, -3.7218F, 8.5642F, 0.4363F, 0.4363F, 0.0F));

		PartDefinition Body_r38 = tente6.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(2, 47).addBox(-0.2188F, -2.7446F, 2.4532F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(4, 49).addBox(-0.2188F, -2.7446F, -0.5468F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.4363F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -3.5746F, -2.6868F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 16).addBox(-11.0F, -3.5746F, -2.6868F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 15.5596F, 0.4104F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(40, 16).addBox(0.0F, 3.9924F, -1.349F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, -1.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, 3.9951F, -2.2792F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftfront = LeftArm.addOrReplaceChild("leftfront", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 4.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.3665F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(25, 48).mirror().addBox(-0.9698F, -0.2888F, 1.6081F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(25, 43).mirror().addBox(-0.9F, -3.5F, 1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.951F, 6.2735F, -11.3701F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(25, 49).addBox(-0.5698F, -1.2888F, 0.6081F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.151F, 9.6123F, -11.0794F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(27, 45).addBox(-0.5698F, -5.2888F, 0.6081F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.151F, 8.2735F, -11.3701F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightLeg_r4 = RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(28, 42).addBox(-2.0698F, -3.622F, -2.9951F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.349F, 9.2537F, -4.9494F, -1.8762F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.0873F, 0.0F, -0.0349F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(23, 41).addBox(0.0F, -3.5F, -1.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.349F, 8.0219F, -1.6401F, -1.1781F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = netHeadYaw * 0.009453292F;
		this.Body.getChild("tente5").xRot = netHeadYaw * 0.009453292F;
		this.Body.getChild("tente6").xRot = netHeadYaw * 0.009453292F;
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
	
	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
	}
}