package FOHClasses;

public class OrderedDish {
    private int ID;
    private int orderId;
    private int menuItemID;
    private int quantity;
    private boolean ready;

    public OrderedDish(int ID, int orderId,int menuItemID, int quantity) {
        this.ID = ID;
        this.orderId = orderId;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
        this.ready = false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
