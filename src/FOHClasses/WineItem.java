package FOHClasses;

/**
 * A subclass of MenuItem representing wines.
 */
public class WineItem extends MenuItem {

    /**
     * The harvest year of the wine.
     */
    private final int vintage;

    /**
     * Constructs a WineItem whilst utilising the superclass' constructor.
     * @param itemId The ID of the item being created
     * @param name The name of the menu item
     * @param price The price in pence of the item
     * @param description A short text description of the item
     * @param allergens A string of allergens
     * @param vintage The harvest year of the wine
     */
    public WineItem(int itemId, String name, int price, String description, String allergens, int vintage) {
        super(itemId, name, price, description, allergens); // Calls parent method's constructor
        this.vintage = vintage;
    }

    public int getVintage() {
        return vintage;
    }
}
