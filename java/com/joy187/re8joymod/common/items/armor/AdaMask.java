// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.items.armor;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class AdaMask extends BipedModel {
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

	public AdaMask() {
		super(1F);
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);


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

		this.head.addChild(Head);
	}

	public final AdaMask applyEntityStats(BipedModel defaultArmor){
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


	//	@Override
//	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//		//previously the render function, render code was moved to a method below
//	}
	public BipedModel applySlot(EquipmentSlotType slot){
		Head.visible = false;
		//        armorBody.showModel = false;
		//        armorRightArm.showModel = false;
		//        armorRightBoot.showModel = false;
		//        armorLeftBoot.showModel = false;

		switch(slot){
			case HEAD:
				Head.visible = true;
				break;
			default:
				break;
		}

		return this;
	}
	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay,red ,green,blue,alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	private final void copyModelAngles(ModelRenderer in, ModelRenderer out){
		out.xRot = in.xRot;
		out.yRot = in.yRot;
		out.zRot = in.zRot;
	}
}