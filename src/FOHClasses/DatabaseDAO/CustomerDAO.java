package FOHClasses.DatabaseDAO;

import java.sql.*;
import java.time.Period;

public class CustomerDAO {

    /**
     * Creates a new customer in the database
     *
     * @param name              Name of the customer
     * @param contactNumber     Customer's contact number
     * @param disabilities      Any disabilities
     * @param allergens         Any allergens
     */
    public static void insertCustomer(String name, String contactNumber, String disabilities, String allergens) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");){
            PreparedStatement createCustomer = connection.prepareStatement("INSERT INTO Customer (name, contactNumber, disabilities, allergens) VALUES (?, ?, ?, ?)");
            createCustomer.setString(1, name);
            createCustomer.setString(2, contactNumber);
            createCustomer.setString(3, disabilities);
            createCustomer.setString(4, allergens);
            createCustomer.executeUpdate();
            createCustomer.close();
            System.out.println("Customer created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  Retrieves all the customers
     */
    public static void selectAllCustomers() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");){
            PreparedStatement selectAllCustomers = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = selectAllCustomers.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customerID");
                String name = resultSet.getString("name");
                String contactNumber = resultSet.getString("contactNumber");
                String disabilities = resultSet.getString("disabilities");
                String allergens = resultSet.getString("allergens");
                System.out.println("CustomerID: " + customerId + ", Name: " + name + ", Contact Number: " + contactNumber + ", Disabilities: " + disabilities + ", Allergens: " + allergens);
            }
            selectAllCustomers.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Search the customer from their phone number
     *
     * @param phoneNumber   Customer's phone number to search for
     */
    public static void searchCustomerByPhoneNumber(String phoneNumber) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement searchCustomer = connection.prepareStatement("SELECT * FROM Customer WHERE contactNumber = ?");
            searchCustomer.setString(1, phoneNumber);
            ResultSet resultSet = searchCustomer.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customerID");
                String name = resultSet.getString("name");
                String contactNumber = resultSet.getString("contactNumber");
                String disabilities = resultSet.getString("disabilities");
                String allergens = resultSet.getString("allergens");
                System.out.println("CustomerID: " + customerId + ", Name: " + name + ", Contact Number: " + contactNumber + ", Disabilities: " + disabilities + ", Allergens: " + allergens);
            }
            searchCustomer.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}