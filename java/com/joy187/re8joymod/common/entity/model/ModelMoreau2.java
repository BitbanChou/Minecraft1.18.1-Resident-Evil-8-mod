// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMoreau;
import com.joy187.re8joymod.common.entity.EntityMoreau2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMoreau2<T extends EntityMoreau2> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer RightArm;
	private final ModelRenderer bottle2_r1;
	private final ModelRenderer bottle3_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer bottle3_r2;
	private final ModelRenderer bottle2_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelMoreau2() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.2618F, 0.0873F, 0.0F);
		Head_r1.texOffs(0, 3).addBox(5.5F, 0.0F, 3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.2618F, -0.2182F, 0.0F);
		Head_r2.texOffs(0, 3).addBox(7.5F, 1.0F, 3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Head_r2.texOffs(0, 3).addBox(6.5F, 0.0F, 2.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-4.1902F, -0.1709F, -3.9835F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.48F, 0.0F, 0.48F);
		Head_r3.texOffs(24, 0).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.48F, 0.0F, 0.1309F);
		Head_r4.texOffs(24, 0).addBox(-2.1F, 1.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		Head_r4.texOffs(24, 0).addBox(-2.1F, 1.0F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.1309F, 0.0F, 0.1309F);
		Head_r5.texOffs(24, 0).addBox(-2.1F, 1.0F, 1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.48F, 0.0F, -0.1745F);
		Head_r6.texOffs(0, 0).addBox(-1.9F, 1.0F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(0.0F, -4.0F, 0.0F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.2182F, 0.0F, 0.0F);
		Head_r7.texOffs(0, 0).addBox(-4.0F, 1.0F, -10.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(14, 14).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 17.0F, 6.0F, 0.0F, false);
		Body.texOffs(0, 35).addBox(-3.0F, -3.0F, 3.0F, 6.0F, 8.0F, 3.0F, 0.0F, false);
		Body.texOffs(18, 23).addBox(-3.0F, 5.0F, -7.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, 6.0F, 0.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.3054F, -0.4363F, 0.0F);
		Body_r1.texOffs(18, 23).addBox(-2.0F, -2.0F, -7.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(-0.5F, 7.2141F, 5.8971F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.5236F, 0.0F, 0.0F);
		Body_r2.texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(-1.5F, -8.0F, 0.0F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.5236F, 0.0F, 0.0F);
		Body_r3.texOffs(14, 14).addBox(-2.5F, 1.0F, -6.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 8.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		bottle2_r1 = new ModelRenderer(this);
		bottle2_r1.setPos(9.5F, 7.8296F, -3.8114F);
		RightArm.addChild(bottle2_r1);
		setRotationAngle(bottle2_r1, -0.1745F, 0.0F, 0.5672F);
		bottle2_r1.texOffs(32, 41).addBox(-9.5F, 4.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle3_r1 = new ModelRenderer(this);
		bottle3_r1.setPos(-1.5F, 7.9449F, -2.2777F);
		RightArm.addChild(bottle3_r1);
		setRotationAngle(bottle3_r1, -0.48F, 0.0F, 0.0F);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-1.0F, 1.9428F, -1.0682F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.4363F, 0.0F, 0.0F);
		RightArm_r1.texOffs(52, 43).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-1.0F, 3.5774F, -0.9063F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(42, 6).addBox(0.0F, -8.0F, 0.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 5.0F, -2.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-2.0F, -6.0F, -2.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		bottle3_r2 = new ModelRenderer(this);
		bottle3_r2.setPos(-1.5F, 5.8296F, -2.8114F);
		leftfront.addChild(bottle3_r2);
		setRotationAngle(bottle3_r2, -0.1745F, 0.0F, 0.5672F);
		bottle3_r2.texOffs(32, 41).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle2_r2 = new ModelRenderer(this);
		bottle2_r2.setPos(0.0F, -0.9487F, -0.0622F);
		leftfront.addChild(bottle2_r2);
		setRotationAngle(bottle2_r2, -0.1745F, 0.0F, 0.0F);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, 6.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(0.0F, 6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(0.0F, 6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, 6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(52, 33).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-1.0F, 3.1681F, -0.4158F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3927F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(0, 60).addBox(-1.0F, 8.0F, -4.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		RightLeg_r1.texOffs(16, 49).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(0.0F, 6.0F, 0.0F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.6981F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(16, 49).addBox(-2.0F, -8.0F, -5.0F, 3.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(1.0F, 3.8855F, 0.2078F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(0, 55).addBox(-2.0F, 7.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		LeftLeg_r1.texOffs(16, 48).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, -0.1745F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(16, 48).addBox(-1.0F, -8.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.Body_r1.xRot = netHeadYaw * 0.007453292F;
		this.Body_r2.zRot = netHeadYaw * 0.007453292F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}