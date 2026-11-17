// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityBeibaby;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelBeibaby<T extends EntityBeibaby> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer lum_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightFront;
	private final ModelRenderer bottle2_r1;
	private final ModelRenderer bottle3_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer bottle3_r2;
	private final ModelRenderer bottle2_r2;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightLeg_r3;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;
	private final ModelRenderer LeftLeg_r3;

	public ModelBeibaby() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(1.0F, -13.0F, 6.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0F, -4.0F, 0.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.2182F, 0.0F, 0.0F);
		Head_r1.texOffs(32, 0).addBox(-3.0F, 8.0F, -10.0F, 9.0F, 5.0F, 7.0F, 0.0F, false);
		Head_r1.texOffs(0, 0).addBox(-4.0F, 1.0F, -10.0F, 11.0F, 8.0F, 10.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(0, 30).addBox(-6.0F, -5.0F, -3.0F, 15.0F, 28.0F, 6.0F, 0.0F, false);
		Body.texOffs(0, 41).addBox(-5.0F, 6.0F, 3.0F, 13.0F, 17.0F, 6.0F, 0.0F, false);
		Body.texOffs(26, 45).addBox(-5.0F, 9.0F, -7.0F, 13.0F, 13.0F, 6.0F, 0.0F, false);
		Body.texOffs(0, 31).addBox(-3.0F, 16.0F, 5.0F, 8.0F, 7.0F, 24.0F, 0.0F, false);
		Body.texOffs(0, 35).addBox(-3.0F, -3.0F, 3.0F, 6.0F, 23.0F, 3.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, 19.5F, 32.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.2618F, 0.0F, 0.0F);
		Body_r1.texOffs(8, 29).addBox(-2.0F, -3.5F, -12.0F, 6.0F, 5.0F, 18.0F, 0.0F, false);

		lum_r1 = new ModelRenderer(this);
		lum_r1.setPos(-1.5F, -13.7511F, -4.0347F);
		Body.addChild(lum_r1);
		setRotationAngle(lum_r1, 0.3054F, 0.0F, 0.1309F);
		lum_r1.texOffs(36, 35).addBox(0.5F, 14.0F, -8.5F, 8.0F, 5.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-10.0F, 21.0387F, 0.2968F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-3.0F, 4.5387F, -1.2032F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.2182F, 0.0F, 1.1781F);
		RightArm_r1.texOffs(42, 6).addBox(-8.0F, -13.0F, 0.0F, 2.0F, 9.0F, 3.0F, 0.0F, false);

		RightFront = new ModelRenderer(this);
		RightFront.setPos(-3.0F, 3.9042F, -1.365F);
		RightArm.addChild(RightFront);
		setRotationAngle(RightFront, 0.5236F, 0.7418F, 0.6109F);
		

		bottle2_r1 = new ModelRenderer(this);
		bottle2_r1.setPos(7.0949F, 1.5584F, -3.3186F);
		RightFront.addChild(bottle2_r1);
		setRotationAngle(bottle2_r1, -0.1745F, 0.0F, 0.5672F);
		bottle2_r1.texOffs(32, 41).addBox(-9.5F, 4.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle3_r1 = new ModelRenderer(this);
		bottle3_r1.setPos(-3.9051F, 1.6737F, -1.785F);
		RightFront.addChild(bottle3_r1);
		setRotationAngle(bottle3_r1, -0.48F, 0.0F, 0.0F);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -1.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-3.4051F, -4.3284F, -0.5754F);
		RightFront.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -0.4363F, 0.0F, 0.0F);
		RightArm_r2.texOffs(52, 43).addBox(-1.0F, -4.0F, -1.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(11.0F, 15.0F, -1.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, -1.0472F);
		LeftArm_r1.texOffs(32, 48).addBox(3.0F, -7.0F, 0.0F, 2.0F, 9.0F, 3.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(9.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -1.1781F, 0.0F, 0.0F);
		

		bottle3_r2 = new ModelRenderer(this);
		bottle3_r2.setPos(-7.1439F, 7.9221F, -2.2932F);
		leftfront.addChild(bottle3_r2);
		setRotationAngle(bottle3_r2, -0.1745F, 0.0F, 0.5672F);
		bottle3_r2.texOffs(32, 41).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle2_r2 = new ModelRenderer(this);
		bottle2_r2.setPos(-5.6439F, 1.1438F, 0.456F);
		leftfront.addChild(bottle2_r2);
		setRotationAngle(bottle2_r2, -0.1745F, 0.0F, 0.0F);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, 8.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(0.0F, 9.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(1.0F, 9.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, 6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(-4.3431F, 3.6518F, -1.0982F);
		leftfront.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(52, 33).addBox(-2.0F, -7.0F, -2.0F, 3.0F, 13.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-5.9F, 20.0F, 16.0F);
		setRotationAngle(RightLeg, 1.501F, 0.2618F, 1.2566F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-0.5F, 10.0643F, -5.9783F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 1.5272F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(0, 60).addBox(-1.5F, 0.5F, -2.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-1.0F, 3.1681F, -0.4158F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.3927F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(16, 49).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(0.0F, 6.0F, 0.0F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, -0.6981F, 0.0F, 0.0F);
		RightLeg_r3.texOffs(16, 49).addBox(-2.0F, -8.0F, -5.0F, 3.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(5.9F, 21.0F, 16.0F);
		setRotationAngle(LeftLeg, 0.5672F, 0.0F, -1.3439F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(1.0F, 14.5106F, -8.6614F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 1.9199F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(0, 55).addBox(-2.0F, 7.0F, -4.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(1.0F, 3.8855F, 0.2078F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(16, 48).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, -0.1745F, 0.0F, 0.0F);
		LeftLeg_r3.texOffs(16, 48).addBox(-1.0F, -8.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.4F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.4F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.2F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.6F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.007453292F;
		this.Head.xRot = headPitch * 0.007453292F;

		this.Body_r1.xRot = headPitch * 0.005453292F;
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