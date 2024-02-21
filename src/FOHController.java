public abstract class FOHController implements FOHManagementInterface, FOHKitchenInterface {


  @Override
  public Menu getMenu() {
    return null;

  }

  @Override
  public BookingData getBookingData(int date) {
    return null;
  }

  @Override
  public void sendBill(int billID, int date, int sum, String stuff, String[] dishes,
      String[] wine) {

  }

  @Override
  public void sendItemPopularity(int date, int itemID) {

  }

  @Override
  public void sendOrder(int orderID, int tableID, int[] dishes, String orderNote) {

  }

  @Override
  public void noteUpdate(int orderID, String newOrderNote) {

  }

  @Override
  public void orderComplete(int orderID) {

  }

  @Override
  public void markDishUnavailable(int dishID) {

  }
}
