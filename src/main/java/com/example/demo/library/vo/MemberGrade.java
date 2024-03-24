package com.example.demo.library.vo;

import java.util.Random;

public enum MemberGrade {
    BLACK(0.0), BRONZE(0.95), SILVER(0.90), GOLD(0.85), PLATINUM(0.80);

    public final double value;

    MemberGrade(double value) {
        this.value = value;
    }

}
