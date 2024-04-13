package FOHClasses.Collection;


import FOHClasses.BookableTable;
import FOHClasses.Booking;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BookableTableCollection {
    private static final HashMap<Integer, BookableTable> tables = new HashMap<>();

    public BookableTableCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param table The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(BookableTable table){
//        int id = table.getTableID();
//        if (tables.containsKey(id)) return false; // Returns false if the booking already exists
//        tables.put(id, table);
//        return true;
        return false;
    }

    /**
     * Removes an entry from the hashmap.
     * @param tableId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int tableId){
        if (tables.remove(tableId) != null) return true; // Null if no value removed (booking ID didn't exist)
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
    public static BookableTable get(int tableId){
        return tables.get(tableId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<BookableTable> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(tables.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds bookings by order of the keys
        List<BookableTable> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(tables.get(key));
        }
        return sorted;
    }
}
