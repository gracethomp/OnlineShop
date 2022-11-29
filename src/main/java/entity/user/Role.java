package entity.user;

public enum Role {
    CLIENT(1), MANAGER(2),  ADMIN(3);

    private int value;

    Role(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
