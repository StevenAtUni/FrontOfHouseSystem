package FOHClasses;

import FOHClasses.Collection.BookingCollection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * A class storing information relating to a booking made.
 */
public class Booking {
    private final int bookingId;
    /**
     * The name of the customer who made the booking
     */
    private String customerName;
    /**
     * The phone number of the customer who made the booking
     */
    private String phoneNumber;
    /**
     * The waiter responsible for the booking
     */
    private int waiterId;
    /**
     * Start time of the booking in seconds since UNIX epoch
     */
    private long startTimestamp;
    /**
     * End time of the booking in seconds since UNIX epoch
     */
    private long endTimestamp;
    /**
     * Lowest tableId represents the collective joined tables
     */
    private int tableId;
    /**
     * The tableIds of the booked tables
     */
    private final HashSet<Integer> tables;
    /**
     * The coverIds of the covers belonging to this booking
     */
    private final HashSet<Integer> covers;
    /**
     * The number of guests/covers. Calculated by counting number of coverIds
     */
    private int numberOfGuests;
    /**
     * Whether the booking had paid for their orders yet
     */
    private boolean paid;

    /**
     * Constructs a new booking object.
     * @param bookingId The ID of the booking object to create
     * @param customerName The full name of the customer making the booking
     * @param phoneNumber The phone number of the customer making the booking
     * @param waiterId The unique identification number of the waiter assigned
     * @param startTimestamp The booking's start time in seconds since the UNIX epoch
     * @param endTimestamp The booking's end time in seconds since the UNIX epoch
     * @param tables An array of tableIds booked
     */
    public Booking(int bookingId, String customerName, String phoneNumber, int waiterId, long startTimestamp, long endTimestamp, int[] tables) {
        this.bookingId = bookingId;
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

    /**
     * Adds a new cover to the booking.
     * @param coverId The ID of the cover to add
     */
    public void addCover(int coverId) {
        covers.add(coverId);
        numberOfGuests = covers.size();
    }

    /**
     * Removes a cover from the booking.
     * @param coverId The ID of the cover to remove
     */
    public void removeCover(int coverId) {
        covers.remove(coverId);
        numberOfGuests = covers.size();
    }

    /**
     * Marks a booking as having paid all of its orders
     * @param paid Whether a payment has been made
     */
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

    /**
     * Fetches the IDs of all tables booked.
     * @return An array of tableIds
     */
    public int[] getTables() {
        int[] arr = new int[tables.size()];
        int i = 0;
        for (int id : tables) {
            arr[i++] = id;
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * Fetches the IDs of all covers of the booking.
     * @return An array of coverIds
     */
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
