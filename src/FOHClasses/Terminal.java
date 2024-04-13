package FOHClasses;

public class Terminal {

    /**
     * Adds an entry to the hashmap
     * @param customerName The name of the customer booking the table
     * @param phoneNumber The phone number of the customer booking the table
     * @param timestamp The UNIX timestamp of
     */
    public static void newBooking(String customerName, String phoneNumber, long timestamp, int tableId, int covers) {
        Booking booking = new Booking(customerName, phoneNumber, timestamp, tableId);
        for (int i = 0; i < covers; i++) {
            booking.addCover(new Cover(timestamp, tableId).getCoverId()); // Creates a cover and adds the coverId to the booking
        }
    }


}
