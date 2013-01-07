/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
/**
 *
 * @author jachnika
 */

public class CollectionForm extends javax.swing.JFrame {
    
    private JButton CollectionAddBookButton;
    private JButton CollectionBackToModeChooserButton;
    private JButton CollectionModifyBookButton;
    private JButton CollectionReceiveBookButton;
    private JButton CollectionRemoveBookButton;
    private JButton CollectionRentBookButton;
    private JButton CollectionSearchBookButton;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTable jTable1;
    private JFrame frame;
    private JPanel jPanel1;
    
    public JFrame CreateForm(ActionListener listener){
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
        CollectionSearchBookButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new JPanel();
        
        CollectionBackToModeChooserButton.setText("< Wróæ do wyboru trybu");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tytul", "Nazwisko", "Imiê", "Wypozyczone", "Wypozyczyl", "Data Wypo¿yczenia", "Data Zwrotu", "Wydawnictwo", "Rok", "Uwagi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        CollectionRemoveBookButton.setText("Usuñ");

        CollectionAddBookButton.setText("Dodaj");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Zarz±dzanie zbiorem");

        CollectionRentBookButton.setText("Wypo¿ycz");
        CollectionRentBookButton.addActionListener(listener);

        CollectionReceiveBookButton.setText("Zwróæ");
        CollectionReceiveBookButton.addActionListener(listener);
           

        CollectionSearchBookButton.setText("Wyszukaj");
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
                                .addComponent(CollectionSearchBookButton)
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
                    .addComponent(CollectionSearchBookButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        frame.getContentPane().add(jPanel1);
	frame.pack();
	frame.setVisible(true);
        return frame;
    }
    }
    

