package FOHClasses;


import FOHClasses.Collection.MenuItemCollection;

public class Bill {
    private final int billID;
    private final int waiterID;
    private final String paymentType;
    private final int totalPrice;
    private final MenuItemCollection items;
    private int serviceCharge;

    public Bill(int billID, int waiter, String paymentType, int totalPrice, MenuItemCollection items) {
        this.billID = billID;
        this.waiterID = waiter;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.items = items;
        this.serviceCharge = 0;
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

    public MenuItemCollection getItems() {
        return items;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }
    public int getBillID(){return billID;}

    public int getWaiterID() {
        return waiterID;
    }

    public void setServiceCharge(int serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
