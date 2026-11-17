package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntitySummonSturm;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class ModelSummonSturm<T extends EntitySummonSturm> extends EntityModel<T> {
    private final ModelRenderer Head;
    private final ModelRenderer Head_r1;
    private final ModelRenderer Head_r2;
    private final ModelRenderer pan;
    private final ModelRenderer Head_r3;
    private final ModelRenderer Head_r4;
    private final ModelRenderer Head_r5;
    private final ModelRenderer Head_r6;
    private final ModelRenderer Body;
    private final ModelRenderer RightArm;
    private final ModelRenderer RightArm_r1;
    private final ModelRenderer LeftArm;
    private final ModelRenderer LeftArm_r1;
    private final ModelRenderer RightLeg;
    private final ModelRenderer Rightll_r1;
    private final ModelRenderer RightLeg_r1;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer Leftll_r1;
    private final ModelRenderer LeftLeg_r1;

    public ModelSummonSturm() {
        texWidth = 64;
        texHeight = 64;

        Head = new ModelRenderer(this);
        Head.setPos(0.0F, -6.3465F, 0.1059F);
        setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
        Head.texOffs(3, 3).addBox(-3.5F, -6.6151F, -4.8376F, 7.0F, 6.0F, 7.0F, 0.0F, false);
        Head.texOffs(3, 3).addBox(-6.5F, -8.6151F, 2.1624F, 13.0F, 12.0F, 7.0F, 0.0F, false);
        Head.texOffs(38, 9).addBox(-1.0F, -3.6151F, -2.8376F, 2.0F, 5.0F, 3.0F, 0.0F, false);

        Head_r1 = new ModelRenderer(this);
        Head_r1.setPos(0.0F, 2.912F, -5.7491F);
        Head.addChild(Head_r1);
        setRotationAngle(Head_r1, 1.789F, 0.0F, 0.0F);
        Head_r1.texOffs(43, 9).addBox(-2.0F, 0.4528F, 1.9743F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        Head_r2 = new ModelRenderer(this);
        Head_r2.setPos(0.5F, -2.6151F, -4.8376F);
        Head.addChild(Head_r2);
        setRotationAngle(Head_r2, 0.0F, 0.0F, -0.6981F);
        Head_r2.texOffs(40, 0).addBox(-5.0F, -3.0F, -2.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);

        pan = new ModelRenderer(this);
        pan.setPos(0.4097F, -0.9741F, -8.1173F);
        Head.addChild(pan);


        Head_r3 = new ModelRenderer(this);
        Head_r3.setPos(-8.833F, -3.167F, 0.0683F);
        pan.addChild(Head_r3);
        setRotationAngle(Head_r3, 1.5708F, 1.7017F, 1.9635F);
        Head_r3.texOffs(28, 46).addBox(-1.5F, -1.5F, -7.5F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        Head_r4 = new ModelRenderer(this);
        Head_r4.setPos(0.0903F, 8.4008F, -0.1295F);
        pan.addChild(Head_r4);
        setRotationAngle(Head_r4, 1.3526F, 0.0F, 0.0F);
        Head_r4.texOffs(28, 46).addBox(-1.5F, -1.5F, -7.5F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        Head_r5 = new ModelRenderer(this);
        Head_r5.setPos(-0.4097F, 3.886F, 2.3682F);
        pan.addChild(Head_r5);
        setRotationAngle(Head_r5, 1.7017F, 0.0F, 0.0F);
        Head_r5.texOffs(35, 27).addBox(-1.0F, -1.91F, 3.4106F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        Head_r6 = new ModelRenderer(this);
        Head_r6.setPos(1.8697F, -0.5501F, 1.809F);
        pan.addChild(Head_r6);
        setRotationAngle(Head_r6, 1.9635F, -0.3927F, 0.6109F);
        Head_r6.texOffs(28, 46).addBox(-2.2172F, -1.1597F, -0.0266F, 3.0F, 3.0F, 16.0F, 0.0F, false);

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, 0.0F, 0.0F);
        Body.texOffs(15, 14).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 12.0F, 9.0F, 0.0F, false);
        Body.texOffs(15, 35).addBox(-4.0F, 5.0F, -4.0F, 8.0F, 4.0F, 7.0F, 0.0F, false);

        RightArm = new ModelRenderer(this);
        RightArm.setPos(-5.0F, 2.0F, 0.0F);


        RightArm_r1 = new ModelRenderer(this);
        RightArm_r1.setPos(-0.5F, -3.0F, 0.5F);
        RightArm.addChild(RightArm_r1);
        setRotationAngle(RightArm_r1, 0.0F, 0.0F, 0.1745F);
        RightArm_r1.texOffs(0, 44).addBox(-2.5F, -6.0F, -2.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

        LeftArm = new ModelRenderer(this);
        LeftArm.setPos(5.0F, 2.0F, 0.0F);
        setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);


        LeftArm_r1 = new ModelRenderer(this);
        LeftArm_r1.setPos(0.2819F, -1.487F, -0.1565F);
        LeftArm.addChild(LeftArm_r1);
        setRotationAngle(LeftArm_r1, -0.0873F, 0.0F, -0.1309F);
        LeftArm_r1.texOffs(12, 22).addBox(-1.4893F, -7.4368F, -1.5096F, 4.0F, 7.0F, 4.0F, 0.0F, false);

        RightLeg = new ModelRenderer(this);
        RightLeg.setPos(-1.9F, 12.0F, 0.0F);
        setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);


        Rightll_r1 = new ModelRenderer(this);
        Rightll_r1.setPos(-1.0296F, -0.2553F, -0.5716F);
        RightLeg.addChild(Rightll_r1);
        setRotationAngle(Rightll_r1, -0.1309F, 0.3054F, 0.0F);
        Rightll_r1.texOffs(17, 49).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);

        RightLeg_r1 = new ModelRenderer(this);
        RightLeg_r1.setPos(0.9308F, 2.6923F, -0.589F);
        RightLeg.addChild(RightLeg_r1);
        setRotationAngle(RightLeg_r1, 0.0873F, 0.1309F, 0.0F);
        RightLeg_r1.texOffs(45, 32).addBox(-4.4F, 0.0F, -3.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

        LeftLeg = new ModelRenderer(this);
        LeftLeg.setPos(1.9F, 12.0F, 0.0F);
        setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);


        Leftll_r1 = new ModelRenderer(this);
        Leftll_r1.setPos(2.3034F, 8.4945F, 1.7722F);
        LeftLeg.addChild(Leftll_r1);
        setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
        Leftll_r1.texOffs(44, 21).addBox(-3.1F, -4.0F, 1.5F, 3.0F, 9.0F, 4.0F, 0.0F, false);

        LeftLeg_r1 = new ModelRenderer(this);
        LeftLeg_r1.setPos(0.2034F, 2.4217F, 1.6726F);
        LeftLeg.addChild(LeftLeg_r1);
        setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
        LeftLeg_r1.texOffs(42, 23).addBox(-2.0F, -5.5F, -2.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
        this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;
        this.RightLeg_r1.yRot = headPitch * 0.017453292F;

        this.LeftArm.yRot= headPitch * 0.017453292F;
        this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.3F * limbSwingAmount;
        this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.3F * limbSwingAmount;

        this.pan.zRot = headPitch * 0.087453292F;

        this.Head.yRot = netHeadYaw * 0.027453292F;
        this.Head.xRot = headPitch * 0.027453292F;

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
        RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}