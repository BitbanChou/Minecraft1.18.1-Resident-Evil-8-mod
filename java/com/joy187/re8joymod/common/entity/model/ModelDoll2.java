// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityDoll2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDoll2<T extends EntityDoll2> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Body;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer RightArm;
	private final ModelRenderer hand1_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer hand2_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer scissors;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer scissors2;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer scissors5;
	private final ModelRenderer Body_r11;
	private final ModelRenderer Body_r12;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer scissors3;
	private final ModelRenderer Body_r16;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer Body_r19;
	private final ModelRenderer Body_r20;
	private final ModelRenderer scissors6;
	private final ModelRenderer Body_r21;
	private final ModelRenderer Body_r22;
	private final ModelRenderer Body_r23;
	private final ModelRenderer Body_r24;
	private final ModelRenderer Body_r25;
	private final ModelRenderer scissors4;
	private final ModelRenderer Body_r26;
	private final ModelRenderer Body_r27;
	private final ModelRenderer Body_r28;
	private final ModelRenderer Body_r29;
	private final ModelRenderer Body_r30;
	private final ModelRenderer LeftLeg;

	public ModelDoll2() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 3.0F, 0.0F);
		setRotationAngle(Head, 0.0262F, 0.0873F, 0.48F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-2.3F, -8.3897F, -0.6637F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.3927F, 0.0F, -0.48F);
		Head_r1.texOffs(12, 34).addBox(-2.9947F, 2.933F, -3.5133F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(2.862F, -0.0131F, -0.2873F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0436F, -0.2618F, 0.7854F);
		Head_r2.texOffs(22, 39).addBox(-7.8446F, -2.3705F, -1.8117F, 4.0F, 1.0F, 4.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-3.3046F, -0.2123F, -1.0511F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0873F, 0.2618F, -1.5708F);
		Head_r3.texOffs(21, 38).addBox(0.6472F, -1.8488F, -1.7838F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-1.2197F, -2.2201F, -2.1883F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.3927F, 0.0F, -0.48F);
		Head_r4.texOffs(21, 40).addBox(-2.1079F, -3.7995F, -0.3417F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-2.3F, -9.3897F, -0.6637F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.3927F, 0.0F, -0.48F);
		Head_r5.texOffs(46, 0).addBox(-4.9947F, 2.933F, -4.5133F, 5.0F, 4.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(14, 5).addBox(-3.0F, 3.0F, -2.0F, 6.0F, 7.0F, 4.0F, 0.0F, false);
		Body.texOffs(10, 6).addBox(-5.0F, 10.0F, -3.0F, 11.0F, 4.0F, 6.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(4.4171F, 3.7881F, 2.5307F);
		Body.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.0F, -0.0436F, -0.0436F);
		Head_r6.texOffs(29, 11).addBox(-8.7F, -2.1F, -5.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(4.4171F, 3.7881F, 2.5307F);
		Body.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.2182F, 0.0F, 0.0873F);
		Head_r7.texOffs(36, 32).addBox(-9.0F, -3.1F, -5.5F, 8.0F, 1.0F, 6.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-4.0F, 7.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.6109F, 0.1309F);
		

		hand1_r1 = new ModelRenderer(this);
		hand1_r1.setPos(-0.5048F, 9.5604F, -0.3124F);
		RightArm.addChild(hand1_r1);
		setRotationAngle(hand1_r1, 0.0436F, -0.5236F, 0.1309F);
		hand1_r1.texOffs(43, 26).addBox(-1.4661F, -7.5085F, 0.3322F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.5F, 0.0608F, -0.1946F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0F, -0.3491F, 0.0F);
		RightArm_r1.texOffs(3, 3).addBox(-0.7568F, -3.9661F, -1.2676F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(4.0F, 3.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		hand2_r1 = new ModelRenderer(this);
		hand2_r1.setPos(3.5587F, 11.1608F, -1.4452F);
		LeftArm.addChild(hand2_r1);
		setRotationAngle(hand2_r1, 0.0436F, -0.5236F, -0.4363F);
		hand2_r1.texOffs(43, 26).addBox(-0.4527F, -5.2916F, 0.1843F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.0873F, 0.0F, -0.3491F);
		LeftArm_r1.texOffs(13, 16).addBox(-0.8649F, -3.9456F, -0.7377F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		scissors = new ModelRenderer(this);
		scissors.setPos(0.854F, 2.5063F, -2.2926F);
		RightLeg.addChild(scissors);
		setRotationAngle(scissors, 2.4871F, -3.0543F, -1.6144F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(10.9352F, 4.2291F, -2.1501F);
		scissors.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.1745F, 0.1309F);
		Body_r1.texOffs(48, 20).addBox(-4.9941F, -1.1412F, -0.3768F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(10.9883F, 3.7862F, -2.1501F);
		scissors.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.1745F, -0.0873F);
		Body_r2.texOffs(50, 25).addBox(-4.8957F, -0.7714F, -0.3594F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(7.1077F, 3.3033F, -1.4555F);
		scissors.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.1745F, 0.0873F);
		Body_r3.texOffs(45, 61).addBox(-0.9853F, -0.7687F, 0.0248F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r3.texOffs(10, 48).addBox(-4.9853F, -0.7687F, -0.3752F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(1.8679F, -1.3012F, -0.0663F);
		scissors.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.1745F, 0.9163F);
		Body_r4.texOffs(7, 47).addBox(-0.2481F, 1.4701F, -0.2452F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(1.8145F, -0.1179F, -0.0663F);
		scissors.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.1745F, 0.0F);
		Body_r5.texOffs(6, 53).addBox(-4.9513F, -1.022F, -0.3692F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors2 = new ModelRenderer(this);
		scissors2.setPos(3.854F, 5.5063F, -1.2926F);
		RightLeg.addChild(scissors2);
		setRotationAngle(scissors2, 0.0436F, -3.0543F, -1.6144F);
		

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors2.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, 0.1745F, 0.1309F);
		Body_r6.texOffs(48, 20).addBox(-4.6737F, -0.6358F, -1.811F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors2.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, 0.1745F, -0.0873F);
		Body_r7.texOffs(50, 25).addBox(-4.6845F, -0.2636F, -1.8129F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors2.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.1745F, 0.0873F);
		Body_r8.texOffs(45, 61).addBox(-0.6867F, -0.2609F, -1.4133F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r8.texOffs(10, 48).addBox(-4.6867F, -0.2609F, -1.8133F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors2.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.1745F, 1.2654F);
		Body_r9.texOffs(7, 47).addBox(1.278F, 2.2466F, -1.4669F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors2.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.1745F, 0.0F);
		Body_r10.texOffs(6, 53).addBox(-4.6964F, -0.5123F, -1.815F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors5 = new ModelRenderer(this);
		scissors5.setPos(3.854F, 5.5063F, -3.2926F);
		RightLeg.addChild(scissors5);
		setRotationAngle(scissors5, 1.1781F, 2.618F, -1.6144F);
		

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors5.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.1745F, 0.1309F);
		Body_r11.texOffs(48, 20).addBox(-4.7133F, 0.2741F, -0.6211F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors5.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.1745F, -0.0873F);
		Body_r12.texOffs(50, 25).addBox(-4.922F, 0.661F, -0.6579F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors5.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.1745F, 0.0873F);
		Body_r13.texOffs(45, 61).addBox(-0.7655F, 0.6555F, -0.2303F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r13.texOffs(10, 48).addBox(-4.7655F, 0.6555F, -0.6303F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors5.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.1745F, 1.2654F);
		Body_r14.texOffs(7, 47).addBox(1.9553F, 2.4792F, -0.1505F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors5.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, 0.1745F, 0.0F);
		Body_r15.texOffs(6, 53).addBox(-4.8544F, 0.4117F, -0.646F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors3 = new ModelRenderer(this);
		scissors3.setPos(3.854F, 5.5063F, 0.7074F);
		RightLeg.addChild(scissors3);
		setRotationAngle(scissors3, -0.6545F, 2.9671F, -1.6144F);
		

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors3.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0F, 0.1745F, 0.1309F);
		Body_r16.texOffs(48, 20).addBox(-4.6897F, 0.1875F, -1.0962F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors3.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.1745F, -0.0873F);
		Body_r17.texOffs(50, 25).addBox(-4.8785F, 0.5637F, -1.1295F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors3.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.1745F, 0.0873F);
		Body_r18.texOffs(45, 61).addBox(-0.7381F, 0.5664F, -0.7048F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r18.texOffs(10, 48).addBox(-4.7381F, 0.5664F, -1.1048F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors3.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.1745F, 1.2654F);
		Body_r19.texOffs(7, 47).addBox(1.9353F, 2.4963F, -0.6334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors3.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.1745F, 0.0F);
		Body_r20.texOffs(6, 53).addBox(-4.8191F, 0.3181F, -1.1191F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors6 = new ModelRenderer(this);
		scissors6.setPos(1.854F, 5.5063F, 0.7074F);
		RightLeg.addChild(scissors6);
		setRotationAngle(scissors6, -1.7453F, 2.9671F, -1.6144F);
		

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors6.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.1745F, 0.1309F);
		Body_r21.texOffs(48, 20).addBox(-4.6897F, 0.1875F, -1.0962F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors6.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.1745F, -0.0873F);
		Body_r22.texOffs(50, 25).addBox(-4.8785F, 0.5637F, -1.1295F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors6.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.1745F, 0.0873F);
		Body_r23.texOffs(45, 61).addBox(-0.7381F, 0.5664F, -0.7048F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r23.texOffs(10, 48).addBox(-4.7381F, 0.5664F, -1.1048F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors6.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.1745F, 1.2654F);
		Body_r24.texOffs(7, 47).addBox(1.9353F, 2.4963F, -0.6334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors6.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.1745F, 0.0F);
		Body_r25.texOffs(6, 53).addBox(-4.8191F, 0.3181F, -1.1191F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		scissors4 = new ModelRenderer(this);
		scissors4.setPos(0.854F, 5.5063F, -0.2926F);
		RightLeg.addChild(scissors4);
		setRotationAngle(scissors4, -2.618F, -3.0543F, -1.6144F);
		

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(6.8628F, 3.7687F, -2.0225F);
		scissors4.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.1745F, 0.1309F);
		Body_r26.texOffs(48, 20).addBox(-4.8916F, -0.2343F, -0.2709F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(6.9159F, 3.3258F, -2.0225F);
		scissors4.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, 0.1745F, -0.0873F);
		Body_r27.texOffs(50, 25).addBox(-4.9892F, 0.1399F, -0.2881F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(3.0352F, 2.8428F, -1.3279F);
		scissors4.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.0F, 0.1745F, 0.0873F);
		Body_r28.texOffs(45, 61).addBox(-0.9218F, 0.1425F, 0.1237F, 4.0F, 1.0F, 0.0F, 0.0F, false);
		Body_r28.texOffs(10, 48).addBox(-4.9218F, 0.1425F, -0.2763F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-0.21F, -2.6917F, 0.0613F);
		scissors4.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.1745F, 1.2654F);
		Body_r29.texOffs(7, 47).addBox(1.3885F, 2.3684F, 0.1311F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-1.1712F, -0.3808F, 0.0613F);
		scissors4.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.1745F, 0.0F);
		Body_r30.texOffs(6, 53).addBox(-4.9663F, -0.1073F, -0.2841F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.scissors.yRot = headPitch * 0.017453292F;
		this.scissors.zRot = headPitch * 0.017453292F;

		this.scissors2.xRot = headPitch * 0.017453292F;
		this.scissors3.xRot = headPitch * 0.020453292F;
		this.scissors4.zRot = headPitch * 0.017453292F;
		this.scissors5.yRot = headPitch * 0.008453292F;
		this.scissors6.xRot = headPitch * 0.020453292F;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;
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