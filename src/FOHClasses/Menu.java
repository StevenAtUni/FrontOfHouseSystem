package FOHClasses;

import FOHClasses.Collection.MenuItemCollection;

public class Menu {
    private final MenuItemCollection items;

    public Menu(MenuItemCollection dishes) {
        this.items = dishes;
    }
    //Getters
    public MenuItemCollection getDishes() {
        return items;
    }

    //Methods
    public void addDish(MenuItem dish){
        items.add(dish);

    }
    public void removeDish(int itemID){
        items.remove(itemID);
    }
}
