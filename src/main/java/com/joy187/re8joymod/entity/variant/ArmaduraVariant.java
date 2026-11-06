package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum ArmaduraVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final ArmaduraVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ArmaduraVariant::getId)).toArray(ArmaduraVariant[]::new);
    private final int id;

    ArmaduraVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ArmaduraVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}