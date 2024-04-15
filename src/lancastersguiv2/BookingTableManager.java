package lancastersguiv2;

import FOHClasses.Booking;
import FOHClasses.Collection.BookingCollection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

public class BookingTableManager {
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

    private static String calculateBookingLength(long startTimestamp, long endTimestamp) {
        long durationMillis = endTimestamp - startTimestamp;
        long minutes = (durationMillis / 1000) / 60;
        long hours = minutes / 60;
        minutes = minutes % 60;
        return String.format("%d:%02d", hours, minutes);
    }

}
