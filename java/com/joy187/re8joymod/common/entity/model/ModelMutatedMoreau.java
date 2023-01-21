// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMoreau;
import com.joy187.re8joymod.common.entity.EntityMoreau3;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMutatedMoreau<T extends EntityMoreau3> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
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
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer chin3_r1;
	private final ModelRenderer chin2_r1;
	private final ModelRenderer chin1_r1;
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
	private final ModelRenderer Body_r43;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightLeg_r3;
	private final ModelRenderer RightLeg_r4;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer eye_r1;
	private final ModelRenderer eye_r2;
	private final ModelRenderer eye_r3;
	private final ModelRenderer eye_r4;
	private final ModelRenderer eye_r5;
	private final ModelRenderer eye_r6;
	private final ModelRenderer eye_r7;
	private final ModelRenderer eye_r8;
	private final ModelRenderer eye_r9;
	private final ModelRenderer eye_r10;
	private final ModelRenderer eye_r11;
	private final ModelRenderer eye_r12;
	private final ModelRenderer eye_r13;
	private final ModelRenderer eye_r14;
	private final ModelRenderer eye_r15;
	private final ModelRenderer eye_r16;
	private final ModelRenderer eye_r17;
	private final ModelRenderer eye_r18;
	private final ModelRenderer eye_r19;
	private final ModelRenderer eye_r20;
	private final ModelRenderer eye_r21;
	private final ModelRenderer eye_r22;
	private final ModelRenderer eye_r23;
	private final ModelRenderer eye_r24;
	private final ModelRenderer eye_r25;
	private final ModelRenderer eye_r26;
	private final ModelRenderer eye_r27;
	private final ModelRenderer hairr;
	private final ModelRenderer hair_r1;
	private final ModelRenderer hair_r2;
	private final ModelRenderer hair_r3;
	private final ModelRenderer hair_r4;
	private final ModelRenderer hair_r5;
	private final ModelRenderer hairr2;
	private final ModelRenderer hair_r6;
	private final ModelRenderer hair_r7;
	private final ModelRenderer hairr3;
	private final ModelRenderer hair_r8;
	private final ModelRenderer hair_r9;
	private final ModelRenderer hair_r10;
	private final ModelRenderer hair_r11;
	private final ModelRenderer RightArm;
	private final ModelRenderer bottle2_r1;
	private final ModelRenderer bottle3_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer leftfront;
	private final ModelRenderer bottle3_r2;
	private final ModelRenderer bottle2_r2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r5;
	private final ModelRenderer RightLeg_r6;
	private final ModelRenderer RightLeg_r7;
	private final ModelRenderer RightLeg_r8;
	private final ModelRenderer RightLeg_r9;
	private final ModelRenderer RightLeg_r10;
	private final ModelRenderer RightLeg_r11;
	private final ModelRenderer viceleft;
	private final ModelRenderer vicer;
	private final ModelRenderer RightLeg_r12;
	private final ModelRenderer RightLeg_r13;
	private final ModelRenderer RightLeg_r14;
	private final ModelRenderer RightLeg_r15;
	private final ModelRenderer LeftLeg_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg_r16;
	private final ModelRenderer RightLeg_r17;
	private final ModelRenderer RightLeg_r18;
	private final ModelRenderer RightLeg_r19;
	private final ModelRenderer RightLeg_r20;
	private final ModelRenderer RightLeg_r21;
	private final ModelRenderer RightLeg_r22;
	private final ModelRenderer otherp;
	private final ModelRenderer RightLeg_r23;
	private final ModelRenderer RightLeg_r24;
	private final ModelRenderer RightLeg_r25;
	private final ModelRenderer RightLeg_r26;
	private final ModelRenderer RightLeg_r27;
	private final ModelRenderer RightLeg_r28;
	private final ModelRenderer RightLeg_r29;
	private final ModelRenderer RightLeg_r30;

	public ModelMutatedMoreau() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 20.0F, -10.0F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-2.5F, -0.7511F, -10.0347F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.1309F, 0.0F, 0.1309F);
		Head_r1.texOffs(24, 0).addBox(-4.9558F, -20.8069F, 2.0515F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(0.0F, -4.0F, 0.0F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.2182F, 0.0F, 0.0F);
		Head_r2.texOffs(0, 0).addBox(-4.0F, -20.8586F, -7.5095F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(18, 30).addBox(-14.9F, 14.4108F, 25.9051F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-6.0F, -14.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-2.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-10.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(6, 36).addBox(-10.0F, -10.0F, 3.0F, 20.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-6.0F, 2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(8, 30).addBox(-16.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);
		Body.texOffs(8, 30).addBox(10.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, true);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(3.0F, 5.0F, 1.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.3054F, -0.4363F, 0.0F);
		Body_r1.texOffs(18, 12).addBox(7.0F, -15.0F, -21.0F, 3.0F, 10.0F, 17.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(6.5961F, 17.5828F, -12.3684F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.5236F, 0.4363F, -0.0873F);
		Body_r2.texOffs(18, 23).addBox(-1.0F, -3.5F, -2.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(6.5961F, 17.5828F, -12.3684F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.5236F, -0.0436F, -0.0873F);
		Body_r3.texOffs(18, 23).addBox(-4.0F, -3.5F, -2.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(-8.0254F, 20.1116F, -5.0856F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.3491F, 0.1745F, 0.2618F);
		Body_r4.texOffs(18, 23).addBox(-4.0F, -4.5F, -6.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(-13.0808F, 13.065F, -5.9068F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.6545F, -0.0873F, 1.0036F);
		Body_r5.texOffs(18, 23).addBox(-3.0F, -3.5F, -6.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(-15.8423F, -2.0741F, -35.0479F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.5672F, 0.1745F, 1.6144F);
		Body_r6.texOffs(18, 23).addBox(-4.0F, -44.5F, -2.5F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-15.1664F, -6.807F, -12.3772F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.3927F, 1.0472F, 1.2654F);
		Body_r7.texOffs(16, 22).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 3.0F, 16.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(-18.3316F, -0.3252F, -13.0755F);
		Body.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.6545F, 0.1745F, 1.2654F);
		Body_r8.texOffs(18, 23).addBox(-8.0F, 2.5F, 1.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-0.5F, 7.2141F, 5.8971F);
		Body.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.5236F, 0.0F, 0.0F);
		Body_r9.texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(0.0F, -4.0F, 5.5F);
		Body.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.3491F, 0.0F, 0.0F);
		Body_r10.texOffs(42, 54).addBox(-3.0F, -5.0F, -17.5F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		Body_r10.texOffs(12, 41).addBox(-6.0F, -7.0F, -12.5F, 12.0F, 9.0F, 14.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(12.0F, -6.0F, 10.5F);
		Body.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.1745F, -0.48F);
		Body_r11.texOffs(12, 29).addBox(-1.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, 0.0F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(-12.0F, -6.0F, 10.5F);
		Body.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, -0.1745F, 0.48F);
		Body_r12.texOffs(12, 29).addBox(-2.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, 0.6545F);
		Body_r13.texOffs(0, 29).addBox(0.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, true);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(-8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, -0.6545F);
		Body_r14.texOffs(0, 29).addBox(-5.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, 0.0F, 1.3963F);
		Body_r15.texOffs(0, 27).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 15.0F, 22.0F, 0.0F, true);
		Body_r15.texOffs(12, 32).addBox(-3.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(2.2121F, 21.993F, 55.785F);
		Body.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0F, -0.0436F, -1.6144F);
		Body_r16.texOffs(0, 29).addBox(8.0F, -5.0F, -2.0F, 7.0F, 10.0F, 18.0F, 0.0F, false);
		Body_r16.texOffs(0, 29).addBox(4.0F, -3.0F, 23.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);
		Body_r16.texOffs(0, 29).addBox(4.0F, -5.0F, 7.0F, 4.0F, 10.0F, 16.0F, 0.0F, false);

		chin3_r1 = new ModelRenderer(this);
		chin3_r1.setPos(2.0172F, 7.5832F, 103.8805F);
		Body.addChild(chin3_r1);
		setRotationAngle(chin3_r1, -0.0873F, 0.6981F, -2.2689F);
		chin3_r1.texOffs(0, 29).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 7.0F, 16.0F, 0.0F, false);

		chin2_r1 = new ModelRenderer(this);
		chin2_r1.setPos(2.0172F, 7.5832F, 103.8805F);
		Body.addChild(chin2_r1);
		setRotationAngle(chin2_r1, 0.48F, 0.6981F, -2.2689F);
		chin2_r1.texOffs(0, 29).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 7.0F, 16.0F, 0.0F, false);

		chin1_r1 = new ModelRenderer(this);
		chin1_r1.setPos(-2.8773F, 12.7897F, 99.7652F);
		Body.addChild(chin1_r1);
		setRotationAngle(chin1_r1, -0.48F, 0.6981F, -2.2689F);
		chin1_r1.texOffs(16, 17).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 7.0F, 16.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(-2.8773F, 12.7897F, 99.7652F);
		Body.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.6981F, -2.2689F);
		Body_r17.texOffs(0, 29).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(2.2121F, 21.993F, 55.785F);
		Body.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.2182F, -1.6144F);
		Body_r18.texOffs(0, 29).addBox(1.0F, -5.0F, -6.0F, 6.0F, 10.0F, 16.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(1.989F, 16.8828F, 44.0F);
		Body.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, -0.2618F, -1.6144F);
		Body_r19.texOffs(0, 29).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 17.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(-7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, -1.3963F);
		Body_r20.texOffs(0, 29).addBox(-1.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
		Body_r20.texOffs(0, 29).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(1.2275F, 4.0987F, 62.3715F);
		Body.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0436F, -0.3054F, -1.6144F);
		Body_r21.texOffs(7, 22).addBox(-7.0F, -4.5F, 9.0F, 6.0F, 11.0F, 17.0F, 0.0F, true);
		Body_r21.texOffs(7, 22).addBox(-5.0F, -4.5F, -7.0F, 8.0F, 11.0F, 17.0F, 0.0F, true);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(-0.5989F, -12.2009F, 25.6123F);
		Body.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0436F, -0.3054F, -1.789F);
		Body_r22.texOffs(7, 22).addBox(-5.5F, -5.5F, 11.0F, 6.0F, 11.0F, 20.0F, 0.0F, true);
		Body_r22.texOffs(0, 30).addBox(-3.5F, -6.5F, -10.0F, 5.0F, 13.0F, 21.0F, 0.0F, true);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(8.089F, -9.2031F, 25.7953F);
		Body.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.2182F, -0.3491F, -0.9599F);
		Body_r23.texOffs(12, 35).addBox(-3.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(-8.089F, -9.2031F, 25.7953F);
		Body.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.2182F, 0.3491F, 0.9599F);
		Body_r24.texOffs(12, 35).addBox(0.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r25);
		setRotationAngle(Body_r25, -0.2618F, -0.2618F, 0.0F);
		Body_r25.texOffs(12, 35).addBox(-7.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r26);
		setRotationAngle(Body_r26, -0.2618F, 0.2618F, 0.0F);
		Body_r26.texOffs(12, 35).addBox(1.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, -0.2618F, 0.0F);
		Body_r27.texOffs(12, 35).addBox(-5.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.0436F, -0.2618F, 0.0F);
		Body_r28.texOffs(10, 32).addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r29);
		setRotationAngle(Body_r29, -0.0436F, 0.2618F, 0.0F);
		Body_r29.texOffs(10, 32).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, false);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r30);
		setRotationAngle(Body_r30, -0.3491F, -0.2618F, 0.0F);
		Body_r30.texOffs(12, 35).addBox(-6.0F, -6.5F, 7.0F, 7.0F, 9.0F, 21.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r31);
		setRotationAngle(Body_r31, -0.3491F, 0.2618F, 0.0F);
		Body_r31.texOffs(12, 35).addBox(-1.0F, -6.5F, 7.0F, 7.0F, 9.0F, 21.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.2618F, 0.0F);
		Body_r32.texOffs(12, 35).addBox(-1.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(4.6711F, -13.1278F, 6.5F);
		Body.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.2182F, 0.0F, 0.3927F);
		Body_r33.texOffs(0, 0).addBox(-6.5F, -1.5F, -11.5F, 13.0F, 4.0F, 23.0F, 0.0F, false);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(0.5F, -14.5F, 6.5F);
		Body.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.2182F, 0.0F, -0.3927F);
		Body_r34.texOffs(0, 0).addBox(-12.5F, -2.5F, -11.5F, 13.0F, 4.0F, 23.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(15.5F, -2.5179F, -10.2272F);
		Body.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.1745F, -0.3927F, 0.0F);
		Body_r35.texOffs(0, 57).addBox(-1.5F, 8.0F, 4.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r35.texOffs(0, 57).addBox(-1.5F, 8.0F, -0.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r35.texOffs(0, 58).addBox(-1.5F, 6.0F, -7.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(4.5383F, 13.9488F, -13.6264F);
		Body.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.1745F, 0.0436F, 0.0F);
		Body_r36.texOffs(0, 58).addBox(-2.0F, -3.0F, 5.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(13.0526F, 10.9943F, -10.6635F);
		Body.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.1745F, 0.48F, 0.0F);
		Body_r37.texOffs(0, 58).addBox(-1.0F, 0.0F, -7.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r37.texOffs(0, 58).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(6.9331F, 13.7751F, -11.5685F);
		Body.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.1745F, 0.0873F, 0.0F);
		Body_r38.texOffs(0, 58).addBox(-13.0F, 2.0F, 5.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r38.texOffs(0, 58).addBox(-13.0F, 3.0F, 1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r38.texOffs(0, 58).addBox(-16.0F, 3.0F, -3.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r38.texOffs(0, 58).addBox(-21.0F, -1.0F, -3.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r38.texOffs(0, 58).addBox(0.0F, -1.0F, -4.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(-12.04F, 10.8207F, -10.4315F);
		Body.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.1745F, 0.0873F, 0.5672F);
		Body_r39.texOffs(0, 59).addBox(-1.0F, -3.0F, 4.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-17.0F, -11.0F, 3.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-13.0F, -12.0F, 8.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-5.0F, -6.0F, 1.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-9.0F, -8.0F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-13.0F, -10.0F, -3.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		Body_r39.texOffs(0, 59).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(-20.9281F, -4.9728F, -9.5263F);
		Body.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.1745F, -0.3491F, 0.5672F);
		Body_r40.texOffs(0, 59).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(16.5F, -1.5179F, -7.2272F);
		Body.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.1745F, -0.3927F, 0.0F);
		Body_r41.texOffs(0, 58).addBox(-14.5F, 14.0F, -4.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(15.5F, -2.5179F, -10.2272F);
		Body.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.5236F, -0.3927F, 0.0F);
		Body_r42.texOffs(0, 58).addBox(-1.5F, -2.0F, -7.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r42.texOffs(0, 58).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-2.5F, -9.0F, -3.0F);
		Body.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.5236F, 0.0F, 0.0F);
		Body_r43.texOffs(0, 58).addBox(14.5F, 1.0F, -6.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-15.9F, 15.1551F, 25.396F);
		Body.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.2182F, 0.4363F, 0.0F);
		RightLeg_r1.texOffs(17, 30).addBox(-3.0F, 0.5F, -0.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-15.9F, 14.9108F, 22.9051F);
		Body.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.0F, 0.1745F, 0.0F);
		RightLeg_r2.texOffs(19, 31).addBox(-2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-12.9F, 12.2285F, 38.6185F);
		Body.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, -1.3963F, 0.0F, 0.0F);
		RightLeg_r3.texOffs(18, 30).addBox(-4.0F, 2.5F, -1.0F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-15.9F, 14.9108F, 22.9051F);
		Body.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, 0.0F, -0.3491F, 0.0F);
		RightLeg_r4.texOffs(17, 29).addBox(4.0F, -0.5F, 0.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-14.9F, 10.5794F, 32.4782F);
		Body.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.48F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(0, 47).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, true);

		eye_r1 = new ModelRenderer(this);
		eye_r1.setPos(6.75F, -17.0753F, 5.9689F);
		Body.addChild(eye_r1);
		setRotationAngle(eye_r1, -0.0873F, 0.0F, 0.5236F);
		eye_r1.texOffs(42, 0).addBox(-7.5F, -2.0F, 6.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		eye_r1.texOffs(42, 0).addBox(-4.5F, -2.0F, 12.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		eye_r2 = new ModelRenderer(this);
		eye_r2.setPos(-6.75F, -17.0753F, 5.9689F);
		Body.addChild(eye_r2);
		setRotationAngle(eye_r2, -0.0873F, 0.0F, -0.5236F);
		eye_r2.texOffs(42, 0).addBox(2.5F, 0.0F, 12.5F, 5.0F, 4.0F, 5.0F, 0.0F, true);
		eye_r2.texOffs(42, 0).addBox(2.5F, -2.0F, 6.5F, 5.0F, 4.0F, 5.0F, 0.0F, true);

		eye_r3 = new ModelRenderer(this);
		eye_r3.setPos(-6.75F, -17.0753F, 5.9689F);
		Body.addChild(eye_r3);
		setRotationAngle(eye_r3, -0.0873F, 0.0F, -1.0472F);
		eye_r3.texOffs(42, 0).addBox(-2.5F, 0.0F, 4.5F, 5.0F, 4.0F, 5.0F, 0.0F, true);

		eye_r4 = new ModelRenderer(this);
		eye_r4.setPos(6.75F, -17.0753F, 5.9689F);
		Body.addChild(eye_r4);
		setRotationAngle(eye_r4, -0.0873F, 0.0F, 1.0472F);
		eye_r4.texOffs(42, 0).addBox(-2.5F, 0.0F, 4.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		eye_r5 = new ModelRenderer(this);
		eye_r5.setPos(-10.3531F, -12.8047F, 4.7609F);
		Body.addChild(eye_r5);
		setRotationAngle(eye_r5, 0.2618F, 0.0F, -1.0472F);
		eye_r5.texOffs(44, 0).addBox(3.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		eye_r5.texOffs(44, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r6 = new ModelRenderer(this);
		eye_r6.setPos(10.3531F, -12.8047F, 4.7609F);
		Body.addChild(eye_r6);
		setRotationAngle(eye_r6, 0.2618F, 0.0F, 1.0472F);
		eye_r6.texOffs(44, 0).addBox(-7.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r6.texOffs(44, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r7 = new ModelRenderer(this);
		eye_r7.setPos(10.5939F, -9.9381F, 23.5951F);
		Body.addChild(eye_r7);
		setRotationAngle(eye_r7, -0.0873F, 1.5272F, 1.0908F);
		eye_r7.texOffs(44, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r8 = new ModelRenderer(this);
		eye_r8.setPos(-10.5939F, -9.9381F, 23.5951F);
		Body.addChild(eye_r8);
		setRotationAngle(eye_r8, -0.0873F, -1.5272F, -1.0908F);
		eye_r8.texOffs(44, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r9 = new ModelRenderer(this);
		eye_r9.setPos(10.3531F, -12.8047F, 4.7609F);
		Body.addChild(eye_r9);
		setRotationAngle(eye_r9, 0.2618F, 1.7453F, 1.0472F);
		eye_r9.texOffs(44, 0).addBox(-16.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r9.texOffs(44, 0).addBox(-22.0F, 4.0F, -13.3F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r9.texOffs(44, 0).addBox(-17.0F, -1.0F, -7.3F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r9.texOffs(44, 0).addBox(-13.0F, -2.0F, -7.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r9.texOffs(44, 0).addBox(-7.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r10 = new ModelRenderer(this);
		eye_r10.setPos(-10.3531F, -12.8047F, 4.7609F);
		Body.addChild(eye_r10);
		setRotationAngle(eye_r10, 0.2618F, -1.7453F, -1.0472F);
		eye_r10.texOffs(44, 0).addBox(12.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		eye_r10.texOffs(44, 0).addBox(13.0F, -1.0F, -7.3F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		eye_r10.texOffs(44, 0).addBox(3.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r11 = new ModelRenderer(this);
		eye_r11.setPos(6.9719F, -13.4681F, 25.4689F);
		Body.addChild(eye_r11);
		setRotationAngle(eye_r11, 0.2618F, 1.0036F, 1.0472F);
		eye_r11.texOffs(44, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r12 = new ModelRenderer(this);
		eye_r12.setPos(-6.9719F, -13.4681F, 25.4689F);
		Body.addChild(eye_r12);
		setRotationAngle(eye_r12, 0.2618F, -1.0036F, -1.0472F);
		eye_r12.texOffs(44, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r13 = new ModelRenderer(this);
		eye_r13.setPos(3.045F, -16.4999F, 24.7841F);
		Body.addChild(eye_r13);
		setRotationAngle(eye_r13, 1.4835F, -2.3998F, -1.0472F);
		eye_r13.texOffs(44, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r14 = new ModelRenderer(this);
		eye_r14.setPos(-3.9869F, -10.8612F, -3.5574F);
		Body.addChild(eye_r14);
		setRotationAngle(eye_r14, 0.6981F, 0.0F, -1.0472F);
		eye_r14.texOffs(44, 0).addBox(-3.5F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		eye_r14.texOffs(44, 0).addBox(-0.5F, -2.0F, -2.5F, 4.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r15 = new ModelRenderer(this);
		eye_r15.setPos(3.9869F, -10.8612F, -3.5574F);
		Body.addChild(eye_r15);
		setRotationAngle(eye_r15, 0.6981F, 0.0F, 1.0472F);
		eye_r15.texOffs(44, 0).addBox(-0.5F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r15.texOffs(44, 0).addBox(-3.5F, -2.0F, -2.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r16 = new ModelRenderer(this);
		eye_r16.setPos(-3.9869F, -10.8612F, -3.5574F);
		Body.addChild(eye_r16);
		setRotationAngle(eye_r16, 0.7418F, 0.0F, -0.7418F);
		eye_r16.texOffs(45, 1).addBox(3.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		eye_r17 = new ModelRenderer(this);
		eye_r17.setPos(15.8537F, -8.1863F, 25.3424F);
		Body.addChild(eye_r17);
		setRotationAngle(eye_r17, 0.5236F, -2.6616F, 0.7418F);
		eye_r17.texOffs(47, 1).addBox(2.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		eye_r17.texOffs(47, 1).addBox(-1.0F, 2.5F, 4.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		eye_r17.texOffs(47, 1).addBox(-1.0F, 2.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		eye_r18 = new ModelRenderer(this);
		eye_r18.setPos(-15.8537F, -8.1863F, 25.3424F);
		Body.addChild(eye_r18);
		setRotationAngle(eye_r18, 0.5236F, 2.6616F, -0.7418F);
		eye_r18.texOffs(47, 1).addBox(-4.0F, 1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		eye_r18.texOffs(47, 1).addBox(-1.0F, 2.5F, 4.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		eye_r18.texOffs(47, 1).addBox(-1.0F, 2.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		eye_r19 = new ModelRenderer(this);
		eye_r19.setPos(13.9745F, -12.4879F, 17.0983F);
		Body.addChild(eye_r19);
		setRotationAngle(eye_r19, -0.4363F, -2.5307F, 1.4835F);
		eye_r19.texOffs(47, 1).addBox(-4.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		eye_r20 = new ModelRenderer(this);
		eye_r20.setPos(-13.9745F, -12.4879F, 17.0983F);
		Body.addChild(eye_r20);
		setRotationAngle(eye_r20, -0.4363F, 2.5307F, -1.4835F);
		eye_r20.texOffs(47, 1).addBox(2.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		eye_r21 = new ModelRenderer(this);
		eye_r21.setPos(12.123F, -8.1355F, 27.7045F);
		Body.addChild(eye_r21);
		setRotationAngle(eye_r21, 0.9163F, -2.6616F, 0.7418F);
		eye_r21.texOffs(45, 1).addBox(1.5F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, true);

		eye_r22 = new ModelRenderer(this);
		eye_r22.setPos(-12.123F, -8.1355F, 27.7045F);
		Body.addChild(eye_r22);
		setRotationAngle(eye_r22, 0.9163F, 2.6616F, -0.7418F);
		eye_r22.texOffs(45, 1).addBox(-4.5F, 0.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye_r23 = new ModelRenderer(this);
		eye_r23.setPos(-9.0726F, -14.8863F, 14.6231F);
		Body.addChild(eye_r23);
		setRotationAngle(eye_r23, 0.2618F, 2.6616F, -0.7418F);
		eye_r23.texOffs(45, 1).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye_r24 = new ModelRenderer(this);
		eye_r24.setPos(3.9869F, -10.8612F, -3.5574F);
		Body.addChild(eye_r24);
		setRotationAngle(eye_r24, 0.7418F, 0.0F, 0.7418F);
		eye_r24.texOffs(45, 1).addBox(-6.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye_r25 = new ModelRenderer(this);
		eye_r25.setPos(2.0335F, -24.7445F, 5.5359F);
		Body.addChild(eye_r25);
		setRotationAngle(eye_r25, 0.5236F, 0.0F, 0.0436F);
		eye_r25.texOffs(41, 0).addBox(-5.5F, 6.0F, -8.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		eye_r25.texOffs(41, 0).addBox(-2.5F, 6.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		eye_r26 = new ModelRenderer(this);
		eye_r26.setPos(-29.5F, -3.6519F, -1.5311F);
		Body.addChild(eye_r26);
		setRotationAngle(eye_r26, 0.5236F, 0.0F, -1.0472F);
		eye_r26.texOffs(42, 0).addBox(20.5F, 13.0F, -8.5F, 5.0F, 4.0F, 5.0F, 0.0F, true);

		eye_r27 = new ModelRenderer(this);
		eye_r27.setPos(29.5F, -3.6519F, -1.5311F);
		Body.addChild(eye_r27);
		setRotationAngle(eye_r27, 0.5236F, 0.0F, 1.0472F);
		eye_r27.texOffs(42, 0).addBox(-25.5F, 13.0F, -8.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		hairr = new ModelRenderer(this);
		hairr.setPos(3.045F, -16.4999F, 24.7841F);
		Body.addChild(hairr);
		

		hair_r1 = new ModelRenderer(this);
		hair_r1.setPos(23.8611F, -17.681F, 20.5035F);
		hairr.addChild(hair_r1);
		setRotationAngle(hair_r1, -0.7471F, -0.5466F, 1.0396F);
		hair_r1.texOffs(21, 38).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r2 = new ModelRenderer(this);
		hair_r2.setPos(3.6347F, -17.2185F, 31.2371F);
		hairr.addChild(hair_r2);
		setRotationAngle(hair_r2, 1.4835F, -2.3998F, -1.5272F);
		hair_r2.texOffs(21, 38).addBox(-0.5F, -12.5F, -0.5F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		hair_r3 = new ModelRenderer(this);
		hair_r3.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r3);
		setRotationAngle(hair_r3, -1.1052F, -0.8438F, 1.2893F);
		hair_r3.texOffs(21, 38).addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r4 = new ModelRenderer(this);
		hair_r4.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r4);
		setRotationAngle(hair_r4, -0.5816F, -0.8438F, 1.2893F);
		hair_r4.texOffs(21, 38).addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		hair_r5 = new ModelRenderer(this);
		hair_r5.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r5);
		setRotationAngle(hair_r5, 1.4835F, -2.3998F, -1.0472F);
		hair_r5.texOffs(21, 38).addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		hairr2 = new ModelRenderer(this);
		hairr2.setPos(-1.955F, -16.4999F, 24.7841F);
		Body.addChild(hairr2);
		setRotationAngle(hairr2, 0.0F, -0.2618F, 0.0F);
		

		hair_r6 = new ModelRenderer(this);
		hair_r6.setPos(3.6347F, -17.2185F, 31.2371F);
		hairr2.addChild(hair_r6);
		setRotationAngle(hair_r6, 1.4835F, -2.3998F, -1.5272F);
		hair_r6.texOffs(1, 46).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r7 = new ModelRenderer(this);
		hair_r7.setPos(0.0F, 0.0F, 0.0F);
		hairr2.addChild(hair_r7);
		setRotationAngle(hair_r7, 1.4835F, -2.3998F, -1.0472F);
		hair_r7.texOffs(21, 38).addBox(7.0F, -23.0F, -2.0F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		hairr3 = new ModelRenderer(this);
		hairr3.setPos(-1.955F, -16.4999F, 24.7841F);
		Body.addChild(hairr3);
		setRotationAngle(hairr3, 0.0F, -0.6981F, 0.0F);
		

		hair_r8 = new ModelRenderer(this);
		hair_r8.setPos(6.9247F, -11.5807F, 24.3213F);
		hairr3.addChild(hair_r8);
		setRotationAngle(hair_r8, -1.9475F, -0.711F, 1.8074F);
		hair_r8.texOffs(4, 41).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r9 = new ModelRenderer(this);
		hair_r9.setPos(1.391F, -12.0431F, 24.6268F);
		hairr3.addChild(hair_r9);
		setRotationAngle(hair_r9, 1.4835F, -2.3998F, -1.5272F);
		hair_r9.texOffs(4, 41).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r10 = new ModelRenderer(this);
		hair_r10.setPos(11.0F, 0.0F, 0.0F);
		hairr3.addChild(hair_r10);
		setRotationAngle(hair_r10, -1.8902F, -0.6185F, 2.2411F);
		hair_r10.texOffs(21, 38).addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r11 = new ModelRenderer(this);
		hair_r11.setPos(0.0F, 0.0F, 0.0F);
		hairr3.addChild(hair_r11);
		setRotationAngle(hair_r11, 1.4835F, -2.3998F, -1.0472F);
		hair_r11.texOffs(21, 38).addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-13.6068F, 9.1652F, -14.8153F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.4363F);
		

		bottle2_r1 = new ModelRenderer(this);
		bottle2_r1.setPos(12.1068F, 19.6644F, 8.0039F);
		RightArm.addChild(bottle2_r1);
		setRotationAngle(bottle2_r1, -0.1745F, 0.0F, 0.5672F);
		bottle2_r1.texOffs(32, 41).addBox(-21.141F, -12.8317F, -4.4352F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle3_r1 = new ModelRenderer(this);
		bottle3_r1.setPos(1.1068F, 19.7797F, 9.5375F);
		RightArm.addChild(bottle3_r1);
		setRotationAngle(bottle3_r1, -0.48F, 0.0F, 0.0F);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -18.4538F, -14.3928F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -18.4538F, -15.3928F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle3_r1.texOffs(32, 42).addBox(-0.5F, -18.4538F, -16.3928F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(1.6068F, 13.7777F, 10.7471F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.4363F, 0.0F, 0.0F);
		RightArm_r1.texOffs(52, 43).addBox(-1.0F, -20.0213F, -13.6187F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(1.6068F, 15.4122F, 10.9089F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.2182F, 0.0F, 0.0F);
		RightArm_r2.texOffs(42, 6).addBox(0.0F, -29.9791F, 0.9596F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(9.0F, 14.5067F, -4.8661F);
		setRotationAngle(LeftArm, 0.2094F, 0.3927F, -0.48F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(5.0F, 12.4933F, -1.1339F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.1745F, 0.0F, 0.0F);
		LeftArm_r1.texOffs(32, 48).addBox(-2.0F, -27.9866F, -1.2322F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setPos(5.0F, 12.4933F, -1.1339F);
		LeftArm.addChild(leftfront);
		setRotationAngle(leftfront, -0.48F, 0.0F, 0.0F);
		

		bottle3_r2 = new ModelRenderer(this);
		bottle3_r2.setPos(-1.5F, 5.8296F, -2.8114F);
		leftfront.addChild(bottle3_r2);
		setRotationAngle(bottle3_r2, -0.1745F, 0.0F, 0.5672F);
		bottle3_r2.texOffs(32, 41).addBox(-11.8907F, -18.0872F, -9.3947F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bottle2_r2 = new ModelRenderer(this);
		bottle2_r2.setPos(0.0F, -0.9487F, -0.0622F);
		leftfront.addChild(bottle2_r2);
		setRotationAngle(bottle2_r2, -0.1745F, 0.0F, 0.0F);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, -13.8569F, -11.4712F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(0.0F, -13.8569F, -10.4712F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(0.0F, -13.8569F, -9.4712F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(32, 42).addBox(-1.0F, -13.8569F, -9.4712F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottle2_r2.texOffs(52, 33).addBox(-2.0F, -19.8569F, -11.4712F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-17.9F, 9.0F, 13.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		RightLeg.texOffs(20, 28).addBox(-4.8953F, -5.2761F, -0.8752F, 8.0F, 7.0F, 5.0F, 0.0F, false);
		RightLeg.texOffs(18, 30).addBox(-2.8953F, 6.1347F, -22.9701F, 2.0F, 1.0F, 8.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(-3.8953F, 6.879F, -16.4792F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r5.texOffs(18, 30).addBox(3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r6 = new ModelRenderer(this);
		RightLeg_r6.setPos(-3.8953F, 6.879F, -16.4792F);
		RightLeg.addChild(RightLeg_r6);
		setRotationAngle(RightLeg_r6, 0.2182F, 0.4363F, 0.0F);
		RightLeg_r6.texOffs(17, 30).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r7 = new ModelRenderer(this);
		RightLeg_r7.setPos(-3.8953F, 6.6347F, -18.9701F);
		RightLeg.addChild(RightLeg_r7);
		setRotationAngle(RightLeg_r7, 0.0F, -0.3491F, 0.0F);
		RightLeg_r7.texOffs(17, 29).addBox(4.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);

		RightLeg_r8 = new ModelRenderer(this);
		RightLeg_r8.setPos(-3.8953F, 6.6347F, -18.9701F);
		RightLeg.addChild(RightLeg_r8);
		setRotationAngle(RightLeg_r8, 0.0F, 0.1745F, 0.0F);
		RightLeg_r8.texOffs(18, 26).addBox(-2.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);

		RightLeg_r9 = new ModelRenderer(this);
		RightLeg_r9.setPos(-0.8953F, 9.1672F, -5.9117F);
		RightLeg.addChild(RightLeg_r9);
		setRotationAngle(RightLeg_r9, -1.789F, 0.0F, 0.0F);
		RightLeg_r9.texOffs(18, 30).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		RightLeg_r9.texOffs(18, 22).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg_r10 = new ModelRenderer(this);
		RightLeg_r10.setPos(1.1047F, 10.5309F, 6.912F);
		RightLeg.addChild(RightLeg_r10);
		setRotationAngle(RightLeg_r10, -1.3963F, 0.0F, 0.0F);
		RightLeg_r10.texOffs(26, 29).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg_r11 = new ModelRenderer(this);
		RightLeg_r11.setPos(0.1047F, 9.3278F, -1.3001F);
		RightLeg.addChild(RightLeg_r11);
		setRotationAngle(RightLeg_r11, 0.3491F, 0.0F, 0.0F);
		RightLeg_r11.texOffs(23, 29).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, false);

		viceleft = new ModelRenderer(this);
		viceleft.setPos(0.1047F, 1.7239F, -3.8752F);
		RightLeg.addChild(viceleft);
		

		vicer = new ModelRenderer(this);
		vicer.setPos(2.9F, 9.8855F, 0.2078F);
		vicer.texOffs(18, 30).addBox(9.0F, 5.5253F, 22.6973F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		RightLeg_r12 = new ModelRenderer(this);
		RightLeg_r12.setPos(12.0F, 6.0253F, 22.6973F);
		vicer.addChild(RightLeg_r12);
		setRotationAngle(RightLeg_r12, 0.0F, 0.3491F, 0.0F);
		RightLeg_r12.texOffs(17, 29).addBox(-5.0F, -0.5F, -2.0F, 2.0F, 1.0F, 6.0F, 0.0F, true);

		RightLeg_r13 = new ModelRenderer(this);
		RightLeg_r13.setPos(12.0F, 6.2696F, 25.1882F);
		vicer.addChild(RightLeg_r13);
		setRotationAngle(RightLeg_r13, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r13.texOffs(17, 30).addBox(1.0F, 0.5F, -1.5F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		RightLeg_r14 = new ModelRenderer(this);
		RightLeg_r14.setPos(12.0F, 6.0253F, 22.6973F);
		vicer.addChild(RightLeg_r14);
		setRotationAngle(RightLeg_r14, 0.0F, -0.1745F, 0.0F);
		RightLeg_r14.texOffs(19, 31).addBox(0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		RightLeg_r15 = new ModelRenderer(this);
		RightLeg_r15.setPos(9.0F, 7.9527F, 36.8319F);
		vicer.addChild(RightLeg_r15);
		setRotationAngle(RightLeg_r15, -1.7017F, 0.0F, 0.0F);
		RightLeg_r15.texOffs(18, 30).addBox(0.0F, 2.5F, -2.0F, 4.0F, 7.0F, 3.0F, 0.0F, true);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(0.0F, 0.0F, 0.0F);
		vicer.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(0, 47).addBox(9.0F, 0.0F, 30.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(19.45F, 8.457F, 12.5608F);
		setRotationAngle(LeftLeg, 0.3054F, 0.0F, -0.0349F);
		LeftLeg.texOffs(18, 30).addBox(0.1359F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r16 = new ModelRenderer(this);
		RightLeg_r16.setPos(3.1359F, 7.032F, -20.3604F);
		LeftLeg.addChild(RightLeg_r16);
		setRotationAngle(RightLeg_r16, 0.0F, 0.3491F, 0.0F);
		RightLeg_r16.texOffs(17, 29).addBox(-6.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r17 = new ModelRenderer(this);
		RightLeg_r17.setPos(3.1359F, 7.032F, -20.3604F);
		LeftLeg.addChild(RightLeg_r17);
		setRotationAngle(RightLeg_r17, 0.0F, -0.1745F, 0.0F);
		RightLeg_r17.texOffs(18, 26).addBox(0.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r18 = new ModelRenderer(this);
		RightLeg_r18.setPos(3.1359F, 7.2763F, -17.8695F);
		LeftLeg.addChild(RightLeg_r18);
		setRotationAngle(RightLeg_r18, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r18.texOffs(17, 30).addBox(1.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		RightLeg_r19 = new ModelRenderer(this);
		RightLeg_r19.setPos(0.1359F, 9.5644F, -7.3021F);
		LeftLeg.addChild(RightLeg_r19);
		setRotationAngle(RightLeg_r19, -1.789F, 0.0F, 0.0F);
		RightLeg_r19.texOffs(18, 30).addBox(0.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, 0.0F, true);
		RightLeg_r19.texOffs(18, 22).addBox(-1.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, true);

		RightLeg_r20 = new ModelRenderer(this);
		RightLeg_r20.setPos(-1.8641F, 10.9282F, 5.5217F);
		LeftLeg.addChild(RightLeg_r20);
		setRotationAngle(RightLeg_r20, -1.3963F, 0.0F, 0.0F);
		RightLeg_r20.texOffs(26, 29).addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, true);

		RightLeg_r21 = new ModelRenderer(this);
		RightLeg_r21.setPos(-0.8641F, 9.7251F, -2.6905F);
		LeftLeg.addChild(RightLeg_r21);
		setRotationAngle(RightLeg_r21, 0.3491F, 0.0F, 0.0F);
		RightLeg_r21.texOffs(23, 29).addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, true);

		RightLeg_r22 = new ModelRenderer(this);
		RightLeg_r22.setPos(-0.8641F, 8.1212F, -5.2655F);
		LeftLeg.addChild(RightLeg_r22);
		setRotationAngle(RightLeg_r22, -0.2182F, 0.0F, 0.0F);
		RightLeg_r22.texOffs(20, 28).addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, 0.0F, true);

		otherp = new ModelRenderer(this);
		otherp.setPos(-17.9F, 12.0F, 10.0F);
		otherp.texOffs(18, 44).addBox(32.8F, -11.0F, -10.0F, 2.0F, 7.0F, 3.0F, 0.0F, true);

		RightLeg_r23 = new ModelRenderer(this);
		RightLeg_r23.setPos(-1.0F, -3.5F, -5.5F);
		otherp.addChild(RightLeg_r23);
		setRotationAngle(RightLeg_r23, 0.3927F, 0.0F, 0.0F);
		RightLeg_r23.texOffs(20, 28).addBox(-1.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, false);
		RightLeg_r23.texOffs(20, 28).addBox(1.0F, -3.5F, -7.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		RightLeg_r24 = new ModelRenderer(this);
		RightLeg_r24.setPos(3.0F, 1.9959F, -5.9183F);
		otherp.addChild(RightLeg_r24);
		setRotationAngle(RightLeg_r24, -0.4363F, 0.0F, 0.0F);
		RightLeg_r24.texOffs(20, 28).addBox(-5.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg_r25 = new ModelRenderer(this);
		RightLeg_r25.setPos(-0.6946F, 11.6242F, -10.8151F);
		otherp.addChild(RightLeg_r25);
		setRotationAngle(RightLeg_r25, 0.3981F, 0.1611F, 0.0674F);
		RightLeg_r25.texOffs(18, 26).addBox(-2.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		RightLeg_r26 = new ModelRenderer(this);
		RightLeg_r26.setPos(-2.0F, 7.7367F, -4.4389F);
		otherp.addChild(RightLeg_r26);
		setRotationAngle(RightLeg_r26, -0.5236F, 0.0F, 0.0F);
		RightLeg_r26.texOffs(20, 28).addBox(2.0F, -3.5F, -8.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r27 = new ModelRenderer(this);
		RightLeg_r27.setPos(36.8F, 4.0808F, -5.211F);
		otherp.addChild(RightLeg_r27);
		setRotationAngle(RightLeg_r27, -0.9163F, 0.0F, 0.0F);
		RightLeg_r27.texOffs(20, 36).addBox(-4.0F, -4.5F, -8.5F, 2.0F, 3.0F, 1.0F, 0.0F, true);

		RightLeg_r28 = new ModelRenderer(this);
		RightLeg_r28.setPos(36.525F, 8.6385F, -9.0941F);
		otherp.addChild(RightLeg_r28);
		setRotationAngle(RightLeg_r28, 0.2657F, -0.1685F, -0.0456F);
		RightLeg_r28.texOffs(18, 26).addBox(0.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		RightLeg_r29 = new ModelRenderer(this);
		RightLeg_r29.setPos(32.8F, -1.0041F, -4.9183F);
		otherp.addChild(RightLeg_r29);
		setRotationAngle(RightLeg_r29, -0.5672F, 0.0F, 0.0F);
		RightLeg_r29.texOffs(20, 28).addBox(3.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, 0.0F, true);

		RightLeg_r30 = new ModelRenderer(this);
		RightLeg_r30.setPos(36.8F, -6.5F, -4.5F);
		otherp.addChild(RightLeg_r30);
		setRotationAngle(RightLeg_r30, 0.2618F, 0.0F, 0.0F);
		RightLeg_r30.texOffs(20, 28).addBox(-4.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, true);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.hair_r3.xRot = netHeadYaw * 0.007453292F;
		this.hairr2.xRot = netHeadYaw * 0.007453292F;
		this.eye_r2.zRot = netHeadYaw * 0.002453292F;
		this.eye_r3.zRot = netHeadYaw * 0.001453292F;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
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
}