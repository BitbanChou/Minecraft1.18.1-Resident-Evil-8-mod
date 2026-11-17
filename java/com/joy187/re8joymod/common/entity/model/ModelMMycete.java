// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMMycete;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelMMycete<T extends EntityMMycete> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer backArm_r1;
	private final ModelRenderer backArm_r2;
	private final ModelRenderer backArm_r3;
	private final ModelRenderer backArm_r4;
	private final ModelRenderer tente5;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer tente;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer Body_r12;
	private final ModelRenderer Body_r13;
	private final ModelRenderer tente2;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer tente4;
	private final ModelRenderer Body_r19;
	private final ModelRenderer Body_r20;
	private final ModelRenderer Body_r21;
	private final ModelRenderer tente7;
	private final ModelRenderer Body_r22;
	private final ModelRenderer Body_r23;
	private final ModelRenderer Body_r24;
	private final ModelRenderer Body_r25;
	private final ModelRenderer tente3;
	private final ModelRenderer Body_r26;
	private final ModelRenderer Body_r27;
	private final ModelRenderer Body_r28;
	private final ModelRenderer Body_r29;
	private final ModelRenderer Body_r30;
	private final ModelRenderer Body_r31;
	private final ModelRenderer Body_r32;
	private final ModelRenderer Body_r33;
	private final ModelRenderer Body_r34;
	private final ModelRenderer Body_r35;
	private final ModelRenderer Body_r36;
	private final ModelRenderer tente6;
	private final ModelRenderer Body_r37;
	private final ModelRenderer Body_r38;
	private final ModelRenderer Body_r39;
	private final ModelRenderer Body_r40;
	private final ModelRenderer Body_r41;
	private final ModelRenderer Body_r42;
	private final ModelRenderer Body_r43;
	private final ModelRenderer Body_r44;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightLeg_r3;
	private final ModelRenderer RightLeg_r4;
	private final ModelRenderer RightLeg_r5;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public ModelMMycete() {
		texWidth = 256;
		texHeight = 256;

		Head = new ModelRenderer(this);
		Head.setPos(-7.1F, -44.5438F, 19.5862F);
		setRotationAngle(Head, -0.1484F, 0.0873F, 0.0F);
		Head.texOffs(74, 19).addBox(-17.2737F, -17.1231F, -20.5922F, 32.0F, 32.0F, 32.0F, 0.0F, false);
		Head.texOffs(0, 30).addBox(11.0263F, -16.1231F, -18.5922F, 4.0F, 8.0F, 12.0F, 1.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(145, 108).addBox(-24.0F, -43.0F, 14.0F, 32.0F, 48.0F, 24.0F, 0.0F, false);

		backArm_r1 = new ModelRenderer(this);
		backArm_r1.setPos(-28.3494F, -20.8085F, 29.2998F);
		Body.addChild(backArm_r1);
		setRotationAngle(backArm_r1, -2.0071F, -0.0873F, 0.3054F);
		backArm_r1.texOffs(44, 56).addBox(2.5F, -21.5F, -6.5F, 4.0F, 20.0F, 8.0F, 0.0F, true);

		backArm_r2 = new ModelRenderer(this);
		backArm_r2.setPos(-25.4728F, -14.7772F, 53.986F);
		Body.addChild(backArm_r2);
		setRotationAngle(backArm_r2, -2.0071F, -0.1309F, -0.1745F);
		backArm_r2.texOffs(32, 48).addBox(-3.5F, -13.5F, -0.5F, 4.0F, 16.0F, 4.0F, 0.0F, true);

		backArm_r3 = new ModelRenderer(this);
		backArm_r3.setPos(16.4775F, -19.1616F, 50.8027F);
		Body.addChild(backArm_r3);
		setRotationAngle(backArm_r3, -2.0071F, 0.1309F, 0.1745F);
		backArm_r3.texOffs(32, 48).addBox(-3.5F, -13.5F, -0.5F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		backArm_r4 = new ModelRenderer(this);
		backArm_r4.setPos(16.5118F, -21.1369F, 28.249F);
		Body.addChild(backArm_r4);
		setRotationAngle(backArm_r4, -2.0071F, 0.3927F, -0.1745F);
		backArm_r4.texOffs(32, 48).addBox(-11.5F, -17.5F, -7.5F, 4.0F, 20.0F, 8.0F, 0.0F, false);

		tente5 = new ModelRenderer(this);
		tente5.setPos(2.0F, 16.0398F, 3.7938F);
		Body.addChild(tente5);
		setRotationAngle(tente5, 0.2618F, 0.0F, 0.0F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(-8.3509F, -151.2761F, 98.4882F);
		tente5.addChild(Body_r1);
		setRotationAngle(Body_r1, 1.2654F, -0.9599F, 0.0F);
		Body_r1.texOffs(9, 134).addBox(-35.437F, 19.8905F, -107.3705F, 4.0F, 4.0F, 18.0F, 0.0F, true);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(-17.9092F, -136.1811F, 128.4685F);
		tente5.addChild(Body_r2);
		setRotationAngle(Body_r2, 2.0944F, -0.9599F, 0.0F);
		Body_r2.texOffs(74, 235).addBox(-54.513F, -81.6613F, -73.1003F, 4.0F, 4.0F, 18.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(-38.5173F, -129.5204F, 92.5093F);
		tente5.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.7418F, 0.6981F, 0.0F);
		Body_r3.texOffs(29, 211).addBox(22.6481F, 63.3864F, -70.2138F, 4.0F, 4.0F, 19.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(-30.2368F, -135.4803F, 101.6637F);
		tente5.addChild(Body_r4);
		setRotationAngle(Body_r4, -0.7854F, 0.1745F, 0.0F);
		Body_r4.texOffs(2, 76).addBox(-3.5017F, 80.2055F, 40.5765F, 4.0F, 4.0F, 12.0F, 0.0F, true);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(-29.2177F, -123.0467F, 110.3229F);
		tente5.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.4363F, 0.1745F, 0.0F);
		Body_r5.texOffs(17, 203).addBox(-0.0017F, 62.0144F, -64.4094F, 4.0F, 4.0F, 20.0F, 0.0F, true);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(-31.3269F, -124.7372F, 115.3523F);
		tente5.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.4363F, -0.4363F, 0.0F);
		Body_r6.texOffs(0, 114).addBox(-20.0321F, 61.3514F, -74.5422F, 4.0F, 4.0F, 24.0F, 0.0F, true);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-15.3773F, -113.2801F, 92.9792F);
		tente5.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.2618F, -0.4363F, 0.0F);
		Body_r7.texOffs(0, 189).addBox(-25.0321F, 69.1157F, -56.7091F, 8.0F, 8.0F, 24.0F, 0.0F, true);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(-23.3936F, -92.7182F, 77.0434F);
		tente5.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.2618F, -0.4363F, 0.0F);
		Body_r8.texOffs(3, 94).addBox(-11.0321F, 52.1157F, -52.7091F, 8.0F, 12.0F, 12.0F, 0.0F, true);

		tente = new ModelRenderer(this);
		tente.setPos(-2.9533F, -55.3471F, 22.0183F);
		Body.addChild(tente);
		setRotationAngle(tente, 0.2182F, 0.5236F, 0.0F);
		

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-6.8501F, -69.0471F, 48.4201F);
		tente.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.2618F, 0.1745F, 0.0F);
		Body_r9.texOffs(3, 94).addBox(4.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(0.3236F, -1.9884F, 45.4055F);
		tente.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.8727F, 0.1745F, 0.0F);
		Body_r10.texOffs(3, 94).addBox(-0.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(0.3236F, -1.9884F, 45.4055F);
		tente.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0873F, 0.1745F, 0.0F);
		Body_r11.texOffs(3, 94).addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(-1.9111F, 8.8107F, 29.8528F);
		tente.addChild(Body_r12);
		setRotationAngle(Body_r12, 1.0036F, 0.1745F, 0.0F);
		Body_r12.texOffs(3, 94).addBox(-3.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, 0.0F, false);
		Body_r12.texOffs(3, 94).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(-5.9152F, -62.7973F, 47.9635F);
		tente.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.6981F, 0.1745F, 0.0F);
		Body_r13.texOffs(3, 94).addBox(4.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, 0.0F, false);

		tente2 = new ModelRenderer(this);
		tente2.setPos(-14.0467F, -55.3471F, 22.0183F);
		Body.addChild(tente2);
		setRotationAngle(tente2, 0.2182F, -0.5236F, 0.0F);
		

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(6.8501F, -69.0471F, 48.4201F);
		tente2.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.2618F, -0.1745F, 0.0F);
		Body_r14.texOffs(3, 94).addBox(-11.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, 0.0F, true);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-0.3236F, -1.9884F, 45.4055F);
		tente2.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.8727F, -0.1745F, 0.0F);
		Body_r15.texOffs(3, 94).addBox(-2.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(-0.3236F, -1.9884F, 45.4055F);
		tente2.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0873F, -0.1745F, 0.0F);
		Body_r16.texOffs(3, 94).addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, 0.0F, true);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(1.9111F, 8.8107F, 29.8528F);
		tente2.addChild(Body_r17);
		setRotationAngle(Body_r17, 1.0036F, -0.1745F, 0.0F);
		Body_r17.texOffs(3, 94).addBox(-2.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, 0.0F, true);
		Body_r17.texOffs(3, 94).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, 0.0F, true);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(5.9152F, -62.7973F, 47.9635F);
		tente2.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.6981F, -0.1745F, 0.0F);
		Body_r18.texOffs(3, 94).addBox(-10.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, 0.0F, true);

		tente4 = new ModelRenderer(this);
		tente4.setPos(-20.9156F, -41.6637F, 24.7039F);
		Body.addChild(tente4);
		

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(-2.8121F, -15.6759F, 15.4043F);
		tente4.addChild(Body_r19);
		setRotationAngle(Body_r19, -0.3455F, -1.4321F, 1.3814F);
		Body_r19.texOffs(3, 94).addBox(-1.0F, -17.0F, 12.0F, 3.0F, 17.0F, 3.0F, 0.0F, false);
		Body_r19.texOffs(3, 94).addBox(-2.0F, -1.0F, 6.0F, 4.0F, 4.0F, 14.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(-2.8121F, -15.6759F, 15.4043F);
		tente4.addChild(Body_r20);
		setRotationAngle(Body_r20, -0.3455F, -1.6939F, 1.3814F);
		Body_r20.texOffs(3, 94).addBox(-2.0F, -3.0F, -7.0F, 5.0F, 6.0F, 14.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(0.0F, 10.0F, 0.0F);
		tente4.addChild(Body_r21);
		setRotationAngle(Body_r21, -0.3455F, -1.083F, 1.3814F);
		Body_r21.texOffs(3, 94).addBox(1.0F, -17.0F, 9.0F, 6.0F, 8.0F, 14.0F, 0.0F, false);

		tente7 = new ModelRenderer(this);
		tente7.setPos(3.9156F, -41.6637F, 24.7039F);
		Body.addChild(tente7);
		

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(-13.8682F, -24.938F, 16.2358F);
		tente7.addChild(Body_r22);
		setRotationAngle(Body_r22, -1.1745F, 1.4321F, -1.3814F);
		Body_r22.texOffs(88, 237).addBox(-2.0F, -16.0F, 15.0F, 3.0F, 11.0F, 3.0F, 0.0F, true);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(2.8121F, -15.6759F, 15.4043F);
		tente7.addChild(Body_r23);
		setRotationAngle(Body_r23, -0.3455F, 1.4321F, -1.3814F);
		Body_r23.texOffs(3, 94).addBox(-2.0F, -17.0F, 12.0F, 3.0F, 17.0F, 3.0F, 0.0F, true);
		Body_r23.texOffs(3, 94).addBox(-2.0F, -1.0F, 6.0F, 4.0F, 4.0F, 14.0F, 0.0F, true);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(2.8121F, -15.6759F, 15.4043F);
		tente7.addChild(Body_r24);
		setRotationAngle(Body_r24, -0.3455F, 1.6939F, -1.3814F);
		Body_r24.texOffs(3, 94).addBox(-3.0F, -3.0F, -7.0F, 5.0F, 6.0F, 14.0F, 0.0F, true);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(0.0F, 10.0F, 0.0F);
		tente7.addChild(Body_r25);
		setRotationAngle(Body_r25, -0.3455F, 1.083F, -1.3814F);
		Body_r25.texOffs(3, 94).addBox(-9.0F, -17.0F, 9.0F, 8.0F, 8.0F, 14.0F, 0.0F, true);

		tente3 = new ModelRenderer(this);
		tente3.setPos(-13.9194F, -56.6247F, 38.5457F);
		Body.addChild(tente3);
		setRotationAngle(tente3, 0.5236F, 0.0873F, 0.0F);
		

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(6.7228F, -70.7694F, 24.8928F);
		tente3.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.2618F, -0.1745F, 0.0F);
		Body_r26.texOffs(3, 94).addBox(-11.0882F, 73.031F, -62.2574F, 7.0F, 9.0F, 12.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-19.3328F, 3.7858F, 30.2164F);
		tente3.addChild(Body_r27);
		setRotationAngle(Body_r27, 1.0908F, -0.9599F, 0.0F);
		Body_r27.texOffs(3, 94).addBox(0.5F, -11.5F, -1.5F, 3.0F, 3.0F, 9.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(-0.4509F, -3.7107F, 21.8782F);
		tente3.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.2618F, -0.9599F, 0.0F);
		Body_r28.texOffs(3, 94).addBox(-5.5F, 0.5F, -1.0F, 3.0F, 3.0F, 15.0F, 0.0F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-0.4509F, -3.7107F, 21.8782F);
		tente3.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.8727F, -0.1745F, 0.0F);
		Body_r29.texOffs(3, 94).addBox(-2.5F, 1.5F, 2.0F, 3.0F, 3.0F, 12.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-0.4509F, -3.7107F, 21.8782F);
		tente3.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0873F, -0.1745F, 0.0F);
		Body_r30.texOffs(3, 94).addBox(-2.5F, -0.5F, -9.0F, 5.0F, 3.0F, 19.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(1.7838F, 7.0883F, 6.3255F);
		tente3.addChild(Body_r31);
		setRotationAngle(Body_r31, 1.0036F, -0.1745F, 0.0F);
		Body_r31.texOffs(3, 94).addBox(-2.0F, 0.0F, 6.0F, 5.0F, 3.0F, 12.0F, 0.0F, true);
		Body_r31.texOffs(3, 94).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, 0.0F, true);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-7.0568F, 26.3494F, -12.9326F);
		tente3.addChild(Body_r32);
		setRotationAngle(Body_r32, -0.2545F, -0.5227F, 1.1555F);
		Body_r32.texOffs(3, 94).addBox(-4.0F, 0.0F, 8.0F, 4.0F, 3.0F, 12.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(17.8956F, 26.3494F, -8.9326F);
		tente3.addChild(Body_r33);
		setRotationAngle(Body_r33, -1.0472F, 0.9163F, -1.6144F);
		Body_r33.texOffs(3, 94).addBox(-1.0F, 0.0F, 9.0F, 4.0F, 3.0F, 12.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-6.9962F, 24.961F, -13.8418F);
		tente3.addChild(Body_r34);
		setRotationAngle(Body_r34, -0.3455F, -0.2976F, 1.3814F);
		Body_r34.texOffs(3, 94).addBox(-5.0F, -1.0F, -3.0F, 6.0F, 4.0F, 12.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(17.835F, 24.961F, -9.8418F);
		tente3.addChild(Body_r35);
		setRotationAngle(Body_r35, -1.0472F, 0.6109F, -1.6144F);
		Body_r35.texOffs(3, 94).addBox(-1.0F, -1.0F, -3.0F, 6.0F, 4.0F, 12.0F, 0.0F, true);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(5.7878F, -64.5196F, 24.4362F);
		tente3.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.6981F, -0.1745F, 0.0F);
		Body_r36.texOffs(3, 94).addBox(-10.0882F, 42.5027F, -75.9791F, 6.0F, 6.0F, 12.0F, 0.0F, true);

		tente6 = new ModelRenderer(this);
		tente6.setPos(-17.0F, 16.0398F, 3.7938F);
		Body.addChild(tente6);
		setRotationAngle(tente6, 0.2618F, 0.0F, 0.0F);
		

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(8.3509F, -151.2761F, 98.4882F);
		tente6.addChild(Body_r37);
		setRotationAngle(Body_r37, 1.2654F, 0.9599F, 0.0F);
		Body_r37.texOffs(9, 134).addBox(31.437F, 19.8905F, -107.3705F, 4.0F, 4.0F, 18.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(17.9092F, -136.1811F, 128.4685F);
		tente6.addChild(Body_r38);
		setRotationAngle(Body_r38, 2.0944F, 0.9599F, 0.0F);
		Body_r38.texOffs(74, 235).addBox(50.513F, -81.6613F, -73.1003F, 4.0F, 4.0F, 18.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(38.5173F, -129.5204F, 92.5093F);
		tente6.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.7418F, -0.6981F, 0.0F);
		Body_r39.texOffs(29, 211).addBox(-26.6481F, 63.3864F, -70.2138F, 4.0F, 4.0F, 19.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(30.2368F, -135.4803F, 101.6637F);
		tente6.addChild(Body_r40);
		setRotationAngle(Body_r40, -0.7854F, -0.1745F, 0.0F);
		Body_r40.texOffs(2, 76).addBox(-0.4983F, 80.2055F, 40.5765F, 4.0F, 4.0F, 12.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(29.2177F, -123.0467F, 110.3229F);
		tente6.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.4363F, -0.1745F, 0.0F);
		Body_r41.texOffs(17, 203).addBox(-3.9983F, 62.0144F, -64.4094F, 4.0F, 4.0F, 20.0F, 0.0F, false);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(31.3269F, -124.7372F, 115.3523F);
		tente6.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.4363F, 0.4363F, 0.0F);
		Body_r42.texOffs(0, 114).addBox(16.0321F, 61.3514F, -74.5422F, 4.0F, 4.0F, 24.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(15.3773F, -113.2801F, 92.9792F);
		tente6.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.2618F, 0.4363F, 0.0F);
		Body_r43.texOffs(0, 189).addBox(17.0321F, 69.1157F, -56.7091F, 8.0F, 8.0F, 24.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(23.3936F, -92.7182F, 77.0434F);
		tente6.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.2618F, 0.4363F, 0.0F);
		Body_r44.texOffs(3, 94).addBox(3.0321F, 52.1157F, -52.7091F, 8.0F, 12.0F, 12.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(20.0F, -119.3072F, 2.5061F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.829F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-7.0F, 47.575F, 71.3688F, 8.0F, 20.0F, 8.0F, 0.0F, true);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-20.0F, -120.4768F, 3.4727F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -0.829F, 0.0F, 0.0F);
		RightArm_r2.texOffs(40, 16).addBox(-7.0F, 47.575F, 71.3688F, 8.0F, 20.0F, 8.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-21.0F, -135.5822F, 8.412F);
		RightArm.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, 0.2182F, 0.0F, 0.0F);
		RightArm_r3.texOffs(40, 16).addBox(-6.0F, 86.2012F, -17.6084F, 8.0F, 20.0F, 8.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, -1.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(11.0F, -118.5957F, 75.9846F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-8.0F, 86.377F, -34.6896F, 8.0F, 20.0F, 8.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(9.2375F, -79.4103F, 39.6097F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.829F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(25, 48).addBox(-6.5478F, 91.5942F, 31.0367F, 8.0F, 4.0F, 4.0F, 0.0F, true);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-20.1812F, -78.9176F, 50.1004F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.9599F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(25, 49).addBox(-3.1496F, 4.7077F, -105.6159F, 8.0F, 2.0F, 5.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(9.1677F, -54.611F, 67.473F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, -0.829F, 0.0F, 0.0F);
		RightLeg_r3.texOffs(25, 43).addBox(-6.478F, 79.383F, -6.0715F, 8.0F, 16.0F, 8.0F, 0.0F, true);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-20.1812F, -82.6089F, 67.963F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, -0.6981F, 0.0F, 0.0F);
		RightLeg_r4.texOffs(27, 45).addBox(-3.1496F, 98.2193F, 1.1519F, 8.0F, 16.0F, 8.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(-20.1812F, -82.6089F, 67.963F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, -1.7453F, 0.0F, 0.0F);
		RightLeg_r5.texOffs(28, 42).addBox(-3.1496F, 20.1121F, 85.6364F, 12.0F, 28.0F, 12.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(7.7607F, -98.7314F, 22.4149F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -1.1781F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(23, 41).addBox(-11.4183F, 26.1792F, 77.4962F, 11.0F, 28.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below

		this.Head.xRot = netHeadYaw * 0.009453292F;
		this.tente4.xRot = netHeadYaw * 0.009453292F;
		this.tente7.xRot = netHeadYaw * 0.009453292F;
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