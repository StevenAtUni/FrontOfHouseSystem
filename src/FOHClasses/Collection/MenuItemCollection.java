package FOHClasses.Collection;

import FOHClasses.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MenuItemCollection {
    private static final HashMap<Integer, MenuItem> items = new HashMap<>();

    public MenuItemCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param menuItem The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public void add(MenuItem menuItem){
        int id = menuItem.getID();
        items.put(id, menuItem);
        //lets say someone order multiple items
    }

    /**
     * Removes an entry from the hashmap.
     * @param itemId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int itemId){
        if (items.remove(itemId) != null) return true; // Null if no value removed (booking ID didn't exist)
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
     * @param itemId The id of the value to get
     * @return The requested value
     */
    public static MenuItem get(int itemId){
        return items.get(itemId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public List<MenuItem> getAll(){
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