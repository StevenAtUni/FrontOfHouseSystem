package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Order {
    private final int orderID;
    private DishCollection items;
    private String orderNotes;
    private String orderStatus;
    private  int tableID;
    private final Customer customer;
    private Waiter server;

    public Order(int orderID, String orderNotes, int tableID, Customer customer, Waiter server) {
        this.orderID = orderID;
        this.orderNotes = orderNotes;
        this.orderStatus = "taking order";
        this.tableID = tableID;
        this.customer = customer;
        this.server = server;
        //TODO add this.items
    }
    //Getter
    public int getOrderID() {
        return orderID;
    }

    public DishCollection getItems() {
        return items;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getTableID() {
        return tableID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Waiter getServer() {
        return server;
    }
    //Setter

    public void setTableID(int tableID ){
        this.tableID=tableID;
    }
    public void setItems(DishCollection items) {
        this.items = items;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
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
