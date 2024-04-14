/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lancastersguiv2;

/**
 *
 * @author josep
 */
public class NewOrder extends javax.swing.JFrame {

    /**
     * Creates new form NewOrder
     */
    public NewOrder() {
        initComponents();
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
        cbNoTable = new javax.swing.JComboBox<>();
        bNoConfirm = new javax.swing.JButton();
        lNoTable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lNoMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lNoMenu.setText("MENU:");

        listNoMenu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spNoMenu.setViewportView(listNoMenu);

        javax.swing.GroupLayout pNoMenuLayout = new javax.swing.GroupLayout(pNoMenu);
        pNoMenu.setLayout(pNoMenuLayout);
        pNoMenuLayout.setHorizontalGroup(
                pNoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoMenuLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lNoMenu)
                                .addContainerGap(86, Short.MAX_VALUE))
                        .addGroup(pNoMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(spNoMenu)
                                .addContainerGap())
        );
        pNoMenuLayout.setVerticalGroup(
                pNoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lNoMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spNoMenu)
                                .addContainerGap())
        );

        bNoAdd.setText("ADD");

        bNoDelete.setText("DELETE");

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
                                .addGroup(pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bNoNote, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addGroup(pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(bNoDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(bNoAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        pNoAddDeleteLayout.setVerticalGroup(
                pNoAddDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoAddDeleteLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(bNoAdd)
                                .addGap(43, 43, 43)
                                .addComponent(bNoDelete)
                                .addGap(41, 41, 41)
                                .addComponent(bNoNote)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lNoOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lNoOrder.setText("ORDER:");

        listNoOrders.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        spNoOrder.setViewportView(listNoOrders);

        javax.swing.GroupLayout pNoOrderLayout = new javax.swing.GroupLayout(pNoOrder);
        pNoOrder.setLayout(pNoOrderLayout);
        pNoOrderLayout.setHorizontalGroup(
                pNoOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoOrderLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lNoOrder)
                                .addContainerGap(78, Short.MAX_VALUE))
                        .addGroup(pNoOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(spNoOrder)
                                .addContainerGap())
        );
        pNoOrderLayout.setVerticalGroup(
                pNoOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoOrderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lNoOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        cbNoTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbNoTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bNoConfirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bNoConfirm.setText("Confirm");
        bNoConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoConfirmActionPerformed(evt);
            }
        });

        lNoTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNoTable.setText("Table:");

        javax.swing.GroupLayout pNoTableLayout = new javax.swing.GroupLayout(pNoTable);
        pNoTable.setLayout(pNoTableLayout);
        pNoTableLayout.setHorizontalGroup(
                pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNoTableLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(bNoConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        pNoTableLayout.setVerticalGroup(
                pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNoTableLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addGroup(pNoTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bNoConfirm)
                                        .addComponent(lNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pNewOrderLayout = new javax.swing.GroupLayout(pNewOrder);
        pNewOrder.setLayout(pNewOrderLayout);
        pNewOrderLayout.setHorizontalGroup(
                pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNewOrderLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pNewOrderLayout.createSequentialGroup()
                                                .addComponent(pNoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pNoAddDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)
                                                .addComponent(pNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(265, 265, 265))
        );
        pNewOrderLayout.setVerticalGroup(
                pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pNewOrderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pNewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pNoAddDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pNoMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pNewOrderLayout.createSequentialGroup()
                                                .addComponent(pNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 6, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(pNoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 594, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(pNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 582, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 492, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pNewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>

    private void bNoConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //send order to database
        this.setVisible(false);
    }

    private void bNoNoteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
    private javax.swing.JButton bNoConfirm;
    private javax.swing.JButton bNoDelete;
    private javax.swing.JButton bNoNote;
    private javax.swing.JComboBox<String> cbNoTable;
    private javax.swing.JLabel lNoMenu;
    private javax.swing.JLabel lNoOrder;
    private javax.swing.JLabel lNoTable;
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
