package FOHClasses.Collection;

import FOHClasses.DatabaseDAO.MenuDAO;
import FOHClasses.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores all the MenuItems currently on the menu.
 */
public class MenuItemCollection {
    /**
     * Stores the itemId as the key and a MenuItem object as the value
     */
    private static final HashMap<Integer, MenuItem> items = new HashMap<>();

    public MenuItemCollection() {
        throw new UnsupportedOperationException("This class should not be instantiated.");
    }

    /**
     * For the generation of a fresh menu from the management team.
     * @param dishMenu A hashmap representing a menu with dishId as the key and a list of dish data as the value
     */
    public static void newMenu(HashMap<Integer, List<String>> dishMenu) {
        MenuItemCollection.reset();
        for (HashMap.Entry<Integer, List<String>> dish : dishMenu.entrySet()) {
            int dishId = dish.getKey();
            List<String> value = dish.getValue();

            MenuItemCollection.add(new MenuItem(dishId, value.get(0), Integer.parseInt(value.get(1)), value.get(2), value.get(3)));
        }
        MenuDAO.addMenu();
    }

    /**
     * For the loading of a menu from the database.
     * @param dishMenu A hashmap representing a menu with dishId as the key and a list of dish data as the value
     */
    public static void loadMenu(HashMap<Integer, List<String>> dishMenu) {
        MenuItemCollection.reset();
        for (HashMap.Entry<Integer, List<String>> dish : dishMenu.entrySet()) {
            int dishId = dish.getKey();
            List<String> value = dish.getValue();

            MenuItemCollection.add(new MenuItem(dishId, value.get(0), Integer.parseInt(value.get(1)), value.get(2), value.get(3)));
        }
//        MenuDAO.addMenu();
    }

    /**
     * Adds an entry to the hashmap
     * @param menuItem The entry to add
     */
    public static void add(MenuItem menuItem){
        int id = menuItem.getItemId();
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
