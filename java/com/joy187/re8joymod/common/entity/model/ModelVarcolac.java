// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityVarcolac;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelVarcolac<T extends EntityVarcolac> extends EntityModel<T> {
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
	private final ModelRenderer Head_r20;
	private final ModelRenderer Head_r21;
	private final ModelRenderer Head_r22;
	private final ModelRenderer Head_r23;
	private final ModelRenderer Head_r24;
	private final ModelRenderer Head_r25;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer RightArm_r9;
	private final ModelRenderer knife;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer LeftArm_r5;
	private final ModelRenderer LeftArm_r6;
	private final ModelRenderer LeftArm_r7;
	private final ModelRenderer LeftArm_r8;
	private final ModelRenderer LeftArm_r9;
	private final ModelRenderer LeftArm_r10;
	private final ModelRenderer knife2;
	private final ModelRenderer RightArm_r10;
	private final ModelRenderer RightArm_r11;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer Leftll_r2;
	private final ModelRenderer LeftLeg_r1;

	public ModelVarcolac() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -3.3465F, -9.8941F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(1, 1).addBox(-3.5F, -10.6042F, -5.0467F, 8.0F, 8.0F, 7.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-4.8383F, -9.2672F, -0.5054F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.5769F, -0.5467F, 0.2877F);
		Head_r1.texOffs(60, 60).addBox(0.3201F, 1.7693F, 3.2123F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(4.724F, -9.6499F, 0.7454F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 1.6577F, 0.0395F, -0.0184F);
		Head_r2.texOffs(60, 60).addBox(0.5137F, 0.7205F, 2.2405F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(2.5677F, -8.4005F, 6.1767F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 1.6968F, 0.3021F, -0.0175F);
		Head_r3.texOffs(9, 57).addBox(0.5137F, 3.7205F, 1.2405F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(0.5677F, -5.4005F, 12.1767F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.5098F, 2.466F, 1.3924F);
		Head_r4.texOffs(60, 60).addBox(4.5137F, 0.7205F, 4.2405F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-4.4323F, -8.4005F, 7.1767F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 1.7117F, -0.5268F, -0.0193F);
		Head_r5.texOffs(60, 60).addBox(-1.4863F, 2.7205F, 1.2405F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-0.4323F, -8.4005F, 7.1767F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 1.7014F, 0.0403F, -0.0167F);
		Head_r6.texOffs(23, 12).addBox(0.5137F, 3.7205F, 1.2405F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(1.4496F, 0.1804F, -1.3168F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.9158F, 0.0295F, -0.0322F);
		Head_r7.texOffs(60, 60).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(0.5677F, -10.4005F, 1.1767F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 1.7014F, 0.0403F, -0.0167F);
		Head_r8.texOffs(60, 60).addBox(0.5137F, 3.7205F, 1.2405F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(3.786F, -7.6514F, -3.1584F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, -1.0422F, -0.2533F, -0.4652F);
		Head_r9.texOffs(56, 55).addBox(-4.5233F, -9.4759F, -5.2074F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(3.786F, -7.6514F, -4.1584F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.2876F, 0.1274F, 0.3656F);
		Head_r10.texOffs(10, 15).addBox(-6.8972F, 2.2686F, -1.7933F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Head_r10.texOffs(18, 9).addBox(-6.8972F, -1.7314F, -1.7933F, 5.0F, 4.0F, 2.0F, 0.0F, false);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(4.923F, -9.5173F, -3.8455F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, -0.2876F, -0.4834F, -0.5507F);
		Head_r11.texOffs(8, 16).addBox(-2.8972F, -1.7314F, -0.9934F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(3.786F, -7.6514F, -4.1584F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, -1.2039F, 0.1274F, 0.7147F);
		Head_r12.texOffs(56, 55).addBox(2.1028F, -7.7314F, 2.2067F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		Head_r13 = new ModelRenderer(this);
		Head_r13.setPos(3.786F, -7.6514F, -4.1584F);
		Head.addChild(Head_r13);
		setRotationAngle(Head_r13, -1.2039F, 0.1274F, 0.3656F);
		Head_r13.texOffs(56, 55).addBox(1.1028F, -7.7314F, 0.2067F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		Head_r13.texOffs(5, 55).addBox(-1.8972F, -7.7314F, -3.7933F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Head_r14 = new ModelRenderer(this);
		Head_r14.setPos(-1.8209F, -4.9342F, -2.909F);
		Head.addChild(Head_r14);
		setRotationAngle(Head_r14, -0.2182F, 0.9599F, 0.0F);
		Head_r14.texOffs(56, 53).addBox(-6.6971F, -2.8953F, -2.725F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r15 = new ModelRenderer(this);
		Head_r15.setPos(-1.8209F, -4.9342F, -2.909F);
		Head.addChild(Head_r15);
		setRotationAngle(Head_r15, -0.2182F, 0.9599F, -0.1745F);
		Head_r15.texOffs(56, 53).addBox(-6.6971F, -1.8953F, -2.725F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r16 = new ModelRenderer(this);
		Head_r16.setPos(-1.8209F, -4.9342F, -2.909F);
		Head.addChild(Head_r16);
		setRotationAngle(Head_r16, -0.2182F, 1.309F, 0.0F);
		Head_r16.texOffs(56, 53).addBox(-4.6971F, -4.8953F, -2.725F, 7.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r17 = new ModelRenderer(this);
		Head_r17.setPos(4.5817F, -3.8618F, -3.9909F);
		Head.addChild(Head_r17);
		setRotationAngle(Head_r17, -0.2618F, -1.6144F, 0.0F);
		Head_r17.texOffs(56, 53).addBox(-1.2842F, -5.4451F, -1.7148F, 6.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r18 = new ModelRenderer(this);
		Head_r18.setPos(-0.553F, -4.8819F, -2.9303F);
		Head.addChild(Head_r18);
		setRotationAngle(Head_r18, 1.7017F, 0.0F, 0.0F);
		Head_r18.texOffs(54, 41).addBox(-1.0F, -5.0F, -2.1756F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		Head_r18.texOffs(56, 53).addBox(0.0F, -5.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r19 = new ModelRenderer(this);
		Head_r19.setPos(-0.553F, -1.3249F, -6.9647F);
		Head.addChild(Head_r19);
		setRotationAngle(Head_r19, -0.9163F, 0.0F, 0.0F);
		Head_r19.texOffs(0, 53).addBox(-1.0F, -6.0F, 1.0F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		Head_r19.texOffs(54, 46).addBox(-1.0F, -4.0F, 0.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r20 = new ModelRenderer(this);
		Head_r20.setPos(1.7162F, -5.1407F, -0.233F);
		Head.addChild(Head_r20);
		setRotationAngle(Head_r20, -1.4287F, 0.2783F, 0.0419F);
		Head_r20.texOffs(3, 53).addBox(-0.1301F, -10.8454F, -4.866F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		Head_r21 = new ModelRenderer(this);
		Head_r21.setPos(-0.2838F, -2.1407F, 5.767F);
		Head.addChild(Head_r21);
		setRotationAngle(Head_r21, -1.636F, 0.7102F, -0.0978F);
		Head_r21.texOffs(56, 53).addBox(1.8699F, -8.8454F, -4.866F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Head_r22 = new ModelRenderer(this);
		Head_r22.setPos(-5.2838F, -5.1407F, 0.767F);
		Head.addChild(Head_r22);
		setRotationAngle(Head_r22, -1.465F, -0.55F, 0.0473F);
		Head_r22.texOffs(56, 53).addBox(0.8699F, -8.8454F, -4.866F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		Head_r23 = new ModelRenderer(this);
		Head_r23.setPos(-1.2838F, -5.1407F, 0.767F);
		Head.addChild(Head_r23);
		setRotationAngle(Head_r23, -1.4396F, 0.0167F, 0.0403F);
		Head_r23.texOffs(17, 8).addBox(-0.1301F, -10.8454F, -4.866F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		Head_r24 = new ModelRenderer(this);
		Head_r24.setPos(-0.2838F, 9.8593F, -10.233F);
		Head.addChild(Head_r24);
		setRotationAngle(Head_r24, -2.1376F, 0.0322F, 0.0295F);
		Head_r24.texOffs(18, 10).addBox(-1.1301F, -1.8454F, -12.866F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r25 = new ModelRenderer(this);
		Head_r25.setPos(-0.2838F, -7.1407F, -5.233F);
		Head.addChild(Head_r25);
		setRotationAngle(Head_r25, -1.4396F, 0.0167F, 0.0403F);
		Head_r25.texOffs(40, 21).addBox(-0.1301F, -10.8454F, -4.866F, 3.0F, 9.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(1.0F, -8.6571F, -4.6672F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 1.3526F, 0.0F, 0.0F);
		Body_r1.texOffs(0, 16).addBox(-3.5F, -5.5F, -4.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(1.0F, -5.5331F, -0.0163F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.9163F, 0.0F, 0.0F);
		Body_r2.texOffs(11, 12).addBox(-4.0F, -5.5F, -4.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(1.0F, 0.0F, -0.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.4363F, 0.0F, 0.0F);
		Body_r3.texOffs(7, 13).addBox(-7.0F, -7.0F, -4.5F, 14.0F, 10.0F, 11.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(1.0F, 4.0F, 0.5F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.1309F, 0.0F, 0.0F);
		Body_r4.texOffs(11, 13).addBox(-6.0F, -3.0F, -4.5F, 12.0F, 6.0F, 9.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-8.0F, -2.0F, -2.0F);
		setRotationAngle(RightArm, 0.3054F, -0.2618F, 0.829F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-3.5F, 1.9707F, -12.2892F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -1.3963F, -0.2618F, -0.3927F);
		RightArm_r1.texOffs(59, 21).addBox(3.5F, -3.5F, 4.55F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightArm_r1.texOffs(9, 21).addBox(3.0F, -6.5F, 3.95F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-1.5F, 0.9707F, -10.2892F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -1.8925F, -0.693F, -1.2025F);
		RightArm_r2.texOffs(59, 22).addBox(1.5F, -3.5F, 1.2892F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-3.5F, 1.9707F, -12.2892F);
		RightArm.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -1.7017F, 0.0F, -0.1309F);
		RightArm_r3.texOffs(59, 21).addBox(-0.5F, -3.5F, 1.55F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		RightArm_r3.texOffs(4, 21).addBox(-1.0F, -6.5F, 1.95F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(0.0F, 5.7853F, -13.903F);
		RightArm.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -1.8762F, 0.0F, 0.0F);
		RightArm_r4.texOffs(59, 21).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-2.0F, 6.3867F, -11.9956F);
		RightArm.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -1.8762F, 0.0F, 0.0F);
		RightArm_r5.texOffs(59, 21).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(-1.5F, 0.9707F, -10.2892F);
		RightArm.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -1.7873F, -0.6735F, -1.0928F);
		RightArm_r6.texOffs(4, 21).addBox(1.0F, -6.5F, 0.95F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(-0.5F, 5.6636F, 2.354F);
		RightArm.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -1.5708F, 0.0F, 0.0F);
		RightArm_r7.texOffs(6, 20).addBox(0.0F, 9.5F, -0.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		RightArm_r7.texOffs(9, 20).addBox(-2.0F, 9.5F, -0.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		RightArm_r7.texOffs(2, 19).addBox(-2.5F, 2.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(-0.6357F, 2.9171F, 0.6397F);
		RightArm.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -0.48F, 0.0F, 0.0F);
		RightArm_r8.texOffs(0, 52).addBox(-2.5F, -3.5F, -2.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(-0.5F, -0.0455F, 1.5863F);
		RightArm.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, 0.0F, 0.0F, 0.1745F);
		RightArm_r9.texOffs(0, 39).addBox(-2.5F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(-1.6786F, 10.2122F, -5.8614F);
		RightArm.addChild(knife);
		setRotationAngle(knife, 3.0543F, -1.6144F, 0.1309F);
		

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(11.0F, -2.0F, -1.0F);
		setRotationAngle(LeftArm, 0.6021F, 0.48F, -0.6981F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(2.6131F, 4.5464F, -13.2538F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.881F, 0.083F, 0.1584F);
		LeftArm_r1.texOffs(59, 21).addBox(-4.5F, -3.0F, -3.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(2.4508F, 5.2968F, -13.339F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -1.789F, 0.2182F, 0.2618F);
		LeftArm_r2.texOffs(59, 21).addBox(-4.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.8821F, 4.4763F, -12.4732F);
		LeftArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -1.4399F, -0.2618F, -1.8762F);
		LeftArm_r3.texOffs(54, 46).addBox(0.5F, -2.0F, 0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.8821F, 4.4763F, -12.4732F);
		LeftArm.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -1.5272F, 0.2182F, -0.0873F);
		LeftArm_r4.texOffs(54, 46).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(2.3852F, 8.4218F, -5.1804F);
		LeftArm.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -1.4399F, -0.2618F, 0.0F);
		LeftArm_r5.texOffs(6, 56).addBox(-2.1076F, 2.0494F, -5.709F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(1.0F, 6.3531F, -5.9514F);
		LeftArm.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -1.9168F, 0.05F, 0.121F);
		LeftArm_r6.texOffs(6, 23).addBox(-2.7F, -0.2511F, -3.9044F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(1.0F, 7.3531F, -5.9514F);
		LeftArm.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -1.5272F, 0.0F, 0.1309F);
		LeftArm_r7.texOffs(6, 23).addBox(-2.7F, -0.2511F, -3.9044F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		LeftArm_r8 = new ModelRenderer(this);
		LeftArm_r8.setPos(1.0F, 7.3531F, -5.9514F);
		LeftArm.addChild(LeftArm_r8);
		setRotationAngle(LeftArm_r8, -1.5272F, 0.0F, 0.0F);
		LeftArm_r8.texOffs(6, 23).addBox(-1.0F, -0.2511F, -3.9044F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftArm_r8.texOffs(0, 20).addBox(-2.0F, -4.2511F, -4.4044F, 4.0F, 6.0F, 3.0F, 0.0F, false);

		LeftArm_r9 = new ModelRenderer(this);
		LeftArm_r9.setPos(0.1481F, 5.2936F, 2.3278F);
		LeftArm.addChild(LeftArm_r9);
		setRotationAngle(LeftArm_r9, -0.9163F, 0.0F, 0.0F);
		LeftArm_r9.texOffs(0, 54).addBox(-1.5F, -2.5624F, -5.3967F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm_r10 = new ModelRenderer(this);
		LeftArm_r10.setPos(0.5F, 6.3721F, 1.0405F);
		LeftArm.addChild(LeftArm_r10);
		setRotationAngle(LeftArm_r10, -0.0873F, 0.0F, -0.1745F);
		LeftArm_r10.texOffs(2, 21).addBox(-0.9904F, -10.9109F, -2.7649F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		knife2 = new ModelRenderer(this);
		knife2.setPos(4.3577F, 10.5115F, -5.4695F);
		LeftArm.addChild(knife2);
		setRotationAngle(knife2, -2.7489F, 1.6144F, -3.0107F);
		

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(2.5091F, -2.2999F, -0.6676F);
		knife2.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, -0.2182F, -0.1745F, 0.0F);
		RightArm_r10.texOffs(54, 42).addBox(1.846F, -4.571F, -1.2342F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(1.6951F, -6.303F, 2.3107F);
		knife2.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, 0.0436F, 0.0F, 0.0F);
		RightArm_r11.texOffs(21, 60).addBox(-1.5314F, -1.3155F, -4.7223F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 8.0F, -1.0F);
		setRotationAngle(RightLeg, -0.0698F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(0.4362F, 3.632F, -0.0409F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.5236F, 0.0F, 0.0F);
		Rightll_r1.texOffs(15, 47).addBox(-3.5F, -6.5F, -4.5F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(2.3362F, 5.7069F, -1.0963F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.5672F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(0, 23).addBox(-4.4F, 7.0F, -6.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(2.3362F, 3.7792F, -1.8579F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.5236F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(0, 18).addBox(-4.4F, 0.0F, -4.0F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(2.9F, 7.0F, -1.0F);
		setRotationAngle(LeftLeg, -0.5672F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(2.2754F, 13.1799F, 6.7178F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 1.2217F, -0.1745F, 0.0F);
		Leftll_r1.texOffs(1, 2).addBox(-3.0651F, 2.1571F, -0.963F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		Leftll_r2 = new ModelRenderer(this);
		Leftll_r2.setPos(1.1368F, 11.9436F, 4.0056F);
		LeftLeg.addChild(Leftll_r2);
		setRotationAngle(Leftll_r2, 1.1345F, -0.0873F, 0.0F);
		Leftll_r2.texOffs(0, 18).addBox(-2.1F, -4.0F, 1.5F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.9711F, 7.1706F, 3.0275F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, -0.1309F);
		LeftLeg_r1.texOffs(15, 48).addBox(-1.0F, -8.5F, -2.5F, 6.0F, 10.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.RightArm_r3.yRot = headPitch * 0.017453292F;
		this.RightArm_r4.xRot = headPitch * 0.017453292F;
		this.LeftArm_r2.xRot = headPitch * 0.017453292F;
		this.LeftArm_r1.yRot = headPitch * 0.007453292F;
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