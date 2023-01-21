package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.joy187.re8joymod.common.entity.model.ModelRe8Dimi;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RederRe8Dimi extends MobRenderer<EntityRe8Dimi, ModelRe8Dimi<EntityRe8Dimi>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dimi1.png");

    public RederRe8Dimi(EntityRendererManager manager) {
        super(manager, new ModelRe8Dimi<EntityRe8Dimi>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRe8Dimi p_110775_1_) {
        return TEXTURE;
    }

}
