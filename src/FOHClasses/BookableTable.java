package FOHClasses;

import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.TableCollection;
import FOHClasses.Collection.WaiterCollection;

public class BookableTable {
    private final int tableID;
    private int capacity;
    private long[] bookedTimes;
    private BookingCollection bookingCollection;
    //isAccessibleTable directly conveys the concept of being usable by people with disabilities
    private boolean isAccessible;
    private TableCollection tableCollection;
    private WaiterCollection assignedWaiters;

    public BookableTable(int tableID, int capacity, boolean isAccessible) {
        this.tableID = tableID;
        this.capacity = capacity;
        this.isAccessible = isAccessible;
        this.bookingCollection = new BookingCollection();
        this.assignedWaiters = new WaiterCollection();
        this.tableCollection = new TableCollection();
    }

    public WaiterCollection getAssignedWaiters() {
        return assignedWaiters;
    }

    public void setAssignedWaiters(WaiterCollection assignedWaiters) {
        this.assignedWaiters = assignedWaiters;
    }

    //Getter
    public int getTableID() {
        return tableID;
    }

    public int getCapacity() {
        return capacity;
    }

    public long[] getBookedTimes() {
        return bookedTimes;
    }

    public BookingCollection getBookingCollection() {
        return bookingCollection;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public TableCollection getTableCollection() {
        return tableCollection;
    }

    //Setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBookedTimes(long[] bookedTimes) {
        this.bookedTimes = bookedTimes;
    }

    public void setBookingCollection(BookingCollection bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public void setTableCollection(TableCollection tableCollection) {
        this.tableCollection = tableCollection;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    //Methods
    public boolean checkAvailability(long time){
        //TODO
        return true;
    }

    public void addTable(PhysicalTable table){
        //TODO
    }

    public void removeTable(PhysicalTable table){
        //TODO
    }

    public void addBooking(Booking booking){
        //TODO
    }
    public void removeBooking(Booking booking){
        //TODO
    }
    public void cancel(){
        //TODO
    }
    public void assignWaiter(Waiter waiter){
        //TODO
    }
    public void removeWaiter(Waiter waiter){
        //TODO
    }

}
