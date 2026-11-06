package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityVillagerGanado;
import com.joy187.re8joymod.entity.model.ModelLycan;
import com.joy187.re8joymod.entity.model.ModelVillagerGanado;
import com.joy187.re8joymod.entity.variant.VillagerGanadoVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderVillagerGanado extends GeoEntityRenderer<EntityVillagerGanado> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<VillagerGanadoVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(VillagerGanadoVariant.class), (p_114874_) -> {
                p_114874_.put(VillagerGanadoVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/vg1.png"));
                p_114874_.put(VillagerGanadoVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/vg3.png"));
                p_114874_.put(VillagerGanadoVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/vg2.png"));
            });

    public RenderVillagerGanado(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelVillagerGanado());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityVillagerGanado instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant1());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityVillagerGanado animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}