package FOHClasses.DatabaseDAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TablesDAO {

    /**
     * Returns an array of Reserved Table IDs given a booking ID
     *
     * @param bookingID ID of the booking
     * @return Array of table IDs
     */
    public static int[] getTablesByBookingID(int bookingID) {
        List<Integer> tableIDs = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
            PreparedStatement selectTables = connection.prepareStatement(
                    "SELECT TablestableID FROM Bookings_Tables WHERE BookingsbookingID = ?");
            selectTables.setInt(1, bookingID);
            ResultSet resultSet = selectTables.executeQuery();

            while (resultSet.next()) {
                int tableID = resultSet.getInt("TablestableID");
                tableIDs.add(tableID);
            }

            selectTables.close();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve tables for booking ID: " + bookingID, e);
        }

        int[] tableIDArray = new int[tableIDs.size()];
        for (int i = 0; i < tableIDs.size(); i++) {
            tableIDArray[i] = tableIDs.get(i);
        }

        return tableIDArray;
    }




}
