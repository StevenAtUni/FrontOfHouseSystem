package FOHClasses.DatabaseDAO;

import java.sql.*;

public class WaiterDAO {
    public static int checkPassword(String passwordToCheck) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
            PreparedStatement checkPassword = connection.prepareStatement("SELECT waiterID, pin FROM Waiter");
            ResultSet resultSet = checkPassword.executeQuery();
            while (resultSet.next()) {
                int waiterID = resultSet.getInt("waiterID");
                String actualPassword = resultSet.getString("pin");
                if (passwordToCheck.equals(actualPassword)) {
                    System.out.println("Found " + waiterID);
                    return waiterID; // Return the waiter ID if the password matches
                }
            }
            checkPassword.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Not found");
        return -1; // Return -1 if no matching password is found
    }

    public static int[] getAllWaiterIDs() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT waiterID FROM Waiter")) {
            int[] waiterIDs = new int[10]; // Assuming a maximum of 10 waiters for simplicity
            int i = 0;
            while (rs.next()) {
                waiterIDs[i++] = rs.getInt("waiterID");
                if (i >= waiterIDs.length) break; // Prevent ArrayIndexOutOfBoundsException
            }
            return waiterIDs;
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }




}
