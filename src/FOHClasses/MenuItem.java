package FOHClasses;

/**
 * A class representing a standard menu item (a dish).
 * Acts as a super class to other types of menu items, such as WineItem.
 */
public class MenuItem {
    private static int nextId = 1;
    private final int itemId;
    /**
     * Name of the item.
     */
    private String name;
    /**
     * Item's price in pence.
     */
    private int price;
    /**
     * Description of the item, often containing significant ingredients.
     */
    private String description;
    /**
     * String of allergens within the item.
     */
    private String allergens;
    /**
     * Whether the item is still available and can be produced by the kitchen.
     */
    private boolean isAvailable;

    /**
     * Constructs a MenuItem object.
     * @param itemId The ID of the item being created
     * @param name The name of the menu item
     * @param price The price in pence of the item
     * @param description A short text description of the item
     * @param allergens A string of allergens
     */
    public MenuItem(int itemId, String name, int price, String description, String allergens) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.allergens = allergens;
        this.isAvailable = true;
    }

    /**
     * For changing the availability of this dish.
     * @param available Whether the dish is currently available
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getAllergens() {
        return allergens;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
