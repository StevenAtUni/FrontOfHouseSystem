package FOHClasses;

import FOHClasses.Collection.BookingCollection;

import java.util.HashSet;

public class Booking {
    private static int nextId = 1;
    private final int bookingId;
    private String customerName;
    private String phoneNumber;
    private int numberOfGuests;
    private HashSet<Integer> covers;
    private long timestamp;
//    private int date;
    private int tableId;

    public Booking(String customerName, String phoneNumber, long timestamp, int tableId) {
        this.bookingId = nextId++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
//        this.numberOfGuests = numberOfGuests;
        this.timestamp = timestamp;
//        this.date = date;
        this.tableId = tableId; //table 0 means unassigned for now

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

    public void addCover(int coverId) {
        this.covers.add(coverId);
        numberOfGuests = covers.size();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public long getTime() {
//        return time;
//    }
//
//    public void setTime(long time) {
//        this.time = time;
//    }
//
//    public int getDate() {
//        return date;
//    }
//
//    public void setDate(int date) {
//        this.date = date;
//    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}
