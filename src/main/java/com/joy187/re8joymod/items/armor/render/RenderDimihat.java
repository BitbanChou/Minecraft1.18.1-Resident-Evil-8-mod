package com.joy187.re8joymod.items.armor.render;

import com.joy187.re8joymod.items.armor.DimihatArmorItem;
import com.joy187.re8joymod.items.armor.model.ModelDimihat;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RenderDimihat extends GeoArmorRenderer<DimihatArmorItem> {
	public RenderDimihat() {
		super(new ModelDimihat());

		// These values are what each bone name is in blockbench. So if your head bone
		// is named "bone545", make sure to do this.headBone = "bone545";
		// The default values are the ones that come with the default armor template in
		// the geckolib blockbench plugin.
//		this.headBone = "Head";
//		this.bodyBone = "other";
//		this.rightArmBone = "other";
//		this.leftArmBone = "other";
//		this.rightLegBone = "other";
//		this.leftLegBone = "other";
//		this.rightBootBone = "other";
//		this.leftBootBone = "other";
	}
	
}