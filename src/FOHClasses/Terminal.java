package FOHClasses;

import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.CoverCollection;
import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.Collection.PhysicalTableCollection;
import FOHClasses.DatabaseDAO.BookingDAO;
import FOHClasses.DatabaseDAO.MenuDAO;
import FOHClasses.DatabaseDAO.OrderDAO;
import FOHInterface.ManagementInterface.IRecord;
//import orders.FOHImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class Terminal {
    private static final int numOfTables = 15;

    public static void initialise() {
        for (int i = 1; i <= numOfTables; i++) {
            new PhysicalTable();
        }

        // Dummy data
        newBooking("John Smith", "12345678910", 1, 1706814000, 1706817600, new int[]{6,7}, 3);
        MenuItemCollection.add(new MenuItem(1, "DemoDish1", 1000, "This is a dish.", "Allergen1"));
        MenuItemCollection.add(new MenuItem(2, "DemoDish2", 2500, "A meal.", "Allergen1, Allergen2"));
//        BookingDAO.returnBookings();
//        MenuDAO.getMenu();
    }

    // For creating a new booking from the UI
    public static boolean newBooking(String customerName, String phoneNumber, int waiterId, long startTimestamp, long endTimestamp, int[] tables, int covers) {
        if (!checkArrangement(tables.length, covers)) return false;

        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            if (!table.isAvailable(startTimestamp, endTimestamp)) return false; // Fails if table not available
        }

        int[] ids = BookingDAO.createBooking(covers, waiterId, customerName, phoneNumber, startTimestamp, endTimestamp, tables);

        Booking booking = createBooking(ids[0], customerName, phoneNumber, waiterId, startTimestamp, endTimestamp, tables);
        if (booking == null) return false;
        for (int coverId = 1; coverId < ids.length; coverId++) {
            booking.addCover(new Cover(coverId, startTimestamp, tables[0]).getCoverId()); // Creates a cover and adds the coverId to the booking
        }
        // TODO Call database add here
        return true;
    }

    // For loading bookings from the database
    public static boolean loadBooking(int bookingId, String customerName, String phoneNumber, int waiterId, long startTimestamp, long endTimeStamp, int[] tables, int[] covers) {
        Booking booking = createBooking(bookingId, customerName, phoneNumber, waiterId, startTimestamp, endTimeStamp, tables);
        if (booking == null) return false;

        // The constructor of Booker adds itself to the BookingCollection
        for (int coverId : covers) {
            booking.addCover(coverId); // Creates a cover and adds the coverId to the booking
        }
        return true;
    }

    private static Booking createBooking(int bookingId, String customerName, String phoneNumber, int waiterId, long startTimestamp, long endTimeStamp, int[] tables) {
        Arrays.sort(tables); // Ensures sorted into ascending order

        for (int tableId : tables) {
            PhysicalTable table = PhysicalTableCollection.get(tableId);
            table.book(startTimestamp, endTimeStamp);
        }

        return new Booking(bookingId, customerName, phoneNumber, waiterId, startTimestamp, endTimeStamp, tables);
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

    // For creating a new order from the UI
    public static void newOrder(int bookingId, int coverId, int[] items, String notes) {
        Booking booking = BookingCollection.get(bookingId);
        int orderId = OrderDAO.createOrder(coverId, notes, items);
        Order order = new Order(orderId, booking.getTableId(), items, notes);
        Cover cover = CoverCollection.get(coverId);
        cover.addOrder(order.getOrderId());
        
        // Sends order to the kitchen
//        FOHImpl.getInstance().makeOrder(order.getOrderId(), order.getTableId(), items, notes);
    }

    // For loading bookings from the database
    public static void loadOrder(int orderId, int tableId, int[] items, String notes) {
        new Order(orderId, tableId, items, notes);
    }

    public static void payWholeBill(int bookingId, boolean isCash) {
        Booking booking = BookingCollection.get(bookingId);
        int[] covers = booking.getCovers();

        ArrayList<Integer> items = new ArrayList<>();
        for (int coverId : covers) {
            Cover cover = CoverCollection.get(coverId);
            int[] orders = cover.getOrders();
            for (int itemId : orders) {
                items.add(itemId);
            }
        }

        createBill(booking, isCash, items, true);
    }

    public static void paySplitBill(int bookingId, boolean isCash) {
        Booking booking = BookingCollection.get(bookingId);
        int[] covers = booking.getCovers();

        for (int coverId : covers) {
            ArrayList<Integer> items = new ArrayList<>();
            Cover cover = CoverCollection.get(coverId);
            int[] orders = cover.getOrders();
            for (int itemId : orders) {
                items.add(itemId);
            }
            createBill(booking, isCash, items, true);
        }
    }

    private static void createBill(Booking booking, boolean isCash, ArrayList<Integer> items, boolean applyServiceCharge) {
        Bill bill = new Bill(booking.getWaiterId(), booking.getStartTimestamp(), booking.getEndTimestamp(), isCash, items, applyServiceCharge);

        // TODO Sends to management
//        IRecord.sendReceipt((int) booking.getStartTimestamp(), (int) booking.getEndTimestamp(), booking.getNumberOfGuests(), items, 0, bill.getServiceCharge());
    }
}
