public interface FOHKitchenInterface {

    // Method for the kitchen to indicate an order is complete and appropriately notify for serving
    void markItemComplete(int orderID, int itemID);

    // Method to notify the FoH System which menu items to display as no longer available to order
    void markItemUnavailable(int itemID);
}
