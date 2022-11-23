package entity;

public enum Role {
    CLIENT(1), MANAGER(2), OWNER(3), ADMIN(4);

    private int value;

    Role(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
