package com.solvd.entity.enums;

public enum Sizes {
    XS(1, 44),
    S(2, 46),
    M(3, 48),
    L(4, 50),
    XL(5, 52);

    private final int logicOrder;
    private final int europeanSize;

    Sizes(int i, int europeanSize) {
        this.logicOrder = i;
        this.europeanSize = europeanSize;
    }

    public int getLogicOrder() {
        return logicOrder;
    }

    public int getEuropeanSize() {
        return europeanSize;
    }
}
