package FOHClasses;

import FOHClasses.Collection.OrderCollection;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private final int orderId;
    private int tableId;
    private String notes;
//    private String waiter;
    private boolean complete;
    private List<Integer> items;

    public Order(int orderId, int tableId, int[] items, String notes) {
//        this.orderId = nextId++;
        this.orderId = orderId;
        this.tableId = tableId;
        this.notes = notes;
//        this.waiter = waiter;
        this.complete = false;


        this.items = new ArrayList<>();
        for (int itemId : items) {
            this.items.add(itemId);
        }
        OrderCollection.add(this);
    }

    public static void setNextId(int nextId) {
        if (Order.nextId < nextId) Order.nextId = nextId; // Only allows nextId to be increased
    }

    public void addItem(int itemId) {
        this.items.add(itemId);
    }

    public void removeItem(int itemId) {
        this.items.remove(itemId);
    }

    public void amendNotes(String notes) {
        this.notes = notes;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public String getNotes() {
        return notes;
    }

    public int[] getItems() {
        int[] arr = new int[items.size()];
        int i = 0;
        for (int id : items) {
            arr[i++] = id;
        }
        return arr;
    }
}


