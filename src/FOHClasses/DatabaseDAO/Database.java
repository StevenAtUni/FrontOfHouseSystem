package FOHClasses.DatabaseDAO;

import java.sql.*;


public class Database {

    public static void  main(String[] args) {
        int numOfPeople = 4;
        String customerName = "Martin";
        String contactNumber = "1234567890";
        long startTime = 1713207600; // Unix timestamp for 7pm
        long endTime = 1713214800;   // Unix timestamp for 9pm
        int[] tableIDs = {1, 2};      // Assuming table IDs are 1 and 2

        // Call the createBooking method
        int[] result = BookingDAO.createBooking(numOfPeople, customerName, contactNumber, startTime, endTime, tableIDs);

        // Display the result
        System.out.println("Booking ID: " + result[0]);
        for (int i = 1; i < result.length; i++) {
            System.out.println("Cover ID " + i + ": " + result[i]);
        }
    }




}
