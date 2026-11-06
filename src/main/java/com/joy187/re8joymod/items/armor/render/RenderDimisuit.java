package com.joy187.re8joymod.items.armor.render;

import com.joy187.re8joymod.items.armor.DimisuitArmorItem;
import com.joy187.re8joymod.items.armor.model.ModelDimisuit;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RenderDimisuit extends GeoArmorRenderer<DimisuitArmorItem> {
	public RenderDimisuit() {
		super(new ModelDimisuit());

		// These values are wsuit each bone name is in blockbench. So if your head bone
		// is named "bone545", make sure to do this.headBone = "bone545";
		// The default values are the ones tsuit come with the default armor template in
		// the geckolib blockbench plugin.
//		this.headBone = "other";
//		this.bodyBone = "chestplate";
//		this.rightArmBone = "rightArm";
//		this.leftArmBone = "leftArm";
//		this.rightLegBone = "other";
//		this.leftLegBone = "other";
//		this.rightBootBone = "other";
//		this.leftBootBone = "other";
	}
	
}