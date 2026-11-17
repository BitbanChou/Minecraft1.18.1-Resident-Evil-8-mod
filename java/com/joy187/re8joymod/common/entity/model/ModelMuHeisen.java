// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMuHeisen;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMuHeisen<T extends EntityMuHeisen> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
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
	private final ModelRenderer wheel_r1;
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
	private final ModelRenderer Body_r58;
	private final ModelRenderer Body_r59;
	private final ModelRenderer Body_r60;
	private final ModelRenderer Body_r61;
	private final ModelRenderer Body_r62;
	private final ModelRenderer Body_r63;
	private final ModelRenderer Body_r64;
	private final ModelRenderer Body_r65;
	private final ModelRenderer Body_r66;
	private final ModelRenderer Body_r67;
	private final ModelRenderer Body_r68;
	private final ModelRenderer Body_r69;
	private final ModelRenderer Body_r70;
	private final ModelRenderer Body_r71;
	private final ModelRenderer Body_r72;
	private final ModelRenderer Body_r73;
	private final ModelRenderer Body_r74;
	private final ModelRenderer Body_r75;
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
	private final ModelRenderer Body_r100;
	private final ModelRenderer Body_r101;
	private final ModelRenderer Body_r102;
	private final ModelRenderer Body_r103;
	private final ModelRenderer Body_r104;
	private final ModelRenderer LeftLeg_r1;
	private final ModelRenderer LeftLeg_r2;
	private final ModelRenderer heart;
	private final ModelRenderer Body_r105;
	private final ModelRenderer Body_r106;
	private final ModelRenderer thread;
	private final ModelRenderer Body_r107;
	private final ModelRenderer Body_r108;
	private final ModelRenderer Body_r109;
	private final ModelRenderer thread2;
	private final ModelRenderer Body_r110;
	private final ModelRenderer Body_r111;
	private final ModelRenderer spark;
	private final ModelRenderer Body_r112;
	private final ModelRenderer Body_r113;
	private final ModelRenderer Body_r114;
	private final ModelRenderer bbb;
	private final ModelRenderer Body_r115;
	private final ModelRenderer Body_r116;
	private final ModelRenderer RightLeg;
	private final ModelRenderer vicer;
	private final ModelRenderer LeftLeg_r3;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer otherp;
	private final ModelRenderer RightLeg_r2;
	private final ModelRenderer RightArm;
	private final ModelRenderer Body_r117;
	private final ModelRenderer Body_r118;
	private final ModelRenderer Body_r119;
	private final ModelRenderer Body_r120;
	private final ModelRenderer Body_r121;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer saw2;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer LeftArm;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer saw;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;

	public ModelMuHeisen() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(-3.4779F, -33.9583F, -40.4964F);
		setRotationAngle(Head, -0.1047F, -0.4363F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(2.4779F, 1.8977F, 5.9449F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.1345F, 0.0F, 0.0F);
		Head_r1.texOffs(13, 40).addBox(4.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(3.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(0.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(1.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(-2.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(2.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(0, 5).addBox(-1.0F, -8.8586F, -7.5095F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(3.4779F, 4.6034F, 8.1481F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 1.1345F, 0.0F, 0.0F);
		Head_r2.texOffs(0, 17).addBox(-5.0F, -7.8586F, -7.5095F, 10.0F, 3.0F, 8.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(3.4779F, 15.9583F, 5.4964F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.2182F, 0.0F, 0.0F);
		Head_r3.texOffs(58, 52).addBox(-4.0F, -19.8586F, -8.5095F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head_r3.texOffs(0, 0).addBox(-5.0F, -22.8586F, -7.5095F, 10.0F, 9.0F, 9.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(3.4779F, -6.6834F, -2.6058F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.2182F, 0.0F, -0.3927F);
		Head_r4.texOffs(40, 0).addBox(-6.0F, -4.0F, 3.5F, 6.0F, 2.0F, 6.0F, 0.0F, false);
		Head_r4.texOffs(26, 0).addBox(-8.0F, -2.0F, 2.5F, 10.0F, 2.0F, 9.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(9.6208F, -11.8296F, 5.3288F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.2182F, 0.3491F, -0.0873F);
		Head_r5.texOffs(0, 49).addBox(-8.0F, 1.5F, 1.0F, 4.0F, 7.0F, 8.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(9.6208F, -11.8296F, 5.3288F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.2182F, 0.3491F, 0.3927F);
		Head_r6.texOffs(0, 49).addBox(-1.0F, 1.5F, 2.0F, 4.0F, 7.0F, 8.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(3.7046F, 15.9583F, 3.6931F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.2182F, 0.3491F, 0.0F);
		Head_r7.texOffs(0, 30).addBox(-5.0F, -20.8586F, 1.4905F, 10.0F, 7.0F, 9.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(0, 29).addBox(-7.4313F, -41.4708F, -28.7351F, 11.0F, 5.0F, 12.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-7.4313F, -30.4708F, -37.7351F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-7.4313F, -30.4708F, -25.7351F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-7.4313F, -30.4708F, -13.7351F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-7.4313F, -30.4708F, -1.7351F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-2.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-6.0F, 2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(8, 30).addBox(-16.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);
		Body.texOffs(8, 30).addBox(10.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, true);
		Body.texOffs(10, 36).addBox(39.5076F, -44.0955F, -11.1015F, 10.0F, 9.0F, 10.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(-1.673F, 19.3639F, 2.4869F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, -0.5304F, 0.1496F, -1.3718F);
		Body_r1.texOffs(18, 23).addBox(-3.3059F, -10.1448F, -18.8216F, 4.0F, 7.0F, 13.0F, 0.0F, false);
		Body_r1.texOffs(18, 23).addBox(-5.3059F, -3.1448F, -20.8216F, 8.0F, 2.0F, 13.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(15.1837F, 12.3535F, -8.3695F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, -1.4348F, 0.6483F, -1.2622F);
		Body_r2.texOffs(27, 42).addBox(-7.0F, 1.5F, -8.5F, 4.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(6.4598F, 12.7002F, -10.8582F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, -1.8275F, -0.0935F, -0.9568F);
		Body_r3.texOffs(30, 43).addBox(3.5189F, -2.8038F, -12.231F, 4.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(5.5959F, 12.0421F, -11.2868F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, -1.4348F, -0.0935F, -0.9568F);
		Body_r4.texOffs(16, 48).addBox(3.5189F, -2.8038F, 1.769F, 4.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(-19.8906F, 15.0409F, -12.8966F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.2618F, 0.0F, 0.0F);
		Body_r5.texOffs(18, 23).addBox(-4.0F, 0.0F, -2.5F, 11.0F, 2.0F, 8.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(-25.3051F, 14.9263F, -11.144F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.1385F, -0.5318F, 1.6514F);
		Body_r6.texOffs(18, 23).addBox(0.0F, -1.5F, -2.5F, 6.0F, 2.0F, 13.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(-0.5F, 7.2141F, 5.8971F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.5236F, 0.0F, 0.0F);
		Body_r7.texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(9.6891F, 11.1756F, 22.9115F);
		Body.addChild(Body_r8);
		setRotationAngle(Body_r8, -0.9599F, -0.2618F, 0.0F);
		Body_r8.texOffs(26, 51).addBox(-6.0F, -3.0F, -3.5F, 12.0F, 6.0F, 7.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(9.7582F, 8.125F, 22.6537F);
		Body.addChild(Body_r9);
		setRotationAngle(Body_r9, -2.0071F, -0.2618F, 0.0F);
		Body_r9.texOffs(26, 51).addBox(-6.0F, -3.0F, -3.5F, 12.0F, 6.0F, 7.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(-2.7257F, -4.0F, 3.5613F);
		Body.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.3491F, -0.2618F, 0.0F);
		Body_r10.texOffs(26, 51).addBox(11.0F, 12.0F, 10.5F, 12.0F, 6.0F, 7.0F, 0.0F, false);
		Body_r10.texOffs(35, 46).addBox(22.0F, 2.0F, -2.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		Body_r10.texOffs(12, 41).addBox(21.0F, 1.0F, 2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);
		Body_r10.texOffs(12, 41).addBox(11.0F, -1.0F, 7.5F, 12.0F, 9.0F, 14.0F, 0.0F, false);
		Body_r10.texOffs(12, 41).addBox(6.0F, -7.0F, -9.5F, 12.0F, 10.0F, 14.0F, 0.0F, false);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(16.395F, -10.086F, 5.1316F);
		Body.addChild(Body_r11);
		setRotationAngle(Body_r11, -0.3054F, 1.309F, -0.2182F);
		Body_r11.texOffs(33, 44).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(20.1624F, -6.487F, 7.2656F);
		Body.addChild(Body_r12);
		setRotationAngle(Body_r12, -1.3526F, -0.0436F, -0.2182F);
		Body_r12.texOffs(32, 43).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(20.1263F, -1.3616F, 9.0736F);
		Body.addChild(Body_r13);
		setRotationAngle(Body_r13, -1.0472F, -0.2618F, 0.0F);
		Body_r13.texOffs(36, 45).addBox(-1.5F, -1.5F, -3.5F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(-2.2954F, -3.316F, -1.9698F);
		Body.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.3491F, 0.3491F, 0.0F);
		Body_r14.texOffs(12, 41).addBox(-16.0F, -8.0F, 6.5F, 12.0F, 9.0F, 14.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(0.0F, -4.0F, 5.5F);
		Body.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.3491F, 0.0F, 0.0F);
		Body_r15.texOffs(12, 41).addBox(-17.0F, -7.0F, -9.5F, 12.0F, 9.0F, 14.0F, 0.0F, false);
		Body_r15.texOffs(12, 41).addBox(-6.0F, -7.0F, -9.5F, 12.0F, 9.0F, 14.0F, 0.0F, false);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(15.2865F, 10.2438F, -0.8999F);
		Body.addChild(Body_r16);
		setRotationAngle(Body_r16, 1.4399F, -0.6109F, 0.0F);
		Body_r16.texOffs(12, 41).addBox(-6.0F, -4.5F, -8.0F, 12.0F, 9.0F, 14.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(-0.0084F, -0.1928F, -6.2983F);
		Body.addChild(Body_r17);
		setRotationAngle(Body_r17, 1.4399F, -0.1745F, 0.0F);
		Body_r17.texOffs(12, 41).addBox(5.0F, -0.5F, -7.0F, 12.0F, 9.0F, 14.0F, 0.0F, false);
		Body_r17.texOffs(12, 41).addBox(-6.0F, -1.5F, -7.0F, 12.0F, 9.0F, 14.0F, 0.0F, false);
		Body_r17.texOffs(0, 41).addBox(-15.0F, -0.5F, -16.0F, 25.0F, 9.0F, 9.0F, 0.0F, false);
		Body_r17.texOffs(12, 41).addBox(-15.0F, -0.5F, -6.0F, 12.0F, 9.0F, 14.0F, 0.0F, false);
		Body_r17.texOffs(12, 41).addBox(-6.0F, -1.5F, -7.0F, 12.0F, 9.0F, 14.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(-13.8874F, 11.3695F, -3.8235F);
		Body.addChild(Body_r18);
		setRotationAngle(Body_r18, 1.4399F, -0.1745F, -0.4363F);
		Body_r18.texOffs(0, 41).addBox(-12.5F, -2.5F, -3.5F, 25.0F, 7.0F, 9.0F, 0.0F, false);
		Body_r18.texOffs(0, 41).addBox(-12.5F, 2.5F, 3.5F, 25.0F, 7.0F, 9.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(5.1763F, 11.2089F, -6.9083F);
		Body.addChild(Body_r19);
		setRotationAngle(Body_r19, 1.4399F, 0.3491F, 0.0F);
		Body_r19.texOffs(0, 41).addBox(-5.0F, -2.5F, -5.5F, 10.0F, 9.0F, 9.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(5.888F, -26.0001F, -21.2154F);
		Body.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.6109F, -0.1745F);
		Body_r20.texOffs(12, 29).addBox(-6.0F, -13.0F, 10.5F, 8.0F, 12.0F, 18.0F, 0.0F, true);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(5.888F, -26.0001F, -21.2154F);
		Body.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.1745F, -0.1745F);
		Body_r21.texOffs(12, 29).addBox(-2.0F, -13.0F, 5.5F, 5.0F, 12.0F, 23.0F, 0.0F, true);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(6.326F, -29.9848F, -38.7205F);
		Body.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, -0.7854F, 0.0436F);
		Body_r22.texOffs(12, 29).addBox(-1.5F, -5.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(5.888F, -26.0001F, -21.2154F);
		Body.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, -0.0436F, -0.1745F);
		Body_r23.texOffs(12, 29).addBox(-1.0F, -13.0F, -18.5F, 3.0F, 12.0F, 23.0F, 0.0F, true);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(-10.8538F, -39.8145F, -19.6924F);
		Body.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, -0.3491F, 0.0873F);
		Body_r24.texOffs(12, 29).addBox(-2.0F, -1.0F, 3.5F, 3.0F, 12.0F, 23.0F, 0.0F, false);
		Body_r24.texOffs(12, 29).addBox(-3.0F, -1.0F, -20.5F, 3.0F, 12.0F, 23.0F, 0.0F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(-3.9375F, -33.6884F, -42.7116F);
		Body.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, -0.829F, 0.0873F);
		Body_r25.texOffs(12, 29).addBox(-3.0F, -4.5F, -2.5F, 4.0F, 11.0F, 7.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, 0.6545F);
		Body_r26.texOffs(0, 29).addBox(0.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(-8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, 0.0F, -0.6545F);
		Body_r27.texOffs(0, 29).addBox(-5.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, false);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.0F, 0.0F, 1.3963F);
		Body_r28.texOffs(0, 27).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 15.0F, 22.0F, 0.0F, true);
		Body_r28.texOffs(12, 32).addBox(-3.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, 0.0F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(4.0359F, 16.4446F, 66.0646F);
		Body.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0436F, 1.2217F);
		Body_r29.texOffs(40, 54).addBox(-1.0F, -9.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-4.0359F, 16.4446F, 66.0646F);
		Body.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, -0.0436F, -1.2217F);
		Body_r30.texOffs(40, 54).addBox(-4.0F, -5.0F, -4.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(5.6698F, 5.4953F, 77.1521F);
		Body.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.3491F, -1.0036F);
		Body_r31.texOffs(16, 60).addBox(-4.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(-5.6698F, 5.4953F, 77.1521F);
		Body.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, -0.3491F, 1.0036F);
		Body_r32.texOffs(16, 60).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, true);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(1.0935F, 15.0584F, 83.1357F);
		Body.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, -0.3491F, 1.3963F);
		Body_r33.texOffs(16, 60).addBox(-8.0F, -4.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(-1.0935F, 15.0584F, 83.1357F);
		Body.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.1309F, -1.6144F);
		Body_r34.texOffs(16, 60).addBox(6.0F, 1.0F, -2.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(-1.0935F, 15.0584F, 83.1357F);
		Body.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.3491F, -1.6144F);
		Body_r35.texOffs(16, 60).addBox(-2.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(2.2121F, 21.993F, 38.785F);
		Body.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, -0.0436F, -1.6144F);
		Body_r36.texOffs(40, 53).addBox(16.0F, -2.0F, 42.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r36.texOffs(0, 29).addBox(10.0F, -11.0F, 20.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r36.texOffs(0, 29).addBox(10.0F, -11.0F, 31.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r36.texOffs(0, 29).addBox(12.0F, -11.0F, 21.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Body_r36.texOffs(0, 29).addBox(7.0F, -3.0F, 26.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);
		Body_r36.texOffs(0, 29).addBox(7.0F, -5.0F, 7.0F, 4.0F, 10.0F, 16.0F, 0.0F, false);

		wheel_r1 = new ModelRenderer(this);
		wheel_r1.setPos(2.2121F, 16.993F, 83.785F);
		Body.addChild(wheel_r1);
		setRotationAngle(wheel_r1, 0.0F, -0.0436F, -1.6144F);
		wheel_r1.texOffs(40, 54).addBox(-2.9534F, -2.2181F, -2.7393F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-2.2121F, 21.993F, 38.785F);
		Body.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0436F, 1.6144F);
		Body_r37.texOffs(0, 29).addBox(-14.0F, -14.0F, 21.0F, 4.0F, 2.0F, 1.0F, 0.0F, true);
		Body_r37.texOffs(0, 29).addBox(-14.0F, -14.0F, 32.0F, 4.0F, 2.0F, 1.0F, 0.0F, true);
		Body_r37.texOffs(0, 29).addBox(-14.0F, -14.0F, 22.0F, 2.0F, 2.0F, 10.0F, 0.0F, true);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(1.989F, 16.8828F, 44.0F);
		Body.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, -0.2618F, -1.6144F);
		Body_r38.texOffs(0, 29).addBox(1.0F, -5.0F, -11.0F, 4.0F, 10.0F, 17.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(-7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, -1.3963F);
		Body_r39.texOffs(0, 29).addBox(-1.0F, -3.0F, 7.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
		Body_r39.texOffs(0, 29).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(1.2275F, 4.0987F, 45.3715F);
		Body.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0436F, -0.3054F, -1.6144F);
		Body_r40.texOffs(7, 20).addBox(-5.0F, -7.5F, 9.0F, 6.0F, 17.0F, 17.0F, 0.0F, true);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-14.1794F, -23.1582F, 42.1038F);
		Body.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0436F, 0.0873F, -1.789F);
		Body_r41.texOffs(2, 55).addBox(-0.5F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(-16.1794F, -24.1582F, 57.1038F);
		Body.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0436F, 0.0873F, -1.789F);
		Body_r42.texOffs(2, 55).addBox(-0.5F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-14.9123F, -13.2308F, 23.815F);
		Body.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0436F, 0.0436F, -1.789F);
		Body_r43.texOffs(4, 40).addBox(-5.0F, 1.5F, 1.5F, 14.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-14.9123F, -13.2308F, 23.815F);
		Body.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0436F, -0.1745F, -1.789F);
		Body_r44.texOffs(5, 38).addBox(-14.0F, -3.5F, -7.5F, 22.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-14.9123F, -13.2308F, 23.815F);
		Body.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0436F, 0.1309F, -1.789F);
		Body_r45.texOffs(5, 38).addBox(-8.0F, -0.5F, -7.5F, 16.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r45.texOffs(5, 38).addBox(-8.0F, -0.5F, -4.5F, 16.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(-11.7801F, -14.7444F, 38.8116F);
		Body.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0436F, 0.3927F, -1.789F);
		Body_r46.texOffs(4, 40).addBox(-4.0F, -4.5F, -14.5F, 18.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(1.4011F, -11.2009F, 10.6123F);
		Body.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0436F, -0.3054F, -1.789F);
		Body_r47.texOffs(2, 55).addBox(5.5F, -12.5F, 24.0F, 18.0F, 3.0F, 3.0F, 0.0F, true);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-0.5989F, -12.2009F, 25.6123F);
		Body.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0436F, -0.3054F, -1.789F);
		Body_r48.texOffs(2, 55).addBox(5.5F, -12.5F, 24.0F, 18.0F, 3.0F, 3.0F, 0.0F, true);
		Body_r48.texOffs(2, 55).addBox(-10.5F, -12.5F, 23.0F, 16.0F, 4.0F, 5.0F, 0.0F, true);
		Body_r48.texOffs(11, 56).addBox(-0.5F, -11.5F, 45.0F, 4.0F, 9.0F, 7.0F, 0.0F, true);
		Body_r48.texOffs(11, 56).addBox(-4.5F, -1.5F, 41.0F, 4.0F, 9.0F, 7.0F, 0.0F, true);
		Body_r48.texOffs(11, 56).addBox(-4.5F, -0.5F, 34.0F, 8.0F, 3.0F, 5.0F, 0.0F, true);
		Body_r48.texOffs(7, 22).addBox(-8.5F, -5.5F, 26.0F, 6.0F, 11.0F, 20.0F, 0.0F, true);
		Body_r48.texOffs(7, 22).addBox(-5.5F, -5.5F, 11.0F, 6.0F, 11.0F, 20.0F, 0.0F, true);
		Body_r48.texOffs(5, 18).addBox(15.5F, -5.5F, -37.0F, 9.0F, 13.0F, 14.0F, 0.0F, true);
		Body_r48.texOffs(0, 30).addBox(-3.5F, -8.5F, -10.0F, 5.0F, 13.0F, 21.0F, 0.0F, true);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-1.4985F, 1.538F, 65.8732F);
		Body.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.7418F, -0.829F, -1.789F);
		Body_r49.texOffs(11, 56).addBox(-4.0F, -2.5F, -1.5F, 10.0F, 4.0F, 4.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(15.6679F, -13.4222F, 57.3077F);
		Body.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0436F, 0.0F, -1.0036F);
		Body_r50.texOffs(11, 56).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 4.0F, 2.0F, 0.0F, true);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(4.9426F, -1.276F, 61.5471F);
		Body.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0436F, 0.3054F, -1.0036F);
		Body_r51.texOffs(11, 56).addBox(5.0F, 0.5F, -1.5F, 8.0F, 4.0F, 2.0F, 0.0F, true);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(5.2143F, -1.7025F, 60.4475F);
		Body.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0436F, 0.0873F, -1.0036F);
		Body_r52.texOffs(11, 56).addBox(-4.0F, 0.5F, -1.5F, 8.0F, 4.0F, 2.0F, 0.0F, true);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-3.9497F, -28.7291F, 50.1501F);
		Body.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0436F, -0.48F, -1.4399F);
		Body_r53.texOffs(11, 56).addBox(-7.0F, 0.5F, -2.5F, 5.0F, 1.0F, 4.0F, 0.0F, true);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-3.911F, -28.5955F, 48.9185F);
		Body.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0436F, -0.3054F, -1.2654F);
		Body_r54.texOffs(11, 56).addBox(-6.0F, -2.5F, -2.5F, 5.0F, 1.0F, 4.0F, 0.0F, true);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-3.7488F, -28.9528F, 48.9185F);
		Body.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0436F, -0.3054F, -1.2654F);
		Body_r55.texOffs(50, 59).addBox(-6.0F, -1.5F, -0.5F, 5.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-5.7063F, -20.6846F, 46.4712F);
		Body.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0436F, -0.3054F, -1.789F);
		Body_r56.texOffs(32, 59).addBox(-11.0F, 1.5F, -2.5F, 12.0F, 1.0F, 4.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-5.1862F, -18.4494F, 45.31F);
		Body.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0436F, -0.3054F, -1.6581F);
		Body_r57.texOffs(11, 56).addBox(-6.0F, -2.5F, -2.5F, 12.0F, 1.0F, 4.0F, 0.0F, true);
		Body_r57.texOffs(36, 59).addBox(-6.0F, -1.5F, -1.5F, 12.0F, 3.0F, 2.0F, 0.0F, true);

		Body_r58 = new ModelRenderer(this);
		Body_r58.setPos(-12.3592F, -3.3924F, 40.7675F);
		Body.addChild(Body_r58);
		setRotationAngle(Body_r58, 0.0436F, 0.3927F, -1.5708F);
		Body_r58.texOffs(39, 50).addBox(-6.0F, 1.5F, -2.0F, 8.0F, 2.0F, 4.0F, 0.0F, true);

		Body_r59 = new ModelRenderer(this);
		Body_r59.setPos(-2.4947F, -8.1955F, 41.7015F);
		Body.addChild(Body_r59);
		setRotationAngle(Body_r59, 0.0436F, -0.3054F, -2.0508F);
		Body_r59.texOffs(11, 56).addBox(-6.0F, -2.5F, -2.5F, 12.0F, 1.0F, 4.0F, 0.0F, true);
		Body_r59.texOffs(36, 59).addBox(-6.0F, -1.5F, -1.5F, 12.0F, 3.0F, 2.0F, 0.0F, true);

		Body_r60 = new ModelRenderer(this);
		Body_r60.setPos(1.6359F, 7.7545F, 70.6461F);
		Body.addChild(Body_r60);
		setRotationAngle(Body_r60, 0.0436F, 0.0F, -1.789F);
		Body_r60.texOffs(7, 22).addBox(-3.0F, -3.5F, -1.0F, 6.0F, 6.0F, 11.0F, 0.0F, true);

		Body_r61 = new ModelRenderer(this);
		Body_r61.setPos(-4.1081F, -35.8703F, 16.4231F);
		Body.addChild(Body_r61);
		setRotationAngle(Body_r61, 0.0436F, -1.2217F, -1.789F);
		Body_r61.texOffs(53, 57).addBox(6.5F, -0.5F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r62 = new ModelRenderer(this);
		Body_r62.setPos(-6.6501F, -27.2783F, 21.7194F);
		Body.addChild(Body_r62);
		setRotationAngle(Body_r62, -0.5236F, -1.2217F, -1.789F);
		Body_r62.texOffs(5, 18).addBox(-4.5F, -10.5F, -7.0F, 9.0F, 13.0F, 14.0F, 0.0F, true);

		Body_r63 = new ModelRenderer(this);
		Body_r63.setPos(8.089F, -9.2031F, 25.7953F);
		Body.addChild(Body_r63);
		setRotationAngle(Body_r63, 0.2182F, -0.3491F, -0.9599F);
		Body_r63.texOffs(12, 35).addBox(-3.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r64 = new ModelRenderer(this);
		Body_r64.setPos(13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r64);
		setRotationAngle(Body_r64, -0.2618F, -0.2618F, 0.0F);
		Body_r64.texOffs(12, 35).addBox(-7.0F, -11.5F, -21.0F, 6.0F, 10.0F, 15.0F, 0.0F, true);
		Body_r64.texOffs(12, 35).addBox(-7.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r65 = new ModelRenderer(this);
		Body_r65.setPos(-13.5886F, -4.5927F, 11.9028F);
		Body.addChild(Body_r65);
		setRotationAngle(Body_r65, 0.6109F, 0.2618F, 0.3491F);
		Body_r65.texOffs(46, 19).addBox(-4.0F, 4.7927F, -4.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		Body_r65.texOffs(46, 13).addBox(-4.0F, 2.5F, -4.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		Body_r66 = new ModelRenderer(this);
		Body_r66.setPos(-13.5886F, -4.5927F, 11.9028F);
		Body.addChild(Body_r66);
		setRotationAngle(Body_r66, 0.0436F, 0.2618F, 0.3491F);
		Body_r66.texOffs(12, 35).addBox(-1.0F, -4.5F, -5.0F, 6.0F, 9.0F, 10.0F, 0.0F, false);

		Body_r67 = new ModelRenderer(this);
		Body_r67.setPos(-13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r67);
		setRotationAngle(Body_r67, -0.2618F, 0.2618F, 0.0F);
		Body_r67.texOffs(12, 35).addBox(2.0F, -19.5F, -12.0F, 6.0F, 10.0F, 17.0F, 0.0F, false);
		Body_r67.texOffs(12, 35).addBox(1.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r68 = new ModelRenderer(this);
		Body_r68.setPos(12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r68);
		setRotationAngle(Body_r68, 0.0F, -0.2618F, 0.0F);
		Body_r68.texOffs(12, 35).addBox(-5.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r69 = new ModelRenderer(this);
		Body_r69.setPos(4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r69);
		setRotationAngle(Body_r69, -0.0436F, -0.2618F, 0.0F);
		Body_r69.texOffs(10, 32).addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, true);

		Body_r70 = new ModelRenderer(this);
		Body_r70.setPos(-4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r70);
		setRotationAngle(Body_r70, -0.0436F, 0.2618F, 0.0F);
		Body_r70.texOffs(10, 32).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, false);

		Body_r71 = new ModelRenderer(this);
		Body_r71.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r71);
		setRotationAngle(Body_r71, -0.0436F, 0.0873F, 0.0F);
		Body_r71.texOffs(12, 35).addBox(1.0F, -1.5F, 7.0F, 7.0F, 9.0F, 21.0F, 0.0F, false);

		Body_r72 = new ModelRenderer(this);
		Body_r72.setPos(12.0F, 7.5F, 30.0F);
		Body.addChild(Body_r72);
		setRotationAngle(Body_r72, -0.0436F, -0.0873F, 0.0F);
		Body_r72.texOffs(12, 35).addBox(-5.9128F, -1.5435F, 7.9952F, 7.0F, 9.0F, 21.0F, 0.0F, true);

		Body_r73 = new ModelRenderer(this);
		Body_r73.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r73);
		setRotationAngle(Body_r73, 0.0F, 0.2618F, 0.0F);
		Body_r73.texOffs(12, 35).addBox(-1.0F, 3.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);
		Body_r73.texOffs(12, 35).addBox(0.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r74 = new ModelRenderer(this);
		Body_r74.setPos(-9.5641F, -32.9295F, 19.1736F);
		Body.addChild(Body_r74);
		setRotationAngle(Body_r74, 0.3491F, 0.0F, -0.4363F);
		Body_r74.texOffs(6, 36).addBox(-18.0F, -26.0F, -4.5F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		Body_r74.texOffs(6, 36).addBox(-4.0F, -36.0F, -7.5F, 6.0F, 12.0F, 12.0F, 0.0F, false);
		Body_r74.texOffs(6, 36).addBox(-21.0F, -41.0F, -12.5F, 6.0F, 7.0F, 12.0F, 0.0F, false);
		Body_r74.texOffs(6, 36).addBox(-19.0F, -14.0F, -6.5F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r75 = new ModelRenderer(this);
		Body_r75.setPos(-17.7443F, -46.6262F, 11.3521F);
		Body.addChild(Body_r75);
		setRotationAngle(Body_r75, 0.3491F, 0.0F, -0.0436F);
		Body_r75.texOffs(36, 38).addBox(-7.0F, 7.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		Body_r76 = new ModelRenderer(this);
		Body_r76.setPos(-13.5641F, -32.9295F, 19.1736F);
		Body.addChild(Body_r76);
		setRotationAngle(Body_r76, 0.3491F, 0.0F, -0.4363F);
		Body_r76.texOffs(6, 36).addBox(0.0F, -22.0F, -4.5F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		Body_r76.texOffs(6, 36).addBox(-1.0F, -10.0F, -6.5F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r77 = new ModelRenderer(this);
		Body_r77.setPos(-22.44F, -22.6828F, 17.3806F);
		Body.addChild(Body_r77);
		setRotationAngle(Body_r77, 0.3491F, 0.0F, -1.2654F);
		Body_r77.texOffs(6, 36).addBox(2.0F, -6.0F, -3.5F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r78 = new ModelRenderer(this);
		Body_r78.setPos(-25.7274F, -57.2076F, -7.342F);
		Body.addChild(Body_r78);
		setRotationAngle(Body_r78, -0.3939F, 0.5086F, -0.5051F);
		Body_r78.texOffs(6, 36).addBox(-3.0F, -6.5F, -2.0F, 6.0F, 7.0F, 12.0F, 0.0F, false);

		Body_r79 = new ModelRenderer(this);
		Body_r79.setPos(0.0F, -19.0F, 15.5F);
		Body.addChild(Body_r79);
		setRotationAngle(Body_r79, 0.0873F, 0.0F, 0.0F);
		Body_r79.texOffs(6, 36).addBox(-10.0F, 2.0F, 1.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r80 = new ModelRenderer(this);
		Body_r80.setPos(-7.3525F, -21.938F, 7.4885F);
		Body.addChild(Body_r80);
		setRotationAngle(Body_r80, 0.0873F, -0.3927F, -0.2182F);
		Body_r80.texOffs(23, 2).addBox(2.0F, -4.5F, -16.5F, 12.0F, 7.0F, 7.0F, 0.0F, false);

		Body_r81 = new ModelRenderer(this);
		Body_r81.setPos(12.9318F, -26.0779F, 8.0672F);
		Body.addChild(Body_r81);
		setRotationAngle(Body_r81, 0.0873F, 0.0436F, -0.2182F);
		Body_r81.texOffs(12, 0).addBox(-6.0F, -4.5F, -9.5F, 12.0F, 7.0F, 7.0F, 0.0F, false);

		Body_r82 = new ModelRenderer(this);
		Body_r82.setPos(13.6761F, -15.7074F, 11.253F);
		Body.addChild(Body_r82);
		setRotationAngle(Body_r82, 0.0873F, -1.0472F, -0.2182F);
		Body_r82.texOffs(4, 35).addBox(-5.0F, -9.0F, -5.5F, 12.0F, 7.0F, 7.0F, 0.0F, false);
		Body_r82.texOffs(4, 35).addBox(-3.0F, -5.0F, 1.5F, 11.0F, 11.0F, 7.0F, 0.0F, false);

		Body_r83 = new ModelRenderer(this);
		Body_r83.setPos(-9.4708F, -18.4711F, 7.5672F);
		Body.addChild(Body_r83);
		setRotationAngle(Body_r83, 0.6981F, 0.1745F, 0.0873F);
		Body_r83.texOffs(4, 35).addBox(-7.0F, -13.0F, -4.5F, 16.0F, 10.0F, 7.0F, 0.0F, false);

		Body_r84 = new ModelRenderer(this);
		Body_r84.setPos(-9.4708F, -18.4711F, 7.5672F);
		Body.addChild(Body_r84);
		setRotationAngle(Body_r84, 0.0873F, 0.5672F, -0.2182F);
		Body_r84.texOffs(4, 35).addBox(-10.0F, -5.0F, -4.5F, 16.0F, 10.0F, 7.0F, 0.0F, false);

		Body_r85 = new ModelRenderer(this);
		Body_r85.setPos(6.5968F, -15.2985F, 24.2035F);
		Body.addChild(Body_r85);
		setRotationAngle(Body_r85, 0.0873F, 0.0F, -0.2182F);
		Body_r85.texOffs(4, 35).addBox(-15.0F, -6.0F, -16.5F, 16.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r85.texOffs(4, 35).addBox(-10.0F, -6.0F, -3.5F, 16.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r86 = new ModelRenderer(this);
		Body_r86.setPos(-16.0F, -34.5563F, 9.8431F);
		Body.addChild(Body_r86);
		setRotationAngle(Body_r86, 0.3491F, 0.0F, 0.1745F);
		Body_r86.texOffs(6, 36).addBox(-3.0F, -7.0F, -6.5F, 12.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r87 = new ModelRenderer(this);
		Body_r87.setPos(0.0F, -19.0F, 15.5F);
		Body.addChild(Body_r87);
		setRotationAngle(Body_r87, 0.7854F, 0.0F, 0.0F);
		Body_r87.texOffs(6, 36).addBox(-22.0F, -10.0F, -1.5F, 12.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r87.texOffs(6, 36).addBox(-13.0F, -19.0F, 15.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r87.texOffs(6, 36).addBox(-9.0F, -19.0F, 4.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r87.texOffs(6, 36).addBox(-5.0F, -7.0F, 4.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r87.texOffs(6, 36).addBox(-10.0F, -10.0F, -1.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r88 = new ModelRenderer(this);
		Body_r88.setPos(30.9314F, -46.2448F, 10.2308F);
		Body.addChild(Body_r88);
		setRotationAngle(Body_r88, -2.5677F, 0.6331F, -0.8182F);
		Body_r88.texOffs(6, 36).addBox(-2.5F, -4.0F, -9.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);

		Body_r89 = new ModelRenderer(this);
		Body_r89.setPos(38.4479F, -47.3854F, -6.3076F);
		Body.addChild(Body_r89);
		setRotationAngle(Body_r89, -3.067F, 0.9781F, -0.108F);
		Body_r89.texOffs(6, 36).addBox(-12.0F, -10.0F, 2.5F, 3.0F, 3.0F, 21.0F, 0.0F, false);

		Body_r90 = new ModelRenderer(this);
		Body_r90.setPos(21.6498F, -45.5292F, 13.0541F);
		Body.addChild(Body_r90);
		setRotationAngle(Body_r90, -2.4561F, 0.9781F, -0.108F);
		Body_r90.texOffs(6, 36).addBox(-1.5F, -5.0F, -13.0F, 4.0F, 6.0F, 21.0F, 0.0F, false);

		Body_r91 = new ModelRenderer(this);
		Body_r91.setPos(21.4174F, -27.3249F, 22.6276F);
		Body.addChild(Body_r91);
		setRotationAngle(Body_r91, -1.4835F, 0.48F, -0.3491F);
		Body_r91.texOffs(6, 36).addBox(13.0F, 6.0F, -11.5F, 20.0F, 4.0F, 5.0F, 0.0F, false);
		Body_r91.texOffs(6, 36).addBox(13.0F, 12.0F, -11.5F, 20.0F, 4.0F, 5.0F, 0.0F, false);
		Body_r91.texOffs(6, 36).addBox(13.0F, 12.0F, -5.5F, 20.0F, 4.0F, 5.0F, 0.0F, false);

		Body_r92 = new ModelRenderer(this);
		Body_r92.setPos(21.4174F, -27.3249F, 22.6276F);
		Body.addChild(Body_r92);
		setRotationAngle(Body_r92, -1.4835F, 0.48F, 0.0436F);
		Body_r92.texOffs(6, 36).addBox(-17.0F, 8.0F, -19.5F, 15.0F, 12.0F, 7.0F, 0.0F, false);
		Body_r92.texOffs(6, 36).addBox(-7.0F, 8.0F, -15.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r93 = new ModelRenderer(this);
		Body_r93.setPos(23.0F, -26.7782F, 22.5503F);
		Body.addChild(Body_r93);
		setRotationAngle(Body_r93, -1.4835F, 0.48F, -0.1745F);
		Body_r93.texOffs(10, 0).addBox(-7.0F, 8.0F, -7.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r94 = new ModelRenderer(this);
		Body_r94.setPos(-4.0F, -31.4185F, 15.9722F);
		Body.addChild(Body_r94);
		setRotationAngle(Body_r94, 0.1309F, 0.0F, 0.0F);
		Body_r94.texOffs(6, 36).addBox(-5.0F, -7.0F, 0.5F, 20.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r95 = new ModelRenderer(this);
		Body_r95.setPos(-3.5F, -7.0F, 14.5F);
		Body.addChild(Body_r95);
		setRotationAngle(Body_r95, 1.8762F, 0.0F, 0.0F);
		Body_r95.texOffs(0, 29).addBox(-4.5F, -8.0F, -3.5F, 13.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r96 = new ModelRenderer(this);
		Body_r96.setPos(3.5687F, -28.4708F, 4.2649F);
		Body.addChild(Body_r96);
		setRotationAngle(Body_r96, 0.0F, 0.1745F, 0.0F);
		Body_r96.texOffs(0, 29).addBox(-3.0F, -2.0F, -20.0F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body_r96.texOffs(0, 29).addBox(-3.0F, -2.0F, -6.0F, 10.0F, 4.0F, 12.0F, 0.0F, false);

		Body_r97 = new ModelRenderer(this);
		Body_r97.setPos(-12.4313F, -28.4708F, -7.7351F);
		Body.addChild(Body_r97);
		setRotationAngle(Body_r97, 0.0F, -0.3054F, 0.0F);
		Body_r97.texOffs(0, 29).addBox(-5.0F, -2.0F, -20.0F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body_r97.texOffs(0, 29).addBox(-3.0F, -2.0F, 3.0F, 10.0F, 4.0F, 12.0F, 0.0F, false);
		Body_r97.texOffs(0, 29).addBox(-5.0F, -2.0F, -8.0F, 10.0F, 4.0F, 13.0F, 0.0F, false);

		Body_r98 = new ModelRenderer(this);
		Body_r98.setPos(11.0687F, -41.9708F, 9.2649F);
		Body.addChild(Body_r98);
		setRotationAngle(Body_r98, 0.6109F, -0.6545F, 0.0F);
		Body_r98.texOffs(0, 29).addBox(-9.5F, -7.5F, -3.0F, 11.0F, 5.0F, 12.0F, 0.0F, false);

		Body_r99 = new ModelRenderer(this);
		Body_r99.setPos(1.0687F, -40.9708F, -1.7351F);
		Body.addChild(Body_r99);
		setRotationAngle(Body_r99, 0.3927F, 0.1745F, 0.0F);
		Body_r99.texOffs(0, 29).addBox(-5.5F, -8.5F, -6.0F, 11.0F, 5.0F, 12.0F, 0.0F, false);

		Body_r100 = new ModelRenderer(this);
		Body_r100.setPos(-14.216F, -46.1305F, -1.3745F);
		Body.addChild(Body_r100);
		setRotationAngle(Body_r100, 2.6616F, 0.0436F, 0.0F);
		Body_r100.texOffs(27, 0).addBox(-4.5F, -5.5F, -11.0F, 7.0F, 5.0F, 10.0F, 0.0F, false);

		Body_r101 = new ModelRenderer(this);
		Body_r101.setPos(-8.9289F, -38.0542F, -8.9123F);
		Body.addChild(Body_r101);
		setRotationAngle(Body_r101, 0.3054F, -0.3927F, 0.0F);
		Body_r101.texOffs(0, 29).addBox(-5.5F, -7.5F, 4.0F, 7.0F, 5.0F, 14.0F, 0.0F, false);

		Body_r102 = new ModelRenderer(this);
		Body_r102.setPos(-6.9313F, -40.9708F, -13.7351F);
		Body.addChild(Body_r102);
		setRotationAngle(Body_r102, 0.2618F, -0.3927F, 0.0F);
		Body_r102.texOffs(1, 23).addBox(-5.5F, -2.5F, -6.0F, 8.0F, 5.0F, 14.0F, 0.0F, false);

		Body_r103 = new ModelRenderer(this);
		Body_r103.setPos(0.0687F, -40.9708F, -13.7351F);
		Body.addChild(Body_r103);
		setRotationAngle(Body_r103, 0.3491F, 0.0F, 0.0F);
		Body_r103.texOffs(9, 47).addBox(-4.5F, -2.5F, -6.0F, 10.0F, 5.0F, 12.0F, 0.0F, false);

		Body_r104 = new ModelRenderer(this);
		Body_r104.setPos(-4.2095F, 11.64F, -6.9824F);
		Body.addChild(Body_r104);
		setRotationAngle(Body_r104, 0.1745F, -0.9599F, 0.0F);
		Body_r104.texOffs(0, 58).addBox(3.3937F, 1.757F, 3.3439F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-14.9F, 13.2983F, 16.28F);
		Body.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.6545F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(34, 36).addBox(-24.0F, -59.0F, 28.0F, 6.0F, 8.0F, 9.0F, 0.0F, true);
		LeftLeg_r1.texOffs(42, 48).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, 0.0F, true);

		LeftLeg_r2 = new ModelRenderer(this);
		LeftLeg_r2.setPos(-14.9F, 21.0586F, 21.6966F);
		Body.addChild(LeftLeg_r2);
		setRotationAngle(LeftLeg_r2, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r2.texOffs(42, 48).addBox(-2.0F, -2.9886F, -2.7385F, 4.0F, 6.0F, 6.0F, 0.0F, true);

		heart = new ModelRenderer(this);
		heart.setPos(-1.6006F, -15.9329F, 5.1404F);
		Body.addChild(heart);
		

		Body_r105 = new ModelRenderer(this);
		Body_r105.setPos(0.0F, -3.0F, -2.0F);
		heart.addChild(Body_r105);
		setRotationAngle(Body_r105, 0.0F, 0.0F, -0.2182F);
		Body_r105.texOffs(4, 35).addBox(2.0F, -8.0F, -3.5F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		Body_r106 = new ModelRenderer(this);
		Body_r106.setPos(1.7783F, 5.0214F, 2.1468F);
		heart.addChild(Body_r106);
		setRotationAngle(Body_r106, 0.6545F, 0.0F, -0.2182F);
		Body_r106.texOffs(4, 35).addBox(2.0F, -8.0F, -3.5F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		thread = new ModelRenderer(this);
		thread.setPos(13.5024F, -15.4907F, 6.0697F);
		Body.addChild(thread);
		

		Body_r107 = new ModelRenderer(this);
		Body_r107.setPos(0.0F, 0.0F, 0.0F);
		thread.addChild(Body_r107);
		setRotationAngle(Body_r107, -0.0873F, 0.0F, 0.3491F);
		Body_r107.texOffs(4, 35).addBox(1.4976F, -5.0F, -4.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Body_r108 = new ModelRenderer(this);
		Body_r108.setPos(0.0F, 0.0F, 0.0F);
		thread.addChild(Body_r108);
		setRotationAngle(Body_r108, -0.0873F, 0.0F, 0.1745F);
		Body_r108.texOffs(4, 35).addBox(-1.0F, -5.0F, -4.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Body_r109 = new ModelRenderer(this);
		Body_r109.setPos(0.0F, 0.0F, 0.0F);
		thread.addChild(Body_r109);
		setRotationAngle(Body_r109, 0.0873F, 0.0F, 0.1745F);
		Body_r109.texOffs(32, 53).addBox(-1.0F, 2.0F, -6.5F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		Body_r109.texOffs(0, 46).addBox(0.0F, 3.0F, -7.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r109.texOffs(0, 46).addBox(0.0F, -8.0F, -6.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r109.texOffs(32, 53).addBox(-1.0F, -9.0F, -4.5F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		thread2 = new ModelRenderer(this);
		thread2.setPos(20.5024F, -29.4907F, -1.9303F);
		Body.addChild(thread2);
		setRotationAngle(thread2, -0.5236F, 0.0F, 0.9163F);
		

		Body_r110 = new ModelRenderer(this);
		Body_r110.setPos(0.0F, 0.0F, 0.0F);
		thread2.addChild(Body_r110);
		setRotationAngle(Body_r110, -0.0873F, 0.0F, 0.1745F);
		Body_r110.texOffs(4, 35).addBox(-1.0F, -5.0F, -4.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		Body_r111 = new ModelRenderer(this);
		Body_r111.setPos(0.0F, 0.0F, 0.0F);
		thread2.addChild(Body_r111);
		setRotationAngle(Body_r111, 0.0873F, 0.0F, 0.1745F);
		Body_r111.texOffs(0, 46).addBox(0.0F, -8.0F, -6.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r111.texOffs(32, 53).addBox(-1.0F, -9.0F, -4.5F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		spark = new ModelRenderer(this);
		spark.setPos(1.6803F, -65.6925F, 7.6459F);
		Body.addChild(spark);
		

		Body_r112 = new ModelRenderer(this);
		Body_r112.setPos(0.0F, 0.0F, 0.0F);
		spark.addChild(Body_r112);
		setRotationAngle(Body_r112, 2.0944F, 0.0F, -0.0436F);
		Body_r112.texOffs(6, 36).addBox(-2.0F, -1.0F, 0.0F, 3.0F, 7.0F, 2.0F, 0.0F, false);

		Body_r113 = new ModelRenderer(this);
		Body_r113.setPos(1.6488F, 14.839F, 12.1499F);
		spark.addChild(Body_r113);
		setRotationAngle(Body_r113, 0.1309F, 0.0F, -0.0436F);
		Body_r113.texOffs(6, 36).addBox(-3.0F, -21.0F, -5.75F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Body_r114 = new ModelRenderer(this);
		Body_r114.setPos(0.6282F, 14.3893F, 13.023F);
		spark.addChild(Body_r114);
		setRotationAngle(Body_r114, 0.3491F, 0.0F, -0.0436F);
		Body_r114.texOffs(6, 36).addBox(-3.0F, -9.0F, -7.75F, 6.0F, 12.0F, 7.0F, 0.0F, false);

		bbb = new ModelRenderer(this);
		bbb.setPos(19.1794F, -30.1582F, 33.1038F);
		Body.addChild(bbb);
		setRotationAngle(bbb, 0.0F, 0.6981F, 0.0F);
		

		Body_r115 = new ModelRenderer(this);
		Body_r115.setPos(0.0F, 0.0F, 0.0F);
		bbb.addChild(Body_r115);
		setRotationAngle(Body_r115, 0.0436F, -0.0873F, 1.789F);
		Body_r115.texOffs(2, 55).addBox(-1.5F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		Body_r116 = new ModelRenderer(this);
		Body_r116.setPos(-15.5805F, 11.9573F, -31.4915F);
		bbb.addChild(Body_r116);
		setRotationAngle(Body_r116, 0.0436F, 0.3054F, 1.789F);
		Body_r116.texOffs(2, 55).addBox(-23.5F, -12.5F, 24.0F, 18.0F, 3.0F, 3.0F, 0.0F, false);
		Body_r116.texOffs(2, 55).addBox(-5.5F, -12.5F, 23.0F, 16.0F, 4.0F, 5.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-18.9F, 21.0F, -8.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.2531F);
		RightLeg.texOffs(0, 38).addBox(-0.8103F, -4.3065F, -4.4032F, 4.0F, 7.0F, 8.0F, 0.0F, false);
		RightLeg.texOffs(0, 37).addBox(-4.8103F, -4.3065F, -4.4032F, 3.0F, 7.0F, 8.0F, 0.0F, false);

		vicer = new ModelRenderer(this);
		vicer.setPos(2.9F, 9.8855F, 0.2078F);
		

		LeftLeg_r3 = new ModelRenderer(this);
		LeftLeg_r3.setPos(0.0F, 0.0F, 0.0F);
		vicer.addChild(LeftLeg_r3);
		setRotationAngle(LeftLeg_r3, 0.0873F, 0.0F, 0.0F);
		LeftLeg_r3.texOffs(42, 48).addBox(9.0F, 0.0F, 28.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(20.45F, 21.457F, -5.4392F);
		setRotationAngle(LeftLeg, 0.3054F, 0.0F, -0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-1.4098F, 1.1098F, 15.8187F);
		LeftLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.2182F, 0.0F, -0.3054F);
		RightLeg_r1.texOffs(0, 42).addBox(-0.7287F, -1.2207F, -17.9795F, 4.0F, 7.0F, 7.0F, 0.0F, true);

		otherp = new ModelRenderer(this);
		otherp.setPos(-17.9F, 12.0F, 10.0F);
		otherp.texOffs(18, 44).addBox(32.8F, -11.0F, -10.0F, 2.0F, 7.0F, 3.0F, 0.0F, true);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(36.8F, 4.0808F, -5.211F);
		otherp.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, -0.9163F, 0.0F, 0.0F);
		RightLeg_r2.texOffs(20, 36).addBox(-4.0F, -4.5F, -8.5F, 2.0F, 3.0F, 1.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-29.8758F, -59.4532F, -8.3846F);
		setRotationAngle(RightArm, -0.1745F, 0.0F, 0.0F);
		

		Body_r117 = new ModelRenderer(this);
		Body_r117.setPos(3.7413F, -5.6261F, -1.073F);
		RightArm.addChild(Body_r117);
		setRotationAngle(Body_r117, 0.4788F, 0.5086F, -0.5051F);
		Body_r117.texOffs(6, 36).addBox(-4.5F, -8.5F, -2.5F, 5.0F, 17.0F, 5.0F, 0.0F, false);

		Body_r118 = new ModelRenderer(this);
		Body_r118.setPos(-10.2587F, 2.3739F, -1.073F);
		RightArm.addChild(Body_r118);
		setRotationAngle(Body_r118, 0.7418F, 0.0F, -0.4363F);
		Body_r118.texOffs(6, 36).addBox(-2.5F, -8.5F, -2.5F, 5.0F, 17.0F, 5.0F, 0.0F, false);

		Body_r119 = new ModelRenderer(this);
		Body_r119.setPos(-1.568F, -10.0515F, -14.009F);
		RightArm.addChild(Body_r119);
		setRotationAngle(Body_r119, 1.4144F, 0.8261F, -0.1245F);
		Body_r119.texOffs(6, 36).addBox(-6.5F, -8.5F, -2.5F, 5.0F, 17.0F, 5.0F, 0.0F, false);

		Body_r120 = new ModelRenderer(this);
		Body_r120.setPos(-15.568F, -2.0515F, -14.009F);
		RightArm.addChild(Body_r120);
		setRotationAngle(Body_r120, 1.4835F, 0.2618F, -0.0873F);
		Body_r120.texOffs(6, 36).addBox(-1.5F, -8.5F, -2.5F, 5.0F, 17.0F, 5.0F, 0.0F, false);

		Body_r121 = new ModelRenderer(this);
		Body_r121.setPos(-17.3898F, -19.8441F, 15.1463F);
		RightArm.addChild(Body_r121);
		setRotationAngle(Body_r121, 1.8762F, 0.0F, 0.0F);
		Body_r121.texOffs(0, 29).addBox(2.5F, -45.0F, -6.5F, 10.0F, 12.0F, 10.0F, 0.0F, false);
		Body_r121.texOffs(0, 29).addBox(-10.5F, -46.0F, -6.5F, 10.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-27.6899F, 25.8695F, -45.2552F);
		RightArm.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3054F, -0.9599F, 2.2253F);
		cube_r1.texOffs(0, 16).addBox(-8.0F, -4.0F, -7.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-15.6148F, 32.6855F, -43.848F);
		RightArm.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.8727F, 0.2618F, -0.3054F);
		cube_r2.texOffs(9, 35).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-18.6813F, 16.8043F, -39.5113F);
		RightArm.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.2618F, 0.0F, -0.3054F);
		cube_r3.texOffs(9, 35).addBox(-5.0F, 3.0F, -4.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-17.8898F, 19.1875F, -39.7701F);
		RightArm.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.6109F, 0.0F, 0.0F);
		cube_r4.texOffs(8, 34).addBox(-5.0F, -27.0F, -6.0F, 10.0F, 20.0F, 10.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-9.0156F, 13.4613F, -37.2513F);
		RightArm.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.2618F, 0.0F, 0.2618F);
		cube_r5.texOffs(9, 35).addBox(-1.5F, 1.0F, -4.0F, 2.0F, 11.0F, 7.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-8.3898F, 15.5826F, -37.7689F);
		RightArm.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.2618F, 0.0F, -0.3054F);
		cube_r6.texOffs(9, 35).addBox(-1.5F, -12.0F, -4.0F, 2.0F, 11.0F, 7.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-17.8898F, 19.1875F, -39.7701F);
		RightArm.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.2618F, 0.0F, 0.0F);
		cube_r7.texOffs(9, 35).addBox(-5.0F, -10.0F, -4.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);

		saw2 = new ModelRenderer(this);
		saw2.setPos(66.5115F, 53.2057F, -49.8199F);
		RightArm.addChild(saw2);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-77.2103F, -10.9124F, -5.4338F);
		saw2.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.1309F, -0.4363F, 0.6545F);
		cube_r8.texOffs(44, 54).addBox(-2.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r8.texOffs(44, 54).addBox(-2.5F, -5.0F, -3.5F, 7.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r8.texOffs(44, 54).addBox(-4.5F, 3.0F, -6.5F, 11.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r8.texOffs(14, 48).addBox(-4.5F, -6.0F, -6.5F, 11.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r8.texOffs(0, 16).addBox(-12.5F, -1.0F, -12.5F, 25.0F, 2.0F, 25.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(-71.6183F, -4.1537F, -17.8556F);
		saw2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.1309F, 0.4363F, 0.6545F);
		cube_r9.texOffs(14, 48).addBox(-20.0F, -2.0F, -6.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r9.texOffs(30, 54).addBox(-14.0F, 0.0F, -10.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r9.texOffs(30, 54).addBox(-8.0F, 0.0F, -5.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r9.texOffs(14, 48).addBox(-18.0F, -1.0F, 18.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r9.texOffs(14, 48).addBox(-7.0F, 0.0F, 11.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r9.texOffs(14, 48).addBox(-4.0F, 0.0F, 0.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(-96.0601F, -11.8101F, -18.3325F);
		saw2.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.1309F, -1.0472F, 0.6545F);
		cube_r10.texOffs(16, 27).addBox(8.0F, -7.0F, 1.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(43.9F, -32.1145F, -10.7922F);
		setRotationAngle(LeftArm, 0.0F, 0.2618F, 0.0436F);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(14.3744F, 15.8463F, -30.4135F);
		LeftArm.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.5236F, 0.2618F, 0.0F);
		cube_r11.texOffs(2, 19).addBox(-16.0F, -1.5F, -6.0F, 8.0F, 3.0F, 11.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(14.3744F, 15.8463F, -30.4135F);
		LeftArm.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.5236F, -0.0873F, 0.0F);
		cube_r12.texOffs(2, 19).addBox(-6.0F, -1.5F, -10.0F, 8.0F, 5.0F, 20.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-1.3744F, -2.0376F, -1.3724F);
		LeftArm.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.5236F, -0.0436F, 0.0F);
		cube_r13.texOffs(17, 46).addBox(-1.0F, -3.5F, -5.5F, 10.0F, 7.0F, 11.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(1.7388F, 5.0604F, -6.8656F);
		LeftArm.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.5236F, -0.4363F, 0.0F);
		cube_r14.texOffs(2, 19).addBox(0.5F, -4.5F, -22.5F, 4.0F, 5.0F, 20.0F, 0.0F, false);
		cube_r14.texOffs(2, 19).addBox(-2.5F, -2.5F, -22.5F, 3.0F, 5.0F, 20.0F, 0.0F, false);
		cube_r14.texOffs(42, 10).addBox(1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 8.0F, 0.0F, false);
		cube_r14.texOffs(48, 13).addBox(-2.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(15.4747F, 16.3104F, -9.9329F);
		LeftArm.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.5236F, -1.9635F, 0.0F);
		cube_r15.texOffs(42, 10).addBox(-0.5F, -2.5F, -2.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(12.7354F, 12.3104F, -7.3842F);
		LeftArm.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.5236F, -0.5672F, 0.0F);
		cube_r16.texOffs(42, 10).addBox(-1.5F, -2.5F, -4.0F, 3.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(1.7388F, 5.0604F, -6.8656F);
		LeftArm.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.5236F, -1.3526F, 0.0F);
		cube_r17.texOffs(42, 10).addBox(1.5F, -2.5F, -10.5F, 3.0F, 5.0F, 8.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(14.11F, 15.0114F, -15.4863F);
		LeftArm.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.5236F, 0.4363F, 0.0F);
		cube_r18.texOffs(42, 10).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, 0.0F, false);

		saw = new ModelRenderer(this);
		saw.setPos(12.3669F, 23.8595F, -42.1516F);
		LeftArm.addChild(saw);
		

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, 0.0F, 0.0F);
		saw.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.1309F, -0.4363F, 0.6545F);
		cube_r19.texOffs(44, 54).addBox(-2.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r19.texOffs(44, 54).addBox(-2.5F, -5.0F, -3.5F, 7.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r19.texOffs(44, 54).addBox(-4.5F, 3.0F, -6.5F, 11.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r19.texOffs(14, 48).addBox(-4.5F, -6.0F, -6.5F, 11.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r19.texOffs(0, 15).addBox(-12.5F, -1.0F, -12.5F, 25.0F, 2.0F, 25.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(-4.3741F, -1.053F, -16.0122F);
		saw.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.1309F, -1.0472F, 0.6545F);
		cube_r20.texOffs(50, 17).addBox(26.5F, -1.0F, 10.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(30.5F, -1.0F, 5.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(27.5F, -1.0F, 0.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(23.5F, -1.0F, -4.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(20.5F, -1.0F, -10.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(13.5F, -1.0F, -10.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(8.5F, -1.0F, -7.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(8.5F, -1.0F, 16.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(3.5F, -1.0F, 10.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(0.5F, -1.0F, 5.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r20.texOffs(50, 17).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-4.3741F, -1.053F, -16.0122F);
		saw.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.1309F, -1.1781F, 0.6545F);
		cube_r21.texOffs(50, 17).addBox(3.5F, -1.0F, -5.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(-18.8499F, -0.8977F, -12.8987F);
		saw.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.1309F, -1.0472F, 0.6545F);
		cube_r22.texOffs(16, 27).addBox(8.0F, -7.0F, 1.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);
	}



	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.8F * limbSwingAmount;
		this.wheel_r1.yRot = MathHelper.cos(limbSwing * 0.7662F) * 1.8F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.8F * limbSwingAmount;
		this.LeftArm.yRot = MathHelper.cos(limbSwing * 0.3662F) * 0.8F * limbSwingAmount;

		this.RightArm.yRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.spark.yRot = netHeadYaw * 0.013453292F;

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		vicer.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		otherp.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

}