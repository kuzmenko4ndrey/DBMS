/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_IIOP;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import javax.rmi.*;
import java.util.Vector;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.naming.Context;

/**
 *
 * @author Neophron
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private IDB db;
    private String dbName;

    public MainFrame() {
        initComponents();
        Context ic;
        Object objref;

        try {
            ic = new InitialContext();

            // STEP 1: Get the Object reference from the Name Service
            // using JNDI call.
            objref = ic.lookup("DBService");
            System.out.println("Client: Obtained a ref. to DB server.");

            // STEP 2: Narrow the object reference to the concrete type and
            // invoke the method.
            db = (IDB) PortableRemoteObject.narrow(
                    objref, IDB.class);
            reWriteTables();
        } catch (Exception e) {
            System.err.println("Exception " + e + "Caught");
            e.printStackTrace();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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

        pathToDB = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addRowField = new javax.swing.JTextField();
        addRowButton = new javax.swing.JButton();
        picture = new java.awt.Canvas();
        tableChooser = new java.awt.Choice();
        newDBButton = new javax.swing.JButton();
        addTableButton = new javax.swing.JButton();
        dropTableButton = new javax.swing.JButton();
        deleteRowButton = new javax.swing.JButton();
        deleteRepetedRowsButton = new javax.swing.JButton();
        getDiffBtwTablesButton = new javax.swing.JButton();
        scrollPane2 = new java.awt.ScrollPane();
        list1 = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pathToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathToDBActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));
        jScrollPane1.setViewportView(table);

        scrollPane1.add(jScrollPane1);

        addRowButton.setText("Add row");
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });

        picture.setMinimumSize(new java.awt.Dimension(100, 100));

        tableChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChooserMouseClicked(evt);
            }
        });
        tableChooser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tableChooserItemStateChanged(evt);
            }
        });
        tableChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableChooserPropertyChange(evt);
            }
        });

        newDBButton.setText("New DB");
        newDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDBButtonActionPerformed(evt);
            }
        });

        addTableButton.setText("Add table");
        addTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTableButtonActionPerformed(evt);
            }
        });

        dropTableButton.setText("Drop table");
        dropTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropTableButtonActionPerformed(evt);
            }
        });

        deleteRowButton.setText("Delete row");
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowButtonActionPerformed(evt);
            }
        });

        deleteRepetedRowsButton.setText("delete repeated rows");
        deleteRepetedRowsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRepetedRowsButtonActionPerformed(evt);
            }
        });

        getDiffBtwTablesButton.setText("get diff btw tables");
        getDiffBtwTablesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDiffBtwTablesButtonActionPerformed(evt);
            }
        });

        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });
        scrollPane2.add(list1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(saveButton)
                        .addGap(46, 46, 46)
                        .addComponent(loadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newDBButton))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(addRowField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(addRowButton)
                                                                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(17, 17, 17)
                                                        .addComponent(dropTableButton))
                                                .addComponent(deleteRowButton)
                                                .addComponent(deleteRepetedRowsButton)
                                                .addComponent(getDiffBtwTablesButton)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(pathToDB, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tableChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addTableButton)
                                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(saveButton)
                                                .addComponent(loadButton)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(newDBButton)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(pathToDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(24, 24, 24))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(tableChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(25, 25, 25)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(addRowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(addRowButton)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(deleteRowButton)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(deleteRepetedRowsButton)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(getDiffBtwTablesButton))
                                                .addComponent(dropTableButton)))
                                .addComponent(addTableButton))
                        .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pathToDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathToDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathToDBActionPerformed

    public void reWriteTables() throws RemoteException {
        tableChooser.removeAll();
        for (String s : db.getTableNames()) {
            tableChooser.add(s);
        }
        table = new JTable();
        list1.removeAll();
    }

    private void addTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTableButtonActionPerformed
        AddTableFrame atf = new AddTableFrame(this, (DB) db);
        atf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        atf.setVisible(true);
    }//GEN-LAST:event_addTableButtonActionPerformed

    private void dropTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //GEN-FIRST:event_dropTableButtonActionPerformed
            db.dropTable(tableChooser.getSelectedItem());
            tableChooser.remove(tableChooser.getSelectedItem());
            tableChooser.select(0);
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_dropTableButtonActionPerformed
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteRowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //GEN-FIRST:event_deleteRowButtonActionPerformed
            //db.deleteRow(tableChooser.getSelectedItem(), table.getSelectedRow());
            db.deleteRow(tableChooser.getSelectedItem(), list1.getSelectedIndex());
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_deleteRowButtonActionPerformed
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addRowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //GEN-FIRST:event_addRowButtonActionPerformed
            String s = addRowField.getText();
            String[] sh = s.split(";");
            ArrayList<Object> als = new ArrayList<>();
            for (String c : sh) {
                als.add(c);
            }
            db.addRow(tableChooser.getSelectedItem(), als);
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_addRowButtonActionPerformed
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tableChooserPropertyChange(java.beans.PropertyChangeEvent evt) {
        try {
            //GEN-FIRST:event_tableChooserPropertyChange
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_tableChooserPropertyChange
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            db.save(pathToDB.getText());
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        try {
            db = DB.load(pathToDB.getText());
            tableChooser.removeAll();
            for (String s : db.getTableNames()) {
                tableChooser.add(s);
            }
            table = new JTable();
            list1.removeAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void newDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDBButtonActionPerformed
        dbName = (String) JOptionPane.showInputDialog("DBName");
        if (dbName.equals("")) {
            dbName = "dbName";
        }
        tableChooser.removeAll();
        list1.removeAll();
        try {
            db = new DB(dbName);
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newDBButtonActionPerformed

    private void tableChooserItemStateChanged(java.awt.event.ItemEvent evt) {
        try {
            //GEN-FIRST:event_tableChooserItemStateChanged
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_tableChooserItemStateChanged
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tableChooserMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            //GEN-FIRST:event_tableChooserMouseClicked
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_tableChooserMouseClicked
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteRepetedRowsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //GEN-FIRST:event_deleteRepetedRowsButtonActionPerformed
            db.deleteRepeatedRows(tableChooser.getSelectedItem());
            //table = new JTable(new MyTableModel(db.getTable(tableChooser.getSelectedItem())));
            list1.removeAll();
            ArrayList<String> k = db.tableToStringArray(tableChooser.getSelectedItem());
            for (int i = 0; i < k.size(); i++) {
                list1.add(k.get(i));
            }
        } //GEN-LAST:event_deleteRepetedRowsButtonActionPerformed
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getDiffBtwTablesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {//GEN-FIRST:event_getDiffBtwTablesButtonActionPerformed
            Object[] possibilities = new Object[db.getTableNames().size()];
            for (int i = 0; i < possibilities.length; i++) {
                possibilities[i] = db.getTableNames().get(i);
            }
            String s = (String) JOptionPane.showInputDialog(
                    null, null,
                    "choose table",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    possibilities[0].toString());
            list1.removeAll();
            ArrayList<String> als = null;
            try {
                als = db.getDiffBetwnTabls(tableChooser.getSelectedItem(), s);
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] k = new String[als.size()];
            for (int i = 0; i < k.length; i++) {
                k[i] = als.get(i);
                list1.add(als.get(i));
            }
        }//GEN-LAST:event_getDiffBtwTablesButtonActionPerformed
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {try {
        //GEN-FIRST:event_list1MouseClicked
        picture.getGraphics().clearRect(0, 0, 100, 100);
        String p = db.getTableData(tableChooser.getSelectedItem()).get(
                list1.getSelectedIndex()).get(db.getPictureIndex(
                        tableChooser.getSelectedItem())).toString();
        if (!p.equals("")) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(p));
            } catch (Exception e) {
            }
            picture.getGraphics().drawImage(img, 0, 0, 100, 100, null);
        }
        } //GEN-LAST:event_list1MouseClicked
        catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowButton;
    private javax.swing.JTextField addRowField;
    private javax.swing.JButton addTableButton;
    private javax.swing.JButton deleteRepetedRowsButton;
    private javax.swing.JButton deleteRowButton;
    private javax.swing.JButton dropTableButton;
    private javax.swing.JButton getDiffBtwTablesButton;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.List list1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newDBButton;
    private javax.swing.JTextField pathToDB;
    private java.awt.Canvas picture;
    private javax.swing.JButton saveButton;
    private java.awt.ScrollPane scrollPane1;
    private java.awt.ScrollPane scrollPane2;
    private javax.swing.JTable table;
    private java.awt.Choice tableChooser;
    // End of variables declaration//GEN-END:variables
}
