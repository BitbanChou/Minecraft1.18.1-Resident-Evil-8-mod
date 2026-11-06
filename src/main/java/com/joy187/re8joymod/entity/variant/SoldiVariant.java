package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum SoldiVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final SoldiVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SoldiVariant::getId)).toArray(SoldiVariant[]::new);
    private final int id;

    SoldiVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SoldiVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}