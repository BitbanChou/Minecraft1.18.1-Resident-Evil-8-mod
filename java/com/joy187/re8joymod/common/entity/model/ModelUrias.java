// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntityUrias;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelUrias<T extends EntityUrias> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer Head_r8;
	private final ModelRenderer Head_r9;
	private final ModelRenderer Head_r10;
	private final ModelRenderer Head_r11;
	private final ModelRenderer Head_r12;
	private final ModelRenderer Head_r13;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer bottle3_r1;
	private final ModelRenderer bottle6_r1;
	private final ModelRenderer bottle6_r2;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelUrias() {
		texWidth = 80;
		texHeight = 80;

		Head = new ModelRenderer(this);
		Head.setPos(-2.0F, -20.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0076F, -6.0401F, -4.4085F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-1.5795F, 12.638F, -3.4642F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.3054F, -0.3054F, -0.829F);
		Head_r1.texOffs(41, 9).addBox(3.843F, -6.3561F, -5.5592F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-1.5795F, 12.638F, -3.4642F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.3054F, -0.3054F, -1.4399F);
		Head_r2.texOffs(49, 6).addBox(5.7716F, 0.9627F, -4.8351F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(5.5643F, 12.638F, -3.4642F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.3054F, 0.3054F, 1.4399F);
		Head_r3.texOffs(34, 0).addBox(-8.7716F, 1.9627F, 3.1649F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.1489F, 9.1456F, -3.6921F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.3054F, 0.48F, 0.1745F);
		Head_r4.texOffs(34, 0).addBox(-5.3393F, -7.5578F, -4.1719F, 3.0F, 1.0F, 1.0F, -1.0F, true);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(6.8382F, 9.959F, -4.7027F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, -0.3054F, -0.48F, -0.1745F);
		Head_r5.texOffs(34, 0).addBox(0.3393F, -7.5578F, -2.1719F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-3.8722F, 10.905F, -2.6039F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.3054F, -0.3054F, 0.0F);
		Head_r6.texOffs(34, 0).addBox(-3.7515F, -8.3481F, -4.6531F, 4.0F, 3.0F, 1.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(7.857F, 10.905F, -2.6039F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.3054F, 0.3054F, 0.0F);
		Head_r7.texOffs(43, 2).addBox(-2.2485F, -7.3481F, -5.6531F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(7.3702F, 4.727F, 0.1972F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, -0.3054F, 0.3054F, 0.829F);
		Head_r8.texOffs(42, 5).addBox(-2.343F, 3.6439F, -4.5592F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(8.8092F, 4.9847F, -3.2022F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, 0.0436F, -0.7418F, 0.0F);
		Head_r9.texOffs(43, 0).addBox(-4.0649F, -9.9755F, 0.2311F, 5.0F, 8.0F, 1.0F, 0.0F, true);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(8.1188F, 1.9969F, -0.9565F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, 0.0436F, -0.3054F, -1.0036F);
		Head_r10.texOffs(41, 10).addBox(4.6481F, -7.3936F, -3.1262F, 4.0F, 5.0F, 1.0F, 0.0F, true);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(-5.1092F, 3.6056F, -1.558F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, 0.0436F, 0.3054F, 1.0036F);
		Head_r11.texOffs(41, 0).addBox(-10.6481F, -7.3936F, -3.1262F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(-4.9565F, 4.2593F, -3.4265F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.0436F, 0.48F, 0.0F);
		Head_r12.texOffs(34, 8).addBox(-4.9351F, -10.9755F, 1.2311F, 7.0F, 10.0F, 0.0F, 0.0F, false);

		Head_r13 = new ModelRenderer(this);
		Head_r13.setPos(1.9924F, 5.916F, -3.0723F);
		Head.addChild(Head_r13);
		setRotationAngle(Head_r13, -0.3491F, 0.0F, 0.0F);
		Head_r13.texOffs(27, 0).addBox(-7.0F, -15.1904F, -4.007F, 12.0F, 7.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(23, 25).addBox(-8.0F, -16.0F, -6.0F, 17.0F, 12.0F, 14.0F, 0.0F, false);
		Body.texOffs(14, 59).addBox(-7.0F, -5.0F, -4.0F, 15.0F, 10.0F, 11.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-12.0F, -14.0F, 0.0F);
		setRotationAngle(RightArm, -0.48F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(1.0F, 16.4245F, 1.9169F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.6109F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-2.0F, -8.6492F, -7.3079F, 5.0F, 8.0F, 5.0F, 0.0F, false);

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
		

		bottle3_r1 = new ModelRenderer(this);
		bottle3_r1.setPos(0.0F, 7.9972F, -5.6445F);
		leftfront.addChild(bottle3_r1);
		setRotationAngle(bottle3_r1, 0.3054F, -2.0944F, 0.0F);
		bottle3_r1.texOffs(27, 35).addBox(-3.8515F, -10.0308F, 22.8376F, 8.0F, 7.0F, 18.0F, 0.0F, false);
		bottle3_r1.texOffs(0, 44).addBox(-2.8515F, -18.0308F, 29.8376F, 6.0F, 8.0F, 8.0F, 0.0F, false);
		bottle3_r1.texOffs(58, 45).addBox(-1.8515F, -17.0308F, 22.8376F, 4.0F, 7.0F, 7.0F, 0.0F, false);
		bottle3_r1.texOffs(0, 9).addBox(-0.8515F, -12.0308F, -3.1624F, 2.0F, 2.0F, 27.0F, 0.0F, false);

		bottle6_r1 = new ModelRenderer(this);
		bottle6_r1.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle6_r1);
		setRotationAngle(bottle6_r1, 0.3054F, -2.0944F, 0.8727F);
		bottle6_r1.texOffs(46, 56).addBox(-4.0F, -7.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-4.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-4.0F, 1.0F, 5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-1.0F, 3.0F, 5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-1.0F, 1.0F, 2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-1.0F, -5.0F, -4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bottle6_r2 = new ModelRenderer(this);
		bottle6_r2.setPos(-26.0155F, -3.2127F, -18.1837F);
		leftfront.addChild(bottle6_r2);
		setRotationAngle(bottle6_r2, 0.0873F, -2.0944F, 0.8727F);
		bottle6_r2.texOffs(46, 56).addBox(-4.0F, -2.0F, 2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(1.0F, 2.5655F, 2.0944F);
		leftfront.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(46, 21).addBox(-3.0F, -14.4414F, -8.8882F, 6.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-1.3412F, 0.7311F, -0.8589F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3491F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(44, 60).addBox(-4.0F, -2.0F, -3.0F, 6.0F, 14.0F, 7.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-0.3412F, 6.8683F, -0.0207F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.6981F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(41, 65).addBox(-5.0F, -14.0F, -8.0F, 7.0F, 11.0F, 8.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(1.0F, 1.4807F, -0.0428F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.5672F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(22, 61).addBox(-2.0F, -2.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);

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