package FOHClasses;

import FOHClasses.Collection.BookingCollection;

public class Customer {
    private final int cutomerID;
    private String name;
    private BookingCollection bookings;
    private String allergens;
    private String disabilities;

    public Customer(int cutomerID, String name, BookingCollection bookings, String allergens, String disabilities) {
        this.cutomerID = cutomerID;
        this.name = name;
        this.bookings = bookings;
        this.allergens = allergens;
        this.disabilities = disabilities;
    }
    //Getter

    public int getCutomerID() {
        return cutomerID;
    }

    public String getName() {
        return name;
    }

    public BookingCollection getBookings() {
        return bookings;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getDisabilities() {
        return disabilities;
    }
    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setBookings(BookingCollection bookings) {
        this.bookings = bookings;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }
    //Methods

}
