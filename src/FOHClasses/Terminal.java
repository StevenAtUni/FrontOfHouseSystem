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

    /**
     * Adds an entry to the hashmap
     * @param customerName The name of the customer booking the table
     * @param phoneNumber The phone number of the customer booking the table
//     * @param timestamp The UNIX timestamp of the scheduled booking
//     * @param tableId The booked table
     * @param covers The number of covers/guests booked
     */
    public static boolean newBooking(String customerName, String phoneNumber, long startTimestamp, long endTimeStamp, int[] tables, int covers) {
        Arrays.sort(tables); // Ensures sorted into ascending order

        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            if (!table.isAvailable(startTimestamp, endTimeStamp)) return false; // Fails if table not available
        }
        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            table.book(startTimestamp, endTimeStamp);
        }

        Booking booking = new Booking(customerName, phoneNumber, startTimestamp, endTimeStamp, tables);
        for (int i = 0; i < covers; i++) {
            booking.addCover(new Cover(startTimestamp, tables[0]).getCoverId()); // Creates a cover and adds the coverId to the booking
        }
        // Both bookings and covers add to the BookingCollection and CoverCollection via their constructors
        return true;
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
}
