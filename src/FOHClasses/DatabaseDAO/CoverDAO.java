package FOHClasses.DatabaseDAO;

import FOHClasses.Terminal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoverDAO {
    public static int[] getCoversByBookingID(int bookingID) {
        List<Integer> coverIDs = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
            PreparedStatement selectCovers = connection.prepareStatement(
                    "SELECT coverID FROM Covers WHERE BookingsbookingID = ?");
            selectCovers.setInt(1, bookingID);
            ResultSet resultSet = selectCovers.executeQuery();

            while (resultSet.next()) {
                int coverID = resultSet.getInt("coverID");
                coverIDs.add(coverID);
            }

            selectCovers.close();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve covers for booking ID: " + bookingID, e);
        }

        // Convert list to array
        int[] coverIDArray = new int[coverIDs.size()];
        for (int i = 0; i < coverIDs.size(); i++) {
            coverIDArray[i] = coverIDs.get(i);
        }

        return coverIDArray;
    }

}
