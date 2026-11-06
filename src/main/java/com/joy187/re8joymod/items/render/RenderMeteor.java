package com.joy187.re8joymod.items.render;

import com.joy187.re8joymod.items.ItemMeteor;
import com.joy187.re8joymod.items.model.ModelMeteor;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class RenderMeteor extends GeoItemRenderer<ItemMeteor> {

    public RenderMeteor() {
        super(new ModelMeteor());
    }
}


