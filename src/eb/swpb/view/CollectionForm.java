/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
//import eb.swpb.model.*;
/**
 *
 * @author jachnika
 */

public class CollectionForm extends javax.swing.JFrame {
    
    public JButton CollectionAddBookButton;
    public JButton CollectionBackToModeChooserButton;
    public JButton CollectionModifyBookButton;
    public JButton CollectionReceiveBookButton;
    public JButton CollectionRemoveBookButton;
    public JButton CollectionRentBookButton;
    public JButton collectionSearchBookButton;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    public JTable jTable1;
    private JFrame frame;
    private JPanel jPanel1;
    public javax.swing.table.DefaultTableModel model;
    
    public JFrame CreateForm(ActionListener listener, LinkedList data){
        frame = new JFrame();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        CollectionBackToModeChooserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CollectionModifyBookButton = new javax.swing.JButton();
        CollectionRemoveBookButton = new javax.swing.JButton();
        CollectionAddBookButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CollectionRentBookButton = new javax.swing.JButton();
        CollectionReceiveBookButton = new javax.swing.JButton();
        collectionSearchBookButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new JPanel();
        
        CollectionBackToModeChooserButton.setText("< Wróæ do wyboru trybu");
        
        model = new javax.swing.table.DefaultTableModel() 
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return false;
            }
        };
        //to jest gówniana czê¶æ programu. Tworzymy model jTable, okre¶lamy kolumny, nastêpnie trzeba rozpakowaæ linkedlist data
        JTable table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Tytul");
        model.addColumn("Nazwisko");
        model.addColumn("Imie");
        model.addColumn("Wypozyczone");
        model.addColumn("Wypozyczyl");
        model.addColumn("Data Wypo¿yczenia");
        model.addColumn("Data Zwrotu");
        model.addColumn("Wydawnictwo");
        model.addColumn("Rok");
        model.addColumn("Uwagi");
        //no i tu jest to rozpakowanie LinkedListy z LinkedListy..... gówniane
        for (int i = 0; i<data.size();i++){
            LinkedList oneList = (LinkedList) data.get(i);
            String[] row = new String[oneList.size()];
            for(int j=0; j<oneList.size();j++){
                 row[j]= (String) oneList.get(j); 
            }
            model.addRow(row);
        }
        
        jTable1.setModel(model);
        
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(6).setResizable(false);
        jTable1.getColumnModel().getColumn(7).setResizable(false);
        jTable1.getColumnModel().getColumn(8).setResizable(false);
        jTable1.getColumnModel().getColumn(9).setResizable(false);
        jTable1.getColumnModel().getColumn(10).setResizable(false);

        CollectionModifyBookButton.setText("Modyfikuj");
        CollectionModifyBookButton.addActionListener(listener);

        CollectionRemoveBookButton.setText("Usuñ");
        CollectionRemoveBookButton.addActionListener(listener);

        CollectionAddBookButton.setText("Dodaj");
        CollectionAddBookButton.addActionListener(listener);
        
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Zarz±dzanie zbiorem");

        CollectionRentBookButton.setText("Wypo¿ycz");
        CollectionRentBookButton.addActionListener(listener);

        CollectionReceiveBookButton.setText("Zwróæ");
        CollectionReceiveBookButton.addActionListener(listener);
           

        collectionSearchBookButton.setText("Wyszukaj");
        collectionSearchBookButton.addActionListener(listener);
       
        GroupLayout layout = new GroupLayout(jPanel1);
        //org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CollectionBackToModeChooserButton)
                        .addGap(org.jdesktop.layout.LayoutStyle.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(CollectionReceiveBookButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .addComponent(CollectionRentBookButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(collectionSearchBookButton)
                                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .addComponent(CollectionAddBookButton)
                                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .addComponent(CollectionRemoveBookButton)
                                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .addComponent(CollectionModifyBookButton))
                            .addComponent(jSeparator1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(CollectionBackToModeChooserButton))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(CollectionRentBookButton)
                        .addComponent(CollectionReceiveBookButton)))
                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .addComponent(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .addComponent(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 442, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(CollectionModifyBookButton)
                    .addComponent(CollectionRemoveBookButton)
                    .addComponent(CollectionAddBookButton)
                    .addComponent(collectionSearchBookButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        frame.getContentPane().add(jPanel1);
	frame.pack();
	frame.setVisible(true);
        return frame;
    }
    }
    

