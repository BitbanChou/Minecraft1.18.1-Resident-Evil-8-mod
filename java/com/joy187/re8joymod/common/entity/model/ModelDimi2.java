// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityDimi2;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDimi2<T extends EntityDimi2> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer hairr2;
	private final ModelRenderer hair_r1;
	private final ModelRenderer hair_r2;
	private final ModelRenderer hairr4;
	private final ModelRenderer hair_r3;
	private final ModelRenderer hair_r4;
	private final ModelRenderer hairr7;
	private final ModelRenderer hair_r5;
	private final ModelRenderer hair_r6;
	private final ModelRenderer hair_r7;
	private final ModelRenderer hair_r8;
	private final ModelRenderer hairr6;
	private final ModelRenderer hair_r9;
	private final ModelRenderer hair_r10;
	private final ModelRenderer hairr5;
	private final ModelRenderer hair_r11;
	private final ModelRenderer hair_r12;
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
	private final ModelRenderer eye_r28;
	private final ModelRenderer eye_r29;
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
	private final ModelRenderer eye_r30;
	private final ModelRenderer hairr3;
	private final ModelRenderer hair_r13;
	private final ModelRenderer hair_r14;
	private final ModelRenderer hair_r15;
	private final ModelRenderer hair_r16;
	private final ModelRenderer hair_r17;
	private final ModelRenderer hair_r18;
	private final ModelRenderer hair_r19;
	private final ModelRenderer hair_r20;
	private final ModelRenderer hairr;
	private final ModelRenderer hair_r21;
	private final ModelRenderer hair_r22;
	private final ModelRenderer hair_r23;
	private final ModelRenderer hair_r24;
	private final ModelRenderer hair_r25;
	private final ModelRenderer hair_r26;
	private final ModelRenderer hair_r27;
	private final ModelRenderer hair_r28;
	private final ModelRenderer hair_r29;
	private final ModelRenderer hair_r30;
	private final ModelRenderer hair_r31;
	private final ModelRenderer hair_r32;
	private final ModelRenderer hair_r33;
	private final ModelRenderer hair_r34;
	private final ModelRenderer lips;
	private final ModelRenderer Body_r46;
	private final ModelRenderer Body_r47;
	private final ModelRenderer Body_r48;
	private final ModelRenderer Body_r49;
	private final ModelRenderer lips2;
	private final ModelRenderer Body_r50;
	private final ModelRenderer Body_r51;
	private final ModelRenderer Body_r52;
	private final ModelRenderer Body_r53;
	private final ModelRenderer lips3;
	private final ModelRenderer Body_r54;
	private final ModelRenderer Body_r55;
	private final ModelRenderer Body_r56;
	private final ModelRenderer Body_r57;
	private final ModelRenderer tail;
	private final ModelRenderer chin4_r1;
	private final ModelRenderer chin2_r1;
	private final ModelRenderer Body_r58;
	private final ModelRenderer Body_r59;
	private final ModelRenderer chin4_r2;
	private final ModelRenderer Body_r60;
	private final ModelRenderer Body_r61;
	private final ModelRenderer wing;
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
	private final ModelRenderer wing2;
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
	private final ModelRenderer innerlips;
	private final ModelRenderer Body_r100;
	private final ModelRenderer Body_r101;
	private final ModelRenderer Body_r102;
	private final ModelRenderer Body_r103;
	private final ModelRenderer insestlips;
	private final ModelRenderer Body_r104;
	private final ModelRenderer Body_r105;
	private final ModelRenderer Body_r106;
	private final ModelRenderer Body_r107;
	private final ModelRenderer insestlips2;
	private final ModelRenderer Body_r108;
	private final ModelRenderer Body_r109;
	private final ModelRenderer Body_r110;
	private final ModelRenderer Body_r111;
	private final ModelRenderer Body_r112;
	private final ModelRenderer innerlips2;
	private final ModelRenderer Body_r113;
	private final ModelRenderer Body_r114;
	private final ModelRenderer Body_r115;
	private final ModelRenderer Body_r116;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightArm_r1;
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
	private final ModelRenderer fur;
	private final ModelRenderer rearfur_r1;
	private final ModelRenderer fur2;
	private final ModelRenderer rearfur_r2;
	private final ModelRenderer viceleft;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg_r14;
	private final ModelRenderer RightLeg_r15;
	private final ModelRenderer RightLeg_r16;
	private final ModelRenderer RightLeg_r17;
	private final ModelRenderer RightLeg_r18;
	private final ModelRenderer RightLeg_r19;
	private final ModelRenderer RightLeg_r20;
	private final ModelRenderer RightLeg_r21;
	private final ModelRenderer RightLeg_r22;
	private final ModelRenderer fur3;
	private final ModelRenderer rearfur_r3;
	private final ModelRenderer fur4;
	private final ModelRenderer rearfur_r4;
	private final ModelRenderer otherp;
	private final ModelRenderer RightLeg_r23;
	private final ModelRenderer RightLeg_r24;
	private final ModelRenderer RightLeg_r25;
	private final ModelRenderer RightLeg_r26;
	private final ModelRenderer RightLeg_r27;
	private final ModelRenderer RightLeg_r28;
	private final ModelRenderer tongue;
	private final ModelRenderer Body_r117;
	private final ModelRenderer Body_r118;
	private final ModelRenderer Body_r119;
	private final ModelRenderer Body_r120;
	private final ModelRenderer Body_r121;
	private final ModelRenderer Body_r122;
	private final ModelRenderer LeftLeg2;
	private final ModelRenderer RightLeg_r29;
	private final ModelRenderer RightLeg_r30;
	private final ModelRenderer RightLeg_r31;
	private final ModelRenderer RightLeg_r32;
	private final ModelRenderer RightLeg_r33;
	private final ModelRenderer RightLeg_r34;
	private final ModelRenderer RightLeg_r35;
	private final ModelRenderer RightLeg_r36;
	private final ModelRenderer RightLeg_r37;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightLeg_r38;
	private final ModelRenderer RightLeg_r39;
	private final ModelRenderer RightLeg_r40;
	private final ModelRenderer RightLeg_r41;
	private final ModelRenderer RightLeg_r42;
	private final ModelRenderer RightLeg_r43;
	private final ModelRenderer RightLeg_r44;
	private final ModelRenderer RightLeg_r45;
	private final ModelRenderer RightLeg_r46;
	private final ModelRenderer RightLeg_r47;
	private final ModelRenderer RightLeg_r48;
	private final ModelRenderer RightLeg_r49;

	public ModelDimi2() {
		texWidth = 128;
		texHeight = 128;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -27.0F, 15.0F);
		setRotationAngle(Head, 0.1571F, 0.0873F, 0.0F);
		

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(0.7992F, -5.0981F, 13.7409F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.7936F, -0.0925F, -0.0093F);
		Head_r1.texOffs(33, 82).addBox(-3.0F, -4.5F, -0.5F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(0.8892F, -4.2521F, 12.8555F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.4446F, -0.0925F, -0.0093F);
		Head_r2.texOffs(33, 82).addBox(-4.0F, -4.5F, -8.5F, 2.0F, 1.0F, 8.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(-15.839F, -4.1043F, -7.2868F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0519F, -0.0925F, -0.0093F);
		Head_r3.texOffs(33, 82).addBox(13.5179F, -3.5324F, 4.9857F, 7.0F, 7.0F, 7.0F, 0.0F, false);

		hairr2 = new ModelRenderer(this);
		hairr2.setPos(5.2239F, 12.8459F, 14.9285F);
		Head.addChild(hairr2);
		setRotationAngle(hairr2, 0.0F, -0.2618F, 0.0F);
		

		hair_r1 = new ModelRenderer(this);
		hair_r1.setPos(2.2496F, -0.1979F, 26.0958F);
		hairr2.addChild(hair_r1);
		setRotationAngle(hair_r1, 1.4835F, -2.3998F, -1.5272F);
		hair_r1.texOffs(121, 75).addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r2 = new ModelRenderer(this);
		hair_r2.setPos(0.0F, 13.0F, 0.0F);
		hairr2.addChild(hair_r2);
		setRotationAngle(hair_r2, 1.4835F, -2.3998F, -1.0472F);
		hair_r2.texOffs(119, 75).addBox(-16.5807F, -21.5748F, 19.1393F, 1.0F, 18.0F, 1.0F, 0.0F, true);

		hairr4 = new ModelRenderer(this);
		hairr4.setPos(11.9889F, 0.291F, 23.8823F);
		Head.addChild(hairr4);
		setRotationAngle(hairr4, 0.0F, -1.0036F, -1.7453F);
		

		hair_r3 = new ModelRenderer(this);
		hair_r3.setPos(-5.4206F, 1.1574F, -18.0676F);
		hairr4.addChild(hair_r3);
		setRotationAngle(hair_r3, -3.0054F, -0.1443F, 2.3021F);
		hair_r3.texOffs(121, 75).addBox(-0.509F, -13.166F, -1.5551F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r4 = new ModelRenderer(this);
		hair_r4.setPos(-5.4206F, 1.1574F, -18.0676F);
		hairr4.addChild(hair_r4);
		setRotationAngle(hair_r4, -2.6752F, 0.1822F, 2.435F);
		hair_r4.texOffs(114, 112).addBox(-0.7104F, -0.3464F, -1.6107F, 1.0F, 14.0F, 1.0F, 0.0F, true);

		hairr7 = new ModelRenderer(this);
		hairr7.setPos(-4.5414F, -12.5578F, 13.7318F);
		Head.addChild(hairr7);
		setRotationAngle(hairr7, -0.4363F, 1.3526F, -1.7017F);
		

		hair_r5 = new ModelRenderer(this);
		hair_r5.setPos(2.1547F, 2.4025F, -0.4201F);
		hairr7.addChild(hair_r5);
		setRotationAngle(hair_r5, -3.0054F, -0.1443F, 2.3021F);
		hair_r5.texOffs(122, 113).addBox(-0.509F, -13.166F, -1.5551F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r6 = new ModelRenderer(this);
		hair_r6.setPos(-5.0479F, 7.1877F, 1.2641F);
		hairr7.addChild(hair_r6);
		setRotationAngle(hair_r6, -1.8025F, 0.1822F, 1.4751F);
		hair_r6.texOffs(114, 112).addBox(1.2896F, -10.3464F, -10.6107F, 1.0F, 11.0F, 1.0F, 0.0F, true);

		hair_r7 = new ModelRenderer(this);
		hair_r7.setPos(0.1097F, 0.0062F, 1.0829F);
		hairr7.addChild(hair_r7);
		setRotationAngle(hair_r7, -1.8025F, 0.1822F, 2.435F);
		hair_r7.texOffs(114, 112).addBox(1.2896F, -0.3464F, -10.6107F, 1.0F, 11.0F, 2.0F, 0.0F, true);

		hair_r8 = new ModelRenderer(this);
		hair_r8.setPos(0.1097F, 0.0062F, 1.0829F);
		hairr7.addChild(hair_r8);
		setRotationAngle(hair_r8, -2.5443F, 0.1822F, 2.435F);
		hair_r8.texOffs(114, 112).addBox(-0.7104F, 2.6536F, -1.6107F, 1.0F, 11.0F, 2.0F, 0.0F, true);

		hairr6 = new ModelRenderer(this);
		hairr6.setPos(5.9889F, -2.709F, 36.8823F);
		Head.addChild(hairr6);
		setRotationAngle(hairr6, 0.0F, -0.0436F, -1.0036F);
		

		hair_r9 = new ModelRenderer(this);
		hair_r9.setPos(8.104F, 1.7646F, -2.7959F);
		hairr6.addChild(hair_r9);
		setRotationAngle(hair_r9, 1.4835F, -2.3998F, -1.5272F);
		hair_r9.texOffs(121, 75).addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r10 = new ModelRenderer(this);
		hair_r10.setPos(7.235F, 12.5548F, -25.9538F);
		hairr6.addChild(hair_r10);
		setRotationAngle(hair_r10, 1.4835F, -2.3998F, -1.0472F);
		hair_r10.texOffs(114, 112).addBox(-16.5807F, -17.5748F, 19.1393F, 1.0F, 14.0F, 1.0F, 0.0F, true);

		hairr5 = new ModelRenderer(this);
		hairr5.setPos(-17.0111F, 3.291F, 37.8823F);
		Head.addChild(hairr5);
		setRotationAngle(hairr5, 0.0F, -0.2618F, 0.0F);
		

		hair_r11 = new ModelRenderer(this);
		hair_r11.setPos(23.104F, 1.7646F, -2.7959F);
		hairr5.addChild(hair_r11);
		setRotationAngle(hair_r11, 1.4835F, -2.3998F, -1.5272F);
		hair_r11.texOffs(121, 75).addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r12 = new ModelRenderer(this);
		hair_r12.setPos(22.235F, 12.5548F, -25.9538F);
		hairr5.addChild(hair_r12);
		setRotationAngle(hair_r12, 1.4835F, -2.3998F, -1.0472F);
		hair_r12.texOffs(119, 75).addBox(-16.5807F, -17.5748F, 19.1393F, 1.0F, 14.0F, 1.0F, 0.0F, true);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(50, 52).addBox(-6.0F, -14.0F, 10.0F, 13.0F, 12.0F, 0.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-2.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-10.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(6, 36).addBox(-10.0F, -10.0F, 3.0F, 20.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(0, 29).addBox(-6.0F, 2.0F, 3.0F, 13.0F, 12.0F, 7.0F, 0.0F, false);
		Body.texOffs(63, 94).addBox(-16.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);
		Body.texOffs(66, 94).addBox(10.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, 0.0F, true);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(11.3337F, -2.3369F, -11.0507F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 1.3526F, 0.0873F, -0.4363F);
		Body_r1.texOffs(18, 12).addBox(-2.5F, 4.0F, -8.5F, 1.0F, 8.0F, 8.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(11.3337F, -2.3369F, -11.0507F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 1.1781F, 0.0873F, -0.4363F);
		Body_r2.texOffs(30, 101).addBox(-1.5F, -5.0F, -8.5F, 1.0F, 10.0F, 17.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(4.5961F, 19.5828F, -12.3684F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.5236F, 0.4363F, -0.0873F);
		Body_r3.texOffs(18, 23).addBox(-1.0F, -3.5F, -2.5F, 8.0F, 2.0F, 13.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setPos(4.5961F, 19.5828F, -12.3684F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.5236F, -0.0436F, -0.0873F);
		Body_r4.texOffs(18, 23).addBox(-4.0F, -3.5F, -2.5F, 8.0F, 3.0F, 13.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setPos(-8.0254F, 20.1116F, -5.0856F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.3491F, 0.1745F, 0.2618F);
		Body_r5.texOffs(18, 23).addBox(-4.0F, -4.5F, -6.5F, 8.0F, 1.0F, 13.0F, 0.0F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setPos(-13.0808F, 13.065F, -5.9068F);
		Body.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.6545F, -0.0873F, 1.0036F);
		Body_r6.texOffs(18, 23).addBox(-3.0F, -3.5F, -6.5F, 8.0F, 1.0F, 13.0F, 0.0F, false);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setPos(6.7571F, 7.3652F, -12.0848F);
		Body.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.1745F, 0.1745F, 2.0071F);
		Body_r7.texOffs(18, 20).addBox(-4.0F, -5.5F, -2.0F, 8.0F, 2.0F, 16.0F, 0.0F, false);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setPos(-0.5F, 7.2141F, 5.8971F);
		Body.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.5236F, 0.0F, 0.0F);
		Body_r8.texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setPos(-0.1446F, -25.006F, 18.6893F);
		Body.addChild(Body_r9);
		setRotationAngle(Body_r9, -1.3963F, 0.0F, 0.0F);
		Body_r9.texOffs(0, 106).addBox(-6.8554F, 24.8498F, 4.1598F, 12.0F, 6.0F, 5.0F, 0.0F, false);
		Body_r9.texOffs(42, 54).addBox(-0.8554F, -1.1502F, -3.8402F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		Body_r9.texOffs(110, 82).addBox(-5.8554F, 3.8498F, 0.1598F, 5.0F, 3.0F, 4.0F, 0.0F, true);
		Body_r9.texOffs(110, 82).addBox(1.1446F, 3.8498F, 0.1598F, 5.0F, 3.0F, 4.0F, 0.0F, false);
		Body_r9.texOffs(86, 114).addBox(-2.8554F, -1.1502F, 4.1598F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Body_r9.texOffs(86, 114).addBox(-3.8554F, -2.1502F, 6.1598F, 8.0F, 7.0F, 6.0F, 0.0F, false);
		Body_r9.texOffs(81, 114).addBox(-5.8554F, -4.1502F, -0.8402F, 12.0F, 9.0F, 5.0F, 0.0F, false);

		eye_r1 = new ModelRenderer(this);
		eye_r1.setPos(7.4142F, -15.3412F, -7.5692F);
		Body.addChild(eye_r1);
		setRotationAngle(eye_r1, -1.1345F, -1.309F, -0.3491F);
		eye_r1.texOffs(75, 112).addBox(-2.5F, -6.0F, -1.5F, 4.0F, 4.0F, 2.0F, 0.0F, false);

		eye_r2 = new ModelRenderer(this);
		eye_r2.setPos(-7.4142F, -15.3412F, -7.5692F);
		Body.addChild(eye_r2);
		setRotationAngle(eye_r2, -1.1345F, 1.309F, 0.3491F);
		eye_r2.texOffs(75, 112).addBox(-1.5F, -6.0F, -1.5F, 4.0F, 4.0F, 2.0F, 0.0F, true);

		eye_r3 = new ModelRenderer(this);
		eye_r3.setPos(4.2468F, -12.6547F, -3.097F);
		Body.addChild(eye_r3);
		setRotationAngle(eye_r3, -0.9599F, -1.7017F, 0.0F);
		eye_r3.texOffs(76, 113).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r4 = new ModelRenderer(this);
		eye_r4.setPos(7.4142F, -15.3412F, -7.5692F);
		Body.addChild(eye_r4);
		setRotationAngle(eye_r4, -0.5672F, -1.309F, 0.0F);
		eye_r4.texOffs(76, 113).addBox(-1.5F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r5 = new ModelRenderer(this);
		eye_r5.setPos(-7.4142F, -15.3412F, -7.5692F);
		Body.addChild(eye_r5);
		setRotationAngle(eye_r5, -0.5672F, 1.309F, 0.0F);
		eye_r5.texOffs(76, 113).addBox(-2.5F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, 0.0F, true);

		eye_r6 = new ModelRenderer(this);
		eye_r6.setPos(8.4042F, -8.0858F, -9.905F);
		Body.addChild(eye_r6);
		setRotationAngle(eye_r6, -0.5672F, -1.309F, 0.3927F);
		eye_r6.texOffs(50, 92).addBox(-0.5F, 1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eye_r6.texOffs(50, 92).addBox(7.5F, 3.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eye_r6.texOffs(50, 92).addBox(9.5F, 4.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eye_r6.texOffs(49, 91).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r7 = new ModelRenderer(this);
		eye_r7.setPos(14.2501F, -1.3502F, 0.8981F);
		Body.addChild(eye_r7);
		setRotationAngle(eye_r7, -0.5672F, -1.309F, 0.0873F);
		eye_r7.texOffs(49, 92).addBox(5.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		eye_r7.texOffs(49, 92).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		eye_r8 = new ModelRenderer(this);
		eye_r8.setPos(-14.2501F, -1.3502F, 0.8981F);
		Body.addChild(eye_r8);
		setRotationAngle(eye_r8, -0.5672F, 1.309F, -0.0873F);
		eye_r8.texOffs(49, 92).addBox(-7.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		eye_r8.texOffs(49, 92).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);

		eye_r9 = new ModelRenderer(this);
		eye_r9.setPos(-8.4042F, -8.0858F, -9.905F);
		Body.addChild(eye_r9);
		setRotationAngle(eye_r9, -0.5672F, 1.309F, -0.3927F);
		eye_r9.texOffs(50, 92).addBox(-9.5F, 3.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		eye_r9.texOffs(50, 92).addBox(-11.5F, 4.0F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		eye_r9.texOffs(50, 92).addBox(-7.5F, 6.0F, -3.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		eye_r9.texOffs(50, 92).addBox(-1.5F, 1.0F, -1.5F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		eye_r9.texOffs(49, 91).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		eye_r10 = new ModelRenderer(this);
		eye_r10.setPos(6.7117F, -17.1301F, -8.0582F);
		Body.addChild(eye_r10);
		setRotationAngle(eye_r10, 0.2618F, -1.309F, -1.1345F);
		eye_r10.texOffs(49, 92).addBox(-4.5F, -1.0F, 1.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		eye_r11 = new ModelRenderer(this);
		eye_r11.setPos(-6.7117F, -17.1301F, -8.0582F);
		Body.addChild(eye_r11);
		setRotationAngle(eye_r11, 0.2618F, 1.309F, 1.1345F);
		eye_r11.texOffs(49, 92).addBox(1.5F, 0.0F, 0.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		eye_r12 = new ModelRenderer(this);
		eye_r12.setPos(6.7117F, -17.1301F, -8.0582F);
		Body.addChild(eye_r12);
		setRotationAngle(eye_r12, -0.5672F, -1.309F, -1.1345F);
		eye_r12.texOffs(49, 92).addBox(-4.5F, -6.0F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		eye_r13 = new ModelRenderer(this);
		eye_r13.setPos(-6.7117F, -17.1301F, -8.0582F);
		Body.addChild(eye_r13);
		setRotationAngle(eye_r13, -0.5672F, 1.309F, 1.1345F);
		eye_r13.texOffs(49, 92).addBox(1.5F, -3.0F, 0.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		eye_r14 = new ModelRenderer(this);
		eye_r14.setPos(1.9514F, -16.8632F, -0.929F);
		Body.addChild(eye_r14);
		setRotationAngle(eye_r14, -0.5672F, -1.309F, 0.0F);
		eye_r14.texOffs(49, 91).addBox(-5.5F, 10.0F, -3.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
		eye_r14.texOffs(49, 91).addBox(-3.5F, 15.0F, -3.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
		eye_r14.texOffs(49, 91).addBox(3.5F, 15.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
		eye_r14.texOffs(49, 91).addBox(-2.5F, 10.0F, -4.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r15 = new ModelRenderer(this);
		eye_r15.setPos(14.6267F, -1.3387F, -3.2901F);
		Body.addChild(eye_r15);
		setRotationAngle(eye_r15, -0.3927F, -1.9199F, -0.3927F);
		eye_r15.texOffs(49, 91).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r16 = new ModelRenderer(this);
		eye_r16.setPos(-14.6267F, -1.3387F, -3.2901F);
		Body.addChild(eye_r16);
		setRotationAngle(eye_r16, -0.3927F, 1.9199F, 0.3927F);
		eye_r16.texOffs(49, 91).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		eye_r17 = new ModelRenderer(this);
		eye_r17.setPos(-1.9514F, -16.8632F, -0.929F);
		Body.addChild(eye_r17);
		setRotationAngle(eye_r17, -0.5672F, 1.309F, 0.0F);
		eye_r17.texOffs(49, 91).addBox(0.5F, 15.0F, -3.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
		eye_r17.texOffs(49, 91).addBox(-6.5F, 15.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
		eye_r17.texOffs(49, 91).addBox(-0.5F, 10.0F, -4.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
		eye_r17.texOffs(49, 91).addBox(2.5F, 10.0F, -3.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		eye_r18 = new ModelRenderer(this);
		eye_r18.setPos(-14.5851F, -2.9098F, 5.0033F);
		Body.addChild(eye_r18);
		setRotationAngle(eye_r18, -0.2618F, 1.5708F, 0.0436F);
		eye_r18.texOffs(50, 93).addBox(-44.5F, 4.5F, 8.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		eye_r18.texOffs(48, 93).addBox(-42.5F, 3.5F, 7.5F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		eye_r18.texOffs(49, 92).addBox(-47.5F, 1.5F, 9.0297F, 3.0F, 3.0F, 1.0F, 0.0F, true);
		eye_r18.texOffs(49, 92).addBox(-44.5F, 0.5F, 7.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);
		eye_r18.texOffs(49, 92).addBox(-0.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		eye_r19 = new ModelRenderer(this);
		eye_r19.setPos(14.5851F, -2.9098F, 5.0033F);
		Body.addChild(eye_r19);
		setRotationAngle(eye_r19, -0.2618F, -1.5708F, -0.0436F);
		eye_r19.texOffs(50, 93).addBox(43.5F, 4.5F, 8.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		eye_r19.texOffs(48, 93).addBox(41.5F, 3.5F, 7.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		eye_r19.texOffs(49, 92).addBox(44.5F, 1.5F, 8.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		eye_r19.texOffs(49, 92).addBox(38.5F, -1.5F, 5.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		eye_r19.texOffs(49, 92).addBox(-2.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		eye_r20 = new ModelRenderer(this);
		eye_r20.setPos(-9.4642F, 0.8018F, 45.0033F);
		Body.addChild(eye_r20);
		setRotationAngle(eye_r20, -1.309F, 1.5708F, 0.0436F);
		eye_r20.texOffs(49, 92).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		eye_r21 = new ModelRenderer(this);
		eye_r21.setPos(9.4642F, 0.8018F, 45.0033F);
		Body.addChild(eye_r21);
		setRotationAngle(eye_r21, -1.309F, -1.5708F, -0.0436F);
		eye_r21.texOffs(49, 92).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		eye_r22 = new ModelRenderer(this);
		eye_r22.setPos(-10.54F, 3.9331F, 51.8877F);
		Body.addChild(eye_r22);
		setRotationAngle(eye_r22, 0.7418F, 1.1345F, 0.7418F);
		eye_r22.texOffs(49, 92).addBox(-1.5F, -0.5F, 4.5F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		eye_r23 = new ModelRenderer(this);
		eye_r23.setPos(10.54F, 3.9331F, 51.8877F);
		Body.addChild(eye_r23);
		setRotationAngle(eye_r23, 0.7418F, -1.1345F, -0.7418F);
		eye_r23.texOffs(49, 92).addBox(-1.5F, -0.5F, 4.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		eye_r24 = new ModelRenderer(this);
		eye_r24.setPos(1.9514F, -16.8632F, -0.929F);
		Body.addChild(eye_r24);
		setRotationAngle(eye_r24, -0.2182F, -1.309F, 0.0F);
		eye_r24.texOffs(75, 113).addBox(-7.5F, 5.0F, -7.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		eye_r25 = new ModelRenderer(this);
		eye_r25.setPos(-1.9514F, -16.8632F, -0.929F);
		Body.addChild(eye_r25);
		setRotationAngle(eye_r25, -0.2182F, 1.309F, 0.0F);
		eye_r25.texOffs(75, 113).addBox(2.5F, 5.0F, -7.0F, 5.0F, 4.0F, 1.0F, 0.0F, true);

		eye_r26 = new ModelRenderer(this);
		eye_r26.setPos(9.5F, -11.2064F, -1.0644F);
		Body.addChild(eye_r26);
		setRotationAngle(eye_r26, -0.7854F, -0.829F, 0.0F);
		eye_r26.texOffs(72, 110).addBox(-4.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);
		eye_r26.texOffs(72, 110).addBox(-1.5F, 3.0F, 1.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);

		eye_r27 = new ModelRenderer(this);
		eye_r27.setPos(-1.0257F, -13.0885F, -4.8314F);
		Body.addChild(eye_r27);
		setRotationAngle(eye_r27, -1.7017F, -1.2654F, 0.1745F);
		eye_r27.texOffs(73, 110).addBox(-0.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r28 = new ModelRenderer(this);
		eye_r28.setPos(-5.5328F, -13.224F, -0.6281F);
		Body.addChild(eye_r28);
		setRotationAngle(eye_r28, -0.7854F, 2.0071F, 0.3491F);
		eye_r28.texOffs(73, 110).addBox(-0.5F, -3.0F, 0.0F, 5.0F, 4.0F, 4.0F, 0.0F, true);

		eye_r29 = new ModelRenderer(this);
		eye_r29.setPos(-9.5F, -11.2064F, -1.0644F);
		Body.addChild(eye_r29);
		setRotationAngle(eye_r29, -0.7854F, 0.829F, 0.0F);
		eye_r29.texOffs(72, 110).addBox(-0.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, 0.0F, true);
		eye_r29.texOffs(72, 110).addBox(-3.5F, 3.0F, 1.0F, 5.0F, 4.0F, 4.0F, 0.0F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setPos(12.0F, -6.0F, 10.5F);
		Body.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.1745F, -0.48F);
		Body_r10.texOffs(44, 29).addBox(-1.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, 0.0F, true);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setPos(-12.0F, -6.0F, 10.5F);
		Body.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, -0.1745F, 0.48F);
		Body_r11.texOffs(45, 29).addBox(-2.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, 0.0F, false);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setPos(8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.0F, 0.0F, 0.6545F);
		Body_r12.texOffs(57, 3).addBox(-3.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, true);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setPos(-8.3807F, 13.7163F, 9.0F);
		Body.addChild(Body_r13);
		setRotationAngle(Body_r13, 0.0F, 0.0F, -0.6545F);
		Body_r13.texOffs(72, 97).addBox(-3.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, 0.0F, false);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setPos(7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.0F, 0.0F, 1.3963F);
		Body_r14.texOffs(70, 91).addBox(-6.0F, -6.0F, -11.0F, 6.0F, 15.0F, 22.0F, 0.0F, true);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setPos(4.4255F, 11.6854F, 27.0F);
		Body.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.0F, -0.1309F, 1.3963F);
		Body_r15.texOffs(12, 32).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 22.0F, 0.0F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setPos(2.2121F, 21.993F, 55.785F);
		Body.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.0F, -0.0436F, -1.6144F);
		Body_r16.texOffs(72, 98).addBox(8.0F, -5.0F, -2.0F, 7.0F, 10.0F, 18.0F, 0.0F, false);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setPos(1.989F, 16.8828F, 44.0F);
		Body.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.0F, -0.0873F, -1.6144F);
		Body_r17.texOffs(69, 101).addBox(4.0F, -7.0F, -9.0F, 3.0F, 10.0F, 17.0F, 0.0F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setPos(-4.4255F, 11.6854F, 27.0F);
		Body.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.0F, 0.2182F, -1.3963F);
		Body_r18.texOffs(56, 1).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setPos(-7.0897F, 15.2773F, 9.0F);
		Body.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, -1.3963F);
		Body_r19.texOffs(72, 93).addBox(-1.0F, -6.0F, -11.0F, 6.0F, 12.0F, 22.0F, 0.0F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setPos(1.2275F, 4.0987F, 62.3715F);
		Body.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0436F, -0.3054F, -1.6144F);
		Body_r20.texOffs(70, 100).addBox(-5.0F, -5.5F, -8.0F, 8.0F, 11.0F, 17.0F, 0.0F, true);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setPos(-0.5989F, -12.2009F, 25.6123F);
		Body.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0436F, -0.3054F, -1.789F);
		Body_r21.texOffs(61, 97).addBox(-5.5F, -5.5F, 11.0F, 6.0F, 11.0F, 20.0F, 0.0F, true);
		Body_r21.texOffs(61, 94).addBox(-3.5F, -6.5F, -10.0F, 5.0F, 13.0F, 21.0F, 0.0F, true);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setPos(8.089F, -9.2031F, 25.7953F);
		Body.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.2182F, -0.3491F, -0.9599F);
		Body_r22.texOffs(82, 99).addBox(-3.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setPos(-8.089F, -9.2031F, 25.7953F);
		Body.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.2182F, 0.3491F, 0.9599F);
		Body_r23.texOffs(82, 99).addBox(0.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setPos(13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r24);
		setRotationAngle(Body_r24, -0.2618F, -0.2618F, 0.0F);
		Body_r24.texOffs(64, 99).addBox(-7.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setPos(-13.8543F, 5.3439F, 26.3663F);
		Body.addChild(Body_r25);
		setRotationAngle(Body_r25, -0.2618F, 0.2618F, 0.0F);
		Body_r25.texOffs(69, 99).addBox(1.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setPos(12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, -0.2618F, 0.0F);
		Body_r26.texOffs(70, 98).addBox(-6.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, true);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setPos(4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r27);
		setRotationAngle(Body_r27, -0.0436F, -0.2618F, 0.0F);
		Body_r27.texOffs(72, 96).addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setPos(-4.2337F, 3.3197F, 50.3251F);
		Body.addChild(Body_r28);
		setRotationAngle(Body_r28, -0.0436F, 0.2618F, 0.0F);
		Body_r28.texOffs(72, 96).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, 0.0F, false);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setPos(12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r29);
		setRotationAngle(Body_r29, -0.3491F, -0.2618F, 0.0F);
		Body_r29.texOffs(70, 98).addBox(-6.0F, -8.5F, 7.0F, 7.0F, 6.0F, 21.0F, 0.0F, true);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r30);
		setRotationAngle(Body_r30, -0.3491F, 0.2618F, 0.0F);
		Body_r30.texOffs(70, 97).addBox(-1.0F, -8.5F, 7.0F, 7.0F, 6.0F, 21.0F, 0.0F, false);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setPos(-12.0F, 7.5F, 31.0F);
		Body.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.2618F, 0.0F);
		Body_r31.texOffs(72, 98).addBox(-1.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setPos(4.6711F, -13.1278F, 6.5F);
		Body.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.2182F, 0.0F, 0.3927F);
		Body_r32.texOffs(0, 0).addBox(-6.5F, -0.5F, -11.5F, 13.0F, 4.0F, 23.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setPos(0.5F, -14.5F, 6.5F);
		Body.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.2182F, 0.0F, -0.3927F);
		Body_r33.texOffs(0, 0).addBox(-12.5F, -1.5F, -11.5F, 13.0F, 4.0F, 23.0F, 0.0F, false);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setPos(4.5383F, 13.9488F, -13.6264F);
		Body.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.1745F, 0.0436F, 0.0F);
		Body_r34.texOffs(0, 58).addBox(-2.0F, -3.0F, 5.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setPos(13.0526F, 10.9943F, -10.6635F);
		Body.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.1745F, 0.48F, 0.0F);
		Body_r35.texOffs(0, 58).addBox(-2.0F, 3.0F, -9.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r35.texOffs(0, 58).addBox(-2.0F, 2.0F, -6.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setPos(6.9331F, 13.7751F, -11.5685F);
		Body.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.1745F, 0.0873F, 0.0F);
		Body_r36.texOffs(0, 58).addBox(-13.0F, 2.0F, 5.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		Body_r36.texOffs(0, 58).addBox(-12.0F, 3.0F, 1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r36.texOffs(0, 58).addBox(-16.0F, 3.0F, -2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body_r36.texOffs(0, 58).addBox(-19.0F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r36.texOffs(0, 58).addBox(-2.0F, 1.0F, -5.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setPos(-12.04F, 10.8207F, -10.4315F);
		Body.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.1745F, 0.0873F, 0.5672F);
		Body_r37.texOffs(0, 59).addBox(0.0F, -3.0F, 4.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Body_r37.texOffs(0, 58).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setPos(16.5F, -1.5179F, -7.2272F);
		Body.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.1745F, -0.3927F, 0.0F);
		Body_r38.texOffs(0, 58).addBox(-16.5F, 17.0F, -5.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setPos(0.9896F, -12.2424F, -10.3271F);
		Body.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.5236F, -1.7017F, 0.0F);
		Body_r39.texOffs(0, 58).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setPos(-6.6787F, -8.9154F, -12.3453F);
		Body.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0873F, -2.0071F, 0.0F);
		Body_r40.texOffs(0, 58).addBox(-1.0F, 3.5F, 0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.texOffs(0, 58).addBox(-1.0F, 1.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.texOffs(0, 58).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setPos(2.2738F, -11.1195F, -9.6538F);
		Body.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0873F, -1.7017F, 0.0F);
		Body_r41.texOffs(0, 58).addBox(-1.5F, -0.5F, 6.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r41.texOffs(0, 58).addBox(-2.5F, -0.5F, 4.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setPos(2.2738F, -11.1195F, -9.6538F);
		Body.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.1745F, -1.7017F, 0.0F);
		Body_r42.texOffs(0, 58).addBox(-2.5F, -0.5F, 2.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r42.texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setPos(15.5F, -2.5179F, -10.2272F);
		Body.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.1745F, -0.3927F, 0.0F);
		Body_r43.texOffs(0, 58).addBox(-10.5F, -7.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r43.texOffs(0, 58).addBox(-10.5F, -5.0F, 2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r43.texOffs(0, 58).addBox(-10.5F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r43.texOffs(0, 58).addBox(-8.5F, 1.0F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r43.texOffs(0, 58).addBox(-8.5F, 3.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setPos(9.4657F, 8.3435F, -13.951F);
		Body.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.1745F, -0.3927F, 0.5672F);
		Body_r44.texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setPos(11.0695F, 6.2002F, -12.5967F);
		Body.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.1745F, -0.3927F, 0.5236F);
		Body_r45.texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		eye_r30 = new ModelRenderer(this);
		eye_r30.setPos(13.9745F, -12.4879F, 17.0983F);
		Body.addChild(eye_r30);
		setRotationAngle(eye_r30, -0.4363F, -2.5307F, 1.4835F);
		eye_r30.texOffs(47, 1).addBox(-4.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		hairr3 = new ModelRenderer(this);
		hairr3.setPos(-3.955F, -28.4999F, 13.7841F);
		Body.addChild(hairr3);
		setRotationAngle(hairr3, 0.0F, -0.6981F, 0.0F);
		

		hair_r13 = new ModelRenderer(this);
		hair_r13.setPos(6.9247F, -11.5807F, 24.3213F);
		hairr3.addChild(hair_r13);
		setRotationAngle(hair_r13, -1.9475F, -0.711F, 1.8074F);
		hair_r13.texOffs(25, 4).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r14 = new ModelRenderer(this);
		hair_r14.setPos(4.8706F, 0.8965F, 9.4795F);
		hairr3.addChild(hair_r14);
		setRotationAngle(hair_r14, -2.7991F, 0.164F, -2.2272F);
		hair_r14.texOffs(102, 19).addBox(-6.5F, -6.5F, 11.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		hair_r14.texOffs(102, 19).addBox(-5.5F, -12.5F, 8.5F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		hair_r15 = new ModelRenderer(this);
		hair_r15.setPos(3.0394F, 0.8965F, 9.4795F);
		hairr3.addChild(hair_r15);
		setRotationAngle(hair_r15, -1.1847F, -0.164F, 2.2272F);
		hair_r15.texOffs(102, 19).addBox(2.5F, -10.5F, -6.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r16 = new ModelRenderer(this);
		hair_r16.setPos(3.0394F, 0.8965F, 9.4795F);
		hairr3.addChild(hair_r16);
		setRotationAngle(hair_r16, -2.0573F, -0.164F, 2.2272F);
		hair_r16.texOffs(102, 19).addBox(4.5F, -4.5F, -1.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r17 = new ModelRenderer(this);
		hair_r17.setPos(3.0394F, 0.8965F, 9.4795F);
		hairr3.addChild(hair_r17);
		setRotationAngle(hair_r17, -2.0573F, -0.6876F, 2.2272F);
		hair_r17.texOffs(26, 3).addBox(-1.5F, -6.5F, -0.5F, 1.0F, 13.0F, 1.0F, 0.0F, true);

		hair_r18 = new ModelRenderer(this);
		hair_r18.setPos(11.0F, 0.0F, 0.0F);
		hairr3.addChild(hair_r18);
		setRotationAngle(hair_r18, -1.8902F, -0.6185F, 2.2411F);
		hair_r18.texOffs(25, 0).addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r19 = new ModelRenderer(this);
		hair_r19.setPos(1.0971F, -8.5633F, 20.6119F);
		hairr3.addChild(hair_r19);
		setRotationAngle(hair_r19, -2.1456F, -0.5627F, 2.2861F);
		hair_r19.texOffs(116, 68).addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r20 = new ModelRenderer(this);
		hair_r20.setPos(4.0F, 1.0F, 0.0F);
		hairr3.addChild(hair_r20);
		setRotationAngle(hair_r20, -1.971F, -0.5627F, 2.2861F);
		hair_r20.texOffs(25, 1).addBox(6.0F, -14.0F, -2.0F, 2.0F, 16.0F, 1.0F, 0.0F, true);

		hairr = new ModelRenderer(this);
		hairr.setPos(3.045F, -1.4999F, 31.7841F);
		Body.addChild(hairr);
		

		hair_r21 = new ModelRenderer(this);
		hair_r21.setPos(24.9874F, -16.9249F, 18.4945F);
		hairr.addChild(hair_r21);
		setRotationAngle(hair_r21, -0.878F, -0.5466F, 1.0396F);
		hair_r21.texOffs(107, 102).addBox(-30.8886F, -19.9984F, -9.4613F, 1.0F, 12.0F, 1.0F, 0.0F, true);

		hair_r22 = new ModelRenderer(this);
		hair_r22.setPos(23.8611F, -17.681F, 20.5035F);
		hairr.addChild(hair_r22);
		setRotationAngle(hair_r22, -0.7471F, -0.5466F, 1.0396F);
		hair_r22.texOffs(107, 102).addBox(-30.8886F, -7.9984F, -10.4613F, 1.0F, 16.0F, 2.0F, 0.0F, true);

		hair_r23 = new ModelRenderer(this);
		hair_r23.setPos(-13.5927F, -40.6592F, 17.6937F);
		hairr.addChild(hair_r23);
		setRotationAngle(hair_r23, 1.8762F, 2.4871F, 1.0036F);
		hair_r23.texOffs(83, 98).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		hair_r24 = new ModelRenderer(this);
		hair_r24.setPos(1.0534F, -47.2327F, 16.9892F);
		hairr.addChild(hair_r24);
		setRotationAngle(hair_r24, 0.829F, -2.4871F, -1.0036F);
		hair_r24.texOffs(83, 98).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, true);

		hair_r25 = new ModelRenderer(this);
		hair_r25.setPos(-1.4543F, -14.6007F, 31.2959F);
		hairr.addChild(hair_r25);
		setRotationAngle(hair_r25, 1.4835F, 2.3998F, 1.0036F);
		hair_r25.texOffs(83, 98).addBox(30.019F, -6.0714F, 3.9331F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		hair_r26 = new ModelRenderer(this);
		hair_r26.setPos(-7.6358F, -19.6007F, 31.2959F);
		hairr.addChild(hair_r26);
		setRotationAngle(hair_r26, 1.4835F, -2.3998F, -1.0036F);
		hair_r26.texOffs(83, 98).addBox(-31.019F, -6.0714F, 3.9331F, 1.0F, 8.0F, 1.0F, 0.0F, true);

		hair_r27 = new ModelRenderer(this);
		hair_r27.setPos(5.6347F, -15.2185F, 31.2371F);
		hairr.addChild(hair_r27);
		setRotationAngle(hair_r27, 1.4835F, -2.3998F, -1.5272F);
		hair_r27.texOffs(25, 6).addBox(-32.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, 0.0F, true);

		hair_r28 = new ModelRenderer(this);
		hair_r28.setPos(-12.7247F, -12.2185F, 31.2371F);
		hairr.addChild(hair_r28);
		setRotationAngle(hair_r28, 1.4835F, 2.3998F, 1.5272F);
		hair_r28.texOffs(102, 22).addBox(31.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		hair_r29 = new ModelRenderer(this);
		hair_r29.setPos(3.6347F, -17.2185F, 31.2371F);
		hairr.addChild(hair_r29);
		setRotationAngle(hair_r29, 1.4835F, -2.3998F, -1.5272F);
		hair_r29.texOffs(102, 22).addBox(-32.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, 0.0F, true);

		hair_r30 = new ModelRenderer(this);
		hair_r30.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r30);
		setRotationAngle(hair_r30, -1.1052F, -0.8438F, 1.2893F);
		hair_r30.texOffs(118, 78).addBox(-24.0459F, -22.3757F, -1.9997F, 1.0F, 16.0F, 1.0F, 0.0F, true);

		hair_r31 = new ModelRenderer(this);
		hair_r31.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r31);
		setRotationAngle(hair_r31, -0.5816F, -0.8438F, 1.2893F);
		hair_r31.texOffs(104, 100).addBox(-25.0459F, -30.2534F, 1.1881F, 2.0F, 25.0F, 2.0F, 0.0F, true);

		hair_r32 = new ModelRenderer(this);
		hair_r32.setPos(2.0F, 2.0F, 0.0F);
		hairr.addChild(hair_r32);
		setRotationAngle(hair_r32, 1.4835F, -2.3998F, -1.0472F);
		hair_r32.texOffs(25, 0).addBox(-20.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		hair_r33 = new ModelRenderer(this);
		hair_r33.setPos(-9.0901F, 5.0F, 0.0F);
		hairr.addChild(hair_r33);
		setRotationAngle(hair_r33, 1.4835F, 2.3998F, 1.0472F);
		hair_r33.texOffs(25, 0).addBox(19.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, 0.0F, false);

		hair_r34 = new ModelRenderer(this);
		hair_r34.setPos(0.0F, 0.0F, 0.0F);
		hairr.addChild(hair_r34);
		setRotationAngle(hair_r34, 1.4835F, -2.3998F, -1.0472F);
		hair_r34.texOffs(25, 0).addBox(-20.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, 0.0F, true);

		lips = new ModelRenderer(this);
		lips.setPos(-16.3283F, 5.6873F, -7.3921F);
		Body.addChild(lips);
		setRotationAngle(lips, 0.7418F, -0.3927F, 0.0436F);
		

		Body_r46 = new ModelRenderer(this);
		Body_r46.setPos(9.2882F, 9.1334F, -3.0394F);
		lips.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.1745F, 0.0873F, 0.5672F);
		Body_r46.texOffs(0, 59).addBox(-5.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r46.texOffs(0, 59).addBox(-9.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r46.texOffs(0, 59).addBox(-13.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r46.texOffs(0, 59).addBox(-17.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r46.texOffs(0, 59).addBox(-13.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r46.texOffs(0, 59).addBox(-13.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setPos(6.1619F, -8.4943F, -4.9852F);
		lips.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.3927F, 1.0472F, 1.2654F);
		Body_r47.texOffs(12, 12).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, 0.0F, false);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setPos(0.4002F, -6.6601F, -2.1343F);
		lips.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.1745F, -0.3491F, 0.5672F);
		Body_r48.texOffs(0, 59).addBox(0.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setPos(2.9967F, -2.0125F, -5.6834F);
		lips.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.6545F, 0.1745F, 1.2654F);
		Body_r49.texOffs(17, 12).addBox(-8.0F, 2.5F, 1.5F, 8.0F, 1.0F, 13.0F, 0.0F, false);

		lips2 = new ModelRenderer(this);
		lips2.setPos(-10.3283F, 25.6873F, -4.3921F);
		Body.addChild(lips2);
		setRotationAngle(lips2, 1.0036F, 0.0873F, -0.9599F);
		

		Body_r50 = new ModelRenderer(this);
		Body_r50.setPos(9.2882F, 9.1334F, -3.0394F);
		lips2.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.1745F, 0.0873F, 0.5672F);
		Body_r50.texOffs(0, 59).addBox(-5.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r50.texOffs(0, 59).addBox(-9.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r50.texOffs(0, 59).addBox(-13.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r50.texOffs(0, 59).addBox(-17.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r50.texOffs(0, 59).addBox(-13.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r50.texOffs(0, 59).addBox(-13.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setPos(6.1619F, -8.4943F, -4.9852F);
		lips2.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.3927F, 1.0472F, 1.2654F);
		Body_r51.texOffs(16, 22).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, 0.0F, false);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setPos(0.4002F, -6.6601F, -2.1343F);
		lips2.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.1745F, -0.3491F, 0.5672F);
		Body_r52.texOffs(0, 59).addBox(0.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setPos(2.9967F, -2.0125F, -5.6834F);
		lips2.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.6545F, 0.1745F, 1.2654F);
		Body_r53.texOffs(15, 21).addBox(-8.0F, 2.5F, 1.5F, 8.0F, 1.0F, 16.0F, 0.0F, false);

		lips3 = new ModelRenderer(this);
		lips3.setPos(10.3283F, 25.6873F, -4.3921F);
		Body.addChild(lips3);
		setRotationAngle(lips3, 1.0036F, -0.0873F, 0.9599F);
		

		Body_r54 = new ModelRenderer(this);
		Body_r54.setPos(-9.2882F, 9.1334F, -3.0394F);
		lips3.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.1745F, -0.0873F, -0.5672F);
		Body_r54.texOffs(0, 59).addBox(4.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r54.texOffs(0, 59).addBox(8.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r54.texOffs(0, 59).addBox(12.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r54.texOffs(0, 59).addBox(16.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r54.texOffs(0, 59).addBox(12.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Body_r54.texOffs(0, 59).addBox(12.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setPos(-6.1619F, -8.4943F, -4.9852F);
		lips3.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.3927F, -1.0472F, -1.2654F);
		Body_r55.texOffs(16, 22).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, 0.0F, true);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setPos(-0.4002F, -6.6601F, -2.1343F);
		lips3.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.1745F, 0.3491F, -0.5672F);
		Body_r56.texOffs(0, 59).addBox(-1.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setPos(-2.9967F, -2.0125F, -5.6834F);
		lips3.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.6545F, -0.1745F, -1.2654F);
		Body_r57.texOffs(15, 21).addBox(0.0F, 2.5F, 1.5F, 8.0F, 1.0F, 16.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setPos(-1.8942F, 12.0352F, 71.1238F);
		Body.addChild(tail);
		

		chin4_r1 = new ModelRenderer(this);
		chin4_r1.setPos(-14.49F, -0.7681F, 46.0439F);
		tail.addChild(chin4_r1);
		setRotationAngle(chin4_r1, -0.0873F, 0.6981F, -2.2689F);
		chin4_r1.texOffs(92, 110).addBox(-1.0F, -7.0F, 23.0F, 2.0F, 1.0F, 14.0F, 0.0F, false);
		chin4_r1.texOffs(71, 105).addBox(-1.0F, -7.0F, 9.0F, 3.0F, 3.0F, 16.0F, 0.0F, false);

		chin2_r1 = new ModelRenderer(this);
		chin2_r1.setPos(3.9114F, -4.452F, 47.7567F);
		tail.addChild(chin2_r1);
		setRotationAngle(chin2_r1, 0.48F, 0.6981F, -2.2689F);
		chin2_r1.texOffs(77, 103).addBox(7.0F, -14.0F, 7.0F, 3.0F, 4.0F, 16.0F, 0.0F, false);
		chin2_r1.texOffs(77, 103).addBox(14.0F, -21.0F, -17.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		Body_r58 = new ModelRenderer(this);
		Body_r58.setPos(-5.086F, 0.6038F, 38.5459F);
		tail.addChild(Body_r58);
		setRotationAngle(Body_r58, 0.6109F, 0.5672F, -2.2689F);
		Body_r58.texOffs(75, 104).addBox(-1.0F, -3.0F, -8.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);

		Body_r59 = new ModelRenderer(this);
		Body_r59.setPos(-0.9831F, 0.7546F, 28.6413F);
		tail.addChild(Body_r59);
		setRotationAngle(Body_r59, 0.0F, 0.5672F, -2.2689F);
		Body_r59.texOffs(70, 106).addBox(-4.0F, -2.0F, -11.0F, 4.0F, 6.0F, 16.0F, 0.0F, false);

		chin4_r2 = new ModelRenderer(this);
		chin4_r2.setPos(-10.6486F, 4.3582F, 30.5214F);
		tail.addChild(chin4_r2);
		setRotationAngle(chin4_r2, 0.48F, 0.4363F, -2.2689F);
		chin4_r2.texOffs(81, 105).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		Body_r60 = new ModelRenderer(this);
		Body_r60.setPos(4.1063F, 9.9578F, -15.3388F);
		tail.addChild(Body_r60);
		setRotationAngle(Body_r60, 0.0F, -0.0436F, -1.6144F);
		Body_r60.texOffs(62, 6).addBox(4.0F, -5.0F, 23.0F, 5.0F, 9.0F, 16.0F, 0.0F, false);

		Body_r61 = new ModelRenderer(this);
		Body_r61.setPos(3.1217F, -7.9365F, -8.7523F);
		tail.addChild(Body_r61);
		setRotationAngle(Body_r61, 0.0436F, -0.3054F, -1.6144F);
		Body_r61.texOffs(75, 100).addBox(-7.0F, -4.5F, 7.0F, 6.0F, 11.0F, 19.0F, 0.0F, true);

		wing = new ModelRenderer(this);
		wing.setPos(30.745F, -16.3552F, 22.2371F);
		Body.addChild(wing);
		

		Body_r62 = new ModelRenderer(this);
		Body_r62.setPos(-0.9804F, -0.6832F, 0.8535F);
		wing.addChild(Body_r62);
		setRotationAngle(Body_r62, -1.309F, -0.6545F, 0.6109F);
		Body_r62.texOffs(82, 109).addBox(-5.0F, -7.5F, -6.5F, 2.0F, 9.0F, 7.0F, 0.0F, false);

		Body_r63 = new ModelRenderer(this);
		Body_r63.setPos(-12.5402F, -3.1633F, 6.4215F);
		wing.addChild(Body_r63);
		setRotationAngle(Body_r63, -1.309F, -0.3491F, 0.1309F);
		Body_r63.texOffs(82, 109).addBox(7.5F, -4.5F, -9.0F, 3.0F, 11.0F, 7.0F, 0.0F, false);

		Body_r64 = new ModelRenderer(this);
		Body_r64.setPos(13.0902F, -12.7751F, 9.6888F);
		wing.addChild(Body_r64);
		setRotationAngle(Body_r64, -1.309F, -0.6981F, -0.4363F);
		Body_r64.texOffs(92, 104).addBox(31.5F, -34.0F, -1.5F, 13.0F, 22.0F, 2.0F, 0.0F, false);
		Body_r64.texOffs(92, 107).addBox(44.5F, -17.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r64.texOffs(92, 107).addBox(32.5F, -13.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r64.texOffs(79, 111).addBox(11.5F, -35.0F, -1.5F, 21.0F, 15.0F, 2.0F, 0.0F, false);
		Body_r64.texOffs(82, 114).addBox(11.5F, -21.0F, -1.5F, 21.0F, 12.0F, 2.0F, 0.0F, false);
		Body_r64.texOffs(92, 107).addBox(19.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, false);

		Body_r65 = new ModelRenderer(this);
		Body_r65.setPos(49.1949F, -32.4285F, 53.9188F);
		wing.addChild(Body_r65);
		setRotationAngle(Body_r65, -1.309F, -0.2182F, -0.4363F);
		Body_r65.texOffs(92, 107).addBox(4.0F, -9.0F, -2.0F, 5.0F, 18.0F, 4.0F, 0.0F, false);
		Body_r65.texOffs(92, 107).addBox(-4.0F, -9.0F, -1.0F, 9.0F, 18.0F, 2.0F, 0.0F, false);

		Body_r66 = new ModelRenderer(this);
		Body_r66.setPos(30.8949F, -29.0355F, 61.6103F);
		wing.addChild(Body_r66);
		setRotationAngle(Body_r66, -1.0908F, -0.6981F, -0.4363F);
		Body_r66.texOffs(117, 82).addBox(20.5F, -31.0F, -3.0F, 3.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r66.texOffs(118, 81).addBox(-7.5F, -36.0F, -3.0F, 3.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r66.texOffs(114, 68).addBox(-9.5F, -18.0F, -3.0F, 5.0F, 27.0F, 2.0F, 0.0F, false);
		Body_r66.texOffs(92, 107).addBox(5.5F, -6.0F, -3.0F, 13.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r66.texOffs(92, 107).addBox(-6.5F, -9.0F, -3.0F, 13.0F, 18.0F, 2.0F, 0.0F, false);

		Body_r67 = new ModelRenderer(this);
		Body_r67.setPos(30.8949F, -29.0355F, 61.6103F);
		wing.addChild(Body_r67);
		setRotationAngle(Body_r67, -1.0908F, -0.6981F, -0.3054F);
		Body_r67.texOffs(114, 68).addBox(17.5F, -16.0F, -3.0F, 5.0F, 27.0F, 2.0F, 0.0F, false);

		Body_r68 = new ModelRenderer(this);
		Body_r68.setPos(4.5337F, -24.0903F, 53.6805F);
		wing.addChild(Body_r68);
		setRotationAngle(Body_r68, -1.0908F, -0.9163F, -0.6109F);
		Body_r68.texOffs(115, 68).addBox(-33.5F, -19.5F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		Body_r68.texOffs(115, 68).addBox(-6.5F, -29.5F, 4.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		Body_r68.texOffs(114, 68).addBox(-34.5F, -11.5F, 1.0F, 4.0F, 12.0F, 2.0F, 0.0F, false);
		Body_r68.texOffs(114, 68).addBox(-8.5F, -19.5F, 4.0F, 4.0F, 27.0F, 2.0F, 0.0F, false);

		Body_r69 = new ModelRenderer(this);
		Body_r69.setPos(45.696F, -27.3701F, 30.2667F);
		wing.addChild(Body_r69);
		setRotationAngle(Body_r69, -1.309F, -0.9599F, -0.4363F);
		Body_r69.texOffs(84, 108).addBox(-9.0F, -3.0F, -2.0F, 18.0F, 6.0F, 4.0F, 0.0F, false);

		Body_r70 = new ModelRenderer(this);
		Body_r70.setPos(48.5061F, -28.6804F, 29.9796F);
		wing.addChild(Body_r70);
		setRotationAngle(Body_r70, -1.309F, -0.6981F, -0.4363F);
		Body_r70.texOffs(80, 111).addBox(-28.0F, -3.0F, -2.0F, 18.0F, 6.0F, 6.0F, 0.0F, false);

		Body_r71 = new ModelRenderer(this);
		Body_r71.setPos(15.7126F, -13.998F, 7.9355F);
		wing.addChild(Body_r71);
		setRotationAngle(Body_r71, -1.309F, -0.6981F, -0.4363F);
		Body_r71.texOffs(84, 108).addBox(44.5F, -2.0F, -2.5F, 18.0F, 6.0F, 4.0F, 0.0F, false);

		Body_r72 = new ModelRenderer(this);
		Body_r72.setPos(-3.6947F, -12.6587F, 33.4207F);
		wing.addChild(Body_r72);
		setRotationAngle(Body_r72, -1.2654F, -0.9599F, -0.4363F);
		Body_r72.texOffs(45, 49).addBox(-11.5F, -4.0F, -1.5F, 23.0F, 12.0F, 3.0F, 0.0F, false);

		Body_r73 = new ModelRenderer(this);
		Body_r73.setPos(1.5147F, -12.1939F, 22.5627F);
		wing.addChild(Body_r73);
		setRotationAngle(Body_r73, -1.309F, -0.48F, -0.4363F);
		Body_r73.texOffs(78, 113).addBox(-10.5F, -6.0F, -1.0F, 23.0F, 12.0F, 3.0F, 0.0F, false);

		Body_r74 = new ModelRenderer(this);
		Body_r74.setPos(7.0645F, -19.4938F, 47.0392F);
		wing.addChild(Body_r74);
		setRotationAngle(Body_r74, -1.4399F, -0.2618F, -0.4363F);
		Body_r74.texOffs(79, 111).addBox(-10.5F, -7.5F, -1.0F, 21.0F, 8.0F, 2.0F, 0.0F, false);

		Body_r75 = new ModelRenderer(this);
		Body_r75.setPos(12.7213F, -12.6031F, 11.5207F);
		wing.addChild(Body_r75);
		setRotationAngle(Body_r75, -1.309F, -0.6109F, -0.4363F);
		Body_r75.texOffs(92, 107).addBox(6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, false);
		Body_r75.texOffs(92, 107).addBox(-6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 3.0F, 0.0F, false);

		Body_r76 = new ModelRenderer(this);
		Body_r76.setPos(-8.4442F, -2.5962F, 7.5464F);
		wing.addChild(Body_r76);
		setRotationAngle(Body_r76, -1.309F, -0.3491F, -0.2618F);
		Body_r76.texOffs(92, 107).addBox(6.5F, -4.5F, -7.0F, 13.0F, 18.0F, 3.0F, 0.0F, false);
		Body_r76.texOffs(80, 114).addBox(-6.5F, -4.5F, -2.0F, 13.0F, 9.0F, 3.0F, 0.0F, false);

		Body_r77 = new ModelRenderer(this);
		Body_r77.setPos(-11.7226F, -7.0934F, 13.0489F);
		wing.addChild(Body_r77);
		setRotationAngle(Body_r77, -1.309F, -0.6981F, -0.2618F);
		Body_r77.texOffs(80, 114).addBox(-5.5F, -4.5F, -0.5F, 13.0F, 9.0F, 3.0F, 0.0F, false);

		Body_r78 = new ModelRenderer(this);
		Body_r78.setPos(-6.774F, -0.2265F, -2.1281F);
		wing.addChild(Body_r78);
		setRotationAngle(Body_r78, -1.3963F, 0.0F, -0.2618F);
		Body_r78.texOffs(80, 114).addBox(-7.5F, -5.5F, -3.0F, 13.0F, 9.0F, 3.0F, 0.0F, false);

		Body_r79 = new ModelRenderer(this);
		Body_r79.setPos(-19.245F, 0.1998F, 4.7656F);
		wing.addChild(Body_r79);
		setRotationAngle(Body_r79, -1.3963F, -0.6545F, 0.0F);
		Body_r79.texOffs(80, 114).addBox(-6.5F, -4.5F, -1.0F, 13.0F, 9.0F, 4.0F, 0.0F, false);

		Body_r80 = new ModelRenderer(this);
		Body_r80.setPos(-30.8896F, -8.6508F, -3.5478F);
		wing.addChild(Body_r80);
		setRotationAngle(Body_r80, -1.3963F, 0.0F, 0.0F);
		Body_r80.texOffs(80, 114).addBox(5.1446F, -4.1502F, 8.1598F, 13.0F, 9.0F, 4.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setPos(-30.745F, -16.3552F, 22.2371F);
		Body.addChild(wing2);
		

		Body_r81 = new ModelRenderer(this);
		Body_r81.setPos(0.0F, 0.0F, 0.0F);
		wing2.addChild(Body_r81);
		setRotationAngle(Body_r81, -1.309F, 0.4363F, -0.6109F);
		Body_r81.texOffs(82, 109).addBox(2.0F, -5.5F, -6.5F, 2.0F, 9.0F, 7.0F, 0.0F, true);

		Body_r82 = new ModelRenderer(this);
		Body_r82.setPos(12.5402F, -3.1633F, 6.4215F);
		wing2.addChild(Body_r82);
		setRotationAngle(Body_r82, -1.309F, 0.3491F, -0.1309F);
		Body_r82.texOffs(82, 109).addBox(-10.5F, -4.5F, -9.0F, 3.0F, 11.0F, 7.0F, 0.0F, true);

		Body_r83 = new ModelRenderer(this);
		Body_r83.setPos(-13.0902F, -12.7751F, 9.6888F);
		wing2.addChild(Body_r83);
		setRotationAngle(Body_r83, -1.309F, 0.6981F, 0.4363F);
		Body_r83.texOffs(92, 104).addBox(-44.5F, -34.0F, -1.5F, 13.0F, 22.0F, 2.0F, 0.0F, true);
		Body_r83.texOffs(92, 107).addBox(-57.5F, -17.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r83.texOffs(92, 107).addBox(-45.5F, -13.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r83.texOffs(79, 111).addBox(-32.5F, -35.0F, -1.5F, 21.0F, 15.0F, 2.0F, 0.0F, true);
		Body_r83.texOffs(82, 114).addBox(-32.5F, -21.0F, -1.5F, 21.0F, 12.0F, 2.0F, 0.0F, true);
		Body_r83.texOffs(92, 107).addBox(-32.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, true);

		Body_r84 = new ModelRenderer(this);
		Body_r84.setPos(-49.1949F, -32.4285F, 53.9188F);
		wing2.addChild(Body_r84);
		setRotationAngle(Body_r84, -1.309F, 0.2182F, 0.4363F);
		Body_r84.texOffs(92, 107).addBox(-9.0F, -9.0F, -2.0F, 5.0F, 18.0F, 4.0F, 0.0F, true);
		Body_r84.texOffs(92, 107).addBox(-5.0F, -9.0F, -1.0F, 9.0F, 18.0F, 2.0F, 0.0F, true);

		Body_r85 = new ModelRenderer(this);
		Body_r85.setPos(-30.8949F, -29.0355F, 61.6103F);
		wing2.addChild(Body_r85);
		setRotationAngle(Body_r85, -1.0908F, 0.6981F, 0.4363F);
		Body_r85.texOffs(117, 82).addBox(-25.5F, -31.0F, -6.0F, 3.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r85.texOffs(118, 81).addBox(4.5F, -36.0F, -3.0F, 3.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r85.texOffs(114, 68).addBox(4.5F, -18.0F, -3.0F, 5.0F, 27.0F, 2.0F, 0.0F, true);
		Body_r85.texOffs(92, 107).addBox(-18.5F, -6.0F, -3.0F, 13.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r85.texOffs(92, 107).addBox(-6.5F, -9.0F, -3.0F, 13.0F, 18.0F, 2.0F, 0.0F, true);

		Body_r86 = new ModelRenderer(this);
		Body_r86.setPos(-30.8949F, -29.0355F, 61.6103F);
		wing2.addChild(Body_r86);
		setRotationAngle(Body_r86, -1.0908F, 0.6981F, 0.3054F);
		Body_r86.texOffs(114, 68).addBox(-23.5F, -16.0F, -7.0F, 5.0F, 27.0F, 2.0F, 0.0F, true);

		Body_r87 = new ModelRenderer(this);
		Body_r87.setPos(-4.5337F, -24.0903F, 53.6805F);
		wing2.addChild(Body_r87);
		setRotationAngle(Body_r87, -1.0908F, 0.9163F, 0.6109F);
		Body_r87.texOffs(115, 68).addBox(31.5F, -19.5F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);
		Body_r87.texOffs(115, 68).addBox(4.5F, -29.5F, 4.0F, 2.0F, 10.0F, 2.0F, 0.0F, true);
		Body_r87.texOffs(114, 68).addBox(30.5F, -11.5F, 1.0F, 4.0F, 12.0F, 2.0F, 0.0F, true);
		Body_r87.texOffs(114, 68).addBox(4.5F, -19.5F, 4.0F, 4.0F, 27.0F, 2.0F, 0.0F, true);

		Body_r88 = new ModelRenderer(this);
		Body_r88.setPos(-45.696F, -27.3701F, 30.2667F);
		wing2.addChild(Body_r88);
		setRotationAngle(Body_r88, -1.309F, 0.9599F, 0.4363F);
		Body_r88.texOffs(84, 108).addBox(-9.0F, -3.0F, -2.0F, 18.0F, 6.0F, 4.0F, 0.0F, true);

		Body_r89 = new ModelRenderer(this);
		Body_r89.setPos(-48.5061F, -28.6804F, 29.9796F);
		wing2.addChild(Body_r89);
		setRotationAngle(Body_r89, -1.309F, 0.6981F, 0.4363F);
		Body_r89.texOffs(80, 111).addBox(10.0F, -3.0F, -2.0F, 18.0F, 6.0F, 6.0F, 0.0F, true);

		Body_r90 = new ModelRenderer(this);
		Body_r90.setPos(-15.7126F, -13.998F, 7.9355F);
		wing2.addChild(Body_r90);
		setRotationAngle(Body_r90, -1.309F, 0.6981F, 0.4363F);
		Body_r90.texOffs(84, 108).addBox(-62.5F, -2.0F, -2.5F, 18.0F, 6.0F, 4.0F, 0.0F, true);

		Body_r91 = new ModelRenderer(this);
		Body_r91.setPos(3.6947F, -12.6587F, 33.4207F);
		wing2.addChild(Body_r91);
		setRotationAngle(Body_r91, -1.2654F, 0.9599F, 0.4363F);
		Body_r91.texOffs(45, 49).addBox(-11.5F, -4.0F, -1.5F, 23.0F, 12.0F, 3.0F, 0.0F, true);

		Body_r92 = new ModelRenderer(this);
		Body_r92.setPos(-1.5147F, -12.1939F, 22.5627F);
		wing2.addChild(Body_r92);
		setRotationAngle(Body_r92, -1.309F, 0.48F, 0.4363F);
		Body_r92.texOffs(78, 113).addBox(-12.5F, -6.0F, -1.0F, 23.0F, 12.0F, 3.0F, 0.0F, true);

		Body_r93 = new ModelRenderer(this);
		Body_r93.setPos(-7.0645F, -19.4938F, 47.0392F);
		wing2.addChild(Body_r93);
		setRotationAngle(Body_r93, -1.4399F, 0.2618F, 0.4363F);
		Body_r93.texOffs(79, 111).addBox(-10.5F, -7.5F, -1.0F, 21.0F, 8.0F, 2.0F, 0.0F, true);

		Body_r94 = new ModelRenderer(this);
		Body_r94.setPos(-12.7213F, -12.6031F, 11.5207F);
		wing2.addChild(Body_r94);
		setRotationAngle(Body_r94, -1.309F, 0.6109F, 0.4363F);
		Body_r94.texOffs(92, 107).addBox(-19.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, 0.0F, true);
		Body_r94.texOffs(92, 107).addBox(-6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 3.0F, 0.0F, true);

		Body_r95 = new ModelRenderer(this);
		Body_r95.setPos(8.4442F, -2.5962F, 7.5464F);
		wing2.addChild(Body_r95);
		setRotationAngle(Body_r95, -1.309F, 0.3491F, 0.2618F);
		Body_r95.texOffs(92, 107).addBox(-19.5F, -4.5F, -7.0F, 13.0F, 18.0F, 3.0F, 0.0F, true);
		Body_r95.texOffs(80, 114).addBox(-6.5F, -4.5F, -2.0F, 13.0F, 9.0F, 3.0F, 0.0F, true);

		Body_r96 = new ModelRenderer(this);
		Body_r96.setPos(11.7226F, -7.0934F, 13.0489F);
		wing2.addChild(Body_r96);
		setRotationAngle(Body_r96, -1.309F, 0.6981F, 0.2618F);
		Body_r96.texOffs(80, 114).addBox(-7.5F, -4.5F, -0.5F, 13.0F, 9.0F, 3.0F, 0.0F, true);

		Body_r97 = new ModelRenderer(this);
		Body_r97.setPos(6.774F, -0.2265F, -2.1281F);
		wing2.addChild(Body_r97);
		setRotationAngle(Body_r97, -1.3963F, 0.0F, 0.2618F);
		Body_r97.texOffs(80, 114).addBox(-5.5F, -5.5F, -3.0F, 13.0F, 9.0F, 3.0F, 0.0F, true);

		Body_r98 = new ModelRenderer(this);
		Body_r98.setPos(19.245F, 0.1998F, 4.7656F);
		wing2.addChild(Body_r98);
		setRotationAngle(Body_r98, -1.3963F, 0.6545F, 0.0F);
		Body_r98.texOffs(80, 114).addBox(-6.5F, -4.5F, -1.0F, 13.0F, 9.0F, 4.0F, 0.0F, true);

		Body_r99 = new ModelRenderer(this);
		Body_r99.setPos(30.8896F, -8.6508F, -3.5478F);
		wing2.addChild(Body_r99);
		setRotationAngle(Body_r99, -1.3963F, 0.0F, 0.0F);
		Body_r99.texOffs(80, 114).addBox(-18.1446F, -4.1502F, 8.1598F, 13.0F, 9.0F, 4.0F, 0.0F, true);

		innerlips = new ModelRenderer(this);
		innerlips.setPos(1.7571F, 7.3652F, -8.0848F);
		Body.addChild(innerlips);
		

		Body_r100 = new ModelRenderer(this);
		Body_r100.setPos(0.0F, 0.0F, 0.0F);
		innerlips.addChild(Body_r100);
		setRotationAngle(Body_r100, 0.1745F, 0.1745F, 2.0071F);
		Body_r100.texOffs(18, 23).addBox(-4.0F, -5.5F, -2.0F, 7.0F, 2.0F, 16.0F, 0.0F, false);

		Body_r101 = new ModelRenderer(this);
		Body_r101.setPos(4.1005F, -1.6859F, -3.8871F);
		innerlips.addChild(Body_r101);
		setRotationAngle(Body_r101, 0.1745F, -1.6144F, 0.0F);
		Body_r101.texOffs(0, 58).addBox(0.0F, 1.5F, -1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r102 = new ModelRenderer(this);
		Body_r102.setPos(14.7429F, -9.8831F, -2.1424F);
		innerlips.addChild(Body_r102);
		setRotationAngle(Body_r102, 0.1745F, -0.3927F, 0.0F);
		Body_r102.texOffs(0, 58).addBox(-10.5F, 7.0F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r102.texOffs(0, 58).addBox(-11.5F, 5.0F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r102.texOffs(0, 58).addBox(-12.5F, 2.0F, 2.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r102.texOffs(0, 58).addBox(-12.5F, -1.0F, 5.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r103 = new ModelRenderer(this);
		Body_r103.setPos(4.5766F, -9.7021F, 1.0341F);
		innerlips.addChild(Body_r103);
		setRotationAngle(Body_r103, 1.1781F, 0.0873F, -0.4363F);
		Body_r103.texOffs(18, 12).addBox(-1.5F, -5.0F, -8.5F, 1.0F, 10.0F, 13.0F, 0.0F, false);

		insestlips = new ModelRenderer(this);
		insestlips.setPos(0.0F, 0.0F, 0.0F);
		innerlips.addChild(insestlips);
		

		Body_r104 = new ModelRenderer(this);
		Body_r104.setPos(0.0F, 0.0F, 0.0F);
		insestlips.addChild(Body_r104);
		setRotationAngle(Body_r104, 0.1745F, 0.1745F, 2.0071F);
		Body_r104.texOffs(18, 23).addBox(-4.0F, -1.5F, -6.0F, 7.0F, 1.0F, 16.0F, 0.0F, false);

		Body_r105 = new ModelRenderer(this);
		Body_r105.setPos(4.1005F, -1.6859F, -3.8871F);
		insestlips.addChild(Body_r105);
		setRotationAngle(Body_r105, 0.1745F, -1.6144F, 0.0F);
		Body_r105.texOffs(0, 56).addBox(-1.0F, 3.5F, 3.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Body_r105.texOffs(0, 58).addBox(-1.0F, 1.5F, 3.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r105.texOffs(0, 56).addBox(-1.0F, -0.5F, 2.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Body_r105.texOffs(0, 56).addBox(-1.0F, -2.5F, 2.5F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		Body_r106 = new ModelRenderer(this);
		Body_r106.setPos(1.2636F, -6.2329F, -2.0091F);
		insestlips.addChild(Body_r106);
		setRotationAngle(Body_r106, 0.1745F, -1.6144F, -0.48F);
		Body_r106.texOffs(0, 56).addBox(-2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r106.texOffs(0, 56).addBox(-1.0F, -2.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body_r106.texOffs(0, 56).addBox(-1.0F, -4.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body_r106.texOffs(0, 56).addBox(0.0F, -6.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Body_r107 = new ModelRenderer(this);
		Body_r107.setPos(4.5766F, -9.7021F, 1.0341F);
		insestlips.addChild(Body_r107);
		setRotationAngle(Body_r107, 1.1781F, 0.0873F, -0.4363F);
		Body_r107.texOffs(30, 23).addBox(-4.5F, -5.0F, -5.5F, 1.0F, 10.0F, 9.0F, 0.0F, false);

		insestlips2 = new ModelRenderer(this);
		insestlips2.setPos(-3.5142F, 0.0F, 0.0F);
		innerlips.addChild(insestlips2);
		

		Body_r108 = new ModelRenderer(this);
		Body_r108.setPos(0.0F, 0.0F, 0.0F);
		insestlips2.addChild(Body_r108);
		setRotationAngle(Body_r108, 0.1745F, -0.1745F, -2.0071F);
		Body_r108.texOffs(18, 23).addBox(-3.0F, -1.5F, -6.0F, 7.0F, 1.0F, 16.0F, 0.0F, true);

		Body_r109 = new ModelRenderer(this);
		Body_r109.setPos(-4.1005F, -1.6859F, -3.8871F);
		insestlips2.addChild(Body_r109);
		setRotationAngle(Body_r109, 0.1745F, 1.6144F, 0.0F);
		Body_r109.texOffs(0, 56).addBox(-1.0F, 3.5F, 3.5F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		Body_r109.texOffs(0, 58).addBox(-1.0F, 1.5F, 3.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r109.texOffs(0, 56).addBox(-1.0F, -0.5F, 2.5F, 2.0F, 1.0F, 2.0F, 0.0F, true);
		Body_r109.texOffs(0, 56).addBox(-1.0F, -2.5F, 2.5F, 2.0F, 1.0F, 2.0F, 0.0F, true);

		Body_r110 = new ModelRenderer(this);
		Body_r110.setPos(-1.2636F, -6.2329F, -2.0091F);
		insestlips2.addChild(Body_r110);
		setRotationAngle(Body_r110, 0.1745F, 1.6144F, 0.48F);
		Body_r110.texOffs(0, 56).addBox(1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r110.texOffs(0, 56).addBox(0.0F, -2.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		Body_r110.texOffs(0, 56).addBox(0.0F, -4.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		Body_r110.texOffs(0, 56).addBox(-1.0F, -6.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		Body_r111 = new ModelRenderer(this);
		Body_r111.setPos(9.4223F, -13.2636F, 4.4968F);
		insestlips2.addChild(Body_r111);
		setRotationAngle(Body_r111, 1.0036F, -0.1309F, -0.5236F);
		Body_r111.texOffs(30, 23).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 5.0F, 0.0F, false);

		Body_r112 = new ModelRenderer(this);
		Body_r112.setPos(-4.5766F, -9.7021F, 1.0341F);
		insestlips2.addChild(Body_r112);
		setRotationAngle(Body_r112, 1.1781F, -0.0873F, 0.4363F);
		Body_r112.texOffs(38, 109).addBox(-4.5F, -7.0F, -1.5F, 1.0F, 10.0F, 9.0F, 0.0F, true);
		Body_r112.texOffs(30, 23).addBox(3.5F, -5.0F, -5.5F, 1.0F, 10.0F, 9.0F, 0.0F, true);

		innerlips2 = new ModelRenderer(this);
		innerlips2.setPos(-1.7571F, 7.3652F, -8.0848F);
		Body.addChild(innerlips2);
		

		Body_r113 = new ModelRenderer(this);
		Body_r113.setPos(0.0F, 0.0F, 0.0F);
		innerlips2.addChild(Body_r113);
		setRotationAngle(Body_r113, 0.1745F, -0.1745F, -2.0071F);
		Body_r113.texOffs(18, 23).addBox(-3.0F, -5.5F, -2.0F, 7.0F, 2.0F, 16.0F, 0.0F, true);

		Body_r114 = new ModelRenderer(this);
		Body_r114.setPos(-4.1005F, -1.6859F, -3.8871F);
		innerlips2.addChild(Body_r114);
		setRotationAngle(Body_r114, 0.1745F, 1.6144F, 0.0F);
		Body_r114.texOffs(0, 58).addBox(-2.0F, 1.5F, -1.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r115 = new ModelRenderer(this);
		Body_r115.setPos(-14.7429F, -9.8831F, -2.1424F);
		innerlips2.addChild(Body_r115);
		setRotationAngle(Body_r115, 0.1745F, 0.3927F, 0.0F);
		Body_r115.texOffs(0, 58).addBox(7.5F, 7.0F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r115.texOffs(0, 58).addBox(9.5F, 5.0F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r115.texOffs(0, 58).addBox(10.5F, 2.0F, 2.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r115.texOffs(0, 58).addBox(10.5F, -1.0F, 5.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r116 = new ModelRenderer(this);
		Body_r116.setPos(-4.5766F, -9.7021F, 1.0341F);
		innerlips2.addChild(Body_r116);
		setRotationAngle(Body_r116, 1.1781F, -0.0873F, 0.4363F);
		Body_r116.texOffs(18, 12).addBox(0.5F, -5.0F, -8.5F, 1.0F, 10.0F, 13.0F, 0.0F, true);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-17.9F, 3.0F, 22.0F);
		setRotationAngle(RightLeg, 0.3665F, 0.0F, 0.0349F);
		RightLeg.texOffs(88, 21).addBox(-3.8953F, -5.2761F, -0.8752F, 8.0F, 7.0F, 5.0F, 0.0F, false);
		RightLeg.texOffs(24, 17).addBox(-2.8953F, 6.1347F, -22.9701F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(2.4F, -15.3341F, -1.4178F);
		RightLeg.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.2182F, 0.0F, 0.1309F);
		RightArm_r1.texOffs(65, 11).addBox(-3.5F, 0.5F, -2.5F, 9.0F, 15.0F, 7.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(-3.8953F, 6.879F, -16.4792F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r1.texOffs(21, 18).addBox(3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r2 = new ModelRenderer(this);
		RightLeg_r2.setPos(-4.1715F, 5.9897F, -17.0715F);
		RightLeg.addChild(RightLeg_r2);
		setRotationAngle(RightLeg_r2, 0.6545F, 0.4363F, 0.0F);
		RightLeg_r2.texOffs(12, 104).addBox(-3.0F, 0.5F, -6.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		RightLeg_r3 = new ModelRenderer(this);
		RightLeg_r3.setPos(-3.8953F, 6.879F, -16.4792F);
		RightLeg.addChild(RightLeg_r3);
		setRotationAngle(RightLeg_r3, 0.2182F, 0.4363F, 0.0F);
		RightLeg_r3.texOffs(11, 104).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		RightLeg_r4 = new ModelRenderer(this);
		RightLeg_r4.setPos(-3.8953F, 6.6347F, -18.9701F);
		RightLeg.addChild(RightLeg_r4);
		setRotationAngle(RightLeg_r4, 0.0F, -0.3491F, 0.0F);
		RightLeg_r4.texOffs(20, 16).addBox(4.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		RightLeg_r5 = new ModelRenderer(this);
		RightLeg_r5.setPos(2.0918F, 7.5533F, -23.3601F);
		RightLeg.addChild(RightLeg_r5);
		setRotationAngle(RightLeg_r5, 0.3927F, -0.1745F, 0.0F);
		RightLeg_r5.texOffs(24, 24).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r6 = new ModelRenderer(this);
		RightLeg_r6.setPos(38.1953F, 7.5533F, -25.0884F);
		RightLeg.addChild(RightLeg_r6);
		setRotationAngle(RightLeg_r6, 0.3927F, 0.0F, 0.0F);
		RightLeg_r6.texOffs(24, 24).addBox(-0.5F, 3.5F, -0.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);
		RightLeg_r6.texOffs(24, 24).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);
		RightLeg_r6.texOffs(24, 24).addBox(-41.0906F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r7 = new ModelRenderer(this);
		RightLeg_r7.setPos(39.7075F, 5.2365F, -19.0392F);
		RightLeg.addChild(RightLeg_r7);
		setRotationAngle(RightLeg_r7, 0.3491F, -0.1745F, 0.0F);
		RightLeg_r7.texOffs(32, 121).addBox(0.0F, -0.5F, -8.0F, 1.0F, 1.0F, 4.0F, 0.0F, true);

		RightLeg_r8 = new ModelRenderer(this);
		RightLeg_r8.setPos(-3.9075F, 5.2365F, -19.0392F);
		RightLeg.addChild(RightLeg_r8);
		setRotationAngle(RightLeg_r8, 0.3491F, 0.1745F, 0.0F);
		RightLeg_r8.texOffs(32, 121).addBox(-2.0F, -0.5F, -9.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r9 = new ModelRenderer(this);
		RightLeg_r9.setPos(39.6953F, 6.6347F, -18.9701F);
		RightLeg.addChild(RightLeg_r9);
		setRotationAngle(RightLeg_r9, 0.0F, -0.1745F, 0.0F);
		RightLeg_r9.texOffs(8, 101).addBox(0.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, true);

		RightLeg_r10 = new ModelRenderer(this);
		RightLeg_r10.setPos(-3.8953F, 6.6347F, -18.9701F);
		RightLeg.addChild(RightLeg_r10);
		setRotationAngle(RightLeg_r10, 0.0F, 0.1745F, 0.0F);
		RightLeg_r10.texOffs(8, 101).addBox(-2.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		RightLeg_r11 = new ModelRenderer(this);
		RightLeg_r11.setPos(-0.8953F, 9.1672F, -5.9117F);
		RightLeg.addChild(RightLeg_r11);
		setRotationAngle(RightLeg_r11, -1.789F, 0.0F, 0.0F);
		RightLeg_r11.texOffs(87, 24).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		RightLeg_r11.texOffs(78, 115).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg_r12 = new ModelRenderer(this);
		RightLeg_r12.setPos(1.1047F, 10.5309F, 6.912F);
		RightLeg.addChild(RightLeg_r12);
		setRotationAngle(RightLeg_r12, -1.3963F, 0.0F, 0.0F);
		RightLeg_r12.texOffs(78, 114).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg_r13 = new ModelRenderer(this);
		RightLeg_r13.setPos(0.1047F, 9.3278F, -1.3001F);
		RightLeg.addChild(RightLeg_r13);
		setRotationAngle(RightLeg_r13, 0.3491F, 0.0F, 0.0F);
		RightLeg_r13.texOffs(88, 21).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, false);

		fur = new ModelRenderer(this);
		fur.setPos(0.1047F, 7.7239F, -3.8752F);
		RightLeg.addChild(fur);
		fur.texOffs(88, 21).addBox(1.0F, -11.0F, 9.0F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		rearfur_r1 = new ModelRenderer(this);
		rearfur_r1.setPos(2.5F, -2.339F, 10.3852F);
		fur.addChild(rearfur_r1);
		setRotationAngle(rearfur_r1, 0.48F, 0.0F, 0.0F);
		rearfur_r1.texOffs(88, 21).addBox(-1.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		fur2 = new ModelRenderer(this);
		fur2.setPos(-1.6453F, 9.5544F, 8.5674F);
		RightLeg.addChild(fur2);
		setRotationAngle(fur2, -0.7854F, 3.1416F, 0.2182F);
		fur2.texOffs(88, 21).addBox(-1.25F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, 0.0F, false);

		rearfur_r2 = new ModelRenderer(this);
		rearfur_r2.setPos(0.25F, 2.8305F, -0.0574F);
		fur2.addChild(rearfur_r2);
		setRotationAngle(rearfur_r2, 0.48F, 0.0F, 0.0F);
		rearfur_r2.texOffs(88, 21).addBox(-1.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		viceleft = new ModelRenderer(this);
		viceleft.setPos(0.1047F, 1.7239F, -3.8752F);
		RightLeg.addChild(viceleft);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(19.45F, 0.457F, 19.5608F);
		setRotationAngle(LeftLeg, 0.6545F, 0.0F, -0.0349F);
		LeftLeg.texOffs(18, 30).addBox(-0.8641F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r14 = new ModelRenderer(this);
		RightLeg_r14.setPos(2.9166F, 4.517F, -19.9976F);
		LeftLeg.addChild(RightLeg_r14);
		setRotationAngle(RightLeg_r14, 0.6545F, -0.4363F, 0.0F);
		RightLeg_r14.texOffs(12, 104).addBox(1.0F, 0.5F, -6.5F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		RightLeg_r15 = new ModelRenderer(this);
		RightLeg_r15.setPos(2.3453F, 9.422F, -14.04F);
		LeftLeg.addChild(RightLeg_r15);
		setRotationAngle(RightLeg_r15, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r15.texOffs(11, 104).addBox(-1.0F, -4.5F, -6.5F, 2.0F, 2.0F, 5.0F, 0.0F, true);

		RightLeg_r16 = new ModelRenderer(this);
		RightLeg_r16.setPos(3.1359F, 7.032F, -20.3604F);
		LeftLeg.addChild(RightLeg_r16);
		setRotationAngle(RightLeg_r16, 0.0F, 0.3491F, 0.0F);
		RightLeg_r16.texOffs(20, 3).addBox(-6.0F, 0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r17 = new ModelRenderer(this);
		RightLeg_r17.setPos(-1.8641F, 10.9282F, 5.5217F);
		LeftLeg.addChild(RightLeg_r17);
		setRotationAngle(RightLeg_r17, -1.3963F, 0.0F, 0.0F);
		RightLeg_r17.texOffs(79, 115).addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, true);

		RightLeg_r18 = new ModelRenderer(this);
		RightLeg_r18.setPos(-0.8641F, 9.7251F, -2.6905F);
		LeftLeg.addChild(RightLeg_r18);
		setRotationAngle(RightLeg_r18, 0.3491F, 0.0F, 0.0F);
		RightLeg_r18.texOffs(77, 116).addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, true);

		RightLeg_r19 = new ModelRenderer(this);
		RightLeg_r19.setPos(0.6359F, -8.2617F, 4.0F);
		LeftLeg.addChild(RightLeg_r19);
		setRotationAngle(RightLeg_r19, 0.0F, 0.0F, -0.48F);
		RightLeg_r19.texOffs(76, 109).addBox(-6.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, 0.0F, true);

		RightLeg_r20 = new ModelRenderer(this);
		RightLeg_r20.setPos(-0.8641F, 8.1212F, -5.2655F);
		LeftLeg.addChild(RightLeg_r20);
		setRotationAngle(RightLeg_r20, -0.2182F, 0.0F, 0.0F);
		RightLeg_r20.texOffs(81, 114).addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, 0.0F, true);

		RightLeg_r21 = new ModelRenderer(this);
		RightLeg_r21.setPos(-0.6547F, 11.7101F, -3.4726F);
		LeftLeg.addChild(RightLeg_r21);
		setRotationAngle(RightLeg_r21, -1.789F, 0.0F, 0.0F);
		RightLeg_r21.texOffs(87, 24).addBox(0.0F, 8.5F, -4.0F, 4.0F, 5.0F, 3.0F, 0.0F, true);

		RightLeg_r22 = new ModelRenderer(this);
		RightLeg_r22.setPos(-0.1547F, 7.9155F, -6.7284F);
		LeftLeg.addChild(RightLeg_r22);
		setRotationAngle(RightLeg_r22, -1.5272F, 0.0F, 0.0F);
		RightLeg_r22.texOffs(78, 115).addBox(-1.5F, -4.5F, -1.0F, 5.0F, 9.0F, 4.0F, 0.0F, true);

		fur3 = new ModelRenderer(this);
		fur3.setPos(0.0953F, 10.0974F, 7.0066F);
		LeftLeg.addChild(fur3);
		setRotationAngle(fur3, -0.7854F, -3.1416F, -0.2182F);
		fur3.texOffs(88, 21).addBox(-1.75F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, 0.0F, true);

		rearfur_r3 = new ModelRenderer(this);
		rearfur_r3.setPos(-0.25F, 2.8305F, -0.0574F);
		fur3.addChild(rearfur_r3);
		setRotationAngle(rearfur_r3, 0.48F, 0.0F, 0.0F);
		rearfur_r3.texOffs(88, 21).addBox(-0.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, 0.0F, true);

		fur4 = new ModelRenderer(this);
		fur4.setPos(4.0953F, 10.0974F, 5.0066F);
		LeftLeg.addChild(fur4);
		setRotationAngle(fur4, -0.7854F, -3.1416F, -0.5672F);
		fur4.texOffs(88, 21).addBox(-1.75F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, 0.0F, true);

		rearfur_r4 = new ModelRenderer(this);
		rearfur_r4.setPos(-0.25F, 2.8305F, -0.0574F);
		fur4.addChild(rearfur_r4);
		setRotationAngle(rearfur_r4, 0.48F, 0.0F, 0.0F);
		rearfur_r4.texOffs(102, 23).addBox(-0.5F, -3.0F, 0.0F, 2.0F, 9.0F, 1.0F, 0.0F, true);

		otherp = new ModelRenderer(this);
		otherp.setPos(-17.9F, 12.0F, 10.0F);
		

		RightLeg_r23 = new ModelRenderer(this);
		RightLeg_r23.setPos(-1.0F, -3.5F, -5.5F);
		otherp.addChild(RightLeg_r23);
		setRotationAngle(RightLeg_r23, 0.3927F, 0.0F, 0.0F);
		RightLeg_r23.texOffs(81, 116).addBox(-1.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, false);

		RightLeg_r24 = new ModelRenderer(this);
		RightLeg_r24.setPos(3.0F, 1.9959F, -5.9183F);
		otherp.addChild(RightLeg_r24);
		setRotationAngle(RightLeg_r24, -0.4363F, 0.0F, 0.0F);
		RightLeg_r24.texOffs(24, 4).addBox(-5.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg_r25 = new ModelRenderer(this);
		RightLeg_r25.setPos(-0.6946F, 11.6242F, -10.8151F);
		otherp.addChild(RightLeg_r25);
		setRotationAngle(RightLeg_r25, 0.3981F, 0.1611F, 0.0674F);
		RightLeg_r25.texOffs(18, 26).addBox(-2.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		RightLeg_r26 = new ModelRenderer(this);
		RightLeg_r26.setPos(36.525F, 8.6385F, -9.0941F);
		otherp.addChild(RightLeg_r26);
		setRotationAngle(RightLeg_r26, 0.2657F, -0.1685F, -0.0456F);
		RightLeg_r26.texOffs(18, 26).addBox(0.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		RightLeg_r27 = new ModelRenderer(this);
		RightLeg_r27.setPos(32.8F, -1.0041F, -4.9183F);
		otherp.addChild(RightLeg_r27);
		setRotationAngle(RightLeg_r27, -0.5672F, 0.0F, 0.0F);
		RightLeg_r27.texOffs(20, 4).addBox(3.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, 0.0F, true);

		RightLeg_r28 = new ModelRenderer(this);
		RightLeg_r28.setPos(36.8F, -6.5F, -4.5F);
		otherp.addChild(RightLeg_r28);
		setRotationAngle(RightLeg_r28, 0.2618F, 0.0F, 0.0F);
		RightLeg_r28.texOffs(44, 50).addBox(-4.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, true);

		tongue = new ModelRenderer(this);
		tongue.setPos(0.0F, 6.0F, 0.0F);
		tongue.texOffs(16, 26).addBox(-2.0F, -4.0F, -14.0F, 4.0F, 5.0F, 7.0F, 0.0F, false);

		Body_r117 = new ModelRenderer(this);
		Body_r117.setPos(13.8178F, 2.1211F, -38.134F);
		tongue.addChild(Body_r117);
		setRotationAngle(Body_r117, -0.2182F, -0.8727F, 0.1745F);
		Body_r117.texOffs(27, 25).addBox(-1.0F, 0.0789F, -5.5F, 2.0F, 1.0F, 11.0F, 0.0F, false);

		Body_r118 = new ModelRenderer(this);
		Body_r118.setPos(12.6373F, 1.9047F, -41.0597F);
		tongue.addChild(Body_r118);
		setRotationAngle(Body_r118, -0.2182F, -0.6109F, 0.0F);
		Body_r118.texOffs(29, 25).addBox(0.0F, -0.5F, -4.5F, 2.0F, 1.0F, 11.0F, 0.0F, false);

		Body_r119 = new ModelRenderer(this);
		Body_r119.setPos(12.6373F, 1.9047F, -41.0597F);
		tongue.addChild(Body_r119);
		setRotationAngle(Body_r119, -0.2182F, -0.3054F, 0.0F);
		Body_r119.texOffs(30, 26).addBox(-2.0F, -0.5F, -4.5F, 2.0F, 1.0F, 11.0F, 0.0F, false);

		Body_r120 = new ModelRenderer(this);
		Body_r120.setPos(0.0F, 1.9404F, -23.0117F);
		tongue.addChild(Body_r120);
		setRotationAngle(Body_r120, 0.1309F, -0.6109F, 0.0F);
		Body_r120.texOffs(17, 24).addBox(-1.0F, -1.5F, -16.5F, 4.0F, 3.0F, 11.0F, 0.0F, false);

		Body_r121 = new ModelRenderer(this);
		Body_r121.setPos(0.0F, 1.9404F, -23.0117F);
		tongue.addChild(Body_r121);
		setRotationAngle(Body_r121, 0.1309F, -0.3927F, 0.0F);
		Body_r121.texOffs(20, 23).addBox(0.0F, -2.5F, -6.5F, 4.0F, 5.0F, 11.0F, 0.0F, false);

		Body_r122 = new ModelRenderer(this);
		Body_r122.setPos(0.0F, -5.3715F, 1.4635F);
		tongue.addChild(Body_r122);
		setRotationAngle(Body_r122, 0.3491F, 0.0F, 0.0F);
		Body_r122.texOffs(16, 25).addBox(-2.0F, -4.0F, -22.0F, 4.0F, 5.0F, 7.0F, 0.0F, false);

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setPos(12.45F, 7.457F, 39.5608F);
		setRotationAngle(LeftLeg2, 0.6545F, 0.0F, -0.0349F);
		LeftLeg2.texOffs(82, 118).addBox(1.1359F, 14.1645F, 7.5029F, 2.0F, 7.0F, 1.0F, 0.0F, true);
		LeftLeg2.texOffs(18, 30).addBox(0.1359F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r29 = new ModelRenderer(this);
		RightLeg_r29.setPos(3.1359F, 7.032F, -20.3604F);
		LeftLeg2.addChild(RightLeg_r29);
		setRotationAngle(RightLeg_r29, 0.0F, 0.3491F, 0.0F);
		RightLeg_r29.texOffs(17, 29).addBox(-6.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r30 = new ModelRenderer(this);
		RightLeg_r30.setPos(3.1359F, 7.032F, -20.3604F);
		LeftLeg2.addChild(RightLeg_r30);
		setRotationAngle(RightLeg_r30, 0.0F, -0.1745F, 0.0F);
		RightLeg_r30.texOffs(18, 26).addBox(0.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, true);

		RightLeg_r31 = new ModelRenderer(this);
		RightLeg_r31.setPos(3.1359F, 7.2763F, -17.8695F);
		LeftLeg2.addChild(RightLeg_r31);
		setRotationAngle(RightLeg_r31, 0.2182F, -0.4363F, 0.0F);
		RightLeg_r31.texOffs(17, 30).addBox(1.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		RightLeg_r32 = new ModelRenderer(this);
		RightLeg_r32.setPos(0.1359F, 9.5644F, -7.3021F);
		LeftLeg2.addChild(RightLeg_r32);
		setRotationAngle(RightLeg_r32, -1.789F, 0.0F, 0.0F);
		RightLeg_r32.texOffs(91, 25).addBox(0.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, 0.0F, true);
		RightLeg_r32.texOffs(24, 0).addBox(-1.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, true);

		RightLeg_r33 = new ModelRenderer(this);
		RightLeg_r33.setPos(-1.8641F, 10.9282F, 5.5217F);
		LeftLeg2.addChild(RightLeg_r33);
		setRotationAngle(RightLeg_r33, -1.3963F, 0.0F, 0.0F);
		RightLeg_r33.texOffs(79, 115).addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, true);

		RightLeg_r34 = new ModelRenderer(this);
		RightLeg_r34.setPos(4.1359F, 1.8206F, 2.946F);
		LeftLeg2.addChild(RightLeg_r34);
		setRotationAngle(RightLeg_r34, 0.3491F, 0.0F, -0.3491F);
		RightLeg_r34.texOffs(75, 20).addBox(0.0F, -3.5F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, true);
		RightLeg_r34.texOffs(115, 76).addBox(-1.0F, -1.5F, -4.0F, 1.0F, 7.0F, 2.0F, 0.0F, true);

		RightLeg_r35 = new ModelRenderer(this);
		RightLeg_r35.setPos(-0.8641F, 9.7251F, -2.6905F);
		LeftLeg2.addChild(RightLeg_r35);
		setRotationAngle(RightLeg_r35, 0.3491F, 0.0F, 0.0F);
		RightLeg_r35.texOffs(77, 116).addBox(2.0F, 1.0F, 7.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);
		RightLeg_r35.texOffs(77, 116).addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, true);

		RightLeg_r36 = new ModelRenderer(this);
		RightLeg_r36.setPos(0.6359F, -8.2617F, 4.0F);
		LeftLeg2.addChild(RightLeg_r36);
		setRotationAngle(RightLeg_r36, 0.0F, 0.0F, -0.48F);
		RightLeg_r36.texOffs(76, 109).addBox(-6.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, 0.0F, true);

		RightLeg_r37 = new ModelRenderer(this);
		RightLeg_r37.setPos(-0.8641F, 8.1212F, -5.2655F);
		LeftLeg2.addChild(RightLeg_r37);
		setRotationAngle(RightLeg_r37, -0.2182F, 0.0F, 0.0F);
		RightLeg_r37.texOffs(81, 114).addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, 0.0F, true);

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setPos(-12.45F, 7.457F, 39.5608F);
		setRotationAngle(RightLeg2, 0.6545F, 0.0F, 0.0349F);
		RightLeg2.texOffs(18, 30).addBox(-2.1359F, 6.532F, -17.3604F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r38 = new ModelRenderer(this);
		RightLeg_r38.setPos(-3.1359F, 7.032F, -16.3604F);
		RightLeg2.addChild(RightLeg_r38);
		setRotationAngle(RightLeg_r38, 0.0F, -0.3491F, 0.0F);
		RightLeg_r38.texOffs(17, 29).addBox(4.0F, -0.5F, -2.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		RightLeg_r39 = new ModelRenderer(this);
		RightLeg_r39.setPos(28.0359F, 7.032F, -16.3604F);
		RightLeg2.addChild(RightLeg_r39);
		setRotationAngle(RightLeg_r39, 0.3927F, -0.1745F, 0.0F);
		RightLeg_r39.texOffs(39, 21).addBox(0.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);

		RightLeg_r40 = new ModelRenderer(this);
		RightLeg_r40.setPos(-3.1359F, 7.032F, -16.3604F);
		RightLeg2.addChild(RightLeg_r40);
		setRotationAngle(RightLeg_r40, 0.3927F, 0.1745F, 0.0F);
		RightLeg_r40.texOffs(39, 21).addBox(-2.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		RightLeg_r41 = new ModelRenderer(this);
		RightLeg_r41.setPos(-3.1359F, 7.032F, -16.3604F);
		RightLeg2.addChild(RightLeg_r41);
		setRotationAngle(RightLeg_r41, 0.0F, 0.1745F, 0.0F);
		RightLeg_r41.texOffs(38, 15).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		RightLeg_r42 = new ModelRenderer(this);
		RightLeg_r42.setPos(-3.1359F, 7.2763F, -13.8695F);
		RightLeg2.addChild(RightLeg_r42);
		setRotationAngle(RightLeg_r42, 0.2182F, 0.4363F, 0.0F);
		RightLeg_r42.texOffs(23, 9).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		RightLeg_r43 = new ModelRenderer(this);
		RightLeg_r43.setPos(-6.7436F, 9.9886F, -16.8739F);
		RightLeg2.addChild(RightLeg_r43);
		setRotationAngle(RightLeg_r43, 0.5236F, 0.4363F, 0.0F);
		RightLeg_r43.texOffs(23, 21).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		RightLeg_r44 = new ModelRenderer(this);
		RightLeg_r44.setPos(-0.1359F, 9.5644F, -3.3021F);
		RightLeg2.addChild(RightLeg_r44);
		setRotationAngle(RightLeg_r44, -1.789F, 0.0F, 0.0F);
		RightLeg_r44.texOffs(86, 24).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);

		RightLeg_r45 = new ModelRenderer(this);
		RightLeg_r45.setPos(-0.1359F, 9.5644F, -7.3021F);
		RightLeg2.addChild(RightLeg_r45);
		setRotationAngle(RightLeg_r45, -1.789F, 0.0F, 0.0F);
		RightLeg_r45.texOffs(21, 4).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 6.0F, 4.0F, 0.0F, false);

		RightLeg_r46 = new ModelRenderer(this);
		RightLeg_r46.setPos(1.8641F, 10.9282F, 5.5217F);
		RightLeg2.addChild(RightLeg_r46);
		setRotationAngle(RightLeg_r46, -1.3963F, 0.0F, 0.0F);
		RightLeg_r46.texOffs(79, 115).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, 0.0F, false);

		RightLeg_r47 = new ModelRenderer(this);
		RightLeg_r47.setPos(0.8641F, 9.7251F, -2.6905F);
		RightLeg2.addChild(RightLeg_r47);
		setRotationAngle(RightLeg_r47, 0.3491F, 0.0F, 0.0F);
		RightLeg_r47.texOffs(77, 116).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, 0.0F, false);

		RightLeg_r48 = new ModelRenderer(this);
		RightLeg_r48.setPos(-0.6359F, -8.2617F, 4.0F);
		RightLeg2.addChild(RightLeg_r48);
		setRotationAngle(RightLeg_r48, 0.0F, 0.0F, 0.48F);
		RightLeg_r48.texOffs(76, 109).addBox(-1.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, 0.0F, false);

		RightLeg_r49 = new ModelRenderer(this);
		RightLeg_r49.setPos(0.8641F, 8.1212F, -5.2655F);
		RightLeg2.addChild(RightLeg_r49);
		setRotationAngle(RightLeg_r49, -0.2182F, 0.0F, 0.0F);
		RightLeg_r49.texOffs(81, 114).addBox(-5.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;

		this.LeftLeg2.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.2F * limbSwingAmount;
		this.RightLeg2.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.2F * limbSwingAmount;

		this.wing.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.4F * limbSwingAmount;
		this.wing2.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.43F * limbSwingAmount;
		this.tail.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.1F * limbSwingAmount;

		this.tongue.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Head.yRot = netHeadYaw * 0.013453292F;
		this.hair_r16.xRot = netHeadYaw * 0.007453292F;
		this.hairr2.xRot = netHeadYaw * 0.007453292F;
		this.eye_r25.xRot = netHeadYaw * 0.002453292F;
		this.RightLeg_r28.xRot = netHeadYaw * 0.001453292F;
	}

//	@Override
//	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//		//previously the render function, render code was moved to a method below
//	}

//	@Override
//	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//		Head.render(matrixStack, buffer, packedLight, packedOverlay);
//		Body.render(matrixStack, buffer, packedLight, packedOverlay);
//		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
//		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
//		otherp.render(matrixStack, buffer, packedLight, packedOverlay);
//		tongue.render(matrixStack, buffer, packedLight, packedOverlay);
//		LeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
//		RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
//	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		otherp.render(matrixStack, buffer, packedLight, packedOverlay);
		tongue.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}