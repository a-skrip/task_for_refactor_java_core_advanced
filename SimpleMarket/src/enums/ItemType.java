package enums;

public enum ItemType {
    KNIFE(1),
    PLATE(2),
    TABLE(3),
    CHAIR(4);

    private final Integer inventNumber;

    ItemType(int inventNumber) {
        this.inventNumber = inventNumber;
    }

    public Integer getInventNumber() {
        return inventNumber;
    }

    public static ItemType getByNumber(Integer number) {
        return switch (number) {
            case 1 -> KNIFE;
            case 2 -> PLATE;
            case 3 -> TABLE;
            case 4 -> CHAIR;
            default -> null;
        };
    }
}
