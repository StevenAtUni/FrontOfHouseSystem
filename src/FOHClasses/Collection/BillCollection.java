package FOHClasses.Collection;

import FOHClasses.Bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BillCollection {
    private static final HashMap<Integer, Bill> bills = new HashMap<>();

    public BillCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param bill The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(Bill bill){
        int billId = bill.getBillID();
        if (bills.containsKey(billId)) return false; // Returns false if the booking already exists
        bills.put(billId, bill);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param billId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int billId){
        if (bills.remove(billId) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        bills.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param bookingId The id of the value to get
     * @return The requested value
     */
    public static Bill get(int bookingId){
        return bills.get(bookingId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<Bill> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(bills.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<Bill> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(bills.get(key));
        }
        return sorted;
    }
}
