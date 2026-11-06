package com.joy187.re8joymod.items.itemBook;

import com.joy187.re8joymod.Main;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.narration.NarrationSupplier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ChangePageButton extends Button{
    private final boolean right;
    public int lastpage = 1;
    private int color;
    public static final int UP = 1;
    public static final int NEXT = 2;
    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID+":textures/gui/re8storybookbutton.png");

    public ChangePageButton(int x, int y, boolean right, int color, OnPress press, Button.CreateNarration p_259552_) {
        super(x, y, 23, 10, Component.translatable(""), press, p_259552_);
        this.right = right;
        this.color = color;
    }
    
    public ChangePageButton(int x, int y, boolean right, int color, String text, OnPress press, Button.CreateNarration p_259552_) {
        super(x, y, 23, 10, Component.translatable(text), press, p_259552_);
        this.right = right;
        this.color = color;
    }



}
