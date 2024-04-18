package FOHClasses;

import FOHClasses.Collection.CoverCollection;

import java.util.HashSet;

/**
 * A class storing information of a cover, primarily which orders belong to it.
 */
public class Cover {
    private final int coverId;
    /**
     * The ID of the table that this cover belongs to
     */
    private int tableId;
    /**
     * Start time of the booking/cover in seconds since UNIX epoch
     */
    private long startTimestamp;
    /**
     * End time of the booking/cover in seconds since UNIX epoch
     */
    private long endTimestamp;
    /**
     * The IDs of the orders belonging to this cover
     */
    private HashSet<Integer> orders; // Stores the orderIds belonging to this cover

    /**
     * Constructs a new cover object
     * @param coverId The ID of the cover object to create
     * @param startTimestamp The booking/cover's start time in seconds since the UNIX epoch
     * @param tableId The table number that this cover is sat at
     */
    public Cover(int coverId, long startTimestamp, int tableId) {
        this.coverId = coverId;
        this.tableId = tableId;
        this.startTimestamp = startTimestamp;
        this.orders = new HashSet<>();

        CoverCollection.add(this); // Adds itself to the cover collection
    }

    /**
     * Adds a new order to the cover.
     * @param orderId The ID of the order to add
     * @return Whether an order was successfully added. Fails if order already added
     */
    public boolean addOrder(int orderId){
        if (orders.contains(orderId)) return false; // Returns false if the order has already been added
        orders.add(orderId);
        return true;
    }

    /**
     * Removes an order from the cover.
     * @param orderId The ID of the order to remove
     * @return Whether the order existed and was part of the cover
     */
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

    /**
     * Fetches the IDs of all orders booked.
     * @return An array of orderIds
     */
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
