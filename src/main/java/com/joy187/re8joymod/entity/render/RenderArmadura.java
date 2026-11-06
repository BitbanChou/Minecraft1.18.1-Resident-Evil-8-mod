package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityArmadura;
import com.joy187.re8joymod.entity.model.ModelArmadura;
import com.joy187.re8joymod.entity.variant.ArmaduraVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderArmadura extends GeoEntityRenderer<EntityArmadura> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<ArmaduraVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ArmaduraVariant.class), (p_114874_) -> {
                p_114874_.put(ArmaduraVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/armadura1.png"));
                p_114874_.put(ArmaduraVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/armadura2.png"));
                p_114874_.put(ArmaduraVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/armadura3.png"));
            });

    public RenderArmadura(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelArmadura());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityArmadura instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant2());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityArmadura animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
        if(animatable.getVariant2().getId()==1)
    	    stack.scale(0.8F, 0.8F, 0.8F);
        else
            stack.scale(0.6F, 0.6F, 0.6F);
        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}