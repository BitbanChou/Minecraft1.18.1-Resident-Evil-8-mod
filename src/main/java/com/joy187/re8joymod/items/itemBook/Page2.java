package com.joy187.re8joymod.items.itemBook;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;

public class Page2 extends BookBase{
    public static final Page2 PAGE_2 = new Page2();
    int page = 0;


	public void render(GuiGraphics pPoseStack, int mouseX, int mouseY, float delta) {
	      super.render(pPoseStack, mouseX, mouseY, delta);
          String text = "Hello World!";

	      int text_left = Math.round((1f/5)*this.width)+10;
	      int text_top = Math.round((1f/8)*this.height)+15;
        pPoseStack.drawString(font,text,text_left,text_top, 0X303030);
        pPoseStack.drawString(font,text,text_left,text_top+10, 0X303030);

	      //mc.fontRenderer.drawString(text,text_left,text_top,0x000000);
	   }	
	   
}
