package com.joy187.re8joymod.common.entity.model;
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelRe8Dimi<T extends EntityRe8Dimi> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer Rightbacktlib;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer Rightfrontlib;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer nail;
	private final ModelRenderer Rightnail_r1;
	private final ModelRenderer RightArm_r9;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer Leftlib;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer Leftfrontlib;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer LeftArm_r5;
	private final ModelRenderer LeftArm_r6;
	private final ModelRenderer LeftArm_r7;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public ModelRe8Dimi() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(-0.4444F, -23.0556F, -3.3889F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);


		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.4444F, 3.0556F, 5.3889F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.1309F, 0.0F, 0.0F);
		Head_r1.texOffs(62, 33).addBox(-4.0F, -9.9993F, -6.9476F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		Head_r1.texOffs(51, 0).addBox(-7.0F, -7.9993F, -6.9476F, 14.0F, 2.0F, 8.0F, 0.0F, false);
		Head_r1.texOffs(75, 43).addBox(-3.0F, -4.9993F, -10.9476F, 13.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r1.texOffs(87, 0).addBox(-12.0F, -4.9993F, -10.9476F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		Head_r1.texOffs(0, 77).addBox(-13.0F, -4.9993F, -10.9476F, 1.0F, 2.0F, 15.0F, 0.0F, false);
		Head_r1.texOffs(68, 66).addBox(9.0F, -5.9993F, -9.9476F, 3.0F, 1.0F, 14.0F, 0.0F, false);
		Head_r1.texOffs(0, 23).addBox(-12.0F, -5.9993F, -9.9476F, 21.0F, 2.0F, 14.0F, 0.0F, false);
		Head_r1.texOffs(32, 80).addBox(-4.0F, -5.9993F, -6.9476F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(56, 12).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 10.0F, 11.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 7.0F, 8.0F, 0.0F, false);
		Body.texOffs(0, 60).addBox(-6.0F, -3.0F, -7.0F, 12.0F, 6.0F, 11.0F, 0.0F, false);
		Body.texOffs(86, 33).addBox(-6.0F, -1.0F, 4.0F, 12.0F, 4.0F, 2.0F, 0.0F, false);
		Body.texOffs(44, 46).addBox(-8.0F, 2.0F, -7.0F, 16.0F, 5.0F, 14.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, 22.0F, 0.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.0436F, 0.0F);
		Body_r1.texOffs(0, 39).addBox(-8.0F, -9.0F, -8.0F, 16.0F, 11.0F, 13.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(0.0F, 9.0F, 0.0F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, -0.0436F, 0.0F);
		Body_r2.texOffs(0, 0).addBox(-9.0F, -4.0F, -9.0F, 18.0F, 8.0F, 15.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(0.0F, -16.0F, -0.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0436F, 0.0F);
		Body_r3.texOffs(88, 65).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(0.0F, -13.5654F, -6.5679F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 1.0036F, 0.0F, 0.0F);
		Body_r4.texOffs(64, 81).addBox(-5.0F, -0.5F, -4.0F, 10.0F, 5.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-9.0F, -10.0F, -1.0F);
		setRotationAngle(RightArm, -0.2182F, 0.0F, 0.0F);


		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(2.0F, -1.759F, -0.7541F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0436F, -0.1745F, 1.4399F);
		RightArm_r1.texOffs(90, 46).addBox(-3.9816F, -2.2586F, -3.0789F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Rightbacktlib = new ModelRenderer(this);
		Rightbacktlib.setPos(0.0F, 2.0F, 0.0F);
		RightArm.addChild(Rightbacktlib);


		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(3.0F, 0.644F, 3.0686F);
		Rightbacktlib.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.1745F, 0.0F, 0.0F);
		RightArm_r2.texOffs(0, 94).addBox(-5.0F, -6.9981F, -5.0872F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Rightfrontlib = new ModelRenderer(this);
		Rightfrontlib.setPos(0.0F, 0.0F, 0.0F);
		Rightbacktlib.addChild(Rightfrontlib);


		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-3.0422F, 18.6266F, -6.0745F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3054F, 0.0436F, 0.0873F);
		RightArm_r3.texOffs(0, 38).addBox(-0.1511F, -7.7229F, -1.5045F, 0.0F, 12.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.3491F, 0.0F, 0.0873F);
		RightArm_r4.texOffs(6, 38).addBox(-1.1702F, 4.3202F, -1.0721F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		RightArm_r4.texOffs(10, 0).addBox(-2.1702F, 3.3202F, -1.0721F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm_r4.texOffs(51, 3).addBox(-2.1702F, 3.3202F, -2.0721F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.6545F, 0.0F, -0.1745F);
		RightArm_r5.texOffs(4, 39).addBox(0.8391F, -3.262F, -0.014F, 1.0F, 12.0F, 0.0F, 0.0F, false);
		RightArm_r5.texOffs(9, 49).addBox(0.8391F, -3.262F, -0.014F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(-1.0774F, 11.6115F, -2.6201F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3491F, 0.0F, -0.1745F);
		RightArm_r6.texOffs(2, 39).addBox(-0.1609F, -0.9749F, 0.5562F, 1.0F, 12.0F, 0.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.3491F, 0.0F, -0.1745F);
		RightArm_r7.texOffs(51, 0).addBox(-0.1609F, -2.6589F, 1.4355F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -0.3491F, 0.0F, 0.0F);
		RightArm_r8.texOffs(0, 77).addBox(-2.0F, -6.6868F, -3.0746F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		nail = new ModelRenderer(this);
		nail.setPos(-1.3274F, 14.8615F, -4.6201F);
		Rightfrontlib.addChild(nail);
		setRotationAngle(nail, -0.0436F, 0.0F, 0.0F);


		Rightnail_r1 = new ModelRenderer(this);
		Rightnail_r1.setPos(0.25F, -3.25F, 0.0F);
		nail.addChild(Rightnail_r1);
		setRotationAngle(Rightnail_r1, -0.1745F, -0.6109F, -0.4363F);
		Rightnail_r1.texOffs(8, 38).addBox(-0.1281F, -0.5693F, -1.6828F, 0.0F, 11.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(0.25F, -3.25F, 0.0F);
		nail.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, -0.3491F, 0.0F, -0.4363F);
		RightArm_r9.texOffs(51, 10).addBox(0.3164F, -2.4682F, -1.5852F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(8.4442F, -8.8343F, -0.4302F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);


		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(-0.5558F, -3.3343F, -0.4302F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.0436F, -0.2182F, -1.4399F);
		LeftArm_r1.texOffs(88, 85).addBox(-0.0164F, -3.2557F, -2.0027F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Leftlib = new ModelRenderer(this);
		Leftlib.setPos(0.5558F, 2.5308F, -0.3245F);
		LeftArm.addChild(Leftlib);


		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.0F, -3.0F, 0.0F);
		Leftlib.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(17, 77).addBox(-2.0F, -5.4988F, -1.9302F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.0F, 4.0829F, -5.6691F);
		Leftlib.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.8727F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(16, 94).addBox(-1.0F, -9.076F, -3.2313F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		Leftfrontlib = new ModelRenderer(this);
		Leftfrontlib.setPos(0.0F, 1.0F, -2.0F);
		Leftlib.addChild(Leftfrontlib);


		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.8727F, 0.0F, 0.0F);
		LeftArm_r4.texOffs(0, 23).addBox(-2.0F, -9.076F, -3.2313F, 4.0F, 11.0F, 3.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(0.3084F, 2.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.8727F, 0.0F, 0.3054F);
		LeftArm_r5.texOffs(45, 46).addBox(0.4117F, 1.9822F, -3.162F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.9599F, 0.0F, 0.0F);
		LeftArm_r6.texOffs(45, 39).addBox(-1.0F, 2.0373F, -1.364F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(0.0F, 7.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -0.8727F, 0.0F, 0.0F);
		LeftArm_r7.texOffs(0, 0).addBox(-1.0F, -0.6472F, -6.2955F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);


		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9F, 5.0F, 0.0F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(64, 91).addBox(-3.9698F, -6.9878F, -1.7911F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);


		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-1.9F, 7.0F, 0.0F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.1745F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(91, 6).addBox(-0.0302F, -8.9988F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		   					//Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch
//		this.Head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
//		this.Head.yRot = p_225597_5_ * ((float)Math.PI / 180F);

		this.Head.yRot = netHeadYaw * 0.007453292F;
		this.Head.xRot = headPitch * 0.007453292F;
//		this.beak.xRot = this.head.xRot;
//		this.beak.yRot = this.head.yRot;
//		this.redThing.xRot = this.head.xRot;
//		this.redThing.yRot = this.head.yRot;
//		this.body.xRot = ((float)Math.PI / 2F);
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.4F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.4F * limbSwingAmount;

	}

//	protected Iterable<ModelRenderer> headParts() {
//	return ImmutableList.of(this.Head);
//}
//
//
//	protected Iterable<ModelRenderer> bodyParts() {
//		return ImmutableList.of(this.Body, this.LeftLeg, this.RightLeg, this.LeftArm, this.RightArm);
//	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot= y;
		modelRenderer.zRot = z;
	}

//	@Override
//	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
//		Head.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//		Body.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//		RightArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//		LeftArm.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//		RightLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//		LeftLeg.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
//
//	}

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