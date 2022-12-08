package com.solvd.entity.enums;

public enum CardType {
    VISA(1), MASTERCARD(2);
    private final int value;

    CardType(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
