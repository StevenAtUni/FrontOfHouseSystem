package FOHClasses.DatabaseDAO;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import FOHClasses.Booking;
import Utils.TimeConversion;

public class BookingDAO {
    public static void createBooking(int customerID, Date bookingDate, Time bookingTime, int numOfPeople, String note) { // BookingDAO.createBooking(1, Date.valueOf("2024-04-15"), Time.valueOf("17:00:00"), 4, "None");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement createBooking = connection.prepareStatement(
                    "INSERT INTO Booking (CustomercustomerID, bookingDate, bookingTime, numOfPeople, BookingStatusbookingStatusID, Note) " +
                            "VALUES (?, ?, ?, ?, 1, ?)"); // Default BookingStatusbookingStatusID to 1 (Confirmed)

            createBooking.setInt(1, customerID);
            createBooking.setDate(2, bookingDate);
            createBooking.setTime(3, bookingTime);
            createBooking.setInt(4, numOfPeople);
            createBooking.setString(5, note);

            createBooking.executeUpdate();
            createBooking.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static List<Booking> findConfirmedBookingsByDate(Date date) { // BookingDAO.findConfirmedBookingsByDate(Date.valueOf("2024-04-15"));
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07","in2033t07_d","qbB_pkC1GZQ");) {
            PreparedStatement selectBookings = connection.prepareStatement(
                    "SELECT * FROM Booking WHERE BookingStatusbookingStatusID = 1 AND bookingDate = ?");

            selectBookings.setDate(1, date);

            ResultSet resultSet = selectBookings.executeQuery();

            List<Booking> bookings = new ArrayList<>();
            while (resultSet.next()) {
                int bookingID = resultSet.getInt("bookingID");
                int customerID = resultSet.getInt("CustomercustomerID");
                Date bookingDate = resultSet.getDate("bookingDate");
                Time bookingTime = resultSet.getTime("bookingTime");
                int numOfPeople = resultSet.getInt("numOfPeople");
                String note = resultSet.getString("Note");

                Booking booking = new Booking(bookingID, customerID,numOfPeople, Instant.now().getEpochSecond(), Math.toIntExact(bookingDate.getTime()), note );
                bookings.add(booking);
            }
            selectBookings.close();
            return bookings;

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
