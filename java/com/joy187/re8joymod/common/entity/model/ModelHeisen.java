// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityHeisen;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHeisen<T extends EntityHeisen> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer bottle1_r1;
	private final ModelRenderer bottle2_r1;
	private final ModelRenderer bottle4_r1;
	private final ModelRenderer bottle3_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer cigar_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelHeisen() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.texOffs(30, 0).addBox(0.0F, -8.0F, -1.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(-5.0F, -8.0F, -1.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(-5.0F, -8.0F, -6.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(0.0F, -8.0F, -6.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		Head.texOffs(32, 0).addBox(-3.0F, -10.0F, -4.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(14, 30).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		bottle1_r1 = new ModelRenderer(this);
		bottle1_r1.setPos(11.0F, 4.0513F, -1.0622F);
		RightArm.addChild(bottle1_r1);
		setRotationAngle(bottle1_r1, -0.1745F, 0.0F, 0.0F);
		bottle1_r1.texOffs(10, 9).addBox(-12.0F, 6.0F, -20.0F, 1.0F, 1.0F, 21.0F, 0.0F, false);

		bottle2_r1 = new ModelRenderer(this);
		bottle2_r1.setPos(11.0F, 5.0513F, 0.9378F);
		RightArm.addChild(bottle2_r1);
		setRotationAngle(bottle2_r1, -0.1745F, 0.0F, 0.0F);
		bottle2_r1.texOffs(46, 17).addBox(-13.0F, 1.0F, -27.0F, 4.0F, 10.0F, 5.0F, 0.0F, false);

		bottle4_r1 = new ModelRenderer(this);
		bottle4_r1.setPos(0.5734F, 12.9619F, -27.4594F);
		RightArm.addChild(bottle4_r1);
		setRotationAngle(bottle4_r1, -0.1745F, -0.6981F, 0.0873F);
		bottle4_r1.texOffs(46, 23).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		bottle3_r1 = new ModelRenderer(this);
		bottle3_r1.setPos(0.0F, 1.1442F, -24.2204F);
		RightArm.addChild(bottle3_r1);
		setRotationAngle(bottle3_r1, -0.1745F, -0.6981F, 0.0436F);
		bottle3_r1.texOffs(46, 23).addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-1.0F, 1.9654F, 0.2679F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.48F, 0.0F, 0.0F);
		RightArm_r1.texOffs(27, 36).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-1.0F, 4.0F, 0.0F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(40, 32).addBox(-2.0F, -6.0F, -1.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, -1.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(48, 52).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		cigar_r1 = new ModelRenderer(this);
		cigar_r1.setPos(0.0F, -0.9487F, -0.0622F);
		leftfront.addChild(cigar_r1);
		setRotationAngle(cigar_r1, -0.1745F, 0.0F, 0.0F);
		cigar_r1.texOffs(0, 43).addBox(-1.0F, 7.0F, -3.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		cigar_r1.texOffs(27, 36).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(0.0F, 4.9036F, -0.7637F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.2182F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(16, 49).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(0.0F, 2.2798F, -2.1F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.1745F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(16, 49).addBox(-2.0F, -3.5F, -1.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 8.6812F, -2.6453F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -0.0436F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(16, 50).addBox(-2.0F, -4.0F, -1.5F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, -0.4363F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(16, 48).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
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
}