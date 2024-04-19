package FOHInterface;

import FOHClasses.*;
import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.OrderCollection;
import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.DatabaseDAO.DishDAO;
import FOHClasses.DatabaseDAO.MenuDAO;
import FOHClasses.DatabaseDAO.OrderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**

 This class implements the FOHManagementInterface and FOHKitchenInterface, providing functionalities for the Front Of House (FOH) system to communicate with management and kitchen.


 */
public class FOHController implements FOHManagementInterface, FOHKitchenInterface {
    // Class name may be changed at a later date when we figure out how we will implement our system/code.
    
    //implemented methods
    /**

     Sends the menu to the system, stored in the static class MenuItemCollection.
     @param dishMenu a HashMap containing dish IDs as keys and a list of Strings representing the details of each dish as values.
     @param wineMenu a HashMap containing wine IDs as keys and a list of Strings representing the details of each wine as values.
     */
    @Override
    public void sendMenu(HashMap<Integer, List<String>> dishMenu, HashMap<Integer, List<String>> wineMenu) {
        MenuItemCollection.newMenu(dishMenu);
    }

    /**

     Gets the number of bookings for a specific time which management can use.
     @param timestamp the timestamp to check bookings for.
     @return the number of bookings that overlap with the given timestamp.
     */
    @Override
    public int getAmountBooked(long timestamp) {
        List<Booking> bookings = BookingCollection.getAll();
        int amountBooked = 0;
        for (Booking booking : bookings){
            if (booking.getStartTimestamp() < timestamp && timestamp < booking.getEndTimestamp()){
                amountBooked += 1;
            }
        }
        return amountBooked;
    }
    /**

     Sets the service charge percentage for bills given by management. Notifies the user the service charge amount.

     @param newCharge the new service charge percentage.
     */
    @Override
    public void setServiceCharge(int newCharge) {

        Bill.setServiceChargePercentage(newCharge);
        String notification = "The service charge now is: " + newCharge +"%";
        Notification.addNotification(notification);
    }
    /**

     Marks an order as complete. Notifies the system the order is ready to collect and sets the order in the database as ready to collect.
     @param orderID the ID of the order to mark complete.
     */

    @Override
    public void markOrderComplete(int orderID) {
        Order order = OrderCollection.get(orderID);
        order.setComplete(true);
        OrderDAO.setOrderStatusToReady(orderID);
        String notification = "Order ID: " +  orderID + " for " + order.getTableId() + " is ready to collect.";
        Notification.addNotification(notification);
    }

    /**

     Marks a dish item as unavailable. Sets the dish in the database as unavailable and notifies the system.
     @param itemID the ID of the dish item to mark unavailable.
     */
    @Override
    public void markItemUnavailable(int itemID) {
        DishDAO.setDishUnavailable(itemID);
        MenuItemCollection.get(itemID).setAvailable(false);
        String notification = "Dish name: " +  MenuItemCollection.get(itemID).getName() + " ID: " + itemID + " is unavailable.";
        Notification.addNotification(notification);
    }

    /**

     Sends all orders in a format requested by the kitchen.
     @return a 2D object array containing order details.
     */
    @Override
    public Object[][] getOrders() {
        List<Order> orders = OrderCollection.getAll();
        Object[][] ordersToSend = new Object[orders.size()][4];
        for (int i = 0; i < orders.size(); i++){
            ordersToSend[i][0] = orders.get(i).getOrderId();
            ordersToSend[i][1] = orders.get(i).getTableId();
            ordersToSend[i][2] = orders.get(i).getItems();
            ordersToSend[i][3] = orders.get(i).getNotes();
        }
        return ordersToSend;
    }

}
