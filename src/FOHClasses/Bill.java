package FOHClasses;


import FOHClasses.Collection.MenuItemCollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class storing all necessary information of a bill/payment.
 */
public class Bill {
    /**
     * The next available ID number
     */
    private static int nextId = 1;
    /**
     * The unique identifier of this bill
     */
    private final int billId;
    /**
     * The waiter responsible for the booking
     */
    private int waiterId;
    /**
     * Start time of the booking in seconds since UNIX epoch
     */
    private long startTimestamp;
    /**
     * End time of the booking in seconds since UNIX epoch
     */
    private long endTimestamp;
    /**
     * Whether the payment was made in cash
     */
    private final boolean isCash;
    /**
     * An ArrayList of IDs representing each item ordered
     */
    private ArrayList<Integer> items;
    /**
     * Price, in pence, of the items ordered
     */
    private int orderPrice = 0;
    /**
     * The amount, in pence, of service charge paid
     */
    private int serviceCharge = 0;
    /**
     * The total price paid in pence
     */
    private int totalPrice = 0;
    /**
     * The service charge as an integer between 0-100
     */
    private static int serviceChargePercentage = 0;

    /**
     * Constructs a bill object.
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
