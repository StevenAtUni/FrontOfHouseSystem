package FOHClasses;

import FOHClasses.Collection.CoverCollection;

public class Cover {
    private static int nextId = 1;
    private final int coverId;
    private long timestamp;
    private int tableId;

    public Cover(long timestamp, int tableId) {
        this.coverId = nextId++; // Increments for the next available ID
        this.timestamp = timestamp;
        this.tableId = tableId;

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
}
