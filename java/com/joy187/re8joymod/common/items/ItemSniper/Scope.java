package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public interface Scope {

    boolean isAiming(Entity entity);

    float getZoomMultiplier(Entity entity);

    ResourceLocation getOverlayTexture(Entity entity);

    int getOverlayTextureWidth();

    int getOverlayTextureHeight();
}

