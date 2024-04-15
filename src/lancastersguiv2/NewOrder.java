/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lancastersguiv2;

import FOHClasses.Booking;
import FOHClasses.Collection.BookingCollection;
import FOHClasses.Collection.MenuItemCollection;
import FOHClasses.MenuItem;
import FOHClasses.Terminal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 *
 * @author josep
 */
public class NewOrder extends javax.swing.JFrame {

    DefaultListModel<String> modelMenu, modelOrder;
    DefaultComboBoxModel<Integer> modelBookingID, modelCoverID;
    Note note;
    static String noteMessage = "";
    int bookingID;

    /**
     * Creates new form NewOrder
     */
    public NewOrder() {
        initComponents();


        //create the models we can use to populate the components
        modelMenu = new DefaultListModel<>();
        modelOrder = new DefaultListModel<>();
        modelBookingID = new DefaultComboBoxModel<>();
        modelCoverID = new DefaultComboBoxModel<>();

        note = new Note();

        for (MenuItem menuItem : MenuItemCollection.getAll()){
            if (menuItem.isAvailable()){}
            modelMenu.addElement(menuItem.getName());
        }
        listNoMenu.setModel(modelMenu);
        for (Booking booking : BookingCollection.getAll()){

            modelBookingID.addElement(booking.getBookingId());
        }
        cbNoBooking.setModel(modelBookingID);


    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        pNewOrder = new javax.swing.JPanel();
        pNoMenu = new javax.swing.JPanel();
        lNoMenu = new javax.swing.JLabel();
        spNoMenu = new javax.swing.JScrollPane();
        listNoMenu = new javax.swing.JList<>();
        pNoAddDelete = new javax.swing.JPanel();
        bNoAdd = new javax.swing.JButton();
        bNoDelete = new javax.swing.JButton();
        bNoNote = new javax.swing.JButton();
        pNoOrder = new javax.swing.JPanel();
        lNoOrder = new javax.swing.JLabel();
        spNoOrder = new javax.swing.JScrollPane();
        listNoOrders = new javax.swing.JList<>();
        pNoTable = new javax.swing.JPanel();
        cbNoBooking = new JComboBox<Integer>();
        bNoConfirm = new javax.swing.JButton();
        lNoBooking = new javax.swing.JLabel();
        lNoCover = new javax.swing.JLabel();
        cbNoCover = new JComboBox<Integer>();
        bNoBooking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lNoMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lNoMenu.setText("MENU:");

        listNoMenu.setMaximumSize(new java.awt.Dimension(100000, 10000));
        listNoMenu.setMinimumSize(new java.awt.Dimension(200, 300));
        listNoMenu.setPreferredSize(new java.awt.Dimension(200, 300));
        spNoMenu.setViewportView(listNoMenu);

        javax.swing.GroupLayout pNoMenuLayout = new javax.swing.GroupLayout(pNoMenu);
        pNoMenu.setLayout(pNoMenuLayout);
        pNoMenuLayout.setHorizontalGroup(
                pNoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(spNoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(pNoMenuLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(lNoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        pNoMenuLayout.setVerticalGroup(
                pNoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lNoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spNoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addContainerGap())
        );

        bNoAdd.setText("ADD");
        bNoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoAddActionPerformed(evt);
            }
        });

        bNoDelete.setText("DELETE");
        bNoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoDeleteActionPerformed(evt);
            }
        });

        bNoNote.setText("NOTE");
        bNoNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoNoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pNoAddDeleteLayout = new javax.swing.GroupLayout(pNoAddDelete);
        pNoAddDelete.setLayout(pNoAddDeleteLayout);
        pNoAddDeleteLayout.setHorizontalGroup(
                pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoAddDeleteLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bNoNote, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bNoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bNoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
        );
        pNoAddDeleteLayout.setVerticalGroup(
                pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoAddDeleteLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(bNoAdd)
                                .addGap(34, 34, 34)
                                .addComponent(bNoDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(bNoNote)
                                .addGap(90, 90, 90))
        );

        lNoOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lNoOrder.setText("ORDER:");

        listNoOrders.setMaximumSize(new java.awt.Dimension(100000, 100000));
        listNoOrders.setMinimumSize(new java.awt.Dimension(200, 300));
        listNoOrders.setPreferredSize(new java.awt.Dimension(200, 300));
        spNoOrder.setViewportView(listNoOrders);

        javax.swing.GroupLayout pNoOrderLayout = new javax.swing.GroupLayout(pNoOrder);
        pNoOrder.setLayout(pNoOrderLayout);
        pNoOrderLayout.setHorizontalGroup(
                pNoOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(spNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(pNoOrderLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lNoOrder)
                                .addGap(0, 91, Short.MAX_VALUE))
        );
        pNoOrderLayout.setVerticalGroup(
                pNoOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spNoOrder)
                                .addGap(12, 12, 12))
        );

        cbNoBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        bNoConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bNoConfirm.setText("Confirm");
        bNoConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoConfirmActionPerformed(evt);
            }
        });

        lNoBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNoBooking.setText("Booking:");

        lNoCover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNoCover.setText("Cover:");

        bNoBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pNoTableLayout = new javax.swing.GroupLayout(pNoTable);
        pNoTable.setLayout(pNoTableLayout);
        pNoTableLayout.setHorizontalGroup(
                pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoTableLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lNoBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbNoBooking, 0, 92, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(bNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lNoCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbNoCover, 0, 92, Short.MAX_VALUE)
                                .addGap(37, 37, 37)
                                .addComponent(bNoConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addGap(36, 36, 36))
        );
        pNoTableLayout.setVerticalGroup(
                pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoTableLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lNoBooking)
                                                .addComponent(bNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bNoConfirm)
                                                .addComponent(cbNoCover, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lNoCover)))
                                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pNewOrderLayout = new javax.swing.GroupLayout(pNewOrder);
        pNewOrder.setLayout(pNewOrderLayout);
        pNewOrderLayout.setHorizontalGroup(
                pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNewOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pNoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pNoAddDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNewOrderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );
        pNewOrderLayout.setVerticalGroup(
                pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNewOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pNoAddDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pNoMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pNoOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(pNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pNewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    //method for creating a new order
    private void bNoConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //send order to database
        List<Integer> l = new ArrayList<>();
        List<String> orderItems = new ArrayList<>();
        int iComponentCount = listNoOrders.getComponentCount();
        for (int i = 0; i < iComponentCount;i++){
            orderItems.add(listNoOrders.getComponent(i).toString());
        }

        List<MenuItem> menuItems = MenuItemCollection.getAll();

        for (String s : orderItems){
            for (MenuItem menuItem : menuItems){
                if (s.equals(menuItem.getName())) {
                    l.add(menuItem.getItemId());
                }
            }
        }
        int[] orders = new int[l.size()];
        for (int i = 0; i < orders.length; i++){
            orders[i] = l.get(i);
        }

        cbNoBooking.setModel(modelBookingID);
        cbNoCover.setModel(modelCoverID);
        int bookingID = (int) modelBookingID.getSelectedItem();
        int coverID = (int) modelCoverID.getSelectedItem();

        Terminal.newOrder(bookingID, coverID, orders, noteMessage);


        noteMessage = "";


        this.setVisible(false);
    }

    private void bNoNoteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        note.setVisible(true);
        //note.get
    }

    private void bNoAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(listNoMenu.getSelectedValue() != null){
            modelOrder.addElement(listNoMenu.getSelectedValue());
            listNoOrders.setModel(modelOrder);
        }
    }

    private void bNoDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(listNoOrders.getSelectedValue() != null){
            modelOrder.remove(listNoOrders.getSelectedIndex());
            listNoOrders.setModel(modelOrder);
        }
    }

    private void bNoBookingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Booking thisBooking;
        if(modelBookingID.getSelectedItem() != null) {
            int bookingID = Integer.parseInt(cbNoBooking.getSelectedItem().toString());
            thisBooking = BookingCollection.get(bookingID);

            modelCoverID.removeAllElements();

            for (int i = 0; i < thisBooking.getCovers().length; i++) {
                modelCoverID.addElement(thisBooking.getCovers()[i]);
            }
        }
        cbNoCover.setModel(modelCoverID);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bNoAdd;
    private javax.swing.JButton bNoBooking;
    private javax.swing.JButton bNoConfirm;
    private javax.swing.JButton bNoDelete;
    private javax.swing.JButton bNoNote;
    private JComboBox<Integer> cbNoBooking;
    private JComboBox<Integer> cbNoCover;
    private javax.swing.JLabel lNoBooking;
    private javax.swing.JLabel lNoCover;
    private javax.swing.JLabel lNoMenu;
    private javax.swing.JLabel lNoOrder;
    private javax.swing.JList<String> listNoMenu;
    private javax.swing.JList<String> listNoOrders;
    private javax.swing.JPanel pNewOrder;
    private javax.swing.JPanel pNoAddDelete;
    private javax.swing.JPanel pNoMenu;
    private javax.swing.JPanel pNoOrder;
    private javax.swing.JPanel pNoTable;
    private javax.swing.JScrollPane spNoMenu;
    private javax.swing.JScrollPane spNoOrder;
    // End of variables declaration
}
