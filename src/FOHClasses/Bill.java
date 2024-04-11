package FOHClasses;

import FOHClasses.Collection.MenuItemCollection;

public class Bill {
    private final int billID;
    private final Waiter waiter;
    private final String paymentType;
    private final int totalPrice;
    private final MenuItemCollection items;
    private final int serviceCharge;

    public Bill(int billID, Waiter waiter, String paymentType, int totalPrice, MenuItemCollection items, int serviceCharge) {
        this.billID = billID;
        this.waiter = waiter;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.items = items;
        this.serviceCharge = serviceCharge;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public MenuItemCollection getItems() {
        return items;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }
    public int getBillID(){return billID;}
}
