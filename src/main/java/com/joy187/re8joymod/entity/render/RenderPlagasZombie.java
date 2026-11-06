package com.joy187.re8joymod.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasZombie;
import com.joy187.re8joymod.entity.model.ModelPlagasZombie;
import com.joy187.re8joymod.entity.variant.PlagasZombieVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class RenderPlagasZombie extends GeoEntityRenderer<EntityPlagasZombie> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    public static final Map<PlagasZombieVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PlagasZombieVariant.class), (p_114874_) -> {
                p_114874_.put(PlagasZombieVariant.DEFAULT,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/plagaszb1.png"));
                p_114874_.put(PlagasZombieVariant.SWORD,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/plagaszb2.png"));
                p_114874_.put(PlagasZombieVariant.CRAZY,
                        new ResourceLocation(Main.MOD_ID, "textures/entity/plagaszb3.png"));
            });

    public RenderPlagasZombie(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasZombie());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagasZombie instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant2());
    	//return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");
    }

    @Override
    public void render(EntityPlagasZombie animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}