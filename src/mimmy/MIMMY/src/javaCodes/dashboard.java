
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Bilal Siddiqui
 */
public class dashboard extends javax.swing.JFrame {

        Connection con = null;
        Statement s;
        String ipadd;
        DefaultTableModel t ;
        String date; 
        
    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        connection();
        refreshDate();
        readData();
    }
    
    //Connection to java and Database
    public void connection(){
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
    
    //Keep recents of current day
    public void refreshDate(){
       Date dateNow = new Date();
       date = dateNow.toString().substring(8, 10);
            try {
                s = con.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM dashboardRecords");
                while(rs.next()){
                    String dateDB = rs.getString("Date");
                    if(date.equalsIgnoreCase(dateDB)){
                        //No operations required
                    }
                    else{
                        PreparedStatement p = con.prepareStatement("DELETE FROM dashboardRecords WHERE Date=?");
                        p.setString(1, dateDB);
                        p.executeUpdate();
                        p.close();
                    }
                }
                s.close();
            } catch (SQLException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
      
       
    }
    //Read data from database to display in table
    public void readData(){
        
            try {
                t = (DefaultTableModel) recentsTable.getModel();
                s = con.createStatement();
                ResultSet rs =s.executeQuery("SELECT * FROM dashboardRecords");
                while(rs.next()){
                     String rec = rs.getString("Recents");
                     t.addRow(new Object[] {rec});
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    //Add recents to database and table
    public void addData(String activity) throws SQLException{
        PreparedStatement p = con.prepareStatement("INSERT INTO dashboardRecords (Recents,Date) VALUES (?,?)");
        p.setString(1, activity);
        p.setString(2,date);
        System.out.println(date);
        p.executeUpdate();
        p.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBg = new javax.swing.JPanel();
        diaryBtn = new javax.swing.JButton();
        addressBtn = new javax.swing.JButton();
        passwordsBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentsTable = new javax.swing.JTable();
        todoBtn = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        bgImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(465, 390));
        setName("DashBoard"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBg.setBackground(new java.awt.Color(204, 204, 204,85));

        diaryBtn.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\diaryBtn.png")); // NOI18N
        diaryBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        diaryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaryBtnActionPerformed(evt);
            }
        });

        addressBtn.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\addressBtn.png")); // NOI18N
        addressBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        addressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressBtnActionPerformed(evt);
            }
        });

        passwordsBtn.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\passBtm.png")); // NOI18N
        passwordsBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        passwordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordsBtnActionPerformed(evt);
            }
        });

        recentsTable.setBackground(new java.awt.Color(255, 153, 51));
        recentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RECENTS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recentsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        recentsTable.setDoubleBuffered(true);
        recentsTable.setGridColor(new java.awt.Color(255, 255, 255));
        recentsTable.setSelectionBackground(new java.awt.Color(255, 255, 153));
        recentsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        recentsTable.setShowGrid(true);
        recentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(recentsTable);
        if (recentsTable.getColumnModel().getColumnCount() > 0) {
            recentsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        todoBtn.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\todoBtn.png")); // NOI18N
        todoBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        todoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoBtnActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("DASHBOARD");

        logoutBtn.setBackground(new java.awt.Color(255, 102, 0));
        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBgLayout = new javax.swing.GroupLayout(panelBg);
        panelBg.setLayout(panelBgLayout);
        panelBgLayout.setHorizontalGroup(
            panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBgLayout.createSequentialGroup()
                .addGroup(panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(todoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addressBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelBgLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(logoutBtn)))
                .addContainerGap())
        );
        panelBgLayout.setVerticalGroup(
            panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBgLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBgLayout.createSequentialGroup()
                        .addComponent(diaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(addressBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(todoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(passwordsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(panelBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 330));

        bgImg.setIcon(new javax.swing.ImageIcon("H:\\summerProjects-sem1\\src\\mimmy\\MIMMY\\src\\images\\dashBg.png")); // NOI18N
        getContentPane().add(bgImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordsBtnActionPerformed
        dispose();
        passwordsgui pg;
            try {
                pg = new passwordsgui();
                pg.setVisible(true);
                addData("Passwords Vault");
            } catch (SQLException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_passwordsBtnActionPerformed

    private void addressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressBtnActionPerformed
//                dispose();
//                addressBook ab;
//            try {
//                ab = new addressBook();
//                ab.setVisible(true);
//                addData("Address Book");
//            } catch (SQLException ex) {
//                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }//GEN-LAST:event_addressBtnActionPerformed

    private void todoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoBtnActionPerformed
//                dispose();
//                todoList tl;
//            try {
//                tl = new passwordsgui();
//                tl.setVisible(true);
//                addData("TODO List");
//            } catch (SQLException ex) {
//                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }//GEN-LAST:event_todoBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void diaryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaryBtnActionPerformed
//        dispose();
//        diary d ;
//            try {
//                d = new passwordsgui();
//                d.setVisible(true);
//                addData("Diary");
//            } catch (SQLException ex) {
//                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }//GEN-LAST:event_diaryBtnActionPerformed

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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addressBtn;
    private javax.swing.JLabel bgImg;
    private javax.swing.JButton diaryBtn;
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel panelBg;
    private javax.swing.JButton passwordsBtn;
    private javax.swing.JTable recentsTable;
    private javax.swing.JButton todoBtn;
    // End of variables declaration//GEN-END:variables
}
