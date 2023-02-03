package com.joy187.re8joymod.common.items.itemBook;


import com.joy187.re8joymod.Utils;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ChangePageButton extends Button {
    private final boolean right;
    private int color;
    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID+":textures/gui/re8storybookbutton.png");

    public ChangePageButton(int x, int y, boolean right, int color, Button.IPressable press) {
        super(x, y, 23, 10, new TranslationTextComponent(""), press);
        this.right = right;
        this.color = color;
    }

    public ChangePageButton(int x, int y, boolean right, int color, String text, Button.IPressable press) {
        super(x, y, 23, 10, new TranslationTextComponent(text), press);
        this.right = right;
        this.color = color;
    }
}