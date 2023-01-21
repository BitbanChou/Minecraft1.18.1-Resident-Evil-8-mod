// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMiranda3;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMiranda3<T extends EntityMiranda3> extends EntityModel<T> {
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
	private final ModelRenderer wingp_r14;
	private final ModelRenderer wingp_r15;
	private final ModelRenderer wingp_r16;
	private final ModelRenderer wingp_r17;
	private final ModelRenderer wingp_r18;
	private final ModelRenderer wingp_r19;
	private final ModelRenderer wingp_r20;
	private final ModelRenderer wing3;
	private final ModelRenderer wingp_r21;
	private final ModelRenderer wingp_r22;
	private final ModelRenderer wingp_r23;
	private final ModelRenderer wingp_r24;
	private final ModelRenderer wingp_r25;
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
	private final ModelRenderer wingp_r37;
	private final ModelRenderer wingp_r38;
	private final ModelRenderer wing4;
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
	private final ModelRenderer wingp_r49;
	private final ModelRenderer wingp_r50;
	private final ModelRenderer wingp_r51;
	private final ModelRenderer wingp_r52;
	private final ModelRenderer wingp_r53;
	private final ModelRenderer wingp_r54;
	private final ModelRenderer wingp_r55;
	private final ModelRenderer wing2;
	private final ModelRenderer wingp_r56;
	private final ModelRenderer wingp_r57;
	private final ModelRenderer wingp_r58;
	private final ModelRenderer wingp_r59;
	private final ModelRenderer wingp_r60;
	private final ModelRenderer wingp_r61;
	private final ModelRenderer wingp_r62;
	private final ModelRenderer wingp_r63;
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
	private final ModelRenderer wingp_r75;
	private final ModelRenderer wingp_r76;
	private final ModelRenderer wingp_r77;
	private final ModelRenderer wingDown;
	private final ModelRenderer wingp_r78;
	private final ModelRenderer wingp_r79;
	private final ModelRenderer wingp_r80;
	private final ModelRenderer wingp_r81;
	private final ModelRenderer wingp_r82;
	private final ModelRenderer wingp_r83;
	private final ModelRenderer wingp_r84;
	private final ModelRenderer wingp_r85;
	private final ModelRenderer wingp_r86;
	private final ModelRenderer wingp_r87;
	private final ModelRenderer wingp_r88;
	private final ModelRenderer wingp_r89;
	private final ModelRenderer wingp_r90;
	private final ModelRenderer wingp_r91;
	private final ModelRenderer wingp_r92;
	private final ModelRenderer wingp_r93;
	private final ModelRenderer wingp_r94;
	private final ModelRenderer wingp_r95;
	private final ModelRenderer wingp_r96;
	private final ModelRenderer wingp_r97;
	private final ModelRenderer wingp_r98;
	private final ModelRenderer wingp_r99;
	private final ModelRenderer wingp_r100;
	private final ModelRenderer wingp_r101;
	private final ModelRenderer wingp_r102;
	private final ModelRenderer wingp_r103;
	private final ModelRenderer wingp_r104;
	private final ModelRenderer wingp_r105;
	private final ModelRenderer wingp_r106;
	private final ModelRenderer wingp_r107;
	private final ModelRenderer wingp_r108;
	private final ModelRenderer wingp_r109;
	private final ModelRenderer wingDown2;
	private final ModelRenderer wingp_r110;
	private final ModelRenderer wingp_r111;
	private final ModelRenderer wingp_r112;
	private final ModelRenderer wingp_r113;
	private final ModelRenderer wingp_r114;
	private final ModelRenderer wingp_r115;
	private final ModelRenderer wingp_r116;
	private final ModelRenderer wingp_r117;
	private final ModelRenderer wingp_r118;
	private final ModelRenderer wingp_r119;
	private final ModelRenderer wingp_r120;
	private final ModelRenderer wingp_r121;
	private final ModelRenderer wingp_r122;
	private final ModelRenderer wingp_r123;
	private final ModelRenderer wingp_r124;
	private final ModelRenderer wingp_r125;
	private final ModelRenderer wingp_r126;
	private final ModelRenderer wingp_r127;
	private final ModelRenderer wingp_r128;
	private final ModelRenderer wingp_r129;
	private final ModelRenderer wingp_r130;
	private final ModelRenderer wingp_r131;
	private final ModelRenderer wingp_r132;
	private final ModelRenderer wingp_r133;
	private final ModelRenderer wingp_r134;
	private final ModelRenderer wingp_r135;
	private final ModelRenderer wingp_r136;
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
	private final ModelRenderer RightLeg_r23;
	private final ModelRenderer RightLeg_r24;
	private final ModelRenderer RightLeg_r25;
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
	private final ModelRenderer LeftLeg_r27;
	private final ModelRenderer LeftLeg_r28;
	private final ModelRenderer LeftLeg_r29;
	private final ModelRenderer LeftLeg_r30;
	private final ModelRenderer LeftLeg_r31;
	private final ModelRenderer LeftLeg_r32;
	private final ModelRenderer LeftLeg_r33;
	private final ModelRenderer LeftLeg_r34;
	private final ModelRenderer LeftLeg_r35;

	public ModelMiranda3() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(-0.4444F, -29.0556F, -3.3889F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(2.3175F, 1.5218F, 5.1602F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.1309F, -1.5708F);
		Head_r1.texOffs(38, 5).addBox(8.9966F, -4.9993F, -7.6859F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-2.9267F, 5.2661F, -1.9904F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.0172F, -0.1298F, 1.7028F);
		Head_r2.texOffs(28, 6).addBox(-11.4111F, 1.8048F, -0.2382F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-2.6633F, 6.6949F, -1.8023F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.1304F, -0.0114F, 3.0551F);
		Head_r3.texOffs(28, 10).addBox(-3.3713F, 11.4585F, -0.2382F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Head_r3.texOffs(26, 13).addBox(-3.3713F, 10.4585F, -0.2382F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(2.1047F, 3.1438F, -2.1382F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.0503F, 0.1209F, -1.9665F);
		Head_r4.texOffs(40, 7).addBox(6.7356F, 4.3255F, -0.2382F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-0.9848F, 3.0527F, -2.7691F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.4002F, -0.0539F, 1.8047F);
		Head_r5.texOffs(26, 8).addBox(-11.2166F, 5.4196F, -2.1795F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-4.8558F, 1.448F, 0.2526F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.0401F, -0.4463F, 1.8201F);
		Head_r6.texOffs(26, 3).addBox(-10.1449F, 1.5975F, 2.3128F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(4.7447F, 1.448F, 0.2526F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.0401F, 0.4463F, -1.8201F);
		Head_r7.texOffs(27, 0).addBox(8.1449F, 1.5975F, 2.3128F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(0.8737F, 3.0527F, -2.7691F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 0.4002F, 0.0539F, -1.8047F);
		Head_r8.texOffs(45, 12).addBox(8.2166F, 5.4196F, -2.1795F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(2.5521F, 6.6949F, -1.8023F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, -0.1304F, 0.0114F, -3.0551F);
		Head_r9.texOffs(28, 12).addBox(-0.6287F, 10.4585F, -0.2382F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r9.texOffs(22, 18).addBox(-1.6287F, 11.4585F, -0.2382F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-3.0404F, 2.2061F, 5.2503F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.1074F, -0.0749F, 2.5348F);
		Head_r10.texOffs(37, 8).addBox(-12.7338F, 4.1894F, -7.6859F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(-0.5556F, 8.0227F, 6.0161F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, 0.1188F, -0.0552F, 0.4331F);
		Head_r11.texOffs(23, 2).addBox(-11.2247F, -14.0593F, -7.6859F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(0.4444F, 9.0227F, 6.0161F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.1309F, 0.0F, 0.0F);
		Head_r12.texOffs(0, 62).addBox(-5.0F, -19.9959F, -6.6859F, 9.0F, 9.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(44, 7).addBox(-6.0F, -28.0F, -6.0F, 12.0F, 12.0F, 11.0F, 0.0F, false);
		Body.texOffs(44, 7).addBox(-5.0F, -29.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Body.texOffs(86, 109).addBox(-3.0F, -23.0F, 5.0F, 5.0F, 7.0F, 2.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-6.0F, -16.0F, -6.0F, 11.0F, 8.0F, 9.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-5.0F, -8.0F, -5.0F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		Body.texOffs(52, 60).addBox(-2.3856F, -7.2398F, -6.2446F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(-3.0F, -6.0F, -1.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.4363F, -0.5672F, 0.0F);
		Body_r1.texOffs(51, 54).addBox(-4.0F, -3.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(3.0F, -6.0F, -1.5F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.4363F, 0.5672F, 0.0F);
		Body_r2.texOffs(51, 54).addBox(0.0F, -3.0F, -3.5F, 3.0F, 4.0F, 7.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(3.5F, -12.0F, -10.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, 0.3927F);
		Body_r3.texOffs(69, 50).addBox(-1.5F, 0.0F, 3.5F, 3.0F, 8.0F, 3.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(-3.5F, -12.0F, -10.5F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.0F, -0.3927F);
		Body_r4.texOffs(69, 50).addBox(-1.5F, 0.0F, 3.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(0.0F, -26.0F, -0.5F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.0436F, 0.0F);
		Body_r5.texOffs(2, 47).addBox(-2.0F, -6.0F, -3.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(0.5F, -22.0F, -3.5F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.6109F, 0.0F, 0.0F);
		Body_r6.texOffs(44, 7).addBox(1.0F, -4.0F, -3.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);
		Body_r6.texOffs(44, 7).addBox(-4.7F, -4.0F, -3.5F, 3.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-0.5F, -28.5F, 5.0F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.3927F, 0.0F, 0.0F);
		Body_r7.texOffs(86, 109).addBox(-2.5F, -0.5F, -1.0F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		circle = new ModelRenderer(this);
		circle.setPos(-0.1203F, -20.1391F, 5.0F);
		Body.addChild(circle);
		circle.texOffs(44, 0).addBox(-1.6529F, -14.4852F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(3.7403F, -10.2461F, 0.0F);
		circle.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.0F, 3.0543F);
		Body_r8.texOffs(44, 0).addBox(1.5F, -2.0F, 0.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r8.texOffs(44, 0).addBox(1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-5.4996F, -10.2461F, 0.0F);
		circle.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.0F, -3.0543F);
		Body_r9.texOffs(44, 0).addBox(-5.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(3.27F, -10.6594F, 0.0F);
		circle.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, 2.7053F);
		Body_r10.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(13.2609F, -22.5389F, -0.5F);
		circle.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.0F, -2.3998F);
		Body_r11.texOffs(44, 0).addBox(8.0F, -2.322F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(8.0F, -4.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(9.0F, -0.722F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(12.7023F, -20.4394F, -0.5F);
		circle.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.0F, -2.2253F);
		Body_r12.texOffs(44, 0).addBox(5.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(13.2743F, -14.3363F, -0.5F);
		circle.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, -1.9199F);
		Body_r13.texOffs(44, 0).addBox(5.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(10.7615F, -16.7378F, -0.5F);
		circle.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, -1.309F);
		Body_r14.texOffs(44, 0).addBox(-3.0F, -1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-0.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, -0.2618F, 0.9599F);
		Body_r15.texOffs(44, 0).addBox(-1.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.2137F, 0.0211F, -0.0118F);
		Body_r16.texOffs(41, 2).addBox(-4.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.2618F, -0.9599F);
		Body_r17.texOffs(44, 0).addBox(-4.0F, 3.5F, 0.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.0F, -0.9599F);
		Body_r18.texOffs(44, 0).addBox(5.0F, 4.5F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(-2.0F, 4.5F, -2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(-1.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(1.1343F, -12.6419F, 0.0F);
		circle.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, -1.1345F);
		Body_r19.texOffs(44, 0).addBox(-1.0F, 6.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(7.6254F, -18.3427F, 0.0F);
		circle.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, -1.5272F);
		Body_r20.texOffs(44, 0).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(5.2466F, -13.7737F, -0.5F);
		circle.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 0.6981F);
		Body_r21.texOffs(44, 0).addBox(-3.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(5.9307F, -15.6531F, -0.5F);
		circle.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 0.3491F);
		Body_r22.texOffs(44, 0).addBox(-3.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(9.4785F, -23.1806F, -0.5F);
		circle.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, -0.6545F);
		Body_r23.texOffs(44, 0).addBox(-2.5F, -1.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(2.7341F, -20.7797F, -5.0F);
		circle.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, -0.1309F);
		Body_r24.texOffs(44, 0).addBox(5.5F, 2.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r24.texOffs(44, 0).addBox(0.5F, 2.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(2.7341F, -20.7797F, -5.0F);
		circle.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, -0.9599F);
		Body_r25.texOffs(44, 0).addBox(3.5F, -1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r25.texOffs(44, 0).addBox(-0.5F, 0.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-5.0059F, -13.7737F, -0.5F);
		circle.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, -0.6981F);
		Body_r26.texOffs(44, 0).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-1.7797F, 25.5909F, -10.8791F);
		circle.addChild(Body_r27);
		setRotationAngle(Body_r27, -0.1441F, -0.084F, -0.6939F);
		Body_r27.texOffs(114, 64).addBox(5.0201F, -14.3613F, 4.0984F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(2.0203F, 25.5909F, -10.8791F);
		circle.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.1441F, 0.084F, 0.6939F);
		Body_r28.texOffs(114, 64).addBox(-10.0201F, -12.3613F, 5.0984F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-5.69F, -15.6531F, -0.5F);
		circle.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, -0.3491F);
		Body_r29.texOffs(44, 0).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-8.7421F, -23.1153F, -0.5F);
		circle.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.0F, 0.6109F);
		Body_r30.texOffs(44, 0).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r30.texOffs(44, 0).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-2.4935F, -20.7797F, -5.0F);
		circle.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.0F, 0.1309F);
		Body_r31.texOffs(44, 0).addBox(-4.5F, 2.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-2.4935F, -20.7797F, -5.0F);
		circle.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.0F, 0.9599F);
		Body_r32.texOffs(44, 0).addBox(-3.5F, 1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(-0.5532F, -21.1868F, -5.0F);
		circle.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, 0.0F, 3.0107F);
		Body_r33.texOffs(44, 0).addBox(-0.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-8.6239F, -17.1063F, 0.0F);
		circle.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.0F, 1.789F);
		Body_r34.texOffs(44, 0).addBox(-4.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r34.texOffs(44, 0).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(4.1591F, -16.6553F, -0.5F);
		circle.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.0F, -1.6581F);
		Body_r35.texOffs(44, 0).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(-3.9185F, -16.6553F, -0.5F);
		circle.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, 0.0F, 1.6581F);
		Body_r36.texOffs(44, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-3.5549F, -15.5447F, -0.5F);
		circle.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0F, 1.0908F);
		Body_r37.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(2.7955F, -15.5447F, -0.5F);
		circle.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, 0.0F, -1.0908F);
		Body_r38.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(7.8646F, -17.1063F, 0.0F);
		circle.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, -1.789F);
		Body_r39.texOffs(44, 0).addBox(2.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r39.texOffs(44, 0).addBox(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(3.7365F, -21.413F, 0.0F);
		circle.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0F, 0.0F, -2.3126F);
		Body_r40.texOffs(46, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-0.4869F, -25.7504F, -1.0F);
		circle.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0F, 0.0F, -2.4435F);
		Body_r41.texOffs(44, 0).addBox(-1.5F, -3.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(0.7276F, -25.7504F, -1.0F);
		circle.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0F, 0.0F, 2.4435F);
		Body_r42.texOffs(44, 0).addBox(-1.5F, -2.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-0.5073F, -25.301F, -1.0F);
		circle.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0F, 0.0F, -2.3562F);
		Body_r43.texOffs(0, 0).addBox(-1.7F, -2.2F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-0.5073F, -25.301F, -1.0F);
		circle.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0F, 0.0F, -3.1416F);
		Body_r44.texOffs(114, 2).addBox(-3.0723F, -11.2F, 0.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-1.5F, -4.2F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-0.2062F, -21.1868F, -5.0F);
		circle.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0F, 0.0F, -3.0107F);
		Body_r45.texOffs(44, 0).addBox(-1.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(2.2407F, -25.0F, 0.0F);
		circle.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0F, 0.0F, -2.9234F);
		Body_r46.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(-1.3234F, -23.7391F, 0.0F);
		circle.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0F, 0.0F, 2.4871F);
		Body_r47.texOffs(44, 0).addBox(-3.0F, 7.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-1.3234F, -23.7391F, 0.0F);
		circle.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0F, 0.0F, 2.7053F);
		Body_r48.texOffs(44, 0).addBox(-2.0F, 5.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-4.5602F, -21.7872F, 0.0F);
		circle.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.0F, 0.0F, 2.1817F);
		Body_r49.texOffs(44, 0).addBox(-3.0F, 5.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(-4.4958F, -21.413F, 0.0F);
		circle.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0F, 0.0F, 2.3126F);
		Body_r50.texOffs(44, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(-4.0293F, -10.6594F, 0.0F);
		circle.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0F, 0.0F, -2.7053F);
		Body_r51.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(-7.3827F, -18.9242F, 0.0F);
		circle.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0F, 0.0F, 1.6581F);
		Body_r52.texOffs(44, 0).addBox(-4.0F, 3.0F, -1.0F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-8.3847F, -18.3427F, 0.0F);
		circle.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0F, 0.0F, 1.5272F);
		Body_r53.texOffs(44, 0).addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-2.5283F, -16.2157F, 0.0F);
		circle.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0F, 0.0F, 1.3963F);
		Body_r54.texOffs(44, 0).addBox(-5.0F, 7.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-1.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0F, 0.0F, 1.2654F);
		Body_r55.texOffs(44, 0).addBox(-5.0F, 6.5F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-1.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0F, 0.0F, 0.9599F);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 4.5F, -2.0F, 6.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 6.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-5.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-3.0F, -25.0F, 0.0F);
		circle.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0F, 0.0F, 2.9234F);
		Body_r57.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wing = new ModelRenderer(this);
		wing.setPos(8.0F, -11.0F, 5.0F);
		Body.addChild(wing);
		setRotationAngle(wing, 0.0F, 0.0F, -0.0873F);
		wing.texOffs(71, 46).addBox(-0.2959F, -14.5893F, 0.0F, 8.0F, 7.0F, 3.0F, 0.0F, false);
		wing.texOffs(90, 103).addBox(-5.2959F, -11.5893F, 0.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		wingp_r1 = new ModelRenderer(this);
		wingp_r1.setPos(34.2573F, -10.2751F, -4.3664F);
		wing.addChild(wingp_r1);
		setRotationAngle(wingp_r1, -0.064F, 0.1397F, 0.5531F);
		wingp_r1.texOffs(112, 59).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r2 = new ModelRenderer(this);
		wingp_r2.setPos(33.2039F, -8.217F, -6.0051F);
		wing.addChild(wingp_r2);
		setRotationAngle(wingp_r2, -0.0961F, 0.3099F, 0.4101F);
		wingp_r2.texOffs(96, 46).addBox(0.0F, -2.0F, 0.5F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		wingp_r3 = new ModelRenderer(this);
		wingp_r3.setPos(33.2039F, -8.217F, -6.0051F);
		wing.addChild(wingp_r3);
		setRotationAngle(wingp_r3, -0.8349F, 0.2947F, 0.2739F);
		wingp_r3.texOffs(96, 46).addBox(-7.0F, -2.0F, -0.5F, 10.0F, 4.0F, 2.0F, 0.0F, false);

		wingp_r4 = new ModelRenderer(this);
		wingp_r4.setPos(28.2039F, -12.217F, -5.0051F);
		wing.addChild(wingp_r4);
		setRotationAngle(wingp_r4, -0.8349F, 0.2947F, 0.2739F);
		wingp_r4.texOffs(96, 46).addBox(-7.0F, -2.0F, -0.5F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r5 = new ModelRenderer(this);
		wingp_r5.setPos(26.1821F, -3.5878F, -5.6462F);
		wing.addChild(wingp_r5);
		setRotationAngle(wingp_r5, 0.0814F, 0.2947F, 0.2739F);
		wingp_r5.texOffs(90, 46).addBox(-3.5564F, -9.3581F, -0.2641F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r6 = new ModelRenderer(this);
		wingp_r6.setPos(15.9126F, -0.7489F, -2.7702F);
		wing.addChild(wingp_r6);
		setRotationAngle(wingp_r6, 0.0547F, 0.3006F, 0.1828F);
		wingp_r6.texOffs(51, 57).addBox(1.2768F, -14.2791F, 0.0811F, 6.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r7 = new ModelRenderer(this);
		wingp_r7.setPos(17.4382F, -0.7522F, -3.2512F);
		wing.addChild(wingp_r7);
		setRotationAngle(wingp_r7, 0.1074F, 0.2865F, 0.3646F);
		wingp_r7.texOffs(113, 75).addBox(-2.7826F, -11.6599F, 0.0811F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r8 = new ModelRenderer(this);
		wingp_r8.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r8);
		setRotationAngle(wingp_r8, 0.1074F, 0.2865F, 0.3646F);
		wingp_r8.texOffs(112, 74).addBox(4.7174F, -13.1599F, -0.4189F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r9 = new ModelRenderer(this);
		wingp_r9.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r9);
		setRotationAngle(wingp_r9, -0.0411F, 0.3027F, -0.1372F);
		wingp_r9.texOffs(69, 60).addBox(6.3593F, -9.8964F, -0.4189F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r10 = new ModelRenderer(this);
		wingp_r10.setPos(14.6643F, 3.5971F, -2.9009F);
		wing.addChild(wingp_r10);
		setRotationAngle(wingp_r10, 0.1896F, 0.2409F, 0.6775F);
		wingp_r10.texOffs(50, 78).addBox(-9.1831F, -10.9339F, 0.5811F, 5.0F, 4.0F, 2.0F, 0.0F, false);

		wingp_r11 = new ModelRenderer(this);
		wingp_r11.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r11);
		setRotationAngle(wingp_r11, 0.1325F, 0.276F, 0.4548F);
		wingp_r11.texOffs(44, 66).addBox(-1.2901F, -10.214F, -0.4189F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r12 = new ModelRenderer(this);
		wingp_r12.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r12);
		setRotationAngle(wingp_r12, 0.1564F, 0.2635F, 0.5444F);
		wingp_r12.texOffs(54, 49).addBox(1.7274F, -8.5864F, -0.4189F, 4.0F, 6.0F, 2.0F, 0.0F, false);
		wingp_r12.texOffs(75, 47).addBox(-6.2726F, -8.5864F, -0.4189F, 9.0F, 6.0F, 2.0F, 0.0F, false);

		wingp_r13 = new ModelRenderer(this);
		wingp_r13.setPos(3.7336F, 4.9445F, 1.0698F);
		wing.addChild(wingp_r13);
		setRotationAngle(wingp_r13, 0.2835F, -0.1153F, 1.947F);
		wingp_r13.texOffs(48, 77).addBox(-12.0492F, 4.689F, -0.9189F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r14 = new ModelRenderer(this);
		wingp_r14.setPos(8.9342F, 4.2266F, -0.5699F);
		wing.addChild(wingp_r14);
		setRotationAngle(wingp_r14, 0.303F, 0.0393F, 1.4459F);
		wingp_r14.texOffs(47, 76).addBox(-9.8964F, 0.6407F, 0.0811F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r15 = new ModelRenderer(this);
		wingp_r15.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r15);
		setRotationAngle(wingp_r15, -0.1074F, 0.2865F, -0.3646F);
		wingp_r15.texOffs(79, 59).addBox(2.7463F, -7.8992F, -0.4189F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		wingp_r16 = new ModelRenderer(this);
		wingp_r16.setPos(29.2573F, -14.2751F, -3.3664F);
		wing.addChild(wingp_r16);
		setRotationAngle(wingp_r16, -0.064F, 0.1397F, 0.5531F);
		wingp_r16.texOffs(112, 59).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r17 = new ModelRenderer(this);
		wingp_r17.setPos(23.5622F, -15.9742F, -2.6595F);
		wing.addChild(wingp_r17);
		setRotationAngle(wingp_r17, -0.1253F, 0.089F, 0.0284F);
		wingp_r17.texOffs(110, 47).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r18 = new ModelRenderer(this);
		wingp_r18.setPos(8.3321F, -0.3519F, 0.1442F);
		wing.addChild(wingp_r18);
		setRotationAngle(wingp_r18, -0.1309F, 0.3054F, 0.0F);
		wingp_r18.texOffs(83, 49).addBox(4.843F, -17.2374F, -1.4189F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r19 = new ModelRenderer(this);
		wingp_r19.setPos(8.3321F, -0.3519F, 0.1442F);
		wing.addChild(wingp_r19);
		setRotationAngle(wingp_r19, 0.0F, 0.3054F, 0.0F);
		wingp_r19.texOffs(53, 55).addBox(4.843F, -14.2374F, -0.4189F, 7.0F, 3.0F, 2.0F, 0.0F, false);
		wingp_r19.texOffs(76, 92).addBox(-1.157F, -14.2374F, -0.4189F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wingp_r20 = new ModelRenderer(this);
		wingp_r20.setPos(8.4083F, -0.2592F, 0.3859F);
		wing.addChild(wingp_r20);
		setRotationAngle(wingp_r20, 0.0F, 0.3054F, 0.0F);
		wingp_r20.texOffs(72, 48).addBox(-1.157F, -17.2374F, -0.4189F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wing3 = new ModelRenderer(this);
		wing3.setPos(3.0F, -18.0F, 7.0F);
		Body.addChild(wing3);
		setRotationAngle(wing3, -0.0114F, -0.0865F, -0.7413F);
		wing3.texOffs(0, 116).addBox(8.0697F, -6.6961F, -1.6818F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wing3.texOffs(1, 119).addBox(0.0697F, -6.6961F, -1.6818F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r21 = new ModelRenderer(this);
		wingp_r21.setPos(31.5943F, -0.8941F, -6.1494F);
		wing3.addChild(wingp_r21);
		setRotationAngle(wingp_r21, -0.0138F, 0.3051F, -0.0457F);
		wingp_r21.texOffs(88, 86).addBox(0.0F, -2.5F, -0.5F, 8.0F, 7.0F, 1.0F, 0.0F, false);

		wingp_r22 = new ModelRenderer(this);
		wingp_r22.setPos(31.5943F, -0.8941F, -6.1494F);
		wing3.addChild(wingp_r22);
		setRotationAngle(wingp_r22, 0.1201F, 0.2815F, 0.4097F);
		wingp_r22.texOffs(88, 86).addBox(-6.0F, -2.5F, -0.5F, 8.0F, 5.0F, 1.0F, 0.0F, false);

		wingp_r23 = new ModelRenderer(this);
		wingp_r23.setPos(19.0477F, 3.5548F, -4.3725F);
		wing3.addChild(wingp_r23);
		setRotationAngle(wingp_r23, 0.0F, 0.3054F, 0.0F);
		wingp_r23.texOffs(88, 86).addBox(10.5002F, -12.9489F, 1.5782F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r24 = new ModelRenderer(this);
		wingp_r24.setPos(19.8727F, 4.2439F, -4.6327F);
		wing3.addChild(wingp_r24);
		setRotationAngle(wingp_r24, -0.0547F, 0.3006F, -0.1828F);
		wingp_r24.texOffs(22, 52).addBox(8.5097F, -11.788F, 1.5782F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		wingp_r25 = new ModelRenderer(this);
		wingp_r25.setPos(41.6525F, -4.2089F, -9.3208F);
		wing3.addChild(wingp_r25);
		setRotationAngle(wingp_r25, 0.2666F, 0.1509F, 1.0675F);
		wingp_r25.texOffs(110, 57).addBox(3.0F, -1.0F, -0.5F, 7.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r26 = new ModelRenderer(this);
		wingp_r26.setPos(41.6525F, -4.2089F, -9.3208F);
		wing3.addChild(wingp_r26);
		setRotationAngle(wingp_r26, 0.1564F, 0.2635F, 0.5444F);
		wingp_r26.texOffs(110, 57).addBox(0.0F, 2.0F, -0.5F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r27 = new ModelRenderer(this);
		wingp_r27.setPos(41.6525F, -4.2089F, -9.3208F);
		wing3.addChild(wingp_r27);
		setRotationAngle(wingp_r27, -0.2099F, 0.2236F, -0.7654F);
		wingp_r27.texOffs(110, 57).addBox(-2.0F, 1.0F, -0.5F, 7.0F, 11.0F, 1.0F, 0.0F, false);

		wingp_r28 = new ModelRenderer(this);
		wingp_r28.setPos(41.6525F, -4.2089F, -9.3208F);
		wing3.addChild(wingp_r28);
		setRotationAngle(wingp_r28, -0.0945F, 0.2909F, -0.3193F);
		wingp_r28.texOffs(110, 57).addBox(-4.0F, -3.0F, -0.5F, 7.0F, 7.0F, 1.0F, 0.0F, false);

		wingp_r29 = new ModelRenderer(this);
		wingp_r29.setPos(17.7525F, 1.0017F, -2.9157F);
		wing3.addChild(wingp_r29);
		setRotationAngle(wingp_r29, 0.0547F, 0.3006F, 0.1828F);
		wingp_r29.texOffs(110, 57).addBox(16.4395F, -13.424F, 0.5782F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r30 = new ModelRenderer(this);
		wingp_r30.setPos(19.8727F, 4.2439F, -4.6327F);
		wing3.addChild(wingp_r30);
		setRotationAngle(wingp_r30, 0.1074F, 0.2865F, 0.3646F);
		wingp_r30.texOffs(113, 69).addBox(3.6086F, -10.9031F, 1.5782F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r31 = new ModelRenderer(this);
		wingp_r31.setPos(22.7215F, 2.6441F, -4.2239F);
		wing3.addChild(wingp_r31);
		setRotationAngle(wingp_r31, 0.2727F, 0.1393F, 1.11F);
		wingp_r31.texOffs(109, 71).addBox(-5.5887F, -3.5629F, 0.3317F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		wingp_r32 = new ModelRenderer(this);
		wingp_r32.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r32);
		setRotationAngle(wingp_r32, -0.0411F, 0.3027F, -0.1372F);
		wingp_r32.texOffs(69, 60).addBox(11.6789F, -6.274F, 1.0782F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r33 = new ModelRenderer(this);
		wingp_r33.setPos(17.0988F, 8.5932F, -4.2823F);
		wing3.addChild(wingp_r33);
		setRotationAngle(wingp_r33, 0.1896F, 0.2409F, 0.6775F);
		wingp_r33.texOffs(50, 78).addBox(-2.8601F, -12.1339F, 2.0782F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r34 = new ModelRenderer(this);
		wingp_r34.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r34);
		setRotationAngle(wingp_r34, 0.2194F, 0.2143F, 0.8091F);
		wingp_r34.texOffs(44, 62).addBox(3.0941F, -10.2657F, 1.0782F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r35 = new ModelRenderer(this);
		wingp_r35.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r35);
		setRotationAngle(wingp_r35, 0.2956F, 0.0779F, 1.3206F);
		wingp_r35.texOffs(46, 72).addBox(-3.3176F, -4.1158F, 1.0782F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r36 = new ModelRenderer(this);
		wingp_r36.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r36);
		setRotationAngle(wingp_r36, 0.2599F, 0.1623F, 1.0248F);
		wingp_r36.texOffs(49, 77).addBox(-1.6703F, -8.8607F, 1.0782F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r37 = new ModelRenderer(this);
		wingp_r37.setPos(9.4713F, 3.9416F, -0.8288F);
		wing3.addChild(wingp_r37);
		setRotationAngle(wingp_r37, -0.1074F, 0.2865F, -0.3646F);
		wingp_r37.texOffs(79, 59).addBox(7.1558F, -3.2112F, 1.0782F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r38 = new ModelRenderer(this);
		wingp_r38.setPos(10.7666F, 4.6442F, -1.2373F);
		wing3.addChild(wingp_r38);
		setRotationAngle(wingp_r38, 0.0F, 0.3054F, 0.0F);
		wingp_r38.texOffs(89, 98).addBox(10.5899F, -13.3403F, 1.0782F, 7.0F, 10.0F, 1.0F, 0.0F, false);
		wingp_r38.texOffs(81, 104).addBox(4.5899F, -11.3403F, 1.0782F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wing4 = new ModelRenderer(this);
		wing4.setPos(-6.0F, -17.0F, 6.0F);
		Body.addChild(wing4);
		setRotationAngle(wing4, -0.0385F, 0.2148F, 0.694F);
		wing4.texOffs(0, 108).addBox(-13.7929F, -9.166F, -1.9948F, 8.0F, 7.0F, 2.0F, 0.0F, true);
		wing4.texOffs(0, 108).addBox(-7.7929F, -9.166F, -0.9948F, 8.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r39 = new ModelRenderer(this);
		wingp_r39.setPos(-19.3923F, -2.3029F, -4.7279F);
		wing4.addChild(wingp_r39);
		setRotationAngle(wingp_r39, -0.1564F, -0.2635F, 0.5444F);
		wingp_r39.texOffs(46, 65).addBox(-15.517F, -1.5273F, 0.8303F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		wingp_r40 = new ModelRenderer(this);
		wingp_r40.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r40);
		setRotationAngle(wingp_r40, -0.0547F, -0.3006F, 0.1828F);
		wingp_r40.texOffs(13, 39).addBox(-14.4752F, -13.9525F, 0.8303F, 6.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r41 = new ModelRenderer(this);
		wingp_r41.setPos(-35.1451F, -7.9527F, -8.2999F);
		wing4.addChild(wingp_r41);
		setRotationAngle(wingp_r41, 0.2783F, -0.1274F, -1.1523F);
		wingp_r41.texOffs(110, 50).addBox(-3.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, 0.0F, true);

		wingp_r42 = new ModelRenderer(this);
		wingp_r42.setPos(-39.1764F, -2.6721F, -9.571F);
		wing4.addChild(wingp_r42);
		setRotationAngle(wingp_r42, 0.0411F, -0.3027F, -0.1372F);
		wingp_r42.texOffs(110, 50).addBox(-7.0F, -0.5F, -0.5F, 7.0F, 5.0F, 1.0F, 0.0F, true);

		wingp_r43 = new ModelRenderer(this);
		wingp_r43.setPos(-48.0917F, 0.2092F, -12.382F);
		wing4.addChild(wingp_r43);
		setRotationAngle(wingp_r43, 0.2194F, -0.2143F, -0.8091F);
		wingp_r43.texOffs(110, 50).addBox(-2.5F, -2.0F, -0.5F, 8.0F, 5.0F, 1.0F, 0.0F, true);

		wingp_r44 = new ModelRenderer(this);
		wingp_r44.setPos(-23.2046F, -5.0935F, -5.9299F);
		wing4.addChild(wingp_r44);
		setRotationAngle(wingp_r44, 0.1564F, -0.2635F, -0.5444F);
		wingp_r44.texOffs(110, 50).addBox(-20.3508F, -12.5667F, 0.8303F, 11.0F, 6.0F, 1.0F, 0.0F, true);
		wingp_r44.texOffs(110, 50).addBox(-18.3508F, -8.5667F, 0.8303F, 6.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r45 = new ModelRenderer(this);
		wingp_r45.setPos(-22.8865F, 0.0769F, -5.8296F);
		wing4.addChild(wingp_r45);
		setRotationAngle(wingp_r45, 0.0547F, -0.3006F, -0.1828F);
		wingp_r45.texOffs(110, 50).addBox(-14.3508F, -8.5667F, 0.8303F, 6.0F, 6.0F, 1.0F, 0.0F, true);
		wingp_r45.texOffs(110, 50).addBox(-11.3508F, -14.5667F, 0.8303F, 6.0F, 9.0F, 1.0F, 0.0F, true);

		wingp_r46 = new ModelRenderer(this);
		wingp_r46.setPos(-29.7921F, 0.1663F, -6.6121F);
		wing4.addChild(wingp_r46);
		setRotationAngle(wingp_r46, 0.2783F, -0.1274F, -1.1523F);
		wingp_r46.texOffs(112, 68).addBox(-1.0F, -5.0F, -0.5F, 6.0F, 9.0F, 1.0F, 0.0F, true);

		wingp_r47 = new ModelRenderer(this);
		wingp_r47.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r47);
		setRotationAngle(wingp_r47, 0.1074F, -0.2865F, -0.3646F);
		wingp_r47.texOffs(114, 74).addBox(-9.4965F, -12.0282F, 0.8303F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		wingp_r48 = new ModelRenderer(this);
		wingp_r48.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r48);
		setRotationAngle(wingp_r48, 0.2666F, -0.1509F, -1.0675F);
		wingp_r48.texOffs(111, 73).addBox(-5.8941F, -12.5461F, 0.3303F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r49 = new ModelRenderer(this);
		wingp_r49.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r49);
		setRotationAngle(wingp_r49, -0.0411F, -0.3027F, 0.1372F);
		wingp_r49.texOffs(69, 60).addBox(-18.6372F, -6.4368F, 0.3303F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r50 = new ModelRenderer(this);
		wingp_r50.setPos(-15.1066F, 6.2793F, -3.9009F);
		wing4.addChild(wingp_r50);
		setRotationAngle(wingp_r50, 0.1896F, -0.2409F, -0.6775F);
		wingp_r50.texOffs(70, 46).addBox(-4.9953F, -14.2196F, 1.3303F, 8.0F, 5.0F, 1.0F, 0.0F, true);

		wingp_r51 = new ModelRenderer(this);
		wingp_r51.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r51);
		setRotationAngle(wingp_r51, 0.2783F, -0.1274F, -1.1523F);
		wingp_r51.texOffs(44, 63).addBox(-2.9318F, -9.7923F, 0.3303F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r52 = new ModelRenderer(this);
		wingp_r52.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r52);
		setRotationAngle(wingp_r52, 0.2921F, -0.0905F, -1.2787F);
		wingp_r52.texOffs(49, 77).addBox(-1.7533F, -8.2252F, 0.3303F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r53 = new ModelRenderer(this);
		wingp_r53.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r53);
		setRotationAngle(wingp_r53, -0.1074F, -0.2865F, 0.3646F);
		wingp_r53.texOffs(79, 59).addBox(-13.1503F, -3.3792F, 0.3303F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r54 = new ModelRenderer(this);
		wingp_r54.setPos(-21.7108F, -9.9905F, -4.0641F);
		wing4.addChild(wingp_r54);
		setRotationAngle(wingp_r54, -0.1325F, -0.276F, 0.4548F);
		wingp_r54.texOffs(76, 97).addBox(-3.5F, -2.0F, -0.5F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		wingp_r55 = new ModelRenderer(this);
		wingp_r55.setPos(-8.7744F, 2.3302F, -0.8558F);
		wing4.addChild(wingp_r55);
		setRotationAngle(wingp_r55, 0.0F, -0.3054F, 0.0F);
		wingp_r55.texOffs(76, 97).addBox(-17.5273F, -12.4963F, 0.3303F, 7.0F, 4.0F, 1.0F, 0.0F, true);
		wingp_r55.texOffs(106, 109).addBox(-10.5273F, -11.4963F, 0.3303F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wing2 = new ModelRenderer(this);
		wing2.setPos(-7.0F, -12.0F, 6.0F);
		Body.addChild(wing2);
		setRotationAngle(wing2, 0.0F, 0.0F, 0.0436F);
		wing2.texOffs(80, 88).addBox(-7.8535F, -13.3085F, -1.0F, 8.0F, 7.0F, 3.0F, 0.0F, true);
		wing2.texOffs(94, 88).addBox(0.1465F, -10.3085F, -1.0F, 5.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r56 = new ModelRenderer(this);
		wingp_r56.setPos(-17.9794F, 0.5543F, -4.2512F);
		wing2.addChild(wingp_r56);
		setRotationAngle(wingp_r56, 0.1074F, -0.2865F, -0.3646F);
		wingp_r56.texOffs(114, 77).addBox(-2.8575F, -11.5562F, -0.0367F, 6.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r57 = new ModelRenderer(this);
		wingp_r57.setPos(-25.3041F, -7.405F, -6.075F);
		wing2.addChild(wingp_r57);
		setRotationAngle(wingp_r57, 0.237F, -0.1945F, -0.8959F);
		wingp_r57.texOffs(112, 74).addBox(-3.5F, -1.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r58 = new ModelRenderer(this);
		wingp_r58.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r58);
		setRotationAngle(wingp_r58, 0.1074F, -0.2865F, -0.3646F);
		wingp_r58.texOffs(112, 74).addBox(-11.3575F, -13.0562F, -0.5367F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r59 = new ModelRenderer(this);
		wingp_r59.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r59);
		setRotationAngle(wingp_r59, -0.0411F, -0.3027F, 0.1372F);
		wingp_r59.texOffs(69, 60).addBox(-12.9921F, -9.9707F, -0.5367F, 7.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r60 = new ModelRenderer(this);
		wingp_r60.setPos(-15.2055F, 4.9037F, -3.9009F);
		wing2.addChild(wingp_r60);
		setRotationAngle(wingp_r60, 0.1896F, -0.2409F, -0.6775F);
		wingp_r60.texOffs(50, 78).addBox(4.4952F, -10.7267F, 0.4633F, 5.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r61 = new ModelRenderer(this);
		wingp_r61.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r61);
		setRotationAngle(wingp_r61, 0.1325F, -0.276F, -0.4548F);
		wingp_r61.texOffs(18, 39).addBox(-3.3604F, -11.0794F, -0.5367F, 5.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r62 = new ModelRenderer(this);
		wingp_r62.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r62);
		setRotationAngle(wingp_r62, 0.1564F, -0.2635F, -0.5444F);
		wingp_r62.texOffs(22, 60).addBox(-5.3909F, -8.4218F, -0.5367F, 3.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r62.texOffs(78, 49).addBox(-2.3909F, -8.4218F, -0.5367F, 5.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r63 = new ModelRenderer(this);
		wingp_r63.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r63);
		setRotationAngle(wingp_r63, 0.2835F, 0.1153F, -1.947F);
		wingp_r63.texOffs(48, 77).addBox(8.9299F, 5.044F, -1.0367F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r64 = new ModelRenderer(this);
		wingp_r64.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r64);
		setRotationAngle(wingp_r64, 0.3011F, 0.0522F, -1.7374F);
		wingp_r64.texOffs(46, 73).addBox(10.3395F, 1.0956F, -0.0367F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r65 = new ModelRenderer(this);
		wingp_r65.setPos(-9.4754F, 5.5331F, -1.5699F);
		wing2.addChild(wingp_r65);
		setRotationAngle(wingp_r65, 0.303F, -0.0393F, -1.4459F);
		wingp_r65.texOffs(47, 76).addBox(7.9707F, 1.0079F, -0.0367F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		wingp_r65.texOffs(49, 74).addBox(9.9707F, 0.0079F, -0.0367F, 3.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r66 = new ModelRenderer(this);
		wingp_r66.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r66);
		setRotationAngle(wingp_r66, -0.1074F, -0.2865F, 0.3646F);
		wingp_r66.texOffs(79, 59).addBox(-8.4039F, -8.0511F, -0.5367F, 6.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r67 = new ModelRenderer(this);
		wingp_r67.setPos(-30.5931F, 4.1313F, -5.344F);
		wing2.addChild(wingp_r67);
		setRotationAngle(wingp_r67, 0.0814F, -0.2947F, -0.2739F);
		wingp_r67.texOffs(12, 40).addBox(-9.6976F, -10.9634F, -0.382F, 8.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r68 = new ModelRenderer(this);
		wingp_r68.setPos(-36.5227F, -4.6058F, -6.2238F);
		wing2.addChild(wingp_r68);
		setRotationAngle(wingp_r68, 0.1158F, -0.284F, -0.6844F);
		wingp_r68.texOffs(17, 81).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r69 = new ModelRenderer(this);
		wingp_r69.setPos(-32.5227F, -7.6058F, -6.2238F);
		wing2.addChild(wingp_r69);
		setRotationAngle(wingp_r69, 0.1158F, -0.284F, -0.6844F);
		wingp_r69.texOffs(17, 81).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r70 = new ModelRenderer(this);
		wingp_r70.setPos(-26.5931F, 1.1313F, -5.344F);
		wing2.addChild(wingp_r70);
		setRotationAngle(wingp_r70, 0.0814F, -0.2947F, -0.2739F);
		wingp_r70.texOffs(12, 40).addBox(-7.6976F, -9.9634F, -0.382F, 6.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r71 = new ModelRenderer(this);
		wingp_r71.setPos(-22.5931F, -2.8687F, -5.344F);
		wing2.addChild(wingp_r71);
		setRotationAngle(wingp_r71, 0.0814F, -0.2947F, -0.2739F);
		wingp_r71.texOffs(73, 49).addBox(-7.6976F, -9.9634F, -0.382F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r72 = new ModelRenderer(this);
		wingp_r72.setPos(-16.7792F, -14.7357F, -2.7063F);
		wing2.addChild(wingp_r72);
		setRotationAngle(wingp_r72, -0.176F, -0.2156F, -0.1413F);
		wingp_r72.texOffs(17, 81).addBox(3.5F, -2.0F, -0.5F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r73 = new ModelRenderer(this);
		wingp_r73.setPos(-16.7792F, -14.7357F, -2.7063F);
		wing2.addChild(wingp_r73);
		setRotationAngle(wingp_r73, -0.0451F, -0.2156F, -0.1413F);
		wingp_r73.texOffs(17, 81).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r74 = new ModelRenderer(this);
		wingp_r74.setPos(-28.5227F, -11.6058F, -6.2238F);
		wing2.addChild(wingp_r74);
		setRotationAngle(wingp_r74, 0.1158F, -0.284F, -0.6844F);
		wingp_r74.texOffs(17, 81).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r75 = new ModelRenderer(this);
		wingp_r75.setPos(-22.5931F, -2.8687F, -5.344F);
		wing2.addChild(wingp_r75);
		setRotationAngle(wingp_r75, -0.0461F, -0.3027F, -0.1372F);
		wingp_r75.texOffs(17, 81).addBox(-2.6976F, -12.9634F, -0.382F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r76 = new ModelRenderer(this);
		wingp_r76.setPos(-22.5931F, -2.8687F, -5.344F);
		wing2.addChild(wingp_r76);
		setRotationAngle(wingp_r76, 0.0411F, -0.3027F, -0.1372F);
		wingp_r76.texOffs(17, 81).addBox(-2.6976F, -9.9634F, -0.382F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r77 = new ModelRenderer(this);
		wingp_r77.setPos(-8.8733F, 0.9546F, -0.8558F);
		wing2.addChild(wingp_r77);
		setRotationAngle(wingp_r77, 0.0F, -0.3054F, 0.0F);
		wingp_r77.texOffs(19, 51).addBox(-11.4693F, -14.2631F, -0.5367F, 7.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r77.texOffs(72, 47).addBox(-4.4693F, -14.2631F, -0.5367F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wingDown = new ModelRenderer(this);
		wingDown.setPos(-4.0F, -15.0F, 6.0F);
		Body.addChild(wingDown);
		setRotationAngle(wingDown, 0.0F, 0.0F, -0.8727F);
		wingDown.texOffs(79, 47).addBox(-7.5574F, -7.7165F, -1.0F, 8.0F, 7.0F, 3.0F, 0.0F, true);
		wingDown.texOffs(79, 47).addBox(0.4426F, -2.7165F, -1.0F, 5.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r78 = new ModelRenderer(this);
		wingp_r78.setPos(-27.8391F, 2.6257F, -4.2512F);
		wingDown.addChild(wingp_r78);
		setRotationAngle(wingp_r78, 0.0547F, -0.3006F, -0.1828F);
		wingp_r78.texOffs(52, 62).addBox(4.0229F, -8.0906F, -3.0906F, 6.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r79 = new ModelRenderer(this);
		wingp_r79.setPos(-27.8391F, 2.6257F, -4.2512F);
		wingDown.addChild(wingp_r79);
		setRotationAngle(wingp_r79, 0.1074F, -0.2865F, -0.3646F);
		wingp_r79.texOffs(114, 77).addBox(5.04F, -4.9353F, -3.0906F, 6.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r80 = new ModelRenderer(this);
		wingp_r80.setPos(-17.4377F, 2.3235F, -0.4474F);
		wingDown.addChild(wingp_r80);
		setRotationAngle(wingp_r80, 0.1564F, -0.2635F, -0.5444F);
		wingp_r80.texOffs(112, 87).addBox(-6.7631F, -10.2301F, -3.5906F, 4.0F, 4.0F, 2.0F, 0.0F, true);
		wingp_r80.texOffs(107, 87).addBox(-2.7631F, -7.2301F, -3.5906F, 7.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r81 = new ModelRenderer(this);
		wingp_r81.setPos(-17.4377F, 2.3235F, -0.4474F);
		wingDown.addChild(wingp_r81);
		setRotationAngle(wingp_r81, -0.0411F, -0.3027F, 0.1372F);
		wingp_r81.texOffs(69, 60).addBox(-2.9298F, -7.7445F, -3.5906F, 7.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r82 = new ModelRenderer(this);
		wingp_r82.setPos(-25.0652F, 6.9751F, -3.9009F);
		wingDown.addChild(wingp_r82);
		setRotationAngle(wingp_r82, 0.1564F, -0.2635F, -0.5444F);
		wingp_r82.texOffs(50, 78).addBox(8.7369F, -4.6301F, -2.5906F, 5.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r83 = new ModelRenderer(this);
		wingp_r83.setPos(-25.0652F, 6.9751F, -3.9009F);
		wingDown.addChild(wingp_r83);
		setRotationAngle(wingp_r83, 0.1896F, -0.2409F, -0.6775F);
		wingp_r83.texOffs(50, 78).addBox(10.0362F, -2.0374F, -2.5906F, 5.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r84 = new ModelRenderer(this);
		wingp_r84.setPos(-17.3313F, 7.6491F, -0.9382F);
		wingDown.addChild(wingp_r84);
		setRotationAngle(wingp_r84, 0.2599F, -0.1623F, -1.0248F);
		wingp_r84.texOffs(44, 66).addBox(9.8664F, 2.0009F, -3.0906F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r85 = new ModelRenderer(this);
		wingp_r85.setPos(-17.4377F, 2.3235F, -0.4474F);
		wingDown.addChild(wingp_r85);
		setRotationAngle(wingp_r85, 0.1564F, -0.2635F, -0.5444F);
		wingp_r85.texOffs(58, 62).addBox(-0.7631F, -3.5301F, -3.5906F, 5.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r86 = new ModelRenderer(this);
		wingp_r86.setPos(-14.1345F, 8.3224F, 0.0698F);
		wingDown.addChild(wingp_r86);
		setRotationAngle(wingp_r86, 0.2835F, 0.1153F, -1.947F);
		wingp_r86.texOffs(48, 77).addBox(1.9708F, 12.6452F, -4.0906F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r87 = new ModelRenderer(this);
		wingp_r87.setPos(-14.1345F, 8.3224F, 0.0698F);
		wingDown.addChild(wingp_r87);
		setRotationAngle(wingp_r87, 0.3011F, 0.0522F, -1.7374F);
		wingp_r87.texOffs(46, 73).addBox(5.1906F, 10.0229F, -3.0906F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r88 = new ModelRenderer(this);
		wingp_r88.setPos(-19.335F, 7.6045F, -1.5699F);
		wingDown.addChild(wingp_r88);
		setRotationAngle(wingp_r88, 0.303F, -0.0393F, -1.4459F);
		wingp_r88.texOffs(47, 76).addBox(5.7445F, 11.0702F, -3.0906F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		wingp_r88.texOffs(49, 74).addBox(7.7445F, 10.0702F, -3.0906F, 3.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r89 = new ModelRenderer(this);
		wingp_r89.setPos(-17.4377F, 2.3235F, -0.4474F);
		wingDown.addChild(wingp_r89);
		setRotationAngle(wingp_r89, 0.2099F, -0.2236F, -0.7654F);
		wingp_r89.texOffs(87, 92).addBox(2.2369F, -1.5301F, -3.5906F, 7.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r90 = new ModelRenderer(this);
		wingp_r90.setPos(-17.4377F, 2.3235F, -0.4474F);
		wingDown.addChild(wingp_r90);
		setRotationAngle(wingp_r90, -0.1074F, -0.2865F, 0.3646F);
		wingp_r90.texOffs(79, 59).addBox(1.9018F, -8.0556F, -3.5906F, 6.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r91 = new ModelRenderer(this);
		wingp_r91.setPos(-34.4491F, -0.9314F, -10.5423F);
		wingDown.addChild(wingp_r91);
		setRotationAngle(wingp_r91, 0.0F, -0.829F, 0.0F);
		wingp_r91.texOffs(109, 43).addBox(1.1578F, -6.7851F, -5.5831F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r92 = new ModelRenderer(this);
		wingp_r92.setPos(-19.7776F, 3.026F, 1.0647F);
		wingDown.addChild(wingp_r92);
		setRotationAngle(wingp_r92, 0.0F, -0.5672F, 0.0F);
		wingp_r92.texOffs(87, 46).addBox(-9.5442F, -10.7425F, -5.2218F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r93 = new ModelRenderer(this);
		wingp_r93.setPos(-18.733F, 3.026F, -0.8558F);
		wingDown.addChild(wingp_r93);
		setRotationAngle(wingp_r93, 0.0F, -0.3054F, 0.0F);
		wingp_r93.texOffs(91, 52).addBox(-1.7836F, -10.7425F, -3.5906F, 7.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r93.texOffs(85, 93).addBox(5.2164F, -10.7425F, -3.5906F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r94 = new ModelRenderer(this);
		wingp_r94.setPos(-27.2615F, -9.028F, -8.6925F);
		wingDown.addChild(wingp_r94);
		setRotationAngle(wingp_r94, -0.0678F, -0.655F, -0.2431F);
		wingp_r94.texOffs(79, 47).addBox(-7.5F, -2.0F, -1.0F, 6.0F, 3.0F, 3.0F, 0.0F, true);

		wingp_r95 = new ModelRenderer(this);
		wingp_r95.setPos(-10.0593F, -6.3935F, 3.0716F);
		wingDown.addChild(wingp_r95);
		setRotationAngle(wingp_r95, -0.3161F, -0.5872F, 0.1793F);
		wingp_r95.texOffs(79, 47).addBox(-24.5F, -1.5F, -1.0F, 7.0F, 4.0F, 3.0F, 0.0F, true);

		wingp_r96 = new ModelRenderer(this);
		wingp_r96.setPos(-8.4624F, -11.1046F, 0.7942F);
		wingDown.addChild(wingp_r96);
		setRotationAngle(wingp_r96, -0.3737F, -0.0402F, 0.6892F);
		wingp_r96.texOffs(79, 47).addBox(-4.0F, -2.0F, -0.5F, 8.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r97 = new ModelRenderer(this);
		wingp_r97.setPos(-24.3874F, -11.7115F, -3.5059F);
		wingDown.addChild(wingp_r97);
		setRotationAngle(wingp_r97, -0.2419F, -0.2904F, -0.0683F);
		wingp_r97.texOffs(79, 47).addBox(9.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r98 = new ModelRenderer(this);
		wingp_r98.setPos(-23.7678F, -12.1273F, -4.8886F);
		wingDown.addChild(wingp_r98);
		setRotationAngle(wingp_r98, -0.2589F, -0.4595F, -0.0219F);
		wingp_r98.texOffs(79, 47).addBox(3.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r99 = new ModelRenderer(this);
		wingp_r99.setPos(-31.5664F, -23.0188F, -8.4354F);
		wingDown.addChild(wingp_r99);
		setRotationAngle(wingp_r99, -0.1917F, -0.5739F, -0.0588F);
		wingp_r99.texOffs(79, 47).addBox(-9.0F, -0.5F, -1.5F, 6.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r100 = new ModelRenderer(this);
		wingp_r100.setPos(-26.8157F, -19.6042F, -6.3517F);
		wingDown.addChild(wingp_r100);
		setRotationAngle(wingp_r100, -0.4263F, -0.4383F, 0.4172F);
		wingp_r100.texOffs(79, 47).addBox(-9.0F, -0.5F, -0.5F, 6.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r100.texOffs(79, 47).addBox(-3.0F, -0.5F, -0.5F, 6.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r101 = new ModelRenderer(this);
		wingp_r101.setPos(-19.6852F, -16.1965F, -3.131F);
		wingDown.addChild(wingp_r101);
		setRotationAngle(wingp_r101, -0.4926F, -0.3607F, 0.5869F);
		wingp_r101.texOffs(79, 47).addBox(-6.0F, -0.5F, -0.5F, 8.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r102 = new ModelRenderer(this);
		wingp_r102.setPos(-30.8157F, -15.6042F, -8.3517F);
		wingDown.addChild(wingp_r102);
		setRotationAngle(wingp_r102, -0.2457F, -0.5549F, -0.0452F);
		wingp_r102.texOffs(79, 47).addBox(-6.0F, 1.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r103 = new ModelRenderer(this);
		wingp_r103.setPos(-30.8157F, -15.6042F, -8.3517F);
		wingDown.addChild(wingp_r103);
		setRotationAngle(wingp_r103, -0.4263F, -0.4383F, 0.3299F);
		wingp_r103.texOffs(79, 47).addBox(-3.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r104 = new ModelRenderer(this);
		wingp_r104.setPos(-23.6852F, -12.1965F, -5.131F);
		wingDown.addChild(wingp_r104);
		setRotationAngle(wingp_r104, -0.4926F, -0.3607F, 0.4997F);
		wingp_r104.texOffs(79, 47).addBox(-6.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r105 = new ModelRenderer(this);
		wingp_r105.setPos(-23.6852F, -12.1965F, -5.131F);
		wingDown.addChild(wingp_r105);
		setRotationAngle(wingp_r105, -0.2715F, -0.5437F, 0.0042F);
		wingp_r105.texOffs(79, 47).addBox(-3.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r106 = new ModelRenderer(this);
		wingp_r106.setPos(-26.9575F, -10.9882F, -7.5037F);
		wingDown.addChild(wingp_r106);
		setRotationAngle(wingp_r106, 0.1311F, -0.5889F, -0.7226F);
		wingp_r106.texOffs(79, 47).addBox(-3.0F, -2.5F, -0.5F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r107 = new ModelRenderer(this);
		wingp_r107.setPos(-10.0593F, -6.3935F, 3.0716F);
		wingDown.addChild(wingp_r107);
		setRotationAngle(wingp_r107, -0.3001F, -0.504F, 0.1483F);
		wingp_r107.texOffs(79, 47).addBox(-22.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r108 = new ModelRenderer(this);
		wingp_r108.setPos(-10.0284F, -7.1904F, 0.0976F);
		wingDown.addChild(wingp_r108);
		setRotationAngle(wingp_r108, -0.2739F, -0.2947F, 0.0814F);
		wingp_r108.texOffs(79, 47).addBox(-12.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r109 = new ModelRenderer(this);
		wingp_r109.setPos(-9.0574F, -7.2165F, 0.0F);
		wingDown.addChild(wingp_r109);
		setRotationAngle(wingp_r109, -0.2679F, -0.2106F, 0.0573F);
		wingp_r109.texOffs(79, 47).addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		wingDown2 = new ModelRenderer(this);
		wingDown2.setPos(4.0F, -15.0F, 6.0F);
		Body.addChild(wingDown2);
		setRotationAngle(wingDown2, 0.0F, 0.0F, 0.8727F);
		wingDown2.texOffs(79, 47).addBox(-1.0854F, -6.9505F, -1.0F, 8.0F, 7.0F, 3.0F, 0.0F, false);
		wingDown2.texOffs(79, 47).addBox(-5.0854F, -1.9505F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		wingp_r110 = new ModelRenderer(this);
		wingp_r110.setPos(28.4098F, 2.1748F, -4.6339F);
		wingDown2.addChild(wingp_r110);
		setRotationAngle(wingp_r110, 0.0138F, 0.3051F, 0.0457F);
		wingp_r110.texOffs(80, 50).addBox(-9.5838F, -8.7155F, -3.0906F, 6.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r111 = new ModelRenderer(this);
		wingp_r111.setPos(16.7949F, 3.0895F, -0.4474F);
		wingDown2.addChild(wingp_r111);
		setRotationAngle(wingp_r111, 0.2727F, 0.1393F, 1.11F);
		wingp_r111.texOffs(112, 72).addBox(-1.9573F, -4.9744F, -3.5906F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		wingp_r111.texOffs(111, 73).addBox(-5.9573F, -6.9744F, -3.5906F, 4.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r112 = new ModelRenderer(this);
		wingp_r112.setPos(16.7949F, 3.0895F, -0.4474F);
		wingDown2.addChild(wingp_r112);
		setRotationAngle(wingp_r112, 0.303F, -0.0393F, 1.6957F);
		wingp_r112.texOffs(118, 70).addBox(-7.9573F, -6.9744F, -3.5906F, 4.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r113 = new ModelRenderer(this);
		wingp_r113.setPos(16.7949F, 3.0895F, -0.4474F);
		wingDown2.addChild(wingp_r113);
		setRotationAngle(wingp_r113, -0.0411F, 0.3027F, -0.1372F);
		wingp_r113.texOffs(69, 60).addBox(-4.0702F, -7.7445F, -3.5906F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r114 = new ModelRenderer(this);
		wingp_r114.setPos(19.7973F, 2.7465F, -3.1855F);
		wingDown2.addChild(wingp_r114);
		setRotationAngle(wingp_r114, 0.2783F, 0.1274F, 1.1523F);
		wingp_r114.texOffs(89, 85).addBox(-7.8479F, 1.8429F, -1.8821F, 6.0F, 4.0F, 2.0F, 0.0F, false);

		wingp_r115 = new ModelRenderer(this);
		wingp_r115.setPos(16.6885F, 8.4151F, -0.9382F);
		wingDown2.addChild(wingp_r115);
		setRotationAngle(wingp_r115, 0.2599F, 0.1623F, 1.0248F);
		wingp_r115.texOffs(44, 66).addBox(-12.8664F, 2.0009F, -3.0906F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r116 = new ModelRenderer(this);
		wingp_r116.setPos(16.7949F, 3.0895F, -0.4474F);
		wingDown2.addChild(wingp_r116);
		setRotationAngle(wingp_r116, 0.2599F, 0.1623F, 1.0248F);
		wingp_r116.texOffs(46, 72).addBox(-4.1203F, 1.243F, -3.5906F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		wingp_r116.texOffs(70, 49).addBox(-9.1203F, 1.243F, -3.5906F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r117 = new ModelRenderer(this);
		wingp_r117.setPos(13.4917F, 9.0885F, 0.0698F);
		wingDown2.addChild(wingp_r117);
		setRotationAngle(wingp_r117, 0.2835F, -0.1153F, 1.947F);
		wingp_r117.texOffs(48, 77).addBox(-4.9708F, 12.6452F, -4.0906F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r118 = new ModelRenderer(this);
		wingp_r118.setPos(13.4917F, 9.0885F, 0.0698F);
		wingDown2.addChild(wingp_r118);
		setRotationAngle(wingp_r118, 0.3011F, -0.0522F, 1.7374F);
		wingp_r118.texOffs(46, 73).addBox(-8.1906F, 10.0229F, -3.0906F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		wingp_r119 = new ModelRenderer(this);
		wingp_r119.setPos(18.6923F, 8.3706F, -1.5699F);
		wingDown2.addChild(wingp_r119);
		setRotationAngle(wingp_r119, 0.303F, 0.0393F, 1.4459F);
		wingp_r119.texOffs(47, 76).addBox(-7.7445F, 11.0702F, -3.0906F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		wingp_r119.texOffs(49, 74).addBox(-10.7445F, 10.0702F, -3.0906F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r120 = new ModelRenderer(this);
		wingp_r120.setPos(16.7949F, 3.0895F, -0.4474F);
		wingDown2.addChild(wingp_r120);
		setRotationAngle(wingp_r120, -0.1074F, 0.2865F, -0.3646F);
		wingp_r120.texOffs(79, 59).addBox(-7.9018F, -8.0556F, -3.5906F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		wingp_r121 = new ModelRenderer(this);
		wingp_r121.setPos(18.0902F, 3.7921F, -0.8558F);
		wingDown2.addChild(wingp_r121);
		setRotationAngle(wingp_r121, 0.0F, 0.3054F, 0.0F);
		wingp_r121.texOffs(89, 67).addBox(-5.2164F, -10.7425F, -3.5906F, 7.0F, 4.0F, 2.0F, 0.0F, false);
		wingp_r121.texOffs(87, 70).addBox(-11.2164F, -10.7425F, -3.5906F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wingp_r122 = new ModelRenderer(this);
		wingp_r122.setPos(8.9951F, -7.66F, 3.0716F);
		wingDown2.addChild(wingp_r122);
		setRotationAngle(wingp_r122, -0.3161F, -0.5872F, -3.0496F);
		wingp_r122.texOffs(79, 47).addBox(-25.5F, -1.5F, -1.0F, 8.0F, 4.0F, 3.0F, 0.0F, true);

		wingp_r123 = new ModelRenderer(this);
		wingp_r123.setPos(8.9951F, -7.66F, 3.0716F);
		wingDown2.addChild(wingp_r123);
		setRotationAngle(wingp_r123, -0.3001F, -0.504F, -3.0805F);
		wingp_r123.texOffs(79, 47).addBox(-22.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r124 = new ModelRenderer(this);
		wingp_r124.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r124);
		setRotationAngle(wingp_r124, -0.3659F, -0.4889F, -3.034F);
		wingp_r124.texOffs(79, 47).addBox(-17.0F, 0.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r125 = new ModelRenderer(this);
		wingp_r125.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r125);
		setRotationAngle(wingp_r125, -0.2965F, -0.5315F, 3.1073F);
		wingp_r125.texOffs(79, 47).addBox(-11.0F, -2.5F, -0.5F, 8.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r126 = new ModelRenderer(this);
		wingp_r126.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r126);
		setRotationAngle(wingp_r126, -0.017F, -0.6014F, 2.595F);
		wingp_r126.texOffs(79, 47).addBox(-14.0F, -1.5F, -0.5F, 7.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r126.texOffs(79, 47).addBox(-7.0F, -2.5F, -0.5F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r127 = new ModelRenderer(this);
		wingp_r127.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r127);
		setRotationAngle(wingp_r127, -0.6007F, -0.0353F, -2.199F);
		wingp_r127.texOffs(91, 47).addBox(-2.0F, 6.5F, -0.5F, 5.0F, 7.0F, 2.0F, 0.0F, true);

		wingp_r128 = new ModelRenderer(this);
		wingp_r128.setPos(23.2777F, -17.4116F, -8.88F);
		wingDown2.addChild(wingp_r128);
		setRotationAngle(wingp_r128, -0.5686F, 0.2082F, -1.8346F);
		wingp_r128.texOffs(91, 47).addBox(6.0F, 5.5F, -0.5F, 2.0F, 10.0F, 2.0F, 0.0F, true);

		wingp_r129 = new ModelRenderer(this);
		wingp_r129.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r129);
		setRotationAngle(wingp_r129, -0.5884F, -0.1333F, -2.344F);
		wingp_r129.texOffs(91, 47).addBox(5.0F, 5.5F, -0.5F, 3.0F, 10.0F, 2.0F, 0.0F, true);

		wingp_r130 = new ModelRenderer(this);
		wingp_r130.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r130);
		setRotationAngle(wingp_r130, -0.6005F, 0.0387F, -2.091F);
		wingp_r130.texOffs(91, 47).addBox(4.0F, 5.5F, -0.5F, 6.0F, 10.0F, 2.0F, 0.0F, true);

		wingp_r131 = new ModelRenderer(this);
		wingp_r131.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r131);
		setRotationAngle(wingp_r131, -0.5697F, -0.205F, -2.4551F);
		wingp_r131.texOffs(91, 47).addBox(-2.0F, -1.5F, -0.5F, 8.0F, 13.0F, 2.0F, 0.0F, true);

		wingp_r132 = new ModelRenderer(this);
		wingp_r132.setPos(22.9796F, -10.0879F, -5.9671F);
		wingDown2.addChild(wingp_r132);
		setRotationAngle(wingp_r132, -0.387F, -0.4728F, -2.9882F);
		wingp_r132.texOffs(79, 47).addBox(-3.0F, -2.5F, -0.5F, 6.0F, 6.0F, 2.0F, 0.0F, true);

		wingp_r133 = new ModelRenderer(this);
		wingp_r133.setPos(9.0259F, -8.4569F, 0.0976F);
		wingDown2.addChild(wingp_r133);
		setRotationAngle(wingp_r133, -0.2739F, -0.2947F, 3.1358F);
		wingp_r133.texOffs(79, 47).addBox(-12.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r134 = new ModelRenderer(this);
		wingp_r134.setPos(24.2866F, -11.3938F, -6.8886F);
		wingDown2.addChild(wingp_r134);
		setRotationAngle(wingp_r134, -0.1703F, -0.4968F, 2.8404F);
		wingp_r134.texOffs(79, 47).addBox(3.0F, -2.5F, -0.5F, 7.0F, 8.0F, 2.0F, 0.0F, true);

		wingp_r135 = new ModelRenderer(this);
		wingp_r135.setPos(23.667F, -10.978F, -5.5059F);
		wingDown2.addChild(wingp_r135);
		setRotationAngle(wingp_r135, -0.2419F, -0.2904F, 2.9861F);
		wingp_r135.texOffs(79, 47).addBox(7.0F, -2.5F, 0.5F, 6.0F, 6.0F, 2.0F, 0.0F, true);

		wingp_r136 = new ModelRenderer(this);
		wingp_r136.setPos(9.997F, -8.4831F, 0.0F);
		wingDown2.addChild(wingp_r136);
		setRotationAngle(wingp_r136, -0.2679F, -0.2106F, 3.1116F);
		wingp_r136.texOffs(79, 47).addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 3.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-7.0F, -22.0F, -1.0F);
		setRotationAngle(RightArm, -0.2084F, 0.0651F, 0.2986F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-0.7331F, 7.4483F, 1.1939F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0436F, -0.1745F, 1.4399F);
		RightArm_r1.texOffs(82, 2).addBox(-11.8899F, -3.5513F, -3.4736F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Rightbacktlib = new ModelRenderer(this);
		Rightbacktlib.setPos(-2.7331F, 11.2073F, 1.948F);
		RightArm.addChild(Rightbacktlib);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(3.0F, 0.644F, 3.0686F);
		Rightbacktlib.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.1745F, 0.0F, 0.0F);
		RightArm_r2.texOffs(86, 15).addBox(-5.0F, -15.9886F, -5.5234F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Rightfrontlib = new ModelRenderer(this);
		Rightfrontlib.setPos(0.0F, 0.0F, 0.0F);
		Rightbacktlib.addChild(Rightfrontlib);
		

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-4.0905F, 13.6249F, -1.1438F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3775F, 0.9144F, -0.0465F);
		RightArm_r3.texOffs(124, 20).addBox(0.9324F, -6.8404F, -4.5391F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-3.9978F, 13.9978F, -1.4862F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, 0.1665F, 0.9578F, 0.6202F);
		RightArm_r4.texOffs(123, 10).addBox(-2.2045F, -13.9296F, -4.5391F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.647F, 5.6035F, -0.8624F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.3463F, -0.0447F, 0.0951F);
		RightArm_r5.texOffs(121, 6).addBox(-3.1756F, -2.0995F, -6.3725F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(1.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3414F, 0.0741F, 0.4236F);
		RightArm_r6.texOffs(121, 6).addBox(-5.7125F, -4.3276F, -6.3725F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.3299F, 10.8257F, -6.8058F);
		Rightfrontlib.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.6378F, -0.1582F, -0.384F);
		RightArm_r7.texOffs(124, 11).addBox(3.9523F, -8.9838F, -4.5842F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(-1.2245F, 9.153F, -1.7002F);
		Rightfrontlib.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -1.0742F, -0.1582F, -0.384F);
		RightArm_r8.texOffs(124, 11).addBox(3.9523F, 4.3725F, -6.0973F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(1.4611F, 9.253F, -1.7553F);
		Rightfrontlib.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, -0.9234F, -0.3332F, -0.6425F);
		RightArm_r9.texOffs(119, 13).addBox(3.8383F, 2.5997F, -8.2601F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(1.268F, 8.3751F, -2.8286F);
		Rightfrontlib.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, -0.5744F, -0.3332F, -0.6425F);
		RightArm_r10.texOffs(124, 12).addBox(3.8383F, -4.97F, -7.3131F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(-1.0663F, 11.0304F, -1.1285F);
		Rightfrontlib.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, -0.5251F, -0.0113F, 0.087F);
		RightArm_r11.texOffs(124, 11).addBox(-0.7771F, 2.9096F, -3.1626F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		RightArm_r12 = new ModelRenderer(this);
		RightArm_r12.setPos(-1.0197F, 10.7748F, -3.2782F);
		Rightfrontlib.addChild(RightArm_r12);
		setRotationAngle(RightArm_r12, -0.3069F, -0.0113F, 0.087F);
		RightArm_r12.texOffs(124, 11).addBox(-0.7771F, -4.2468F, -2.5899F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r13 = new ModelRenderer(this);
		RightArm_r13.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r13);
		setRotationAngle(RightArm_r13, 0.0421F, -0.0113F, 0.087F);
		RightArm_r13.texOffs(124, 11).addBox(-0.7771F, -11.3157F, 0.3347F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r14 = new ModelRenderer(this);
		RightArm_r14.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r14);
		setRotationAngle(RightArm_r14, -0.3491F, 0.0F, 0.0F);
		RightArm_r14.texOffs(88, 21).addBox(-2.0F, -5.1207F, -7.4476F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		RightArm_r14.texOffs(88, 27).addBox(-2.0F, -15.1207F, -8.4476F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(7.4442F, -23.8343F, -0.4302F);
		setRotationAngle(LeftArm, 0.1939F, 0.0796F, -0.3849F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(0.5726F, 9.0093F, -3.133F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.0436F, -0.2182F, -1.4399F);
		LeftArm_r1.texOffs(82, 2).addBox(8.9015F, -4.5342F, -1.0161F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Leftlib = new ModelRenderer(this);
		Leftlib.setPos(1.6842F, 14.8744F, -3.0274F);
		LeftArm.addChild(Leftlib);
		

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.0F, -3.0F, 0.0F);
		Leftlib.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(88, 14).addBox(-2.0F, -15.4927F, -1.5812F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Leftfrontlib = new ModelRenderer(this);
		Leftfrontlib.setPos(0.0F, 1.0F, -2.0F);
		Leftlib.addChild(Leftfrontlib);
		

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.8727F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(89, 21).addBox(-1.0F, -5.9561F, -9.3879F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		LeftArm_r3.texOffs(91, 27).addBox(-2.0F, -16.9561F, -9.3879F, 4.0F, 11.0F, 3.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(4.9445F, 13.4316F, -16.3494F);
		Leftfrontlib.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, 0.1035F, 0.8681F, 2.0115F);
		LeftArm_r4.texOffs(122, 12).addBox(-6.0735F, 14.2324F, -5.7288F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(0.4582F, 7.3186F, -11.0091F);
		Leftfrontlib.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.6779F, 0.6002F, 0.9172F);
		LeftArm_r5.texOffs(124, 12).addBox(-6.3242F, 1.3373F, -5.7288F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(-1.1606F, 6.4973F, -10.6558F);
		Leftfrontlib.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.8335F, 0.2975F, 0.5656F);
		LeftArm_r6.texOffs(120, 2).addBox(-4.5595F, -7.2972F, -5.7288F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(-0.393F, 3.4677F, -6.9372F);
		Leftfrontlib.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -0.8608F, -0.1666F, 0.1639F);
		LeftArm_r7.texOffs(120, 2).addBox(-0.6061F, -9.2413F, -5.7288F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r8 = new ModelRenderer(this);
		LeftArm_r8.setPos(2.8957F, 9.0511F, -13.7826F);
		Leftfrontlib.addChild(LeftArm_r8);
		setRotationAngle(LeftArm_r8, -0.6842F, 0.494F, 0.4289F);
		LeftArm_r8.texOffs(124, 11).addBox(-3.6104F, -2.6485F, -5.6284F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r9 = new ModelRenderer(this);
		LeftArm_r9.setPos(2.193F, 10.9341F, -16.3847F);
		Leftfrontlib.addChild(LeftArm_r9);
		setRotationAngle(LeftArm_r9, -0.8016F, 0.2007F, 0.2975F);
		LeftArm_r9.texOffs(124, 11).addBox(-2.4021F, -5.3017F, -5.6298F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		LeftArm_r9.texOffs(124, 11).addBox(-3.4021F, -10.3017F, -5.6298F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r10 = new ModelRenderer(this);
		LeftArm_r10.setPos(3.3558F, 7.8434F, -12.9522F);
		Leftfrontlib.addChild(LeftArm_r10);
		setRotationAngle(LeftArm_r10, -0.8196F, -0.0535F, 0.057F);
		LeftArm_r10.texOffs(124, 11).addBox(-0.9008F, -10.8841F, -5.6298F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r11 = new ModelRenderer(this);
		LeftArm_r11.setPos(0.3084F, 1.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r11);
		setRotationAngle(LeftArm_r11, -0.8745F, -0.4493F, 0.114F);
		LeftArm_r11.texOffs(120, 2).addBox(-0.5715F, -6.0129F, -8.0936F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r12 = new ModelRenderer(this);
		LeftArm_r12.setPos(1.2743F, 8.8434F, -13.3917F);
		Leftfrontlib.addChild(LeftArm_r12);
		setRotationAngle(LeftArm_r12, -0.8071F, 0.1643F, 0.0577F);
		LeftArm_r12.texOffs(124, 11).addBox(-1.307F, -10.8518F, -5.6284F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r13 = new ModelRenderer(this);
		LeftArm_r13.setPos(0.3084F, 2.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r13);
		setRotationAngle(LeftArm_r13, -0.8492F, -0.2324F, 0.1055F);
		LeftArm_r13.texOffs(120, 2).addBox(-0.9532F, -6.0868F, -7.9718F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r14 = new ModelRenderer(this);
		LeftArm_r14.setPos(6.4042F, 5.8592F, -6.8251F);
		Leftfrontlib.addChild(LeftArm_r14);
		setRotationAngle(LeftArm_r14, -0.649F, 0.7759F, 0.8367F);
		LeftArm_r14.texOffs(96, 7).addBox(-6.9756F, 9.5664F, -8.1932F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r15 = new ModelRenderer(this);
		LeftArm_r15.setPos(3.958F, 3.1638F, -3.2644F);
		Leftfrontlib.addChild(LeftArm_r15);
		setRotationAngle(LeftArm_r15, -0.8645F, 0.5029F, 0.4813F);
		LeftArm_r15.texOffs(94, 12).addBox(-5.4723F, 3.4882F, -8.1932F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r16 = new ModelRenderer(this);
		LeftArm_r16.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r16);
		setRotationAngle(LeftArm_r16, -0.9609F, 0.12F, 0.1746F);
		LeftArm_r16.texOffs(122, 11).addBox(-2.7424F, -5.0325F, -8.1932F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r17 = new ModelRenderer(this);
		LeftArm_r17.setPos(0.2826F, 7.6205F, -4.3097F);
		Leftfrontlib.addChild(LeftArm_r17);
		setRotationAngle(LeftArm_r17, -0.6276F, 0.6532F, 0.6973F);
		LeftArm_r17.texOffs(97, 8).addBox(-7.6265F, -2.7526F, -12.4521F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r18 = new ModelRenderer(this);
		LeftArm_r18.setPos(0.0F, 7.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r18);
		setRotationAngle(LeftArm_r18, -0.8239F, 0.3297F, 0.2912F);
		LeftArm_r18.texOffs(122, 12).addBox(-4.9972F, -7.8628F, -12.4521F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 10.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.5857F, 0.1676F, 0.4395F);
		RightLeg_r1.texOffs(75, 89).addBox(-2.8474F, -1.7397F, -6.3297F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.605F, 0.045F, 0.258F);
		RightLeg_r2.texOffs(78, 90).addBox(-2.754F, -9.2437F, -6.3297F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-9.6983F, 6.5502F, -0.7084F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, 0.0433F, 0.62F, 0.0014F);
		RightLeg_r3.texOffs(78, 90).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-6.224F, 11.3943F, -4.8532F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, -0.6015F, -0.1664F, -1.8806F);
		RightLeg_r4.texOffs(78, 90).addBox(5.7809F, -5.7918F, 1.059F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r4.texOffs(78, 90).addBox(4.7809F, -0.7918F, 0.059F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(-2.6252F, 1.4955F, -3.161F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, -0.1687F, 0.045F, 0.258F);
		RightLeg_r5.texOffs(78, 90).addBox(-3.631F, -1.1054F, -0.843F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		RightLeg_r5.texOffs(78, 90).addBox(-4.631F, -16.1054F, -1.843F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r6 = new ModelRenderer(this);
		RightLeg_r6.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r6);
		setRotationAngle(RightLeg_r6, -0.5236F, 0.0F, 0.0F);
		RightLeg_r6.texOffs(85, 69).addBox(-2.3188F, 0.5138F, -10.6149F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		RightLeg_r6.texOffs(54, 75).addBox(-2.3188F, -9.4862F, -11.6149F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		RightLeg_r6.texOffs(78, 90).addBox(-4.3188F, -18.4862F, -12.6149F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r7 = new ModelRenderer(this);
		RightLeg_r7.setPos(1.9698F, 1.2504F, -1.1762F);
		RightLeg.addChild(RightLeg_r7);
		setRotationAngle(RightLeg_r7, -0.5236F, 0.0F, 0.0F);
		RightLeg_r7.texOffs(85, 69).addBox(-2.3188F, 5.5138F, -11.6149F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightLeg_r8 = new ModelRenderer(this);
		RightLeg_r8.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r8);
		setRotationAngle(RightLeg_r8, -0.9163F, 0.0F, 0.0F);
		RightLeg_r8.texOffs(91, 76).addBox(-2.3188F, -4.3076F, -13.636F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		RightLeg_r9 = new ModelRenderer(this);
		RightLeg_r9.setPos(0.3402F, 12.0249F, -3.3044F);
		RightLeg.addChild(RightLeg_r9);
		setRotationAngle(RightLeg_r9, -0.49F, 0.1925F, 0.3444F);
		RightLeg_r9.texOffs(56, 67).addBox(-5.8121F, 0.5536F, -7.6149F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r10 = new ModelRenderer(this);
		RightLeg_r10.setPos(1.0327F, 6.189F, 0.0649F);
		RightLeg.addChild(RightLeg_r10);
		setRotationAngle(RightLeg_r10, -0.5219F, 0.0436F, 0.0756F);
		RightLeg_r10.texOffs(56, 67).addBox(-5.8121F, 0.5536F, -7.6149F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r10.texOffs(56, 67).addBox(-4.8121F, 0.5536F, -10.6149F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r11 = new ModelRenderer(this);
		RightLeg_r11.setPos(-5.0078F, 5.2056F, 0.6327F);
		RightLeg.addChild(RightLeg_r11);
		setRotationAngle(RightLeg_r11, -0.338F, -0.4079F, -0.8458F);
		RightLeg_r11.texOffs(56, 67).addBox(0.2612F, 2.5658F, -10.6149F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r12 = new ModelRenderer(this);
		RightLeg_r12.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r12);
		setRotationAngle(RightLeg_r12, -0.5087F, 0.1298F, 0.228F);
		RightLeg_r12.texOffs(56, 67).addBox(-5.7791F, -4.2388F, -11.6149F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		RightLeg_r13 = new ModelRenderer(this);
		RightLeg_r13.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r13);
		setRotationAngle(RightLeg_r13, -0.0859F, 0.0151F, 0.1739F);
		RightLeg_r13.texOffs(78, 90).addBox(-6.3512F, -5.8F, -1.7464F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r14 = new ModelRenderer(this);
		RightLeg_r14.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r14);
		setRotationAngle(RightLeg_r14, -0.0873F, 0.0F, 0.0F);
		RightLeg_r14.texOffs(78, 90).addBox(-3.3188F, -5.927F, -1.7464F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		RightLeg_r14.texOffs(78, 90).addBox(-4.3188F, -20.927F, -1.7464F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r15 = new ModelRenderer(this);
		RightLeg_r15.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r15);
		setRotationAngle(RightLeg_r15, -0.0436F, 1.3526F, -0.2618F);
		RightLeg_r15.texOffs(78, 90).addBox(-1.5811F, -11.3372F, 0.4451F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r16 = new ModelRenderer(this);
		RightLeg_r16.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r16);
		setRotationAngle(RightLeg_r16, 0.1309F, 1.3526F, -0.2618F);
		RightLeg_r16.texOffs(78, 90).addBox(-1.5811F, -5.0204F, 2.1763F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r17 = new ModelRenderer(this);
		RightLeg_r17.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r17);
		setRotationAngle(RightLeg_r17, -0.1605F, -0.4269F, 0.6748F);
		RightLeg_r17.texOffs(78, 90).addBox(-3.0224F, -4.8286F, 0.8841F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r18 = new ModelRenderer(this);
		RightLeg_r18.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r18);
		setRotationAngle(RightLeg_r18, 0.1309F, -0.4363F, 0.0F);
		RightLeg_r18.texOffs(78, 90).addBox(0.2938F, -6.6889F, 0.8841F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r19 = new ModelRenderer(this);
		RightLeg_r19.setPos(-5.4837F, 10.8326F, 3.6585F);
		RightLeg.addChild(RightLeg_r19);
		setRotationAngle(RightLeg_r19, 0.3054F, -0.4363F, 0.0F);
		RightLeg_r19.texOffs(78, 90).addBox(-0.2062F, -6.7753F, 1.8434F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		RightLeg_r20 = new ModelRenderer(this);
		RightLeg_r20.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r20);
		setRotationAngle(RightLeg_r20, -0.0436F, -0.4363F, 0.0F);
		RightLeg_r20.texOffs(78, 90).addBox(-0.7062F, -1.4297F, -0.1324F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r21 = new ModelRenderer(this);
		RightLeg_r21.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r21);
		setRotationAngle(RightLeg_r21, 0.1815F, -1.1101F, 0.0283F);
		RightLeg_r21.texOffs(78, 90).addBox(-1.1421F, -15.1288F, -1.1077F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		RightLeg_r22 = new ModelRenderer(this);
		RightLeg_r22.setPos(-2.8773F, 15.1257F, 3.8799F);
		RightLeg.addChild(RightLeg_r22);
		setRotationAngle(RightLeg_r22, 0.1265F, -0.0338F, 0.2597F);
		RightLeg_r22.texOffs(78, 90).addBox(-1.2094F, -6.6865F, 0.9027F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r23 = new ModelRenderer(this);
		RightLeg_r23.setPos(-1.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r23);
		setRotationAngle(RightLeg_r23, 0.1309F, 0.0F, 0.0F);
		RightLeg_r23.texOffs(78, 90).addBox(-1.2094F, -6.6865F, 0.9027F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r24 = new ModelRenderer(this);
		RightLeg_r24.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r24);
		setRotationAngle(RightLeg_r24, -0.0436F, 0.0F, 0.0F);
		RightLeg_r24.texOffs(78, 90).addBox(-2.2094F, -1.4305F, -0.1137F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r25 = new ModelRenderer(this);
		RightLeg_r25.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r25);
		setRotationAngle(RightLeg_r25, 0.2618F, 0.0F, 0.0F);
		RightLeg_r25.texOffs(78, 90).addBox(-2.2094F, -14.8895F, 0.6286F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 9.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -0.121F, -0.05F, -0.3897F);
		LeftLeg_r1.texOffs(101, 92).addBox(3.5729F, -15.305F, -2.7047F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 3.0256F, 0.3201F, 2.7968F);
		LeftLeg_r2.texOffs(96, 35).addBox(-1.7541F, -5.2945F, 1.3906F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, 3.0268F, 0.305F, 2.2461F);
		LeftLeg_r3.texOffs(101, 92).addBox(-4.0553F, -1.4399F, 2.1304F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r4 = new ModelRenderer(this);
		LeftLeg_r4.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r4);
		setRotationAngle(LeftLeg_r4, -3.1269F, 0.3249F, 2.6589F);
		LeftLeg_r4.texOffs(101, 92).addBox(-5.0553F, -3.4399F, 2.1304F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r5 = new ModelRenderer(this);
		LeftLeg_r5.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r5);
		setRotationAngle(LeftLeg_r5, -2.9871F, 0.2874F, 3.1152F);
		LeftLeg_r5.texOffs(101, 92).addBox(-3.0553F, -6.4399F, 2.1304F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg_r6 = new ModelRenderer(this);
		LeftLeg_r6.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r6);
		setRotationAngle(LeftLeg_r6, -3.0831F, 0.3201F, 2.7968F);
		LeftLeg_r6.texOffs(101, 92).addBox(-4.7541F, -13.1614F, 2.1304F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		LeftLeg_r6.texOffs(101, 92).addBox(-2.7541F, -12.1614F, 2.1304F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		LeftLeg_r7 = new ModelRenderer(this);
		LeftLeg_r7.setPos(-3.3457F, 4.7914F, -7.1957F);
		LeftLeg.addChild(LeftLeg_r7);
		setRotationAngle(LeftLeg_r7, 0.2696F, -0.0447F, -0.3463F);
		LeftLeg_r7.texOffs(101, 92).addBox(6.2291F, -1.8831F, 0.5448F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r8 = new ModelRenderer(this);
		LeftLeg_r8.setPos(6.0333F, 14.8874F, -3.0176F);
		LeftLeg.addChild(LeftLeg_r8);
		setRotationAngle(LeftLeg_r8, -0.9249F, 0.4264F, -0.8026F);
		LeftLeg_r8.texOffs(101, 92).addBox(3.9298F, -6.5727F, -3.1335F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r9 = new ModelRenderer(this);
		LeftLeg_r9.setPos(-3.2859F, 5.2417F, -5.0329F);
		LeftLeg.addChild(LeftLeg_r9);
		setRotationAngle(LeftLeg_r9, 0.0951F, -0.0447F, -0.3463F);
		LeftLeg_r9.texOffs(101, 92).addBox(7.2291F, 5.2819F, -0.5143F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r10 = new ModelRenderer(this);
		LeftLeg_r10.setPos(-2.0081F, 5.5409F, -6.2858F);
		LeftLeg.addChild(LeftLeg_r10);
		setRotationAngle(LeftLeg_r10, -0.1289F, -0.0227F, -0.1731F);
		LeftLeg_r10.texOffs(101, 92).addBox(2.1792F, 6.0432F, -2.7047F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftLeg_r10.texOffs(101, 92).addBox(1.1792F, 3.0432F, -2.7047F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r11 = new ModelRenderer(this);
		LeftLeg_r11.setPos(-3.8474F, 7.1788F, -11.4113F);
		LeftLeg.addChild(LeftLeg_r11);
		setRotationAngle(LeftLeg_r11, -0.1135F, -0.0653F, -0.5199F);
		LeftLeg_r11.texOffs(101, 92).addBox(-1.8208F, 1.0432F, -1.7047F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg_r12 = new ModelRenderer(this);
		LeftLeg_r12.setPos(-2.1632F, -4.0475F, -9.018F);
		LeftLeg.addChild(LeftLeg_r12);
		setRotationAngle(LeftLeg_r12, -0.2704F, -0.0983F, 0.0644F);
		LeftLeg_r12.texOffs(114, 64).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r13 = new ModelRenderer(this);
		LeftLeg_r13.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r13);
		setRotationAngle(LeftLeg_r13, -0.1308F, 0.0057F, 0.0433F);
		LeftLeg_r13.texOffs(101, 92).addBox(-0.0604F, -2.0838F, -3.7047F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r14 = new ModelRenderer(this);
		LeftLeg_r14.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r14);
		setRotationAngle(LeftLeg_r14, -0.1278F, -0.0283F, -0.2164F);
		LeftLeg_r14.texOffs(101, 92).addBox(0.1633F, -15.8069F, -4.7047F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r15 = new ModelRenderer(this);
		LeftLeg_r15.setPos(-2.8778F, 11.009F, 8.8684F);
		LeftLeg.addChild(LeftLeg_r15);
		setRotationAngle(LeftLeg_r15, -0.2818F, -0.0458F, -0.0047F);
		LeftLeg_r15.texOffs(112, 109).addBox(-0.3105F, -5.879F, -3.6515F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg_r16 = new ModelRenderer(this);
		LeftLeg_r16.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r16);
		setRotationAngle(LeftLeg_r16, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r16.texOffs(112, 109).addBox(6.8182F, -0.5044F, 8.8813F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		LeftLeg_r16.texOffs(112, 109).addBox(6.8182F, 1.4956F, 8.8813F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg_r16.texOffs(112, 109).addBox(6.8182F, -2.5044F, 7.8813F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r17 = new ModelRenderer(this);
		LeftLeg_r17.setPos(11.4441F, 6.5575F, 4.7056F);
		LeftLeg.addChild(LeftLeg_r17);
		setRotationAngle(LeftLeg_r17, 1.4068F, 0.2521F, 0.0452F);
		LeftLeg_r17.texOffs(102, 23).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r18 = new ModelRenderer(this);
		LeftLeg_r18.setPos(6.6774F, 10.511F, 6.5659F);
		LeftLeg.addChild(LeftLeg_r18);
		setRotationAngle(LeftLeg_r18, -0.0915F, 0.5398F, -1.2653F);
		LeftLeg_r18.texOffs(114, 23).addBox(4.9202F, 0.2444F, 0.8813F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		LeftLeg_r18.texOffs(100, 23).addBox(4.9202F, -2.7556F, 0.8813F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		LeftLeg_r19 = new ModelRenderer(this);
		LeftLeg_r19.setPos(4.2319F, 7.2039F, 6.4029F);
		LeftLeg.addChild(LeftLeg_r19);
		setRotationAngle(LeftLeg_r19, 1.3974F, 0.2072F, -0.0254F);
		LeftLeg_r19.texOffs(113, 66).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftLeg_r20 = new ModelRenderer(this);
		LeftLeg_r20.setPos(4.8443F, 9.0801F, 9.3639F);
		LeftLeg.addChild(LeftLeg_r20);
		setRotationAngle(LeftLeg_r20, 0.5991F, 0.5099F, -0.4257F);
		LeftLeg_r20.texOffs(113, 66).addBox(-0.5F, -2.0F, 1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r21 = new ModelRenderer(this);
		LeftLeg_r21.setPos(-3.7346F, 9.2118F, 7.4768F);
		LeftLeg.addChild(LeftLeg_r21);
		setRotationAngle(LeftLeg_r21, 0.2441F, 0.7634F, -0.1541F);
		LeftLeg_r21.texOffs(113, 66).addBox(6.1526F, -2.5596F, 4.4193F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r22 = new ModelRenderer(this);
		LeftLeg_r22.setPos(-2.6153F, 12.9096F, 9.4445F);
		LeftLeg.addChild(LeftLeg_r22);
		setRotationAngle(LeftLeg_r22, 0.1356F, -0.2792F, 1.5097F);
		LeftLeg_r22.texOffs(113, 66).addBox(-6.9407F, 2.0195F, -0.3091F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r23 = new ModelRenderer(this);
		LeftLeg_r23.setPos(0.3132F, 8.893F, 11.2963F);
		LeftLeg.addChild(LeftLeg_r23);
		setRotationAngle(LeftLeg_r23, 0.427F, 0.297F, -0.439F);
		LeftLeg_r23.texOffs(113, 66).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r24 = new ModelRenderer(this);
		LeftLeg_r24.setPos(-2.4699F, 5.453F, 7.954F);
		LeftLeg.addChild(LeftLeg_r24);
		setRotationAngle(LeftLeg_r24, 0.7987F, 0.2599F, -0.3568F);
		LeftLeg_r24.texOffs(113, 66).addBox(0.0F, -2.5F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		LeftLeg_r25 = new ModelRenderer(this);
		LeftLeg_r25.setPos(-2.6793F, 11.3583F, 8.9952F);
		LeftLeg.addChild(LeftLeg_r25);
		setRotationAngle(LeftLeg_r25, 0.257F, -0.1746F, 0.9826F);
		LeftLeg_r25.texOffs(113, 66).addBox(-5.9045F, -6.8865F, -0.3091F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r26 = new ModelRenderer(this);
		LeftLeg_r26.setPos(2.4477F, 7.2158F, 5.8952F);
		LeftLeg.addChild(LeftLeg_r26);
		setRotationAngle(LeftLeg_r26, 1.0504F, 0.0524F, 0.8515F);
		LeftLeg_r26.texOffs(113, 66).addBox(-5.2441F, -5.6105F, -0.1168F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r27 = new ModelRenderer(this);
		LeftLeg_r27.setPos(-3.0047F, 9.9526F, 6.5206F);
		LeftLeg.addChild(LeftLeg_r27);
		setRotationAngle(LeftLeg_r27, 0.375F, 0.7634F, -0.1541F);
		LeftLeg_r27.texOffs(113, 66).addBox(5.1526F, -9.3262F, 5.1416F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r28 = new ModelRenderer(this);
		LeftLeg_r28.setPos(-4.7346F, 9.2118F, 1.4768F);
		LeftLeg.addChild(LeftLeg_r28);
		setRotationAngle(LeftLeg_r28, 0.4241F, -0.5792F, -0.1329F);
		LeftLeg_r28.texOffs(113, 66).addBox(4.887F, -2.8236F, 2.109F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r29 = new ModelRenderer(this);
		LeftLeg_r29.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r29);
		setRotationAngle(LeftLeg_r29, 0.555F, -0.5792F, -0.1329F);
		LeftLeg_r29.texOffs(113, 66).addBox(3.887F, -9.6284F, 3.8685F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r30 = new ModelRenderer(this);
		LeftLeg_r30.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r30);
		setRotationAngle(LeftLeg_r30, 0.5151F, -0.8108F, -0.4443F);
		LeftLeg_r30.texOffs(112, 109).addBox(6.7527F, -23.8216F, -1.7624F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftLeg_r31 = new ModelRenderer(this);
		LeftLeg_r31.setPos(7.5872F, 7.1335F, -0.1865F);
		LeftLeg.addChild(LeftLeg_r31);
		setRotationAngle(LeftLeg_r31, 0.9925F, 0.0954F, -0.931F);
		LeftLeg_r31.texOffs(112, 109).addBox(-0.5F, 2.5F, -2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r32 = new ModelRenderer(this);
		LeftLeg_r32.setPos(7.5872F, 7.1335F, -0.1865F);
		LeftLeg.addChild(LeftLeg_r32);
		setRotationAngle(LeftLeg_r32, 0.3816F, 0.0954F, -0.931F);
		LeftLeg_r32.texOffs(112, 109).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r33 = new ModelRenderer(this);
		LeftLeg_r33.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r33);
		setRotationAngle(LeftLeg_r33, -0.0363F, 0.3309F, -0.1175F);
		LeftLeg_r33.texOffs(112, 109).addBox(5.8182F, -3.7436F, -3.904F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg_r33.texOffs(112, 109).addBox(4.8182F, -11.7436F, -4.904F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r34 = new ModelRenderer(this);
		LeftLeg_r34.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r34);
		setRotationAngle(LeftLeg_r34, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r34.texOffs(112, 109).addBox(2.8182F, -11.5044F, 2.8813F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r35 = new ModelRenderer(this);
		LeftLeg_r35.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r35);
		setRotationAngle(LeftLeg_r35, 0.3532F, 0.1942F, -0.1118F);
		LeftLeg_r35.texOffs(112, 109).addBox(6.68F, -24.7123F, 4.2203F, 4.0F, 15.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.3F * limbSwingAmount;
		this.LeftLeg.yRot = MathHelper.cos(limbSwing * 0.5662F) * 0.4F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.3F * limbSwingAmount;
		this.RightLeg.yRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.3F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.wing3.yRot = netHeadYaw * 0.009453292F;
		this.wing4.yRot = netHeadYaw * 0.009453292F;

		this.wingDown.yRot = netHeadYaw * 0.009453292F;
		this.wingDown2.yRot = netHeadYaw * 0.009453292F;
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