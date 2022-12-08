package com.solvd.entity.enums;

public enum Rating {
    STAR1(1), STAR2(2), STAR3(3), STAR4(4), STAR(5);

    private final int value;

    Rating(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
