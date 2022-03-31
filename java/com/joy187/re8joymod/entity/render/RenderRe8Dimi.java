package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRe8Dimi;
import com.joy187.re8joymod.entity.model.ModelRe8Dimi;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderRe8Dimi extends MobRenderer<EntityRe8Dimi, ModelRe8Dimi<EntityRe8Dimi>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/re8dimi.png");

    public RenderRe8Dimi(EntityRendererProvider.Context manager) {
        super(manager, new ModelRe8Dimi<>(manager.bakeLayer(ModelRe8Dimi.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityRe8Dimi p_110775_1_) {
        return TEXTURE;
    }


}
