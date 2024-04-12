package FOHClasses;

import FOHClasses.Collection.TableCollection;
import FOHClasses.Collection.WaiterCollection;

import java.util.ArrayList;

public class PhysicalTable {
    private final int tableID;
    private int childSeats;
    private BookableTable assignedTable;
    private final ArrayList<Integer> currentOrder;

    public PhysicalTable(int tableID, int childSeats, BookableTable assignedTable) {
        this.tableID = tableID;
        this.childSeats = childSeats;
        this.assignedTable = assignedTable;
        currentOrder = new ArrayList<>();
    }

    public BookableTable getAssignedTable() {
        return assignedTable;
    }

    public void setAssignedTable(BookableTable assignedTable) {
        this.assignedTable = assignedTable;
    }

    //Getters

    public int getTableID() {
        return tableID;
    }

    public int getChildSeats() {
        return childSeats;
    }


    //Setters

    public void setChildSeats(int childSeats) {
        this.childSeats = childSeats;
    }

    //Methods
    public void connectTable(PhysicalTable table){
        //TODO
    }
    public void removeTable(PhysicalTable table){
        //TODO
    }

    public ArrayList<Integer> getCurrentOrder() {
        return currentOrder;
    }

    public void addOrder(int order){
        currentOrder.add(order);
    }

    public void removeOrder(int order){
        currentOrder.remove(order);
    }
}
