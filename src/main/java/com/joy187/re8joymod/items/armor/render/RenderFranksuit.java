package com.joy187.re8joymod.items.armor.render;

import com.joy187.re8joymod.items.armor.FranksuitArmorItem;
import com.joy187.re8joymod.items.armor.model.ModelFranksuit;

import software.bernie.geckolib.renderer.GeoArmorRenderer;


public class RenderFranksuit extends GeoArmorRenderer<FranksuitArmorItem> {
	public RenderFranksuit() {
		super(new ModelFranksuit());

		// These values are what each bone name is in blockbench. So if your head bone
		// is named "bone545", make sure to do this.headBone = "bone545";
		// The default values are the ones that come with the default armor template in
		// the geckolib blockbench plugin.
//		this.headBone = "Head";
//		this.bodyBone = "chestplate";
//		this.rightArmBone = "rightArm";
//		this.leftArmBone = "leftArm";
//		this.rightLegBone = "rightLeg";
//		this.leftLegBone = "leftLeg";
//		this.rightBootBone = "rightBoot";
//		this.leftBootBone = "leftBoot";
	}
	
}