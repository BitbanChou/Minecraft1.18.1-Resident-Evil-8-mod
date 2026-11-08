package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.model.ModelDund;
import com.joy187.re8joymod.entity.model.ModelRe8Dimi;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderRe8Dimi extends GeoEntityRenderer<EntityRe8Dimi> {

//    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/dimi1.png");
//
//    public RenderRe8Dimi(EntityRendererProvider.Context manager) {
//        super(manager, new ModelRe8Dimi<>(manager.bakeLayer(ModelRe8Dimi.LAYER_LOCATION)), 0.7F);
//     }
//    
//    @Override
//    public ResourceLocation getTextureLocation(EntityRe8Dimi p_110775_1_) {
//        return TEXTURE;
//    }
    public RenderRe8Dimi(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelRe8Dimi());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityRe8Dimi instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/re8dimi.png");
    }

    @Override
    public void render(EntityRe8Dimi animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
        // Fully hide Lady D while she is in fly form — only the Fly entity should show.
        if (animatable.isInFlyForm() || animatable.isInvisible()) {
            return;
        }
    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
    
}
