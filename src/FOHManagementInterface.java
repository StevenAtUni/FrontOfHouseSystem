public interface FOHManagementInterface {

  //Method to get the menu from management
  public Menu getMenu();
  
  //Get the booking day of the current day from management
  public BookingData getBookingData (int date);

  //send the receipts data to management
  public void sendBill (int billID, int date, int sum, String stuff, String[] dishes, String[] wine);

  public void sendItemPopularity(int date, int itemID);

}
