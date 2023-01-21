// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityBeibaby;
import com.joy187.re8joymod.common.entity.EntityBela;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import java.util.function.Consumer;

public class ModelBela<T extends EntityBela> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer breast_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer knife;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelBela() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(3, 3).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Head.texOffs(43, 9).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 2.0F, 4.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 15).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 13.0F, 5.0F, 0.0F, false);
		Body.texOffs(35, 21).addBox(-4.0F, 12.0F, 1.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);

		breast_r1 = new ModelRenderer(this);
		breast_r1.setPos(0.0F, 3.5F, -3.0F);
		Body.addChild(breast_r1);
		setRotationAngle(breast_r1, -0.7418F, 0.0F, 0.0F);
		breast_r1.texOffs(15, 57).addBox(-3.0F, -1.5F, -1.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		RightArm.texOffs(1, 50).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

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
		RightArm_r2.setPos(-0.1896F, 4.7809F, -11.4821F);
		knife.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -1.5272F, 0.0F, 0.0F);
		RightArm_r2.texOffs(38, 35).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-0.1896F, 3.694F, -10.4538F);
		knife.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.5236F, 0.0F, 0.0F);
		RightArm_r3.texOffs(38, 35).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-0.6896F, 4.1755F, -6.6176F);
		knife.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, 0.1309F, 0.0F, 0.0F);
		RightArm_r4.texOffs(38, 35).addBox(0.0F, -1.766F, -2.6428F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.137F, 2.8774F, -8.8254F);
		knife.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, 0.8727F, 0.0F, 0.0873F);
		RightArm_r5.texOffs(38, 35).addBox(-0.5F, 0.5F, 0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.0F, 1.0F, -3.0F);
		knife.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.1745F, 0.0F, 0.0F);
		RightArm_r6.texOffs(34, 41).addBox(-0.5F, 0.5F, -3.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);

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