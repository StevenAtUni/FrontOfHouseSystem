package FOHClasses;

import FOHClasses.Collection.DishCollection;

public class Bill {
    private final Waiter waiter;
    private final String paymenType;
    private final int totalPrice;
    private final DishCollection items;
    private final int serviceCharge;

    public Bill(Waiter waiter, String paymenType, int totalPrice, DishCollection items, int serviceCharge) {
        this.waiter = waiter;
        this.paymenType = paymenType;
        this.totalPrice = totalPrice;
        this.items = items;
        this.serviceCharge = serviceCharge;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public String getPaymentType() {
        return paymenType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public DishCollection getItems() {
        return items;
    }

    public int getServiceCharge() {
        return serviceCharge;
    }
}
