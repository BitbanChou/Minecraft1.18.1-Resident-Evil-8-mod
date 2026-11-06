package com.joy187.re8joymod.entity.render;

import java.util.Map;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySummonDaughter;
import com.joy187.re8joymod.entity.model.ModelSummonDaughter;
import com.joy187.re8joymod.entity.variant.DaughterVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderSummonDaughter extends GeoEntityRenderer<EntitySummonDaughter> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/SummonDaughter.png");
    public static final Map<DaughterVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DaughterVariant.class), (p_114874_) -> {
                p_114874_.put(DaughterVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/bela.png"));
                p_114874_.put(DaughterVariant.CASSANDRA,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/cassandra.png"));
                p_114874_.put(DaughterVariant.DANIELA,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/daniela.png"));
            });

    public RenderSummonDaughter(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSummonDaughter());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySummonDaughter instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/SummonDaughter.png");
    }

    @Override
    public void render(EntitySummonDaughter animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(0.8F, 0.8F, 0.8F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}