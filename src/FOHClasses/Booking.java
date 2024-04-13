package FOHClasses;

public class Booking {
    private final int bookingId;
    private int customerID;
    private int numberOfGuests;
    private long time;
    private int date;
    private int tableNumber;
    private String note;

    public Booking(int bookingId, int customerName, int numberOfGuests,long time, int date, String note) {
        this.bookingId = bookingId;
        this.customerID = customerName;
        this.numberOfGuests= numberOfGuests;
        this.time = time;
        this.date = date;
        this.note = note;
        this.tableNumber = 0;//table 0 means unassigned for now
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerName(int customerName) {
        this.customerID = customerName;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
