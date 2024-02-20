public abstract class FOHController implements FOHManagementInterface, FOHKitchenInterface {


  @Override
  public void getMenu(String[][] menu) {

  }

  @Override
  public void getBookingData(String bookingData) {

  }

  @Override
  public void sendRecipe(int bookingID, int bookingStartTime, int bookingEndTime, int diners,
      String[] dishesPurchased, int dishPrices, int tipAmount, int serviceCharge) {

  }

  @Override
  public void sendOrder(int orderID, int tableID, String[] dishName, String orderNote) {

  }

  @Override
  public void noteUpdate(int orderID, String NewOrderNote) {

  }

  @Override
  public void orderComplete(int orderID) {

  }

  @Override
  public void DishUnavailable(String dishName) {

  }
}
