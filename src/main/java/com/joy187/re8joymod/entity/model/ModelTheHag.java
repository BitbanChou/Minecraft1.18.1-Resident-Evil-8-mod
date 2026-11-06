package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityTheHag;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;
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


public class ModelTheHag<T extends EntityTheHag> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/thehag.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelTheHag(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(4, 4).addBox(-3.5F, -2.637F, -2.4195F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(21, 26).addBox(-2.5F, -4.637F, -2.4195F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 14).addBox(-3.0F, -3.6535F, 0.8941F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.3465F, -2.8941F, -0.1047F, 0.0873F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(30, 25).mirror().addBox(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0232F, 0.947F, 0.0805F, 0.0F, 0.0F, -1.4835F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(32, 25).mirror().addBox(-2.0F, 0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.867F, -3.0939F, 0.0805F, 0.0F, 0.0F, -1.0908F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(19, 26).addBox(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0743F, 0.9001F, 0.0805F, 0.0F, 0.0F, 1.4835F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(19, 26).addBox(-2.0F, 0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9181F, -3.1408F, 0.0805F, 0.0F, 0.0F, 1.0908F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(15, 14).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 17).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 1.0F, 0.1309F, 0.0F, 0.3927F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(6, 47).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4163F, 6.9677F, -3.4797F, 1.3606F, 0.0522F, 0.3011F));

		PartDefinition RightArm_r2 = RightArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(22, 54).addBox(-0.5F, -2.5F, -3.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9238F, 3.9865F, -1.8165F, 2.1023F, 0.0522F, 0.3011F));

		PartDefinition RightArm_r3 = RightArm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(5, 45).addBox(-0.5F, -3.5F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.483F, 6.1036F, -0.0241F, -0.1666F, 0.0522F, 0.3011F));

		PartDefinition RightArm_r4 = RightArm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(0, 41).addBox(-0.2F, -3.0F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, 0.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition wand = RightArm.addOrReplaceChild("wand", CubeListBuilder.create(), PartPose.offset(-0.9238F, 3.9865F, -1.8165F));

		PartDefinition stick_r1 = wand.addOrReplaceChild("stick_r1", CubeListBuilder.create().texOffs(22, 54).addBox(-0.5F, 1.5F, -0.2583F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 49).addBox(-0.5F, -3.5F, -1.2583F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1681F, 11.2622F, -1.9253F, 3.1416F, 0.5672F, 2.7489F));

		PartDefinition stick_r2 = wand.addOrReplaceChild("stick_r2", CubeListBuilder.create().texOffs(39, 27).addBox(-0.3F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4384F, -7.9031F, -1.5F, 0.0F, -0.3491F, -0.3927F));

		PartDefinition stick_r3 = wand.addOrReplaceChild("stick_r3", CubeListBuilder.create().texOffs(41, 25).addBox(-2.0762F, -5.5F, -2.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 51).addBox(-1.5F, 1.5F, -2.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition skull = wand.addOrReplaceChild("skull", CubeListBuilder.create(), PartPose.offset(-4.4384F, -7.9031F, -1.5F));

		PartDefinition skul_r1 = skull.addOrReplaceChild("skul_r1", CubeListBuilder.create().texOffs(0, 36).addBox(-3.3F, 0.5F, -1.3835F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-3.3F, -2.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, -0.3927F));

		PartDefinition skull2 = wand.addOrReplaceChild("skull2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.4384F, -10.9031F, -1.5F, -1.3867F, -0.7769F, 1.441F));

		PartDefinition skul_r2 = skull2.addOrReplaceChild("skul_r2", CubeListBuilder.create().texOffs(6, 24).addBox(-2.3F, 0.5F, -1.3835F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1238F, -0.3272F, -0.0232F));

		PartDefinition skul_r3 = skull2.addOrReplaceChild("skul_r3", CubeListBuilder.create().texOffs(48, 16).addBox(-3.3F, -2.5F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-3.3F, -0.5F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, -0.3927F));

		PartDefinition heel = wand.addOrReplaceChild("heel", CubeListBuilder.create(), PartPose.offset(4.1681F, 11.2622F, -1.9253F));

		PartDefinition stick_r4 = heel.addOrReplaceChild("stick_r4", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.063F, -27.7242F, 2.3251F, 0.0275F, -0.9009F, -0.446F));

		PartDefinition stick_r5 = heel.addOrReplaceChild("stick_r5", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0976F, -28.0918F, 2.9387F, 0.2893F, -0.9009F, -0.446F));

		PartDefinition stick_r6 = heel.addOrReplaceChild("stick_r6", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -0.5F, -1.9F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.211F, -28.2846F, 2.9538F, 0.5075F, -0.9009F, -0.446F));

		PartDefinition stick_r7 = heel.addOrReplaceChild("stick_r7", CubeListBuilder.create().texOffs(3, 40).addBox(0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.211F, -28.2846F, 2.9538F, -1.6136F, -1.3134F, 0.8117F));

		PartDefinition stick_r8 = heel.addOrReplaceChild("stick_r8", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 40).addBox(-0.5F, -0.8F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.211F, -28.2846F, 2.9538F, -1.5888F, -0.9209F, 0.7846F));

		PartDefinition stick_r9 = heel.addOrReplaceChild("stick_r9", CubeListBuilder.create().texOffs(3, 40).addBox(-0.8F, -3.5F, -0.0767F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0551F, -28.2721F, 2.8184F, -0.2857F, 0.5349F, -0.1984F));

		PartDefinition stick_r10 = heel.addOrReplaceChild("stick_r10", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -5.5F, 0.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0551F, -28.2721F, 2.8184F, -0.3766F, -0.8509F, 0.2393F));

		PartDefinition stick_r11 = heel.addOrReplaceChild("stick_r11", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0551F, -28.2721F, 2.8184F, -0.5512F, -0.8509F, 0.2393F));

		PartDefinition stick_r12 = heel.addOrReplaceChild("stick_r12", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.211F, -28.2846F, 2.9538F, -0.3766F, -0.8509F, 0.2393F));

		PartDefinition stick_r13 = heel.addOrReplaceChild("stick_r13", CubeListBuilder.create().texOffs(3, 40).addBox(0.7F, -6.5F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6066F, -19.1653F, 0.4253F, -0.1202F, -0.9051F, -0.0926F));

		PartDefinition heel2 = wand.addOrReplaceChild("heel2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.8319F, -9.7378F, 1.0747F, 2.7762F, 0.7704F, 1.8391F));

		PartDefinition stick_r14 = heel2.addOrReplaceChild("stick_r14", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.937F, -6.7242F, 2.3251F, 0.0275F, -0.9009F, -0.446F));

		PartDefinition stick_r15 = heel2.addOrReplaceChild("stick_r15", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9024F, -7.0918F, 2.9387F, 0.2893F, -0.9009F, -0.446F));

		PartDefinition stick_r16 = heel2.addOrReplaceChild("stick_r16", CubeListBuilder.create().texOffs(3, 40).addBox(-2.5F, -0.5F, -1.9F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.789F, -7.2846F, 2.9538F, 0.5075F, -0.9009F, -0.446F));

		PartDefinition stick_r17 = heel2.addOrReplaceChild("stick_r17", CubeListBuilder.create().texOffs(3, 40).addBox(0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.789F, -7.2846F, 2.9538F, -1.6136F, -1.3134F, 0.8117F));

		PartDefinition stick_r18 = heel2.addOrReplaceChild("stick_r18", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 40).addBox(-0.5F, -0.8F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.789F, -7.2846F, 2.9538F, -1.5888F, -0.9209F, 0.7846F));

		PartDefinition stick_r19 = heel2.addOrReplaceChild("stick_r19", CubeListBuilder.create().texOffs(3, 40).addBox(-0.8F, -3.5F, -0.0767F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9449F, -7.2721F, 2.8184F, -0.2857F, 0.5349F, -0.1984F));

		PartDefinition stick_r20 = heel2.addOrReplaceChild("stick_r20", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -5.5F, 0.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9449F, -7.2721F, 2.8184F, -0.3766F, -0.8509F, 0.2393F));

		PartDefinition stick_r21 = heel2.addOrReplaceChild("stick_r21", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9449F, -7.2721F, 2.8184F, -0.5512F, -0.8509F, 0.2393F));

		PartDefinition stick_r22 = heel2.addOrReplaceChild("stick_r22", CubeListBuilder.create().texOffs(3, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.789F, -7.2846F, 2.9538F, -0.3766F, -0.8509F, 0.2393F));

		PartDefinition stick_r23 = heel2.addOrReplaceChild("stick_r23", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3352F, -2.9208F, -2.0855F, -2.7535F, 0.7045F, -1.1018F));

		PartDefinition stick_r24 = heel2.addOrReplaceChild("stick_r24", CubeListBuilder.create().texOffs(19, 6).addBox(0.0F, -3.5F, -0.1793F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8935F, -3.7575F, -0.379F, 2.0531F, 0.3243F, -1.3505F));

		PartDefinition stick_r25 = heel2.addOrReplaceChild("stick_r25", CubeListBuilder.create().texOffs(19, 4).addBox(-2.0F, -2.5F, 3.8207F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.806F, -2.8645F, -2.3852F, -3.1101F, 1.3383F, 0.2339F));

		PartDefinition stick_r26 = heel2.addOrReplaceChild("stick_r26", CubeListBuilder.create().texOffs(19, 4).addBox(0.0F, -3.5F, 0.8207F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8935F, -3.7575F, -0.379F, 1.8386F, 0.5153F, -1.2349F));

		PartDefinition stick_r27 = heel2.addOrReplaceChild("stick_r27", CubeListBuilder.create().texOffs(19, 3).addBox(0.0F, -4.5F, 0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8935F, -3.7575F, -0.379F, 2.0568F, 0.5153F, -1.2349F));

		PartDefinition stick_r28 = heel2.addOrReplaceChild("stick_r28", CubeListBuilder.create().texOffs(55, 8).addBox(-1.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8935F, -3.7575F, -0.379F, 2.1335F, 0.7045F, -1.1018F));

		PartDefinition stick_r29 = heel2.addOrReplaceChild("stick_r29", CubeListBuilder.create().texOffs(55, 9).addBox(0.7F, -6.5F, -6.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.753F, -1.7078F, -3.439F, -2.7971F, 0.7045F, -1.1018F));

		PartDefinition stick_r30 = heel2.addOrReplaceChild("stick_r30", CubeListBuilder.create().texOffs(56, 8).addBox(0.7F, -6.5F, -6.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2429F, -0.1877F, -0.7827F, -1.0518F, 0.7045F, -1.1018F));

		PartDefinition stick_r31 = heel2.addOrReplaceChild("stick_r31", CubeListBuilder.create().texOffs(3, 40).addBox(0.7F, -6.5F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3934F, 1.8347F, 0.4253F, -0.1202F, -0.9051F, -0.0926F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 3.0F, 0.0F, 0.1724F, 0.1195F, -0.6005F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(44, 58).addBox(-1.0F, 1.5F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1441F, 4.4529F, -5.4533F, -2.137F, 0.51F, -0.9634F));

		PartDefinition LeftArm_r2 = LeftArm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(41, 53).addBox(0.0F, 1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 59).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6005F, 4.7553F, -4.9416F, -1.5116F, 0.7409F, 0.0399F));

		PartDefinition LeftArm_r3 = LeftArm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(33, 51).addBox(0.5F, -1.2812F, -3.4483F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.0562F, 0.6078F, -0.9163F, 0.0F, 0.0F));

		PartDefinition LeftArm_r4 = LeftArm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(12, 22).addBox(-1.5F, -5.9776F, -1.1344F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0219F, -0.2921F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 16.0F, 0.0F, -0.2007F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(45, 38).addBox(-3.0F, 7.0F, -2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(45, 32).addBox(-3.4F, 0.0F, -1.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7604F, 0.5767F, -0.8652F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 16.0F, 0.0F, -0.5236F, 0.0F, -0.0349F));

		PartDefinition Leftll_r1 = LeftLeg.addOrReplaceChild("Leftll_r1", CubeListBuilder.create().texOffs(45, 38).addBox(-2.7F, 2.0F, 0.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(44, 21).addBox(-3.1F, -5.0F, 1.5F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.616F, 5.7689F, -0.3772F, 0.5672F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.6F * limbSwingAmount;

		this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 0.3F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.007453292F;
		this.Head.xRot = headPitch * 0.007453292F;
	}
	
	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
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
}