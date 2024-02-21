public interface FOHManagementInterface {

    //Method to get the menu from mangement
    public void getMenu (String[][] menu);

    //Get the booking day of the current day from management
    public void getBookingData (String bookingData);

    //send the receipts data to mangement
    public void sendReceipts(int bookingID, int bookingStartTime, int bookingEndTime, int diners, String[] dishesPurchased, int dishPrices, int tipAmount, int serviceCharge);

}
