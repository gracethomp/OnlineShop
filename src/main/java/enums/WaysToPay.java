package enums;

public enum WaysToPay {
    CASH(1), FULL_PREPAYMENT(2), PARTIAL_PREPAYMENT(3);

    private final int value;

    WaysToPay(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
