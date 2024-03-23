package com.example.demo.library.vo;

import java.util.Random;

public enum DamageLevel {
    LV1(1), LV2(0.9), LV3(0.8), LV4(0.7), LV5(0.6);

    public final double value;

    DamageLevel(double value) {
        this.value = value;
    }

    private static final Random RANDOM = new Random();
    private static final DamageLevel[] VALUES = values();

    public static DamageLevel getRandomGenreType() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

}
