// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.joy187.re8joymod.common.entity.model;


import com.joy187.re8joymod.common.entity.EntityFrank6;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelFrank6<T extends EntityFrank6> extends EntityModel<T> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2;
	private final ModelRenderer RightArm_r3;
	private final ModelRenderer RightArm_r4;
	private final ModelRenderer RightArm_r5;
	private final ModelRenderer knife;
	private final ModelRenderer RightArm_r6;
	private final ModelRenderer RightArm_r7;
	private final ModelRenderer RightArm_r8;
	private final ModelRenderer RightArm_r9;
	private final ModelRenderer RightArm_r10;
	private final ModelRenderer RightArm_r11;
	private final ModelRenderer RightArm_r12;
	private final ModelRenderer RightArm_r13;
	private final ModelRenderer RightArm_r14;
	private final ModelRenderer RightArm_r15;
	private final ModelRenderer RightArm_r16;
	private final ModelRenderer RightArm_r17;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer LeftArm_r5;
	private final ModelRenderer knife2;
	private final ModelRenderer RightArm_r18;
	private final ModelRenderer RightArm_r19;
	private final ModelRenderer RightArm_r20;
	private final ModelRenderer RightArm_r21;
	private final ModelRenderer RightArm_r22;
	private final ModelRenderer RightArm_r23;
	private final ModelRenderer RightArm_r24;
	private final ModelRenderer RightArm_r25;
	private final ModelRenderer RightArm_r26;
	private final ModelRenderer RightArm_r27;
	private final ModelRenderer RightArm_r28;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightll_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftll_r1;
	private final ModelRenderer LeftLeg_r1;

	public ModelFrank6() {
		texWidth = 64;
		texHeight = 64;

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -6.3465F, 0.1059F);
		setRotationAngle(Head, -0.1047F, 0.0873F, 0.0F);
		Head.texOffs(1, 0).addBox(-3.5F, -6.6261F, -4.6285F, 8.0F, 8.0F, 7.0F, 0.0F, false);
		Head.texOffs(38, 9).addBox(-1.0F, -1.6261F, -2.6285F, 2.0F, 5.0F, 3.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setPos(-3.0982F, -4.5124F, 2.5869F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.5708F, 0.0436F, 0.0F);
		Head_r1.texOffs(20, 24).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setPos(-3.7132F, -6.6675F, 0.0419F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 1.5708F, 0.0F, -0.6109F);
		Head_r2.texOffs(37, 48).addBox(-1.0F, -4.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setPos(3.5F, 1.9229F, -4.9581F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 1.789F, -0.2618F, -0.48F);
		Head_r3.texOffs(3, 27).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setPos(-3.5F, 2.8037F, -5.2609F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 1.6144F, 0.4363F, 0.5236F);
		Head_r4.texOffs(4, 28).addBox(-0.313F, 0.6706F, -0.3718F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setPos(0.5F, -5.1261F, -5.1285F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.0F, 0.0F, -0.1745F);
		Head_r5.texOffs(0, 50).addBox(-4.0F, -1.5F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 0.0F, 0.0F);
		Body.texOffs(15, 14).addBox(-4.0F, -5.0F, -4.0F, 9.0F, 14.0F, 6.0F, 0.0F, false);
		Body.texOffs(25, 17).addBox(-3.0F, -4.0F, 2.0F, 7.0F, 8.0F, 3.0F, 0.0F, false);
		Body.texOffs(34, 25).addBox(-4.5F, 4.0F, 1.0F, 10.0F, 9.0F, 2.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setPos(0.5F, 0.5F, -5.0F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, -0.2182F, -0.2182F);
		Body_r1.texOffs(39, 55).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setPos(5.5F, -4.0F, -1.0F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.0F, -0.2618F);
		Body_r2.texOffs(15, 14).addBox(-2.5F, -1.0F, -2.0F, 7.0F, 4.0F, 5.0F, 0.0F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setPos(-5.5F, -4.0F, -1.0F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, 0.2618F);
		Body_r3.texOffs(15, 14).addBox(-3.5F, -1.0F, -2.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setPos(-6.0F, 2.0F, 0.0F);
		

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setPos(-3.5F, 1.0162F, -13.3755F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -1.3963F, -0.2618F, -0.3927F);
		RightArm_r1.texOffs(23, 22).addBox(3.5F, -0.5F, 4.55F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		RightArm_r1.texOffs(21, 23).addBox(3.0F, -6.5F, 3.95F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightArm_r2 = new ModelRenderer(this);
		RightArm_r2.setPos(-3.5F, 1.0162F, -13.3755F);
		RightArm.addChild(RightArm_r2);
		setRotationAngle(RightArm_r2, -1.8762F, 0.0F, -0.1309F);
		RightArm_r2.texOffs(23, 22).addBox(-0.5F, -0.5F, 0.55F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		RightArm_r2.texOffs(0, 36).addBox(-1.0F, -6.5F, -0.05F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightArm_r3 = new ModelRenderer(this);
		RightArm_r3.setPos(-0.5F, 4.7091F, 1.2678F);
		RightArm.addChild(RightArm_r3);
		setRotationAngle(RightArm_r3, -1.5708F, 0.0F, 0.0F);
		RightArm_r3.texOffs(27, 60).addBox(-1.5F, 15.5F, -0.2F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightArm_r3.texOffs(0, 36).addBox(-2.0F, 9.5F, -0.8F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		RightArm_r3.texOffs(0, 36).addBox(-2.5F, 2.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightArm_r4 = new ModelRenderer(this);
		RightArm_r4.setPos(-0.6357F, 1.9626F, -0.9466F);
		RightArm.addChild(RightArm_r4);
		setRotationAngle(RightArm_r4, -0.48F, 0.0F, 0.0F);
		RightArm_r4.texOffs(0, 36).addBox(-2.5F, -3.5F, -2.5F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		RightArm_r5 = new ModelRenderer(this);
		RightArm_r5.setPos(-0.5F, -1.0F, 0.5F);
		RightArm.addChild(RightArm_r5);
		setRotationAngle(RightArm_r5, 0.0F, 0.0F, 0.1745F);
		RightArm_r5.texOffs(0, 44).addBox(-2.5F, -4.0F, -2.5F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		knife = new ModelRenderer(this);
		knife.setPos(-1.6786F, 8.2577F, -6.9476F);
		RightArm.addChild(knife);
		setRotationAngle(knife, 3.0543F, -1.6144F, 0.1309F);
		

		RightArm_r6 = new ModelRenderer(this);
		RightArm_r6.setPos(0.3916F, -6.6013F, -0.5854F);
		knife.addChild(RightArm_r6);
		setRotationAngle(RightArm_r6, 1.0472F, 0.0F, 0.0F);
		RightArm_r6.texOffs(22, 59).addBox(-0.8802F, 1.9109F, -11.8497F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r7 = new ModelRenderer(this);
		RightArm_r7.setPos(0.3916F, -3.7813F, 0.7669F);
		knife.addChild(RightArm_r7);
		setRotationAngle(RightArm_r7, 0.1309F, 0.0F, 0.0F);
		RightArm_r7.texOffs(22, 59).addBox(-0.8802F, 4.4185F, -4.2353F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r8 = new ModelRenderer(this);
		RightArm_r8.setPos(0.3916F, -4.1893F, 0.507F);
		knife.addChild(RightArm_r8);
		setRotationAngle(RightArm_r8, -0.5672F, 0.0F, 0.0F);
		RightArm_r8.texOffs(22, 59).addBox(-0.8802F, 3.7404F, 3.0983F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		RightArm_r9 = new ModelRenderer(this);
		RightArm_r9.setPos(0.3916F, -2.7934F, 0.5466F);
		knife.addChild(RightArm_r9);
		setRotationAngle(RightArm_r9, -1.0036F, 0.0F, 0.0F);
		RightArm_r9.texOffs(21, 60).addBox(-0.8802F, 5.245F, 1.6469F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r9.texOffs(21, 60).addBox(-0.8802F, 1.245F, 2.6469F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r10 = new ModelRenderer(this);
		RightArm_r10.setPos(0.3916F, -2.7934F, 0.5466F);
		knife.addChild(RightArm_r10);
		setRotationAngle(RightArm_r10, -0.6981F, 0.0F, 0.0F);
		RightArm_r10.texOffs(21, 60).addBox(-0.8802F, 1.365F, 4.6296F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r11 = new ModelRenderer(this);
		RightArm_r11.setPos(0.3916F, -2.7934F, 0.5466F);
		knife.addChild(RightArm_r11);
		setRotationAngle(RightArm_r11, -0.48F, 0.0F, 0.0F);
		RightArm_r11.texOffs(21, 60).addBox(-0.8802F, 2.9507F, 3.7188F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm_r12 = new ModelRenderer(this);
		RightArm_r12.setPos(0.3916F, -2.7498F, -0.4525F);
		knife.addChild(RightArm_r12);
		setRotationAngle(RightArm_r12, -0.1745F, 0.0F, 0.0F);
		RightArm_r12.texOffs(21, 60).addBox(-0.8802F, 8.412F, 0.2778F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r12.texOffs(21, 60).addBox(-0.8802F, 8.412F, -1.7222F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r13 = new ModelRenderer(this);
		RightArm_r13.setPos(0.3916F, -2.7498F, -0.4525F);
		knife.addChild(RightArm_r13);
		setRotationAngle(RightArm_r13, 0.5236F, 0.0F, 0.0F);
		RightArm_r13.texOffs(21, 60).addBox(-0.8802F, 2.7627F, -5.0615F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r14 = new ModelRenderer(this);
		RightArm_r14.setPos(0.3916F, -0.9698F, 4.63F);
		knife.addChild(RightArm_r14);
		setRotationAngle(RightArm_r14, 0.0436F, 0.0F, 0.0F);
		RightArm_r14.texOffs(21, 60).addBox(-0.8802F, 1.4639F, -5.8038F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightArm_r14.texOffs(21, 54).addBox(-3.8802F, 3.4639F, -6.8038F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		RightArm_r14.texOffs(21, 54).addBox(-0.8802F, 4.4639F, -8.8038F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		RightArm_r15 = new ModelRenderer(this);
		RightArm_r15.setPos(-5.0F, 1.244F, 0.157F);
		knife.addChild(RightArm_r15);
		setRotationAngle(RightArm_r15, -1.0908F, 0.0F, 0.0F);
		RightArm_r15.texOffs(21, 54).addBox(-0.4886F, -0.0002F, 0.2321F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		RightArm_r16 = new ModelRenderer(this);
		RightArm_r16.setPos(-3.0F, 2.744F, -0.843F);
		knife.addChild(RightArm_r16);
		setRotationAngle(RightArm_r16, -1.5708F, 0.0F, 0.0F);
		RightArm_r16.texOffs(21, 54).addBox(-0.4886F, -1.913F, -2.0019F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		RightArm_r17 = new ModelRenderer(this);
		RightArm_r17.setPos(-6.0F, 1.7013F, 0.1125F);
		knife.addChild(RightArm_r17);
		setRotationAngle(RightArm_r17, 0.5672F, 0.0F, 0.0F);
		RightArm_r17.texOffs(21, 54).addBox(-0.4886F, 0.6384F, -3.1469F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setPos(7.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, 0.0F);
		

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setPos(1.0F, 4.981F, -7.4918F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.537F, -0.2985F, 0.0655F);
		LeftArm_r1.texOffs(24, 24).addBox(1.5F, 1.2496F, -0.9681F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm_r1.texOffs(33, 51).addBox(1.0F, 0.2496F, -1.9681F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setPos(1.0F, 4.981F, -7.4918F);
		LeftArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -1.5272F, 0.0F, 0.0F);
		LeftArm_r2.texOffs(24, 26).addBox(-0.5F, 0.9992F, -1.9363F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm_r2.texOffs(33, 51).addBox(-1.0F, -0.0008F, -2.9363F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftArm_r2.texOffs(33, 51).addBox(-2.0F, -4.0008F, -3.4363F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setPos(1.0F, 1.0702F, -8.1623F);
		LeftArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, -1.4399F, -0.2618F, 0.0F);
		LeftArm_r3.texOffs(33, 51).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setPos(0.1481F, 2.9215F, 0.7873F);
		LeftArm.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, -0.9163F, 0.0F, 0.0F);
		LeftArm_r4.texOffs(33, 51).addBox(-1.5F, -2.802F, -4.7472F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setPos(0.5F, 4.0F, -0.5F);
		LeftArm.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.0873F, 0.0F, -0.1745F);
		LeftArm_r5.texOffs(12, 22).addBox(-1.1603F, -8.9331F, -1.8881F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		knife2 = new ModelRenderer(this);
		knife2.setPos(4.3577F, 8.1394F, -7.01F);
		LeftArm.addChild(knife2);
		setRotationAngle(knife2, -2.7489F, 1.6144F, -3.0107F);
		

		RightArm_r18 = new ModelRenderer(this);
		RightArm_r18.setPos(1.6951F, -11.9346F, -2.9047F);
		knife2.addChild(RightArm_r18);
		setRotationAngle(RightArm_r18, 1.0472F, 0.0F, 0.0F);
		RightArm_r18.texOffs(22, 59).addBox(-1.3181F, 2.4991F, -8.1838F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r19 = new ModelRenderer(this);
		RightArm_r19.setPos(1.6951F, -9.1146F, -1.5524F);
		knife2.addChild(RightArm_r19);
		setRotationAngle(RightArm_r19, 0.1309F, 0.0F, 0.0F);
		RightArm_r19.texOffs(22, 59).addBox(-1.3181F, 1.6507F, -3.1237F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r20 = new ModelRenderer(this);
		RightArm_r20.setPos(1.6951F, -9.5225F, -1.8123F);
		knife2.addChild(RightArm_r20);
		setRotationAngle(RightArm_r20, -0.5672F, 0.0F, 0.0F);
		RightArm_r20.texOffs(22, 59).addBox(0.6819F, 2.1396F, 1.5279F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightArm_r21 = new ModelRenderer(this);
		RightArm_r21.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r21);
		setRotationAngle(RightArm_r21, -1.0036F, 0.0F, 0.0F);
		RightArm_r21.texOffs(21, 60).addBox(-1.3181F, 2.6452F, -1.2981F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm_r21.texOffs(21, 60).addBox(-1.3181F, 0.6452F, -0.2981F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r22 = new ModelRenderer(this);
		RightArm_r22.setPos(3.8609F, -7.4915F, -0.7731F);
		knife2.addChild(RightArm_r22);
		setRotationAngle(RightArm_r22, -0.2182F, -0.1745F, 0.0F);
		RightArm_r22.texOffs(21, 60).addBox(-2.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r23 = new ModelRenderer(this);
		RightArm_r23.setPos(3.8399F, -7.5007F, 2.3799F);
		knife2.addChild(RightArm_r23);
		setRotationAngle(RightArm_r23, -1.0823F, -0.2843F, 0.0918F);
		RightArm_r23.texOffs(21, 60).addBox(0.9816F, 3.0216F, 2.8282F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r24 = new ModelRenderer(this);
		RightArm_r24.setPos(3.679F, -8.3489F, 0.0125F);
		knife2.addChild(RightArm_r24);
		setRotationAngle(RightArm_r24, -1.0036F, 0.0F, 0.0F);
		RightArm_r24.texOffs(21, 60).addBox(0.6819F, 3.6452F, 0.7019F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r25 = new ModelRenderer(this);
		RightArm_r25.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r25);
		setRotationAngle(RightArm_r25, -0.6981F, 0.0F, 0.0F);
		RightArm_r25.texOffs(21, 60).addBox(-0.3181F, -0.0001F, 1.6026F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r26 = new ModelRenderer(this);
		RightArm_r26.setPos(1.6951F, -8.1267F, -1.7728F);
		knife2.addChild(RightArm_r26);
		setRotationAngle(RightArm_r26, -0.48F, 0.0F, 0.0F);
		RightArm_r26.texOffs(21, 60).addBox(-1.3181F, 0.2267F, 2.4683F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		RightArm_r27 = new ModelRenderer(this);
		RightArm_r27.setPos(1.6951F, -8.083F, -2.7718F);
		knife2.addChild(RightArm_r27);
		setRotationAngle(RightArm_r27, 0.5236F, 0.0F, 0.0F);
		RightArm_r27.texOffs(21, 60).addBox(-1.3181F, 0.7071F, -2.5927F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm_r28 = new ModelRenderer(this);
		RightArm_r28.setPos(1.6951F, -6.303F, 2.3107F);
		knife2.addChild(RightArm_r28);
		setRotationAngle(RightArm_r28, 0.0436F, 0.0F, 0.0F);
		RightArm_r28.texOffs(21, 60).addBox(-1.3181F, -0.3865F, -5.0248F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setPos(-1.9F, 12.0F, -1.0F);
		setRotationAngle(RightLeg, -0.2007F, 0.0F, 0.0349F);
		

		Rightll_r1 = new ModelRenderer(this);
		Rightll_r1.setPos(2.6966F, 11.2769F, -0.5927F);
		RightLeg.addChild(Rightll_r1);
		setRotationAngle(Rightll_r1, -0.1309F, 0.0F, 0.0F);
		Rightll_r1.texOffs(17, 49).addBox(-4.9F, -15.0F, -4.0F, 5.0F, 8.0F, 5.0F, 0.0F, false);

		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setPos(2.1966F, 3.466F, 0.34F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0873F, 0.0F, 0.0F);
		RightLeg_r1.texOffs(45, 32).addBox(-4.4F, 0.0F, -4.0F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setPos(2.9F, 12.0F, -1.0F);
		setRotationAngle(LeftLeg, -0.2618F, 0.0F, -0.0349F);
		

		Leftll_r1 = new ModelRenderer(this);
		Leftll_r1.setPos(1.3034F, 8.4945F, 1.7722F);
		LeftLeg.addChild(Leftll_r1);
		setRotationAngle(Leftll_r1, 0.829F, 0.0F, 0.0F);
		Leftll_r1.texOffs(44, 21).addBox(-3.1F, -4.0F, 1.5F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setPos(-0.7966F, 2.7637F, 0.7329F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.3491F, 0.0F, 0.0F);
		LeftLeg_r1.texOffs(42, 23).addBox(-2.0F, -5.5F, -1.5F, 5.0F, 7.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
		this.LeftLeg.xRot = MathHelper.cos(limbSwing * 0.5662F) * 1.4F * limbSwingAmount;
		this.RightLeg.xRot = MathHelper.cos(limbSwing * 0.5662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightLeg_r1.yRot = headPitch * 0.017453292F;

		this.LeftArm_r2.yRot = headPitch * 0.017453292F;
		this.LeftArm.xRot = MathHelper.cos(limbSwing * 0.7662F) * 1.3F * limbSwingAmount;
		this.RightArm.xRot = MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.3F * limbSwingAmount;

		this.knife.yRot = headPitch * 0.017453292F;

		this.Head.yRot = netHeadYaw * 0.027453292F;
		this.Head.xRot = headPitch * 0.027453292F;

		this.Head_r2.xRot = headPitch * 0.027453292F;
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