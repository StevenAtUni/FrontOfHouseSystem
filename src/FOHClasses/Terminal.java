package FOHClasses;

import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.CoverCollection;
import FOHClasses.Collection.PhysicalTableCollection;

import java.util.Arrays;

public class Terminal {

    public static void initialise() {
        for (int i = 1; i <= 15; i++) {
            new PhysicalTable();
        }
    }

    // For creating a new booking from the UI
    public static boolean newBooking(String customerName, String phoneNumber, long startTimestamp, long endTimeStamp, int[] tables, int covers) {
        if (!checkArrangement(tables.length, covers)) return false;

        Booking booking = createBooking(customerName, phoneNumber, startTimestamp, endTimeStamp, tables);
        if (booking == null) return false;
        for (int i = 0; i < covers; i++) {
            booking.addCover(new Cover(startTimestamp, tables[0]).getCoverId()); // Creates a cover and adds the coverId to the booking
        }
        // Call database add here
        return true;
    }

    // For loading bookings from the database
    public static boolean loadBooking(String customerName, String phoneNumber, long startTimestamp, long endTimeStamp, int[] tables, int[] covers) {
        Booking booking = createBooking(customerName, phoneNumber, startTimestamp, endTimeStamp, tables);
        if (booking == null) return false;

        // The constructor of Booker adds itself to the BookingCollection
        for (int coverId : covers) {
            booking.addCover(coverId); // Creates a cover and adds the coverId to the booking
        }
        return true;
    }

    private static Booking createBooking(String customerName, String phoneNumber, long startTimestamp, long endTimeStamp, int[] tables) {
        Arrays.sort(tables); // Ensures sorted into ascending order

        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            if (!table.isAvailable(startTimestamp, endTimeStamp)) return null; // Fails if table not available
        }
        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            table.book(startTimestamp, endTimeStamp);
        }

        return new Booking(customerName, phoneNumber, startTimestamp, endTimeStamp, tables);
    }

    /**
     * Unbooks a booking
     * @param bookingId The id of the booking to be deleted
     * @return A boolean identifying whether a booking was removed
     */
    public static boolean deleteBooking(int bookingId) {
        try {
            Booking booking = BookingCollection.get(bookingId);
            int[] covers = booking.getCovers();
            for (int coverId : covers) {
                CoverCollection.remove(coverId);
            }

            int[] tables = booking.getTables();
            for (int tableId : tables) { // For each table booked by the booking
                // Gets the table object and calls unbook() on it with the timestamp from the booking
                PhysicalTableCollection.get(tableId).unbook(booking.getStartTimestamp());
            }

            BookingCollection.remove(bookingId); // Finally, removes the booking
            return true;
        } catch (Exception e) {
            System.err.println("Tried to delete a booking that did not exist.");
            return false;
        }
    }

    /* TODO
    public static boolean editBooking(int bookingId, String customerName, String phoneNumber, long startTimestamp, long endTimeStamp, int[] tables, int newCovers) {
        if (!checkArrangement(tables.length, newCovers)) return false;

        Booking booking = BookingCollection.get(bookingId);
        int currentCovers = booking.getCovers().length;
        if (currentCovers != newCovers) {
            int difference = newCovers - currentCovers;

            if (difference > 0) {
                for (int i = 0; i < difference; i++) booking.addCover(new Cover(startTimestamp, tables[0]).getCoverId());
            } else if (difference < 0) {
                for (int i = 0; i < difference; i++) {

                }
                int[] covers = booking.getCovers();
                for (int coverId : covers) {
                    CoverCollection.remove(coverId);
                }
            }
        }
        return true;
    }
     */

    public static boolean checkArrangement(int tables, int covers) {
        if ((covers / 2f) > tables) return false; // Returns false if more covers than table can sit
        return true;
    }

    public static void createOrder() {

    }
}
