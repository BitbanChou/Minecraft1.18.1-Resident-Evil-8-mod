// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMiranda1;
import com.joy187.re8joymod.common.entity.EntityMiranda2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMiranda2<T extends EntityMiranda2> extends EntityModel<T> {
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
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer circle;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer Body_r12;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
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
	private final ModelRenderer Body_r56;
	private final ModelRenderer Body_r57;
	private final ModelRenderer wing;
	private final ModelRenderer wingp_r1;
	private final ModelRenderer wingp_r2;
	private final ModelRenderer wingp_r3;
	private final ModelRenderer wingp_r4;
	private final ModelRenderer wingp_r5;
	private final ModelRenderer wingp_r6;
	private final ModelRenderer wingp_r7;
	private final ModelRenderer wingp_r8;
	private final ModelRenderer wingp_r9;
	private final ModelRenderer wingp_r10;
	private final ModelRenderer wingp_r11;
	private final ModelRenderer wingp_r12;
	private final ModelRenderer wingp_r13;
	private final ModelRenderer wing3;
	private final ModelRenderer wingp_r14;
	private final ModelRenderer wingp_r15;
	private final ModelRenderer wingp_r16;
	private final ModelRenderer wingp_r17;
	private final ModelRenderer wingp_r18;
	private final ModelRenderer wingp_r19;
	private final ModelRenderer wingp_r20;
	private final ModelRenderer wingp_r21;
	private final ModelRenderer wingp_r22;
	private final ModelRenderer wingp_r23;
	private final ModelRenderer wingp_r24;
	private final ModelRenderer wingp_r25;
	private final ModelRenderer wing4;
	private final ModelRenderer wingp_r26;
	private final ModelRenderer wingp_r27;
	private final ModelRenderer wingp_r28;
	private final ModelRenderer wingp_r29;
	private final ModelRenderer wingp_r30;
	private final ModelRenderer wingp_r31;
	private final ModelRenderer wingp_r32;
	private final ModelRenderer wingp_r33;
	private final ModelRenderer wingp_r34;
	private final ModelRenderer wingp_r35;
	private final ModelRenderer wingp_r36;
	private final ModelRenderer wing2;
	private final ModelRenderer wingp_r37;
	private final ModelRenderer wingp_r38;
	private final ModelRenderer wingp_r39;
	private final ModelRenderer wingp_r40;
	private final ModelRenderer wingp_r41;
	private final ModelRenderer wingp_r42;
	private final ModelRenderer wingp_r43;
	private final ModelRenderer wingp_r44;
	private final ModelRenderer wingp_r45;
	private final ModelRenderer wingp_r46;
	private final ModelRenderer wingp_r47;
	private final ModelRenderer wingp_r48;
	private final ModelRenderer wingDown;
	private final ModelRenderer wingp_r49;
	private final ModelRenderer wingp_r50;
	private final ModelRenderer wingp_r51;
	private final ModelRenderer wingp_r52;
	private final ModelRenderer wingp_r53;
	private final ModelRenderer wingp_r54;
	private final ModelRenderer wingp_r55;
	private final ModelRenderer wingp_r56;
	private final ModelRenderer wingp_r57;
	private final ModelRenderer wingp_r58;
	private final ModelRenderer wingp_r59;
	private final ModelRenderer wingp_r60;
	private final ModelRenderer wingp_r61;
	private final ModelRenderer wingp_r62;
	private final ModelRenderer wingp_r63;
	private final ModelRenderer wingDown2;
	private final ModelRenderer wingp_r64;
	private final ModelRenderer wingp_r65;
	private final ModelRenderer wingp_r66;
	private final ModelRenderer wingp_r67;
	private final ModelRenderer wingp_r68;
	private final ModelRenderer wingp_r69;
	private final ModelRenderer wingp_r70;
	private final ModelRenderer wingp_r71;
	private final ModelRenderer wingp_r72;
	private final ModelRenderer wingp_r73;
	private final ModelRenderer wingp_r74;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer Rightbacktlib;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer Rightfrontlib;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer RightArm_r9;
	private final ModelRenderer RightArm_r10;
	private final ModelRenderer RightArm_r11;
	private final ModelRenderer RightArm_r12;
	private final ModelRenderer RightArm_r13;
	private final ModelRenderer RightArm_r14;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer Leftlib;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer Leftfrontlib;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer LeftArm_r5;
	private final ModelRenderer LeftArm_r6;
	private final ModelRenderer LeftArm_r7;
	private final ModelRenderer LeftArm_r8;
	private final ModelRenderer LeftArm_r9;
	private final ModelRenderer LeftArm_r10;
	private final ModelRenderer LeftArm_r11;
	private final ModelRenderer LeftArm_r12;
	private final ModelRenderer LeftArm_r13;
	private final ModelRenderer LeftArm_r14;
	private final ModelRenderer LeftArm_r15;
	private final ModelRenderer LeftArm_r16;
	private final ModelRenderer LeftArm_r17;
	private final ModelRenderer LeftArm_r18;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightLeg_r3;
	private final ModelRenderer RightLeg_r4;
	private final ModelRenderer RightLeg_r5;
	private final ModelRenderer RightLeg_r6;
	private final ModelRenderer RightLeg_r7;
	private final ModelRenderer RightLeg_r8;
	private final ModelRenderer RightLeg_r9;
	private final ModelRenderer RightLeg_r10;
	private final ModelRenderer RightLeg_r11;
	private final ModelRenderer RightLeg_r12;
	private final ModelRenderer RightLeg_r13;
	private final ModelRenderer RightLeg_r14;
	private final ModelRenderer RightLeg_r15;
	private final ModelRenderer RightLeg_r16;
	private final ModelRenderer RightLeg_r17;
	private final ModelRenderer RightLeg_r18;
	private final ModelRenderer RightLeg_r19;
	private final ModelRenderer RightLeg_r20;
	private final ModelRenderer RightLeg_r21;
	private final ModelRenderer RightLeg_r22;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;
	private final ModelRenderer LeftLeg_r3;
	private final ModelRenderer LeftLeg_r4;
	private final ModelRenderer LeftLeg_r5;
	private final ModelRenderer LeftLeg_r6;
	private final ModelRenderer LeftLeg_r7;
	private final ModelRenderer LeftLeg_r8;
	private final ModelRenderer LeftLeg_r9;
	private final ModelRenderer LeftLeg_r10;
	private final ModelRenderer LeftLeg_r11;
	private final ModelRenderer LeftLeg_r12;
	private final ModelRenderer LeftLeg_r13;
	private final ModelRenderer LeftLeg_r14;
	private final ModelRenderer LeftLeg_r15;
	private final ModelRenderer LeftLeg_r16;
	private final ModelRenderer LeftLeg_r17;
	private final ModelRenderer LeftLeg_r18;
	private final ModelRenderer LeftLeg_r19;
	private final ModelRenderer LeftLeg_r20;
	private final ModelRenderer LeftLeg_r21;
	private final ModelRenderer LeftLeg_r22;
	private final ModelRenderer LeftLeg_r23;
	private final ModelRenderer LeftLeg_r24;
	private final ModelRenderer LeftLeg_r25;
	private final ModelRenderer LeftLeg_r26;

	public ModelMiranda2() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(-0.4444F, -23.0556F, -3.3889F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(2.3175F, -4.4454F, 4.533F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.1309F, -1.5708F);
		Head_r1.texOffs(38, 5).addBox(2.9986F, -4.9993F, -7.8429F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-2.9267F, -0.701F, -2.6176F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.0172F, -0.1298F, 1.7028F);
		Head_r2.texOffs(28, 6).addBox(-5.4644F, 1.0219F, -0.3953F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-2.6633F, 0.7278F, -2.4295F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.1304F, -0.0114F, 3.0551F);
		Head_r3.texOffs(28, 10).addBox(-2.8485F, 5.4834F, -0.3953F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Head_r3.texOffs(26, 13).addBox(-2.8485F, 4.4834F, -0.3953F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(2.1047F, -2.8234F, -2.7653F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.0503F, 0.1209F, -1.9665F);
		Head_r4.texOffs(40, 7).addBox(1.1943F, 2.0302F, -0.3953F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-0.9848F, -2.9144F, -3.3962F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.4002F, -0.0539F, 1.8047F);
		Head_r5.texOffs(26, 8).addBox(-5.3866F, 4.2679F, -1.3518F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-4.8558F, -4.5191F, -0.3746F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.0401F, -0.4463F, 1.8201F);
		Head_r6.texOffs(26, 3).addBox(-4.658F, 0.2038F, 0.3251F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(4.7447F, -4.5191F, -0.3746F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.0401F, 0.4463F, -1.8201F);
		Head_r7.texOffs(27, 0).addBox(2.658F, 0.2038F, 0.3251F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(0.8737F, -2.9144F, -3.3962F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 0.4002F, 0.0539F, -1.8047F);
		Head_r8.texOffs(45, 12).addBox(2.3866F, 4.2679F, -1.3518F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(2.5521F, 0.7278F, -2.4295F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, -0.1304F, 0.0114F, -3.0551F);
		Head_r9.texOffs(28, 12).addBox(-1.1515F, 4.4834F, -0.3953F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r9.texOffs(22, 18).addBox(-2.1515F, 5.4834F, -0.3953F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-3.0404F, -3.761F, 4.6231F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.1074F, -0.0749F, 2.5348F);
		Head_r10.texOffs(37, 8).addBox(-9.2935F, -0.7238F, -7.8429F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(-0.5556F, 2.0556F, 5.3889F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, 0.1188F, -0.0552F, 0.4331F);
		Head_r11.texOffs(23, 2).addBox(-8.6899F, -8.6233F, -7.8429F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(0.4444F, 3.0556F, 5.3889F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.1309F, 0.0F, 0.0F);
		Head_r12.texOffs(0, 62).addBox(-5.0F, -13.9979F, -6.8429F, 9.0F, 9.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(44, 7).addBox(-6.0F, -22.0F, -6.0F, 12.0F, 12.0F, 11.0F, 0.0F, false);
		Body.texOffs(44, 7).addBox(-5.0F, -23.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Body.texOffs(86, 109).addBox(-3.0F, -17.0F, 5.0F, 5.0F, 7.0F, 2.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-6.0F, -10.0F, -6.0F, 11.0F, 8.0F, 9.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-5.0F, -2.0F, -5.0F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		Body.texOffs(52, 60).addBox(-2.3856F, -1.2398F, -6.2446F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(-3.0F, 0.0F, -1.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.4363F, -0.5672F, 0.0F);
		Body_r1.texOffs(51, 54).addBox(-4.0F, -3.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(3.0F, 0.0F, -1.5F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.4363F, 0.5672F, 0.0F);
		Body_r2.texOffs(51, 54).addBox(0.0F, -3.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(3.5F, -6.0F, -10.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, 0.3927F);
		Body_r3.texOffs(69, 50).addBox(-1.5F, 0.0F, 3.5F, 3.0F, 8.0F, 3.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(-3.5F, -6.0F, -10.5F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.0F, -0.3927F);
		Body_r4.texOffs(69, 50).addBox(-1.5F, 0.0F, 3.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(0.0F, -20.0F, -0.5F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.0436F, 0.0F);
		Body_r5.texOffs(2, 47).addBox(-2.0F, -6.0F, -3.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(0.5F, -16.0F, -3.5F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.6109F, 0.0F, 0.0F);
		Body_r6.texOffs(44, 7).addBox(1.0F, -4.0F, -3.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);
		Body_r6.texOffs(44, 7).addBox(-4.7F, -4.0F, -3.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-0.5F, -22.5F, 5.0F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.3927F, 0.0F, 0.0F);
		Body_r7.texOffs(86, 109).addBox(-2.5F, -0.5F, -1.0F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		circle = new ModelRenderer(this);
		circle.setPos(-0.1203F, -20.1391F, 5.0F);
		Body.addChild(circle);
		circle.texOffs(44, 0).addBox(-1.6529F, -8.4852F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(3.7403F, -4.2461F, 0.0F);
		circle.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.0F, 3.0543F);
		Body_r8.texOffs(44, 0).addBox(1.5F, -2.0F, 0.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r8.texOffs(44, 0).addBox(1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-5.4996F, -4.2461F, 0.0F);
		circle.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.0F, -3.0543F);
		Body_r9.texOffs(44, 0).addBox(-5.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(3.27F, -4.6594F, 0.0F);
		circle.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, 2.7053F);
		Body_r10.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(13.2609F, -16.5389F, -0.5F);
		circle.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.0F, -2.3998F);
		Body_r11.texOffs(44, 0).addBox(8.0F, -2.322F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(8.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(9.0F, -0.722F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(12.7023F, -14.4394F, -0.5F);
		circle.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.0F, -2.2253F);
		Body_r12.texOffs(44, 0).addBox(5.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(13.2743F, -8.3363F, -0.5F);
		circle.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, -1.9199F);
		Body_r13.texOffs(44, 0).addBox(5.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(10.7615F, -10.7378F, -0.5F);
		circle.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, -1.309F);
		Body_r14.texOffs(44, 0).addBox(-3.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-0.8797F, -8.3609F, 0.0F);
		circle.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, -0.2618F, 0.9599F);
		Body_r15.texOffs(44, 0).addBox(-1.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(1.1203F, -8.3609F, 0.0F);
		circle.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.2137F, 0.0211F, -0.0118F);
		Body_r16.texOffs(41, 2).addBox(-4.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(1.1203F, -8.3609F, 0.0F);
		circle.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.2618F, -0.9599F);
		Body_r17.texOffs(44, 0).addBox(-4.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(1.1203F, -8.3609F, 0.0F);
		circle.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.0F, -0.9599F);
		Body_r18.texOffs(44, 0).addBox(5.0F, 4.5F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(-2.0F, 4.5F, -2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(-1.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(1.1343F, -6.6419F, 0.0F);
		circle.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, -1.1345F);
		Body_r19.texOffs(44, 0).addBox(-1.0F, 6.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(7.6254F, -12.3427F, 0.0F);
		circle.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, -1.5272F);
		Body_r20.texOffs(44, 0).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(5.2466F, -7.7737F, -0.5F);
		circle.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 0.6981F);
		Body_r21.texOffs(44, 0).addBox(-3.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(5.9307F, -9.6531F, -0.5F);
		circle.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 0.3491F);
		Body_r22.texOffs(44, 0).addBox(-3.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(9.4785F, -17.1806F, -0.5F);
		circle.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, -0.6545F);
		Body_r23.texOffs(44, 0).addBox(-2.5F, -1.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(2.7341F, -14.7797F, -5.0F);
		circle.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, -0.1309F);
		Body_r24.texOffs(44, 0).addBox(5.5F, 2.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r24.texOffs(44, 0).addBox(0.5F, 2.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(2.7341F, -14.7797F, -5.0F);
		circle.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, -0.9599F);
		Body_r25.texOffs(44, 0).addBox(3.5F, -1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r25.texOffs(44, 0).addBox(-0.5F, 0.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-5.0059F, -7.7737F, -0.5F);
		circle.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, -0.6981F);
		Body_r26.texOffs(44, 0).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-1.7797F, 31.5909F, -10.8791F);
		circle.addChild(Body_r27);
		setRotationAngle(Body_r27, -0.1441F, -0.084F, -0.6939F);
		Body_r27.texOffs(114, 64).addBox(5.0201F, -14.3613F, 4.0984F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(2.0203F, 31.5909F, -10.8791F);
		circle.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.1441F, 0.084F, 0.6939F);
		Body_r28.texOffs(114, 64).addBox(-10.0201F, -12.3613F, 5.0984F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-5.69F, -9.6531F, -0.5F);
		circle.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, -0.3491F);
		Body_r29.texOffs(44, 0).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-8.7421F, -17.1153F, -0.5F);
		circle.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.0F, 0.6109F);
		Body_r30.texOffs(44, 0).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r30.texOffs(44, 0).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-2.4935F, -14.7797F, -5.0F);
		circle.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.0F, 0.1309F);
		Body_r31.texOffs(44, 0).addBox(-4.5F, 2.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-2.4935F, -14.7797F, -5.0F);
		circle.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.0F, 0.9599F);
		Body_r32.texOffs(44, 0).addBox(-3.5F, 1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(-0.5532F, -15.1868F, -5.0F);
		circle.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, 0.0F, 3.0107F);
		Body_r33.texOffs(44, 0).addBox(-0.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-8.6239F, -11.1063F, 0.0F);
		circle.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.0F, 1.789F);
		Body_r34.texOffs(44, 0).addBox(-4.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r34.texOffs(44, 0).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(4.1591F, -10.6553F, -0.5F);
		circle.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.0F, -1.6581F);
		Body_r35.texOffs(44, 0).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(-3.9185F, -10.6553F, -0.5F);
		circle.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, 0.0F, 1.6581F);
		Body_r36.texOffs(44, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-3.5549F, -9.5447F, -0.5F);
		circle.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0F, 1.0908F);
		Body_r37.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(2.7955F, -9.5447F, -0.5F);
		circle.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, 0.0F, -1.0908F);
		Body_r38.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(7.8646F, -11.1063F, 0.0F);
		circle.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, -1.789F);
		Body_r39.texOffs(44, 0).addBox(2.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r39.texOffs(44, 0).addBox(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(3.7365F, -15.413F, 0.0F);
		circle.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0F, 0.0F, -2.3126F);
		Body_r40.texOffs(46, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-0.4869F, -19.7504F, -1.0F);
		circle.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0F, 0.0F, -2.4435F);
		Body_r41.texOffs(44, 0).addBox(-1.5F, -3.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(0.7276F, -19.7504F, -1.0F);
		circle.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0F, 0.0F, 2.4435F);
		Body_r42.texOffs(44, 0).addBox(-1.5F, -2.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-0.5073F, -19.301F, -1.0F);
		circle.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0F, 0.0F, -2.3562F);
		Body_r43.texOffs(0, 0).addBox(-1.7F, -2.2F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-0.5073F, -19.301F, -1.0F);
		circle.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0F, 0.0F, -3.1416F);
		Body_r44.texOffs(114, 2).addBox(-3.0723F, -11.2F, 0.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-1.5F, -4.2F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-0.2062F, -15.1868F, -5.0F);
		circle.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0F, 0.0F, -3.0107F);
		Body_r45.texOffs(44, 0).addBox(-1.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(2.2407F, -19.0F, 0.0F);
		circle.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0F, 0.0F, -2.9234F);
		Body_r46.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(-1.3234F, -17.7391F, 0.0F);
		circle.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0F, 0.0F, 2.4871F);
		Body_r47.texOffs(44, 0).addBox(-3.0F, 7.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-1.3234F, -17.7391F, 0.0F);
		circle.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0F, 0.0F, 2.7053F);
		Body_r48.texOffs(44, 0).addBox(-2.0F, 5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-4.5602F, -15.7872F, 0.0F);
		circle.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.0F, 0.0F, 2.1817F);
		Body_r49.texOffs(44, 0).addBox(-3.0F, 5.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(-4.4958F, -15.413F, 0.0F);
		circle.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0F, 0.0F, 2.3126F);
		Body_r50.texOffs(44, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(-4.0293F, -4.6594F, 0.0F);
		circle.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0F, 0.0F, -2.7053F);
		Body_r51.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(-7.3827F, -12.9242F, 0.0F);
		circle.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0F, 0.0F, 1.6581F);
		Body_r52.texOffs(44, 0).addBox(-4.0F, 3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-8.3847F, -12.3427F, 0.0F);
		circle.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0F, 0.0F, 1.5272F);
		Body_r53.texOffs(44, 0).addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-2.5283F, -10.2157F, 0.0F);
		circle.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0F, 0.0F, 1.3963F);
		Body_r54.texOffs(44, 0).addBox(-5.0F, 7.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-1.8797F, -8.3609F, 0.0F);
		circle.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0F, 0.0F, 1.2654F);
		Body_r55.texOffs(44, 0).addBox(-5.0F, 6.5F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-1.8797F, -8.3609F, 0.0F);
		circle.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0F, 0.0F, 0.9599F);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 4.5F, -2.0F, 6.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 6.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-3.0F, -19.0F, 0.0F);
		circle.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0F, 0.0F, 2.9234F);
		Body_r57.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wing = new ModelRenderer(this);
		wing.setPos(8.0F, -11.0F, 5.0F);
		Body.addChild(wing);
		setRotationAngle(wing, 0.0F, 0.0F, -0.0873F);
		wing.texOffs(47, 83).addBox(-0.8188F, -8.6122F, 0.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wing.texOffs(90, 103).addBox(-5.8188F, -5.6122F, 0.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r1 = new ModelRenderer(this);
		wingp_r1.setPos(26.1821F, -3.5878F, -5.6462F);
		wing.addChild(wingp_r1);
		setRotationAngle(wingp_r1, 0.0814F, 0.2947F, 0.2739F);
		wingp_r1.texOffs(89, 36).addBox(-2.4911F, -3.4555F, -0.4214F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r2 = new ModelRenderer(this);
		wingp_r2.setPos(15.9126F, -0.7489F, -2.7702F);
		wing.addChild(wingp_r2);
		setRotationAngle(wingp_r2, 0.0547F, 0.3006F, 0.1828F);
		wingp_r2.texOffs(49, 62).addBox(1.8236F, -8.3062F, -0.0761F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r3 = new ModelRenderer(this);
		wingp_r3.setPos(17.4382F, -0.7522F, -3.2512F);
		wing.addChild(wingp_r3);
		setRotationAngle(wingp_r3, 0.1074F, 0.2865F, 0.3646F);
		wingp_r3.texOffs(114, 77).addBox(-1.2069F, -5.8726F, -0.0761F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r4 = new ModelRenderer(this);
		wingp_r4.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r4);
		setRotationAngle(wingp_r4, 0.1074F, 0.2865F, 0.3646F);
		wingp_r4.texOffs(112, 74).addBox(6.2931F, -7.3726F, -0.5761F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r5 = new ModelRenderer(this);
		wingp_r5.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r5);
		setRotationAngle(wingp_r5, -0.0411F, 0.3027F, -0.1372F);
		wingp_r5.texOffs(69, 60).addBox(5.0846F, -4.0355F, -0.5761F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r6 = new ModelRenderer(this);
		wingp_r6.setPos(14.6643F, 3.5971F, -2.9009F);
		wing.addChild(wingp_r6);
		setRotationAngle(wingp_r6, 0.1896F, 0.2409F, 0.6775F);
		wingp_r6.texOffs(50, 78).addBox(-5.9401F, -5.8882F, 0.4239F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r7 = new ModelRenderer(this);
		wingp_r7.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r7);
		setRotationAngle(wingp_r7, 0.1325F, 0.276F, 0.4548F);
		wingp_r7.texOffs(44, 66).addBox(0.784F, -4.5861F, -0.5761F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r8 = new ModelRenderer(this);
		wingp_r8.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r8);
		setRotationAngle(wingp_r8, 0.1564F, 0.2635F, 0.5444F);
		wingp_r8.texOffs(46, 72).addBox(5.2841F, -3.1606F, -0.5761F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r8.texOffs(49, 77).addBox(0.2841F, -3.1606F, -0.5761F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r9 = new ModelRenderer(this);
		wingp_r9.setPos(3.7336F, 4.9445F, 1.0698F);
		wing.addChild(wingp_r9);
		setRotationAngle(wingp_r9, 0.2835F, -0.1153F, 1.947F);
		wingp_r9.texOffs(48, 77).addBox(-6.3362F, 2.8624F, -1.0761F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r10 = new ModelRenderer(this);
		wingp_r10.setPos(3.7336F, 4.9445F, 1.0698F);
		wing.addChild(wingp_r10);
		setRotationAngle(wingp_r10, 0.3011F, -0.0522F, 1.7374F);
		wingp_r10.texOffs(46, 73).addBox(-7.4061F, 0.1764F, -0.0761F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r11 = new ModelRenderer(this);
		wingp_r11.setPos(8.9342F, 4.2266F, -0.5699F);
		wing.addChild(wingp_r11);
		setRotationAngle(wingp_r11, 0.303F, 0.0393F, 1.4459F);
		wingp_r11.texOffs(47, 76).addBox(-4.0355F, 1.9154F, -0.0761F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r11.texOffs(49, 74).addBox(-7.0355F, 0.9154F, -0.0761F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r12 = new ModelRenderer(this);
		wingp_r12.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r12);
		setRotationAngle(wingp_r12, -0.1074F, 0.2865F, -0.3646F);
		wingp_r12.texOffs(79, 59).addBox(0.2333F, -2.4531F, -0.5761F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r13 = new ModelRenderer(this);
		wingp_r13.setPos(8.3321F, -0.3519F, 0.1442F);
		wing.addChild(wingp_r13);
		setRotationAngle(wingp_r13, 0.0F, 0.3054F, 0.0F);
		wingp_r13.texOffs(45, 76).addBox(4.3443F, -8.2602F, -0.5761F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r13.texOffs(46, 78).addBox(-1.6557F, -8.2602F, -0.5761F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wing3 = new ModelRenderer(this);
		wing3.setPos(3.0F, -18.0F, 7.0F);
		Body.addChild(wing3);
		setRotationAngle(wing3, -0.0114F, -0.0865F, -0.7413F);
		wing3.texOffs(0, 108).addBox(4.0335F, -2.2747F, -1.2812F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wing3.texOffs(0, 108).addBox(-3.9665F, -2.2747F, -1.2812F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r14 = new ModelRenderer(this);
		wingp_r14.setPos(19.0477F, 3.5548F, -4.3725F);
		wing3.addChild(wingp_r14);
		setRotationAngle(wingp_r14, 0.0F, 0.3054F, 0.0F);
		wingp_r14.texOffs(46, 65).addBox(6.5304F, -6.5275F, 0.7465F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r15 = new ModelRenderer(this);
		wingp_r15.setPos(19.8727F, 4.2439F, -4.6327F);
		wing3.addChild(wingp_r15);
		setRotationAngle(wingp_r15, -0.0547F, 0.3006F, -0.1828F);
		wingp_r15.texOffs(46, 65).addBox(3.8324F, -6.1232F, 0.7465F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r16 = new ModelRenderer(this);
		wingp_r16.setPos(17.7525F, 1.0017F, -2.9157F);
		wing3.addChild(wingp_r16);
		setRotationAngle(wingp_r16, 0.0547F, 0.3006F, 0.1828F);
		wingp_r16.texOffs(46, 65).addBox(13.2977F, -6.3804F, -0.2535F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r17 = new ModelRenderer(this);
		wingp_r17.setPos(19.8727F, 4.2439F, -4.6327F);
		wing3.addChild(wingp_r17);
		setRotationAngle(wingp_r17, 0.1074F, 0.2865F, 0.3646F);
		wingp_r17.texOffs(114, 77).addBox(1.3904F, -5.3906F, 0.7465F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r18 = new ModelRenderer(this);
		wingp_r18.setPos(22.7215F, 2.6441F, -4.2239F);
		wing3.addChild(wingp_r18);
		setRotationAngle(wingp_r18, 0.2727F, 0.1393F, 1.11F);
		wingp_r18.texOffs(111, 76).addBox(-3.5F, 5.0F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r19 = new ModelRenderer(this);
		wingp_r19.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r19);
		setRotationAngle(wingp_r19, -0.0411F, 0.3027F, -0.1372F);
		wingp_r19.texOffs(69, 60).addBox(7.1659F, -2.4086F, 0.2465F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r20 = new ModelRenderer(this);
		wingp_r20.setPos(17.0988F, 8.5932F, -4.2823F);
		wing3.addChild(wingp_r20);
		setRotationAngle(wingp_r20, 0.1896F, 0.2409F, 0.6775F);
		wingp_r20.texOffs(50, 78).addBox(-3.3181F, -6.2095F, 1.2465F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r21 = new ModelRenderer(this);
		wingp_r21.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r21);
		setRotationAngle(wingp_r21, 0.2194F, 0.2143F, 0.8091F);
		wingp_r21.texOffs(44, 62).addBox(3.4134F, -4.3322F, 0.2465F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r22 = new ModelRenderer(this);
		wingp_r22.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r22);
		setRotationAngle(wingp_r22, 0.2956F, 0.0779F, 1.3206F);
		wingp_r22.texOffs(46, 72).addBox(-0.0744F, 0.8631F, 0.2465F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r23 = new ModelRenderer(this);
		wingp_r23.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r23);
		setRotationAngle(wingp_r23, 0.2599F, 0.1623F, 1.0248F);
		wingp_r23.texOffs(49, 77).addBox(-0.0744F, -3.1369F, 0.2465F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r24 = new ModelRenderer(this);
		wingp_r24.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r24);
		setRotationAngle(wingp_r24, -0.1074F, 0.2865F, -0.3646F);
		wingp_r24.texOffs(79, 59).addBox(1.9131F, -0.4143F, 0.2465F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r25 = new ModelRenderer(this);
		wingp_r25.setPos(10.7666F, 4.6442F, -1.2373F);
		wing3.addChild(wingp_r25);
		setRotationAngle(wingp_r25, 0.0F, 0.3054F, 0.0F);
		wingp_r25.texOffs(45, 76).addBox(6.6201F, -6.9189F, 0.2465F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r25.texOffs(46, 78).addBox(0.6201F, -6.9189F, 0.2465F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wing4 = new ModelRenderer(this);
		wing4.setPos(-6.0F, -17.0F, 6.0F);
		Body.addChild(wing4);
		setRotationAngle(wing4, -0.0385F, 0.2148F, 0.694F);
		wing4.texOffs(0, 108).addBox(-10.0435F, -4.5887F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);
		wing4.texOffs(0, 108).addBox(-4.0435F, -4.5887F, 0.0F, 8.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r26 = new ModelRenderer(this);
		wingp_r26.setPos(-19.3923F, -2.3029F, -4.7279F);
		wing4.addChild(wingp_r26);
		setRotationAngle(wingp_r26, -0.1564F, -0.2635F, 0.5444F);
		wingp_r26.texOffs(46, 65).addBox(-9.8724F, 0.4993F, 0.6516F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		wingp_r27 = new ModelRenderer(this);
		wingp_r27.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r27);
		setRotationAngle(wingp_r27, -0.0547F, -0.3006F, 0.1828F);
		wingp_r27.texOffs(46, 65).addBox(-9.8642F, -6.1176F, 0.6516F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r28 = new ModelRenderer(this);
		wingp_r28.setPos(-22.8865F, 0.0769F, -5.8296F);
		wing4.addChild(wingp_r28);
		setRotationAngle(wingp_r28, 0.0547F, -0.3006F, -0.1828F);
		wingp_r28.texOffs(46, 65).addBox(-8.3295F, -6.386F, 0.6516F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r29 = new ModelRenderer(this);
		wingp_r29.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r29);
		setRotationAngle(wingp_r29, 0.1074F, -0.2865F, -0.3646F);
		wingp_r29.texOffs(114, 77).addBox(-7.4207F, -5.4016F, 0.6516F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r30 = new ModelRenderer(this);
		wingp_r30.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r30);
		setRotationAngle(wingp_r30, 0.2666F, -0.1509F, -1.0675F);
		wingp_r30.texOffs(111, 73).addBox(-7.9207F, -6.9016F, 0.1516F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r31 = new ModelRenderer(this);
		wingp_r31.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r31);
		setRotationAngle(wingp_r31, -0.0411F, -0.3027F, 0.1372F);
		wingp_r31.texOffs(69, 60).addBox(-14.1978F, -2.4044F, 0.1516F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r32 = new ModelRenderer(this);
		wingp_r32.setPos(-15.1066F, 6.2793F, -3.9009F);
		wing4.addChild(wingp_r32);
		setRotationAngle(wingp_r32, 0.1896F, -0.2409F, -0.6775F);
		wingp_r32.texOffs(50, 78).addBox(-1.7075F, -6.2291F, 1.1516F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r33 = new ModelRenderer(this);
		wingp_r33.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r33);
		setRotationAngle(wingp_r33, 0.2783F, -0.1274F, -1.1523F);
		wingp_r33.texOffs(44, 63).addBox(-5.4426F, -4.3459F, 0.1516F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r34 = new ModelRenderer(this);
		wingp_r34.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r34);
		setRotationAngle(wingp_r34, 0.2921F, -0.0905F, -1.2787F);
		wingp_r34.texOffs(49, 77).addBox(-4.9535F, -3.153F, 0.1516F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r35 = new ModelRenderer(this);
		wingp_r35.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r35);
		setRotationAngle(wingp_r35, -0.1074F, -0.2865F, 0.3646F);
		wingp_r35.texOffs(79, 59).addBox(-7.9434F, -0.4033F, 0.1516F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r36 = new ModelRenderer(this);
		wingp_r36.setPos(-8.7744F, 2.3302F, -0.8558F);
		wing4.addChild(wingp_r36);
		setRotationAngle(wingp_r36, 0.0F, -0.3054F, 0.0F);
		wingp_r36.texOffs(45, 76).addBox(-13.6523F, -6.9189F, 0.1516F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r36.texOffs(46, 78).addBox(-6.6523F, -6.9189F, 0.1516F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wing2 = new ModelRenderer(this);
		wing2.setPos(-7.0F, -12.0F, 6.0F);
		Body.addChild(wing2);
		setRotationAngle(wing2, 0.0F, 0.0F, 0.0436F);
		wing2.texOffs(47, 83).addBox(-7.5917F, -7.3142F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);
		wing2.texOffs(94, 88).addBox(0.4083F, -4.3142F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r37 = new ModelRenderer(this);
		wingp_r37.setPos(-17.9794F, 0.5543F, -4.2512F);
		wing2.addChild(wingp_r37);
		setRotationAngle(wingp_r37, 0.1074F, -0.2865F, -0.3646F);
		wingp_r37.texOffs(114, 77).addBox(-4.6731F, -5.8381F, -0.1154F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r38 = new ModelRenderer(this);
		wingp_r38.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r38);
		setRotationAngle(wingp_r38, 0.1074F, -0.2865F, -0.3646F);
		wingp_r38.texOffs(111, 81).addBox(-13.1731F, -7.3381F, -0.6154F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r39 = new ModelRenderer(this);
		wingp_r39.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r39);
		setRotationAngle(wingp_r39, -0.0411F, -0.3027F, 0.1372F);
		wingp_r39.texOffs(69, 60).addBox(-11.9623F, -4.0602F, -0.6154F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r40 = new ModelRenderer(this);
		wingp_r40.setPos(-15.2055F, 4.9037F, -3.9009F);
		wing2.addChild(wingp_r40);
		setRotationAngle(wingp_r40, 0.1896F, -0.2409F, -0.6775F);
		wingp_r40.texOffs(50, 78).addBox(1.0441F, -5.8192F, 0.3846F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r41 = new ModelRenderer(this);
		wingp_r41.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r41);
		setRotationAngle(wingp_r41, 0.1325F, -0.276F, -0.4548F);
		wingp_r41.texOffs(44, 66).addBox(-5.6674F, -4.5412F, -0.6154F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r42 = new ModelRenderer(this);
		wingp_r42.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r42);
		setRotationAngle(wingp_r42, 0.1564F, -0.2635F, -0.5444F);
		wingp_r42.texOffs(46, 72).addBox(-8.1719F, -3.1058F, -0.6154F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r42.texOffs(49, 77).addBox(-5.1719F, -3.1058F, -0.6154F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r43 = new ModelRenderer(this);
		wingp_r43.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r43);
		setRotationAngle(wingp_r43, 0.2835F, 0.1153F, -1.947F);
		wingp_r43.texOffs(48, 77).addBox(3.2964F, 2.9807F, -1.1154F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r44 = new ModelRenderer(this);
		wingp_r44.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r44);
		setRotationAngle(wingp_r44, 0.3011F, 0.0522F, -1.7374F);
		wingp_r44.texOffs(46, 73).addBox(4.3929F, 0.3006F, -0.1154F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r45 = new ModelRenderer(this);
		wingp_r45.setPos(-9.4754F, 5.5331F, -1.5699F);
		wing2.addChild(wingp_r45);
		setRotationAngle(wingp_r45, 0.303F, -0.0393F, -1.4459F);
		wingp_r45.texOffs(47, 76).addBox(2.0602F, 2.0377F, -0.1154F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r45.texOffs(49, 74).addBox(4.0602F, 1.0377F, -0.1154F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r46 = new ModelRenderer(this);
		wingp_r46.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r46);
		setRotationAngle(wingp_r46, -0.1074F, -0.2865F, 0.3646F);
		wingp_r46.texOffs(79, 59).addBox(-6.1192F, -2.5037F, -0.6154F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r47 = new ModelRenderer(this);
		wingp_r47.setPos(-22.5931F, -2.8687F, -5.344F);
		wing2.addChild(wingp_r47);
		setRotationAngle(wingp_r47, 0.0411F, -0.3027F, -0.1372F);
		wingp_r47.texOffs(11, 76).addBox(-8.2325F, -3.9878F, -0.4607F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r47.texOffs(13, 78).addBox(-3.2325F, -3.9878F, -0.4607F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r48 = new ModelRenderer(this);
		wingp_r48.setPos(-8.8733F, 0.9546F, -0.8558F);
		wing2.addChild(wingp_r48);
		setRotationAngle(wingp_r48, 0.0F, -0.3054F, 0.0F);
		wingp_r48.texOffs(45, 76).addBox(-11.2197F, -8.2688F, -0.6154F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r48.texOffs(46, 78).addBox(-4.2197F, -8.2688F, -0.6154F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingDown = new ModelRenderer(this);
		wingDown.setPos(-7.0F, -9.0F, 6.0F);
		Body.addChild(wingDown);
		setRotationAngle(wingDown, 0.0F, 0.0F, -0.8727F);
		wingDown.texOffs(79, 47).addBox(-5.629F, -5.4184F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);
		wingDown.texOffs(79, 47).addBox(2.371F, -0.4184F, -1.0F, 5.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r49 = new ModelRenderer(this);
		wingp_r49.setPos(-21.3144F, 1.0672F, -4.2512F);
		wingDown.addChild(wingp_r49);
		setRotationAngle(wingp_r49, 0.0547F, -0.3006F, -0.1828F);
		wingp_r49.texOffs(52, 62).addBox(-0.9638F, -5.0537F, -1.7085F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r50 = new ModelRenderer(this);
		wingp_r50.setPos(-21.3144F, 1.0672F, -4.2512F);
		wingDown.addChild(wingp_r50);
		setRotationAngle(wingp_r50, 0.1074F, -0.2865F, -0.3646F);
		wingp_r50.texOffs(114, 77).addBox(-0.3983F, -2.8104F, -1.7085F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r51 = new ModelRenderer(this);
		wingp_r51.setPos(-10.913F, 0.7649F, -0.4474F);
		wingDown.addChild(wingp_r51);
		setRotationAngle(wingp_r51, 0.1564F, -0.2635F, -0.5444F);
		wingp_r51.texOffs(111, 81).addBox(-12.4877F, -6.0818F, -2.2085F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r51.texOffs(111, 81).addBox(-8.4877F, -6.0818F, -2.2085F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r52 = new ModelRenderer(this);
		wingp_r52.setPos(-10.913F, 0.7649F, -0.4474F);
		wingDown.addChild(wingp_r52);
		setRotationAngle(wingp_r52, -0.0411F, -0.3027F, 0.1372F);
		wingp_r52.texOffs(69, 60).addBox(-6.7724F, -3.3486F, -2.2085F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r53 = new ModelRenderer(this);
		wingp_r53.setPos(-18.5406F, 5.4165F, -3.9009F);
		wingDown.addChild(wingp_r53);
		setRotationAngle(wingp_r53, 0.1564F, -0.2635F, -0.5444F);
		wingp_r53.texOffs(50, 78).addBox(3.0123F, -3.4819F, -1.2085F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r54 = new ModelRenderer(this);
		wingp_r54.setPos(-18.5406F, 5.4165F, -3.9009F);
		wingDown.addChild(wingp_r54);
		setRotationAngle(wingp_r54, 0.1896F, -0.2409F, -0.6775F);
		wingp_r54.texOffs(50, 78).addBox(4.2107F, -1.6462F, -1.2085F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r55 = new ModelRenderer(this);
		wingp_r55.setPos(-10.8067F, 6.0905F, -0.9382F);
		wingDown.addChild(wingp_r55);
		setRotationAngle(wingp_r55, 0.2599F, -0.1623F, -1.0248F);
		wingp_r55.texOffs(44, 66).addBox(4.2584F, 0.3761F, -1.7085F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r56 = new ModelRenderer(this);
		wingp_r56.setPos(-10.913F, 0.7649F, -0.4474F);
		wingDown.addChild(wingp_r56);
		setRotationAngle(wingp_r56, 0.1564F, -0.2635F, -0.5444F);
		wingp_r56.texOffs(46, 72).addBox(-4.4877F, -0.3818F, -2.2085F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r56.texOffs(49, 77).addBox(-1.4877F, -0.3818F, -2.2085F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r57 = new ModelRenderer(this);
		wingp_r57.setPos(-7.6098F, 6.7639F, 0.0698F);
		wingDown.addChild(wingp_r57);
		setRotationAngle(wingp_r57, 0.2835F, 0.1153F, -1.947F);
		wingp_r57.texOffs(48, 77).addBox(0.0852F, 7.1195F, -2.7085F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r58 = new ModelRenderer(this);
		wingp_r58.setPos(-7.6098F, 6.7639F, 0.0698F);
		wingDown.addChild(wingp_r58);
		setRotationAngle(wingp_r58, 0.3011F, 0.0522F, -1.7374F);
		wingp_r58.texOffs(46, 73).addBox(2.1536F, 5.0362F, -1.7085F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r59 = new ModelRenderer(this);
		wingp_r59.setPos(-12.8104F, 6.046F, -1.5699F);
		wingDown.addChild(wingp_r59);
		setRotationAngle(wingp_r59, 0.303F, -0.0393F, -1.4459F);
		wingp_r59.texOffs(47, 76).addBox(1.3486F, 7.2276F, -1.7085F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r59.texOffs(49, 74).addBox(3.3486F, 6.2276F, -1.7085F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r60 = new ModelRenderer(this);
		wingp_r60.setPos(-10.913F, 0.7649F, -0.4474F);
		wingDown.addChild(wingp_r60);
		setRotationAngle(wingp_r60, -0.1074F, -0.2865F, 0.3646F);
		wingp_r60.texOffs(79, 59).addBox(-0.8983F, -2.9322F, -2.2085F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r61 = new ModelRenderer(this);
		wingp_r61.setPos(-27.9244F, -2.49F, -10.5423F);
		wingDown.addChild(wingp_r61);
		setRotationAngle(wingp_r61, 0.0F, -0.829F, 0.0F);
		wingp_r61.texOffs(90, 36).addBox(-1.9474F, -2.9284F, -2.1944F, 7.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r62 = new ModelRenderer(this);
		wingp_r62.setPos(-13.253F, 1.4674F, 1.0647F);
		wingDown.addChild(wingp_r62);
		setRotationAngle(wingp_r62, 0.0F, -0.5672F, 0.0F);
		wingp_r62.texOffs(86, 38).addBox(-13.4207F, -6.8858F, -2.7522F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r63 = new ModelRenderer(this);
		wingp_r63.setPos(-12.2083F, 1.4674F, -0.8558F);
		wingDown.addChild(wingp_r63);
		setRotationAngle(wingp_r63, 0.0F, -0.3054F, 0.0F);
		wingp_r63.texOffs(91, 52).addBox(-6.1671F, -6.8858F, -2.2085F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r63.texOffs(85, 93).addBox(0.8329F, -6.8858F, -2.2085F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingDown2 = new ModelRenderer(this);
		wingDown2.setPos(8.0F, -2.0F, 6.0F);
		Body.addChild(wingDown2);
		setRotationAngle(wingDown2, 0.0F, 0.0F, 0.8727F);
		wingDown2.texOffs(79, 47).addBox(-9.0189F, -8.3858F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wingDown2.texOffs(79, 47).addBox(-13.0189F, -3.3858F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r64 = new ModelRenderer(this);
		wingp_r64.setPos(15.8801F, -3.1173F, -4.6339F);
		wingDown2.addChild(wingp_r64);
		setRotationAngle(wingp_r64, 0.0138F, 0.3051F, 0.0457F);
		wingp_r64.texOffs(80, 50).addBox(-5.0362F, -5.0537F, -1.7085F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r65 = new ModelRenderer(this);
		wingp_r65.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r65);
		setRotationAngle(wingp_r65, 0.2727F, 0.1393F, 1.11F);
		wingp_r65.texOffs(111, 81).addBox(3.4877F, -6.0818F, -2.2085F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r65.texOffs(111, 81).addBox(-0.5123F, -6.0818F, -2.2085F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r66 = new ModelRenderer(this);
		wingp_r66.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r66);
		setRotationAngle(wingp_r66, -0.0411F, 0.3027F, -0.1372F);
		wingp_r66.texOffs(69, 60).addBox(-0.2276F, -3.3486F, -2.2085F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r67 = new ModelRenderer(this);
		wingp_r67.setPos(7.2675F, -2.5455F, -3.1855F);
		wingDown2.addChild(wingp_r67);
		setRotationAngle(wingp_r67, 0.2783F, 0.1274F, 1.1523F);
		wingp_r67.texOffs(50, 78).addBox(-2.5F, 0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r68 = new ModelRenderer(this);
		wingp_r68.setPos(4.1588F, 3.123F, -0.9382F);
		wingDown2.addChild(wingp_r68);
		setRotationAngle(wingp_r68, 0.2599F, 0.1623F, 1.0248F);
		wingp_r68.texOffs(44, 66).addBox(-7.2584F, 0.3761F, -1.7085F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r69 = new ModelRenderer(this);
		wingp_r69.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r69);
		setRotationAngle(wingp_r69, 0.2599F, 0.1623F, 1.0248F);
		wingp_r69.texOffs(46, 72).addBox(1.4877F, -0.3818F, -2.2085F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r69.texOffs(49, 77).addBox(-3.5123F, -0.3818F, -2.2085F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r70 = new ModelRenderer(this);
		wingp_r70.setPos(0.962F, 3.7964F, 0.0698F);
		wingDown2.addChild(wingp_r70);
		setRotationAngle(wingp_r70, 0.2835F, -0.1153F, 1.947F);
		wingp_r70.texOffs(48, 77).addBox(-3.0852F, 7.1195F, -2.7085F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r71 = new ModelRenderer(this);
		wingp_r71.setPos(0.962F, 3.7964F, 0.0698F);
		wingDown2.addChild(wingp_r71);
		setRotationAngle(wingp_r71, 0.3011F, -0.0522F, 1.7374F);
		wingp_r71.texOffs(46, 73).addBox(-5.1536F, 5.0362F, -1.7085F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r72 = new ModelRenderer(this);
		wingp_r72.setPos(6.1625F, 3.0785F, -1.5699F);
		wingDown2.addChild(wingp_r72);
		setRotationAngle(wingp_r72, 0.303F, 0.0393F, 1.4459F);
		wingp_r72.texOffs(47, 76).addBox(-3.3486F, 7.2276F, -1.7085F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r72.texOffs(49, 74).addBox(-6.3486F, 6.2276F, -1.7085F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r73 = new ModelRenderer(this);
		wingp_r73.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r73);
		setRotationAngle(wingp_r73, -0.1074F, 0.2865F, -0.3646F);
		wingp_r73.texOffs(79, 59).addBox(-5.1017F, -2.9322F, -2.2085F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r74 = new ModelRenderer(this);
		wingp_r74.setPos(5.5604F, -1.5F, -0.8558F);
		wingDown2.addChild(wingp_r74);
		setRotationAngle(wingp_r74, 0.0F, 0.3054F, 0.0F);
		wingp_r74.texOffs(89, 67).addBox(-0.8329F, -6.8858F, -2.2085F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r74.texOffs(87, 70).addBox(-6.8329F, -6.8858F, -2.2085F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-7.0F, -18.0F, -1.0F);
		setRotationAngle(RightArm, -0.2182F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(0.0F, 3.1224F, 0.3281F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0436F, -0.1745F, 1.4399F);
		RightArm_r1.texOffs(82, 2).addBox(-5.9449F, -2.7757F, -3.2368F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Rightbacktlib = new ModelRenderer(this);
		Rightbacktlib.setPos(-2.0F, 6.8815F, 1.0822F);
		RightArm.addChild(Rightbacktlib);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(3.0F, 0.644F, 3.0686F);
		Rightbacktlib.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.1745F, 0.0F, 0.0F);
		RightArm_r2.texOffs(86, 15).addBox(-5.0F, -9.9943F, -5.2617F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Rightfrontlib = new ModelRenderer(this);
		Rightfrontlib.setPos(0.0F, 0.0F, 0.0F);
		Rightbacktlib.addChild(Rightfrontlib);
		

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-4.0905F, 13.6249F, -1.1438F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3775F, 0.9144F, -0.0465F);
		RightArm_r3.texOffs(124, 20).addBox(-0.2626F, -1.6135F, -1.8464F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-3.9978F, 13.9978F, -1.4862F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, 0.1665F, 0.9578F, 0.6202F);
		RightArm_r4.texOffs(123, 10).addBox(-1.3082F, -8.6432F, -1.8464F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.647F, 5.6035F, -0.8624F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.3463F, -0.0447F, 0.0951F);
		RightArm_r5.texOffs(121, 6).addBox(-2.562F, 2.9537F, -3.1962F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(1.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3414F, 0.0741F, 0.4236F);
		RightArm_r6.texOffs(121, 6).addBox(-3.4077F, 0.211F, -3.1962F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.3299F, 10.8257F, -6.8058F);
		Rightfrontlib.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.6378F, -0.1582F, -0.384F);
		RightArm_r7.texOffs(124, 11).addBox(1.9898F, -5.59F, -0.0421F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(-1.2245F, 9.153F, -1.7002F);
		Rightfrontlib.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -1.0742F, -0.1582F, -0.384F);
		RightArm_r8.texOffs(124, 11).addBox(1.9898F, 5.5288F, -0.5465F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(1.4611F, 9.253F, -1.7553F);
		Rightfrontlib.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, -0.9234F, -0.3332F, -0.6425F);
		RightArm_r9.texOffs(119, 13).addBox(0.9461F, 3.5332F, -3.0867F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(1.268F, 8.3751F, -2.8286F);
		Rightfrontlib.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, -0.5744F, -0.3332F, -0.6425F);
		RightArm_r10.texOffs(124, 12).addBox(0.9461F, -2.3233F, -2.771F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(-1.0663F, 11.0304F, -1.1285F);
		Rightfrontlib.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, -0.5251F, -0.0113F, 0.087F);
		RightArm_r11.texOffs(124, 11).addBox(-0.2533F, 7.3109F, 0.8813F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		RightArm_r12 = new ModelRenderer(this);
		RightArm_r12.setPos(-1.0197F, 10.7748F, -3.2782F);
		Rightfrontlib.addChild(RightArm_r12);
		setRotationAngle(RightArm_r12, -0.3069F, -0.0113F, 0.087F);
		RightArm_r12.texOffs(124, 11).addBox(-0.2533F, 0.9255F, 0.4056F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r13 = new ModelRenderer(this);
		RightArm_r13.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r13);
		setRotationAngle(RightArm_r13, 0.0421F, -0.0113F, 0.087F);
		RightArm_r13.texOffs(124, 11).addBox(-0.2533F, -5.4308F, 1.3804F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r14 = new ModelRenderer(this);
		RightArm_r14.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r14);
		setRotationAngle(RightArm_r14, -0.3491F, 0.0F, 0.0F);
		RightArm_r14.texOffs(88, 21).addBox(-2.0F, -0.0603F, -4.2238F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		RightArm_r14.texOffs(88, 27).addBox(-2.0F, -10.0603F, -5.2238F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.4442F, -18.8343F, -0.4302F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(2.4442F, 4.4908F, -2.0935F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.0436F, -0.2182F, -1.4399F);
		LeftArm_r1.texOffs(82, 2).addBox(2.9508F, -3.7671F, -1.008F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Leftlib = new ModelRenderer(this);
		Leftlib.setPos(3.5558F, 10.3559F, -1.9878F);
		LeftArm.addChild(Leftlib);
		

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.0F, -3.0F, 0.0F);
		Leftlib.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(88, 14).addBox(-2.0F, -9.4963F, -1.7906F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Leftfrontlib = new ModelRenderer(this);
		Leftfrontlib.setPos(0.0F, 1.0F, -2.0F);
		Leftlib.addChild(Leftfrontlib);
		

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.8727F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(89, 21).addBox(-1.0F, -1.2281F, -5.694F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		LeftArm_r3.texOffs(91, 27).addBox(-2.0F, -12.2281F, -5.694F, 4.0F, 11.0F, 3.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(4.9445F, 13.4316F, -16.3494F);
		Leftfrontlib.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, 0.1035F, 0.8681F, 2.0115F);
		LeftArm_r4.texOffs(122, 12).addBox(-1.6912F, 12.0775F, -2.2429F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(0.4582F, 7.3186F, -11.0091F);
		Leftfrontlib.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.6779F, 0.6002F, 0.9172F);
		LeftArm_r5.texOffs(124, 12).addBox(-1.7747F, 3.1124F, -2.2429F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(-1.1606F, 6.4973F, -10.6558F);
		Leftfrontlib.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.8335F, 0.2975F, 0.5656F);
		LeftArm_r6.texOffs(120, 2).addBox(-1.1865F, -3.7657F, -2.2429F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(-0.393F, 3.4677F, -6.9372F);
		Leftfrontlib.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -0.8608F, -0.1666F, 0.1639F);
		LeftArm_r7.texOffs(120, 2).addBox(0.1313F, -4.4138F, -2.2429F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r8 = new ModelRenderer(this);
		LeftArm_r8.setPos(2.8957F, 9.0511F, -13.7826F);
		Leftfrontlib.addChild(LeftArm_r8);
		setRotationAngle(LeftArm_r8, -0.6842F, 0.494F, 0.4289F);
		LeftArm_r8.texOffs(124, 11).addBox(-0.8701F, 1.4505F, -2.2095F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r9 = new ModelRenderer(this);
		LeftArm_r9.setPos(2.193F, 10.9341F, -16.3847F);
		Leftfrontlib.addChild(LeftArm_r9);
		setRotationAngle(LeftArm_r9, -0.8016F, 0.2007F, 0.2975F);
		LeftArm_r9.texOffs(124, 11).addBox(-0.4674F, -0.7672F, -2.2099F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		LeftArm_r9.texOffs(124, 11).addBox(-1.4674F, -5.7672F, -2.2099F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r10 = new ModelRenderer(this);
		LeftArm_r10.setPos(3.3558F, 7.8434F, -12.9522F);
		Leftfrontlib.addChild(LeftArm_r10);
		setRotationAngle(LeftArm_r10, -0.8196F, -0.0535F, 0.057F);
		LeftArm_r10.texOffs(124, 11).addBox(-0.6336F, -5.9614F, -2.2099F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r11 = new ModelRenderer(this);
		LeftArm_r11.setPos(0.3084F, 1.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r11);
		setRotationAngle(LeftArm_r11, -0.8745F, -0.4493F, 0.114F);
		LeftArm_r11.texOffs(120, 2).addBox(-0.5121F, -1.1888F, -4.5265F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r12 = new ModelRenderer(this);
		LeftArm_r12.setPos(1.2743F, 8.8434F, -13.3917F);
		Leftfrontlib.addChild(LeftArm_r12);
		setRotationAngle(LeftArm_r12, -0.8071F, 0.1643F, 0.0577F);
		LeftArm_r12.texOffs(124, 11).addBox(-0.769F, -5.9506F, -2.2095F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r13 = new ModelRenderer(this);
		LeftArm_r13.setPos(0.3084F, 2.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r13);
		setRotationAngle(LeftArm_r13, -0.8492F, -0.2324F, 0.1055F);
		LeftArm_r13.texOffs(120, 2).addBox(-0.6393F, -1.2134F, -4.4859F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r14 = new ModelRenderer(this);
		LeftArm_r14.setPos(6.4042F, 5.8592F, -6.8251F);
		Leftfrontlib.addChild(LeftArm_r14);
		setRotationAngle(LeftArm_r14, -0.649F, 0.7759F, 0.8367F);
		LeftArm_r14.texOffs(96, 7).addBox(-2.9919F, 11.3928F, -4.0951F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r15 = new ModelRenderer(this);
		LeftArm_r15.setPos(3.958F, 3.1638F, -3.2644F);
		Leftfrontlib.addChild(LeftArm_r15);
		setRotationAngle(LeftArm_r15, -0.8645F, 0.5029F, 0.4813F);
		LeftArm_r15.texOffs(94, 12).addBox(-2.4908F, 6.7F, -4.0951F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r16 = new ModelRenderer(this);
		LeftArm_r16.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r16);
		setRotationAngle(LeftArm_r16, -0.9609F, 0.12F, 0.1746F);
		LeftArm_r16.texOffs(122, 11).addBox(-1.5808F, -0.8069F, -4.0951F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r17 = new ModelRenderer(this);
		LeftArm_r17.setPos(0.2826F, 7.6205F, -4.3097F);
		Leftfrontlib.addChild(LeftArm_r17);
		setRotationAngle(LeftArm_r17, -0.6276F, 0.6532F, 0.6973F);
		LeftArm_r17.texOffs(97, 8).addBox(-3.8755F, 0.1257F, -8.7581F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r18 = new ModelRenderer(this);
		LeftArm_r18.setPos(0.0F, 7.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r18);
		setRotationAngle(LeftArm_r18, -0.8239F, 0.3297F, 0.2912F);
		LeftArm_r18.texOffs(122, 12).addBox(-2.9991F, -3.5777F, -8.7581F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 10.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.5857F, 0.1676F, 0.4395F);
		RightLeg_r1.texOffs(75, 89).addBox(0.0F, 3.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.605F, 0.045F, 0.258F);
		RightLeg_r2.texOffs(78, 90).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-6.224F, 11.3943F, -4.8532F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, -0.6015F, -0.1664F, -1.8806F);
		RightLeg_r3.texOffs(78, 90).addBox(0.0F, -7.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r3.texOffs(78, 90).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-2.6252F, 1.4955F, -3.161F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, -0.1687F, 0.045F, 0.258F);
		RightLeg_r4.texOffs(78, 90).addBox(-1.877F, 4.6315F, -0.9477F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		RightLeg_r4.texOffs(78, 90).addBox(-2.877F, -10.3685F, -1.9477F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, -0.5236F, 0.0F, 0.0F);
		RightLeg_r5.texOffs(85, 69).addBox(-2.1094F, 6.1834F, -8.6627F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		RightLeg_r5.texOffs(54, 75).addBox(-2.1094F, -3.8166F, -9.6627F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		RightLeg_r5.texOffs(78, 90).addBox(-4.1094F, -12.8166F, -10.6627F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r6 = new ModelRenderer(this);
		RightLeg_r6.setPos(1.9698F, 1.2504F, -1.1762F);
		RightLeg.addChild(RightLeg_r6);
		setRotationAngle(RightLeg_r6, -0.5236F, 0.0F, 0.0F);
		RightLeg_r6.texOffs(85, 69).addBox(-2.1094F, 11.1834F, -9.6627F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightLeg_r7 = new ModelRenderer(this);
		RightLeg_r7.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r7);
		setRotationAngle(RightLeg_r7, -0.9163F, 0.0F, 0.0F);
		RightLeg_r7.texOffs(85, 69).addBox(-2.1094F, 0.1834F, -9.6627F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		RightLeg_r8 = new ModelRenderer(this);
		RightLeg_r8.setPos(1.0327F, 6.189F, 0.0649F);
		RightLeg.addChild(RightLeg_r8);
		setRotationAngle(RightLeg_r8, -0.5219F, 0.0436F, 0.0756F);
		RightLeg_r8.texOffs(56, 67).addBox(-5.1094F, 6.1834F, -5.6627F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r8.texOffs(56, 67).addBox(-4.1094F, 6.1834F, -8.6627F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r9 = new ModelRenderer(this);
		RightLeg_r9.setPos(-5.0078F, 5.2056F, 0.6327F);
		RightLeg.addChild(RightLeg_r9);
		setRotationAngle(RightLeg_r9, -0.338F, -0.4079F, -0.8458F);
		RightLeg_r9.texOffs(56, 67).addBox(-4.1094F, 6.1834F, -8.6627F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r10 = new ModelRenderer(this);
		RightLeg_r10.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r10);
		setRotationAngle(RightLeg_r10, -0.5087F, 0.1298F, 0.228F);
		RightLeg_r10.texOffs(56, 67).addBox(-4.1094F, 1.1834F, -9.6627F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		RightLeg_r11 = new ModelRenderer(this);
		RightLeg_r11.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r11);
		setRotationAngle(RightLeg_r11, -0.0859F, 0.0151F, 0.1739F);
		RightLeg_r11.texOffs(78, 90).addBox(-5.1094F, 0.0365F, -2.3732F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r12 = new ModelRenderer(this);
		RightLeg_r12.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r12);
		setRotationAngle(RightLeg_r12, -0.0873F, 0.0F, 0.0F);
		RightLeg_r12.texOffs(78, 90).addBox(-3.1094F, 0.0365F, -2.3732F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		RightLeg_r12.texOffs(78, 90).addBox(-4.1094F, -14.9635F, -2.3732F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r13 = new ModelRenderer(this);
		RightLeg_r13.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r13);
		setRotationAngle(RightLeg_r13, -0.0436F, 1.3526F, -0.2618F);
		RightLeg_r13.texOffs(78, 90).addBox(-0.75F, -5.5358F, -0.8406F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r14 = new ModelRenderer(this);
		RightLeg_r14.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r14);
		setRotationAngle(RightLeg_r14, 0.1309F, 1.3526F, -0.2618F);
		RightLeg_r14.texOffs(78, 90).addBox(-0.75F, 0.4696F, -0.0973F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r15 = new ModelRenderer(this);
		RightLeg_r15.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r15);
		setRotationAngle(RightLeg_r15, -0.1605F, -0.4269F, 0.6748F);
		RightLeg_r15.texOffs(78, 90).addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r16 = new ModelRenderer(this);
		RightLeg_r16.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r16);
		setRotationAngle(RightLeg_r16, 0.1309F, -0.4363F, 0.0F);
		RightLeg_r16.texOffs(78, 90).addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r17 = new ModelRenderer(this);
		RightLeg_r17.setPos(-5.4837F, 10.8326F, 3.6585F);
		RightLeg.addChild(RightLeg_r17);
		setRotationAngle(RightLeg_r17, 0.3054F, -0.4363F, 0.0F);
		RightLeg_r17.texOffs(78, 90).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		RightLeg_r18 = new ModelRenderer(this);
		RightLeg_r18.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r18);
		setRotationAngle(RightLeg_r18, -0.0436F, -0.4363F, 0.0F);
		RightLeg_r18.texOffs(78, 90).addBox(-1.0F, 4.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r19 = new ModelRenderer(this);
		RightLeg_r19.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r19);
		setRotationAngle(RightLeg_r19, 0.1815F, -1.1101F, 0.0283F);
		RightLeg_r19.texOffs(78, 90).addBox(-2.0F, -9.5F, -3.0F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		RightLeg_r20 = new ModelRenderer(this);
		RightLeg_r20.setPos(-1.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r20);
		setRotationAngle(RightLeg_r20, 0.1309F, 0.0F, 0.0F);
		RightLeg_r20.texOffs(78, 90).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r21 = new ModelRenderer(this);
		RightLeg_r21.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r21);
		setRotationAngle(RightLeg_r21, -0.0436F, 0.0F, 0.0F);
		RightLeg_r21.texOffs(78, 90).addBox(-2.0F, 4.5F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r22 = new ModelRenderer(this);
		RightLeg_r22.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r22);
		setRotationAngle(RightLeg_r22, 0.2618F, 0.0F, 0.0F);
		RightLeg_r22.texOffs(78, 90).addBox(-2.0F, -9.5F, -2.0F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 9.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -0.121F, -0.05F, -0.3897F);
		LeftLeg_r1.texOffs(101, 92).addBox(1.191F, -10.1017F, -0.9016F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 3.0256F, 0.3201F, 2.7968F);
		LeftLeg_r2.texOffs(96, 35).addBox(0.0F, 0.3499F, 0.3587F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, -2.9871F, 0.2874F, 3.1152F);
		LeftLeg_r3.texOffs(101, 92).addBox(-3.0F, -0.782F, 0.134F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg_r4 = new ModelRenderer(this);
		LeftLeg_r4.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r4);
		setRotationAngle(LeftLeg_r4, -3.0831F, 0.3201F, 2.7968F);
		LeftLeg_r4.texOffs(101, 92).addBox(-3.0F, -7.782F, 0.134F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		LeftLeg_r4.texOffs(101, 92).addBox(-1.0F, -6.782F, 0.134F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		LeftLeg_r5 = new ModelRenderer(this);
		LeftLeg_r5.setPos(-3.3457F, 4.7914F, -7.1957F);
		LeftLeg.addChild(LeftLeg_r5);
		setRotationAngle(LeftLeg_r5, 0.2696F, -0.0447F, -0.3463F);
		LeftLeg_r5.texOffs(101, 92).addBox(4.0764F, 3.7056F, 0.1816F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r6 = new ModelRenderer(this);
		LeftLeg_r6.setPos(6.0333F, 14.8874F, -3.0176F);
		LeftLeg.addChild(LeftLeg_r6);
		setRotationAngle(LeftLeg_r6, -0.9249F, 0.4264F, -0.8026F);
		LeftLeg_r6.texOffs(101, 92).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r7 = new ModelRenderer(this);
		LeftLeg_r7.setPos(-3.2859F, 5.2417F, -5.0329F);
		LeftLeg.addChild(LeftLeg_r7);
		setRotationAngle(LeftLeg_r7, 0.0951F, -0.0447F, -0.3463F);
		LeftLeg_r7.texOffs(101, 92).addBox(5.0764F, 10.8488F, 0.0984F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r8 = new ModelRenderer(this);
		LeftLeg_r8.setPos(-2.0081F, 5.5409F, -6.2858F);
		LeftLeg.addChild(LeftLeg_r8);
		setRotationAngle(LeftLeg_r8, -0.1289F, -0.0227F, -0.1731F);
		LeftLeg_r8.texOffs(101, 92).addBox(-0.0201F, 8.6387F, -0.9016F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r9 = new ModelRenderer(this);
		LeftLeg_r9.setPos(0.9033F, 3.9141F, -6.1711F);
		LeftLeg.addChild(LeftLeg_r9);
		setRotationAngle(LeftLeg_r9, -0.2382F, 0.1621F, 0.9915F);
		LeftLeg_r9.texOffs(122, 54).addBox(-3.0201F, 5.6387F, -1.9016F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r10 = new ModelRenderer(this);
		LeftLeg_r10.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r10);
		setRotationAngle(LeftLeg_r10, -0.275F, 0.084F, 0.6939F);
		LeftLeg_r10.texOffs(114, 64).addBox(-3.0201F, -2.3613F, -2.9016F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r11 = new ModelRenderer(this);
		LeftLeg_r11.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r11);
		setRotationAngle(LeftLeg_r11, -0.1308F, 0.0057F, 0.0433F);
		LeftLeg_r11.texOffs(101, 92).addBox(-0.0201F, 3.6387F, -1.9016F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r12 = new ModelRenderer(this);
		LeftLeg_r12.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r12);
		setRotationAngle(LeftLeg_r12, -0.1278F, -0.0283F, -0.2164F);
		LeftLeg_r12.texOffs(101, 92).addBox(-1.2789F, -10.269F, -2.9016F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r13 = new ModelRenderer(this);
		LeftLeg_r13.setPos(-2.8778F, 11.009F, 8.8684F);
		LeftLeg.addChild(LeftLeg_r13);
		setRotationAngle(LeftLeg_r13, -0.2818F, -0.0458F, -0.0047F);
		LeftLeg_r13.texOffs(112, 109).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg_r14 = new ModelRenderer(this);
		LeftLeg_r14.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r14);
		setRotationAngle(LeftLeg_r14, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r14.texOffs(112, 109).addBox(5.6284F, 5.0674F, 7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		LeftLeg_r14.texOffs(112, 109).addBox(5.6284F, 7.0674F, 7.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg_r14.texOffs(112, 109).addBox(5.6284F, 3.0674F, 6.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r15 = new ModelRenderer(this);
		LeftLeg_r15.setPos(6.6774F, 10.511F, 6.5659F);
		LeftLeg.addChild(LeftLeg_r15);
		setRotationAngle(LeftLeg_r15, -0.0915F, 0.5398F, -1.2653F);
		LeftLeg_r15.texOffs(102, 23).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		LeftLeg_r15.texOffs(100, 23).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		LeftLeg_r16 = new ModelRenderer(this);
		LeftLeg_r16.setPos(-3.7346F, 9.2118F, 7.4768F);
		LeftLeg.addChild(LeftLeg_r16);
		setRotationAngle(LeftLeg_r16, 0.2441F, 0.7634F, -0.1541F);
		LeftLeg_r16.texOffs(113, 66).addBox(4.6284F, 3.0674F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r17 = new ModelRenderer(this);
		LeftLeg_r17.setPos(-2.6153F, 12.9096F, 9.4445F);
		LeftLeg.addChild(LeftLeg_r17);
		setRotationAngle(LeftLeg_r17, 0.1356F, -0.2792F, 1.5097F);
		LeftLeg_r17.texOffs(113, 66).addBox(-1.0F, 2.5F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r18 = new ModelRenderer(this);
		LeftLeg_r18.setPos(-2.6793F, 11.3583F, 8.9952F);
		LeftLeg.addChild(LeftLeg_r18);
		setRotationAngle(LeftLeg_r18, 0.257F, -0.1746F, 0.9826F);
		LeftLeg_r18.texOffs(113, 66).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r19 = new ModelRenderer(this);
		LeftLeg_r19.setPos(2.4477F, 7.2158F, 5.8952F);
		LeftLeg.addChild(LeftLeg_r19);
		setRotationAngle(LeftLeg_r19, 1.0504F, 0.0524F, 0.8515F);
		LeftLeg_r19.texOffs(113, 66).addBox(-1.0F, -2.5F, -3.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r20 = new ModelRenderer(this);
		LeftLeg_r20.setPos(-3.0047F, 9.9526F, 6.5206F);
		LeftLeg.addChild(LeftLeg_r20);
		setRotationAngle(LeftLeg_r20, 0.375F, 0.7634F, -0.1541F);
		LeftLeg_r20.texOffs(113, 66).addBox(3.6284F, -3.9326F, 3.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r21 = new ModelRenderer(this);
		LeftLeg_r21.setPos(-4.7346F, 9.2118F, 1.4768F);
		LeftLeg.addChild(LeftLeg_r21);
		setRotationAngle(LeftLeg_r21, 0.4241F, -0.5792F, -0.1329F);
		LeftLeg_r21.texOffs(113, 66).addBox(4.6284F, 3.0674F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r22 = new ModelRenderer(this);
		LeftLeg_r22.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r22);
		setRotationAngle(LeftLeg_r22, 0.555F, -0.5792F, -0.1329F);
		LeftLeg_r22.texOffs(113, 66).addBox(3.6284F, -3.9326F, 2.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r23 = new ModelRenderer(this);
		LeftLeg_r23.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r23);
		setRotationAngle(LeftLeg_r23, 0.5151F, -0.8108F, -0.4443F);
		LeftLeg_r23.texOffs(112, 109).addBox(5.6284F, -17.9326F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftLeg_r24 = new ModelRenderer(this);
		LeftLeg_r24.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r24);
		setRotationAngle(LeftLeg_r24, -0.0363F, 0.3309F, -0.1175F);
		LeftLeg_r24.texOffs(112, 109).addBox(4.6284F, 2.0674F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg_r24.texOffs(112, 109).addBox(3.6284F, -5.9326F, -4.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r25 = new ModelRenderer(this);
		LeftLeg_r25.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r25);
		setRotationAngle(LeftLeg_r25, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r25.texOffs(112, 109).addBox(1.6284F, -5.9326F, 1.0F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r26 = new ModelRenderer(this);
		LeftLeg_r26.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r26);
		setRotationAngle(LeftLeg_r26, 0.3532F, 0.1942F, -0.1118F);
		LeftLeg_r26.texOffs(112, 109).addBox(5.6284F, -18.9326F, 3.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.2F * limbSwingAmount;
		this.LeftLeg.yRot = MathHelper.cos(limbSwing * 0.5662F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.2F * limbSwingAmount;
		this.RightLeg.yRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.6F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.wingDown.yRot = netHeadYaw * 0.007453292F;
		this.wing3.yRot = netHeadYaw * 0.014453292F;
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