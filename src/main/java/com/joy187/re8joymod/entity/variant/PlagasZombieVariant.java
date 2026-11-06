package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum PlagasZombieVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final PlagasZombieVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(PlagasZombieVariant::getId)).toArray(PlagasZombieVariant[]::new);
    private final int id;

    PlagasZombieVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PlagasZombieVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}