package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityCvg;
import com.joy187.re8joymod.entity.model.ModelCvg;
import com.joy187.re8joymod.entity.variant.CvgVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderCvg extends GeoEntityRenderer<EntityCvg> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<CvgVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CvgVariant.class), (p_114874_) -> {
                p_114874_.put(CvgVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/cvg.png"));
                p_114874_.put(CvgVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/cvg2.png"));
            });

    public RenderCvg(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelCvg());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityCvg instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant1());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityCvg animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}