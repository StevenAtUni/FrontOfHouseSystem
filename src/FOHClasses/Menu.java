package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Menu {
    private final DishCollection items;

    public Menu(DishCollection dishes) {
        this.items = dishes;
    }
    //Getters
    public DishCollection getDishes() {
        return items;
    }

    //Methods
    public void addDish(MenuItem dish){
        items.addItem(dish);

    }
    public void removeDish(int itemID){
        items.removeItem(itemID);
    }
}
