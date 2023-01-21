// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.items.armor;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class HeisenHead extends BipedModel {
	private final ModelRenderer Head;

	public HeisenHead() {
		super(1F);
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(30, 0).addBox(0.0F, -8.0F, -1.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(-5.0F, -8.0F, -1.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(-5.0F, -8.0F, -6.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		Head.texOffs(33, 2).addBox(0.0F, -8.0F, -6.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		Head.texOffs(32, 0).addBox(-3.0F, -10.0F, -4.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);
		this.head.addChild(Head);
	}

	public final HeisenHead applyEntityStats(BipedModel defaultArmor){
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