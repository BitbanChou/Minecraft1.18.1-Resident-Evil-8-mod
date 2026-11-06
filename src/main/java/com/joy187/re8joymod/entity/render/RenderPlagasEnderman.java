package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLeon;
import com.joy187.re8joymod.entity.EntityMiranda1;
import com.joy187.re8joymod.entity.EntityPlagasEnderman;
import com.joy187.re8joymod.entity.model.ModelPlagasEnderman;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderPlagasEnderman extends GeoEntityRenderer<EntityPlagasEnderman> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");


    @Override
    public ResourceLocation getTextureLocation(EntityPlagasEnderman instance) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagasenderman.png");
    }

    public RenderPlagasEnderman(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasEnderman());
        this.shadowRadius = 0.5f;
    }

    @Override
    public void render(EntityPlagasEnderman animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1.1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}