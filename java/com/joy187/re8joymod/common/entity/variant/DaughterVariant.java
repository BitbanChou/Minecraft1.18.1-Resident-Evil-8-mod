package com.joy187.re8joymod.common.entity.variant;


import java.util.Arrays;
import java.util.Comparator;

public enum DaughterVariant {
    DEFAULT(0),
    CASSANDRA(1),
    DANIELA(2);

    private static final DaughterVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DaughterVariant::getId)).toArray(DaughterVariant[]::new);
    private final int id;

    DaughterVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static DaughterVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}