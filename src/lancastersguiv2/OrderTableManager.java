package lancastersguiv2;

import FOHClasses.Booking;
import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.CoverCollection;
import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.Collection.OrderCollection;
import FOHClasses.Cover;
import FOHClasses.MenuItem;
import FOHClasses.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;

public class OrderTableManager {
    public static void updateOrderTable(JTable orderTable) {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);  // Clear existing data

        List<Order> orders = OrderCollection.getAll();

        int bookingID = 0;
        int coverID = 0;
        int tableID = 0;
        int orderID = 0;
        String note = "";
        int waiterID = 0;
        String bookingIDs = "";
        String coverIDs = "";
        String tableIDs = "";
        String waiterIDs = "" ;
        String items = "";

        for (Order order : orders) {
            for (Booking booking: BookingCollection.getAll()){
                if (booking.getTableId() == order.getTableId()){
                    bookingID = booking.getBookingId();
                    waiterID = booking.getWaiterId();
                }

            }
            for (Cover cover: CoverCollection.getAll()){
                for (int i:cover.getOrders()){
                    if (i == order.getOrderId()){
                        coverID = cover.getCoverId();
                    }
                }
            }

            orderID = order.getOrderId();

            items = order.getItemString();

            tableID = order.getTableId();

            note = order.getNotes();

            bookingIDs = String.valueOf(bookingID);

            coverIDs = String.valueOf(coverID);

            tableIDs = String.valueOf(tableID);

            waiterIDs = String.valueOf(waiterID);

            model.addRow(new Object[]{
                    bookingIDs,
                    coverIDs,
                    orderID,
                    tableIDs,
                    items,
                    note,
                    waiterIDs
            });
        }

    }

}
