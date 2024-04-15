package FOHClasses.DatabaseDAO;

import FOHClasses.DishQuantity;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class OrderDAO {

        public static int createOrder(int coverID, String orderNote, int[] dishIDs) {
            /* List<DishQuantity> dishQuantities = new ArrayList<>();
            dishQuantities.add(new DishQuantity(1, 2));
            dishQuantities.add(new DishQuantity(2, 1));
            OrderDAO.createOrder(2, "None", dishQuantities); */
            int generatedOrderID = -1; // Initialize with a default value
            HashMap<Integer, Integer> countMap = new HashMap<>();

            // Count the occurrences of each number
            for (int num : dishIDs) {
                if (countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num) + 1);
                } else {
                    countMap.put(num, 1);
                }
            }


            try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {

                // Create the order
                PreparedStatement createOrder = connection.prepareStatement(
                        "INSERT INTO `Order` (orderNote, CoverscoverID) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

                createOrder.setString(1, orderNote);
                createOrder.setInt(2, coverID);

                int rowsAffected = createOrder.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.println("Failed to create new order.");
                    return generatedOrderID;
                }

                ResultSet generatedKeys = createOrder.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedOrderID = generatedKeys.getInt(1); // Retrieve the generated orderID
                    System.out.println("New order with ID " + generatedOrderID + " has been successfully created.");
                    // Add dishes to OrderedDishes table
                    PreparedStatement addOrderedDish = connection.prepareStatement(
                            "INSERT INTO OrderedDishes (OrderorderID, DishesdishID, Quantity) VALUES (?, ?, ?)");

                    for (int key : countMap.keySet()) {
                        int count = countMap.get(key);
                        addOrderedDish.setInt(1, generatedOrderID);
                        addOrderedDish.setInt(2, key);
                        addOrderedDish.setInt(3, count);

                        addOrderedDish.addBatch();
                    }

                    addOrderedDish.executeBatch();
                    addOrderedDish.close();
                } else {
                    System.out.println("Failed to retrieve generated order ID.");
                    return generatedOrderID;
                }

                createOrder.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return generatedOrderID;
        }



        public static void cancelOrder(int orderID) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
                PreparedStatement cancelOrder = connection.prepareStatement(
                        "UPDATE `Order` SET OrderStatusorderStatusID = 4 WHERE orderID = ?");
                cancelOrder.setInt(1, orderID);

                int rowsAffected = cancelOrder.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.println("Failed to cancel order with ID: " + orderID);
                } else {
                    System.out.println("Order with ID " + orderID + " has been cancelled successfully.");
                }

                cancelOrder.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public static void setOrderStatusToReady(int orderID) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
                PreparedStatement prepareOrder = connection.prepareStatement(
                        "UPDATE `Order` SET OrderStatusorderStatusID = 3 WHERE orderID = ? AND OrderStatusorderStatusID = 1");
                prepareOrder.setInt(1, orderID);

                int rowsAffected = prepareOrder.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.println("Failed to set order with ID " + orderID + " to 'Ready'.");
                } else {
                    System.out.println("Order with ID " + orderID + " is now set to 'Ready'.");
                }

                prepareOrder.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public static void setOrderStatusToCompleted(int orderID) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t07", "in2033t07_d", "qbB_pkC1GZQ");) {
                PreparedStatement completeOrder = connection.prepareStatement(
                        "UPDATE `Order` SET OrderStatusorderStatusID = 4 WHERE orderID = ? AND OrderStatusorderStatusID = 3");
                completeOrder.setInt(1, orderID);

                int rowsAffected = completeOrder.executeUpdate();

                if (rowsAffected == 0) {
                    System.out.println("Failed to set order with ID " + orderID + " to 'Completed'.");
                } else {
                    System.out.println("Order with ID " + orderID + " is now set to 'Completed'.");
                }

                completeOrder.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }




