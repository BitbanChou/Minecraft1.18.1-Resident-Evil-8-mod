package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMerchant;
import com.joy187.re8joymod.entity.model.ModelMerchant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderMerchant extends GeoEntityRenderer<EntityMerchant>{

	
    public RenderMerchant(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMerchant());
        this.shadowRadius = 0.5f;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 30.0D);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMerchant instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/merchant.png");
    }

    @Override
    public void render(EntityMerchant animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
//        if(animatable.isBaby()) {
//            stack.scale(0.4F, 0.4F, 0.4F);
//        } else {
//            stack.scale(0.8F, 0.8F, 0.8F);
//        }
    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}