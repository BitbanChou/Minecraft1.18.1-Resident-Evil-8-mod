package com.joy187.re8joymod.entity.variant;


import java.util.Arrays;
import java.util.Comparator;

public enum LycanVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final LycanVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(LycanVariant::getId)).toArray(LycanVariant[]::new);
    private final int id;

    LycanVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static LycanVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}