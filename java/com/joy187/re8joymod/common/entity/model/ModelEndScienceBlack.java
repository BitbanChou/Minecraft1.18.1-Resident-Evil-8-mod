package com.joy187.re8joymod.common.entity.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports
import com.joy187.re8joymod.common.entity.EntityEndScienceBlack;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelEndScienceBlack<T extends EntityEndScienceBlack> extends EntityModel<T>{

	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer headwear;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public ModelEndScienceBlack() {
		texWidth = 128;
		texHeight = 128;

		body = new ModelRenderer(this);
		body.setPos(0.0F, -15.0F, 0.0F);
		body.texOffs(50, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.texOffs(29, 29).addBox(-3.5F, 0.75F, -1.5F, 7.0F, 26.0F, 3.0F, 1.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -15.0F, 0.0F);
		head.texOffs(26, 10).addBox(-4.5F, -8.25F, -4.75F, 9.0F, 8.0F, 6.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(-4.0F, -8.25F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		headwear = new ModelRenderer(this);
		headwear.setPos(0.0F, -15.0F, 0.0F);
		headwear.texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(5.0F, -13.0F, 0.0F);
		right_arm.texOffs(49, 24).addBox(-11.5F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setPos(-5.0F, -13.0F, 0.0F);
		left_arm.texOffs(16, 32).addBox(9.75F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(2.0F, -6.0F, 0.0F);
		right_leg.texOffs(8, 32).addBox(-5.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setPos(-2.0F, -6.0F, 0.0F);
		left_leg.texOffs(0, 32).addBox(3.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.left_leg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
        this.right_leg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

        this.left_arm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
        this.right_arm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        headwear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}