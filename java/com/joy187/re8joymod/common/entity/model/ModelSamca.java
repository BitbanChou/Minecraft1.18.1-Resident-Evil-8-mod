// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntitySamca;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelSamca<T extends EntitySamca> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer tone;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Body;
	private final ModelRenderer wing1;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer wing2;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer knife;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelSamca() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(3, 3).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Head.texOffs(43, 9).addBox(-3.0F, -6.5F, -3.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		tone = new ModelRenderer(this);
		tone.setPos(0.0F, -0.083F, -3.3653F);
		Head.addChild(tone);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(5.5889F, 1.6536F, -10.2414F);
		tone.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.8727F, -1.0036F, -0.3054F);
		Head_r1.texOffs(45, 34).addBox(-0.5F, 0.0F, -9.0F, 1.0F, 0.0F, 6.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(5.4701F, 3.1805F, -9.8768F);
		tone.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.3491F, -1.0036F, -0.3054F);
		Head_r2.texOffs(45, 34).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-2.3037F, -0.417F, -2.247F);
		tone.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.3927F, -0.6545F, 0.0F);
		Head_r3.texOffs(2, 3).addBox(0.0F, -0.5F, -9.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-0.5F, -0.417F, -1.6347F);
		tone.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.3927F, 0.0F, 0.0F);
		Head_r4.texOffs(45, 34).addBox(0.0F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 15).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 13.0F, 5.0F, 0.0F, false);
		Body.texOffs(18, 19).addBox(-4.0F, 1.0F, 0.0F, 8.0F, 10.0F, 3.0F, 0.0F, false);

		wing1 = new ModelRenderer(this);
		wing1.setPos(0.0F, 24.0F, 0.0F);
		Body.addChild(wing1);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(12.6321F, -15.1448F, 5.5328F);
		wing1.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.0436F, 0.2618F);
		Body_r1.texOffs(32, 60).addBox(-5.0F, 0.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(11.5294F, -19.0F, 5.4421F);
		wing1.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.0436F, 0.3054F);
		Body_r2.texOffs(15, 15).addBox(-5.0F, -8.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		Body_r2.texOffs(30, 55).addBox(-5.0F, -5.0F, -1.0F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(10.8935F, -18.7674F, 5.4857F);
		wing1.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0436F, 0.8727F);
		Body_r3.texOffs(48, 55).addBox(-4.0F, -8.0F, -1.0F, 7.0F, 8.0F, 1.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(6.0154F, -18.0F, 4.7162F);
		wing1.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, -0.3054F, 0.0F);
		Body_r4.texOffs(16, 54).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 8.0F, 2.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(2.5F, -17.5F, 3.0F);
		wing1.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, -0.7854F, 0.0F);
		Body_r5.texOffs(16, 52).addBox(-2.5F, -5.5F, -1.0F, 4.0F, 10.0F, 2.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setPos(0.0F, 24.0F, 0.0F);
		Body.addChild(wing2);
		

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(-12.6321F, -15.1448F, 5.5328F);
		wing2.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, -0.0436F, -0.5236F);
		Body_r6.texOffs(0, 61).addBox(-2.0F, -4.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-12.6321F, -15.1448F, 5.5328F);
		wing2.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, -0.0436F, -0.2618F);
		Body_r7.texOffs(9, 56).addBox(-1.0F, 0.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(-11.5294F, -19.0F, 5.4421F);
		wing2.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, -0.0436F, -0.3054F);
		Body_r8.texOffs(33, 55).addBox(4.0F, -8.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, true);
		Body_r8.texOffs(45, 55).addBox(-2.0F, -5.0F, -1.0F, 7.0F, 7.0F, 2.0F, 0.0F, true);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-10.8935F, -18.7674F, 5.4857F);
		wing2.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, -0.0436F, -0.8727F);
		Body_r9.texOffs(32, 55).addBox(-3.0F, -8.0F, -1.0F, 7.0F, 8.0F, 1.0F, 0.0F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-6.0154F, -18.0F, 4.7162F);
		wing2.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.3054F, 0.0F);
		Body_r10.texOffs(16, 54).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 8.0F, 2.0F, 0.0F, true);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(-2.5F, -17.5F, 3.0F);
		wing2.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.7854F, 0.0F);
		Body_r11.texOffs(5, 19).addBox(-1.5F, -5.5F, -1.0F, 4.0F, 10.0F, 2.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		RightArm.texOffs(0, 22).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 8.1864F, -0.085F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.1745F, 0.0F, 0.0F);
		RightArm_r1.texOffs(1, 36).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(-0.5F, 13.1864F, 2.915F);
		RightArm.addChild(knife);
		setRotationAngle(knife, 0.0F, 0.0F, 3.0107F);
		

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.5F, 3.2012F, 0.8802F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.9163F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(33, 51).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.0873F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(25, 22).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1309F, 0.0F, 0.0F);
		Rightll_r1.texOffs(2, 54).addBox(-2.9F, -13.0F, -3.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9F, 4.494F, -0.0683F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(1, 36).addBox(-2.9F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.4764F, 9.2308F, 1.6216F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
		Leftll_r1.texOffs(26, 21).addBox(-3.5F, -4.0F, 1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(42, 23).addBox(-2.0F, -4.5F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below

		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.5F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		this.RightLeg_r1.yRot = headPitch * 0.017453292F;

		this.LeftArm_r2.yRot = headPitch * 0.017453292F;
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.tone.zRot = headPitch * 0.017453292F;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
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