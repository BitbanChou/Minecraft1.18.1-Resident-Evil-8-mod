// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityLycan1;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelLycan1<T extends EntityLycan1> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer Head_r8;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer knife;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer knife2;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelLycan1() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -7.3465F, 0.1059F);
		setRotationAngle(Head, -0.0611F, 0.0873F, 0.0F);
		Head.texOffs(1, 1).addBox(-3.5F, -6.6261F, -4.6285F, 8.0F, 8.0F, 7.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, -1.6261F, -2.6285F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-4.8383F, -8.2727F, -1.4008F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 2.0944F, -0.6109F, 0.0F);
		Head_r1.texOffs(60, 56).addBox(0.5F, -1.5F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(5.6324F, -9.9391F, -0.4105F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 2.0944F, 0.0436F, 0.0F);
		Head_r2.texOffs(60, 60).addBox(-0.5F, -1.5F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(1.0672F, -10.6107F, -0.476F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 2.0944F, 0.0436F, 0.0F);
		Head_r3.texOffs(60, 60).addBox(-0.5F, -1.5F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(3.786F, -6.6568F, -4.0539F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.5672F, -0.0436F, -0.5236F);
		Head_r4.texOffs(18, 9).addBox(-6.0F, -5.5F, -2.5F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(3.786F, -6.6568F, -4.0539F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, -0.5672F, 0.0F, 0.3054F);
		Head_r5.texOffs(7, 18).addBox(-1.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-1.8209F, -3.9397F, -2.8045F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.2182F, 1.309F, 0.0F);
		Head_r6.texOffs(56, 53).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(4.5817F, -2.8673F, -3.8863F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.5672F, -1.1345F, 0.0F);
		Head_r7.texOffs(56, 53).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(-0.2838F, -5.1461F, -5.1285F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, -0.5672F, 0.0F, 0.0436F);
		Head_r8.texOffs(1, 21).addBox(-2.0F, 0.5F, -1.0F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		Head_r8.texOffs(56, 53).addBox(0.0F, -6.5F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(11, 12).addBox(-4.0F, -6.0F, -5.0F, 10.0F, 15.0F, 8.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(5.5F, -5.0F, -1.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.0F, -0.2618F);
		Body_r1.texOffs(0, 18).addBox(-2.5F, -1.0F, -2.0F, 7.0F, 4.0F, 5.0F, 0.0F, true);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(-5.5F, -5.0F, -1.0F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.0F, 0.2618F);
		Body_r2.texOffs(0, 20).addBox(-3.5F, -1.0F, -2.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-6.0F, 0.0F, -2.0F);
		setRotationAngle(RightArm, -0.0436F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-3.5F, 1.9707F, -12.2892F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -1.3963F, -0.2618F, -0.3927F);
		RightArm_r1.texOffs(8, 55).addBox(3.5F, -0.5F, 4.55F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		RightArm_r1.texOffs(9, 21).addBox(3.0F, -6.5F, 3.95F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-3.5F, 1.9707F, -12.2892F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -1.7017F, 0.0F, -0.1309F);
		RightArm_r2.texOffs(13, 21).addBox(-0.5F, -0.5F, 1.55F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		RightArm_r2.texOffs(4, 21).addBox(-1.0F, -6.5F, 0.95F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-0.5F, 5.6636F, 2.354F);
		RightArm.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -1.5708F, 0.0F, 0.0F);
		RightArm_r3.texOffs(58, 57).addBox(-1.5F, 15.5F, -0.2F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		RightArm_r3.texOffs(6, 20).addBox(-2.0F, 9.5F, -0.8F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		RightArm_r3.texOffs(2, 19).addBox(-2.5F, 2.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-0.6357F, 2.9171F, 0.6397F);
		RightArm.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.48F, 0.0F, 0.0F);
		RightArm_r4.texOffs(0, 52).addBox(-2.5F, -3.5F, -2.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.5F, -0.0455F, 1.5863F);
		RightArm.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, 0.0F, 0.0F, 0.1745F);
		RightArm_r5.texOffs(0, 39).addBox(-2.5F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(-1.6786F, 10.2122F, -5.8614F);
		RightArm.addChild(knife);
		setRotationAngle(knife, 3.0543F, -1.6144F, 0.1309F);
		

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.3916F, -0.9698F, 4.63F);
		knife.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, 0.0436F, 0.0F, 0.0F);
		RightArm_r6.texOffs(0, 56).addBox(-3.8745F, 4.4601F, -6.8908F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(8.0F, 0.0F, -2.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 7.3531F, -5.9514F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.5272F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(8, 51).addBox(-0.5F, 0.7489F, -2.9044F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		LeftArm_r1.texOffs(6, 23).addBox(-1.0F, -0.2511F, -3.9044F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftArm_r1.texOffs(0, 20).addBox(-2.0F, -4.2511F, -4.4044F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(1.0F, 3.4424F, -6.6218F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -1.4399F, -0.2618F, 0.0F);
		LeftArm_r2.texOffs(6, 56).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.1481F, 5.2936F, 2.3278F);
		LeftArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.9163F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(0, 54).addBox(-1.5F, -3.5624F, -5.3967F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.5F, 6.3721F, 1.0405F);
		LeftArm.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.0873F, 0.0F, -0.1745F);
		LeftArm_r4.texOffs(2, 21).addBox(-0.9904F, -9.9109F, -1.7649F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		knife2 = new ModelRenderer(this);
		knife2.setPos(4.3577F, 10.5115F, -5.4695F);
		LeftArm.addChild(knife2);
		setRotationAngle(knife2, -2.7489F, 1.6144F, -3.0107F);
		

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(3.8609F, -7.4915F, -0.7731F);
		knife2.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.2182F, -0.1745F, 0.0F);
		RightArm_r7.texOffs(0, 23).addBox(-2.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(1.6951F, -6.303F, 2.3107F);
		knife2.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, 0.0436F, 0.0F, 0.0F);
		RightArm_r8.texOffs(21, 60).addBox(-1.5314F, -1.3155F, -4.7223F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 10.0F, -1.0F);
		setRotationAngle(RightLeg, -0.0698F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(2.7664F, 13.2355F, -0.1942F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1309F, 0.0F, 0.0F);
		Rightll_r1.texOffs(15, 48).addBox(-4.9F, -16.0F, -4.0F, 5.0F, 9.0F, 5.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(2.2664F, 5.4247F, 0.7385F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(0, 25).addBox(-4.4F, 8.0F, -5.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		RightLeg_r1.texOffs(0, 18).addBox(-4.4F, 0.0F, -4.0F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(2.9F, 10.0F, -1.0F);
		setRotationAngle(LeftLeg, -0.5672F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.2336F, 10.3728F, 2.4558F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
		Leftll_r1.texOffs(0, 25).addBox(-3.0651F, 4.1571F, 0.037F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		Leftll_r1.texOffs(0, 18).addBox(-3.1F, -4.0F, 1.5F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.8664F, 4.6419F, 1.4166F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(16, 48).addBox(-2.0F, -6.5F, -1.5F, 5.0F, 8.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

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