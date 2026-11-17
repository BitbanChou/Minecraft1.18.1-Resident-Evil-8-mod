package com.joy187.re8joymod.common.items.ItemSniper;

import com.joy187.re8joymod.Utils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import org.lwjgl.opengl.GL11;

public class ZoomBase extends Screen {
    protected static final int X = 2048;
    protected static final int Y = 512;
    private static final ResourceLocation TEXTURE=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/hp_scope.png");

    public ZoomBase(ItemStack book) {
        super(new TranslationTextComponent(""));
    }


    public void render(MatrixStack pMatrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(pMatrixStack);

        //background.draw(matrixStack, partialTicks, (int) bookHeight, (float) backgroundScale);
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.s(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.bindTexture(0);
        this.renderBackground(pMatrixStack);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bind(TEXTURE);
        this.getMinecraft().getTextureManager().getTexture(TEXTURE);

        int cornerX = (this.width - X) / 2;
        int cornerY = (this.height - Y) / 2;
        blit(pMatrixStack, cornerX, cornerY, 0, 0, X, Y, 2048,512);

        super.render(pMatrixStack, mouseX, mouseY, delta);
    }
//
//    public void render(float f) {
//        RenderSystem.disableAlphaTest();
//        RenderSystem.disableDepthTest();
//        RenderSystem.depthMask(false);
//        RenderSystem.defaultBlendFunc();
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, f);
//        this.minecraft.getTextureManager().bind(TEXTURE);
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder bufferBuilder = tessellator.getBuilder();
//        bufferBuilder.begin(7,  DefaultVertexFormats.POSITION_TEX);
//        bufferBuilder.vertex(0.0D, (double)this.minecraft.getWindow().getGuiScaledHeight(), -90.0D).uv(0.0F, 1.0F).endVertex();
//        bufferBuilder.vertex((double)this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight(), -90.0D).uv(1.0F, 1.0F).endVertex();
//        bufferBuilder.vertex((double)this.minecraft.getWindow().getGuiScaledWidth(), 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
//        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
//        tessellator.end();
//        RenderSystem.depthMask(true);
//        RenderSystem.enableDepthTest();
//        RenderSystem.enableAlphaTest();
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//    }

    @Override
    public void tick()
    {
        super.tick();

    }
//
//    @Override
//    public boolean isPauseScreen()
//    {
//        return false;
//    }

}
