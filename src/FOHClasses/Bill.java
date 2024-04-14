package FOHClasses;


import FOHClasses.Collection.MenuItemCollection;

import java.util.List;

public class Bill {
    private final int billID;
    private final int waiterID;
    private final String paymentType;
    private final int totalPrice;
    private List<DishQuantity> items;
    private  int serviceCharge = 0;
    private static int serviceChargePercentage = 0;

    public Bill(int billID, int waiter, String paymentType, int totalPrice, List<DishQuantity> items, boolean applyServiceCharge) {
        this.billID = billID;
        this.waiterID = waiter;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.items = items;
        if (applyServiceCharge){
            this.serviceCharge = this.totalPrice * (serviceChargePercentage/100);
        }
    }

    public int getWaiter() {
        return waiterID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<DishQuantity> getItems() {
        return items;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }
    public int getBillID(){return billID;}

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public static int getServiceChargePercentage() {
        return serviceChargePercentage;
    }

    public static void setServiceChargePercentage(int serviceChargePercentage) {
        Bill.serviceChargePercentage = serviceChargePercentage;
    }
}
