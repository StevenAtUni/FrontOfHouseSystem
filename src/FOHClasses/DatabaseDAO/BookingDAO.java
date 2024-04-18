package FOHClasses.DatabaseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import FOHClasses.Booking;
import FOHClasses.Terminal;

public class BookingDAO {
    /**
     * Creates a new booking and inserts it into the database
     *
     * @param numOfPeople       Number of people attending
     * @param waiterID          ID of the waiter serving the booking
     * @param customerName      Name of the customer that made the booking
     * @param contactNumber     Customer's contact number
     * @param startTime         Start time of the booking in UNIX timestamp format
     * @param endTime           End time of the booking in UNIX timestamp format
     * @param tableIDs          Array of tableIDs reserved for this booking
     * @return An array which contains the bookingID and the coverIDs
     */
    public static int[] createBooking(int numOfPeople, int waiterID, String customerName, String contactNumber, long startTime, long endTime, int[] tableIDs) {

        int bookingID = -1; // Initialize bookingID
        List <Integer> coverIDs = new ArrayList<>(); // Initialise Array

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            // Insert into Bookings table
            PreparedStatement createBooking = connection.prepareStatement(
                    "INSERT INTO Bookings (numOfPeople, customerName, contactNumber, startTime, endTime, WaiterwaiterID) " +
                            "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            // System.out.println(startTime);
            Timestamp tstartTime = new Timestamp(startTime * 1000L);
            Timestamp tendTime = new Timestamp(endTime * 1000L);

            createBooking.setInt(1, numOfPeople);
            createBooking.setString(2, customerName);
            createBooking.setString(3, contactNumber);
            createBooking.setTimestamp(4, tstartTime);
            createBooking.setTimestamp(5, tendTime);
            createBooking.setInt(6, waiterID);

            int rowsAffected = createBooking.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Failed to create new booking.");
            } else {
                // Retrieve the generated bookingID
                ResultSet generatedKeys = createBooking.getGeneratedKeys();
                if (generatedKeys.next()) {
                    bookingID = generatedKeys.getInt(1);
                    System.out.println("Booking created successfully with ID: " + bookingID);
                }
            }

            createBooking.close();

            // Insert into Bookings_Tables table
            if (bookingID != -1) {
                PreparedStatement insertBookingTables = connection.prepareStatement(
                        "INSERT INTO Bookings_Tables (BookingsbookingID, TablestableID) VALUES (?, ?)");

                // Insert each table ID associated with the booking
                for (int tableID : tableIDs) {
                    insertBookingTables.setInt(1, bookingID);
                    insertBookingTables.setInt(2, tableID);
                    insertBookingTables.addBatch();
                }

                insertBookingTables.executeBatch();
                insertBookingTables.close();


                PreparedStatement insertCovers = connection.prepareStatement(
                        "INSERT INTO Covers (coverNumber, BookingsbookingID) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < numOfPeople; i++) {
                    insertCovers.setInt(1, i + 1); // coverNumber starts from 1
                    insertCovers.setInt(2, bookingID);
                    insertCovers.executeUpdate();

                    ResultSet generatedCoverKeys = insertCovers.getGeneratedKeys();
                    if (generatedCoverKeys.next()) {
                        coverIDs.add(generatedCoverKeys.getInt(1));
                    }
                }

                insertCovers.close();
            } else {
                System.out.println("Failed to insert tables for the booking");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int[] result = new int[1 + coverIDs.size()];
        result[0] = bookingID;
        for (int i = 0; i < coverIDs.size(); i++) {
            result[i + 1] = coverIDs.get(i);
        }
        return result;
    }

    /**
     * Retruns bookings from the database which have status ID of 1 or 2, which means bookings that are either confirmed or arrived, these are loaded onto the program.
     * For each booking it returns the corresponding tableIDs reseved and the coverIDs
     * loadBooking method is called to store the booking locally in the program
     */
    public static void returnBookings() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement selectBookings = connection.prepareStatement(
                    "SELECT * FROM Bookings WHERE BookingStatusbookingStatusID IN (1, 2)");
            ResultSet resultSet = selectBookings.executeQuery();

            while (resultSet.next()) {
                int bookingID = resultSet.getInt("bookingID");
                int numOfPeople = resultSet.getInt("numOfPeople");
                String customerName = resultSet.getString("customerName");
                String contactNumber = resultSet.getString("contactNumber");
                Timestamp startTime = resultSet.getTimestamp("startTime");
                Timestamp endTime = resultSet.getTimestamp("endTime");
                boolean paymentStatus = resultSet.getBoolean("paymentStatus");
                int statusID = resultSet.getInt("BookingStatusbookingStatusID");
                int waiterID = resultSet.getInt("WaiterwaiterID");

                // Assuming you have waiterId, tables, and covers available from somewhere
                int[] tables = TablesDAO.getTablesByBookingID(bookingID);
                int[] covers = CoverDAO.getCoversByBookingID(bookingID);

                long startTimeUnix = startTime.getTime() / 1000;
                long endTimeUnix = endTime.getTime() / 1000;

                Terminal.loadBooking(bookingID, customerName, contactNumber, waiterID, startTimeUnix, endTimeUnix,tables,covers);

                System.out.println("BookingID: " + bookingID + ", Num of People: " + numOfPeople +
                        ", Customer Name: " + customerName + ", Contact Number: " + contactNumber +
                        ", Start Time: " + startTimeUnix + ", End Time: " + endTimeUnix +
                        ", Payment Status: " + (paymentStatus ? "Paid" : "Not Paid") +
                        ", StatusID: " + statusID);
            }   

            selectBookings.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Deletes a booking form the database given a b bookingID
     * Initially all data is deleted from the Bookings_Tables which stores the reserved tables
     * then the Bookings itself is deleted from the Bookings table
     *
     * @param bookingID ID of the booking to delete
     */
    public static void deleteBooking(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            // Delete from Bookings_Tables table
            PreparedStatement deleteBookingTables = connection.prepareStatement(
                    "DELETE FROM Bookings_Tables WHERE BookingsbookingID = ?");
            deleteBookingTables.setInt(1, bookingID);
            deleteBookingTables.executeUpdate();
            deleteBookingTables.close();

            // Delete from Bookings table
            PreparedStatement deleteBooking = connection.prepareStatement(
                    "DELETE FROM Bookings WHERE bookingID = ?");
            deleteBooking.setInt(1, bookingID);
            int rowsAffected = deleteBooking.executeUpdate();
            deleteBooking.close();

            if (rowsAffected > 0) {
                System.out.println("Booking with ID " + bookingID + " deleted successfully.");
            } else {
                System.out.println("No booking found with ID " + bookingID + ".");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Set status of a booking to Arrived in the database given a bookingID
     * Updates the BookingStatusbookingStatusID column in the Bookings table to 2 for "Arrived"
     * @param bookingID Id of the booking to set as arrived
     */
    public static void setBookingStatusToArrived(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_a","rXwsW4mUvPU");) {
            PreparedStatement setArrivedStatus = connection.prepareStatement(
                    "UPDATE Bookings SET BookingStatusbookingStatusID = 2 WHERE bookingID = ? AND BookingStatusbookingStatusID = 1"); // 1 represents "Confirmed", 2 represents "Arrived"

            setArrivedStatus.setInt(1, bookingID);

            int rowsAffected = setArrivedStatus.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Booking with ID " + bookingID + " is either not found or not confirmed.");
            } else {
                System.out.println("Booking with ID " + bookingID + " has been successfully set to 'Arrived' status.");
            }

            setArrivedStatus.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Set status of a booking to Completed in the database given a bookingID
     * Updates the BookingStatusbookingStatusID column in the Bookings table to 3 for "Completed"
     * @param bookingID Id of the booking to set as completed
     */
    public static void setBookingStatusToCompleted(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_a", "rXwsW4mUvPU");) {
            PreparedStatement setCompletedStatus = connection.prepareStatement(
                    "UPDATE Bookings SET BookingStatusbookingStatusID = 3 WHERE bookingID = ?"); // 3 represents "Completed"

            setCompletedStatus.setInt(1, bookingID);

            int rowsAffected = setCompletedStatus.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Booking with ID " + bookingID + " is not found.");
            } else {
                System.out.println("Booking with ID " + bookingID + " has been successfully set to 'Completed' status.");
            }
            setCompletedStatus.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
