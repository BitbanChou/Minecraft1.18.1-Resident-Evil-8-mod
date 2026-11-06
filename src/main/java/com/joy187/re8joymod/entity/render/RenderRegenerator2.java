package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRegenerator2;
import com.joy187.re8joymod.entity.model.ModelRegenerator2;
import com.joy187.re8joymod.entity.variant.RegeneratorVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderRegenerator2 extends GeoEntityRenderer<EntityRegenerator2> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<RegeneratorVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RegeneratorVariant.class), (p_114874_) -> {
                p_114874_.put(RegeneratorVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/reg.png"));
                p_114874_.put(RegeneratorVariant.MID,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/reg2.png"));
                p_114874_.put(RegeneratorVariant.LOW,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/reg3.png"));
            });

    public RenderRegenerator2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelRegenerator2());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityRegenerator2 instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityRegenerator2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(2.7F, 2.7F, 2.7F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}