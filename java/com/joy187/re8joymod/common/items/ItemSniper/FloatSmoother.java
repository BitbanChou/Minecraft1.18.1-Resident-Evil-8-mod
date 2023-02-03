package com.joy187.re8joymod.common.items.ItemSniper;

import net.minecraft.util.math.MathHelper;

public class FloatSmoother {

    private final float acceleration;

    private volatile float targetValue;
    private volatile float remainingValue;
    private volatile float lastAmount;

    public FloatSmoother(float acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Accumulate value.
     *
     * @param value - amount to add
     */
    public void add(float value) {
        this.targetValue += value;
    }

    public void reset() {
        this.targetValue = 0.0F;
        this.remainingValue = 0.0F;
        this.lastAmount = 0.0F;
    }

    public float getAndDecelerate(float deceleration) {
        float deltaAmount = this.targetValue - this.remainingValue;
        float lerpAmount = MathHelper.lerp(this.acceleration, this.lastAmount, deltaAmount);
        float signum = Math.signum(deltaAmount);
        if (signum * deltaAmount > signum * this.lastAmount) {
            deltaAmount = lerpAmount;
        }

        this.lastAmount = lerpAmount;

        float result = deltaAmount * Math.min(deceleration, 1.0F);
        this.remainingValue += result;

        if (Math.abs(result) < 0.001F) {
            result = 0.0F;
            this.reset();
        }

        return result;
    }
}
