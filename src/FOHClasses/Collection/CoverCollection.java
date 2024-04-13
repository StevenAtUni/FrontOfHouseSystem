package FOHClasses.Collection;

import FOHClasses.Cover;

import java.util.*;

public class CoverCollection {
    private static final HashMap<Integer, Cover> covers = new HashMap<>();

    public CoverCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * Adds an entry to the hashmap
     * @param cover The entry to add
     * @return Whether the operation succeeded (false if entry already exists)
     */
    public static boolean add(Cover cover){
        int coverId = cover.getCoverId();
        if (covers.containsKey(coverId)) return false; // Returns false if the cover already exists
        covers.put(coverId, cover);
        return true;
    }

    /**
     * Removes an entry from the hashmap.
     * @param coverId The id of the entry to remove
     * @return Whether the operation succeeded
     */
    public static boolean remove(int coverId){
        if (covers.remove(coverId) != null) return true; // Null if no value removed (cover ID didn't exist)
        return false;
    }

    /**
     * Clears the hashmap.
     */
    public static void reset(){
        covers.clear(); // Removes all entries
    }

    /**
     * Get a value from the hashmap.
     * @param coverId The id of the value to get
     * @return The requested value
     */
    public static Cover get(int coverId){
        return covers.get(coverId);
    }

    /**
     * Returns all entries in ascending order by ID value.
     * @return A list of all entries.
     */
    public static List<Cover> getAll(){
        List<Integer> sortedKeys = new ArrayList<>(covers.keySet()); // Gets all keys
        Collections.sort(sortedKeys); // Sorts keys

        // Adds covers by order of the keys
        List<Cover> sorted = new ArrayList<>();
        for (int key : sortedKeys) {
            sorted.add(covers.get(key));
        }
        return sorted;
    }
}
