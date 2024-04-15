package FOHClasses.DatabaseDAO;

import java.sql.*;


public class Database {

    public static void  main(String[] args) {
        int coverID = 2;
        String orderNote = "Test order";
        int[] dishIDs = {1, 2, 2, 3, 3, 3};

        int generatedOrderID = OrderDAO.createOrder(coverID, orderNote, dishIDs);
        System.out.println("Generated Order ID: " + generatedOrderID);
    }




}
