package com.joy187.re8joymod.common.items.armor;
// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class FrankHead extends BipedModel {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;

	public FrankHead() {
		super(1F);
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(8.0F, -6.3465F, -9.8941F);
		Head.texOffs(1, 0).addBox(-11.5F, -1.6535F, 5.3715F, 8.0F, 8.0F, 7.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-11.0982F, -4.5124F, 6.5869F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.7854F, 0.0F, 0.0F);
		Head_r1.texOffs(8, 5).addBox(-1.0F, 2.8589F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-11.7132F, -6.6675F, 4.0419F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.7854F, 0.0F, 0.0F);
		Head_r2.texOffs(1, 36).addBox(-1.0F, 5.014F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-7.5F, -5.1261F, -1.1285F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0F, 0.0F, -0.3927F);
		Head_r3.texOffs(0, 50).addBox(-6.0F, 3.4726F, 5.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);

		this.head.addChild(Head);
	}

	public final FrankHead applyEntityStats(BipedModel defaultArmor){
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