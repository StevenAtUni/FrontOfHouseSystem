package FOHClasses.DatabaseDAO;

import java.sql.*;

public class DishDAO {

    /**
     * Adds a dish to a menu in the database
     *
     * @param name          Name of the dish
     * @param price         Price of the dish
     * @param description   Description of the dish
     * @param allergens     Allergens in the dish
     * @param menuID        ID of the menu of the dish
     * @param dishID        ID of the dish
     */
    public static void addDish(String name, int price, String description, String allergens, int menuID, int dishID) { // Adds a dish to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement addDish = connection.prepareStatement(
                    "INSERT INTO Dishes (name, price, description, allergens, MenumenuID, dishID) VALUES (?, ?, ?, ?, ?, ?)");

            addDish.setString(1, name);
            addDish.setDouble(2, price);
            addDish.setString(3, description);
            addDish.setString(4, allergens);
            addDish.setInt(5, menuID);
            addDish.setInt(6, dishID);

            int rowsAffected = addDish.executeUpdate();

            if (rowsAffected == 0) {
                // If no rows were affected, it means the dish was not added
                System.out.println("Failed to add dish: " + name);
            } else {
                System.out.println("Dish added successfully: " + name);
            }

            addDish.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Show dishes by menuID
     *
     * @param menuID ID of the menu to show dishes from
     */
    public static void showDishesByMenuID(int menuID) { // Shows Dishes given a MenuID
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement selectDishes = connection.prepareStatement(
                    "SELECT * FROM Dishes WHERE MenumenuID = ?");
            selectDishes.setInt(1, menuID);
            ResultSet resultSet = selectDishes.executeQuery();

            while (resultSet.next()) {
                int dishID = resultSet.getInt("dishID");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                boolean availability = resultSet.getBoolean("availability");
                String allergens = resultSet.getString("allergens");

                System.out.println("DishID: " + dishID + ", Name: " + name + ", Price: $" + price +
                        ", Description: " + description + ", Availability: " + availability +
                        ", Allergens: " + allergens);
            }

            selectDishes.close(); // Close the PreparedStatement
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets a selected dish to unavailable
     *
     * @param dishID ID of the dish to set as unavailable
     */
    public static void setDishUnavailable(int dishID) { // Sets the dish availability to Unavailable
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_a","rXwsW4mUvPU");) {
            PreparedStatement updateDishAvailability = connection.prepareStatement(
                    "UPDATE Dishes SET availability = 0 WHERE dishID = ?");

            updateDishAvailability.setInt(1, dishID);

            int rowsAffected = updateDishAvailability.executeUpdate();

            if (rowsAffected == 0) {
                // If no rows were affected, it means the dish with the specified ID was not found
                System.out.println("No dish found with ID: " + dishID);
            } else {
                System.out.println("Dish availability updated successfully for dishID: " + dishID);
            }

            updateDishAvailability.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
