package FOHClasses;

import lancastersguiv2.TabbedGUI;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private static final List<String> notification = new ArrayList<>();

    public static List<String> getNotification() {
        return notification;
    }

    public static void addNotification(String notification){
        Notification.notification.add(notification);
        TabbedGUI.newNotification(notification);
    }
}
