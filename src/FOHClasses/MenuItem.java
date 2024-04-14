package FOHClasses;

public class MenuItem {
    private static int nextId = 1;
    private final int itemId;
    private String name;
    private int price;
    private String description;
    private String allergens;
    private boolean isAvailable;

    public MenuItem(int itemId, String name, int price, String description, String allergens) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.allergens = allergens;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
