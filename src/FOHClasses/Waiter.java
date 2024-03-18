package FOHClasses;

public class Waiter {
    private final int staffID;
    private String name;
    private int pin;
    private String phoneNumber;
    private String waiterType;
    private PhysicalTable tableCurrentlyWaiting;
    private float salary;
    private float tipEarned;
    private String email;
    private String payInfo;
    private Order currentOrder;

    public Waiter(int staffID, String name, int pin, String waiterType, PhysicalTable tableCurrentlyWaiting, float salary, float tipEarned, String email, String payInfo) {
        this.staffID = staffID;
        this.name = name;
        this.pin = pin;
        this.waiterType = waiterType;
        this.tableCurrentlyWaiting = tableCurrentlyWaiting;
        this.salary = salary;
        this.tipEarned = tipEarned;
        this.email = email;
        this.payInfo = payInfo;
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

    public PhysicalTable getTableCurrentlyWaiting() {
        return tableCurrentlyWaiting;
    }

    public float getSalary() {
        return salary;
    }

    public float getTipEarned() {
        return tipEarned;
    }

    public String getEmail() {
        return email;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public Order getCurrentOrder() {
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

    public void setTableCurrentlyWaiting(PhysicalTable tableCurrentlyWaiting) {
        this.tableCurrentlyWaiting = tableCurrentlyWaiting;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setTipEarned(float tipEarned) {
        this.tipEarned = tipEarned;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    //Methods
    public void payWaiter(){
        //TODO
    }
    public void login(int StaffID, int pin){
        //TODO
    }
    public void logout(){
        //TODO
    };
}
