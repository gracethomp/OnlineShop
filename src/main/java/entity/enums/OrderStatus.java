package entity.enums;

public enum OrderStatus {
    REGISTERED(1), IN_PROGRESS(2), CANCELLED(3), DONE(4);

    private final int value;

    OrderStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
