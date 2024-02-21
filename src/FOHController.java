
public abstract class FOHController implements FOHManagementInterface, FOHKitchenInterface {


  @Override
  public Menu getMenu() {
      return null;
  }

  @Override
  public void sendBill(int billID, int date, int sum, String stuff, String[] servedDishes,
      String[] servedWines) {

  }

  @Override
  public void sendDishPopularity(int date, int itemID, int saleNum) {

  }

  @Override
  public void sendInfoForBooking(int date, int bookings) {

  }

  @Override
  public void sendInfoForStaffNeeded(int date, int time, int bookings, int customers, int tables) {

  }

  @Override
  public void sendReservationInfo(int date, int reservID, String name, int people, int tables,
      String tableArrangement) {

  }

  @Override
  public BoookingData getBookingData(int date) {

    return null;
  }


  @Override
  public void sendOrder(int orderID, int tableID, int[] dishes, String orderNote) {

  }

  @Override
  public void sendNoteUpdate(int orderID, String newOrderNote) {

  }

  @Override
  public void getOrderComplete() {

  }

  @Override
  public void markDishUnavailable() {

  }
}
