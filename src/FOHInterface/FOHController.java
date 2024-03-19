package FOHInterface;

import FOHClasses.*;
import FOHClasses.Collection.BookingCollection;

public class FOHController implements FOHManagementInterface, FOHKitchenInterface {
    // Class name may be changed at a later date when we figure out how we will implement our system/code.

    @Override
    public void sendMenu(Object[][] menu, Object[][] drinksMenu, Object[][] wineMenu) {
    }

    @Override
    public int getAmountBooked(int timestamp) {
        return 0;
    }

    @Override
    public void setServiceCharge(int newCharge) {
    }

    @Override
    public void markItemComplete(int orderID, int itemID) {
    }

    @Override
    public void markItemUnavailable(int itemID) {
    }

    @Override
    public Object[][] getOrders() {
        return null;
    }

    //Methods

    public Customer createCustomer(int id, String name, String[] allergens, String[] disabilities){
        //this makes a customer class.
        return new Customer(id, name, new BookingCollection(), allergens, disabilities);
        //TODO: Send this information to the Database to store, implement how the UI can use this method
    }

    public void makeBooking(Customer customer, int bookingID, BookableTable reservedTable, String note, int numberOfDiners, long time){
        //This method creates a booking class and then is added in the booking collection for its respectable Bookable table and customer

        if (!reservedTable.checkAvailability(time)){
            //TODO: Indicate that there is no availability for this table at the given time.
        }
        else if (!reservedTable.isAccessible()){ // also add condition based on customer disabilities
            //TODO: Indicate that the table is not accessible based on the customer
        }
        else {
            Booking booking = new Booking(bookingID, time, customer, reservedTable, note, numberOfDiners);
            customer.addBooking(booking);
            reservedTable.addBooking(booking);
        }

    }



}
