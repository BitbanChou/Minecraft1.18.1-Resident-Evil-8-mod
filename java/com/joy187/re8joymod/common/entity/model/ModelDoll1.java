// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityDoll1;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDoll1<T extends EntityDoll1> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Body;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer move_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer hand1_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer hand2_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer scissors;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;
	private final ModelRenderer LeftLeg_r3;

	public ModelDoll1() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 3.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.48F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-2.3F, -8.3897F, -0.6637F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.3927F, 0.0F, -0.48F);
		Head_r1.texOffs(12, 34).addBox(-2.9869F, 5.8325F, -4.2833F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(0.1699F, -6.4495F, -1.8643F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.3927F, -1.1345F, -0.0873F);
		Head_r2.texOffs(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-1.7223F, -2.9771F, -1.5772F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.3927F, -0.3054F, -0.0873F);
		Head_r3.texOffs(11, 43).addBox(1.5F, -2.9F, -0.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r3.texOffs(40, 24).addBox(1.0F, -1.9F, -1.1F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r3.texOffs(28, 6).addBox(0.5F, -0.9F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.3F, -9.3897F, -0.6637F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.3927F, 0.0F, -0.48F);
		Head_r4.texOffs(0, 13).addBox(-4.9869F, 5.8325F, -5.2833F, 5.0F, 4.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(7, 0).addBox(-3.0F, 6.0F, -2.0F, 6.0F, 9.0F, 4.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(4.4171F, 6.7881F, 2.5307F);
		Body.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.3927F, -0.0436F, -0.0436F);
		Head_r5.texOffs(29, 11).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(4.4171F, 6.7881F, 2.5307F);
		Body.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.3927F, 0.0F, 0.0873F);
		Head_r6.texOffs(30, 18).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		move_r1 = new ModelRenderer(this);
		move_r1.setPos(-0.9071F, 10.5F, -2.1269F);
		Body.addChild(move_r1);
		setRotationAngle(move_r1, 0.0F, 1.8762F, 0.0F);
		move_r1.texOffs(14, 32).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 7.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.6109F, 0.0F);
		

		hand1_r1 = new ModelRenderer(this);
		hand1_r1.setPos(-0.5048F, 9.5604F, -0.3124F);
		RightArm.addChild(hand1_r1);
		setRotationAngle(hand1_r1, 0.0436F, -0.5236F, 0.1309F);
		hand1_r1.texOffs(43, 26).addBox(-0.4952F, -4.6749F, 0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 0.0608F, -0.1946F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0F, -0.3491F, 0.0F);
		RightArm_r1.texOffs(3, 3).addBox(-0.203F, -1.076F, -0.6841F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(4.0F, 3.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		hand2_r1 = new ModelRenderer(this);
		hand2_r1.setPos(0.5287F, 9.6418F, -1.1634F);
		LeftArm.addChild(hand2_r1);
		setRotationAngle(hand2_r1, 0.0436F, -0.5236F, 0.0436F);
		hand2_r1.texOffs(43, 26).addBox(-1.5287F, -1.5F, 0.1634F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.0873F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(13, 16).addBox(-1.5F, -1.0373F, -1.1093F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		scissors = new ModelRenderer(this);
		scissors.setPos(-2.5F, 7.0F, -4.0F);
		LeftArm.addChild(scissors);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(12.2304F, 4.5649F, -5.9772F);
		scissors.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.1745F, 0.1309F);
		Body_r1.texOffs(48, 20).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(12.2836F, 4.122F, -5.9772F);
		scissors.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.1745F, -0.0873F);
		Body_r2.texOffs(50, 25).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(8.4029F, 3.639F, -5.2826F);
		scissors.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.1745F, 0.0873F);
		Body_r3.texOffs(45, 61).addBox(2.0F, -0.5F, -0.1F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r3.texOffs(10, 48).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(8.842F, 7.5524F, -5.9772F);
		scissors.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.1745F, 1.3526F);
		Body_r4.texOffs(46, 13).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(9.2763F, 7.4508F, -5.9772F);
		scissors.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.1745F, 1.1345F);
		Body_r5.texOffs(47, 11).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(8.4029F, 3.639F, -5.2826F);
		scissors.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, 0.1745F, 1.309F);
		Body_r6.texOffs(36, 47).addBox(2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r6.texOffs(16, 49).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(3.1747F, -1.1832F, -3.8934F);
		scissors.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, 0.1745F, 0.5672F);
		Body_r7.texOffs(7, 47).addBox(2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(3.1213F, 0.0F, -3.8934F);
		scissors.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.1745F, 0.0F);
		Body_r8.texOffs(6, 53).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(0.354F, 0.5F, -1.5901F);
		scissors.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 1.0908F, 0.0F);
		Body_r9.texOffs(6, 50).addBox(-1.5F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-1.0F, 0.5F, 2.0F);
		scissors.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 1.4835F, 0.0F);
		Body_r10.texOffs(16, 47).addBox(-0.5F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(-0.7933F, 0.2683F, 0.5F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1745F, 0.0F, -0.0436F);
		Rightll_r1.texOffs(17, 4).addBox(0.732F, 1.7511F, -2.2535F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-3.1874F, 8.6749F, 0.8632F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.0436F, 0.0F, 0.1309F);
		LeftLeg_r1.texOffs(4, 27).addBox(-1.0F, -1.6749F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 0.0436F, 0.0F, -0.0873F);
		LeftLeg_r2.texOffs(4, 27).addBox(-1.6027F, 3.3871F, -0.4323F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(-0.0236F, 3.5F, 0.5824F);
		LeftLeg.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, 0.1745F, 0.0F, -0.0873F);
		LeftLeg_r3.texOffs(18, 5).addBox(-1.6027F, -1.6129F, -1.4323F, 2.0F, 6.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.scissors.yRot = headPitch * 0.017453292F;
		this.scissors.zRot = headPitch * 0.017453292F;

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