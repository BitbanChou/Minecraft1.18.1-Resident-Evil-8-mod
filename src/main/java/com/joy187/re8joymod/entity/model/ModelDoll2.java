package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll2;

import net.minecraft.client.model.geom.ModelPart;
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


public class ModelDoll2<T extends EntityDoll2> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelDoll2(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0262F, 0.0873F, 0.48F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(12, 34).addBox(-2.9947F, 2.933F, -3.5133F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -8.3897F, -0.6637F, 0.3927F, 0.0F, -0.48F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(22, 39).mirror().addBox(-7.8446F, -2.3705F, -1.8117F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.862F, -0.0131F, -0.2873F, 0.0436F, -0.2618F, 0.7854F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(21, 38).addBox(0.6472F, -1.8488F, -1.7838F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3046F, -0.2123F, -1.0511F, 0.0873F, 0.2618F, -1.5708F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(21, 40).addBox(-2.1079F, -3.7995F, -0.3417F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2197F, -2.2201F, -2.1883F, 0.3927F, 0.0F, -0.48F));

		PartDefinition Head_r5 = Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(46, 0).addBox(-4.9947F, 2.933F, -4.5133F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -9.3897F, -0.6637F, 0.3927F, 0.0F, -0.48F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(14, 5).addBox(-3.0F, 3.0F, -2.0F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 6).addBox(-5.0F, 10.0F, -3.0F, 11.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r6 = Body.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(29, 11).addBox(-8.7F, -2.1F, -5.5F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4171F, 3.7881F, 2.5307F, 0.0F, -0.0436F, -0.0436F));

		PartDefinition Head_r7 = Body.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(36, 32).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4171F, 3.7881F, 2.5307F, 0.2182F, 0.0F, 0.0873F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 7.0F, 0.0F, -0.1745F, 0.6109F, 0.1309F));

		PartDefinition hand1_r1 = RightArm.addOrReplaceChild("hand1_r1", CubeListBuilder.create().texOffs(43, 26).addBox(-1.4661F, -7.5085F, 0.3322F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5048F, 9.5604F, -0.3124F, 0.0436F, -0.5236F, 0.1309F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(3, 3).addBox(-0.7568F, -3.9661F, -1.2676F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0608F, -0.1946F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 3.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

		PartDefinition hand2_r1 = LeftArm.addOrReplaceChild("hand2_r1", CubeListBuilder.create().texOffs(43, 26).addBox(-0.4527F, -5.2916F, 0.1843F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5587F, 11.1608F, -1.4452F, 0.0436F, -0.5236F, -0.4363F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(13, 16).addBox(-0.8649F, -3.9456F, -0.7377F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.0873F, 0.0F, -0.3491F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));

		PartDefinition scissors = RightLeg.addOrReplaceChild("scissors", CubeListBuilder.create(), PartPose.offsetAndRotation(0.854F, 2.5063F, -2.2926F, 2.4871F, -3.0543F, -1.6144F));

		PartDefinition Body_r1 = scissors.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(48, 20).addBox(-4.9941F, -1.1412F, -0.3768F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.9352F, 4.2291F, -2.1501F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r2 = scissors.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(50, 25).addBox(-4.8957F, -0.7714F, -0.3594F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.9883F, 3.7862F, -2.1501F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r3 = scissors.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(45, 61).addBox(-0.9853F, -0.7687F, 0.0248F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.9853F, -0.7687F, -0.3752F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1077F, 3.3033F, -1.4555F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r4 = scissors.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(7, 47).addBox(-0.2481F, 1.4701F, -0.2452F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8679F, -1.3012F, -0.0663F, 0.0F, 0.1745F, 0.9163F));

		PartDefinition Body_r5 = scissors.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(6, 53).addBox(-4.9513F, -1.022F, -0.3692F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8145F, -0.1179F, -0.0663F, 0.0F, 0.1745F, 0.0F));

		PartDefinition scissors2 = RightLeg.addOrReplaceChild("scissors2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.854F, 5.5063F, -1.2926F, 0.0436F, -3.0543F, -1.6144F));

		PartDefinition Body_r6 = scissors2.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(48, 20).addBox(-4.6737F, -0.6358F, -1.811F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8628F, 3.7687F, -2.0225F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r7 = scissors2.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(50, 25).addBox(-4.6845F, -0.2636F, -1.8129F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9159F, 3.3258F, -2.0225F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r8 = scissors2.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(45, 61).addBox(-0.6867F, -0.2609F, -1.4133F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.6867F, -0.2609F, -1.8133F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0352F, 2.8428F, -1.3279F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r9 = scissors2.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(7, 47).addBox(1.278F, 2.2466F, -1.4669F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.21F, -2.6917F, 0.0613F, 0.0F, 0.1745F, 1.2654F));

		PartDefinition Body_r10 = scissors2.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(6, 53).addBox(-4.6964F, -0.5123F, -1.815F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1712F, -0.3808F, 0.0613F, 0.0F, 0.1745F, 0.0F));

		PartDefinition scissors5 = RightLeg.addOrReplaceChild("scissors5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.854F, 5.5063F, -3.2926F, 1.1781F, 2.618F, -1.6144F));

		PartDefinition Body_r11 = scissors5.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(48, 20).addBox(-4.7133F, 0.2741F, -0.6211F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8628F, 3.7687F, -2.0225F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r12 = scissors5.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(50, 25).addBox(-4.922F, 0.661F, -0.6579F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9159F, 3.3258F, -2.0225F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r13 = scissors5.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(45, 61).addBox(-0.7655F, 0.6555F, -0.2303F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.7655F, 0.6555F, -0.6303F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0352F, 2.8428F, -1.3279F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r14 = scissors5.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(7, 47).addBox(1.9553F, 2.4792F, -0.1505F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.21F, -2.6917F, 0.0613F, 0.0F, 0.1745F, 1.2654F));

		PartDefinition Body_r15 = scissors5.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(6, 53).addBox(-4.8544F, 0.4117F, -0.646F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1712F, -0.3808F, 0.0613F, 0.0F, 0.1745F, 0.0F));

		PartDefinition scissors3 = RightLeg.addOrReplaceChild("scissors3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.854F, 5.5063F, 0.7074F, -0.6545F, 2.9671F, -1.6144F));

		PartDefinition Body_r16 = scissors3.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(48, 20).addBox(-4.6897F, 0.1875F, -1.0962F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8628F, 3.7687F, -2.0225F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r17 = scissors3.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(50, 25).addBox(-4.8785F, 0.5637F, -1.1295F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9159F, 3.3258F, -2.0225F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r18 = scissors3.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(45, 61).addBox(-0.7381F, 0.5664F, -0.7048F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.7381F, 0.5664F, -1.1048F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0352F, 2.8428F, -1.3279F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r19 = scissors3.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(7, 47).addBox(1.9353F, 2.4963F, -0.6334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.21F, -2.6917F, 0.0613F, 0.0F, 0.1745F, 1.2654F));

		PartDefinition Body_r20 = scissors3.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(6, 53).addBox(-4.8191F, 0.3181F, -1.1191F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1712F, -0.3808F, 0.0613F, 0.0F, 0.1745F, 0.0F));

		PartDefinition scissors6 = RightLeg.addOrReplaceChild("scissors6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.854F, 5.5063F, 0.7074F, -1.7453F, 2.9671F, -1.6144F));

		PartDefinition Body_r21 = scissors6.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(48, 20).addBox(-4.6897F, 0.1875F, -1.0962F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8628F, 3.7687F, -2.0225F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r22 = scissors6.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(50, 25).addBox(-4.8785F, 0.5637F, -1.1295F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9159F, 3.3258F, -2.0225F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r23 = scissors6.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(45, 61).addBox(-0.7381F, 0.5664F, -0.7048F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.7381F, 0.5664F, -1.1048F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0352F, 2.8428F, -1.3279F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r24 = scissors6.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(7, 47).addBox(1.9353F, 2.4963F, -0.6334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.21F, -2.6917F, 0.0613F, 0.0F, 0.1745F, 1.2654F));

		PartDefinition Body_r25 = scissors6.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(6, 53).addBox(-4.8191F, 0.3181F, -1.1191F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1712F, -0.3808F, 0.0613F, 0.0F, 0.1745F, 0.0F));

		PartDefinition scissors4 = RightLeg.addOrReplaceChild("scissors4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.854F, 5.5063F, -0.2926F, -2.618F, -3.0543F, -1.6144F));

		PartDefinition Body_r26 = scissors4.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(48, 20).addBox(-4.8916F, -0.2343F, -0.2709F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8628F, 3.7687F, -2.0225F, 0.0F, 0.1745F, 0.1309F));

		PartDefinition Body_r27 = scissors4.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(50, 25).addBox(-4.9892F, 0.1399F, -0.2881F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9159F, 3.3258F, -2.0225F, 0.0F, 0.1745F, -0.0873F));

		PartDefinition Body_r28 = scissors4.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(45, 61).addBox(-0.9218F, 0.1425F, 0.1237F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(10, 48).addBox(-4.9218F, 0.1425F, -0.2763F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0352F, 2.8428F, -1.3279F, 0.0F, 0.1745F, 0.0873F));

		PartDefinition Body_r29 = scissors4.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(7, 47).addBox(1.3885F, 2.3684F, 0.1311F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.21F, -2.6917F, 0.0613F, 0.0F, 0.1745F, 1.2654F));

		PartDefinition Body_r30 = scissors4.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(6, 53).addBox(-4.9663F, -0.1073F, -0.2841F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1712F, -0.3808F, 0.0613F, 0.0F, 0.1745F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg.getChild("scissors").yRot = headPitch * 0.017453292F;
		this.RightLeg.getChild("scissors").zRot = headPitch * 0.017453292F;
		
		
		this.RightLeg.getChild("scissors2").xRot = headPitch * 0.017453292F;
		this.RightLeg.getChild("scissors3").xRot = headPitch * 0.020453292F;
		this.RightLeg.getChild("scissors4").zRot = headPitch * 0.017453292F;
		this.RightLeg.getChild("scissors5").yRot = headPitch * 0.008453292F;
		this.RightLeg.getChild("scissors6").xRot = headPitch * 0.020453292F;

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