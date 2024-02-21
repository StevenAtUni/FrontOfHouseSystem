public interface FOHKitchenInterface {

  //Dish ordering, a method that will send data of the order
  public void sendOrder(int orderID, int tableID, int[] dishes, String orderNote);

  //Note update, the method on which will send an update to a note to the kitchen on a specific order
  public void noteUpdate (int orderID, String newOrderNote);

  //Method for the kitchen to indicate a order is complete
  public void orderComplete(int orderID);

  // method for the kitchen to notify which dishes are unavailable
  public void markDishUnavailable(int dishID);

}
