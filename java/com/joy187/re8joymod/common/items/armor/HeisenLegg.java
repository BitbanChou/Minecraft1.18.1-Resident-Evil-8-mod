// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.items.armor;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class HeisenLegg extends BipedModel {
	private final ModelRenderer Legg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public HeisenLegg() {
		super(1F);
		texWidth = 64;
		texHeight = 64;

		Legg = new ModelRenderer(this);
		Legg.setPos(0.0F, 24.0F, 0.0F);


		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, -2.0F, 0.0F);
		Legg.addChild(RightLeg);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);


		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(0.0F, 2.2798F, -2.1F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.4363F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(16, 49).addBox(-2.0F, -3.5F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, -2.0F, 0.0F);
		Legg.addChild(LeftLeg);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);


		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 5.8264F, 0.9848F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(16, 48).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);


		this.leftLeg.addChild(LeftLeg);
	}

	public final HeisenLegg applyEntityStats(BipedModel defaultArmor){
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
//		Legg.render(matrixStack, buffer, packedLight, packedOverlay);
//		copyModelAngles(this.Legg,this.Legg);
		super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay,red ,green,blue,alpha);
	}

	public BipedModel applySlot(EquipmentSlotType slot){
		Legg.visible = false;
		LeftLeg.visible = false;


		switch(slot){
			case LEGS:
				Legg.visible = true;
//				LeftLeg.visible = true;

				break;
			default:
				break;
		}

		return this;
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