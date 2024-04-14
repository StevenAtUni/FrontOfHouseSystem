package FOHClasses.Collection;

import FOHClasses.Waiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WaiterCollection {
    private static final HashMap<Integer, Waiter> waiters = new HashMap<>();

    public WaiterCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param waiter The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(Waiter waiter){
        int id = waiter.getStaffID();
        if (waiters.containsKey(id)) return false; // Returns false if the booking already exists
        waiters.put(id, waiter);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param waiterId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int waiterId){
        if (waiters.remove(waiterId) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        waiters.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param waiterId The id of the value to get
     * @return The requested value
     */
    public static Waiter get(int waiterId){
        return waiters.get(waiterId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<Waiter> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(waiters.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<Waiter> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(waiters.get(key));
        }
        return sorted;
    }
}
