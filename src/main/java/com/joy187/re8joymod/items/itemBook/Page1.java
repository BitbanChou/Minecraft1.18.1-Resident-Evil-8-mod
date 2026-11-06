package com.joy187.re8joymod.items.itemBook;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;

public class Page1 extends BookBase{
    public static final Page1 PAGE_1 = new Page1();
    int page = 0;


	public void render(GuiGraphics pPoseStack, int mouseX, int mouseY, float delta) {
	      super.render(pPoseStack, mouseX, mouseY, delta);
          String text = I18n.get("book.welcome");

	      int text_left = Math.round((1f/5)*this.width)+10;
	      int text_top = Math.round((1f/8)*this.height)+15;
			pPoseStack.drawString(font,text,text_left,text_top, 0X303030);

	      //mc.fontRenderer.drawString(text,text_left,text_top,0x000000);
	   }	
	   
//    @Override
//    protected void actionPerformed(GuiButton button) throws IOException {
//        super.page = this.page;
//        super.actionPerformed(button);
//    }
//
//    @Override
//    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//        super.drawScreen(mouseX, mouseY, partialTicks);
//        String text = I18n.format("book.welcome");
//
//        //String text = I18n.format("book.text1");
//        int text_left = Math.round((1f/5)*this.width)+10;
//        int text_top = Math.round((1f/8)*this.height)+15;
//        mc.fontRenderer.drawString(text,text_left,text_top,0x000000);
//
//    }

}
