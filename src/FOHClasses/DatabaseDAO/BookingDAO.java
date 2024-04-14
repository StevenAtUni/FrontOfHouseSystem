package FOHClasses.DatabaseDAO;

import java.sql.*;

import FOHClasses.Booking;

public class BookingDAO {
    public static void createBooking(int numOfPeople, String customerName, String contactNumber, long startTime, long endTime, int[] tableIDs) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            // Insert into Bookings table
            PreparedStatement createBooking = connection.prepareStatement(
                    "INSERT INTO Bookings (numOfPeople, customerName, contactNumber, startTime, endTime) " +
                            "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            Timestamp tstartTime = new Timestamp(startTime * 1000L);
            Timestamp tendTime = new Timestamp(endTime * 1000L);

            createBooking.setInt(1, numOfPeople);
            createBooking.setString(2, customerName);
            createBooking.setString(3, contactNumber);
            createBooking.setTimestamp(4, tstartTime);
            createBooking.setTimestamp(5, tendTime);

            int rowsAffected = createBooking.executeUpdate();
            int bookingID = -1; // Initialize bookingID

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
            } else {
                System.out.println("Failed to insert tables for the booking");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static void findConfirmedBookingsByDate(Date date) { // BookingDAO.findConfirmedBookingsByDate(Date.valueOf("2024-04-15"));
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement selectBookings = connection.prepareStatement(
                    "SELECT * FROM Booking WHERE BookingStatusbookingStatusID = 1 AND bookingDate = ?");

            selectBookings.setDate(1, date);

            ResultSet resultSet = selectBookings.executeQuery();

            while (resultSet.next()) {
                int bookingID = resultSet.getInt("bookingID");
                int customerID = resultSet.getInt("CustomercustomerID");
                Date bookingDate = resultSet.getDate("bookingDate");
                Time bookingTime = resultSet.getTime("bookingTime");
                int numOfPeople = resultSet.getInt("numOfPeople");
                String note = resultSet.getString("Note");

                System.out.println("BookingID: " + bookingID + ", CustomerID: " + customerID +
                        ", Date: " + bookingDate + ", Time: " + bookingTime +
                        ", Number of People: " + numOfPeople + ", Note: " + note);
            }

            selectBookings.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void cancelConfirmedBooking(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_a","rXwsW4mUvPU");) {
            PreparedStatement cancelBooking = connection.prepareStatement(
                    "UPDATE Booking SET BookingStatusbookingStatusID = 4 WHERE bookingID = ? AND BookingStatusbookingStatusID = 1"); // 1 represents "Confirmed", 4 represents "Cancelled"

            cancelBooking.setInt(1, bookingID);

            int rowsAffected = cancelBooking.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Booking with ID " + bookingID + " is either not found or not confirmed.");
            } else {
                System.out.println("Booking with ID " + bookingID + " has been successfully cancelled.");
            }

            cancelBooking.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setBookingStatusToArrived(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_a","rXwsW4mUvPU");) {
            PreparedStatement setArrivedStatus = connection.prepareStatement(
                    "UPDATE Booking SET BookingStatusbookingStatusID = 2 WHERE bookingID = ? AND BookingStatusbookingStatusID = 1"); // 1 represents "Confirmed", 2 represents "Arrived"

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

    public static void setBookingStatusToCompleted(int bookingID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_a","rXwsW4mUvPU");) {
            PreparedStatement setCompletedStatus = connection.prepareStatement(
                    "UPDATE Booking SET BookingStatusbookingStatusID = 3 WHERE bookingID = ? AND BookingStatusbookingStatusID = 2"); // 2 represents "Arrived", 3 represents "Completed"

            setCompletedStatus.setInt(1, bookingID);

            int rowsAffected = setCompletedStatus.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Booking with ID " + bookingID + " is either not found or not in 'Arrived' status.");
            } else {
                System.out.println("Booking with ID " + bookingID + " has been successfully set to 'Completed' status."); // TO DO  (automatically create receipt)
            }
            setCompletedStatus.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
