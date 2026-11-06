package com.joy187.re8joymod.entity.variant;


import java.util.Arrays;
import java.util.Comparator;

public enum RegeneratorVariant {
    DEFAULT(0),
    MID(1),
    LOW(2);

    private static final RegeneratorVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(RegeneratorVariant::getId)).toArray(RegeneratorVariant[]::new);
    private final int id;

    RegeneratorVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static RegeneratorVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}