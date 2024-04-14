package FOHClasses.Collection;

import FOHClasses.Bill;
import FOHClasses.OrderedDish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OrderedDishCollection {
    private static final HashMap<Integer, OrderedDish> dishes = new HashMap<>();

    public OrderedDishCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param dish The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(OrderedDish dish){
        int billId = dish.getID();
        if (dishes.containsKey(billId)) return false; // Returns false if the booking already exists
        dishes.put(billId, dish);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param OrdereddishID The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int ordereddishID){
        if (dishes.remove(ordereddishID) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        dishes.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param orderedDishID The id of the value to get
     * @return The requested value
     */
    public static OrderedDish get(int orderedDishID){
        return dishes.get(orderedDishID);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<OrderedDish> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(dishes.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<OrderedDish> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(dishes.get(key));
        }
        return sorted;
    }

}
