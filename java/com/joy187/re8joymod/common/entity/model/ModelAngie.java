// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityAngie;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelAngie<T extends EntityAngie> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelAngie() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -2.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.48F);


		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.0F, -4.0F, 0.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.3927F, 0.0F, -0.48F);
		Head_r1.texOffs(12, 34).addBox(-2.9869F, 5.8325F, -4.2833F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		Head_r1.texOffs(28, 6).addBox(-5.9869F, 3.8325F, -5.2833F, 8.0F, 1.0F, 5.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-1.6708F, 2.5075F, 2.7616F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.6109F, 0.0F, -0.48F);
		Head_r2.texOffs(38, 27).addBox(-2.5F, -2.0F, -0.5F, 9.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-1.3136F, -4.3577F, -0.3827F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.3927F, 0.0F, -0.48F);
		Head_r3.texOffs(34, 0).addBox(-5.9869F, 4.8325F, -5.2833F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(4.5323F, 0.8459F, 0.1225F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.3927F, 0.0F, -0.829F);
		Head_r4.texOffs(34, 0).addBox(-0.5F, -2.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(0.0F, -5.0F, 0.0F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.3927F, 0.0F, -0.48F);
		Head_r5.texOffs(47, 38).addBox(-4.9869F, 5.8325F, -5.2833F, 5.0F, 4.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(34, 13).addBox(-3.0F, 6.0F, -2.0F, 6.0F, 9.0F, 4.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, 8.5F, -3.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, -0.7418F, 0.0F, 0.0F);
		Body_r1.texOffs(21, 59).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 3.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.6109F, 0.0F);


		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.3214F, 3.9298F, 0.5767F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.8727F, -0.1309F, 0.0873F);
		RightArm_r1.texOffs(39, 52).addBox(1.0388F, 3.5366F, 3.775F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-0.5F, 4.0F, 0.5F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.0F, -0.3491F, 0.0F);
		RightArm_r2.texOffs(38, 54).addBox(0.797F, -1.076F, -0.6841F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(4.0F, 3.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);


		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.2227F, 3.9392F, 0.3999F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.9163F, 0.0F, -0.2618F);
		LeftArm_r1.texOffs(39, 51).addBox(-2.7658F, 4.7006F, 2.615F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.0873F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(39, 53).addBox(-1.5F, -1.0373F, -1.1093F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);


		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(-0.7933F, 0.2683F, 0.5F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, 0.0F, 0.0F, 0.2182F);
		Rightll_r1.texOffs(27, 40).addBox(0.732F, 1.7511F, -2.4535F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-2.0796F, 3.9313F, -2.0F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0F, -0.2618F, 0.4363F);
		RightLeg_r1.texOffs(0, 34).addBox(2.6872F, 1.5456F, -0.4984F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);


		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(0.5087F, 8.0493F, 0.5824F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, -3.098F, 0.0F, -0.3491F);
		Leftll_r1.texOffs(0, 38).addBox(-1.3471F, -4.5981F, -1.1678F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.0F, 0.0F, -0.0873F);
		LeftLeg_r1.texOffs(25, 37).addBox(-1.6027F, -1.6129F, -0.6323F, 2.0F, 6.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.Body.yRot = netHeadYaw * 0.017453292F;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.4662F + (float)Math.PI) * 0.4F * limbSwingAmount;

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