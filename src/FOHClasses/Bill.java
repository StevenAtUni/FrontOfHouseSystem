package FOHClasses;


import FOHClasses.Collection.MenuItemCollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An object storing all necessary information of a bill/payment.
 */
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

    /**
     * @param waiterId The waiter that was responsible for the table
     * @param startTimestamp The booking's start time in seconds since the UNIX epoch
     * @param endTimestamp The booking's end time in seconds since the UNIX epoch
     * @param isCash Whether the payment/bill has been made in cash
     * @param items An ArrayList of the IDs purchased by the order
     * @param applyServiceCharge Whether the service charge should be applied
     */
    public Bill(int waiterId, long startTimestamp, long endTimestamp, boolean isCash, ArrayList<Integer> items, boolean applyServiceCharge) {
        this.billId = nextId++;
        this.waiterId = waiterId;
        this.isCash = isCash;
        this.items = items;

        if (applyServiceCharge){
            this.serviceCharge = this.orderPrice * (serviceChargePercentage/100);
        }

        this.totalPrice = orderPrice + serviceCharge;
    }

    /**
     * Increases the nextId
     * @param nextId The number to increase it to
     */
    public static void setNextId(int nextId) {
        if (Bill.nextId < nextId) Bill.nextId = nextId; // Only allows nextId to be increased
    }

    /**
     * For management to change the service charge
     * @param serviceChargePercentage The percentage of the service charge (0-100)
     */
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
