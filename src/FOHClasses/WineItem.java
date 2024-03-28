package FOHClasses;

public class WineItem extends MenuItem {

    private final int vintage;

    public WineItem(int ID, String name, String allergens, String description, int price, int vintage) {
        super(ID, name, allergens, description, price); // Calls parent method's constructor
        this.vintage = vintage;
    }
}
