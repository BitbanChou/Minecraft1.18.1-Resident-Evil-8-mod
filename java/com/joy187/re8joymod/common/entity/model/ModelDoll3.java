// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityDoll3;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDoll3<T extends EntityDoll3> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer RightArm;
	private final ModelRenderer hand1_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer hand2_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer scissors;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Body_r6;
	private final ModelRenderer scissors5;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer scissors3;
	private final ModelRenderer Body_r12;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer scissors6;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer Body_r19;
	private final ModelRenderer Body_r20;
	private final ModelRenderer Body_r21;
	private final ModelRenderer LeftLeg;

	public ModelDoll3() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 3.0F, 0.0F);
		setRotationAngle(Head, 0.0262F, 0.0873F, 0.48F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-2.3F, -8.3897F, -0.6637F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.3927F, 0.0F, -0.48F);
		Head_r1.texOffs(12, 34).addBox(-2.9966F, 5.8633F, -3.8802F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(14, 5).addBox(-3.0F, 4.0F, -2.0F, 6.0F, 7.0F, 4.0F, 0.0F, false);
		Body.texOffs(6, 5).addBox(-4.0F, 11.0F, -3.0F, 8.0F, 4.0F, 6.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(4.4171F, 4.7881F, 2.5307F);
		Body.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0F, -0.0436F, -0.0436F);
		Head_r2.texOffs(29, 11).addBox(-8.7F, -2.1F, -5.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(4.4171F, 4.7881F, 2.5307F);
		Body.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.2182F, 0.0F, 0.0873F);
		Head_r3.texOffs(36, 32).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 7.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.6109F, 0.1309F);
		

		hand1_r1 = new ModelRenderer(this);
		hand1_r1.setPos(-0.5048F, 9.5604F, -0.3124F);
		RightArm.addChild(hand1_r1);
		setRotationAngle(hand1_r1, 0.0436F, -0.5236F, 0.1309F);
		hand1_r1.texOffs(43, 26).addBox(-1.1425F, -6.564F, 0.3881F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 0.0608F, -0.1946F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0F, -0.3491F, 0.0F);
		RightArm_r1.texOffs(3, 3).addBox(-0.5722F, -3.0027F, -1.0731F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(4.0F, 3.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		hand2_r1 = new ModelRenderer(this);
		hand2_r1.setPos(3.5587F, 11.1608F, -1.4452F);
		LeftArm.addChild(hand2_r1);
		setRotationAngle(hand2_r1, 0.0436F, -0.5236F, -0.4363F);
		hand2_r1.texOffs(43, 26).addBox(-0.9146F, -4.4048F, 0.1722F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.0873F, 0.0F, -0.3491F);
		LeftArm_r1.texOffs(13, 16).addBox(-1.1994F, -3.0118F, -0.8647F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		scissors = new ModelRenderer(this);
		scissors.setPos(0.854F, 2.5063F, -2.2926F);
		RightLeg.addChild(scissors);
		setRotationAngle(scissors, 2.4871F, -3.0543F, -1.6144F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(9.4524F, 3.8311F, -2.1501F);
		scissors.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.1745F, 0.1309F);
		Body_r1.texOffs(48, 20).addBox(-3.9961F, -1.0941F, -0.4178F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(9.5057F, 3.3892F, -2.1501F);
		scissors.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.1745F, -0.0873F);
		Body_r2.texOffs(50, 25).addBox(-3.9305F, -0.5143F, -0.4063F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(5.4519F, 2.8901F, -2.4403F);
		scissors.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.1745F, 0.0873F);
		Body_r3.texOffs(45, 61).addBox(0.0098F, -0.6791F, 1.0832F, 4.0F, 1.0F, 0.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(4.459F, 3.5515F, -0.6691F);
		scissors.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.1745F, 0.0873F);
		Body_r4.texOffs(10, 48).addBox(-2.7653F, -1.4246F, -0.9993F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(1.429F, -1.3363F, -0.0663F);
		scissors.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.1745F, 1.3526F);
		Body_r5.texOffs(7, 47).addBox(0.1612F, -0.4308F, -0.3901F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(1.8145F, -0.1179F, -0.0663F);
		scissors.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, 0.1745F, 0.0F);
		Body_r6.texOffs(6, 53).addBox(-3.9676F, -0.848F, -0.4128F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors5 = new ModelRenderer(this);
		scissors5.setPos(3.854F, 5.5063F, -3.2926F);
		RightLeg.addChild(scissors5);
		setRotationAngle(scissors5, 1.1781F, 2.618F, -1.6144F);
		

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors5.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, 0.1745F, 0.1309F);
		Body_r7.texOffs(48, 20).addBox(-3.8089F, -0.1506F, -0.5807F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors5.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.1745F, -0.0873F);
		Body_r8.texOffs(50, 25).addBox(-3.948F, 0.4407F, -0.6053F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors5.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.1745F, 0.0873F);
		Body_r9.texOffs(45, 61).addBox(0.1563F, 0.2703F, -0.1869F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r9.texOffs(10, 48).addBox(-3.8437F, 0.2703F, -0.5869F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors5.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.1745F, 1.2654F);
		Body_r10.texOffs(7, 47).addBox(1.9702F, 1.4862F, -0.267F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors5.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.1745F, 0.0F);
		Body_r11.texOffs(6, 53).addBox(-3.9029F, 0.1078F, -0.5973F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors3 = new ModelRenderer(this);
		scissors3.setPos(3.854F, 5.5063F, 0.7074F);
		RightLeg.addChild(scissors3);
		setRotationAngle(scissors3, -0.6545F, 2.9671F, -1.6144F);
		

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors3.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.1745F, 0.1309F);
		Body_r12.texOffs(48, 20).addBox(-3.7172F, 0.0403F, -0.9157F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors3.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.1745F, -0.0873F);
		Body_r13.texOffs(50, 25).addBox(-3.8978F, 0.634F, -0.9475F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors3.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.1745F, 0.0873F);
		Body_r14.texOffs(45, 61).addBox(0.2398F, 0.4624F, -0.5233F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r14.texOffs(10, 48).addBox(-3.7602F, 0.4624F, -0.9233F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors3.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, 0.1745F, 1.2654F);
		Body_r15.texOffs(7, 47).addBox(2.214F, 1.5377F, -0.5752F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors3.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0F, 0.1745F, 0.0F);
		Body_r16.texOffs(6, 53).addBox(-3.836F, 0.3013F, -0.9366F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors6 = new ModelRenderer(this);
		scissors6.setPos(1.854F, 5.5063F, 0.7074F);
		RightLeg.addChild(scissors6);
		setRotationAngle(scissors6, -1.7453F, 2.9671F, -1.6144F);
		

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors6.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.1745F, 0.1309F);
		Body_r17.texOffs(48, 20).addBox(-3.7136F, 0.0415F, -0.9351F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors6.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.1745F, -0.0873F);
		Body_r18.texOffs(50, 25).addBox(-3.8944F, 0.6352F, -0.967F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors6.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.1745F, 0.0873F);
		Body_r19.texOffs(45, 61).addBox(0.2433F, 0.4636F, -0.5427F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r19.texOffs(10, 48).addBox(-3.7567F, 0.4636F, -0.9427F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors6.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.1745F, 1.2654F);
		Body_r20.texOffs(7, 47).addBox(2.2185F, 1.5381F, -0.5944F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors6.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.1745F, 0.0F);
		Body_r21.texOffs(6, 53).addBox(-3.8326F, 0.3024F, -0.9561F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.scissors.zRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.scissors6.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;

		this.scissors3.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;
		this.scissors5.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

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