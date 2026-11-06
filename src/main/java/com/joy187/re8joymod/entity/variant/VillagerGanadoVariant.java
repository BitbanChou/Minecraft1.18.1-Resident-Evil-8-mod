package com.joy187.re8joymod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;


public enum VillagerGanadoVariant {
    DEFAULT(0),
    SWORD(1),
    CRAZY(2);

    private static final VillagerGanadoVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(VillagerGanadoVariant::getId)).toArray(VillagerGanadoVariant[]::new);
    private final int id;

    VillagerGanadoVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static VillagerGanadoVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}