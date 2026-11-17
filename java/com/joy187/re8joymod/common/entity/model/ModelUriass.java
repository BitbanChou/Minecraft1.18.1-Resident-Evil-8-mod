// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityUriass;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelUriass<T extends EntityUriass> extends EntityModel<T> {
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
	private final ModelRenderer hair3_r1;
	private final ModelRenderer Head_r14;
	private final ModelRenderer Head_r15;
	private final ModelRenderer hair4_r1;
	private final ModelRenderer hair5_r1;
	private final ModelRenderer hair2_r1;
	private final ModelRenderer hair1_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer hammer1;
	private final ModelRenderer bottle1_r1;
	private final ModelRenderer hammer2;
	private final ModelRenderer bottle8_r1;
	private final ModelRenderer bottle7_r1;
	private final ModelRenderer bottle6_r1;
	private final ModelRenderer bottle8_r2;
	private final ModelRenderer bottle6_r2;
	private final ModelRenderer bottle6_r3;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;

	public ModelUriass() {
		texWidth = 100;
		texHeight = 100;

		Head = new ModelRenderer(this);
		Head.setPos(1.0F, -25.0F, -2.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(1, 0).addBox(-6.1819F, -10.2374F, -2.6361F, 12.0F, 12.0F, 12.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-1.7538F, 17.4023F, -0.9601F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, -0.3054F, -0.3054F, -0.829F);
		Head_r1.texOffs(41, 9).addBox(8.518F, -10.1677F, -9.111F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-1.7538F, 17.4023F, -0.9601F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0F, -0.3054F, -1.6144F);
		Head_r2.texOffs(64, 7).addBox(9.1847F, -3.7337F, -7.6244F, 6.0F, 13.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(5.39F, 17.4023F, -0.9601F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.3054F, 0.3054F, 1.4399F);
		Head_r3.texOffs(34, 0).addBox(-15.1342F, 1.93F, 0.2467F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.3232F, 13.9099F, -1.188F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.3054F, 0.48F, 0.1745F);
		Head_r4.texOffs(34, 0).addBox(-6.0738F, -13.7333F, -7.3849F, 3.0F, 1.0F, 1.0F, -1.0F, true);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(0.5877F, 2.7665F, 6.1201F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 1.2654F, -0.4363F, -0.1745F);
		Head_r5.texOffs(34, 0).addBox(1.1257F, -10.7391F, -6.9864F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-4.0465F, 15.6694F, -0.0997F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.3054F, -0.3054F, 0.0F);
		Head_r6.texOffs(34, 0).addBox(-5.9715F, -14.7777F, -7.412F, 4.0F, 5.0F, 1.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(7.1959F, 9.4914F, 2.7013F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.3054F, 0.3054F, 0.829F);
		Head_r7.texOffs(42, 5).addBox(-7.018F, -0.1677F, -8.111F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(9.352F, 6.7439F, 0.2558F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 0.0436F, -0.7418F, 0.0F);
		Head_r8.texOffs(43, 0).addBox(-4.5593F, -16.9541F, -0.0042F, 5.0F, 12.0F, 1.0F, 0.0F, true);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(8.1919F, 4.6669F, 5.4308F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, 0.1309F, -0.7854F, -1.0036F);
		Head_r9.texOffs(41, 10).addBox(2.2825F, -12.7115F, -12.2671F, 7.0F, 6.0F, 1.0F, 0.0F, true);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-8.4817F, 5.0128F, 2.7555F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, 0.0436F, 0.5236F, 1.0036F);
		Head_r10.texOffs(41, 0).addBox(-15.3671F, -11.2862F, -8.529F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(-7.8991F, 7.6993F, -0.7311F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, 0.0436F, 0.48F, 0.0F);
		Head_r11.texOffs(34, 8).addBox(-3.5972F, -17.9588F, -0.1136F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(-0.1819F, -5.2632F, 1.5028F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 2.3562F, 0.0F, 0.0F);
		Head_r12.texOffs(27, 0).addBox(-8.0F, 0.9052F, 4.94F, 15.0F, 7.0F, 1.0F, 0.0F, false);

		Head_r13 = new ModelRenderer(this);
		Head_r13.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(Head_r13);
		setRotationAngle(Head_r13, 1.0036F, 0.0F, -0.0873F);
		Head_r13.texOffs(1, 0).addBox(-9.0F, -10.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Head_r13.texOffs(1, 0).addBox(-9.0F, -11.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		hair3_r1 = new ModelRenderer(this);
		hair3_r1.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(hair3_r1);
		setRotationAngle(hair3_r1, 1.0036F, 0.3054F, 0.0F);
		hair3_r1.texOffs(1, 0).addBox(-1.0F, -10.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		hair3_r1.texOffs(1, 0).addBox(-1.0F, -11.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		Head_r14 = new ModelRenderer(this);
		Head_r14.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(Head_r14);
		setRotationAngle(Head_r14, 0.4363F, 0.0873F, 0.0F);
		Head_r14.texOffs(1, 0).addBox(-1.0F, -6.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Head_r14.texOffs(1, 0).addBox(-1.0F, -7.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		Head_r15 = new ModelRenderer(this);
		Head_r15.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(Head_r15);
		setRotationAngle(Head_r15, 0.6545F, 0.0873F, 0.0F);
		Head_r15.texOffs(1, 0).addBox(-5.0F, -6.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		Head_r15.texOffs(1, 0).addBox(-5.0F, -7.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		hair4_r1 = new ModelRenderer(this);
		hair4_r1.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(hair4_r1);
		setRotationAngle(hair4_r1, 0.6545F, -0.2182F, 0.0F);
		hair4_r1.texOffs(1, 0).addBox(-11.0F, -2.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		hair4_r1.texOffs(1, 0).addBox(-11.0F, -3.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		hair5_r1 = new ModelRenderer(this);
		hair5_r1.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(hair5_r1);
		setRotationAngle(hair5_r1, 0.3927F, -0.2182F, 0.0F);
		hair5_r1.texOffs(1, 0).addBox(-8.0F, -2.0F, 1.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		hair5_r1.texOffs(1, 0).addBox(-8.0F, -3.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		hair2_r1 = new ModelRenderer(this);
		hair2_r1.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(hair2_r1);
		setRotationAngle(hair2_r1, 0.3927F, 0.2618F, 0.0F);
		hair2_r1.texOffs(1, 0).addBox(0.0F, -2.0F, 5.5F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		hair2_r1.texOffs(1, 0).addBox(0.0F, -3.0F, -5.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		hair1_r1 = new ModelRenderer(this);
		hair1_r1.setPos(4.8181F, -5.2374F, 14.8639F);
		Head.addChild(hair1_r1);
		setRotationAngle(hair1_r1, 0.7854F, -0.2182F, 0.0F);
		hair1_r1.texOffs(1, 0).addBox(-5.0F, -2.0F, 1.5F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		hair1_r1.texOffs(1, 0).addBox(-5.0F, -3.0F, -9.5F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(29, 30).addBox(-9.0F, -23.0F, -6.0F, 19.0F, 17.0F, 15.0F, 0.0F, false);
		Body.texOffs(29, 44).addBox(-8.0F, -6.0F, -4.0F, 16.0F, 9.0F, 11.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-12.0F, -19.0F, 2.0F);
		setRotationAngle(RightArm, -0.3927F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(1.0F, 2.3502F, 4.4042F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.6109F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 15).addBox(-3.0F, 3.6824F, -2.619F, 6.0F, 11.0F, 5.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(2.0F, 25.1155F, 3.3131F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(60, 36).addBox(-4.0F, -28.7463F, -1.1138F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(10.0F, -17.0F, 2.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(2.5F, 5.4681F, -2.8801F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.829F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(42, 86).addBox(-1.5F, 2.5F, -3.5F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		LeftArm_r1.texOffs(42, 86).addBox(-3.5F, -4.5F, -2.5F, 7.0F, 9.0F, 5.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(1.0F, 21.9611F, -6.8848F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(58, 84).addBox(-2.0F, -28.986F, -0.1973F, 7.0F, 10.0F, 6.0F, 0.0F, false);

		hammer1 = new ModelRenderer(this);
		hammer1.setPos(3.0F, 12.9611F, -2.8848F);
		LeftArm.addChild(hammer1);
		setRotationAngle(hammer1, 0.2618F, 0.0F, 0.4363F);
		

		bottle1_r1 = new ModelRenderer(this);
		bottle1_r1.setPos(-4.5371F, 9.2808F, -4.7774F);
		hammer1.addChild(bottle1_r1);
		setRotationAngle(bottle1_r1, 0.3054F, -2.0944F, 0.0F);
		bottle1_r1.texOffs(0, 9).addBox(-2.4715F, -18.1828F, -0.2419F, 2.0F, 2.0F, 36.0F, 0.0F, false);
		bottle1_r1.texOffs(56, 6).addBox(-2.4715F, -21.1828F, -2.2419F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle1_r1.texOffs(56, 6).addBox(-3.4715F, -19.1828F, -5.2419F, 4.0F, 3.0F, 5.0F, 0.0F, false);

		hammer2 = new ModelRenderer(this);
		hammer2.setPos(-13.8541F, -11.2033F, -8.0193F);
		LeftArm.addChild(hammer2);
		setRotationAngle(hammer2, 0.3491F, 0.0F, 0.6545F);
		

		bottle8_r1 = new ModelRenderer(this);
		bottle8_r1.setPos(10.8541F, 20.1615F, -11.51F);
		hammer2.addChild(bottle8_r1);
		setRotationAngle(bottle8_r1, 0.3054F, -2.0944F, 0.0F);
		bottle8_r1.texOffs(92, 61).addBox(2.5285F, -28.1828F, 26.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 61).addBox(2.5285F, -28.1828F, 35.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 60).addBox(-4.4715F, -28.1828F, 35.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 62).addBox(-5.4715F, -28.1828F, 29.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(0.5285F, -28.1828F, 30.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(5.5285F, -20.1828F, 27.7581F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(5.5285F, -14.1828F, 27.7581F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(5.5285F, -17.1828F, 31.7581F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(5.5285F, -22.1828F, 34.7581F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(5.5285F, -14.1828F, 34.7581F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 60).addBox(-3.4715F, -11.1828F, 33.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 60).addBox(-5.4715F, -11.1828F, 36.7581F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(92, 60).addBox(1.5285F, -11.1828F, 32.7581F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(-2.4715F, -20.1828F, 19.7581F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		bottle8_r1.texOffs(44, 46).addBox(-7.4715F, -24.1828F, 25.7581F, 14.0F, 14.0F, 14.0F, 0.0F, false);

		bottle7_r1 = new ModelRenderer(this);
		bottle7_r1.setPos(-10.0186F, -18.1225F, -24.1053F);
		hammer2.addChild(bottle7_r1);
		setRotationAngle(bottle7_r1, 0.2182F, -2.0944F, 0.1745F);
		bottle7_r1.texOffs(91, 63).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		bottle6_r1 = new ModelRenderer(this);
		bottle6_r1.setPos(-15.1614F, 8.9517F, -24.0491F);
		hammer2.addChild(bottle6_r1);
		setRotationAngle(bottle6_r1, 0.3054F, -2.0944F, 0.8727F);
		bottle6_r1.texOffs(46, 56).addBox(-3.0364F, -10.5083F, 3.4637F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-8.0364F, -11.5083F, 9.4637F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-0.0364F, -1.5083F, 11.4637F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle6_r1.texOffs(46, 56).addBox(-0.0364F, -7.5083F, -1.5363F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		bottle8_r2 = new ModelRenderer(this);
		bottle8_r2.setPos(-4.2606F, -5.4141F, -32.1729F);
		hammer2.addChild(bottle8_r2);
		setRotationAngle(bottle8_r2, 0.3054F, -1.5272F, 0.8727F);
		bottle8_r2.texOffs(46, 56).addBox(-5.0F, 7.0F, 1.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		bottle8_r2.texOffs(46, 56).addBox(-4.0F, 1.0F, 2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		bottle6_r2 = new ModelRenderer(this);
		bottle6_r2.setPos(-15.1614F, 8.9517F, -24.0491F);
		hammer2.addChild(bottle6_r2);
		setRotationAngle(bottle6_r2, 0.0873F, -2.0944F, 0.8727F);
		bottle6_r2.texOffs(46, 56).addBox(6.9636F, -7.8478F, 14.7676F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		bottle6_r3 = new ModelRenderer(this);
		bottle6_r3.setPos(-17.1451F, -9.9486F, -30.8771F);
		hammer2.addChild(bottle6_r3);
		setRotationAngle(bottle6_r3, 1.0472F, -2.0944F, 0.8727F);
		bottle6_r3.texOffs(56, 68).addBox(-5.0F, -2.5F, -3.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle6_r3.texOffs(56, 68).addBox(4.0F, -2.5F, 1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle6_r3.texOffs(56, 68).addBox(3.0F, -2.5F, -8.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bottle6_r3.texOffs(56, 68).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-4.9F, 4.0F, -1.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9362F, 7.7391F, -4.6202F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.3491F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(44, 60).addBox(-4.0F, -2.0F, -3.0F, 7.0F, 14.0F, 7.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(2.9362F, 13.8763F, -3.782F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.6981F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(18, 79).addBox(-5.0F, -17.0F, -8.0F, 7.0F, 14.0F, 7.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(3.9F, 4.0F, -2.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-1.278F, 9.2015F, 2.6404F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.5672F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(1, 56).addBox(-3.0F, -2.0F, -3.0F, 7.0F, 13.0F, 6.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(-2.278F, 13.5472F, 3.6679F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, -0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(22, 61).addBox(-2.0F, -18.0F, -5.0F, 7.0F, 14.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.1F * limbSwingAmount;
		this.RightArm.xRot= MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.6F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.hair1_r1.xRot = headPitch * 0.017453292F;
		this.hair2_r1.xRot = headPitch * 0.017453292F;

		this.hair5_r1.yRot =  headPitch * 0.017453292F;
		this.hair4_r1.xRot =  headPitch * 0.024453292F;
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