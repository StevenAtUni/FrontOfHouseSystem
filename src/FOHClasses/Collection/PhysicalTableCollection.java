package FOHClasses.Collection;

import FOHClasses.PhysicalTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhysicalTableCollection {
    private static final HashMap<Integer, PhysicalTable> tables = new HashMap<>();

    public PhysicalTableCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Sets up the hashmap.
     */
    public static void initialise(){
        // Initialises the hashmap
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
