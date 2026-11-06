package com.joy187.re8joymod.event;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.ItemCombatKnife;
import com.joy187.re8joymod.util.Vector3f;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {


    private static final CustomArmAnimation SWING_ANIMATION = new CustomArmAnimation();


    @SubscribeEvent
    public static void onRenderHandEvent(RenderHandEvent event) {
        InteractionHand hand = event.getHand();
        Minecraft mc = Minecraft.getInstance();
        ItemStack itemStack = mc.player.getItemInHand(hand);
        // 这里只为带有特定剑类物品的场合，进行挥剑动画绘制
        if (!itemStack.isEmpty() && (itemStack.getItem() instanceof SwordItem ||  itemStack.getItem() instanceof ItemCombatKnife) && Main.renderExecute>0) {
            //System.out.println("sword! "+" "+Main.renderExecute);
            if(Main.renderExecute==20){
                SWING_ANIMATION.doSwing();
            }
            if(Main.renderExecute>0) Main.renderExecute--;
            // 计算挥剑动画的进度
            float swingProgress = SWING_ANIMATION.getSwingProgress(event.getPartialTick());
            // 应用旋转矩阵
            PoseStack matrixStack = event.getPoseStack();
            matrixStack.pushPose();
            float f = 0.4F;
            float f1 = -0.6F * swingProgress - 0.3F;
            float f2 = -0.5F*2;
            float angle = (float) Math.toRadians(-90);// * swingProgress;
            matrixStack.translate(hand == InteractionHand.MAIN_HAND ? f : -f, f1+0.4, f2);
            matrixStack.mulPose(Vector3f.ZP.rotation(angle)); //绕Z轴向下转45度
            matrixStack.mulPose(Vector3f.XP.rotation(angle));
            matrixStack.scale(1.5f,1.5f,1.5f);
//            matrixStack.mulPose(Vector3f.YN.rotation(angle));
            //mc.getItemRenderer().renderStatic(mc.player, itemStack, hand == InteractionHand.MAIN_HAND ? ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND : ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND, false, matrixStack, event.getMultiBufferSource(),mc.level, event.getPackedLight(), OverlayTexture.NO_OVERLAY, mc.player.getId());
            ItemDisplayContext transformType = hand == InteractionHand.MAIN_HAND ? ItemDisplayContext.FIRST_PERSON_LEFT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND;
            mc.getItemRenderer().renderStatic(mc.player, itemStack, transformType, false, matrixStack, event.getMultiBufferSource(), mc.level, event.getPackedLight(), OverlayTexture.NO_OVERLAY, mc.player.getId());
            //mc.getItemRenderer().renderStatic(mc.player, itemStack, ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, false, matrixStack, event.getMultiBufferSource(), event.getPackedLight(), OverlayTexture.NO_OVERLAY, null);
            //mc.getItemRenderer().renderGuiItem(itemStack, 0, 0);
            matrixStack.popPose();
        }
    }

}