package com.joy187.re8joymod.common.items.ItemSniper;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;

public class Crosshair {

    public static final Codec<Crosshair> CODEC = RecordCodecBuilder.create(instance -> instance
            .group(
                    ResourceLocation.CODEC.fieldOf("name").forGetter(Crosshair::getName),
                    ResourceLocation.CODEC.fieldOf("top").forGetter(Crosshair::getTop),
                    ResourceLocation.CODEC.fieldOf("bottom").forGetter(Crosshair::getBottom),
                    ResourceLocation.CODEC.fieldOf("left").forGetter(Crosshair::getLeft),
                    ResourceLocation.CODEC.fieldOf("right").forGetter(Crosshair::getRight),
                    ResourceLocation.CODEC.fieldOf("middle").forGetter(Crosshair::getMiddle))
            .apply(instance, Crosshair::new));

    private final ResourceLocation name;

    private final ResourceLocation top;
    private final ResourceLocation bottom;
    private final ResourceLocation left;
    private final ResourceLocation right;
    private final ResourceLocation middle;

    public Crosshair(ResourceLocation name, ResourceLocation top,
                     ResourceLocation bottom, ResourceLocation left, ResourceLocation right,
                     ResourceLocation middle) {
        this.name = name;
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    public ResourceLocation getName() {
        return this.name;
    }

    public ResourceLocation getTop() {
        return this.top;
    }

    public ResourceLocation getBottom() {
        return this.bottom;
    }

    public ResourceLocation getLeft() {
        return this.left;
    }

    public ResourceLocation getRight() {
        return this.right;
    }

    public ResourceLocation getMiddle() {
        return this.middle;
    }
}
