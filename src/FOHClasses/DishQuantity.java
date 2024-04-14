package FOHClasses;

public class DishQuantity {
    private int dishID;
    private int quantity;

    public DishQuantity(int dishID, int quantity) {
        this.dishID = dishID;
        this.quantity = quantity;
    }

    public int getDishID() {
        return dishID;
    }

    public int getQuantity() {
        return quantity;
    }
}

