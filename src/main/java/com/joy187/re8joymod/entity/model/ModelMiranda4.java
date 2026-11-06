package com.joy187.re8joymod.entity.model;
// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda4;
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

public class ModelMiranda4<T extends EntityMiranda4> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelMiranda4(ModelPart root) {
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

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5556F, -49.0556F, 37.6111F, -0.1047F, 0.0F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(38, 5).addBox(27.9165F, -1.9993F, 33.8236F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6825F, 25.6979F, -33.5246F, 0.0F, 0.1309F, -1.5708F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(28, 6).mirror().addBox(-30.5607F, 1.3F, 41.2713F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.9267F, 29.4423F, -40.6752F, -0.0172F, -0.1298F, 1.7028F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(28, 10).mirror().addBox(-8.0088F, 30.045F, 41.2713F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(26, 13).mirror().addBox(-8.0088F, 29.045F, 41.2713F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.6633F, 30.871F, -40.4871F, -0.1304F, -0.0114F, 3.0551F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(40, 7).addBox(23.0673F, 14.3375F, 41.2713F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, 27.3199F, -40.823F, -0.0503F, 0.1209F, -1.9665F));

		PartDefinition Head_r5 = Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(26, 8).mirror().addBox(-33.3109F, 23.4496F, 33.5524F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9848F, 27.2289F, -41.4539F, 0.4002F, -0.0539F, 1.8047F));

		PartDefinition Head_r6 = Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(26, 3).mirror().addBox(-15.2486F, 2.8372F, 47.7266F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.8558F, 25.6241F, -38.4322F, -0.0401F, -0.4463F, 1.8201F));

		PartDefinition Head_r7 = Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(27, 0).addBox(11.9134F, 8.6727F, 47.321F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7447F, 25.6241F, -38.4322F, -0.0401F, 0.4463F, -1.8201F));

		PartDefinition Head_r8 = Head.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(45, 12).addBox(28.922F, 28.7959F, 31.2097F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1263F, 27.2289F, -41.4539F, 0.4002F, 0.0539F, -1.8047F));

		PartDefinition Head_r9 = Head.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(28, 12).addBox(-1.9683F, 29.5679F, 41.2713F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 18).addBox(-2.9683F, 30.5679F, 41.2713F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4479F, 30.871F, -40.4871F, -0.1304F, 0.0114F, -3.0551F));

		PartDefinition Head_r10 = Head.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(37, 8).addBox(-26.0433F, 17.9669F, 33.8236F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0404F, 26.3822F, -33.4345F, -0.1074F, -0.0749F, 2.5348F));

		PartDefinition Head_r11 = Head.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(23, 2).addBox(-16.5017F, -32.4744F, 33.8236F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5556F, 32.1988F, -32.6688F, 0.1188F, -0.0552F, 0.4331F));

		PartDefinition Head_r12 = Head.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(0, 62).addBox(-2.0F, -38.9158F, 34.8236F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5556F, 33.1988F, -32.6688F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(44, 7).addBox(-3.0F, -46.1926F, 35.8334F, 12.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(-2.0F, -47.1926F, 36.8334F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(86, 109).addBox(0.0F, -41.1926F, 46.8334F, 5.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 65).addBox(-3.0F, -34.1926F, 35.8334F, 11.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(46, 65).addBox(-2.0F, -26.1926F, 36.8334F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(52, 60).addBox(0.6144F, -25.4323F, 35.5888F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(51, 54).addBox(21.0072F, -5.2585F, 34.7039F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, -1.5F, 0.4363F, -0.5672F, 0.0F));

		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(51, 54).mirror().addBox(-19.9469F, -3.8961F, 37.6257F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -6.0F, -1.5F, 0.4363F, 0.5672F, 0.0F));

		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(69, 50).mirror().addBox(-5.6904F, -17.9558F, 45.3334F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -12.0F, -10.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(69, 50).addBox(8.2336F, -15.6597F, 45.3334F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -12.0F, -10.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(2, 47).addBox(-0.8276F, -24.1926F, 40.4244F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, -0.5F, 0.0F, 0.0436F, 0.0F));

		PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(44, 7).addBox(4.0F, -42.8971F, 20.3331F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(44, 7).addBox(-1.7F, -42.8971F, 20.3331F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -22.0F, -3.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(86, 109).addBox(0.5F, -1.2988F, 44.611F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -28.5F, 5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition circle = Body.addOrReplaceChild("circle", CubeListBuilder.create().texOffs(44, 0).addBox(1.3471F, -32.6778F, 40.8334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1203F, -20.1391F, 5.0F));

		PartDefinition Body_r8 = circle.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(44, 0).addBox(-3.0742F, 15.8619F, 41.8334F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-3.0742F, 16.8619F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7403F, -10.2461F, 0.0F, 0.0F, 0.0F, 3.0543F));

		PartDefinition Body_r9 = circle.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-6.903F, 17.3848F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.4996F, -10.2461F, 0.0F, 0.0F, 0.0F, -3.0543F));

		PartDefinition Body_r10 = circle.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(44, 0).addBox(-11.9074F, 14.2202F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.27F, -10.6594F, 0.0F, 0.0F, 0.0F, 2.7053F));

		PartDefinition Body_r11 = circle.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(44, 0).addBox(18.0789F, 13.1178F, 41.3334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(18.0789F, 11.4397F, 41.3334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(19.0789F, 14.7178F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2609F, -22.5389F, -0.5F, 0.0F, 0.0F, -2.3998F));

		PartDefinition Body_r12 = circle.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(44, 0).addBox(17.6069F, 12.455F, 41.3334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7023F, -20.4394F, -0.5F, 0.0F, 0.0F, -2.2253F));

		PartDefinition Body_r13 = circle.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(44, 0).addBox(21.0694F, 8.0413F, 41.3334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2743F, -14.3363F, -0.5F, 0.0F, 0.0F, -1.9199F));

		PartDefinition Body_r14 = circle.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(44, 0).addBox(15.3491F, -2.8108F, 41.3334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.7615F, -16.7378F, -0.5F, 0.0F, 0.0F, -1.309F));

		PartDefinition Body_r15 = circle.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-2.9053F, -9.3923F, 43.8196F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8797F, -14.3609F, 0.0F, 0.0F, -0.2618F, 0.9599F));

		PartDefinition Body_r16 = circle.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(41, 2).addBox(-1.669F, -5.3594F, 44.7893F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1203F, -14.3609F, 0.0F, 0.2137F, 0.0211F, -0.0118F));

		PartDefinition Body_r17 = circle.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(44, 0).addBox(1.2295F, -4.4774F, 44.7103F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1203F, -14.3609F, 0.0F, 0.0F, 0.2618F, -0.9599F));

		PartDefinition Body_r18 = circle.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(44, 0).addBox(21.6232F, -3.4774F, 39.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(14.6232F, -3.4774F, 39.8334F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(15.6232F, -4.4774F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1203F, -14.3609F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition Body_r19 = circle.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(44, 0).addBox(16.7559F, 1.5304F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1343F, -12.6419F, 0.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition Body_r20 = circle.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(44, 0).addBox(15.3061F, 1.2036F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6254F, -18.3427F, 0.0F, 0.0F, 0.0F, -1.5272F));

		PartDefinition Body_r21 = circle.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(44, 0).addBox(-12.3958F, -15.3647F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2466F, -13.7737F, -0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Body_r22 = circle.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(44, 0).addBox(-6.4031F, -18.6215F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9307F, -15.6531F, -0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Body_r23 = circle.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(44, 0).addBox(10.955F, -14.1069F, 41.3334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.4785F, -23.1806F, -0.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Body_r24 = circle.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(44, 0).addBox(10.8489F, -15.6454F, 45.8334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(5.8489F, -15.6454F, 45.8334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7341F, -20.7797F, -5.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body_r25 = circle.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(44, 0).addBox(20.1232F, -8.9774F, 45.8334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(16.1232F, -7.9774F, 45.8334F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7341F, -20.7797F, -5.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition Body_r26 = circle.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(11.9921F, -11.508F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0059F, -13.7737F, -0.5F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Body_r27 = circle.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(114, 64).mirror().addBox(22.422F, -32.1231F, 42.4611F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7797F, 25.5909F, -10.8791F, -0.1441F, -0.084F, -0.6939F));

		PartDefinition Body_r28 = circle.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(114, 64).addBox(-22.8258F, -33.9762F, 43.2928F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0203F, 25.5909F, -10.8791F, -0.1441F, 0.084F, 0.6939F));

		PartDefinition Body_r29 = circle.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(7.0413F, -16.5694F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.69F, -15.6531F, -0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Body_r30 = circle.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-9.9774F, -16.1232F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-9.9774F, -19.1232F, 41.3334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.7421F, -23.1153F, -0.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Body_r31 = circle.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-3.9003F, -16.4285F, 45.8334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4935F, -20.7797F, -5.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body_r32 = circle.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-16.6818F, -11.8923F, 45.8334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4935F, -20.7797F, -5.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Body_r33 = circle.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-5.8489F, 16.6454F, 45.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5532F, -21.1868F, -5.0F, 0.0F, 0.0F, 3.0107F));

		PartDefinition Body_r34 = circle.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-22.4107F, -3.9913F, 40.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-22.4107F, 0.0087F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.6239F, -17.1063F, 0.0F, 0.0F, 0.0F, 1.789F));

		PartDefinition Body_r35 = circle.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(44, 0).addBox(17.3619F, 3.0742F, 41.3334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1591F, -16.6553F, -0.5F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Body_r36 = circle.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-19.8848F, -1.903F, 41.3334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.9185F, -16.6553F, -0.5F, 0.0F, 0.0F, 1.6581F));

		PartDefinition Body_r37 = circle.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-15.7518F, -11.5614F, 41.3334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5549F, -15.5447F, -0.5F, 0.0F, 0.0F, 1.0908F));

		PartDefinition Body_r38 = circle.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(44, 0).addBox(16.5223F, -6.2394F, 41.3334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7955F, -15.5447F, -0.5F, 0.0F, 0.0F, -1.0908F));

		PartDefinition Body_r39 = circle.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(44, 0).addBox(19.112F, 1.8665F, 40.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(18.112F, 5.8665F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8646F, -17.1063F, 0.0F, 0.0F, 0.0F, -1.789F));

		PartDefinition Body_r40 = circle.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(46, 0).addBox(8.3862F, 15.5026F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7365F, -21.413F, 0.0F, 0.0F, 0.0F, -2.3126F));

		PartDefinition Body_r41 = circle.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(7.8958F, 12.6647F, 41.8334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4869F, -25.7504F, -1.0F, 0.0F, 0.0F, -2.4435F));

		PartDefinition Body_r42 = circle.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(44, 0).addBox(-15.4921F, 9.808F, 41.8334F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7276F, -25.7504F, -1.0F, 0.0F, 0.0F, 2.4435F));

		PartDefinition Body_r43 = circle.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(0, 0).addBox(9.0427F, 12.7854F, 40.8334F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5073F, -25.301F, -1.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition Body_r44 = circle.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(114, 2).addBox(-6.0723F, 6.9926F, 41.8334F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-4.5F, 13.9926F, 41.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 0).addBox(-4.5F, 17.1926F, 41.8334F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5073F, -25.301F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Body_r45 = circle.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(44, 0).addBox(-2.0997F, 17.4285F, 45.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2062F, -21.1868F, -5.0F, 0.0F, 0.0F, -3.0107F));

		PartDefinition Body_r46 = circle.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(44, 0).addBox(-0.4913F, 17.4107F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2407F, -25.0F, 0.0F, 0.0F, 0.0F, -2.9234F));

		PartDefinition Body_r47 = circle.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-16.455F, 19.6069F, 40.8334F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3234F, -23.7391F, 0.0F, 0.0F, 0.0F, 2.4871F));

		PartDefinition Body_r48 = circle.addOrReplaceChild("Body_r48", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-12.4074F, 20.2202F, 40.8334F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3234F, -23.7391F, 0.0F, 0.0F, 0.0F, 2.7053F));

		PartDefinition Body_r49 = circle.addOrReplaceChild("Body_r49", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-19.6232F, 12.9774F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5602F, -21.7872F, 0.0F, 0.0F, 0.0F, 2.1817F));

		PartDefinition Body_r50 = circle.addOrReplaceChild("Body_r50", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-18.4397F, 11.0789F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4958F, -21.413F, 0.0F, 0.0F, 0.0F, 2.3126F));

		PartDefinition Body_r51 = circle.addOrReplaceChild("Body_r51", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(3.4696F, 16.7559F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0293F, -10.6594F, 0.0F, 0.0F, 0.0F, -2.7053F));

		PartDefinition Body_r52 = circle.addOrReplaceChild("Body_r52", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-22.3848F, 1.597F, 40.8334F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.3827F, -18.9242F, 0.0F, 0.0F, 0.0F, 1.6581F));

		PartDefinition Body_r53 = circle.addOrReplaceChild("Body_r53", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-18.0444F, -4.7907F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.3847F, -18.3427F, 0.0F, 0.0F, 0.0F, 1.5272F));

		PartDefinition Body_r54 = circle.addOrReplaceChild("Body_r54", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-22.3952F, 1.3865F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5283F, -16.2157F, 0.0F, 0.0F, 0.0F, 1.3963F));

		PartDefinition Body_r55 = circle.addOrReplaceChild("Body_r55", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-21.4484F, -1.8318F, 39.8334F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8797F, -14.3609F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition Body_r56 = circle.addOrReplaceChild("Body_r56", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-18.1818F, -8.3923F, 39.8334F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-18.1818F, -6.3923F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-18.1818F, -9.3923F, 40.8334F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8797F, -14.3609F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Body_r57 = circle.addOrReplaceChild("Body_r57", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-8.3665F, 16.112F, 40.8334F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -25.0F, 0.0F, 0.0F, 0.0F, 2.9234F));

		PartDefinition wing = Body.addOrReplaceChild("wing", CubeListBuilder.create().texOffs(71, 46).addBox(2.3824F, -8.0571F, -1.7594F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(90, 103).addBox(-2.6176F, -5.0571F, -1.7594F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -34.0F, 47.0F, 0.0F, -0.3927F, -0.0873F));

		PartDefinition wingp_r1 = wing.addOrReplaceChild("wingp_r1", CubeListBuilder.create().texOffs(112, 59).addBox(-14.7626F, -21.6668F, 38.9519F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.3614F, 14.119F, -47.9592F, -0.064F, 0.1397F, 0.5531F));

		PartDefinition wingp_r2 = wing.addOrReplaceChild("wingp_r2", CubeListBuilder.create().texOffs(72, 46).addBox(-10.0F, -2.0F, -2.0F, 20.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(56.8543F, 57.9655F, -20.2075F, 0.2203F, 0.021F, 1.4504F));

		PartDefinition wingp_r3 = wing.addOrReplaceChild("wingp_r3", CubeListBuilder.create().texOffs(72, 46).addBox(16.5F, -17.0F, -6.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(56.2234F, 21.8041F, -11.2411F, 0.3025F, 0.1179F, 1.9266F));

		PartDefinition wingp_r4 = wing.addOrReplaceChild("wingp_r4", CubeListBuilder.create().texOffs(72, 46).addBox(15.5F, -11.0F, -6.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(72, 46).addBox(22.5F, -13.0F, -6.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.5852F, 23.6167F, -10.9725F, 0.2853F, 0.1559F, 1.8002F));

		PartDefinition wingp_r5 = wing.addOrReplaceChild("wingp_r5", CubeListBuilder.create().texOffs(72, 46).addBox(2.5F, -3.0F, -6.0F, 23.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.5852F, 23.6167F, -10.9725F, 0.2265F, 0.2338F, 1.499F));

		PartDefinition wingp_r6 = wing.addOrReplaceChild("wingp_r6", CubeListBuilder.create().texOffs(74, 49).addBox(-38.5462F, -16.8588F, 37.5204F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(74, 49).addBox(-32.5462F, -18.8588F, 37.5204F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.7548F, 18.584F, -48.2152F, 0.1824F, 0.2693F, 1.3226F));

		PartDefinition wingp_r7 = wing.addOrReplaceChild("wingp_r7", CubeListBuilder.create().texOffs(51, 51).addBox(-25.5462F, -20.8588F, 37.5204F, 33.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.7548F, 18.584F, -48.2152F, 0.1452F, 0.2907F, 1.1882F));

		PartDefinition wingp_r8 = wing.addOrReplaceChild("wingp_r8", CubeListBuilder.create().texOffs(96, 46).addBox(-15.5462F, -23.8588F, 37.5204F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.308F, 16.1771F, -49.5979F, -0.0961F, 0.3099F, 0.4101F));

		PartDefinition wingp_r9 = wing.addOrReplaceChild("wingp_r9", CubeListBuilder.create().texOffs(96, 46).addBox(-19.5601F, -43.9522F, 12.6245F, 10.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.308F, 12.1771F, -48.5979F, -0.8349F, 0.2947F, 0.2739F));

		PartDefinition wingp_r10 = wing.addOrReplaceChild("wingp_r10", CubeListBuilder.create().texOffs(90, 46).addBox(-16.1165F, -24.4846F, 41.0085F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.2862F, 20.8063F, -49.239F, 0.0814F, 0.2947F, 0.2739F));

		PartDefinition wingp_r11 = wing.addOrReplaceChild("wingp_r11", CubeListBuilder.create().texOffs(51, 57).addBox(-9.9171F, -30.4428F, 41.3538F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0168F, 23.6453F, -46.363F, 0.0547F, 0.3006F, 0.1828F));

		PartDefinition wingp_r12 = wing.addOrReplaceChild("wingp_r12", CubeListBuilder.create().texOffs(112, 59).addBox(-3.5F, -1.5F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.0626F, -7.5517F, -3.6435F, -0.0778F, 0.6185F, 0.5168F));

		PartDefinition wingp_r13 = wing.addOrReplaceChild("wingp_r13", CubeListBuilder.create().texOffs(110, 47).addBox(-3.1703F, -24.5962F, 38.9519F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.6664F, 8.4199F, -46.2523F, -0.1253F, 0.089F, 0.0284F));

		PartDefinition wingp_r14 = wing.addOrReplaceChild("wingp_r14", CubeListBuilder.create().texOffs(83, 49).addBox(-3.3741F, -40.3336F, 37.1692F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4363F, 24.0422F, -43.4486F, -0.1309F, 0.3054F, 0.0F));

		PartDefinition wingp_r15 = wing.addOrReplaceChild("wingp_r15", CubeListBuilder.create().texOffs(77, 49).addBox(-3.3741F, -32.0993F, 40.8538F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4363F, 24.0422F, -43.4486F, 0.0F, 0.3054F, 0.0F));

		PartDefinition wingp_r16 = wing.addOrReplaceChild("wingp_r16", CubeListBuilder.create().texOffs(72, 48).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9845F, -7.6355F, -1.8958F, -0.0681F, 0.298F, -0.2284F));

		PartDefinition wing3 = Body.addOrReplaceChild("wing3", CubeListBuilder.create().texOffs(0, 116).addBox(7.6122F, -1.7361F, -1.4667F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 119).addBox(-0.3878F, -1.7361F, -1.4667F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -40.0F, 49.0F, -0.2732F, -0.0865F, -0.7413F));

		PartDefinition wingp_r17 = wing3.addOrReplaceChild("wingp_r17", CubeListBuilder.create().texOffs(88, 86).addBox(16.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5326F, 30.3933F, -40.008F, 0.0F, 0.3054F, 0.0F));

		PartDefinition wingp_r18 = wing3.addOrReplaceChild("wingp_r18", CubeListBuilder.create().texOffs(22, 52).addBox(18.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3576F, 31.0824F, -40.2681F, -0.0547F, 0.3006F, -0.1828F));

		PartDefinition wingp_r19 = wing3.addOrReplaceChild("wingp_r19", CubeListBuilder.create().texOffs(87, 83).addBox(-30.3031F, -55.442F, 8.9077F, 3.0F, 40.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9494F, 116.7368F, -62.3566F, -0.5821F, 1.2564F, 0.0427F));

		PartDefinition wingp_r20 = wing3.addOrReplaceChild("wingp_r20", CubeListBuilder.create().texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.0984F, 31.4275F, -25.7451F, 0.5366F, 0.7419F, 0.4476F));

		PartDefinition wingp_r21 = wing3.addOrReplaceChild("wingp_r21", CubeListBuilder.create().texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.0984F, 31.4275F, -25.7451F, -0.262F, 1.1313F, 0.5378F));

		PartDefinition wingp_r22 = wing3.addOrReplaceChild("wingp_r22", CubeListBuilder.create().texOffs(87, 83).addBox(-7.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-4.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-4.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-1.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.2283F, 16.6943F, -19.8695F, 0.1342F, 0.7094F, 0.5392F));

		PartDefinition wingp_r23 = wing3.addOrReplaceChild("wingp_r23", CubeListBuilder.create().texOffs(87, 83).addBox(-2.75F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(0.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.2283F, 16.6943F, -19.8695F, 0.8743F, 1.0502F, 0.9807F));

		PartDefinition wingp_r24 = wing3.addOrReplaceChild("wingp_r24", CubeListBuilder.create().texOffs(87, 83).addBox(-23.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-26.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-23.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.969F, 51.6926F, -55.6902F, 0.1743F, 1.1313F, 0.5378F));

		PartDefinition wingp_r25 = wing3.addOrReplaceChild("wingp_r25", CubeListBuilder.create().texOffs(87, 83).addBox(-22.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.969F, 51.6926F, -55.6902F, -0.6992F, 0.9914F, -0.4423F));

		PartDefinition wingp_r26 = wing3.addOrReplaceChild("wingp_r26", CubeListBuilder.create().texOffs(88, 34).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.7293F, 68.5933F, -27.4624F, 0.0932F, 0.6551F, 0.4366F));

		PartDefinition wingp_r27 = wing3.addOrReplaceChild("wingp_r27", CubeListBuilder.create().texOffs(87, 83).addBox(10.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(5.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(0.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.3982F, 73.7436F, -23.9547F, 0.8891F, 0.8433F, 1.3715F));

		PartDefinition wingp_r28 = wing3.addOrReplaceChild("wingp_r28", CubeListBuilder.create().texOffs(87, 83).addBox(-27.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.969F, 51.6926F, -55.6902F, -0.1989F, 1.1291F, 0.1262F));

		PartDefinition wingp_r29 = wing3.addOrReplaceChild("wingp_r29", CubeListBuilder.create().texOffs(87, 83).addBox(-12.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.9402F, 14.9448F, -46.4754F, -0.3234F, 0.7468F, -0.0065F));

		PartDefinition wingp_r30 = wing3.addOrReplaceChild("wingp_r30", CubeListBuilder.create().texOffs(85, 92).addBox(17.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.1375F, 22.6296F, -44.9563F, -0.6462F, 0.2236F, -0.7654F));

		PartDefinition wingp_r31 = wing3.addOrReplaceChild("wingp_r31", CubeListBuilder.create().texOffs(95, 81).addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(46.7202F, 4.6334F, -10.1781F, -0.6898F, 0.2236F, -0.7654F));

		PartDefinition wingp_r32 = wing3.addOrReplaceChild("wingp_r32", CubeListBuilder.create().texOffs(102, 53).addBox(8.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.1375F, 22.6296F, -44.9563F, -0.0945F, 0.2909F, -0.3193F));

		PartDefinition wingp_r33 = wing3.addOrReplaceChild("wingp_r33", CubeListBuilder.create().texOffs(102, 54).addBox(18.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7625F, 27.8402F, -38.5511F, 0.0547F, 0.3006F, 0.1828F));

		PartDefinition wingp_r34 = wing3.addOrReplaceChild("wingp_r34", CubeListBuilder.create().texOffs(69, 60).addBox(20.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0438F, 30.7802F, -36.4643F, -0.0411F, 0.3027F, -0.1372F));

		PartDefinition wingp_r35 = wing3.addOrReplaceChild("wingp_r35", CubeListBuilder.create().texOffs(46, 72).addBox(-22.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0438F, 30.7802F, -36.4643F, 0.2956F, 0.0779F, 1.3206F));

		PartDefinition wingp_r36 = wing3.addOrReplaceChild("wingp_r36", CubeListBuilder.create().texOffs(49, 77).addBox(-16.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0438F, 30.7802F, -36.4643F, 0.2599F, 0.1623F, 1.0248F));

		PartDefinition wingp_r37 = wing3.addOrReplaceChild("wingp_r37", CubeListBuilder.create().texOffs(79, 59).addBox(20.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0438F, 30.7802F, -36.4643F, -0.1074F, 0.2865F, -0.3646F));

		PartDefinition wingp_r38 = wing3.addOrReplaceChild("wingp_r38", CubeListBuilder.create().texOffs(89, 98).addBox(17.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(81, 104).addBox(11.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7485F, 31.4827F, -36.8727F, 0.0F, 0.3054F, 0.0F));

		PartDefinition wing4 = Body.addOrReplaceChild("wing4", CubeListBuilder.create().texOffs(0, 116).addBox(12.579F, -2.893F, -3.9745F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 119).addBox(4.579F, -2.893F, -3.9745F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -32.0F, 45.0F, 1.4518F, -0.9572F, -1.7107F));

		PartDefinition wingp_r39 = wing4.addOrReplaceChild("wingp_r39", CubeListBuilder.create().texOffs(88, 86).addBox(16.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4994F, 29.2364F, -42.5157F, 0.0F, 0.3054F, 0.0F));

		PartDefinition wingp_r40 = wing4.addOrReplaceChild("wingp_r40", CubeListBuilder.create().texOffs(22, 52).addBox(18.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3244F, 29.9255F, -42.7758F, -0.0547F, 0.3006F, -0.1828F));

		PartDefinition wingp_r41 = wing4.addOrReplaceChild("wingp_r41", CubeListBuilder.create().texOffs(87, 83).addBox(-30.3031F, -55.442F, 8.9077F, 3.0F, 29.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0174F, 115.5798F, -64.8643F, -0.5821F, 1.2564F, 0.0427F));

		PartDefinition wingp_r42 = wing4.addOrReplaceChild("wingp_r42", CubeListBuilder.create().texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(52.0651F, 30.2705F, -28.2528F, 0.5366F, 0.7419F, 0.4476F));

		PartDefinition wingp_r43 = wing4.addOrReplaceChild("wingp_r43", CubeListBuilder.create().texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(52.0651F, 30.2705F, -28.2528F, -0.262F, 1.1313F, 0.5378F));

		PartDefinition wingp_r44 = wing4.addOrReplaceChild("wingp_r44", CubeListBuilder.create().texOffs(87, 83).addBox(-7.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-4.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-4.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-1.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.1951F, 15.5374F, -22.3772F, 0.1342F, 0.7094F, 0.5392F));

		PartDefinition wingp_r45 = wing4.addOrReplaceChild("wingp_r45", CubeListBuilder.create().texOffs(87, 83).addBox(-2.75F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(0.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.1951F, 15.5374F, -22.3772F, 0.8743F, 1.0502F, 0.9807F));

		PartDefinition wingp_r46 = wing4.addOrReplaceChild("wingp_r46", CubeListBuilder.create().texOffs(87, 83).addBox(-23.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-26.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-23.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.9358F, 50.5356F, -58.1979F, 0.1743F, 1.1313F, 0.5378F));

		PartDefinition wingp_r47 = wing4.addOrReplaceChild("wingp_r47", CubeListBuilder.create().texOffs(87, 83).addBox(-22.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.9358F, 50.5356F, -58.1979F, -0.6992F, 0.9914F, -0.4423F));

		PartDefinition wingp_r48 = wing4.addOrReplaceChild("wingp_r48", CubeListBuilder.create().texOffs(88, 34).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.6961F, 67.4363F, -29.9701F, 0.0932F, 0.6551F, 0.4366F));

		PartDefinition wingp_r49 = wing4.addOrReplaceChild("wingp_r49", CubeListBuilder.create().texOffs(87, 83).addBox(10.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(5.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(0.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.365F, 72.5866F, -26.4624F, 0.8891F, 0.8433F, 1.3715F));

		PartDefinition wingp_r50 = wing4.addOrReplaceChild("wingp_r50", CubeListBuilder.create().texOffs(87, 83).addBox(-27.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.9358F, 50.5356F, -58.1979F, -0.1989F, 1.1291F, 0.1262F));

		PartDefinition wingp_r51 = wing4.addOrReplaceChild("wingp_r51", CubeListBuilder.create().texOffs(87, 83).addBox(-12.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.907F, 13.7879F, -48.9832F, -0.3234F, 0.7468F, -0.0065F));

		PartDefinition wingp_r52 = wing4.addOrReplaceChild("wingp_r52", CubeListBuilder.create().texOffs(85, 92).addBox(17.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.1043F, 21.4727F, -47.464F, -0.6462F, 0.2236F, -0.7654F));

		PartDefinition wingp_r53 = wing4.addOrReplaceChild("wingp_r53", CubeListBuilder.create().texOffs(95, 81).addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(51.687F, 3.4764F, -12.6858F, -0.6898F, 0.2236F, -0.7654F));

		PartDefinition wingp_r54 = wing4.addOrReplaceChild("wingp_r54", CubeListBuilder.create().texOffs(102, 53).addBox(8.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.1043F, 21.4727F, -47.464F, -0.0945F, 0.2909F, -0.3193F));

		PartDefinition wingp_r55 = wing4.addOrReplaceChild("wingp_r55", CubeListBuilder.create().texOffs(102, 54).addBox(18.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2043F, 26.6832F, -41.0588F, 0.0547F, 0.3006F, 0.1828F));

		PartDefinition wingp_r56 = wing4.addOrReplaceChild("wingp_r56", CubeListBuilder.create().texOffs(69, 60).addBox(20.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.077F, 29.6232F, -38.972F, -0.0411F, 0.3027F, -0.1372F));

		PartDefinition wingp_r57 = wing4.addOrReplaceChild("wingp_r57", CubeListBuilder.create().texOffs(46, 72).addBox(-22.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.077F, 29.6232F, -38.972F, 0.2956F, 0.0779F, 1.3206F));

		PartDefinition wingp_r58 = wing4.addOrReplaceChild("wingp_r58", CubeListBuilder.create().texOffs(49, 77).addBox(-16.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.077F, 29.6232F, -38.972F, 0.2599F, 0.1623F, 1.0248F));

		PartDefinition wingp_r59 = wing4.addOrReplaceChild("wingp_r59", CubeListBuilder.create().texOffs(79, 59).addBox(20.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.077F, 29.6232F, -38.972F, -0.1074F, 0.2865F, -0.3646F));

		PartDefinition wingp_r60 = wing4.addOrReplaceChild("wingp_r60", CubeListBuilder.create().texOffs(89, 98).addBox(17.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(81, 104).addBox(11.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7817F, 30.3257F, -39.3804F, 0.0F, 0.3054F, 0.0F));

		PartDefinition wing6 = Body.addOrReplaceChild("wing6", CubeListBuilder.create().texOffs(0, 116).mirror().addBox(-19.7368F, -0.6218F, -1.3919F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1, 119).mirror().addBox(-11.7368F, -0.6218F, -1.3919F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -39.0F, 47.0F, 1.1188F, 0.882F, 1.2944F));

		PartDefinition wingp_r61 = wing6.addOrReplaceChild("wingp_r61", CubeListBuilder.create().texOffs(88, 86).mirror().addBox(-22.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.6573F, 31.5076F, -39.9331F, 0.0F, -0.3054F, 0.0F));

		PartDefinition wingp_r62 = wing6.addOrReplaceChild("wingp_r62", CubeListBuilder.create().texOffs(22, 52).mirror().addBox(-21.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.4822F, 32.1967F, -40.1933F, -0.0547F, -0.3006F, 0.1828F));

		PartDefinition wingp_r63 = wing6.addOrReplaceChild("wingp_r63", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(27.3031F, -55.442F, 8.9077F, 3.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1753F, 117.8511F, -62.2817F, -0.5821F, -1.2564F, -0.0427F));

		PartDefinition wingp_r64 = wing6.addOrReplaceChild("wingp_r64", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-51.223F, 32.5418F, -25.6702F, 0.5366F, -0.7419F, -0.4476F));

		PartDefinition wingp_r65 = wing6.addOrReplaceChild("wingp_r65", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-51.223F, 32.5418F, -25.6702F, -0.262F, -1.1313F, -0.5378F));

		PartDefinition wingp_r66 = wing6.addOrReplaceChild("wingp_r66", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(3.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(3.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(0.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(0.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-53.3529F, 17.8086F, -19.7946F, 0.1342F, -0.7094F, -0.5392F));

		PartDefinition wingp_r67 = wing6.addOrReplaceChild("wingp_r67", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-1.25F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-1.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-53.3529F, 17.8086F, -19.7946F, 0.8743F, -1.0502F, -0.9807F));

		PartDefinition wingp_r68 = wing6.addOrReplaceChild("wingp_r68", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(22.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(22.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(19.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-29.0936F, 52.8069F, -55.6153F, 0.1743F, -1.1313F, -0.5378F));

		PartDefinition wingp_r69 = wing6.addOrReplaceChild("wingp_r69", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(19.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-29.0936F, 52.8069F, -55.6153F, -0.6992F, -0.9914F, 0.4423F));

		PartDefinition wingp_r70 = wing6.addOrReplaceChild("wingp_r70", CubeListBuilder.create().texOffs(88, 34).mirror().addBox(-1.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-39.8539F, 69.7075F, -27.3876F, 0.0932F, -0.6551F, -0.4366F));

		PartDefinition wingp_r71 = wing6.addOrReplaceChild("wingp_r71", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-11.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-7.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-2.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-34.5228F, 74.8578F, -23.8798F, 0.8891F, -0.8433F, -1.3715F));

		PartDefinition wingp_r72 = wing6.addOrReplaceChild("wingp_r72", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(20.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-29.0936F, 52.8069F, -55.6153F, -0.1989F, -1.1291F, -0.1262F));

		PartDefinition wingp_r73 = wing6.addOrReplaceChild("wingp_r73", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(5.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-35.0648F, 16.0591F, -46.4006F, -0.3234F, -0.7468F, 0.0065F));

		PartDefinition wingp_r74 = wing6.addOrReplaceChild("wingp_r74", CubeListBuilder.create().texOffs(85, 92).mirror().addBox(-24.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.2621F, 23.7439F, -44.8814F, -0.6462F, -0.2236F, 0.7654F));

		PartDefinition wingp_r75 = wing6.addOrReplaceChild("wingp_r75", CubeListBuilder.create().texOffs(95, 81).mirror().addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-50.8448F, 5.7476F, -10.1033F, -0.6898F, -0.2236F, 0.7654F));

		PartDefinition wingp_r76 = wing6.addOrReplaceChild("wingp_r76", CubeListBuilder.create().texOffs(102, 53).mirror().addBox(-17.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.2621F, 23.7439F, -44.8814F, -0.0945F, -0.2909F, 0.3193F));

		PartDefinition wingp_r77 = wing6.addOrReplaceChild("wingp_r77", CubeListBuilder.create().texOffs(102, 54).mirror().addBox(-26.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3621F, 28.9545F, -38.4763F, 0.0547F, -0.3006F, -0.1828F));

		PartDefinition wingp_r78 = wing6.addOrReplaceChild("wingp_r78", CubeListBuilder.create().texOffs(69, 60).mirror().addBox(-27.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9192F, 31.8944F, -36.3894F, -0.0411F, -0.3027F, 0.1372F));

		PartDefinition wingp_r79 = wing6.addOrReplaceChild("wingp_r79", CubeListBuilder.create().texOffs(46, 72).mirror().addBox(19.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9192F, 31.8944F, -36.3894F, 0.2956F, -0.0779F, -1.3206F));

		PartDefinition wingp_r80 = wing6.addOrReplaceChild("wingp_r80", CubeListBuilder.create().texOffs(49, 77).mirror().addBox(11.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9192F, 31.8944F, -36.3894F, 0.2599F, -0.1623F, -1.0248F));

		PartDefinition wingp_r81 = wing6.addOrReplaceChild("wingp_r81", CubeListBuilder.create().texOffs(79, 59).mirror().addBox(-26.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9192F, 31.8944F, -36.3894F, -0.1074F, -0.2865F, 0.3646F));

		PartDefinition wingp_r82 = wing6.addOrReplaceChild("wingp_r82", CubeListBuilder.create().texOffs(89, 98).mirror().addBox(-24.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(81, 104).mirror().addBox(-17.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6239F, 32.597F, -36.7979F, 0.0F, -0.3054F, 0.0F));

		PartDefinition wing5 = Body.addOrReplaceChild("wing5", CubeListBuilder.create().texOffs(1, 119).mirror().addBox(-10.6865F, -2.5968F, 1.1424F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -38.0F, 46.0F, -0.2732F, 0.0865F, 0.7413F));

		PartDefinition wingp_r83 = wing5.addOrReplaceChild("wingp_r83", CubeListBuilder.create().texOffs(88, 86).mirror().addBox(-22.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.607F, 29.5326F, -37.3989F, 0.0F, -0.3054F, 0.0F));

		PartDefinition wingp_r84 = wing5.addOrReplaceChild("wingp_r84", CubeListBuilder.create().texOffs(22, 52).mirror().addBox(-21.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.432F, 30.2217F, -37.659F, -0.0547F, -0.3006F, 0.1828F));

		PartDefinition wingp_r85 = wing5.addOrReplaceChild("wingp_r85", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(27.3031F, -55.442F, 8.9077F, 3.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.125F, 115.8761F, -59.7474F, -0.5821F, -1.2564F, -0.0427F));

		PartDefinition wingp_r86 = wing5.addOrReplaceChild("wingp_r86", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-50.1727F, 30.5668F, -23.1359F, 0.5366F, -0.7419F, -0.4476F));

		PartDefinition wingp_r87 = wing5.addOrReplaceChild("wingp_r87", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-50.1727F, 30.5668F, -23.1359F, -0.262F, -1.1313F, -0.5378F));

		PartDefinition wingp_r88 = wing5.addOrReplaceChild("wingp_r88", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(3.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(3.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(0.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(0.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-52.3027F, 15.8336F, -17.2603F, 0.1342F, -0.7094F, -0.5392F));

		PartDefinition wingp_r89 = wing5.addOrReplaceChild("wingp_r89", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-1.25F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-1.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-52.3027F, 15.8336F, -17.2603F, 0.8743F, -1.0502F, -0.9807F));

		PartDefinition wingp_r90 = wing5.addOrReplaceChild("wingp_r90", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(22.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(22.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(19.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.0433F, 50.8319F, -53.081F, 0.1743F, -1.1313F, -0.5378F));

		PartDefinition wingp_r91 = wing5.addOrReplaceChild("wingp_r91", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(19.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.0433F, 50.8319F, -53.081F, -0.6992F, -0.9914F, 0.4423F));

		PartDefinition wingp_r92 = wing5.addOrReplaceChild("wingp_r92", CubeListBuilder.create().texOffs(78, 12).mirror().addBox(3.0F, 1.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(88, 34).mirror().addBox(-1.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-38.8036F, 67.7325F, -24.8533F, 0.0932F, -0.6551F, -0.4366F));

		PartDefinition wingp_r93 = wing5.addOrReplaceChild("wingp_r93", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(-11.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-7.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-2.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(87, 83).mirror().addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-33.4725F, 72.8828F, -21.3455F, 0.8891F, -0.8433F, -1.3715F));

		PartDefinition wingp_r94 = wing5.addOrReplaceChild("wingp_r94", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(20.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.0433F, 50.8319F, -53.081F, -0.1989F, -1.1291F, -0.1262F));

		PartDefinition wingp_r95 = wing5.addOrReplaceChild("wingp_r95", CubeListBuilder.create().texOffs(87, 83).mirror().addBox(5.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-34.0145F, 14.0841F, -43.8663F, -0.3234F, -0.7468F, 0.0065F));

		PartDefinition wingp_r96 = wing5.addOrReplaceChild("wingp_r96", CubeListBuilder.create().texOffs(85, 92).mirror().addBox(-24.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.2118F, 21.7689F, -42.3471F, -0.6462F, -0.2236F, 0.7654F));

		PartDefinition wingp_r97 = wing5.addOrReplaceChild("wingp_r97", CubeListBuilder.create().texOffs(110, 57).mirror().addBox(-24.5299F, -15.8497F, 37.2448F, 7.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.2118F, 21.7689F, -42.3471F, -0.3408F, -0.2236F, 0.7654F));

		PartDefinition wingp_r98 = wing5.addOrReplaceChild("wingp_r98", CubeListBuilder.create().texOffs(110, 57).mirror().addBox(-17.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.2118F, 21.7689F, -42.3471F, -0.0945F, -0.2909F, 0.3193F));

		PartDefinition wingp_r99 = wing5.addOrReplaceChild("wingp_r99", CubeListBuilder.create().texOffs(110, 57).mirror().addBox(-26.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3118F, 26.9795F, -35.942F, 0.0547F, -0.3006F, -0.1828F));

		PartDefinition wingp_r100 = wing5.addOrReplaceChild("wingp_r100", CubeListBuilder.create().texOffs(69, 60).mirror().addBox(-27.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9694F, 29.9194F, -33.8552F, -0.0411F, -0.3027F, 0.1372F));

		PartDefinition wingp_r101 = wing5.addOrReplaceChild("wingp_r101", CubeListBuilder.create().texOffs(44, 62).mirror().addBox(2.8216F, -30.2909F, 40.6994F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9694F, 29.9194F, -33.8552F, 0.2194F, -0.2143F, -0.8091F));

		PartDefinition wingp_r102 = wing5.addOrReplaceChild("wingp_r102", CubeListBuilder.create().texOffs(71, 87).mirror().addBox(25.7835F, -22.0003F, 40.6994F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9694F, 29.9194F, -33.8552F, 0.2956F, -0.0779F, -1.3206F));

		PartDefinition wingp_r103 = wing5.addOrReplaceChild("wingp_r103", CubeListBuilder.create().texOffs(89, 98).mirror().addBox(-24.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(81, 104).mirror().addBox(-17.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.6741F, 30.622F, -34.2636F, 0.0F, -0.3054F, 0.0F));

		PartDefinition wing2 = Body.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(80, 88).mirror().addBox(-13.5759F, -7.7205F, -0.4613F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(94, 88).mirror().addBox(-5.5759F, -4.7205F, -0.4613F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -35.0F, 46.0F, 0.0F, 0.3054F, 0.0436F));

		PartDefinition wingp_r104 = wing2.addOrReplaceChild("wingp_r104", CubeListBuilder.create().texOffs(114, 77).mirror().addBox(17.1993F, -23.7371F, 39.1978F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9055F, 24.4485F, -45.5459F, 0.1074F, -0.2865F, -0.3646F));

		PartDefinition wingp_r105 = wing2.addOrReplaceChild("wingp_r105", CubeListBuilder.create().texOffs(112, 74).mirror().addBox(19.9602F, -2.0205F, 38.7346F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-33.2302F, 16.4891F, -47.3696F, 0.237F, -0.1945F, -0.8959F));

		PartDefinition wingp_r106 = wing2.addOrReplaceChild("wingp_r106", CubeListBuilder.create().texOffs(112, 74).mirror().addBox(8.6993F, -25.2371F, 38.6978F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.504F, 24.1462F, -41.7421F, 0.1074F, -0.2865F, -0.3646F));

		PartDefinition wingp_r107 = wing2.addOrReplaceChild("wingp_r107", CubeListBuilder.create().texOffs(69, 60).mirror().addBox(-0.826F, -30.0364F, 38.6978F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.504F, 24.1462F, -41.7421F, -0.0411F, -0.3027F, 0.1372F));

		PartDefinition wingp_r108 = wing2.addOrReplaceChild("wingp_r108", CubeListBuilder.create().texOffs(50, 78).mirror().addBox(27.2866F, -16.3126F, 39.6978F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-23.1316F, 28.7978F, -45.1956F, 0.1896F, -0.2409F, -0.6775F));

		PartDefinition wingp_r109 = wing2.addOrReplaceChild("wingp_r109", CubeListBuilder.create().texOffs(18, 39).mirror().addBox(17.6818F, -21.4658F, 38.6978F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.504F, 24.1462F, -41.7421F, 0.1325F, -0.276F, -0.4548F));

		PartDefinition wingp_r110 = wing2.addOrReplaceChild("wingp_r110", CubeListBuilder.create().texOffs(79, 59).mirror().addBox(-0.8692F, -30.2745F, 38.6978F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.504F, 24.1462F, -41.7421F, -0.1074F, -0.2865F, 0.3646F));

		PartDefinition wingp_r111 = wing2.addOrReplaceChild("wingp_r111", CubeListBuilder.create().texOffs(73, 49).mirror().addBox(11.2213F, -23.846F, 38.8526F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.5192F, 21.0254F, -46.6386F, 0.0814F, -0.2947F, -0.2739F));

		PartDefinition wingp_r112 = wing2.addOrReplaceChild("wingp_r112", CubeListBuilder.create().texOffs(17, 81).mirror().addBox(14.2474F, -26.1966F, 38.8526F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.5192F, 21.0254F, -46.6386F, 0.0411F, -0.3027F, -0.1372F));

		PartDefinition wingp_r113 = wing2.addOrReplaceChild("wingp_r113", CubeListBuilder.create().texOffs(19, 51).mirror().addBox(3.2118F, -32.5692F, 38.6978F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 47).mirror().addBox(10.2118F, -32.5692F, 38.6978F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.7993F, 24.8487F, -42.1505F, 0.0F, -0.3054F, 0.0F));

		PartDefinition bone = wing2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 108).mirror().addBox(-22.6113F, -57.3838F, 41.2479F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 108).mirror().addBox(-28.6113F, -57.3838F, 40.2479F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.86F, 49.7243F, -43.2947F));

		PartDefinition wingp_r114 = bone.addOrReplaceChild("wingp_r114", CubeListBuilder.create().texOffs(106, 109).mirror().addBox(-16.2253F, -28.8838F, 42.2255F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(76, 97).mirror().addBox(-23.2253F, -29.8838F, 42.2255F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5604F, -28.5F, 3.1442F, 0.0F, -0.3054F, 0.0F));

		PartDefinition wingp_r115 = bone.addOrReplaceChild("wingp_r115", CubeListBuilder.create().texOffs(76, 97).mirror().addBox(-16.0124F, -15.3504F, 41.3952F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.4969F, -40.8207F, -0.0641F, -0.1325F, -0.276F, 0.4548F));

		PartDefinition wingp_r116 = bone.addOrReplaceChild("wingp_r116", CubeListBuilder.create().texOffs(79, 59).mirror().addBox(-24.4515F, -17.7693F, 42.2255F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2651F, -29.2026F, 3.5526F, -0.1074F, -0.2865F, 0.3646F));

		PartDefinition wingp_r117 = bone.addOrReplaceChild("wingp_r117", CubeListBuilder.create().texOffs(69, 60).mirror().addBox(-26.5559F, -22.9318F, 42.2255F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.2651F, -29.2026F, 3.5526F, -0.0411F, -0.3027F, 0.1372F));

		PartDefinition wingp_r118 = bone.addOrReplaceChild("wingp_r118", CubeListBuilder.create().texOffs(114, 74).mirror().addBox(-8.9039F, -30.316F, 42.7255F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.6666F, -28.9003F, -0.2512F, 0.1074F, -0.2865F, -0.3646F));

		PartDefinition wingp_r119 = bone.addOrReplaceChild("wingp_r119", CubeListBuilder.create().texOffs(104, 50).mirror().addBox(-13.9429F, -32.6795F, 40.7255F, 6.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(110, 50).mirror().addBox(-16.9429F, -26.6795F, 42.7255F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.6726F, -30.7533F, -1.8296F, 0.0547F, -0.3006F, -0.1828F));

		PartDefinition wingp_r120 = bone.addOrReplaceChild("wingp_r120", CubeListBuilder.create().texOffs(104, 50).mirror().addBox(-14.5916F, -27.4737F, 40.7255F, 6.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.9906F, -35.9238F, -1.9299F, 0.1564F, -0.2635F, -0.5444F));

		PartDefinition wingp_r121 = bone.addOrReplaceChild("wingp_r121", CubeListBuilder.create().texOffs(99, 50).mirror().addBox(-0.5F, -3.0F, -0.5F, 11.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-54.9502F, -54.1709F, 31.322F, 0.288F, -0.103F, -1.2367F));

		PartDefinition wingp_r122 = bone.addOrReplaceChild("wingp_r122", CubeListBuilder.create().texOffs(99, 50).mirror().addBox(-5.5F, -3.0F, -1.5F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-54.9502F, -54.1709F, 31.322F, 0.2194F, -0.2143F, -0.8091F));

		PartDefinition wingp_r123 = bone.addOrReplaceChild("wingp_r123", CubeListBuilder.create().texOffs(102, 50).mirror().addBox(-32.2342F, -13.3239F, 39.3952F, 18.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-57.7622F, -15.6241F, -12.4444F, 0.3043F, 0.0262F, -1.654F));

		PartDefinition wingp_r124 = bone.addOrReplaceChild("wingp_r124", CubeListBuilder.create().texOffs(102, 50).mirror().addBox(-41.2342F, -13.3239F, 38.3952F, 22.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(102, 50).mirror().addBox(-26.2342F, -13.3239F, 39.3952F, 40.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-44.8777F, -30.621F, -8.382F, 0.2921F, -0.0905F, -1.2787F));

		PartDefinition wingp_r125 = bone.addOrReplaceChild("wingp_r125", CubeListBuilder.create().texOffs(102, 50).mirror().addBox(5.7658F, -18.3239F, 39.3952F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-44.8777F, -30.621F, -8.382F, 0.2194F, -0.2143F, -0.8091F));

		PartDefinition wingp_r126 = bone.addOrReplaceChild("wingp_r126", CubeListBuilder.create().texOffs(105, 50).mirror().addBox(-10.3797F, -18.4825F, 41.3952F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-35.9625F, -33.5023F, -5.571F, 0.0411F, -0.3027F, -0.1372F));

		PartDefinition wingp_r127 = bone.addOrReplaceChild("wingp_r127", CubeListBuilder.create().texOffs(110, 50).mirror().addBox(9.8504F, -16.0124F, 41.3952F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-31.9312F, -38.7829F, -4.2999F, 0.2783F, -0.1274F, -1.1523F));

		PartDefinition wingp_r128 = bone.addOrReplaceChild("wingp_r128", CubeListBuilder.create().texOffs(13, 39).mirror().addBox(-23.1059F, -30.0864F, 42.7255F, 6.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.6666F, -28.9003F, -0.2512F, -0.0547F, -0.3006F, 0.1828F));

		PartDefinition wingp_r129 = bone.addOrReplaceChild("wingp_r129", CubeListBuilder.create().texOffs(46, 65).mirror().addBox(-29.1453F, -13.7364F, 42.7255F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.1783F, -33.1331F, -0.7279F, -0.1564F, -0.2635F, 0.5444F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -45.0F, 40.0F, -0.2084F, 0.0651F, 0.2986F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(82, 2).addBox(-33.7474F, 0.1733F, 36.5061F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6876F, 37.3271F, -33.8561F, 0.0436F, -0.1745F, 1.4399F));

		PartDefinition Rightbacktlib = RightArm.addOrReplaceChild("Rightbacktlib", CubeListBuilder.create(), PartPose.offset(6.6876F, 41.0862F, -33.1021F));

		PartDefinition RightArm_r2 = Rightbacktlib.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(86, 15).addBox(-10.6789F, -37.3519F, 34.4936F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.644F, 3.0686F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Rightfrontlib = Rightbacktlib.addOrReplaceChild("Rightfrontlib", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm_r3 = Rightfrontlib.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(124, 20).addBox(-30.0155F, -39.8288F, 2.094F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0905F, 13.6249F, -1.1438F, -0.3775F, 0.9144F, -0.0465F));

		PartDefinition RightArm_r4 = Rightfrontlib.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(123, 10).addBox(-43.4207F, -32.5636F, 2.094F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9978F, 13.9978F, -1.4862F, 0.1665F, 0.9578F, 0.6202F));

		PartDefinition RightArm_r5 = Rightfrontlib.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(121, 6).addBox(-9.8838F, -40.0308F, 18.2488F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.647F, 5.6035F, -0.8624F, -0.3463F, -0.0447F, 0.0951F));

		PartDefinition RightArm_r6 = Rightfrontlib.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(121, 6).addBox(-24.9895F, -37.6771F, 18.2488F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.8017F, -1.1584F, -0.3414F, 0.0741F, 0.4236F));

		PartDefinition RightArm_r7 = Rightfrontlib.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(124, 11).addBox(14.7314F, -52.0427F, 6.3588F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3299F, 10.8257F, -6.8058F, -0.6378F, -0.1582F, -0.384F));

		PartDefinition RightArm_r8 = Rightfrontlib.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(124, 11).addBox(14.7314F, -39.2767F, -14.3771F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2245F, 9.153F, -1.7002F, -1.0742F, -0.1582F, -0.384F));

		PartDefinition RightArm_r9 = Rightfrontlib.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(119, 13).addBox(27.0665F, -36.6865F, -10.9138F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4611F, 9.253F, -1.7553F, -0.9234F, -0.3332F, -0.6425F));

		PartDefinition RightArm_r10 = Rightfrontlib.addOrReplaceChild("RightArm_r10", CubeListBuilder.create().texOffs(124, 12).addBox(27.0665F, -42.7946F, 3.6298F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.268F, 8.3751F, -2.8286F, -0.5744F, -0.3332F, -0.6425F));

		PartDefinition RightArm_r11 = Rightfrontlib.addOrReplaceChild("RightArm_r11", CubeListBuilder.create().texOffs(124, 11).addBox(-8.4636F, -38.7291F, 14.0752F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0663F, 11.0304F, -1.1285F, -0.5251F, -0.0113F, 0.087F));

		PartDefinition RightArm_r12 = Rightfrontlib.addOrReplaceChild("RightArm_r12", CubeListBuilder.create().texOffs(124, 11).addBox(-8.4636F, -41.1675F, 23.2516F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0197F, 10.7748F, -3.2782F, -0.3069F, -0.0113F, 0.087F));

		PartDefinition RightArm_r13 = Rightfrontlib.addOrReplaceChild("RightArm_r13", CubeListBuilder.create().texOffs(124, 11).addBox(-8.4636F, -37.1715F, 37.2453F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0774F, 11.6115F, -4.6201F, 0.0421F, -0.0113F, 0.087F));

		PartDefinition RightArm_r14 = Rightfrontlib.addOrReplaceChild("RightArm_r14", CubeListBuilder.create().texOffs(88, 21).addBox(-7.6789F, -43.6304F, 16.5265F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 27).addBox(-7.6789F, -53.6304F, 15.5265F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8017F, -1.1584F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(9.4442F, -45.8343F, 40.5698F, 0.1939F, 0.0796F, -0.3849F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(82, 2).addBox(28.1333F, 3.0066F, 39.7672F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.248F, 20.2496F, -47.8111F, 0.0436F, -0.2182F, -1.4399F));

		PartDefinition Leftlib = LeftArm.addOrReplaceChild("Leftlib", CubeListBuilder.create(), PartPose.offset(-5.1365F, 26.1147F, -47.7055F));

		PartDefinition LeftArm_r2 = Leftlib.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(86, 0).addBox(-2.0F, 2.5F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9959F, -23.788F, 46.7572F, -0.6965F, -0.0436F, -0.0756F));

		PartDefinition LeftArm_r3 = Leftlib.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(88, 14).addBox(4.9959F, -32.0915F, 40.4371F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Leftfrontlib = Leftlib.addOrReplaceChild("Leftfrontlib", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -2.0F));

		PartDefinition LeftArm_r4 = Leftfrontlib.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(89, 21).addBox(5.9959F, -45.6804F, 12.1304F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0829F, -3.6691F, -0.8727F, 0.0F, 0.0F));

		PartDefinition LeftArm_r5 = Leftfrontlib.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(122, 12).addBox(-47.0698F, 13.8534F, 14.4989F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9445F, 13.4316F, -16.3494F, 0.1035F, 0.8681F, 2.0115F));

		PartDefinition LeftArm_r6 = Leftfrontlib.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(124, 12).addBox(-33.7414F, -29.1444F, 14.4989F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4582F, 7.3186F, -11.0091F, -0.6779F, 0.6002F, 0.9172F));

		PartDefinition LeftArm_r7 = Leftfrontlib.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(120, 2).addBox(-16.5258F, -46.5101F, 14.4989F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1606F, 6.4973F, -10.6558F, -0.8335F, 0.2975F, 0.5656F));

		PartDefinition LeftArm_r8 = Leftfrontlib.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(120, 2).addBox(12.0832F, -48.2261F, 14.4989F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.393F, 3.4677F, -6.9372F, -0.8608F, -0.1666F, 0.1639F));

		PartDefinition LeftArm_r9 = Leftfrontlib.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(124, 11).addBox(-22.3077F, -36.6912F, 18.486F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8957F, 9.0511F, -13.7826F, -0.6842F, 0.494F, 0.4289F));

		PartDefinition LeftArm_r10 = Leftfrontlib.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(124, 11).addBox(-7.2726F, -44.4883F, 17.4069F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(124, 11).addBox(-8.2726F, -49.4883F, 17.4069F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.193F, 10.9341F, -16.3847F, -0.8016F, 0.2007F, 0.2975F));

		PartDefinition LeftArm_r11 = Leftfrontlib.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(124, 11).addBox(7.9251F, -49.3732F, 17.4069F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3558F, 7.8434F, -12.9522F, -0.8196F, -0.0535F, 0.057F));

		PartDefinition LeftArm_r12 = Leftfrontlib.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(120, 2).addBox(23.987F, -40.9063F, 8.3178F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3084F, 1.5147F, -3.6691F, -0.8745F, -0.4493F, 0.114F));

		PartDefinition LeftArm_r13 = Leftfrontlib.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(124, 11).addBox(-2.1724F, -49.6814F, 18.486F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2743F, 8.8434F, -13.3917F, -0.8071F, 0.1643F, 0.0577F));

		PartDefinition LeftArm_r14 = Leftfrontlib.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(120, 2).addBox(15.0856F, -43.8174F, 12.2559F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3084F, 2.5147F, -3.6691F, -0.8492F, -0.2324F, 0.1055F));

		PartDefinition LeftArm_r15 = Leftfrontlib.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(96, 7).addBox(-39.4262F, -17.636F, 9.0401F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4042F, 5.8592F, -6.8251F, -0.649F, 0.7759F, 0.8367F));

		PartDefinition LeftArm_r16 = Leftfrontlib.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(94, 12).addBox(-25.0429F, -34.0619F, 9.0401F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.958F, 3.1638F, -3.2644F, -0.8645F, 0.5029F, 0.4813F));

		PartDefinition LeftArm_r17 = Leftfrontlib.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(122, 11).addBox(-2.763F, -47.3765F, 9.0401F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0829F, -3.6691F, -0.9609F, 0.12F, 0.1746F));

		PartDefinition LeftArm_r18 = Leftfrontlib.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(97, 8).addBox(-34.8831F, -32.4854F, 9.0662F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2826F, 7.6205F, -4.3097F, -0.6276F, 0.6532F, 0.6973F));

		PartDefinition LeftArm_r19 = Leftfrontlib.addOrReplaceChild("LeftArm_r19", CubeListBuilder.create().texOffs(122, 12).addBox(-15.445F, -46.8218F, 9.0662F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0829F, -3.6691F, -0.8239F, 0.3297F, 0.2912F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 10.0F, 0.0F, 0.192F, 0.0F, 0.0349F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(75, 89).addBox(-13.1432F, -35.2792F, 22.9807F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7064F, 9.4918F, -4.5178F, -0.5857F, 0.1676F, 0.4395F));

		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(78, 90).addBox(-5.5465F, -44.2165F, 22.9807F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7064F, 9.4918F, -4.5178F, -0.605F, 0.045F, 0.258F));

		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(78, 90).addBox(-24.2554F, -10.7807F, 37.1827F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.6983F, 6.5502F, -0.7084F, 0.0433F, 0.62F, 0.0014F));

		PartDefinition RightLeg_r4 = RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(78, 90).addBox(23.5665F, -24.5984F, 38.7417F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 90).addBox(22.5665F, -19.5984F, 37.7417F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.224F, 11.3943F, -4.8532F, -0.6015F, -0.1664F, -1.8806F));

		PartDefinition RightLeg_r5 = RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(78, 90).addBox(-6.4235F, -20.4145F, 40.5014F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 90).addBox(-7.4235F, -35.4145F, 39.5014F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6252F, 1.4955F, -3.161F, -0.1687F, 0.045F, 0.258F));

		PartDefinition RightLeg_r6 = RightLeg.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(85, 69).addBox(-0.0186F, -31.8324F, 21.6098F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 75).addBox(-0.0186F, -41.8324F, 20.6098F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 90).addBox(-2.0186F, -50.8324F, 19.6098F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 6.9621F, -0.3814F, -0.5236F, 0.0F, 0.0F));

		PartDefinition RightLeg_r7 = RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(85, 69).addBox(-0.0186F, -26.8324F, 20.6098F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 1.2504F, -1.1762F, -0.5236F, 0.0F, 0.0F));

		PartDefinition RightLeg_r8 = RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(91, 76).addBox(-0.0186F, -46.5234F, 3.7575F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 6.9621F, -0.3814F, -0.9163F, 0.0F, 0.0F));

		PartDefinition RightLeg_r9 = RightLeg.addOrReplaceChild("RightLeg_r9", CubeListBuilder.create().texOffs(56, 67).addBox(-16.0654F, -30.2106F, 24.6098F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3402F, 12.0249F, -3.3044F, -0.49F, 0.1925F, 0.3444F));

		PartDefinition RightLeg_r10 = RightLeg.addOrReplaceChild("RightLeg_r10", CubeListBuilder.create().texOffs(56, 67).addBox(-6.3399F, -31.8699F, 24.6098F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 67).addBox(-5.3399F, -31.8699F, 21.6098F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0327F, 6.189F, 0.0649F, -0.5219F, 0.0436F, 0.0756F));

		PartDefinition RightLeg_r11 = RightLeg.addOrReplaceChild("RightLeg_r11", CubeListBuilder.create().texOffs(56, 67).addBox(27.3234F, -15.3004F, 21.6098F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0078F, 5.2056F, 0.6327F, -0.338F, -0.4079F, -0.8458F));

		PartDefinition RightLeg_r12 = RightLeg.addOrReplaceChild("RightLeg_r12", CubeListBuilder.create().texOffs(56, 67).addBox(-11.9291F, -36.0782F, 20.6098F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 6.9621F, -0.3814F, -0.5087F, 0.1298F, 0.228F));

		PartDefinition RightLeg_r13 = RightLeg.addOrReplaceChild("RightLeg_r13", CubeListBuilder.create().texOffs(78, 90).addBox(-6.8116F, -21.6578F, 41.1292F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 6.9621F, -0.3814F, -0.0859F, 0.0151F, 0.1739F));

		PartDefinition RightLeg_r14 = RightLeg.addOrReplaceChild("RightLeg_r14", CubeListBuilder.create().texOffs(78, 90).addBox(-1.0186F, -21.6238F, 41.1292F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 90).addBox(-2.0186F, -36.6238F, 41.1292F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9698F, 6.9621F, -0.3814F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg_r15 = RightLeg.addOrReplaceChild("RightLeg_r15", CubeListBuilder.create().texOffs(78, 90).addBox(-43.4692F, -22.8682F, 14.6725F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6104F, 9.8624F, 3.2851F, -0.0436F, 1.3526F, -0.2618F));

		PartDefinition RightLeg_r16 = RightLeg.addOrReplaceChild("RightLeg_r16", CubeListBuilder.create().texOffs(78, 90).addBox(-43.4692F, -13.9056F, 18.1899F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6104F, 9.8624F, 3.2851F, 0.1309F, 1.3526F, -0.2618F));

		PartDefinition RightLeg_r17 = RightLeg.addOrReplaceChild("RightLeg_r17", CubeListBuilder.create().texOffs(78, 90).addBox(10.0964F, -22.2067F, 41.0824F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1396F, 11.3321F, 3.3805F, -0.1605F, -0.4269F, 0.6748F));

		PartDefinition RightLeg_r18 = RightLeg.addOrReplaceChild("RightLeg_r18", CubeListBuilder.create().texOffs(78, 90).addBox(21.0077F, -13.3996F, 41.0824F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1396F, 11.3321F, 3.3805F, 0.1309F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r19 = RightLeg.addOrReplaceChild("RightLeg_r19", CubeListBuilder.create().texOffs(78, 90).addBox(20.5077F, -6.4037F, 42.5962F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4837F, 10.8326F, 3.6585F, 0.3054F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r20 = RightLeg.addOrReplaceChild("RightLeg_r20", CubeListBuilder.create().texOffs(78, 90).addBox(20.0077F, -15.0187F, 38.2899F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1396F, -0.1569F, 3.8821F, -0.0436F, -0.4363F, 0.0F));

		PartDefinition RightLeg_r21 = RightLeg.addOrReplaceChild("RightLeg_r21", CubeListBuilder.create().texOffs(78, 90).addBox(39.2158F, -23.673F, 18.5959F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1396F, -0.1569F, 3.8821F, 0.1815F, -1.1101F, 0.0283F));

		PartDefinition RightLeg_r22 = RightLeg.addOrReplaceChild("RightLeg_r22", CubeListBuilder.create().texOffs(78, 90).addBox(-0.5521F, -13.1206F, 46.1594F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8773F, 15.1257F, 3.8799F, 0.1265F, -0.0338F, 0.2597F));

		PartDefinition RightLeg_r23 = RightLeg.addOrReplaceChild("RightLeg_r23", CubeListBuilder.create().texOffs(78, 90).addBox(1.0908F, -12.7312F, 46.1594F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1396F, 11.3321F, 3.3805F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightLeg_r24 = RightLeg.addOrReplaceChild("RightLeg_r24", CubeListBuilder.create().texOffs(78, 90).addBox(0.0908F, -15.2421F, 43.4058F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1396F, -0.1569F, 3.8821F, -0.0436F, 0.0F, 0.0F));

		PartDefinition RightLeg_r25 = RightLeg.addOrReplaceChild("RightLeg_r25", CubeListBuilder.create().texOffs(78, 90).addBox(0.0908F, -14.9753F, 46.2872F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1396F, -0.1569F, 3.8821F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9F, 9.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));

		PartDefinition LeftLeg_r1 = LeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(101, 92).addBox(18.9626F, -42.8004F, 30.4187F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4518F, -5.8791F, -0.121F, -0.05F, -0.3897F));

		PartDefinition LeftLeg_r2 = LeftLeg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(96, 35).addBox(-25.2418F, -25.4112F, -32.279F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6013F, 12.3738F, -6.1697F, 3.0256F, 0.3201F, 2.7968F));

		PartDefinition LeftLeg_r3 = LeftLeg.addOrReplaceChild("LeftLeg_r3", CubeListBuilder.create().texOffs(101, 92).addBox(-37.2252F, -11.9163F, -27.5345F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5372F, 12.4623F, -6.2034F, 3.0268F, 0.305F, 2.2461F));

		PartDefinition LeftLeg_r4 = LeftLeg.addOrReplaceChild("LeftLeg_r4", CubeListBuilder.create().texOffs(101, 92).addBox(-31.6911F, -25.8124F, -27.5345F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5372F, 12.4623F, -6.2034F, -3.1269F, 0.3249F, 2.6589F));

		PartDefinition LeftLeg_r5 = LeftLeg.addOrReplaceChild("LeftLeg_r5", CubeListBuilder.create().texOffs(101, 92).addBox(-17.7405F, -37.973F, -27.5345F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5372F, 12.4623F, -6.2034F, -2.9871F, 0.2874F, 3.1152F));

		PartDefinition LeftLeg_r6 = LeftLeg.addOrReplaceChild("LeftLeg_r6", CubeListBuilder.create().texOffs(101, 92).addBox(-28.2418F, -38.8192F, -27.5345F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(101, 92).addBox(-26.2418F, -37.8192F, -27.5345F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6013F, 12.3738F, -6.1697F, -3.0831F, 0.3201F, 2.7968F));

		PartDefinition LeftLeg_r7 = LeftLeg.addOrReplaceChild("LeftLeg_r7", CubeListBuilder.create().texOffs(101, 92).addBox(20.4048F, -15.2058F, 41.9158F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3457F, 4.7914F, -7.1957F, 0.2696F, -0.0447F, -0.3463F));

		PartDefinition LeftLeg_r8 = LeftLeg.addOrReplaceChild("LeftLeg_r8", CubeListBuilder.create().texOffs(101, 92).addBox(8.4783F, -50.1769F, 9.8275F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0333F, 14.8874F, -3.0176F, -0.9249F, 0.4264F, -0.8026F));

		PartDefinition LeftLeg_r9 = LeftLeg.addOrReplaceChild("LeftLeg_r9", CubeListBuilder.create().texOffs(101, 92).addBox(21.4048F, -15.0223F, 37.9147F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2859F, 5.2417F, -5.0329F, 0.0951F, -0.0447F, -0.3463F));

		PartDefinition LeftLeg_r10 = LeftLeg.addOrReplaceChild("LeftLeg_r10", CubeListBuilder.create().texOffs(101, 92).addBox(11.2529F, -24.1314F, 30.4187F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(101, 92).addBox(10.2529F, -27.1314F, 30.4187F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0081F, 5.5409F, -6.2858F, -0.1289F, -0.0227F, -0.1731F));

		PartDefinition LeftLeg_r11 = LeftLeg.addOrReplaceChild("LeftLeg_r11", CubeListBuilder.create().texOffs(101, 92).addBox(17.026F, -24.2082F, 31.4187F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8474F, 7.1788F, -11.4113F, -0.1135F, -0.0653F, -0.5199F));

		PartDefinition LeftLeg_r12 = LeftLeg.addOrReplaceChild("LeftLeg_r12", CubeListBuilder.create().texOffs(114, 64).addBox(4.5855F, -39.6689F, 27.0451F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1632F, -4.0475F, -9.018F, -0.2704F, -0.0983F, 0.0644F));

		PartDefinition LeftLeg_r13 = LeftLeg.addOrReplaceChild("LeftLeg_r13", CubeListBuilder.create().texOffs(101, 92).addBox(2.2673F, -33.507F, 29.4187F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4518F, -5.8791F, -0.1308F, 0.0057F, 0.0433F));

		PartDefinition LeftLeg_r14 = LeftLeg.addOrReplaceChild("LeftLeg_r14", CubeListBuilder.create().texOffs(101, 92).addBox(10.5447F, -45.557F, 28.4187F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4518F, -5.8791F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition LeftLeg_r15 = LeftLeg.addOrReplaceChild("LeftLeg_r15", CubeListBuilder.create().texOffs(112, 109).addBox(5.1989F, -41.7186F, 24.1903F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8778F, 11.009F, 8.8684F, -0.2818F, -0.0458F, -0.0047F));

		PartDefinition LeftLeg_r16 = LeftLeg.addOrReplaceChild("LeftLeg_r16", CubeListBuilder.create().texOffs(112, 109).addBox(1.2536F, -8.1259F, 53.6133F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 109).addBox(1.2536F, -6.1259F, 53.6133F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(112, 109).addBox(1.2536F, -10.1259F, 52.6133F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0047F, 9.9526F, 0.5206F, 0.4436F, 0.3309F, -0.1175F));

		PartDefinition LeftLeg_r17 = LeftLeg.addOrReplaceChild("LeftLeg_r17", CubeListBuilder.create().texOffs(102, 23).addBox(-7.3034F, 31.5074F, 31.9191F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4441F, 6.5575F, 4.7056F, 1.4068F, 0.2521F, 0.0452F));

		PartDefinition LeftLeg_r18 = LeftLeg.addOrReplaceChild("LeftLeg_r18", CubeListBuilder.create().texOffs(114, 23).addBox(8.7383F, -8.3853F, 45.6133F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(100, 23).addBox(8.7383F, -11.3853F, 45.6133F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6774F, 10.511F, 6.5659F, -0.0915F, 0.5398F, -1.2653F));

		PartDefinition LeftLeg_r19 = LeftLeg.addOrReplaceChild("LeftLeg_r19", CubeListBuilder.create().texOffs(113, 66).addBox(-3.8144F, 29.8902F, 32.0888F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2319F, 7.2039F, 6.4029F, 1.3974F, 0.2072F, -0.0254F));

		PartDefinition LeftLeg_r20 = LeftLeg.addOrReplaceChild("LeftLeg_r20", CubeListBuilder.create().texOffs(113, 66).addBox(-5.9617F, 1.3139F, 46.768F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8443F, 9.0801F, 9.3639F, 0.5991F, 0.5099F, -0.4257F));

		PartDefinition LeftLeg_r21 = LeftLeg.addOrReplaceChild("LeftLeg_r21", CubeListBuilder.create().texOffs(113, 66).addBox(-13.7773F, -19.8693F, 41.7445F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7346F, 9.2118F, 7.4768F, 0.2441F, 0.7634F, -0.1541F));

		PartDefinition LeftLeg_r22 = LeftLeg.addOrReplaceChild("LeftLeg_r22", CubeListBuilder.create().texOffs(113, 66).addBox(-22.1685F, 2.5305F, 42.7937F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6153F, 12.9096F, 9.4445F, 0.1356F, -0.2792F, 1.5097F));

		PartDefinition LeftLeg_r23 = LeftLeg.addOrReplaceChild("LeftLeg_r23", CubeListBuilder.create().texOffs(113, 66).addBox(2.7452F, -7.1661F, 44.9105F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3132F, 8.893F, 11.2963F, 0.427F, 0.297F, -0.439F));

		PartDefinition LeftLeg_r24 = LeftLeg.addOrReplaceChild("LeftLeg_r24", CubeListBuilder.create().texOffs(113, 66).addBox(2.8697F, 8.8656F, 43.1881F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4699F, 5.453F, 7.954F, 0.7987F, 0.2599F, -0.3568F));

		PartDefinition LeftLeg_r25 = LeftLeg.addOrReplaceChild("LeftLeg_r25", CubeListBuilder.create().texOffs(113, 66).addBox(-19.3477F, -14.0579F, 42.7937F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6793F, 11.3583F, 8.9952F, 0.257F, -0.1746F, 0.9826F));

		PartDefinition LeftLeg_r26 = LeftLeg.addOrReplaceChild("LeftLeg_r26", CubeListBuilder.create().texOffs(113, 66).addBox(-24.8051F, 15.4518F, 35.4324F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4477F, 7.2158F, 5.8952F, 1.0504F, 0.0524F, 0.8515F));

		PartDefinition LeftLeg_r27 = LeftLeg.addOrReplaceChild("LeftLeg_r27", CubeListBuilder.create().texOffs(113, 66).addBox(-14.7773F, -21.6159F, 44.4069F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0047F, 9.9526F, 6.5206F, 0.375F, 0.7634F, -0.1541F));

		PartDefinition LeftLeg_r28 = LeftLeg.addOrReplaceChild("LeftLeg_r28", CubeListBuilder.create().texOffs(113, 66).addBox(31.1243F, -15.4041F, 37.3699F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7346F, 9.2118F, 1.4768F, 0.4241F, -0.5792F, -0.1329F));

		PartDefinition LeftLeg_r29 = LeftLeg.addOrReplaceChild("LeftLeg_r29", CubeListBuilder.create().texOffs(113, 66).addBox(30.1243F, -17.4988F, 40.4698F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0047F, 9.9526F, 0.5206F, 0.555F, -0.5792F, -0.1329F));

		PartDefinition LeftLeg_r30 = LeftLeg.addOrReplaceChild("LeftLeg_r30", CubeListBuilder.create().texOffs(112, 109).addBox(43.7234F, -36.177F, 22.123F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0047F, 9.9526F, 0.5206F, 0.5151F, -0.8108F, -0.4443F));

		PartDefinition LeftLeg_r31 = LeftLeg.addOrReplaceChild("LeftLeg_r31", CubeListBuilder.create().texOffs(112, 109).addBox(19.5009F, 28.0718F, 29.6877F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5872F, 7.1335F, -0.1865F, 0.9925F, 0.0954F, -0.931F));

		PartDefinition LeftLeg_r32 = LeftLeg.addOrReplaceChild("LeftLeg_r32", CubeListBuilder.create().texOffs(112, 109).addBox(19.5009F, 1.985F, 40.534F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5872F, 7.1335F, -0.1865F, 0.3816F, 0.0954F, -0.931F));

		PartDefinition LeftLeg_r33 = LeftLeg.addOrReplaceChild("LeftLeg_r33", CubeListBuilder.create().texOffs(112, 109).addBox(0.2536F, -31.1588F, 32.2545F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(112, 109).addBox(-0.7464F, -39.1588F, 31.2545F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8962F, 9.0632F, 5.0407F, -0.0363F, 0.3309F, -0.1175F));

		PartDefinition LeftLeg_r34 = LeftLeg.addOrReplaceChild("LeftLeg_r34", CubeListBuilder.create().texOffs(112, 109).addBox(-2.7464F, -19.1259F, 47.6133F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8962F, 9.0632F, 5.0407F, 0.4436F, 0.3309F, -0.1175F));

		PartDefinition LeftLeg_r35 = LeftLeg.addOrReplaceChild("LeftLeg_r35", CubeListBuilder.create().texOffs(112, 109).addBox(6.0824F, -36.2443F, 48.4544F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0047F, 9.9526F, 0.5206F, 0.3532F, 0.1942F, -0.1118F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 0.12F * limbSwingAmount;
		this.LeftLeg.yRot = Mth.cos(limbSwing * 0.5662F) * 0.12F * limbSwingAmount;

		this.LeftArm.xRot = Mth.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
		
		this.Body.getChild("wing3").xRot = Mth.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;

		this.Body.getChild("wing4").xRot = netHeadYaw * 0.017453292F;
		this.Body.getChild("wing").yRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.25F * limbSwingAmount;

		this.Body.getChild("wing5").xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.Body.getChild("wing2").yRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.25F * limbSwingAmount;
		this.Body.getChild("wing6").xRot = netHeadYaw * 0.017453292F;
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