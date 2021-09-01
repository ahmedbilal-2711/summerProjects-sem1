/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Bilal Siddiqui
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class passwordsgui extends javax.swing.JFrame {
        
        
    Connection con = null;
    Statement s = null;
    DefaultTableModel t ;
    String ipadd;
    
    public passwordsgui() throws SQLException {
        initComponents();
        t = (DefaultTableModel) passTable.getModel();
        connection();
        readData();
        
    }
    
    //Connection to java and Database
    public void connection(){
        //Get ip of computer for connection
        try {
    
            InetAddress ip = InetAddress.getLocalHost();
            ipadd = ip.toString().substring(12);
            System.out.println("Your current IP address : " + ipadd); 
         } catch (UnknownHostException ex) {
            Logger.getLogger(passwordsgui.class.getName()).log(Level.SEVERE, null, ex);
         }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
            con = DriverManager.getConnection("jdbc:sqlserver://"+ipadd+":2001;databaseName=passwords", "ahmed", "1"); 
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
     //Read data from database and show into table
     public void readData() throws SQLException{
        s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM mimmy_passwords");
        while (rs.next()) {
            
            int sr = rs.getInt("Sr");
            String app = rs.getString("App");
            String email = rs.getString("Email");
            String pass = rs.getString("Password");
            System.out.println(sr+"\t"+app+"\t"+email+"\t"+pass);
            t.addRow(new Object[]{sr,app,email,pass});
        }
        s.close();
     }
     
     //Update Data from the row selected
     public void updateData(){
         if(passTable.getSelectedRowCount()==1){
            try {
                //Fetch data from the table
                int row = passTable.getSelectedRow();
                String app =  (String) t.getValueAt(row, 1);
                String email = (String) t.getValueAt(row, 2);
                String ps = (String) t.getValueAt(row, 3);
                System.out.println("Debug\t"+row+"\t"+app+"\t"+email+"\t"+ps );
                //Inserting updated table to database
                int sr = (int) t.getValueAt(row, 0);
                PreparedStatement s = con.prepareStatement("UPDATE mimmy_passwords set App=?, Email=?, Password= ? WHERE Sr = "+sr);  
                s.setString(1, app);
                s.setString(2, email);
                s.setString(3, ps);
                s.executeUpdate();
                s.close();
            } catch (SQLException ex) {
                Logger.getLogger(passwordsgui.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
         else{
             JOptionPane.showMessageDialog(this, "Please select a row");
         }
     }
     
     //Add new data
     public void addData(){
         dispose();
         passwordsAddInput i = new passwordsAddInput();
         i.setVisible(true);
     }
     
     //Delete the selected row from table and database
     public void deleteData(){
        try {
            //Delete from database
            int row = passTable.getSelectedRow();
            int sr = (int) t.getValueAt(row, 0);
            System.out.println(row);
            PreparedStatement p = con.prepareStatement("DELETE FROM mimmy_passwords WHERE Sr="+sr);
            p.executeUpdate();
            t.removeRow(row);
            System.out.println("deleted");
            p.close();
            //Delete from tabel
        } catch (SQLException ex) {
            Logger.getLogger(passwordsgui.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPane = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        headerImg = new javax.swing.JLabel();
        editPane = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        deletePane = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        addPane = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        footerImg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        passTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Passwords Vault"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\passwordsBack.png")); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backPaneLayout = new javax.swing.GroupLayout(backPane);
        backPane.setLayout(backPaneLayout);
        backPaneLayout.setHorizontalGroup(
            backPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPaneLayout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backPaneLayout.setVerticalGroup(
            backPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backPaneLayout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(backPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 40));

        headerImg.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\passwordsBg.png")); // NOI18N
        getContentPane().add(headerImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        edit.setBackground(new java.awt.Color(0, 0, 0));
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPaneLayout = new javax.swing.GroupLayout(editPane);
        editPane.setLayout(editPaneLayout);
        editPaneLayout.setHorizontalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPaneLayout.createSequentialGroup()
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        editPaneLayout.setVerticalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(editPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 60, -1));

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePaneLayout = new javax.swing.GroupLayout(deletePane);
        deletePane.setLayout(deletePaneLayout);
        deletePaneLayout.setHorizontalGroup(
            deletePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        deletePaneLayout.setVerticalGroup(
            deletePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(deletePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 290, 80, -1));

        add.setBackground(new java.awt.Color(0, 0, 0));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPaneLayout = new javax.swing.GroupLayout(addPane);
        addPane.setLayout(addPaneLayout);
        addPaneLayout.setHorizontalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPaneLayout.createSequentialGroup()
                .addComponent(add)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addPaneLayout.setVerticalGroup(
            addPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(addPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 50, 30));

        footerImg.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\passwordsBg.png")); // NOI18N
        getContentPane().add(footerImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 500, 50));

        passTable.setAutoCreateRowSorter(true);
        passTable.setBackground(new java.awt.Color(0, 102, 0));
        passTable.setForeground(new java.awt.Color(255, 255, 255));
        passTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr No.", "App", "Email", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        passTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        passTable.setGridColor(new java.awt.Color(255, 255, 255));
        passTable.setSelectionBackground(new java.awt.Color(204, 255, 204));
        passTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        passTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(passTable);
        if (passTable.getColumnModel().getColumnCount() > 0) {
            passTable.getColumnModel().getColumn(0).setHeaderValue("Sr No.");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 500, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        dispose();
    //  menu m = new menu();
    }//GEN-LAST:event_backActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        //sqlquery
        updateData();
    }//GEN-LAST:event_editActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        //sqlquery
        addData();
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        //sqlquery
        deleteData();
    }//GEN-LAST:event_deleteActionPerformed

    //SQL CONNECTION
   
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
            java.util.logging.Logger.getLogger(passwordsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passwordsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passwordsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passwordsgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new passwordsgui().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(passwordsgui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JPanel addPane;
    private javax.swing.JButton back;
    private javax.swing.JPanel backPane;
    private javax.swing.JButton delete;
    private javax.swing.JPanel deletePane;
    private javax.swing.JButton edit;
    private javax.swing.JPanel editPane;
    private javax.swing.JLabel footerImg;
    private javax.swing.JLabel headerImg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable passTable;
    // End of variables declaration//GEN-END:variables
}