package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeisencar;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.resources.ResourceLocation;
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


public class ModelHeisencar<T extends EntityHeisencar> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/heisencar.png"), "main");
	private final ModelPart Body;
	private final ModelPart RightLeg;
	private final ModelPart vicer;
	private final ModelPart LeftLeg;
	private final ModelPart otherp;

	public ModelHeisencar(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightLeg = root.getChild("RightLeg");
		this.vicer = root.getChild("vicer");
		this.LeftLeg = root.getChild("LeftLeg");
		this.otherp = root.getChild("otherp");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -15.0F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 47).mirror().addBox(-4.5F, -17.9F, 2.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 47).mirror().addBox(-1.5F, -11.9F, -1.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 47).mirror().addBox(-6.5F, -11.9F, -1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 47).mirror().addBox(-4.5F, -12.9F, -1.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.2337F, 12.3197F, 14.3251F, -0.0422F, 0.0434F, -0.0131F));

		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-0.5F, -12.9F, -6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.7663F, 3.3197F, 39.3251F, -0.0382F, 0.0469F, 0.0742F));

		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(6, 46).mirror().addBox(-0.5F, -18.9F, -6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0502F, 4.2171F, 39.3441F, -0.034F, 0.05F, 0.1615F));

		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(6, 46).mirror().addBox(-0.5F, -18.9F, -6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9735F, 4.3973F, 39.2038F, -0.044F, 0.0415F, -0.0568F));

		PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-0.5F, -12.9F, -6.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2337F, 3.3197F, 39.3251F, -0.0382F, 0.0469F, 0.0742F));

		PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(51, 13).mirror().addBox(-10.5F, -7.4F, -17.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2337F, 3.3197F, 39.3251F, -0.0071F, 0.0601F, 0.6421F));

		PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(0, 43).mirror().addBox(-5.5F, -10.9F, -16.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 43).mirror().addBox(-10.5F, -7.9F, -15.0F, 15.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2337F, 3.3197F, 39.3251F, -0.0422F, 0.0434F, -0.0131F));

		PartDefinition Body_r8 = Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(10, 32).mirror().addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.2337F, 3.3197F, 39.3251F, -0.0436F, -0.2618F, 0.0F));

		PartDefinition Body_r9 = Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(10, 32).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2337F, 3.3197F, 39.3251F, -0.0436F, 0.2618F, 0.0F));

		PartDefinition Body_r10 = Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(12, 35).addBox(4.0F, -3.5F, 7.0F, 7.0F, 9.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 7.5F, 20.0F, -0.0436F, 0.0873F, 0.0F));

		PartDefinition Body_r11 = Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(12, 35).mirror().addBox(-7.9128F, -3.5435F, 7.9952F, 7.0F, 9.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 7.5F, 19.0F, -0.0436F, -0.0873F, 0.0F));

		PartDefinition Body_r12 = Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 23).addBox(-23.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9702F, 3.5492F, 0.3231F, -1.5708F, 1.4835F, -1.5708F));

		PartDefinition leftweapon = Body.addOrReplaceChild("leftweapon", CubeListBuilder.create(), PartPose.offset(-0.9702F, 3.5492F, 0.3231F));

		PartDefinition Body_r13 = leftweapon.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, 28).addBox(9.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(4.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-1.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(5, 39).addBox(-6.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-19.0F, -13.0F, -7.7F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-17.0F, -11.0F, -7.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-17.0F, -8.0F, -6.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 1.4835F, -1.5708F));

		PartDefinition Body_r14 = leftweapon.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(32, 62).addBox(-9.0F, -18.0F, -6.7F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-12.0F, -19.0F, -7.7F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-15.0F, -18.0F, -7.7F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-15.0F, -17.0F, -4.7F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-17.0F, -15.0F, -5.7F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4835F, 1.4835F, -1.5708F));

		PartDefinition Body_r15 = leftweapon.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 28).addBox(-16.0F, -8.0F, -3.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 1.4835F, -1.5708F));

		PartDefinition Body_r16 = leftweapon.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 28).addBox(-16.0F, -8.0F, -3.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.4399F, 1.4835F, -1.5708F));

		PartDefinition rightweapon = Body.addOrReplaceChild("rightweapon", CubeListBuilder.create(), PartPose.offset(-0.9807F, -2.3258F, 13.3591F));

		PartDefinition Body_r17 = rightweapon.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(38, 14).addBox(6.0F, -11.0F, -13.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(15, 27).addBox(10.0F, -12.0F, -12.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 17).addBox(27.0F, -10.5F, -10.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 17).addBox(23.0F, -10.5F, -10.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 17).addBox(18.0F, -11.0F, -10.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 37).addBox(12.0F, -11.0F, -10.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(15, 27).addBox(7.0F, -12.0F, -9.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(15, 27).addBox(-3.0F, -12.0F, -8.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.969F, 1.5267F, -1.4414F));

		PartDefinition Body_r18 = rightweapon.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(50, 19).addBox(-10.2655F, -0.9139F, -3.2318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-11.2655F, -0.9139F, -6.7318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-9.2655F, -0.9139F, -6.2318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-8.2655F, -0.9139F, -2.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-6.2655F, -0.9139F, -1.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-7.2655F, -0.9139F, -5.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-5.2655F, -0.9139F, -4.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(-3.2655F, -0.9139F, -3.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(0.7345F, -0.9139F, -1.5318F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -10.0F, -31.0F, -3.1237F, 1.1346F, -1.5975F));

		PartDefinition Body_r19 = rightweapon.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(50, 19).addBox(32.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(30.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 19).addBox(28.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.098F, 1.3963F, -1.5708F));

		PartDefinition Body_r20 = rightweapon.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(50, 19).addBox(31.0F, -10.1F, -2.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1164F, 1.2654F, -1.5897F));

		PartDefinition Body_r21 = rightweapon.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -11.0F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.098F, 1.3963F, -1.5708F));

		PartDefinition Body_r22 = rightweapon.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(15, 24).addBox(-2.0F, -2.0F, 2.0F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0361F, 3.71F, -0.6542F, 1.3526F, 1.3963F, -1.5708F));

		PartDefinition Body_r23 = rightweapon.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -9.0F, -2.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6208F, -0.4802F, 0.0847F, -3.098F, 1.3963F, -1.5708F));

		PartDefinition Body_r24 = rightweapon.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -6.0F, 3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4049F, 5.0432F, -0.8893F, -1.8326F, 1.3963F, -1.5708F));

		PartDefinition Body_r25 = rightweapon.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(15, 24).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.9104F, 2.4398F, -0.4302F, 1.8762F, 1.3963F, -1.5708F));

		PartDefinition Body_r26 = rightweapon.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -10.0F, 3.0F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6208F, -0.4802F, 0.0847F, -2.2253F, 1.3963F, -1.5708F));

		PartDefinition Body_r27 = rightweapon.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8733F, 1.4814F, -0.2612F, 3.098F, 1.3963F, -1.5708F));

		PartDefinition Body_r28 = rightweapon.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.52F, 3.9291F, -0.6928F, -2.3998F, 1.3963F, -1.5708F));

		PartDefinition Body_r29 = rightweapon.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0106F, 5.875F, -1.0359F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition rightp = Body.addOrReplaceChild("rightp", CubeListBuilder.create(), PartPose.offset(10.0845F, 2.1919F, 20.8411F));

		PartDefinition Body_r30 = rightp.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(0, 23).addBox(-4.9514F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1374F, 0.4343F, -1.3937F));

		PartDefinition Body_r31 = rightp.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(0, 23).addBox(-21.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-21.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-23.0F, -1.0F, 1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-21.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, 1.5708F, 1.4835F, 1.5708F));

		PartDefinition Body_r32 = rightp.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(15.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0845F, 5.8081F, -20.8411F, 1.5708F, -1.4835F, -1.5708F));

		PartDefinition Body_r33 = rightp.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-0.0486F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.1689F, 0.0F, 0.0F, -3.1374F, -0.4343F, 1.3937F));

		PartDefinition Body_r34 = rightp.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.3721F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5009F, 3.6181F, -4.2919F, -0.0054F, -0.8871F, -1.6084F));

		PartDefinition Body_r35 = rightp.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(0, 23).addBox(-22.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4633F, 7.0089F, -20.7808F, -0.0224F, 1.3983F, 1.7241F));

		PartDefinition Body_r36 = rightp.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(17.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.7057F, 7.0089F, -20.7808F, -0.0224F, -1.3983F, -1.7241F));

		PartDefinition Body_r37 = rightp.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(9.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 23).mirror().addBox(3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 23).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, -0.3054F, -1.4835F, -1.5708F));

		PartDefinition Body_r38 = rightp.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(20.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1143F, 3.3573F, -20.5179F, -1.5708F, -1.4835F, 1.5708F));

		PartDefinition Body_r39 = rightp.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-2.0F, -5.0F, -3.0F, 25.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0845F, 5.8081F, -20.8411F, 3.098F, -1.4835F, -1.5708F));

		PartDefinition Body_r40 = rightp.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -2.0F, -2.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, 0.036F, 0.5912F, 1.593F));

		PartDefinition Body_r41 = rightp.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, -0.3054F, 1.4835F, 1.5708F));

		PartDefinition Body_r42 = rightp.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(0, 23).addBox(-1.6279F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6681F, 3.6181F, -4.2919F, -0.0054F, 0.8871F, 1.6084F));

		PartDefinition rightp2 = Body.addOrReplaceChild("rightp2", CubeListBuilder.create(), PartPose.offset(-3.9155F, 2.1919F, 20.8411F));

		PartDefinition Body_r43 = rightp2.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(0, 23).addBox(-4.9514F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1374F, 0.4343F, -1.3937F));

		PartDefinition Body_r44 = rightp2.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(0, 23).addBox(-21.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-21.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-21.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, 1.5708F, 1.4835F, 1.5708F));

		PartDefinition Body_r45 = rightp2.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(15.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0845F, 5.8081F, -20.8411F, 1.5708F, -1.4835F, -1.5708F));

		PartDefinition Body_r46 = rightp2.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-0.0486F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.1689F, 0.0F, 0.0F, -3.1374F, -0.4343F, 1.3937F));

		PartDefinition Body_r47 = rightp2.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-1.3721F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5009F, 3.6181F, -4.2919F, -0.0054F, -0.8871F, -1.6084F));

		PartDefinition Body_r48 = rightp2.addOrReplaceChild("Body_r48", CubeListBuilder.create().texOffs(0, 23).addBox(-22.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4633F, 7.0089F, -20.7808F, -0.0224F, 1.3983F, 1.7241F));

		PartDefinition Body_r49 = rightp2.addOrReplaceChild("Body_r49", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(17.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.7057F, 7.0089F, -20.7808F, -0.0224F, -1.3983F, -1.7241F));

		PartDefinition Body_r50 = rightp2.addOrReplaceChild("Body_r50", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(9.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 23).mirror().addBox(3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 23).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, -0.3054F, -1.4835F, -1.5708F));

		PartDefinition Body_r51 = rightp2.addOrReplaceChild("Body_r51", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(20.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1143F, 3.3573F, -20.5179F, -1.5708F, -1.4835F, 1.5708F));

		PartDefinition Body_r52 = rightp2.addOrReplaceChild("Body_r52", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(-2.0F, -5.0F, -3.0F, 25.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0845F, 5.8081F, -20.8411F, 3.098F, -1.4835F, -1.5708F));

		PartDefinition Body_r53 = rightp2.addOrReplaceChild("Body_r53", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -2.0F, -2.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, 0.036F, 0.5912F, 1.593F));

		PartDefinition Body_r54 = rightp2.addOrReplaceChild("Body_r54", CubeListBuilder.create().texOffs(0, 23).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-9.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-15.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0845F, 5.8081F, -20.8411F, -0.3054F, 1.4835F, 1.5708F));

		PartDefinition Body_r55 = rightp2.addOrReplaceChild("Body_r55", CubeListBuilder.create().texOffs(0, 23).addBox(-1.6279F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6681F, 3.6181F, -4.2919F, -0.0054F, 0.8871F, 1.6084F));

		PartDefinition chain = Body.addOrReplaceChild("chain", CubeListBuilder.create(), PartPose.offset(13.8817F, 19.6156F, 18.7475F));

		PartDefinition Body_r56 = chain.addOrReplaceChild("Body_r56", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 16.0F, 3.0155F, 1.0961F, -1.6297F));

		PartDefinition Body_r57 = chain.addOrReplaceChild("Body_r57", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.7595F, -3.434F, -4.9151F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2689F, -1.447F, 17.4722F, 0.0632F, 0.4271F, 1.6503F));

		PartDefinition Body_r58 = chain.addOrReplaceChild("Body_r58", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3071F, -2.9363F, 16.7548F, 2.7011F, 1.4356F, -1.9544F));

		PartDefinition Body_r59 = chain.addOrReplaceChild("Body_r59", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(9.0F, -13.0F, 16.0F, 2.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.7268F, -5.0725F, -10.1794F, 0.0576F, -0.052F, 1.6211F));

		PartDefinition Body_r60 = chain.addOrReplaceChild("Body_r60", CubeListBuilder.create().texOffs(26, 51).addBox(-4.0F, 1.0F, -3.5F, 10.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1926F, 0.5599F, -15.836F, -0.9599F, 0.0436F, 0.0F));

		PartDefinition Body_r61 = chain.addOrReplaceChild("Body_r61", CubeListBuilder.create().texOffs(26, 51).addBox(-3.0F, 1.0F, -3.5F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1235F, -2.4906F, -16.0938F, -2.0071F, 0.0436F, 0.0F));

		PartDefinition Body_r62 = chain.addOrReplaceChild("Body_r62", CubeListBuilder.create().texOffs(26, 51).addBox(8.0F, 14.0F, 14.5F, 10.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.6074F, -14.6156F, -35.1862F, 0.3491F, 0.0436F, 0.0F));

		PartDefinition Body_r63 = chain.addOrReplaceChild("Body_r63", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.0F, -13.0F, 0.0F, 2.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 32).mirror().addBox(9.0F, -13.0F, -5.0F, 2.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.653F, -6.5097F, -10.231F, 0.0575F, 0.0351F, 1.6262F));

		PartDefinition Body_r64 = chain.addOrReplaceChild("Body_r64", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.0F, -13.0F, 13.0F, 2.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.5968F, -7.6527F, -10.3155F, 0.0579F, 0.1222F, 1.6312F));

		PartDefinition rw2_r1 = chain.addOrReplaceChild("rw2_r1", CubeListBuilder.create().texOffs(36, 49).mirror().addBox(-3.8531F, -2.0341F, -3.1524F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.653F, 0.4903F, 13.769F, 0.062F, 0.3835F, 1.6474F));

		PartDefinition rw5_r1 = chain.addOrReplaceChild("rw5_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.653F, 1.4903F, 2.769F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition pillar_r1 = chain.addOrReplaceChild("pillar_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-5.9224F, 1.4611F, 6.7007F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.653F, -0.5097F, -3.231F, 0.0575F, 0.0351F, 1.6262F));

		PartDefinition rw6_r1 = chain.addOrReplaceChild("rw6_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.653F, 1.4903F, 8.769F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition pillar_r2 = chain.addOrReplaceChild("pillar_r2", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-5.9224F, 1.4611F, 6.7007F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.653F, -0.5097F, -13.231F, 0.0575F, 0.0351F, 1.6262F));

		PartDefinition rw4_r1 = chain.addOrReplaceChild("rw4_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.653F, 1.4903F, -1.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition rw3_r1 = chain.addOrReplaceChild("rw3_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.653F, 1.4903F, -7.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition rw1_r1 = chain.addOrReplaceChild("rw1_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-3.9224F, 0.4611F, -3.2993F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.653F, -0.5097F, -13.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition chain2 = Body.addOrReplaceChild("chain2", CubeListBuilder.create(), PartPose.offset(-13.8817F, 21.6156F, 34.7475F));

		PartDefinition lw6_r1 = chain2.addOrReplaceChild("lw6_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1104F, -0.5097F, -6.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition pillar_r3 = chain2.addOrReplaceChild("pillar_r3", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-5.9224F, 1.4611F, 7.7007F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1104F, -2.5097F, -18.231F, 0.0575F, 0.0351F, 1.6262F));

		PartDefinition lw5_r1 = chain2.addOrReplaceChild("lw5_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1104F, -0.5097F, -12.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition lw3_r1 = chain2.addOrReplaceChild("lw3_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1104F, -0.5097F, -23.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition lw4_r1 = chain2.addOrReplaceChild("lw4_r1", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1104F, -0.5097F, -17.231F, 0.0858F, -0.8357F, 1.5604F));

		PartDefinition pillar_r4 = chain2.addOrReplaceChild("pillar_r4", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-5.9224F, 1.4611F, 7.7007F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1104F, -2.5097F, -29.231F, 0.0575F, 0.0351F, 1.6262F));

		PartDefinition Body_r65 = chain2.addOrReplaceChild("Body_r65", CubeListBuilder.create().texOffs(12, 32).addBox(0.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.0155F, -1.0961F, 1.6297F));

		PartDefinition Body_r66 = chain2.addOrReplaceChild("Body_r66", CubeListBuilder.create().texOffs(12, 32).addBox(0.7595F, -3.434F, -4.9151F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2689F, -3.447F, 1.4722F, 0.0632F, -0.4271F, -1.6503F));

		PartDefinition Body_r67 = chain2.addOrReplaceChild("Body_r67", CubeListBuilder.create().texOffs(12, 32).addBox(0.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3071F, -4.9363F, 0.7548F, 2.7011F, -1.4356F, 1.9544F));

		PartDefinition Body_r68 = chain2.addOrReplaceChild("Body_r68", CubeListBuilder.create().texOffs(12, 32).addBox(-11.0F, -13.0F, 16.0F, 2.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.7268F, -7.0725F, -26.1794F, 0.0576F, 0.052F, -1.6211F));

		PartDefinition Body_r69 = chain2.addOrReplaceChild("Body_r69", CubeListBuilder.create().texOffs(26, 51).mirror().addBox(-6.0F, 1.0F, -3.5F, 10.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1926F, -1.4401F, -31.836F, -0.9599F, -0.0436F, 0.0F));

		PartDefinition Body_r70 = chain2.addOrReplaceChild("Body_r70", CubeListBuilder.create().texOffs(26, 51).mirror().addBox(-6.0F, 1.0F, -3.5F, 9.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1235F, -4.4906F, -32.0938F, -2.0071F, -0.0436F, 0.0F));

		PartDefinition Body_r71 = chain2.addOrReplaceChild("Body_r71", CubeListBuilder.create().texOffs(26, 51).mirror().addBox(-18.0F, 14.0F, 14.5F, 10.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.6074F, -16.6156F, -51.1862F, 0.3491F, -0.0436F, 0.0F));

		PartDefinition Body_r72 = chain2.addOrReplaceChild("Body_r72", CubeListBuilder.create().texOffs(12, 32).addBox(0.0F, -13.0F, 0.0F, 2.0F, 10.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(12, 32).addBox(-11.0F, -13.0F, -5.0F, 2.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.653F, -8.5097F, -26.231F, 0.0575F, -0.0351F, -1.6262F));

		PartDefinition Body_r73 = chain2.addOrReplaceChild("Body_r73", CubeListBuilder.create().texOffs(12, 32).addBox(0.0F, -13.0F, 13.0F, 2.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5968F, -9.6527F, -26.3155F, 0.0579F, -0.1222F, -1.6312F));

		PartDefinition lw2_r1 = chain2.addOrReplaceChild("lw2_r1", CubeListBuilder.create().texOffs(5, 55).addBox(-2.9763F, -1.0904F, -2.7278F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.653F, -2.5097F, -2.231F, 0.0729F, 0.6617F, -1.5793F));

		PartDefinition lw1_r1 = chain2.addOrReplaceChild("lw1_r1", CubeListBuilder.create().texOffs(0, 35).addBox(-3.1728F, -0.5933F, -3.773F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.653F, -2.5097F, -28.231F, 3.0514F, -0.8792F, 1.587F));

		PartDefinition upperpart = Body.addOrReplaceChild("upperpart", CubeListBuilder.create(), PartPose.offset(-0.0084F, -0.1928F, -6.2983F));

		PartDefinition Body_r74 = upperpart.addOrReplaceChild("Body_r74", CubeListBuilder.create().texOffs(0, 19).addBox(-3.748F, -3.9629F, 1.4238F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7691F, 26.3557F, -11.519F, 0.1764F, 0.0418F, -0.0283F));

		PartDefinition Body_r75 = upperpart.addOrReplaceChild("Body_r75", CubeListBuilder.create().texOffs(5, 37).addBox(-11.0F, 5.5F, -12.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(5, 37).addBox(7.0F, 5.5F, -12.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(47, 58).addBox(-4.0F, 3.5F, -12.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(47, 58).addBox(1.0F, 3.5F, -12.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(43, 55).addBox(-3.0F, 3.5F, -10.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-11.0F, 2.5F, -16.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3545F, 0.0418F, -0.0283F));

		PartDefinition rightpart = upperpart.addOrReplaceChild("rightpart", CubeListBuilder.create(), PartPose.offset(11.1115F, 25.8159F, -12.5423F));

		PartDefinition Body_r76 = rightpart.addOrReplaceChild("Body_r76", CubeListBuilder.create().texOffs(0, 23).addBox(-3.148F, -2.6758F, -0.5762F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0417F, 0.0418F, -0.0283F));

		PartDefinition Body_r77 = rightpart.addOrReplaceChild("Body_r77", CubeListBuilder.create().texOffs(0, 23).addBox(-3.748F, -3.1629F, 1.4238F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3424F, 0.5398F, 1.0232F, 0.4819F, 0.0418F, -0.0283F));

		PartDefinition Body_r78 = rightpart.addOrReplaceChild("Body_r78", CubeListBuilder.create().texOffs(0, 23).addBox(-2.748F, -3.6758F, 1.4238F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9454F, -1.6702F, 6.0067F, 1.4418F, 0.0418F, -0.0283F));

		PartDefinition Body_r79 = rightpart.addOrReplaceChild("Body_r79", CubeListBuilder.create().texOffs(5, 32).addBox(-2.748F, 1.3242F, 1.4238F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9454F, -1.6702F, 6.0067F, 1.5728F, -0.3073F, -0.029F));

		PartDefinition Body_r80 = rightpart.addOrReplaceChild("Body_r80", CubeListBuilder.create().texOffs(0, 23).addBox(-2.748F, -2.6758F, 1.4238F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9454F, -1.6702F, 6.0067F, 1.5727F, 0.0418F, -0.0283F));

		PartDefinition Body_r81 = rightpart.addOrReplaceChild("Body_r81", CubeListBuilder.create().texOffs(0, 22).addBox(-3.148F, -3.6758F, -2.5762F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3805F, 0.5161F, 0.1296F, -0.0417F, 0.0418F, -0.0283F));

		PartDefinition Body_r82 = rightpart.addOrReplaceChild("Body_r82", CubeListBuilder.create().texOffs(0, 21).addBox(-3.748F, -3.6758F, 0.4238F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3424F, 0.5398F, 1.0232F, 0.4819F, 0.0418F, -0.0283F));

		PartDefinition Body_r83 = rightpart.addOrReplaceChild("Body_r83", CubeListBuilder.create().texOffs(0, 22).addBox(-2.748F, -4.6758F, 1.4238F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9454F, -1.6702F, 6.0067F, 1.18F, 0.0418F, -0.0283F));

		PartDefinition Body_r84 = rightpart.addOrReplaceChild("Body_r84", CubeListBuilder.create().texOffs(36, 29).addBox(-2.748F, -3.6758F, 1.4238F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1115F, -9.8159F, 7.5423F, 1.8345F, 0.0418F, -0.0283F));

		PartDefinition Body_r85 = rightpart.addOrReplaceChild("Body_r85", CubeListBuilder.create().texOffs(36, 29).addBox(-2.748F, -4.6758F, -4.5762F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1115F, -9.8159F, 7.5423F, 1.5727F, 0.0418F, -0.0283F));

		PartDefinition Body_r86 = rightpart.addOrReplaceChild("Body_r86", CubeListBuilder.create().texOffs(0, 41).addBox(-2.748F, -1.6758F, -3.5762F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1115F, -9.8159F, 7.5423F, 2.009F, 0.0418F, -0.0283F));

		PartDefinition Body_r87 = rightpart.addOrReplaceChild("Body_r87", CubeListBuilder.create().texOffs(0, 41).addBox(3.0F, -5.5F, -23.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.1115F, -25.8159F, 12.5423F, 1.6163F, 0.0418F, -0.0283F));

		PartDefinition leftpart = upperpart.addOrReplaceChild("leftpart", CubeListBuilder.create(), PartPose.offset(-15.0946F, 25.8159F, -12.5423F));

		PartDefinition Body_r88 = leftpart.addOrReplaceChild("Body_r88", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(2.148F, -2.6758F, -0.5762F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0417F, -0.0418F, 0.0283F));

		PartDefinition Body_r89 = leftpart.addOrReplaceChild("Body_r89", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(1.748F, -3.1629F, 1.4238F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3424F, 0.5398F, 1.0232F, 0.4819F, -0.0418F, 0.0283F));

		PartDefinition Body_r90 = leftpart.addOrReplaceChild("Body_r90", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(1.748F, -3.6758F, 1.4238F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9454F, -1.6702F, 6.0067F, 1.4418F, -0.0418F, 0.0283F));

		PartDefinition Body_r91 = leftpart.addOrReplaceChild("Body_r91", CubeListBuilder.create().texOffs(6, 32).mirror().addBox(0.748F, 1.3242F, 1.4238F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9454F, -1.6702F, 6.0067F, 1.5728F, 0.3509F, 0.029F));

		PartDefinition Body_r92 = leftpart.addOrReplaceChild("Body_r92", CubeListBuilder.create().texOffs(0, 23).mirror().addBox(0.748F, -2.6758F, 1.4238F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9454F, -1.6702F, 6.0067F, 1.5727F, -0.0418F, 0.0283F));

		PartDefinition Body_r93 = leftpart.addOrReplaceChild("Body_r93", CubeListBuilder.create().texOffs(1, 22).mirror().addBox(2.148F, -3.6758F, -2.5762F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.3805F, 0.5161F, 0.1296F, -0.0417F, -0.0418F, 0.0283F));

		PartDefinition Body_r94 = leftpart.addOrReplaceChild("Body_r94", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(1.748F, -3.6758F, 0.4238F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.3424F, 0.5398F, 1.0232F, 0.4819F, -0.0418F, 0.0283F));

		PartDefinition Body_r95 = leftpart.addOrReplaceChild("Body_r95", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(0.748F, -4.6758F, 1.4238F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9454F, -1.6702F, 6.0067F, 1.18F, -0.0418F, 0.0283F));

		PartDefinition Body_r96 = leftpart.addOrReplaceChild("Body_r96", CubeListBuilder.create().texOffs(38, 29).mirror().addBox(0.748F, -3.6758F, 1.4238F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1115F, -9.8159F, 7.5423F, 1.8781F, -0.0418F, 0.0283F));

		PartDefinition Body_r97 = leftpart.addOrReplaceChild("Body_r97", CubeListBuilder.create().texOffs(38, 29).mirror().addBox(0.748F, -4.6758F, -4.5762F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1115F, -9.8159F, 7.5423F, 1.5727F, -0.0418F, 0.0283F));

		PartDefinition Body_r98 = leftpart.addOrReplaceChild("Body_r98", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(1.748F, -1.6758F, -3.5762F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1115F, -9.8159F, 7.5423F, 2.009F, -0.0418F, 0.0283F));

		PartDefinition Body_r99 = leftpart.addOrReplaceChild("Body_r99", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(-6.0F, -5.5F, -23.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.1115F, -25.8159F, 12.5423F, 1.6163F, -0.0418F, 0.0283F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 38).addBox(3.1529F, -3.7944F, -4.3754F, 3.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, 20.0F, -8.0F, 3.098F, 0.0F, 0.0F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 39).addBox(-3.0418F, -6.6658F, -17.0021F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1683F, 3.6408F, 13.4137F, -0.0436F, 0.0F, 0.0F));

		PartDefinition vicer = partdefinition.addOrReplaceChild("vicer", CubeListBuilder.create(), PartPose.offset(2.9F, 9.8855F, 0.2078F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(20.45F, 21.457F, -5.4392F, 0.3054F, 0.0F, -0.0349F));

		PartDefinition otherp = partdefinition.addOrReplaceChild("otherp", CubeListBuilder.create(), PartPose.offset(-17.9F, 12.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw1_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw2_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw3_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw4_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw5_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain2").getChild("lw6_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;

		this.Body.getChild("chain").getChild("rw1_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain").getChild("rw2_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain").getChild("rw3_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain").getChild("rw4_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain").getChild("rw5_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.Body.getChild("chain").getChild("rw6_r1").yRot = Mth.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;

	}
	
	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.xRot = x;
		ModelPart.yRot= y;
		ModelPart.zRot = z;
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		vicer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		otherp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}