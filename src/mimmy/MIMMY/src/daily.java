

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlPhA
 */
public class daily extends javax.swing.JFrame implements Runnable {
    int hour,min,second;

    /**
     * Creates new form daily
     */
    public daily() {
        initComponents();
        Thread t=new Thread(this);
        t.start();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tarea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lasttext = new javax.swing.JButton();
        save = new javax.swing.JButton();
        timeframe = new javax.swing.JLabel();
        dframe = new javax.swing.JLabel();
        dayv = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        diarytable = new javax.swing.JTable();
        t = new javax.swing.JTextField();
        dlt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tarea1.setColumns(20);
        tarea1.setRows(5);
        jScrollPane1.setViewportView(tarea1);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel1.setText("       SO WHAT HAPPENED TODAY?");

        lasttext.setText("GET LAST TEXT ");
        lasttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasttextActionPerformed(evt);
            }
        });

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        timeframe.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        timeframe.setText("t");

        dframe.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        dframe.setText("gv bn m mm");

        dayv.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        dayv.setText("2");

        diarytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIME", "DATE", "DAY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(diarytable);

        t.setText("jTextField1");

        dlt.setText("DELETE");
        dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltActionPerformed(evt);
            }
        });

        jButton1.setText("BACK TO MAIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeframe, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66)
                                .addComponent(dframe, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(dayv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lasttext, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                            .addComponent(dlt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dframe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeframe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayv, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save)
                            .addComponent(lasttext, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlt)
                            .addComponent(jButton1))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        TODOLIST to=new TODOLIST();
        DefaultTableModel model=(DefaultTableModel) diarytable.getModel();
        to.check(diarytable,"dailyroutine");
    }//GEN-LAST:event_formWindowOpened

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String ti=timeframe.getText();
        String dt=dframe.getText();
        String dy=dayv.getText();
        String tname="dailyroutine";
        DefaultTableModel model=(DefaultTableModel) diarytable.getModel();
        model.addRow(new Object[]{ti,dt,dy});
        String path=ti.concat(" "+dt).concat(".txt") ;
        
        try{
            File f=new File(path);
           if (f.createNewFile())
           {
               JOptionPane.showMessageDialog(null,"FILE "+path+" CREATED AT "+f.getAbsolutePath());
           }
            FileWriter fw=new FileWriter(path);
            fw.write("Date "+dt+"\t\t\t\tTIME "+ti+"\t\t\t\tDAY "+dy+"\n"+tarea1.getText());
            fw.close();
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        tarea1.setText("");
        TODOLIST to=new TODOLIST();
        to.add(tname, ti, dt, dy);
    }//GEN-LAST:event_saveActionPerformed

    private void lasttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasttextActionPerformed
        try {
            // TODO add your handling code here:
            //DefaultTableModel model=(DefaultTableModel) diarytable.getModel();
            
            int row=diarytable.getSelectedRow();
            String tableti=(String) diarytable.getValueAt( row, 0 );
            String tabledt=(String) diarytable.getValueAt( row, 1 );
            String path=tableti.concat(" "+tabledt).concat(".txt") ;
            System.out.println(path);
            
            
            BufferedReader br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) { 
                sb.append(line).append("\n"); 
                line = br.readLine();
            }
            String fileAsString = sb.toString();
            tarea1.setText(fileAsString);
        } catch (IOException ex) {
            Logger.getLogger(daily.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lasttextActionPerformed

    private void dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltActionPerformed
        // TODO add your handling code here:
        String message="ARE YOU SURE YOU WANT TO DELETE FILES, ONCE DELETED WON'T BE EASY TO RECOVER";
        int reply = JOptionPane.showConfirmDialog(null,message);
if (reply == JOptionPane.YES_OPTION) {
  

         
        TODOLIST td=new TODOLIST();
        DefaultTableModel model=(DefaultTableModel)diarytable.getModel();
        int row=diarytable.getSelectedRow(); 
       String ti = (String)diarytable.getValueAt( row,0);
       String dt=  (String)diarytable.getValueAt( row,1);
       String path=ti.concat(" "+dt).concat(".txt");
       File file=new File(path);
       if(file.exists())
       {
        
           file.delete();
            JOptionPane.showMessageDialog(null,"FILE "+path+" DELETED ");
       }
        
       td. delete("dailyroutine",ti,"TIME");
       model.removeRow(row);}
    else {
    JOptionPane.showMessageDialog(null, "GOODBYE");
    }
    }//GEN-LAST:event_dltActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Front f=new Front();
        f.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(daily.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daily.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daily.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daily.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daily().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dayv;
    private javax.swing.JLabel dframe;
    private javax.swing.JTable diarytable;
    private javax.swing.JButton dlt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lasttext;
    private javax.swing.JButton save;
    private javax.swing.JTextField t;
    private javax.swing.JTextArea tarea1;
    private javax.swing.JLabel timeframe;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
        Calendar c=Calendar.getInstance();
        hour=c.get(Calendar.HOUR_OF_DAY);
        min=c.get(Calendar.MINUTE);
        second=c.get(Calendar.SECOND);
        SimpleDateFormat sdf=new SimpleDateFormat("hh-mm-ss aa");
        Date dat=c.getTime();
        String time=sdf.format(dat);
        timeframe.setText(time);
            
             SimpleDateFormat sdfd=new SimpleDateFormat("YYYY-dd-MM");
              Date d=new Date();
             String da=sdfd.format(d);
              dframe.setText(da);
              Calendar calendar = Calendar.getInstance();
               Date date = calendar.getTime();
               String day= new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
               dayv.setText(day);
             
        }
        
     }
}