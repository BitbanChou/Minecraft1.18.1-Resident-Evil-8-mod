package com.joy187.re8joymod.common.items.armor;
// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class FrankBoots extends BipedModel {
	private final ModelRenderer Shoe;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;

	public FrankBoots() {
		super(1F);
		texWidth = 64;
		texHeight = 64;

		Shoe = new ModelRenderer(this);
		Shoe.setPos(2.9F, 12.0F, -1.0F);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(0.0F, 0.0F, 0.0F);
		Shoe.addChild(LeftLeg);
		setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.1122F, 10.0145F, 2.8444F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.2182F, 0.0F, 0.0436F);
		LeftLeg_r1.texOffs(19, 14).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-4.8F, 0.0F, 0.0F);
		//Shoe.addChildhild(RightLeg);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(-0.7034F, 0.0099F, -0.0408F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, 0.1745F, 0.0F, -0.0436F);
		Rightll_r1.texOffs(16, 15).addBox(-3.5F, 9.0F, -2.5F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		this.leftLeg.addChild(LeftLeg);
	}

	public BipedModel applySlot(EquipmentSlotType slot){
		Shoe.visible = false;
		LeftLeg.visible = false;
		RightLeg.visible = false;
		LeftLeg_r1.visible = false;
		Rightll_r1.visible = false;
//        armorBody.showModel = false;
//        armorRightArm.showModel = false;
//        armorRightBoot.showModel = false;
//        armorLeftBoot.showModel = false;

		switch(slot){
            case FEET:
                Shoe.visible = true;

				break;
			default:
				break;
		}

		return this;
	}

	public final FrankBoots applyEntityStats(BipedModel defaultArmor){
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
//		Shoe.render(matrixStack, buffer, packedLight, packedOverlay);
//		copyModelAngles(this.Shoe,this.Shoe);
		super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay,red ,green,blue,alpha);

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