package com.joy187.re8joymod.common.entity.render;

import com.google.common.collect.Maps;
import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntitySummonDaughter;
import com.joy187.re8joymod.common.entity.model.ModelSummonDaughter;
import com.joy187.re8joymod.common.entity.variant.DaughterVariant;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

import java.util.Map;


public class RenderSummonDaughter extends MobRenderer<EntitySummonDaughter, ModelSummonDaughter<EntitySummonDaughter>> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank5.png");
    public static final Map<DaughterVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DaughterVariant.class), (p_114874_) -> {
                p_114874_.put(DaughterVariant.DEFAULT,
                        new ResourceLocation(Utils.MOD_ID, "textures/entity/bela.png"));
                p_114874_.put(DaughterVariant.CASSANDRA,
                        new ResourceLocation(Utils.MOD_ID, "textures/entity/cassandra.png"));
                p_114874_.put(DaughterVariant.DANIELA,
                        new ResourceLocation(Utils.MOD_ID, "textures/entity/daniela.png"));
            });

    public RenderSummonDaughter(EntityRendererManager manager) {
        super(manager, new ModelSummonDaughter<EntitySummonDaughter>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySummonDaughter instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

}
//public class RenderSummonDaughter extends GeoEntityRenderer<EntitySummonDaughter> {
//
//
//
//    @Override
//    public ResourceLocation getTextureLocation(EntitySummonDaughter instance) {
//        return LOCATION_BY_VARIANT.get(instance.getVariant());
//        //return new ResourceLocation(Main.MOD_ID, "textures/entity/SummonDaughter.png");
//    }
//
//    @Override
//    public RenderType getRenderType(EntitySummonDaughter animatable, float partialTicks, PoseStack stack,
//                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
//                                    ResourceLocation textureLocation) {
//
//        stack.scale(0.8F, 0.8F, 0.8F);
//
//        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
//    }
//
//}