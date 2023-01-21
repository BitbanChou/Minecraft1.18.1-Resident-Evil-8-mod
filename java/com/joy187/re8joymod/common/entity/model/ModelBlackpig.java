package com.joy187.re8joymod.common.entity.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.joy187.re8joymod.common.entity.EntityBp;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelBlackpig<T extends EntityBp> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public ModelBlackpig() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(-1.0F, 10.0F, -11.0F);
		setRotationAngle(Head, -0.0611F, 0.0873F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0375F, 0.9002F, 0.9395F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.1309F, -0.0436F, 0.0F);
		Head_r1.texOffs(0, 11).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 11).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(-0.75F, 18.25F, 0.25F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.75F, -4.25F, -0.25F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 1.5272F, 0.0F, 0.0F);
		Body_r1.texOffs(36, 26).addBox(-1.0F, 7.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(0.75F, -4.25F, -0.25F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 1.5708F, 0.0F, 0.0F);
		Body_r2.texOffs(27, 25).addBox(-6.0F, -7.0F, -3.0F, 11.0F, 15.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 19.4668F, -3.1067F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(0.0F, -0.7914F, -0.2074F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.1745F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-2.0F, -2.035F, -2.5212F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(1.0F, 18.5026F, -3.5916F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, -0.3589F, -1.5474F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.2182F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-2.0F, -2.3146F, -0.7895F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(5.0F, -12.5682F, 1.9678F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-4.7986F, 17.5427F, 5.6753F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(3.0343F, 1.9758F, -0.6199F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3491F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(48, 50).addBox(-3.9651F, -5.0008F, -3.0174F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.7986F, 18.0914F, 5.4111F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.5279F, 1.1107F, -1.4446F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.1745F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(48, 50).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
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

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.1F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.1F * limbSwingAmount;
		this.RightLeg_r1.yRot = headPitch * 0.017453292F;

		this.LeftArm.yRot = headPitch * 0.017453292F;
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.Head.xRot = headPitch * 0.013453292F;
	}
}