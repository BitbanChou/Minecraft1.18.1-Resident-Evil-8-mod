package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityCassandra;
import com.joy187.re8joymod.common.entity.model.ModelCassandra;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderCassandra extends MobRenderer<EntityCassandra, ModelCassandra<EntityCassandra>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/cassandra.png");

    public RenderCassandra(EntityRendererManager manager) {
        super(manager, new ModelCassandra<EntityCassandra>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityCassandra p_110775_1_) {
        return TEXTURE;
    }

}