/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jachnika
 */
public class ReceiveForm extends javax.swing.JFrame{
    
    private JFrame frame;
    private JPanel jPanel1;
    private javax.swing.JLabel ReceiveAuthorLabel;
    private javax.swing.JTextField ReceiveBookIdTexField;
    private javax.swing.JButton ReceiveConfirmButton;
    private javax.swing.JButton ReceiveExitButton;
    private javax.swing.JLabel ReceiveNameLabel;
    private javax.swing.JButton ReceiveSearchButton;
    private javax.swing.JLabel ReceiveSurnameLabel;
    private javax.swing.JLabel ReceiveTitleLabel;
    private javax.swing.JLabel ReceiveUserIdLabel;
    private javax.swing.JLabel ReceiveYearLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField6;
    
    private JFrame createFrom (ActionListener listener) {

        frame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        ReceiveTitleLabel = new javax.swing.JLabel();
        ReceiveAuthorLabel = new javax.swing.JLabel();
        ReceiveYearLabel = new javax.swing.JLabel();
        ReceiveBookIdTexField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        ReceiveUserIdLabel = new javax.swing.JLabel();
        ReceiveNameLabel = new javax.swing.JLabel();
        ReceiveSurnameLabel = new javax.swing.JLabel();
        ReceiveConfirmButton = new javax.swing.JButton();
        ReceiveExitButton = new javax.swing.JButton();
        ReceiveSearchButton = new javax.swing.JButton();

        jTextField6.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Zwrot");

        jLabel2.setText("ID Ksi±¿ki");

        ReceiveTitleLabel.setText("Tytu³:");

        ReceiveAuthorLabel.setText("Autor:");

        ReceiveYearLabel.setText("Rok:");

        ReceiveUserIdLabel.setText("ID Czytelnika");

        ReceiveNameLabel.setText("Nazwisko");

        ReceiveSurnameLabel.setText("Imiê");

        ReceiveConfirmButton.setText("Zatwierd¼");

        ReceiveExitButton.setText("Wyjd¼");

        ReceiveSearchButton.setText("Wyszukaj");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(110, 110, 110))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(ReceiveSearchButton)
                        .addContainerGap())))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jSeparator1)
                            .add(jSeparator2)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                                .add(ReceiveBookIdTexField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(ReceiveTitleLabel)
                                    .add(ReceiveAuthorLabel)
                                    .add(ReceiveYearLabel)
                                    .add(ReceiveUserIdLabel)
                                    .add(ReceiveNameLabel)
                                    .add(ReceiveSurnameLabel))
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(ReceiveExitButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(ReceiveConfirmButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ReceiveBookIdTexField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveSearchButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(ReceiveTitleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveAuthorLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveYearLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveUserIdLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveNameLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ReceiveSurnameLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ReceiveConfirmButton)
                    .add(ReceiveExitButton)))
        );

        frame.getContentPane().add(jPanel1);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }// </editor-fold>            
}
