package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDimi2;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.model.GeoModel;

// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelDimi2 extends GeoModel<EntityDimi2> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "dimi2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDimi2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/dimi2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDimi2 object) {
        //return RenderDund.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dimi2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDimi2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/dimi2.animation.json");
    }	
	//	private final ModelPart Head;
//	private final ModelPart Body;
//	private final ModelPart RightLeg;
//	private final ModelPart LeftLeg;
//	private final ModelPart otherp;
//	private final ModelPart tongue;
//	private final ModelPart LeftLeg2;
//	private final ModelPart RightLeg2;
//
//	public ModelDimi2(ModelPart root) {
//		this.Head = root.getChild("Head");
//		this.Body = root.getChild("Body");
//		this.RightLeg = root.getChild("RightLeg");
//		this.LeftLeg = root.getChild("LeftLeg");
//		this.otherp = root.getChild("otherp");
//		this.tongue = root.getChild("tongue");
//		this.LeftLeg2 = root.getChild("LeftLeg2");
//		this.RightLeg2 = root.getChild("RightLeg2");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -27.0F, 15.0F, 0.1571F, 0.0873F, 0.0F));
//
//		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(33, 82).addBox(-3.0F, -4.5F, -0.5F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7992F, -5.0981F, 13.7409F, 0.7936F, -0.0925F, -0.0093F));
//
//		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(33, 82).addBox(-4.0F, -4.5F, -8.5F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8892F, -4.2521F, 12.8555F, 0.4446F, -0.0925F, -0.0093F));
//
//		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(33, 82).addBox(13.5179F, -3.5324F, 4.9857F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.839F, -4.1043F, -7.2868F, 0.0519F, -0.0925F, -0.0093F));
//
//		PartDefinition hairr2 = Head.addOrReplaceChild("hairr2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.2239F, 12.8459F, 14.9285F, 0.0F, -0.2618F, 0.0F));
//
//		PartDefinition hair_r1 = hairr2.addOrReplaceChild("hair_r1", CubeListBuilder.create().texOffs(121, 75).mirror().addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.2496F, -0.1979F, 26.0958F, 1.4835F, -2.3998F, -1.5272F));
//
//		PartDefinition hair_r2 = hairr2.addOrReplaceChild("hair_r2", CubeListBuilder.create().texOffs(119, 75).mirror().addBox(-16.5807F, -21.5748F, 19.1393F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 1.4835F, -2.3998F, -1.0472F));
//
//		PartDefinition hairr4 = Head.addOrReplaceChild("hairr4", CubeListBuilder.create(), PartPose.offsetAndRotation(11.9889F, 0.291F, 23.8823F, 0.0F, -1.0036F, -1.7453F));
//
//		PartDefinition hair_r3 = hairr4.addOrReplaceChild("hair_r3", CubeListBuilder.create().texOffs(121, 75).mirror().addBox(-0.509F, -13.166F, -1.5551F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.4206F, 1.1574F, -18.0676F, -3.0054F, -0.1443F, 2.3021F));
//
//		PartDefinition hair_r4 = hairr4.addOrReplaceChild("hair_r4", CubeListBuilder.create().texOffs(114, 112).mirror().addBox(-0.7104F, -0.3464F, -1.6107F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.4206F, 1.1574F, -18.0676F, -2.6752F, 0.1822F, 2.435F));
//
//		PartDefinition hairr7 = Head.addOrReplaceChild("hairr7", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5414F, -12.5578F, 13.7318F, -0.4363F, 1.3526F, -1.7017F));
//
//		PartDefinition hair_r5 = hairr7.addOrReplaceChild("hair_r5", CubeListBuilder.create().texOffs(122, 113).mirror().addBox(-0.509F, -13.166F, -1.5551F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1547F, 2.4025F, -0.4201F, -3.0054F, -0.1443F, 2.3021F));
//
//		PartDefinition hair_r6 = hairr7.addOrReplaceChild("hair_r6", CubeListBuilder.create().texOffs(114, 112).mirror().addBox(1.2896F, -10.3464F, -10.6107F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0479F, 7.1877F, 1.2641F, -1.8025F, 0.1822F, 1.4751F));
//
//		PartDefinition hair_r7 = hairr7.addOrReplaceChild("hair_r7", CubeListBuilder.create().texOffs(114, 112).mirror().addBox(1.2896F, -0.3464F, -10.6107F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1097F, 0.0062F, 1.0829F, -1.8025F, 0.1822F, 2.435F));
//
//		PartDefinition hair_r8 = hairr7.addOrReplaceChild("hair_r8", CubeListBuilder.create().texOffs(114, 112).mirror().addBox(-0.7104F, 2.6536F, -1.6107F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1097F, 0.0062F, 1.0829F, -2.5443F, 0.1822F, 2.435F));
//
//		PartDefinition hairr6 = Head.addOrReplaceChild("hairr6", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9889F, -2.709F, 36.8823F, 0.0F, -0.0436F, -1.0036F));
//
//		PartDefinition hair_r9 = hairr6.addOrReplaceChild("hair_r9", CubeListBuilder.create().texOffs(121, 75).mirror().addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.104F, 1.7646F, -2.7959F, 1.4835F, -2.3998F, -1.5272F));
//
//		PartDefinition hair_r10 = hairr6.addOrReplaceChild("hair_r10", CubeListBuilder.create().texOffs(114, 112).mirror().addBox(-16.5807F, -17.5748F, 19.1393F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.235F, 12.5548F, -25.9538F, 1.4835F, -2.3998F, -1.0472F));
//
//		PartDefinition hairr5 = Head.addOrReplaceChild("hairr5", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0111F, 3.291F, 37.8823F, 0.0F, -0.2618F, 0.0F));
//
//		PartDefinition hair_r11 = hairr5.addOrReplaceChild("hair_r11", CubeListBuilder.create().texOffs(121, 75).mirror().addBox(-29.7582F, -10.2447F, 8.6103F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.104F, 1.7646F, -2.7959F, 1.4835F, -2.3998F, -1.5272F));
//
//		PartDefinition hair_r12 = hairr5.addOrReplaceChild("hair_r12", CubeListBuilder.create().texOffs(119, 75).mirror().addBox(-16.5807F, -17.5748F, 19.1393F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.235F, 12.5548F, -25.9538F, 1.4835F, -2.3998F, -1.0472F));
//
//		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(50, 52).addBox(-6.0F, -14.0F, 10.0F, 13.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 29).addBox(-2.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 29).addBox(-10.0F, -2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(6, 36).addBox(-10.0F, -10.0F, 3.0F, 20.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 29).addBox(-6.0F, 2.0F, 3.0F, 13.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(63, 94).addBox(-16.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F))
//		.texOffs(66, 94).mirror().addBox(10.0F, 0.0F, -2.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(18, 12).addBox(-2.5F, 4.0F, -8.5F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.3337F, -2.3369F, -11.0507F, 1.3526F, 0.0873F, -0.4363F));
//
//		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(30, 101).addBox(-1.5F, -5.0F, -8.5F, 1.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.3337F, -2.3369F, -11.0507F, 1.1781F, 0.0873F, -0.4363F));
//
//		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(18, 23).addBox(-1.0F, -3.5F, -2.5F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5961F, 19.5828F, -12.3684F, 0.5236F, 0.4363F, -0.0873F));
//
//		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(18, 23).addBox(-4.0F, -3.5F, -2.5F, 8.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5961F, 19.5828F, -12.3684F, 0.5236F, -0.0436F, -0.0873F));
//
//		PartDefinition Body_r5 = Body.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(18, 23).addBox(-4.0F, -4.5F, -6.5F, 8.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0254F, 20.1116F, -5.0856F, 0.3491F, 0.1745F, 0.2618F));
//
//		PartDefinition Body_r6 = Body.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(18, 23).addBox(-3.0F, -3.5F, -6.5F, 8.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0808F, 13.065F, -5.9068F, 0.6545F, -0.0873F, 1.0036F));
//
//		PartDefinition Body_r7 = Body.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(18, 20).addBox(-4.0F, -5.5F, -2.0F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7571F, 7.3652F, -12.0848F, 0.1745F, 0.1745F, 2.0071F));
//
//		PartDefinition Body_r8 = Body.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.2141F, 5.8971F, 0.5236F, 0.0F, 0.0F));
//
//		PartDefinition Body_r9 = Body.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 106).addBox(-6.8554F, 24.8498F, 4.1598F, 12.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
//		.texOffs(42, 54).addBox(-0.8554F, -1.1502F, -3.8402F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
//		.texOffs(110, 82).mirror().addBox(-5.8554F, 3.8498F, 0.1598F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(110, 82).addBox(1.1446F, 3.8498F, 0.1598F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
//		.texOffs(86, 114).addBox(-2.8554F, -1.1502F, 4.1598F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(86, 114).addBox(-3.8554F, -2.1502F, 6.1598F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
//		.texOffs(81, 114).addBox(-5.8554F, -4.1502F, -0.8402F, 12.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1446F, -25.006F, 18.6893F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition eye_r1 = Body.addOrReplaceChild("eye_r1", CubeListBuilder.create().texOffs(75, 112).addBox(-2.5F, -6.0F, -1.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4142F, -15.3412F, -7.5692F, -1.1345F, -1.309F, -0.3491F));
//
//		PartDefinition eye_r2 = Body.addOrReplaceChild("eye_r2", CubeListBuilder.create().texOffs(75, 112).mirror().addBox(-1.5F, -6.0F, -1.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.4142F, -15.3412F, -7.5692F, -1.1345F, 1.309F, 0.3491F));
//
//		PartDefinition eye_r3 = Body.addOrReplaceChild("eye_r3", CubeListBuilder.create().texOffs(76, 113).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2468F, -12.6547F, -3.097F, -0.9599F, -1.7017F, 0.0F));
//
//		PartDefinition eye_r4 = Body.addOrReplaceChild("eye_r4", CubeListBuilder.create().texOffs(76, 113).addBox(-1.5F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4142F, -15.3412F, -7.5692F, -0.5672F, -1.309F, 0.0F));
//
//		PartDefinition eye_r5 = Body.addOrReplaceChild("eye_r5", CubeListBuilder.create().texOffs(76, 113).mirror().addBox(-2.5F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.4142F, -15.3412F, -7.5692F, -0.5672F, 1.309F, 0.0F));
//
//		PartDefinition eye_r6 = Body.addOrReplaceChild("eye_r6", CubeListBuilder.create().texOffs(50, 92).addBox(-0.5F, 1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(50, 92).addBox(7.5F, 3.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(50, 92).addBox(9.5F, 4.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 91).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4042F, -8.0858F, -9.905F, -0.5672F, -1.309F, 0.3927F));
//
//		PartDefinition eye_r7 = Body.addOrReplaceChild("eye_r7", CubeListBuilder.create().texOffs(49, 92).addBox(5.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 92).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.2501F, -1.3502F, 0.8981F, -0.5672F, -1.309F, 0.0873F));
//
//		PartDefinition eye_r8 = Body.addOrReplaceChild("eye_r8", CubeListBuilder.create().texOffs(49, 92).mirror().addBox(-7.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 92).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.2501F, -1.3502F, 0.8981F, -0.5672F, 1.309F, -0.0873F));
//
//		PartDefinition eye_r9 = Body.addOrReplaceChild("eye_r9", CubeListBuilder.create().texOffs(50, 92).mirror().addBox(-9.5F, 3.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(50, 92).mirror().addBox(-11.5F, 4.0F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(50, 92).mirror().addBox(-7.5F, 6.0F, -3.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(50, 92).mirror().addBox(-1.5F, 1.0F, -1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 91).mirror().addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.4042F, -8.0858F, -9.905F, -0.5672F, 1.309F, -0.3927F));
//
//		PartDefinition eye_r10 = Body.addOrReplaceChild("eye_r10", CubeListBuilder.create().texOffs(49, 92).addBox(-4.5F, -1.0F, 1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7117F, -17.1301F, -8.0582F, 0.2618F, -1.309F, -1.1345F));
//
//		PartDefinition eye_r11 = Body.addOrReplaceChild("eye_r11", CubeListBuilder.create().texOffs(49, 92).mirror().addBox(1.5F, 0.0F, 0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.7117F, -17.1301F, -8.0582F, 0.2618F, 1.309F, 1.1345F));
//
//		PartDefinition eye_r12 = Body.addOrReplaceChild("eye_r12", CubeListBuilder.create().texOffs(49, 92).addBox(-4.5F, -6.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7117F, -17.1301F, -8.0582F, -0.5672F, -1.309F, -1.1345F));
//
//		PartDefinition eye_r13 = Body.addOrReplaceChild("eye_r13", CubeListBuilder.create().texOffs(49, 92).mirror().addBox(1.5F, -3.0F, 0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.7117F, -17.1301F, -8.0582F, -0.5672F, 1.309F, 1.1345F));
//
//		PartDefinition eye_r14 = Body.addOrReplaceChild("eye_r14", CubeListBuilder.create().texOffs(49, 91).addBox(-5.5F, 10.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 91).addBox(-3.5F, 15.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 91).addBox(3.5F, 15.0F, -2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 91).addBox(-2.5F, 10.0F, -4.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9514F, -16.8632F, -0.929F, -0.5672F, -1.309F, 0.0F));
//
//		PartDefinition eye_r15 = Body.addOrReplaceChild("eye_r15", CubeListBuilder.create().texOffs(49, 91).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.6267F, -1.3387F, -3.2901F, -0.3927F, -1.9199F, -0.3927F));
//
//		PartDefinition eye_r16 = Body.addOrReplaceChild("eye_r16", CubeListBuilder.create().texOffs(49, 91).mirror().addBox(-1.5F, -3.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.6267F, -1.3387F, -3.2901F, -0.3927F, 1.9199F, 0.3927F));
//
//		PartDefinition eye_r17 = Body.addOrReplaceChild("eye_r17", CubeListBuilder.create().texOffs(49, 91).mirror().addBox(0.5F, 15.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 91).mirror().addBox(-6.5F, 15.0F, -2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 91).mirror().addBox(-0.5F, 10.0F, -4.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 91).mirror().addBox(2.5F, 10.0F, -3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9514F, -16.8632F, -0.929F, -0.5672F, 1.309F, 0.0F));
//
//		PartDefinition eye_r18 = Body.addOrReplaceChild("eye_r18", CubeListBuilder.create().texOffs(50, 93).mirror().addBox(-44.5F, 4.5F, 8.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(48, 93).mirror().addBox(-42.5F, 3.5F, 7.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 92).mirror().addBox(-47.5F, 1.5F, 9.0297F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 92).mirror().addBox(-44.5F, 0.5F, 7.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(49, 92).mirror().addBox(-0.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.5851F, -2.9098F, 5.0033F, -0.2618F, 1.5708F, 0.0436F));
//
//		PartDefinition eye_r19 = Body.addOrReplaceChild("eye_r19", CubeListBuilder.create().texOffs(50, 93).addBox(43.5F, 4.5F, 8.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(48, 93).addBox(41.5F, 3.5F, 7.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 92).addBox(44.5F, 1.5F, 8.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 92).addBox(38.5F, -1.5F, 5.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(49, 92).addBox(-2.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5851F, -2.9098F, 5.0033F, -0.2618F, -1.5708F, -0.0436F));
//
//		PartDefinition eye_r20 = Body.addOrReplaceChild("eye_r20", CubeListBuilder.create().texOffs(49, 92).mirror().addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.4642F, 0.8018F, 45.0033F, -1.309F, 1.5708F, 0.0436F));
//
//		PartDefinition eye_r21 = Body.addOrReplaceChild("eye_r21", CubeListBuilder.create().texOffs(49, 92).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.4642F, 0.8018F, 45.0033F, -1.309F, -1.5708F, -0.0436F));
//
//		PartDefinition eye_r22 = Body.addOrReplaceChild("eye_r22", CubeListBuilder.create().texOffs(49, 92).mirror().addBox(-1.5F, -0.5F, 4.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.54F, 3.9331F, 51.8877F, 0.7418F, 1.1345F, 0.7418F));
//
//		PartDefinition eye_r23 = Body.addOrReplaceChild("eye_r23", CubeListBuilder.create().texOffs(49, 92).addBox(-1.5F, -0.5F, 4.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.54F, 3.9331F, 51.8877F, 0.7418F, -1.1345F, -0.7418F));
//
//		PartDefinition eye_r24 = Body.addOrReplaceChild("eye_r24", CubeListBuilder.create().texOffs(75, 113).addBox(-7.5F, 5.0F, -7.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9514F, -16.8632F, -0.929F, -0.2182F, -1.309F, 0.0F));
//
//		PartDefinition eye_r25 = Body.addOrReplaceChild("eye_r25", CubeListBuilder.create().texOffs(75, 113).mirror().addBox(2.5F, 5.0F, -7.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9514F, -16.8632F, -0.929F, -0.2182F, 1.309F, 0.0F));
//
//		PartDefinition eye_r26 = Body.addOrReplaceChild("eye_r26", CubeListBuilder.create().texOffs(72, 110).addBox(-4.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
//		.texOffs(72, 110).addBox(-1.5F, 3.0F, 1.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, -11.2064F, -1.0644F, -0.7854F, -0.829F, 0.0F));
//
//		PartDefinition eye_r27 = Body.addOrReplaceChild("eye_r27", CubeListBuilder.create().texOffs(73, 110).mirror().addBox(-0.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0257F, -13.0885F, -4.8314F, -1.7017F, -1.2654F, 0.1745F));
//
//		PartDefinition eye_r28 = Body.addOrReplaceChild("eye_r28", CubeListBuilder.create().texOffs(73, 110).mirror().addBox(-0.5F, -3.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5328F, -13.224F, -0.6281F, -0.7854F, 2.0071F, 0.3491F));
//
//		PartDefinition eye_r29 = Body.addOrReplaceChild("eye_r29", CubeListBuilder.create().texOffs(72, 110).mirror().addBox(-0.5F, -2.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(72, 110).mirror().addBox(-3.5F, 3.0F, 1.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.5F, -11.2064F, -1.0644F, -0.7854F, 0.829F, 0.0F));
//
//		PartDefinition Body_r10 = Body.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(44, 29).mirror().addBox(-1.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -6.0F, 10.5F, 0.0F, 0.1745F, -0.48F));
//
//		PartDefinition Body_r11 = Body.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(45, 29).addBox(-2.0F, -6.0F, -16.5F, 3.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.0F, 10.5F, 0.0F, -0.1745F, 0.48F));
//
//		PartDefinition Body_r12 = Body.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(57, 3).mirror().addBox(-3.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.3807F, 13.7163F, 9.0F, 0.0F, 0.0F, 0.6545F));
//
//		PartDefinition Body_r13 = Body.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(72, 97).addBox(-3.0F, -6.0F, -11.0F, 5.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3807F, 13.7163F, 9.0F, 0.0F, 0.0F, -0.6545F));
//
//		PartDefinition Body_r14 = Body.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(70, 91).mirror().addBox(-6.0F, -6.0F, -11.0F, 6.0F, 15.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0897F, 15.2773F, 9.0F, 0.0F, 0.0F, 1.3963F));
//
//		PartDefinition Body_r15 = Body.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.4255F, 11.6854F, 27.0F, 0.0F, -0.1309F, 1.3963F));
//
//		PartDefinition Body_r16 = Body.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(72, 98).addBox(8.0F, -5.0F, -2.0F, 7.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2121F, 21.993F, 55.785F, 0.0F, -0.0436F, -1.6144F));
//
//		PartDefinition Body_r17 = Body.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(69, 101).addBox(4.0F, -7.0F, -9.0F, 3.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.989F, 16.8828F, 44.0F, 0.0F, -0.0873F, -1.6144F));
//
//		PartDefinition Body_r18 = Body.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(56, 1).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4255F, 11.6854F, 27.0F, 0.0F, 0.2182F, -1.3963F));
//
//		PartDefinition Body_r19 = Body.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(72, 93).addBox(-1.0F, -6.0F, -11.0F, 6.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0897F, 15.2773F, 9.0F, 0.0F, 0.0F, -1.3963F));
//
//		PartDefinition Body_r20 = Body.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(70, 100).mirror().addBox(-5.0F, -5.5F, -8.0F, 8.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2275F, 4.0987F, 62.3715F, 0.0436F, -0.3054F, -1.6144F));
//
//		PartDefinition Body_r21 = Body.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(61, 97).mirror().addBox(-5.5F, -5.5F, 11.0F, 6.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(61, 94).mirror().addBox(-3.5F, -6.5F, -10.0F, 5.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5989F, -12.2009F, 25.6123F, 0.0436F, -0.3054F, -1.789F));
//
//		PartDefinition Body_r22 = Body.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(82, 99).mirror().addBox(-3.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.089F, -9.2031F, 25.7953F, 0.2182F, -0.3491F, -0.9599F));
//
//		PartDefinition Body_r23 = Body.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(82, 99).addBox(0.0F, -4.5F, -10.0F, 3.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.089F, -9.2031F, 25.7953F, 0.2182F, 0.3491F, 0.9599F));
//
//		PartDefinition Body_r24 = Body.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(64, 99).mirror().addBox(-7.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.8543F, 5.3439F, 26.3663F, -0.2618F, -0.2618F, 0.0F));
//
//		PartDefinition Body_r25 = Body.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(69, 99).addBox(1.0F, -10.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.8543F, 5.3439F, 26.3663F, -0.2618F, 0.2618F, 0.0F));
//
//		PartDefinition Body_r26 = Body.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(70, 98).mirror().addBox(-6.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 7.5F, 31.0F, 0.0F, -0.2618F, 0.0F));
//
//		PartDefinition Body_r27 = Body.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(72, 96).mirror().addBox(-4.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.2337F, 3.3197F, 50.3251F, -0.0436F, -0.2618F, 0.0F));
//
//		PartDefinition Body_r28 = Body.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(72, 96).addBox(-2.5F, -7.5F, -15.0F, 7.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2337F, 3.3197F, 50.3251F, -0.0436F, 0.2618F, 0.0F));
//
//		PartDefinition Body_r29 = Body.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(70, 98).mirror().addBox(-6.0F, -8.5F, 7.0F, 7.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 7.5F, 31.0F, -0.3491F, -0.2618F, 0.0F));
//
//		PartDefinition Body_r30 = Body.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(70, 97).addBox(-1.0F, -8.5F, 7.0F, 7.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 7.5F, 31.0F, -0.3491F, 0.2618F, 0.0F));
//
//		PartDefinition Body_r31 = Body.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(72, 98).addBox(-1.0F, -4.5F, -12.0F, 6.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 7.5F, 31.0F, 0.0F, 0.2618F, 0.0F));
//
//		PartDefinition Body_r32 = Body.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -0.5F, -11.5F, 13.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6711F, -13.1278F, 6.5F, 0.2182F, 0.0F, 0.3927F));
//
//		PartDefinition Body_r33 = Body.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -1.5F, -11.5F, 13.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -14.5F, 6.5F, 0.2182F, 0.0F, -0.3927F));
//
//		PartDefinition Body_r34 = Body.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -3.0F, 5.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5383F, 13.9488F, -13.6264F, 0.1745F, 0.0436F, 0.0F));
//
//		PartDefinition Body_r35 = Body.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, 3.0F, -9.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-2.0F, 2.0F, -6.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0526F, 10.9943F, -10.6635F, 0.1745F, 0.48F, 0.0F));
//
//		PartDefinition Body_r36 = Body.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(0, 58).addBox(-13.0F, 2.0F, 5.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-12.0F, 3.0F, 1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-16.0F, 3.0F, -2.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-19.0F, 0.0F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-2.0F, 1.0F, -5.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.9331F, 13.7751F, -11.5685F, 0.1745F, 0.0873F, 0.0F));
//
//		PartDefinition Body_r37 = Body.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -3.0F, 4.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.04F, 10.8207F, -10.4315F, 0.1745F, 0.0873F, 0.5672F));
//
//		PartDefinition Body_r38 = Body.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(0, 58).addBox(-16.5F, 17.0F, -5.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5F, -1.5179F, -7.2272F, 0.1745F, -0.3927F, 0.0F));
//
//		PartDefinition Body_r39 = Body.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9896F, -12.2424F, -10.3271F, 0.5236F, -1.7017F, 0.0F));
//
//		PartDefinition Body_r40 = Body.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(0, 58).addBox(-1.0F, 3.5F, 0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-1.0F, 1.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6787F, -8.9154F, -12.3453F, 0.0873F, -2.0071F, 0.0F));
//
//		PartDefinition Body_r41 = Body.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(0, 58).addBox(-1.5F, -0.5F, 6.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-2.5F, -0.5F, 4.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2738F, -11.1195F, -9.6538F, 0.0873F, -1.7017F, 0.0F));
//
//		PartDefinition Body_r42 = Body.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(0, 58).addBox(-2.5F, -0.5F, 2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2738F, -11.1195F, -9.6538F, 0.1745F, -1.7017F, 0.0F));
//
//		PartDefinition Body_r43 = Body.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(0, 58).addBox(-10.5F, -7.0F, 4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-10.5F, -5.0F, 2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-10.5F, -3.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-8.5F, 1.0F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-8.5F, 3.0F, -5.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, -2.5179F, -10.2272F, 0.1745F, -0.3927F, 0.0F));
//
//		PartDefinition Body_r44 = Body.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.4657F, 8.3435F, -13.951F, 0.1745F, -0.3927F, 0.5672F));
//
//		PartDefinition Body_r45 = Body.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(0, 58).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0695F, 6.2002F, -12.5967F, 0.1745F, -0.3927F, 0.5236F));
//
//		PartDefinition eye_r30 = Body.addOrReplaceChild("eye_r30", CubeListBuilder.create().texOffs(47, 1).mirror().addBox(-4.0F, -0.5F, 2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.9745F, -12.4879F, 17.0983F, -0.4363F, -2.5307F, 1.4835F));
//
//		PartDefinition hairr3 = Body.addOrReplaceChild("hairr3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.955F, -28.4999F, 13.7841F, 0.0F, -0.6981F, 0.0F));
//
//		PartDefinition hair_r13 = hairr3.addOrReplaceChild("hair_r13", CubeListBuilder.create().texOffs(25, 4).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.9247F, -11.5807F, 24.3213F, -1.9475F, -0.711F, 1.8074F));
//
//		PartDefinition hair_r14 = hairr3.addOrReplaceChild("hair_r14", CubeListBuilder.create().texOffs(102, 19).addBox(-6.5F, -6.5F, 11.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(102, 19).addBox(-5.5F, -12.5F, 8.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8706F, 0.8965F, 9.4795F, -2.7991F, 0.164F, -2.2272F));
//
//		PartDefinition hair_r15 = hairr3.addOrReplaceChild("hair_r15", CubeListBuilder.create().texOffs(102, 19).mirror().addBox(2.5F, -10.5F, -6.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0394F, 0.8965F, 9.4795F, -1.1847F, -0.164F, 2.2272F));
//
//		PartDefinition hair_r16 = hairr3.addOrReplaceChild("hair_r16", CubeListBuilder.create().texOffs(102, 19).mirror().addBox(4.5F, -4.5F, -1.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0394F, 0.8965F, 9.4795F, -2.0573F, -0.164F, 2.2272F));
//
//		PartDefinition hair_r17 = hairr3.addOrReplaceChild("hair_r17", CubeListBuilder.create().texOffs(26, 3).mirror().addBox(-1.5F, -6.5F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0394F, 0.8965F, 9.4795F, -2.0573F, -0.6876F, 2.2272F));
//
//		PartDefinition hair_r18 = hairr3.addOrReplaceChild("hair_r18", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(7.0F, -14.0F, -2.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, -1.8902F, -0.6185F, 2.2411F));
//
//		PartDefinition hair_r19 = hairr3.addOrReplaceChild("hair_r19", CubeListBuilder.create().texOffs(116, 68).mirror().addBox(-0.5F, -8.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0971F, -8.5633F, 20.6119F, -2.1456F, -0.5627F, 2.2861F));
//
//		PartDefinition hair_r20 = hairr3.addOrReplaceChild("hair_r20", CubeListBuilder.create().texOffs(25, 1).mirror().addBox(6.0F, -14.0F, -2.0F, 2.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 1.0F, 0.0F, -1.971F, -0.5627F, 2.2861F));
//
//		PartDefinition hairr = Body.addOrReplaceChild("hairr", CubeListBuilder.create(), PartPose.offset(3.045F, -1.4999F, 31.7841F));
//
//		PartDefinition hair_r21 = hairr.addOrReplaceChild("hair_r21", CubeListBuilder.create().texOffs(107, 102).mirror().addBox(-30.8886F, -19.9984F, -9.4613F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.9874F, -16.9249F, 18.4945F, -0.878F, -0.5466F, 1.0396F));
//
//		PartDefinition hair_r22 = hairr.addOrReplaceChild("hair_r22", CubeListBuilder.create().texOffs(107, 102).mirror().addBox(-30.8886F, -7.9984F, -10.4613F, 1.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.8611F, -17.681F, 20.5035F, -0.7471F, -0.5466F, 1.0396F));
//
//		PartDefinition hair_r23 = hairr.addOrReplaceChild("hair_r23", CubeListBuilder.create().texOffs(83, 98).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.5927F, -40.6592F, 17.6937F, 1.8762F, 2.4871F, 1.0036F));
//
//		PartDefinition hair_r24 = hairr.addOrReplaceChild("hair_r24", CubeListBuilder.create().texOffs(83, 98).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0534F, -47.2327F, 16.9892F, 0.829F, -2.4871F, -1.0036F));
//
//		PartDefinition hair_r25 = hairr.addOrReplaceChild("hair_r25", CubeListBuilder.create().texOffs(83, 98).addBox(30.019F, -6.0714F, 3.9331F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4543F, -14.6007F, 31.2959F, 1.4835F, 2.3998F, 1.0036F));
//
//		PartDefinition hair_r26 = hairr.addOrReplaceChild("hair_r26", CubeListBuilder.create().texOffs(83, 98).mirror().addBox(-31.019F, -6.0714F, 3.9331F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.6358F, -19.6007F, 31.2959F, 1.4835F, -2.3998F, -1.0036F));
//
//		PartDefinition hair_r27 = hairr.addOrReplaceChild("hair_r27", CubeListBuilder.create().texOffs(25, 6).mirror().addBox(-32.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.6347F, -15.2185F, 31.2371F, 1.4835F, -2.3998F, -1.5272F));
//
//		PartDefinition hair_r28 = hairr.addOrReplaceChild("hair_r28", CubeListBuilder.create().texOffs(102, 22).addBox(31.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.7247F, -12.2185F, 31.2371F, 1.4835F, 2.3998F, 1.5272F));
//
//		PartDefinition hair_r29 = hairr.addOrReplaceChild("hair_r29", CubeListBuilder.create().texOffs(102, 22).mirror().addBox(-32.019F, 0.9286F, 3.9331F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6347F, -17.2185F, 31.2371F, 1.4835F, -2.3998F, -1.5272F));
//
//		PartDefinition hair_r30 = hairr.addOrReplaceChild("hair_r30", CubeListBuilder.create().texOffs(118, 78).mirror().addBox(-24.0459F, -22.3757F, -1.9997F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1052F, -0.8438F, 1.2893F));
//
//		PartDefinition hair_r31 = hairr.addOrReplaceChild("hair_r31", CubeListBuilder.create().texOffs(104, 100).mirror().addBox(-25.0459F, -30.2534F, 1.1881F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5816F, -0.8438F, 1.2893F));
//
//		PartDefinition hair_r32 = hairr.addOrReplaceChild("hair_r32", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-20.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 2.0F, 0.0F, 1.4835F, -2.3998F, -1.0472F));
//
//		PartDefinition hair_r33 = hairr.addOrReplaceChild("hair_r33", CubeListBuilder.create().texOffs(25, 0).addBox(19.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0901F, 5.0F, 0.0F, 1.4835F, 2.3998F, 1.0472F));
//
//		PartDefinition hair_r34 = hairr.addOrReplaceChild("hair_r34", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-20.7095F, -25.095F, 14.18F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.4835F, -2.3998F, -1.0472F));
//
//		PartDefinition lips = Body.addOrReplaceChild("lips", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.3283F, 5.6873F, -7.3921F, 0.7418F, -0.3927F, 0.0436F));
//
//		PartDefinition Body_r46 = lips.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(0, 59).addBox(-5.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-9.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-17.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2882F, 9.1334F, -3.0394F, 0.1745F, 0.0873F, 0.5672F));
//
//		PartDefinition Body_r47 = lips.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(12, 12).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1619F, -8.4943F, -4.9852F, 0.3927F, 1.0472F, 1.2654F));
//
//		PartDefinition Body_r48 = lips.addOrReplaceChild("Body_r48", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4002F, -6.6601F, -2.1343F, 0.1745F, -0.3491F, 0.5672F));
//
//		PartDefinition Body_r49 = lips.addOrReplaceChild("Body_r49", CubeListBuilder.create().texOffs(17, 12).addBox(-8.0F, 2.5F, 1.5F, 8.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9967F, -2.0125F, -5.6834F, 0.6545F, 0.1745F, 1.2654F));
//
//		PartDefinition lips2 = Body.addOrReplaceChild("lips2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.3283F, 25.6873F, -4.3921F, 1.0036F, 0.0873F, -0.9599F));
//
//		PartDefinition Body_r50 = lips2.addOrReplaceChild("Body_r50", CubeListBuilder.create().texOffs(0, 59).addBox(-5.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-9.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-17.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 59).addBox(-13.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2882F, 9.1334F, -3.0394F, 0.1745F, 0.0873F, 0.5672F));
//
//		PartDefinition Body_r51 = lips2.addOrReplaceChild("Body_r51", CubeListBuilder.create().texOffs(16, 22).addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1619F, -8.4943F, -4.9852F, 0.3927F, 1.0472F, 1.2654F));
//
//		PartDefinition Body_r52 = lips2.addOrReplaceChild("Body_r52", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4002F, -6.6601F, -2.1343F, 0.1745F, -0.3491F, 0.5672F));
//
//		PartDefinition Body_r53 = lips2.addOrReplaceChild("Body_r53", CubeListBuilder.create().texOffs(15, 21).addBox(-8.0F, 2.5F, 1.5F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9967F, -2.0125F, -5.6834F, 0.6545F, 0.1745F, 1.2654F));
//
//		PartDefinition lips3 = Body.addOrReplaceChild("lips3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.3283F, 25.6873F, -4.3921F, 1.0036F, -0.0873F, 0.9599F));
//
//		PartDefinition Body_r54 = lips3.addOrReplaceChild("Body_r54", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(4.0F, -8.0F, 1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 59).mirror().addBox(8.0F, -9.0F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 59).mirror().addBox(12.0F, -10.0F, -3.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 59).mirror().addBox(16.0F, -12.0F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 59).mirror().addBox(12.0F, -12.0F, 6.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 59).mirror().addBox(12.0F, -14.0F, 9.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.2882F, 9.1334F, -3.0394F, 0.1745F, -0.0873F, -0.5672F));
//
//		PartDefinition Body_r55 = lips3.addOrReplaceChild("Body_r55", CubeListBuilder.create().texOffs(16, 22).mirror().addBox(-4.0F, 5.5F, -2.5F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.1619F, -8.4943F, -4.9852F, 0.3927F, -1.0472F, -1.2654F));
//
//		PartDefinition Body_r56 = lips3.addOrReplaceChild("Body_r56", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-1.0F, -2.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.4002F, -6.6601F, -2.1343F, 0.1745F, 0.3491F, -0.5672F));
//
//		PartDefinition Body_r57 = lips3.addOrReplaceChild("Body_r57", CubeListBuilder.create().texOffs(15, 21).mirror().addBox(0.0F, 2.5F, 1.5F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.9967F, -2.0125F, -5.6834F, 0.6545F, -0.1745F, -1.2654F));
//
//		PartDefinition tail = Body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(-1.8942F, 12.0352F, 71.1238F));
//
//		PartDefinition chin4_r1 = tail.addOrReplaceChild("chin4_r1", CubeListBuilder.create().texOffs(92, 110).addBox(-1.0F, -7.0F, 23.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
//		.texOffs(71, 105).addBox(-1.0F, -7.0F, 9.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.49F, -0.7681F, 46.0439F, -0.0873F, 0.6981F, -2.2689F));
//
//		PartDefinition chin2_r1 = tail.addOrReplaceChild("chin2_r1", CubeListBuilder.create().texOffs(77, 103).addBox(7.0F, -14.0F, 7.0F, 3.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
//		.texOffs(77, 103).addBox(14.0F, -21.0F, -17.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9114F, -4.452F, 47.7567F, 0.48F, 0.6981F, -2.2689F));
//
//		PartDefinition Body_r58 = tail.addOrReplaceChild("Body_r58", CubeListBuilder.create().texOffs(75, 104).addBox(-1.0F, -3.0F, -8.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.086F, 0.6038F, 38.5459F, 0.6109F, 0.5672F, -2.2689F));
//
//		PartDefinition Body_r59 = tail.addOrReplaceChild("Body_r59", CubeListBuilder.create().texOffs(70, 106).addBox(-4.0F, -2.0F, -11.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9831F, 0.7546F, 28.6413F, 0.0F, 0.5672F, -2.2689F));
//
//		PartDefinition chin4_r2 = tail.addOrReplaceChild("chin4_r2", CubeListBuilder.create().texOffs(81, 105).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.6486F, 4.3582F, 30.5214F, 0.48F, 0.4363F, -2.2689F));
//
//		PartDefinition Body_r60 = tail.addOrReplaceChild("Body_r60", CubeListBuilder.create().texOffs(62, 6).addBox(4.0F, -5.0F, 23.0F, 5.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1063F, 9.9578F, -15.3388F, 0.0F, -0.0436F, -1.6144F));
//
//		PartDefinition Body_r61 = tail.addOrReplaceChild("Body_r61", CubeListBuilder.create().texOffs(75, 100).mirror().addBox(-7.0F, -4.5F, 7.0F, 6.0F, 11.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1217F, -7.9365F, -8.7523F, 0.0436F, -0.3054F, -1.6144F));
//
//		PartDefinition wing = Body.addOrReplaceChild("wing", CubeListBuilder.create(), PartPose.offset(30.745F, -16.3552F, 22.2371F));
//
//		PartDefinition Body_r62 = wing.addOrReplaceChild("Body_r62", CubeListBuilder.create().texOffs(82, 109).addBox(-5.0F, -7.5F, -6.5F, 2.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9804F, -0.6832F, 0.8535F, -1.309F, -0.6545F, 0.6109F));
//
//		PartDefinition Body_r63 = wing.addOrReplaceChild("Body_r63", CubeListBuilder.create().texOffs(82, 109).addBox(7.5F, -4.5F, -9.0F, 3.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.5402F, -3.1633F, 6.4215F, -1.309F, -0.3491F, 0.1309F));
//
//		PartDefinition Body_r64 = wing.addOrReplaceChild("Body_r64", CubeListBuilder.create().texOffs(92, 104).addBox(31.5F, -34.0F, -1.5F, 13.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(44.5F, -17.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(32.5F, -13.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(79, 111).addBox(11.5F, -35.0F, -1.5F, 21.0F, 15.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(82, 114).addBox(11.5F, -21.0F, -1.5F, 21.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(19.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0902F, -12.7751F, 9.6888F, -1.309F, -0.6981F, -0.4363F));
//
//		PartDefinition Body_r65 = wing.addOrReplaceChild("Body_r65", CubeListBuilder.create().texOffs(92, 107).addBox(4.0F, -9.0F, -2.0F, 5.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(-4.0F, -9.0F, -1.0F, 9.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.1949F, -32.4285F, 53.9188F, -1.309F, -0.2182F, -0.4363F));
//
//		PartDefinition Body_r66 = wing.addOrReplaceChild("Body_r66", CubeListBuilder.create().texOffs(117, 82).addBox(20.5F, -31.0F, -3.0F, 3.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(118, 81).addBox(-7.5F, -36.0F, -3.0F, 3.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(114, 68).addBox(-9.5F, -18.0F, -3.0F, 5.0F, 27.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(5.5F, -6.0F, -3.0F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(-6.5F, -9.0F, -3.0F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.8949F, -29.0355F, 61.6103F, -1.0908F, -0.6981F, -0.4363F));
//
//		PartDefinition Body_r67 = wing.addOrReplaceChild("Body_r67", CubeListBuilder.create().texOffs(114, 68).addBox(17.5F, -16.0F, -3.0F, 5.0F, 27.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.8949F, -29.0355F, 61.6103F, -1.0908F, -0.6981F, -0.3054F));
//
//		PartDefinition Body_r68 = wing.addOrReplaceChild("Body_r68", CubeListBuilder.create().texOffs(115, 68).addBox(-33.5F, -19.5F, 1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(115, 68).addBox(-6.5F, -29.5F, 4.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(114, 68).addBox(-34.5F, -11.5F, 1.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(114, 68).addBox(-8.5F, -19.5F, 4.0F, 4.0F, 27.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5337F, -24.0903F, 53.6805F, -1.0908F, -0.9163F, -0.6109F));
//
//		PartDefinition Body_r69 = wing.addOrReplaceChild("Body_r69", CubeListBuilder.create().texOffs(84, 108).addBox(-9.0F, -3.0F, -2.0F, 18.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(45.696F, -27.3701F, 30.2667F, -1.309F, -0.9599F, -0.4363F));
//
//		PartDefinition Body_r70 = wing.addOrReplaceChild("Body_r70", CubeListBuilder.create().texOffs(80, 111).addBox(-28.0F, -3.0F, -2.0F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.5061F, -28.6804F, 29.9796F, -1.309F, -0.6981F, -0.4363F));
//
//		PartDefinition Body_r71 = wing.addOrReplaceChild("Body_r71", CubeListBuilder.create().texOffs(84, 108).addBox(44.5F, -2.0F, -2.5F, 18.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.7126F, -13.998F, 7.9355F, -1.309F, -0.6981F, -0.4363F));
//
//		PartDefinition Body_r72 = wing.addOrReplaceChild("Body_r72", CubeListBuilder.create().texOffs(45, 49).addBox(-11.5F, -4.0F, -1.5F, 23.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6947F, -12.6587F, 33.4207F, -1.2654F, -0.9599F, -0.4363F));
//
//		PartDefinition Body_r73 = wing.addOrReplaceChild("Body_r73", CubeListBuilder.create().texOffs(78, 113).addBox(-10.5F, -6.0F, -1.0F, 23.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5147F, -12.1939F, 22.5627F, -1.309F, -0.48F, -0.4363F));
//
//		PartDefinition Body_r74 = wing.addOrReplaceChild("Body_r74", CubeListBuilder.create().texOffs(79, 111).addBox(-10.5F, -7.5F, -1.0F, 21.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0645F, -19.4938F, 47.0392F, -1.4399F, -0.2618F, -0.4363F));
//
//		PartDefinition Body_r75 = wing.addOrReplaceChild("Body_r75", CubeListBuilder.create().texOffs(92, 107).addBox(6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(92, 107).addBox(-6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7213F, -12.6031F, 11.5207F, -1.309F, -0.6109F, -0.4363F));
//
//		PartDefinition Body_r76 = wing.addOrReplaceChild("Body_r76", CubeListBuilder.create().texOffs(92, 107).addBox(6.5F, -4.5F, -7.0F, 13.0F, 18.0F, 3.0F, new CubeDeformation(0.0F))
//		.texOffs(80, 114).addBox(-6.5F, -4.5F, -2.0F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4442F, -2.5962F, 7.5464F, -1.309F, -0.3491F, -0.2618F));
//
//		PartDefinition Body_r77 = wing.addOrReplaceChild("Body_r77", CubeListBuilder.create().texOffs(80, 114).addBox(-5.5F, -4.5F, -0.5F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7226F, -7.0934F, 13.0489F, -1.309F, -0.6981F, -0.2618F));
//
//		PartDefinition Body_r78 = wing.addOrReplaceChild("Body_r78", CubeListBuilder.create().texOffs(80, 114).addBox(-7.5F, -5.5F, -3.0F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.774F, -0.2265F, -2.1281F, -1.3963F, 0.0F, -0.2618F));
//
//		PartDefinition Body_r79 = wing.addOrReplaceChild("Body_r79", CubeListBuilder.create().texOffs(80, 114).addBox(-6.5F, -4.5F, -1.0F, 13.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.245F, 0.1998F, 4.7656F, -1.3963F, -0.6545F, 0.0F));
//
//		PartDefinition Body_r80 = wing.addOrReplaceChild("Body_r80", CubeListBuilder.create().texOffs(80, 114).addBox(5.1446F, -4.1502F, 8.1598F, 13.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.8896F, -8.6508F, -3.5478F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition wing2 = Body.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offset(-30.745F, -16.3552F, 22.2371F));
//
//		PartDefinition Body_r81 = wing2.addOrReplaceChild("Body_r81", CubeListBuilder.create().texOffs(82, 109).mirror().addBox(2.0F, -5.5F, -6.5F, 2.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.309F, 0.4363F, -0.6109F));
//
//		PartDefinition Body_r82 = wing2.addOrReplaceChild("Body_r82", CubeListBuilder.create().texOffs(82, 109).mirror().addBox(-10.5F, -4.5F, -9.0F, 3.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.5402F, -3.1633F, 6.4215F, -1.309F, 0.3491F, -0.1309F));
//
//		PartDefinition Body_r83 = wing2.addOrReplaceChild("Body_r83", CubeListBuilder.create().texOffs(92, 104).mirror().addBox(-44.5F, -34.0F, -1.5F, 13.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-57.5F, -17.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-45.5F, -13.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(79, 111).mirror().addBox(-32.5F, -35.0F, -1.5F, 21.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(82, 114).mirror().addBox(-32.5F, -21.0F, -1.5F, 21.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-32.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0902F, -12.7751F, 9.6888F, -1.309F, 0.6981F, 0.4363F));
//
//		PartDefinition Body_r84 = wing2.addOrReplaceChild("Body_r84", CubeListBuilder.create().texOffs(92, 107).mirror().addBox(-9.0F, -9.0F, -2.0F, 5.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-5.0F, -9.0F, -1.0F, 9.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-49.1949F, -32.4285F, 53.9188F, -1.309F, 0.2182F, 0.4363F));
//
//		PartDefinition Body_r85 = wing2.addOrReplaceChild("Body_r85", CubeListBuilder.create().texOffs(117, 82).mirror().addBox(-25.5F, -31.0F, -6.0F, 3.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(118, 81).mirror().addBox(4.5F, -36.0F, -3.0F, 3.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(114, 68).mirror().addBox(4.5F, -18.0F, -3.0F, 5.0F, 27.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-18.5F, -6.0F, -3.0F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-6.5F, -9.0F, -3.0F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.8949F, -29.0355F, 61.6103F, -1.0908F, 0.6981F, 0.4363F));
//
//		PartDefinition Body_r86 = wing2.addOrReplaceChild("Body_r86", CubeListBuilder.create().texOffs(114, 68).mirror().addBox(-23.5F, -16.0F, -7.0F, 5.0F, 27.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.8949F, -29.0355F, 61.6103F, -1.0908F, 0.6981F, 0.3054F));
//
//		PartDefinition Body_r87 = wing2.addOrReplaceChild("Body_r87", CubeListBuilder.create().texOffs(115, 68).mirror().addBox(31.5F, -19.5F, 1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(115, 68).mirror().addBox(4.5F, -29.5F, 4.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(114, 68).mirror().addBox(30.5F, -11.5F, 1.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(114, 68).mirror().addBox(4.5F, -19.5F, 4.0F, 4.0F, 27.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5337F, -24.0903F, 53.6805F, -1.0908F, 0.9163F, 0.6109F));
//
//		PartDefinition Body_r88 = wing2.addOrReplaceChild("Body_r88", CubeListBuilder.create().texOffs(84, 108).mirror().addBox(-9.0F, -3.0F, -2.0F, 18.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-45.696F, -27.3701F, 30.2667F, -1.309F, 0.9599F, 0.4363F));
//
//		PartDefinition Body_r89 = wing2.addOrReplaceChild("Body_r89", CubeListBuilder.create().texOffs(80, 111).mirror().addBox(10.0F, -3.0F, -2.0F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-48.5061F, -28.6804F, 29.9796F, -1.309F, 0.6981F, 0.4363F));
//
//		PartDefinition Body_r90 = wing2.addOrReplaceChild("Body_r90", CubeListBuilder.create().texOffs(84, 108).mirror().addBox(-62.5F, -2.0F, -2.5F, 18.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.7126F, -13.998F, 7.9355F, -1.309F, 0.6981F, 0.4363F));
//
//		PartDefinition Body_r91 = wing2.addOrReplaceChild("Body_r91", CubeListBuilder.create().texOffs(45, 49).mirror().addBox(-11.5F, -4.0F, -1.5F, 23.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6947F, -12.6587F, 33.4207F, -1.2654F, 0.9599F, 0.4363F));
//
//		PartDefinition Body_r92 = wing2.addOrReplaceChild("Body_r92", CubeListBuilder.create().texOffs(78, 113).mirror().addBox(-12.5F, -6.0F, -1.0F, 23.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5147F, -12.1939F, 22.5627F, -1.309F, 0.48F, 0.4363F));
//
//		PartDefinition Body_r93 = wing2.addOrReplaceChild("Body_r93", CubeListBuilder.create().texOffs(79, 111).mirror().addBox(-10.5F, -7.5F, -1.0F, 21.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0645F, -19.4938F, 47.0392F, -1.4399F, 0.2618F, 0.4363F));
//
//		PartDefinition Body_r94 = wing2.addOrReplaceChild("Body_r94", CubeListBuilder.create().texOffs(92, 107).mirror().addBox(-19.5F, -9.0F, -1.5F, 13.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(92, 107).mirror().addBox(-6.5F, -9.0F, -1.5F, 13.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.7213F, -12.6031F, 11.5207F, -1.309F, 0.6109F, 0.4363F));
//
//		PartDefinition Body_r95 = wing2.addOrReplaceChild("Body_r95", CubeListBuilder.create().texOffs(92, 107).mirror().addBox(-19.5F, -4.5F, -7.0F, 13.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(80, 114).mirror().addBox(-6.5F, -4.5F, -2.0F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.4442F, -2.5962F, 7.5464F, -1.309F, 0.3491F, 0.2618F));
//
//		PartDefinition Body_r96 = wing2.addOrReplaceChild("Body_r96", CubeListBuilder.create().texOffs(80, 114).mirror().addBox(-7.5F, -4.5F, -0.5F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.7226F, -7.0934F, 13.0489F, -1.309F, 0.6981F, 0.2618F));
//
//		PartDefinition Body_r97 = wing2.addOrReplaceChild("Body_r97", CubeListBuilder.create().texOffs(80, 114).mirror().addBox(-5.5F, -5.5F, -3.0F, 13.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.774F, -0.2265F, -2.1281F, -1.3963F, 0.0F, 0.2618F));
//
//		PartDefinition Body_r98 = wing2.addOrReplaceChild("Body_r98", CubeListBuilder.create().texOffs(80, 114).mirror().addBox(-6.5F, -4.5F, -1.0F, 13.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(19.245F, 0.1998F, 4.7656F, -1.3963F, 0.6545F, 0.0F));
//
//		PartDefinition Body_r99 = wing2.addOrReplaceChild("Body_r99", CubeListBuilder.create().texOffs(80, 114).mirror().addBox(-18.1446F, -4.1502F, 8.1598F, 13.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.8896F, -8.6508F, -3.5478F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition innerlips = Body.addOrReplaceChild("innerlips", CubeListBuilder.create(), PartPose.offset(1.7571F, 7.3652F, -8.0848F));
//
//		PartDefinition Body_r100 = innerlips.addOrReplaceChild("Body_r100", CubeListBuilder.create().texOffs(18, 23).addBox(-4.0F, -5.5F, -2.0F, 7.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.1745F, 2.0071F));
//
//		PartDefinition Body_r101 = innerlips.addOrReplaceChild("Body_r101", CubeListBuilder.create().texOffs(0, 58).addBox(0.0F, 1.5F, -1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1005F, -1.6859F, -3.8871F, 0.1745F, -1.6144F, 0.0F));
//
//		PartDefinition Body_r102 = innerlips.addOrReplaceChild("Body_r102", CubeListBuilder.create().texOffs(0, 58).addBox(-10.5F, 7.0F, 1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-11.5F, 5.0F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-12.5F, 2.0F, 2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-12.5F, -1.0F, 5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.7429F, -9.8831F, -2.1424F, 0.1745F, -0.3927F, 0.0F));
//
//		PartDefinition Body_r103 = innerlips.addOrReplaceChild("Body_r103", CubeListBuilder.create().texOffs(18, 12).addBox(-1.5F, -5.0F, -8.5F, 1.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5766F, -9.7021F, 1.0341F, 1.1781F, 0.0873F, -0.4363F));
//
//		PartDefinition insestlips = innerlips.addOrReplaceChild("insestlips", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
//
//		PartDefinition Body_r104 = insestlips.addOrReplaceChild("Body_r104", CubeListBuilder.create().texOffs(18, 23).addBox(-4.0F, -1.5F, -6.0F, 7.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.1745F, 2.0071F));
//
//		PartDefinition Body_r105 = insestlips.addOrReplaceChild("Body_r105", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, 3.5F, 3.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 58).addBox(-1.0F, 1.5F, 3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 56).addBox(-1.0F, -0.5F, 2.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 56).addBox(-1.0F, -2.5F, 2.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1005F, -1.6859F, -3.8871F, 0.1745F, -1.6144F, 0.0F));
//
//		PartDefinition Body_r106 = insestlips.addOrReplaceChild("Body_r106", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 56).addBox(-1.0F, -2.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 56).addBox(-1.0F, -4.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
//		.texOffs(0, 56).addBox(0.0F, -6.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2636F, -6.2329F, -2.0091F, 0.1745F, -1.6144F, -0.48F));
//
//		PartDefinition Body_r107 = insestlips.addOrReplaceChild("Body_r107", CubeListBuilder.create().texOffs(30, 23).addBox(-4.5F, -5.0F, -5.5F, 1.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5766F, -9.7021F, 1.0341F, 1.1781F, 0.0873F, -0.4363F));
//
//		PartDefinition insestlips2 = innerlips.addOrReplaceChild("insestlips2", CubeListBuilder.create(), PartPose.offset(-3.5142F, 0.0F, 0.0F));
//
//		PartDefinition Body_r108 = insestlips2.addOrReplaceChild("Body_r108", CubeListBuilder.create().texOffs(18, 23).mirror().addBox(-3.0F, -1.5F, -6.0F, 7.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.1745F, -2.0071F));
//
//		PartDefinition Body_r109 = insestlips2.addOrReplaceChild("Body_r109", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-1.0F, 3.5F, 3.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 58).mirror().addBox(-1.0F, 1.5F, 3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 56).mirror().addBox(-1.0F, -0.5F, 2.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 56).mirror().addBox(-1.0F, -2.5F, 2.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1005F, -1.6859F, -3.8871F, 0.1745F, 1.6144F, 0.0F));
//
//		PartDefinition Body_r110 = insestlips2.addOrReplaceChild("Body_r110", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 56).mirror().addBox(0.0F, -2.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 56).mirror().addBox(0.0F, -4.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 56).mirror().addBox(-1.0F, -6.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2636F, -6.2329F, -2.0091F, 0.1745F, 1.6144F, 0.48F));
//
//		PartDefinition Body_r111 = insestlips2.addOrReplaceChild("Body_r111", CubeListBuilder.create().texOffs(30, 23).addBox(-0.5F, -10.0F, -0.5F, 1.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.4223F, -13.2636F, 4.4968F, 1.0036F, -0.1309F, -0.5236F));
//
//		PartDefinition Body_r112 = insestlips2.addOrReplaceChild("Body_r112", CubeListBuilder.create().texOffs(38, 109).mirror().addBox(-4.5F, -7.0F, -1.5F, 1.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(30, 23).mirror().addBox(3.5F, -5.0F, -5.5F, 1.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5766F, -9.7021F, 1.0341F, 1.1781F, -0.0873F, 0.4363F));
//
//		PartDefinition innerlips2 = Body.addOrReplaceChild("innerlips2", CubeListBuilder.create(), PartPose.offset(-1.7571F, 7.3652F, -8.0848F));
//
//		PartDefinition Body_r113 = innerlips2.addOrReplaceChild("Body_r113", CubeListBuilder.create().texOffs(18, 23).mirror().addBox(-3.0F, -5.5F, -2.0F, 7.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, -0.1745F, -2.0071F));
//
//		PartDefinition Body_r114 = innerlips2.addOrReplaceChild("Body_r114", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-2.0F, 1.5F, -1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1005F, -1.6859F, -3.8871F, 0.1745F, 1.6144F, 0.0F));
//
//		PartDefinition Body_r115 = innerlips2.addOrReplaceChild("Body_r115", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(7.5F, 7.0F, 1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 58).mirror().addBox(9.5F, 5.0F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 58).mirror().addBox(10.5F, 2.0F, 2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(0, 58).mirror().addBox(10.5F, -1.0F, 5.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.7429F, -9.8831F, -2.1424F, 0.1745F, 0.3927F, 0.0F));
//
//		PartDefinition Body_r116 = innerlips2.addOrReplaceChild("Body_r116", CubeListBuilder.create().texOffs(18, 12).mirror().addBox(0.5F, -5.0F, -8.5F, 1.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5766F, -9.7021F, 1.0341F, 1.1781F, -0.0873F, 0.4363F));
//
//		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(88, 21).addBox(-3.8953F, -5.2761F, -0.8752F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
//		.texOffs(24, 17).addBox(-2.8953F, 6.1347F, -22.9701F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.9F, 3.0F, 22.0F, 0.3665F, 0.0F, 0.0349F));
//
//		PartDefinition RightArm_r1 = RightLeg.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(65, 11).addBox(-3.5F, 0.5F, -2.5F, 9.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, -15.3341F, -1.4178F, 0.2182F, 0.0F, 0.1309F));
//
//		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(21, 18).addBox(3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.879F, -16.4792F, 0.2182F, -0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r2 = RightLeg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(12, 104).addBox(-3.0F, 0.5F, -6.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1715F, 5.9897F, -17.0715F, 0.6545F, 0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r3 = RightLeg.addOrReplaceChild("RightLeg_r3", CubeListBuilder.create().texOffs(11, 104).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.879F, -16.4792F, 0.2182F, 0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r4 = RightLeg.addOrReplaceChild("RightLeg_r4", CubeListBuilder.create().texOffs(20, 16).addBox(4.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.6347F, -18.9701F, 0.0F, -0.3491F, 0.0F));
//
//		PartDefinition RightLeg_r5 = RightLeg.addOrReplaceChild("RightLeg_r5", CubeListBuilder.create().texOffs(24, 24).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0918F, 7.5533F, -23.3601F, 0.3927F, -0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r6 = RightLeg.addOrReplaceChild("RightLeg_r6", CubeListBuilder.create().texOffs(24, 24).mirror().addBox(-0.5F, 3.5F, -0.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(24, 24).mirror().addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(24, 24).addBox(-41.0906F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.1953F, 7.5533F, -25.0884F, 0.3927F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r7 = RightLeg.addOrReplaceChild("RightLeg_r7", CubeListBuilder.create().texOffs(32, 121).mirror().addBox(0.0F, -0.5F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(39.7075F, 5.2365F, -19.0392F, 0.3491F, -0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r8 = RightLeg.addOrReplaceChild("RightLeg_r8", CubeListBuilder.create().texOffs(32, 121).addBox(-2.0F, -0.5F, -9.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9075F, 5.2365F, -19.0392F, 0.3491F, 0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r9 = RightLeg.addOrReplaceChild("RightLeg_r9", CubeListBuilder.create().texOffs(8, 101).mirror().addBox(0.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(39.6953F, 6.6347F, -18.9701F, 0.0F, -0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r10 = RightLeg.addOrReplaceChild("RightLeg_r10", CubeListBuilder.create().texOffs(8, 101).addBox(-2.0F, -0.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8953F, 6.6347F, -18.9701F, 0.0F, 0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r11 = RightLeg.addOrReplaceChild("RightLeg_r11", CubeListBuilder.create().texOffs(87, 24).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
//		.texOffs(78, 115).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, 9.1672F, -5.9117F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r12 = RightLeg.addOrReplaceChild("RightLeg_r12", CubeListBuilder.create().texOffs(78, 114).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1047F, 10.5309F, 6.912F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r13 = RightLeg.addOrReplaceChild("RightLeg_r13", CubeListBuilder.create().texOffs(88, 21).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1047F, 9.3278F, -1.3001F, 0.3491F, 0.0F, 0.0F));
//
//		PartDefinition fur = RightLeg.addOrReplaceChild("fur", CubeListBuilder.create().texOffs(88, 21).addBox(1.0F, -11.0F, 9.0F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1047F, 7.7239F, -3.8752F));
//
//		PartDefinition rearfur_r1 = fur.addOrReplaceChild("rearfur_r1", CubeListBuilder.create().texOffs(88, 21).addBox(-1.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.339F, 10.3852F, 0.48F, 0.0F, 0.0F));
//
//		PartDefinition fur2 = RightLeg.addOrReplaceChild("fur2", CubeListBuilder.create().texOffs(88, 21).addBox(-1.25F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6453F, 9.5544F, 8.5674F, -0.7854F, 3.1416F, 0.2182F));
//
//		PartDefinition rearfur_r2 = fur2.addOrReplaceChild("rearfur_r2", CubeListBuilder.create().texOffs(88, 21).addBox(-1.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 2.8305F, -0.0574F, 0.48F, 0.0F, 0.0F));
//
//		PartDefinition viceleft = RightLeg.addOrReplaceChild("viceleft", CubeListBuilder.create(), PartPose.offset(0.1047F, 1.7239F, -3.8752F));
//
//		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(18, 30).mirror().addBox(-0.8641F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(19.45F, 0.457F, 19.5608F, 0.6545F, 0.0F, -0.0349F));
//
//		PartDefinition RightLeg_r14 = LeftLeg.addOrReplaceChild("RightLeg_r14", CubeListBuilder.create().texOffs(12, 104).mirror().addBox(1.0F, 0.5F, -6.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9166F, 4.517F, -19.9976F, 0.6545F, -0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r15 = LeftLeg.addOrReplaceChild("RightLeg_r15", CubeListBuilder.create().texOffs(11, 104).mirror().addBox(-1.0F, -4.5F, -6.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.3453F, 9.422F, -14.04F, 0.2182F, -0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r16 = LeftLeg.addOrReplaceChild("RightLeg_r16", CubeListBuilder.create().texOffs(20, 3).mirror().addBox(-6.0F, 0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.032F, -20.3604F, 0.0F, 0.3491F, 0.0F));
//
//		PartDefinition RightLeg_r17 = LeftLeg.addOrReplaceChild("RightLeg_r17", CubeListBuilder.create().texOffs(79, 115).mirror().addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8641F, 10.9282F, 5.5217F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r18 = LeftLeg.addOrReplaceChild("RightLeg_r18", CubeListBuilder.create().texOffs(77, 116).mirror().addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 9.7251F, -2.6905F, 0.3491F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r19 = LeftLeg.addOrReplaceChild("RightLeg_r19", CubeListBuilder.create().texOffs(76, 109).mirror().addBox(-6.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6359F, -8.2617F, 4.0F, 0.0F, 0.0F, -0.48F));
//
//		PartDefinition RightLeg_r20 = LeftLeg.addOrReplaceChild("RightLeg_r20", CubeListBuilder.create().texOffs(81, 114).mirror().addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 8.1212F, -5.2655F, -0.2182F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r21 = LeftLeg.addOrReplaceChild("RightLeg_r21", CubeListBuilder.create().texOffs(87, 24).mirror().addBox(0.0F, 8.5F, -4.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6547F, 11.7101F, -3.4726F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r22 = LeftLeg.addOrReplaceChild("RightLeg_r22", CubeListBuilder.create().texOffs(78, 115).mirror().addBox(-1.5F, -4.5F, -1.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1547F, 7.9155F, -6.7284F, -1.5272F, 0.0F, 0.0F));
//
//		PartDefinition fur3 = LeftLeg.addOrReplaceChild("fur3", CubeListBuilder.create().texOffs(88, 21).mirror().addBox(-1.75F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0953F, 10.0974F, 7.0066F, -0.7854F, -3.1416F, -0.2182F));
//
//		PartDefinition rearfur_r3 = fur3.addOrReplaceChild("rearfur_r3", CubeListBuilder.create().texOffs(88, 21).mirror().addBox(-0.5F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 2.8305F, -0.0574F, 0.48F, 0.0F, 0.0F));
//
//		PartDefinition fur4 = LeftLeg.addOrReplaceChild("fur4", CubeListBuilder.create().texOffs(88, 21).mirror().addBox(-1.75F, -5.8305F, -1.4426F, 3.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0953F, 10.0974F, 5.0066F, -0.7854F, -3.1416F, -0.5672F));
//
//		PartDefinition rearfur_r4 = fur4.addOrReplaceChild("rearfur_r4", CubeListBuilder.create().texOffs(102, 23).mirror().addBox(-0.5F, -3.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 2.8305F, -0.0574F, 0.48F, 0.0F, 0.0F));
//
//		PartDefinition otherp = partdefinition.addOrReplaceChild("otherp", CubeListBuilder.create(), PartPose.offset(-17.9F, 12.0F, 10.0F));
//
//		PartDefinition RightLeg_r23 = otherp.addOrReplaceChild("RightLeg_r23", CubeListBuilder.create().texOffs(81, 116).addBox(-1.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.5F, -5.5F, 0.3927F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r24 = otherp.addOrReplaceChild("RightLeg_r24", CubeListBuilder.create().texOffs(24, 4).addBox(-5.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.9959F, -5.9183F, -0.4363F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r25 = otherp.addOrReplaceChild("RightLeg_r25", CubeListBuilder.create().texOffs(18, 26).addBox(-2.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6946F, 11.6242F, -10.8151F, 0.3981F, 0.1611F, 0.0674F));
//
//		PartDefinition RightLeg_r26 = otherp.addOrReplaceChild("RightLeg_r26", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(0.0F, -6.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(36.525F, 8.6385F, -9.0941F, 0.2657F, -0.1685F, -0.0456F));
//
//		PartDefinition RightLeg_r27 = otherp.addOrReplaceChild("RightLeg_r27", CubeListBuilder.create().texOffs(20, 4).mirror().addBox(3.0F, -3.5F, -2.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(32.8F, -1.0041F, -4.9183F, -0.5672F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r28 = otherp.addOrReplaceChild("RightLeg_r28", CubeListBuilder.create().texOffs(44, 50).mirror().addBox(-4.0F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(36.8F, -6.5F, -4.5F, 0.2618F, 0.0F, 0.0F));
//
//		PartDefinition tongue = partdefinition.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(16, 26).addBox(-2.0F, -4.0F, -14.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));
//
//		PartDefinition Body_r117 = tongue.addOrReplaceChild("Body_r117", CubeListBuilder.create().texOffs(27, 25).addBox(-1.0F, 0.0789F, -5.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.8178F, 2.1211F, -38.134F, -0.2182F, -0.8727F, 0.1745F));
//
//		PartDefinition Body_r118 = tongue.addOrReplaceChild("Body_r118", CubeListBuilder.create().texOffs(29, 25).addBox(0.0F, -0.5F, -4.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6373F, 1.9047F, -41.0597F, -0.2182F, -0.6109F, 0.0F));
//
//		PartDefinition Body_r119 = tongue.addOrReplaceChild("Body_r119", CubeListBuilder.create().texOffs(30, 26).addBox(-2.0F, -0.5F, -4.5F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6373F, 1.9047F, -41.0597F, -0.2182F, -0.3054F, 0.0F));
//
//		PartDefinition Body_r120 = tongue.addOrReplaceChild("Body_r120", CubeListBuilder.create().texOffs(17, 24).addBox(-1.0F, -1.5F, -16.5F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9404F, -23.0117F, 0.1309F, -0.6109F, 0.0F));
//
//		PartDefinition Body_r121 = tongue.addOrReplaceChild("Body_r121", CubeListBuilder.create().texOffs(20, 23).addBox(0.0F, -2.5F, -6.5F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9404F, -23.0117F, 0.1309F, -0.3927F, 0.0F));
//
//		PartDefinition Body_r122 = tongue.addOrReplaceChild("Body_r122", CubeListBuilder.create().texOffs(16, 25).addBox(-2.0F, -4.0F, -22.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3715F, 1.4635F, 0.3491F, 0.0F, 0.0F));
//
//		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(82, 118).mirror().addBox(1.1359F, 14.1645F, 7.5029F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(18, 30).mirror().addBox(0.1359F, 6.532F, -24.3604F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.45F, 7.457F, 39.5608F, 0.6545F, 0.0F, -0.0349F));
//
//		PartDefinition RightLeg_r29 = LeftLeg2.addOrReplaceChild("RightLeg_r29", CubeListBuilder.create().texOffs(17, 29).mirror().addBox(-6.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.032F, -20.3604F, 0.0F, 0.3491F, 0.0F));
//
//		PartDefinition RightLeg_r30 = LeftLeg2.addOrReplaceChild("RightLeg_r30", CubeListBuilder.create().texOffs(18, 26).mirror().addBox(0.0F, -0.5F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.032F, -20.3604F, 0.0F, -0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r31 = LeftLeg2.addOrReplaceChild("RightLeg_r31", CubeListBuilder.create().texOffs(17, 30).mirror().addBox(1.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 7.2763F, -17.8695F, 0.2182F, -0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r32 = LeftLeg2.addOrReplaceChild("RightLeg_r32", CubeListBuilder.create().texOffs(91, 25).mirror().addBox(0.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(24, 0).mirror().addBox(-1.0F, -4.5F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1359F, 9.5644F, -7.3021F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r33 = LeftLeg2.addOrReplaceChild("RightLeg_r33", CubeListBuilder.create().texOffs(79, 115).mirror().addBox(-1.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8641F, 10.9282F, 5.5217F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r34 = LeftLeg2.addOrReplaceChild("RightLeg_r34", CubeListBuilder.create().texOffs(75, 20).mirror().addBox(0.0F, -3.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(115, 76).mirror().addBox(-1.0F, -1.5F, -4.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1359F, 1.8206F, 2.946F, 0.3491F, 0.0F, -0.3491F));
//
//		PartDefinition RightLeg_r35 = LeftLeg2.addOrReplaceChild("RightLeg_r35", CubeListBuilder.create().texOffs(77, 116).mirror().addBox(2.0F, 1.0F, 7.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
//		.texOffs(77, 116).mirror().addBox(-3.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 9.7251F, -2.6905F, 0.3491F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r36 = LeftLeg2.addOrReplaceChild("RightLeg_r36", CubeListBuilder.create().texOffs(76, 109).mirror().addBox(-6.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6359F, -8.2617F, 4.0F, 0.0F, 0.0F, -0.48F));
//
//		PartDefinition RightLeg_r37 = LeftLeg2.addOrReplaceChild("RightLeg_r37", CubeListBuilder.create().texOffs(81, 114).mirror().addBox(-3.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8641F, 8.1212F, -5.2655F, -0.2182F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(18, 30).addBox(-2.1359F, 6.532F, -17.3604F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.45F, 7.457F, 39.5608F, 0.6545F, 0.0F, 0.0349F));
//
//		PartDefinition RightLeg_r38 = RightLeg2.addOrReplaceChild("RightLeg_r38", CubeListBuilder.create().texOffs(17, 29).addBox(4.0F, -0.5F, -2.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1359F, 7.032F, -16.3604F, 0.0F, -0.3491F, 0.0F));
//
//		PartDefinition RightLeg_r39 = RightLeg2.addOrReplaceChild("RightLeg_r39", CubeListBuilder.create().texOffs(39, 21).mirror().addBox(0.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0359F, 7.032F, -16.3604F, 0.3927F, -0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r40 = RightLeg2.addOrReplaceChild("RightLeg_r40", CubeListBuilder.create().texOffs(39, 21).addBox(-2.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1359F, 7.032F, -16.3604F, 0.3927F, 0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r41 = RightLeg2.addOrReplaceChild("RightLeg_r41", CubeListBuilder.create().texOffs(38, 15).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1359F, 7.032F, -16.3604F, 0.0F, 0.1745F, 0.0F));
//
//		PartDefinition RightLeg_r42 = RightLeg2.addOrReplaceChild("RightLeg_r42", CubeListBuilder.create().texOffs(23, 9).addBox(-3.0F, 0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1359F, 7.2763F, -13.8695F, 0.2182F, 0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r43 = RightLeg2.addOrReplaceChild("RightLeg_r43", CubeListBuilder.create().texOffs(23, 21).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7436F, 9.9886F, -16.8739F, 0.5236F, 0.4363F, 0.0F));
//
//		PartDefinition RightLeg_r44 = RightLeg2.addOrReplaceChild("RightLeg_r44", CubeListBuilder.create().texOffs(86, 24).addBox(-4.0F, 4.5F, -1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1359F, 9.5644F, -3.3021F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r45 = RightLeg2.addOrReplaceChild("RightLeg_r45", CubeListBuilder.create().texOffs(21, 4).addBox(-4.0F, -4.5F, -2.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1359F, 9.5644F, -7.3021F, -1.789F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r46 = RightLeg2.addOrReplaceChild("RightLeg_r46", CubeListBuilder.create().texOffs(79, 115).addBox(-6.0F, 0.0F, -4.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8641F, 10.9282F, 5.5217F, -1.3963F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r47 = RightLeg2.addOrReplaceChild("RightLeg_r47", CubeListBuilder.create().texOffs(77, 116).addBox(-5.0F, -7.0F, 3.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8641F, 9.7251F, -2.6905F, 0.3491F, 0.0F, 0.0F));
//
//		PartDefinition RightLeg_r48 = RightLeg2.addOrReplaceChild("RightLeg_r48", CubeListBuilder.create().texOffs(76, 109).addBox(-1.5F, -6.0F, -3.5F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6359F, -8.2617F, 4.0F, 0.0F, 0.0F, 0.48F));
//
//		PartDefinition RightLeg_r49 = RightLeg2.addOrReplaceChild("RightLeg_r49", CubeListBuilder.create().texOffs(81, 114).addBox(-5.0F, -13.0F, 2.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8641F, 8.1212F, -5.2655F, -0.2182F, 0.0F, 0.0F));
//
//		return LayerDefinition.create(meshdefinition, 128, 128);
//	}
//
//	@Override
//	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//			this.LeftLeg.xRot = Mth.cos(limbSwing * 0.5662F) * 0.8F * limbSwingAmount;
//			this.RightLeg.xRot = Mth.cos(limbSwing * 0.5662F + (float)Math.PI) * 0.8F * limbSwingAmount;
//
//			this.LeftLeg2.xRot = Mth.cos(limbSwing * 0.7662F) * 0.2F * limbSwingAmount;
//			this.RightLeg2.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.2F * limbSwingAmount;
//
//			this.Body.getChild("wing").xRot = Mth.cos(limbSwing * 0.7662F) * 0.4F * limbSwingAmount;
//			this.Body.getChild("wing2").xRot = Mth.cos(limbSwing * 0.7662F) * 0.43F * limbSwingAmount;
//			this.Body.getChild("tail").xRot = Mth.cos(limbSwing * 0.7662F) * 0.1F * limbSwingAmount;
//
//			this.tongue.xRot = Mth.cos(limbSwing * 0.7662F + (float)Math.PI) * 0.2F * limbSwingAmount;
//			this.Head.yRot = netHeadYaw * 0.013453292F;
//			this.Body.getChild("hairr3").getChild("hair_r16").xRot = netHeadYaw * 0.007453292F;
//			this.Head.getChild("hairr2").xRot = netHeadYaw * 0.007453292F;
//			this.Body.getChild("eye_r25").xRot = netHeadYaw * 0.002453292F;
//			this.otherp.getChild("RightLeg_r28").xRot = netHeadYaw * 0.001453292F;
//			
//	}
//	
//	public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
//		ModelPart.xRot = x;
//		ModelPart.yRot= y;
//		ModelPart.zRot = z;
//	}
//	
//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		Head.render(poseStack, buffer, packedLight, packedOverlay);
//		Body.render(poseStack, buffer, packedLight, packedOverlay);
//		RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
//		LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
//		otherp.render(poseStack, buffer, packedLight, packedOverlay);
//		tongue.render(poseStack, buffer, packedLight, packedOverlay);
//		LeftLeg2.render(poseStack, buffer, packedLight, packedOverlay);
//		RightLeg2.render(poseStack, buffer, packedLight, packedOverlay);
//	}
	
}