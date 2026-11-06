package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
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

public class ModelMoreauProjectile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/moreau.png"), "main");

	private final ModelPart mopro;

	public ModelMoreauProjectile(ModelPart root) {
		this.mopro = root.getChild("mopro");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mopro = partdefinition.addOrReplaceChild("mopro", CubeListBuilder.create(), PartPose.offset(1.0F, 16.0F, -1.0F));

		PartDefinition cube_r1 = mopro.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(0.3355F, -0.005F, -0.3F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4986F, 3.0F, 1.4799F, -1.5708F, 0.4363F, 0.0F));

		PartDefinition cube_r2 = mopro.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 11).addBox(-1.2F, 2.5F, -1.4F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 1.5F, -0.3586F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r3 = mopro.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 11).addBox(-1.4F, 1.5F, -6.4F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 1.5F, -0.6414F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mopro.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}


}