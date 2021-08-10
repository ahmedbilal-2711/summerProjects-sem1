/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimmy;

import java.awt.event.KeyEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maryam
 */
public class AddressBook extends javax.swing.JFrame {
        DefaultTableModel model;
    /**
     * Creates new form AddressBook
     */
    public AddressBook() {
        initComponents();
        model = (DefaultTableModel) address_tbl.getModel();
        address_tbl.setRowHeight(25);
        address_tbl.setShowGrid(true);
    }
    
    public void tableChanged() {
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address_tbl = new javax.swing.JTable();
        clear_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 83, 83,80));

        jLabel1.setFont(new java.awt.Font("Rage Italic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MIMMY'S ADDRESS BOOK");

        address_tbl.setBackground(new java.awt.Color(204, 153, 255));
        address_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Work", "Mobile", "Home", "Email Address", "Date Of Birth", "Address"
            }
        ));
        address_tbl.setColumnSelectionAllowed(true);
        address_tbl.setNextFocusableComponent(add_btn);
        address_tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                address_tblKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(address_tbl);
        if (address_tbl.getColumnModel().getColumnCount() > 0) {
            address_tbl.getColumnModel().getColumn(0).setResizable(false);
            address_tbl.getColumnModel().getColumn(0).setHeaderValue("Name");
            address_tbl.getColumnModel().getColumn(1).setResizable(false);
            address_tbl.getColumnModel().getColumn(1).setHeaderValue("Work");
            address_tbl.getColumnModel().getColumn(2).setResizable(false);
            address_tbl.getColumnModel().getColumn(2).setHeaderValue("Mobile");
            address_tbl.getColumnModel().getColumn(3).setResizable(false);
            address_tbl.getColumnModel().getColumn(3).setHeaderValue("Home");
            address_tbl.getColumnModel().getColumn(4).setResizable(false);
            address_tbl.getColumnModel().getColumn(4).setHeaderValue("Email Address");
            address_tbl.getColumnModel().getColumn(5).setHeaderValue("Date Of Birth");
            address_tbl.getColumnModel().getColumn(6).setResizable(false);
            address_tbl.getColumnModel().getColumn(6).setHeaderValue("Address");
        }

        clear_btn.setBackground(new java.awt.Color(204, 153, 255));
        clear_btn.setText("Clear");
        clear_btn.setBorder(null);
        clear_btn.setNextFocusableComponent(address_tbl);
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        close_btn.setBackground(new java.awt.Color(204, 153, 255));
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mimmy/previous.png"))); // NOI18N
        close_btn.setBorder(null);
        close_btn.setFocusable(false);
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(204, 153, 255));
        delete_btn.setText("Delete");
        delete_btn.setBorder(null);
        delete_btn.setNextFocusableComponent(clear_btn);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        add_btn.setBackground(new java.awt.Color(204, 153, 255));
        add_btn.setText("Add");
        add_btn.setBorder(null);
        add_btn.setNextFocusableComponent(update_btn);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(new java.awt.Color(204, 153, 255));
        update_btn.setText("Update");
        update_btn.setBorder(null);
        update_btn.setNextFocusableComponent(delete_btn);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mimmy/wallpaper_geometric_color_20_2k_uhd_by_airworldking_d9pj82h-pre.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        setSize(new java.awt.Dimension(906, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        dispose();
    }//GEN-LAST:event_close_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        if (address_tbl.getSelectedRow() != -1){
            
            int modelRow = address_tbl.convertRowIndexToModel(address_tbl.getSelectedRow());
            model.removeRow(modelRow);
            model.addRow(new Object[]{});

            
        }
    }//GEN-LAST:event_clear_btnActionPerformed

    private void address_tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_tblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if ((address_tbl.getSelectedRow() + 1) == model.getRowCount()) {
                model.addRow(new Object[]{});
            }

        }
    }//GEN-LAST:event_address_tblKeyPressed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (address_tbl.getSelectedRow() != -1) {
            int modelRow = address_tbl.convertRowIndexToModel(address_tbl.getSelectedRow());
            model.removeRow(modelRow);
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        model.addRow(new Object[]{});
    }//GEN-LAST:event_add_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_btnActionPerformed

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
            java.util.logging.Logger.getLogger(AddressBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddressBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddressBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddressBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddressBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTable address_tbl;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton close_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
