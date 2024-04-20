package FOHClasses.Collection;

import FOHClasses.Cover;
import FOHClasses.PhysicalTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores all the PhysicalTable objects.
 */
public class PhysicalTableCollection {
    /**
     * Stores the tableId as the key and an Order object as the value
     */
    private static final HashMap<Integer, PhysicalTable> tables = new HashMap<>();

    public PhysicalTableCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param table The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(PhysicalTable table){
        int tableId = table.getTableId();
        if (tables.containsKey(tableId)) return false; // Returns false if the cover already exists
        tables.put(tableId, table);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param tableId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int tableId){
        if (tables.remove(tableId) != null) return true; // Null if no value removed (tableId didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        tables.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param tableId The id of the value to get
     * @return The requested value
     */
    public static PhysicalTable get(int tableId){
        return tables.get(tableId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<PhysicalTable> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(tables.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<PhysicalTable> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(tables.get(key));
        }
        return sorted;
    }
}
