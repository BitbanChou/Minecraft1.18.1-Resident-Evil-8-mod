package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum CvgVariant {
    DEFAULT(0),
    SWORD(1);

    private static final CvgVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CvgVariant::getId)).toArray(CvgVariant[]::new);
    private final int id;

    CvgVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CvgVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}