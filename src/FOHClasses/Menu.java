package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Menu {
    private final DishCollection dishes;

    public Menu(DishCollection dishes) {
        this.dishes = dishes;
    }
    //Getters
    public DishCollection getDishes() {
        return dishes;
    }

    //Methods
    public void addDish(Dish dish){
        //TODO
    }
    public void removeDish(Dish dish){
        //TODO
    }
}
