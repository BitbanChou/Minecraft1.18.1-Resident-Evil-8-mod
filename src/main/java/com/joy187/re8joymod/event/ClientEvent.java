package com.joy187.re8joymod.event;

import com.joy187.re8joymod.config.ModCommonConfig;
import com.joy187.re8joymod.entity.EntityCameraShake;
import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientEvent {
    public ClientEvent() {}

    @SubscribeEvent
    public void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        float delta = Minecraft.getInstance().getFrameTime();
        if (ModCommonConfig.SCREEN_SHAKE.get() && !minecraft.isPaused()) {
            if (player != null) {
                float ticksExistedDelta = (float)player.tickCount + delta;
                float shakeAmplitude = 0.0f;
                //player.getDeltaMovement().add(shakeAmplitude*0.01*player.getRandom().nextDouble(),shakeAmplitude*0.2*player.getRandom().nextDouble(),shakeAmplitude*0.1*player.getRandom().nextDouble());
                for (EntityCameraShake ScreenShake : player.level().getEntitiesOfClass(EntityCameraShake.class, player.getBoundingBox().inflate(20.0, 20.0, 20.0))) {
                    if (!(ScreenShake.distanceTo(player) < ScreenShake.getRadius())) continue;
                    shakeAmplitude += ScreenShake.getShakeAmount(player, delta);
                }
                if (shakeAmplitude > 1.0f) {
                    shakeAmplitude = 1.0f;
                }
                event.setPitch((float)((double)event.getPitch() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 3.0f + 2.0f) * 25.0));
                event.setYaw((float)((double)event.getYaw() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 5.0f + 1.0f) * 25.0));
                event.setRoll((float)((double)event.getRoll() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 4.0f) * 25.0));
                if (player.getEffect(EffectInit.STUN.get()) != null) {
                    MobEffectInstance effectinstance1 = player.getEffect(EffectInit.STUN.get());
                    float shakeAmplitude1 = (float)((double)(1 + effectinstance1.getAmplifier()) * 0.01);
                    event.setPitch((float)((double)event.getPitch() + (double)shakeAmplitude1 * Math.cos(ticksExistedDelta * 3.0f + 2.0f) * 25.0));
                    event.setYaw((float)((double)event.getYaw() + (double)shakeAmplitude1 * Math.cos(ticksExistedDelta * 5.0f + 1.0f) * 25.0));
                    event.setRoll((float)((double)event.getRoll() + (double)shakeAmplitude1 * Math.cos(ticksExistedDelta * 4.0f) * 25.0));
                }
            }
        }
    }

}
