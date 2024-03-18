package FOHClasses;

public class Dish {
    private final String dishName;
    private final String ingredients;
    private int price;
    private String allergens;
    private boolean isAvailable;

    public Dish(String dishName, String ingredients, int price, String allergens) {
        this.dishName = dishName;
        this.ingredients = ingredients;
        this.price = price;
        this.allergens = allergens;
        this.isAvailable = true;
    }
    //Getters

    public String getDishName() {
        return dishName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    public String getAllergens() {
        return allergens;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    //Setters

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
