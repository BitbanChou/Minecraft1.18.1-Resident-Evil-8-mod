// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.HeisenCarEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHeisenCar<T extends HeisenCarEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
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
	private final ModelRenderer leftweapon;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer rightweapon;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer Body_r19;
	private final ModelRenderer Body_r20;
	private final ModelRenderer Body_r21;
	private final ModelRenderer Body_r22;
	private final ModelRenderer Body_r23;
	private final ModelRenderer Body_r24;
	private final ModelRenderer Body_r25;
	private final ModelRenderer Body_r26;
	private final ModelRenderer Body_r27;
	private final ModelRenderer Body_r28;
	private final ModelRenderer Body_r29;
	private final ModelRenderer rightp;
	private final ModelRenderer Body_r30;
	private final ModelRenderer Body_r31;
	private final ModelRenderer Body_r32;
	private final ModelRenderer Body_r33;
	private final ModelRenderer Body_r34;
	private final ModelRenderer Body_r35;
	private final ModelRenderer Body_r36;
	private final ModelRenderer Body_r37;
	private final ModelRenderer Body_r38;
	private final ModelRenderer Body_r39;
	private final ModelRenderer Body_r40;
	private final ModelRenderer Body_r41;
	private final ModelRenderer Body_r42;
	private final ModelRenderer rightp2;
	private final ModelRenderer Body_r43;
	private final ModelRenderer Body_r44;
	private final ModelRenderer Body_r45;
	private final ModelRenderer Body_r46;
	private final ModelRenderer Body_r47;
	private final ModelRenderer Body_r48;
	private final ModelRenderer Body_r49;
	private final ModelRenderer Body_r50;
	private final ModelRenderer Body_r51;
	private final ModelRenderer Body_r52;
	private final ModelRenderer Body_r53;
	private final ModelRenderer Body_r54;
	private final ModelRenderer Body_r55;
	private final ModelRenderer chain;
	private final ModelRenderer Body_r56;
	private final ModelRenderer Body_r57;
	private final ModelRenderer Body_r58;
	private final ModelRenderer Body_r59;
	private final ModelRenderer Body_r60;
	private final ModelRenderer Body_r61;
	private final ModelRenderer Body_r62;
	private final ModelRenderer Body_r63;
	private final ModelRenderer Body_r64;
	private final ModelRenderer rw2_r1;
	private final ModelRenderer rw5_r1;
	private final ModelRenderer pillar_r1;
	private final ModelRenderer rw6_r1;
	private final ModelRenderer pillar_r2;
	private final ModelRenderer rw4_r1;
	private final ModelRenderer rw3_r1;
	private final ModelRenderer rw1_r1;
	private final ModelRenderer chain2;
	private final ModelRenderer lw6_r1;
	private final ModelRenderer pillar_r3;
	private final ModelRenderer lw5_r1;
	private final ModelRenderer lw3_r1;
	private final ModelRenderer lw4_r1;
	private final ModelRenderer pillar_r4;
	private final ModelRenderer Body_r65;
	private final ModelRenderer Body_r66;
	private final ModelRenderer Body_r67;
	private final ModelRenderer Body_r68;
	private final ModelRenderer Body_r69;
	private final ModelRenderer Body_r70;
	private final ModelRenderer Body_r71;
	private final ModelRenderer Body_r72;
	private final ModelRenderer Body_r73;
	private final ModelRenderer lw2_r1;
	private final ModelRenderer lw1_r1;
	private final ModelRenderer upperpart;
	private final ModelRenderer Body_r74;
	private final ModelRenderer Body_r75;
	private final ModelRenderer rightpart;
	private final ModelRenderer Body_r76;
	private final ModelRenderer Body_r77;
	private final ModelRenderer Body_r78;
	private final ModelRenderer Body_r79;
	private final ModelRenderer Body_r80;
	private final ModelRenderer Body_r81;
	private final ModelRenderer Body_r82;
	private final ModelRenderer Body_r83;
	private final ModelRenderer Body_r84;
	private final ModelRenderer Body_r85;
	private final ModelRenderer Body_r86;
	private final ModelRenderer Body_r87;
	private final ModelRenderer leftpart;
	private final ModelRenderer Body_r88;
	private final ModelRenderer Body_r89;
	private final ModelRenderer Body_r90;
	private final ModelRenderer Body_r91;
	private final ModelRenderer Body_r92;
	private final ModelRenderer Body_r93;
	private final ModelRenderer Body_r94;
	private final ModelRenderer Body_r95;
	private final ModelRenderer Body_r96;
	private final ModelRenderer Body_r97;
	private final ModelRenderer Body_r98;
	private final ModelRenderer Body_r99;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer vicer;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer otherp;

	public ModelHeisenCar() {
		texWidth = 64;
		texHeight = 64;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, -15.0F);


		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(2.2337F, 12.3197F, 14.3251F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, -0.0422F, 0.0434F, -0.0131F);
		Body_r1.texOffs(0, 47).addBox(-4.5F, -17.9F, 2.0F, 3.0F, 5.0F, 1.0F, 0.0F, true);
		Body_r1.texOffs(0, 47).addBox(-1.5F, -11.9F, -1.0F, 3.0F, 1.0F, 4.0F, 0.0F, true);
		Body_r1.texOffs(0, 47).addBox(-6.5F, -11.9F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, true);
		Body_r1.texOffs(0, 47).addBox(-4.5F, -12.9F, -1.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(-3.7663F, 3.3197F, 39.3251F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, -0.0382F, 0.0469F, 0.0742F);
		Body_r2.texOffs(36, 0).addBox(-0.5F, -12.9F, -6.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(-5.0502F, 4.2171F, 39.3441F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, -0.034F, 0.05F, 0.1615F);
		Body_r3.texOffs(6, 46).addBox(-0.5F, -18.9F, -6.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(4.9735F, 4.3973F, 39.2038F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, -0.044F, 0.0415F, -0.0568F);
		Body_r4.texOffs(6, 46).addBox(-0.5F, -18.9F, -6.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(3.2337F, 3.3197F, 39.3251F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, -0.0382F, 0.0469F, 0.0742F);
		Body_r5.texOffs(38, 0).addBox(-0.5F, -12.9F, -6.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(3.2337F, 3.3197F, 39.3251F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.0071F, 0.0601F, 0.6421F);
		Body_r6.texOffs(51, 13).addBox(-10.5F, -7.4F, -17.0F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(3.2337F, 3.3197F, 39.3251F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, -0.0422F, 0.0434F, -0.0131F);
		Body_r7.texOffs(0, 43).addBox(-5.5F, -10.9F, -16.0F, 4.0F, 3.0F, 9.0F, 0.0F, true);
		Body_r7.texOffs(0, 43).addBox(-10.5F, -7.9F, -15.0F, 15.0F, 1.0F, 20.0F, 0.0F, true);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(4.2337F, 3.3197F, 39.3251F);
		Body.addChild(Body_r8);
		setRotationAngle(Body_r8, -0.0436F, -0.2618F, 0.0F);
		Body_r8.texOffs(10, 32).addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, true);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-4.2337F, 3.3197F, 39.3251F);
		Body.addChild(Body_r9);
		setRotationAngle(Body_r9, -0.0436F, 0.2618F, 0.0F);
		Body_r9.texOffs(10, 32).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-13.0F, 7.5F, 20.0F);
		Body.addChild(Body_r10);
		setRotationAngle(Body_r10, -0.0436F, 0.0873F, 0.0F);
		Body_r10.texOffs(12, 35).addBox(4.0F, -3.5F, 7.0F, 7.0F, 9.0F, 21.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(11.0F, 7.5F, 19.0F);
		Body.addChild(Body_r11);
		setRotationAngle(Body_r11, -0.0436F, -0.0873F, 0.0F);
		Body_r11.texOffs(12, 35).addBox(-7.9128F, -3.5435F, 7.9952F, 7.0F, 9.0F, 21.0F, 0.0F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(-0.9702F, 3.5492F, 0.3231F);
		Body.addChild(Body_r12);
		setRotationAngle(Body_r12, -1.5708F, 1.4835F, -1.5708F);
		Body_r12.texOffs(0, 23).addBox(-23.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		leftweapon = new ModelRenderer(this);
		leftweapon.setPos(-0.9702F, 3.5492F, 0.3231F);
		Body.addChild(leftweapon);


		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(0.0F, 0.0F, 0.0F);
		leftweapon.addChild(Body_r13);
		setRotationAngle(Body_r13, -1.5708F, 1.4835F, -1.5708F);
		Body_r13.texOffs(0, 28).addBox(9.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r13.texOffs(0, 28).addBox(4.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r13.texOffs(0, 28).addBox(-1.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r13.texOffs(5, 39).addBox(-6.0F, -11.0F, -7.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r13.texOffs(0, 28).addBox(-19.0F, -13.0F, -7.7F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		Body_r13.texOffs(0, 28).addBox(-17.0F, -11.0F, -7.0F, 11.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r13.texOffs(0, 28).addBox(-17.0F, -8.0F, -6.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(0.0F, 0.0F, 0.0F);
		leftweapon.addChild(Body_r14);
		setRotationAngle(Body_r14, -1.4835F, 1.4835F, -1.5708F);
		Body_r14.texOffs(32, 62).addBox(-9.0F, -18.0F, -6.7F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r14.texOffs(0, 28).addBox(-12.0F, -19.0F, -7.7F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body_r14.texOffs(0, 28).addBox(-15.0F, -18.0F, -7.7F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r14.texOffs(0, 28).addBox(-15.0F, -17.0F, -4.7F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r14.texOffs(0, 28).addBox(-17.0F, -15.0F, -5.7F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(0.0F, 0.0F, 0.0F);
		leftweapon.addChild(Body_r15);
		setRotationAngle(Body_r15, -1.1345F, 1.4835F, -1.5708F);
		Body_r15.texOffs(0, 28).addBox(-16.0F, -8.0F, -3.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(0.0F, 0.0F, 0.0F);
		leftweapon.addChild(Body_r16);
		setRotationAngle(Body_r16, -1.4399F, 1.4835F, -1.5708F);
		Body_r16.texOffs(0, 28).addBox(-16.0F, -8.0F, -3.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		rightweapon = new ModelRenderer(this);
		rightweapon.setPos(-0.9807F, -2.3258F, 13.3591F);
		Body.addChild(rightweapon);


		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(0.0F, 0.0F, 0.0F);
		rightweapon.addChild(Body_r17);
		setRotationAngle(Body_r17, -2.969F, 1.5267F, -1.4414F);
		Body_r17.texOffs(38, 14).addBox(6.0F, -11.0F, -13.0F, 8.0F, 2.0F, 4.0F, 0.0F, false);
		Body_r17.texOffs(15, 27).addBox(10.0F, -12.0F, -12.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r17.texOffs(47, 17).addBox(27.0F, -10.5F, -10.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r17.texOffs(47, 17).addBox(23.0F, -10.5F, -10.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r17.texOffs(46, 17).addBox(18.0F, -11.0F, -10.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r17.texOffs(32, 37).addBox(12.0F, -11.0F, -10.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r17.texOffs(15, 27).addBox(7.0F, -12.0F, -9.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);
		Body_r17.texOffs(15, 27).addBox(-3.0F, -12.0F, -8.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(9.0F, -10.0F, -31.0F);
		rightweapon.addChild(Body_r18);
		setRotationAngle(Body_r18, -3.1237F, 1.1346F, -1.5975F);
		Body_r18.texOffs(50, 19).addBox(-10.2655F, -0.9139F, -3.2318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-11.2655F, -0.9139F, -6.7318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-9.2655F, -0.9139F, -6.2318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-8.2655F, -0.9139F, -2.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-6.2655F, -0.9139F, -1.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-7.2655F, -0.9139F, -5.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-5.2655F, -0.9139F, -4.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(-3.2655F, -0.9139F, -3.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(50, 19).addBox(0.7345F, -0.9139F, -1.5318F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(0.0F, 0.0F, 0.0F);
		rightweapon.addChild(Body_r19);
		setRotationAngle(Body_r19, -3.098F, 1.3963F, -1.5708F);
		Body_r19.texOffs(50, 19).addBox(32.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r19.texOffs(50, 19).addBox(30.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r19.texOffs(50, 19).addBox(28.0F, -10.1F, -3.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(0.0F, 0.0F, 0.0F);
		rightweapon.addChild(Body_r20);
		setRotationAngle(Body_r20, -3.1164F, 1.2654F, -1.5897F);
		Body_r20.texOffs(50, 19).addBox(31.0F, -10.1F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(0.0F, 0.0F, 0.0F);
		rightweapon.addChild(Body_r21);
		setRotationAngle(Body_r21, -3.098F, 1.3963F, -1.5708F);
		Body_r21.texOffs(15, 27).addBox(-2.0F, -11.0F, -5.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(11.0361F, 3.71F, -0.6542F);
		rightweapon.addChild(Body_r22);
		setRotationAngle(Body_r22, 1.3526F, 1.3963F, -1.5708F);
		Body_r22.texOffs(15, 24).addBox(-2.0F, -2.0F, 2.0F, 3.0F, 10.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(0.6208F, -0.4802F, 0.0847F);
		rightweapon.addChild(Body_r23);
		setRotationAngle(Body_r23, -3.098F, 1.3963F, -1.5708F);
		Body_r23.texOffs(15, 27).addBox(-2.0F, -9.0F, -2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(-0.4049F, 5.0432F, -0.8893F);
		rightweapon.addChild(Body_r24);
		setRotationAngle(Body_r24, -1.8326F, 1.3963F, -1.5708F);
		Body_r24.texOffs(15, 27).addBox(-2.0F, -6.0F, 3.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(10.9104F, 2.4398F, -0.4302F);
		rightweapon.addChild(Body_r25);
		setRotationAngle(Body_r25, 1.8762F, 1.3963F, -1.5708F);
		Body_r25.texOffs(15, 24).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(0.6208F, -0.4802F, 0.0847F);
		rightweapon.addChild(Body_r26);
		setRotationAngle(Body_r26, -2.2253F, 1.3963F, -1.5708F);
		Body_r26.texOffs(15, 27).addBox(-2.0F, -10.0F, 3.0F, 3.0F, 10.0F, 1.0F, 0.0F, false);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(5.8733F, 1.4814F, -0.2612F);
		rightweapon.addChild(Body_r27);
		setRotationAngle(Body_r27, 3.098F, 1.3963F, -1.5708F);
		Body_r27.texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(3.52F, 3.9291F, -0.6928F);
		rightweapon.addChild(Body_r28);
		setRotationAngle(Body_r28, -2.3998F, 1.3963F, -1.5708F);
		Body_r28.texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(0.0106F, 5.875F, -1.0359F);
		rightweapon.addChild(Body_r29);
		setRotationAngle(Body_r29, -1.5708F, 1.3963F, -1.5708F);
		Body_r29.texOffs(15, 27).addBox(-2.0F, -2.0F, 3.0F, 3.0F, 5.0F, 1.0F, 0.0F, false);

		rightp = new ModelRenderer(this);
		rightp.setPos(10.0845F, 2.1919F, 20.8411F);
		Body.addChild(rightp);


		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(0.0F, 0.0F, 0.0F);
		rightp.addChild(Body_r30);
		setRotationAngle(Body_r30, -3.1374F, 0.4343F, -1.3937F);
		Body_r30.texOffs(0, 23).addBox(-4.9514F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r31);
		setRotationAngle(Body_r31, 1.5708F, 1.4835F, 1.5708F);
		Body_r31.texOffs(0, 23).addBox(-21.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-21.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-23.0F, -1.0F, 1.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-21.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-9.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-15.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-9.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r31.texOffs(0, 23).addBox(-15.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-5.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r32);
		setRotationAngle(Body_r32, 1.5708F, -1.4835F, -1.5708F);
		Body_r32.texOffs(0, 23).addBox(15.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(-7.1689F, 0.0F, 0.0F);
		rightp.addChild(Body_r33);
		setRotationAngle(Body_r33, -3.1374F, -0.4343F, 1.3937F);
		Body_r33.texOffs(0, 23).addBox(-0.0486F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-4.5009F, 3.6181F, -4.2919F);
		rightp.addChild(Body_r34);
		setRotationAngle(Body_r34, -0.0054F, -0.8871F, -1.6084F);
		Body_r34.texOffs(0, 23).addBox(-1.3721F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(-2.4633F, 7.0089F, -20.7808F);
		rightp.addChild(Body_r35);
		setRotationAngle(Body_r35, -0.0224F, 1.3983F, 1.7241F);
		Body_r35.texOffs(0, 23).addBox(-22.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(-4.7057F, 7.0089F, -20.7808F);
		rightp.addChild(Body_r36);
		setRotationAngle(Body_r36, -0.0224F, -1.3983F, -1.7241F);
		Body_r36.texOffs(0, 23).addBox(17.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r37);
		setRotationAngle(Body_r37, -0.3054F, -1.4835F, -1.5708F);
		Body_r37.texOffs(0, 23).addBox(9.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);
		Body_r37.texOffs(0, 23).addBox(3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);
		Body_r37.texOffs(0, 23).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(-4.1143F, 3.3573F, -20.5179F);
		rightp.addChild(Body_r38);
		setRotationAngle(Body_r38, -1.5708F, -1.4835F, 1.5708F);
		Body_r38.texOffs(0, 23).addBox(20.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(-5.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r39);
		setRotationAngle(Body_r39, 3.098F, -1.4835F, -1.5708F);
		Body_r39.texOffs(0, 23).addBox(-2.0F, -5.0F, -3.0F, 25.0F, 7.0F, 1.0F, 0.0F, true);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.036F, 0.5912F, 1.593F);
		Body_r40.texOffs(0, 21).addBox(0.0F, -2.0F, -2.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp.addChild(Body_r41);
		setRotationAngle(Body_r41, -0.3054F, 1.4835F, 1.5708F);
		Body_r41.texOffs(0, 23).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r41.texOffs(0, 23).addBox(-9.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r41.texOffs(0, 23).addBox(-15.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(-2.6681F, 3.6181F, -4.2919F);
		rightp.addChild(Body_r42);
		setRotationAngle(Body_r42, -0.0054F, 0.8871F, 1.6084F);
		Body_r42.texOffs(0, 23).addBox(-1.6279F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		rightp2 = new ModelRenderer(this);
		rightp2.setPos(-3.9155F, 2.1919F, 20.8411F);
		Body.addChild(rightp2);


		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(0.0F, 0.0F, 0.0F);
		rightp2.addChild(Body_r43);
		setRotationAngle(Body_r43, -3.1374F, 0.4343F, -1.3937F);
		Body_r43.texOffs(0, 23).addBox(-4.9514F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r44);
		setRotationAngle(Body_r44, 1.5708F, 1.4835F, 1.5708F);
		Body_r44.texOffs(0, 23).addBox(-21.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-21.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-21.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-9.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-15.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-9.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(0, 23).addBox(-15.0F, -1.0F, 2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-5.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r45);
		setRotationAngle(Body_r45, 1.5708F, -1.4835F, -1.5708F);
		Body_r45.texOffs(0, 23).addBox(15.0F, -3.0F, 2.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(-7.1689F, 0.0F, 0.0F);
		rightp2.addChild(Body_r46);
		setRotationAngle(Body_r46, -3.1374F, -0.4343F, 1.3937F);
		Body_r46.texOffs(0, 23).addBox(-0.0486F, -0.7174F, -0.4362F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(-4.5009F, 3.6181F, -4.2919F);
		rightp2.addChild(Body_r47);
		setRotationAngle(Body_r47, -0.0054F, -0.8871F, -1.6084F);
		Body_r47.texOffs(0, 23).addBox(-1.3721F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-2.4633F, 7.0089F, -20.7808F);
		rightp2.addChild(Body_r48);
		setRotationAngle(Body_r48, -0.0224F, 1.3983F, 1.7241F);
		Body_r48.texOffs(0, 23).addBox(-22.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-4.7057F, 7.0089F, -20.7808F);
		rightp2.addChild(Body_r49);
		setRotationAngle(Body_r49, -0.0224F, -1.3983F, -1.7241F);
		Body_r49.texOffs(0, 23).addBox(17.0F, -2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r50);
		setRotationAngle(Body_r50, -0.3054F, -1.4835F, -1.5708F);
		Body_r50.texOffs(0, 23).addBox(9.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);
		Body_r50.texOffs(0, 23).addBox(3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);
		Body_r50.texOffs(0, 23).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(-4.1143F, 3.3573F, -20.5179F);
		rightp2.addChild(Body_r51);
		setRotationAngle(Body_r51, -1.5708F, -1.4835F, 1.5708F);
		Body_r51.texOffs(0, 23).addBox(20.0F, -2.0F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(-5.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r52);
		setRotationAngle(Body_r52, 3.098F, -1.4835F, -1.5708F);
		Body_r52.texOffs(0, 23).addBox(-2.0F, -5.0F, -3.0F, 25.0F, 7.0F, 1.0F, 0.0F, true);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.036F, 0.5912F, 1.593F);
		Body_r53.texOffs(0, 21).addBox(0.0F, -2.0F, -2.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-2.0845F, 5.8081F, -20.8411F);
		rightp2.addChild(Body_r54);
		setRotationAngle(Body_r54, -0.3054F, 1.4835F, 1.5708F);
		Body_r54.texOffs(0, 23).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r54.texOffs(0, 23).addBox(-9.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r54.texOffs(0, 23).addBox(-15.0F, -2.0F, -2.0F, 6.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-2.6681F, 3.6181F, -4.2919F);
		rightp2.addChild(Body_r55);
		setRotationAngle(Body_r55, -0.0054F, 0.8871F, 1.6084F);
		Body_r55.texOffs(0, 23).addBox(-1.6279F, -2.7789F, -2.8294F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		chain = new ModelRenderer(this);
		chain.setPos(13.8817F, 19.6156F, 18.7475F);
		Body.addChild(chain);


		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(0.0F, 2.0F, 16.0F);
		chain.addChild(Body_r56);
		setRotationAngle(Body_r56, 3.0155F, 1.0961F, -1.6297F);
		Body_r56.texOffs(12, 32).addBox(-2.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 3.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(0.2689F, -1.447F, 17.4722F);
		chain.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0632F, 0.4271F, 1.6503F);
		Body_r57.texOffs(12, 32).addBox(-2.7595F, -3.434F, -4.9151F, 2.0F, 10.0F, 6.0F, 0.0F, true);

		Body_r58 = new ModelRenderer(this);
		Body_r58.setPos(0.3071F, -2.9363F, 16.7548F);
		chain.addChild(Body_r58);
		setRotationAngle(Body_r58, 2.7011F, 1.4356F, -1.9544F);
		Body_r58.texOffs(12, 32).addBox(-2.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 6.0F, 0.0F, true);

		Body_r59 = new ModelRenderer(this);
		Body_r59.setPos(-10.7268F, -5.0725F, -10.1794F);
		chain.addChild(Body_r59);
		setRotationAngle(Body_r59, 0.0576F, -0.052F, 1.6211F);
		Body_r59.texOffs(12, 32).addBox(9.0F, -13.0F, 16.0F, 2.0F, 10.0F, 11.0F, 0.0F, true);

		Body_r60 = new ModelRenderer(this);
		Body_r60.setPos(-4.1926F, 0.5599F, -15.836F);
		chain.addChild(Body_r60);
		setRotationAngle(Body_r60, -0.9599F, 0.0436F, 0.0F);
		Body_r60.texOffs(26, 51).addBox(-4.0F, 1.0F, -3.5F, 10.0F, 2.0F, 7.0F, 0.0F, false);

		Body_r61 = new ModelRenderer(this);
		Body_r61.setPos(-4.1235F, -2.4906F, -16.0938F);
		chain.addChild(Body_r61);
		setRotationAngle(Body_r61, -2.0071F, 0.0436F, 0.0F);
		Body_r61.texOffs(26, 51).addBox(-3.0F, 1.0F, -3.5F, 9.0F, 2.0F, 7.0F, 0.0F, false);

		Body_r62 = new ModelRenderer(this);
		Body_r62.setPos(-16.6074F, -14.6156F, -35.1862F);
		chain.addChild(Body_r62);
		setRotationAngle(Body_r62, 0.3491F, 0.0436F, 0.0F);
		Body_r62.texOffs(26, 51).addBox(8.0F, 14.0F, 14.5F, 10.0F, 3.0F, 7.0F, 0.0F, false);

		Body_r63 = new ModelRenderer(this);
		Body_r63.setPos(-10.653F, -6.5097F, -10.231F);
		chain.addChild(Body_r63);
		setRotationAngle(Body_r63, 0.0575F, 0.0351F, 1.6262F);
		Body_r63.texOffs(12, 32).addBox(-2.0F, -13.0F, 0.0F, 2.0F, 10.0F, 13.0F, 0.0F, true);
		Body_r63.texOffs(12, 32).addBox(9.0F, -13.0F, -5.0F, 2.0F, 10.0F, 22.0F, 0.0F, true);

		Body_r64 = new ModelRenderer(this);
		Body_r64.setPos(-10.5968F, -7.6527F, -10.3155F);
		chain.addChild(Body_r64);
		setRotationAngle(Body_r64, 0.0579F, 0.1222F, 1.6312F);
		Body_r64.texOffs(12, 32).addBox(-2.0F, -13.0F, 13.0F, 2.0F, 10.0F, 12.0F, 0.0F, true);

		rw2_r1 = new ModelRenderer(this);
		rw2_r1.setPos(-1.653F, 0.4903F, 13.769F);
		chain.addChild(rw2_r1);
		setRotationAngle(rw2_r1, 0.062F, 0.3835F, 1.6474F);
		rw2_r1.texOffs(36, 49).addBox(-3.8531F, -2.0341F, -3.1524F, 6.0F, 3.0F, 6.0F, 0.0F, true);

		rw5_r1 = new ModelRenderer(this);
		rw5_r1.setPos(-1.653F, 1.4903F, 2.769F);
		chain.addChild(rw5_r1);
		setRotationAngle(rw5_r1, 0.0858F, -0.8357F, 1.5604F);
		rw5_r1.texOffs(0, 35).addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		pillar_r1 = new ModelRenderer(this);
		pillar_r1.setPos(-0.653F, -0.5097F, -3.231F);
		chain.addChild(pillar_r1);
		setRotationAngle(pillar_r1, 0.0575F, 0.0351F, 1.6262F);
		pillar_r1.texOffs(0, 35).addBox(-5.9224F, 1.4611F, 6.7007F, 7.0F, 2.0F, 4.0F, 0.0F, true);

		rw6_r1 = new ModelRenderer(this);
		rw6_r1.setPos(-0.653F, 1.4903F, 8.769F);
		chain.addChild(rw6_r1);
		setRotationAngle(rw6_r1, 0.0858F, -0.8357F, 1.5604F);
		rw6_r1.texOffs(0, 35).addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		pillar_r2 = new ModelRenderer(this);
		pillar_r2.setPos(-0.653F, -0.5097F, -13.231F);
		chain.addChild(pillar_r2);
		setRotationAngle(pillar_r2, 0.0575F, 0.0351F, 1.6262F);
		pillar_r2.texOffs(0, 35).addBox(-5.9224F, 1.4611F, 6.7007F, 7.0F, 2.0F, 4.0F, 0.0F, true);

		rw4_r1 = new ModelRenderer(this);
		rw4_r1.setPos(-0.653F, 1.4903F, -1.231F);
		chain.addChild(rw4_r1);
		setRotationAngle(rw4_r1, 0.0858F, -0.8357F, 1.5604F);
		rw4_r1.texOffs(0, 35).addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		rw3_r1 = new ModelRenderer(this);
		rw3_r1.setPos(-1.653F, 1.4903F, -7.231F);
		chain.addChild(rw3_r1);
		setRotationAngle(rw3_r1, 0.0858F, -0.8357F, 1.5604F);
		rw3_r1.texOffs(0, 35).addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		rw1_r1 = new ModelRenderer(this);
		rw1_r1.setPos(-0.653F, -0.5097F, -13.231F);
		chain.addChild(rw1_r1);
		setRotationAngle(rw1_r1, 0.0858F, -0.8357F, 1.5604F);
		rw1_r1.texOffs(0, 35).addBox(-3.9224F, 0.4611F, -3.2993F, 7.0F, 3.0F, 7.0F, 0.0F, true);

		chain2 = new ModelRenderer(this);
		chain2.setPos(-13.8817F, 21.6156F, 34.7475F);
		Body.addChild(chain2);


		lw6_r1 = new ModelRenderer(this);
		lw6_r1.setPos(3.1104F, -0.5097F, -6.231F);
		chain2.addChild(lw6_r1);
		setRotationAngle(lw6_r1, 0.0858F, -0.8357F, 1.5604F);
		lw6_r1.texOffs(0, 35).addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		pillar_r3 = new ModelRenderer(this);
		pillar_r3.setPos(3.1104F, -2.5097F, -18.231F);
		chain2.addChild(pillar_r3);
		setRotationAngle(pillar_r3, 0.0575F, 0.0351F, 1.6262F);
		pillar_r3.texOffs(0, 35).addBox(-5.9224F, 1.4611F, 7.7007F, 7.0F, 2.0F, 4.0F, 0.0F, true);

		lw5_r1 = new ModelRenderer(this);
		lw5_r1.setPos(2.1104F, -0.5097F, -12.231F);
		chain2.addChild(lw5_r1);
		setRotationAngle(lw5_r1, 0.0858F, -0.8357F, 1.5604F);
		lw5_r1.texOffs(0, 35).addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		lw3_r1 = new ModelRenderer(this);
		lw3_r1.setPos(2.1104F, -0.5097F, -23.231F);
		chain2.addChild(lw3_r1);
		setRotationAngle(lw3_r1, 0.0858F, -0.8357F, 1.5604F);
		lw3_r1.texOffs(0, 35).addBox(-1.7073F, -0.7742F, -1.7507F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		lw4_r1 = new ModelRenderer(this);
		lw4_r1.setPos(3.1104F, -0.5097F, -17.231F);
		chain2.addChild(lw4_r1);
		setRotationAngle(lw4_r1, 0.0858F, -0.8357F, 1.5604F);
		lw4_r1.texOffs(0, 35).addBox(-2.1648F, -0.122F, -1.8379F, 4.0F, 3.0F, 4.0F, 0.0F, true);

		pillar_r4 = new ModelRenderer(this);
		pillar_r4.setPos(3.1104F, -2.5097F, -29.231F);
		chain2.addChild(pillar_r4);
		setRotationAngle(pillar_r4, 0.0575F, 0.0351F, 1.6262F);
		pillar_r4.texOffs(0, 35).addBox(-5.9224F, 1.4611F, 7.7007F, 7.0F, 2.0F, 4.0F, 0.0F, true);

		Body_r65 = new ModelRenderer(this);
		Body_r65.setPos(0.0F, 0.0F, 0.0F);
		chain2.addChild(Body_r65);
		setRotationAngle(Body_r65, 3.0155F, -1.0961F, 1.6297F);
		Body_r65.texOffs(12, 32).addBox(0.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 3.0F, 0.0F, false);

		Body_r66 = new ModelRenderer(this);
		Body_r66.setPos(-0.2689F, -3.447F, 1.4722F);
		chain2.addChild(Body_r66);
		setRotationAngle(Body_r66, 0.0632F, -0.4271F, -1.6503F);
		Body_r66.texOffs(12, 32).addBox(0.7595F, -3.434F, -4.9151F, 2.0F, 10.0F, 6.0F, 0.0F, false);

		Body_r67 = new ModelRenderer(this);
		Body_r67.setPos(-0.3071F, -4.9363F, 0.7548F);
		chain2.addChild(Body_r67);
		setRotationAngle(Body_r67, 2.7011F, -1.4356F, 1.9544F);
		Body_r67.texOffs(12, 32).addBox(0.7595F, -3.434F, -0.9151F, 2.0F, 10.0F, 6.0F, 0.0F, false);

		Body_r68 = new ModelRenderer(this);
		Body_r68.setPos(10.7268F, -7.0725F, -26.1794F);
		chain2.addChild(Body_r68);
		setRotationAngle(Body_r68, 0.0576F, 0.052F, -1.6211F);
		Body_r68.texOffs(12, 32).addBox(-11.0F, -13.0F, 16.0F, 2.0F, 10.0F, 11.0F, 0.0F, false);

		Body_r69 = new ModelRenderer(this);
		Body_r69.setPos(4.1926F, -1.4401F, -31.836F);
		chain2.addChild(Body_r69);
		setRotationAngle(Body_r69, -0.9599F, -0.0436F, 0.0F);
		Body_r69.texOffs(26, 51).addBox(-6.0F, 1.0F, -3.5F, 10.0F, 2.0F, 7.0F, 0.0F, true);

		Body_r70 = new ModelRenderer(this);
		Body_r70.setPos(4.1235F, -4.4906F, -32.0938F);
		chain2.addChild(Body_r70);
		setRotationAngle(Body_r70, -2.0071F, -0.0436F, 0.0F);
		Body_r70.texOffs(26, 51).addBox(-6.0F, 1.0F, -3.5F, 9.0F, 2.0F, 7.0F, 0.0F, true);

		Body_r71 = new ModelRenderer(this);
		Body_r71.setPos(16.6074F, -16.6156F, -51.1862F);
		chain2.addChild(Body_r71);
		setRotationAngle(Body_r71, 0.3491F, -0.0436F, 0.0F);
		Body_r71.texOffs(26, 51).addBox(-18.0F, 14.0F, 14.5F, 10.0F, 3.0F, 7.0F, 0.0F, true);

		Body_r72 = new ModelRenderer(this);
		Body_r72.setPos(10.653F, -8.5097F, -26.231F);
		chain2.addChild(Body_r72);
		setRotationAngle(Body_r72, 0.0575F, -0.0351F, -1.6262F);
		Body_r72.texOffs(12, 32).addBox(0.0F, -13.0F, 0.0F, 2.0F, 10.0F, 13.0F, 0.0F, false);
		Body_r72.texOffs(12, 32).addBox(-11.0F, -13.0F, -5.0F, 2.0F, 10.0F, 22.0F, 0.0F, false);

		Body_r73 = new ModelRenderer(this);
		Body_r73.setPos(10.5968F, -9.6527F, -26.3155F);
		chain2.addChild(Body_r73);
		setRotationAngle(Body_r73, 0.0579F, -0.1222F, -1.6312F);
		Body_r73.texOffs(12, 32).addBox(0.0F, -13.0F, 13.0F, 2.0F, 10.0F, 12.0F, 0.0F, false);

		lw2_r1 = new ModelRenderer(this);
		lw2_r1.setPos(0.653F, -2.5097F, -2.231F);
		chain2.addChild(lw2_r1);
		setRotationAngle(lw2_r1, 0.0729F, 0.6617F, -1.5793F);
		lw2_r1.texOffs(5, 55).addBox(-2.9763F, -1.0904F, -2.7278F, 5.0F, 3.0F, 5.0F, 0.0F, false);

		lw1_r1 = new ModelRenderer(this);
		lw1_r1.setPos(1.653F, -2.5097F, -28.231F);
		chain2.addChild(lw1_r1);
		setRotationAngle(lw1_r1, 3.0514F, -0.8792F, 1.587F);
		lw1_r1.texOffs(0, 35).addBox(-3.1728F, -0.5933F, -3.773F, 7.0F, 3.0F, 7.0F, 0.0F, false);

		upperpart = new ModelRenderer(this);
		upperpart.setPos(-0.0084F, -0.1928F, -6.2983F);
		Body.addChild(upperpart);


		Body_r74 = new ModelRenderer(this);
		Body_r74.setPos(7.7691F, 26.3557F, -11.519F);
		upperpart.addChild(Body_r74);
		setRotationAngle(Body_r74, 0.1764F, 0.0418F, -0.0283F);
		Body_r74.texOffs(0, 19).addBox(-3.748F, -3.9629F, 1.4238F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		Body_r75 = new ModelRenderer(this);
		Body_r75.setPos(0.0F, 0.0F, 0.0F);
		upperpart.addChild(Body_r75);
		setRotationAngle(Body_r75, 1.3545F, 0.0418F, -0.0283F);
		Body_r75.texOffs(5, 37).addBox(-11.0F, 5.5F, -12.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		Body_r75.texOffs(5, 37).addBox(7.0F, 5.5F, -12.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		Body_r75.texOffs(47, 58).addBox(-4.0F, 3.5F, -12.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		Body_r75.texOffs(47, 58).addBox(1.0F, 3.5F, -12.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		Body_r75.texOffs(43, 55).addBox(-3.0F, 3.5F, -10.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Body_r75.texOffs(0, 41).addBox(-11.0F, 2.5F, -16.0F, 20.0F, 3.0F, 4.0F, 0.0F, false);

		rightpart = new ModelRenderer(this);
		rightpart.setPos(11.1115F, 25.8159F, -12.5423F);
		upperpart.addChild(rightpart);


		Body_r76 = new ModelRenderer(this);
		Body_r76.setPos(0.0F, 0.0F, 0.0F);
		rightpart.addChild(Body_r76);
		setRotationAngle(Body_r76, -0.0417F, 0.0418F, -0.0283F);
		Body_r76.texOffs(0, 23).addBox(-3.148F, -2.6758F, -0.5762F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Body_r77 = new ModelRenderer(this);
		Body_r77.setPos(-0.3424F, 0.5398F, 1.0232F);
		rightpart.addChild(Body_r77);
		setRotationAngle(Body_r77, 0.4819F, 0.0418F, -0.0283F);
		Body_r77.texOffs(0, 23).addBox(-3.748F, -3.1629F, 1.4238F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r78 = new ModelRenderer(this);
		Body_r78.setPos(-0.9454F, -1.6702F, 6.0067F);
		rightpart.addChild(Body_r78);
		setRotationAngle(Body_r78, 1.4418F, 0.0418F, -0.0283F);
		Body_r78.texOffs(0, 23).addBox(-2.748F, -3.6758F, 1.4238F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r79 = new ModelRenderer(this);
		Body_r79.setPos(-0.9454F, -1.6702F, 6.0067F);
		rightpart.addChild(Body_r79);
		setRotationAngle(Body_r79, 1.5728F, -0.3073F, -0.029F);
		Body_r79.texOffs(5, 32).addBox(-2.748F, 1.3242F, 1.4238F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r80 = new ModelRenderer(this);
		Body_r80.setPos(-0.9454F, -1.6702F, 6.0067F);
		rightpart.addChild(Body_r80);
		setRotationAngle(Body_r80, 1.5727F, 0.0418F, -0.0283F);
		Body_r80.texOffs(0, 23).addBox(-2.748F, -2.6758F, 1.4238F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Body_r81 = new ModelRenderer(this);
		Body_r81.setPos(-3.3805F, 0.5161F, 0.1296F);
		rightpart.addChild(Body_r81);
		setRotationAngle(Body_r81, -0.0417F, 0.0418F, -0.0283F);
		Body_r81.texOffs(0, 22).addBox(-3.148F, -3.6758F, -2.5762F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r82 = new ModelRenderer(this);
		Body_r82.setPos(-3.3424F, 0.5398F, 1.0232F);
		rightpart.addChild(Body_r82);
		setRotationAngle(Body_r82, 0.4819F, 0.0418F, -0.0283F);
		Body_r82.texOffs(0, 21).addBox(-3.748F, -3.6758F, 0.4238F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		Body_r83 = new ModelRenderer(this);
		Body_r83.setPos(-3.9454F, -1.6702F, 6.0067F);
		rightpart.addChild(Body_r83);
		setRotationAngle(Body_r83, 1.18F, 0.0418F, -0.0283F);
		Body_r83.texOffs(0, 22).addBox(-2.748F, -4.6758F, 1.4238F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Body_r84 = new ModelRenderer(this);
		Body_r84.setPos(-4.1115F, -9.8159F, 7.5423F);
		rightpart.addChild(Body_r84);
		setRotationAngle(Body_r84, 1.8345F, 0.0418F, -0.0283F);
		Body_r84.texOffs(36, 29).addBox(-2.748F, -3.6758F, 1.4238F, 2.0F, 3.0F, 4.0F, 0.0F, false);

		Body_r85 = new ModelRenderer(this);
		Body_r85.setPos(-4.1115F, -9.8159F, 7.5423F);
		rightpart.addChild(Body_r85);
		setRotationAngle(Body_r85, 1.5727F, 0.0418F, -0.0283F);
		Body_r85.texOffs(36, 29).addBox(-2.748F, -4.6758F, -4.5762F, 2.0F, 4.0F, 7.0F, 0.0F, false);

		Body_r86 = new ModelRenderer(this);
		Body_r86.setPos(-4.1115F, -9.8159F, 7.5423F);
		rightpart.addChild(Body_r86);
		setRotationAngle(Body_r86, 2.009F, 0.0418F, -0.0283F);
		Body_r86.texOffs(0, 41).addBox(-2.748F, -1.6758F, -3.5762F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		Body_r87 = new ModelRenderer(this);
		Body_r87.setPos(-11.1115F, -25.8159F, 12.5423F);
		rightpart.addChild(Body_r87);
		setRotationAngle(Body_r87, 1.6163F, 0.0418F, -0.0283F);
		Body_r87.texOffs(0, 41).addBox(3.0F, -5.5F, -23.0F, 3.0F, 10.0F, 5.0F, 0.0F, false);

		leftpart = new ModelRenderer(this);
		leftpart.setPos(-15.0946F, 25.8159F, -12.5423F);
		upperpart.addChild(leftpart);


		Body_r88 = new ModelRenderer(this);
		Body_r88.setPos(0.0F, 0.0F, 0.0F);
		leftpart.addChild(Body_r88);
		setRotationAngle(Body_r88, -0.0417F, -0.0418F, 0.0283F);
		Body_r88.texOffs(0, 23).addBox(2.148F, -2.6758F, -0.5762F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		Body_r89 = new ModelRenderer(this);
		Body_r89.setPos(0.3424F, 0.5398F, 1.0232F);
		leftpart.addChild(Body_r89);
		setRotationAngle(Body_r89, 0.4819F, -0.0418F, 0.0283F);
		Body_r89.texOffs(0, 23).addBox(1.748F, -3.1629F, 1.4238F, 2.0F, 2.0F, 3.0F, 0.0F, true);

		Body_r90 = new ModelRenderer(this);
		Body_r90.setPos(0.9454F, -1.6702F, 6.0067F);
		leftpart.addChild(Body_r90);
		setRotationAngle(Body_r90, 1.4418F, -0.0418F, 0.0283F);
		Body_r90.texOffs(0, 23).addBox(1.748F, -3.6758F, 1.4238F, 1.0F, 2.0F, 3.0F, 0.0F, true);

		Body_r91 = new ModelRenderer(this);
		Body_r91.setPos(0.9454F, -1.6702F, 6.0067F);
		leftpart.addChild(Body_r91);
		setRotationAngle(Body_r91, 1.5728F, 0.3509F, 0.029F);
		Body_r91.texOffs(6, 32).addBox(0.748F, 1.3242F, 1.4238F, 2.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r92 = new ModelRenderer(this);
		Body_r92.setPos(0.9454F, -1.6702F, 6.0067F);
		leftpart.addChild(Body_r92);
		setRotationAngle(Body_r92, 1.5727F, -0.0418F, 0.0283F);
		Body_r92.texOffs(0, 23).addBox(0.748F, -2.6758F, 1.4238F, 2.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r93 = new ModelRenderer(this);
		Body_r93.setPos(3.3805F, 0.5161F, 0.1296F);
		leftpart.addChild(Body_r93);
		setRotationAngle(Body_r93, -0.0417F, -0.0418F, 0.0283F);
		Body_r93.texOffs(1, 22).addBox(2.148F, -3.6758F, -2.5762F, 1.0F, 2.0F, 3.0F, 0.0F, true);

		Body_r94 = new ModelRenderer(this);
		Body_r94.setPos(3.3424F, 0.5398F, 1.0232F);
		leftpart.addChild(Body_r94);
		setRotationAngle(Body_r94, 0.4819F, -0.0418F, 0.0283F);
		Body_r94.texOffs(0, 22).addBox(1.748F, -3.6758F, 0.4238F, 2.0F, 2.0F, 5.0F, 0.0F, true);

		Body_r95 = new ModelRenderer(this);
		Body_r95.setPos(3.9454F, -1.6702F, 6.0067F);
		leftpart.addChild(Body_r95);
		setRotationAngle(Body_r95, 1.18F, -0.0418F, 0.0283F);
		Body_r95.texOffs(0, 22).addBox(0.748F, -4.6758F, 1.4238F, 2.0F, 5.0F, 3.0F, 0.0F, true);

		Body_r96 = new ModelRenderer(this);
		Body_r96.setPos(4.1115F, -9.8159F, 7.5423F);
		leftpart.addChild(Body_r96);
		setRotationAngle(Body_r96, 1.8781F, -0.0418F, 0.0283F);
		Body_r96.texOffs(38, 29).addBox(0.748F, -3.6758F, 1.4238F, 2.0F, 3.0F, 4.0F, 0.0F, true);

		Body_r97 = new ModelRenderer(this);
		Body_r97.setPos(4.1115F, -9.8159F, 7.5423F);
		leftpart.addChild(Body_r97);
		setRotationAngle(Body_r97, 1.5727F, -0.0418F, 0.0283F);
		Body_r97.texOffs(38, 29).addBox(0.748F, -4.6758F, -4.5762F, 2.0F, 4.0F, 7.0F, 0.0F, true);

		Body_r98 = new ModelRenderer(this);
		Body_r98.setPos(4.1115F, -9.8159F, 7.5423F);
		leftpart.addChild(Body_r98);
		setRotationAngle(Body_r98, 2.009F, -0.0418F, 0.0283F);
		Body_r98.texOffs(0, 41).addBox(1.748F, -1.6758F, -3.5762F, 1.0F, 3.0F, 5.0F, 0.0F, true);

		Body_r99 = new ModelRenderer(this);
		Body_r99.setPos(11.1115F, -25.8159F, 12.5423F);
		leftpart.addChild(Body_r99);
		setRotationAngle(Body_r99, 1.6163F, -0.0418F, 0.0283F);
		Body_r99.texOffs(0, 41).addBox(-6.0F, -5.5F, -23.0F, 3.0F, 10.0F, 5.0F, 0.0F, true);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-4.9F, 20.0F, -8.0F);
		setRotationAngle(RightLeg, 3.098F, 0.0F, 0.0F);
		RightLeg.texOffs(0, 38).addBox(3.1529F, -3.7944F, -4.3754F, 3.0F, 8.0F, 9.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(3.1683F, 3.6408F, 13.4137F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.0436F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(0, 39).addBox(-3.0418F, -6.6658F, -17.0021F, 3.0F, 8.0F, 8.0F, 0.0F, false);

		vicer = new ModelRenderer(this);
		vicer.setPos(2.9F, 9.8855F, 0.2078F);


		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(20.45F, 21.457F, -5.4392F);
		setRotationAngle(LeftLeg, 0.3054F, 0.0F, -0.0349F);


		otherp = new ModelRenderer(this);
		otherp.setPos(-17.9F, 12.0F, 10.0F);
		
	}

//	@Override
//	public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
//
//	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
//		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.8F * limbSwingAmount;
		this.lw1_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.lw2_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.lw3_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.lw4_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.lw5_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.lw6_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;

		this.rw1_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.rw2_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.rw3_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.rw4_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.rw5_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.rw6_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;

	}
//	@Override
//	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//		//previously the render function, render code was moved to a method below
//	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		vicer.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		otherp.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

//	@Override
//	public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
//
//	}
}