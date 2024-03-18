package FOHClasses;

public class Booking {
    private final int bookingID;
    private long time;
    private final Customer customer;
    private BookableTable reservedTable;
    private String note;
    private int numberOfDiners;


    //constructor
    public Booking(int bookingID, long time, Customer customer, BookableTable reservedTable, String note, int numberOfDiners) {
        this.bookingID = bookingID;
        this.time = time;
        this.customer = customer;
        this.reservedTable = reservedTable;
        this.note = note;
        this.numberOfDiners = numberOfDiners;
    }

    //Getters
    public int getBookingID() {
        return bookingID;
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

    public int getNumberOfDiners() {
        return numberOfDiners;
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

    public void setNumberOfDiners(int numberOfDiners) {
        this.numberOfDiners = numberOfDiners;
    }

    //Methods
    //TODO add methods
}
