package lancastersguiv2;

import FOHClasses.Booking;
import FOHClasses.Collection.BookingCollection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

/**
 * This class handles updating the JTable with booking data.
 * It formats and displays each booking's details within the table model.
 */
public class BookingTableManager {

    /**
     * Updates the provided JTable with current booking information.
     * Clears the table and repopulates it with formatted data from all bookings.
     *
     * @param bookingTable The JTable to populate with booking data.
     */
    public static void updateBookingTable(JTable bookingTable) {
        DefaultTableModel model = (DefaultTableModel) bookingTable.getModel();
        model.setRowCount(0);  // Clear existing data

        List<Booking> bookings = BookingCollection.getAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Booking b : bookings) {
            String time = dateFormat.format(new Date(b.getStartTimestamp()));
            String date = dateOnlyFormat.format(new Date(b.getStartTimestamp()));
            String tables = Arrays.toString(b.getTables()).replaceAll("[\\[\\]]", "");

            model.addRow(new Object[]{
                    b.getCustomerName(),
                    b.getPhoneNumber(),
                    b.getNumberOfGuests(),
                    time,
                    date,
                    tables,
                    b.getWaiterId(),
                    calculateBookingLength(b.getStartTimestamp(), b.getEndTimestamp())
            });
        }
    }

    /**
     * Calculates the duration of a booking given start and end timestamps.
     * Outputs the duration as a string in hours and minutes (hh:mm).
     * If the end timestamp is before the start timestamp, logs an error and
     * returns an error message.
     *
     * @param startTimestamp The start time of the booking in milliseconds since epoch.
     * @param endTimestamp The end time of the booking in milliseconds since epoch.
     * @return A string representing the booking duration in HH:mm format, or an error message.
     */
    private static String calculateBookingLength(long startTimestamp, long endTimestamp) {
        if (endTimestamp < startTimestamp) {
            System.out.println("Error: End timestamp is less than start timestamp.");
            return "Error in timestamps";
        }
        long durationSeconds = endTimestamp - startTimestamp;
        long minutes = durationSeconds / 60;
        long hours = minutes / 60;
        minutes = minutes % 60;
        return String.format("%d:%02d", hours, minutes);
    }
}
