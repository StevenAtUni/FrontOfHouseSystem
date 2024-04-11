package FOHClasses.Collection;

import FOHClasses.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MenuItemCollection {
    private static final HashMap<Integer, MenuItem> items = new HashMap<>();

    /**
     * Adds an entry to the hashmap
     * @param menuItem The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(MenuItem menuItem){
        int id = menuItem.getID();
        if (items.containsKey(id)) return false; // Returns false if the booking already exists
        items.put(id, menuItem);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param tableId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int tableId){
        if (items.remove(tableId) != null) return true; // Null if no value removed (booking ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        items.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param tableId The id of the value to get
     * @return The requested value
     */
    public static MenuItem get(int tableId){
        return items.get(tableId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<MenuItem> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(items.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<MenuItem> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(items.get(key));
        }
        return sorted;
    }
}
