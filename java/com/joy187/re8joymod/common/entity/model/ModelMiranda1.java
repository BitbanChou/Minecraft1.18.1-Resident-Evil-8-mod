// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityMiranda1;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMiranda1<T extends EntityMiranda1> extends EntityModel<T> {
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
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer swi2;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer swi;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer cir;
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
	private final ModelRenderer circle;
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
	private final ModelRenderer Body_r58;
	private final ModelRenderer Body_r59;
	private final ModelRenderer Body_r60;
	private final ModelRenderer Body_r61;
	private final ModelRenderer Body_r62;
	private final ModelRenderer Body_r63;
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
	private final ModelRenderer wing3;
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
	private final ModelRenderer wing5;
	private final ModelRenderer wingp_r25;
	private final ModelRenderer wingp_r26;
	private final ModelRenderer wingp_r27;
	private final ModelRenderer wingp_r28;
	private final ModelRenderer wingp_r29;
	private final ModelRenderer wingp_r30;
	private final ModelRenderer wingp_r31;
	private final ModelRenderer wingp_r32;
	private final ModelRenderer wingp_r33;
	private final ModelRenderer wing6;
	private final ModelRenderer wingp_r34;
	private final ModelRenderer wingp_r35;
	private final ModelRenderer wingp_r36;
	private final ModelRenderer wingp_r37;
	private final ModelRenderer wingp_r38;
	private final ModelRenderer wingp_r39;
	private final ModelRenderer wingp_r40;
	private final ModelRenderer wingp_r41;
	private final ModelRenderer wingp_r42;
	private final ModelRenderer wing4;
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
	private final ModelRenderer wing2;
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
	private final ModelRenderer wingp_r64;
	private final ModelRenderer wingp_r65;
	private final ModelRenderer wingp_r66;
	private final ModelRenderer wingp_r67;
	private final ModelRenderer wingDown;
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
	private final ModelRenderer wingDown3;
	private final ModelRenderer wingp_r81;
	private final ModelRenderer wingp_r82;
	private final ModelRenderer wingp_r83;
	private final ModelRenderer wingp_r84;
	private final ModelRenderer wingp_r85;
	private final ModelRenderer wingp_r86;
	private final ModelRenderer wingp_r87;
	private final ModelRenderer wingp_r88;
	private final ModelRenderer wingp_r89;
	private final ModelRenderer wingDown4;
	private final ModelRenderer wingp_r90;
	private final ModelRenderer wingp_r91;
	private final ModelRenderer wingp_r92;
	private final ModelRenderer wingp_r93;
	private final ModelRenderer wingp_r94;
	private final ModelRenderer wingp_r95;
	private final ModelRenderer wingp_r96;
	private final ModelRenderer wingp_r97;
	private final ModelRenderer wingDown2;
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
	private final ModelRenderer wingp_r110;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer Rightbacktlib;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer Rightfrontlib;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer RightArm_r6;
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
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg_r1;

	public ModelMiranda1() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(-0.4444F, -23.0556F, -3.3889F);
		setRotationAngle(Head, -0.1047F, 0.0F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(2.3175F, -3.4454F, 4.533F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.1309F, -1.5708F);
		Head_r1.texOffs(35, 0).addBox(-0.0003F, -4.9993F, -7.9215F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Head_r1.texOffs(43, 1).addBox(-7.0003F, -2.9993F, -7.9215F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-0.9873F, 4.6244F, -1.9165F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, -0.1074F, 0.0749F, -2.5348F);
		Head_r2.texOffs(43, 1).addBox(-0.4266F, 0.8189F, -0.4738F, 3.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-1.6745F, 0.7548F, -2.4259F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, -0.0844F, 0.1002F, -2.2732F);
		Head_r3.texOffs(43, 1).addBox(-0.7342F, -1.8574F, -0.4738F, 4.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-2.2885F, 0.6526F, -2.4394F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, -0.1074F, 0.0749F, -2.5348F);
		Head_r4.texOffs(43, 1).addBox(-2.9266F, -0.6811F, -0.4738F, 6.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(-2.6633F, 0.7278F, -2.4295F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, -0.1249F, 0.0393F, -2.8386F);
		Head_r5.texOffs(43, 1).addBox(-2.1994F, 0.4534F, -0.4738F, 5.0F, 0.0F, 1.0F, 0.0F, true);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setPos(-2.9267F, -0.701F, -2.6176F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, -0.0172F, -0.1298F, 1.7028F);
		Head_r6.texOffs(43, 1).addBox(-2.4911F, 1.6305F, -0.4738F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setPos(-2.6633F, 0.7278F, -2.4295F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, -0.1304F, -0.0114F, 3.0551F);
		Head_r7.texOffs(43, 1).addBox(-2.5871F, 1.4959F, -0.4738F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Head_r7.texOffs(43, 1).addBox(-2.5871F, 0.4959F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setPos(2.1047F, -1.8234F, -2.7653F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, -0.0503F, 0.1209F, -1.9665F);
		Head_r8.texOffs(43, 1).addBox(-1.5764F, 1.8826F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r9 = new ModelRenderer(this);
		Head_r9.setPos(-0.9848F, -1.9144F, -3.3962F);
		Head.addChild(Head_r9);
		setRotationAngle(Head_r9, 0.4002F, -0.0539F, 1.8047F);
		Head_r9.texOffs(43, 1).addBox(-2.4717F, 3.692F, -0.9379F, 3.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r10 = new ModelRenderer(this);
		Head_r10.setPos(-4.8558F, -3.5191F, -0.3746F);
		Head.addChild(Head_r10);
		setRotationAngle(Head_r10, -0.0401F, -0.4463F, 1.8201F);
		Head_r10.texOffs(43, 1).addBox(-1.9145F, -0.493F, -0.6687F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Head_r11 = new ModelRenderer(this);
		Head_r11.setPos(4.7447F, -3.5191F, -0.3746F);
		Head.addChild(Head_r11);
		setRotationAngle(Head_r11, -0.0401F, 0.4463F, -1.8201F);
		Head_r11.texOffs(43, 1).addBox(-0.0855F, -0.493F, -0.6687F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r12 = new ModelRenderer(this);
		Head_r12.setPos(0.8737F, -1.9144F, -3.3962F);
		Head.addChild(Head_r12);
		setRotationAngle(Head_r12, 0.4002F, 0.0539F, -1.8047F);
		Head_r12.texOffs(43, 1).addBox(-0.5283F, 3.692F, -0.9379F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r13 = new ModelRenderer(this);
		Head_r13.setPos(0.8762F, 4.6244F, -1.9165F);
		Head.addChild(Head_r13);
		setRotationAngle(Head_r13, -0.1074F, -0.0749F, 2.5348F);
		Head_r13.texOffs(43, 1).addBox(-2.5734F, 0.8189F, -0.4738F, 3.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r14 = new ModelRenderer(this);
		Head_r14.setPos(1.5634F, 0.7548F, -2.4259F);
		Head.addChild(Head_r14);
		setRotationAngle(Head_r14, -0.0844F, -0.1002F, 2.2732F);
		Head_r14.texOffs(43, 1).addBox(-3.2658F, -1.8574F, -0.4738F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r15 = new ModelRenderer(this);
		Head_r15.setPos(2.1774F, 0.6526F, -2.4394F);
		Head.addChild(Head_r15);
		setRotationAngle(Head_r15, -0.1074F, -0.0749F, 2.5348F);
		Head_r15.texOffs(43, 1).addBox(-3.0734F, -0.6811F, -0.4738F, 6.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r16 = new ModelRenderer(this);
		Head_r16.setPos(2.5521F, 0.7278F, -2.4295F);
		Head.addChild(Head_r16);
		setRotationAngle(Head_r16, -0.1249F, -0.0393F, 2.8386F);
		Head_r16.texOffs(43, 1).addBox(-2.8006F, 0.4534F, -0.4738F, 5.0F, 0.0F, 1.0F, 0.0F, false);

		Head_r17 = new ModelRenderer(this);
		Head_r17.setPos(2.5521F, 0.7278F, -2.4295F);
		Head.addChild(Head_r17);
		setRotationAngle(Head_r17, -0.1304F, 0.0114F, -3.0551F);
		Head_r17.texOffs(43, 1).addBox(-1.4129F, 0.4959F, -0.4738F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head_r17.texOffs(43, 1).addBox(-2.4129F, 1.4959F, -0.4738F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r18 = new ModelRenderer(this);
		Head_r18.setPos(-3.0404F, -2.761F, 4.6231F);
		Head.addChild(Head_r18);
		setRotationAngle(Head_r18, -0.1074F, -0.0749F, 2.5348F);
		Head_r18.texOffs(37, 0).addBox(-7.5734F, -2.1804F, -7.9215F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r19 = new ModelRenderer(this);
		Head_r19.setPos(-0.5556F, 3.0556F, 5.3889F);
		Head.addChild(Head_r19);
		setRotationAngle(Head_r19, 0.1188F, -0.0552F, 0.4331F);
		Head_r19.texOffs(37, 0).addBox(-7.4225F, -5.9053F, -7.9215F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r20 = new ModelRenderer(this);
		Head_r20.setPos(0.4444F, 3.0556F, 5.3889F);
		Head.addChild(Head_r20);
		setRotationAngle(Head_r20, 0.1309F, 0.0F, 0.0F);
		Head_r20.texOffs(0, 62).addBox(-5.0F, -10.999F, -6.9215F, 9.0F, 9.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(44, 7).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 12.0F, 11.0F, 0.0F, false);
		Body.texOffs(44, 7).addBox(-5.0F, -20.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		Body.texOffs(86, 109).addBox(-6.0F, -19.0F, 5.0F, 12.0F, 18.0F, 2.0F, 0.0F, false);
		Body.texOffs(46, 65).addBox(-6.0F, -7.0F, -6.0F, 11.0F, 8.0F, 9.0F, 0.0F, false);
		Body.texOffs(0, 82).addBox(-7.0F, 1.0F, -6.0F, 13.0F, 22.0F, 9.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.0F, -17.0F, -0.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.0436F, 0.0F);
		Body_r1.texOffs(2, 47).addBox(-2.0F, -6.0F, -3.5F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(0.5F, -13.0F, -3.5F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, -0.6109F, 0.0F, 0.0F);
		Body_r2.texOffs(44, 7).addBox(-5.0F, -4.0F, -3.5F, 9.0F, 6.0F, 5.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(-0.5F, -19.5F, 5.0F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.3927F, 0.0F, 0.0F);
		Body_r3.texOffs(86, 109).addBox(-2.5F, -0.5F, -1.0F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(9.5F, -19.0F, -2.0F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.0F, -0.1745F);
		Body_r4.texOffs(38, 38).addBox(-3.5F, -1.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, true);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(-9.5F, -19.0F, -2.0F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.0F, 0.1745F);
		Body_r5.texOffs(38, 38).addBox(-1.5F, -1.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);

		swi2 = new ModelRenderer(this);
		swi2.setPos(-5.0F, -17.9256F, -6.5295F);
		Body.addChild(swi2);
		

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(0.0F, 0.0F, 0.0F);
		swi2.addChild(Body_r6);
		setRotationAngle(Body_r6, -0.0873F, 0.0F, 0.0F);
		Body_r6.texOffs(64, 93).addBox(-2.0F, 3.5F, -1.5F, 4.0F, 28.0F, 1.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(0.0F, 1.5197F, 0.4653F);
		swi2.addChild(Body_r7);
		setRotationAngle(Body_r7, -0.3491F, 0.0F, 0.0F);
		Body_r7.texOffs(66, 85).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 5.0F, 1.0F, 0.0F, false);

		swi = new ModelRenderer(this);
		swi.setPos(5.0F, -18.4059F, -6.0642F);
		Body.addChild(swi);
		

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(0.0F, 2.0F, 0.0F);
		swi.addChild(Body_r8);
		setRotationAngle(Body_r8, -0.3491F, 0.0F, 0.0F);
		Body_r8.texOffs(65, 84).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 5.0F, 1.0F, 0.0F, true);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(0.0F, 0.4803F, -0.4653F);
		swi.addChild(Body_r9);
		setRotationAngle(Body_r9, -0.0873F, 0.0F, 0.0F);
		Body_r9.texOffs(64, 93).addBox(-2.0F, 3.5F, -1.5F, 4.0F, 28.0F, 1.0F, 0.0F, true);

		cir = new ModelRenderer(this);
		cir.setPos(-1.5367F, -9.3923F, -7.5F);
		Body.addChild(cir);
		cir.texOffs(47, 3).addBox(3.1124F, -3.7573F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);
		cir.texOffs(47, 3).addBox(-2.039F, -3.9573F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(0.0F, 0.0F, 0.0F);
		cir.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, 1.0472F);
		Body_r10.texOffs(44, 0).addBox(-3.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(0.3784F, -0.7999F, 0.0F);
		cir.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.0F, 0.48F);
		Body_r11.texOffs(44, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(2.3319F, -8.1397F, -4.5F);
		cir.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.0F, -3.098F);
		Body_r12.texOffs(44, 0).addBox(-0.5F, -8.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(2.6951F, -0.7999F, 0.0F);
		cir.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, -0.48F);
		Body_r13.texOffs(44, 0).addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(3.0734F, 0.0F, 0.0F);
		cir.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, -1.0472F);
		Body_r14.texOffs(44, 0).addBox(1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(4.7565F, 0.7189F, 0.0F);
		cir.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, 0.0F, -1.5708F);
		Body_r15.texOffs(44, 0).addBox(3.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(3.5065F, -7.8122F, -4.5F);
		cir.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0F, 0.0F, -2.0944F);
		Body_r16.texOffs(44, 0).addBox(-3.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(2.9574F, -7.2631F, -4.5F);
		cir.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, 0.0F, -2.618F);
		Body_r17.texOffs(44, 0).addBox(-1.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(-0.433F, -7.8122F, -4.5F);
		cir.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.0F, 2.0944F);
		Body_r18.texOffs(44, 0).addBox(1.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(-1.683F, 0.7189F, 0.0F);
		cir.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, 1.5708F);
		Body_r19.texOffs(44, 0).addBox(-5.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(0.116F, -7.2631F, -4.5F);
		cir.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, 2.618F);
		Body_r20.texOffs(44, 0).addBox(-0.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(1.3292F, -1.8856F, 0.0F);
		cir.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 0.3491F);
		Body_r21.texOffs(41, 125).addBox(0.0F, -0.5F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, true);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(1.961F, -5.7573F, 0.0F);
		cir.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 0.7418F);
		Body_r22.texOffs(47, 3).addBox(-2.0F, 2.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(1.1124F, -5.7573F, 0.0F);
		cir.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, -0.7418F);
		Body_r23.texOffs(47, 3).addBox(0.0F, 2.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(1.1124F, -5.7573F, 0.0F);
		cir.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, -1.1345F);
		Body_r24.texOffs(47, 3).addBox(-1.0F, 1.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(0.9903F, -1.2868F, 0.0F);
		cir.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, -2.0071F);
		Body_r25.texOffs(47, 3).addBox(3.0F, 2.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);
		Body_r25.texOffs(41, 125).addBox(-1.0F, 2.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(-0.3647F, -2.3793F, 0.0F);
		cir.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, -0.8727F);
		Body_r26.texOffs(41, 125).addBox(-1.0F, 2.0F, -0.5F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(5.0044F, -1.656F, -4.5F);
		cir.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, 0.0F, -0.6109F);
		Body_r27.texOffs(41, 125).addBox(-2.5F, -3.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(4.8592F, -5.8811F, -4.5F);
		cir.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.0F, 0.0F, -1.789F);
		Body_r28.texOffs(41, 125).addBox(-2.5F, -3.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(2.3944F, -7.3819F, -4.5F);
		cir.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, -2.7489F);
		Body_r29.texOffs(41, 125).addBox(-0.5F, -4.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(2.0249F, -7.5349F, -4.5F);
		cir.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.0F, -2.7489F);
		Body_r30.texOffs(47, 0).addBox(-1.9F, -3.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(2.0249F, -7.5349F, -4.5F);
		cir.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.0F, -3.098F);
		Body_r31.texOffs(44, 0).addBox(-0.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		circle = new ModelRenderer(this);
		circle.setPos(-0.1203F, -20.1391F, 5.0F);
		Body.addChild(circle);
		circle.texOffs(44, 0).addBox(-1.6529F, -5.4852F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(3.7403F, -1.2461F, 0.0F);
		circle.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.0F, 3.0543F);
		Body_r32.texOffs(44, 0).addBox(1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(-5.4996F, -1.2461F, 0.0F);
		circle.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, 0.0F, -3.0543F);
		Body_r33.texOffs(44, 0).addBox(-5.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(3.27F, -1.6594F, 0.0F);
		circle.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.0F, 2.7053F);
		Body_r34.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(1.1203F, -5.3609F, 0.0F);
		circle.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.0F, -0.9599F);
		Body_r35.texOffs(44, 0).addBox(-1.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(7.6254F, -9.3427F, 0.0F);
		circle.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, 0.0F, -1.5272F);
		Body_r36.texOffs(44, 0).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(5.2466F, -4.7737F, -0.5F);
		circle.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0F, 0.6981F);
		Body_r37.texOffs(44, 0).addBox(-3.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(5.9307F, -6.6531F, -0.5F);
		circle.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, 0.0F, 0.3491F);
		Body_r38.texOffs(44, 0).addBox(-3.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(2.7341F, -11.7797F, -5.0F);
		circle.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, -0.1309F);
		Body_r39.texOffs(44, 0).addBox(0.5F, 2.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(2.7341F, -11.7797F, -5.0F);
		circle.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0F, 0.0F, -0.9599F);
		Body_r40.texOffs(44, 0).addBox(-0.5F, 0.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(-5.0059F, -4.7737F, -0.5F);
		circle.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0F, 0.0F, -0.6981F);
		Body_r41.texOffs(44, 0).addBox(-2.0F, 0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(-5.69F, -6.6531F, -0.5F);
		circle.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0F, 0.0F, -0.3491F);
		Body_r42.texOffs(44, 0).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(-2.4935F, -11.7797F, -5.0F);
		circle.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0F, 0.0F, 0.1309F);
		Body_r43.texOffs(44, 0).addBox(-4.5F, 2.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(-2.4935F, -11.7797F, -5.0F);
		circle.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0F, 0.0F, 0.9599F);
		Body_r44.texOffs(44, 0).addBox(-3.5F, 1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(-0.5532F, -12.1868F, -5.0F);
		circle.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0F, 0.0F, 3.0107F);
		Body_r45.texOffs(44, 0).addBox(-0.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(-8.6239F, -8.1063F, 0.0F);
		circle.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0F, 0.0F, 1.789F);
		Body_r46.texOffs(44, 0).addBox(-4.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r46.texOffs(44, 0).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(4.1591F, -7.6553F, -0.5F);
		circle.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0F, 0.0F, -1.6581F);
		Body_r47.texOffs(44, 0).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(-3.9185F, -7.6553F, -0.5F);
		circle.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0F, 0.0F, 1.6581F);
		Body_r48.texOffs(44, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(-3.5549F, -6.5447F, -0.5F);
		circle.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.0F, 0.0F, 1.0908F);
		Body_r49.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(2.7955F, -6.5447F, -0.5F);
		circle.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0F, 0.0F, -1.0908F);
		Body_r50.texOffs(44, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(7.8646F, -8.1063F, 0.0F);
		circle.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0F, 0.0F, -1.789F);
		Body_r51.texOffs(44, 0).addBox(2.0F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r51.texOffs(44, 0).addBox(1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(3.7365F, -12.413F, 0.0F);
		circle.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0F, 0.0F, -2.3126F);
		Body_r52.texOffs(46, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(-0.4869F, -16.7504F, -1.0F);
		circle.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0F, 0.0F, -2.4435F);
		Body_r53.texOffs(44, 0).addBox(-1.5F, -3.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(0.7276F, -16.7504F, -1.0F);
		circle.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0F, 0.0F, 2.4435F);
		Body_r54.texOffs(44, 0).addBox(-1.5F, -2.2F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-0.5073F, -16.301F, -1.0F);
		circle.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0F, 0.0F, -2.3562F);
		Body_r55.texOffs(0, 0).addBox(-1.7F, -2.2F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-0.5073F, -16.301F, -1.0F);
		circle.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0F, 0.0F, -3.1416F);
		Body_r56.texOffs(114, 2).addBox(-3.0723F, -11.2F, 0.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		Body_r56.texOffs(44, 0).addBox(-1.5F, -4.2F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r56.texOffs(44, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-0.2062F, -12.1868F, -5.0F);
		circle.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0F, 0.0F, -3.0107F);
		Body_r57.texOffs(44, 0).addBox(-1.5F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r58 = new ModelRenderer(this);
		Body_r58.setPos(2.2407F, -16.0F, 0.0F);
		circle.addChild(Body_r58);
		setRotationAngle(Body_r58, 0.0F, 0.0F, -2.9234F);
		Body_r58.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r59 = new ModelRenderer(this);
		Body_r59.setPos(-4.4958F, -12.413F, 0.0F);
		circle.addChild(Body_r59);
		setRotationAngle(Body_r59, 0.0F, 0.0F, 2.3126F);
		Body_r59.texOffs(44, 0).addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r60 = new ModelRenderer(this);
		Body_r60.setPos(-4.0293F, -1.6594F, 0.0F);
		circle.addChild(Body_r60);
		setRotationAngle(Body_r60, 0.0F, 0.0F, -2.7053F);
		Body_r60.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r61 = new ModelRenderer(this);
		Body_r61.setPos(-8.3847F, -9.3427F, 0.0F);
		circle.addChild(Body_r61);
		setRotationAngle(Body_r61, 0.0F, 0.0F, 1.5272F);
		Body_r61.texOffs(44, 0).addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r62 = new ModelRenderer(this);
		Body_r62.setPos(-1.8797F, -5.3609F, 0.0F);
		circle.addChild(Body_r62);
		setRotationAngle(Body_r62, 0.0F, 0.0F, 0.9599F);
		Body_r62.texOffs(44, 0).addBox(-5.0F, 3.5F, -1.0F, 6.0F, 2.0F, 1.0F, 0.0F, true);

		Body_r63 = new ModelRenderer(this);
		Body_r63.setPos(-3.0F, -16.0F, 0.0F);
		circle.addChild(Body_r63);
		setRotationAngle(Body_r63, 0.0F, 0.0F, 2.9234F);
		Body_r63.texOffs(44, 0).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wing = new ModelRenderer(this);
		wing.setPos(8.0F, -11.0F, 5.0F);
		Body.addChild(wing);
		setRotationAngle(wing, 0.0F, 0.0F, -0.3927F);
		wing.texOffs(47, 83).addBox(-1.0803F, -5.6236F, 0.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);

		wingp_r1 = new ModelRenderer(this);
		wingp_r1.setPos(20.5549F, -3.7481F, -4.2339F);
		wing.addChild(wingp_r1);
		setRotationAngle(wingp_r1, -0.1564F, 0.2635F, -0.5444F);
		wingp_r1.texOffs(46, 65).addBox(1.834F, -2.3529F, -0.1548F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		wingp_r1.texOffs(46, 65).addBox(0.834F, -2.3529F, -0.1548F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r2 = new ModelRenderer(this);
		wingp_r2.setPos(17.4382F, -0.7522F, -3.2512F);
		wing.addChild(wingp_r2);
		setRotationAngle(wingp_r2, -0.0547F, 0.3006F, -0.1828F);
		wingp_r2.texOffs(46, 65).addBox(1.0596F, -4.9394F, -0.1548F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r3 = new ModelRenderer(this);
		wingp_r3.setPos(17.4382F, -0.7522F, -3.2512F);
		wing.addChild(wingp_r3);
		setRotationAngle(wingp_r3, 0.0547F, 0.3006F, 0.1828F);
		wingp_r3.texOffs(46, 65).addBox(0.097F, -4.3197F, -0.1548F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r4 = new ModelRenderer(this);
		wingp_r4.setPos(17.4382F, -0.7522F, -3.2512F);
		wing.addChild(wingp_r4);
		setRotationAngle(wingp_r4, 0.1074F, 0.2865F, 0.3646F);
		wingp_r4.texOffs(114, 77).addBox(-0.4191F, -2.979F, -0.1548F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r5 = new ModelRenderer(this);
		wingp_r5.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r5);
		setRotationAngle(wingp_r5, 0.1074F, 0.2865F, 0.3646F);
		wingp_r5.texOffs(111, 81).addBox(7.0809F, -4.479F, -0.6548F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r6 = new ModelRenderer(this);
		wingp_r6.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r6);
		setRotationAngle(wingp_r6, -0.0411F, 0.3027F, -0.1372F);
		wingp_r6.texOffs(69, 60).addBox(4.4473F, -1.105F, -0.6548F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r7 = new ModelRenderer(this);
		wingp_r7.setPos(14.6643F, 3.5971F, -2.9009F);
		wing.addChild(wingp_r7);
		setRotationAngle(wingp_r7, 0.1896F, 0.2409F, 0.6775F);
		wingp_r7.texOffs(50, 78).addBox(-4.3186F, -3.3654F, 0.3452F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r8 = new ModelRenderer(this);
		wingp_r8.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r8);
		setRotationAngle(wingp_r8, 0.1325F, 0.276F, 0.4548F);
		wingp_r8.texOffs(44, 66).addBox(1.821F, -1.7721F, -0.6548F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r9 = new ModelRenderer(this);
		wingp_r9.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r9);
		setRotationAngle(wingp_r9, 0.1564F, 0.2635F, 0.5444F);
		wingp_r9.texOffs(46, 72).addBox(6.5624F, -0.4478F, -0.6548F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r9.texOffs(49, 77).addBox(1.5624F, -0.4478F, -0.6548F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r10 = new ModelRenderer(this);
		wingp_r10.setPos(3.7336F, 4.9445F, 1.0698F);
		wing.addChild(wingp_r10);
		setRotationAngle(wingp_r10, 0.2835F, -0.1153F, 1.947F);
		wingp_r10.texOffs(48, 77).addBox(-3.4797F, 1.9491F, -1.1548F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r11 = new ModelRenderer(this);
		wingp_r11.setPos(3.7336F, 4.9445F, 1.0698F);
		wing.addChild(wingp_r11);
		setRotationAngle(wingp_r11, 0.3011F, -0.0522F, 1.7374F);
		wingp_r11.texOffs(46, 73).addBox(-4.4197F, -0.097F, -0.1548F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r12 = new ModelRenderer(this);
		wingp_r12.setPos(8.9342F, 4.2266F, -0.5699F);
		wing.addChild(wingp_r12);
		setRotationAngle(wingp_r12, 0.303F, 0.0393F, 1.4459F);
		wingp_r12.texOffs(47, 76).addBox(-1.105F, 2.5527F, -0.1548F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r12.texOffs(49, 74).addBox(-4.105F, 1.5527F, -0.1548F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r13 = new ModelRenderer(this);
		wingp_r13.setPos(7.0368F, -1.0545F, 0.5526F);
		wing.addChild(wingp_r13);
		setRotationAngle(wingp_r13, -0.1074F, 0.2865F, -0.3646F);
		wingp_r13.texOffs(79, 59).addBox(-1.0232F, 0.27F, -0.6548F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r14 = new ModelRenderer(this);
		wingp_r14.setPos(8.3321F, -0.3519F, 0.1442F);
		wing.addChild(wingp_r14);
		setRotationAngle(wingp_r14, 0.0F, 0.3054F, 0.0F);
		wingp_r14.texOffs(45, 76).addBox(4.0949F, -5.2716F, -0.6548F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r14.texOffs(46, 78).addBox(-1.9051F, -5.2716F, -0.6548F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wing3 = new ModelRenderer(this);
		wing3.setPos(11.0F, -17.0F, 6.0F);
		Body.addChild(wing3);
		setRotationAngle(wing3, 0.0F, 0.0436F, -0.8727F);
		wing3.texOffs(0, 108).addBox(-3.4686F, -6.4905F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);

		wingp_r15 = new ModelRenderer(this);
		wingp_r15.setPos(14.6666F, -1.9003F, -4.2512F);
		wing3.addChild(wingp_r15);
		setRotationAngle(wingp_r15, -0.0547F, 0.3006F, -0.1828F);
		wingp_r15.texOffs(46, 65).addBox(4.3708F, -4.5991F, -0.0395F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		wingp_r15.texOffs(46, 65).addBox(1.3708F, -4.5991F, -0.0395F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r16 = new ModelRenderer(this);
		wingp_r16.setPos(14.6666F, -1.9003F, -4.2512F);
		wing3.addChild(wingp_r16);
		setRotationAngle(wingp_r16, 0.0547F, 0.3006F, 0.1828F);
		wingp_r16.texOffs(46, 65).addBox(0.5059F, -4.1064F, -0.0395F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r17 = new ModelRenderer(this);
		wingp_r17.setPos(14.6666F, -1.9003F, -4.2512F);
		wing3.addChild(wingp_r17);
		setRotationAngle(wingp_r17, 0.1074F, 0.2865F, 0.3646F);
		wingp_r17.texOffs(114, 77).addBox(0.0206F, -2.8399F, -0.0395F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r18 = new ModelRenderer(this);
		wingp_r18.setPos(4.2651F, -2.2026F, -0.4474F);
		wing3.addChild(wingp_r18);
		setRotationAngle(wingp_r18, 0.1074F, 0.2865F, 0.3646F);
		wingp_r18.texOffs(111, 81).addBox(7.5206F, -4.3399F, -0.5395F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r19 = new ModelRenderer(this);
		wingp_r19.setPos(4.2651F, -2.2026F, -0.4474F);
		wing3.addChild(wingp_r19);
		setRotationAngle(wingp_r19, -0.0411F, 0.3027F, -0.1372F);
		wingp_r19.texOffs(69, 60).addBox(4.7731F, -0.7786F, -0.5395F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r20 = new ModelRenderer(this);
		wingp_r20.setPos(11.8927F, 2.449F, -3.9009F);
		wing3.addChild(wingp_r20);
		setRotationAngle(wingp_r20, 0.1896F, 0.2409F, 0.6775F);
		wingp_r20.texOffs(50, 78).addBox(-3.8574F, -3.365F, 0.4605F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r21 = new ModelRenderer(this);
		wingp_r21.setPos(4.2651F, -2.2026F, -0.4474F);
		wing3.addChild(wingp_r21);
		setRotationAngle(wingp_r21, 0.1325F, 0.276F, 0.4548F);
		wingp_r21.texOffs(44, 66).addBox(2.2711F, -1.6719F, -0.5395F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r22 = new ModelRenderer(this);
		wingp_r22.setPos(4.2651F, -2.2026F, -0.4474F);
		wing3.addChild(wingp_r22);
		setRotationAngle(wingp_r22, 0.1564F, 0.2635F, 0.5444F);
		wingp_r22.texOffs(46, 72).addBox(7.0196F, -0.3871F, -0.5395F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r22.texOffs(49, 77).addBox(2.0196F, -0.3871F, -0.5395F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r23 = new ModelRenderer(this);
		wingp_r23.setPos(4.2651F, -2.2026F, -0.4474F);
		wing3.addChild(wingp_r23);
		setRotationAngle(wingp_r23, -0.1074F, 0.2865F, -0.3646F);
		wingp_r23.texOffs(79, 59).addBox(-0.7757F, 0.6592F, -0.5395F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r24 = new ModelRenderer(this);
		wingp_r24.setPos(5.5604F, -1.5F, -0.8558F);
		wing3.addChild(wingp_r24);
		setRotationAngle(wingp_r24, 0.0F, 0.3054F, 0.0F);
		wingp_r24.texOffs(45, 76).addBox(4.4605F, -4.9905F, -0.5395F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r24.texOffs(46, 78).addBox(-1.5395F, -4.9905F, -0.5395F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wing5 = new ModelRenderer(this);
		wing5.setPos(11.0F, -14.0F, 7.0F);
		Body.addChild(wing5);
		setRotationAngle(wing5, -0.0193F, -0.2173F, -0.3906F);
		wing5.texOffs(0, 108).addBox(-1.8629F, -6.7707F, -1.0999F, 6.0F, 6.0F, 2.0F, 0.0F, false);

		wingp_r25 = new ModelRenderer(this);
		wingp_r25.setPos(14.6666F, -1.9003F, -4.2512F);
		wing5.addChild(wingp_r25);
		setRotationAngle(wingp_r25, -0.0547F, 0.3006F, -0.1828F);
		wingp_r25.texOffs(46, 65).addBox(4.0788F, -4.9351F, -0.2534F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		wingp_r25.texOffs(46, 65).addBox(1.0788F, -4.9351F, -0.2534F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r26 = new ModelRenderer(this);
		wingp_r26.setPos(14.6666F, -1.9003F, -4.2512F);
		wing5.addChild(wingp_r26);
		setRotationAngle(wingp_r26, 0.0547F, 0.3006F, 0.1828F);
		wingp_r26.texOffs(46, 65).addBox(0.1165F, -4.3222F, -0.2534F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r27 = new ModelRenderer(this);
		wingp_r27.setPos(14.6666F, -1.9003F, -4.2512F);
		wing5.addChild(wingp_r27);
		setRotationAngle(wingp_r27, 0.1074F, 0.2865F, 0.3646F);
		wingp_r27.texOffs(114, 77).addBox(-0.4003F, -2.9848F, -0.2534F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r28 = new ModelRenderer(this);
		wingp_r28.setPos(4.2651F, -2.2026F, -0.4474F);
		wing5.addChild(wingp_r28);
		setRotationAngle(wingp_r28, 0.1074F, 0.2865F, 0.3646F);
		wingp_r28.texOffs(111, 81).addBox(7.0997F, -4.4848F, -0.7534F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r29 = new ModelRenderer(this);
		wingp_r29.setPos(4.2651F, -2.2026F, -0.4474F);
		wing5.addChild(wingp_r29);
		setRotationAngle(wingp_r29, -0.0411F, 0.3027F, -0.1372F);
		wingp_r29.texOffs(69, 60).addBox(4.4667F, -1.1015F, -0.7534F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r30 = new ModelRenderer(this);
		wingp_r30.setPos(11.8927F, 2.449F, -3.9009F);
		wing5.addChild(wingp_r30);
		setRotationAngle(wingp_r30, 0.1896F, 0.2409F, 0.6775F);
		wingp_r30.texOffs(50, 78).addBox(-4.3024F, -3.3766F, 0.2466F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r31 = new ModelRenderer(this);
		wingp_r31.setPos(4.2651F, -2.2026F, -0.4474F);
		wing5.addChild(wingp_r31);
		setRotationAngle(wingp_r31, 0.1564F, 0.2635F, 0.5444F);
		wingp_r31.texOffs(46, 72).addBox(6.5799F, -1.4568F, -0.7534F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r31.texOffs(49, 77).addBox(1.5799F, -1.4568F, -0.7534F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r32 = new ModelRenderer(this);
		wingp_r32.setPos(4.2651F, -2.2026F, -0.4474F);
		wing5.addChild(wingp_r32);
		setRotationAngle(wingp_r32, -0.1074F, 0.2865F, -0.3646F);
		wingp_r32.texOffs(79, 59).addBox(-1.005F, 0.2776F, -0.7534F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r33 = new ModelRenderer(this);
		wingp_r33.setPos(5.5604F, -1.5F, -0.8558F);
		wing5.addChild(wingp_r33);
		setRotationAngle(wingp_r33, 0.0F, 0.3054F, 0.0F);
		wingp_r33.texOffs(45, 76).addBox(4.1146F, -5.2707F, -0.7534F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r33.texOffs(46, 78).addBox(-1.8854F, -5.2707F, -0.7534F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wing6 = new ModelRenderer(this);
		wing6.setPos(-9.0F, -15.0F, 7.0F);
		Body.addChild(wing6);
		setRotationAngle(wing6, -0.0193F, 0.2173F, 0.3906F);
		wing6.texOffs(0, 108).addBox(-4.1371F, -6.7707F, -1.0999F, 6.0F, 6.0F, 2.0F, 0.0F, true);

		wingp_r34 = new ModelRenderer(this);
		wingp_r34.setPos(-14.6666F, -1.9003F, -4.2512F);
		wing6.addChild(wingp_r34);
		setRotationAngle(wingp_r34, -0.0547F, -0.3006F, 0.1828F);
		wingp_r34.texOffs(49, 61).addBox(-7.0788F, -4.9351F, -0.2534F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r34.texOffs(46, 65).addBox(-4.0788F, -4.9351F, -0.2534F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r35 = new ModelRenderer(this);
		wingp_r35.setPos(-14.6666F, -1.9003F, -4.2512F);
		wing6.addChild(wingp_r35);
		setRotationAngle(wingp_r35, 0.0547F, -0.3006F, -0.1828F);
		wingp_r35.texOffs(47, 71).addBox(-7.1165F, -4.3222F, -0.2534F, 7.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r36 = new ModelRenderer(this);
		wingp_r36.setPos(-14.6666F, -1.9003F, -4.2512F);
		wing6.addChild(wingp_r36);
		setRotationAngle(wingp_r36, 0.1074F, -0.2865F, -0.3646F);
		wingp_r36.texOffs(114, 77).addBox(-5.5997F, -2.9848F, -0.2534F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r37 = new ModelRenderer(this);
		wingp_r37.setPos(-4.2651F, -2.2026F, -0.4474F);
		wing6.addChild(wingp_r37);
		setRotationAngle(wingp_r37, 0.1074F, -0.2865F, -0.3646F);
		wingp_r37.texOffs(111, 81).addBox(-14.0997F, -4.4848F, -0.7534F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r38 = new ModelRenderer(this);
		wingp_r38.setPos(-4.2651F, -2.2026F, -0.4474F);
		wing6.addChild(wingp_r38);
		setRotationAngle(wingp_r38, -0.0411F, -0.3027F, 0.1372F);
		wingp_r38.texOffs(69, 60).addBox(-11.4667F, -1.1015F, -0.7534F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r39 = new ModelRenderer(this);
		wingp_r39.setPos(-11.8927F, 2.449F, -3.9009F);
		wing6.addChild(wingp_r39);
		setRotationAngle(wingp_r39, 0.1896F, -0.2409F, -0.6775F);
		wingp_r39.texOffs(50, 78).addBox(-0.6976F, -3.3766F, 0.2466F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r40 = new ModelRenderer(this);
		wingp_r40.setPos(-4.2651F, -2.2026F, -0.4474F);
		wing6.addChild(wingp_r40);
		setRotationAngle(wingp_r40, 0.1564F, -0.2635F, -0.5444F);
		wingp_r40.texOffs(46, 72).addBox(-9.5799F, -1.4568F, -0.7534F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r40.texOffs(49, 77).addBox(-6.5799F, -1.4568F, -0.7534F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r41 = new ModelRenderer(this);
		wingp_r41.setPos(-4.2651F, -2.2026F, -0.4474F);
		wing6.addChild(wingp_r41);
		setRotationAngle(wingp_r41, -0.1074F, -0.2865F, 0.3646F);
		wingp_r41.texOffs(79, 59).addBox(-4.995F, 0.2776F, -0.7534F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r42 = new ModelRenderer(this);
		wingp_r42.setPos(-5.5604F, -1.5F, -0.8558F);
		wing6.addChild(wingp_r42);
		setRotationAngle(wingp_r42, 0.0F, -0.3054F, 0.0F);
		wingp_r42.texOffs(45, 76).addBox(-11.1146F, -5.2707F, -0.7534F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r42.texOffs(46, 78).addBox(-4.1146F, -5.2707F, -0.7534F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wing4 = new ModelRenderer(this);
		wing4.setPos(-6.0F, -17.0F, 6.0F);
		Body.addChild(wing4);
		setRotationAngle(wing4, 0.0F, 0.0F, 0.8727F);
		wing4.texOffs(0, 108).addBox(-7.7453F, -2.6603F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);

		wingp_r43 = new ModelRenderer(this);
		wingp_r43.setPos(-19.3923F, -2.3029F, -4.7279F);
		wing4.addChild(wingp_r43);
		setRotationAngle(wingp_r43, -0.1564F, -0.2635F, 0.5444F);
		wingp_r43.texOffs(46, 65).addBox(-7.0101F, 1.0734F, -0.0395F, 2.0F, 0.0F, 1.0F, 0.0F, true);

		wingp_r44 = new ModelRenderer(this);
		wingp_r44.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r44);
		setRotationAngle(wingp_r44, -0.0547F, -0.3006F, 0.1828F);
		wingp_r44.texOffs(46, 65).addBox(-7.3708F, -4.5991F, -0.0395F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r45 = new ModelRenderer(this);
		wingp_r45.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r45);
		setRotationAngle(wingp_r45, 0.0547F, -0.3006F, -0.1828F);
		wingp_r45.texOffs(46, 65).addBox(-6.5059F, -4.1064F, -0.0395F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r46 = new ModelRenderer(this);
		wingp_r46.setPos(-17.8805F, 1.93F, -4.2512F);
		wing4.addChild(wingp_r46);
		setRotationAngle(wingp_r46, 0.1074F, -0.2865F, -0.3646F);
		wingp_r46.texOffs(114, 77).addBox(-6.0206F, -2.8399F, -0.0395F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r47 = new ModelRenderer(this);
		wingp_r47.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r47);
		setRotationAngle(wingp_r47, 0.1074F, -0.2865F, -0.3646F);
		wingp_r47.texOffs(111, 81).addBox(-14.5206F, -4.3399F, -0.5395F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r48 = new ModelRenderer(this);
		wingp_r48.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r48);
		setRotationAngle(wingp_r48, -0.0411F, -0.3027F, 0.1372F);
		wingp_r48.texOffs(69, 60).addBox(-11.7731F, -0.7786F, -0.5395F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r49 = new ModelRenderer(this);
		wingp_r49.setPos(-15.1066F, 6.2793F, -3.9009F);
		wing4.addChild(wingp_r49);
		setRotationAngle(wingp_r49, 0.1896F, -0.2409F, -0.6775F);
		wingp_r49.texOffs(50, 78).addBox(-1.1426F, -3.365F, 0.4605F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r50 = new ModelRenderer(this);
		wingp_r50.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r50);
		setRotationAngle(wingp_r50, 0.1325F, -0.276F, -0.4548F);
		wingp_r50.texOffs(44, 66).addBox(-7.2711F, -1.6719F, -0.5395F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r51 = new ModelRenderer(this);
		wingp_r51.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r51);
		setRotationAngle(wingp_r51, 0.1564F, -0.2635F, -0.5444F);
		wingp_r51.texOffs(46, 72).addBox(-10.0196F, -0.3871F, -0.5395F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r51.texOffs(49, 77).addBox(-7.0196F, -0.3871F, -0.5395F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r52 = new ModelRenderer(this);
		wingp_r52.setPos(-7.4791F, 1.6277F, -0.4474F);
		wing4.addChild(wingp_r52);
		setRotationAngle(wingp_r52, -0.1074F, -0.2865F, 0.3646F);
		wingp_r52.texOffs(79, 59).addBox(-5.2243F, 0.6592F, -0.5395F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r53 = new ModelRenderer(this);
		wingp_r53.setPos(-8.7744F, 2.3302F, -0.8558F);
		wing4.addChild(wingp_r53);
		setRotationAngle(wingp_r53, 0.0F, -0.3054F, 0.0F);
		wingp_r53.texOffs(45, 76).addBox(-11.4605F, -4.9905F, -0.5395F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r53.texOffs(46, 78).addBox(-4.4605F, -4.9905F, -0.5395F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wing2 = new ModelRenderer(this);
		wing2.setPos(-7.0F, -12.0F, 6.0F);
		Body.addChild(wing2);
		setRotationAngle(wing2, 0.0F, 0.0F, 0.3927F);
		wing2.texOffs(47, 83).addBox(-7.4609F, -4.317F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);

		wingp_r54 = new ModelRenderer(this);
		wingp_r54.setPos(-21.0961F, -2.4416F, -5.2339F);
		wing2.addChild(wingp_r54);
		setRotationAngle(wingp_r54, -0.1564F, -0.2635F, 0.5444F);
		wingp_r54.texOffs(46, 65).addBox(-3.834F, -2.3529F, -0.1548F, 2.0F, 0.0F, 1.0F, 0.0F, true);
		wingp_r54.texOffs(46, 65).addBox(-1.834F, -2.3529F, -0.1548F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r55 = new ModelRenderer(this);
		wingp_r55.setPos(-17.9794F, 0.5543F, -4.2512F);
		wing2.addChild(wingp_r55);
		setRotationAngle(wingp_r55, -0.0547F, -0.3006F, 0.1828F);
		wingp_r55.texOffs(46, 65).addBox(-4.0596F, -4.9394F, -0.1548F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r56 = new ModelRenderer(this);
		wingp_r56.setPos(-17.9794F, 0.5543F, -4.2512F);
		wing2.addChild(wingp_r56);
		setRotationAngle(wingp_r56, 0.0547F, -0.3006F, -0.1828F);
		wingp_r56.texOffs(46, 66).addBox(-6.097F, -4.3197F, -0.1548F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r57 = new ModelRenderer(this);
		wingp_r57.setPos(-17.9794F, 0.5543F, -4.2512F);
		wing2.addChild(wingp_r57);
		setRotationAngle(wingp_r57, 0.1074F, -0.2865F, -0.3646F);
		wingp_r57.texOffs(114, 77).addBox(-5.5809F, -2.979F, -0.1548F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r58 = new ModelRenderer(this);
		wingp_r58.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r58);
		setRotationAngle(wingp_r58, 0.1074F, -0.2865F, -0.3646F);
		wingp_r58.texOffs(111, 81).addBox(-14.0809F, -4.479F, -0.6548F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r59 = new ModelRenderer(this);
		wingp_r59.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r59);
		setRotationAngle(wingp_r59, -0.0411F, -0.3027F, 0.1372F);
		wingp_r59.texOffs(69, 60).addBox(-11.4473F, -1.105F, -0.6548F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r60 = new ModelRenderer(this);
		wingp_r60.setPos(-15.2055F, 4.9037F, -3.9009F);
		wing2.addChild(wingp_r60);
		setRotationAngle(wingp_r60, 0.1896F, -0.2409F, -0.6775F);
		wingp_r60.texOffs(50, 78).addBox(-0.6814F, -3.3654F, 0.3452F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r61 = new ModelRenderer(this);
		wingp_r61.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r61);
		setRotationAngle(wingp_r61, 0.1325F, -0.276F, -0.4548F);
		wingp_r61.texOffs(44, 66).addBox(-6.821F, -1.7721F, -0.6548F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r62 = new ModelRenderer(this);
		wingp_r62.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r62);
		setRotationAngle(wingp_r62, 0.1564F, -0.2635F, -0.5444F);
		wingp_r62.texOffs(46, 72).addBox(-9.5624F, -0.4478F, -0.6548F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r62.texOffs(49, 77).addBox(-6.5624F, -0.4478F, -0.6548F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r63 = new ModelRenderer(this);
		wingp_r63.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r63);
		setRotationAngle(wingp_r63, 0.2835F, 0.1153F, -1.947F);
		wingp_r63.texOffs(48, 77).addBox(0.4797F, 1.9491F, -1.1548F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r64 = new ModelRenderer(this);
		wingp_r64.setPos(-4.2748F, 6.251F, 0.0698F);
		wing2.addChild(wingp_r64);
		setRotationAngle(wingp_r64, 0.3011F, 0.0522F, -1.7374F);
		wingp_r64.texOffs(46, 73).addBox(1.4197F, -0.097F, -0.1548F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r65 = new ModelRenderer(this);
		wingp_r65.setPos(-9.4754F, 5.5331F, -1.5699F);
		wing2.addChild(wingp_r65);
		setRotationAngle(wingp_r65, 0.303F, -0.0393F, -1.4459F);
		wingp_r65.texOffs(47, 76).addBox(-0.895F, 2.5527F, -0.1548F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r65.texOffs(49, 74).addBox(1.105F, 1.5527F, -0.1548F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r66 = new ModelRenderer(this);
		wingp_r66.setPos(-7.578F, 0.2521F, -0.4474F);
		wing2.addChild(wingp_r66);
		setRotationAngle(wingp_r66, -0.1074F, -0.2865F, 0.3646F);
		wingp_r66.texOffs(79, 59).addBox(-4.9768F, 0.27F, -0.6548F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r67 = new ModelRenderer(this);
		wingp_r67.setPos(-8.8733F, 0.9546F, -0.8558F);
		wing2.addChild(wingp_r67);
		setRotationAngle(wingp_r67, 0.0F, -0.3054F, 0.0F);
		wingp_r67.texOffs(45, 76).addBox(-11.0949F, -5.2716F, -0.6548F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r67.texOffs(46, 78).addBox(-4.0949F, -5.2716F, -0.6548F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingDown = new ModelRenderer(this);
		wingDown.setPos(-11.0F, -4.0F, 6.0F);
		Body.addChild(wingDown);
		setRotationAngle(wingDown, 0.0F, 0.0F, -0.6109F);
		wingDown.texOffs(79, 47).addBox(-1.2793F, -6.4575F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, true);

		wingp_r68 = new ModelRenderer(this);
		wingp_r68.setPos(-14.6666F, -1.9003F, -4.2512F);
		wingDown.addChild(wingp_r68);
		setRotationAngle(wingp_r68, 0.0547F, -0.3006F, -0.1828F);
		wingp_r68.texOffs(52, 62).addBox(-3.4571F, -3.5352F, -1.0174F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r69 = new ModelRenderer(this);
		wingp_r69.setPos(-14.6666F, -1.9003F, -4.2512F);
		wingDown.addChild(wingp_r69);
		setRotationAngle(wingp_r69, 0.1074F, -0.2865F, -0.3646F);
		wingp_r69.texOffs(114, 77).addBox(-3.1174F, -1.748F, -1.0174F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r70 = new ModelRenderer(this);
		wingp_r70.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown.addChild(wingp_r70);
		setRotationAngle(wingp_r70, 0.1564F, -0.2635F, -0.5444F);
		wingp_r70.texOffs(111, 81).addBox(-15.35F, -5.5077F, -1.5174F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r70.texOffs(111, 81).addBox(-11.35F, -5.5077F, -1.5174F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r71 = new ModelRenderer(this);
		wingp_r71.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown.addChild(wingp_r71);
		setRotationAngle(wingp_r71, -0.0411F, -0.3027F, 0.1372F);
		wingp_r71.texOffs(69, 60).addBox(-8.6937F, -1.1506F, -1.5174F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r72 = new ModelRenderer(this);
		wingp_r72.setPos(-11.8927F, 2.449F, -3.9009F);
		wingDown.addChild(wingp_r72);
		setRotationAngle(wingp_r72, 0.1564F, -0.2635F, -0.5444F);
		wingp_r72.texOffs(50, 78).addBox(0.15F, -2.9077F, -0.5174F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r73 = new ModelRenderer(this);
		wingp_r73.setPos(-11.8927F, 2.449F, -3.9009F);
		wingDown.addChild(wingp_r73);
		setRotationAngle(wingp_r73, 0.1896F, -0.2409F, -0.6775F);
		wingp_r73.texOffs(50, 78).addBox(1.298F, -1.4506F, -0.5174F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r74 = new ModelRenderer(this);
		wingp_r74.setPos(-4.1588F, 3.123F, -0.9382F);
		wingDown.addChild(wingp_r74);
		setRotationAngle(wingp_r74, 0.2599F, -0.1623F, -1.0248F);
		wingp_r74.texOffs(44, 66).addBox(1.4544F, -0.4363F, -1.0174F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r75 = new ModelRenderer(this);
		wingp_r75.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown.addChild(wingp_r75);
		setRotationAngle(wingp_r75, 0.1564F, -0.2635F, -0.5444F);
		wingp_r75.texOffs(46, 72).addBox(-7.35F, 0.1923F, -1.5174F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r75.texOffs(49, 77).addBox(-4.35F, 0.1923F, -1.5174F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r76 = new ModelRenderer(this);
		wingp_r76.setPos(-0.962F, 3.7964F, 0.0698F);
		wingDown.addChild(wingp_r76);
		setRotationAngle(wingp_r76, 0.2835F, 0.1153F, -1.947F);
		wingp_r76.texOffs(48, 77).addBox(-0.8576F, 4.3566F, -2.0174F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r77 = new ModelRenderer(this);
		wingp_r77.setPos(-0.962F, 3.7964F, 0.0698F);
		wingDown.addChild(wingp_r77);
		setRotationAngle(wingp_r77, 0.3011F, 0.0522F, -1.7374F);
		wingp_r77.texOffs(46, 73).addBox(0.6351F, 2.5429F, -1.0174F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r78 = new ModelRenderer(this);
		wingp_r78.setPos(-6.1625F, 3.0785F, -1.5699F);
		wingDown.addChild(wingp_r78);
		setRotationAngle(wingp_r78, 0.303F, -0.0393F, -1.4459F);
		wingp_r78.texOffs(47, 76).addBox(-0.8494F, 5.3063F, -1.0174F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r78.texOffs(49, 74).addBox(1.1506F, 4.3063F, -1.0174F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r79 = new ModelRenderer(this);
		wingp_r79.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown.addChild(wingp_r79);
		setRotationAngle(wingp_r79, -0.1074F, -0.2865F, 0.3646F);
		wingp_r79.texOffs(79, 59).addBox(-2.2984F, -0.3705F, -1.5174F, 6.0F, 2.0F, 2.0F, 0.0F, true);

		wingp_r80 = new ModelRenderer(this);
		wingp_r80.setPos(-5.5604F, -1.5F, -0.8558F);
		wingDown.addChild(wingp_r80);
		setRotationAngle(wingp_r80, 0.0F, -0.3054F, 0.0F);
		wingp_r80.texOffs(91, 52).addBox(-8.3589F, -4.9575F, -1.5174F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r80.texOffs(85, 93).addBox(-1.3589F, -4.9575F, -1.5174F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingDown3 = new ModelRenderer(this);
		wingDown3.setPos(-3.0F, -3.0F, 6.0F);
		Body.addChild(wingDown3);
		setRotationAngle(wingDown3, -0.0814F, 0.2947F, -0.9284F);
		

		wingp_r81 = new ModelRenderer(this);
		wingp_r81.setPos(-14.6666F, -1.9003F, -4.2512F);
		wingDown3.addChild(wingp_r81);
		setRotationAngle(wingp_r81, 0.0547F, -0.3006F, -0.1828F);
		wingp_r81.texOffs(52, 62).addBox(-2.8577F, -2.8108F, -0.6674F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r82 = new ModelRenderer(this);
		wingp_r82.setPos(-14.6666F, -1.9003F, -4.2512F);
		wingDown3.addChild(wingp_r82);
		setRotationAngle(wingp_r82, 0.1074F, -0.2865F, -0.3646F);
		wingp_r82.texOffs(114, 77).addBox(-2.6529F, -0.9305F, -0.6674F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r83 = new ModelRenderer(this);
		wingp_r83.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown3.addChild(wingp_r83);
		setRotationAngle(wingp_r83, 0.1564F, -0.2635F, -0.5444F);
		wingp_r83.texOffs(107, 77).addBox(-15.0345F, -4.622F, -1.1674F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r83.texOffs(90, 72).addBox(-11.0345F, -4.622F, -1.1674F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r84 = new ModelRenderer(this);
		wingp_r84.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown3.addChild(wingp_r84);
		setRotationAngle(wingp_r84, -0.0411F, -0.3027F, 0.1372F);
		wingp_r84.texOffs(69, 60).addBox(-7.9042F, -0.64F, -1.1674F, 7.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r85 = new ModelRenderer(this);
		wingp_r85.setPos(-11.8927F, 2.449F, -3.9009F);
		wingDown3.addChild(wingp_r85);
		setRotationAngle(wingp_r85, 0.1564F, -0.2635F, -0.5444F);
		wingp_r85.texOffs(50, 78).addBox(0.4655F, -2.022F, -0.1674F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r86 = new ModelRenderer(this);
		wingp_r86.setPos(-11.8927F, 2.449F, -3.9009F);
		wingDown3.addChild(wingp_r86);
		setRotationAngle(wingp_r86, 0.1896F, -0.2409F, -0.6775F);
		wingp_r86.texOffs(50, 78).addBox(1.4952F, -0.5313F, -0.1674F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r87 = new ModelRenderer(this);
		wingp_r87.setPos(-4.2651F, -2.2026F, -0.4474F);
		wingDown3.addChild(wingp_r87);
		setRotationAngle(wingp_r87, 0.1564F, -0.2635F, -0.5444F);
		wingp_r87.texOffs(46, 72).addBox(-7.0345F, 1.078F, -1.1674F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		wingp_r87.texOffs(49, 77).addBox(-4.0345F, 1.078F, -1.1674F, 5.0F, 2.0F, 1.0F, 0.0F, true);

		wingp_r88 = new ModelRenderer(this);
		wingp_r88.setPos(-0.962F, 3.7964F, 0.0698F);
		wingDown3.addChild(wingp_r88);
		setRotationAngle(wingp_r88, 0.2835F, 0.1153F, -1.947F);
		wingp_r88.texOffs(48, 77).addBox(-1.6946F, 4.785F, -1.6674F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		wingp_r89 = new ModelRenderer(this);
		wingp_r89.setPos(-5.5604F, -1.5F, -0.8558F);
		wingDown3.addChild(wingp_r89);
		setRotationAngle(wingp_r89, 0.0F, -0.3054F, 0.0F);
		wingp_r89.texOffs(91, 52).addBox(-7.6428F, -4.3482F, -1.1674F, 7.0F, 3.0F, 1.0F, 0.0F, true);
		wingp_r89.texOffs(85, 93).addBox(-0.6428F, -4.3482F, -1.1674F, 6.0F, 5.0F, 2.0F, 0.0F, true);

		wingDown4 = new ModelRenderer(this);
		wingDown4.setPos(4.0F, -3.0F, 6.0F);
		Body.addChild(wingDown4);
		setRotationAngle(wingDown4, -0.0814F, -0.2947F, 0.9284F);
		

		wingp_r90 = new ModelRenderer(this);
		wingp_r90.setPos(13.52F, -0.3326F, -3.7741F);
		wingDown4.addChild(wingp_r90);
		setRotationAngle(wingp_r90, 0.0547F, 0.3006F, 0.1828F);
		wingp_r90.texOffs(52, 62).addBox(-3.1423F, -2.8108F, -0.6674F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r91 = new ModelRenderer(this);
		wingp_r91.setPos(13.52F, -0.3326F, -3.7741F);
		wingDown4.addChild(wingp_r91);
		setRotationAngle(wingp_r91, 0.1074F, 0.2865F, 0.3646F);
		wingp_r91.texOffs(114, 77).addBox(-3.3471F, -0.9305F, -0.6674F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r92 = new ModelRenderer(this);
		wingp_r92.setPos(3.1185F, -0.6349F, 0.0297F);
		wingDown4.addChild(wingp_r92);
		setRotationAngle(wingp_r92, 0.1564F, 0.2635F, 0.5444F);
		wingp_r92.texOffs(107, 77).addBox(11.0345F, -4.622F, -1.1674F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r92.texOffs(90, 72).addBox(4.0345F, -4.622F, -1.1674F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r93 = new ModelRenderer(this);
		wingp_r93.setPos(3.1185F, -0.6349F, 0.0297F);
		wingDown4.addChild(wingp_r93);
		setRotationAngle(wingp_r93, -0.0411F, 0.3027F, -0.1372F);
		wingp_r93.texOffs(69, 60).addBox(0.9042F, -0.64F, -1.1674F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r94 = new ModelRenderer(this);
		wingp_r94.setPos(10.7461F, 4.0167F, -3.4238F);
		wingDown4.addChild(wingp_r94);
		setRotationAngle(wingp_r94, 0.1564F, 0.2635F, 0.5444F);
		wingp_r94.texOffs(50, 78).addBox(-5.4655F, -2.022F, -0.1674F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r95 = new ModelRenderer(this);
		wingp_r95.setPos(10.7461F, 4.0167F, -3.4238F);
		wingDown4.addChild(wingp_r95);
		setRotationAngle(wingp_r95, 0.1896F, 0.2409F, 0.6775F);
		wingp_r95.texOffs(50, 78).addBox(-6.4952F, -0.5313F, -0.1674F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r96 = new ModelRenderer(this);
		wingp_r96.setPos(3.1185F, -0.6349F, 0.0297F);
		wingDown4.addChild(wingp_r96);
		setRotationAngle(wingp_r96, 0.1564F, 0.2635F, 0.5444F);
		wingp_r96.texOffs(49, 77).addBox(-0.9655F, 1.078F, -1.1674F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r97 = new ModelRenderer(this);
		wingp_r97.setPos(4.4139F, 0.0677F, -0.3787F);
		wingDown4.addChild(wingp_r97);
		setRotationAngle(wingp_r97, 0.0F, 0.3054F, 0.0F);
		wingp_r97.texOffs(91, 52).addBox(0.6428F, -4.3482F, -1.1674F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r97.texOffs(85, 93).addBox(-5.3572F, -4.3482F, -1.1674F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		wingDown2 = new ModelRenderer(this);
		wingDown2.setPos(11.0F, -4.0F, 6.0F);
		Body.addChild(wingDown2);
		setRotationAngle(wingDown2, 0.0F, 0.0F, 0.6109F);
		wingDown2.texOffs(79, 47).addBox(-6.7207F, -6.4575F, -1.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);

		wingp_r98 = new ModelRenderer(this);
		wingp_r98.setPos(14.6666F, -1.9003F, -4.2512F);
		wingDown2.addChild(wingp_r98);
		setRotationAngle(wingp_r98, 0.0547F, 0.3006F, 0.1828F);
		wingp_r98.texOffs(52, 62).addBox(-2.5429F, -3.5352F, -1.0174F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r99 = new ModelRenderer(this);
		wingp_r99.setPos(14.6666F, -1.9003F, -4.2512F);
		wingDown2.addChild(wingp_r99);
		setRotationAngle(wingp_r99, 0.1074F, 0.2865F, 0.3646F);
		wingp_r99.texOffs(114, 77).addBox(-2.8826F, -1.748F, -1.0174F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r100 = new ModelRenderer(this);
		wingp_r100.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r100);
		setRotationAngle(wingp_r100, 0.1564F, 0.2635F, 0.5444F);
		wingp_r100.texOffs(111, 81).addBox(11.35F, -5.5077F, -1.5174F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r100.texOffs(111, 81).addBox(4.35F, -5.5077F, -1.5174F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r101 = new ModelRenderer(this);
		wingp_r101.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r101);
		setRotationAngle(wingp_r101, -0.0411F, 0.3027F, -0.1372F);
		wingp_r101.texOffs(69, 60).addBox(1.6937F, -1.1506F, -1.5174F, 7.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r102 = new ModelRenderer(this);
		wingp_r102.setPos(11.8927F, 2.449F, -3.9009F);
		wingDown2.addChild(wingp_r102);
		setRotationAngle(wingp_r102, 0.1564F, 0.2635F, 0.5444F);
		wingp_r102.texOffs(50, 78).addBox(-5.15F, -2.9077F, -0.5174F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r103 = new ModelRenderer(this);
		wingp_r103.setPos(11.8927F, 2.449F, -3.9009F);
		wingDown2.addChild(wingp_r103);
		setRotationAngle(wingp_r103, 0.1896F, 0.2409F, 0.6775F);
		wingp_r103.texOffs(50, 78).addBox(-6.298F, -1.4506F, -0.5174F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r104 = new ModelRenderer(this);
		wingp_r104.setPos(4.1588F, 3.123F, -0.9382F);
		wingDown2.addChild(wingp_r104);
		setRotationAngle(wingp_r104, 0.2599F, 0.1623F, 1.0248F);
		wingp_r104.texOffs(44, 66).addBox(-4.4544F, -0.4363F, -1.0174F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r105 = new ModelRenderer(this);
		wingp_r105.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r105);
		setRotationAngle(wingp_r105, 0.1564F, 0.2635F, 0.5444F);
		wingp_r105.texOffs(46, 72).addBox(4.35F, 0.1923F, -1.5174F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r105.texOffs(49, 77).addBox(-0.65F, 0.1923F, -1.5174F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r106 = new ModelRenderer(this);
		wingp_r106.setPos(0.962F, 3.7964F, 0.0698F);
		wingDown2.addChild(wingp_r106);
		setRotationAngle(wingp_r106, 0.2835F, -0.1153F, 1.947F);
		wingp_r106.texOffs(48, 77).addBox(-2.1424F, 4.3566F, -2.0174F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r107 = new ModelRenderer(this);
		wingp_r107.setPos(0.962F, 3.7964F, 0.0698F);
		wingDown2.addChild(wingp_r107);
		setRotationAngle(wingp_r107, 0.3011F, -0.0522F, 1.7374F);
		wingp_r107.texOffs(46, 73).addBox(-3.6351F, 2.5429F, -1.0174F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		wingp_r108 = new ModelRenderer(this);
		wingp_r108.setPos(6.1625F, 3.0785F, -1.5699F);
		wingDown2.addChild(wingp_r108);
		setRotationAngle(wingp_r108, 0.303F, 0.0393F, 1.4459F);
		wingp_r108.texOffs(47, 76).addBox(-1.1506F, 5.3063F, -1.0174F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		wingp_r108.texOffs(49, 74).addBox(-4.1506F, 4.3063F, -1.0174F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		wingp_r109 = new ModelRenderer(this);
		wingp_r109.setPos(4.2651F, -2.2026F, -0.4474F);
		wingDown2.addChild(wingp_r109);
		setRotationAngle(wingp_r109, -0.1074F, 0.2865F, -0.3646F);
		wingp_r109.texOffs(79, 59).addBox(-3.7016F, -0.3705F, -1.5174F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		wingp_r110 = new ModelRenderer(this);
		wingp_r110.setPos(5.5604F, -1.5F, -0.8558F);
		wingDown2.addChild(wingp_r110);
		setRotationAngle(wingp_r110, 0.0F, 0.3054F, 0.0F);
		wingp_r110.texOffs(89, 67).addBox(1.3589F, -4.9575F, -1.5174F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		wingp_r110.texOffs(87, 70).addBox(-4.6411F, -4.9575F, -1.5174F, 6.0F, 5.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-9.0F, -13.0F, -1.0F);
		setRotationAngle(RightArm, -0.2182F, 0.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(2.0F, -1.759F, -0.7541F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.0436F, -0.1745F, 1.4399F);
		RightArm_r1.texOffs(82, 2).addBox(-2.9725F, -2.3878F, -3.1184F, 4.0F, 6.0F, 6.0F, 0.0F, false);

		Rightbacktlib = new ModelRenderer(this);
		Rightbacktlib.setPos(0.0F, 2.0F, 0.0F);
		RightArm.addChild(Rightbacktlib);
		

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(3.0F, 0.644F, 3.0686F);
		Rightbacktlib.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 0.1745F, 0.0F, 0.0F);
		RightArm_r2.texOffs(0, 94).addBox(-5.0F, -6.9971F, -5.1309F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Rightfrontlib = new ModelRenderer(this);
		Rightfrontlib.setPos(0.0F, 0.0F, 0.0F);
		Rightbacktlib.addChild(Rightfrontlib);
		

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.3491F, 0.0F, 0.0873F);
		RightArm_r3.texOffs(121, 6).addBox(-2.2553F, 2.4803F, -0.6081F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightArm_r3.texOffs(121, 6).addBox(-2.2553F, 2.4803F, -1.6081F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.6545F, 0.0F, -0.1745F);
		RightArm_r4.texOffs(115, 5).addBox(1.0086F, -3.8931F, 0.229F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm_r4.texOffs(118, 7).addBox(1.0086F, -3.8931F, -0.771F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-1.0774F, 11.6115F, -4.6201F);
		Rightfrontlib.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, -0.3491F, 0.0F, -0.1745F);
		RightArm_r5.texOffs(120, 4).addBox(0.0086F, -3.4884F, 0.9033F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.0F, 6.8017F, -1.1584F);
		Rightfrontlib.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, -0.3491F, 0.0F, 0.0F);
		RightArm_r6.texOffs(0, 77).addBox(-2.0F, -7.5302F, -3.6119F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(8.4442F, -10.8343F, -0.4302F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(-0.5558F, -3.3343F, -0.4302F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.0436F, -0.2182F, -1.4399F);
		LeftArm_r1.texOffs(88, 85).addBox(-0.0246F, -3.3836F, -1.004F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		Leftlib = new ModelRenderer(this);
		Leftlib.setPos(0.5558F, 2.5308F, -0.3245F);
		LeftArm.addChild(Leftlib);
		

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.0F, -3.0F, 0.0F);
		Leftlib.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -0.1745F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(2, 3).addBox(-2.0F, -6.4982F, -1.8953F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(0.0F, 4.0829F, -5.6691F);
		Leftlib.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.8727F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(16, 94).addBox(-1.0F, -9.864F, -3.847F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		Leftfrontlib = new ModelRenderer(this);
		Leftfrontlib.setPos(0.0F, 1.0F, -2.0F);
		Leftlib.addChild(Leftfrontlib);
		

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.8727F, 0.0F, 0.0F);
		LeftArm_r4.texOffs(0, 23).addBox(-2.0F, -9.864F, -3.847F, 4.0F, 11.0F, 3.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(0.3084F, 2.5147F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.8727F, 0.0F, 0.3054F);
		LeftArm_r5.texOffs(120, 2).addBox(0.1176F, 1.2233F, -2.7429F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm_r5.texOffs(120, 2).addBox(0.1176F, 1.2233F, -3.7429F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setPos(0.0F, 3.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.9599F, 0.0F, 0.0F);
		LeftArm_r6.texOffs(120, 5).addBox(-1.0F, 1.3059F, -2.046F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setPos(0.0F, 7.0829F, -3.6691F);
		Leftfrontlib.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -0.8727F, 0.0F, 0.0F);
		LeftArm_r7.texOffs(120, 5).addBox(-1.0F, -1.4352F, -6.9112F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 10.0F, 0.0F);
		setRotationAngle(RightLeg, 0.192F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.9698F, 6.9621F, -0.3814F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, -0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(78, 90).addBox(-4.0047F, -7.9817F, -2.6866F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 9.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.1745F, 0.0F, -0.0349F);
		

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-2.0047F, 9.9526F, 0.5206F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.1745F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(101, 92).addBox(0.0047F, -9.9982F, -2.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);
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

		this.swi.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.6F * limbSwingAmount;
		this.swi.yRot = MathHelper.cos(limbSwing * 0.5662F) * 0.3F * limbSwingAmount;

		this.swi2.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.6F * limbSwingAmount;
		this.swi2.yRot = MathHelper.cos(limbSwing * 0.5662F) * 0.3F * limbSwingAmount;

		this.wing5.yRot = netHeadYaw * 0.017453292F;
		this.wingDown4.yRot = netHeadYaw * 0.017453292F;

		this.wingDown.yRot = netHeadYaw * 0.007453292F;
		this.wing4.yRot = netHeadYaw * 0.016453292F;
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