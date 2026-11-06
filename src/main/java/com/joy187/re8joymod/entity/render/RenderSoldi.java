package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySoldi;
import com.joy187.re8joymod.entity.model.ModelSoldi;
import com.joy187.re8joymod.entity.variant.SoldiVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderSoldi extends GeoEntityRenderer<EntitySoldi> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<SoldiVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SoldiVariant.class), (p_114874_) -> {
                p_114874_.put(SoldiVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/soldi.png"));
                p_114874_.put(SoldiVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/soldi3.png"));
                p_114874_.put(SoldiVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/soldi2.png"));
            });

    public RenderSoldi(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSoldi());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySoldi instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant1());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntitySoldi animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}