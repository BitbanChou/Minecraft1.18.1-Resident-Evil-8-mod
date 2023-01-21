// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMiranda4;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMiranda4<T extends EntityMiranda4> extends EntityModel<T> {
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
	private final ModelRenderer wing3;
	private final ModelRenderer wingp_r17;
	private final ModelRenderer wingp_r18;
	private final ModelRenderer wingp_r19;
	private final ModelRenderer wingp_r20;
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
	private final ModelRenderer wingp_r56;
	private final ModelRenderer wingp_r57;
	private final ModelRenderer wingp_r58;
	private final ModelRenderer wingp_r59;
	private final ModelRenderer wingp_r60;
	private final ModelRenderer wing6;
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
	private final ModelRenderer wingp_r78;
	private final ModelRenderer wingp_r79;
	private final ModelRenderer wingp_r80;
	private final ModelRenderer wingp_r81;
	private final ModelRenderer wingp_r82;
	private final ModelRenderer wing5;
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
	private final ModelRenderer wing2;
	private final ModelRenderer wingp_r104;
	private final ModelRenderer wingp_r105;
	private final ModelRenderer wingp_r106;
	private final ModelRenderer wingp_r107;
	private final ModelRenderer wingp_r108;
	private final ModelRenderer wingp_r109;
	private final ModelRenderer wingp_r110;
	private final ModelRenderer wingp_r111;
	private final ModelRenderer wingp_r112;
	private final ModelRenderer wingp_r113;
	private final ModelRenderer bone;
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
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer Leftfrontlib;
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
	private final ModelRenderer LeftArm_r19;
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

	public ModelMiranda4() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(2.5556F, -49.0556F, 37.6111F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-0.6825F, 25.6979F, -33.5246F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.1309F, -1.5708F);
		Head_r1.texOffs(38, 5).addBox(27.9165F, -1.9993F, 33.8236F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-5.9267F, 29.4423F, -40.6752F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.0172F, -0.1298F, 1.7028F);
		Head_r2.texOffs(28, 6).addBox(-30.5607F, 1.3F, 41.2713F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-5.6633F, 30.871F, -40.4871F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.1304F, -0.0114F, 3.0551F);
		Head_r3.texOffs(28, 10).addBox(-8.0088F, 30.045F, 41.2713F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Head_r3.texOffs(26, 13).addBox(-8.0088F, 29.045F, 41.2713F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-0.8953F, 27.3199F, -40.823F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.0503F, 0.1209F, -1.9665F);
		Head_r4.texOffs(40, 7).addBox(23.0673F, 14.3375F, 41.2713F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-3.9848F, 27.2289F, -41.4539F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.4002F, -0.0539F, 1.8047F);
		Head_r5.texOffs(26, 8).addBox(-33.3109F, 23.4496F, 33.5524F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-7.8558F, 25.6241F, -38.4322F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.0401F, -0.4463F, 1.8201F);
		Head_r6.texOffs(26, 3).addBox(-15.2486F, 2.8372F, 47.7266F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(1.7447F, 25.6241F, -38.4322F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.0401F, 0.4463F, -1.8201F);
		Head_r7.texOffs(27, 0).addBox(11.9134F, 8.6727F, 47.321F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(-2.1263F, 27.2289F, -41.4539F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 0.4002F, 0.0539F, -1.8047F);
		Head_r8.texOffs(45, 12).addBox(28.922F, 28.7959F, 31.2097F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(-0.4479F, 30.871F, -40.4871F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, -0.1304F, 0.0114F, -3.0551F);
		Head_r9.texOffs(28, 12).addBox(-1.9683F, 29.5679F, 41.2713F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r9.texOffs(22, 18).addBox(-2.9683F, 30.5679F, 41.2713F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-6.0404F, 26.3822F, -33.4345F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.1074F, -0.0749F, 2.5348F);
		Head_r10.texOffs(37, 8).addBox(-26.0433F, 17.9669F, 33.8236F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(-3.5556F, 32.1988F, -32.6688F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, 0.1188F, -0.0552F, 0.4331F);
		Head_r11.texOffs(23, 2).addBox(-16.5017F, -32.4744F, 33.8236F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(-2.5556F, 33.1988F, -32.6688F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.1309F, 0.0F, 0.0F);
		Head_r12.texOffs(0, 62).addBox(-2.0F, -38.9158F, 34.8236F, 9.0F, 9.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		setRotationAngle(Body, 0.0436F, 0.0F, 0.0F);
		Body.texOffs(44, 7).addBox(-3.0F, -46.1926F, 35.8334F, 12.0F, 12.0F, 11.0F, 0.0F, false);
		Body.texOffs(44, 7).addBox(-2.0F, -47.1926F, 36.8334F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Body.texOffs(86, 109).addBox(0.0F, -41.1926F, 46.8334F, 5.0F, 7.0F, 2.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-3.0F, -34.1926F, 35.8334F, 11.0F, 8.0F, 9.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-2.0F, -26.1926F, 36.8334F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		Body.texOffs(52, 60).addBox(0.6144F, -25.4323F, 35.5888F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(-3.0F, -6.0F, -1.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.4363F, -0.5672F, 0.0F);
		Body_r1.texOffs(51, 54).addBox(21.0072F, -5.2585F, 34.7039F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(3.0F, -6.0F, -1.5F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.4363F, 0.5672F, 0.0F);
		Body_r2.texOffs(51, 54).addBox(-19.9469F, -3.8961F, 37.6257F, 3.0F, 4.0F, 7.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(3.5F, -12.0F, -10.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, 0.3927F);
		Body_r3.texOffs(69, 50).addBox(-5.6904F, -17.9558F, 45.3334F, 3.0F, 8.0F, 3.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(-3.5F, -12.0F, -10.5F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.0F, -0.3927F);
		Body_r4.texOffs(69, 50).addBox(8.2336F, -15.6597F, 45.3334F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(0.0F, -26.0F, -0.5F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.0436F, 0.0F);
		Body_r5.texOffs(2, 47).addBox(-0.8276F, -24.1926F, 40.4244F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(0.5F, -22.0F, -3.5F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.6109F, 0.0F, 0.0F);
		Body_r6.texOffs(44, 7).addBox(4.0F, -42.8971F, 20.3331F, 3.0F, 6.0F, 5.0F, 0.0F, false);
		Body_r6.texOffs(44, 7).addBox(-1.7F, -42.8971F, 20.3331F, 3.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-0.5F, -28.5F, 5.0F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.3927F, 0.0F, 0.0F);
		Body_r7.texOffs(86, 109).addBox(0.5F, -1.2988F, 44.611F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		circle = new ModelRenderer(this);
		circle.setPos(-0.1203F, -20.1391F, 5.0F);
		Body.addChild(circle);
		circle.texOffs(44, 0).addBox(1.3471F, -32.6778F, 40.8334F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(3.7403F, -10.2461F, 0.0F);
		circle.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.0F, 3.0543F);
		Body_r8.texOffs(44, 0).addBox(-3.0742F, 15.8619F, 41.8334F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r8.texOffs(44, 0).addBox(-3.0742F, 16.8619F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-5.4996F, -10.2461F, 0.0F);
		circle.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.0F, -3.0543F);
		Body_r9.texOffs(44, 0).addBox(-6.903F, 17.3848F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(3.27F, -10.6594F, 0.0F);
		circle.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, 2.7053F);
		Body_r10.texOffs(44, 0).addBox(-11.9074F, 14.2202F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(13.2609F, -22.5389F, -0.5F);
		circle.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.0F, -2.3998F);
		Body_r11.texOffs(44, 0).addBox(18.0789F, 13.1178F, 41.3334F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(18.0789F, 11.4397F, 41.3334F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r11.texOffs(44, 0).addBox(19.0789F, 14.7178F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(12.7023F, -20.4394F, -0.5F);
		circle.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.0F, -2.2253F);
		Body_r12.texOffs(44, 0).addBox(17.6069F, 12.455F, 41.3334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(13.2743F, -14.3363F, -0.5F);
		circle.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, -1.9199F);
		Body_r13.texOffs(44, 0).addBox(21.0694F, 8.0413F, 41.3334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(10.7615F, -16.7378F, -0.5F);
		circle.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, -1.309F);
		Body_r14.texOffs(44, 0).addBox(15.3491F, -2.8108F, 41.3334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(-0.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, -0.2618F, 0.9599F);
		Body_r15.texOffs(44, 0).addBox(-2.9053F, -9.3923F, 43.8196F, 5.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.2137F, 0.0211F, -0.0118F);
		Body_r16.texOffs(41, 2).addBox(-1.669F, -5.3594F, 44.7893F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.2618F, -0.9599F);
		Body_r17.texOffs(44, 0).addBox(1.2295F, -4.4774F, 44.7103F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(1.1203F, -14.3609F, 0.0F);
		circle.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.0F, -0.9599F);
		Body_r18.texOffs(44, 0).addBox(21.6232F, -3.4774F, 39.8334F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(14.6232F, -3.4774F, 39.8334F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		Body_r18.texOffs(44, 0).addBox(15.6232F, -4.4774F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(1.1343F, -12.6419F, 0.0F);
		circle.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, -1.1345F);
		Body_r19.texOffs(44, 0).addBox(16.7559F, 1.5304F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(7.6254F, -18.3427F, 0.0F);
		circle.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, -1.5272F);
		Body_r20.texOffs(44, 0).addBox(15.3061F, 1.2036F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(5.2466F, -13.7737F, -0.5F);
		circle.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 0.6981F);
		Body_r21.texOffs(44, 0).addBox(-12.3958F, -15.3647F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(5.9307F, -15.6531F, -0.5F);
		circle.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 0.3491F);
		Body_r22.texOffs(44, 0).addBox(-6.4031F, -18.6215F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(9.4785F, -23.1806F, -0.5F);
		circle.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, -0.6545F);
		Body_r23.texOffs(44, 0).addBox(10.955F, -14.1069F, 41.3334F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(2.7341F, -20.7797F, -5.0F);
		circle.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, -0.1309F);
		Body_r24.texOffs(44, 0).addBox(10.8489F, -15.6454F, 45.8334F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r24.texOffs(44, 0).addBox(5.8489F, -15.6454F, 45.8334F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(2.7341F, -20.7797F, -5.0F);
		circle.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, -0.9599F);
		Body_r25.texOffs(44, 0).addBox(20.1232F, -8.9774F, 45.8334F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r25.texOffs(44, 0).addBox(16.1232F, -7.9774F, 45.8334F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-5.0059F, -13.7737F, -0.5F);
		circle.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, -0.6981F);
		Body_r26.texOffs(44, 0).addBox(11.9921F, -11.508F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-1.7797F, 25.5909F, -10.8791F);
		circle.addChild(Body_r27);
		setRotationAngle(Body_r27, -0.1441F, -0.084F, -0.6939F);
		Body_r27.texOffs(114, 64).addBox(22.422F, -32.1231F, 42.4611F, 2.0F, 8.0F, 2.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(2.0203F, 25.5909F, -10.8791F);
		circle.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.1441F, 0.084F, 0.6939F);
		Body_r28.texOffs(114, 64).addBox(-22.8258F, -33.9762F, 43.2928F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(-5.69F, -15.6531F, -0.5F);
		circle.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, -0.3491F);
		Body_r29.texOffs(44, 0).addBox(7.0413F, -16.5694F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-8.7421F, -23.1153F, -0.5F);
		circle.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.0F, 0.6109F);
		Body_r30.texOffs(44, 0).addBox(-9.9774F, -16.1232F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r30.texOffs(44, 0).addBox(-9.9774F, -19.1232F, 41.3334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-2.4935F, -20.7797F, -5.0F);
		circle.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.0F, 0.1309F);
		Body_r31.texOffs(44, 0).addBox(-3.9003F, -16.4285F, 45.8334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-2.4935F, -20.7797F, -5.0F);
		circle.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.0F, 0.9599F);
		Body_r32.texOffs(44, 0).addBox(-16.6818F, -11.8923F, 45.8334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(-0.5532F, -21.1868F, -5.0F);
		circle.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, 0.0F, 3.0107F);
		Body_r33.texOffs(44, 0).addBox(-5.8489F, 16.6454F, 45.8334F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-8.6239F, -17.1063F, 0.0F);
		circle.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.0F, 1.789F);
		Body_r34.texOffs(44, 0).addBox(-22.4107F, -3.9913F, 40.8334F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r34.texOffs(44, 0).addBox(-22.4107F, 0.0087F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(4.1591F, -16.6553F, -0.5F);
		circle.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.0F, -1.6581F);
		Body_r35.texOffs(44, 0).addBox(17.3619F, 3.0742F, 41.3334F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(-3.9185F, -16.6553F, -0.5F);
		circle.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, 0.0F, 1.6581F);
		Body_r36.texOffs(44, 0).addBox(-19.8848F, -1.903F, 41.3334F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-3.5549F, -15.5447F, -0.5F);
		circle.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0F, 1.0908F);
		Body_r37.texOffs(44, 0).addBox(-15.7518F, -11.5614F, 41.3334F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(2.7955F, -15.5447F, -0.5F);
		circle.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, 0.0F, -1.0908F);
		Body_r38.texOffs(44, 0).addBox(16.5223F, -6.2394F, 41.3334F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(7.8646F, -17.1063F, 0.0F);
		circle.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, -1.789F);
		Body_r39.texOffs(44, 0).addBox(19.112F, 1.8665F, 40.8334F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r39.texOffs(44, 0).addBox(18.112F, 5.8665F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(3.7365F, -21.413F, 0.0F);
		circle.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0F, 0.0F, -2.3126F);
		Body_r40.texOffs(46, 0).addBox(8.3862F, 15.5026F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-0.4869F, -25.7504F, -1.0F);
		circle.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0F, 0.0F, -2.4435F);
		Body_r41.texOffs(44, 0).addBox(7.8958F, 12.6647F, 41.8334F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(0.7276F, -25.7504F, -1.0F);
		circle.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0F, 0.0F, 2.4435F);
		Body_r42.texOffs(44, 0).addBox(-15.4921F, 9.808F, 41.8334F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-0.5073F, -25.301F, -1.0F);
		circle.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0F, 0.0F, -2.3562F);
		Body_r43.texOffs(0, 0).addBox(9.0427F, 12.7854F, 40.8334F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-0.5073F, -25.301F, -1.0F);
		circle.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0F, 0.0F, -3.1416F);
		Body_r44.texOffs(114, 2).addBox(-6.0723F, 6.9926F, 41.8334F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-4.5F, 13.9926F, 41.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r44.texOffs(44, 0).addBox(-4.5F, 17.1926F, 41.8334F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-0.2062F, -21.1868F, -5.0F);
		circle.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0F, 0.0F, -3.0107F);
		Body_r45.texOffs(44, 0).addBox(-2.0997F, 17.4285F, 45.8334F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(2.2407F, -25.0F, 0.0F);
		circle.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0F, 0.0F, -2.9234F);
		Body_r46.texOffs(44, 0).addBox(-0.4913F, 17.4107F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(-1.3234F, -23.7391F, 0.0F);
		circle.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0F, 0.0F, 2.4871F);
		Body_r47.texOffs(44, 0).addBox(-16.455F, 19.6069F, 40.8334F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-1.3234F, -23.7391F, 0.0F);
		circle.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0F, 0.0F, 2.7053F);
		Body_r48.texOffs(44, 0).addBox(-12.4074F, 20.2202F, 40.8334F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-4.5602F, -21.7872F, 0.0F);
		circle.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.0F, 0.0F, 2.1817F);
		Body_r49.texOffs(44, 0).addBox(-19.6232F, 12.9774F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(-4.4958F, -21.413F, 0.0F);
		circle.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0F, 0.0F, 2.3126F);
		Body_r50.texOffs(44, 0).addBox(-18.4397F, 11.0789F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(-4.0293F, -10.6594F, 0.0F);
		circle.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0F, 0.0F, -2.7053F);
		Body_r51.texOffs(44, 0).addBox(3.4696F, 16.7559F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(-7.3827F, -18.9242F, 0.0F);
		circle.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0F, 0.0F, 1.6581F);
		Body_r52.texOffs(44, 0).addBox(-22.3848F, 1.597F, 40.8334F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-8.3847F, -18.3427F, 0.0F);
		circle.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0F, 0.0F, 1.5272F);
		Body_r53.texOffs(44, 0).addBox(-18.0444F, -4.7907F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-2.5283F, -16.2157F, 0.0F);
		circle.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0F, 0.0F, 1.3963F);
		Body_r54.texOffs(44, 0).addBox(-22.3952F, 1.3865F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-1.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0F, 0.0F, 1.2654F);
		Body_r55.texOffs(44, 0).addBox(-21.4484F, -1.8318F, 39.8334F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-1.8797F, -14.3609F, 0.0F);
		circle.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0F, 0.0F, 0.9599F);
		Body_r56.texOffs(44, 0).addBox(-18.1818F, -8.3923F, 39.8334F, 6.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-18.1818F, -6.3923F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, true);
		Body_r56.texOffs(44, 0).addBox(-18.1818F, -9.3923F, 40.8334F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-3.0F, -25.0F, 0.0F);
		circle.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0F, 0.0F, 2.9234F);
		Body_r57.texOffs(44, 0).addBox(-8.3665F, 16.112F, 40.8334F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wing = new ModelRenderer(this);
		wing.setPos(6.0F, -34.0F, 47.0F);
		Body.addChild(wing);
		setRotationAngle(wing, 0.0F, -0.3927F, -0.0873F);
		wing.texOffs(71, 46).addBox(2.3824F, -8.0571F, -1.7594F, 8.0F, 7.0F, 3.0F, 0.0F, false);
		wing.texOffs(90, 103).addBox(-2.6176F, -5.0571F, -1.7594F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		wingp_r1 = new ModelRenderer(this);
		wingp_r1.setPos(32.3614F, 14.119F, -47.9592F);
		wing.addChild(wingp_r1);
		setRotationAngle(wingp_r1, -0.064F, 0.1397F, 0.5531F);
		wingp_r1.texOffs(112, 59).addBox(-14.7626F, -21.6668F, 38.9519F, 7.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r2 = new ModelRenderer(this);
		wingp_r2.setPos(56.8543F, 57.9655F, -20.2075F);
		wing.addChild(wingp_r2);
		setRotationAngle(wingp_r2, 0.2203F, 0.021F, 1.4504F);
		wingp_r2.texOffs(72, 46).addBox(-10.0F, -2.0F, -2.0F, 20.0F, 4.0F, 4.0F, 0.0F, false);

		wingp_r3 = new ModelRenderer(this);
		wingp_r3.setPos(56.2234F, 21.8041F, -11.2411F);
		wing.addChild(wingp_r3);
		setRotationAngle(wingp_r3, 0.3025F, 0.1179F, 1.9266F);
		wingp_r3.texOffs(72, 46).addBox(16.5F, -17.0F, -6.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		wingp_r4 = new ModelRenderer(this);
		wingp_r4.setPos(53.5852F, 23.6167F, -10.9725F);
		wing.addChild(wingp_r4);
		setRotationAngle(wingp_r4, 0.2853F, 0.1559F, 1.8002F);
		wingp_r4.texOffs(72, 46).addBox(15.5F, -11.0F, -6.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		wingp_r4.texOffs(72, 46).addBox(22.5F, -13.0F, -6.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		wingp_r5 = new ModelRenderer(this);
		wingp_r5.setPos(53.5852F, 23.6167F, -10.9725F);
		wing.addChild(wingp_r5);
		setRotationAngle(wingp_r5, 0.2265F, 0.2338F, 1.499F);
		wingp_r5.texOffs(72, 46).addBox(2.5F, -3.0F, -6.0F, 23.0F, 6.0F, 5.0F, 0.0F, false);

		wingp_r6 = new ModelRenderer(this);
		wingp_r6.setPos(23.7548F, 18.584F, -48.2152F);
		wing.addChild(wingp_r6);
		setRotationAngle(wingp_r6, 0.1824F, 0.2693F, 1.3226F);
		wingp_r6.texOffs(74, 49).addBox(-38.5462F, -16.8588F, 37.5204F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		wingp_r6.texOffs(74, 49).addBox(-32.5462F, -18.8588F, 37.5204F, 18.0F, 5.0F, 5.0F, 0.0F, false);

		wingp_r7 = new ModelRenderer(this);
		wingp_r7.setPos(23.7548F, 18.584F, -48.2152F);
		wing.addChild(wingp_r7);
		setRotationAngle(wingp_r7, 0.1452F, 0.2907F, 1.1882F);
		wingp_r7.texOffs(51, 51).addBox(-25.5462F, -20.8588F, 37.5204F, 33.0F, 4.0F, 5.0F, 0.0F, false);

		wingp_r8 = new ModelRenderer(this);
		wingp_r8.setPos(31.308F, 16.1771F, -49.5979F);
		wing.addChild(wingp_r8);
		setRotationAngle(wingp_r8, -0.0961F, 0.3099F, 0.4101F);
		wingp_r8.texOffs(96, 46).addBox(-15.5462F, -23.8588F, 37.5204F, 7.0F, 4.0F, 2.0F, 0.0F, false);

		wingp_r9 = new ModelRenderer(this);
		wingp_r9.setPos(26.308F, 12.1771F, -48.5979F);
		wing.addChild(wingp_r9);
		setRotationAngle(wingp_r9, -0.8349F, 0.2947F, 0.2739F);
		wingp_r9.texOffs(96, 46).addBox(-19.5601F, -43.9522F, 12.6245F, 10.0F, 2.0F, 4.0F, 0.0F, false);

		wingp_r10 = new ModelRenderer(this);
		wingp_r10.setPos(24.2862F, 20.8063F, -49.239F);
		wing.addChild(wingp_r10);
		setRotationAngle(wingp_r10, 0.0814F, 0.2947F, 0.2739F);
		wingp_r10.texOffs(90, 46).addBox(-16.1165F, -24.4846F, 41.0085F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r11 = new ModelRenderer(this);
		wingp_r11.setPos(14.0168F, 23.6453F, -46.363F);
		wing.addChild(wingp_r11);
		setRotationAngle(wingp_r11, 0.0547F, 0.3006F, 0.1828F);
		wingp_r11.texOffs(51, 57).addBox(-9.9171F, -30.4428F, 41.3538F, 6.0F, 3.0F, 4.0F, 0.0F, false);

		wingp_r12 = new ModelRenderer(this);
		wingp_r12.setPos(32.0626F, -7.5517F, -3.6435F);
		wing.addChild(wingp_r12);
		setRotationAngle(wingp_r12, -0.0778F, 0.6185F, 0.5168F);
		wingp_r12.texOffs(112, 59).addBox(-3.5F, -1.5F, -2.0F, 7.0F, 3.0F, 4.0F, 0.0F, false);

		wingp_r13 = new ModelRenderer(this);
		wingp_r13.setPos(21.6664F, 8.4199F, -46.2523F);
		wing.addChild(wingp_r13);
		setRotationAngle(wingp_r13, -0.1253F, 0.089F, 0.0284F);
		wingp_r13.texOffs(110, 47).addBox(-3.1703F, -24.5962F, 38.9519F, 7.0F, 3.0F, 4.0F, 0.0F, false);

		wingp_r14 = new ModelRenderer(this);
		wingp_r14.setPos(6.4363F, 24.0422F, -43.4486F);
		wing.addChild(wingp_r14);
		setRotationAngle(wingp_r14, -0.1309F, 0.3054F, 0.0F);
		wingp_r14.texOffs(83, 49).addBox(-3.3741F, -40.3336F, 37.1692F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r15 = new ModelRenderer(this);
		wingp_r15.setPos(6.4363F, 24.0422F, -43.4486F);
		wing.addChild(wingp_r15);
		setRotationAngle(wingp_r15, 0.0F, 0.3054F, 0.0F);
		wingp_r15.texOffs(77, 49).addBox(-3.3741F, -32.0993F, 40.8538F, 7.0F, 3.0F, 4.0F, 0.0F, false);

		wingp_r16 = new ModelRenderer(this);
		wingp_r16.setPos(12.9845F, -7.6355F, -1.8958F);
		wing.addChild(wingp_r16);
		setRotationAngle(wingp_r16, -0.0681F, 0.298F, -0.2284F);
		wingp_r16.texOffs(72, 48).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		wing3 = new ModelRenderer(this);
		wing3.setPos(3.0F, -40.0F, 49.0F);
		Body.addChild(wing3);
		setRotationAngle(wing3, -0.2732F, -0.0865F, -0.7413F);
		wing3.texOffs(0, 116).addBox(7.6122F, -1.7361F, -1.4667F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wing3.texOffs(1, 119).addBox(-0.3878F, -1.7361F, -1.4667F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r17 = new ModelRenderer(this);
		wingp_r17.setPos(0.5326F, 30.3933F, -40.008F);
		wing3.addChild(wingp_r17);
		setRotationAngle(wingp_r17, 0.0F, 0.3054F, 0.0F);
		wingp_r17.texOffs(88, 86).addBox(16.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r18 = new ModelRenderer(this);
		wingp_r18.setPos(1.3576F, 31.0824F, -40.2681F);
		wing3.addChild(wingp_r18);
		setRotationAngle(wingp_r18, -0.0547F, 0.3006F, -0.1828F);
		wingp_r18.texOffs(22, 52).addBox(18.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		wingp_r19 = new ModelRenderer(this);
		wingp_r19.setPos(-0.9494F, 116.7368F, -62.3566F);
		wing3.addChild(wingp_r19);
		setRotationAngle(wingp_r19, -0.5821F, 1.2564F, 0.0427F);
		wingp_r19.texOffs(87, 83).addBox(-30.3031F, -55.442F, 8.9077F, 3.0F, 40.0F, 3.0F, 0.0F, false);

		wingp_r20 = new ModelRenderer(this);
		wingp_r20.setPos(47.0984F, 31.4275F, -25.7451F);
		wing3.addChild(wingp_r20);
		setRotationAngle(wingp_r20, 0.5366F, 0.7419F, 0.4476F);
		wingp_r20.texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r21 = new ModelRenderer(this);
		wingp_r21.setPos(47.0984F, 31.4275F, -25.7451F);
		wing3.addChild(wingp_r21);
		setRotationAngle(wingp_r21, -0.262F, 1.1313F, 0.5378F);
		wingp_r21.texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r22 = new ModelRenderer(this);
		wingp_r22.setPos(49.2283F, 16.6943F, -19.8695F);
		wing3.addChild(wingp_r22);
		setRotationAngle(wingp_r22, 0.1342F, 0.7094F, 0.5392F);
		wingp_r22.texOffs(87, 83).addBox(-7.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r22.texOffs(87, 83).addBox(-4.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		wingp_r22.texOffs(87, 83).addBox(-4.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r22.texOffs(87, 83).addBox(-1.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r23 = new ModelRenderer(this);
		wingp_r23.setPos(49.2283F, 16.6943F, -19.8695F);
		wing3.addChild(wingp_r23);
		setRotationAngle(wingp_r23, 0.8743F, 1.0502F, 0.9807F);
		wingp_r23.texOffs(87, 83).addBox(-2.75F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r23.texOffs(87, 83).addBox(0.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r24 = new ModelRenderer(this);
		wingp_r24.setPos(24.969F, 51.6926F, -55.6902F);
		wing3.addChild(wingp_r24);
		setRotationAngle(wingp_r24, 0.1743F, 1.1313F, 0.5378F);
		wingp_r24.texOffs(87, 83).addBox(-23.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		wingp_r24.texOffs(87, 83).addBox(-26.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, 0.0F, false);
		wingp_r24.texOffs(87, 83).addBox(-23.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, 0.0F, false);

		wingp_r25 = new ModelRenderer(this);
		wingp_r25.setPos(24.969F, 51.6926F, -55.6902F);
		wing3.addChild(wingp_r25);
		setRotationAngle(wingp_r25, -0.6992F, 0.9914F, -0.4423F);
		wingp_r25.texOffs(87, 83).addBox(-22.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, 0.0F, false);

		wingp_r26 = new ModelRenderer(this);
		wingp_r26.setPos(35.7293F, 68.5933F, -27.4624F);
		wing3.addChild(wingp_r26);
		setRotationAngle(wingp_r26, 0.0932F, 0.6551F, 0.4366F);
		wingp_r26.texOffs(88, 34).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r27 = new ModelRenderer(this);
		wingp_r27.setPos(30.3982F, 73.7436F, -23.9547F);
		wing3.addChild(wingp_r27);
		setRotationAngle(wingp_r27, 0.8891F, 0.8433F, 1.3715F);
		wingp_r27.texOffs(87, 83).addBox(10.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		wingp_r27.texOffs(87, 83).addBox(5.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r27.texOffs(87, 83).addBox(0.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r27.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		wingp_r28 = new ModelRenderer(this);
		wingp_r28.setPos(24.969F, 51.6926F, -55.6902F);
		wing3.addChild(wingp_r28);
		setRotationAngle(wingp_r28, -0.1989F, 1.1291F, 0.1262F);
		wingp_r28.texOffs(87, 83).addBox(-27.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, 0.0F, false);

		wingp_r29 = new ModelRenderer(this);
		wingp_r29.setPos(30.9402F, 14.9448F, -46.4754F);
		wing3.addChild(wingp_r29);
		setRotationAngle(wingp_r29, -0.3234F, 0.7468F, -0.0065F);
		wingp_r29.texOffs(87, 83).addBox(-12.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, 0.0F, false);

		wingp_r30 = new ModelRenderer(this);
		wingp_r30.setPos(23.1375F, 22.6296F, -44.9563F);
		wing3.addChild(wingp_r30);
		setRotationAngle(wingp_r30, -0.6462F, 0.2236F, -0.7654F);
		wingp_r30.texOffs(85, 92).addBox(17.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, 0.0F, false);

		wingp_r31 = new ModelRenderer(this);
		wingp_r31.setPos(46.7202F, 4.6334F, -10.1781F);
		wing3.addChild(wingp_r31);
		setRotationAngle(wingp_r31, -0.6898F, 0.2236F, -0.7654F);
		wingp_r31.texOffs(95, 81).addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, 0.0F, false);

		wingp_r32 = new ModelRenderer(this);
		wingp_r32.setPos(23.1375F, 22.6296F, -44.9563F);
		wing3.addChild(wingp_r32);
		setRotationAngle(wingp_r32, -0.0945F, 0.2909F, -0.3193F);
		wingp_r32.texOffs(102, 53).addBox(8.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, 0.0F, false);

		wingp_r33 = new ModelRenderer(this);
		wingp_r33.setPos(-0.7625F, 27.8402F, -38.5511F);
		wing3.addChild(wingp_r33);
		setRotationAngle(wingp_r33, 0.0547F, 0.3006F, 0.1828F);
		wingp_r33.texOffs(102, 54).addBox(18.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r34 = new ModelRenderer(this);
		wingp_r34.setPos(-9.0438F, 30.7802F, -36.4643F);
		wing3.addChild(wingp_r34);
		setRotationAngle(wingp_r34, -0.0411F, 0.3027F, -0.1372F);
		wingp_r34.texOffs(69, 60).addBox(20.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r35 = new ModelRenderer(this);
		wingp_r35.setPos(-9.0438F, 30.7802F, -36.4643F);
		wing3.addChild(wingp_r35);
		setRotationAngle(wingp_r35, 0.2956F, 0.0779F, 1.3206F);
		wingp_r35.texOffs(46, 72).addBox(-22.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r36 = new ModelRenderer(this);
		wingp_r36.setPos(-9.0438F, 30.7802F, -36.4643F);
		wing3.addChild(wingp_r36);
		setRotationAngle(wingp_r36, 0.2599F, 0.1623F, 1.0248F);
		wingp_r36.texOffs(49, 77).addBox(-16.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r37 = new ModelRenderer(this);
		wingp_r37.setPos(-9.0438F, 30.7802F, -36.4643F);
		wing3.addChild(wingp_r37);
		setRotationAngle(wingp_r37, -0.1074F, 0.2865F, -0.3646F);
		wingp_r37.texOffs(79, 59).addBox(20.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r38 = new ModelRenderer(this);
		wingp_r38.setPos(-7.7485F, 31.4827F, -36.8727F);
		wing3.addChild(wingp_r38);
		setRotationAngle(wingp_r38, 0.0F, 0.3054F, 0.0F);
		wingp_r38.texOffs(89, 98).addBox(17.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, 0.0F, false);
		wingp_r38.texOffs(81, 104).addBox(11.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wing4 = new ModelRenderer(this);
		wing4.setPos(1.0F, -32.0F, 45.0F);
		Body.addChild(wing4);
		setRotationAngle(wing4, 1.4518F, -0.9572F, -1.7107F);
		wing4.texOffs(0, 116).addBox(12.579F, -2.893F, -3.9745F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		wing4.texOffs(1, 119).addBox(4.579F, -2.893F, -3.9745F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		wingp_r39 = new ModelRenderer(this);
		wingp_r39.setPos(5.4994F, 29.2364F, -42.5157F);
		wing4.addChild(wingp_r39);
		setRotationAngle(wingp_r39, 0.0F, 0.3054F, 0.0F);
		wingp_r39.texOffs(88, 86).addBox(16.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r40 = new ModelRenderer(this);
		wingp_r40.setPos(6.3244F, 29.9255F, -42.7758F);
		wing4.addChild(wingp_r40);
		setRotationAngle(wingp_r40, -0.0547F, 0.3006F, -0.1828F);
		wingp_r40.texOffs(22, 52).addBox(18.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		wingp_r41 = new ModelRenderer(this);
		wingp_r41.setPos(4.0174F, 115.5798F, -64.8643F);
		wing4.addChild(wingp_r41);
		setRotationAngle(wingp_r41, -0.5821F, 1.2564F, 0.0427F);
		wingp_r41.texOffs(87, 83).addBox(-30.3031F, -55.442F, 8.9077F, 3.0F, 29.0F, 3.0F, 0.0F, false);

		wingp_r42 = new ModelRenderer(this);
		wingp_r42.setPos(52.0651F, 30.2705F, -28.2528F);
		wing4.addChild(wingp_r42);
		setRotationAngle(wingp_r42, 0.5366F, 0.7419F, 0.4476F);
		wingp_r42.texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r43 = new ModelRenderer(this);
		wingp_r43.setPos(52.0651F, 30.2705F, -28.2528F);
		wing4.addChild(wingp_r43);
		setRotationAngle(wingp_r43, -0.262F, 1.1313F, 0.5378F);
		wingp_r43.texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r44 = new ModelRenderer(this);
		wingp_r44.setPos(54.1951F, 15.5374F, -22.3772F);
		wing4.addChild(wingp_r44);
		setRotationAngle(wingp_r44, 0.1342F, 0.7094F, 0.5392F);
		wingp_r44.texOffs(87, 83).addBox(-7.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r44.texOffs(87, 83).addBox(-4.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		wingp_r44.texOffs(87, 83).addBox(-4.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r44.texOffs(87, 83).addBox(-1.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r45 = new ModelRenderer(this);
		wingp_r45.setPos(54.1951F, 15.5374F, -22.3772F);
		wing4.addChild(wingp_r45);
		setRotationAngle(wingp_r45, 0.8743F, 1.0502F, 0.9807F);
		wingp_r45.texOffs(87, 83).addBox(-2.75F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r45.texOffs(87, 83).addBox(0.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		wingp_r46 = new ModelRenderer(this);
		wingp_r46.setPos(29.9358F, 50.5356F, -58.1979F);
		wing4.addChild(wingp_r46);
		setRotationAngle(wingp_r46, 0.1743F, 1.1313F, 0.5378F);
		wingp_r46.texOffs(87, 83).addBox(-23.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		wingp_r46.texOffs(87, 83).addBox(-26.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, 0.0F, false);
		wingp_r46.texOffs(87, 83).addBox(-23.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, 0.0F, false);

		wingp_r47 = new ModelRenderer(this);
		wingp_r47.setPos(29.9358F, 50.5356F, -58.1979F);
		wing4.addChild(wingp_r47);
		setRotationAngle(wingp_r47, -0.6992F, 0.9914F, -0.4423F);
		wingp_r47.texOffs(87, 83).addBox(-22.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, 0.0F, false);

		wingp_r48 = new ModelRenderer(this);
		wingp_r48.setPos(40.6961F, 67.4363F, -29.9701F);
		wing4.addChild(wingp_r48);
		setRotationAngle(wingp_r48, 0.0932F, 0.6551F, 0.4366F);
		wingp_r48.texOffs(88, 34).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r49 = new ModelRenderer(this);
		wingp_r49.setPos(35.365F, 72.5866F, -26.4624F);
		wing4.addChild(wingp_r49);
		setRotationAngle(wingp_r49, 0.8891F, 0.8433F, 1.3715F);
		wingp_r49.texOffs(87, 83).addBox(10.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		wingp_r49.texOffs(87, 83).addBox(5.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r49.texOffs(87, 83).addBox(0.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		wingp_r49.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		wingp_r50 = new ModelRenderer(this);
		wingp_r50.setPos(29.9358F, 50.5356F, -58.1979F);
		wing4.addChild(wingp_r50);
		setRotationAngle(wingp_r50, -0.1989F, 1.1291F, 0.1262F);
		wingp_r50.texOffs(87, 83).addBox(-27.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, 0.0F, false);

		wingp_r51 = new ModelRenderer(this);
		wingp_r51.setPos(35.907F, 13.7879F, -48.9832F);
		wing4.addChild(wingp_r51);
		setRotationAngle(wingp_r51, -0.3234F, 0.7468F, -0.0065F);
		wingp_r51.texOffs(87, 83).addBox(-12.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, 0.0F, false);

		wingp_r52 = new ModelRenderer(this);
		wingp_r52.setPos(28.1043F, 21.4727F, -47.464F);
		wing4.addChild(wingp_r52);
		setRotationAngle(wingp_r52, -0.6462F, 0.2236F, -0.7654F);
		wingp_r52.texOffs(85, 92).addBox(17.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, 0.0F, false);

		wingp_r53 = new ModelRenderer(this);
		wingp_r53.setPos(51.687F, 3.4764F, -12.6858F);
		wing4.addChild(wingp_r53);
		setRotationAngle(wingp_r53, -0.6898F, 0.2236F, -0.7654F);
		wingp_r53.texOffs(95, 81).addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, 0.0F, false);

		wingp_r54 = new ModelRenderer(this);
		wingp_r54.setPos(28.1043F, 21.4727F, -47.464F);
		wing4.addChild(wingp_r54);
		setRotationAngle(wingp_r54, -0.0945F, 0.2909F, -0.3193F);
		wingp_r54.texOffs(102, 53).addBox(8.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, 0.0F, false);

		wingp_r55 = new ModelRenderer(this);
		wingp_r55.setPos(4.2043F, 26.6832F, -41.0588F);
		wing4.addChild(wingp_r55);
		setRotationAngle(wingp_r55, 0.0547F, 0.3006F, 0.1828F);
		wingp_r55.texOffs(102, 54).addBox(18.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, 0.0F, false);

		wingp_r56 = new ModelRenderer(this);
		wingp_r56.setPos(-4.077F, 29.6232F, -38.972F);
		wing4.addChild(wingp_r56);
		setRotationAngle(wingp_r56, -0.0411F, 0.3027F, -0.1372F);
		wingp_r56.texOffs(69, 60).addBox(20.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r57 = new ModelRenderer(this);
		wingp_r57.setPos(-4.077F, 29.6232F, -38.972F);
		wing4.addChild(wingp_r57);
		setRotationAngle(wingp_r57, 0.2956F, 0.0779F, 1.3206F);
		wingp_r57.texOffs(46, 72).addBox(-22.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r58 = new ModelRenderer(this);
		wingp_r58.setPos(-4.077F, 29.6232F, -38.972F);
		wing4.addChild(wingp_r58);
		setRotationAngle(wingp_r58, 0.2599F, 0.1623F, 1.0248F);
		wingp_r58.texOffs(49, 77).addBox(-16.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r59 = new ModelRenderer(this);
		wingp_r59.setPos(-4.077F, 29.6232F, -38.972F);
		wing4.addChild(wingp_r59);
		setRotationAngle(wingp_r59, -0.1074F, 0.2865F, -0.3646F);
		wingp_r59.texOffs(79, 59).addBox(20.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r60 = new ModelRenderer(this);
		wingp_r60.setPos(-2.7817F, 30.3257F, -39.3804F);
		wing4.addChild(wingp_r60);
		setRotationAngle(wingp_r60, 0.0F, 0.3054F, 0.0F);
		wingp_r60.texOffs(89, 98).addBox(17.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, 0.0F, false);
		wingp_r60.texOffs(81, 104).addBox(11.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, 0.0F, false);

		wing6 = new ModelRenderer(this);
		wing6.setPos(-1.0F, -39.0F, 47.0F);
		Body.addChild(wing6);
		setRotationAngle(wing6, 1.1188F, 0.882F, 1.2944F);
		wing6.texOffs(0, 116).addBox(-19.7368F, -0.6218F, -1.3919F, 8.0F, 7.0F, 2.0F, 0.0F, true);
		wing6.texOffs(1, 119).addBox(-11.7368F, -0.6218F, -1.3919F, 8.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r61 = new ModelRenderer(this);
		wingp_r61.setPos(-4.6573F, 31.5076F, -39.9331F);
		wing6.addChild(wingp_r61);
		setRotationAngle(wingp_r61, 0.0F, -0.3054F, 0.0F);
		wingp_r61.texOffs(88, 86).addBox(-22.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 4.0F, 0.0F, true);

		wingp_r62 = new ModelRenderer(this);
		wingp_r62.setPos(-5.4822F, 32.1967F, -40.1933F);
		wing6.addChild(wingp_r62);
		setRotationAngle(wingp_r62, -0.0547F, -0.3006F, 0.1828F);
		wingp_r62.texOffs(22, 52).addBox(-21.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r63 = new ModelRenderer(this);
		wingp_r63.setPos(-3.1753F, 117.8511F, -62.2817F);
		wing6.addChild(wingp_r63);
		setRotationAngle(wingp_r63, -0.5821F, -1.2564F, -0.0427F);
		wingp_r63.texOffs(87, 83).addBox(27.3031F, -55.442F, 8.9077F, 3.0F, 23.0F, 3.0F, 0.0F, true);

		wingp_r64 = new ModelRenderer(this);
		wingp_r64.setPos(-51.223F, 32.5418F, -25.6702F);
		wing6.addChild(wingp_r64);
		setRotationAngle(wingp_r64, 0.5366F, -0.7419F, -0.4476F);
		wingp_r64.texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r65 = new ModelRenderer(this);
		wingp_r65.setPos(-51.223F, 32.5418F, -25.6702F);
		wing6.addChild(wingp_r65);
		setRotationAngle(wingp_r65, -0.262F, -1.1313F, -0.5378F);
		wingp_r65.texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r66 = new ModelRenderer(this);
		wingp_r66.setPos(-53.3529F, 17.8086F, -19.7946F);
		wing6.addChild(wingp_r66);
		setRotationAngle(wingp_r66, 0.1342F, -0.7094F, -0.5392F);
		wingp_r66.texOffs(87, 83).addBox(3.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r66.texOffs(87, 83).addBox(3.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);
		wingp_r66.texOffs(87, 83).addBox(0.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r66.texOffs(87, 83).addBox(0.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r67 = new ModelRenderer(this);
		wingp_r67.setPos(-53.3529F, 17.8086F, -19.7946F);
		wing6.addChild(wingp_r67);
		setRotationAngle(wingp_r67, 0.8743F, -1.0502F, -0.9807F);
		wingp_r67.texOffs(87, 83).addBox(-1.25F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r67.texOffs(87, 83).addBox(-1.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r68 = new ModelRenderer(this);
		wingp_r68.setPos(-29.0936F, 52.8069F, -55.6153F);
		wing6.addChild(wingp_r68);
		setRotationAngle(wingp_r68, 0.1743F, -1.1313F, -0.5378F);
		wingp_r68.texOffs(87, 83).addBox(22.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, 0.0F, true);
		wingp_r68.texOffs(87, 83).addBox(22.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, 0.0F, true);
		wingp_r68.texOffs(87, 83).addBox(19.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, 0.0F, true);

		wingp_r69 = new ModelRenderer(this);
		wingp_r69.setPos(-29.0936F, 52.8069F, -55.6153F);
		wing6.addChild(wingp_r69);
		setRotationAngle(wingp_r69, -0.6992F, -0.9914F, 0.4423F);
		wingp_r69.texOffs(87, 83).addBox(19.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, 0.0F, true);

		wingp_r70 = new ModelRenderer(this);
		wingp_r70.setPos(-39.8539F, 69.7075F, -27.3876F);
		wing6.addChild(wingp_r70);
		setRotationAngle(wingp_r70, 0.0932F, -0.6551F, -0.4366F);
		wingp_r70.texOffs(88, 34).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, true);

		wingp_r71 = new ModelRenderer(this);
		wingp_r71.setPos(-34.5228F, 74.8578F, -23.8798F);
		wing6.addChild(wingp_r71);
		setRotationAngle(wingp_r71, 0.8891F, -0.8433F, -1.3715F);
		wingp_r71.texOffs(87, 83).addBox(-11.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		wingp_r71.texOffs(87, 83).addBox(-7.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r71.texOffs(87, 83).addBox(-2.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r71.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, 0.0F, true);

		wingp_r72 = new ModelRenderer(this);
		wingp_r72.setPos(-29.0936F, 52.8069F, -55.6153F);
		wing6.addChild(wingp_r72);
		setRotationAngle(wingp_r72, -0.1989F, -1.1291F, -0.1262F);
		wingp_r72.texOffs(87, 83).addBox(20.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, 0.0F, true);

		wingp_r73 = new ModelRenderer(this);
		wingp_r73.setPos(-35.0648F, 16.0591F, -46.4006F);
		wing6.addChild(wingp_r73);
		setRotationAngle(wingp_r73, -0.3234F, -0.7468F, 0.0065F);
		wingp_r73.texOffs(87, 83).addBox(5.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, 0.0F, true);

		wingp_r74 = new ModelRenderer(this);
		wingp_r74.setPos(-27.2621F, 23.7439F, -44.8814F);
		wing6.addChild(wingp_r74);
		setRotationAngle(wingp_r74, -0.6462F, -0.2236F, 0.7654F);
		wingp_r74.texOffs(85, 92).addBox(-24.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, 0.0F, true);

		wingp_r75 = new ModelRenderer(this);
		wingp_r75.setPos(-50.8448F, 5.7476F, -10.1033F);
		wing6.addChild(wingp_r75);
		setRotationAngle(wingp_r75, -0.6898F, -0.2236F, 0.7654F);
		wingp_r75.texOffs(95, 81).addBox(-3.5F, -5.5F, -2.0F, 7.0F, 11.0F, 4.0F, 0.0F, true);

		wingp_r76 = new ModelRenderer(this);
		wingp_r76.setPos(-27.2621F, 23.7439F, -44.8814F);
		wing6.addChild(wingp_r76);
		setRotationAngle(wingp_r76, -0.0945F, -0.2909F, 0.3193F);
		wingp_r76.texOffs(102, 53).addBox(-17.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 4.0F, 0.0F, true);

		wingp_r77 = new ModelRenderer(this);
		wingp_r77.setPos(-3.3621F, 28.9545F, -38.4763F);
		wing6.addChild(wingp_r77);
		setRotationAngle(wingp_r77, 0.0547F, -0.3006F, -0.1828F);
		wingp_r77.texOffs(102, 54).addBox(-26.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 4.0F, 0.0F, true);

		wingp_r78 = new ModelRenderer(this);
		wingp_r78.setPos(4.9192F, 31.8944F, -36.3894F);
		wing6.addChild(wingp_r78);
		setRotationAngle(wingp_r78, -0.0411F, -0.3027F, 0.1372F);
		wingp_r78.texOffs(69, 60).addBox(-27.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r79 = new ModelRenderer(this);
		wingp_r79.setPos(4.9192F, 31.8944F, -36.3894F);
		wing6.addChild(wingp_r79);
		setRotationAngle(wingp_r79, 0.2956F, -0.0779F, -1.3206F);
		wingp_r79.texOffs(46, 72).addBox(19.7835F, -16.0003F, 40.6994F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r80 = new ModelRenderer(this);
		wingp_r80.setPos(4.9192F, 31.8944F, -36.3894F);
		wing6.addChild(wingp_r80);
		setRotationAngle(wingp_r80, 0.2599F, -0.1623F, -1.0248F);
		wingp_r80.texOffs(49, 77).addBox(11.6616F, -26.0485F, 40.6994F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r81 = new ModelRenderer(this);
		wingp_r81.setPos(4.9192F, 31.8944F, -36.3894F);
		wing6.addChild(wingp_r81);
		setRotationAngle(wingp_r81, -0.1074F, -0.2865F, 0.3646F);
		wingp_r81.texOffs(79, 59).addBox(-26.6915F, -21.5673F, 40.6994F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r82 = new ModelRenderer(this);
		wingp_r82.setPos(3.6239F, 32.597F, -36.7979F);
		wing6.addChild(wingp_r82);
		setRotationAngle(wingp_r82, 0.0F, -0.3054F, 0.0F);
		wingp_r82.texOffs(89, 98).addBox(-24.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 4.0F, 0.0F, true);
		wingp_r82.texOffs(81, 104).addBox(-17.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wing5 = new ModelRenderer(this);
		wing5.setPos(-1.0F, -38.0F, 46.0F);
		Body.addChild(wing5);
		setRotationAngle(wing5, -0.2732F, 0.0865F, 0.7413F);
		wing5.texOffs(1, 119).addBox(-10.6865F, -2.5968F, 1.1424F, 8.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r83 = new ModelRenderer(this);
		wingp_r83.setPos(-3.607F, 29.5326F, -37.3989F);
		wing5.addChild(wingp_r83);
		setRotationAngle(wingp_r83, 0.0F, -0.3054F, 0.0F);
		wingp_r83.texOffs(88, 86).addBox(-22.9415F, -34.8274F, 41.1994F, 6.0F, 6.0F, 1.0F, 0.0F, true);

		wingp_r84 = new ModelRenderer(this);
		wingp_r84.setPos(-4.432F, 30.2217F, -37.659F);
		wing5.addChild(wingp_r84);
		setRotationAngle(wingp_r84, -0.0547F, -0.3006F, 0.1828F);
		wingp_r84.texOffs(22, 52).addBox(-21.6523F, -32.2156F, 41.1994F, 3.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r85 = new ModelRenderer(this);
		wingp_r85.setPos(-2.125F, 115.8761F, -59.7474F);
		wing5.addChild(wingp_r85);
		setRotationAngle(wingp_r85, -0.5821F, -1.2564F, -0.0427F);
		wingp_r85.texOffs(87, 83).addBox(27.3031F, -55.442F, 8.9077F, 3.0F, 39.0F, 3.0F, 0.0F, true);

		wingp_r86 = new ModelRenderer(this);
		wingp_r86.setPos(-50.1727F, 30.5668F, -23.1359F);
		wing5.addChild(wingp_r86);
		setRotationAngle(wingp_r86, 0.5366F, -0.7419F, -0.4476F);
		wingp_r86.texOffs(87, 83).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r87 = new ModelRenderer(this);
		wingp_r87.setPos(-50.1727F, 30.5668F, -23.1359F);
		wing5.addChild(wingp_r87);
		setRotationAngle(wingp_r87, -0.262F, -1.1313F, -0.5378F);
		wingp_r87.texOffs(87, 83).addBox(-0.5F, 1.5F, 2.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r88 = new ModelRenderer(this);
		wingp_r88.setPos(-52.3027F, 15.8336F, -17.2603F);
		wing5.addChild(wingp_r88);
		setRotationAngle(wingp_r88, 0.1342F, -0.7094F, -0.5392F);
		wingp_r88.texOffs(87, 83).addBox(3.75F, -10.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r88.texOffs(87, 83).addBox(3.75F, -15.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);
		wingp_r88.texOffs(87, 83).addBox(0.75F, -4.5F, -0.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r88.texOffs(87, 83).addBox(0.75F, -9.5F, -0.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r89 = new ModelRenderer(this);
		wingp_r89.setPos(-52.3027F, 15.8336F, -17.2603F);
		wing5.addChild(wingp_r89);
		setRotationAngle(wingp_r89, 0.8743F, -1.0502F, -0.9807F);
		wingp_r89.texOffs(87, 83).addBox(-1.25F, -1.5F, -4.75F, 4.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r89.texOffs(87, 83).addBox(-1.25F, -6.5F, -4.75F, 1.0F, 5.0F, 2.0F, 0.0F, true);

		wingp_r90 = new ModelRenderer(this);
		wingp_r90.setPos(-28.0433F, 50.8319F, -53.081F);
		wing5.addChild(wingp_r90);
		setRotationAngle(wingp_r90, 0.1743F, -1.1313F, -0.5378F);
		wingp_r90.texOffs(87, 83).addBox(22.9289F, -27.2415F, 24.2199F, 1.0F, 5.0F, 2.0F, 0.0F, true);
		wingp_r90.texOffs(87, 83).addBox(22.9289F, -22.2415F, 23.2199F, 4.0F, 11.0F, 3.0F, 0.0F, true);
		wingp_r90.texOffs(87, 83).addBox(19.9289F, -7.2415F, 23.2199F, 4.0F, 14.0F, 3.0F, 0.0F, true);

		wingp_r91 = new ModelRenderer(this);
		wingp_r91.setPos(-28.0433F, 50.8319F, -53.081F);
		wing5.addChild(wingp_r91);
		setRotationAngle(wingp_r91, -0.6992F, -0.9914F, 0.4423F);
		wingp_r91.texOffs(87, 83).addBox(19.9289F, -29.2415F, 23.2199F, 3.0F, 11.0F, 2.0F, 0.0F, true);

		wingp_r92 = new ModelRenderer(this);
		wingp_r92.setPos(-38.8036F, 67.7325F, -24.8533F);
		wing5.addChild(wingp_r92);
		setRotationAngle(wingp_r92, 0.0932F, -0.6551F, -0.4366F);
		wingp_r92.texOffs(78, 12).addBox(3.0F, 1.0F, 0.0F, 4.0F, 6.0F, 4.0F, 0.0F, true);
		wingp_r92.texOffs(88, 34).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, true);

		wingp_r93 = new ModelRenderer(this);
		wingp_r93.setPos(-33.4725F, 72.8828F, -21.3455F);
		wing5.addChild(wingp_r93);
		setRotationAngle(wingp_r93, 0.8891F, -0.8433F, -1.3715F);
		wingp_r93.texOffs(87, 83).addBox(-11.0F, 15.0F, -3.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		wingp_r93.texOffs(87, 83).addBox(-7.0F, 9.0F, -3.5F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r93.texOffs(87, 83).addBox(-2.0F, 9.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.0F, true);
		wingp_r93.texOffs(87, 83).addBox(-2.0F, 3.0F, -1.5F, 4.0F, 7.0F, 3.0F, 0.0F, true);

		wingp_r94 = new ModelRenderer(this);
		wingp_r94.setPos(-28.0433F, 50.8319F, -53.081F);
		wing5.addChild(wingp_r94);
		setRotationAngle(wingp_r94, -0.1989F, -1.1291F, -0.1262F);
		wingp_r94.texOffs(87, 83).addBox(20.9289F, -16.2415F, 23.2199F, 7.0F, 39.0F, 3.0F, 0.0F, true);

		wingp_r95 = new ModelRenderer(this);
		wingp_r95.setPos(-34.0145F, 14.0841F, -43.8663F);
		wing5.addChild(wingp_r95);
		setRotationAngle(wingp_r95, -0.3234F, -0.7468F, 0.0065F);
		wingp_r95.texOffs(87, 83).addBox(5.9991F, -19.9236F, 29.2499F, 7.0F, 39.0F, 3.0F, 0.0F, true);

		wingp_r96 = new ModelRenderer(this);
		wingp_r96.setPos(-26.2118F, 21.7689F, -42.3471F);
		wing5.addChild(wingp_r96);
		setRotationAngle(wingp_r96, -0.6462F, -0.2236F, 0.7654F);
		wingp_r96.texOffs(85, 92).addBox(-24.5299F, -26.4199F, 30.4311F, 7.0F, 11.0F, 3.0F, 0.0F, true);

		wingp_r97 = new ModelRenderer(this);
		wingp_r97.setPos(-26.2118F, 21.7689F, -42.3471F);
		wing5.addChild(wingp_r97);
		setRotationAngle(wingp_r97, -0.3408F, -0.2236F, 0.7654F);
		wingp_r97.texOffs(110, 57).addBox(-24.5299F, -15.8497F, 37.2448F, 7.0F, 11.0F, 1.0F, 0.0F, true);

		wingp_r98 = new ModelRenderer(this);
		wingp_r98.setPos(-26.2118F, 21.7689F, -42.3471F);
		wing5.addChild(wingp_r98);
		setRotationAngle(wingp_r98, -0.0945F, -0.2909F, 0.3193F);
		wingp_r98.texOffs(110, 57).addBox(-17.7222F, -21.929F, 39.1212F, 9.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r99 = new ModelRenderer(this);
		wingp_r99.setPos(-2.3118F, 26.9795F, -35.942F);
		wing5.addChild(wingp_r99);
		setRotationAngle(wingp_r99, 0.0547F, -0.3006F, -0.1828F);
		wingp_r99.texOffs(110, 57).addBox(-26.9838F, -36.0886F, 40.1994F, 8.0F, 6.0F, 1.0F, 0.0F, true);

		wingp_r100 = new ModelRenderer(this);
		wingp_r100.setPos(5.9694F, 29.9194F, -33.8552F);
		wing5.addChild(wingp_r100);
		setRotationAngle(wingp_r100, -0.0411F, -0.3027F, 0.1372F);
		wingp_r100.texOffs(69, 60).addBox(-27.9208F, -27.1245F, 40.6994F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r101 = new ModelRenderer(this);
		wingp_r101.setPos(5.9694F, 29.9194F, -33.8552F);
		wing5.addChild(wingp_r101);
		setRotationAngle(wingp_r101, 0.2194F, -0.2143F, -0.8091F);
		wingp_r101.texOffs(44, 62).addBox(2.8216F, -30.2909F, 40.6994F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r102 = new ModelRenderer(this);
		wingp_r102.setPos(5.9694F, 29.9194F, -33.8552F);
		wing5.addChild(wingp_r102);
		setRotationAngle(wingp_r102, 0.2956F, -0.0779F, -1.3206F);
		wingp_r102.texOffs(71, 87).addBox(25.7835F, -22.0003F, 40.6994F, 5.0F, 9.0F, 3.0F, 0.0F, true);

		wingp_r103 = new ModelRenderer(this);
		wingp_r103.setPos(4.6741F, 30.622F, -34.2636F);
		wing5.addChild(wingp_r103);
		setRotationAngle(wingp_r103, 0.0F, -0.3054F, 0.0F);
		wingp_r103.texOffs(89, 98).addBox(-24.0312F, -35.2188F, 40.6994F, 7.0F, 7.0F, 1.0F, 0.0F, true);
		wingp_r103.texOffs(81, 104).addBox(-17.0312F, -33.2188F, 40.6994F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wing2 = new ModelRenderer(this);
		wing2.setPos(4.0F, -35.0F, 46.0F);
		Body.addChild(wing2);
		setRotationAngle(wing2, 0.0F, 0.3054F, 0.0436F);
		wing2.texOffs(80, 88).addBox(-13.5759F, -7.7205F, -0.4613F, 8.0F, 7.0F, 3.0F, 0.0F, true);
		wing2.texOffs(94, 88).addBox(-5.5759F, -4.7205F, -0.4613F, 5.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r104 = new ModelRenderer(this);
		wingp_r104.setPos(-25.9055F, 24.4485F, -45.5459F);
		wing2.addChild(wingp_r104);
		setRotationAngle(wingp_r104, 0.1074F, -0.2865F, -0.3646F);
		wingp_r104.texOffs(114, 77).addBox(17.1993F, -23.7371F, 39.1978F, 6.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r105 = new ModelRenderer(this);
		wingp_r105.setPos(-33.2302F, 16.4891F, -47.3696F);
		wing2.addChild(wingp_r105);
		setRotationAngle(wingp_r105, 0.237F, -0.1945F, -0.8959F);
		wingp_r105.texOffs(112, 74).addBox(19.9602F, -2.0205F, 38.7346F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r106 = new ModelRenderer(this);
		wingp_r106.setPos(-15.504F, 24.1462F, -41.7421F);
		wing2.addChild(wingp_r106);
		setRotationAngle(wingp_r106, 0.1074F, -0.2865F, -0.3646F);
		wingp_r106.texOffs(112, 74).addBox(8.6993F, -25.2371F, 38.6978F, 7.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r107 = new ModelRenderer(this);
		wingp_r107.setPos(-15.504F, 24.1462F, -41.7421F);
		wing2.addChild(wingp_r107);
		setRotationAngle(wingp_r107, -0.0411F, -0.3027F, 0.1372F);
		wingp_r107.texOffs(69, 60).addBox(-0.826F, -30.0364F, 38.6978F, 7.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r108 = new ModelRenderer(this);
		wingp_r108.setPos(-23.1316F, 28.7978F, -45.1956F);
		wing2.addChild(wingp_r108);
		setRotationAngle(wingp_r108, 0.1896F, -0.2409F, -0.6775F);
		wingp_r108.texOffs(50, 78).addBox(27.2866F, -16.3126F, 39.6978F, 5.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r109 = new ModelRenderer(this);
		wingp_r109.setPos(-15.504F, 24.1462F, -41.7421F);
		wing2.addChild(wingp_r109);
		setRotationAngle(wingp_r109, 0.1325F, -0.276F, -0.4548F);
		wingp_r109.texOffs(18, 39).addBox(17.6818F, -21.4658F, 38.6978F, 5.0F, 3.0F, 2.0F, 0.0F, true);

		wingp_r110 = new ModelRenderer(this);
		wingp_r110.setPos(-15.504F, 24.1462F, -41.7421F);
		wing2.addChild(wingp_r110);
		setRotationAngle(wingp_r110, -0.1074F, -0.2865F, 0.3646F);
		wingp_r110.texOffs(79, 59).addBox(-0.8692F, -30.2745F, 38.6978F, 6.0F, 2.0F, 3.0F, 0.0F, true);

		wingp_r111 = new ModelRenderer(this);
		wingp_r111.setPos(-30.5192F, 21.0254F, -46.6386F);
		wing2.addChild(wingp_r111);
		setRotationAngle(wingp_r111, 0.0814F, -0.2947F, -0.2739F);
		wingp_r111.texOffs(73, 49).addBox(11.2213F, -23.846F, 38.8526F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r112 = new ModelRenderer(this);
		wingp_r112.setPos(-30.5192F, 21.0254F, -46.6386F);
		wing2.addChild(wingp_r112);
		setRotationAngle(wingp_r112, 0.0411F, -0.3027F, -0.1372F);
		wingp_r112.texOffs(17, 81).addBox(14.2474F, -26.1966F, 38.8526F, 7.0F, 4.0F, 2.0F, 0.0F, true);

		wingp_r113 = new ModelRenderer(this);
		wingp_r113.setPos(-16.7993F, 24.8487F, -42.1505F);
		wing2.addChild(wingp_r113);
		setRotationAngle(wingp_r113, 0.0F, -0.3054F, 0.0F);
		wingp_r113.texOffs(19, 51).addBox(3.2118F, -32.5692F, 38.6978F, 7.0F, 3.0F, 2.0F, 0.0F, true);
		wingp_r113.texOffs(72, 47).addBox(10.2118F, -32.5692F, 38.6978F, 6.0F, 5.0F, 3.0F, 0.0F, true);

		bone = new ModelRenderer(this);
		bone.setPos(1.86F, 49.7243F, -43.2947F);
		wing2.addChild(bone);
		bone.texOffs(0, 108).addBox(-22.6113F, -57.3838F, 41.2479F, 8.0F, 3.0F, 2.0F, 0.0F, true);
		bone.texOffs(0, 108).addBox(-28.6113F, -57.3838F, 40.2479F, 8.0F, 7.0F, 2.0F, 0.0F, true);

		wingp_r114 = new ModelRenderer(this);
		wingp_r114.setPos(-5.5604F, -28.5F, 3.1442F);
		bone.addChild(wingp_r114);
		setRotationAngle(wingp_r114, 0.0F, -0.3054F, 0.0F);
		wingp_r114.texOffs(106, 109).addBox(-16.2253F, -28.8838F, 42.2255F, 6.0F, 5.0F, 2.0F, 0.0F, true);
		wingp_r114.texOffs(76, 97).addBox(-23.2253F, -29.8838F, 42.2255F, 7.0F, 4.0F, 1.0F, 0.0F, true);

		wingp_r115 = new ModelRenderer(this);
		wingp_r115.setPos(-18.4969F, -40.8207F, -0.0641F);
		bone.addChild(wingp_r115);
		setRotationAngle(wingp_r115, -0.1325F, -0.276F, 0.4548F);
		wingp_r115.texOffs(76, 97).addBox(-16.0124F, -15.3504F, 41.3952F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		wingp_r116 = new ModelRenderer(this);
		wingp_r116.setPos(-4.2651F, -29.2026F, 3.5526F);
		bone.addChild(wingp_r116);
		setRotationAngle(wingp_r116, -0.1074F, -0.2865F, 0.3646F);
		wingp_r116.texOffs(79, 59).addBox(-24.4515F, -17.7693F, 42.2255F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r117 = new ModelRenderer(this);
		wingp_r117.setPos(-4.2651F, -29.2026F, 3.5526F);
		bone.addChild(wingp_r117);
		setRotationAngle(wingp_r117, -0.0411F, -0.3027F, 0.1372F);
		wingp_r117.texOffs(69, 60).addBox(-26.5559F, -22.9318F, 42.2255F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r118 = new ModelRenderer(this);
		wingp_r118.setPos(-14.6666F, -28.9003F, -0.2512F);
		bone.addChild(wingp_r118);
		setRotationAngle(wingp_r118, 0.1074F, -0.2865F, -0.3646F);
		wingp_r118.texOffs(114, 74).addBox(-8.9039F, -30.316F, 42.7255F, 6.0F, 4.0F, 1.0F, 0.0F, true);

		wingp_r119 = new ModelRenderer(this);
		wingp_r119.setPos(-19.6726F, -30.7533F, -1.8296F);
		bone.addChild(wingp_r119);
		setRotationAngle(wingp_r119, 0.0547F, -0.3006F, -0.1828F);
		wingp_r119.texOffs(104, 50).addBox(-13.9429F, -32.6795F, 40.7255F, 6.0F, 9.0F, 3.0F, 0.0F, true);
		wingp_r119.texOffs(110, 50).addBox(-16.9429F, -26.6795F, 42.7255F, 6.0F, 6.0F, 1.0F, 0.0F, true);

		wingp_r120 = new ModelRenderer(this);
		wingp_r120.setPos(-19.9906F, -35.9238F, -1.9299F);
		bone.addChild(wingp_r120);
		setRotationAngle(wingp_r120, 0.1564F, -0.2635F, -0.5444F);
		wingp_r120.texOffs(104, 50).addBox(-14.5916F, -27.4737F, 40.7255F, 6.0F, 8.0F, 3.0F, 0.0F, true);

		wingp_r121 = new ModelRenderer(this);
		wingp_r121.setPos(-54.9502F, -54.1709F, 31.322F);
		bone.addChild(wingp_r121);
		setRotationAngle(wingp_r121, 0.288F, -0.103F, -1.2367F);
		wingp_r121.texOffs(99, 50).addBox(-0.5F, -3.0F, -0.5F, 11.0F, 1.0F, 2.0F, 0.0F, true);

		wingp_r122 = new ModelRenderer(this);
		wingp_r122.setPos(-54.9502F, -54.1709F, 31.322F);
		bone.addChild(wingp_r122);
		setRotationAngle(wingp_r122, 0.2194F, -0.2143F, -0.8091F);
		wingp_r122.texOffs(99, 50).addBox(-5.5F, -3.0F, -1.5F, 16.0F, 3.0F, 3.0F, 0.0F, true);

		wingp_r123 = new ModelRenderer(this);
		wingp_r123.setPos(-57.7622F, -15.6241F, -12.4444F);
		bone.addChild(wingp_r123);
		setRotationAngle(wingp_r123, 0.3043F, 0.0262F, -1.654F);
		wingp_r123.texOffs(102, 50).addBox(-32.2342F, -13.3239F, 39.3952F, 18.0F, 3.0F, 4.0F, 0.0F, true);

		wingp_r124 = new ModelRenderer(this);
		wingp_r124.setPos(-44.8777F, -30.621F, -8.382F);
		bone.addChild(wingp_r124);
		setRotationAngle(wingp_r124, 0.2921F, -0.0905F, -1.2787F);
		wingp_r124.texOffs(102, 50).addBox(-41.2342F, -13.3239F, 38.3952F, 22.0F, 5.0F, 5.0F, 0.0F, true);
		wingp_r124.texOffs(102, 50).addBox(-26.2342F, -13.3239F, 39.3952F, 40.0F, 3.0F, 3.0F, 0.0F, true);

		wingp_r125 = new ModelRenderer(this);
		wingp_r125.setPos(-44.8777F, -30.621F, -8.382F);
		bone.addChild(wingp_r125);
		setRotationAngle(wingp_r125, 0.2194F, -0.2143F, -0.8091F);
		wingp_r125.texOffs(102, 50).addBox(5.7658F, -18.3239F, 39.3952F, 8.0F, 5.0F, 3.0F, 0.0F, true);

		wingp_r126 = new ModelRenderer(this);
		wingp_r126.setPos(-35.9625F, -33.5023F, -5.571F);
		bone.addChild(wingp_r126);
		setRotationAngle(wingp_r126, 0.0411F, -0.3027F, -0.1372F);
		wingp_r126.texOffs(105, 50).addBox(-10.3797F, -18.4825F, 41.3952F, 8.0F, 5.0F, 1.0F, 0.0F, true);

		wingp_r127 = new ModelRenderer(this);
		wingp_r127.setPos(-31.9312F, -38.7829F, -4.2999F);
		bone.addChild(wingp_r127);
		setRotationAngle(wingp_r127, 0.2783F, -0.1274F, -1.1523F);
		wingp_r127.texOffs(110, 50).addBox(9.8504F, -16.0124F, 41.3952F, 5.0F, 6.0F, 1.0F, 0.0F, true);

		wingp_r128 = new ModelRenderer(this);
		wingp_r128.setPos(-14.6666F, -28.9003F, -0.2512F);
		bone.addChild(wingp_r128);
		setRotationAngle(wingp_r128, -0.0547F, -0.3006F, 0.1828F);
		wingp_r128.texOffs(13, 39).addBox(-23.1059F, -30.0864F, 42.7255F, 6.0F, 7.0F, 1.0F, 0.0F, true);

		wingp_r129 = new ModelRenderer(this);
		wingp_r129.setPos(-16.1783F, -33.1331F, -0.7279F);
		bone.addChild(wingp_r129);
		setRotationAngle(wingp_r129, -0.1564F, -0.2635F, 0.5444F);
		wingp_r129.texOffs(46, 65).addBox(-29.1453F, -13.7364F, 42.7255F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-7.0F, -45.0F, 40.0F);
		setRotationAngle(RightArm, -0.2084F, 0.0651F, 0.2986F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(8.6876F, 37.3271F, -33.8561F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0436F, -0.1745F, 1.4399F);
		RightArm_r1.texOffs(82, 2).addBox(-33.7474F, 0.1733F, 36.5061F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Rightbacktlib = new ModelRenderer(this);
		Rightbacktlib.setPos(6.6876F, 41.0862F, -33.1021F);
		RightArm.addChild(Rightbacktlib);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(3.0F, 0.644F, 3.0686F);
		Rightbacktlib.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.1745F, 0.0F, 0.0F);
		RightArm_r2.texOffs(86, 15).addBox(-10.6789F, -37.3519F, 34.4936F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Rightfrontlib = new ModelRenderer(this);
		Rightfrontlib.setPos(0.0F, 0.0F, 0.0F);
		Rightbacktlib.addChild(Rightfrontlib);
		

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-4.0905F, 13.6249F, -1.1438F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3775F, 0.9144F, -0.0465F);
		RightArm_r3.texOffs(124, 20).addBox(-30.0155F, -39.8288F, 2.094F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-3.9978F, 13.9978F, -1.4862F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, 0.1665F, 0.9578F, 0.6202F);
		RightArm_r4.texOffs(123, 10).addBox(-43.4207F, -32.5636F, 2.094F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.647F, 5.6035F, -0.8624F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.3463F, -0.0447F, 0.0951F);
		RightArm_r5.texOffs(121, 6).addBox(-9.8838F, -40.0308F, 18.2488F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(1.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3414F, 0.0741F, 0.4236F);
		RightArm_r6.texOffs(121, 6).addBox(-24.9895F, -37.6771F, 18.2488F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.3299F, 10.8257F, -6.8058F);
		Rightfrontlib.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, -0.6378F, -0.1582F, -0.384F);
		RightArm_r7.texOffs(124, 11).addBox(14.7314F, -52.0427F, 6.3588F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(-1.2245F, 9.153F, -1.7002F);
		Rightfrontlib.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -1.0742F, -0.1582F, -0.384F);
		RightArm_r8.texOffs(124, 11).addBox(14.7314F, -39.2767F, -14.3771F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(1.4611F, 9.253F, -1.7553F);
		Rightfrontlib.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, -0.9234F, -0.3332F, -0.6425F);
		RightArm_r9.texOffs(119, 13).addBox(27.0665F, -36.6865F, -10.9138F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(1.268F, 8.3751F, -2.8286F);
		Rightfrontlib.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, -0.5744F, -0.3332F, -0.6425F);
		RightArm_r10.texOffs(124, 12).addBox(27.0665F, -42.7946F, 3.6298F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(-1.0663F, 11.0304F, -1.1285F);
		Rightfrontlib.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, -0.5251F, -0.0113F, 0.087F);
		RightArm_r11.texOffs(124, 11).addBox(-8.4636F, -38.7291F, 14.0752F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		RightArm_r12 = new ModelRenderer(this);
		RightArm_r12.setPos(-1.0197F, 10.7748F, -3.2782F);
		Rightfrontlib.addChild(RightArm_r12);
		setRotationAngle(RightArm_r12, -0.3069F, -0.0113F, 0.087F);
		RightArm_r12.texOffs(124, 11).addBox(-8.4636F, -41.1675F, 23.2516F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r13 = new ModelRenderer(this);
		RightArm_r13.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r13);
		setRotationAngle(RightArm_r13, 0.0421F, -0.0113F, 0.087F);
		RightArm_r13.texOffs(124, 11).addBox(-8.4636F, -37.1715F, 37.2453F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm_r14 = new ModelRenderer(this);
		RightArm_r14.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r14);
		setRotationAngle(RightArm_r14, -0.3491F, 0.0F, 0.0F);
		RightArm_r14.texOffs(88, 21).addBox(-7.6789F, -43.6304F, 16.5265F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		RightArm_r14.texOffs(88, 27).addBox(-7.6789F, -53.6304F, 15.5265F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(9.4442F, -45.8343F, 40.5698F);
		setRotationAngle(LeftArm, 0.1939F, 0.0796F, -0.3849F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(-6.248F, 20.2496F, -47.8111F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.0436F, -0.2182F, -1.4399F);
		LeftArm_r1.texOffs(82, 2).addBox(28.1333F, 3.0066F, 39.7672F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Leftlib = new ModelRenderer(this);
		Leftlib.setPos(-5.1365F, 26.1147F, -47.7055F);
		LeftArm.addChild(Leftlib);
		

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(6.9959F, -23.788F, 46.7572F);
		Leftlib.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.6965F, -0.0436F, -0.0756F);
		LeftArm_r2.texOffs(86, 0).addBox(-2.0F, 2.5F, -2.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.0F, -3.0F, 0.0F);
		Leftlib.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.1745F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(88, 14).addBox(4.9959F, -32.0915F, 40.4371F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Leftfrontlib = new ModelRenderer(this);
		Leftfrontlib.setPos(0.0F, 1.0F, -2.0F);
		Leftlib.addChild(Leftfrontlib);
		

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.8727F, 0.0F, 0.0F);
		LeftArm_r4.texOffs(89, 21).addBox(5.9959F, -45.6804F, 12.1304F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(4.9445F, 13.4316F, -16.3494F);
		Leftfrontlib.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, 0.1035F, 0.8681F, 2.0115F);
		LeftArm_r5.texOffs(122, 12).addBox(-47.0698F, 13.8534F, 14.4989F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(0.4582F, 7.3186F, -11.0091F);
		Leftfrontlib.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.6779F, 0.6002F, 0.9172F);
		LeftArm_r6.texOffs(124, 12).addBox(-33.7414F, -29.1444F, 14.4989F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(-1.1606F, 6.4973F, -10.6558F);
		Leftfrontlib.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -0.8335F, 0.2975F, 0.5656F);
		LeftArm_r7.texOffs(120, 2).addBox(-16.5258F, -46.5101F, 14.4989F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r8 = new ModelRenderer(this);
		LeftArm_r8.setPos(-0.393F, 3.4677F, -6.9372F);
		Leftfrontlib.addChild(LeftArm_r8);
		setRotationAngle(LeftArm_r8, -0.8608F, -0.1666F, 0.1639F);
		LeftArm_r8.texOffs(120, 2).addBox(12.0832F, -48.2261F, 14.4989F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm_r9 = new ModelRenderer(this);
		LeftArm_r9.setPos(2.8957F, 9.0511F, -13.7826F);
		Leftfrontlib.addChild(LeftArm_r9);
		setRotationAngle(LeftArm_r9, -0.6842F, 0.494F, 0.4289F);
		LeftArm_r9.texOffs(124, 11).addBox(-22.3077F, -36.6912F, 18.486F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r10 = new ModelRenderer(this);
		LeftArm_r10.setPos(2.193F, 10.9341F, -16.3847F);
		Leftfrontlib.addChild(LeftArm_r10);
		setRotationAngle(LeftArm_r10, -0.8016F, 0.2007F, 0.2975F);
		LeftArm_r10.texOffs(124, 11).addBox(-7.2726F, -44.4883F, 17.4069F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		LeftArm_r10.texOffs(124, 11).addBox(-8.2726F, -49.4883F, 17.4069F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r11 = new ModelRenderer(this);
		LeftArm_r11.setPos(3.3558F, 7.8434F, -12.9522F);
		Leftfrontlib.addChild(LeftArm_r11);
		setRotationAngle(LeftArm_r11, -0.8196F, -0.0535F, 0.057F);
		LeftArm_r11.texOffs(124, 11).addBox(7.9251F, -49.3732F, 17.4069F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r12 = new ModelRenderer(this);
		LeftArm_r12.setPos(0.3084F, 1.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r12);
		setRotationAngle(LeftArm_r12, -0.8745F, -0.4493F, 0.114F);
		LeftArm_r12.texOffs(120, 2).addBox(23.987F, -40.9063F, 8.3178F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r13 = new ModelRenderer(this);
		LeftArm_r13.setPos(1.2743F, 8.8434F, -13.3917F);
		Leftfrontlib.addChild(LeftArm_r13);
		setRotationAngle(LeftArm_r13, -0.8071F, 0.1643F, 0.0577F);
		LeftArm_r13.texOffs(124, 11).addBox(-2.1724F, -49.6814F, 18.486F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r14 = new ModelRenderer(this);
		LeftArm_r14.setPos(0.3084F, 2.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r14);
		setRotationAngle(LeftArm_r14, -0.8492F, -0.2324F, 0.1055F);
		LeftArm_r14.texOffs(120, 2).addBox(15.0856F, -43.8174F, 12.2559F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftArm_r15 = new ModelRenderer(this);
		LeftArm_r15.setPos(6.4042F, 5.8592F, -6.8251F);
		Leftfrontlib.addChild(LeftArm_r15);
		setRotationAngle(LeftArm_r15, -0.649F, 0.7759F, 0.8367F);
		LeftArm_r15.texOffs(96, 7).addBox(-39.4262F, -17.636F, 9.0401F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r16 = new ModelRenderer(this);
		LeftArm_r16.setPos(3.958F, 3.1638F, -3.2644F);
		Leftfrontlib.addChild(LeftArm_r16);
		setRotationAngle(LeftArm_r16, -0.8645F, 0.5029F, 0.4813F);
		LeftArm_r16.texOffs(94, 12).addBox(-25.0429F, -34.0619F, 9.0401F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r17 = new ModelRenderer(this);
		LeftArm_r17.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r17);
		setRotationAngle(LeftArm_r17, -0.9609F, 0.12F, 0.1746F);
		LeftArm_r17.texOffs(122, 11).addBox(-2.763F, -47.3765F, 9.0401F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm_r18 = new ModelRenderer(this);
		LeftArm_r18.setPos(0.2826F, 7.6205F, -4.3097F);
		Leftfrontlib.addChild(LeftArm_r18);
		setRotationAngle(LeftArm_r18, -0.6276F, 0.6532F, 0.6973F);
		LeftArm_r18.texOffs(97, 8).addBox(-34.8831F, -32.4854F, 9.0662F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r19 = new ModelRenderer(this);
		LeftArm_r19.setPos(0.0F, 7.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r19);
		setRotationAngle(LeftArm_r19, -0.8239F, 0.3297F, 0.2912F);
		LeftArm_r19.texOffs(122, 12).addBox(-15.445F, -46.8218F, 9.0662F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 10.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.5857F, 0.1676F, 0.4395F);
		RightLeg_r1.texOffs(75, 89).addBox(-13.1432F, -35.2792F, 22.9807F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-5.7064F, 9.4918F, -4.5178F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.605F, 0.045F, 0.258F);
		RightLeg_r2.texOffs(78, 90).addBox(-5.5465F, -44.2165F, 22.9807F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-9.6983F, 6.5502F, -0.7084F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, 0.0433F, 0.62F, 0.0014F);
		RightLeg_r3.texOffs(78, 90).addBox(-24.2554F, -10.7807F, 37.1827F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-6.224F, 11.3943F, -4.8532F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, -0.6015F, -0.1664F, -1.8806F);
		RightLeg_r4.texOffs(78, 90).addBox(23.5665F, -24.5984F, 38.7417F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r4.texOffs(78, 90).addBox(22.5665F, -19.5984F, 37.7417F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(-2.6252F, 1.4955F, -3.161F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, -0.1687F, 0.045F, 0.258F);
		RightLeg_r5.texOffs(78, 90).addBox(-6.4235F, -20.4145F, 40.5014F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		RightLeg_r5.texOffs(78, 90).addBox(-7.4235F, -35.4145F, 39.5014F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r6 = new ModelRenderer(this);
		RightLeg_r6.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r6);
		setRotationAngle(RightLeg_r6, -0.5236F, 0.0F, 0.0F);
		RightLeg_r6.texOffs(85, 69).addBox(-0.0186F, -31.8324F, 21.6098F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		RightLeg_r6.texOffs(54, 75).addBox(-0.0186F, -41.8324F, 20.6098F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		RightLeg_r6.texOffs(78, 90).addBox(-2.0186F, -50.8324F, 19.6098F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r7 = new ModelRenderer(this);
		RightLeg_r7.setPos(1.9698F, 1.2504F, -1.1762F);
		RightLeg.addChild(RightLeg_r7);
		setRotationAngle(RightLeg_r7, -0.5236F, 0.0F, 0.0F);
		RightLeg_r7.texOffs(85, 69).addBox(-0.0186F, -26.8324F, 20.6098F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		RightLeg_r8 = new ModelRenderer(this);
		RightLeg_r8.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r8);
		setRotationAngle(RightLeg_r8, -0.9163F, 0.0F, 0.0F);
		RightLeg_r8.texOffs(91, 76).addBox(-0.0186F, -46.5234F, 3.7575F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		RightLeg_r9 = new ModelRenderer(this);
		RightLeg_r9.setPos(0.3402F, 12.0249F, -3.3044F);
		RightLeg.addChild(RightLeg_r9);
		setRotationAngle(RightLeg_r9, -0.49F, 0.1925F, 0.3444F);
		RightLeg_r9.texOffs(56, 67).addBox(-16.0654F, -30.2106F, 24.6098F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r10 = new ModelRenderer(this);
		RightLeg_r10.setPos(1.0327F, 6.189F, 0.0649F);
		RightLeg.addChild(RightLeg_r10);
		setRotationAngle(RightLeg_r10, -0.5219F, 0.0436F, 0.0756F);
		RightLeg_r10.texOffs(56, 67).addBox(-6.3399F, -31.8699F, 24.6098F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg_r10.texOffs(56, 67).addBox(-5.3399F, -31.8699F, 21.6098F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r11 = new ModelRenderer(this);
		RightLeg_r11.setPos(-5.0078F, 5.2056F, 0.6327F);
		RightLeg.addChild(RightLeg_r11);
		setRotationAngle(RightLeg_r11, -0.338F, -0.4079F, -0.8458F);
		RightLeg_r11.texOffs(56, 67).addBox(27.3234F, -15.3004F, 21.6098F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg_r12 = new ModelRenderer(this);
		RightLeg_r12.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r12);
		setRotationAngle(RightLeg_r12, -0.5087F, 0.1298F, 0.228F);
		RightLeg_r12.texOffs(56, 67).addBox(-11.9291F, -36.0782F, 20.6098F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		RightLeg_r13 = new ModelRenderer(this);
		RightLeg_r13.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r13);
		setRotationAngle(RightLeg_r13, -0.0859F, 0.0151F, 0.1739F);
		RightLeg_r13.texOffs(78, 90).addBox(-6.8116F, -21.6578F, 41.1292F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r14 = new ModelRenderer(this);
		RightLeg_r14.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r14);
		setRotationAngle(RightLeg_r14, -0.0873F, 0.0F, 0.0F);
		RightLeg_r14.texOffs(78, 90).addBox(-1.0186F, -21.6238F, 41.1292F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		RightLeg_r14.texOffs(78, 90).addBox(-2.0186F, -36.6238F, 41.1292F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		RightLeg_r15 = new ModelRenderer(this);
		RightLeg_r15.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r15);
		setRotationAngle(RightLeg_r15, -0.0436F, 1.3526F, -0.2618F);
		RightLeg_r15.texOffs(78, 90).addBox(-43.4692F, -22.8682F, 14.6725F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r16 = new ModelRenderer(this);
		RightLeg_r16.setPos(0.6104F, 9.8624F, 3.2851F);
		RightLeg.addChild(RightLeg_r16);
		setRotationAngle(RightLeg_r16, 0.1309F, 1.3526F, -0.2618F);
		RightLeg_r16.texOffs(78, 90).addBox(-43.4692F, -13.9056F, 18.1899F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r17 = new ModelRenderer(this);
		RightLeg_r17.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r17);
		setRotationAngle(RightLeg_r17, -0.1605F, -0.4269F, 0.6748F);
		RightLeg_r17.texOffs(78, 90).addBox(10.0964F, -22.2067F, 41.0824F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r18 = new ModelRenderer(this);
		RightLeg_r18.setPos(-7.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r18);
		setRotationAngle(RightLeg_r18, 0.1309F, -0.4363F, 0.0F);
		RightLeg_r18.texOffs(78, 90).addBox(21.0077F, -13.3996F, 41.0824F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r19 = new ModelRenderer(this);
		RightLeg_r19.setPos(-5.4837F, 10.8326F, 3.6585F);
		RightLeg.addChild(RightLeg_r19);
		setRotationAngle(RightLeg_r19, 0.3054F, -0.4363F, 0.0F);
		RightLeg_r19.texOffs(78, 90).addBox(20.5077F, -6.4037F, 42.5962F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		RightLeg_r20 = new ModelRenderer(this);
		RightLeg_r20.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r20);
		setRotationAngle(RightLeg_r20, -0.0436F, -0.4363F, 0.0F);
		RightLeg_r20.texOffs(78, 90).addBox(20.0077F, -15.0187F, 38.2899F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r21 = new ModelRenderer(this);
		RightLeg_r21.setPos(-6.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r21);
		setRotationAngle(RightLeg_r21, 0.1815F, -1.1101F, 0.0283F);
		RightLeg_r21.texOffs(78, 90).addBox(39.2158F, -23.673F, 18.5959F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		RightLeg_r22 = new ModelRenderer(this);
		RightLeg_r22.setPos(-2.8773F, 15.1257F, 3.8799F);
		RightLeg.addChild(RightLeg_r22);
		setRotationAngle(RightLeg_r22, 0.1265F, -0.0338F, 0.2597F);
		RightLeg_r22.texOffs(78, 90).addBox(-0.5521F, -13.1206F, 46.1594F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r23 = new ModelRenderer(this);
		RightLeg_r23.setPos(-1.1396F, 11.3321F, 3.3805F);
		RightLeg.addChild(RightLeg_r23);
		setRotationAngle(RightLeg_r23, 0.1309F, 0.0F, 0.0F);
		RightLeg_r23.texOffs(78, 90).addBox(1.0908F, -12.7312F, 46.1594F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		RightLeg_r24 = new ModelRenderer(this);
		RightLeg_r24.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r24);
		setRotationAngle(RightLeg_r24, -0.0436F, 0.0F, 0.0F);
		RightLeg_r24.texOffs(78, 90).addBox(0.0908F, -15.2421F, 43.4058F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightLeg_r25 = new ModelRenderer(this);
		RightLeg_r25.setPos(-0.1396F, -0.1569F, 3.8821F);
		RightLeg.addChild(RightLeg_r25);
		setRotationAngle(RightLeg_r25, 0.2618F, 0.0F, 0.0F);
		RightLeg_r25.texOffs(78, 90).addBox(0.0908F, -14.9753F, 46.2872F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 9.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, -0.121F, -0.05F, -0.3897F);
		LeftLeg_r1.texOffs(101, 92).addBox(18.9626F, -42.8004F, 30.4187F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 3.0256F, 0.3201F, 2.7968F);
		LeftLeg_r2.texOffs(96, 35).addBox(-25.2418F, -25.4112F, -32.279F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, 3.0268F, 0.305F, 2.2461F);
		LeftLeg_r3.texOffs(101, 92).addBox(-37.2252F, -11.9163F, -27.5345F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r4 = new ModelRenderer(this);
		LeftLeg_r4.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r4);
		setRotationAngle(LeftLeg_r4, -3.1269F, 0.3249F, 2.6589F);
		LeftLeg_r4.texOffs(101, 92).addBox(-31.6911F, -25.8124F, -27.5345F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r5 = new ModelRenderer(this);
		LeftLeg_r5.setPos(6.5372F, 12.4623F, -6.2034F);
		LeftLeg.addChild(LeftLeg_r5);
		setRotationAngle(LeftLeg_r5, -2.9871F, 0.2874F, 3.1152F);
		LeftLeg_r5.texOffs(101, 92).addBox(-17.7405F, -37.973F, -27.5345F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg_r6 = new ModelRenderer(this);
		LeftLeg_r6.setPos(6.6013F, 12.3738F, -6.1697F);
		LeftLeg.addChild(LeftLeg_r6);
		setRotationAngle(LeftLeg_r6, -3.0831F, 0.3201F, 2.7968F);
		LeftLeg_r6.texOffs(101, 92).addBox(-28.2418F, -38.8192F, -27.5345F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		LeftLeg_r6.texOffs(101, 92).addBox(-26.2418F, -37.8192F, -27.5345F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		LeftLeg_r7 = new ModelRenderer(this);
		LeftLeg_r7.setPos(-3.3457F, 4.7914F, -7.1957F);
		LeftLeg.addChild(LeftLeg_r7);
		setRotationAngle(LeftLeg_r7, 0.2696F, -0.0447F, -0.3463F);
		LeftLeg_r7.texOffs(101, 92).addBox(20.4048F, -15.2058F, 41.9158F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r8 = new ModelRenderer(this);
		LeftLeg_r8.setPos(6.0333F, 14.8874F, -3.0176F);
		LeftLeg.addChild(LeftLeg_r8);
		setRotationAngle(LeftLeg_r8, -0.9249F, 0.4264F, -0.8026F);
		LeftLeg_r8.texOffs(101, 92).addBox(8.4783F, -50.1769F, 9.8275F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r9 = new ModelRenderer(this);
		LeftLeg_r9.setPos(-3.2859F, 5.2417F, -5.0329F);
		LeftLeg.addChild(LeftLeg_r9);
		setRotationAngle(LeftLeg_r9, 0.0951F, -0.0447F, -0.3463F);
		LeftLeg_r9.texOffs(101, 92).addBox(21.4048F, -15.0223F, 37.9147F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r10 = new ModelRenderer(this);
		LeftLeg_r10.setPos(-2.0081F, 5.5409F, -6.2858F);
		LeftLeg.addChild(LeftLeg_r10);
		setRotationAngle(LeftLeg_r10, -0.1289F, -0.0227F, -0.1731F);
		LeftLeg_r10.texOffs(101, 92).addBox(11.2529F, -24.1314F, 30.4187F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftLeg_r10.texOffs(101, 92).addBox(10.2529F, -27.1314F, 30.4187F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r11 = new ModelRenderer(this);
		LeftLeg_r11.setPos(-3.8474F, 7.1788F, -11.4113F);
		LeftLeg.addChild(LeftLeg_r11);
		setRotationAngle(LeftLeg_r11, -0.1135F, -0.0653F, -0.5199F);
		LeftLeg_r11.texOffs(101, 92).addBox(17.026F, -24.2082F, 31.4187F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg_r12 = new ModelRenderer(this);
		LeftLeg_r12.setPos(-2.1632F, -4.0475F, -9.018F);
		LeftLeg.addChild(LeftLeg_r12);
		setRotationAngle(LeftLeg_r12, -0.2704F, -0.0983F, 0.0644F);
		LeftLeg_r12.texOffs(114, 64).addBox(4.5855F, -39.6689F, 27.0451F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r13 = new ModelRenderer(this);
		LeftLeg_r13.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r13);
		setRotationAngle(LeftLeg_r13, -0.1308F, 0.0057F, 0.0433F);
		LeftLeg_r13.texOffs(101, 92).addBox(2.2673F, -33.507F, 29.4187F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		LeftLeg_r14 = new ModelRenderer(this);
		LeftLeg_r14.setPos(0.0F, 2.4518F, -5.8791F);
		LeftLeg.addChild(LeftLeg_r14);
		setRotationAngle(LeftLeg_r14, -0.1278F, -0.0283F, -0.2164F);
		LeftLeg_r14.texOffs(101, 92).addBox(10.5447F, -45.557F, 28.4187F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg_r15 = new ModelRenderer(this);
		LeftLeg_r15.setPos(-2.8778F, 11.009F, 8.8684F);
		LeftLeg.addChild(LeftLeg_r15);
		setRotationAngle(LeftLeg_r15, -0.2818F, -0.0458F, -0.0047F);
		LeftLeg_r15.texOffs(112, 109).addBox(5.1989F, -41.7186F, 24.1903F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg_r16 = new ModelRenderer(this);
		LeftLeg_r16.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r16);
		setRotationAngle(LeftLeg_r16, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r16.texOffs(112, 109).addBox(1.2536F, -8.1259F, 53.6133F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		LeftLeg_r16.texOffs(112, 109).addBox(1.2536F, -6.1259F, 53.6133F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg_r16.texOffs(112, 109).addBox(1.2536F, -10.1259F, 52.6133F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		LeftLeg_r17 = new ModelRenderer(this);
		LeftLeg_r17.setPos(11.4441F, 6.5575F, 4.7056F);
		LeftLeg.addChild(LeftLeg_r17);
		setRotationAngle(LeftLeg_r17, 1.4068F, 0.2521F, 0.0452F);
		LeftLeg_r17.texOffs(102, 23).addBox(-7.3034F, 31.5074F, 31.9191F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r18 = new ModelRenderer(this);
		LeftLeg_r18.setPos(6.6774F, 10.511F, 6.5659F);
		LeftLeg.addChild(LeftLeg_r18);
		setRotationAngle(LeftLeg_r18, -0.0915F, 0.5398F, -1.2653F);
		LeftLeg_r18.texOffs(114, 23).addBox(8.7383F, -8.3853F, 45.6133F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		LeftLeg_r18.texOffs(100, 23).addBox(8.7383F, -11.3853F, 45.6133F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		LeftLeg_r19 = new ModelRenderer(this);
		LeftLeg_r19.setPos(4.2319F, 7.2039F, 6.4029F);
		LeftLeg.addChild(LeftLeg_r19);
		setRotationAngle(LeftLeg_r19, 1.3974F, 0.2072F, -0.0254F);
		LeftLeg_r19.texOffs(113, 66).addBox(-3.8144F, 29.8902F, 32.0888F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		LeftLeg_r20 = new ModelRenderer(this);
		LeftLeg_r20.setPos(4.8443F, 9.0801F, 9.3639F);
		LeftLeg.addChild(LeftLeg_r20);
		setRotationAngle(LeftLeg_r20, 0.5991F, 0.5099F, -0.4257F);
		LeftLeg_r20.texOffs(113, 66).addBox(-5.9617F, 1.3139F, 46.768F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r21 = new ModelRenderer(this);
		LeftLeg_r21.setPos(-3.7346F, 9.2118F, 7.4768F);
		LeftLeg.addChild(LeftLeg_r21);
		setRotationAngle(LeftLeg_r21, 0.2441F, 0.7634F, -0.1541F);
		LeftLeg_r21.texOffs(113, 66).addBox(-13.7773F, -19.8693F, 41.7445F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r22 = new ModelRenderer(this);
		LeftLeg_r22.setPos(-2.6153F, 12.9096F, 9.4445F);
		LeftLeg.addChild(LeftLeg_r22);
		setRotationAngle(LeftLeg_r22, 0.1356F, -0.2792F, 1.5097F);
		LeftLeg_r22.texOffs(113, 66).addBox(-22.1685F, 2.5305F, 42.7937F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r23 = new ModelRenderer(this);
		LeftLeg_r23.setPos(0.3132F, 8.893F, 11.2963F);
		LeftLeg.addChild(LeftLeg_r23);
		setRotationAngle(LeftLeg_r23, 0.427F, 0.297F, -0.439F);
		LeftLeg_r23.texOffs(113, 66).addBox(2.7452F, -7.1661F, 44.9105F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		LeftLeg_r24 = new ModelRenderer(this);
		LeftLeg_r24.setPos(-2.4699F, 5.453F, 7.954F);
		LeftLeg.addChild(LeftLeg_r24);
		setRotationAngle(LeftLeg_r24, 0.7987F, 0.2599F, -0.3568F);
		LeftLeg_r24.texOffs(113, 66).addBox(2.8697F, 8.8656F, 43.1881F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		LeftLeg_r25 = new ModelRenderer(this);
		LeftLeg_r25.setPos(-2.6793F, 11.3583F, 8.9952F);
		LeftLeg.addChild(LeftLeg_r25);
		setRotationAngle(LeftLeg_r25, 0.257F, -0.1746F, 0.9826F);
		LeftLeg_r25.texOffs(113, 66).addBox(-19.3477F, -14.0579F, 42.7937F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r26 = new ModelRenderer(this);
		LeftLeg_r26.setPos(2.4477F, 7.2158F, 5.8952F);
		LeftLeg.addChild(LeftLeg_r26);
		setRotationAngle(LeftLeg_r26, 1.0504F, 0.0524F, 0.8515F);
		LeftLeg_r26.texOffs(113, 66).addBox(-24.8051F, 15.4518F, 35.4324F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r27 = new ModelRenderer(this);
		LeftLeg_r27.setPos(-3.0047F, 9.9526F, 6.5206F);
		LeftLeg.addChild(LeftLeg_r27);
		setRotationAngle(LeftLeg_r27, 0.375F, 0.7634F, -0.1541F);
		LeftLeg_r27.texOffs(113, 66).addBox(-14.7773F, -21.6159F, 44.4069F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r28 = new ModelRenderer(this);
		LeftLeg_r28.setPos(-4.7346F, 9.2118F, 1.4768F);
		LeftLeg.addChild(LeftLeg_r28);
		setRotationAngle(LeftLeg_r28, 0.4241F, -0.5792F, -0.1329F);
		LeftLeg_r28.texOffs(113, 66).addBox(31.1243F, -15.4041F, 37.3699F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftLeg_r29 = new ModelRenderer(this);
		LeftLeg_r29.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r29);
		setRotationAngle(LeftLeg_r29, 0.555F, -0.5792F, -0.1329F);
		LeftLeg_r29.texOffs(113, 66).addBox(30.1243F, -17.4988F, 40.4698F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftLeg_r30 = new ModelRenderer(this);
		LeftLeg_r30.setPos(-4.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r30);
		setRotationAngle(LeftLeg_r30, 0.5151F, -0.8108F, -0.4443F);
		LeftLeg_r30.texOffs(112, 109).addBox(43.7234F, -36.177F, 22.123F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		LeftLeg_r31 = new ModelRenderer(this);
		LeftLeg_r31.setPos(7.5872F, 7.1335F, -0.1865F);
		LeftLeg.addChild(LeftLeg_r31);
		setRotationAngle(LeftLeg_r31, 0.9925F, 0.0954F, -0.931F);
		LeftLeg_r31.texOffs(112, 109).addBox(19.5009F, 28.0718F, 29.6877F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r32 = new ModelRenderer(this);
		LeftLeg_r32.setPos(7.5872F, 7.1335F, -0.1865F);
		LeftLeg.addChild(LeftLeg_r32);
		setRotationAngle(LeftLeg_r32, 0.3816F, 0.0954F, -0.931F);
		LeftLeg_r32.texOffs(112, 109).addBox(19.5009F, 1.985F, 40.534F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		LeftLeg_r33 = new ModelRenderer(this);
		LeftLeg_r33.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r33);
		setRotationAngle(LeftLeg_r33, -0.0363F, 0.3309F, -0.1175F);
		LeftLeg_r33.texOffs(112, 109).addBox(0.2536F, -31.1588F, 32.2545F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg_r33.texOffs(112, 109).addBox(-0.7464F, -39.1588F, 31.2545F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r34 = new ModelRenderer(this);
		LeftLeg_r34.setPos(2.8962F, 9.0632F, 5.0407F);
		LeftLeg.addChild(LeftLeg_r34);
		setRotationAngle(LeftLeg_r34, 0.4436F, 0.3309F, -0.1175F);
		LeftLeg_r34.texOffs(112, 109).addBox(-2.7464F, -19.1259F, 47.6133F, 4.0F, 8.0F, 2.0F, 0.0F, false);

		LeftLeg_r35 = new ModelRenderer(this);
		LeftLeg_r35.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r35);
		setRotationAngle(LeftLeg_r35, 0.3532F, 0.1942F, -0.1118F);
		LeftLeg_r35.texOffs(112, 109).addBox(6.0824F, -36.2443F, 48.4544F, 4.0F, 15.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.12F * limbSwingAmount;
		this.LeftLeg.yRot = MathHelper.cos(limbSwing * 0.5662F) * 0.12F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.017453292F;
		this.Head.xRot = headPitch * 0.017453292F;

		this.wing3.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
		this.wing4.xRot = netHeadYaw * 0.017453292F;
		this.wing.yRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.25F * limbSwingAmount;

		this.wing5.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.wing2.yRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.25F * limbSwingAmount;
		this.wing6.xRot = netHeadYaw * 0.017453292F;

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