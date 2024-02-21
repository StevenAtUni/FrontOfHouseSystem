public abstract class FOHController implements FOHManagementInterface, FOHKitchenInterface {


  @Override
  public void getMenu(String[][] menu) {

  }

  @Override
  public void getBookingData(String bookingData) {

  }

  @Override
  public void sendReceipts(int bookingID, int bookingStartTime, int bookingEndTime, int diners,
      String[] dishesPurchased, int dishPrices, int tipAmount, int serviceCharge) {

  }

//  @Override
//  public void sendOrder(int orderID, int tableID, int[] dishes, String orderNote) {
//
//  }

//  @Override
//  public void noteUpdate(int orderID, String newOrderNote) {
//
//  }

  @Override
  public void markOrderComplete(int orderID) {

  }

  @Override
  public void markItemUnavailable(int itemID) {

  }
}
