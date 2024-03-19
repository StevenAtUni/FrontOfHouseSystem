package FOHClasses;

import FOHClasses.Collection.TableCollection;
import FOHClasses.Collection.WaiterCollection;

public class PhysicalTable {
    private final int tableID;
    private int childSeats;
    private BookableTable assignedTable;

    public PhysicalTable(int tableID, int childSeats, BookableTable assignedTable) {
        this.tableID = tableID;
        this.childSeats = childSeats;
        this.assignedTable = assignedTable;
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

}
