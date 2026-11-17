package com.joy187.re8joymod.common.screen;


import com.joy187.re8joymod.Utils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class VirusGeneratorScreen extends ContainerScreen<VirusGeneratorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Utils.MOD_ID, "textures/gui/virus_generator.png");

    public VirusGeneratorScreen(VirusGeneratorMenu pMenu, PlayerInventory pPlayerInventory, ITextComponent pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(MatrixStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        //RenderSystem.(GameRenderer::getPositionTexShader);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(TEXTURE);
        //RenderSystem.(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(this.menu.isCrafting()) {
            //blit(pPoseStack, x + 102, y + 41, 176, 0, 8, menu.getScaledProgress());
            blit(pPoseStack, x + 8, y + 54+12-13, 176, 12-13, 14, this.menu.getScaledProgress());
        }
    }

    @Override
    public void render(MatrixStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
//        this.getMinecraft().getTextureManager().bind(TEXTURE);
//        this.getMinecraft().getTextureManager().getTexture(TEXTURE);
        super.render(pPoseStack, mouseX, mouseY, delta);
        //renderTooltip(pPoseStack, mouseX, mouseY);
    }
}