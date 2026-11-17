// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityAda;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelAdawang<T extends EntityAda>  extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer hat;
	private final ModelRenderer mouth4_r1;
	private final ModelRenderer mouth8_r1;
	private final ModelRenderer mouth7_r1;
	private final ModelRenderer mouth6_r1;
	private final ModelRenderer mouth5_r1;
	private final ModelRenderer mouth6_r2;
	private final ModelRenderer mouth5_r2;
	private final ModelRenderer mouth4_r2;
	private final ModelRenderer mouth3_r1;
	private final ModelRenderer mouth2_r1;
	private final ModelRenderer mouth1_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer arrow;
	private final ModelRenderer arr3_r1;
	private final ModelRenderer arr2_r1;
	private final ModelRenderer arr1_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelAdawang() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setPos(0.0F, 0.0F, 0.0F);
		Head.addChild(hat);
		hat.texOffs(4, 39).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 5.0F, 2.0F, 0.0F, false);
		hat.texOffs(37, 40).addBox(1.0F, -2.0F, -6.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		hat.texOffs(47, 40).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		hat.texOffs(37, 40).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		mouth4_r1 = new ModelRenderer(this);
		mouth4_r1.setPos(0.0F, -3.8844F, -1.112F);
		hat.addChild(mouth4_r1);
		setRotationAngle(mouth4_r1, 0.5672F, 0.0F, 0.0F);
		mouth4_r1.texOffs(23, 37).addBox(-0.5F, -2.5F, -11.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		mouth8_r1 = new ModelRenderer(this);
		mouth8_r1.setPos(0.9703F, -3.5F, -4.2763F);
		hat.addChild(mouth8_r1);
		setRotationAngle(mouth8_r1, -3.1416F, 1.1781F, -3.1416F);
		mouth8_r1.texOffs(48, 42).addBox(-2.5F, 0.5F, -6.2F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		mouth7_r1 = new ModelRenderer(this);
		mouth7_r1.setPos(-0.9703F, -3.5F, -4.2763F);
		hat.addChild(mouth7_r1);
		setRotationAngle(mouth7_r1, -3.1416F, -1.1781F, 3.1416F);
		mouth7_r1.texOffs(8, 39).addBox(-0.5F, 0.5F, -6.2F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		mouth6_r1 = new ModelRenderer(this);
		mouth6_r1.setPos(-0.8813F, -3.5F, -0.1985F);
		hat.addChild(mouth6_r1);
		setRotationAngle(mouth6_r1, 0.0F, -1.1345F, 0.0F);
		mouth6_r1.texOffs(8, 39).addBox(-2.5F, 0.6F, -6.2F, 3.0F, 3.0F, 2.0F, 0.0F, true);

		mouth5_r1 = new ModelRenderer(this);
		mouth5_r1.setPos(0.8813F, -3.5F, -0.1985F);
		hat.addChild(mouth5_r1);
		setRotationAngle(mouth5_r1, 0.0F, 1.1345F, 0.0F);
		mouth5_r1.texOffs(4, 39).addBox(-0.5F, 0.6F, -6.2F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		mouth6_r2 = new ModelRenderer(this);
		mouth6_r2.setPos(-0.2418F, -4.0818F, -1.1421F);
		hat.addChild(mouth6_r2);
		setRotationAngle(mouth6_r2, 0.0F, 0.0F, 0.2618F);
		mouth6_r2.texOffs(13, 36).addBox(0.5F, -2.0F, -4.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		mouth5_r2 = new ModelRenderer(this);
		mouth5_r2.setPos(0.2418F, -4.0818F, -1.1421F);
		hat.addChild(mouth5_r2);
		setRotationAngle(mouth5_r2, 0.0F, 0.0F, -0.2618F);
		mouth5_r2.texOffs(4, 39).addBox(-3.5F, -2.0F, -4.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		mouth4_r2 = new ModelRenderer(this);
		mouth4_r2.setPos(0.0F, -4.0F, 0.0F);
		hat.addChild(mouth4_r2);
		setRotationAngle(mouth4_r2, 0.6981F, 0.0F, 0.0F);
		mouth4_r2.texOffs(23, 37).addBox(-0.5F, -4.0F, -7.0F, 1.0F, 0.0F, 5.0F, 0.0F, false);

		mouth3_r1 = new ModelRenderer(this);
		mouth3_r1.setPos(0.0F, -4.0F, 0.0F);
		hat.addChild(mouth3_r1);
		setRotationAngle(mouth3_r1, 0.5672F, 0.0F, 0.0F);
		mouth3_r1.texOffs(23, 37).addBox(-0.5F, -3.0F, -8.0F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		mouth2_r1 = new ModelRenderer(this);
		mouth2_r1.setPos(0.0F, -10.7078F, -8.8856F);
		hat.addChild(mouth2_r1);
		setRotationAngle(mouth2_r1, 1.309F, 0.0F, 0.0F);
		mouth2_r1.texOffs(27, 37).addBox(-0.5F, 0.0F, -13.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		mouth1_r1 = new ModelRenderer(this);
		mouth1_r1.setPos(0.0F, 1.0F, -11.0F);
		hat.addChild(mouth1_r1);
		setRotationAngle(mouth1_r1, 0.3491F, 0.0F, 0.0F);
		mouth1_r1.texOffs(27, 37).addBox(-0.5F, -0.9362F, 0.0467F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(14, 14).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, 6.0F, 0.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, -0.0998F, -0.1468F, 0.7298F);
		Body_r1.texOffs(43, 22).addBox(5.0F, 4.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r1.texOffs(43, 22).addBox(4.0F, 0.0F, 2.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(0.0F, 6.0F, 0.0F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.2618F, 0.0F, 0.0F);
		Body_r2.texOffs(18, 18).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		arrow = new ModelRenderer(this);
		arrow.setPos(0.0F, 6.0F, 0.0F);
		Body.addChild(arrow);
		

		arr3_r1 = new ModelRenderer(this);
		arr3_r1.setPos(2.8735F, 3.5087F, -2.1785F);
		arrow.addChild(arr3_r1);
		setRotationAngle(arr3_r1, 0.1343F, -0.9722F, 0.6145F);
		arr3_r1.texOffs(57, 55).addBox(5.0F, -5.0F, 3.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		arr2_r1 = new ModelRenderer(this);
		arr2_r1.setPos(-0.4733F, 0.4171F, 1.3342F);
		arrow.addChild(arr2_r1);
		setRotationAngle(arr2_r1, 0.0756F, -0.0599F, 0.7211F);
		arr2_r1.texOffs(57, 55).addBox(5.0F, -5.0F, 2.4F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		arr1_r1 = new ModelRenderer(this);
		arr1_r1.setPos(0.0F, 0.0F, 0.0F);
		arrow.addChild(arr1_r1);
		setRotationAngle(arr1_r1, -0.0989F, -0.0599F, 0.7211F);
		arr1_r1.texOffs(26, 9).addBox(5.0F, -2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-1.0F, 4.0F, 0.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.2182F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-1.0F, -6.0F, -1.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, -1.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-2.0F, -6.0F, -2.0F, 3.0F, 11.0F, 4.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(0.0F, 4.5936F, -2.9174F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3927F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(32, 50).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(0.0F, 6.0F, 0.0F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.6981F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(16, 48).addBox(-2.0F, -5.3F, -6.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 3.953F, 0.5264F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.5672F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(17, 51).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, -0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(16, 48).addBox(-2.0F, -7.0F, -3.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
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