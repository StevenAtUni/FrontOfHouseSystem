package FOHClasses;

import FOHClasses.Collection.OrderCollection;
import FOHClasses.Collection.PhysicalTableCollection;

public class Waiter {
    private final int staffID;
    private String name;
    private int pin;
    private String phoneNumber;
    private String waiterType;
    private PhysicalTableCollection tableCurrentlyWaiting;
    private float tipEarned;
    private String email;
    private OrderCollection currentOrder;

    public Waiter(int staffID, String name, int pin, String waiterType, String email) {
        this.staffID = staffID;
        this.name = name;
        this.pin = pin;
        this.waiterType = waiterType;
        this.tableCurrentlyWaiting = new PhysicalTableCollection();
        this.currentOrder = new OrderCollection();
        this.tipEarned = 0;
        this.email = email;
    }

    //Getters

    public int getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWaiterType() {
        return waiterType;
    }

    public PhysicalTableCollection getTableCurrentlyWaiting() {
        return tableCurrentlyWaiting;
    }


    public float getTipEarned() {
        return tipEarned;
    }

    public String getEmail() {
        return email;
    }


    public OrderCollection getCurrentOrder() {
        return currentOrder;
    }
    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWaiterType(String waiterType) {
        this.waiterType = waiterType;
    }

    public void setTableCurrentlyWaiting(PhysicalTableCollection tableCurrentlyWaiting) {
        this.tableCurrentlyWaiting = tableCurrentlyWaiting;
    }

    public void setTipEarned(float tipEarned) {
        this.tipEarned = tipEarned;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurrentOrder(OrderCollection currentOrder) {
        this.currentOrder = currentOrder;
    }

    //Methods
    public void login(int StaffID, int pin){
        //TODO
    }
    public void logout(){
        //TODO
    };
}
