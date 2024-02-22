public interface FOHManagementInterface {

    // Method for the management team to invoke and send us the new menu.
    void sendMenu (Object[][] menu);

    // Method for the management team to view how many tables (2 seats) are booked for specific time
    int getAmountBooked(int timestamp);
}
