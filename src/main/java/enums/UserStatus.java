package enums;

public enum UserStatus {
    OK(1), BLOCKED(2);

    private final int value;

    UserStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
