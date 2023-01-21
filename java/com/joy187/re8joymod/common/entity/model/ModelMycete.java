// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntityMycete;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelMycete<T extends EntityMycete> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer backArm_r1;
	private final ModelRenderer backArm_r2;
	private final ModelRenderer backArm_r3;
	private final ModelRenderer backArm_r4;
	private final ModelRenderer tente;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer Body_r12;
	private final ModelRenderer tente3;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer tente4;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer Body_r19;
	private final ModelRenderer tente2;
	private final ModelRenderer Body_r20;
	private final ModelRenderer Body_r21;
	private final ModelRenderer Body_r22;
	private final ModelRenderer Body_r23;
	private final ModelRenderer Body_r24;
	private final ModelRenderer tente5;
	private final ModelRenderer Body_r25;
	private final ModelRenderer Body_r26;
	private final ModelRenderer Body_r27;
	private final ModelRenderer Body_r28;
	private final ModelRenderer Body_r29;
	private final ModelRenderer Body_r30;
	private final ModelRenderer tente6;
	private final ModelRenderer Body_r31;
	private final ModelRenderer Body_r32;
	private final ModelRenderer Body_r33;
	private final ModelRenderer Body_r34;
	private final ModelRenderer Body_r35;
	private final ModelRenderer Body_r36;
	private final ModelRenderer Body_r37;
	private final ModelRenderer Body_r38;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightLeg_r3;
	private final ModelRenderer RightLeg_r4;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public ModelMycete() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(1.9F, 8.4562F, -3.4138F);
		setRotationAngle(Head, -0.1484F, 0.0873F, 0.0F);
		Head.texOffs(19, 5).addBox(-5.9F, -3.5F, -2.75F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.texOffs(14, 19).addBox(1.4F, -1.5F, -2.75F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(36, 27).addBox(-4.0F, 8.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);

		backArm_r1 = new ModelRenderer(this);
		backArm_r1.setPos(-3.2085F, 17.1689F, 3.3347F);
		Body.addChild(backArm_r1);
		setRotationAngle(backArm_r1, -2.0071F, -0.0873F, 0.3054F);
		backArm_r1.texOffs(32, 48).addBox(-2.5F, -2.5F, -0.5F, 2.0F, 5.0F, 2.0F, 0.0F, true);

		backArm_r2 = new ModelRenderer(this);
		backArm_r2.setPos(-5.7156F, 18.4391F, 6.5726F);
		Body.addChild(backArm_r2);
		setRotationAngle(backArm_r2, -2.0071F, -0.1309F, -0.1745F);
		backArm_r2.texOffs(32, 48).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);

		backArm_r3 = new ModelRenderer(this);
		backArm_r3.setPos(6.7156F, 16.4391F, 7.5726F);
		Body.addChild(backArm_r3);
		setRotationAngle(backArm_r3, -2.0071F, 0.1309F, 0.1745F);
		backArm_r3.texOffs(32, 48).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		backArm_r4 = new ModelRenderer(this);
		backArm_r4.setPos(4.2085F, 15.1689F, 4.3347F);
		Body.addChild(backArm_r4);
		setRotationAngle(backArm_r4, -2.0071F, 0.6545F, -0.3054F);
		backArm_r4.texOffs(32, 48).addBox(0.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		tente = new ModelRenderer(this);
		tente.setPos(2.0F, 12.0398F, 2.7938F);
		Body.addChild(tente);
		setRotationAngle(tente, 0.3054F, 0.0F, 0.0F);
		

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(6.3674F, -5.6236F, 12.4718F);
		tente.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.4363F, 0.9599F, 0.0F);
		Body_r1.texOffs(1, 23).addBox(2.0074F, -2.0829F, -3.3812F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(3.2058F, -5.0825F, 17.0114F);
		tente.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.2618F, -0.1745F, 0.0F);
		Body_r2.texOffs(0, 47).addBox(-0.5F, -3.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(3.7583F, -6.3571F, 13.2763F);
		tente.addChild(Body_r3);
		setRotationAngle(Body_r3, -0.7854F, -0.1745F, 0.0F);
		Body_r3.texOffs(0, 47).addBox(-0.3956F, -2.2676F, -0.93F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(5.0969F, -3.7218F, 8.5642F);
		tente.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.4363F, -0.1745F, 0.0F);
		Body_r4.texOffs(2, 36).addBox(-0.8956F, -1.9784F, 2.3429F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(5.0969F, -3.7218F, 8.5642F);
		tente.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.4363F, 0.4363F, 0.0F);
		Body_r5.texOffs(2, 28).addBox(-1.2542F, -1.9984F, -1.6999F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(4.4376F, -6.6041F, 8.3333F);
		tente.addChild(Body_r6);
		setRotationAngle(Body_r6, 1.0036F, 0.4363F, 0.0F);
		Body_r6.texOffs(4, 28).addBox(-0.7542F, -3.0652F, -2.0984F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(0.0F, 0.0F, 0.0F);
		tente.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.6545F, 0.4363F, 0.0F);
		Body_r7.texOffs(5, 39).addBox(-0.2542F, -1.1815F, 4.0936F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(0.0F, 0.0F, 0.0F);
		tente.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.2618F, 0.4363F, 0.0F);
		Body_r8.texOffs(4, 46).addBox(-0.2542F, -2.7014F, 2.5202F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		Body_r8.texOffs(5, 30).addBox(-2.2542F, -1.7014F, 2.5202F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Body_r8.texOffs(5, 30).addBox(-2.2542F, -1.7014F, -0.4798F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r8.texOffs(5, 30).addBox(-0.2542F, -2.7014F, -0.4798F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-0.1882F, -1.7279F, 5.5119F);
		tente.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.9163F, 0.4363F, -1.0472F);
		Body_r9.texOffs(15, 44).addBox(0.7429F, -0.0943F, 0.5134F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(0.3452F, -1.2272F, 0.7403F);
		tente.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0436F, 0.4363F, 0.0F);
		Body_r10.texOffs(5, 30).addBox(-2.2542F, -1.8818F, 5.1277F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(-3.7729F, 1.2374F, 2.4708F);
		tente.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.2618F, 0.48F, 0.0F);
		Body_r11.texOffs(5, 30).addBox(-0.1048F, -2.0544F, 1.759F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(-3.7729F, 1.2374F, 2.4708F);
		tente.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.2618F, -0.0873F, 0.0F);
		Body_r12.texOffs(5, 30).addBox(0.2253F, -2.0374F, 0.8224F, 1.0F, 1.0F, 4.0F, 0.0F, true);
		Body_r12.texOffs(5, 30).addBox(-0.7747F, -2.4374F, -2.1776F, 2.0F, 2.0F, 3.0F, 0.0F, true);

		tente3 = new ModelRenderer(this);
		tente3.setPos(1.0F, 10.0398F, 2.7938F);
		Body.addChild(tente3);
		setRotationAngle(tente3, 0.829F, 0.0F, 0.0F);
		

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(2.1083F, -2.6982F, 5.7043F);
		tente3.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.1309F, 0.4363F, 3.0107F);
		Body_r13.texOffs(1, 20).addBox(-1.283F, 0.9929F, -0.4238F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(4.4376F, -6.6041F, 8.3333F);
		tente3.addChild(Body_r14);
		setRotationAngle(Body_r14, 1.0036F, 0.4363F, 0.0F);
		Body_r14.texOffs(1, 20).addBox(-1.1232F, -2.0989F, -2.1424F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(0.0F, 0.0F, 0.0F);
		tente3.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.6545F, 0.4363F, 0.0F);
		Body_r15.texOffs(12, 56).addBox(-0.6232F, -0.2584F, 4.3828F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(0.0F, 0.0F, 0.0F);
		tente3.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.2618F, 0.4363F, 0.0F);
		Body_r16.texOffs(3, 38).addBox(-0.6232F, -1.9593F, 3.1406F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		Body_r16.texOffs(0, 20).addBox(-0.6232F, -1.9593F, 0.1406F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		tente4 = new ModelRenderer(this);
		tente4.setPos(-1.0F, 10.0398F, 2.7938F);
		Body.addChild(tente4);
		setRotationAngle(tente4, 0.829F, 0.0F, 0.0F);
		

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(-4.4376F, -6.6041F, 8.3333F);
		tente4.addChild(Body_r17);
		setRotationAngle(Body_r17, 1.0036F, -0.4363F, 0.0F);
		Body_r17.texOffs(14, 14).addBox(0.1232F, -2.0989F, -2.1424F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(0.0F, 0.0F, 0.0F);
		tente4.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.6545F, -0.4363F, 0.0F);
		Body_r18.texOffs(6, 48).addBox(-0.3768F, -0.2584F, 4.3828F, 1.0F, 1.0F, 6.0F, 0.0F, true);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(0.0F, 0.0F, 0.0F);
		tente4.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.2618F, -0.4363F, 0.0F);
		Body_r19.texOffs(15, 57).addBox(-1.3768F, -1.9593F, 3.1406F, 2.0F, 1.0F, 6.0F, 0.0F, true);
		Body_r19.texOffs(7, 41).addBox(-1.3768F, -1.9593F, 0.1406F, 2.0F, 2.0F, 3.0F, 0.0F, true);

		tente2 = new ModelRenderer(this);
		tente2.setPos(-2.0F, 12.0398F, 3.7938F);
		Body.addChild(tente2);
		setRotationAngle(tente2, 0.2618F, 0.0F, 0.0F);
		

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(-6.3674F, -5.6236F, 12.4718F);
		tente2.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.4363F, -0.9599F, 0.0F);
		Body_r20.texOffs(11, 42).addBox(-3.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(-3.7583F, -6.3571F, 13.2763F);
		tente2.addChild(Body_r21);
		setRotationAngle(Body_r21, -0.7854F, 0.1745F, 0.0F);
		Body_r21.texOffs(6, 36).addBox(-0.5899F, -1.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(-5.0969F, -3.7218F, 8.5642F);
		tente2.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.4363F, 0.1745F, 0.0F);
		Body_r22.texOffs(8, 48).addBox(-0.0899F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, 0.0F, true);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(-5.0969F, -3.7218F, 8.5642F);
		tente2.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.4363F, -0.4363F, 0.0F);
		Body_r23.texOffs(3, 47).addBox(0.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, 0.0F, true);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(0.0F, 0.0F, 0.0F);
		tente2.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.2618F, -0.4363F, 0.0F);
		Body_r24.texOffs(3, 49).addBox(-1.7812F, -2.7446F, 2.4532F, 2.0F, 1.0F, 6.0F, 0.0F, true);
		Body_r24.texOffs(9, 40).addBox(-1.7812F, -2.7446F, -0.5468F, 2.0F, 2.0F, 3.0F, 0.0F, true);

		tente5 = new ModelRenderer(this);
		tente5.setPos(-1.0F, 16.0398F, 3.7938F);
		Body.addChild(tente5);
		setRotationAngle(tente5, 0.2618F, 0.0F, 0.0F);
		

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(-6.3674F, -5.6236F, 12.4718F);
		tente5.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.4363F, -0.9599F, 0.0F);
		Body_r25.texOffs(11, 39).addBox(-3.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-3.7583F, -6.3571F, 13.2763F);
		tente5.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.7418F, 0.1745F, 0.0F);
		Body_r26.texOffs(5, 49).addBox(-0.5899F, -0.2265F, 1.9944F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-3.7583F, -6.3571F, 13.2763F);
		tente5.addChild(Body_r27);
		setRotationAngle(Body_r27, -0.7854F, 0.1745F, 0.0F);
		Body_r27.texOffs(5, 49).addBox(-0.5899F, -2.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(-5.0969F, -3.7218F, 8.5642F);
		tente5.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.4363F, 0.1745F, 0.0F);
		Body_r28.texOffs(5, 47).addBox(-0.0899F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, 0.0F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-5.0969F, -3.7218F, 8.5642F);
		tente5.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.4363F, -0.4363F, 0.0F);
		Body_r29.texOffs(0, 44).addBox(0.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(0.0F, 0.0F, 0.0F);
		tente5.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.2618F, -0.4363F, 0.0F);
		Body_r30.texOffs(2, 47).addBox(-1.7812F, -2.7446F, 2.4532F, 2.0F, 2.0F, 6.0F, 0.0F, true);
		Body_r30.texOffs(4, 49).addBox(-1.7812F, -2.7446F, -0.5468F, 2.0F, 3.0F, 3.0F, 0.0F, true);

		tente6 = new ModelRenderer(this);
		tente6.setPos(1.0F, 16.0398F, 3.7938F);
		Body.addChild(tente6);
		setRotationAngle(tente6, 0.2618F, 0.0F, 0.0F);
		

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(6.3674F, -5.6236F, 12.4718F);
		tente6.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.4363F, 0.9599F, 0.0F);
		Body_r31.texOffs(11, 39).addBox(2.076F, -2.1254F, -3.4145F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(2.8198F, -7.3791F, 18.5988F);
		tente6.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.3491F, -0.1745F, 0.0F);
		Body_r32.texOffs(5, 49).addBox(-0.4101F, -0.1762F, -4.3801F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(3.7583F, -6.3571F, 13.2763F);
		tente6.addChild(Body_r33);
		setRotationAngle(Body_r33, -0.7854F, -0.1745F, 0.0F);
		Body_r33.texOffs(5, 49).addBox(-0.4101F, -0.2265F, -1.0056F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(5.0969F, -3.7218F, 8.5642F);
		tente6.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.4363F, -0.1745F, 0.0F);
		Body_r34.texOffs(5, 47).addBox(-0.9101F, -2.0354F, 2.2784F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(-0.4431F, -3.7218F, 8.3078F);
		tente6.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.4363F, -1.0908F, 0.0F);
		Body_r35.texOffs(0, 44).addBox(-2.0408F, -2.1498F, -2.9669F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(2.8312F, -3.7218F, 9.6207F);
		tente6.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.4363F, -0.3054F, 0.0F);
		Body_r36.texOffs(0, 44).addBox(-2.3443F, -2.0422F, -4.7361F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(5.0969F, -3.7218F, 8.5642F);
		tente6.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.4363F, 0.4363F, 0.0F);
		Body_r37.texOffs(0, 44).addBox(-1.2188F, -2.0526F, -1.7584F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(0.0F, 0.0F, 0.0F);
		tente6.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.2618F, 0.4363F, 0.0F);
		Body_r38.texOffs(2, 47).addBox(-0.2188F, -2.7446F, 2.4532F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		Body_r38.texOffs(4, 49).addBox(-0.2188F, -2.7446F, -0.5468F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(10.0F, 15.5596F, 0.4104F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.829F, 0.0F, 0.0F);
		RightArm_r1.texOffs(40, 16).addBox(-1.0F, -3.5746F, -2.6868F, 2.0F, 5.0F, 2.0F, 0.0F, true);
		RightArm_r1.texOffs(40, 16).addBox(-11.0F, -3.5746F, -2.6868F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-1.0F, 4.0F, 0.0F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(40, 16).addBox(0.0F, 3.9924F, -1.349F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 2.0F, -1.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-2.0F, 3.9951F, -2.2792F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(1.0F, 4.0F, 0.0F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(4.951F, 6.2735F, -11.3701F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.829F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(25, 48).addBox(-0.9698F, -0.2888F, 1.6081F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		RightLeg_r1.texOffs(25, 43).addBox(-0.9F, -3.5F, 1.5F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-1.151F, 9.6123F, -11.0794F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.3491F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(25, 49).addBox(-0.5698F, -1.2888F, 0.6081F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-1.151F, 8.2735F, -11.3701F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, -0.829F, 0.0F, 0.0F);
		RightLeg_r3.texOffs(27, 45).addBox(-0.5698F, -5.2888F, 0.6081F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(0.349F, 9.2537F, -4.9494F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, -1.8762F, 0.0F, 0.0F);
		RightLeg_r4.texOffs(28, 42).addBox(-2.0698F, -3.622F, -2.9951F, 2.0F, 7.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.0873F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.349F, 8.0219F, -1.6401F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -1.1781F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(23, 41).addBox(0.0F, -3.5F, -1.0F, 2.0F, 7.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.Head.xRot = netHeadYaw * 0.009453292F;
		this.tente5.xRot = netHeadYaw * 0.009453292F;
		this.tente6.xRot = netHeadYaw * 0.009453292F;
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