package FOHClasses;

import java.util.function.ToDoubleBiFunction;

public class Booking {
    private final int bookingInt;
    private long time;
    private final Customer customer;
    private BookableTable reservedTable;
    private String note;
    private int numberOfPeople;


    //constructor
    public Booking(int bookingInt, long time, Customer customer, BookableTable reservedTable, String note, int numberOfPeople) {
        this.bookingInt = bookingInt;
        this.time = time;
        this.customer = customer;
        this.reservedTable = reservedTable;
        this.note = note;
        this.numberOfPeople = numberOfPeople;
    }

    //Getters
    public int getBookingInt() {
        return bookingInt;
    }

    public long getTime() {
        return time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BookableTable getReservedTable() {
        return reservedTable;
    }

    public String getNote() {
        return note;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    //Setters

    public void setTime(long time) {
        this.time = time;
    }

    public void setReservedTable(BookableTable reservedTable) {
        this.reservedTable = reservedTable;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    //Methods
    //TODO add methods
}
