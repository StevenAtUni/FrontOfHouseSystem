package FOHClasses.DatabaseDAO;

import java.sql.*;

public class MenuDAO {

    public static void addMenu(int menuID, String description, Date startDay, Date endDate) { // MenuDAO.addMenu(1,"Food", Date.valueOf("2024-04-15") , Date.valueOf("2024-04-22"));
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement addMenu = connection.prepareStatement(
                    "INSERT INTO Menu (menuID, description, startDay, endDate) VALUES (?, ?, ?, ?)");

            addMenu.setInt(1, menuID);
            addMenu.setString(2, description);
            addMenu.setDate(3, startDay);
            addMenu.setDate(4, endDate);

            int rowsAffected = addMenu.executeUpdate();

            if (rowsAffected == 0) {
                // If no rows were affected, it means the menu was not added
                System.out.println("Failed to add menu with ID " + menuID);
            } else {
                System.out.println("Menu with ID " + menuID + " has been successfully added.");
            }

            addMenu.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
