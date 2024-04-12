package FOHClasses;

public class MenuItem {
    private final int ID;
    private final String name;
//    private final String ingredients;
    private final String allergens;
    private final String description;
    private final int price;
    private boolean isAvailable;

    public MenuItem(int ID, String name, String allergens, String description, int price) {
        this.ID = ID;
        this.name = name;
        this.allergens = allergens;
        this.description = description;
//        this.ingredients = ingredients;
        this.price = price;
        this.isAvailable = true;
    }

    //Getters

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

//    public String getIngredients() {
//        return ingredients;
//    }

    //Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
