/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//delete button
package javaCodes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Maryam
 */
public class AddressBook extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection con;
    /**
     * Creates new form AddressBook
     */
    public AddressBook() {
        initComponents();
        model = (DefaultTableModel) address_tbl.getModel();
        address_tbl.setRowHeight(25);
        address_tbl.setShowGrid(true);
        CreateConnection();
        DefaultTableCellRenderer MyHeaderRender = new DefaultTableCellRenderer();
        MyHeaderRender.setBackground(new Color(204,153,255));
        MyHeaderRender.setForeground(new Color(0,0,0));
        address_tbl.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(3).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(4).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(5).setHeaderRenderer(MyHeaderRender);
        address_tbl.getTableHeader().getColumnModel().getColumn(6).setHeaderRenderer(MyHeaderRender);
    }

    public void CreateConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimmy", "root", "password");
            System.out.println("Database connection successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Refresh() throws SQLException {

        model.setRowCount(0);

        String Name = "", Work = "", Mobile = "", Home = "", Email = "", DoB = "", Address = "";

        String sql = "SELECT * FROM mimmy.address_tbl";

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Name = rs.getString("Name");
                Work = rs.getString("Work");
                Mobile = rs.getString("Mobile");
                Home = rs.getString("Home");
                Email = rs.getString("Email");
                DoB = rs.getString("DoB");
                Address = rs.getString("Address");
                model.addRow(new String[]{Name, Work, Mobile, Home, Email, DoB, Address});
            }
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteAll() throws SQLException {

        String sql = "DELETE FROM mimmy.address_tbl";
        Statement s = con.prepareStatement(sql);
        s.execute(sql);

    }

    public void Delete() throws SQLException {

        int row = address_tbl.getSelectedRow();
        int modelRow = address_tbl.convertRowIndexToModel(row);
        if (address_tbl.getSelectedRowCount() != -1) {
            if (model.getValueAt(model.getRowCount() - 1, 0) != null) {

                String selected = model.getValueAt(modelRow, 0).toString();
                model.removeRow(modelRow);
                search_txt.setText("");
                TableRowSorter<DefaultTableModel> t4 = new TableRowSorter<>(model);
                address_tbl.setRowSorter(t4);
                t4.setRowFilter(null);
                String sql = "DELETE FROM mimmy.address_tbl WHERE NAME = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, selected);
                ps.executeUpdate();
                ps.close();
                System.out.println("Row Deleted!");
                model.setRowCount(0);
                Refresh();
            } else {
                model.removeRow(modelRow);
                System.out.println("Empty Row Deleted");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select A Row");
        }

    }

    public void Save() throws SQLException {

        DeleteAll();

        if (model.getValueAt(model.getRowCount() - 1, 0) != null) {

            String Name = "", Work = "", Mobile = "", Home = "", Email = "", DoB = "", Address = "";

            for (int i = 0; i < model.getRowCount(); i++) {
                Name = model.getValueAt(i, 0).toString();
                Work = model.getValueAt(i, 1).toString();
                Mobile = model.getValueAt(i, 2).toString();
                Home = model.getValueAt(i, 3).toString();
                Email = model.getValueAt(i, 4).toString();
                DoB = model.getValueAt(i, 5).toString();
                Address = model.getValueAt(i, 6).toString();

                String sql = "INSERT INTO mimmy.address_tbl(Name, Work, Mobile, Home, Email, DoB, Address) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement s;

                s = con.prepareStatement(sql);
                s.setString(1, Name);
                s.setString(2, Work);
                s.setString(3, Mobile);
                s.setString(4, Home);
                s.setString(5, Email);
                s.setString(6, DoB);
                s.setString(7, Address);
                s.execute();
            }
            System.out.println("Data saved");
            model.setRowCount(0);
            System.out.println("Table rows cleared");
            Refresh();
        } else {
            JOptionPane.showMessageDialog(this, "Row Is Empty. Please Fill The Row!");
        }

    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_pl = new javax.swing.JPanel();
        mimmy_lbl = new javax.swing.JLabel();
        addresstable_sp = new javax.swing.JScrollPane();
        address_tbl = new javax.swing.JTable();
        clear_btn = new javax.swing.JButton();
        close_btn1 = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        close_btn2 = new javax.swing.JButton();
        search_lbl = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        icon_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frame_pl.setBackground(new java.awt.Color(249, 83, 83,80));

        mimmy_lbl.setFont(new java.awt.Font("Rage Italic", 1, 36)); // NOI18N
        mimmy_lbl.setForeground(new java.awt.Color(255, 255, 255));
        mimmy_lbl.setText("MIMMY'S ADDRESS BOOK");

        address_tbl.setBackground(new java.awt.Color(204, 153, 255));
        address_tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        address_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Work", "Mobile", "Home", "Email Address", "Date Of Birth", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        address_tbl.setNextFocusableComponent(save_btn);
        address_tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                address_tblKeyPressed(evt);
            }
        });
        addresstable_sp.setViewportView(address_tbl);
        if (address_tbl.getColumnModel().getColumnCount() > 0) {
            address_tbl.getColumnModel().getColumn(0).setResizable(false);
            address_tbl.getColumnModel().getColumn(1).setResizable(false);
            address_tbl.getColumnModel().getColumn(2).setResizable(false);
            address_tbl.getColumnModel().getColumn(3).setResizable(false);
            address_tbl.getColumnModel().getColumn(4).setResizable(false);
            address_tbl.getColumnModel().getColumn(5).setResizable(false);
            address_tbl.getColumnModel().getColumn(6).setResizable(false);
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

        close_btn1.setBackground(new java.awt.Color(204, 153, 255));
        close_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        close_btn1.setBorder(null);
        close_btn1.setFocusable(false);
        close_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btn1ActionPerformed(evt);
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

        save_btn.setBackground(new java.awt.Color(204, 153, 255));
        save_btn.setText("Save");
        save_btn.setBorder(null);
        save_btn.setNextFocusableComponent(save_btn);
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        close_btn2.setBackground(new java.awt.Color(204, 153, 255));
        close_btn2.setText("Close");
        close_btn2.setBorder(null);
        close_btn2.setNextFocusableComponent(address_tbl);
        close_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btn2ActionPerformed(evt);
            }
        });

        search_lbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search_lbl.setForeground(new java.awt.Color(255, 255, 255));
        search_lbl.setText("Search");

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout frame_plLayout = new javax.swing.GroupLayout(frame_pl);
        frame_pl.setLayout(frame_plLayout);
        frame_plLayout.setHorizontalGroup(
            frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addresstable_sp)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_plLayout.createSequentialGroup()
                .addGroup(frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(frame_plLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_plLayout.createSequentialGroup()
                        .addComponent(close_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(mimmy_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frame_plLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(close_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        frame_plLayout.setVerticalGroup(
            frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_plLayout.createSequentialGroup()
                .addGroup(frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mimmy_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(addresstable_sp, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(frame_plLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(frame_pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        icon_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaper_geometric_color_20_2k_uhd_by_airworldking_d9pj82h-pre.jpg"))); // NOI18N
        icon_lbl.setText("jLabel3");
        getContentPane().add(icon_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        setSize(new java.awt.Dimension(906, 559));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btn1ActionPerformed
        dispose();
    }//GEN-LAST:event_close_btn1ActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        if (address_tbl.getSelectedRow() != -1) {

            int i = address_tbl.convertRowIndexToModel(address_tbl.getSelectedRow());
            model.removeRow(i);
            model.addRow(new Object[]{});

        }
    }//GEN-LAST:event_clear_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed

        try {
            Delete();

        } catch (SQLException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        try {
            Save();
        } catch (SQLException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_btnActionPerformed

    private void address_tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_tblKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if ((address_tbl.getSelectedRow() + 1) == model.getRowCount()) {
                model.addRow(new Object[]{});
            }

        }
    }//GEN-LAST:event_address_tblKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        
        if (model.getRowCount() <= 0) {
            try {
                Refresh();
                model.addRow(new Object[]{});
            } catch (SQLException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void close_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btn2ActionPerformed
        dispose();
    }//GEN-LAST:event_close_btn2ActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        TableRowSorter<DefaultTableModel> t4 = new TableRowSorter<>(model);
        address_tbl.setRowSorter(t4);
        t4.setRowFilter(RowFilter.regexFilter("(?i)" + search_txt.getText().trim()));
    }//GEN-LAST:event_search_txtKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//        AddressBook ab = new AddressBook();
//        ab.CreateConnection();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddressBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable address_tbl;
    private javax.swing.JScrollPane addresstable_sp;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton close_btn1;
    private javax.swing.JButton close_btn2;
    private javax.swing.JButton delete_btn;
    private javax.swing.JPanel frame_pl;
    private javax.swing.JLabel icon_lbl;
    private javax.swing.JLabel mimmy_lbl;
    private javax.swing.JButton save_btn;
    private javax.swing.JLabel search_lbl;
    private javax.swing.JTextField search_txt;
    // End of variables declaration//GEN-END:variables
}
