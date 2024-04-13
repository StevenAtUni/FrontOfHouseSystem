package FOHClasses;

import FOHClasses.Collection.PhysicalTableCollection;
import FOHClasses.Collection.TableCollection;
import FOHClasses.Collection.WaiterCollection;

import java.util.ArrayList;
import java.util.HashMap;

public class PhysicalTable {
    private static int nextId = 1;
    private final int tableId;
//    private int childSeats;
    private HashMap<Long, Long> bookedTimes; // Key = startTimestamp, Value = endTimeStamp

    public PhysicalTable() {
        this.tableId = nextId++;
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

    public boolean isAvailable(long startTimestamp, long endTimestamp) {
        for (HashMap.Entry<Long, Long> booking : bookedTimes.entrySet()) {
            if ((startTimestamp >= booking.getKey() && startTimestamp < booking.getValue()) ||
                    (endTimestamp > booking.getKey() && endTimestamp < booking.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean book(long startTimestamp, long endTimestamp) {
        if (isAvailable(startTimestamp, endTimestamp)) {
            bookedTimes.put(startTimestamp, endTimestamp);
            return true;
        }
        return false;
    }

    public void unbook(long startTimestamp) {
        bookedTimes.remove(startTimestamp);
    }
}
