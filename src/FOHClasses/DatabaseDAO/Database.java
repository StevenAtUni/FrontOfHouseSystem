package FOHClasses.DatabaseDAO;

import java.sql.*;


public class Database {

    public static void  main(String[] args) {
        int[] tableIDs = {1, 5, 10};
        BookingDAO.createBooking(4, "Martin", "12334521", 1713207600, 1713214800, tableIDs);
    }




}
