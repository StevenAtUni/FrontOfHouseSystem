public interface FOHManagementInterface {
  public void getMenu (String[][] menu);

  public void getBookingData (String bookingData);

  public void sendRecipe(int bookingID, int bookingStartTime, int bookingEndTime, int diners, String[] dishesPurchased, int dishPrices, int tipAmount, int serviceCharge);

}
