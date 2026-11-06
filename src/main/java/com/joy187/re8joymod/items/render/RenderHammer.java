package com.joy187.re8joymod.items.render;

import com.joy187.re8joymod.items.ItemHammer;
import com.joy187.re8joymod.items.model.ModelHammer;
import software.bernie.geckolib.renderer.GeoItemRenderer;


public class RenderHammer extends GeoItemRenderer<ItemHammer> {
	public RenderHammer() {
		super(new ModelHammer());
	}

}