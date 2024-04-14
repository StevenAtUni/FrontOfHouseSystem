package FOHClasses;


import FOHClasses.Collection.MenuItemCollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bill {
    private static int nextId = 1;
    private final int billId;
    private final int waiterId;
    private long startTimestamp;
    private long endTimestamp;
    private final boolean isCash;
    private ArrayList<Integer> items;
    private int orderPrice = 0;
    private int serviceCharge = 0;
    private int totalPrice = 0;
    private static int serviceChargePercentage = 0;

    public Bill(int waiterId, long startTimestamp, long endTimestamp, boolean isCash, ArrayList<Integer> items, boolean applyServiceCharge) {
        this.billId = nextId++;
        this.waiterId = waiterId;
        this.isCash = isCash;
        this.items = items;

//        // Counts up the number of items ordered
//        for (int itemId : items) {
//            MenuItem item = MenuItemCollection.get(itemId);
//            orderPrice += item.getPrice();
//
//            if (this.items.containsKey(itemId)) {
//                int newCount = this.items.get(itemId);
//                this.items.put(itemId, newCount+1);
//            } else {
//                this.items.put(itemId, 1);
//            }
//        }

        if (applyServiceCharge){
            this.serviceCharge = this.orderPrice * (serviceChargePercentage/100);
        }

        this.totalPrice = orderPrice + serviceCharge;
    }

    public static void setNextId(int nextId) {
        if (Bill.nextId < nextId) Bill.nextId = nextId; // Only allows nextId to be increased
    }

    public static void setServiceChargePercentage(int serviceChargePercentage) {
        Bill.serviceChargePercentage = serviceChargePercentage;
    }

    public int getBillId() {
        return billId;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public boolean isCash() {
        return isCash;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public static int getServiceChargePercentage() {
        return serviceChargePercentage;
    }
}
