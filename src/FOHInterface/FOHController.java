package FOHInterface;

import FOHClasses.*;
import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.OrderCollection;
import FOHClasses.Collection.DishCollection;

public class FOHController implements FOHManagementInterface, FOHKitchenInterface {
    // Class name may be changed at a later date when we figure out how we will implement our system/code.

    //implemented methods
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
        //TODO: Send this information to the Database to store
    }

    public BookableTable createBookableTable (int tableID, int capacity, boolean isAccessible){
        //this makes a Bookable table class
        return new BookableTable(tableID, capacity, isAccessible);
        //TODO: Send this information to the Database to store
    }

    public Waiter createWaiter(int staffID, String name, int pin, String waiterType, String email){
        //This make the waiter class
        return new Waiter(staffID, name, pin, waiterType, email);
        //TODO: Send this information to the Database to store
    }

    public PhysicalTable createTable(int tableID, int childSeats, BookableTable assignedTable){
        //THis makes a physical table class
        return new PhysicalTable(tableID, childSeats, assignedTable);
        //TODO: Send this information to the Database to store
    }


    public void makeBooking(Customer customer, int bookingID, BookableTable reservedTable, String note, int numberOfDiners, long time){
        //This method creates a booking class and then is added in the booking collection for its respectable Bookable table and customer

        if (!reservedTable.checkAvailability(time)){
            //TODO: Indicate that there is no availability for this table at the given time.
        }
        else if (!reservedTable.isAccessible()){ //TODO: add conditions in the IF statement based on customer disabilities
            //TODO: Indicate that the table is not accessible based on the customer
        }
        else {
            Booking booking = new Booking(bookingID, time, customer, reservedTable, note, numberOfDiners);
            //TODO: Send this information to the Database to store

            //Storing the booking object within the booking collections
            customer.addBooking(booking);
            reservedTable.addBooking(booking);
        }

    }

    public Order makeOrder(int orderId, String customerName, int tableNumber, String[] items, String notes, String waiter){
        return new Order(orderId, customerName,tableNumber,items,notes,waiter);
    }

    public void submitOrder(Order order){
        //send order to database
    }

    public void editOrder(int orderId, String customerName, int tableNumber, String[] items, String notes, String waiter){
        Order editedOrder = makeOrder(orderId,customerName,tableNumber,items,notes,waiter);
        submitOrder(editedOrder);

    }

    public void archiveOrder(int OrderId){
        //remove the order and archive it from the database
    }
    public Order getOrder(int orderInt){
        //get the order detail from database
        return null;
    }

    public OrderCollection makeOrderCollection(){
        OrderCollection collection = new OrderCollection();
        //get list of orders
        int[] orderIDs = new int[]{};
        for (int id : orderIDs){
            Order order = getOrder(id);
            collection.addOrder(order);
        }
        return collection;
    }

    public MenuItem getItem(int itemID){
        //get item from database
        return null;
    }

    public Menu makeMenu(){
        //get list of menu id
        DishCollection dishCollection = new DishCollection();
        int[] menuIDs = new int[]{};
        for (int id : menuIDs){
            dishCollection.addItem(getItem(id));
        }
        return new Menu(dishCollection);
    }

    public void addTableToBookable(PhysicalTable table, BookableTable bTable){
        //adds table to the table collection of bookable table
        bTable.addTable(table);
        table.setAssignedTable(bTable);
    }


    public void assignWaiterToTable(Waiter waiter, BookableTable table){
        // assign a waiter to a table and vice versa
        table.assignWaiter(waiter);
        waiter.assignTable(table);
    }

}
