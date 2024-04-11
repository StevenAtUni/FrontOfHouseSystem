package FOHClasses;

import FOHClasses.Collection.BookingCollection;

public class Customer {
    private final int customerID;
    private String name;
    private BookingCollection bookingCollection;

    private String[] allergens;

    private String[] disabilities;

    public Customer(int cutomerID, String name, BookingCollection bookingCollection, String[] allergens, String[] disabilities) {
        this.customerID = cutomerID;
        this.name = name;
        this.bookingCollection = bookingCollection;
        this.allergens = allergens;
        this.disabilities = disabilities;
    }

    //Getter

    public String[] getAllergens() {
        return allergens;
    }

    public String[] getDisabilities() {
        return disabilities;
    }
    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public BookingCollection getBookings() {
        return bookingCollection;
    }



    //Setters
    public void setAllergens(String[] allergens) {
        this.allergens = allergens;
    }

    public void setDisabilities(String[] disabilities) {
        this.disabilities = disabilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookings(BookingCollection bookingCollection) {
        this.bookingCollection = bookingCollection;
    }


    //Methods
    public void addBooking(Booking booking){
        //TODO
    }
    public void removeBooking(Booking booking){
        //TODO
    }

}
