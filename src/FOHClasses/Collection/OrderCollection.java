package FOHClasses.Collection;

import FOHClasses.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OrderCollection {
    private static final HashMap<Integer, Order> orders = new HashMap<>();

    public OrderCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param order The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(Order order){
        int id = order.getOrderId();
        if (orders.containsKey(id)) return false; // Returns false if the booking already exists
        orders.put(id, order);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param orderId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int orderId){
        if (orders.remove(orderId) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        orders.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param orderId The id of the value to get
     * @return The requested value
     */
    public static Order get(int orderId){
        return orders.get(orderId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<Order> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(orders.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<Order> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(orders.get(key));
        }
        return sorted;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
