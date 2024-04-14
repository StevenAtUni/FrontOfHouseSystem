package FOHClasses;

public class BookableTable {
    private static int nextId = 1;
    private final int tableID;
    private int capacity;
//    private long[] bookedTimes;
//    private BookingCollection bookingCollection;
    //isAccessibleTable directly conveys the concept of being usable by people with disabilities
//    private boolean isAccessible;
//    private TableCollection tableCollection;
//    private WaiterCollection assignedWaiters;

    public BookableTable() {
        this.tableID = nextId;
        this.capacity = 2;
//        this.isAccessible = isAccessible;
//        this.bookingCollection = new BookingCollection();
//        this.assignedWaiters = new WaiterCollection();
//        this.tableCollection = new TableCollection();
    }

    public static void setNextId(int nextId) {
        if (BookableTable.nextId < nextId) BookableTable.nextId = nextId; // Only allows nextId to be increased
    }

    public static class OrderedDishes {
    }
}
