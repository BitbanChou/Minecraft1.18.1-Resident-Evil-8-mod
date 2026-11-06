package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLycan;
import com.joy187.re8joymod.entity.model.ModelLycan;
import com.joy187.re8joymod.entity.variant.LycanVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import net.minecraft.Util;
import java.util.Map;
import com.google.common.collect.Maps;

public class RenderLycan extends GeoEntityRenderer<EntityLycan> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<LycanVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(LycanVariant.class), (p_114874_) -> {
                p_114874_.put(LycanVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png"));
                p_114874_.put(LycanVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/lycansw.png"));
                p_114874_.put(LycanVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/lycancrazy.png"));
            });

    public RenderLycan(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelLycan());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityLycan instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityLycan animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}