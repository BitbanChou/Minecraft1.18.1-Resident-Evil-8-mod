// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;

import com.joy187.re8joymod.common.entity.EntityTheHag;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelTheHag<T extends EntityTheHag> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer wand;
	private final ModelRenderer stick_r1;
	private final ModelRenderer stick_r2;
	private final ModelRenderer stick_r3;
	private final ModelRenderer skull;
	private final ModelRenderer skul_r1;
	private final ModelRenderer skull2;
	private final ModelRenderer skul_r2;
	private final ModelRenderer skul_r3;
	private final ModelRenderer heel;
	private final ModelRenderer stick_r4;
	private final ModelRenderer stick_r5;
	private final ModelRenderer stick_r6;
	private final ModelRenderer stick_r7;
	private final ModelRenderer stick_r8;
	private final ModelRenderer stick_r9;
	private final ModelRenderer stick_r10;
	private final ModelRenderer stick_r11;
	private final ModelRenderer stick_r12;
	private final ModelRenderer stick_r13;
	private final ModelRenderer heel2;
	private final ModelRenderer stick_r14;
	private final ModelRenderer stick_r15;
	private final ModelRenderer stick_r16;
	private final ModelRenderer stick_r17;
	private final ModelRenderer stick_r18;
	private final ModelRenderer stick_r19;
	private final ModelRenderer stick_r20;
	private final ModelRenderer stick_r21;
	private final ModelRenderer stick_r22;
	private final ModelRenderer stick_r23;
	private final ModelRenderer stick_r24;
	private final ModelRenderer stick_r25;
	private final ModelRenderer stick_r26;
	private final ModelRenderer stick_r27;
	private final ModelRenderer stick_r28;
	private final ModelRenderer stick_r29;
	private final ModelRenderer stick_r30;
	private final ModelRenderer stick_r31;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;

	public ModelTheHag() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -1.3465F, -2.8941F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(4, 4).addBox(-3.5F, -2.637F, -2.4195F, 6.0F, 6.0F, 5.0F, 0.0F, false);
		Head.texOffs(21, 26).addBox(-2.5F, -4.637F, -2.4195F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		Head.texOffs(15, 14).addBox(-3.0F, -3.6535F, 0.8941F, 5.0F, 7.0F, 4.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-4.0232F, 0.947F, 0.0805F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.0F, -1.4835F);
		Head_r1.texOffs(30, 25).addBox(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, true);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-3.867F, -3.0939F, 0.0805F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0F, 0.0F, -1.0908F);
		Head_r2.texOffs(32, 25).addBox(-2.0F, 0.5F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, true);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(3.0743F, 0.9001F, 0.0805F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0F, 0.0F, 1.4835F);
		Head_r3.texOffs(19, 26).addBox(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(2.9181F, -3.1408F, 0.0805F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.0F, 0.0F, 1.0908F);
		Head_r4.texOffs(19, 26).addBox(-2.0F, 0.5F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 14).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 11.0F, 5.0F, 0.0F, false);
		Body.texOffs(24, 17).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 11.0F, 7.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-5.0F, 2.0F, 1.0F);
		setRotationAngle(RightArm, 0.1309F, 0.0F, 0.3927F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-1.4163F, 6.9677F, -3.4797F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 1.3606F, 0.0522F, 0.3011F);
		RightArm_r1.texOffs(6, 47).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-0.9238F, 3.9865F, -1.8165F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, 2.1023F, 0.0522F, 0.3011F);
		RightArm_r2.texOffs(22, 54).addBox(-0.5F, -2.5F, -3.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-1.483F, 6.1036F, -0.0241F);
		RightArm.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -0.1666F, 0.0522F, 0.3011F);
		RightArm_r3.texOffs(5, 45).addBox(-0.5F, -3.5F, -1.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-0.5F, 1.0F, 0.5F);
		RightArm.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, 0.0F, 0.0F, 0.2182F);
		RightArm_r4.texOffs(0, 41).addBox(-0.2F, -3.0F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		wand = new ModelRenderer(this);
		wand.setPos(-0.9238F, 3.9865F, -1.8165F);
		RightArm.addChild(wand);
		

		stick_r1 = new ModelRenderer(this);
		stick_r1.setPos(4.1681F, 11.2622F, -1.9253F);
		wand.addChild(stick_r1);
		setRotationAngle(stick_r1, 3.1416F, 0.5672F, 2.7489F);
		stick_r1.texOffs(22, 54).addBox(-0.5F, 1.5F, -0.2583F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		stick_r1.texOffs(24, 49).addBox(-0.5F, -3.5F, -1.2583F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		stick_r2 = new ModelRenderer(this);
		stick_r2.setPos(-4.4384F, -7.9031F, -1.5F);
		wand.addChild(stick_r2);
		setRotationAngle(stick_r2, 0.0F, -0.3491F, -0.3927F);
		stick_r2.texOffs(39, 27).addBox(-0.3F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		stick_r3 = new ModelRenderer(this);
		stick_r3.setPos(0.0F, 0.0F, 0.0F);
		wand.addChild(stick_r3);
		setRotationAngle(stick_r3, 0.0F, 0.0F, -0.3927F);
		stick_r3.texOffs(41, 25).addBox(-2.0762F, -5.5F, -2.5F, 3.0F, 7.0F, 2.0F, 0.0F, false);
		stick_r3.texOffs(26, 51).addBox(-1.5F, 1.5F, -2.5F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		skull = new ModelRenderer(this);
		skull.setPos(-4.4384F, -7.9031F, -1.5F);
		wand.addChild(skull);
		

		skul_r1 = new ModelRenderer(this);
		skul_r1.setPos(0.0F, 0.0F, 0.0F);
		skull.addChild(skul_r1);
		setRotationAngle(skul_r1, 0.0F, -0.3491F, -0.3927F);
		skul_r1.texOffs(0, 36).addBox(-3.3F, 0.5F, -1.3835F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		skul_r1.texOffs(0, 49).addBox(-3.3F, -2.5F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		skull2 = new ModelRenderer(this);
		skull2.setPos(-4.4384F, -10.9031F, -1.5F);
		wand.addChild(skull2);
		setRotationAngle(skull2, -1.3867F, -0.7769F, 1.441F);
		

		skul_r2 = new ModelRenderer(this);
		skul_r2.setPos(0.0F, 0.0F, 0.0F);
		skull2.addChild(skul_r2);
		setRotationAngle(skul_r2, -0.1238F, -0.3272F, -0.0232F);
		skul_r2.texOffs(6, 24).addBox(-2.3F, 0.5F, -1.3835F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		skul_r3 = new ModelRenderer(this);
		skul_r3.setPos(0.0F, 0.0F, 0.0F);
		skull2.addChild(skul_r3);
		setRotationAngle(skul_r3, 0.0F, -0.3491F, -0.3927F);
		skul_r3.texOffs(48, 16).addBox(-3.3F, -2.5F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		skul_r3.texOffs(0, 36).addBox(-3.3F, -0.5F, -2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		heel = new ModelRenderer(this);
		heel.setPos(4.1681F, 11.2622F, -1.9253F);
		wand.addChild(heel);
		

		stick_r4 = new ModelRenderer(this);
		stick_r4.setPos(-7.063F, -27.7242F, 2.3251F);
		heel.addChild(stick_r4);
		setRotationAngle(stick_r4, 0.0275F, -0.9009F, -0.446F);
		stick_r4.texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r5 = new ModelRenderer(this);
		stick_r5.setPos(-8.0976F, -28.0918F, 2.9387F);
		heel.addChild(stick_r5);
		setRotationAngle(stick_r5, 0.2893F, -0.9009F, -0.446F);
		stick_r5.texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r6 = new ModelRenderer(this);
		stick_r6.setPos(-8.211F, -28.2846F, 2.9538F);
		heel.addChild(stick_r6);
		setRotationAngle(stick_r6, 0.5075F, -0.9009F, -0.446F);
		stick_r6.texOffs(3, 40).addBox(-2.5F, -0.5F, -1.9F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		stick_r7 = new ModelRenderer(this);
		stick_r7.setPos(-8.211F, -28.2846F, 2.9538F);
		heel.addChild(stick_r7);
		setRotationAngle(stick_r7, -1.6136F, -1.3134F, 0.8117F);
		stick_r7.texOffs(3, 40).addBox(0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r8 = new ModelRenderer(this);
		stick_r8.setPos(-8.211F, -28.2846F, 2.9538F);
		heel.addChild(stick_r8);
		setRotationAngle(stick_r8, -1.5888F, -0.9209F, 0.7846F);
		stick_r8.texOffs(3, 40).addBox(-0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		stick_r8.texOffs(3, 40).addBox(-0.5F, -0.8F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r9 = new ModelRenderer(this);
		stick_r9.setPos(-8.0551F, -28.2721F, 2.8184F);
		heel.addChild(stick_r9);
		setRotationAngle(stick_r9, -0.2857F, 0.5349F, -0.1984F);
		stick_r9.texOffs(3, 40).addBox(-0.8F, -3.5F, -0.0767F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		stick_r10 = new ModelRenderer(this);
		stick_r10.setPos(-8.0551F, -28.2721F, 2.8184F);
		heel.addChild(stick_r10);
		setRotationAngle(stick_r10, -0.3766F, -0.8509F, 0.2393F);
		stick_r10.texOffs(3, 40).addBox(-0.5F, -5.5F, 0.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r11 = new ModelRenderer(this);
		stick_r11.setPos(-8.0551F, -28.2721F, 2.8184F);
		heel.addChild(stick_r11);
		setRotationAngle(stick_r11, -0.5512F, -0.8509F, 0.2393F);
		stick_r11.texOffs(3, 40).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r12 = new ModelRenderer(this);
		stick_r12.setPos(-8.211F, -28.2846F, 2.9538F);
		heel.addChild(stick_r12);
		setRotationAngle(stick_r12, -0.3766F, -0.8509F, 0.2393F);
		stick_r12.texOffs(3, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r13 = new ModelRenderer(this);
		stick_r13.setPos(-8.6066F, -19.1653F, 0.4253F);
		heel.addChild(stick_r13);
		setRotationAngle(stick_r13, -0.1202F, -0.9051F, -0.0926F);
		stick_r13.texOffs(3, 40).addBox(0.7F, -6.5F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		heel2 = new ModelRenderer(this);
		heel2.setPos(-5.8319F, -9.7378F, 1.0747F);
		wand.addChild(heel2);
		setRotationAngle(heel2, 2.7762F, 0.7704F, 1.8391F);
		

		stick_r14 = new ModelRenderer(this);
		stick_r14.setPos(1.937F, -6.7242F, 2.3251F);
		heel2.addChild(stick_r14);
		setRotationAngle(stick_r14, 0.0275F, -0.9009F, -0.446F);
		stick_r14.texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r15 = new ModelRenderer(this);
		stick_r15.setPos(0.9024F, -7.0918F, 2.9387F);
		heel2.addChild(stick_r15);
		setRotationAngle(stick_r15, 0.2893F, -0.9009F, -0.446F);
		stick_r15.texOffs(3, 40).addBox(-2.5F, -4.5F, -0.9F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r16 = new ModelRenderer(this);
		stick_r16.setPos(0.789F, -7.2846F, 2.9538F);
		heel2.addChild(stick_r16);
		setRotationAngle(stick_r16, 0.5075F, -0.9009F, -0.446F);
		stick_r16.texOffs(3, 40).addBox(-2.5F, -0.5F, -1.9F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		stick_r17 = new ModelRenderer(this);
		stick_r17.setPos(0.789F, -7.2846F, 2.9538F);
		heel2.addChild(stick_r17);
		setRotationAngle(stick_r17, -1.6136F, -1.3134F, 0.8117F);
		stick_r17.texOffs(3, 40).addBox(0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r18 = new ModelRenderer(this);
		stick_r18.setPos(0.789F, -7.2846F, 2.9538F);
		heel2.addChild(stick_r18);
		setRotationAngle(stick_r18, -1.5888F, -0.9209F, 0.7846F);
		stick_r18.texOffs(3, 40).addBox(-0.5F, -2.8F, 0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		stick_r18.texOffs(3, 40).addBox(-0.5F, -0.8F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r19 = new ModelRenderer(this);
		stick_r19.setPos(0.9449F, -7.2721F, 2.8184F);
		heel2.addChild(stick_r19);
		setRotationAngle(stick_r19, -0.2857F, 0.5349F, -0.1984F);
		stick_r19.texOffs(3, 40).addBox(-0.8F, -3.5F, -0.0767F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		stick_r20 = new ModelRenderer(this);
		stick_r20.setPos(0.9449F, -7.2721F, 2.8184F);
		heel2.addChild(stick_r20);
		setRotationAngle(stick_r20, -0.3766F, -0.8509F, 0.2393F);
		stick_r20.texOffs(3, 40).addBox(-0.5F, -5.5F, 0.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r21 = new ModelRenderer(this);
		stick_r21.setPos(0.9449F, -7.2721F, 2.8184F);
		heel2.addChild(stick_r21);
		setRotationAngle(stick_r21, -0.5512F, -0.8509F, 0.2393F);
		stick_r21.texOffs(3, 40).addBox(-0.5F, -5.5F, -0.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);

		stick_r22 = new ModelRenderer(this);
		stick_r22.setPos(0.789F, -7.2846F, 2.9538F);
		heel2.addChild(stick_r22);
		setRotationAngle(stick_r22, -0.3766F, -0.8509F, 0.2393F);
		stick_r22.texOffs(3, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r23 = new ModelRenderer(this);
		stick_r23.setPos(3.3352F, -2.9208F, -2.0855F);
		heel2.addChild(stick_r23);
		setRotationAngle(stick_r23, -2.7535F, 0.7045F, -1.1018F);
		stick_r23.texOffs(42, 0).addBox(-1.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r24 = new ModelRenderer(this);
		stick_r24.setPos(4.8935F, -3.7575F, -0.379F);
		heel2.addChild(stick_r24);
		setRotationAngle(stick_r24, 2.0531F, 0.3243F, -1.3505F);
		stick_r24.texOffs(19, 6).addBox(0.0F, -3.5F, -0.1793F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r25 = new ModelRenderer(this);
		stick_r25.setPos(5.806F, -2.8645F, -2.3852F);
		heel2.addChild(stick_r25);
		setRotationAngle(stick_r25, -3.1101F, 1.3383F, 0.2339F);
		stick_r25.texOffs(19, 4).addBox(-2.0F, -2.5F, 3.8207F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r26 = new ModelRenderer(this);
		stick_r26.setPos(4.8935F, -3.7575F, -0.379F);
		heel2.addChild(stick_r26);
		setRotationAngle(stick_r26, 1.8386F, 0.5153F, -1.2349F);
		stick_r26.texOffs(19, 4).addBox(0.0F, -3.5F, 0.8207F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stick_r27 = new ModelRenderer(this);
		stick_r27.setPos(4.8935F, -3.7575F, -0.379F);
		heel2.addChild(stick_r27);
		setRotationAngle(stick_r27, 2.0568F, 0.5153F, -1.2349F);
		stick_r27.texOffs(19, 3).addBox(0.0F, -4.5F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		stick_r28 = new ModelRenderer(this);
		stick_r28.setPos(4.8935F, -3.7575F, -0.379F);
		heel2.addChild(stick_r28);
		setRotationAngle(stick_r28, 2.1335F, 0.7045F, -1.1018F);
		stick_r28.texOffs(55, 8).addBox(-1.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r29 = new ModelRenderer(this);
		stick_r29.setPos(-1.753F, -1.7078F, -3.439F);
		heel2.addChild(stick_r29);
		setRotationAngle(stick_r29, -2.7971F, 0.7045F, -1.1018F);
		stick_r29.texOffs(55, 9).addBox(0.7F, -6.5F, -6.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r30 = new ModelRenderer(this);
		stick_r30.setPos(6.2429F, -0.1877F, -0.7827F);
		heel2.addChild(stick_r30);
		setRotationAngle(stick_r30, -1.0518F, 0.7045F, -1.1018F);
		stick_r30.texOffs(56, 8).addBox(0.7F, -6.5F, -6.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		stick_r31 = new ModelRenderer(this);
		stick_r31.setPos(0.3934F, 1.8347F, 0.4253F);
		heel2.addChild(stick_r31);
		setRotationAngle(stick_r31, -0.1202F, -0.9051F, -0.0926F);
		stick_r31.texOffs(3, 40).addBox(0.7F, -6.5F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(5.0F, 3.0F, 0.0F);
		setRotationAngle(LeftArm, 0.1724F, 0.1195F, -0.6005F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.1441F, 4.4529F, -5.4533F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -2.137F, 0.51F, -0.9634F);
		LeftArm_r1.texOffs(44, 58).addBox(-1.0F, 1.5F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(0.6005F, 4.7553F, -4.9416F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -1.5116F, 0.7409F, 0.0399F);
		LeftArm_r2.texOffs(41, 53).addBox(0.0F, 1.5F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		LeftArm_r2.texOffs(40, 59).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(-1.5F, 3.0562F, 0.6078F);
		LeftArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -0.9163F, 0.0F, 0.0F);
		LeftArm_r3.texOffs(33, 51).addBox(0.5F, -1.2812F, -3.4483F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.5F, 3.0219F, -0.2921F);
		LeftArm.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.0873F, 0.0F, 0.0F);
		LeftArm_r4.texOffs(12, 22).addBox(-1.5F, -5.9776F, -1.1344F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 16.0F, 0.0F);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(1.7604F, 0.5767F, -0.8652F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.1745F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(45, 38).addBox(-3.0F, 7.0F, -2.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightLeg_r1.texOffs(45, 32).addBox(-3.4F, 0.0F, -1.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(1.9F, 16.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.5236F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.616F, 5.7689F, -0.3772F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.5672F, 0.0F, 0.0F);
		Leftll_r1.texOffs(45, 38).addBox(-2.7F, 2.0F, 0.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Leftll_r1.texOffs(44, 21).addBox(-3.1F, -5.0F, 1.5F, 3.0F, 8.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.6F * limbSwingAmount;

		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 0.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.3F * limbSwingAmount;

		this.Head.yRot = netHeadYaw * 0.007453292F;
		this.Head.xRot = headPitch * 0.007453292F;
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