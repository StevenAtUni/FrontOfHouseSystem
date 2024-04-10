package FOHClasses.Collection;

import FOHClasses.Booking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookingCollection {
    private final ArrayList<Booking> bookings;

    public BookingCollection(){
        this.bookings = new ArrayList<>();
    }

    public void add(Booking booking){
        bookings.add(booking);
    }
}
