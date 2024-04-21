package FOHClasses;

import FOHClasses.Collection.PhysicalTableCollection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class representing each physical table in the restaurant that is available to booking.
 */
public class PhysicalTable {
    /**
     * The next available ID number
     */
    private static int nextId = 1;
    private final int tableId;
    /**
     * A HashMap storing the startTimestamp as the key and endTimestamp as the value, both as seconds since UNIX epoch.
     */
    private HashMap<Long, Long> bookedTimes;

    /**
     * Constructor for a physical table.
     */
    public PhysicalTable() {
        this.tableId = nextId++; // Auto-increments the tableId
//        this.childSeats = 0;
        this.bookedTimes = new HashMap<>();

        PhysicalTableCollection.add(this);
    }

    public static void setNextId(int nextId) {
        if (PhysicalTable.nextId < nextId) PhysicalTable.nextId = nextId; // Only allows nextId to be increased
    }

    public int getTableId() {
        return tableId;
    }

    /**
     * Checks if the table is available during the provided timeframe.
     * @param startTimestamp The start of the range to check in seconds since the UNIX epoch
     * @param endTimestamp The end of the range to check in seconds since the UNIX epoch
     * @return True if the table is available during the provided time range
     */
    public boolean isAvailable(long startTimestamp, long endTimestamp) {
        for (HashMap.Entry<Long, Long> booking : bookedTimes.entrySet()) {
            if ((booking.getKey() <= startTimestamp && startTimestamp < booking.getValue()) ||
                    (booking.getKey() < endTimestamp && endTimestamp < booking.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reserves a table for the provided timeframe. Also checks if available during the time before booking.
     * @param startTimestamp The start time of the booking in seconds since the UNIX epoch
     * @param endTimestamp The end time of the booking in seconds since the UNIX epoch
     * @return True if the reservation was successful
     */
    public boolean book(long startTimestamp, long endTimestamp) {
        if (isAvailable(startTimestamp, endTimestamp)) {
            bookedTimes.put(startTimestamp, endTimestamp);
            return true;
        }
        return false;
    }

    /**
     * Unbooks a reservation that starts at the provided time.
     * @param startTimestamp The start time of the booking in seconds since the UNIX epoch
     */
    // Releases a reservation.
    public void unbook(long startTimestamp) {
        bookedTimes.remove(startTimestamp);
    }
}
