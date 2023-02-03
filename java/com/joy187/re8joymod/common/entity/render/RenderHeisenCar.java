package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.HeisenCarEntity;
import com.joy187.re8joymod.common.entity.model.ModelHeisenCar;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderHeisenCar extends MobRenderer<HeisenCarEntity, ModelHeisenCar<HeisenCarEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/heisenberg2.png");

    public RenderHeisenCar(EntityRendererManager manager) {
        super(manager, new ModelHeisenCar<HeisenCarEntity>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(HeisenCarEntity p_110775_1_) {
        return TEXTURE;
    }

}