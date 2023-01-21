package com.joy187.re8joymod.common.items.armor;

// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class MirandaMask extends BipedModel {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer Head_r8;
	private final ModelRenderer Head_r9;
	private final ModelRenderer Head_r10;
	private final ModelRenderer Head_r11;
	private final ModelRenderer Head_r12;
	private final ModelRenderer Head_r13;
	private final ModelRenderer Head_r14;
	private final ModelRenderer Head_r15;
	private final ModelRenderer Head_r16;
	private final ModelRenderer Head_r17;
	private final ModelRenderer Head_r18;
	private final ModelRenderer Head_r19;

	public MirandaMask() {
		super(1F);
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(-0.4444F, -2.0556F, -2.3889F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(2.3175F, -3.4454F, 4.533F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.1309F, -1.5708F);
		Head_r1.texOffs(35, 0).addBox(-0.0003F, -4.9993F, -7.9215F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(43, 1).addBox(-7.0003F, -2.9993F, -7.9215F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-0.9873F, 4.6244F, -1.9165F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.1074F, 0.0749F, -2.5348F);
		Head_r2.texOffs(43, 1).addBox(-0.4266F, 0.8189F, -0.4738F, 3.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-1.6745F, 0.7548F, -2.4259F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.0844F, 0.1002F, -2.2732F);
		Head_r3.texOffs(43, 1).addBox(-0.7342F, -1.8574F, -0.4738F, 4.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.2885F, 0.6526F, -2.4394F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.1074F, 0.0749F, -2.5348F);
		Head_r4.texOffs(43, 1).addBox(-2.9266F, -0.6811F, -0.4738F, 6.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-2.6633F, 0.7278F, -2.4295F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, -0.1249F, 0.0393F, -2.8386F);
		Head_r5.texOffs(43, 1).addBox(-2.1994F, 0.4534F, -0.4738F, 5.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-2.9267F, -0.701F, -2.6176F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.0172F, -0.1298F, 1.7028F);
		Head_r6.texOffs(43, 1).addBox(-2.4911F, 1.6305F, -0.4738F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(-2.6633F, 0.7278F, -2.4295F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.1304F, -0.0114F, 3.0551F);
		Head_r7.texOffs(43, 1).addBox(-2.5871F, 1.4959F, -0.4738F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Head_r7.texOffs(43, 1).addBox(-2.5871F, 0.4959F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(2.1047F, -1.8234F, -2.7653F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, -0.0503F, 0.1209F, -1.9665F);
		Head_r8.texOffs(43, 1).addBox(-1.5764F, 1.8826F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(-0.9848F, -1.9144F, -3.3962F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, 0.4002F, -0.0539F, 1.8047F);
		Head_r9.texOffs(43, 1).addBox(-2.4717F, 3.692F, -0.9379F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-4.8558F, -3.5191F, -0.3746F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.0401F, -0.4463F, 1.8201F);
		Head_r10.texOffs(43, 1).addBox(-1.9145F, -0.493F, -0.6687F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(4.7447F, -3.5191F, -0.3746F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, -0.0401F, 0.4463F, -1.8201F);
		Head_r11.texOffs(43, 1).addBox(-0.0855F, -0.493F, -0.6687F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(0.8737F, -1.9144F, -3.3962F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.4002F, 0.0539F, -1.8047F);
		Head_r12.texOffs(43, 1).addBox(-0.5283F, 3.692F, -0.9379F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r13 = new ModelRenderer(this);
		Head_r13.setPos(0.8762F, 4.6244F, -1.9165F);
		Head.addChild(Head_r13);
		setRotationAngle(Head_r13, -0.1074F, -0.0749F, 2.5348F);
		Head_r13.texOffs(43, 1).addBox(-2.5734F, 0.8189F, -0.4738F, 3.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r14 = new ModelRenderer(this);
		Head_r14.setPos(1.5634F, 0.7548F, -2.4259F);
		Head.addChild(Head_r14);
		setRotationAngle(Head_r14, -0.0844F, -0.1002F, 2.2732F);
		Head_r14.texOffs(43, 1).addBox(-3.2658F, -1.8574F, -0.4738F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r15 = new ModelRenderer(this);
		Head_r15.setPos(2.1774F, 0.6526F, -2.4394F);
		Head.addChild(Head_r15);
		setRotationAngle(Head_r15, -0.1074F, -0.0749F, 2.5348F);
		Head_r15.texOffs(43, 1).addBox(-3.0734F, -0.6811F, -0.4738F, 6.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r16 = new ModelRenderer(this);
		Head_r16.setPos(2.5521F, 0.7278F, -2.4295F);
		Head.addChild(Head_r16);
		setRotationAngle(Head_r16, -0.1249F, -0.0393F, 2.8386F);
		Head_r16.texOffs(43, 1).addBox(-2.8006F, 0.4534F, -0.4738F, 5.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r17 = new ModelRenderer(this);
		Head_r17.setPos(2.5521F, 0.7278F, -2.4295F);
		Head.addChild(Head_r17);
		setRotationAngle(Head_r17, -0.1304F, 0.0114F, -3.0551F);
		Head_r17.texOffs(43, 1).addBox(-1.4129F, 0.4959F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r17.texOffs(43, 1).addBox(-2.4129F, 1.4959F, -0.4738F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r18 = new ModelRenderer(this);
		Head_r18.setPos(-3.0404F, -2.761F, 4.6231F);
		Head.addChild(Head_r18);
		setRotationAngle(Head_r18, -0.1074F, -0.0749F, 2.5348F);
		Head_r18.texOffs(37, 0).addBox(-7.5734F, -2.1804F, -7.9215F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r19 = new ModelRenderer(this);
		Head_r19.setPos(-0.5556F, 3.0556F, 5.3889F);
		Head.addChild(Head_r19);
		setRotationAngle(Head_r19, 0.1188F, -0.0552F, 0.4331F);
		Head_r19.texOffs(37, 0).addBox(-7.4225F, -5.9053F, -7.9215F, 5.0F, 1.0F, 1.0F, 0.0F, false);
	}

	public final MirandaMask applyEntityStats(BipedModel defaultArmor){
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
		copyModelAngles(this.Head,this.Head);
	}

	public BipedModel applySlot(EquipmentSlotType slot){
		Head.visible = false;
		switch(slot){
			case HEAD:
				Head.visible = true;
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