public interface FOHKitchenInterface {

    // Method for the kitchen to indicate an order is complete.
    // FoH's implementation will work out when a course has been fully assembled at the pass to notify for serving
    void markItemComplete(int orderID, int itemID);

    // Method to notify the FoH System which menu items to display as no longer available to order
    void markItemUnavailable(int itemID);

    // Returns an 2D array of Objects (allows varying data types) to the Kitchen's place of method invocation
    Object[][] getOrders();
    /*
    We are including this method as you requested it in your requirements document, but it should ideally be
    a method within the Kitchen's interface so that FOH can invoke it whenever there is an order to send.

    Within your interface, there should be:
        void sendOrder(int orderID, int tableID, int[] items, String orderNote);
    Note: Within our requirements document, it is featured as "ArrayList<Integer> items" but int[] would be more
    memory efficient.

    The reasoning for implementing this on your side of the system is that we will need to invoke this method
    on demand to send you the data via parameters, allowing you to then process that data however you want.
    By providing us with the public method, we use it when an order has been made. If it is implemented in our
    interface, you would have to routinely call it to check if there have been any new orders, which is not
    optimal or efficient.
     */
}
