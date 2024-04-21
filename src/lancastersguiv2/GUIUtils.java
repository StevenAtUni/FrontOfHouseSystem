package lancastersguiv2;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.List; // Import for using List
import FOHClasses.DatabaseDAO.WaiterDAO; // Adjust the import based on the actual package of WaiterDAO

/**
 * This class provides utility methods for GUI components to interact with application data,
 * such as populating UI elements with data from the database.
 */
public class GUIUtils {

    /**
     * Populates JComboBox with waiter IDs retrieved from the database.
     * The IDs are added as string items to the provided JComboBox.
     * If an error occurs during retrieval, an error dialog is shown.
     *
     * @param comboBox The JComboBox to be populated with waiter IDs.
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
