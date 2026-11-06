package com.joy187.re8joymod.items.render;

import com.joy187.re8joymod.items.ItemWand;
import com.joy187.re8joymod.items.model.ModelWand;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class RenderWand extends GeoItemRenderer<ItemWand> {

    public RenderWand() {
        super(new ModelWand());
    }
}


