package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum PlagasVillagerVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final PlagasVillagerVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(PlagasVillagerVariant::getId)).toArray(PlagasVillagerVariant[]::new);
    private final int id;

    PlagasVillagerVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PlagasVillagerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}