package FOHClasses;

import FOHClasses.Collection.OrderCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * A class storing information relating to an order made by the customer.
 */
public class Order {
    /**
     * Unused
     */
    private static int nextId = 1;
    private final int orderId;
    private int tableId;
    /**
     * Notes for the kitchen attached to an order
     */
    private String notes;
    /**
     * Whether the order has been completed
     */
    private boolean complete;
    /**
     * Stores the menu IDs of the menuItems ordered
     */
    private List<Integer> items;

    /**
     * Constructs an order object.
     * @param orderId The unique identifier to give to this order object
     * @param tableId The table number that this order is destined for
     * @param items A list of IDs that have been ordered, each representing a dish
     * @param notes The custom note for the kitchen
     */
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

    /**
     * Unused.
     */
    public static void setNextId(int nextId) {
        if (Order.nextId < nextId) Order.nextId = nextId; // Only allows nextId to be increased
    }

    /**
     * For modifying the order with a new item.
     * @param itemId ID of the new menu item to add
     */
    public void addItem(int itemId) {
        this.items.add(itemId);
    }

    /**
     * For modifying the order to remove an item.
     * @param itemId ID of the new menu item to remove
     */
    public void removeItem(int itemId) {
        this.items.remove(itemId);
    }

    /**
     * Overrides the previous order note.
     * @param notes The new order note
     */
    public void amendNotes(String notes) {
        this.notes = notes;
    }

    /** For updating the status of an order.
     * @param complete Whether the order has been completed
     */
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

    /**
     * Fetches all items ordered.
     * @return An array of IDs of the items ordered
     */
    // Returns all itemIds
    public int[] getItems() {
        int[] arr = new int[items.size()];
        int i = 0;
        for (int id : items) {
            arr[i++] = id;
        }
        return arr;
    }

    public boolean isComplete() {
        return complete;
    }
}


