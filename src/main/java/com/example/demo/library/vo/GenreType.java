package com.example.demo.library.vo;

import java.util.Random;

public enum GenreType {
    TYPE1, TYPE2, TYPE3, TYPE4, TYPE5, TYPE6, TYPE7, TYPE8;

    private static final Random RANDOM = new Random();
    private static final GenreType[] VALUES = values();

    public static GenreType getRandomGenreType() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

}
