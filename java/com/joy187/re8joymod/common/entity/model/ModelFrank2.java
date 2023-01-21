// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityFrank2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelFrank2<T extends EntityFrank2> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
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
	private final ModelRenderer knife2;
	private final ModelRenderer RightArm_r11;
	private final ModelRenderer RightArm_r12;
	private final ModelRenderer RightArm_r13;
	private final ModelRenderer RightArm_r14;
	private final ModelRenderer RightArm_r15;
	private final ModelRenderer RightArm_r16;
	private final ModelRenderer RightArm_r17;
	private final ModelRenderer RightArm_r18;
	private final ModelRenderer RightArm_r19;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelFrank2() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -6.3465F, 0.1059F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(3, 3).addBox(-3.5F, -2.637F, -4.4195F, 7.0F, 6.0F, 7.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, 0.363F, -2.4195F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0F, 2.3465F, -0.1059F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.4835F, 0.0F, 0.0F);
		Head_r1.texOffs(43, 9).addBox(-3.0F, -6.5724F, -0.0551F, 6.0F, 2.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 14).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 14.0F, 7.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		RightArm.texOffs(0, 44).addBox(-3.0F, -5.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 5.1864F, -0.085F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.1745F, 0.0F, 0.0F);
		RightArm_r1.texOffs(0, 36).addBox(-2.5F, -3.5F, -1.5F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.981F, -7.4918F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.5272F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(33, 51).addBox(-0.5F, 1.5F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm_r1.texOffs(33, 51).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftArm_r1.texOffs(33, 51).addBox(-2.0F, -3.5F, -1.5F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.5F, 3.2012F, 0.8802F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.9163F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(33, 51).addBox(-1.5F, -1.2812F, -3.4483F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.0873F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(12, 22).addBox(-1.5F, -8.9776F, -2.1344F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(4.3577F, 8.1394F, -4.01F);
		LeftArm.addChild(knife);
		setRotationAngle(knife, -2.7489F, 1.6144F, -3.0107F);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(1.6951F, -11.9346F, -2.9047F);
		knife.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 1.0472F, 0.0F, 0.0F);
		RightArm_r2.texOffs(22, 59).addBox(-0.8916F, 0.9872F, -10.0758F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(1.6951F, -9.1146F, -1.5524F);
		knife.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, 0.1309F, 0.0F, 0.0F);
		RightArm_r3.texOffs(22, 59).addBox(-0.8916F, 2.4489F, -3.8882F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(1.6951F, -9.5225F, -1.8123F);
		knife.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.5672F, 0.0F, 0.0F);
		RightArm_r4.texOffs(22, 59).addBox(-0.8916F, 2.0085F, 2.0981F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(1.6951F, -8.1267F, -1.7728F);
		knife.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -1.0036F, 0.0F, 0.0F);
		RightArm_r5.texOffs(21, 60).addBox(-0.8916F, 4.0981F, 0.0085F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r5.texOffs(21, 60).addBox(-0.8916F, 0.0981F, 1.0085F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(1.6951F, -8.1267F, -1.7728F);
		knife.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.6981F, 0.0F, 0.0F);
		RightArm_r6.texOffs(21, 60).addBox(-0.8916F, -0.2215F, 3.4119F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(1.6951F, -8.1267F, -1.7728F);
		knife.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.48F, 0.0F, 0.0F);
		RightArm_r7.texOffs(21, 60).addBox(-0.8916F, 1.1383F, 2.8734F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(1.6951F, -8.083F, -2.7718F);
		knife.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -0.1745F, 0.0F, 0.0F);
		RightArm_r8.texOffs(21, 60).addBox(-0.8916F, 6.4291F, 0.0165F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r8.texOffs(21, 60).addBox(-0.8916F, 6.4291F, -1.9835F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(1.6951F, -8.083F, -2.7718F);
		knife.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, 0.5236F, 0.0F, 0.0F);
		RightArm_r9.texOffs(21, 60).addBox(-0.8916F, 1.0758F, -3.9872F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(1.6951F, -6.303F, 2.3107F);
		knife.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, 0.0436F, 0.0F, 0.0F);
		RightArm_r10.texOffs(21, 60).addBox(-0.8916F, -0.5285F, -5.6297F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightArm_r10.texOffs(21, 54).addBox(-0.8916F, 2.4715F, -8.6297F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		knife2 = new ModelRenderer(this);
		knife2.setPos(4.3577F, 8.1394F, -7.01F);
		LeftArm.addChild(knife2);
		setRotationAngle(knife2, -2.7489F, 1.6144F, -3.0107F);
		

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(1.6951F, -11.9346F, -2.9047F);
		knife2.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, 1.0472F, 0.0F, 0.0F);
		RightArm_r11.texOffs(22, 59).addBox(-0.8916F, 2.9872F, -10.0758F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r12 = new ModelRenderer(this);
		RightArm_r12.setPos(1.6951F, -9.1146F, -1.5524F);
		knife2.addChild(RightArm_r12);
		setRotationAngle(RightArm_r12, 0.1309F, 0.0F, 0.0F);
		RightArm_r12.texOffs(22, 59).addBox(-0.8916F, 3.4489F, -3.8882F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r13 = new ModelRenderer(this);
		RightArm_r13.setPos(1.6951F, -9.5225F, -1.8123F);
		knife2.addChild(RightArm_r13);
		setRotationAngle(RightArm_r13, -0.5672F, 0.0F, 0.0F);
		RightArm_r13.texOffs(22, 59).addBox(1.1084F, 4.0085F, 2.0981F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r14 = new ModelRenderer(this);
		RightArm_r14.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r14);
		setRotationAngle(RightArm_r14, -1.0036F, 0.0F, 0.0F);
		RightArm_r14.texOffs(21, 60).addBox(-0.8916F, 4.0981F, 0.0085F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r14.texOffs(21, 60).addBox(-0.8916F, 2.0981F, 1.0085F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r15 = new ModelRenderer(this);
		RightArm_r15.setPos(3.679F, -8.3489F, 0.0125F);
		knife2.addChild(RightArm_r15);
		setRotationAngle(RightArm_r15, -1.0036F, 0.0F, 0.0F);
		RightArm_r15.texOffs(21, 60).addBox(1.1084F, 5.0981F, 2.0085F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r16 = new ModelRenderer(this);
		RightArm_r16.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r16);
		setRotationAngle(RightArm_r16, -0.6981F, 0.0F, 0.0F);
		RightArm_r16.texOffs(21, 60).addBox(0.1084F, 1.7785F, 2.4119F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r17 = new ModelRenderer(this);
		RightArm_r17.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r17);
		setRotationAngle(RightArm_r17, -0.48F, 0.0F, 0.0F);
		RightArm_r17.texOffs(21, 60).addBox(-0.8916F, 2.1383F, 2.8734F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r18 = new ModelRenderer(this);
		RightArm_r18.setPos(1.6951F, -8.083F, -2.7718F);
		knife2.addChild(RightArm_r18);
		setRotationAngle(RightArm_r18, 0.5236F, 0.0F, 0.0F);
		RightArm_r18.texOffs(21, 60).addBox(-0.8916F, 2.0758F, -3.9872F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r19 = new ModelRenderer(this);
		RightArm_r19.setPos(1.6951F, -6.303F, 2.3107F);
		knife2.addChild(RightArm_r19);
		setRotationAngle(RightArm_r19, 0.0436F, 0.0F, 0.0F);
		RightArm_r19.texOffs(21, 60).addBox(-0.8916F, 1.4715F, -5.6297F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1309F, 0.0F, 0.0F);
		Rightll_r1.texOffs(17, 49).addBox(-3.9F, -14.0F, -4.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9F, 4.494F, -0.0683F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(45, 32).addBox(-3.4F, 0.0F, -3.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.4764F, 9.2308F, 1.6216F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
		Leftll_r1.texOffs(44, 21).addBox(-3.1F, -4.0F, 1.5F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(42, 23).addBox(-2.0F, -5.5F, -1.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);
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