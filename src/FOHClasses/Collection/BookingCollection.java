package FOHClasses.Collection;

import FOHClasses.Booking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookingCollection {
    private final ArrayList<Booking> bookings;

    public BookingCollection(){
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }
    public void removeBooking(int bookingID){
        bookings.removeIf(booking -> booking.getBookingId() == bookingID);
    }
}
