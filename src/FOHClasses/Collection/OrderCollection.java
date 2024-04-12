package FOHClasses.Collection;

import FOHClasses.Order;

import java.util.ArrayList;

public class OrderCollection {
    private final ArrayList<Order> orders;

    public OrderCollection() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(int orderID){
        orders.removeIf(order -> order.getOrderId() == orderID);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
