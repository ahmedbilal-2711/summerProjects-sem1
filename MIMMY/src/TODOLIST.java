import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*sssssss*/
/**
 *
 * @author AlPhA
 */
public class TODOLIST extends javax.swing.JFrame {

    /**
     * Creates new form TODOLIST
     */
    public TODOLIST() {
        initComponents();
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time1 = new cambodia.raven.Time();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listings = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timefield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add = new javax.swing.JButton();
        check = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        history = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        time1.setTextRefernce(timefield);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("TASK TO BE DONE");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("DATE");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("TIME");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("ADD TIME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TASK", "TASKTIME", "TASKDATE"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add.setBackground(new java.awt.Color(204, 204, 255));
        add.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 0, 51));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(204, 204, 255));
        check.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        check.setForeground(new java.awt.Color(255, 0, 51));
        check.setText("CHECK");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(204, 204, 255));
        delete.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 0, 51));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        history.setText("CHECK YOUR HISTORY");
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });

        jButton2.setText("BACK TO MAIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(check, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(listings, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)
                                                .addGap(24, 24, 24)
                                                .addComponent(timefield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(387, 387, 387)
                                        .addComponent(delete)))
                                .addGap(0, 16, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(1, 1, 1)
                        .addComponent(add)
                        .addGap(35, 35, 35)
                        .addComponent(check))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(history)
                    .addComponent(jButton2))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 710, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\AlPhA\\Desktop\\bg.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 730, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     
    public void add(String tablename,String s1,String s2,String s3)
    {
         try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy","root","12345");
   
             String sql="insert into "+tablename+" values (?,?,?)";
             PreparedStatement pst=conn.prepareStatement(sql);
             pst.setString(1,s1);
             pst.setString(2,s2);
             pst.setString(3,s3);
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "ADDED INTO "+tablename+" SUCCESFULLY");
             conn.close();
            
            }  catch(Exception e){
                    e.printStackTrace();
            }
    }
    
    public void check(JTable tablename ,String tab)
  {
      try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy","root","12345");
   
             String sql="select * from "+tab;
             PreparedStatement pst=conn.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
               tablename.setModel(DbUtils.resultSetToTableModel(rs));
              
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ITS NOT WORKING");
        }
  }
    
    public void delete(String tablename ,String colvalue,String colname)
    {
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy","root","12345");
            String sql="delete from "+ tablename+" where "+colname+" = ?";
            PreparedStatement pst=conn.prepareStatement(sql);
           pst.setString(1, colvalue);
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELETD SUCCESFULLY");
             conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, " ITS NOT WORKING");
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        time1.showPopup();
    
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
     
        String s1=listings.getText();
        String s2=timefield.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s3 = dateFormat.format(date.getDate());
        
        
        add("todolist",s1,s2,s3);
        
         DefaultTableModel model=(DefaultTableModel) table.getModel();
         model.addRow(new Object[]{listings.getText(),timefield.getText(),s3});
         listings.setText("");  
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
      DefaultTableModel model=(DefaultTableModel)table.getModel();
        int row=table.getSelectedRow();
        int col = 0;  
       String task = (String) table.getValueAt( row, col );
         
        model.removeRow(row);
        delete("todolist",task,"TASK");
         
         
    }//GEN-LAST:event_deleteActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)table.getModel();
       
        history hi=new history();
        check(table,"todolist");
        
         
         int r=table.getRowCount();
        DateFormat  st = new SimpleDateFormat("hh:mm aa");
    	String systime =  st.format(new Date()).toString();
         
        for(int i=0;i<r;i++)
            {
                Date dates=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String stre=sdf.format(dates);
                String test=(String) table.getValueAt(i, 2);
                String ttime=(String) table.getValueAt(i, 1);         
            try {
                 SimpleDateFormat sdtf= new SimpleDateFormat("hh:mm aa");
                        Date d1;
                        d1 = sdtf.parse(systime);
                        Date d2=sdtf.parse(ttime);
                        long elap=d1.getTime()-d2.getTime();
                        long elapsed=elap/3600000;
                         if(elapsed>0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+table.getValueAt(i, 0)+" PASSED "+(elapsed)+" HOURS BEFORE");
                                   
                        }
                         if(elapsed>4 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+table.getValueAt(i, 0)+" PASSED "+(elapsed)+" HOURS BEFORE");
                          table.setRowSelectionInterval(i, i);
                          int t=table.getSelectedRow();
                          String s1=(String) table.getValueAt(t, 0);
                          String s2=(String) table.getValueAt(t, 1);
                          String s3=(String) table.getValueAt(t, 2);
                          add("history",s1,s2,s3);                           
                            }
                         if(elapsed<0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOU HAVE TO PERFORM "+table.getValueAt(i, 0)+" AFTER "+(-elapsed)+" hours") ;  
                        }
                         if(elapsed==0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+table.getValueAt(i, 0)+" IS RIGHT NOW");  
                          table.setRowSelectionInterval(i, i);
                          int t=table.getSelectedRow();
                          String s1=(String) table.getValueAt(t, 0);
                          String s2=(String) table.getValueAt(t, 1);
                          String s3=(String) table.getValueAt(t, 2);
                          add("history",s1,s2,s3); 
                          delete("todolist",s1,"TASK");
                          
                        }
                         } catch (ParseException ex) {
                             Logger.getLogger(TODOLIST.class.getName()).log(Level.SEVERE, null, ex);
                            }  
                
            }
    }//GEN-LAST:event_checkActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableMouseClicked

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        // TODO add your handling code here:
        
         history h=new history();
         h.setVisible(true);
         dispose();
           
        
    }//GEN-LAST:event_historyActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Front().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TODOLIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TODOLIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TODOLIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TODOLIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TODOLIST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton check;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JButton history;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField listings;
    private javax.swing.JTable table;
    private cambodia.raven.Time time1;
    private javax.swing.JTextField timefield;
    // End of variables declaration//GEN-END:variables
}