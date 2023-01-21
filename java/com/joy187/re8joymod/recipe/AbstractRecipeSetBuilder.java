package com.joy187.re8joymod.common.recipe;

import net.minecraft.util.ResourceLocation;

public class AbstractRecipeSetBuilder
{

    protected final String modid;

    public AbstractRecipeSetBuilder(String modid)
    {
        this.modid = modid;
    }

    public ResourceLocation make_resource(String path)
    {
        return new ResourceLocation(this.modid, path);
    }

}