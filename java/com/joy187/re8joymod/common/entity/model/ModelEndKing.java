package com.joy187.re8joymod.common.entity.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.joy187.re8joymod.common.entity.EntityEndKing;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelEndKing<T extends EntityEndKing> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	//public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "endshadow_king_"), "main");
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer head;
	private final ModelRenderer headwear;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

//	public ModelEndKing(ModelRenderer root) {
//		this.body = root.getChild("body");
//		this.body_r1 = root.getChild("body_r1");
//		this.head = root.getChild("head");
//		this.headwear = root.getChild("headwear");
//		this.right_arm = root.getChild("right_arm");
//		this.left_arm = root.getChild("left_arm");
//		this.right_leg = root.getChild("right_leg");
//		this.left_leg = root.getChild("left_leg");
//	}

	public ModelEndKing() {
		texWidth = 128;
		texHeight = 128;

		body = new ModelRenderer(this);
		body.setPos(0.0F, -15.0F, 0.0F);
		body.texOffs(8, 52).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F,false);

		body_r1 = new ModelRenderer(this);
		body_r1.setPos(0.0F, -15.0F, 0.0F);
		body_r1.texOffs(4, 0).addBox(-8.0F, -39.0F, 6.0F, 12.0F, 27.0F, 1.0F,false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -15.0F, 0.0F);
		head.texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		headwear = new ModelRenderer(this);
		headwear.setPos(0.0F, -15.0F, 0.0F);
		headwear.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(5.0F, -13.0F, 0.0F);
		right_arm.texOffs(8, 32).addBox(-11.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setPos(-5.0F, -13.0F, 0.0F);
		left_arm.texOffs(0, 32).addBox(9.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(2.0F, -6.0F, 0.0F);
		right_leg.texOffs(32, 0).addBox(-5.0F, 6.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(-2.0F, -6.0F, 0.0F);
		left_leg.texOffs(16, 32).addBox(3.0F, 6.0F, -1.0F, 2.0F, 24.0F, 2.0F, 0.0F, false);
	}

//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//
//		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(4, 0).addBox(-8.0F, -39.0F, 6.0F, 12.0F, 27.0F, 1.0F,false), PartPose.offsetAndRotation(2.0F, 39.623F, 1.8786F, 0.1745F, 0.0F, 0.0F));
//
//		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(4, 36).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F,false)
//		.texOffs(21, 19).addBox(-4.5F, -14.0F, -4.5F, 9.0F, 8.0F, 9.0F,false), PartPose.offset(0.0F, -15.0F, 0.0F));
//
//		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(30, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -15.0F, 0.0F));
//
//		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 36).addBox(-11.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F,false), PartPose.offset(5.0F, -13.0F, 0.0F));
//
//		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, -13.0F, 0.0F));
//
//		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(36, 36).addBox(9.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F,false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
//
//		PartDefinition bone = left_arm.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 51).addBox(-1.0F, 5.0F, -2.0F, 2.0F, 15.0F, 2.0F,false), PartPose.offsetAndRotation(10.0F, 12.3048F, -1.7559F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(9.5F, -14.0F, -20.25F, 1.0F, 51.0F, 1.0F,false)
//		.texOffs(30, 0).addBox(9.0F, 29.0F, -20.75F, 2.0F, 5.0F, 2.0F,false)
//		.texOffs(48, 16).addBox(6.5F, -15.0F, -23.25F, 7.0F, 4.0F, 7.0F,false)
//		.texOffs(32, 52).addBox(5.5F, -21.0F, -20.25F, 1.0F, 8.0F, 1.0F,false)
//		.texOffs(8, 34).addBox(13.5F, -21.0F, -20.25F, 1.0F, 8.0F, 1.0F,false)
//		.texOffs(52, 39).addBox(7.5F, -11.0F, -22.25F, 5.0F, 3.0F, 5.0F,false)
//		.texOffs(52, 31).addBox(7.5F, -15.5F, -22.25F, 5.0F, 3.0F, 5.0F,false)
//		.texOffs(54, 0).addBox(8.5F, -8.0F, -21.25F, 3.0F, 3.0F, 3.0F,false)
//		.texOffs(4, 28).addBox(8.5F, -20.0F, -21.25F, 3.0F, 3.0F, 3.0F,false), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(32, 61).addBox(9.5F, -21.0F, -16.25F, 1.0F, 8.0F, 1.0F,false)
//		.texOffs(30, 16).addBox(9.5F, -22.0F, -18.25F, 1.0F, 1.0F, 2.0F,false)
//		.texOffs(13, 28).addBox(9.5F, -22.0F, -23.25F, 1.0F, 1.0F, 2.0F,false)
//		.texOffs(34, 16).addBox(6.5F, -22.0F, -20.25F, 2.0F, 1.0F, 1.0F,false)
//		.texOffs(15, 33).addBox(11.5F, -22.0F, -20.25F, 2.0F, 1.0F, 1.0F,false)
//		.texOffs(4, 34).addBox(9.5F, -21.0F, -24.25F, 1.0F, 8.0F, 1.0F,false), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(36, 36).addBox(-5.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F,false), PartPose.offset(2.0F, -6.0F, 0.0F));
//
//		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 36).addBox(3.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F,false), PartPose.offset(-2.0F, -6.0F, 0.0F));
//
//		return LayerDefinition.create(meshdefinition, 128, 128);
//	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.left_leg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.right_leg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.left_arm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.right_arm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.head.yRot = netHeadYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
	
}