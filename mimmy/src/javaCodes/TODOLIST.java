/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaCodes;

import cambodia.raven.Time;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Maryam
 */
public class TODOLIST extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form list
     */
    public TODOLIST() {
        initComponents();
        model = (DefaultTableModel) task_tbl.getModel();
        task_tbl.setRowHeight(25);
        task_tbl.setShowGrid(true);
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(new Color(179, 255, 255));
        MyHeaderRender.setForeground(new Color(0, 0, 0));
        task_tbl.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        task_tbl.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        task_tbl.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
       
    }
    Time time = new Time();
    public void add(String tablename, String s1, String s2, String s3) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy", "root", "12345");

            String sql = "insert into " + tablename + " values (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, s1);
            pst.setString(2, s2);
            pst.setString(3, s3);

            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "ADDED INTO " + tablename + " SUCCESFULLY");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check(JTable tablename, String tab) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy", "root", "12345");

            String sql = "select * from " + tab;
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            tablename.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ITS NOT WORKING");
        }
    }

    public void delete(String tablename, String colvalue, String colname) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy", "root", "12345");
            String sql = "delete from " + tablename + " where " + colname + " = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, colvalue);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELETD SUCCESFULLY");
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " ITS NOT WORKING");
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

        time1 = new cambodia.raven.Time();
        back_btn = new javax.swing.JButton();
        TDL_pl = new javax.swing.JPanel();
        task_pl = new javax.swing.JScrollPane();
        task_tbl = new javax.swing.JTable();
        myTask_tf = new javax.swing.JTextField();
        myTask_lbl = new javax.swing.JLabel();
        time_lbl = new javax.swing.JLabel();
        date_lbl = new javax.swing.JLabel();
        date_tf = new com.toedter.calendar.JDateChooser();
        time_btn = new javax.swing.JButton();
        time_tf = new javax.swing.JTextField();
        refresh_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        history_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        show_btn = new javax.swing.JButton();
        title_lbl = new javax.swing.JLabel();
        background_lbl = new javax.swing.JLabel();

        time1.setTextRefernce(time_tf);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_btn.setBackground(new java.awt.Color(179, 255, 255));
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        back_btn.setBorder(null);
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        TDL_pl.setBackground(new java.awt.Color(13, 8, 154,80));

        task_tbl.setBackground(new java.awt.Color(179, 255, 255));
        task_tbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        task_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "My Task", "Time", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        task_tbl.setGridColor(new java.awt.Color(153, 153, 153));
        task_pl.setViewportView(task_tbl);
        if (task_tbl.getColumnModel().getColumnCount() > 0) {
            task_tbl.getColumnModel().getColumn(0).setResizable(false);
            task_tbl.getColumnModel().getColumn(1).setResizable(false);
            task_tbl.getColumnModel().getColumn(2).setResizable(false);
        }

        myTask_tf.setBorder(null);
        myTask_tf.setCaretColor(new java.awt.Color(255, 255, 255));
        myTask_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myTask_tfActionPerformed(evt);
            }
        });

        myTask_lbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        myTask_lbl.setText("My Task");

        time_lbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        time_lbl.setText("Time");

        date_lbl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        date_lbl.setText("Date");

        date_tf.setToolTipText("");
        date_tf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar.png")));

        time_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clk.png"))); // NOI18N
        time_btn.setBorder(null);
        time_btn.setIconTextGap(0);
        time_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_btnActionPerformed(evt);
            }
        });

        time_tf.setBorder(null);

        refresh_btn.setBackground(new java.awt.Color(179, 255, 255));
        refresh_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refresh_btn.setText("Refresh");
        refresh_btn.setBorder(null);

        add_btn.setBackground(new java.awt.Color(179, 255, 255));
        add_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add_btn.setText("Add");
        add_btn.setBorder(null);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        history_btn.setBackground(new java.awt.Color(179, 255, 255));
        history_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        history_btn.setText("History");
        history_btn.setBorder(null);
        history_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(179, 255, 255));
        delete_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delete_btn.setText("Delete");
        delete_btn.setBorder(null);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Search");

        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        show_btn.setBackground(new java.awt.Color(179, 255, 255));
        show_btn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        show_btn.setText("Show");
        show_btn.setBorder(null);
        show_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TDL_plLayout = new javax.swing.GroupLayout(TDL_pl);
        TDL_pl.setLayout(TDL_plLayout);
        TDL_plLayout.setHorizontalGroup(
            TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TDL_plLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TDL_plLayout.createSequentialGroup()
                        .addComponent(task_pl, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TDL_plLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TDL_plLayout.createSequentialGroup()
                                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(show_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TDL_plLayout.createSequentialGroup()
                                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(TDL_plLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(history_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TDL_plLayout.createSequentialGroup()
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(myTask_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myTask_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TDL_plLayout.createSequentialGroup()
                                .addComponent(time_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(time_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(136, 136, 136)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        TDL_plLayout.setVerticalGroup(
            TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TDL_plLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myTask_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myTask_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(time_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(time_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TDL_plLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(task_pl, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TDL_plLayout.createSequentialGroup()
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TDL_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(show_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(history_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(TDL_pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 770, 380));

        title_lbl.setFont(new java.awt.Font("Rage Italic", 1, 48)); // NOI18N
        title_lbl.setForeground(new java.awt.Color(255, 255, 230));
        title_lbl.setText("MIMMY'S TO-DO LIST");
        title_lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(title_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 550, 70));

        background_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blue_bg.jpg"))); // NOI18N
        background_lbl.setText("jLabel1");
        getContentPane().add(background_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myTask_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTask_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myTask_tfActionPerformed

    private void time_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_btnActionPerformed
        time1.showPopup();
        
    }//GEN-LAST:event_time_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        String s1=myTask_tf.getText();
        String s2=time_tf.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s3 = dateFormat.format(date_tf.getDate());
        
        
        add("todolist",s1,s2,s3);
        
         DefaultTableModel model=(DefaultTableModel) task_tbl.getModel();
         model.addRow(new Object[]{myTask_tf.getText(),time_tf.getText(),s3});
         myTask_tf.setText("");
    }//GEN-LAST:event_add_btnActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void show_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_btnActionPerformed
        DefaultTableModel model=(DefaultTableModel)task_tbl.getModel();
       
        History hi=new History();
        check(task_tbl,"todolist");
        
         
         int r=task_tbl.getRowCount();
        DateFormat  st = new SimpleDateFormat("hh:mm aa");
    	String systime =  st.format(new Date()).toString();
         
        for(int i=0;i<r;i++)
            {
                Date dates=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String stre=sdf.format(dates);
                String test=(String) task_tbl.getValueAt(i, 2);
                String ttime=(String) task_tbl.getValueAt(i, 1);         
            try {
                 SimpleDateFormat sdtf= new SimpleDateFormat("hh:mm aa");
                        Date d1;
                        d1 = sdtf.parse(systime);
                        Date d2=sdtf.parse(ttime);
                        long elap=d1.getTime()-d2.getTime();
                        long elapsed=elap/3600000;
                         if(elapsed>0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+task_tbl.getValueAt(i, 0)+" PASSED "+(elapsed)+" HOURS BEFORE");
                                   
                        }
                         if(elapsed>4 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+task_tbl.getValueAt(i, 0)+" PASSED "+(elapsed)+" HOURS BEFORE");
                          task_tbl.setRowSelectionInterval(i, i);
                          int t=task_tbl.getSelectedRow();
                          String s1=(String) task_tbl.getValueAt(t, 0);
                          String s2=(String) task_tbl.getValueAt(t, 1);
                          String s3=(String) task_tbl.getValueAt(t, 2);
                          add("history",s1,s2,s3);                           
                            }
                         if(elapsed<0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOU HAVE TO PERFORM "+task_tbl.getValueAt(i, 0)+" AFTER "+(-elapsed)+" hours") ;  
                        }
                         if(elapsed==0 && stre.equals(test))
                        {
                          JOptionPane.showMessageDialog(null, "YOUR TIME TO DO "+task_tbl.getValueAt(i, 0)+" IS RIGHT NOW");  
                          task_tbl.setRowSelectionInterval(i, i);
                          int t=task_tbl.getSelectedRow();
                          String s1=(String) task_tbl.getValueAt(t, 0);
                          String s2=(String) task_tbl.getValueAt(t, 1);
                          String s3=(String) task_tbl.getValueAt(t, 2);
                          add("history",s1,s2,s3); 
                          delete("todolist",s1,"TASK");
                          
                        }
                         } catch (ParseException ex) {
                             Logger.getLogger(TODOLIST.class.getName()).log(Level.SEVERE, null, ex);
                            }  
                
            }
    }//GEN-LAST:event_show_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        DefaultTableModel model=(DefaultTableModel)task_tbl.getModel();
        int row=task_tbl.getSelectedRow();
        int col = 0;  
       String task = (String) task_tbl.getValueAt( row, col );
         
        model.removeRow(row);
        delete("todolist",task,"TASK");
    }//GEN-LAST:event_delete_btnActionPerformed

    private void history_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_btnActionPerformed
        History h = new History();
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_history_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        dispose();
    }//GEN-LAST:event_back_btnActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TODOLIST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TDL_pl;
    private javax.swing.JButton add_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel background_lbl;
    private javax.swing.JLabel date_lbl;
    private com.toedter.calendar.JDateChooser date_tf;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton history_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel myTask_lbl;
    private javax.swing.JTextField myTask_tf;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton show_btn;
    private javax.swing.JScrollPane task_pl;
    private javax.swing.JTable task_tbl;
    private cambodia.raven.Time time1;
    private javax.swing.JButton time_btn;
    private javax.swing.JLabel time_lbl;
    private javax.swing.JTextField time_tf;
    private javax.swing.JLabel title_lbl;
    // End of variables declaration//GEN-END:variables
}
