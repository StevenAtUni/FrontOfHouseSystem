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

public class FOHController implements FOHManagementInterface, FOHKitchenInterface {
    // Class name may be changed at a later date when we figure out how we will implement our system/code.

    //implemented methods
    @Override
    public void sendMenu(HashMap<Integer, List<String>> dishMenu, HashMap<Integer, List<String>> wineMenu) {
        MenuItemCollection.newMenu(dishMenu);
    }

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

    @Override
    public void setServiceCharge(int newCharge) {

        Bill.setServiceChargePercentage(newCharge);
        String notification = "The service charge now is: " + newCharge +"%";
        Notification.addNotification(notification);
    }

    @Override
    public void markOrderComplete(int orderID) {
        OrderCollection.get(orderID).setComplete(true);
        OrderDAO.setOrderStatusToReady(orderID);
        String notification = "The Order: " +  orderID + " is ready to collect.";
        Notification.addNotification(notification);
    }

    @Override
    public void markItemUnavailable(int itemID) {
        DishDAO.setDishUnavailable(itemID);
        MenuItemCollection.get(itemID).setAvailable(false);
        String notification = "The dish: " +  MenuItemCollection.get(itemID).getName() + "-" + itemID + " is unavailable.";
        Notification.addNotification(notification);
    }

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
