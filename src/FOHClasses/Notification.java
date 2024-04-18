package FOHClasses;

import lancastersguiv2.TabbedGUI;

import java.util.ArrayList;
import java.util.List;

/**
 * A static class for handling notifications.
 */
public class Notification {
    /**
     * ArrayList of notification messages as strings.
     */
    private static final List<String> notification = new ArrayList<>();

    /**
     * Fetches all notifications.
     * @return An ArrayList of notifications
     */
    public static List<String> getNotification() {
        return notification;
    }

    /**
     * Adds a new notification to the list of notifications.
     * @param notification The notification to add
     */
    public static void addNotification(String notification){
        Notification.notification.add(notification);
        TabbedGUI.newNotification(notification);
    }
}
