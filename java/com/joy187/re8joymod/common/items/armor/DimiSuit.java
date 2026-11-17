package com.joy187.re8joymod.common.items.armor;
// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.joy187.re8joymod.common.items.armor.DimiHat;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class DimiSuit extends BipedModel {
	private final ModelRenderer bone;
	private final ModelRenderer BodyPart;
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
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer Rightbacktlib;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer Rightfrontlib;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer nail;
	private final ModelRenderer RightArm_r7;

	public DimiSuit() {
		super(1F);
		texWidth = 128;
		texHeight = 128;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 38.0F, 0.0F);
		

		BodyPart = new ModelRenderer(this);
		BodyPart.setPos(0.0F, -24.0F, 0.0F);
		bone.addChild(BodyPart);
		BodyPart.texOffs(56, 12).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 10.0F, 11.0F, 0.0F, false);
		BodyPart.texOffs(46, 65).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 7.0F, 8.0F, 0.0F, false);
		BodyPart.texOffs(0, 60).addBox(-6.0F, -3.0F, -7.0F, 12.0F, 6.0F, 11.0F, 0.0F, false);
		BodyPart.texOffs(86, 33).addBox(-6.0F, -1.0F, 4.0F, 12.0F, 4.0F, 2.0F, 0.0F, false);
		BodyPart.texOffs(44, 46).addBox(-8.0F, 2.0F, -7.0F, 16.0F, 5.0F, 14.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(8.4442F, -32.8343F, -0.4302F);
		bone.addChild(LeftArm);
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

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-9.0F, -34.0F, -1.0F);
		bone.addChild(RightArm);
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
		RightArm_r3.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3491F, 0.0F, 0.0873F);
		RightArm_r3.texOffs(10, 0).addBox(-2.1702F, 3.3202F, -1.0721F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm_r3.texOffs(51, 3).addBox(-2.1702F, 3.3202F, -2.0721F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.6545F, 0.0F, -0.1745F);
		RightArm_r4.texOffs(9, 49).addBox(0.8391F, -3.262F, -0.014F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.3491F, 0.0F, -0.1745F);
		RightArm_r5.texOffs(51, 0).addBox(-0.1609F, -2.6589F, 1.4355F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3491F, 0.0F, 0.0F);
		RightArm_r6.texOffs(0, 77).addBox(-2.0F, -6.6868F, -3.0746F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		nail = new ModelRenderer(this);
		nail.setPos(-1.3274F, 14.8615F, -4.6201F);
		Rightfrontlib.addChild(nail);
		setRotationAngle(nail, -0.0436F, 0.0F, 0.0F);
		

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.25F, -3.25F, 0.0F);
		nail.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.3491F, 0.0F, -0.4363F);
		RightArm_r7.texOffs(51, 10).addBox(0.3164F, -2.4682F, -1.5852F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		this.body.addChild(bone);
		this.leftArm.addChild(LeftArm);
		this.rightArm.addChild(RightArm);
	}

	public final DimiSuit applyEntityStats(BipedModel defaultArmor){
//        this.isSitting = defaultArmor.isSitting;
//        this.rightArmPose = defaultArmor.rightArmPose;
//        this.leftArmPose = defaultArmor.leftArmPose;

		this.leftArmPose = defaultArmor.leftArmPose;
		this.rightArmPose = defaultArmor.rightArmPose;
		this.crouching = defaultArmor.crouching;
		this.head.copyFrom(defaultArmor.head);
		this.hat.copyFrom(defaultArmor.hat);
		this.body.copyFrom(defaultArmor.body);
		this.rightArm.copyFrom(defaultArmor.rightArm);
		this.leftArm.copyFrom(defaultArmor.leftArm);
		this.rightLeg.copyFrom(defaultArmor.rightLeg);
		this.leftLeg.copyFrom(defaultArmor.leftLeg);
		return this;
	}

	@Override
	public void copyPropertiesTo(BipedModel p_217148_1_) {
		super.copyPropertiesTo(p_217148_1_);
		p_217148_1_.leftArmPose = this.leftArmPose;
		p_217148_1_.rightArmPose = this.rightArmPose;
		p_217148_1_.crouching = this.crouching;
		p_217148_1_.head.copyFrom(this.head);
		p_217148_1_.hat.copyFrom(this.hat);
		p_217148_1_.body.copyFrom(this.body);
		p_217148_1_.rightArm.copyFrom(this.rightArm);
		p_217148_1_.leftArm.copyFrom(this.leftArm);
		p_217148_1_.rightLeg.copyFrom(this.rightLeg);
		p_217148_1_.leftLeg.copyFrom(this.leftLeg);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
//		super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay,red ,green,blue,alpha);

	}



	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public BipedModel applySlot(EquipmentSlotType slot){
		bone.visible = false;
		switch(slot){
			case CHEST:
				bone.visible = true;
				break;
			default:
				break;
		}

		return this;
	}
}