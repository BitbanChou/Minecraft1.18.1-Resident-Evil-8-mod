package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasVillager;
import com.joy187.re8joymod.entity.model.ModelPlagasVillager;
import com.joy187.re8joymod.entity.variant.PlagasVillagerVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderPlagasVillager extends GeoEntityRenderer<EntityPlagasVillager> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<PlagasVillagerVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PlagasVillagerVariant.class), (p_114874_) -> {
                p_114874_.put(PlagasVillagerVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/plagasvillager.png"));
                p_114874_.put(PlagasVillagerVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/vg2.png"));
                p_114874_.put(PlagasVillagerVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/grandpaa.png"));
            });

    public RenderPlagasVillager(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasVillager());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagasVillager instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant2());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityPlagasVillager animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}