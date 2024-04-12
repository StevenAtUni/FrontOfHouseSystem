package FOHClasses.Collection;

import FOHClasses.Booking;

import java.util.*;

public class BookingCollection {
    private static final HashMap<Integer, Booking> bookings = new HashMap<>();

    /**
     * Adds an entry to the hashmap
     * @param booking The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(Booking booking){
        int bookingId = booking.getBookingId();
        if (bookings.containsKey(bookingId)) return false; // Returns false if the booking already exists
        bookings.put(bookingId, booking);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param bookingId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int bookingId){
        if (bookings.remove(bookingId) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        bookings.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param bookingId The id of the value to get
     * @return The requested value
     */
    public static Booking get(int bookingId){
        return bookings.get(bookingId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<Booking> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(bookings.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<Booking> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(bookings.get(key));
        }
        return sorted;
    }
}
