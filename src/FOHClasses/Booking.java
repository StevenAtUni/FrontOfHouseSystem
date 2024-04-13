package FOHClasses;

import FOHClasses.Collection.BookingCollection;

import java.util.HashSet;

public class Booking {
    private static int nextId = 1;
    private final int bookingId;
    private String customerName;
    private String phoneNumber;
    private long startTimestamp;
    private long endTimestamp;
    private int tableId;
    private HashSet<Integer> tables;
    private HashSet<Integer> covers;
    private int numberOfGuests;

    public Booking(String customerName, String phoneNumber, long startTimestamp, long endTimestamp, int[] tables) {
        this.bookingId = nextId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.tableId = tables[0];
        this.tables = new HashSet<>();
        for (int tableId : tables) {
            this.tables.add(tableId);
        }

        // Assigns the covers to the booking
        this.covers = new HashSet<>();
        BookingCollection.add(this);
    }

    public static void setNextId(int nextId) {
        if (Booking.nextId < nextId) Booking.nextId = nextId; // Only allows nextId to be increased
    }

    public int getBookingId() {
        return bookingId;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public int[] getTables() {
        int[] arr = new int[tables.size()];
        int i = 0;
        for (int id : tables) {
            arr[i++] = id;
        }
        return arr;
    }

    public void addCover(int coverId) {
        this.covers.add(coverId);
        numberOfGuests = covers.size();
    }

    public void removeCover(int coverId) {

    }

    public int[] getCovers() {
        int[] arr = new int[covers.size()];
        int i = 0;
        for (int id : covers) {
            arr[i++] = id;
        }
        return arr;
    }
}
