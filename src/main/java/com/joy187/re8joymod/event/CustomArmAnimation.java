package com.joy187.re8joymod.event;

public class CustomArmAnimation {
    // 挥剑周期
    private static final int SWING_PERIOD = 20;
    // 挥剑前半周期的中心点
    private static final float SWING_CENTER_START = 0.2f;
    // 挥剑后半周期的中心点
    private static final float SWING_CENTER_END = 0.8f;
    // 挥剑反弹周期
    private static final float SWING_REBOUND_PERIOD = 0.5f;
    // 挥剑反弹的距离
    private static final float SWING_REBOUND_DISTANCE = 0.2f;

    private int current = 0;
    private float swingProgress = 0;
    private float reboundProgress = -1;

    // 进行挥剑动画
    public void doSwing() {
        current = 0;
        swingProgress = 0;
        reboundProgress = -1;
    }

    // 获取当前挥剑动画的进度
    public float getSwingProgress(float partialTicks) {
        current++;
        float currentSwingProgress = current / (float)SWING_PERIOD;
        // 如果超过周期，则重新开始挥剑动画
        if (current >= SWING_PERIOD) {
            // 挥剑动画结束，重置状态
            current = 0;
            swingProgress = 0;
            reboundProgress = 0;
            return 0;
        }
        // 挥剑前半周期
        if (currentSwingProgress <= SWING_CENTER_START) {
            swingProgress = currentSwingProgress / SWING_CENTER_START;
        }
        // 挥剑后半周期
        else if (currentSwingProgress < SWING_CENTER_END) {
            swingProgress = 1.0f;
        }
        // 挥剑反弹周期
        else {
            float reboundLength = currentSwingProgress - SWING_CENTER_END;
            if (reboundProgress < 0) {
                reboundProgress = 0;
            } else if (reboundProgress + partialTicks > SWING_REBOUND_PERIOD) {
                reboundProgress = SWING_REBOUND_PERIOD;
            } else {
                reboundProgress += partialTicks;
            }

            float reboundProgressRad = (float) Math.PI * (reboundProgress / SWING_REBOUND_PERIOD);
            float rebound = (float) Math.sin(reboundProgressRad) * SWING_REBOUND_DISTANCE;
            swingProgress = 1 - reboundLength / (SWING_CENTER_END - SWING_CENTER_START) + rebound;
        }
        return swingProgress;
    }
}
