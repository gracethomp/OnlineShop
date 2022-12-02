package enums;

public enum Sizes {
    XS(1), S(2), M(3), L(4), XL(5);

    private final int value;

    Sizes(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
