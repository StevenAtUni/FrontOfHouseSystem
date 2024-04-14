package FOHClasses;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private static final List<String> notification = new ArrayList<>();

    public static String[] getNotification() {
        return (String[]) notification.toArray();
    }


    public static void addNotification(String notification){
        Notification.notification.add(notification);
    }
}
