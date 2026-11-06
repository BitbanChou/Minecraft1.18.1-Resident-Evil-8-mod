package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMannequin;
import com.joy187.re8joymod.entity.model.ModelMannequin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderMannequin extends MobRenderer<EntityMannequin, ModelMannequin<EntityMannequin>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/mannequin.png");

    public RenderMannequin(EntityRendererProvider.Context manager) {
        super(manager, new ModelMannequin<>(manager.bakeLayer(ModelMannequin.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMannequin p_110775_1_) {
        return TEXTURE;
    }
}
