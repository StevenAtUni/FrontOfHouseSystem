package FOHClasses.Collection;

import FOHClasses.MenuItem;

import java.util.ArrayList;

public class DishCollection {
    private final ArrayList<MenuItem> items;

    public DishCollection(){
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public void removeItem(int itemID){
        items.removeIf(item -> item.getID() == itemID);
    }
}
