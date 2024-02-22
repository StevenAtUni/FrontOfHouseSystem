public interface FOHKitchenInterface {

    // Method for the kitchen to indicate an order is complete
    void markOrderComplete(int orderID);

    // Method for the kitchen to notify which dishes are unavailable
    void markItemUnavailable(int itemID);
}
