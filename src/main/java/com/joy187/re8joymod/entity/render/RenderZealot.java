package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityZealot;
import com.joy187.re8joymod.entity.model.ModelZealot;
import com.joy187.re8joymod.entity.variant.ZealotVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderZealot extends GeoEntityRenderer<EntityZealot> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<ZealotVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ZealotVariant.class), (p_114874_) -> {
                p_114874_.put(ZealotVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/zealot.png"));
                p_114874_.put(ZealotVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/zealot2.png"));
                p_114874_.put(ZealotVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/zealot4.png"));
            });

    public RenderZealot(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelZealot());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityZealot instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant2());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityZealot animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}