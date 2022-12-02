package entity.enums;

public enum Role {
    CLIENT(1), MANAGER(2),  ADMIN(3);

    private final int value;

    Role(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
