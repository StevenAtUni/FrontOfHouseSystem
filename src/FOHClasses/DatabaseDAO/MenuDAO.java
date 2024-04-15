package FOHClasses.DatabaseDAO;

import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDAO {

    public static void addMenu() {
        // MenuDAO.addMenu(1,"Food", Date.valueOf("2024-04-15") , Date.valueOf("2024-04-22"));
        List<MenuItem> Items = MenuItemCollection.getAll();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement addMenu = connection.prepareStatement(
                    "INSERT INTO Menus () VALUES ();", PreparedStatement.RETURN_GENERATED_KEYS);

            int rowsAffected = addMenu.executeUpdate();
            int generatedMenuID = -1;


            if (rowsAffected == 0) {
                // If no rows were affected, it means the menu was not added
                System.out.println("Failed to add menu with ID ");
            } else {
                // Retrieve the generated menuID
                ResultSet generatedKeys = addMenu.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedMenuID = generatedKeys.getInt(1);
                    System.out.println("Created a menu with ID: " + generatedMenuID);
                } else {
                    System.out.println("Failed to retrieve generated menu ID.");
                    return;
                }
            }

            addMenu.close();

            for (MenuItem item : Items) {
                DishDAO.addDish(item.getName(), item.getPrice(), item.getDescription(), item.getAllergens(), generatedMenuID, item.getItemId());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMenu(){
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement addMenu = connection.prepareStatement("SELECT * FROM Dishes");
            ResultSet resultSet = addMenu.executeQuery();
            while (resultSet.next()){
                List<String> strings = new ArrayList<>();
                strings.add(resultSet.getString("name"));
                strings.add(String.valueOf(resultSet.getInt("price")));
                strings.add(resultSet.getString("description"));
                strings.add(resultSet.getString("allergens"));

                map.put(resultSet.getInt("dishId"), strings);
            }

            addMenu.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}