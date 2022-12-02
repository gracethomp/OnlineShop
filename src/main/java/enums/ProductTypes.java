package enums;

public enum ProductTypes {
    CLOTHES(1),
    TECHNIC(2),
    HOUSEHOLD(3),
    TOOLS(4),
    PLUMBING(5),
    GARDEN(6),
    SPORT(7),
    BEAUTY(8),
    CHILDREN(9),
    PETS(10),
    SCHOOL(11);

    private final int value;

    ProductTypes(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
