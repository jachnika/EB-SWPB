/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author jachnika
 */
public class UsersForm extends javax.swing.JFrame {

    private javax.swing.JFrame frame;
    private javax.swing.JPanel panel;
    public javax.swing.JButton UsersAddButton;
    public javax.swing.JButton UsersBackToModeChooserButton;
    public javax.swing.JButton UsersModifyButton;
    public javax.swing.JButton UsersRemoveButton;
    public javax.swing.JButton UsersSearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTable1;
    public javax.swing.table.DefaultTableModel model;

    public JFrame CreateForm(ActionListener listener, LinkedList data) {

        frame = new JFrame();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UsersBackToModeChooserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UsersSearchButton = new javax.swing.JButton();
        UsersAddButton = new javax.swing.JButton();
        UsersRemoveButton = new javax.swing.JButton();
        UsersModifyButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        model = new javax.swing.table.DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return false;
            }
        };
        //to jest gówniana czê¶æ programu. Tworzymy model jTable, okre¶lamy kolumny, nastêpnie trzeba rozpakowaæ linkedlist data
        jTable1 = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Nazwisko");
        model.addColumn("Imie");
        model.addColumn("Urodzony");
        model.addColumn("Ulica");
        model.addColumn("NrDomu");
        model.addColumn("NrMieszkania");
        model.addColumn("KodPoczt");
        model.addColumn("Miejscowo¶æ");
        model.addColumn("Grupa");
        //no i tu jest to rozpakowanie LinkedListy z LinkedListy..... gówniane
        for (int i = 0; i < data.size(); i++) {
            LinkedList oneList = (LinkedList) data.get(i);
            String[] row = new String[oneList.size()];
            for (int j = 0; j < oneList.size(); j++) {
                row[j] = (String) oneList.get(j);
            }
            model.addRow(row);
        }

        jTable1.setModel(model);

        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(6).setResizable(false);
        jTable1.getColumnModel().getColumn(8).setResizable(false);

        UsersBackToModeChooserButton.setText("< Wróæ do wyboru trybu");
        UsersBackToModeChooserButton.addActionListener(listener);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Zarz±dzanie u¿ytkownikami");

        UsersSearchButton.setText("Wyszukaj");
        UsersSearchButton.addActionListener(listener);

        UsersAddButton.setText("Dodaj");
        UsersAddButton.addActionListener(listener);

        UsersRemoveButton.setText("Usuñ");
        UsersRemoveButton.addActionListener(listener);

        UsersModifyButton.setText("Modyfikuj");
        UsersModifyButton.addActionListener(listener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                .add(UsersBackToModeChooserButton)
                .add(75, 75, 75)
                .add(jLabel1)
                .add(0, 202, Short.MAX_VALUE))
                .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(UsersSearchButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(UsersAddButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(UsersRemoveButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(UsersModifyButton))
                .add(jScrollPane1)
                .add(jSeparator1))))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, UsersBackToModeChooserButton)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 358, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(UsersSearchButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(UsersAddButton)
                .add(UsersRemoveButton)
                .add(UsersModifyButton))
                .addContainerGap()));

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
