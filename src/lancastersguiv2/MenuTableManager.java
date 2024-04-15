package lancastersguiv2;

import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MenuTableManager {
    public static void updateMenuTable(JTable menuTable){
        DefaultTableModel model = (DefaultTableModel) menuTable.getModel();
        model.setRowCount(0);  // Clear existing data

        List<MenuItem> menuItems = MenuItemCollection.getAll();

        for (MenuItem menuItem : menuItems) {
            model.addRow(new Object[]{
                    menuItem.getName(),
                    menuItem.getPrice(),
                    menuItem.getDescription(),
                    menuItem.getAllergens()
            });
        }

    }
}
