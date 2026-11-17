package com.joy187.re8joymod.common.items.ItemSniper;

public class ZoomUtils {

    //The zoom FOV multipliers. Used by the GameRenderer mixin.
    public static float zoomFovMultiplier = 1.0F;
    public static float lastZoomFovMultiplier = 1.0F;
    public static boolean zoomState = false;
    public static boolean lastZoomState = false;

    //The zoom overlay's alpha. Used by the InGameHud mixin.
    public static float zoomOverlayAlpha = 0.0F;
    public static float lastZoomOverlayAlpha = 0.0F;

    public static double zoomDivisor = 4.0F;
    public double scrollStep = 1.0;

    //The equivalent of GameRenderer's updateFovMultiplier but for zooming. Used by zoom transitions.
    public static final void updateZoomFovMultiplier() {
        float zoomMultiplier = 1.0F;
        double dividedZoomMultiplier = 1.0 / 4;

        if (ZoomUtils.zoomState) {
            zoomMultiplier = (float)dividedZoomMultiplier;
        }

        lastZoomFovMultiplier = zoomFovMultiplier;

//        if (OkZoomerConfigPojo.features.zoomTransition.equals(ZoomTransitionOptions.SMOOTH)) {
            zoomFovMultiplier += (zoomMultiplier - zoomFovMultiplier) * 0.75;
//        } else if (OkZoomerConfigPojo.features.zoomTransition.equals(ZoomTransitionOptions.LINEAR)) {
//            double linearStep = dividedZoomMultiplier;
//            if (linearStep < OkZoomerConfigPojo.values.minimumLinearStep) {
//                linearStep = OkZoomerConfigPojo.values.minimumLinearStep;
//            }
//            if (linearStep > OkZoomerConfigPojo.values.maximumLinearStep) {
//                linearStep = OkZoomerConfigPojo.values.maximumLinearStep;
//            }
//            zoomFovMultiplier = MathHelper.stepTowards(zoomFovMultiplier, zoomMultiplier, (float)linearStep);
//        }
    }

    //Handles the zoom overlay transparency with transitions. Used by zoom overlay.
    public static final void updateZoomOverlayAlpha() {
        float zoomMultiplier = 0.0F;

        if (ZoomUtils.zoomState) {
            zoomMultiplier = 1.0F;
        }

        lastZoomOverlayAlpha = zoomOverlayAlpha;

//        if (OkZoomerConfigPojo.features.zoomTransition.equals(ZoomTransitionOptions.SMOOTH)) {
            zoomOverlayAlpha += (zoomMultiplier - zoomOverlayAlpha) * 0.75;
//        }
//        else if (OkZoomerConfigPojo.features.zoomTransition.equals(ZoomTransitionOptions.LINEAR)) {
//            double linearStep = 1.0F / 4;
//            if (linearStep < OkZoomerConfigPojo.values.minimumLinearStep) {
//                linearStep = OkZoomerConfigPojo.values.minimumLinearStep;
//            }
//            if (linearStep > OkZoomerConfigPojo.values.maximumLinearStep) {
//                linearStep = OkZoomerConfigPojo.values.maximumLinearStep;
//            }
//            zoomOverlayAlpha = MathHelper.stepTowards(zoomOverlayAlpha, zoomMultiplier, (float)linearStep);
//        }
    }

    //The method used for changing the zoom divisor, used by zoom scrolling and the keybinds.
    public static final void changeZoomDivisor(boolean increase) {
        //If the zoom is disabled, don't allow for zoom scrolling
//        if (ZoomPackets.disableZoom || ZoomPackets.disableZoomScrolling) {
//            return;
//        }

        double changedZoomDivisor;
        double lesserChangedZoomDivisor;

        if (increase) {
            changedZoomDivisor = zoomDivisor + 1;
            lesserChangedZoomDivisor = zoomDivisor + 0.5;
        } else {
            changedZoomDivisor = zoomDivisor - 1;
            lesserChangedZoomDivisor = zoomDivisor - 0.5;
            lastZoomState = true;
        }

        if (lesserChangedZoomDivisor <= 4) {
            changedZoomDivisor = lesserChangedZoomDivisor;
        }

        if (changedZoomDivisor >= 1) {
            if (changedZoomDivisor <= 2) {
                zoomDivisor = changedZoomDivisor;
            }
        }
    }

}
