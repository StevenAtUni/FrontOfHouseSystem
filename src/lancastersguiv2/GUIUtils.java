package lancastersguiv2;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List; // Import for using List
import FOHClasses.DatabaseDAO.WaiterDAO; // Adjust the import based on the actual package of WaiterDAO

public class GUIUtils {

    /**
     * Populates the provided JComboBox with waiter IDs from the database.
     * @param comboBox The JComboBox to populate.
     */
    public static void populateWaiterDropdown(JComboBox<String> comboBox) {
        try {
            int[] waiterIDs = WaiterDAO.getAllWaiterIDs(); // Assuming this method exists and returns List<Integer>
            for (int id : waiterIDs) {
                comboBox.addItem(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load waiter IDs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

