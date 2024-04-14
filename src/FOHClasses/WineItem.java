package FOHClasses;

public class WineItem extends MenuItem {

    private final int vintage;

    public WineItem(int itemId, String name, int price, String description, String allergens, int vintage) {
        super(itemId, name, price, description, allergens); // Calls parent method's constructor
        this.vintage = vintage;
    }
}
