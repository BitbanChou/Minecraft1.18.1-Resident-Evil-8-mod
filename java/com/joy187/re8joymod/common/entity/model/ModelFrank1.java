// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntityFrank1;
import com.joy187.re8joymod.common.entity.EntityHeisen;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelFrank1<T extends EntityFrank1> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer knife;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer RightArm_r9;
	private final ModelRenderer RightArm_r10;
	private final ModelRenderer RightArm_r11;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelFrank1() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(3, 3).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0F, -4.0F, 0.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.4835F, 0.0F, 0.0F);
		Head_r1.texOffs(43, 9).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 2.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 14).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 13.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		RightArm.texOffs(0, 44).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 8.1864F, -0.085F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.1745F, 0.0F, 0.0F);
		RightArm_r1.texOffs(1, 36).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(-0.5F, 13.1864F, 2.915F);
		RightArm.addChild(knife);
		setRotationAngle(knife, 0.0F, 0.0F, 3.0107F);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(0.0F, -6.2771F, -21.9856F);
		knife.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 1.0472F, 0.0F, 0.0F);
		RightArm_r2.texOffs(22, 59).addBox(-0.5F, -0.5F, -7.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(0.0F, -3.4571F, -20.6333F);
		knife.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, 0.1309F, 0.0F, 0.0F);
		RightArm_r3.texOffs(22, 59).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(0.0F, -3.865F, -20.8931F);
		knife.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.5672F, 0.0F, 0.0F);
		RightArm_r4.texOffs(22, 59).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(0.0F, -2.4692F, -20.8536F);
		knife.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -1.0036F, 0.0F, 0.0F);
		RightArm_r5.texOffs(21, 60).addBox(-0.5F, 2.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r5.texOffs(21, 60).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.0F, -2.4692F, -20.8536F);
		knife.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.6981F, 0.0F, 0.0F);
		RightArm_r6.texOffs(21, 60).addBox(-0.5F, -2.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.0F, -2.4692F, -20.8536F);
		knife.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.48F, 0.0F, 0.0F);
		RightArm_r7.texOffs(21, 60).addBox(-0.5F, -1.5F, 1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(0.0F, -2.4256F, -21.8526F);
		knife.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -0.1745F, 0.0F, 0.0F);
		RightArm_r8.texOffs(21, 60).addBox(-0.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r8.texOffs(21, 60).addBox(-0.5F, 3.5F, -2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(0.0F, -2.4256F, -21.8526F);
		knife.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, 0.5236F, 0.0F, 0.0F);
		RightArm_r9.texOffs(21, 60).addBox(-0.5F, -1.5F, -2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(0.0F, -0.6456F, -16.7702F);
		knife.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, 0.0436F, 0.0F, 0.0F);
		RightArm_r10.texOffs(21, 60).addBox(-0.5F, -3.5F, -5.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightArm_r10.texOffs(21, 54).addBox(-0.5F, -0.5F, -8.5F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(0.0F, 1.0F, -3.0F);
		knife.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, -0.1745F, 0.0F, 0.0F);
		RightArm_r11.texOffs(6, 46).addBox(-0.5F, -0.5F, -14.5F, 1.0F, 1.0F, 17.0F, 0.0F, false);

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
		LeftArm_r2.texOffs(12, 22).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1309F, 0.0F, 0.0F);
		Rightll_r1.texOffs(17, 49).addBox(-2.9F, -13.0F, -3.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9F, 4.494F, -0.0683F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(45, 32).addBox(-2.9F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.4764F, 9.2308F, 1.6216F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
		Leftll_r1.texOffs(44, 21).addBox(-3.5F, -4.0F, 1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(42, 23).addBox(-2.0F, -4.5F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below

		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.4F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightLeg_r1.yRot = headPitch * 0.017453292F;

		this.LeftArm_r2.yRot = headPitch * 0.017453292F;
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.knife.yRot = headPitch * 0.017453292F;

		this.Head.yRot= netHeadYaw * 0.017453292F;
		this.Head.xRot= headPitch * 0.017453292F;
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