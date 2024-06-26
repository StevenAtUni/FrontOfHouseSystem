package FOHInterface;

import java.util.HashMap;
import java.util.List;

public interface FOHManagementInterface {

    // Method for the management team to invoke and send us the new menu.
    void sendMenu(HashMap<Integer, List<String>> dishMenu, HashMap<Integer, List<String>> wineMenu);
    // Three separate menus for dishes, drinks and wines, as requested by your Deputy Leader on Thursday evening

    // Method to view how many individual 2-seat tables are booked for the specified time
    int getAmountBooked(long timestamp);

    // Method to update the service charge percentage. Integer used as per management's request
    void setServiceCharge(int newCharge);
}
