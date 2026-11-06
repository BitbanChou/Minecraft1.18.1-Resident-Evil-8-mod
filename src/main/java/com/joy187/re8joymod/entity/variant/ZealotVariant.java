package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum ZealotVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final ZealotVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ZealotVariant::getId)).toArray(ZealotVariant[]::new);
    private final int id;

    ZealotVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ZealotVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}