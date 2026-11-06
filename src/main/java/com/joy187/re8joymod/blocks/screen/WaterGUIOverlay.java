package com.joy187.re8joymod.blocks.screen;

import com.joy187.re8joymod.Main;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;

public class WaterGUIOverlay {

	private static final ResourceLocation FULL_THIRST = new ResourceLocation(Main.MOD_ID,
			"textures/gui/full_thirst.png");
	private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(Main.MOD_ID,
			"textures/gui/empty_thirst.png");
	
//	public static final IIngameOverlay HUD_THIRST = ((gui,poseStack,partialTick,width,height) -> {
//			int x = width / 2;
//			int y = height;
//			
//			RenderSystem.setShader(GameRenderer::getPositionTexShader);
//			RenderSystem.setShaderColor(1.0F, 1.0F,1.0F,1.0F);
//			RenderSystem.setShaderTexture(0,EMPTY_THIRST);
//
//			for(int i=0; i < 10; i++) {
//				GuiComponent.blit(poseStack, x- 94 +(i* 9),y - 54,0,0, 13,13,13,13);
//			}
//			RenderSystem.setShaderTexture(0,FULL_THIRST);
//			for(int i =0;i< 10;i++){
////				if(ClientThirstData.getPlayerThirst() > i) {
////					GuiComponent.blit(poseStack,x-94+(i* 9),y - 54,0,0, 13,13,13,13);
////				}
////				else {
////					break;
////				}
//			}
	public static void renderBg(PoseStack poseStack, float partialTick, int width, int height) 
	{
		int x = width / 2;
		int y = height;
		
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F,1.0F,1.0F);
		RenderSystem.setShaderTexture(0,EMPTY_THIRST);

		for(int i=0; i < 10; i++) {
			//GuiComponent.blit(poseStack, x- 94 +(i* 9),y - 54,0,0, 13,13,13,13);
		}
		RenderSystem.setShaderTexture(0,FULL_THIRST);
		for(int i =0;i< 10;i++){
//			if(ClientThirstData.getPlayerThirst() > i) {
//				GuiComponent.blit(poseStack,x-94+(i* 9),y - 54,0,0, 13,13,13,13);
//			}
//			else {
//				break;
//			}
		}
	}
	
}
