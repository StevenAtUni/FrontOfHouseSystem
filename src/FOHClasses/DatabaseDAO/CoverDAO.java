package FOHClasses.DatabaseDAO;

import FOHClasses.Terminal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoverDAO {
    /**
     * Returns the coverID associated with the given bookingID
     *
     * @param bookingID ID of the booking to return coverIDs for
     * @return An array of coverIDs for the given bookingID
     */
    public static int[] getCoversByBookingID(int bookingID) { // Returns a covers given a BookingID in a form of an array
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
            throw new RuntimeException(e);
        }

        // Convert list to array
        int[] coverIDArray = new int[coverIDs.size()];
        for (int i = 0; i < coverIDs.size(); i++) {
            coverIDArray[i] = coverIDs.get(i);
        }

        return coverIDArray;
    }

}
