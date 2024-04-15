package FOHClasses;

import FOHClasses.Collection.BookingCollection;

import java.util.Arrays;
import java.util.HashSet;

public class Booking {
    private static int nextId = 1;
    private final int bookingId;
    private String customerName;
    private String phoneNumber;
    private int waiterId;
    private long startTimestamp;
    private long endTimestamp;
    private int tableId;
    private final HashSet<Integer> tables;
    private final HashSet<Integer> covers;
    private int numberOfGuests;
    private boolean paid;

    public Booking(String customerName, String phoneNumber, int waiterId, long startTimestamp, long endTimestamp, int[] tables) {
        this.bookingId = nextId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.waiterId = waiterId;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.tableId = tables[0];
        this.tables = new HashSet<>();
        for (int tableId : tables) {
            this.tables.add(tableId);
        }

        // Assigns the covers to the booking
        this.covers = new HashSet<>();
        this.paid = false;
        BookingCollection.add(this);
    }

    public static void setNextId(int nextId) {
        if (Booking.nextId < nextId) Booking.nextId = nextId; // Only allows nextId to be increased
    }

    public void addCover(int coverId) {
        covers.add(coverId);
        numberOfGuests = covers.size();
    }

    public void removeCover(int coverId) {
        covers.remove(coverId);
        numberOfGuests = covers.size();
    }

    public void setPaid(boolean paid) {
        if (paid) this.paid = true; // Doesn't allow something to become unpaid
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public int getTableId() {
        return tableId;
    }

    public int[] getTables() {
        int[] arr = new int[tables.size()];
        int i = 0;
        for (int id : tables) {
            arr[i++] = id;
        }
        Arrays.sort(arr);
        return arr;
    }

    public int[] getCovers() {
        int[] arr = new int[covers.size()];
        int i = 0;
        for (int id : covers) {
            arr[i++] = id;
        }
        return arr;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isPaid() {
        return paid;
    }
}
