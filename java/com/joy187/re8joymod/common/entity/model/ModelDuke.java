package com.joy187.re8joymod.common.entity.model;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.joy187.re8joymod.common.entity.EntityDuke;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDuke<T extends EntityDuke>  extends EntityModel<T>{
	private final ModelRenderer duke;
	private final ModelRenderer upbody;
	private final ModelRenderer head_r1;
	private final ModelRenderer rightlib;
	private final ModelRenderer rightarm_r1;
	private final ModelRenderer right1_r1;
	private final ModelRenderer leftlib;
	private final ModelRenderer leftarm_r1;
	private final ModelRenderer left_r1;
	private final ModelRenderer body;
	private final ModelRenderer leftl;
	private final ModelRenderer rightl;

	public ModelDuke() {
		texWidth = 128;
		texHeight = 128;

		duke = new ModelRenderer(this);
		duke.setPos(1.0F, 13.0F, -10.0F);
		setRotationAngle(duke, 0.0F, -1.5708F, 0.0F);
		

		upbody = new ModelRenderer(this);
		upbody.setPos(9.0F, -28.0F, 0.0F);
		duke.addChild(upbody);
		

		head_r1 = new ModelRenderer(this);
		head_r1.setPos(-1.0F, -3.0F, 0.0F);
		upbody.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, 1.5708F, 0.0F);
		head_r1.texOffs(0, 0).addBox(-8.0F, -11.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		rightlib = new ModelRenderer(this);
		rightlib.setPos(9.6499F, -20.8823F, -11.0774F);
		duke.addChild(rightlib);
		setRotationAngle(rightlib, -2.93F, -0.3361F, -1.6854F);
		

		rightarm_r1 = new ModelRenderer(this);
		rightarm_r1.setPos(-2.2667F, 4.3503F, 1.1162F);
		rightlib.addChild(rightarm_r1);
		setRotationAngle(rightarm_r1, 0.0F, 0.2182F, 1.309F);
		rightarm_r1.texOffs(82, 34).addBox(-5.7581F, -6.1022F, -2.1681F, 8.0F, 22.0F, 6.0F, 0.0F, false);

		right1_r1 = new ModelRenderer(this);
		right1_r1.setPos(8.4334F, 11.1148F, 10.2711F);
		rightlib.addChild(right1_r1);
		setRotationAngle(right1_r1, 0.0808F, 0.1348F, 1.4196F);
		right1_r1.texOffs(80, 41).addBox(-15.0F, 1.3969F, -13.4202F, 10.0F, 6.0F, 6.0F, 0.0F, false);

		leftlib = new ModelRenderer(this);
		leftlib.setPos(10.1153F, -21.4814F, 10.8706F);
		duke.addChild(leftlib);
		setRotationAngle(leftlib, 1.7017F, 0.0F, -0.1745F);
		

		leftarm_r1 = new ModelRenderer(this);
		leftarm_r1.setPos(-1.1195F, 1.3764F, -3.0166F);
		leftlib.addChild(leftarm_r1);
		setRotationAngle(leftarm_r1, -1.2654F, 0.1309F, 0.0F);
		leftarm_r1.texOffs(2, 34).addBox(-3.3474F, -5.0694F, -0.6758F, 8.0F, 22.0F, 6.0F, 0.0F, false);

		left_r1 = new ModelRenderer(this);
		left_r1.setPos(-5.6666F, 22.9407F, -8.406F);
		leftlib.addChild(left_r1);
		setRotationAngle(left_r1, -0.2182F, 0.0F, 0.0F);
		left_r1.texOffs(46, 51).addBox(0.0F, -26.0F, 1.0F, 10.0F, 6.0F, 6.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, -16.0F, 0.0F);
		duke.addChild(body);
		body.texOffs(27, 33).addBox(2.0F, -10.0F, -6.0F, 15.0F, 10.0F, 13.0F, 0.0F, false);
		body.texOffs(87, 90).addBox(3.0F, -10.0F, 6.0F, 13.0F, 10.0F, 4.0F, 0.0F, false);
		body.texOffs(87, 90).addBox(3.0F, -10.0F, -10.0F, 13.0F, 10.0F, 4.0F, 0.0F, false);
		body.texOffs(24, 58).addBox(-2.0F, 2.0F, -13.0F, 22.0F, 18.0F, 27.0F, 0.0F, false);
		body.texOffs(33, 39).addBox(0.0F, -3.0F, -10.0F, 18.0F, 7.0F, 21.0F, 0.0F, false);

		leftl = new ModelRenderer(this);
		leftl.setPos(9.0F, 0.0F, 3.0F);
		duke.addChild(leftl);
		leftl.texOffs(66, 99).addBox(-4.0F, 1.0F, -3.0F, 8.0F, 10.0F, 6.0F, 0.0F, false);

		rightl = new ModelRenderer(this);
		rightl.setPos(9.0F, -5.0F, -3.0F);
		duke.addChild(rightl);
		rightl.texOffs(34, 98).addBox(-4.0F, 7.0F, -3.0F, 8.0F, 9.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.leftl.zRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.rightl.zRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.leftlib.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.rightlib.zRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.upbody.yRot = netHeadYaw * 0.017453292F;
		this.upbody.xRot = headPitch * 0.017453292F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		duke.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}