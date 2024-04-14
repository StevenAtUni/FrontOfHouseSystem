package FOHClasses;

public class OrderedDish {
    private static int nextId = 1;
    private  int id;
    private int orderID;
    private int menuItemID;
    private int quantity;
    private boolean isReady;

    public OrderedDish(int id,int orderID, int menuItemID, int quantity ) {
        this.id = nextId++;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
        this.isReady = false;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
