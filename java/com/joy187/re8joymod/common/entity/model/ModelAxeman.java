package com.joy187.re8joymod.common.entity.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.joy187.re8joymod.common.entity.EntityAxeman;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelAxeman<T extends EntityAxeman> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer bottle4_r1;
	private final ModelRenderer bottle4_r2;
	private final ModelRenderer bottle6_r1;
	private final ModelRenderer bottle5_r1;
	private final ModelRenderer bottle10_r1;
	private final ModelRenderer bottle9_r1;
	private final ModelRenderer bottle11_r1;
	private final ModelRenderer bottle10_r2;
	private final ModelRenderer bottle9_r2;
	private final ModelRenderer bottle7_r1;
	private final ModelRenderer bottle6_r2;
	private final ModelRenderer bottle5_r2;
	private final ModelRenderer bottle5_r3;
	private final ModelRenderer bottle4_r3;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelAxeman() {
		texWidth = 80;
		texHeight = 80;

		Head = new ModelRenderer(this);
		Head.setPos(-2.0F, -20.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0076F, -6.0401F, -4.4085F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(5.5643F, 12.638F, -3.4642F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.3054F, 0.3054F, 1.4399F);
		Head_r1.texOffs(34, 0).addBox(-8.7716F, 1.9627F, 3.1649F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(18, 25).addBox(-8.0F, -16.0F, -6.0F, 17.0F, 12.0F, 14.0F, 0.0F, false);
		Body.texOffs(14, 59).addBox(-7.0F, -5.0F, -4.0F, 15.0F, 10.0F, 11.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-12.0F, -14.0F, 0.0F);
		setRotationAngle(RightArm, -0.48F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(1.0F, 16.4245F, 1.9169F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.6109F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-1.98F, -8.6492F, -7.3079F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(2.0F, 19.7569F, 2.7784F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(60, 36).addBox(-3.0F, -21.9848F, -0.3021F, 5.0F, 11.0F, 5.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(10.0F, -11.0F, 2.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 16.0922F, -5.6373F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(36, 20).addBox(-2.0F, -21.9903F, -1.4416F, 6.0F, 10.0F, 5.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 16.0922F, -5.6373F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		bottle4_r1 = new ModelRenderer(this);
		bottle4_r1.setPos(0.0F, 7.9972F, -5.6445F);
		leftfront.addChild(bottle4_r1);
		setRotationAngle(bottle4_r1, 0.3054F, -2.0944F, 0.0F);
		bottle4_r1.texOffs(28, 53).addBox(-1.8515F, -6.0308F, 23.8376F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		bottle4_r1.texOffs(36, 52).addBox(-1.8515F, -7.0308F, 26.8376F, 4.0F, 6.0F, 11.0F, 0.0F, false);
		bottle4_r1.texOffs(0, 44).addBox(-2.8515F, -12.0308F, 29.8376F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		bottle4_r1.texOffs(12, 9).addBox(-1.8515F, -12.0308F, 35.8376F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bottle4_r1.texOffs(58, 45).addBox(-1.8515F, -13.0308F, 22.8376F, 4.0F, 3.0F, 7.0F, 0.0F, false);
		bottle4_r1.texOffs(0, 9).addBox(-0.3515F, -11.6308F, -10.1624F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bottle4_r1.texOffs(0, 9).addBox(-0.8515F, -12.0308F, -3.1624F, 2.0F, 2.0F, 27.0F, 0.0F, false);

		bottle4_r2 = new ModelRenderer(this);
		bottle4_r2.setPos(0.0F, 7.9972F, -5.6445F);
		leftfront.addChild(bottle4_r2);
		setRotationAngle(bottle4_r2, -2.9234F, -1.0472F, 3.1416F);
		bottle4_r2.texOffs(29, 35).addBox(-1.8415F, -11.0308F, 36.8376F, 4.0F, 7.0F, 2.0F, 0.0F, false);

		bottle6_r1 = new ModelRenderer(this);
		bottle6_r1.setPos(-29.1756F, -0.9788F, -20.6883F);
		leftfront.addChild(bottle6_r1);
		setRotationAngle(bottle6_r1, -2.0135F, -0.987F, -2.8534F);
		bottle6_r1.texOffs(40, 48).addBox(-3.0F, -17.0F, -2.4F, 2.0F, 7.0F, 4.0F, 0.0F, false);

		bottle5_r1 = new ModelRenderer(this);
		bottle5_r1.setPos(-30.7678F, -3.4017F, -18.9228F);
		leftfront.addChild(bottle5_r1);
		setRotationAngle(bottle5_r1, -2.2602F, -1.0831F, -2.8456F);
		bottle5_r1.texOffs(46, 56).addBox(-4.0F, -19.0F, -8.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bottle10_r1 = new ModelRenderer(this);
		bottle10_r1.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle10_r1);
		setRotationAngle(bottle10_r1, -2.7498F, -0.9857F, -3.0417F);
		bottle10_r1.texOffs(36, 49).addBox(-2.5F, -12.0F, 2.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		bottle9_r1 = new ModelRenderer(this);
		bottle9_r1.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle9_r1);
		setRotationAngle(bottle9_r1, 3.0098F, -0.9857F, -3.0417F);
		bottle9_r1.texOffs(41, 51).addBox(-2.5F, -12.0F, -11.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		bottle11_r1 = new ModelRenderer(this);
		bottle11_r1.setPos(-23.4963F, -3.7906F, -16.5612F);
		leftfront.addChild(bottle11_r1);
		setRotationAngle(bottle11_r1, -2.5317F, -0.9857F, -3.0417F);
		bottle11_r1.texOffs(36, 53).addBox(-2.99F, -13.0F, 3.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		bottle10_r2 = new ModelRenderer(this);
		bottle10_r2.setPos(-23.4963F, -3.7906F, -16.5612F);
		leftfront.addChild(bottle10_r2);
		setRotationAngle(bottle10_r2, 2.7916F, -0.9857F, -3.0417F);
		bottle10_r2.texOffs(36, 53).addBox(-2.99F, -16.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		bottle9_r2 = new ModelRenderer(this);
		bottle9_r2.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle9_r2);
		setRotationAngle(bottle9_r2, -3.0553F, -0.9857F, -3.0417F);
		bottle9_r2.texOffs(36, 49).addBox(-3.0F, -16.0F, -4.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		bottle9_r2.texOffs(33, 49).addBox(-3.0F, -13.0F, -4.0F, 2.0F, 4.0F, 7.0F, 0.0F, false);

		bottle7_r1 = new ModelRenderer(this);
		bottle7_r1.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle7_r1);
		setRotationAngle(bottle7_r1, -2.7498F, -0.9857F, -3.0417F);
		bottle7_r1.texOffs(36, 49).addBox(-3.0F, -8.0F, -1.0F, 2.0F, 4.0F, 7.0F, 0.0F, false);

		bottle6_r2 = new ModelRenderer(this);
		bottle6_r2.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle6_r2);
		setRotationAngle(bottle6_r2, -1.827F, -1.188F, 3.0082F);
		bottle6_r2.texOffs(44, 54).addBox(-5.0F, 5.0F, 4.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		bottle5_r2 = new ModelRenderer(this);
		bottle5_r2.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle5_r2);
		setRotationAngle(bottle5_r2, 0.3054F, -2.0944F, 0.8727F);
		bottle5_r2.texOffs(46, 56).addBox(-1.0F, 1.0F, 2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle5_r2.texOffs(46, 56).addBox(-1.0F, -5.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle5_r2.texOffs(46, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bottle5_r3 = new ModelRenderer(this);
		bottle5_r3.setPos(-27.7552F, -13.3629F, -23.3104F);
		leftfront.addChild(bottle5_r3);
		setRotationAngle(bottle5_r3, -0.1862F, 0.6229F, 0.1571F);
		bottle5_r3.texOffs(12, 9).addBox(-1.0941F, -1.5434F, -0.0194F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		bottle4_r3 = new ModelRenderer(this);
		bottle4_r3.setPos(5.4653F, 5.1466F, -33.1923F);
		leftfront.addChild(bottle4_r3);
		setRotationAngle(bottle4_r3, -0.5001F, -1.2518F, 0.7451F);
		bottle4_r3.texOffs(12, 9).addBox(-1.8515F, -12.0308F, 36.8376F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(1.0F, 2.5655F, 2.0944F);
		leftfront.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(46, 21).addBox(-3.02F, -14.4414F, -8.8882F, 6.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-1.3412F, 0.7311F, -0.8589F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3491F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(44, 59).addBox(-3.99F, -2.0F, -4.0F, 6.0F, 14.0F, 7.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-0.3412F, 6.8683F, -0.0207F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.6981F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(41, 61).addBox(-5.0F, -14.0F, -9.0F, 7.0F, 11.0F, 8.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(1.0F, 1.4807F, -0.0428F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.5672F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(22, 61).addBox(-2.01F, -2.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, -0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(22, 61).addBox(-2.0F, -16.0F, -5.0F, 7.0F, 12.0F, 7.0F, 0.0F, false);
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