package FOHClasses;

import FOHClasses.Collection.CoverCollection;

import java.util.HashSet;

public class Cover {
    private static int nextId = 1;
    private final int coverId;
    private long startTimestamp;
    private long endTimestamp;
    private int tableId;
    private HashSet<Integer> orders;

    public Cover(long startTimestamp, int tableId) {
        this.coverId = nextId++; // Increments for the next available ID
        this.startTimestamp = startTimestamp;
        this.tableId = tableId;
        this.orders = new HashSet<>();

        CoverCollection.add(this); // Adds itself to the cover collection
    }

    public static void setNextId(int nextId) {
        if (Cover.nextId < nextId) Cover.nextId = nextId; // Only allows nextId to be increased
    }

    public int getCoverId() {
        return coverId;
    }

    public int getTableId() {
        return tableId;
    }

    public boolean addOrder(int orderId){
        if (orders.contains(orderId)) return false; // Returns false if the order has already been added
        orders.add(orderId);
        return true;
    }

    public boolean removeOrder(int orderId){
        if (orders.contains(orderId)) {
            orders.remove(orderId);
            return true;
        }
        return false;
    }
}
