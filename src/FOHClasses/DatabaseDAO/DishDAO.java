package FOHClasses.DatabaseDAO;

import java.sql.*;

public class DishDAO {

    public static void addDish(String name, double price, String description, String allergens, int menuID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement addDish = connection.prepareStatement(
                    "INSERT INTO Dishes (name, price, description, allergens, MenumenuID) VALUES (?, ?, ?, ?, ?)");

            addDish.setString(1, name);
            addDish.setDouble(2, price);
            addDish.setString(3, description);
            addDish.setString(4, allergens);
            addDish.setInt(5, menuID);

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

    public static void showDishesByMenuID(int menuID) {
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

}
