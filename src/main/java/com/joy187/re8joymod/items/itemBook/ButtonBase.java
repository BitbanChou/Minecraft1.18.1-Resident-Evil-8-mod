package com.joy187.re8joymod.items.itemBook;

import com.joy187.re8joymod.Main;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ButtonBase extends Button {
    //private final boolean right;
    public int lastpage = 1;
    private int color;
    public static final int UP = 1;
    public static final int NEXT = 2;
    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, ":textures/gui/re8storybookbutton.png");

    public ButtonBase(int x, int y, boolean right, int color, OnPress press, Button.CreateNarration p_259552_) {
        super(x, y, 23, 10, Component.translatable(""), press, p_259552_);
        //this.right = right;
        this.color = color;
    }
    
    public ButtonBase(int buttonId, int x, int y, int widthIn, int heightIn, Component p_93725_, OnPress p_93726_, Button.CreateNarration p_259552_) {
        super(x, y, widthIn, heightIn,p_93725_,p_93726_,p_259552_);
        this.color = color;
    }
//    public ButtonBase(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
//        super(buttonId, x, y, widthIn, heightIn, buttonText);
//    }
    
//    @Override
//    public void renderButton(PoseStack matrixStack,  int mouseX, int mouseY, float partial) {
//        super.renderButton(matrixStack, mouseX, mouseY, partial);
//        if (this.active) {
//            boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
//            RenderSystem.setShader(GameRenderer::getPositionTexShader);
//            RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
//            int i = 0;
//            int j = 64;
//            if (flag) {
//                i += 23;
//            }
//
//            if (!this.right) {
//                j += 13;
//            }
//            j += color * 23;
//
//            this.blit(matrixStack, this.x, this.y, i, j, width, height);
//        }
//
//     }
}