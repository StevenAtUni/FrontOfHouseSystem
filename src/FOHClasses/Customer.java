package FOHClasses;


import java.util.ArrayList;

public class Customer {
    private final int customerID;
    private String name;
    private ArrayList<Integer> bookingIDs;

    private String[] allergens;

    private String[] disabilities;

    public Customer(int customerID, String name, String[] allergens, String[] disabilities) {
        this.customerID = customerID;
        this.name = name;
        this.bookingIDs = new ArrayList<Integer>();
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

    public ArrayList<Integer> getBookings() {
        return bookingIDs;
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

    public void setBookings(ArrayList<Integer> bookingCollection) {
        this.bookingIDs = bookingCollection;
    }


    //Methods
    public void addBooking(int bookingID){
        bookingIDs.add(bookingID);
    }
    public void removeBooking(int bookingID){
        bookingIDs.remove(bookingID);
    }

}
