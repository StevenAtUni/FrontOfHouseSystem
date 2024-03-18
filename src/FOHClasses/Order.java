package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Order {
    private final int orderInt;
    private DishCollection items;
    private String specialRequests;
    private String orderStatus;
    private final PhysicalTable table;
    private final Customer customer;
    private Waiter server;

    public Order(int orderInt, String specialRequests, PhysicalTable table, Customer customer, Waiter server) {
        this.orderInt = orderInt;
        this.specialRequests = specialRequests;
        this.orderStatus = "taking order";
        this.table = table;
        this.customer = customer;
        this.server = server;
        //TODO add this.items
    }
    //Getter
    public int getOrderInt() {
        return orderInt;
    }

    public DishCollection getItems() {
        return items;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public PhysicalTable getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Waiter getServer() {
        return server;
    }
    //Setter

    public void setItems(DishCollection items) {
        this.items = items;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setServer(Waiter server) {
        this.server = server;
    }
    //Methods
    public void addItem(Dish dish){
        //TODO
    }
    public void removeItem(Dish dish){
        //TODO
    }
}
