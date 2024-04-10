package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Order {
    private final int orderId;
    private String customerName;
    private int tableNumber;
    private String[] items;
    private String notes;
    private String waiter;

    public Order(int orderId, String customerName, int tableNumber, String[] items, String notes, String waiter) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.items = items;
        this.notes = notes;
        this.waiter = waiter;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
}
