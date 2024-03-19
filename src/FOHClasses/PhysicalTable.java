package FOHClasses;

import FOHClasses.Collection.TableCollection;
import FOHClasses.Collection.WaiterCollection;

public class PhysicalTable {
    private final int tableID;
    private int childSeats;
    private WaiterCollection assignedWaiters;
    private TableCollection tableCollection;

    public PhysicalTable(int tableID, int childSeats) {
        this.tableID = tableID;
        this.childSeats = childSeats;
        this.assignedWaiters = new WaiterCollection();
        this.tableCollection = new TableCollection();
    }

    //Getters

    public int getTableID() {
        return tableID;
    }

    public int getChildSeats() {
        return childSeats;
    }

    public WaiterCollection getAssignedWaiters() {
        return assignedWaiters;
    }

    public TableCollection getTableCollection() {
        return tableCollection;
    }

    //Setters

    public void setChildSeats(int childSeats) {
        this.childSeats = childSeats;
    }

    public void setAssignedWaiters(WaiterCollection assignedWaiters) {
        this.assignedWaiters = assignedWaiters;
    }

    public void setTableCollection(TableCollection tableCollection) {
        this.tableCollection = tableCollection;
    }
    //Methods
    public void assignWaiter(Waiter waiter){
        //TODO
    }
    public void removeWaiter(Waiter waiter){
        //TODO
    }
    public void connectTable(PhysicalTable table){
        //TODO
    }
    public void removeTable(PhysicalTable table){
        //TODO
    }

}
