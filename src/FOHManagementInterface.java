public interface FOHManagementInterface {

  //Method to get the menu from management
  public Menu getMenu ();
  
  //Get the booking day of the current day from management
  public BoookingData getBookingData (int date);

  //send the receipts data to management
  public void sendBill (int billID, int date, int sum, String stuff, String[] servedDishes, String[] servedWines);

  public void sendDishPopularity (int date, int itemID, int saleNum);

  //send booking info
  public void sendInfoForBooking (int date, int bookings);

  public void sendInfoForStaffNeeded (int date, int time, int bookings, int customers, int tables);

  public void sendReservationInfo (int date, int reservID, String name, int people, int tables, String tableArrangement);
}

/**
 * Front of House:
 *
 * 	- Sales table
 * 		- Bills
 * 			- Bill ID
 * 			- Date
 * 			- Sum
 * 			- Stuff
 * 			- Dishes served
 * 			- Wines served
 * 		- Dish popularity
 * 			- Date
 * 			- Dish ID
 * 			- Number of sales
 * 		- Wine popularity
 * 			- Date
 * 			- Wine ID
 * 			- Number of sales
 *
 * 	- Bookings table
 * 		- Predict bookings
 * 			- Date
 * 			- Number of bookings
 * 		- Predict number of staff needed
 * 			- Date
 * 			- Time
 * 			- Number of bookings
 * 			- Number of people
 * 			- Number of tables
 * 		- Pre-booking information
 * 			- Date
 * 			- Reservation number
 * 			- Reservation name
 * 			- Number of people
 * 			- Number of tables
 * 			- Table arrangement information (if any)

 **/
