package FOHClasses;

import FOHClasses.Collection.CoverCollection;

import java.util.HashSet;

public class Cover {
    private final int coverId;
    private int tableId;
    private long startTimestamp;
    private long endTimestamp;
    private HashSet<Integer> orders; // Stores the orderIds belonging to this cover

    public Cover(int coverId, long startTimestamp, int tableId) {
        this.coverId = coverId;
        this.tableId = tableId;
        this.startTimestamp = startTimestamp;
        this.orders = new HashSet<>();

        CoverCollection.add(this); // Adds itself to the cover collection
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

    public int getCoverId() {
        return coverId;
    }

    public int getTableId() {
        return tableId;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    // Returns all orderIds
    public int[] getOrders() {
        int[] arr = new int[orders.size()];
        int i = 0;
        for (int id : orders) {
            arr[i++] = id;
        }
        return arr;
    }
}
