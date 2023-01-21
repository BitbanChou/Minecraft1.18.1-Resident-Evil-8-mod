package com.joy187.re8joymod.common.items.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class DimiHat extends BipedModel {
	private final ModelRenderer Head;

//    ResourceLocation ourTexture = new ResourceLocation("modid:textures/yourpath/mycustomarmormodel.png");

	public DimiHat() {
		super(1F);
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(8.5556F, -27.0556F, -11.3889F);
		Head.texOffs(0, 23).addBox(-19.5556F, 18.0556F, 5.3889F, 23.0F, 3.0F, 14.0F, 0.0F, false);
		Head.texOffs(68, 66).addBox(0.4444F, 18.0556F, 5.3889F, 6.0F, 2.0F, 14.0F, 0.0F, false);
		Head.texOffs(0, 77).addBox(-21.5556F, 18.0556F, 4.3889F, 5.0F, 2.0F, 15.0F, 0.0F, false);
		Head.texOffs(79, 19).addBox(-20.5556F, 18.0556F, 4.3889F, 12.0F, 3.0F, 2.0F, 0.0F, false);
		Head.texOffs(75, 43).addBox(-11.5556F, 18.0556F, 4.3889F, 16.0F, 2.0F, 2.0F, 0.0F, false);
		Head.texOffs(73, 0).addBox(-17.5556F, 15.0556F, 8.3889F, 19.0F, 6.0F, 8.0F, 0.0F, false);
		Head.texOffs(0, 0).addBox(-12.5556F, 18.0556F, 8.3889F, 11.0F, 3.0F, 8.0F, 0.0F, false);

		this.head.addChild(Head);
	}


	public final DimiHat applyEntityStats(BipedModel defaultArmor){
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
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
//		super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay,red ,green,blue,alpha);

	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}



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


}